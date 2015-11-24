package com.apress.isf.spring.views;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.core.io.Resource;

public class Menu {

	//���ҽ� ������ �ε��ϴ� ���
	// org.springframework.core.io.ResourceŬ������ ����ϴ� ���� �����ش�.
	private Resource menuFile = null;

	public Resource getMenuFile() {
		return menuFile;
	}

	public void setMenuFile(Resource menuFile) {
		this.menuFile = menuFile;
	}

	public void printMenu() {
		try {
			InputStream stream = getMenuFile().getInputStream();
			Scanner scanner = new Scanner(stream);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
