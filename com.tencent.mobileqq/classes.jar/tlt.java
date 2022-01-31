import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;

public class tlt
  extends FriendListObserver
{
  public tlt(QQSettingMe paramQQSettingMe) {}
  
  protected void onGetStoreFace(boolean paramBoolean, String paramString)
  {
    onUpdateCustomHead(paramBoolean, paramString);
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.a(paramString);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new tlu(this));
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1) && (this.a.c)) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new tlv(this));
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int k = 0;
    String str;
    int i;
    if ((paramBoolean) && (this.a.c) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (str != null)
      {
        j = k;
        if (i < paramArrayOfString.length)
        {
          if (!str.equals(paramArrayOfString[i])) {
            break label97;
          }
          j = 1;
        }
      }
      if (j != 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new tlw(this));
      }
      return;
      label97:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tlt
 * JD-Core Version:    0.7.0.1
 */