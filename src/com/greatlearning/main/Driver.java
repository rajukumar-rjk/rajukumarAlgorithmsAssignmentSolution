package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.model.*;
import com.greatlearning.service.*;

public class Driver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// taking value for no of companies
		System.out.println("enter the no of companies");
		int noOfCompanies = scan.nextInt();
		Company[] companies = new Company[noOfCompanies];

		// for each company taking value for stock price and if changes in price happens yesterday
		for (int i = 0; i < noOfCompanies; i++) {
			Company company = new Company();
			System.out.println("Enter current stock price of the company " + (i + 1));
			company.setSharePrice(scan.nextDouble());
			System.out.println("Whether company's stock price rose today compare to yesterday? (true / false)");
			if (scan.next().toLowerCase().charAt(0) == 't') {
				company.setStockPriceUp(true);
			} else {
				company.setStockPriceUp(false);
			}
			companies[i] = company;
		}

		// below codes are self-explanatory 
		MergeSort mergeSort = new MergeSort();
		BinarySearch binarySearch = new BinarySearch();

		int choice = 0;
		int count = 0;
		
		mergeSort.sort(companies);

		do {
			System.out.println("Enter the operation that you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("press 0 to exit");

			choice = scan.nextInt();

			switch (choice) {
			case 0:
				System.out.println("Exited successfully");
				break;
			case 1:
				System.out.println("Stock prices in ascending order are:");
				for (int i = 0; i < companies.length; i++) {
					System.out.print(companies[i].getSharePrice() + "\t");
				}
				System.out.println();
				break;
			case 2:
				System.out.println("Stock prices in descending order are:");
				for (int i = companies.length - 1; i >= 0; i--) {
					System.out.print(companies[i].getSharePrice() + "\t");
				}
				System.out.println();
				break;
			case 3:
				count = 0;
				for (int i = 0; i < companies.length; i++) {
					count += companies[i].isStockPriceUp() ? 1 : 0;
				}
				System.out.println("Total no of companies whose stock price rose today: " + count);
				break;
			case 4:
				count = 0;
				for (int i = 0; i < companies.length; i++) {
					count += companies[i].isStockPriceUp() ? 0 : 1;
				}
				System.out.println("Total no of companies whose stock price declined today: " + count);
				break;
			case 5:
				System.out.println("Enter the key value");
				double key = scan.nextDouble();
				boolean keyFound = binarySearch.search(companies, key);
				if (keyFound) {
					System.out.println("Stock of value " + key + " is present");
				} else {
					System.out.println("Value not found");
				}
				break;
			default:
				System.out.println("Invalid option");
			}
		} while (choice != 0);

		scan.close();
	}
}