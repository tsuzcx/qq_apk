import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx.OnPrivateIMECommandListener;
import java.util.ArrayList;

public class byc
  implements XEditTextEx.OnPrivateIMECommandListener
{
  public byc(ChatActivity paramChatActivity) {}
  
  public boolean a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivity", 2, "onPrivateIMECommand(), action:" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramBundle != null) && (InputMethodUtil.a(this.a)))
    {
      if (!"com.sogou.inputmethod.expression".equals(paramString)) {
        break label229;
      }
      paramString = paramBundle.getString("SOGOU_EXP_PATH");
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivity", 2, "onPrivateIMECommand(), path:" + paramString);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramBundle = new Intent(this.a, SendPhotoActivity.class);
        paramBundle.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramBundle.putExtra("uintype", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramBundle.putExtra("troop_uin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramString);
        paramBundle.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
        paramBundle.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1034);
        paramBundle.putExtra("PicContants.NEED_COMPRESS", false);
        paramBundle.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
        this.a.startActivity(paramBundle);
      }
    }
    label229:
    while (!"com.sogou.inputmethod.appid".equals(paramString)) {
      return true;
    }
    paramBundle = paramBundle.getString("SOGOU_APP_ID");
    Object localObject = this.a.b.a();
    paramString = AuthorityUtil.a(this.a, (String)localObject, paramBundle);
    if (QLog.isColorLevel())
    {
      QLog.d("ChatActivity", 2, "onPrivateIMECommand(), appId:" + paramBundle);
      QLog.d("ChatActivity", 2, "onPrivateIMECommand(), selfUin:" + (String)localObject);
      QLog.d("ChatActivity", 2, "onPrivateIMECommand(), openId:" + paramString);
    }
    paramBundle = (InputMethodManager)this.a.getSystemService("input_method");
    localObject = new Bundle();
    ((Bundle)localObject).putString("SOGOU_OPENID", paramString);
    paramBundle.sendAppPrivateCommand(this.a.jdField_a_of_type_AndroidWidgetEditText, "com.tencent.mobileqq.sogou.openid", (Bundle)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byc
 * JD-Core Version:    0.7.0.1
 */