import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNearbyRecommenderTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class akkw
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "-----addGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + aqft.pk(paramString3));
    }
    long l = anaz.gQ();
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)anbi.d(-5007);
    localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramString3, l, -5007, paramInt, l);
    localMessageForGrayTips.isread = paramBoolean2;
    if ((!paramBoolean1) || (!achp.a(paramQQAppInterface, localMessageForGrayTips, false))) {
      paramQQAppInterface.b().b(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public static String[] a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
    int i = localSharedPreferences.getInt(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_nearbyrecommender_reasontype", 0);
    paramQQAppInterface = localSharedPreferences.getString(paramQQAppInterface.getCurrentAccountUin() + "_" + "key_nearbyrecommender_uins", "");
    return new String[] { Integer.toString(i), paramQQAppInterface };
  }
  
  public static boolean bi(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.b().k(acbn.bkE, 1001);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      MessageRecord localMessageRecord;
      do
      {
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        localMessageRecord = (MessageRecord)paramQQAppInterface.next();
      } while ((localMessageRecord.msgtype != -4011) || (((MessageForNearbyRecommenderTips)localMessageRecord).readFlag));
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyRecommenderUtils", 2, "checkUnreadMsgForNearbyRecommender,resut=" + bool);
      }
      return bool;
    }
  }
  
  public static void c(Context paramContext, String paramString, List<Object> paramList)
  {
    if (paramList == null) {
      return;
    }
    aqhq.x(paramString + "v5.8.nbr", new Object[] { paramList });
  }
  
  public static void dz(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "checkExpireTime");
    }
    if (bi(paramQQAppInterface))
    {
      int i = paramQQAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).getInt("key_expiretime", 172800);
      long l3 = System.currentTimeMillis();
      long l2 = 0L;
      Object localObject = paramQQAppInterface.getApplication().getFileStreamPath(paramQQAppInterface.getCurrentAccountUin() + "v5.8.nbr");
      long l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (((File)localObject).exists()) {
          l1 = ((File)localObject).lastModified();
        }
      }
      if (i <= Math.abs(l3 - l1) / 1000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyRecommenderUtils", 2, "checkExpireTime-->expire true");
        }
        paramQQAppInterface = paramQQAppInterface.b();
        localObject = paramQQAppInterface.k(acbn.bkE, 1001).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (localMessageRecord.msgtype == -4011) {
            paramQQAppInterface.b(localMessageRecord, true);
          }
        }
      }
    }
  }
  
  public static void e(AppInterface paramAppInterface, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    int i;
    int j;
    int k;
    long l1;
    long l2;
    do
    {
      return;
      SharedPreferences.Editor localEditor = paramAppInterface.getApplication().getSharedPreferences("sp_nearbyrecommender", 0).edit();
      i = paramBundle.getInt("key_login_pull_interval", -1);
      if (i != -1) {
        localEditor.putInt(paramAppInterface.getCurrentAccountUin() + "_" + "key_login_pull_interval", i);
      }
      j = paramBundle.getInt("key_msgbox_pull_interval", -1);
      if (j != -1) {
        localEditor.putInt(paramAppInterface.getCurrentAccountUin() + "_" + "key_msgbox_pull_interval", j);
      }
      k = paramBundle.getInt("key_expiretime", -1);
      if (k != -1) {
        localEditor.putInt(paramAppInterface.getCurrentAccountUin() + "_" + "key_expiretime", k);
      }
      l1 = paramBundle.getLong("key_login_pull_time", 0L);
      if (l1 != 0L) {
        localEditor.putLong(paramAppInterface.getCurrentAccountUin() + "_" + "key_login_pull_time", l1);
      }
      l2 = paramBundle.getLong("key_msgbox_pull_time", 0L);
      if (l2 != 0L) {
        localEditor.putLong(paramAppInterface.getCurrentAccountUin() + "_" + "key_msgbox_pull_time", l2);
      }
      String str = paramBundle.getString("key_nearbyrecommender_title");
      if (!TextUtils.isEmpty(str)) {
        localEditor.putString("key_nearbyrecommender_title", str);
      }
      int m = paramBundle.getInt("key_nearbyrecommender_reasontype", -1);
      if (m != -1) {
        localEditor.putInt(paramAppInterface.getCurrentAccountUin() + "_" + "key_nearbyrecommender_reasontype", m);
      }
      paramBundle = paramBundle.getString("key_nearbyrecommender_uins");
      if (!"".equals(paramBundle)) {
        localEditor.putString(paramAppInterface.getCurrentAccountUin() + "_" + "key_nearbyrecommender_uins", paramBundle);
      }
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.d("NearbyRecommenderUtils", 2, "updateConfigs--->login_pull_interval=" + i + ",msgbox_pull_interval=" + j + ",expiretime=" + k + ",login_pull_time=" + l1 + ",msgbox_pull_time=" + l2);
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyRecommenderUtils", 2, "addNearbyRecommenderMsg");
    }
    MessageForNearbyRecommenderTips localMessageForNearbyRecommenderTips = (MessageForNearbyRecommenderTips)anbi.d(-4011);
    long l = anaz.gQ();
    localMessageForNearbyRecommenderTips.init(paramQQAppInterface.getCurrentAccountUin(), acbn.blp, acbn.blp, "", l, -4011, 1001, l);
    localMessageForNearbyRecommenderTips.isread = true;
    top.a(localMessageForNearbyRecommenderTips, false);
    localMessageForNearbyRecommenderTips.readFlag = false;
    localMessageForNearbyRecommenderTips.strBrief = paramString;
    localMessageForNearbyRecommenderTips.uRecommendTime = paramLong;
    localMessageForNearbyRecommenderTips.serial();
    paramQQAppInterface.b().b(localMessageForNearbyRecommenderTips, localMessageForNearbyRecommenderTips.selfuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akkw
 * JD-Core Version:    0.7.0.1
 */