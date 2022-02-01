import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ufa
  extends achq
{
  public ufa(AddRequestActivity paramAddRequestActivity) {}
  
  protected void L(boolean paramBoolean, String paramString)
  {
    if ((this.this$0.k != null) && (this.this$0.k.isShowing())) {
      this.this$0.dismissDialog(2);
    }
    this.this$0.aL(2130840113, this.this$0.getString(2131720219));
  }
  
  protected void M(boolean paramBoolean, String paramString)
  {
    if ((this.this$0.k != null) && (this.this$0.k.isShowing())) {
      this.this$0.dismissDialog(2);
    }
    this.this$0.aL(2130840113, this.this$0.getString(2131720204));
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (!AddRequestActivity.b(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionFin");
      }
      return;
    }
    long l2 = anzd.a().hf();
    long l1 = l2;
    if (!TextUtils.isEmpty(paramString1)) {}
    structmsg.StructMsg localStructMsg;
    try
    {
      l1 = Long.parseLong(paramString1);
      localStructMsg = anzd.a().a(Long.valueOf(l1));
      if (!paramBoolean) {
        if (!TextUtils.isEmpty(paramString3))
        {
          QQToast.a(this.this$0, 1, paramString3, 0).show(this.this$0.getTitleBarHeight());
          if (anzf.a(localStructMsg, paramInt3, paramString2, paramString4)) {
            this.this$0.finish();
          }
          AddRequestActivity.a(this.this$0, false);
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        l1 = l2;
        continue;
        paramString3 = this.this$0.getResources().getString(2131719483);
      }
      anzf.a(localStructMsg, paramInt1, paramString2, paramInt2);
      if ((AddRequestActivity.c(this.this$0)) && (localStructMsg != null)) {
        localStructMsg.msg.friend_info.msg_blacklist.setHasFlag(false);
      }
      paramString2 = null;
      if (paramInt1 != 1) {
        break label257;
      }
    }
    this.this$0.setResult(-1);
    this.this$0.finish();
    paramString1 = this.this$0.getResources().getString(2131694032);
    label257:
    do
    {
      do
      {
        QQToast.a(this.this$0, 2, paramString1, 0).show(this.this$0.getTitleBarHeight());
        break;
        paramString1 = paramString2;
      } while (paramInt1 != 0);
      paramString1 = paramString2;
    } while (localStructMsg == null);
    paramString2 = this.this$0.getResources().getString(2131694020);
    paramString3 = new Bundle();
    paramString3.putString("base_uin", String.valueOf(localStructMsg.req_uin.get()));
    paramString1 = this.this$0.strNickName;
    if (TextUtils.isEmpty(this.this$0.strNickName)) {
      paramString1 = this.this$0.aKN;
    }
    paramString3.putString("base_nick", paramString1);
    paramString3.putInt("verfy_type", AddRequestActivity.b(this.this$0));
    paramString3.putString("verfy_msg", AddRequestActivity.a(this.this$0));
    if (AddRequestActivity.a(this.this$0) != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString3.putBoolean("isFromWzry", paramBoolean);
      AutoRemarkActivity.a(this.this$0, 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
      paramString1 = paramString2;
      break;
    }
  }
  
  protected void iv(String paramString)
  {
    if (AddRequestActivity.d(this.this$0))
    {
      paramString = this.this$0.getString(2131720702);
      QQToast.a(this.this$0, 1, paramString, 0).show(this.this$0.getTitleBarHeight());
    }
    for (;;)
    {
      AddRequestActivity.a(this.this$0, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "onSendSystemMsgActionError");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ufa
 * JD-Core Version:    0.7.0.1
 */