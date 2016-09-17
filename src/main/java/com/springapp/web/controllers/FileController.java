package com.springapp.web.controllers;

import com.springapp.services.DiffFinder;
import com.springapp.services.ZipCreator;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipOutputStream;

@Controller
public class FileController {

	private String fileDiff;

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ModelAndView fileUpload(@RequestParam("file1") final MultipartFile file1,
								   @RequestParam("file2") final MultipartFile file2)
			throws IllegalStateException, IOException {
		ModelAndView model = new ModelAndView("main");
		String strFile1 = "", strFile2 = "";

		try {
			if (!file1.isEmpty()) {
				try {
					strFile1 = IOUtils.toString(file1.getInputStream(), "UTF-8");
					model.addObject("file1Message", "Ok!");
				} catch (Exception e) {
					model.addObject("file1Message", "Fail: " + e.getMessage());
				}
			} else {
				model.addObject("file1Message", "Fail! Empty file!");
			}
		} catch (OutOfMemoryError e) {
			model.addObject("file1Message", "Fail! File to big!");
		}

		try {
			if (!file2.isEmpty()) {
				try {
					strFile2 = IOUtils.toString(file2.getInputStream(), "UTF-8");
					model.addObject("file2Message", "Ok!");
				} catch (Exception e) {
					model.addObject("file2Message", "Fail: " + e.getMessage());
				}
			} else {
				model.addObject("file2Message", "Fail! Empty file!");
			}
		} catch (OutOfMemoryError e) {
			model.addObject("file2Message", "Fail! File to big!");
		}
		fileDiff = DiffFinder.getDifference(strFile1, strFile2);
		model.addObject("file", fileDiff);
		if (!(file1.isEmpty() && file2.isEmpty()))
			model.addObject("condition", true);
		return model;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletResponse response) throws IOException {
		File file = new File("result.txt");
		FileUtils.writeStringToFile(file, fileDiff);

		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment; filename=result.zip");
		ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());

		ZipCreator zipCreator = new ZipCreator();
		zipCreator.zip(file, zipOutputStream);
		zipOutputStream.close();
	}

}
