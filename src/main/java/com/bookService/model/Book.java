package com.bookService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	private int bookId;
	@Column
	private String bookName;
	@Column
	private String bookPublisher;
	@Column
	private String bookStream;
	
}
