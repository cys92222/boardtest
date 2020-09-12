package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board_commentVo {
	private int comment_no;
	private String id;
	private String content;
	private String comment_date;
	private int board_no;
}
