package com.example.demo.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {
	private int board_no;
	private String id;
	private String title;
	private String content;
	private String board_date;
	private int hit;
	private String category;
	private String filename;
	
	private MultipartFile mf;
	private int cnt;

}
