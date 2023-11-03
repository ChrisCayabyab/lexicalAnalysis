import java.util.Scanner;

public class LexicalAnalysis
{
    static String[] array, arrayOrig;
    static String sourceLanguage, output="Output is: ", concatenate="";
    static boolean isValid;
    static Scanner sc;
    public static void main(String[] args) {

        start();
        split();
        assessValue();
        print();
    }
    static void start()
    {
        sc = new Scanner(System.in);
        System.out.print("Enter Source Language:");
        sourceLanguage = sc.nextLine();
    }
    static void split()
    {
        arrayOrig = sourceLanguage.split(" ");

        isValid();

        if(arrayOrig.length<3) {
            array = new String[2];
            for (int i = 0; i < arrayOrig.length; i++)
            {
                array[i] = arrayOrig[i];
            }
        }
        if(arrayOrig.length>2) {
            array = new String[4];

            for(int i=0; i<arrayOrig.length;i++)
            {
                if(i>2) {
                    concatenate += arrayOrig[i];
                }
                else{
                    array[i] = arrayOrig[i];
                }
            }
            array[3] = concatenate;}
    }
    static void assessValue(){

        if(array[0].equalsIgnoreCase("int") || array[0].equalsIgnoreCase("Double") || array[0].equalsIgnoreCase("String") || array[0].equalsIgnoreCase("Char")) {
            output+= "<data_type>";
        }
        if(!array[1].contains("\"")){
            output += "<identifier>";
        }
        if(array.length<3) {
            if (array[1].contains(";")) {
                output += "<delimiter>";
            }
        }
        if(array.length>3) {
            if (array[2] != null && array[2].contains("=")) {
                output += "<assignment_operator>";
            }
            if (array[3] != null && array[0].equalsIgnoreCase("int") && array[3].contains("1") && !array[3].contains("\"") && !array[3].contains(".")) {
                output += "<value>";
            }
            if (array[3] != null && array[0].equalsIgnoreCase("Double") && array[3].contains(".") && !array[3].contains("\"")) {
                output += "<value>";
            }
            if (array[3] != null && array[0].equalsIgnoreCase("String") && array[3].contains("\"")) {
                output += "<value>";
            }
            if (array[3] != null && array[0].equalsIgnoreCase("Char") && array[3].contains("\'")) {
                output += "<value>";
            }
            if (array[3].contains(";")) {
                output += "<delimiter>";
            }
        }
    }
    static void isValid()
    {
        if(sourceLanguage.charAt(sourceLanguage.length()-1)==';')
        {
                isValid = true;
        }
        if(arrayOrig.length<2){
            System.out.println("Invalid Input");
            System.exit(0);
        }
    }
    static void print(){
        System.out.println(output + "\n");
    }
}