import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.confess.ConfessConfig.1;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

public class aegp
{
  private static File ak = new File(BaseApplicationImpl.getApplication().getFilesDir(), "confess_talk");
  public static final String bwM = acfp.m(2131704291);
  public static final String bwN = acfp.m(2131704289);
  public static final String bwO = acfp.m(2131704294);
  public static final String bwP = acfp.m(2131704295);
  public static final String bwQ = acfp.m(2131704290);
  public static final String bwR = acfp.m(2131704292);
  public static final String bwS = acfp.m(2131704297);
  public static final String bwT = acfp.m(2131704293);
  public long VY;
  private long VZ;
  private long Wa;
  private long Wb;
  private boolean bTK;
  public String bwU;
  public String bwV;
  public String bwW;
  public String bwX;
  public String bwY;
  public String bwZ;
  public String bxa;
  public String bxb;
  private String bxc;
  public int cMC;
  public int cMD;
  public int cME;
  public int cMF;
  public int cMG;
  public int cMH;
  public int cMI;
  public int cMJ;
  public int cMK = 24;
  public int cML;
  public int cMM;
  private int cMN;
  private int cMO;
  public String detailUrl;
  private Object dm = new Object();
  boolean inited = false;
  private String mAccount;
  private final Random mRandom;
  public int nY;
  public String subtitle;
  public String title;
  public float vL;
  
  public aegp(String paramString)
  {
    this.mAccount = paramString;
    paramString = aqmj.a(this.mAccount, "confess_config_sp");
    this.mRandom = new Random(SystemClock.elapsedRealtime());
    this.VZ = paramString.getLong("lLastVanishTime", 0L);
    this.cMN = paramString.getInt("nContinuousVanishCount", 0);
    cc(null, true);
    ThreadManager.postImmediately(new ConfessConfig.1(this), null, true);
  }
  
