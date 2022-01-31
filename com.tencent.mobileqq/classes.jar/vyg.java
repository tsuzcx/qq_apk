import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class vyg
  extends QidianBusinessObserver
{
  public vyg(FriendChatPie paramFriendChatPie) {}
  
  protected void d(boolean paramBoolean, HashMap paramHashMap)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a().getString(2131438751), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.a().getString(2131438752), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
  
  protected void e(boolean paramBoolean, HashMap paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (paramHashMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramHashMap.uin)))
      {
        paramHashMap = this.a.b.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if (paramHashMap != null)
        {
          FriendChatPie.a(this.a, true);
          FriendChatPie.a(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          FriendChatPie.a(this.a).setOnClickListener(null);
          if (!this.a.P)
          {
            this.a.g = paramHashMap;
            FriendChatPie.b(this.a).setText(paramHashMap);
            if (ChatActivityConstants.N) {
              FriendChatPie.c(this.a).setContentDescription(paramHashMap);
            }
          }
          FriendChatPie.b(this.a, true);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        FriendChatPie.b(this.a, false);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("FriendChatPie", 2, "onGetQidianUserDetailInfo not current curFriendUin");
      return;
    }
    QLog.d("FriendChatPie", 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyg
 * JD-Core Version:    0.7.0.1
 */