import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONObject;

public class ajdf
  implements Manager
{
  private static long DEFAULT_INTERVAL = 86400L;
  public static String bQM = acfp.m(2131704215);
  public static String bQN = acfp.m(2131704214);
  public static int dhY;
  public static int dhZ = 1;
  public static int dia = 2;
  public static int dib = 3;
  public static int dic = 4;
  public static int did = 100;
  public static int die = 101;
  QQAppInterface app;
  
  public ajdf(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForMarketFace paramMessageForMarketFace)
  {
    MarkFaceMessage localMarkFaceMessage = paramMessageForMarketFace.mMarkFaceMessage;
    int i;
    if ((localMarkFaceMessage != null) && (localMarkFaceMessage.copywritingType != dhY))
    {
      i = ((ajdf)paramQQAppInterface.getManager(200)).a(paramMessageForMarketFace.time, String.valueOf(localMarkFaceMessage.dwTabID), localMarkFaceMessage.copywritingContent, localMarkFaceMessage.copywritingType);
      if (i != 0) {
        break label70;
      }
      localMarkFaceMessage.shouldDisplay = true;
    }
    for (;;)
    {
      try
      {
        paramMessageForMarketFace.msgData = aczw.b(localMarkFaceMessage);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        label70:
        QLog.e("MessageForMarketFace", 1, "decodeC2CUinPairPackage: ", paramQQAppInterface);
      }
      if ((i == 1) && (localMarkFaceMessage.hasIpProduct))
      {
        localMarkFaceMessage.shouldDisplay = true;
        localMarkFaceMessage.showIpProduct = true;
        localMarkFaceMessage.from = bQM;
        localMarkFaceMessage.copywritingContent = bQN;
      }
      else
      {
        localMarkFaceMessage.shouldDisplay = false;
      }
    }
  }
  
  public int a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("commercial_sp" + this.app.getAccount(), 0);
    long l2 = localSharedPreferences.getLong("disPlayInteval", -1L);
    l1 = l2;
    if (l2 == -1L) {}
    for (;;)
    {
      try
      {
        localObject = VasQuickUpdateManager.getJSONFromLocal(this.app, "vip_personal_card.json", false, null);
        if (localObject == null) {
          continue;
        }
        if (!((JSONObject)localObject).has("ipStackConfigDic")) {
          continue;
        }
        localObject = ((JSONObject)localObject).getJSONObject("ipStackConfigDic");
        if (!((JSONObject)localObject).has("ipStackTimeInterval")) {
          continue;
        }
        l1 = ((JSONObject)localObject).getInt("ipStackTimeInterval");
        if (QLog.isColorLevel()) {
          QLog.d("CommercialDrainageManager", 2, "getJson interval = " + l1);
        }
        l2 = l1;
        if (l1 <= 0L) {
          l2 = DEFAULT_INTERVAL;
        }
        if (Build.VERSION.SDK_INT <= 8) {
          continue;
        }
        localSharedPreferences.edit().putLong("disPlayInteval", l2).apply();
        l1 = l2;
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        l1 = DEFAULT_INTERVAL;
        QLog.e("CommercialDrainageManager", 1, "getShowCount error = " + localException);
        continue;
        QLog.e("CommercialDrainageManager", 1, "getShowCount json not exist");
        l1 = DEFAULT_INTERVAL;
        continue;
        boolean bool = false;
        continue;
        localException.commit();
        continue;
      }
      if (localSharedPreferences.getLong(paramString1 + "_lastDisPlayTime", 9223372036854775807L) + l1 <= paramLong) {
        continue;
      }
      bool = true;
      i = localSharedPreferences.getInt(paramString1 + "_count", 0);
      localObject = localSharedPreferences.edit();
      if (!bool)
      {
        i = 0;
        ((SharedPreferences.Editor)localObject).putLong(paramString1 + "_lastDisPlayTime", paramLong);
      }
      ((SharedPreferences.Editor)localObject).putInt(paramString1 + "_count", i + 1);
      if (Build.VERSION.SDK_INT <= 8) {
        continue;
      }
      ((SharedPreferences.Editor)localObject).apply();
      if (QLog.isColorLevel()) {
        QLog.d("CommercialDrainageManager", 2, "getShowCount, haveShown = " + bool + " count = " + i + " epId = " + paramString1 + " timestamp = " + paramLong + "interval = " + l1 + " name = " + paramString2 + " type = " + paramInt);
      }
      return i;
      localObject = null;
      continue;
      l1 = -1L;
      continue;
      localSharedPreferences.edit().putLong("disPlayInteval", l2).commit();
      l1 = l2;
    }
  }
  
  public boolean a(VipIPSiteInfo paramVipIPSiteInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVipIPSiteInfo != null)
    {
      paramVipIPSiteInfo = paramVipIPSiteInfo.strType;
      if ((!"comic".equals(paramVipIPSiteInfo)) && (!"book".equals(paramVipIPSiteInfo)) && (!"video".equals(paramVipIPSiteInfo)) && (!"goods".equals(paramVipIPSiteInfo)))
      {
        bool1 = bool2;
        if (!"game".equals(paramVipIPSiteInfo)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage.endTime != paramEmoticonPackage.beginTime) && ((paramEmoticonPackage.beginTime >= System.currentTimeMillis()) || (System.currentTimeMillis() >= paramEmoticonPackage.endTime));
  }
  
  public boolean c(EmoticonPackage paramEmoticonPackage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEmoticonPackage != null) {
      if ((TextUtils.isEmpty(paramEmoticonPackage.ipUrl)) && (TextUtils.isEmpty(paramEmoticonPackage.ipName)) && (TextUtils.isEmpty(paramEmoticonPackage.ipDetail)) && (TextUtils.isEmpty(paramEmoticonPackage.ipOpName)))
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramEmoticonPackage.ipJumpUrl)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean e(Emoticon paramEmoticon)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramEmoticon != null) {
      if (TextUtils.isEmpty(paramEmoticon.ipsiteUrl))
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramEmoticon.ipsiteName)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void kf(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CommercialDrainageManager", 2, "updateDisPlayInteval interval = " + paramLong);
    }
    long l = paramLong;
    if (paramLong <= 0L) {
      l = DEFAULT_INTERVAL;
    }
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("commercial_sp" + this.app.getAccount(), 0);
    if (Build.VERSION.SDK_INT > 8)
    {
      localSharedPreferences.edit().putLong("disPlayInteval", l).apply();
      return;
    }
    localSharedPreferences.edit().putLong("disPlayInteval", l).commit();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajdf
 * JD-Core Version:    0.7.0.1
 */