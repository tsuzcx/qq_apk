import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class abfk
  extends achq
{
  abfk(abfd paramabfd) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionFin|isSuccess : " + paramBoolean + ",logStr : " + paramString1 + ",actionType : " + paramInt1 + ", msgDetail : " + paramString2 + ",resultCode : " + paramInt2 + ", respType : " + paramInt3 + "msgFail : " + paramString3 + "msgInvalidDecided : " + paramString4 + ",remarkRet : " + paramInt4);
    }
    abfd.d(this.this$0);
    this.this$0.notifyDataSetChanged();
    long l1 = anzd.a().hf();
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      structmsg.StructMsg localStructMsg;
      try
      {
        l2 = Long.parseLong(paramString1);
        l1 = l2;
        localStructMsg = anzd.a().a(Long.valueOf(l1));
        if (paramBoolean) {
          break label239;
        }
        if (TextUtils.isEmpty(paramString3)) {
          break label219;
        }
        QQToast.a(abfd.a(this.this$0), 1, paramString3, 0).show(abfd.b(this.this$0));
        anzf.a(localStructMsg, paramInt3, paramString2, paramString4);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      continue;
      label219:
      paramString3 = abfd.a(this.this$0).getResources().getString(2131719483);
      continue;
      label239:
      paramString1 = abfd.a(this.this$0).getResources().getString(2131694020);
      QQToast.a(abfd.a(this.this$0), 2, paramString1, 0).show(abfd.b(this.this$0));
      long l2 = anzd.a().he();
      anzf.a(localStructMsg, paramInt1, paramString2, paramInt2);
      if ((l2 != 0L) && (localStructMsg != null)) {}
      try
      {
        this.this$0.mApp.b().c(acbn.bkJ, 0, l2, localStructMsg.toByteArray());
        if ((paramInt1 != 0) || (localStructMsg == null)) {
          continue;
        }
        paramString3 = new Bundle();
        paramString3.putString("base_uin", String.valueOf(localStructMsg.req_uin.get()));
        paramString2 = localStructMsg.msg.req_uin_nick.get();
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = String.valueOf(localStructMsg.req_uin.get());
        }
        paramString3.putString("base_nick", paramString1);
        paramString3.putInt("verfy_type", localStructMsg.msg.sub_type.get());
        paramString3.putString("verfy_msg", localStructMsg.msg.msg_additional.get());
        if (ytq.a(this.this$0.mApp, String.valueOf(localStructMsg.req_uin.get()), localStructMsg, false))
        {
          paramString4 = new String(localStructMsg.msg.bytes_game_nick.get().toByteArray());
          paramString2 = paramString1;
          if (!TextUtils.isEmpty(paramString4)) {
            paramString2 = KplRoleInfo.WZRYUIinfo.buildNickName(paramString1, paramString4);
          }
          paramString3.putString("base_nick", paramString2);
          paramString3.putBoolean("isFromWzry", true);
        }
        AutoRemarkActivity.a(abfd.a(this.this$0), 0, String.valueOf(localStructMsg.req_uin.get()), l1, paramString3);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionFin Exception!");
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetSystemMsgFin|isSuccess : " + paramBoolean1 + ", bTimeOut : " + paramBoolean2);
    }
    if (abfd.a(this.this$0).isFinishing()) {
      return;
    }
    if (paramBoolean1) {
      abfd.c(this.this$0);
    }
    for (;;)
    {
      abfd.e(this.this$0);
      return;
      if ((paramBoolean2) && (abfd.a(this.this$0)))
      {
        paramList = abfd.a(this.this$0).getResources().getString(2131720697);
        QQToast.a(abfd.a(this.this$0), 1, paramList, 0).show(abfd.b(this.this$0));
      }
    }
  }
  
  protected void aO(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onDeleteAllSysMsg " + paramBoolean + " " + paramInt);
    }
    abfd.d(this.this$0);
    if (paramBoolean)
    {
      if (abfd.a(this.this$0) != null) {
        abfd.a(this.this$0).finish();
      }
      return;
    }
    QQToast.a(abfd.a(this.this$0), 2131701779, 0).show();
  }
  
  protected void bh(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetDelSystemMsgFin|isSuccess : " + paramBoolean1 + ", bTimeOut : " + paramBoolean2);
    }
    abfd.d(this.this$0);
    if (paramBoolean1) {
      abfd.c(this.this$0);
    }
    while ((!paramBoolean2) || (!abfd.a(this.this$0))) {
      return;
    }
    String str = abfd.a(this.this$0).getResources().getString(2131720690);
    QQToast.a(abfd.a(this.this$0), 1, str, 0).show(abfd.b(this.this$0));
  }
  
  protected void clC()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onGetDelSystemMsgError");
    }
    abfd.d(this.this$0);
    String str = abfd.a(this.this$0).getResources().getString(2131720690);
    QQToast.a(abfd.a(this.this$0), 1, str, 0).show(abfd.b(this.this$0));
  }
  
  protected void iv(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSendSystemMsgActionError execute");
    }
    abfd.d(this.this$0);
    paramString = abfd.a(this.this$0).getResources().getString(2131720702);
    QQToast.a(abfd.a(this.this$0), 1, paramString, 0).show(abfd.b(this.this$0));
  }
  
  public void zl(String paramString)
  {
    abfd.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abfk
 * JD-Core Version:    0.7.0.1
 */