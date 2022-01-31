import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class bgj
  implements Runnable
{
  public bgj(VideoController paramVideoController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "networkBrokenRunnable");
    }
    if ((this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.e > 0) && (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.e <= 4))
    {
      this.a.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 0);
      this.a.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 9);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_Long, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgj
 * JD-Core Version:    0.7.0.1
 */