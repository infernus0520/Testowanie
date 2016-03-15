package wejsciowka01;

import java.util.ArrayList;
import java.util.List;

public class SportowiecManager {
	public List<Sportowiec> getSportowcy() {
		return sportowcy;
	}
	public void setSportowcy(List<Sportowiec> sportowcy) {
		this.sportowcy = sportowcy;
	}
	List<Sportowiec> sportowcy;
	
	public SportowiecManager(){
	sportowcy = new ArrayList();
	}
	
	public void add(Sportowiec s){
		sportowcy.add(s);
	}
	public List<Sportowiec> getAll() {
		return sportowcy;		
	}
}
