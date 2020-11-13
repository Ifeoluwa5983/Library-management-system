package com.librarryMS.library.entity;

import java.util.List;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Library {
	
	private List<Book> books ;

}
