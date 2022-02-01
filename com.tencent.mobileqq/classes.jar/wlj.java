import android.support.annotation.NonNull;
import java.io.File;

public abstract class wlj
{
  protected wlj a;
  protected String[] a;
  
  public wlj(@NonNull String[] paramArrayOfString)
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
  
  public wlj a(wlj paramwlj)
  {
    this.jdField_a_of_type_Wlj = paramwlj;
    return this.jdField_a_of_type_Wlj;
  }
  
  public void a(File paramFile)
  {
    try
    {
      zom.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      yuk.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(wlk paramwlk)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramwlk);
    if (this.jdField_a_of_type_Wlj != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Wlj.a(paramwlk);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          yuk.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = zom.a() / 1024L;
      yuk.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramwlk.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramwlk.jdField_a_of_type_Int != 0) {
        yup.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramwlk.jdField_a_of_type_Int), String.valueOf(paramwlk.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramwlk.jdField_b_of_type_Int == 0);
    yup.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramwlk.jdField_b_of_type_Int), String.valueOf(paramwlk.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, wlk paramwlk);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlj
 * JD-Core Version:    0.7.0.1
 */