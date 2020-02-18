/*Colin Brennan ITM 411 Lab 2*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.*;
import java.util.*;

public class BankRecords extends Client {
	// setup static objects for IO processing
	// array of BankRecords objects
	static BankRecords robjs[] = new BankRecords[600];

	// array list to hold spreadsheet rows & columns
	static ArrayList<List<String>> array = new ArrayList<>();

	// instance fields
	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private int children;
	private String car;
	private String save_act;
	private String current_act;
	private String mortgage;
	private String pep;

	/* create remaining instance fields with appropriate data types */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getSave_act() {
		return save_act;
	}

	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}

	public String getCurrent_act() {
		return current_act;
	}

	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}

	public String getMortgage() {
		return mortgage;
	}

	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}

	// read data
	public void readData() {
		BufferedReader br;
		try {
			// initialize reader object and set file path to root of project
			br = new BufferedReader(new FileReader(new File("bank-Detail.csv")));

			String line;

			// read each record in csv file
			try {
				while ((line = br.readLine()) != null) {
					// parse each record in csv file by a comma ( , )
					// into a list stored in the arraylist-&gt; Arrays
					array.add(Arrays.asList(line.split(",")));
				}
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

		// call function for processing record data
		processData();
	}

	public void processData() {
		// create index for array while iterating thru arraylist
		int idx = 0;

		/*
		 * create for each loop to cycle thru arraylist of values and PASS that data
		 * into your record objects' setters�
		 */
		for (List<String> rowData : array) {

			// initialize array of objects
			robjs[idx] = new BankRecords();

			// call setters below�and populate them, item by item
			robjs[idx].setId(rowData.get(0)); // get 1st column
			robjs[idx].setAge(Integer.parseInt(rowData.get(1))); // get 2 nd column
			robjs[idx].setSex(rowData.get(2));
			robjs[idx].setRegion(rowData.get(3));
			robjs[idx].setIncome(Double.parseDouble(rowData.get(4)));
			robjs[idx].setMortgage(rowData.get(10));

			/*
			 * continue processing arraylist item values into each array object-&gt; robjs[]
			 * by index
			 */

			idx++;
		}
		printData(); // call function to print objects held in memory
	}

	public void printData() {
		// 1. Set appropriate headings for displaying first 25 records
		// 2. Create for loop and print each record objects instance data
		// 3. Within for loop use appropriate formatting techniques to print
		// out record detail
		System.out.println("ID\t\tAGE\t\tSEX\t\tREGION\t\tINCOME\t\tMORTGAGE");

		for (int idx = 0; idx < 25; idx++) {
			System.out.format("%s\t\t", robjs[idx].getId());
			System.out.format("%d\t\t", robjs[idx].getAge());
			System.out.format("%s\t\t", robjs[idx].getSex());
			System.out.format("%s\t\t", robjs[idx].getRegion());
			System.out.format("%.2f\t\t", robjs[idx].getIncome());
			System.out.format("%s\t\t", robjs[idx].getMortgage());
			System.out.print("\n");
		}

	}

}