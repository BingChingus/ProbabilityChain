public class ProbabilityChain 
{
 public static void main(String[] args)
 {
    /*
     * Goal: run a series of "coin flips" for however long, displaying the longest consecutive chain of heads/tails
     * 
     * 1. make coin
     * 2. devise way to recognize a chain and keep track of record length
     */

    int coin;
    int prevFlip  = 0;
    int length    = 0;
    int maxLength = 0;

    int i = 0; //needed for the first time around, since there aren't any prev flips
    while(true)
    {
        coin = (int) (Math.random() * 2); //heads = 0, tails = 1
        //System.out.println(coin); //test code

        if(i == 0)
        {
            prevFlip = coin;
            i++;
        }

        if (prevFlip == coin)
        {
            length++;

            if (length > maxLength)
            {
                maxLength = length;

                if (coin == 0)
                {
                    System.out.println("Current Chain: " + "Heads at " + maxLength);
                }
                else
                {
                    System.out.println("Current Chain: " + "Tails at " + maxLength);
                }
            }
        }
        else
        {
            length = 0;
        }

        prevFlip = coin;
    }

 }    
}
