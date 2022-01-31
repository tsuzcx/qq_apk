import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.IVcController;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.qphone.base.util.QLog;

public class bgq
  implements PhoneStatusMonitor.PhoneStatusListener
{
  bgq(VideoController paramVideoController) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(VideoController.jdField_a_of_type_JavaLangString, 2, "onCallStateChanged isCalling: " + paramBoolean);
    }
    if (paramBoolean) {
      switch (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.e)
      {
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(22), Boolean.valueOf(paramBoolean) });
      return;
      this.a.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 0);
      this.a.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 0);
      continue;
      this.a.jdField_a_of_type_ComTencentAvCoreIVcController.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, this.a.e());
      this.a.a(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 0);
      this.a.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.jdField_a_of_type_JavaLangString, 1);
      continue;
      this.a.b(true);
      continue;
      this.a.a(this.a.jdField_c_of_type_Long);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(67), Long.valueOf(this.a.jdField_c_of_type_Long) });
      continue;
      this.a.b(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.b);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(66), Long.valueOf(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.b) });
      continue;
      switch (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.e)
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        break;
      case 2: 
        if ((this.a.i) && (!TextUtils.isEmpty(this.a.b)))
        {
          this.a.a(this.a.V, this.a.b, this.a.jdField_c_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.v);
          this.a.i = false;
          this.a.V = 0;
          this.a.b = null;
        }
        break;
      case 3: 
      case 4: 
      case 9: 
      case 10: 
        this.a.b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgq
 * JD-Core Version:    0.7.0.1
 */