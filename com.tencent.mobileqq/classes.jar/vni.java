import android.support.annotation.NonNull;
import java.io.File;

public abstract class vni
{
  protected vni a;
  protected String[] a;
  
  public vni(@NonNull String[] paramArrayOfString)
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
  
  public vni a(vni paramvni)
  {
    this.jdField_a_of_type_Vni = paramvni;
    return this.jdField_a_of_type_Vni;
  }
  
  public void a(File paramFile)
  {
    try
    {
      ypi.d(paramFile.getPath());
      return;
    }
    catch (Exception paramFile)
    {
      xvv.d("Q.qqstory.cleaner:AbsCleanStep", "delete failed : " + paramFile);
    }
  }
  
  public void a(vnj paramvnj)
  {
    a(this.jdField_a_of_type_ArrayOfJavaLangString, paramvnj);
    if (this.jdField_a_of_type_Vni != null) {}
    long l;
    do
    {
      try
      {
        Thread.sleep(100L);
        this.jdField_a_of_type_Vni.a(paramvnj);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          xvv.e("Q.qqstory.cleaner:AbsCleanStep", "sleep error ,InterruptedException");
        }
      }
      l = ypi.a() / 1024L;
      xvv.d("Q.qqstory.cleaner:AbsCleanStep", "clean cache over , spend time = %d , free size = %d", new Object[] { Long.valueOf(System.currentTimeMillis() - paramvnj.jdField_a_of_type_Long), Long.valueOf(l) });
      if (paramvnj.jdField_a_of_type_Int != 0) {
        xwa.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(0), String.valueOf(paramvnj.jdField_a_of_type_Int), String.valueOf(paramvnj.jdField_a_of_type_Double), String.valueOf(l) });
      }
    } while (paramvnj.jdField_b_of_type_Int == 0);
    xwa.b("story_cache", "clear_cache", 0, 0, new String[] { String.valueOf(1), String.valueOf(paramvnj.jdField_b_of_type_Int), String.valueOf(paramvnj.jdField_b_of_type_Double), String.valueOf(l) });
  }
  
  protected abstract void a(String[] paramArrayOfString, vnj paramvnj);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vni
 * JD-Core Version:    0.7.0.1
 */