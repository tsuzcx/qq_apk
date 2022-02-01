import android.support.annotation.NonNull;
import java.io.File;

public abstract class wcd
{
  protected wcd a;
  protected String[] a;
  
  public wcd(@NonNull String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public static double a(File paramFile)
  {
    double d1 = 0.0D;
    double d2;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      d2 = d1;
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        for (;;)
        {
          d2 = d1;
          if (i >= j) {
            break;
          }
          d2 = a(paramFile[i]);
          i += 1;
          d1 = d2 + d1;
        }
      }
    }
    else
    {
      d2 = paramFile.length() / 1024.0D / 1024.0D;
    }
    return d2;
  }
  
  public wcd a(wcd paramwcd)
  {
    this.jdField_a_of_type_Wcd = paramwcd;
    return this.jdField_a_of_type_Wcd;
  }
  
  public void a(File paramFile)
  {
    try
    {
      zeb.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      ykq.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(wce paramwce)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramwce);
    if (this.jdField_a_of_type_Wcd != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Wcd.a(paramwce);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          ykq.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = zeb.a() / 1024L;
      ykq.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramwce.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramwce.jdField_a_of_type_Int != 0) {
        ykv.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramwce.jdField_a_of_type_Int), String.valueOf(paramwce.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramwce.jdField_b_of_type_Int == 0);
    ykv.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramwce.jdField_b_of_type_Int), String.valueOf(paramwce.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, wce paramwce);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcd
 * JD-Core Version:    0.7.0.1
 */