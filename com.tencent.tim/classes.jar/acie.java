import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.NearbyFlowerManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.GrayTipsInfo;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class acie
  implements Manager
{
  public static final String boN = acfp.m(2131708696);
  public static final String boO = acfp.m(2131708704);
  public static final String boP = acfp.m(2131708699);
  public static int cxb;
  public static int cxc = 60;
  public QQAppInterface app;
  public String boJ;
  public String boK;
  public String boL;
  public String boM;
  public int cxa;
  public HashMap<String, Long> iW;
  Map<String, Long> jo = new HashMap();
  Map<String, Long> jp = new HashMap();
  public Handler mHandler;
  
  public acie(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mHandler = new Handler(Looper.getMainLooper());
    initConfig();
  }
  
  public static void O(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.postImmediately(new NearbyFlowerManager.1(paramQQAppInterface, paramString), null, true);
  }
  
  public static final acie a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (acie)paramQQAppInterface.getManager(124);
  }
  
  private GrayTipsInfo a(String paramString1, String paramString2, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "shouldShowTip start");
    }
    int j = 0;
    int i = 0;
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject5 = null;
    Object localObject2 = null;
    if (this.app.getCurrentAccountUin().equals(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.iW == null) {
        this.iW = new HashMap();
      }
      long l = anaz.gQ();
      if (!bool) {
        if (((Boolean)ajrb.a(this.app.getCurrentAccountUin(), "sp_file_nearby_flower_tip", 0, "nearby_flower_tip_first_flag", Boolean.valueOf(true))).booleanValue())
        {
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "shouldShowTip first rec");
          }
          localObject1 = this.boL;
          localObject4 = this.boM;
          localObject3 = localObject2;
          if (Friends.isValidUin(paramString1)) {
            localObject3 = String.format("https://imgcache.qq.com/club/client/flower/release/html/gift_mall.html?ADTAG=%s&_bid=2050&sourceType=%d&_handle=1&_wv=2147347&platId=1&qqVersion=%s", new Object[] { "aio.m.xiaohuitiao", Integer.valueOf(1), "3.4.4" });
          }
          ajrb.a(this.app.getCurrentAccountUin(), "sp_file_nearby_flower_tip", 0, "nearby_flower_tip_first_flag", Boolean.valueOf(false));
          anot.a(this.app, "CliOper", "", "", "0X80060B6", "0X80060B6", 0, 0, "", "", "", "");
          localObject2 = localObject4;
          i = 1;
        }
      }
      for (;;)
      {
        localObject4 = null;
        if (i != 0)
        {
          localObject1 = a(bool, (String)localObject1, paramAbsStructMsg);
          paramAbsStructMsg = new GrayTipsInfo();
          paramAbsStructMsg.text = ((String)localObject1);
          localObject4 = paramAbsStructMsg;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject4 = paramAbsStructMsg;
            if (((String)localObject1).contains((CharSequence)localObject2))
            {
              i = ((String)localObject1).indexOf((String)localObject2);
              localObject1 = new GrayTipsSpan(i, ((String)localObject2).length() + i, (String)localObject3);
              localObject2 = new ArrayList();
              ((ArrayList)localObject2).add(localObject1);
              paramAbsStructMsg.spans = ((ArrayList)localObject2);
              localObject4 = paramAbsStructMsg;
            }
          }
        }
        paramAbsStructMsg = this.iW;
        if (bool) {}
        for (;;)
        {
          paramAbsStructMsg.put(paramString2, Long.valueOf(l));
          return localObject4;
          localObject2 = (Long)this.iW.get(paramString1);
          if ((localObject2 != null) && (l - ((Long)localObject2).longValue() <= cxc)) {
            break label591;
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "shouldShowTip rec >60s");
          }
          localObject1 = c(paramAbsStructMsg);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label585;
          }
          anot.a(this.app, "CliOper", "", "", "0X80060B8", "0X80060B8", 0, 0, "", "", "", "");
          localObject2 = null;
          i = 1;
          break;
          Long localLong = (Long)this.iW.get(paramString2);
          if (localLong != null)
          {
            localObject1 = localObject6;
            i = j;
            localObject3 = localObject5;
            localObject2 = localObject4;
            if (l - localLong.longValue() <= cxc) {
              break;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "shouldShowTip send >60s");
          }
          localObject1 = this.boJ;
          anot.a(this.app, "CliOper", "", "", "0X80060B5", "0X80060B5", 0, 0, "", "", "", "");
          i = 1;
          localObject3 = localObject5;
          localObject2 = localObject4;
          break;
          paramString2 = paramString1;
        }
        label585:
        localObject2 = null;
        continue;
        label591:
        localObject2 = null;
      }
    }
  }
  
  private String a(boolean paramBoolean, String paramString, AbsStructMsg paramAbsStructMsg)
  {
    String str = paramString;
    if (paramString.contains("Ta"))
    {
      str = paramString;
      if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
      {
        paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
        str = paramString;
        if (paramAbsStructMsg.getItemCount() > 0)
        {
          anqu localanqu = paramAbsStructMsg.getItemByIndex(0);
          str = paramString;
          if ((localanqu instanceof ansy))
          {
            if (!paramBoolean) {
              break label118;
            }
            paramAbsStructMsg = "rSex";
            paramAbsStructMsg = ((ansy)localanqu).mBundle.getString(paramAbsStructMsg);
            str = paramString;
            if (!TextUtils.isEmpty(paramAbsStructMsg)) {
              if (Integer.valueOf(paramAbsStructMsg).intValue() != 2) {
                break label125;
              }
            }
          }
        }
      }
    }
    label118:
    label125:
    for (paramAbsStructMsg = acfp.m(2131708695);; paramAbsStructMsg = acfp.m(2131708705))
    {
      str = paramString.replace("Ta", paramAbsStructMsg);
      return str;
      paramAbsStructMsg = "sSex";
      break;
    }
  }
  
  private String c(AbsStructMsg paramAbsStructMsg)
  {
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "getFlowerFlorid");
    }
    Object localObject = str;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = (StructMsgForGeneralShare)paramAbsStructMsg;
      localObject = str;
      if (paramAbsStructMsg.getItemCount() > 0)
      {
        paramAbsStructMsg = paramAbsStructMsg.getItemByIndex(0);
        if (!(paramAbsStructMsg instanceof ansy)) {
          break label147;
        }
        paramAbsStructMsg = ((ansy)paramAbsStructMsg).mBundle.getString("cMean");
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramAbsStructMsg)) && (this.boK.contains("XX朵YY")))
      {
        str = this.boK.replace("XX朵YY", paramAbsStructMsg);
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("NearbyFlowerManager", 2, "getFlowerFlorid,cMean:" + paramAbsStructMsg + " wording:" + str);
          localObject = str;
        }
      }
      label147:
      do
      {
        return localObject;
        if (!(paramAbsStructMsg instanceof anud)) {
          break label248;
        }
        paramAbsStructMsg = ((anud)paramAbsStructMsg).rz.iterator();
        do
        {
          if (!paramAbsStructMsg.hasNext()) {
            break;
          }
          localObject = (anqu)paramAbsStructMsg.next();
        } while (!(localObject instanceof StructMsgItemTitle));
        paramAbsStructMsg = ((StructMsgItemTitle)localObject).getText();
        break;
        localObject = str;
      } while (!QLog.isColorLevel());
      QLog.i("NearbyFlowerManager", 2, "getFlowerFlorid,cMean:" + paramAbsStructMsg + " wording:" + null);
      return null;
      label248:
      paramAbsStructMsg = null;
    }
  }
  
  private SharedPreferences getPref()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("nearby_flower_" + this.app.getCurrentAccountUin(), 0);
  }
  
  public static void i(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    anot.a(null, "dc00899", "grp_lbs", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  private void initConfig()
  {
    this.boJ = ((String)ajrb.a(this.app.getAccount(), "sp_file_nearby_flower_tip", 0, "senderGrayTip", boN));
    this.boK = ((String)ajrb.a(this.app.getAccount(), "sp_file_nearby_flower_tip", 0, "receiverGrayTip", "Ta送了你XX朵YY，快和Ta说声谢谢吧。"));
    this.boL = ((String)ajrb.a(this.app.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", boO));
    this.boM = ((String)ajrb.a(this.app.getAccount(), "sp_file_nearby_flower_tip", 0, "exchangeHighLight", boP));
    cxb = ((Integer)ajrb.a(this.app.getAccount(), "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(cxb))).intValue();
    this.cxa = ((Integer)ajrb.a(this.app.getAccount(), "sp_file_nearby_flower_tip", 0, "scoreThreshold", Integer.valueOf(0))).intValue();
  }
  
  public void Er(String paramString)
  {
    long l = anaz.gQ();
    getPref().edit().putLong(getKey(paramString), l);
    this.jp.put(paramString, Long.valueOf(l));
  }
  
  public void Es(String paramString)
  {
    getPref().edit().remove(getKey(paramString));
    this.jp.put(paramString, Long.valueOf(0L));
  }
  
  public MessageRecord a(String paramString1, String paramString2, int paramInt, AbsStructMsg paramAbsStructMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "insertFlowerTipMsg start");
    }
    paramString2 = a(paramString1, paramString2, paramAbsStructMsg);
    if (paramString2 != null)
    {
      paramAbsStructMsg = this.app.getCurrentAccountUin();
      long l = anaz.gQ();
      MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)anbi.d(-2037);
      localMessageForNewGrayTips.init(paramAbsStructMsg, paramString1, paramAbsStructMsg, paramString2.text, l, -2037, paramInt, l);
      localMessageForNewGrayTips.isread = true;
      localMessageForNewGrayTips.spans = paramString2.spans;
      localMessageForNewGrayTips.updateMsgData();
      if (QLog.isColorLevel()) {
        QLog.i("NearbyFlowerManager", 2, "insertFlowerTipMsg has grayTip");
      }
      return localMessageForNewGrayTips;
    }
    return null;
  }
  
  public void eS(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFlowerManager", 2, "handleGetNewConfig:" + paramString2);
    }
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString2);
        if (!localJSONObject.has("senderGrayTip")) {
          break label447;
        }
        paramString2 = localJSONObject.getString("senderGrayTip");
        if (!localJSONObject.has("receiverGrayTip")) {
          break label469;
        }
        str1 = localJSONObject.getString("receiverGrayTip");
        if (!localJSONObject.has("exchangeGrayTip")) {
          break label476;
        }
        str2 = localJSONObject.getString("exchangeGrayTip");
        if (!localJSONObject.has("exchangeHighLight")) {
          break label483;
        }
        str3 = localJSONObject.getString("exchangeHighLight");
        if (!localJSONObject.has("openFlag")) {
          break label453;
        }
        i = localJSONObject.getInt("openFlag");
        if (!localJSONObject.has("groupAnimationScore")) {
          break label460;
        }
        j = localJSONObject.getInt("groupAnimationScore");
        if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.equals(this.boJ)))
        {
          this.boJ = paramString2;
          ajrb.a(paramString1, "sp_file_nearby_flower_tip", 0, "senderGrayTip", this.boJ);
        }
        if ((!TextUtils.isEmpty(str1)) && (!paramString2.equals(this.boK)))
        {
          this.boK = str1;
          ajrb.a(paramString1, "sp_file_nearby_flower_tip", 0, "receiverGrayTip", this.boK);
        }
        if ((!TextUtils.isEmpty(str2)) && (!paramString2.equals(this.boL)))
        {
          this.boL = str2;
          ajrb.a(paramString1, "sp_file_nearby_flower_tip", 0, "exchangeGrayTip", this.boL);
        }
        if ((!TextUtils.isEmpty(str3)) && (!paramString2.equals(this.boM)))
        {
          this.boM = str3;
          ajrb.a(paramString1, "sp_file_nearby_flower_tip", 0, "exchangeHighLight", this.boM);
        }
        if (i != cxb)
        {
          cxb = i;
          ajrb.a(paramString1, "sp_file_nearby_flower_tip", 0, "openFlag", Integer.valueOf(cxb));
        }
        if (j != this.cxa)
        {
          this.cxa = j;
          ajrb.a(paramString1, "sp_file_nearby_flower_tip", 0, "scoreThreshold", Integer.valueOf(this.cxa));
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("NearbyFlowerManager", 2, "handleGetNewConfig parse success");
        return;
      }
      catch (JSONException paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("NearbyFlowerManager", 2, "handleGetNewConfig parse exception:" + paramString1);
      paramString1.printStackTrace();
      return;
      label447:
      paramString2 = "";
      continue;
      label453:
      int i = cxb;
      continue;
      label460:
      int j = this.cxa;
      continue;
      label469:
      String str1 = "";
      continue;
      label476:
      String str2 = "";
      continue;
      label483:
      String str3 = "";
    }
  }
  
  public String getKey(String paramString)
  {
    return paramString + "_key_time_joinhotchat";
  }
  
  public void ja(List<HotChatInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NearbyFlowerManager", 2, "onGetJoinedHotchats:" + paramList.size());
    }
    Object localObject1 = getPref();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    try
    {
      localObject1 = ((SharedPreferences)localObject1).getAll();
      if (localObject1 == null) {
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    catch (Exception localException)
    {
      String str;
      for (;;)
      {
        str = null;
      }
      HashSet localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localHashSet.add(((HotChatInfo)paramList.next()).troopUin);
      }
      paramList = str.entrySet().iterator();
      while (paramList.hasNext())
      {
        str = (String)((Map.Entry)paramList.next()).getKey();
        if (!localHashSet.contains(str))
        {
          localEditor.remove(str);
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerManager", 2, "onGetJoinedHotchats.remove:" + str);
          }
        }
      }
      localEditor.commit();
    }
  }
  
  public void onDestroy()
  {
    this.mHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acie
 * JD-Core Version:    0.7.0.1
 */