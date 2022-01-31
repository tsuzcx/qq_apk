import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.VcSystemInfo;

public class bgs
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  
  public bgs(VideoController paramVideoController, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().h < 0)
    {
      VcSystemInfo localVcSystemInfo = new VcSystemInfo();
      localVcSystemInfo.a();
      int i = localVcSystemInfo.d();
      long l = VcSystemInfo.a();
      int j = Build.VERSION.SDK_INT;
      if ((i < 4) || (l / 1000L < 800L) || (j < 9)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().h = 0;
      }
    }
    this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(30), this.jdField_a_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Bgs = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgs
 * JD-Core Version:    0.7.0.1
 */