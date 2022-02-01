import VIP.AIOSendRes;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class aquv
{
  private static aquv b;
  public static String cxA = "mvip.p.a.aio_qunkt";
  public static String cxB = "mvip.p.a.aio_qunzs";
  public static String cxC = "mvip.p.a.aio_tlzkt";
  public static String cxD = "mvip.p.a.aio_tlzzs";
  static String cxE = acfp.m(2131702307);
  static String cxF = acfp.m(2131702305);
  static String cxG = acfp.m(2131702306);
  static String cxH = acfp.m(2131702304);
  public static String cxy = "mvip.pt.android.aiocuifei_recikai";
  public static String cxz = "mvip.pt.android.aiocuifei_recizeng";
  public List<String> Ji;
  public MessageRecord N;
  public long atQ = 86400L;
  public long atR = 86400L;
  public long atS = 86400L;
  public long atT = 2000L;
  private boolean cWj;
  public String cxI = cxE;
  public String cxJ = cxF;
  public String cxK = cxG;
  public String cxL = cxH;
  public String cxM = cxE;
  public String cxN = cxG;
  public String cxO = cxF;
  public String cxP = cxH;
  public String cxQ;
  public String cxR;
  public String cxS;
  public String cxT;
  private int ecY = 1;
  public int ecZ = 1;
  public int eda = 1;
  public int edb = 1;
  private String[] ev;
  private String[] id;
  public String[] ie;
  public String mKeyword;
  public SessionInfo mSessionInfo;
  public String openUrl;
  public Map<String, Boolean> ou = new HashMap();
  
  public static aquv a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new aquv();
      }
      return b;
    }
    finally {}
  }
  
  private String[] a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean) {
      if ((this.ev != null) && (this.ev.length >= 1)) {}
    }
    for (i = 1;; i = 1) {
      do
      {
        if (i != 0) {
          cW(paramContext, paramString);
        }
        if (!paramBoolean) {
          break;
        }
        return this.ev;
      } while ((this.id != null) && (this.id.length >= 1));
    }
    return this.id;
  }
  
  private static boolean isValidUin(String paramString)
  {
    return (paramString != null) && (paramString.length() > 2);
  }
  
  public Pair<String, String> a(boolean paramBoolean, int paramInt)
  {
    String str2 = "";
    String str1 = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new Pair(str2, str1);
      if (paramBoolean) {}
      for (str2 = this.cxI;; str2 = this.cxJ)
      {
        if (!paramBoolean) {
          break label86;
        }
        str1 = this.cxK;
        break;
      }
      label86:
      str1 = this.cxL;
      continue;
      if (paramBoolean) {}
      for (str2 = this.cxM;; str2 = this.cxO)
      {
        if (!paramBoolean) {
          break label125;
        }
        str1 = this.cxN;
        break;
      }
      label125:
      str1 = this.cxP;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong)
  {
    paramQQAppInterface.getApplication().getSharedPreferences("AioVipKeywordGrayTips_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit().putLong("lastShowGrayTipsTime_" + paramInt + "_" + paramString, paramLong).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, String paramString, Context paramContext, boolean paramBoolean)
  {
    QLog.e("AioVipKeywordHelper", 1, "detectKeyword : params error");
  }
  
  public void ak(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AioVipKeywordHelper", 2, "updateKeywordJson");
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    iv(paramString1, paramString2);
    aqhq.writeFile(paramContext.getFilesDir() + File.separator + "vipKerwordJson", paramString1);
  }
  
  public void b(QQAppInterface paramQQAppInterface, AIOSendRes paramAIOSendRes)
  {
    if (paramAIOSendRes != null)
    {
      this.cxR = paramAIOSendRes.sGrayStipMsg;
      if (paramAIOSendRes.mHighLightMap != null)
      {
        Iterator localIterator = paramAIOSendRes.mHighLightMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          this.cxS = ((String)localIterator.next());
          this.cxT = ((String)paramAIOSendRes.mHighLightMap.get(this.cxS));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 4, "fetched tips from server: tips=" + this.cxR + ", highlight=" + this.cxS + ", openUrl=" + this.cxT);
      }
      if ((this.mKeyword != null) && (this.mSessionInfo != null))
      {
        b(paramQQAppInterface, this.mSessionInfo, this.mKeyword, true);
        this.mKeyword = null;
        this.mSessionInfo = null;
      }
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject;
      String str1;
      label58:
      String str2;
      if (this.N != null)
      {
        localObject = a(this.N.isSend(), paramSessionInfo.cZ);
        if (!this.N.isSend()) {
          break label233;
        }
        if (!paramBoolean) {
          break label198;
        }
        str1 = this.cxR;
        if (!paramBoolean) {
          break label211;
        }
        localObject = this.cxS;
        if (!paramBoolean) {
          break label224;
        }
        str2 = this.cxT;
        break label274;
      }
      for (;;)
      {
        label72:
        String str3 = paramSessionInfo.aTl;
        if (isValidUin(str3))
        {
          a(paramQQAppInterface, paramSessionInfo.cZ, str3, System.currentTimeMillis());
          b(paramQQAppInterface, str3, this.N.senderuin, paramSessionInfo.cZ, -4021, str1, (String)localObject, str2, paramString);
          if (!this.N.isSend()) {
            break label262;
          }
        }
        label262:
        for (paramQQAppInterface = "0";; paramQQAppInterface = "1")
        {
          VasWebviewUtil.reportVipKeywords(paramString, paramQQAppInterface, "0", go(paramSessionInfo.cZ), str3, "", "", "", "", "");
          this.N = null;
          if (paramBoolean)
          {
            this.cxT = null;
            this.cxS = null;
            this.cxR = null;
          }
          return;
          label198:
          str1 = (String)((Pair)localObject).first;
          break;
          label211:
          localObject = (String)((Pair)localObject).second;
          break label58;
          label224:
          str2 = this.openUrl;
          break label274;
          label233:
          str1 = (String)((Pair)localObject).first;
          localObject = (String)((Pair)localObject).second;
          str2 = this.cxQ;
          break label72;
        }
      }
    }
    finally {}
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    MessageRecord localMessageRecord = anbi.d(paramInt2);
    localMessageRecord.selfuin = paramQQAppInterface.getCurrentAccountUin();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "";
    }
    localMessageRecord.frienduin = str;
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = "";
      localMessageRecord.senderuin = paramString1;
      localMessageRecord.msg = paramString3;
      localMessageRecord.msgtype = paramInt2;
      localMessageRecord.isread = true;
      if (!paramString2.equals(paramQQAppInterface.getAccount())) {
        break label224;
      }
      paramInt2 = 1;
      label87:
      localMessageRecord.issend = paramInt2;
      localMessageRecord.istroop = paramInt1;
      paramInt1 = amzo.seq;
      amzo.seq = paramInt1 + 1;
      localMessageRecord.msgseq = paramInt1;
      if (this.N == null) {
        break label230;
      }
      l = this.N.shmsgseq;
      label137:
      localMessageRecord.shmsgseq = l;
      localMessageRecord.msgUid = ahav.ge();
      if (this.N == null) {
        break label249;
      }
    }
    label224:
    label230:
    label249:
    for (long l = this.N.time;; l = anaz.gQ())
    {
      localMessageRecord.time = l;
      localMessageRecord.saveExtInfoToExtStr("aio_vip_keyword", paramString6);
      localMessageRecord.saveExtInfoToExtStr("aio_vip_tips_highlight", paramString4);
      localMessageRecord.saveExtInfoToExtStr("aio_vip_tips_open_url", paramString5);
      paramQQAppInterface.b().b(localMessageRecord, paramQQAppInterface.getCurrentAccountUin());
      return;
      paramString1 = paramString2;
      break;
      paramInt2 = 0;
      break label87;
      l = Math.abs(new Random().nextInt());
      break label137;
    }
  }
  
  public String c(boolean paramBoolean, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      if (paramBoolean) {
        return cxy;
      }
      return cxz;
    case 1: 
      if (paramBoolean) {
        return cxA;
      }
      return cxB;
    }
    if (paramBoolean) {
      return cxC;
    }
    return cxD;
  }
  
  public void cW(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    do
    {
      return;
      Object localObject = null;
      File localFile = new File(paramContext.getFilesDir(), "vipKerwordJson");
      paramContext = localObject;
      if (localFile.exists()) {
        paramContext = aqhq.readFileContent(localFile);
      }
    } while (TextUtils.isEmpty(paramContext));
    iv(paramContext, paramString);
    p(BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public String go(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "0";
    case 1: 
      return "1";
    }
    return "2";
  }
  
  public void iv(String paramString1, String paramString2)
  {
    String[] arrayOfString = null;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString1);
        if (!((JSONObject)localObject).has("switch")) {
          break label676;
        }
        i = ((JSONObject)localObject).getInt("switch");
        this.ecY = i;
        if (((JSONObject)localObject).has("openWording"))
        {
          paramString1 = ((JSONObject)localObject).getString("openWording");
          this.cxI = paramString1;
          if (((JSONObject)localObject).has("openHighlightWording"))
          {
            paramString1 = ((JSONObject)localObject).getString("openHighlightWording");
            this.cxK = paramString1;
            if (!((JSONObject)localObject).has("giftWording")) {
              continue;
            }
            paramString1 = ((JSONObject)localObject).getString("giftWording");
            this.cxJ = paramString1;
            if (!((JSONObject)localObject).has("giftHighlightWording")) {
              continue;
            }
            paramString1 = ((JSONObject)localObject).getString("giftHighlightWording");
            this.cxL = paramString1;
            this.cxM = ((JSONObject)localObject).optString("groupOpenWording", cxE);
            this.cxN = ((JSONObject)localObject).optString("groupOpenHighlightWording", cxG);
            this.cxO = ((JSONObject)localObject).optString("groupGiftWording", cxF);
            this.cxP = ((JSONObject)localObject).optString("groupGiftHighlightWording", cxH);
            if (!((JSONObject)localObject).has("giftUrl")) {
              break label681;
            }
            paramString1 = ((JSONObject)localObject).getString("giftUrl");
            this.cxQ = paramString1;
            if (!((JSONObject)localObject).has("openUrl")) {
              break label686;
            }
            paramString1 = ((JSONObject)localObject).getString("openUrl");
            this.openUrl = paramString1;
            if (!((JSONObject)localObject).has("grayTail")) {
              break label691;
            }
            paramString1 = ((JSONObject)localObject).getString("grayTail");
            this.cWj = false;
            if (!TextUtils.isEmpty(paramString1))
            {
              paramString1 = paramString1.split(";");
              i = 0;
              if (i < paramString1.length)
              {
                localCharSequence = paramString1[i];
                if ((TextUtils.isEmpty(localCharSequence)) || (!paramString2.endsWith(localCharSequence.trim()))) {
                  break label696;
                }
                this.cWj = true;
              }
            }
            if (!((JSONObject)localObject).has("keyword")) {
              break label703;
            }
            paramString1 = ((JSONObject)localObject).getString("keyword");
            if (TextUtils.isEmpty(paramString1)) {
              continue;
            }
            paramString2 = new ArrayList();
            paramString1 = paramString1.split(";");
            i = 0;
            if (i >= paramString1.length) {
              continue;
            }
            CharSequence localCharSequence = paramString1[i];
            if ((TextUtils.isEmpty(localCharSequence)) || (TextUtils.isEmpty(localCharSequence.trim()))) {
              break label669;
            }
            paramString2.add(localCharSequence.trim().toLowerCase());
            break label669;
          }
        }
        else
        {
          paramString1 = cxE;
          continue;
        }
        paramString1 = cxG;
        continue;
        paramString1 = cxF;
        continue;
        paramString1 = cxH;
        continue;
        this.ev = ((String[])paramString2.toArray(new String[paramString2.size()]));
        paramString1 = arrayOfString;
        if (((JSONObject)localObject).has("groupKeywords")) {
          paramString1 = ((JSONObject)localObject).optString("groupKeywords");
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString2 = new ArrayList();
          arrayOfString = paramString1.split(";");
          i = 0;
          if (i < arrayOfString.length)
          {
            localObject = arrayOfString[i];
            if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(((String)localObject).trim()))) {
              break label708;
            }
            paramString2.add(((String)localObject).trim().toLowerCase());
            break label708;
          }
          this.id = ((String[])paramString2.toArray(new String[paramString2.size()]));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AioVipKeywordHelper", 2, "keyword = " + paramString1);
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("AioVipKeywordHelper", 1, "parseKeyword : json error " + paramString1);
        return;
      }
      this.id = this.ev;
      continue;
      label669:
      i += 1;
      continue;
      label676:
      int i = 0;
      continue;
      label681:
      paramString1 = null;
      continue;
      label686:
      paramString1 = null;
      continue;
      label691:
      paramString1 = null;
      continue;
      label696:
      i += 1;
      continue;
      label703:
      paramString1 = null;
      continue;
      label708:
      i += 1;
    }
  }
  
  public boolean k(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((TextUtils.isEmpty(paramSessionInfo.aTl)) && (QLog.isColorLevel())) {
      QLog.d("AioVipKeywordHelper", 2, "sessionInfo.curFriendUin=" + paramSessionInfo.aTl + ", need not detect keyword.");
    }
    return false;
  }
  
  public void p(AppRuntime paramAppRuntime)
  {
    boolean bool2 = false;
    paramAppRuntime = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "vip_personal_card.json", true, null);
    if (paramAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioVipKeywordHelper", 2, "parsejson file not exists");
      }
      return;
    }
    Object localObject1 = paramAppRuntime.optJSONObject("isChooseStyleClosed");
    if (localObject1 != null) {
      if (((JSONObject)localObject1).optInt("isChooseStyleClosed", 0) != 1) {
        break label266;
      }
    }
    ArrayList localArrayList;
    int j;
    int i;
    label266:
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity.cwm = bool1;
      localObject1 = paramAppRuntime.optJSONObject("aioVIPGrayTips");
      if (localObject1 == null) {
        break label385;
      }
      this.ecZ = ((JSONObject)localObject1).optInt("c2cEnable", 1);
      this.eda = ((JSONObject)localObject1).optInt("groupEnable", 1);
      this.edb = ((JSONObject)localObject1).optInt("discussGroupEnable", 1);
      this.atQ = ((JSONObject)localObject1).optLong("c2cFreq", 86400L);
      this.atR = ((JSONObject)localObject1).optLong("groupFreq", 86400L);
      this.atS = ((JSONObject)localObject1).optLong("discussGroupFreq", 86400L);
      this.atT = ((JSONObject)localObject1).optLong("fetchWordingTolerateTime", 2000L);
      Object localObject2 = ((JSONObject)localObject1).optString("dirtyWords");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label296;
      }
      localArrayList = new ArrayList();
      localObject2 = ((String)localObject2).split(";");
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject2[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localArrayList.add(localCharSequence.trim().toLowerCase());
        }
        i += 1;
      }
    }
    this.ie = ((String[])localArrayList.toArray(new String[localArrayList.size()]));
    label296:
    localObject1 = ((JSONObject)localObject1).optString("groupGrayTail");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.Ji = new ArrayList();
      localObject1 = ((String)localObject1).split(";");
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        localArrayList = localObject1[i];
        if (!TextUtils.isEmpty(localArrayList)) {
          this.Ji.add(localArrayList.trim().toLowerCase());
        }
        i += 1;
      }
    }
    label385:
    localObject1 = paramAppRuntime.optJSONObject("recommendConfig");
    if (localObject1 != null) {
      afns.jd(((JSONObject)localObject1).optLong("interval", 86400L));
    }
    localObject1 = paramAppRuntime.optJSONObject("lottieConfig");
    if (localObject1 != null) {
      if (((JSONObject)localObject1).optInt("switch") != 1) {
        break label769;
      }
    }
    label769:
    for (bool1 = true;; bool1 = false)
    {
      ahes.sEnable = bool1;
      QLog.i("AioVipKeywordHelper", 1, "lottieConfig.switch is " + bool1);
      localObject1 = paramAppRuntime.optJSONObject("ipProductGrayTips");
      if (localObject1 != null)
      {
        ajdf.bQM = ((JSONObject)localObject1).optString("leftText", ajdf.bQM);
        ajdf.bQN = ((JSONObject)localObject1).optString("linkText", ajdf.bQN);
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 2, "ipProductGrayTips: " + ((JSONObject)localObject1).toString());
        }
      }
      localObject1 = paramAppRuntime.optJSONObject("getStrangerInterval");
      if (localObject1 != null)
      {
        aqgm.dZe = ((JSONObject)localObject1).optInt("interval", 5000);
        QLog.d("AioVipKeywordHelper", 1, "getStrangerInterval is " + aqgm.dZe);
      }
      localObject1 = paramAppRuntime.optJSONObject("downloadTimeoutConfig");
      if (localObject1 != null)
      {
        afke.cRt = ((JSONObject)localObject1).optInt("emotion", afke.cRt);
        bool1 = bool2;
        if (((JSONObject)localObject1).optInt("emoTryReadNoLen", 0) == 1) {
          bool1 = true;
        }
        afke.bYt = bool1;
        QLog.d("AioVipKeywordHelper", 1, "downloadTimeoutConfig is " + ((JSONObject)localObject1).toString());
      }
      localObject1 = paramAppRuntime.optJSONObject("tmsDualCoreConfig");
      if (localObject1 != null) {
        QLog.d("KC.TMSManager", 1, "tms DPC : " + ((JSONObject)localObject1).toString());
      }
      localObject1 = paramAppRuntime.optJSONArray("shareDomainConfig");
      if (localObject1 != null) {
        aqrv.a().x((JSONArray)localObject1);
      }
      afli.s(paramAppRuntime.optJSONArray("h5MagicTips"));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aquv
 * JD-Core Version:    0.7.0.1
 */