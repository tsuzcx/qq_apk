import com.tencent.mobileqq.apollo.ai.ApolloAIActivity;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import java.io.File;

public class ylc
  implements Runnable
{
  public ylc(ApolloAIActivity paramApolloAIActivity) {}
  
  public void run()
  {
    try
    {
      File[] arrayOfFile = new File(ApolloConstant.m).listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile.exists()) {
            localFile.delete();
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ylc
 * JD-Core Version:    0.7.0.1
 */