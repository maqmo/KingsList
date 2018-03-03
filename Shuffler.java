package hw1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Shuffler {

	private String[] list;
	private String[] shuffledList;
	private Random randomGenerator;
	int randomIndex;

	public Shuffler(String[] list) {
		this.list = list;
		randomGenerator = new Random(System.currentTimeMillis());
		randomizeIndex();
		shuffledList = shuffle();

	}

	public Shuffler(String fileName) throws IOException {
		list = readFile(fileName); 
		randomGenerator = new Random(System.currentTimeMillis());
		randomizeIndex();
		shuffledList = shuffle();
	}

	public String[] getList(){
		return list;
	}

	public int getRandomIndex(){
		return randomIndex;
	}

	public void setRandomIndex(int index) {
		randomIndex = index;
	}

	public void randomizeIndex() {
		randomIndex = (int)(randomGenerator.nextDouble() * list.length);
	}

	public String[] getShuffledList(){
		return shuffledList;
	}

	public String[] readFile(String fileName) throws IOException {
		List<String> lines = new ArrayList<String>();
		BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
		String fileLine = "";
		while ((fileLine = inputStream.readLine()) != null)
			lines.add(fileLine);
		inputStream.close();
		return lines.toArray(new String[1]);
	}



//untested..__--``--__....__--``--__....__--``--__....__--``--__....__--``--__....__--``--__....__--``--__....__--``--__....__--``--__..


public void writeFile(String fileName) throws IOException {
	Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
	for (int i =0 ; i< list.length; i++) {
		w.write(shuffledList[i] + "\n");
	}
	w.close();
}

private String[] shuffle()	{
	int end = list.length - 1;
	String temp = "";
	String[] listCopy = Arrays.copyOf(list, list.length);
	while (end >= 0) {
		temp = listCopy[end];
		listCopy[end] = listCopy[randomIndex];
		listCopy[randomIndex] = temp;
		randomizeIndex();
		end--;
	}
	return listCopy;
}
public int getDiffBetweenLists() {
	int count = 0;
	for (int i = 0 ; i < list.length; i++) {
		if (list[i] == shuffledList[i])
			count++;
	}
	return count;
}

public static void main(String[] args){

	String[] letters = {"a","b","c","d","e","f","g"};
	Shuffler s = null;
	if (args.length == 1) {
		try {
			s = new Shuffler(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	else {
		s = new Shuffler(letters);
	}
	System.out.println(Arrays.toString(s.getShuffledList()));
	System.out.println(Arrays.toString(s.getList()));
	System.out.println(s.getDiffBetweenLists());
	try {
		s.writeFile("flea.txt");
	} catch (IOException e) {
		e.printStackTrace();
	}


}
}