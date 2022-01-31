import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler;
import com.tencent.qphone.base.util.QLog;

public class flt
  extends Handler
{
  public flt(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler, Looper paramLooper, QQAppInterface paramQQAppInterface)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1001: 
      QLog.d("UploadPhoto", 2, "Get Message Progress. clientKey= " + paramMessage.arg1 + " progress=" + paramMessage.arg2);
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1000: 
      QLog.d("UploadPhoto", 2, "Get Message Finished. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1003: 
      QLog.d("UploadPhoto", 2, "Get Message failed. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      return;
    case 1005: 
      QLog.d("UploadPhoto", 2, "Get Message task removed. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      i = paramMessage.arg1;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, i, paramMessage.arg2);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a.remove(i);
      return;
    case 1004: 
      QLog.d("UploadPhoto", 2, "Get Message no task. clientKey= " + paramMessage.arg1 + " arg2=" + paramMessage.arg2);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(paramMessage.what, paramMessage.arg1, paramMessage.arg2);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a.clear();
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    int i = ((Integer)paramMessage[0]).intValue();
    flw localflw = (flw)paramMessage[1];
    int j = ((Integer)paramMessage[2]).intValue();
    int k = ((Integer)paramMessage[3]).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(localflw.jdField_a_of_type_Long, j, k);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopQZoneUploadAlbumHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, localflw.jdField_a_of_type_JavaLangString, localflw.jdField_a_of_type_Long, j, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     flt
 * JD-Core Version:    0.7.0.1
 */