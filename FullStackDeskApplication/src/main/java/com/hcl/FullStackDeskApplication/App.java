package com.hcl.FullStackDeskApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	static ArrayList<Integer> expenses = new ArrayList<>();

	public static void main(String[] args) {
		expenses.add(1000);
		expenses.add(2300);
		expenses.add(45000);
		expenses.add(32000);
		expenses.add(110);
		System.out.println("\n**************************************\n");
		System.out.println("\tWelcome to TheDesk \n");
		System.out.println("**************************************");
		optionsSelection();
	}

	private static void optionsSelection() {
		String[] theOptions = { "1. I wish to review my expenditure", "2. I wish to add my expenditure",
				"3. I wish to delete my expenditure", "4. I wish to sort the expenditures",
				"5. I wish to search for a particular expenditure", "6. Close the application" };
		for (String option : theOptions) {
			System.out.println(option);
		}
		System.out.println("\nEnter your choice:\t");
		Scanner sc = new Scanner(System.in);
		int options = sc.nextInt();
		switch (options) {
		case 1:
			System.out.println("Your saved expenses are listed below: \n");
			System.out.println(expenses + "\n");
			optionsSelection();
			break;
		case 2:
			System.out.println("Enter the value to add your Expense: \n");
			int value = sc.nextInt();
			expenses.add(value);
			System.out.println("Your value is updated\n");
			System.out.println(expenses + "\n");
			optionsSelection();
			break;
		case 3:
			System.out.println(
					"You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
			int con_choice = sc.nextInt();
			if (con_choice == options) {
				expenses.clear();
				System.out.println(expenses + "\n");
				System.out.println("All your expenses are erased!\n");
			} else {
				System.out.println("Oops... try again!");
			}
			optionsSelection();
			break;
		case 4:
			sortExpenses(expenses);
			optionsSelection();
			break;
		case 5:
			System.out.println("Enter the expense you need to search:\t");
			int searchValue = sc.nextInt();
			searchExpenses(expenses, searchValue);
			optionsSelection();
			break;
		case 6:
			closeApp();
			break;
		default:
			System.out.println("You have made an invalid choice!");
			break;
		}
	}

	private static void closeApp() {
		System.out.println("Closing your application... \nThank you!");
		System.exit(0);
	}

	private static void searchExpenses(ArrayList<Integer> arrayList, Integer value) {
		boolean foundResult = false;
		// Iterate through the array and check if value at the index matches
		// with the value to be found
		for (int expense : arrayList) {
			if (expense == value) {
				foundResult = true;
			}
		}
		if (foundResult) {
			System.out.println("Found expense " + value);
		} else {
			System.out.println("Did not find expense " + value);
		}
	}

	private static void sortExpenses(ArrayList<Integer> arrayList) {
		quicksort(arrayList, 0, arrayList.size() - 1);
		System.out.println("Expenses In Order");
		System.out.println(arrayList + "\n");
	}

	public static int partion(ArrayList<Integer> arr, int left, int right) {
		// take first element as a pivot
		int pivot = arr.get(left);
		// i is index that should trace the smallest elements than pivot.
		// at last we will swap element at index i with pivot.
		// means before ith index all elements should be less than pivot.
		int i = left;

		for (int j = left + 1; j <= right; j++) {
			if (arr.get(j) < pivot) {
				i++; // small element found we should increment i.
				swap(arr, i, j); // swap the elements so that small element will
									// come to correct position.
			}
		}
		// after loop ends before ith index all small elements were placed.
		// now swap i index with the pivot.
		swap(arr, i, left);
		return i;
	}

	public static void quicksort(ArrayList<Integer> arr, int low, int high) {
		if (low < high) {
			// dividing array with the pivot.
			int p = partion(arr, low, high);
			quicksort(arr, low, p - 1);
			quicksort(arr, p + 1, high);
		}
	}

	public static void swap(ArrayList<Integer> arr, int i, int j) {
		Integer temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
}
