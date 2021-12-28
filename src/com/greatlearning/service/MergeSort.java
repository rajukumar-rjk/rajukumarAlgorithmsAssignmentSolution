package com.greatlearning.service;

import com.greatlearning.model.*;

public class MergeSort {
	
	public void sort(Company[] companies) {
		divideArray(companies, 0, companies.length - 1);
	}
	
	public void divideArray(Company[] companies, int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			divideArray(companies, first, mid);
			divideArray(companies, mid + 1, last);
			conquerArray(companies, first, mid, last);
		}
	}

	public void conquerArray(Company[] companies, int first, int mid, int last) {
		int leftArrayLength = mid - first + 1;
		int rightArrayLength = last - mid;

		Company[] leftArray = new Company[leftArrayLength];
		Company[] rightArray = new Company[rightArrayLength];

		for (int i = 0; i < leftArrayLength; i++) {
			leftArray[i] = companies[first + i];
		}

		for (int i = 0; i < rightArrayLength; i++) {
			rightArray[i] = companies[mid + 1 + i];
		}

		int i = 0;
		int j = 0;
		int k = first;

		while (i < leftArrayLength && j < rightArrayLength) {
			if (leftArray[i].getSharePrice() <= rightArray[j].getSharePrice()) {
				companies[k] = leftArray[i];
				i++;

			} else {
				companies[k] = rightArray[j];
				j++;
			}

			k++;
		}

		while (i < leftArrayLength) {
			companies[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArrayLength) {
			companies[k] = rightArray[j];
			j++;
			k++;
		}
	}
}

