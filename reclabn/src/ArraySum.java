
public class ArraySum {

	public int sumOfArray(Integer[] myArray, int sumto) {
		return sumOfArray(myArray,sumto,0);
		
	}
	public int sumOfArray(Integer[] myArray, int sumto,int i) {
		if(i<=sumto) {
			return sumOfArray( myArray,  sumto, i+1)+myArray[i];
		}else
			return 0;
		
	}

}
