import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.BaseActivity;
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

public class bzn
  extends StrangerObserver
{
  public bzn(FriendChatPie paramFriendChatPie) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField)
  {
    if (FriendChatPie.a(this.a).isFinishing()) {}
    label325:
    label326:
    for (;;)
    {
      return;
      if (FriendChatPie.a(this.a) != null) {
        FriendChatPie.b(this.a).dismiss();
      }
      if (paramBoolean)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        paramBoolean = false;
        if (paramPBRepeatMessageField.hasNext())
        {
          if (!String.valueOf(((oidb_0x5d4.DelResult)paramPBRepeatMessageField.next()).uin.get()).equalsIgnoreCase(FriendChatPie.c(this.a).jdField_a_of_type_JavaLangString)) {
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
          QLog.d("ChatActivity", 2, "StrangerObserver : onDelete , result=" + paramBoolean);
        }
        paramPBRepeatMessageField = new ArrayList();
        paramPBRepeatMessageField.add(FriendChatPie.d(this.a).jdField_a_of_type_JavaLangString);
        ChatActivityFacade.a(FriendChatPie.a(this.a), BaseApplication.getContext(), paramPBRepeatMessageField);
        paramPBRepeatMessageField = FriendChatPie.b(this.a).a().a();
        if (paramPBRepeatMessageField != null)
        {
          RecentUser localRecentUser = paramPBRepeatMessageField.a(FriendChatPie.e(this.a).jdField_a_of_type_JavaLangString, FriendChatPie.f(this.a).jdField_a_of_type_Int);
          if (QLog.isDevelopLevel()) {
            QLog.d("ChatActivity", 4, "StrangerObserver, delete Recent user");
          }
          paramPBRepeatMessageField.b(localRecentUser);
        }
        QQToast.a(FriendChatPie.b(this.a), 2, FriendChatPie.c(this.a).getResources().getString(2131364311), 0).a();
        if (this.a.g) {
          FriendChatPie.d(this.a).setResult(-1);
        }
        this.a.t();
        return;
        QQToast.a(FriendChatPie.e(this.a), FriendChatPie.f(this.a).getResources().getString(2131364312), 0).a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzn
 * JD-Core Version:    0.7.0.1
 */