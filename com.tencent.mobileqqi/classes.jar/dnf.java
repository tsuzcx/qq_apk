import android.os.Message;
import com.tencent.mobileqq.activity.SendMultiPictureHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class dnf
  extends TransProcessorHandler
{
  public dnf(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (FileMsg)paramMessage.obj;
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "file is null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendMultiPictureHelper", 2, "transferListener status: " + i);
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessage.m, paramMessage.k, paramMessage.c);
      } while (this.a.d);
      if (this.a.jdField_b_of_type_Boolean)
      {
        if (paramMessage.u == 1005)
        {
          this.a.jdField_c_of_type_Boolean = true;
          return;
        }
        if (paramMessage.u == 1003)
        {
          this.a.a();
          return;
        }
        SendMultiPictureHelper.a(this.a, this.a.jdField_c_of_type_Int, this.a.jdField_c_of_type_JavaLangString, paramMessage.c);
        return;
      }
      if (paramMessage.u == 1003)
      {
        this.a.a();
        return;
      }
      if (paramMessage.u == 1005)
      {
        this.a.a();
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null);
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.f, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnf
 * JD-Core Version:    0.7.0.1
 */