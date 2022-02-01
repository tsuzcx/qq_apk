import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.31.1;
import com.tencent.mobileqq.activity.Conversation.31.2;
import com.tencent.mobileqq.activity.Conversation.31.3;
import com.tencent.mobileqq.app.MessageHandler.d;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class usm
  extends achq
{
  public usm(Conversation paramConversation) {}
  
  protected void AB(int paramInt)
  {
    this.this$0.runOnUiThread(new Conversation.31.3(this, paramInt));
  }
  
  public void U(boolean paramBoolean, String paramString)
  {
    this.this$0.n(8, paramString, -2147483648);
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    paramString1 = aajt.makeKey(paramString1, -2147483648);
    this.this$0.e(2, 9, paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong)
  {
    paramString = aajt.makeKey(paramString, -2147483648);
    this.this$0.e(2, 9, paramString);
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, MessageHandler.d paramd)
  {
    a(paramBoolean, paramString, paramLong);
  }
  
  public void a(boolean paramBoolean, String paramString, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() isSuccess=" + paramBoolean + " subAccount=" + paramString);
      if (paramanxs != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() mainAccount=" + paramanxs.aLa + " subAccount=" + paramanxs.aQf + " data.errorType=" + paramanxs.errorType + " errorMsg=" + paramanxs.errorMsg + " isNeedStartGetMsg=" + paramanxs.cKA);
      }
    }
    if ((!paramBoolean) || (paramanxs == null)) {
      return;
    }
    if (paramanxs.errorType == 0)
    {
      anxk.G(this.this$0.app, paramString, 1);
      paramanxs = (anxk)this.this$0.app.getManager(62);
      if (paramanxs != null) {
        paramanxs.v(paramString, 1, true);
      }
    }
    for (;;)
    {
      this.this$0.fI(0L);
      return;
      if (paramanxs.errorType == 1)
      {
        anxk.aL(this.this$0.app, paramString);
        Conversation.j(this.this$0);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, anxt paramanxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramanxt != null) {
        QLog.d("SUB_ACCOUNT", 2, "onSubAccountThirdQQUnreadMsgNum.data=" + paramanxt);
      }
    }
    if ((this.this$0.app == null) || (!this.this$0.app.isRunning())) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramanxt == null) || (paramanxt.dNj == 0));
      i = anxk.ab(this.this$0.app);
    } while ((paramanxt.dNj <= i) || (anxk.a(this.this$0.app, this.this$0.app.a()) > 0));
    anxk.o(this.this$0.app, paramanxt.dNj);
    if (this.this$0.app.a().a().b(acbn.bku, 7000) == null) {
      anxk.G(this.this$0.app, acbn.bku, 7);
    }
    for (;;)
    {
      this.this$0.fI(0L);
      return;
      anxk.G(this.this$0.app, acbn.bku, 6);
    }
  }
  
  public void b(boolean paramBoolean, String paramString, anxs paramanxs)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramanxs != null) {
        QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.data.errorType=" + paramanxs.errorType + " errorMsg=" + paramanxs.errorMsg + " mainAccount=" + paramanxs.aLa + "  subAccount=" + paramanxs.aQf + " isNeedStartGetMsg=" + paramanxs.cKA);
      }
    }
    if (paramanxs != null) {
      switch (paramanxs.errorType)
      {
      default: 
        if ((paramanxs.cKB) && (!paramanxs.cKC) && (paramanxs.aQf != null) && (paramanxs.aQf.length() > 4))
        {
          anxk.G(this.this$0.app, paramString, 6);
          paramanxs.cKC = true;
        }
        break;
      }
    }
    for (;;)
    {
      this.this$0.fI(0L);
      return;
      anxk.aL(this.this$0.app, paramString);
      continue;
      anxk.J(this.this$0.app, 0);
    }
  }
  
  public void b(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.troop.revoked_troop_msg", 2, "onMsgRevokeNotice, isSuccess:" + paramBoolean1);
    }
    if (!paramBoolean1) {
      return;
    }
    MessageRecord localMessageRecord;
    apnu localapnu;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localMessageRecord = (MessageRecord)paramList.get(0);
      localapnu = (apnu)this.this$0.app.getManager(363);
      switch (localMessageRecord.istroop)
      {
      }
    }
    for (;;)
    {
      super.b(paramBoolean1, paramList, paramBoolean2);
      return;
      if (localapnu.eQ(localMessageRecord.frienduin) != -1)
      {
        ((apdd)this.this$0.app.b().a(localMessageRecord.istroop)).b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
        this.this$0.n(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        continue;
        if (localapnu.eQ(localMessageRecord.frienduin + "&" + 3000) != -1)
        {
          ((acqr)this.this$0.app.b().a(localMessageRecord.istroop)).b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.shmsgseq);
          this.this$0.n(8, localMessageRecord.frienduin, localMessageRecord.istroop);
        }
      }
    }
  }
  
  protected void bML()
  {
    this.this$0.fI(0L);
  }
  
  public void bMM()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, onBoxMsgUnreadNumRefresh");
    }
    this.this$0.fI(0L);
  }
  
  protected void onUpdateRecentList()
  {
    aizp.a().di(this.this$0.app);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.this$0.fI(0L);
  }
  
  protected void wS(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetOfflineMsgFinished|isSuc = " + paramBoolean);
    }
    if (this.this$0.FM > 0L) {
      aqmq.br("Conversation_PullToRefresh_msgCB", SystemClock.uptimeMillis() - this.this$0.FM);
    }
    if (this.this$0.uC != 1000L) {
      this.this$0.uC = 1000L;
    }
    this.this$0.runOnUiThread(new Conversation.31.1(this, paramBoolean));
    Object localObject = (PublicAccountHandler)this.this$0.app.getBusinessHandler(11);
    if (localObject != null)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
      long l = localSharedPreferences.getLong("fresh_weather_time", 0L);
      l = System.currentTimeMillis() - l;
      if ((l > 86400000L) || (l < 0L))
      {
        ((PublicAccountHandler)localObject).J(-1, 0, 0, 0);
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putLong("fresh_weather_time", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  protected void wT(boolean paramBoolean)
  {
    this.this$0.runOnUiThread(new Conversation.31.2(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usm
 * JD-Core Version:    0.7.0.1
 */