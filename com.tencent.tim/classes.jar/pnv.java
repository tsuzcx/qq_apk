import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import java.io.File;

@TargetApi(14)
public class pnv
  extends pnq
{
  public pnv(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  protected void a(String[] paramArrayOfString, pnq.a parama)
  {
    int n = paramArrayOfString.length;
    int i = 0;
    if (i < n)
    {
      File localFile1 = new File(paramArrayOfString[i]);
      double d = a(localFile1);
      File[] arrayOfFile = localFile1.listFiles();
      if (arrayOfFile == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l = System.currentTimeMillis();
        int i1 = arrayOfFile.length;
        int k = 0;
        int j = 0;
        for (;;)
        {
          if (j < i1)
          {
            if (j % 150 == 0) {}
            try
            {
              Thread.sleep(100L);
              File localFile2 = arrayOfFile[j];
              int m = k;
              if (l - localFile2.lastModified() > 86400000L)
              {
                deleteFile(localFile2);
                m = k + 1;
              }
              j += 1;
              k = m;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                ram.e("Q.qqstory.cleaner:TimeCleanStep", "sleep error ,InterruptedException");
              }
            }
          }
        }
        parama.bj = (d - a(localFile1) + parama.bj);
        parama.bjx = (k + parama.bjx);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnv
 * JD-Core Version:    0.7.0.1
 */