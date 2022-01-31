import android.support.annotation.NonNull;
import java.io.File;

public abstract class uoc
{
  protected uoc a;
  protected String[] a;
  
  public uoc(@NonNull String[] paramArrayOfString)
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
  
  public uoc a(uoc paramuoc)
  {
    this.jdField_a_of_type_Uoc = paramuoc;
    return this.jdField_a_of_type_Uoc;
  }
  
  public void a(File paramFile)
  {
    try
    {
      xrg.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      wxe.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(uod paramuod)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramuod);
    if (this.jdField_a_of_type_Uoc != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Uoc.a(paramuod);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          wxe.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = xrg.a() / 1024L;
      wxe.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramuod.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramuod.jdField_a_of_type_Int != 0) {
        wxj.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramuod.jdField_a_of_type_Int), String.valueOf(paramuod.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramuod.jdField_b_of_type_Int == 0);
    wxj.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramuod.jdField_b_of_type_Int), String.valueOf(paramuod.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, uod paramuod);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uoc
 * JD-Core Version:    0.7.0.1
 */