  public static boolean B(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    while (aqmj.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L) <= 0L) {
      return false;
    }
    return true;
  }
  
  public static boolean C(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return aqmj.a(paramQQAppInterface.getAccount(), "confess_config_sp").getBoolean(paramString, false);
  }
  
  public static boolean D(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return aqmj.a(paramQQAppInterface.getAccount(), "confess_config_sp").getBoolean("holmes_tips_show_" + paramString, false);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if ((paramAppInterface == null) || (paramContext == null)) {
      return;
    }
    paramAppInterface = ((aegs)paramAppInterface.getManager(269)).b();
    if (paramAppInterface == null)
    {
      paramAppInterface = "https://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
      label30:
      if (TextUtils.isEmpty(paramAppInterface)) {
        break label197;
      }
      paramAppInterface = paramAppInterface + "&fromUin=" + ajri.encode(paramString1);
      paramAppInterface = paramAppInterface + "&toUin=" + ajri.encode(paramString2);
      paramString1 = paramAppInterface + "&topicId=" + paramInt;
      if (!paramBoolean) {
        break label199;
      }
    }
    label197:
    label199:
    for (paramAppInterface = "1";; paramAppInterface = "0")
    {
      paramAppInterface = paramString1 + "&isConfessor=" + paramAppInterface;
      paramString1 = new Intent(paramContext, QQBrowserActivity.class);
      paramString1.putExtra("hide_more_button", true);
      paramString1.putExtra("hide_operation_bar", true);
      paramString1.putExtra("url", paramAppInterface);
      paramContext.startActivity(paramString1);
      return;
      paramAppInterface = paramAppInterface.bxb;
      break label30;
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return aqmj.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "updateHolmesTipsNeedShow key:" + paramString + " value:" + paramBoolean);
    }
    return aqmj.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit().putBoolean("holmes_tips_show_" + paramString, paramBoolean).commit();
  }
  
  public static int c(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    int i = localCalendar1.get(6);
    int m = localCalendar1.get(1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    int k = localCalendar2.get(6);
    int j = localCalendar1.get(1);
    i -= k;
    k = i;
    if (j != m)
    {
      k = i;
      if (j < m)
      {
        if (((j % 4 == 0) && (j % 100 != 0)) || (j % 400 == 0)) {
          i += 366;
        }
        for (;;)
        {
          j += 1;
          break;
          i += 365;
        }
      }
    }
    return k;
  }
  
  public static long c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {
      return 0L;
    }
    return aqmj.a(paramQQAppInterface.getAccount(), "confess_config_sp").getLong(paramString, 0L);
  }
  
  private void cc(String paramString, boolean paramBoolean)
  {
    this.bTK = false;
    this.Wa = 0L;
    this.Wb = 0L;
    this.bxc = "";
    this.cMO = 0;
    this.cMI = 1;
    this.cMJ = 0;
    this.bxa = "";
    this.cMK = 24;
    this.cML = 5;
    this.cMM = 0;
    label322:
    Locale localLocale;
    if (TextUtils.isEmpty(paramString))
    {
      this.cMC = 0;
      this.cMD = 0;
      this.cME = 0;
      this.cMF = 0;
      this.cMG = 0;
      this.nY = 0;
      this.vL = 5.0F;
      if (TextUtils.isEmpty(this.bwV)) {
        this.bwV = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=contact_tab";
      }
      if (TextUtils.isEmpty(this.bwU)) {
        this.bwU = "https://ti.qq.com/honest-say/main.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.title)) {
        this.title = bwM;
      }
      if (TextUtils.isEmpty(this.subtitle)) {
        this.subtitle = bwN;
      }
      if (TextUtils.isEmpty(this.bwW)) {
        this.bwW = "https://ti.qq.com/honest-say/friends-received.html?_bid=3104&_wv=9191&_qStyle=1&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.detailUrl)) {
        this.detailUrl = "https://ti.qq.com/honest-say/confess-detail.html?_bid=3104&_wv=9191&_nav_alpha=0&_nav_txtclr=ffffff&_nav_titleclr=ffffff&_nav_anim=true&ADTAG=aio_card";
      }
      if (TextUtils.isEmpty(this.bwY)) {
        this.bwY = "https://ti.qq.com/honest-say/setting.html?_wv=9191&_wwv=4&_qStyle=1&adtag=message_box";
      }
      if (TextUtils.isEmpty(this.bxa)) {
        this.bxa = bwO;
      }
      if (TextUtils.isEmpty(this.bwX)) {
        this.bwX = "https://ti.qq.com/honest-say/group-received.html?_bid=3104&_wv=9191&_qStyle=1";
      }
      if (TextUtils.isEmpty(this.bwZ)) {
        this.bwZ = "https://ti.qq.com/honest-say/rank.html?_wv=9191&_wwv=4&_qStyle=1";
      }
      if (TextUtils.isEmpty(this.bxb)) {
        this.bxb = "https://ti.qq.com/honest-say/holmes.html?_nav_alpha=0&_wwv=4&_qStyle=1";
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramBoolean) {
        break label896;
      }
      this.VY = anaz.gQ();
      e((QQAppInterface)localObject, "rec_config_time", this.VY);
      if (QLog.isDevelopLevel())
      {
        localLocale = Locale.getDefault();
        if (!paramBoolean) {
          break label910;
        }
      }
    }
    label896:
    label910:
    String str;
    for (Object localObject = "local";; str = "server")
    {
      for (;;)
      {
        QLog.i("ConfessConfig", 4, String.format(localLocale, "parse %s config: %s", new Object[] { localObject, paramString }));
        return;
        try
        {
          localObject = new JSONObject(paramString);
          if (((JSONObject)localObject).has("min")) {
            this.cMD = ((JSONObject)localObject).getInt("min");
          }
          if (((JSONObject)localObject).has("max")) {
            this.cME = ((JSONObject)localObject).getInt("max");
          }
          if (((JSONObject)localObject).has("delta")) {
            this.cMF = ((JSONObject)localObject).getInt("delta");
          }
          if (((JSONObject)localObject).has("X")) {
            this.cMG = ((JSONObject)localObject).getInt("X");
          }
          if (((JSONObject)localObject).has("Y")) {
            this.nY = ((JSONObject)localObject).getInt("Y");
          }
          if (((JSONObject)localObject).has("contactEntryUrl")) {
            this.bwV = ((JSONObject)localObject).getString("contactEntryUrl");
          }
          if (((JSONObject)localObject).has("boxEntryUrl")) {
            this.bwU = ((JSONObject)localObject).getString("boxEntryUrl");
          }
          if (((JSONObject)localObject).has("title")) {
            this.title = ((JSONObject)localObject).getString("title");
          }
          if (((JSONObject)localObject).has("subtitle")) {
            this.subtitle = ((JSONObject)localObject).getString("subtitle");
          }
          if (((JSONObject)localObject).has("changeInterval")) {
            this.vL = ((float)((JSONObject)localObject).getDouble("changeInterval"));
          }
          if (((JSONObject)localObject).has("frdRecUrl")) {
            this.bwW = ((JSONObject)localObject).getString("frdRecUrl");
          }
          if (((JSONObject)localObject).has("frdRecMsgSwitch")) {
            this.cMO = ((JSONObject)localObject).getInt("frdRecMsgSwitch");
          }
          if (((JSONObject)localObject).has("detailUrl")) {
            this.detailUrl = ((JSONObject)localObject).getString("detailUrl");
          }
          if (((JSONObject)localObject).has("settingUrl")) {
            this.bwY = ((JSONObject)localObject).getString("settingUrl");
          }
          if (((JSONObject)localObject).has("entryBoxSwitch")) {
            this.cMI = ((JSONObject)localObject).getInt("entryBoxSwitch");
          }
          if (((JSONObject)localObject).has("entryContactSwitch")) {
            this.cMJ = ((JSONObject)localObject).getInt("entryContactSwitch");
          }
          if (((JSONObject)localObject).has("redPointText")) {
            this.bxa = ((JSONObject)localObject).getString("redPointText");
          }
          if (((JSONObject)localObject).has("blockTime")) {
            this.cMK = ((JSONObject)localObject).getInt("blockTime");
          }
          if (((JSONObject)localObject).has("groupCfsListUrl")) {
            this.bwX = ((JSONObject)localObject).getString("groupCfsListUrl");
          }
          if (((JSONObject)localObject).has("rankingSwitch")) {
            this.cMH = ((JSONObject)localObject).getInt("rankingSwitch");
          }
          if (((JSONObject)localObject).has("rankingUrl")) {
            this.bwZ = ((JSONObject)localObject).getString("rankingUrl");
          }
          if (((JSONObject)localObject).has("holmesCount")) {
            this.cML = ((JSONObject)localObject).optInt("holmesCount", 5);
          }
          if (((JSONObject)localObject).has("holmesUrl")) {
            this.bxb = ((JSONObject)localObject).optString("holmesUrl");
          }
          if (!((JSONObject)localObject).has("holmesSwitch")) {
            break;
          }
          this.cMM = ((JSONObject)localObject).optInt("holmesSwitch", 0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      break;
      this.VY = c(localException, "rec_config_time");
      break label322;
    }
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, String.format("saveRedPointShow key:%s value:%d", new Object[] { paramString, Long.valueOf(paramLong) }));
    }
    aqmj.a(paramQQAppInterface.getAccount(), "confess_config_sp").edit().putLong(paramString, paramLong).apply();
  }
  
  public static boolean i(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {
      return false;
    }
    return ((aegs)paramAppInterface.getManager(269)).b().agE();
  }
  
  public static boolean ly(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "saveConfig2File config is: " + paramString);
    }
    String str2 = ak.getPath() + File.separator;
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    boolean bool = aqhq.z(str2, "confess_talk.cfg", str1);
    QLog.i("ConfessConfig", 1, "saveConfig2File result : " + bool);
    return bool;
  }
  
  private String tf()
  {
    Object localObject = "";
    try
    {
      String str = aqhq.readFileToString(new File(ak, "confess_talk.cfg"));
      localObject = str;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.i("ConfessConfig", 1, "getConfigFromFile exception : " + QLog.getStackTraceString(localIOException));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "getConfigFromFile config is: " + (String)localObject);
    }
    return localObject;
  }
  
  public boolean agD()
  {
    boolean bool3 = true;
    long l = SystemClock.elapsedRealtime();
    if (Math.abs(l - this.Wa) < 60000L) {
      return this.bTK;
    }
    boolean bool1;
    if (this.cMJ >= 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (TextUtils.isEmpty(this.bwV)) {
          bool2 = false;
        }
      }
      bool1 = bool2;
      if (bool2)
      {
        if (c(NetConnInfoCenter.getServerTimeMillis(), this.VZ) == 0) {
          break label132;
        }
        bool1 = true;
      }
      label80:
      if ((!bool1) || (this.cMN < this.cMG)) {
        break label142;
      }
      if (c(NetConnInfoCenter.getServerTimeMillis(), this.VZ) <= this.nY) {
        break label137;
      }
      bool1 = bool3;
    }
    label132:
    label137:
    label142:
    for (;;)
    {
      this.Wa = l;
      this.bTK = bool1;
      return bool1;
      bool1 = false;
      break;
      bool1 = false;
      break label80;
      bool1 = false;
    }
  }
  
  public boolean agE()
  {
    return this.cMM == 1;
  }
  
  public boolean agF()
  {
    return this.cMO == 1;
  }
  
  public String getSubTitle()
  {
    long l = SystemClock.elapsedRealtime();
    if ((!TextUtils.isEmpty(this.bxc)) && (Math.abs(l - this.Wb) < (this.vL * 60000.0F))) {
      return this.bxc;
    }
    if (TextUtils.isEmpty(this.subtitle)) {
      this.bxc = "";
    }
    for (;;)
    {
      return this.bxc;
      if (!this.subtitle.contains("N"))
      {
        this.bxc = this.subtitle;
      }
      else if ((this.cME > 0) && (this.cME > this.cMD))
      {
        int i = this.mRandom.nextInt(this.cME);
        int j = this.cME;
        int k = this.cMD;
        int m = this.cMD;
        this.Wb = l;
        NumberFormat localNumberFormat = NumberFormat.getNumberInstance();
        this.bxc = this.subtitle.replace("N", localNumberFormat.format(i % (j - k + 1) + m));
      }
      else
      {
        this.bxc = "";
      }
    }
  }
  
  public void initConfig()
  {
    if (this.inited) {
      return;
    }
    String str = tf();
    synchronized (this.dm)
    {
      if (!this.inited)
      {
        cc(str, true);
        this.inited = true;
      }
      return;
    }
  }
  
  public boolean lx(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfessConfig", 2, "onGetConfigFromServer config :" + paramString);
    }
    synchronized (this.dm)
    {
      cc(paramString, false);
      return ly(paramString);
    }
  }
  
  public String r(QQAppInterface paramQQAppInterface)
  {
    if (B(paramQQAppInterface, "redpoint_leba_show"))
    {
      if (this.bxa == null) {
        return bwO;
      }
      return this.bxa;
    }
    if (this.title == null) {
      return bwM;
    }
    return this.title;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(140);
    localStringBuilder.append("HonestSayConfig{").append("nSwitch: ").append(this.cMC).append(", frdRecMsgSwitch: ").append(this.cMO).append(", nMin: ").append(this.cMD).append(", nMax: ").append(this.cME).append(", nDelta: ").append(this.cMF).append(", nX: ").append(this.cMG).append(", nY: ").append(this.nY).append(", fChangeInterval: ").append(this.vL).append(", title: ").append(this.title).append(", subtitle: ").append(this.subtitle).append(", contactEntryUrl: ").append(this.bwV).append(", boxEntryUrl: ").append(this.bwU).append(", detailUrl: ").append(this.detailUrl).append(", settingUrl: ").append(this.bwY).append(", lLastVanishTime: ").append(this.VZ).append(", nContinuousVanishCount: ").append(this.cMN).append(", rankingUrl: ").append(this.bwZ).append(", rankSwitch: ").append(this.cMH).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aegp
 * JD-Core Version:    0.7.0.1
 */