import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;

public class vpr
  extends StrangerObserver
{
  public vpr(FriendChatPie paramFriendChatPie) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField)
  {
    if (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {}
    label325:
    label326:
    for (;;)
    {
      return;
      if (this.a.c != null) {
        this.a.c.dismiss();
      }
      if (paramBoolean)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        paramBoolean = false;
        if (paramPBRepeatMessageField.hasNext())
        {
          if (!String.valueOf(((oidb_0x5d4.DelResult)paramPBRepeatMessageField.next()).uin.get()).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label325;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        break;
        if (!paramBoolean) {
          break label326;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendChatPie", 2, "StrangerObserver : onDelete , result=" + paramBoolean);
        }
        paramPBRepeatMessageField = new ArrayList();
        paramPBRepeatMessageField.add(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), paramPBRepeatMessageField);
        paramPBRepeatMessageField = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        if (paramPBRepeatMessageField != null)
        {
          RecentUser localRecentUser = paramPBRepeatMessageField.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          if (QLog.isDevelopLevel()) {
            QLog.d("FriendChatPie", 4, "StrangerObserver, delete Recent user");
          }
          paramPBRepeatMessageField.b(localRecentUser);
        }
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131436899), 0).a();
        if (this.a.n) {
          this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1);
        }
        this.a.A();
        return;
        QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131436900), 0).a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpr
 * JD-Core Version:    0.7.0.1
 */