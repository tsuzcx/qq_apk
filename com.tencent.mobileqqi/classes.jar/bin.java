import android.content.Intent;
import android.os.IBinder.DeathRecipient;
import android.text.TextUtils;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class bin
  implements IBinder.DeathRecipient
{
  bin(bim parambim) {}
  
  public void binderDied()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "video process died!");
    }
    String str2;
    String str3;
    String str1;
    Object localObject;
    if (this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.j)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "video chatting!");
      }
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.c)) {
        this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.c = this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
      str2 = this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.b;
      str3 = this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.c;
      if ((this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Int != 1004) && (this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Int != 1000) && (this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Int != 1020)) {
        break label431;
      }
      str1 = this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.d;
      localObject = str2;
    }
    for (;;)
    {
      VideoMsgTools.a(this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Int, 45, true, (String)localObject, str1, true, null, true);
      localObject = new Intent();
      ((Intent)localObject).setAction("tencent.av.v2q.StopVideoChat");
      ((Intent)localObject).putExtra("uinType", this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("peerUin", this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.b);
      ((Intent)localObject).putExtra("extraUin", this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.d);
      ((Intent)localObject).putExtra("onlyAudio", true);
      this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.sendBroadcast((Intent)localObject);
      if (this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        long l1 = this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (l1 > 0L)
        {
          long l2 = Long.valueOf(this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).longValue();
          localObject = new Intent();
          ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
          ((Intent)localObject).putExtra("type", 23);
          ((Intent)localObject).putExtra("friendUin", l2);
          ((Intent)localObject).putExtra("discussId", l1);
          this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.sendBroadcast((Intent)localObject);
        }
      }
      QAVNotification.a(this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.getApplicationContext());
      this.a.jdField_a_of_type_AndroidOsIBinder = null;
      return;
      label431:
      localObject = str2;
      str1 = str3;
      if (this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.jdField_a_of_type_Int == 1006)
      {
        localObject = str2;
        str1 = str3;
        if (!str2.startsWith("+"))
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvServiceQQServiceForAV.d;
          str1 = str3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bin
 * JD-Core Version:    0.7.0.1
 */