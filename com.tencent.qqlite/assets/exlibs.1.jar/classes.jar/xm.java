import android.app.Dialog;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class xm
  extends MessageObserver
{
  public xm(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(String paramString)
  {
    if ((AddRequestActivity.a(this.a) != null) && (AddRequestActivity.a(this.a).isShowing()))
    {
      AddRequestActivity.a(this.a).dismiss();
      paramString = this.a.getString(2131362903);
      QQToast.a(this.a, 1, paramString, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.dismissDialog(2);
    }
    this.a.a(2130838004, this.a.getString(2131363424));
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (paramInt1 == 0) {
      return;
    }
    long l2 = FriendSystemMsgController.a().b();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      l1 = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        if (AddRequestActivity.a(this.a) != null) {
          AddRequestActivity.a(this.a).dismiss();
        }
        if (SystemMsgUtils.a(FriendSystemMsgController.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4)) {
          this.a.finish();
        }
        AddRequestActivity.a(this.a, false);
        return;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        l1 = l2;
        continue;
        if (AddRequestActivity.a(this.a) != null) {
          AddRequestActivity.a(this.a).dismiss();
        }
        this.a.finish();
        SystemMsgUtils.a(FriendSystemMsgController.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
        if (AddRequestActivity.b(this.a)) {
          FriendSystemMsgController.a().a(Long.valueOf(l1)).msg.friend_info.msg_blacklist.setHasFlag(false);
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.dismissDialog(2);
    }
    this.a.a(2130838004, this.a.getString(2131363425));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xm
 * JD-Core Version:    0.7.0.1
 */