package com.smruti.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String authorName;
	
	private String bookName;
	
	private Double bookPrice;
	
	
}
