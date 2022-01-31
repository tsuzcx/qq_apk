import android.support.annotation.NonNull;
import java.io.File;

public abstract class ujt
{
  protected ujt a;
  protected String[] a;
  
  public ujt(@NonNull String[] paramArrayOfString)
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
  
  public ujt a(ujt paramujt)
  {
    this.jdField_a_of_type_Ujt = paramujt;
    return this.jdField_a_of_type_Ujt;
  }
  
  public void a(File paramFile)
  {
    try
    {
      xmx.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      wsv.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(uju paramuju)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramuju);
    if (this.jdField_a_of_type_Ujt != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Ujt.a(paramuju);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          wsv.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = xmx.a() / 1024L;
      wsv.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramuju.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramuju.jdField_a_of_type_Int != 0) {
        wta.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramuju.jdField_a_of_type_Int), String.valueOf(paramuju.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramuju.jdField_b_of_type_Int == 0);
    wta.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramuju.jdField_b_of_type_Int), String.valueOf(paramuju.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, uju paramuju);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujt
 * JD-Core Version:    0.7.0.1
 */