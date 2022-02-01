import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VipGrayConfigHelper.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqrt
{
  private static final List<String> Ja = new ArrayList();
  private static aqrt a;
  private static final AtomicInteger ch = new AtomicInteger(0);
  private static final Runnable hT = new VipGrayConfigHelper.1();
  private static final Map<String, AtomicInteger> oq = new HashMap();
  private static final Map<String, AtomicInteger> or = new HashMap();
  private static final Map<String, AtomicReference<Intent>> os = new HashMap();
  private static final Map<String, AtomicLong> ot = new HashMap();
  public String cwC = "";
  public String cwD = "";
  public String cwE = "";
  public String cwF = "";
  private String cwG = "https://imgcache.gtimg.cn/club/mqgame/";
  private int eco = 1;
  private List<WeakReference<aqrt.a>> gV = new ArrayList();
  
  public static aqrt a()
  {
    if (a == null) {
      a = new aqrt();
    }
    return a;
  }
  
  private void a(AppRuntime paramAppRuntime, JSONArray paramJSONArray, boolean paramBoolean)
  {
    if ((paramAppRuntime == null) || (paramJSONArray == null) || (paramJSONArray.length() < 0))
    {
      QLog.e("VipGrayConfigHelper", 1, "parseVipGrayConfig app = null or configList = null or len < 0");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipGrayConfigHelper", 2, "parseVipGrayConfig begin config = " + paramJSONArray.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("vipGrayConfigSp", 0);
    if (paramBoolean)
    {
      Ja.clear();
      oq.clear();
      or.clear();
      ot.clear();
      os.clear();
      ((SharedPreferences)localObject).edit().clear().apply();
      if (paramBoolean) {
        ch.set(0);
      }
    }
    for (;;)
    {
      try
      {
        int j = paramJSONArray.length();
        int i = 0;
        String str;
        if (i < j)
        {
          localObject = paramJSONArray.getJSONObject(i);
          str = ((JSONObject)localObject).optString("business");
          if ("vipEnterText".equals(str))
          {
            if (a(paramAppRuntime, (JSONObject)localObject))
            {
              this.cwC = ((JSONObject)localObject).optString("notVip");
              this.cwE = ((JSONObject)localObject).optString("outdatedVip");
              this.cwD = ((JSONObject)localObject).optString("vip");
              this.cwF = ((JSONObject)localObject).optString("svip");
              if (QLog.isColorLevel()) {
                QLog.d("VipGrayConfigHelper", 2, "parse vipEnterText notvip = " + this.cwC + ", outdatevip = " + this.cwE + ", vipstr= " + this.cwD + ", svip = " + this.cwF);
              }
            }
            i += 1;
            continue;
            if (!Ja.isEmpty()) {
              break;
            }
            paramBoolean = true;
            break;
          }
          if (("backgroundWebView".equals(str)) && (paramBoolean)) {
            continue;
          }
          if (!"gameIcon".equals(str)) {
            break label455;
          }
          if (!a(paramAppRuntime, (JSONObject)localObject)) {
            continue;
          }
          this.cwG = ((JSONObject)localObject).optString("baseUrl", "");
          this.eco = ((JSONObject)localObject).optInt("expireDay", 0);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VipGrayConfigHelper", 2, "king info, url = " + this.cwG + ",expireDay = " + this.eco);
          continue;
        }
        if (!"ipStackConfigDic".equals(str)) {
          continue;
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("VipGrayConfigHelper", 1, "parseVipGrayConfig exception", paramAppRuntime);
        efk();
        return;
      }
      label455:
      if (a(paramAppRuntime, (JSONObject)localObject))
      {
        long l = ((JSONObject)localObject).optLong("ipStackTimeInterval");
        ((ajdf)paramAppRuntime.getManager(200)).kf(l);
        if (QLog.isColorLevel()) {
          QLog.d("VipGrayConfigHelper", 2, "ipsite interval = " + l);
        }
      }
    }
  }
  
  private void bCS()
  {
    try
    {
      int j = this.gV.size();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          aqrt.a locala = (aqrt.a)((WeakReference)this.gV.get(i)).get();
          if (locala != null) {
            locala.bUr();
          }
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  public static void efk()
  {
    int i = ch.get();
    if ((i < 0) || (i >= Ja.size())) {}
    Object localObject;
    do
    {
      return;
      localObject = (String)Ja.get(i);
      localObject = (AtomicLong)ot.get(localObject);
    } while (localObject == null);
    ThreadManager.getSubThreadHandler().removeCallbacks(hT);
    ThreadManager.getSubThreadHandler().postDelayed(hT, ((AtomicLong)localObject).get());
  }
  
  private void efl()
  {
    this.cwC = "";
    this.cwD = "";
    this.cwE = "";
    this.cwF = "";
    this.cwG = "https://imgcache.gtimg.cn/club/mqgame/";
    this.eco = 1;
  }
  
  /* Error */
  public void a(aqrt.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 85	aqrt:gV	Ljava/util/List;
    //   9: invokeinterface 274 1 0
    //   14: if_icmpge +38 -> 52
    //   17: aload_0
    //   18: getfield 85	aqrt:gV	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 278 2 0
    //   27: checkcast 280	mqq/util/WeakReference
    //   30: invokevirtual 283	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   33: checkcast 6	aqrt$a
    //   36: astore_3
    //   37: aload_3
    //   38: aload_1
    //   39: if_acmpne +6 -> 45
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: iload_2
    //   46: iconst_1
    //   47: iadd
    //   48: istore_2
    //   49: goto -45 -> 4
    //   52: aload_1
    //   53: ifnull -11 -> 42
    //   56: aload_0
    //   57: getfield 85	aqrt:gV	Ljava/util/List;
    //   60: new 280	mqq/util/WeakReference
    //   63: dup
    //   64: aload_1
    //   65: invokespecial 317	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   68: invokeinterface 320 2 0
    //   73: pop
    //   74: goto -32 -> 42
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	aqrt
    //   0	82	1	parama	aqrt.a
    //   3	46	2	i	int
    //   36	2	3	locala	aqrt.a
    // Exception table:
    //   from	to	target	type
    //   4	37	77	finally
    //   56	74	77	finally
  }
  
  public void a(URLImageView paramURLImageView, boolean paramBoolean1, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean2, String paramString)
  {
    if (paramURLImageView == null) {}
    do
    {
      return;
      paramURLImageView.setVisibility(8);
    } while (!e(paramBoolean1, paramLong1));
    paramURLImageView.setVisibility(0);
    paramString = b(paramString, paramLong2, paramInt, paramBoolean2);
    if (TextUtils.isEmpty(paramString))
    {
      paramURLImageView.setVisibility(8);
      return;
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, new ColorDrawable(), new ColorDrawable());
    if (localURLDrawable.getStatus() != 1) {
      localURLDrawable.restartDownload();
    }
    paramURLImageView.setBackgroundDrawable(localURLDrawable);
    paramURLImageView.setURLDrawableDownListener(new aqru(this, paramString, paramURLImageView));
  }
  
  public boolean a(AppRuntime paramAppRuntime, JSONObject paramJSONObject)
  {
    bool3 = false;
    bool1 = false;
    boolean bool2 = true;
    if ((paramAppRuntime == null) || (paramJSONObject == null))
    {
      QLog.e("VipGrayConfigHelper", 1, "isConfigValid app = null || config = null");
      bool2 = bool1;
      return bool2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipGrayConfigHelper", 2, "isConfigValid config = " + paramJSONObject.toString());
    }
    try
    {
      i = paramJSONObject.optInt("platformId");
      if (i != 0)
      {
        bool1 = bool3;
        if (i != 2) {
          break label300;
        }
      }
      if (!paramJSONObject.has("minVersion")) {
        break label434;
      }
      str = paramJSONObject.getString("minVersion");
      if ((TextUtils.isEmpty(str)) || (aqqi.bV(str, "3.4.4.3058"))) {
        break label434;
      }
      i = 0;
    }
    catch (Exception paramAppRuntime)
    {
      for (;;)
      {
        String str;
        int j;
        int k;
        long l1;
        long l2;
        long l3;
        label300:
        label340:
        label383:
        QLog.e("VipGrayConfigHelper", 1, "isConfigValid exception", paramAppRuntime);
        bool1 = bool3;
        continue;
        int i = 1;
        continue;
        bool1 = false;
      }
    }
    j = i;
    if (i != 0)
    {
      j = i;
      if (paramJSONObject.has("maxVersion"))
      {
        str = paramJSONObject.getString("maxVersion");
        j = i;
        if (!TextUtils.isEmpty(str))
        {
          j = i;
          if (!aqqi.bV("3.4.4.3058", str)) {
            j = 0;
          }
        }
      }
    }
    bool1 = bool3;
    if (j != 0)
    {
      paramAppRuntime = paramAppRuntime.getAccount();
      i = paramJSONObject.optInt("startIndex");
      j = paramJSONObject.optInt("endIndex");
      if (i < j) {
        break label383;
      }
      k = paramAppRuntime.length();
      if ((k < i) || (k < j)) {
        break label340;
      }
      l1 = Long.parseLong(paramAppRuntime.substring(k - i, k - j + 1));
      l2 = paramJSONObject.optLong("min");
      l3 = paramJSONObject.optLong("max");
      if ((l1 < l2) || (l1 > l3)) {
        break label439;
      }
    }
    for (bool1 = bool2;; bool1 = bool3)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VipGrayConfigHelper", 2, "isConfigValid valid = " + bool1);
      return bool1;
      QLog.e("VipGrayConfigHelper", 1, "parseJson, index config error, uin length=" + k + ", config=" + paramJSONObject.toString());
      break label439;
      QLog.e("VipGrayConfigHelper", 1, "parseJson, startIndex < endIndex, element=" + paramJSONObject);
    }
  }
  
  public String b(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    return c(paramString, paramLong, paramInt, paramBoolean, false);
  }
  
  public void b(aqrt.a parama)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.gV.size())
        {
          if ((aqrt.a)((WeakReference)this.gV.get(i)).get() == parama)
          {
            parama = this.gV.get(i);
            if (parama != null) {
              this.gV.remove(parama);
            }
            return;
          }
          i += 1;
        }
        else
        {
          parama = null;
        }
      }
      finally {}
    }
  }
  
  public String c(String paramString, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("VipGrayConfigHelper", 2, "getNamePlateOfKingUrl, gameAppId = " + paramLong + " dan = " + paramInt + " danSwitch = " + paramBoolean1 + " isSetting = " + paramBoolean2);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    int j;
    SharedPreferences localSharedPreferences;
    int i;
    if ((!TextUtils.isEmpty(this.cwG)) && (paramLong != 0L))
    {
      j = 1;
      if (!(localObject instanceof QQAppInterface)) {
        break label385;
      }
      localObject = (QQAppInterface)localObject;
      localSharedPreferences = ((QQAppInterface)localObject).getApp().getSharedPreferences("sp_plate_of_king", 0);
      if ((TextUtils.isEmpty(paramString)) || (!((QQAppInterface)localObject).getCurrentUin().equals(paramString))) {
        break label255;
      }
      i = 1;
    }
    label146:
    for (boolean bool = localSharedPreferences.getBoolean("plate_of_king_display_switch_" + ((QQAppInterface)localObject).getCurrentUin(), true);; bool = true)
    {
      if (i != 0)
      {
        i = k;
        if (j != 0) {
          if (!bool)
          {
            i = k;
            if (!paramBoolean2) {}
          }
          else
          {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          if (paramInt == 0)
          {
            return this.cwG + paramLong + ".png";
            j = 0;
            break;
            label255:
            i = 0;
            break label146;
            i = k;
            if (j == 0) {
              continue;
            }
            i = k;
            if (!paramBoolean1) {
              continue;
            }
            i = 1;
            continue;
          }
          return this.cwG + paramLong + "_" + paramInt + ".png";
        }
      }
      QLog.e("VipGrayConfigHelper", 1, "getNamePlateOfKingUrl namePlateOfKingUrl = null gameAppId= " + paramLong + " dan= " + paramInt + " danSwitch= " + paramBoolean1 + " localSwitch = " + bool);
      return null;
      i = 0;
    }
  }
  
  public void d(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      QLog.e("VipGrayConfigHelper", 1, "parsejson error, app = null");
    }
    Object localObject;
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VipGrayConfigHelper", 2, "parsejson, begin");
      }
      efl();
      try
      {
        localObject = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "vip_personal_card.json", true, null);
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VipGrayConfigHelper", 2, "parsejson file not exists");
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("VipGrayConfigHelper", 1, "parseJson exception", paramAppRuntime);
      }
    }
    for (;;)
    {
      bCS();
      return;
      localObject = ((JSONObject)localObject).optJSONArray("vipGrayConfig");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0)) {
        a(paramAppRuntime, (JSONArray)localObject, paramBoolean);
      } else {
        QLog.e("VipGrayConfigHelper", 1, "parsejson configList = null or len < 0");
      }
    }
  }
  
  public boolean e(boolean paramBoolean, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipGrayConfigHelper", 2, "showNamePlateOfKing, isSuperVip = " + paramBoolean + ", lastLoginTime = " + paramLong);
    }
    if (!paramBoolean) {
      return false;
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    paramLong = NetConnInfoCenter.getServerTime();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    int i = localCalendar.get(6);
    localCalendar.setTimeInMillis(l * 1000L);
    return i - localCalendar.get(6) <= this.eco;
  }
  
  public void k(AppRuntime paramAppRuntime)
  {
    d(paramAppRuntime, false);
  }
  
  public static abstract interface a
  {
    public abstract void bUr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqrt
 * JD-Core Version:    0.7.0.1
 */