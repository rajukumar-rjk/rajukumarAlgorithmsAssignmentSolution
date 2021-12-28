package com.greatlearning.service;

import com.greatlearning.model.*;

public class BinarySearch {
	public boolean search(Company[] companies, double searchValue) {

		int first = 0;
		int last = companies.length - 1;
		int mid;
		
		while (first <= last) {
			mid = (first + last) / 2;
			
			if (companies[mid].getSharePrice() == searchValue) {
				return true;

			} else if (companies[mid].getSharePrice() < searchValue) {
				first = mid + 1;

			} else {
				last = mid - 1;
			}

		}
		
		return false;
	}

}
