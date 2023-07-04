import java.text.DecimalFormat;

public class ProbabilityChain 
{
 public static void main(String[] args)
 {

    int coin;
    int prevFlip  = 0;
    int numFlips  = 0;
    int length    = 0;
    int maxLength = 0;

    //format will be used to make the numFlips value actually readable
    DecimalFormat format = new DecimalFormat();
    format.getDecimalFormatSymbols().setGroupingSeparator(',');
    format.setGroupingSize(3);

    int i = 0; //needed for the first time around, since there aren't any prev flips
    while(true)
    {
        coin = (int) (Math.random() * 2); //heads = 0, tails = 1

        //if it's the first flip, the previous flip is the current one (only for the first flip)
        if(i == 0)
        {
            prevFlip = coin;
            i++;
        }

        //checks if chain is unbroken
        if (prevFlip == coin)
        {
            length++;

            //checks if chain beats the longest one
            if (length > maxLength)
            {
                maxLength = length;

                //prints correct info if theres a new record
                if (coin == 0)
                {
                    System.out.println("Current Chain: " + "Heads at " + maxLength + " after " + format.format(numFlips) + " flips");
                }
                else
                {
                    System.out.println("Current Chain: " + "Tails at " + maxLength + " after " + format.format(numFlips) + " flips");
                }
            }
        }
        else
        {
            length = 0; //reset if chain is broken
        }

        prevFlip = coin;
        numFlips++;
    }

 }    
}
