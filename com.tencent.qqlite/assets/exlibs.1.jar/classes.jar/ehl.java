import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import java.io.File;

public class ehl
  extends Thread
{
  public ehl(ShareAppLogHelper paramShareAppLogHelper, String paramString) {}
  
  public void run()
  {
    try
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ehl
 * JD-Core Version:    0.7.0.1
 */