import com.tencent.mobileqq.activity.aio.doodle.LineLayer;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class uph
  implements Runnable
{
  public final String a;
  
  public uph(LineLayer paramLineLayer)
  {
    this.jdField_a_of_type_JavaLangString = (AppConstants.bM + "temp" + File.separator);
  }
  
  public void run()
  {
    try
    {
      FileUtils.a(this.jdField_a_of_type_JavaLangString, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ClearTempFileJobdownloading", 2, "makedir execption: " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */