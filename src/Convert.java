/**
 * Created by Ryan on 2/13/2018.
 */
public class Convert {

    public static void main(String args[]){
        if (args.length==0){
            System.out.println("Error: No Filename Given");
            System.exit(0);
        }
        XMLConverter file = new XMLConverter(args[0]);
    }

}
