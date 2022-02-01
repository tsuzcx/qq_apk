import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.7.1;
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

public class yxx
  extends achq
{
  public yxx(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
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
          break label176;
        }
        if (this.this$0.J != null) {
          this.this$0.J.dismiss();
        }
        paramString1 = this.this$0.P.getResources().getString(2131719483);
        if (TextUtils.isEmpty(paramString3)) {
          break label693;
        }
        QQToast.a(this.this$0.P, 1, paramString3, 0).show(this.this$0.getTitleBarHeight());
        anzf.a(anze.a().a(Long.valueOf(l1)), paramInt3, paramString2, paramString4);
        paramString1 = anze.a().a(Long.valueOf(l1));
        if ((paramString1 != null) && (paramString1.msg_type.get() == 2))
        {
          this.this$0.g.sendEmptyMessage(1012);
          TroopNotifyAndRecommendView.c(this.this$0);
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label176:
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
              QLog.i("TroopNotifyAndRecommendView", 2, "onSendSystemMsgActionFin Exception!");
            }
          }
        }
        this.this$0.g.sendEmptyMessage(1012);
        TroopNotifyAndRecommendView.c(this.this$0);
        if ((!this.this$0.tz.isEmpty()) || (!this.this$0.tx.isEmpty()) || (!this.this$0.ty.isEmpty()) || (TroopNotifyAndRecommendView.b(this.this$0) == null)) {
          break label671;
        }
        TroopNotifyAndRecommendView.b(this.this$0).setVisibility(8);
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
      label671:
      if (TroopNotifyAndRecommendView.b(this.this$0) != null)
      {
        TroopNotifyAndRecommendView.b(this.this$0).setVisibility(0);
        return;
        label693:
        paramString3 = paramString1;
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.bengin");
    }
    TroopNotifyAndRecommendView.b(this.this$0);
    if (((Activity)this.this$0.P).isFinishing()) {}
    while (!paramBoolean1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.success");
    }
    for (;;)
    {
      try
      {
        if ((this.this$0.mDataList != null) && (paramList != null))
        {
          this.this$0.mDataList = paramList;
          int i = anze.a().af(this.this$0.app);
          yxz.L(this.this$0.mDataList, i);
          this.this$0.ty = yxz.dc();
          this.this$0.tz = yxz.dd();
          this.this$0.mDataList = yxz.de();
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotifyAndRecommendView", 2, new Object[] { "mDataList Size =", Integer.valueOf(this.this$0.mDataList.size()), "mExitDataList Size =", Integer.valueOf(this.this$0.ty.size()), "mUndealDataList Size=", Integer.valueOf(this.this$0.tz.size()) });
          }
          if ((this.this$0.mType == 1) && (this.this$0.tz.size() > 0)) {
            this.this$0.mDataList = this.this$0.tz;
          }
        }
        else
        {
          if ((this.this$0.b == null) || (this.this$0.a == null)) {
            break;
          }
          this.this$0.a.runOnUiThread(new TroopNotifyAndRecommendView.7.1(this));
          return;
        }
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        return;
      }
      if ((this.this$0.mType == 2) && (this.this$0.ty.size() > 0)) {
        this.this$0.mDataList = this.this$0.ty;
      }
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSuspiciousSystemMsgFin.bengin");
    }
    if (((Activity)this.this$0.P).isFinishing()) {}
    label407:
    do
    {
      return;
      TroopNotifyAndRecommendView.a(this.this$0);
      if ((!paramBoolean1) && (paramBoolean2) && (this.this$0.bpk))
      {
        String str = this.this$0.P.getResources().getString(2131720697);
        QQToast.a(this.this$0.P, 1, str, 0).show(this.this$0.getTitleBarHeight());
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopNotifyAndRecommendView", 2, "onGetSuspiciousSystemMsgFin.success");
      }
      for (;;)
      {
        try
        {
          if ((this.this$0.tx != null) && (paramList != null) && (paramList.size() > 0))
          {
            this.this$0.tx.clear();
            this.this$0.tx = TroopNotifyAndRecommendView.g(this.this$0.tx, paramList);
          }
          anze.a().O(this.this$0.app, 0);
          if (TroopNotifyAndRecommendView.a(this.this$0) == null) {
            continue;
          }
          TroopNotifyAndRecommendView.a(this.this$0).clearDatas();
          TroopNotifyAndRecommendView.a(this.this$0).gQ(this.this$0.tx);
          TroopNotifyAndRecommendView.a(this.this$0).notifyDataSetChanged();
          this.this$0.app.a().a().FN(true);
          if (TroopNotifyAndRecommendView.a(this.this$0).getVisibility() == 8) {
            anot.a(this.this$0.app, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
          }
          TroopNotifyAndRecommendView.a(this.this$0).setVisibility(0);
        }
        catch (Exception paramList)
        {
          paramList.printStackTrace();
          QLog.d("TroopNotifyAndRecommendView", 1, "onGetSuspiciousSystemMsgFin failed", paramList);
          continue;
        }
        if ((!this.this$0.tz.isEmpty()) || (!this.this$0.tx.isEmpty()) || (!this.this$0.ty.isEmpty()) || (TroopNotifyAndRecommendView.b(this.this$0) == null)) {
          break label407;
        }
        TroopNotifyAndRecommendView.b(this.this$0).setVisibility(8);
        return;
        TroopNotifyAndRecommendView.a(this.this$0).setVisibility(8);
      }
    } while (TroopNotifyAndRecommendView.b(this.this$0) == null);
    TroopNotifyAndRecommendView.b(this.this$0).setVisibility(0);
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
 * Qualified Name:     yxx
 * JD-Core Version:    0.7.0.1
 */