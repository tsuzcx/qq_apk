import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aafi
  implements apqk.c
{
  private boolean Yp;
  public SpecifyGiftView b;
  public MessageForQQWalletMsg c;
  private Runnable fa;
  public WindowManager mWindowManager;
  
  public aafi(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    this.c = paramMessageForQQWalletMsg;
  }
  
  public static boolean R(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      try
      {
        i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("specify_redpack_is_reply"));
        if (i == 1) {
          return true;
        }
      }
      catch (Throwable paramMessageRecord)
      {
        for (;;)
        {
          int i = 0;
        }
      }
      return false;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramQQAppInterface == null) || (paramMessageForQQWalletMsg == null)) {
      return false;
    }
    boolean bool = a(paramMessageForQQWalletMsg, paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "tryScheduleSpecifyAnim isValidAnim=" + bool);
    }
    if (bool)
    {
      ((apqk)paramQQAppInterface.getManager(223)).a(new aafi(paramMessageForQQWalletMsg), false);
      return true;
    }
    return false;
  }
  
  public static boolean a(Object paramObject, QQAppInterface paramQQAppInterface)
  {
    if (!(paramObject instanceof MessageForQQWalletMsg)) {
      return false;
    }
    paramObject = (MessageForQQWalletMsg)paramObject;
    int i = paramObject.messageType;
    if ((i == 7) || (i == 8) || (i == 11) || (i == 12))
    {
      if (TextUtils.isEmpty(paramObject.mQQWalletRedPacketMsg.body.feedId)) {
        return false;
      }
      if (paramObject.isRedPackExpired()) {
        return false;
      }
      if ((!aado.a().Wh()) && (!paramQQAppInterface.getCurrentUin().equals(paramObject.senderuin)))
      {
        if (paramObject.mQQWalletRedPacketMsg.specifyUinList == null) {
          break label176;
        }
        paramObject = paramObject.mQQWalletRedPacketMsg.specifyUinList.iterator();
        Long localLong;
        do
        {
          if (!paramObject.hasNext()) {
            break;
          }
          localLong = (Long)paramObject.next();
        } while (!paramQQAppInterface.getCurrentUin().equals(localLong + ""));
      }
    }
    label176:
    for (i = 1;; i = 0)
    {
      return i != 0;
      return false;
    }
  }
  
  public static void c(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord.saveExtInfoToExtStr("specify_redpack_is_reply", "1");
      aagd.e(paramQQAppInterface, paramMessageRecord);
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, anyo.a parama)
  {
    aagd.e(aagd.getQQAppInterface(), "212", "only.animation.show");
    String str = aafg.qs() + this.c.mQQWalletRedPacketMsg.body.feedId + ".zip";
    WeakReference localWeakReference = new WeakReference(this.c);
    paramBaseChatPie = new WeakReference(paramBaseChatPie);
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim start");
    }
    parama = new aafj(this, parama);
    this.fa = new SpecifyRedPacketAnimMsg.2(this, parama);
    ThreadManager.getUIHandler().postDelayed(this.fa, 10000L);
    PreloadManager.a().c(str, new aafk(this, localWeakReference, parama, paramBaseChatPie));
  }
  
  public String getFriendUin()
  {
    return this.c.frienduin;
  }
  
  public int getLimitType()
  {
    return 1;
  }
  
  public long getSenderUin()
  {
    try
    {
      long l = Long.parseLong(this.c.senderuin);
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
  
  public long getShmsgseq()
  {
    return this.c.shmsgseq;
  }
  
  public boolean isReaded()
  {
    return false;
  }
  
  public void onDestroy()
  {
    if (this.b != null) {}
    try
    {
      this.b.removeAllViews();
      this.mWindowManager.removeViewImmediate(this.b);
      this.b = null;
      this.mWindowManager = null;
      this.Yp = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.send_gift", 2, "closeRedPackGiftAnimation exception ", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafi
 * JD-Core Version:    0.7.0.1
 */