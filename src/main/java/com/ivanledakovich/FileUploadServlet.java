package com.ivanledakovich;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(description = "Upload File To The Server", urlPatterns = { "/fileUploadServlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String UPLOAD_DIR = "uploadedFiles";
	public static final String CONVERTED_DIR = "convertedFiles";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String applicationPath = getServletContext().getRealPath(""),
				uploadPath = applicationPath + File.separator + UPLOAD_DIR,
				convertedPath = applicationPath + CONVERTED_DIR;

		File fileUploadDirectory = new File(uploadPath);
		if (!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}
		File fileConvertedDirectory = new File(convertedPath);
		if (!fileConvertedDirectory.exists()) {
			fileConvertedDirectory.mkdirs();
		}

		String fileName = "";
		UploadDetail details = null;
		List<UploadDetail> fileList = new ArrayList<UploadDetail>();

		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
			details = new UploadDetail();
			details.setFileName(fileName);
			details.setFileSize(part.getSize() / 1024);
			try {
				part.write(uploadPath + File.separator + fileName);
				details.setUploadStatus("Success");
			} catch (IOException ioObj) {
				details.setUploadStatus("Failure : "+ ioObj.getMessage());
			}
			fileList.add(details);
		}

		request.setAttribute("uploadedFiles", fileList);
		HttpSession session = request.getSession();
		session.setAttribute("uploadedFiles", fileList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/fileuploadResponse.jsp");
		dispatcher.forward(request, response);
		System.out.println(convertedPath);
		Main.main(uploadPath, convertedPath);
	}

	private String extractFileName(Part part) {
		String fileName = "", 
				contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return fileName;
	}
}