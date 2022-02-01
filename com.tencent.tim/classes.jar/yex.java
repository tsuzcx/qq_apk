import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.30.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yex
  extends xwn.a
{
  public yex(TroopChatPie paramTroopChatPie)
  {
    super(paramTroopChatPie);
  }
  
  protected void U(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.this$0.sessionInfo.aTl)) || (paramInt1 != this.this$0.sessionInfo.cZ)) {}
    while (paramInt1 != 1) {
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 1: 
    case 2: 
      paramString = this.this$0.bX.obtainMessage(5, 1, 0, this.this$0.mActivity.getString(2131690281));
      this.this$0.bX.sendMessage(paramString);
    }
    for (;;)
    {
      this.this$0.finish();
      return;
      paramString = this.this$0.bX.obtainMessage(5, 1, 0, this.this$0.mActivity.getString(2131690275));
      this.this$0.bX.sendMessage(paramString);
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.this$0.sessionInfo.aTl)) || (paramInt1 != this.this$0.sessionInfo.cZ))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError exception uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
      }
      paramString1 = this.this$0.app.b().a(paramString1, paramInt1, paramLong2);
      if ((paramString1 != null) && (paramString1.msgtype == -2058) && ((paramString1.extraflag == 32768) || (paramString1.sendFailCode == 41)))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.this$0.TAG, 2, "onUpdateSendMsgError, sticker msg is failed!, now remove!");
        }
        this.this$0.app.b().b(paramString1, false);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "onUpdateSendMsgError uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2);
    }
    if ((paramInt1 == 1) || (paramInt1 == 3000) || (paramInt1 == 0))
    {
      paramSendMessageHandler = this.this$0.app.b().a(paramString1, paramInt1, paramLong2);
      if ((paramSendMessageHandler == null) || (!(paramSendMessageHandler instanceof MessageForStructing))) {
        break label398;
      }
      if ("viewMultiMsg".equals(((MessageForStructing)paramSendMessageHandler).structingMsg.mMsgAction)) {
        ajlc.a().a(this.this$0.app, paramString1, paramInt1, paramLong2, false);
      }
    }
    label388:
    label398:
    while ((paramSendMessageHandler == null) || (paramSendMessageHandler.msgtype != -2058) || ((paramSendMessageHandler.extraflag != 32768) && (paramSendMessageHandler.sendFailCode != 41)))
    {
      if (paramInt1 == 1) {}
      switch (paramInt2)
      {
      default: 
        this.this$0.refresh(196608);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "onUpdateSendMsgError, sticker msg is failed!");
    }
    this.this$0.app.b().b(paramSendMessageHandler, false);
    paramString1 = top.u(paramString1, paramInt1);
    boolean bool;
    if (EmojiStickerManager.a().fk.containsKey(paramString1))
    {
      paramLong1 = ((Long)EmojiStickerManager.a().fk.get(paramString1)).longValue();
      if (System.currentTimeMillis() - paramLong1 <= 300000L) {
        break label896;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.TAG, 2, "send sticker msg fail, is need send Toast " + bool);
      }
      if (!bool) {
        break;
      }
      EmojiStickerManager.a().fk.put(paramString1, Long.valueOf(System.currentTimeMillis()));
      ThreadManager.getUIHandler().post(new TroopChatPie.30.1(this, paramSendMessageHandler));
      break;
      bool = true;
      continue;
      paramString1 = this.this$0.bX.obtainMessage(5, 1, 0, this.this$0.mActivity.getString(2131690281));
      this.this$0.bX.sendMessage(paramString1);
      break label388;
      paramString1 = this.this$0.bX.obtainMessage(5, 1, 0, this.this$0.mActivity.getString(2131690275));
      this.this$0.bX.sendMessage(paramString1);
      break label388;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.this$0.mActivity.getResources().getString(2131698289);
      }
      paramString1 = this.this$0.bX.obtainMessage(5, 1, 0, paramString1);
      this.this$0.bX.sendMessage(paramString1);
      break label388;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = this.this$0.mActivity.getResources().getString(2131698281);
      }
      paramString1 = this.this$0.bX.obtainMessage(5, 1, 0, paramString1);
      this.this$0.bX.sendMessage(paramString1);
      break label388;
      paramString1 = (TroopManager)this.this$0.app.getManager(52);
      if ((paramString1 != null) && (paramString1.kB(this.this$0.sessionInfo.troopUin)))
      {
        paramString1.FA(this.this$0.sessionInfo.troopUin);
        break label388;
      }
      if (TextUtils.isEmpty(paramString2)) {
        break label388;
      }
      paramString1 = this.this$0.bX.obtainMessage(5, 1, 0, paramString2);
      this.this$0.bX.sendMessage(paramString1);
      break label388;
      label896:
      bool = false;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.TAG, 2, "onGetSystemMsgFin.success");
      }
      List localList = this.this$0.app.b().k(acbn.bkK, 0);
      Object localObject = null;
      paramList = localObject;
      if (localList != null)
      {
        paramList = localObject;
        if (localList.size() - 1 >= 0) {
          paramList = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if ((paramList != null) && ((paramList instanceof MessageForSystemMsg))) {
        break label101;
      }
    }
    label101:
    long l;
    do
    {
      int i;
      do
      {
        do
        {
          return;
          paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        } while ((paramList.msg_type.get() != 2) || (paramList.msg.get() == null));
        i = paramList.msg.group_msg_type.get();
      } while ((i != 3) && (i != 15));
      l = paramList.msg.group_code.get();
    } while ((this.this$0.sessionInfo.aTl == null) || (!this.this$0.sessionInfo.aTl.equalsIgnoreCase("" + l)));
    this.this$0.chy();
  }
  
  public void bI(List<MessageRecord> paramList)
  {
    super.bI(paramList);
    if (paramList.isEmpty()) {}
    for (paramList = null;; paramList = (MessageRecord)paramList.get(0))
    {
      if ((paramList != null) && (TroopChatPie.c(this.this$0).vm() == 35)) {
        this.this$0.aG(true, true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yex
 * JD-Core Version:    0.7.0.1
 */