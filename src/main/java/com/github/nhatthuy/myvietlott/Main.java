package com.github.nhatthuy.myvietlott;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Main {
	public static List<List> ListAll = new ArrayList<List>();
	

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		List<String> results = Files.readAllLines(Paths.get("src", "result.txt"));
		
		for (int i = 0; i < ListAll.size(); i++) {
			for (int j = i + 1; j < ListAll.size(); j++) {
					
				if (CompareTwoList(ListAll.get(i),ListAll.get(j)))
					System.out.println("Có 1 bộ trùng thu : "+i+" va  "+j+"  " + ListAll.get(j));

			}
		}

		List ListRandom = CreatListRandom();

		for (int i = 0; i < ListAll.size(); i++) {
			if (!CompareTwoList(ListAll.get(i), ListRandom))
				break;

		}

		System.out.println("BO SO MAY MAN CUA BAN LA:");
		Collections.sort(ListRandom);
		System.out.println(ListRandom);

	}

	public static List<List> CreatListRandom() {
		List ListRandom = new ArrayList();
		Random rd = new Random();

		Vector v = new Vector();
		int iNew = 0;
		for (int i = 0; i < 6;) {
			iNew = rd.nextInt(45) + 1;
			if (!v.contains(iNew)) {
				i++;
				v.add(iNew);
				ListRandom.add(iNew);
			}
		}
		return ListRandom;
	}

	public static Boolean CompareTwoList(List<String> L1, List L2)
	{
		List<String> LA = new ArrayList<String>(L1);
	
		LA.removeAll(L2);
		if (LA.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}
}