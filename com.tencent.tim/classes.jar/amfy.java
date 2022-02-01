import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class amfy
  implements QQPermissionCallback
{
  public amfy(SignTextEditFragment paramSignTextEditFragment, AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 2, "requestPermission user denied");
    }
    aqha.a(this.jdField_a_of_type_MqqAppAppActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignTextEditFragment", 2, "requestPermission user grant");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignTextEditFragment.dNh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfy
 * JD-Core Version:    0.7.0.1
 */