import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatShare;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;

public class zml
  implements Runnable
{
  public zml(HotChatShare paramHotChatShare) {}
  
  public void run()
  {
    Object localObject = "stranger_" + String.valueOf(200) + "_" + this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin;
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject);
    if ((localObject != null) && (!TextUtils.isEmpty(((Setting)localObject).url))) {
      this.a.b = (((Setting)localObject).url + "140");
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatShare", 2, "handleShare.fromdb.ownerHeadUrl=" + this.a.b);
    }
    if (!TextUtils.isEmpty(this.a.b)) {
      if (this.a.jdField_a_of_type_Int == 0) {
        this.a.jdField_a_of_type_Int = 2;
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Int == 3) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new zmm(this));
      }
      return;
      if (this.a.jdField_a_of_type_Int == 1)
      {
        this.a.jdField_a_of_type_Int = 3;
        continue;
        ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.ownerUin, 200, (byte)1, (byte)3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zml
 * JD-Core Version:    0.7.0.1
 */