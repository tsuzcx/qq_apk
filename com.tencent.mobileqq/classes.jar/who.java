import android.support.annotation.NonNull;
import java.io.File;

public abstract class who
{
  protected who a;
  protected String[] a;
  
  public who(@NonNull String[] paramArrayOfString)
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
  
  public who a(who paramwho)
  {
    this.jdField_a_of_type_Who = paramwho;
    return this.jdField_a_of_type_Who;
  }
  
  public void a(File paramFile)
  {
    try
    {
      zkr.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      yqp.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(whp paramwhp)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramwhp);
    if (this.jdField_a_of_type_Who != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Who.a(paramwhp);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          yqp.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = zkr.a() / 1024L;
      yqp.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramwhp.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramwhp.jdField_a_of_type_Int != 0) {
        yqu.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramwhp.jdField_a_of_type_Int), String.valueOf(paramwhp.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramwhp.jdField_b_of_type_Int == 0);
    yqu.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramwhp.jdField_b_of_type_Int), String.valueOf(paramwhp.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, whp paramwhp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     who
 * JD-Core Version:    0.7.0.1
 */