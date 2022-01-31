import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class bgk
  implements Runnable
{
  public bgk(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "connectingRunnable");
    }
    if (!this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.e())
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 0);
      this.a.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgk
 * JD-Core Version:    0.7.0.1
 */