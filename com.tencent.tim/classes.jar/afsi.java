import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.LruCache;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.3;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.4;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.5;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.9;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SearchKeyWord;

public class afsi
  implements afss.a, Manager
{
  public static final String DEFAULT_TAG = acfp.m(2131706006);
  public static afuc a;
  private static final Object mLock = new Object();
  private List<aftd> Au;
  private volatile boolean ES;
  private volatile long XJ;
  private accn jdField_a_of_type_Accn = new afsj(this);
  private afsi.a jdField_a_of_type_Afsi$a;
  private afss jdField_a_of_type_Afss;
  private afvv jdField_a_of_type_Afvv;
  private aldd jdField_a_of_type_Aldd;
  private oidb_0xdb1.SchoolInfo jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  private boolean aMz;
  private afvv b;
  private String bFd;
  public String bFe;
  private String bFf = "";
  private String bFg = "";
  private afsr c = new afsm(this);
  private long cL;
  private int cTO;
  private int cTP;
  private int cTQ;
  private boolean caE;
  private volatile boolean caF;
  private volatile boolean caG;
  private Object dC = new Object();
  private int downloadTimes;
  private EntityManager em;
  private boolean inited;
  private QQAppInterface mApp;
  private int mCurrentTab = -1;
  private LruCache<String, ExtendFriendUserInfo> u = new LruCache(50);
  private ArrayList<String> wp = new ArrayList();
  private ArrayList<String> wq = new ArrayList();
  
  public afsi(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mApp.addObserver(this.jdField_a_of_type_Accn);
    this.mApp.addObserver(this.c);
    this.jdField_a_of_type_Afss = new afss(this.mApp);
    this.jdField_a_of_type_Afss.a(this);
    this.jdField_a_of_type_Afvv = new afvv(this.mApp, 2);
    this.b = new afvv(this.mApp, 1);
    this.em = paramQQAppInterface.a().createEntityManager();
    ThreadManager.postImmediately(new ExtendFriendManager.3(this), null, true);
  }
  
  private void Bv(boolean paramBoolean)
  {
    ((afsg)this.mApp.getBusinessHandler(127)).notifyUI(5, true, Boolean.valueOf(paramBoolean));
  }
  
  private void Io(boolean paramBoolean)
  {
    aqmj.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785").edit().putBoolean("sp_extend_friend_is_user_student", paramBoolean).commit();
  }
  
  private void Iq(boolean paramBoolean)
  {
    QLog.i("ExtendFriendManager", 2, "setExtendFriendUsing o " + paramBoolean);
    this.ES = paramBoolean;
  }
  
  private static int J(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if (paramQQAppInterface != null) {
      i = aqmj.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_forbid_flag", 0);
    }
    return i;
  }
  
  private afsi.a a(String paramString)
  {
    int j = 0;
    afsi.a locala = new afsi.a();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        locala.bFh = paramString.optString("contactEntranceTitle");
        locala.bFi = paramString.optString("contactEntranceLine1");
        locala.bFj = paramString.optString("contactEntranceLine2");
        locala.bFk = paramString.optString("addEntranceTitle");
        locala.bFl = paramString.optString("addEntranceLine1");
        locala.cTR = paramString.optInt("maxPlayers");
        locala.cTS = paramString.optInt("minPlayers");
        locala.cTT = paramString.optInt("voiceMaxLength");
        locala.cTU = paramString.optInt("maxSlipTimes");
        locala.cTV = paramString.optInt("redisplayInterval");
        locala.bFm = paramString.optString("defaultDecleration");
        locala.cTW = paramString.optInt("declerationMinLen");
        locala.cTX = paramString.optInt("isExpandEntranceOnTop");
        locala.bFn = paramString.optString("resourceURL");
        locala.bFo = paramString.optString("resourceMD5");
        locala.cTY = paramString.optInt("isShowGroup");
        locala.bFq = paramString.optString("ExpandExamImg");
        locala.cUd = paramString.optInt("exposureTimeLimit", 2);
        locala.bVX = paramString.optBoolean("showVipIcon", false);
        locala.cUe = paramString.optInt("GrayTipsMsgCount", 50);
        locala.bFr = paramString.optString("GrayTipsMsg");
        locala.bFs = paramString.optString("GrayTipsMsgLight");
        locala.cUf = paramString.optInt("IceBreakSwitch", 1);
        locala.bFt = paramString.optString("BeatWarning");
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendManager", 2, "parseConfig config.exposureTimeLimit:" + locala.cUd);
        }
        locala.Av.clear();
        JSONArray localJSONArray = paramString.optJSONArray("defaultTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            locala.Av.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        locala.Aw.clear();
        localJSONArray = paramString.optJSONArray("searchTags");
        if (localJSONArray != null)
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            locala.Aw.add(localJSONArray.optString(i));
            i += 1;
            continue;
          }
        }
        locala.bFp = paramString.optString("searchHint");
        localJSONArray = paramString.optJSONArray("ExpandMatchRes");
        if (localJSONArray != null)
        {
          i = j;
          if (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject == null) {
              break label730;
            }
            afsi.b localb = new afsi.b();
            localb.name = localJSONObject.optString("name");
            if ("aioVideo".equals(localb.name))
            {
              localb.url = localJSONObject.optString("resourceURLAndroid");
              localb.md5 = localJSONObject.optString("resourceMD5Android");
              if (QLog.isColorLevel()) {
                QLog.d("ExtendFriendManager", 2, String.format("aiovideo use android url:%s", new Object[] { localb.url }));
              }
              if (!localb.akg()) {
                break label730;
              }
              locala.kw.put(localb.name, localb);
              break label730;
            }
            localb.url = localJSONObject.optString("resourceURL");
            localb.md5 = localJSONObject.optString("resourceMD5");
            continue;
          }
        }
        locala.cTZ = paramString.optInt("ExpandMatchSwitch");
      }
      catch (JSONException paramString)
      {
        QLog.e("ExtendFriendManager", 2, "parseConfig fail.", paramString);
        return null;
      }
      locala.cUa = paramString.optInt("isNuanSSFirst");
      locala.cUb = paramString.optInt("isVoiceMatchOpen");
      locala.cUc = paramString.optInt("isSignalOpen");
      return locala;
      label730:
      i += 1;
    }
  }
  
  private static SpannableStringBuilder a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramBaseActivity.getString(2131701113));
    if (paramBoolean) {
      return localSpannableStringBuilder;
    }
    localSpannableStringBuilder.append("\n");
    Object localObject = new SpannableString("图");
    int i = aqnm.dip2px(20.0F);
    Drawable localDrawable = paramBaseActivity.getResources().getDrawable(2130842211);
    localDrawable.setBounds(0, 0, i, i);
    ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 1), 0, ((SpannableString)localObject).length(), 17);
    localSpannableStringBuilder.append((CharSequence)localObject);
    localSpannableStringBuilder.append(" ");
    paramBaseActivity = paramBaseActivity.getString(2131701114);
    localObject = a(paramQQAppInterface, paramLong);
    paramQQAppInterface = String.format(" %s ", new Object[] { ((ArrayList)localObject).get(0) });
    localObject = (String)((ArrayList)localObject).get(1);
    localObject = new SpannableString(paramBaseActivity + paramQQAppInterface + (String)localObject);
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(14, true), 0, ((SpannableString)localObject).length(), 17);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#878B99")), 0, ((SpannableString)localObject).length(), 17);
    i = paramBaseActivity.length();
    int j = paramBaseActivity.length() + paramQQAppInterface.length();
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(24, true), i, j, 33);
    ((SpannableString)localObject).setSpan(new StyleSpan(1), i, j, 33);
    localSpannableStringBuilder.append((CharSequence)localObject);
    return localSpannableStringBuilder;
  }
  
  private static ArrayList<String> a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramLong > 86400L)
    {
      localArrayList.add(String.valueOf((paramLong + 86400L - 1L) / 86400L));
      localArrayList.add(paramQQAppInterface.getApp().getString(2131692438));
      return localArrayList;
    }
    if (paramLong > 3600L)
    {
      localArrayList.add(String.valueOf((paramLong + 3600L - 1L) / 3600L));
      localArrayList.add(paramQQAppInterface.getApp().getString(2131694709));
      return localArrayList;
    }
    if (paramLong > 60L)
    {
      localArrayList.add(String.valueOf((paramLong + 60L - 1L) / 60L));
      localArrayList.add(paramQQAppInterface.getApp().getString(2131695949));
      return localArrayList;
    }
    if (paramLong > 0L)
    {
      localArrayList.add(String.valueOf(paramLong));
      localArrayList.add(paramQQAppInterface.getApp().getString(2131719351));
      return localArrayList;
    }
    localArrayList.add(String.valueOf(0));
    localArrayList.add(paramQQAppInterface.getApp().getString(2131719351));
    return localArrayList;
  }
  
  private void a(Context paramContext, afxt paramafxt)
  {
    if (paramafxt == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync start");
    }
    if ((!aqiw.isNetSupport(paramContext)) || (!afwz.yQ()))
    {
      a(false, null, paramafxt);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.XJ < 3600000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync get cache");
      }
      paramContext = aczc.a("extend_friend");
      if ((paramContext != null) && (paramContext.a != null))
      {
        a(true, paramContext, paramafxt);
        return;
      }
    }
    this.XJ = l;
    aczc.a(new afsp(this, "extend_friend", false, paramafxt));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = aqmj.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").edit();
      paramQQAppInterface.putInt("sp_extend_friend_forbid_flag", paramInt);
      paramQQAppInterface.putLong("sp_extend_friend_forbid_end_time", paramLong);
      paramQQAppInterface.commit();
    }
  }
  
  private void a(oidb_0xdb1.SchoolInfo paramSchoolInfo)
  {
    int j = 0;
    if (paramSchoolInfo != null)
    {
      this.jdField_a_of_type_Aldd = new aldd();
      Object localObject = this.jdField_a_of_type_Aldd;
      int i;
      if (paramSchoolInfo.uint32_idx.has())
      {
        i = paramSchoolInfo.uint32_idx.get();
        ((aldd)localObject).drZ = i;
        localObject = this.jdField_a_of_type_Aldd;
        i = j;
        if (paramSchoolInfo.uint32_category.has()) {
          i = paramSchoolInfo.uint32_category.get();
        }
        ((aldd)localObject).dsa = i;
        aldd localaldd = this.jdField_a_of_type_Aldd;
        if (!paramSchoolInfo.str_school_id.has()) {
          break label147;
        }
        localObject = paramSchoolInfo.str_school_id.get();
        label104:
        localaldd.bVN = ((String)localObject);
        localObject = this.jdField_a_of_type_Aldd;
        if (!paramSchoolInfo.str_school_name.has()) {
          break label154;
        }
      }
      label147:
      label154:
      for (paramSchoolInfo = paramSchoolInfo.str_school_name.get();; paramSchoolInfo = "")
      {
        ((aldd)localObject).bVO = paramSchoolInfo;
        return;
        i = 0;
        break;
        localObject = "";
        break label104;
      }
    }
    this.jdField_a_of_type_Aldd = null;
  }
  
  private void a(boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo, afxt paramafxt)
  {
    paramafxt.a(paramBoolean, aftc.a(paramSosoLbsInfo));
  }
  
  public static boolean a(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface)
  {
    if ((paramBaseActivity == null) || (paramQQAppInterface == null) || (paramBaseActivity.isFinishing())) {}
    int i;
    do
    {
      return false;
      i = J(paramQQAppInterface);
    } while (i == 0);
    long l = i(paramQQAppInterface) - NetConnInfoCenter.getServerTime();
    if ((i != 1) || (l > 8640000L)) {}
    for (boolean bool = true; (bool) || (l > 0L); bool = false)
    {
      aqju localaqju = aqha.a(paramBaseActivity, 230);
      paramQQAppInterface = a(paramBaseActivity, paramQQAppInterface, bool, l);
      localaqju.setTitle(paramBaseActivity.getString(2131701115)).setMessage(paramQQAppInterface).setPositiveButton(paramBaseActivity.getString(2131701112), new afsl(paramBaseActivity)).setOnKeyListener(new afsk(paramBaseActivity));
      localaqju.show();
      return true;
    }
    a(paramQQAppInterface, 0, 0L);
    return false;
  }
  
  public static void ce(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("setAnswerQuestionFlag, uin: %s, flag: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    aqmj.k(paramString).edit().putBoolean("sp_extend_friend_question", paramBoolean).apply();
  }
  
  private void dbM()
  {
    this.caF = aqmj.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785").getBoolean("sp_extend_friend_is_user_student", false);
  }
  
  private void dbN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig=%s mDownloader=%s", new Object[] { this.jdField_a_of_type_Afsi$a, this.jdField_a_of_type_Afss }));
    }
    if ((this.jdField_a_of_type_Afsi$a != null) && (this.jdField_a_of_type_Afss != null)) {
      try
      {
        this.jdField_a_of_type_Afss.fy(this.jdField_a_of_type_Afsi$a.bFn, this.jdField_a_of_type_Afsi$a.bFo);
        if (!this.jdField_a_of_type_Afss.akh())
        {
          this.jdField_a_of_type_Afss.downloadResource();
          In(false);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("checkToDownloadResource mResourceReady=%s", new Object[] { Boolean.valueOf(this.aMz) }));
          }
          return;
          In(true);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ExtendFriendManager", 1, "checkToDownloadResource fail.", localException);
        }
      }
    }
    if (this.jdField_a_of_type_Afsi$a == null)
    {
      QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mConfig is null", new Object[0]));
      return;
    }
    QLog.e("ExtendFriendManager", 2, String.format("checkToDownloadResource mDownloader is null", new Object[0]));
  }
  
  private void dbO()
  {
    String str = afxw.kL("expand_question_dialog.png");
    File localFile = new File(str);
    boolean bool = localFile.exists();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("downloadQuestionRes, filePath:%s, isExist:%s", new Object[] { str, Boolean.valueOf(bool) }));
    }
    if (bool) {}
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_Afsi$a == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Afsi$a.bFq))) {
        break label149;
      }
      i = aqva.a(new aquz(this.jdField_a_of_type_Afsi$a.bFq, localFile), this.mApp);
      if (i != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendManager", 2, "downloadQuestionRes success!");
    return;
    QLog.e("ExtendFriendManager", 1, String.format("downloadQuestionRes fail, ret = %s", new Object[] { Integer.valueOf(i) }));
    return;
    label149:
    QLog.e("ExtendFriendManager", 1, "downloadQuestionRes, config or url is empty!");
  }
  
  private void dbP()
  {
    if (this.mApp != null) {}
    for (;;)
    {
      try
      {
        Card localCard = ((acff)this.mApp.getManager(51)).b(this.mApp.getCurrentUin());
        if (localCard != null)
        {
          if (TextUtils.isEmpty(localCard.declaration)) {
            continue;
          }
          bool1 = true;
          boolean bool2 = localCard.isShowCard;
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData profileComplete=%s showCard=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          }
          if (jdField_a_of_type_Afuc != null)
          {
            jdField_a_of_type_Afuc.caM = bool1;
            jdField_a_of_type_Afuc.caN = bool2;
          }
        }
      }
      catch (Exception localException)
      {
        boolean bool1;
        QLog.e("ExtendFriendManager", 1, "updateSwitchInCacheData fail.", localException);
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("updateSwitchInCacheData %s", new Object[] { jdField_a_of_type_Afuc }));
      }
      return;
      bool1 = false;
    }
  }
  
  private void dbW()
  {
    SharedPreferences localSharedPreferences = aqmj.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = localSharedPreferences.getLong("sp_extend_friend_first_enter_everyday", 0L);
    long l2 = anaz.gQ();
    boolean bool = false;
    if (l2 - l1 > 86400L) {
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        localSharedPreferences.edit().putLong("sp_extend_friend_first_enter_everyday", l2).remove("sp_extend_friend_signal_everyday_report_" + l1).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "checkFirstEnterExtendFriendEveryDay first:" + l1 + " current:" + l2 + " isFirstTimeToday:" + bool);
      }
      return;
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(1000L * l1);
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(1000L * l2);
      if (localCalendar1.get(6) != localCalendar2.get(6)) {
        bool = true;
      }
    }
  }
  
  private void dbX()
  {
    SharedPreferences localSharedPreferences = aqmj.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785");
    long l1 = localSharedPreferences.getLong("sp_extend_friend_first_enter_everyday", 0L);
    if (l1 > 0L)
    {
      String str = "sp_extend_friend_signal_everyday_report_" + l1;
      boolean bool = localSharedPreferences.getBoolean(str, false);
      if (!bool)
      {
        long l2 = anaz.gQ();
        anot.a(this.mApp, "dc00898", "", "", "0X800AE99", "0X800AE99", 0, 0, String.valueOf(l2 - l1), "", "", "");
        localSharedPreferences.edit().putBoolean(str, true).commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "checkReportForFirstReceiveCardEveryDay " + l1 + " " + bool);
      }
    }
  }
  
  private static long i(QQAppInterface paramQQAppInterface)
  {
    long l = 0L;
    if (paramQQAppInterface != null) {
      l = aqmj.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getLong("sp_extend_friend_forbid_end_time", 0L);
    }
    return l;
  }
  
  public static boolean me(String paramString)
  {
    boolean bool = aqmj.k(paramString).getBoolean("sp_extend_friend_question", true);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "needAnswerQuestion: " + bool);
    }
    return bool;
  }
  
  public int DA()
  {
    return this.cTQ;
  }
  
  public int DB()
  {
    return this.cTP;
  }
  
  public int Dy()
  {
    if (this.cTO == 0) {
      if ((this.jdField_a_of_type_Afsi$a == null) || (this.jdField_a_of_type_Afsi$a.cTR <= 0)) {
        break label66;
      }
    }
    label66:
    for (this.cTO = (this.jdField_a_of_type_Afsi$a.cTS + new Random().nextInt(this.jdField_a_of_type_Afsi$a.cTR - this.jdField_a_of_type_Afsi$a.cTS));; this.cTO = new Random().nextInt(10000000)) {
      return this.cTO;
    }
  }
  
  public int Dz()
  {
    int j = 2147483647;
    int i = j;
    if (isInited())
    {
      i = j;
      if (this.jdField_a_of_type_Afsi$a != null) {
        i = this.jdField_a_of_type_Afsi$a.cUe;
      }
    }
    return i;
  }
  
  public void Ii(String arg1)
  {
    afsi.a locala = a(???);
    synchronized (mLock)
    {
      this.jdField_a_of_type_Afsi$a = locala;
      this.inited = true;
      boolean bool = afwv.b(this.jdField_a_of_type_Afsi$a);
      ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.4(this, bool));
      return;
    }
  }
  
  public void Im(boolean paramBoolean)
  {
    In(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, String.format("onResourceDownloadComplete mResourceReady=%s", new Object[] { Boolean.valueOf(this.aMz) }));
    }
    if (!paramBoolean) {
      QLog.e("ExtendFriendManager", 2, "onResourceDownloadComplete FAILED!");
    }
  }
  
  public void In(boolean paramBoolean)
  {
    this.aMz = paramBoolean;
    Bv(paramBoolean);
  }
  
  public void Ip(boolean paramBoolean)
  {
    QLog.i("ExtendFriendManager", 2, "setSingalBombWaiting o " + paramBoolean);
    this.caG = paramBoolean;
  }
  
  public void K(List<String> paramList1, List<String> paramList2)
  {
    if (paramList2 != null)
    {
      this.wq.clear();
      this.wq.addAll(paramList2);
    }
  }
  
  public void Nf(int paramInt)
  {
    this.mCurrentTab = paramInt;
  }
  
  public void O(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getUnlimitMatchUserInfo() uin = " + paramString1 + " matchUin = " + paramString2 + "uinType=" + paramInt);
    }
    ((afsg)this.mApp.getBusinessHandler(127)).f(paramString1, paramString2, paramInt);
  }
  
  public List<String> Y(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1)
    {
      String[] arrayOfString = ands.c(this.mApp.getLongAccountUin());
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, String.format("getDefaultTags campusHotTags=%s", new Object[] { Arrays.toString(arrayOfString) }));
      }
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        this.wp.clear();
        this.wp.addAll(Arrays.asList(arrayOfString));
      }
      paramInt = this.wp.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 5);
        localArrayList.addAll(this.wp.subList(0, paramInt));
      }
    }
    for (;;)
    {
      localArrayList.add(0, DEFAULT_TAG);
      return localArrayList;
      paramInt = this.wq.size();
      if (paramInt > 0)
      {
        paramInt = Math.min(paramInt, 5);
        localArrayList.addAll(this.wq.subList(0, paramInt));
      }
    }
  }
  
  public List<String> Z(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 1) {
      if (this.wp.size() > 0) {
        localArrayList.addAll(this.wp);
      }
    }
    while (this.wq.size() <= 0) {
      return localArrayList;
    }
    localArrayList.addAll(this.wq);
    return localArrayList;
  }
  
  public afsi.a a()
  {
    return this.jdField_a_of_type_Afsi$a;
  }
  
  public aftc a()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = aczc.a("extend_friend");
    aftc localaftc = null;
    if (localSosoLbsInfo != null) {
      localaftc = aftc.a(localSosoLbsInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync " + localaftc);
    }
    long l = System.currentTimeMillis();
    if ((aqiw.isNetSupport(this.mApp.getApp().getBaseContext())) && (afwz.yQ()) && (l - this.XJ > 3600000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoSync start");
      }
      this.XJ = l;
      ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.9(this));
    }
    return localaftc;
  }
  
  public aftd a()
  {
    synchronized (this.dC)
    {
      if ((this.Au == null) || (this.Au.isEmpty())) {
        break label162;
      }
      long l = anaz.gQ();
      Iterator localIterator = this.Au.iterator();
      while (localIterator.hasNext())
      {
        aftd localaftd2 = (aftd)localIterator.next();
        if (l - localaftd2.pushTime > 86400L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendManager", 2, "checkAndGetLatestSignalBombCardData remove timeout data " + localaftd2.uin);
          }
          localIterator.remove();
        }
      }
    }
    if (!this.Au.isEmpty())
    {
      aftd localaftd1 = (aftd)this.Au.remove(0);
      return localaftd1;
    }
    label162:
    return null;
  }
  
  public afvv a()
  {
    return this.jdField_a_of_type_Afvv;
  }
  
  public aldd a()
  {
    return this.jdField_a_of_type_Aldd;
  }
  
  public ExtendFriendUserInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.em == null) || (!this.em.isOpen())) {
      return null;
    }
    return (ExtendFriendUserInfo)this.em.find(ExtendFriendUserInfo.class, paramString);
  }
  
  public ExtendFriendUserInfo a(String paramString, boolean paramBoolean)
  {
    ExtendFriendUserInfo localExtendFriendUserInfo2 = (ExtendFriendUserInfo)this.u.get(paramString);
    ExtendFriendUserInfo localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
    if (localExtendFriendUserInfo2 == null)
    {
      localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
      if (paramBoolean)
      {
        localExtendFriendUserInfo2 = a(paramString);
        localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
        if (localExtendFriendUserInfo2 != null)
        {
          this.u.put(paramString, localExtendFriendUserInfo2);
          localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
        }
      }
    }
    return localExtendFriendUserInfo1;
  }
  
  public oidb_0xdb1.SchoolInfo a()
  {
    return this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo;
  }
  
  public void a(aftd paramaftd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "addExtendFriendSignalBombCardData " + paramaftd);
    }
    if (paramaftd != null) {
      synchronized (this.dC)
      {
        if (this.Au == null) {
          this.Au = new ArrayList(5);
        }
        this.Au.add(0, paramaftd);
        return;
      }
    }
  }
  
  public void a(aftr paramaftr)
  {
    Object localObject2;
    String str;
    Object localObject1;
    int j;
    boolean bool;
    if (paramaftr != null)
    {
      this.mApp.a().h(paramaftr.bFC, paramaftr.uin, paramaftr.sig);
      if (akf())
      {
        a(aftd.a(paramaftr));
        if (paramaftr.a != null)
        {
          localObject2 = this.mApp;
          str = paramaftr.bFC;
          i = paramaftr.a.cUg;
          if (!this.caF) {
            break label242;
          }
          localObject1 = "1";
          anot.a((QQAppInterface)localObject2, "dc00898", "", str, "0X800AE9A", "0X800AE9A", i, 0, "", (String)localObject1, paramaftr.a.bFx, paramaftr.a.bFy);
        }
        dbX();
      }
      aine.ai(this.mApp, paramaftr.bFC);
      aine.n(this.mApp, paramaftr.bFC, 1044);
      aine.a(this.mApp, paramaftr, paramaftr.timeStamp, 1);
      localObject1 = this.mApp;
      localObject2 = paramaftr.bFC;
      j = paramaftr.tagId;
      str = paramaftr.tagName;
      if (TextUtils.isEmpty(paramaftr.tipsWording)) {
        break label250;
      }
      bool = true;
      label198:
      if (paramaftr.a == null) {
        break label256;
      }
    }
    label256:
    for (int i = paramaftr.a.distance;; i = -1)
    {
      aine.a((QQAppInterface)localObject1, (String)localObject2, j, str, bool, i, true, 4);
      aqgv.b(this.mApp, paramaftr.bFC, true);
      return;
      label242:
      localObject1 = "2";
      break;
      label250:
      bool = false;
      break label198;
    }
  }
  
  public void a(ExtendFriendUserInfo paramExtendFriendUserInfo)
  {
    if (paramExtendFriendUserInfo == null) {}
    for (;;)
    {
      return;
      this.u.put(paramExtendFriendUserInfo.uin, paramExtendFriendUserInfo);
      if ((this.em != null) && (this.em.isOpen()))
      {
        if (paramExtendFriendUserInfo.getStatus() != 1000) {
          break label86;
        }
        this.em.persistOrReplace(paramExtendFriendUserInfo);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ExtendFriendManager", 2, "updateExtendFriendUserInfo " + paramExtendFriendUserInfo);
        return;
        label86:
        if (paramExtendFriendUserInfo.getStatus() == 1001) {
          this.em.update(paramExtendFriendUserInfo);
        }
      }
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_0xdb1.RspBody paramRspBody)
  {
    Object localObject2 = "";
    int k = 0;
    int j;
    String str1;
    label45:
    int i;
    label62:
    label89:
    boolean bool;
    label98:
    String str2;
    label131:
    label140:
    label167:
    label191:
    Object localObject1;
    label219:
    label253:
    ArrayList localArrayList;
    label290:
    label329:
    label347:
    Iterator localIterator;
    if (paramRspBody.enum_school_verify_status.has())
    {
      j = paramRspBody.enum_school_verify_status.get();
      if (!paramRspBody.str_school_verify_tips.has()) {
        break label459;
      }
      str1 = paramRspBody.str_school_verify_tips.get();
      this.bFg = str1;
      if (!TextUtils.isEmpty(str1)) {
        break label466;
      }
      i = 1;
      hS(j, i);
      if (!paramRspBody.uint32_user_identity.has()) {
        break label472;
      }
      i = paramRspBody.uint32_user_identity.get();
      if (i != 1) {
        break label478;
      }
      bool = true;
      this.caF = bool;
      Io(this.caF);
      if (!paramRspBody.uint32_need_display_school_info.has()) {
        break label484;
      }
      i = paramRspBody.uint32_need_display_school_info.get();
      if (i != 1) {
        break label490;
      }
      bool = true;
      this.caE = bool;
      if (!paramRspBody.msg_new_school_info.has()) {
        break label496;
      }
      paramFromServiceMsg = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_new_school_info.get();
      this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo = paramFromServiceMsg;
      if (!paramRspBody.str_suggest_school_name.has()) {
        break label501;
      }
      str2 = paramRspBody.str_suggest_school_name.get();
      this.bFf = str2;
      if (!paramRspBody.msg_kuolie_school_info.has()) {
        break label508;
      }
      localObject1 = (oidb_0xdb1.SchoolInfo)paramRspBody.msg_kuolie_school_info.get();
      a((oidb_0xdb1.SchoolInfo)localObject1);
      paramFromServiceMsg = (FromServiceMsg)localObject2;
      if (localObject1 != null)
      {
        if (!((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.has()) {
          break label514;
        }
        paramFromServiceMsg = ((oidb_0xdb1.SchoolInfo)localObject1).str_school_name.get();
      }
      i = k;
      if (paramToServiceMsg.extraData.getBoolean("key_need_get_online_number", false))
      {
        if (!paramRspBody.uint32_online_num.has()) {
          break label520;
        }
        i = paramRspBody.uint32_online_num.get();
      }
      this.cTP = i;
      if (!paramToServiceMsg.extraData.getBoolean("key_need_get_search_keywords", false)) {
        break label637;
      }
      if (!paramRspBody.msg_campus_search_keywords.has()) {
        break label526;
      }
      localObject1 = paramRspBody.msg_campus_search_keywords.get();
      if (!paramRspBody.msg_voice_search_keywords.has()) {
        break label532;
      }
      paramToServiceMsg = paramRspBody.msg_voice_search_keywords.get();
      localObject2 = new ArrayList();
      localArrayList = new ArrayList();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label544;
      }
      localIterator = ((List)localObject1).iterator();
    }
    label389:
    label520:
    label526:
    label532:
    label542:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label544;
      }
      localObject1 = (oidb_0xdb1.SearchKeyWord)localIterator.next();
      if (((oidb_0xdb1.SearchKeyWord)localObject1).str_school_name.has()) {}
      for (localObject1 = ((oidb_0xdb1.SearchKeyWord)localObject1).str_school_name.get();; localObject1 = "")
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label542;
        }
        ((List)localObject2).add(localObject1);
        break label389;
        j = 0;
        break;
        label459:
        str1 = "";
        break label45;
        label466:
        i = 2;
        break label62;
        label472:
        i = 0;
        break label89;
        label478:
        bool = false;
        break label98;
        label484:
        i = 0;
        break label131;
        label490:
        bool = false;
        break label140;
        label496:
        paramFromServiceMsg = null;
        break label167;
        label501:
        str2 = "";
        break label191;
        label508:
        localObject1 = null;
        break label219;
        paramFromServiceMsg = "";
        break label253;
        i = 0;
        break label290;
        localObject1 = null;
        break label329;
        paramToServiceMsg = null;
        break label347;
      }
    }
    label514:
    label544:
    if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
    {
      localObject1 = paramToServiceMsg.iterator();
      label627:
      while (((Iterator)localObject1).hasNext())
      {
        paramToServiceMsg = (oidb_0xdb1.SearchKeyWord)((Iterator)localObject1).next();
        if (paramToServiceMsg.str_school_name.has()) {}
        for (paramToServiceMsg = paramToServiceMsg.str_school_name.get();; paramToServiceMsg = "")
        {
          if (TextUtils.isEmpty(paramToServiceMsg)) {
            break label627;
          }
          localArrayList.add(paramToServiceMsg);
          break;
        }
      }
    }
    K((List)localObject2, localArrayList);
    label637:
    if (paramRspBody.uint32_forbid_flag.has())
    {
      k = paramRspBody.uint32_forbid_flag.get();
      if (!paramRspBody.uint32_forbid_end_time.has()) {
        break label830;
      }
    }
    label830:
    for (long l = paramRspBody.uint32_forbid_end_time.get();; l = 0L)
    {
      a(this.mApp, k, l);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "handleGetExtendFriendPermissionAndStatusResponse. ,verifyStatus = " + j + ",verifyTips = " + str1 + ",serverSuggestSchoolName = " + str2 + ",schoolNameInExtendFriendCard = " + paramFromServiceMsg + ",onlineNumber = " + i + ",needShowEduBackgroundUpdateDialog = " + this.caE + ",profileNewSchoolInfo = " + this.jdField_a_of_type_TencentImOidbCmd0xdb1Oidb_0xdb1$SchoolInfo + ",isUserStudentOrNot = " + this.caF + ",forbidFlag = " + k + ",forbidEndTime = " + l);
      }
      return;
      k = 0;
      break;
    }
  }
  
  public boolean a(afsi.a parama)
  {
    boolean bool = true;
    if ((parama == null) || (this.mApp == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        parama = aqmj.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785");
        int i = parama.getInt("sp_extend_friend_entry_contact", 0);
        int j = parama.getInt("sp_extend_friend_entry_add_friend", 0);
        if ((i != 1) || (j != 1)) {
          break label87;
        }
        return bool;
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ExtendFriendManager", 2, parama.getMessage());
      return false;
      label87:
      bool = false;
    }
  }
  
  public boolean ajY()
  {
    return this.caF;
  }
  
  public boolean ajZ()
  {
    if ((isInited()) && (this.jdField_a_of_type_Afsi$a != null)) {}
    for (int i = this.jdField_a_of_type_Afsi$a.cUf;; i = 1) {
      return i == 1;
    }
  }
  
  public boolean aka()
  {
    boolean bool2 = false;
    boolean bool3 = afxn.ay(this.mApp);
    boolean bool1 = bool2;
    if (bool3) {
      if ((this.cTQ != 0) && (this.cTQ != 2))
      {
        bool1 = bool2;
        if (this.cTQ != 3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "isNeedShowCertificateBanner result = " + bool1 + ",showFlag = " + bool3);
    }
    return bool1;
  }
  
  public boolean akb()
  {
    if (this.jdField_a_of_type_Afsi$a == null) {}
    while (this.jdField_a_of_type_Afsi$a.cTZ != 1) {
      return false;
    }
    return true;
  }
  
  public boolean akc()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Afsi$a != null) && (this.jdField_a_of_type_Afsi$a.cUb == 1)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "bVoiceMatchOpen  " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean akd()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Afsi$a != null) && (this.jdField_a_of_type_Afsi$a.cUc == 1)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendManager", 2, "bSignalBombOpen  " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean ake()
  {
    QLog.i("ExtendFriendManager", 2, "getIsSingalBombWaiting o " + this.caG);
    return this.caG;
  }
  
  public boolean akf()
  {
    QLog.i("ExtendFriendManager", 2, "getIsExtendFriendUsing " + this.ES);
    return this.ES;
  }
  
  public afsi.a b()
  {
    if (!isInited()) {
      initConfig();
    }
    return this.jdField_a_of_type_Afsi$a;
  }
  
  public afvv b()
  {
    return this.b;
  }
  
  public void bR(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendManager.5(this));
  }
  
  public ArrayList<aepf.a> cX()
  {
    return aepg.a().cT();
  }
  
  public void dbQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateMatchChatConfig ");
    }
    ((afsg)this.mApp.getBusinessHandler(127)).notifyUI(18, true, null);
  }
  
  public void dbR()
  {
    this.u.evictAll();
    if ((this.em != null) && (this.em.isOpen())) {
      this.em.drop(ExtendFriendUserInfo.class);
    }
  }
  
  public void dbS()
  {
    Iq(true);
    a(this.mApp.getApp().getBaseContext(), new afsn(this));
    dbW();
  }
  
  public void dbT()
  {
    Iq(false);
    ((afsg)this.mApp.getBusinessHandler(127)).ajX();
  }
  
  public void dbU()
  {
    a(this.mApp.getApp().getBaseContext(), new afso(this));
  }
  
  public void dbV()
  {
    synchronized (this.dC)
    {
      if (this.Au != null) {
        this.Au.clear();
      }
      return;
    }
  }
  
  public void h(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCurExtendFriendSchoolInfo ,idx = " + paramInt1 + ",schoolName = " + paramString1 + ",schoolId = " + paramString2 + ",schoolCategory = " + paramInt2);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      this.jdField_a_of_type_Aldd = null;
      return;
    }
    if (this.jdField_a_of_type_Aldd == null) {
      this.jdField_a_of_type_Aldd = new aldd();
    }
    this.jdField_a_of_type_Aldd.drZ = paramInt1;
    this.jdField_a_of_type_Aldd.bVO = paramString1;
    this.jdField_a_of_type_Aldd.bVN = paramString2;
    this.jdField_a_of_type_Aldd.dsa = paramInt2;
  }
  
  public void hS(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "updateCampusCertificateStatus campusCertificateStatus = " + this.cTQ + ",new status = " + paramInt1);
    }
    this.cTQ = paramInt1;
    afxn.g(this.mApp, paramInt1, paramInt2);
  }
  
  /* Error */
  public void initConfig()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 753	afsi:inited	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 118	afsi:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokevirtual 615	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: aload_0
    //   16: getfield 118	afsi:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 185	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: ldc 187
    //   24: invokestatic 1514	aqgt:k	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_1
    //   28: aload_1
    //   29: invokestatic 886	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifne +74 -> 106
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 1025	afsi:a	(Ljava/lang/String;)Lafsi$a;
    //   40: astore_2
    //   41: getstatic 78	afsi:mLock	Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_0
    //   48: getfield 753	afsi:inited	Z
    //   51: ifne +13 -> 64
    //   54: aload_0
    //   55: aload_2
    //   56: putfield 253	afsi:jdField_a_of_type_Afsi$a	Lafsi$a;
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 753	afsi:inited	Z
    //   64: aload_1
    //   65: monitorexit
    //   66: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq -62 -> 7
    //   72: ldc 213
    //   74: iconst_2
    //   75: ldc_w 1515
    //   78: invokestatic 234	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: return
    //   82: astore_1
    //   83: invokestatic 399	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq -79 -> 7
    //   89: ldc 213
    //   91: iconst_2
    //   92: aload_1
    //   93: invokevirtual 1416	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   96: aload_1
    //   97: invokestatic 1517	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: return
    //   101: astore_2
    //   102: aload_1
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    //   106: getstatic 78	afsi:mLock	Ljava/lang/Object;
    //   109: astore_1
    //   110: aload_1
    //   111: monitorenter
    //   112: aload_0
    //   113: getfield 753	afsi:inited	Z
    //   116: ifne +8 -> 124
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield 753	afsi:inited	Z
    //   124: aload_1
    //   125: monitorexit
    //   126: ldc 213
    //   128: iconst_2
    //   129: ldc_w 1519
    //   132: invokestatic 863	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: goto -69 -> 66
    //   138: astore_2
    //   139: aload_1
    //   140: monitorexit
    //   141: aload_2
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	afsi
    //   82	21	1	localException	Exception
    //   40	16	2	locala	afsi.a
    //   101	4	2	localObject3	Object
    //   138	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   8	28	82	java/lang/Exception
    //   47	64	101	finally
    //   64	66	101	finally
    //   102	104	101	finally
    //   112	124	138	finally
    //   124	126	138	finally
    //   139	141	138	finally
  }
  
  public boolean isInited()
  {
    return this.inited;
  }
  
  public boolean isResourceReady()
  {
    if (!this.aMz) {
      QLog.e("ExtendFriendManager", 2, "isResourceReady NOT READY!");
    }
    return this.aMz;
  }
  
  public void onDestroy()
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Accn);
      this.mApp.removeObserver(this.c);
    }
    this.mApp = null;
    if (this.jdField_a_of_type_Afss != null)
    {
      this.jdField_a_of_type_Afss.dbY();
      this.jdField_a_of_type_Afss.a(null);
      this.jdField_a_of_type_Afss = null;
      this.aMz = false;
    }
    jdField_a_of_type_Afuc = null;
    if (this.u != null) {
      this.u.evictAll();
    }
  }
  
  public String uB()
  {
    int k = 0;
    if (TextUtils.isEmpty(this.bFd))
    {
      String str = String.valueOf(Dy());
      int i = str.length();
      int m = str.length() / 3 + i;
      int n = str.length() % 3;
      i = n;
      int j = m;
      if (n == 0)
      {
        i = n + 3;
        j = m - 1;
      }
      char[] arrayOfChar = new char[j];
      m = 0;
      j = k;
      k = i;
      i = m;
      if (i < arrayOfChar.length)
      {
        if (i == k)
        {
          k += 4;
          arrayOfChar[i] = ',';
          j += 1;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfChar[i] = str.charAt(i - j);
        }
      }
      this.bFd = new String(arrayOfChar);
    }
    return this.bFd;
  }
  
  public String uC()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isInited())
    {
      afsi.a locala = a();
      localObject1 = localObject2;
      if (locala != null) {
        localObject1 = locala.bFp;
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = acfp.m(2131706003);
    }
    return localObject2;
  }
  
  public String uD()
  {
    String str2 = "";
    String str1 = str2;
    if (isInited())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Afsi$a != null) {
        str1 = this.jdField_a_of_type_Afsi$a.bFr;
      }
    }
    return str1;
  }
  
  public String uE()
  {
    String str2 = "";
    String str1 = str2;
    if (isInited())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Afsi$a != null) {
        str1 = this.jdField_a_of_type_Afsi$a.bFs;
      }
    }
    return str1;
  }
  
  public String uF()
  {
    String str2 = "";
    String str1 = str2;
    if (isInited())
    {
      str1 = str2;
      if (this.jdField_a_of_type_Afsi$a != null) {
        str1 = this.jdField_a_of_type_Afsi$a.bFt;
      }
    }
    return str1;
  }
  
  public String uG()
  {
    return this.bFf;
  }
  
  public String uH()
  {
    if (this.jdField_a_of_type_Aldd != null) {
      return this.jdField_a_of_type_Aldd.bVO;
    }
    return "";
  }
  
  public void v(String paramString, Bundle paramBundle)
  {
    ExtendFriendUserInfo localExtendFriendUserInfo2 = a(paramString, true);
    ExtendFriendUserInfo localExtendFriendUserInfo1 = localExtendFriendUserInfo2;
    if (localExtendFriendUserInfo2 == null) {
      localExtendFriendUserInfo1 = new ExtendFriendUserInfo();
    }
    localExtendFriendUserInfo1.uin = paramString;
    localExtendFriendUserInfo1.fromType = paramBundle.getInt("fromType", 3);
    a(localExtendFriendUserInfo1);
  }
  
  public static class a
  {
    public List<String> Av = new ArrayList();
    public List<String> Aw = new ArrayList();
    public String bFh;
    public String bFi;
    public String bFj;
    public String bFk;
    public String bFl;
    public String bFm;
    public String bFn;
    public String bFo;
    public String bFp;
    public String bFq;
    public String bFr;
    public String bFs;
    public String bFt;
    public boolean bVX;
    public int cTR;
    public int cTS;
    public int cTT;
    public int cTU;
    public int cTV;
    public int cTW;
    public int cTX;
    public int cTY;
    public int cTZ;
    public int cUa;
    public int cUb;
    public int cUc;
    public int cUd = 2;
    public int cUe = 50;
    public int cUf = 1;
    public HashMap<String, afsi.b> kw = new HashMap();
  }
  
  public class b
  {
    public String md5;
    public String name;
    public String url;
    
    public b() {}
    
    public boolean akg()
    {
      return (!TextUtils.isEmpty(this.name)) && (!TextUtils.isEmpty(this.url)) && (!TextUtils.isEmpty(this.md5));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsi
 * JD-Core Version:    0.7.0.1
 */