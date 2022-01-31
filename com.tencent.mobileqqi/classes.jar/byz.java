import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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

public class byz
  extends StrangerObserver
{
  public byz(ChatActivity paramChatActivity) {}
  
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField)
  {
    if (this.a.isFinishing()) {}
    label318:
    label319:
    for (;;)
    {
      return;
      if ((ChatActivity.a(this.a) != null) && (ChatActivity.a(this.a).isShowing())) {
        ChatActivity.a(this.a).cancel();
      }
      if (paramBoolean)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        paramBoolean = false;
        if (paramPBRepeatMessageField.hasNext())
        {
          if (!String.valueOf(((oidb_0x5d4.DelResult)paramPBRepeatMessageField.next()).uin.get()).equalsIgnoreCase(this.a.b.a())) {
            break label318;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        break;
        if (!paramBoolean) {
          break label319;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivity", 2, "StrangerObserver : onDelete , result=" + paramBoolean);
        }
        paramPBRepeatMessageField = new ArrayList();
        paramPBRepeatMessageField.add(this.a.a.jdField_a_of_type_JavaLangString);
        ChatActivityFacade.a(this.a.b, BaseApplication.getContext(), paramPBRepeatMessageField);
        paramPBRepeatMessageField = this.a.b.a().a();
        if (paramPBRepeatMessageField != null)
        {
          RecentUser localRecentUser = paramPBRepeatMessageField.a(this.a.a.jdField_a_of_type_JavaLangString, this.a.a.jdField_a_of_type_Int);
          if (QLog.isDevelopLevel()) {
            QLog.d("ChatActivity", 4, "StrangerObserver, delete Recent user");
          }
          paramPBRepeatMessageField.b(localRecentUser);
        }
        QQToast.a(this.a, 2, this.a.getResources().getString(2131561961), 0).a();
        if (ChatActivity.f(this.a)) {
          this.a.setResult(-1);
        }
        this.a.finish();
        return;
        QQToast.a(this.a, this.a.getResources().getString(2131562061), 0).a();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     byz
 * JD-Core Version:    0.7.0.1
 */