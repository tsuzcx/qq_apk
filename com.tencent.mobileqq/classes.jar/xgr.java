import java.io.InputStream;
import java.util.ArrayList;

public abstract class xgr
{
  protected static int a;
  protected static ArrayList<String[]> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String a(String paramString)
  {
    return sds.b(paramString);
  }
  
  public abstract xgs a(String paramString);
  
  public abstract void a();
  
  public abstract void a(String paramString);
  
  public abstract boolean a(String paramString);
  
  public abstract boolean a(String paramString, InputStream paramInputStream);
  
  public abstract boolean a(String paramString1, String paramString2);
  
  public void b()
  {
    for (;;)
    {
      try
      {
        int i = jdField_a_of_type_Int;
        if (i >= 1) {
          return;
        }
        jdField_a_of_type_Int += 1;
        if (jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          String[] arrayOfString = (String[])jdField_a_of_type_JavaUtilArrayList.remove(0);
          a(arrayOfString[0], arrayOfString[1]);
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        else
        {
          jdField_a_of_type_Int -= 1;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xgr
 * JD-Core Version:    0.7.0.1
 */