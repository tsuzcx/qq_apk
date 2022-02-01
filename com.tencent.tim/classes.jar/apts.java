import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import mqq.manager.Manager;

public class apts
  implements Manager
{
  public static int dVR = 1080;
  public static int dVS = 1920;
  QQAppInterface mApp;
  
  public apts(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private MessageForTroopReward a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    MessageForTroopReward localMessageForTroopReward = new MessageForTroopReward();
    localMessageForTroopReward.selfuin = this.mApp.getCurrentAccountUin();
    localMessageForTroopReward.frienduin = paramString1;
    localMessageForTroopReward.senderuin = this.mApp.getCurrentAccountUin();
    localMessageForTroopReward.msgUid = anbk.I(paramInt1);
    localMessageForTroopReward.msg = aqiu.pC(null);
    localMessageForTroopReward.msgtype = -2048;
    localMessageForTroopReward.isread = true;
    localMessageForTroopReward.issend = 1;
    localMessageForTroopReward.istroop = 1;
    localMessageForTroopReward.time = anaz.gQ();
    localMessageForTroopReward.rewardCreateTime = ((int)(System.currentTimeMillis() / 1000L));
    localMessageForTroopReward.rewardMoney = paramInt2;
    localMessageForTroopReward.rewardContent = paramString2;
    localMessageForTroopReward.rewardType = paramInt3;
    localMessageForTroopReward.mediaPath = paramString3;
    localMessageForTroopReward.rewardStatus = 10000;
    localMessageForTroopReward.rewardSeq = localMessageForTroopReward.uniseq;
    localMessageForTroopReward.prewrite();
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "buildTroopRewardMgr success");
    }
    return localMessageForTroopReward;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean)
  {
    paramQQAppInterface = "https://qun.qq.com/qunpay/reward/index.html?_wv=1039&_bid=2313&gc=" + paramString;
    paramString = new Intent(paramContext, QQBrowserActivity.class);
    paramString.putExtra("url", paramQQAppInterface);
    if (paramBoolean) {
      paramString.addFlags(268435456);
    }
    paramContext.startActivity(paramString);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "openNewReward:" + paramQQAppInterface);
    }
  }
  
  public MessageForTroopReward a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (this.mApp.a(1) == null) {
      return null;
    }
    Object localObject1 = i(paramString1, 1);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
      } while ((!(localObject2 instanceof MessageForTroopReward)) || (!paramString2.equals(((MessageForTroopReward)localObject2).rewardId)));
    }
    for (localObject1 = (MessageForTroopReward)localObject2;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        paramString1 = this.mApp.b().b(paramString1, 1, new int[] { -2048 }).iterator();
        while (paramString1.hasNext())
        {
          localObject2 = (MessageRecord)paramString1.next();
          if ((localObject2 instanceof MessageForTroopReward))
          {
            localObject2 = (MessageForTroopReward)localObject2;
            ((MessageForTroopReward)localObject2).parse();
            if (paramString2.equals(((MessageForTroopReward)localObject2).rewardId)) {
              return localObject2;
            }
          }
        }
      }
      return localObject1;
    }
  }
  
  public void a(MessageForTroopReward paramMessageForTroopReward)
  {
    if (paramMessageForTroopReward != null)
    {
      paramMessageForTroopReward.prewrite();
      this.mApp.b().c(paramMessageForTroopReward.frienduin, 1, paramMessageForTroopReward.uniseq, paramMessageForTroopReward.msgData);
    }
  }
  
  public void d(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.troop_reward", 2, "insertAIOMsg troop uin empty");
      }
      return;
    }
    paramString1 = a(paramString1, Math.abs(new Random().nextInt()), paramInt1, paramString2, paramString3, paramInt2);
    this.mApp.b().b(paramString1, this.mApp.getCurrentAccountUin());
  }
  
  protected List<MessageRecord> i(String paramString, int paramInt)
  {
    tom localtom = this.mApp.a(0).a();
    Lock localLock = localtom.a(paramString, paramInt);
    localLock.lock();
    try
    {
      paramString = localtom.b().get(u(paramString, paramInt));
      if (paramString != null)
      {
        paramString = (List)((ArrayList)paramString).clone();
        return paramString;
      }
      return paramString;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public void onDestroy() {}
  
  protected String u(String paramString, int paramInt)
  {
    return top.u(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apts
 * JD-Core Version:    0.7.0.1
 */