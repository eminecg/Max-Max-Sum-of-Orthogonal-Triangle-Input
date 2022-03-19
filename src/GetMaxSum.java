import java.io.*;
import java.util.*;
import static java.lang.Math.max;


public class GetMaxSum {
    public static void main(String[] args) throws IOException {
        // Change the current file address
        String fileAddress="C:\\Users\\emine\\OneDrive\\Belgeler\\GitHub\\Max-Max-Sum-of-Orthogonal-Triangle-Input\\test.txt";

        String inputSample =
                "1\n" +
                        "8 4\n" +
                        "2 6 9\n" +
                        "8 5 9 3" ;

        //Reading from a file
        File file = new File(fileAddress);
        Scanner sc = new Scanner(file);

        String input="";
        while (sc.hasNextLine())
            input+=sc.nextLine()+"\n";


        ArrayList <ArrayList<Integer>> temp_ =generate2DArray(input);
        int maxSum=getSum(temp_, 0, 0, temp_.size(), temp_.get(0).size());
        System.out.println(maxSum);

    }

    public static ArrayList <ArrayList<Integer>> generate2DArray ( String input)
    {

        String[] lines = input.split("\\R");

        for(int i=0; i<lines.length ;i++){
            int temp= lines.length-1-i;
            while (temp>0){
                lines[i]=lines[i]+" -1";
                temp--;
            }
        }


        ArrayList <ArrayList<Integer>> inputAsInt =new ArrayList<>();

        for(int i=0; i<lines.length ;i++){
            //for each line
            String[] splited_line =lines[i].split(" ");
            ArrayList <Integer> temp=new ArrayList<>();

            for (int j = 0; j < splited_line.length; j++) {
                int number =Integer.parseInt(splited_line[j]);
                if(isPrime(number)==false){
                    temp.add(Integer.parseInt(splited_line[j]));
                }
                else{
                    temp.add(-1);
                }

            }
            inputAsInt.add(i,temp);
        }


        return inputAsInt;  // checks non-prime numbers and returns them from converted array
    }

    public static boolean isPrime(int number)
    {
        // Test whether the parameter is a prime number.
        if ((number & 1) == 0)
        {
            if (number == 2)
            {
                return true;
            }
            return false;
        }

        for (int i = 3; (i * i) <= number; i += 2)
        {
            if ((number % i) == 0)
            {
                return false;
            }
        }
        return number != 1;
    }

    public static int getSum(ArrayList <ArrayList<Integer>> input , int i, int j, int row, int col){
        if(j == col ){
            return 0;
        }

        if(i == row-1 ){
            return input.get(i).get(j) ;
        }

        return input.get(i).get(j) + max(getSum(input, i+1, j, row, col),
                getSum(input, i+1, j+1, row, col)) ;
    }

}
