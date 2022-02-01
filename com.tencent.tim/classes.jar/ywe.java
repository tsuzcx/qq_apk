import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ywe
  extends achq
{
  public ywe(NotificationView paramNotificationView) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    long l1 = anze.a().hf();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      long l2;
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        if (paramBoolean) {
          break label169;
        }
        if (this.this$0.J != null) {
          this.this$0.J.dismiss();
        }
        paramString1 = this.this$0.P.getResources().getString(2131719483);
        if (TextUtils.isEmpty(paramString3)) {
          break label590;
        }
        QQToast.a(this.this$0.P, 1, paramString3, 0).show(this.this$0.getTitleBarHeight());
        anzf.a(anze.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4);
        paramString1 = anze.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg_type.get() == 2)) {
          this.this$0.g.sendEmptyMessage(1012);
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label169:
      if (this.this$0.J != null) {
        this.this$0.J.dismiss();
      }
      paramString3 = this.this$0.P.getResources().getString(2131694032);
      if (paramInt1 == 1)
      {
        paramString1 = anze.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg.group_msg_type.get() == 82)) {
          paramString1 = paramString2;
        }
      }
      for (;;)
      {
        QQToast.a(this.this$0.P, 2, paramString1, 0).show(this.this$0.getTitleBarHeight());
        l2 = anze.a().he();
        anzf.a(anze.a().a(Long.valueOf(l1)), paramInt1, paramString2, paramInt2);
        paramString1 = anze.a().a(Long.valueOf(l1));
        if (paramString1 != null)
        {
          paramInt2 = paramString1.msg.group_inviter_role.get();
          if (((paramInt2 == 2) || (paramInt2 == 3)) && (paramInt1 == 1))
          {
            paramString2 = "" + paramString1.msg.group_code.get();
            paramString3 = paramString1.msg.group_name.get();
            this.this$0.app.a().eQ(paramString2, paramString3);
          }
        }
        if (l2 != 0L) {}
        try
        {
          if ((this.this$0.app != null) && (paramString1 != null)) {
            this.this$0.app.b().c(acbn.bkK, 0, l2, paramString1.toByteArray());
          }
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i("NotificationView", 2, "onSendSystemMsgActionFin Exception!");
            }
          }
        }
        this.this$0.g.sendEmptyMessage(1012);
        return;
        paramString1 = this.this$0.P.getResources().getString(2131694020);
        continue;
        if (paramInt1 == 2)
        {
          paramString1 = this.this$0.P.getResources().getString(2131694030);
        }
        else
        {
          paramString1 = paramString3;
          if (paramInt1 == 0)
          {
            paramString4 = anze.a().a(Long.valueOf(l1));
            paramString1 = paramString3;
            if (paramString4 != null)
            {
              paramString1 = paramString3;
              if (paramString4.msg.group_msg_type.get() == 82) {
                paramString1 = this.this$0.P.getResources().getString(2131694030);
              }
            }
          }
        }
      }
      label590:
      paramString3 = paramString1;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "onGetSystemMsgFin.bengin");
    }
    NotificationView.b(this.this$0);
    if (((Activity)this.this$0.P).isFinishing()) {}
    label253:
    do
    {
      for (;;)
      {
        return;
        if (!paramBoolean1) {
          break label253;
        }
        if (QLog.isColorLevel()) {
          QLog.i("NotificationView", 2, "onGetSystemMsgFin.success");
        }
        try
        {
          if ((this.this$0.mDataList != null) && (paramList != null)) {
            this.this$0.mDataList = TroopNotifyAndRecommendView.g(this.this$0.mDataList, paramList);
          }
          if (this.this$0.b != null)
          {
            this.this$0.b.setData(this.this$0.mDataList);
            this.this$0.b.unreadMsgNum = anze.a().af(this.this$0.app);
            this.this$0.b.notifyDataSetChanged();
            if (this.this$0.isChecked)
            {
              this.this$0.app.a().a().cOd();
              this.this$0.app.a().G(acbn.bkT, 9000, 0 - anze.a().af(this.this$0.app));
              anze.a().N(this.this$0.app, 0);
              NotificationView.a(this.this$0, false);
              this.this$0.clB();
              return;
            }
          }
        }
        catch (Exception paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
      NotificationView.a(this.this$0, true);
      return;
    } while ((!paramBoolean2) || (!this.this$0.bpk));
    paramList = this.this$0.P.getResources().getString(2131720697);
    QQToast.a(this.this$0.P, 1, paramList, 0).show(this.this$0.getTitleBarHeight());
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    NotificationView.a(this.this$0);
  }
  
  protected void iv(String paramString)
  {
    if ((this.this$0.J != null) && (this.this$0.J.isShowing()))
    {
      this.this$0.J.dismiss();
      paramString = this.this$0.P.getResources().getString(2131720702);
      QQToast.a(this.this$0.P, 1, paramString, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywe
 * JD-Core Version:    0.7.0.1
 */