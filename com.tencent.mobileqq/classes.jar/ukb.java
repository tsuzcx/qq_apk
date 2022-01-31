import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import java.io.File;

@TargetApi(14)
public class ukb
  extends ujt
{
  public ukb(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
  }
  
  protected void a(String[] paramArrayOfString, uju paramuju)
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
                a(localFile2);
                m = k + 1;
              }
              j += 1;
              k = m;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                wsv.e("Q.qqstory.cleaner:TimeCleanStep", "sleep error ,InterruptedException");
              }
            }
          }
        }
        paramuju.jdField_b_of_type_Double = (d - a(localFile1) + paramuju.jdField_b_of_type_Double);
        paramuju.jdField_b_of_type_Int = (k + paramuju.jdField_b_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukb
 * JD-Core Version:    0.7.0.1
 */