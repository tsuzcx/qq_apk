import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.1;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.11;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.12;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.13;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.14;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.15;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.16;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.18;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.19;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.2;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.20;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.3;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.4;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.5;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.6;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.7;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.8;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;
import com.tencent.biz.pubaccount.readinjoy.kandianreport.ReadInJoyMMapKvStorage;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class lcm
{
  private static lcm.g jdField_a_of_type_Lcm$g = new lcm.g(null);
  private static volatile lcm jdField_a_of_type_Lcm;
  private static int aNn;
  private static int aNo;
  private static boolean ajd;
  private static boolean aje;
  private static boolean ajf;
  private static volatile boolean ajg;
  public static long tA;
  private static long tB;
  private static long tC;
  private static long tD;
  private static long tE;
  private static long tF;
  private static long tG = System.currentTimeMillis();
  public static final long tw = ;
  private static long tx;
  private static long ty;
  private static long tz;
  private lcm.c jdField_a_of_type_Lcm$c;
  public lcm.k a;
  String aey = "";
  boolean ajc = false;
  private boolean ajh;
  private boolean aji;
  public lcm.k b = this.jdField_a_of_type_Lcm$k;
  private String[] bl = { "com.tencent.weishi", "com.tencent.reading", "com.tencent.mtt", "com.tencent.qqlive", "com.tencent.news" };
  private String[] bm = { "ws", "kb", "ll", "sp", "xw" };
  private Runnable cE = new ReadinjoySPEventReport.8(this);
  long clickTime = -1L;
  private Pair<Long, Integer> d;
  private Pair<Long, Integer> e;
  private Handler handler = new Handler(ThreadManager.getSubThreadLooper());
  private List<Object> hh = new LinkedList();
  private List<Pair<Long, Integer>> hi = Collections.synchronizedList(new ArrayList());
  private List<Pair<Long, Integer>> hj = Collections.synchronizedList(new ArrayList());
  private List<Pair<Long, Integer>> hk = Collections.synchronizedList(new ArrayList());
  private StringBuilder u = new StringBuilder(1024);
  
  static
  {
    tA = -1L;
    tE = System.currentTimeMillis();
    aje = true;
  }
  
  private lcm()
  {
    this.jdField_a_of_type_Lcm$k = new lcm.k();
    init();
  }
  
  public static long B(long paramLong)
  {
    paramLong = Math.max(Math.max(cy(), tE), paramLong);
    return System.currentTimeMillis() - paramLong;
  }
  
  public static boolean BL()
  {
    return ajd;
  }
  
  public static void X(int paramInt, boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.13(paramInt, paramBoolean));
  }
  
  private String a(anqv paramanqv)
  {
    paramanqv = paramanqv.rz.iterator();
    while (paramanqv.hasNext())
    {
      anqu localanqu = (anqu)paramanqv.next();
      if ((localanqu instanceof StructMsgItemTitle)) {
        return ((StructMsgItemTitle)localanqu).getText();
      }
    }
    return "";
  }
  
  private lcm.c a(List<ChatMessage> paramList)
  {
    lcm.c localc = new lcm.c();
    int i = 0;
    int j = 0;
    Object localObject = awit.t();
    long l1 = ((Integer)((Pair)localObject).first).intValue();
    long l2 = ((Integer)((Pair)localObject).second).intValue();
    long l3 = NetConnInfoCenter.getServerTime();
    int k = paramList.size() - 1;
    long l4;
    if (k >= 0)
    {
      localObject = (ChatMessage)paramList.get(k);
      l4 = l3 - ((ChatMessage)localObject).time;
      if ((l4 <= l1) || (l4 <= l2)) {}
    }
    else
    {
      paramList = kxm.getAppRuntime();
      if ((paramList == null) || (!(paramList instanceof QQAppInterface))) {
        break label446;
      }
      k = ((QQAppInterface)paramList).b().bl();
      label133:
      paramList = new oidb_cmd0x80a.AttributeList();
      paramList.att_id.set(1);
      paramList.att_name.set("Time");
      paramList.att_value.set(String.valueOf(System.currentTimeMillis() / 1000L));
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("MsgPulse");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(l1 + ":" + j + "`" + l2 + ":" + i);
      oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(3);
      localAttributeList1.att_name.set("Keyword");
      localAttributeList1.att_value.set("");
      oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(4);
      localAttributeList2.att_name.set("LeftBtmRedCnt");
      localAttributeList2.att_value.set(String.valueOf(k));
      localc.a = paramList;
      localc.b = ((oidb_cmd0x80a.AttributeList)localObject);
      localc.c = localAttributeList1;
      localc.d = localAttributeList2;
      return localc;
    }
    int m;
    if ((!((ChatMessage)localObject).isSendFromLocal()) && (l4 <= l1))
    {
      m = j + 1;
      j = i;
      i = m;
    }
    for (;;)
    {
      m = k - 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break;
      if ((((ChatMessage)localObject).isSendFromLocal()) && (l4 <= l2))
      {
        m = i + 1;
        i = j;
        j = m;
        continue;
        label446:
        k = 0;
        break label133;
      }
      m = i;
      i = j;
      j = m;
    }
  }
  
  public static lcm a()
  {
    if (jdField_a_of_type_Lcm == null) {}
    try
    {
      if (jdField_a_of_type_Lcm == null) {
        jdField_a_of_type_Lcm = new lcm();
      }
      return jdField_a_of_type_Lcm;
    }
    finally {}
  }
  
  public static void a(int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    if (df(paramInt1) < 0) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.15(paramList, paramInt1, paramInt2));
  }
  
  public static void a(int paramInt1, Map<String, String> paramMap, int paramInt2)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.19(paramInt1, paramMap, paramInt2));
  }
  
  public static void aJV()
  {
    tC = NetConnInfoCenter.getServerTime();
  }
  
  public static void aJW()
  {
    tD = System.currentTimeMillis();
  }
  
  public static void aJX()
  {
    ni(true);
  }
  
  public static void aJY()
  {
    if (ajg) {
      return;
    }
    ajg = true;
    try
    {
      lcf.init();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      BaseApplicationImpl.getContext().registerReceiver(jdField_a_of_type_Lcm$g, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void aJZ()
  {
    ThreadManager.getSubThreadHandler().post(new ReadinjoySPEventReport.4());
  }
  
  private void aKa()
  {
    if (dz(14))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_Lcm$c.a);
      localArrayList.add(this.jdField_a_of_type_Lcm$c.c);
      localArrayList.add(this.jdField_a_of_type_Lcm$c.d);
      ocp.y(14, localArrayList);
    }
  }
  
  public static void aKc()
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.14());
  }
  
  public static void aKd() {}
  
  public static void aKe()
  {
    ocp.y(71, new ArrayList());
  }
  
  public static void aKf()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("daily_folderstatus");
    localAttributeList.att_value.set(kvs.iL());
    localArrayList.add(localAttributeList);
    ocp.y(91, localArrayList);
  }
  
  public static void aKg()
  {
    tG = System.currentTimeMillis();
  }
  
  public static String as(long paramLong)
  {
    Object localObject1 = null;
    switch ((int)paramLong)
    {
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = String.valueOf(paramLong);
      }
      return localObject2;
      localObject1 = "KongJian";
      continue;
      localObject1 = "YueDu";
      continue;
      localObject1 = "BuLuo";
      continue;
      localObject1 = "DongMan";
      continue;
      localObject1 = "FujinQun";
      continue;
      localObject1 = "XinWen";
      continue;
      localObject1 = "Now";
      continue;
      localObject1 = "RiJi";
      continue;
      localObject1 = "YouXi";
      continue;
      localObject1 = "YinYue";
      continue;
      localObject1 = "ChiHe";
      continue;
      localObject1 = "KeTang";
      continue;
      localObject1 = "YunDong";
      continue;
      localObject1 = "GouWu";
      continue;
      localObject1 = "KongJian";
      continue;
      localObject1 = "FuJin";
      continue;
      localObject1 = "XiaoYuan";
    }
  }
  
  public static void b(int paramInt1, Map<String, String> paramMap, int paramInt2)
  {
    lcm.k localk = a().jdField_a_of_type_Lcm$k;
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localk.nm(bool);
      ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.20(paramInt1, paramMap, paramInt2));
      return;
    }
  }
  
  public static long cA()
  {
    return tD;
  }
  
  public static void ce(List<lcm.j> paramList)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.16(paramList));
  }
  
  public static long cy()
  {
    return tB;
  }
  
  public static long cz()
  {
    return tC;
  }
  
  public static int df(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 0: 
      return 2;
    case 1: 
      return 0;
    }
    return 1;
  }
  
  public static int dg(int paramInt)
  {
    int i = 0;
    if (paramInt == MainFragment.bIk) {
      i = 1;
    }
    do
    {
      return i;
      if (paramInt == MainFragment.bIm) {
        return 2;
      }
      if (paramInt == MainFragment.bIq) {
        return 3;
      }
    } while (paramInt != MainFragment.bIn);
    return 4;
  }
  
  private static boolean dz(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    QLog.d("ReadinjoySPEventReport", 2, "canReport : eventID " + paramInt);
    long l1 = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    AppRuntime localAppRuntime;
    do
    {
      do
      {
        return false;
        long l2 = ty;
        if (((SPEventReportSwitch.BM()) && (l1 - l2 >= SPEventReportSwitch.ov() * 1000)) || (SPEventReportSwitch.dB(paramInt))) {}
        for (bool1 = true;; bool1 = false) {
          return bool1;
        }
        return SPEventReportSwitch.dB(paramInt);
        return SPEventReportSwitch.dB(paramInt);
        return SPEventReportSwitch.dB(paramInt);
      } while (((!SPEventReportSwitch.BM()) || (l1 - tz < SPEventReportSwitch.ow() * 1000) || (aNn > 1)) && (!SPEventReportSwitch.dB(paramInt)));
      return true;
      if (Calendar.getInstance().get(5) != aNo) {}
      for (int i = 1; (i != 0) || ((SPEventReportSwitch.BM()) && (SPEventReportSwitch.dB(paramInt))); i = 0) {
        return true;
      }
      return true;
      try
      {
        Pair localPair = awit.u();
        paramInt = (int)(Long.valueOf(kxm.getAccount()).longValue() % 100L);
        if ((localPair != null) && (paramInt >= ((Integer)localPair.first).intValue()))
        {
          i = ((Integer)localPair.second).intValue();
          if (paramInt > i) {}
        }
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        return SPEventReportSwitch.dB(paramInt);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      if (NetConnInfoCenter.getServerTime() - tF < tA) {}
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
      localAppRuntime = kxm.getAppRuntime();
    } while ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface)) || (!BaseActivity.mAppForground) || (!SPEventReportSwitch.dB(paramInt)));
    return true;
  }
  
  public static void eu(long paramLong)
  {
    tB = paramLong;
  }
  
  private String getMmapUtilsName(String paramString)
  {
    String str = kxm.getAppRuntime().getAccount();
    return str + "_" + paramString;
  }
  
  private void init() {}
  
  private String jh()
  {
    Object localObject2 = null;
    Object localObject3 = Aladdin.getConfig(225);
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((AladdinConfig)localObject3).getString("report_app_package_list", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        localObject2 = ((AladdinConfig)localObject3).getString("report_app_name_list", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = ((String)localObject2).split("\\|");
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      if (localObject2 == null) {
        localObject2 = this.bl;
      }
      for (;;)
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = this.bm;
        }
        if (localObject2.length != localObject3.length) {
          return "";
        }
        localObject1 = new StringBuilder();
        int i = 0;
        if (i < localObject2.length)
        {
          ((StringBuilder)localObject1).append(localObject3[i]);
          ((StringBuilder)localObject1).append("_");
          String str = aqiz.O(BaseApplicationImpl.getContext(), localObject2[i]);
          if (("0".equals(str)) || (TextUtils.isEmpty(str)))
          {
            ((StringBuilder)localObject1).append("0_");
            ((StringBuilder)localObject1).append("-1");
          }
          for (;;)
          {
            if (i != localObject2.length - 1) {
              ((StringBuilder)localObject1).append("|");
            }
            i += 1;
            break;
            ((StringBuilder)localObject1).append("1_");
            ((StringBuilder)localObject1).append(str);
          }
        }
        QLog.d("ReadinjoySPEventReport", 1, "getAppInstallInfo: " + ((StringBuilder)localObject1).toString());
        return ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      localObject1 = null;
      continue;
      localObject1 = null;
      break;
      localObject1 = null;
    }
  }
  
  private String n(List<ChatMessage> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if ((paramList == null) || (paramList.isEmpty())) {
      return "";
    }
    paramList = (ChatMessage)paramList.get(paramList.size() - 1);
    if ((paramList instanceof MessageForStructing))
    {
      paramList = ((MessageForStructing)paramList).structingMsg;
      if ((paramList instanceof StructMsgForGeneralShare))
      {
        paramList = ((StructMsgForGeneralShare)paramList).mStructMsgItemLists.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (anqu)paramList.next();
          if ((localObject instanceof anqv))
          {
            localObject = a((anqv)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              if (localStringBuilder.length() > 0) {
                localStringBuilder.append("`");
              }
              localStringBuilder.append((String)localObject);
            }
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void ni(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    eu(System.currentTimeMillis());
    lcm.d.foreground();
    ReadInJoyDailyFragment.aKQ();
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.2());
  }
  
  private static void nj(boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.3(paramBoolean));
  }
  
  public static void nk(boolean paramBoolean)
  {
    if (paramBoolean) {}
    do
    {
      return;
      mgn.aPb();
      ReadInJoyDailyFragment.aKP();
    } while (lcm.d.aNy == 2);
    lcm.d.aCg();
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.12(B(cy())));
  }
  
  public static void o(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.18(paramInt2, paramInt4, paramInt3, paramInt1));
  }
  
  private static int or()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((BatteryManager)BaseApplicationImpl.getApplication().getSystemService("batterymanager")).getIntProperty(4);
    }
    Intent localIntent = new ContextWrapper(BaseApplicationImpl.getApplication().getApplicationContext()).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (localIntent.getIntExtra("level", -1) * 100 / localIntent.getIntExtra("scale", -1) != 0) {
      return localIntent.getIntExtra("scale", -1);
    }
    return 1;
  }
  
  private void qF(int paramInt)
  {
    if (dz(12))
    {
      ArrayList localArrayList = new ArrayList();
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("Type");
      localAttributeList.att_value.set(String.valueOf(paramInt));
      localArrayList.add(localAttributeList);
      ocp.y(12, localArrayList);
    }
  }
  
  public static void qH(int paramInt)
  {
    int i = 1;
    int j = 1;
    boolean bool1 = false;
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject != null) && ((localObject instanceof SplashActivity)))
    {
      localObject = (MainFragment)((SplashActivity)localObject).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
      if (localObject == null) {}
    }
    for (;;)
    {
      try
      {
        k = MainFragment.bIk;
        if (paramInt != k) {}
      }
      catch (Exception localException1)
      {
        int k;
        boolean bool2;
        i = 0;
        wja.a("onMainFragmentTabClick", "onMainFragmentTabClick", localException1);
        continue;
      }
      try
      {
        k = ((View)((MainFragment)localObject).y().get(MainFragment.aOe + "_num")).getVisibility();
        if (k != 0) {
          continue;
        }
        bool1 = true;
        i = j;
      }
      catch (Exception localException2)
      {
        continue;
        bool1 = false;
        i = 0;
        continue;
      }
      if (i != 0) {
        X(i, bool1);
      }
      if (paramInt != MainFragment.bIq) {
        mgn.aPb();
      }
      return;
      bool1 = false;
      i = j;
      continue;
      i = MainFragment.bIm;
      if (paramInt == i)
      {
        j = 2;
        i = j;
        bool2 = ((MainFragment)localObject).a(MainFragment.aOf).aux();
        bool1 = bool2;
        i = j;
      }
      else
      {
        i = MainFragment.bIq;
        if (paramInt == i)
        {
          j = 3;
          i = j;
          bool2 = ((MainFragment)localObject).a(MainFragment.aOh).aux();
          bool1 = bool2;
          i = j;
        }
        else
        {
          i = MainFragment.bIn;
          if (paramInt == i)
          {
            j = 4;
            i = j;
            bool2 = ((MainFragment)localObject).a(MainFragment.aOg).aux();
            bool1 = bool2;
            i = j;
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }
  
  public static void qI(int paramInt)
  {
    Object localObject = roq.getDateString();
    if (TextUtils.equals((CharSequence)localObject, (String)awit.f("dau_report_type_" + paramInt, "")))
    {
      QLog.d("ReadinjoySPEventReport", 2, "has report dau for type today, type :" + paramInt);
      return;
    }
    awit.H("dau_report_type_" + paramInt, localObject);
    localObject = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
    ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("Type");
    ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(paramInt + "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    ocp.y(94, localArrayList);
  }
  
  public void A(String paramString, long paramLong)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.11(this, paramString, paramLong));
  }
  
  public void V(int paramInt, boolean paramBoolean) {}
  
  public void W(int paramInt, boolean paramBoolean)
  {
    this.aey = as(paramInt);
    this.ajc = paramBoolean;
    this.clickTime = System.currentTimeMillis();
    lcm.d.qJ(2);
  }
  
  public lcm.c a()
  {
    lcm.c localc = this.jdField_a_of_type_Lcm$c;
    this.jdField_a_of_type_Lcm$c = null;
    return localc;
  }
  
  public void a(int paramInt1, List paramList, String paramString, int paramInt2, int paramInt3)
  {
    njm.tJ(2);
    if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3000) || (dA(paramInt2)))
    {
      if (paramInt1 == 1) {
        aJV();
      }
      for (;;)
      {
        ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.6(this, paramInt1, paramList));
        return;
        a(paramInt2, paramInt3, paramList);
      }
    }
    if (paramInt1 == 1)
    {
      aJW();
      return;
    }
    a().A(paramString, cA());
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    try
    {
      if ("2909288299".equals(paramString)) {
        na("GetNextMsg");
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoySPEventReport", 2, "reportPubAioMenuAction", paramString);
    }
  }
  
  public void a(String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3)
  {
    try
    {
      oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(1);
      localAttributeList1.att_name.set("ActType");
      localAttributeList1.att_value.set(paramString1);
      oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(2);
      localAttributeList2.att_name.set("HasRedPnt");
      Object localObject2 = localAttributeList2.att_value;
      if (paramBoolean) {}
      for (Object localObject1 = "1";; localObject1 = "0")
      {
        ((PBStringField)localObject2).set((String)localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("Time");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(B(paramLong)));
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(4);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("Exposures");
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(paramString2);
        paramString2 = new oidb_cmd0x80a.AttributeList();
        paramString2.att_id.set(5);
        paramString2.att_name.set("Clicks");
        paramString2.att_value.set(paramString3);
        paramString3 = new ArrayList(3);
        paramString3.add(localAttributeList1);
        paramString3.add(localAttributeList2);
        paramString3.add(localObject1);
        paramString3.add(localObject2);
        paramString3.add(paramString2);
        ocp.y(3, paramString3);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction actType:" + paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", paramString1);
      }
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean, List<ChatMessage> paramList)
  {
    a(paramString, paramLong, paramBoolean, paramList, true);
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean1, List<ChatMessage> paramList, boolean paramBoolean2)
  {
    if ("2909288299".equals(paramString))
    {
      a("Enter", paramLong, paramBoolean1, n(paramList), this.u.toString());
      this.u.setLength(0);
      if (paramBoolean2) {
        lcm.d.aKh();
      }
    }
  }
  
  public void a(String paramString, anqu paramanqu)
  {
    if ("2909288299".equals(paramString))
    {
      na("ClickMsg");
      if ((paramanqu != null) && ((paramanqu instanceof anqv)))
      {
        paramString = a((anqv)paramanqu);
        if (!TextUtils.isEmpty(paramString))
        {
          if (this.u.length() > 0) {
            this.u.append("`");
          }
          this.u.append(paramString);
        }
      }
    }
  }
  
  public void aJS()
  {
    ThreadManager.post(new ReadinjoySPEventReport.1(this), 8, null, true);
  }
  
  public void aJT()
  {
    try
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      int i = ((QQAppInterface)localObject1).b().bl();
      boolean bool = kxm.f((QQAppInterface)localObject1);
      oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
      localAttributeList1.att_id.set(1);
      localAttributeList1.att_name.set("UnreadMsg");
      localAttributeList1.att_value.set(String.valueOf(i));
      oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
      localAttributeList2.att_id.set(2);
      localAttributeList2.att_name.set("KDInScreen");
      Object localObject2 = localAttributeList2.att_value;
      if (bool) {}
      for (localObject1 = "1";; localObject1 = "0")
      {
        ((PBStringField)localObject2).set((String)localObject1);
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(3);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("FoldStatus");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(kxm.aMw + "");
        localObject2 = new ArrayList(3);
        ((List)localObject2).add(localAttributeList1);
        ((List)localObject2).add(localAttributeList2);
        ((List)localObject2).add(localObject1);
        ocp.y(1, (List)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg unRead:" + i + " isFirst:" + bool);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportManualRefresMsg", localException);
      }
    }
  }
  
  public void aJU()
  {
    ng(true);
  }
  
  public void aKb()
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.7(this));
    this.aji = true;
  }
  
  public void ag(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      this.aey = paramString;
    }
    this.ajc = paramBoolean;
    this.clickTime = System.currentTimeMillis();
    lcm.d.qJ(2);
  }
  
  public long cB()
  {
    return tx;
  }
  
  public boolean dA(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
      if (paramInt >= 1000)
      {
        bool1 = bool2;
        if (paramInt <= 1034) {
          bool1 = true;
        }
      }
      break;
    }
    return bool1;
  }
  
  public ArrayList<oidb_cmd0x80a.AttributeList> j(int paramInt)
  {
    lcm.b localb = new lcm.b(null);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.sProcessId != 1) {
      return localArrayList;
    }
    int k = 0;
    int j = 0;
    int i = k;
    if (localQQAppInterface != null)
    {
      i = k;
      if (localQQAppInterface.isLogin())
      {
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(0);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("UnreadMsg");
        localObject2 = localQQAppInterface.b();
        i = j;
        if (localObject2 != null) {
          i = ((QQMessageFacade)localObject2).bl();
        }
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(i));
        localArrayList.add(localObject1);
      }
    }
    Object localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(100);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("FolderStatus");
    ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(kxm.aMw));
    localArrayList.add(localObject1);
    Object localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(101);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("KDInScreen");
    Object localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
    if (kxm.f(localQQAppInterface)) {}
    for (localObject1 = String.valueOf(1);; localObject1 = String.valueOf(0))
    {
      ((PBStringField)localObject3).set((String)localObject1);
      localArrayList.add(localObject2);
      localObject1 = ocp.li();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(102);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("KDAttrL");
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
        localArrayList.add(localObject2);
      }
      localObject1 = new StringBuilder(1024);
      if (this.hi.size() <= 0) {
        break label448;
      }
      localObject2 = new ArrayList(this.hi);
      j = 0;
      while (j < ((ArrayList)localObject2).size())
      {
        localObject3 = (Pair)((ArrayList)localObject2).get(j);
        if (j != 0) {
          ((StringBuilder)localObject1).append("`");
        }
        ((StringBuilder)localObject1).append(String.valueOf(((Pair)localObject3).first));
        if (j != 0) {
          ((StringBuilder)localObject1).append(":").append(String.valueOf(((Pair)localObject3).second));
        }
        j += 1;
      }
    }
    this.hi.clear();
    label448:
    localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(103);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("LeftBtmRedPntPulse");
    ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((StringBuilder)localObject1).toString());
    localArrayList.add(localObject2);
    ((StringBuilder)localObject1).setLength(0);
    ((StringBuilder)localObject1).trimToSize();
    if (this.hj.size() > 0)
    {
      localObject2 = new ArrayList(this.hj);
      j = 0;
      while (j < ((ArrayList)localObject2).size())
      {
        localObject3 = (Pair)((ArrayList)localObject2).get(j);
        if (j != 0) {
          ((StringBuilder)localObject1).append("`");
        }
        ((StringBuilder)localObject1).append(String.valueOf(((Pair)localObject3).first));
        if (j != 0) {
          ((StringBuilder)localObject1).append(":").append(String.valueOf(((Pair)localObject3).second));
        }
        j += 1;
      }
      this.hj.clear();
    }
    localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(104);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FirstScnRedPntPulse");
    ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((StringBuilder)localObject1).toString());
    localArrayList.add(localObject2);
    ((StringBuilder)localObject1).setLength(0);
    ((StringBuilder)localObject1).trimToSize();
    if (this.hk.size() > 0)
    {
      localObject2 = new ArrayList(this.hk);
      j = 0;
      while (j < ((ArrayList)localObject2).size())
      {
        localObject3 = (Pair)((ArrayList)localObject2).get(j);
        if (j != 0) {
          ((StringBuilder)localObject1).append("`");
        }
        ((StringBuilder)localObject1).append(String.valueOf(((Pair)localObject3).first));
        if (j != 0) {
          ((StringBuilder)localObject1).append(":").append(String.valueOf(((Pair)localObject3).second));
        }
        j += 1;
      }
      this.hk.clear();
    }
    localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(105);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("AIOPulse");
    ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set(((StringBuilder)localObject1).toString());
    localArrayList.add(localObject2);
    localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(106);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("LastRedExposureTime");
    ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(kxm.ta + ":" + kxm.aMw);
    localArrayList.add(localObject1);
    localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(107);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("dt_red");
    localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
    long l;
    if (BL())
    {
      localObject1 = String.valueOf(1);
      ((PBStringField)localObject3).set((String)localObject1);
      localArrayList.add(localObject2);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(108);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("last_inforeground_time");
      if (cy() <= 0L) {
        break label1334;
      }
      l = cy();
      label1032:
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(l / 1000L));
      localArrayList.add(localObject1);
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(109);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("last_in_aio_time");
      ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(cz()));
      localArrayList.add(localObject1);
      localObject1 = a().a();
      if (localObject1 != null)
      {
        ((lcm.c)localObject1).b.att_id.set(110);
        localArrayList.add(((lcm.c)localObject1).b);
      }
      localObject1 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(112);
      ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("UniversalStateBit");
      localObject2 = ((oidb_cmd0x80a.AttributeList)localObject1).att_value;
      if (!ocp.GC()) {
        break label1342;
      }
    }
    label1334:
    label1342:
    for (j = 1;; j = 0)
    {
      ((PBStringField)localObject2).set(String.valueOf(j));
      localArrayList.add(localObject1);
      k = ocp.aS(acbn.blO);
      localObject3 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(113);
      ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("subscribe_folderstatus");
      localObject1 = kvv.iM();
      if (paramInt != 70) {
        break label1347;
      }
      j = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (j >= localArrayList.size()) {
          break;
        }
        if (((oidb_cmd0x80a.AttributeList)localArrayList.get(j)).att_id.get() == 2)
        {
          localObject1 = ((oidb_cmd0x80a.AttributeList)localArrayList.get(j)).att_value.get();
          QLog.d("PublicAccountUtil", 2, "replace common kandianSubscribe forderStatus with business value !");
        }
        j += 1;
      }
      localObject1 = String.valueOf(0);
      break;
      l = System.currentTimeMillis();
      break label1032;
    }
    label1347:
    localObject2 = localObject1;
    ((oidb_cmd0x80a.AttributeList)localObject3).att_value.set((String)localObject2);
    localArrayList.add(localObject3);
    localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(114);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("subscribe_msgbox_pos");
    ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(k));
    localArrayList.add(localObject1);
    localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(115);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("subscribe_in_screen");
    localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
    if ((k >= 0) && (k + 1 <= kxm.aMt)) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      ((PBStringField)localObject3).set((String)localObject1);
      localArrayList.add(localObject2);
      localObject1 = rpc.al(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(116);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("wifiName");
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1 + "");
        localArrayList.add(localObject2);
      }
      localObject1 = kvs.iL();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1721;
      }
      localObject3 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject3).att_id.set(117);
      ((oidb_cmd0x80a.AttributeList)localObject3).att_name.set("daily_folderstatus");
      if (paramInt != 90) {
        break;
      }
      paramInt = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (paramInt >= localArrayList.size()) {
          break;
        }
        if (((oidb_cmd0x80a.AttributeList)localArrayList.get(paramInt)).att_id.get() == 2)
        {
          localObject1 = ((oidb_cmd0x80a.AttributeList)localArrayList.get(paramInt)).att_value.get();
          QLog.d("PublicAccountUtil", 2, "replace common kandianDaily forderStatus with business value !");
        }
        paramInt += 1;
      }
    }
    localObject2 = localObject1;
    ((oidb_cmd0x80a.AttributeList)localObject3).att_value.set((String)localObject2);
    localArrayList.add(localObject3);
    label1721:
    paramInt = kvs.nL();
    localObject1 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(118);
    ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("daily_msgbox_pos");
    ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(String.valueOf(paramInt));
    localArrayList.add(localObject1);
    localObject2 = new oidb_cmd0x80a.AttributeList();
    ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(119);
    ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("daily_in_screen");
    localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
    if ((paramInt >= 0) && (paramInt + 1 <= kxm.aMt))
    {
      localObject1 = "1";
      ((PBStringField)localObject3).set((String)localObject1);
      localArrayList.add(localObject2);
      boolean bool = SettingCloneUtil.readValue(BaseApplicationImpl.getContext(), kxm.getAccount(), "", "qqsetting_notify_showcontent_key", true);
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(120);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("PushPreviewQ");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if (!bool) {
        break label2642;
      }
      localObject1 = "1";
      label1909:
      ((PBStringField)localObject3).set((String)localObject1);
      localArrayList.add(localObject2);
      bool = FriendsStatusUtil.bc(BaseApplicationImpl.getApplication());
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(121);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("NoDisturbAtNight");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if (!bool) {
        break label2650;
      }
      localObject1 = "1";
      label1979:
      ((PBStringField)localObject3).set((String)localObject1);
      localArrayList.add(localObject2);
      paramInt = awit.at((QQAppInterface)kxm.getAppRuntime());
      if (paramInt != -1)
      {
        localObject1 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(122);
        ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("DongTaiKandian");
        ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set(paramInt + "");
        localArrayList.add(localObject1);
      }
      localObject1 = aqgz.getBSSID(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new oidb_cmd0x80a.AttributeList();
        ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(123);
        ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("BSSID");
        ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
        localArrayList.add(localObject2);
      }
      paramInt = lcm.h.ot();
      localObject2 = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(124);
      ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("MsgListFristDataIsVisable");
      localObject3 = ((oidb_cmd0x80a.AttributeList)localObject2).att_value;
      if (paramInt != 0) {
        break label2658;
      }
      localObject1 = "1";
      label2188:
      ((PBStringField)localObject3).set((String)localObject1);
      localArrayList.add(localObject2);
      localObject1 = aqgz.getDeviceOSVersion();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).equals("5")) || (((String)localObject1).equals("5.0")) || (((String)localObject1).compareTo("5.0.0") >= 0)))
      {
        localObject1 = ReadInJoyMMapKvStorage.getInstance(getMmapUtilsName("80aEvent"));
        localObject2 = ((ReadInJoyMMapKvStorage)localObject1).getValeForKey("content");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if ((((ReadInJoyMMapKvStorage)localObject1).getExpiredTime() == 0) || (((ReadInJoyMMapKvStorage)localObject1).getExpiredTime() >= System.currentTimeMillis() / 1000L)) {
            break label2666;
          }
          ((ReadInJoyMMapKvStorage)localObject1).invalidate();
        }
      }
      label2309:
      localObject1 = new StringBuilder().append(i).append("_");
      if (kxm.aMw != 1) {
        break label2682;
      }
      paramInt = 0;
      label2337:
      localObject2 = ((StringBuilder)localObject1).append(paramInt).append("_");
      if (!BL()) {
        break label2687;
      }
      localObject1 = String.valueOf(1);
      label2363:
      localObject2 = (String)localObject1;
      localObject3 = localb.a(126, "ScreenInfo", kxm.be(-1));
      if (!anlm.Vr()) {
        break label2696;
      }
      localObject1 = "1";
      label2402:
      localObject2 = ((lcm.b)localObject3).a(128, "is_jcjj_mode", (String)localObject1).a(129, "network", lhf.getNetType() + "").a(130, "battery", or() + "").a(131, "sessionID", tG / 1000L + "").a(132, "redDot", (String)localObject2).a(133, "app_install_list", jh());
      if (!anwa.aze()) {
        break label2704;
      }
      localObject1 = "1";
      label2546:
      ((lcm.b)localObject2).a(134, "is_study_mode", (String)localObject1);
      localObject1 = ((KandianMergeManager)localQQAppInterface.getManager(162)).a();
      if (localObject1 == null) {
        break label2712;
      }
    }
    label2696:
    label2704:
    label2712:
    for (localObject1 = ((KandianMsgBoxRedPntInfo)localObject1).mMsgCnt + "";; localObject1 = "0")
    {
      localb.a(135, "kdTabNumRed", (String)localObject1);
      localArrayList.addAll(localb.build());
      return localArrayList;
      localObject1 = "0";
      break;
      label2642:
      localObject1 = "0";
      break label1909;
      label2650:
      localObject1 = "0";
      break label1979;
      label2658:
      localObject1 = "0";
      break label2188;
      label2666:
      localb.a(127, "FeatureFrameworkAttr", (String)localObject2);
      break label2309;
      label2682:
      paramInt = 1;
      break label2337;
      label2687:
      localObject1 = String.valueOf(0);
      break label2363;
      localObject1 = "0";
      break label2402;
      localObject1 = "0";
      break label2546;
    }
  }
  
  public void mZ(String paramString)
  {
    if ("2909288299".equals(paramString)) {
      lcm.d.qJ(3);
    }
  }
  
  public void na(String paramString)
  {
    try
    {
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(1);
      localAttributeList.att_name.set("ActType");
      localAttributeList.att_value.set(paramString);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localAttributeList);
      ocp.y(3, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction actType:" + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoySPEventReport", 2, "reportQQNewsAction", paramString);
    }
  }
  
  public void ng(boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.aey))
    {
      odv.e(this.aey, this.ajc, this.clickTime);
      if (paramBoolean)
      {
        this.aey = "";
        lcm.d.aKh();
      }
    }
  }
  
  public void nh(boolean paramBoolean)
  {
    ajd = paramBoolean;
  }
  
  public void qE(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadinjoySPEventReport.5(this, paramInt));
  }
  
  public void qG(int paramInt)
  {
    this.handler.removeCallbacks(this.cE);
    this.handler.postDelayed(this.cE, paramInt * 1000);
  }
  
  class a
    implements Comparable<a>
  {
    public int aNw;
    public String aez = "nil";
    public boolean ajl;
    public boolean ajm;
    public long articleID;
    public long exposureTime;
    public float jk;
    public long seq;
    public String title;
    
    private a() {}
    
    public int a(a parama)
    {
      if (parama.seq > this.seq) {
        return 1;
      }
      if (parama.seq == this.seq) {
        return 0;
      }
      return -1;
    }
    
    @NonNull
    public String toString()
    {
      int j = 1;
      StringBuilder localStringBuilder = new StringBuilder().append(this.articleID).append("_").append(this.aNw).append("_").append(this.exposureTime).append("_").append(String.format("%.2f", new Object[] { Float.valueOf(this.jk) })).append("_");
      if (this.ajl)
      {
        i = 1;
        localStringBuilder = localStringBuilder.append(i).append("_");
        if (!this.ajm) {
          break label128;
        }
      }
      label128:
      for (int i = j;; i = 0)
      {
        return i + "_" + this.aez;
        i = 0;
        break;
      }
    }
  }
  
  class b
  {
    private List<oidb_cmd0x80a.AttributeList> ho = new ArrayList();
    
    private b() {}
    
    public b a(int paramInt, String paramString1, String paramString2)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        QLog.d("CommonAttrBulder", 1, "attr value is Empty ! id : " + paramInt + ", name : " + paramString1);
        return this;
      }
      oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(paramInt);
      localAttributeList.att_name.set(paramString1);
      localAttributeList.att_value.set(paramString2);
      this.ho.add(localAttributeList);
      return this;
    }
    
    public List<oidb_cmd0x80a.AttributeList> build()
    {
      return this.ho;
    }
  }
  
  public class c
  {
    public oidb_cmd0x80a.AttributeList a;
    public oidb_cmd0x80a.AttributeList b;
    public oidb_cmd0x80a.AttributeList c;
    public oidb_cmd0x80a.AttributeList d;
    
    public c() {}
  }
  
  public static class d
  {
    private static int aNx = -1;
    public static int aNy;
    private static Map<Integer, lcm.e> eh = new ConcurrentHashMap();
    private static List<lcm.e> hp = new ArrayList();
    public static long tJ;
    public static long tK;
    public static long tL;
    public static long tM;
    
    static
    {
      aNy = 2;
      init();
    }
    
    public static void a(lcm.e parame)
    {
      if (parame == null) {}
      for (;;)
      {
        return;
        try
        {
          if (hp.contains(parame)) {
            continue;
          }
          hp.add(parame);
        }
        finally {}
      }
    }
    
    public static void aCg()
    {
      try
      {
        aNy = 2;
        if (isNeedReport())
        {
          localObject1 = (lcm.e)eh.get(Integer.valueOf(aNx));
          if (localObject1 != null) {
            ((lcm.e)localObject1).aCg();
          }
        }
        Object localObject1 = hp.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          lcm.e locale = (lcm.e)((Iterator)localObject1).next();
          if (locale != null) {
            locale.aCg();
          }
        }
      }
      finally {}
    }
    
    public static void aKh()
    {
      aNx = -1;
    }
    
    public static void b(lcm.e parame)
    {
      if (parame != null) {}
      try
      {
        hp.remove(parame);
        return;
      }
      finally
      {
        parame = finally;
        throw parame;
      }
    }
    
    public static void foreground()
    {
      try
      {
        aNy = 1;
        lcm.D(System.currentTimeMillis());
        if (isNeedReport())
        {
          localObject1 = (lcm.e)eh.get(Integer.valueOf(aNx));
          if (localObject1 != null) {
            ((lcm.e)localObject1).foreground();
          }
        }
        Object localObject1 = hp.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          lcm.e locale = (lcm.e)((Iterator)localObject1).next();
          if (locale != null) {
            locale.foreground();
          }
        }
      }
      finally {}
    }
    
    private static void init()
    {
      eh.put(Integer.valueOf(2), new lcn());
      eh.put(Integer.valueOf(3), new lco());
      eh.put(Integer.valueOf(25), new lcp());
      eh.put(Integer.valueOf(4), new lcq());
    }
    
    private static boolean isNeedReport()
    {
      if (aNx > 0) {}
      switch (aNx)
      {
      default: 
        return false;
      }
      return true;
    }
    
    public static void qJ(int paramInt)
    {
      aNx = paramInt;
      switch (paramInt)
      {
      default: 
        return;
      case 2: 
        tJ = System.currentTimeMillis();
        return;
      case 3: 
        tK = System.currentTimeMillis();
        return;
      case 25: 
        tL = System.currentTimeMillis();
        return;
      }
      tM = System.currentTimeMillis();
    }
  }
  
  public static abstract interface e
  {
    public abstract void aCg();
    
    public abstract void foreground();
  }
  
  class f
  {
    public long exposureTime;
    public ArrayList<Pair<BaseArticleInfo, Float>> kt = new ArrayList();
    public long time;
    
    private f() {}
    
    public ArrayList<Long> bd()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.kt.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Long.valueOf(((BaseArticleInfo)((Pair)localIterator.next()).first).mArticleID));
      }
      return localArrayList;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("screenInfo : \n");
      Iterator localIterator = this.kt.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        localStringBuilder.append("【").append(((BaseArticleInfo)localPair.first).mTitle).append("】");
      }
      return localStringBuilder.toString();
    }
  }
  
  static class g
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {}
      do
      {
        return;
        if (paramIntent.getAction().equals("android.intent.action.SCREEN_OFF"))
        {
          QLog.d("ReadinjoySPEventReport", 2, "receive screen off broadcast");
          lcm.nl(false);
          return;
        }
        if (paramIntent.getAction().equals("android.intent.action.SCREEN_ON"))
        {
          QLog.d("ReadinjoySPEventReport", 2, "receive screen on broadcast");
          lcm.nl(true);
          return;
        }
        if ("mqq.intent.action.QQ_FOREGROUND".equals(paramIntent.getAction()))
        {
          lcm.ni(false);
          lcm.access$1000();
          return;
        }
      } while (!"mqq.intent.action.QQ_BACKGROUND".equals(paramIntent.getAction()));
      lcm.nk(false);
      lcm.access$1000();
    }
  }
  
  public static class h
  {
    static int aNA;
    static int aNz = -1;
    static int endIndex = -1;
    static long endTime;
    static long startTime;
    
    static void e(AbsListView paramAbsListView)
    {
      lcm.j localj = new lcm.j();
      int i = paramAbsListView.getLastVisiblePosition();
      int j = ((ListAdapter)paramAbsListView.getAdapter()).getCount();
      localj.direction = getDirection();
      localj.distance = Math.abs(endIndex - aNz);
      localj.tO = (endTime - startTime);
      localj.aNB = (j - i);
      localj.tP = endTime;
      localj.count = j;
      lcm.i.a(localj);
    }
    
    static int getDirection()
    {
      if (aNz > endIndex) {
        return 0;
      }
      return 1;
    }
    
    private static void h(AbsListView paramAbsListView, int paramInt)
    {
      if (paramInt != 0) {
        return;
      }
      aNA = paramAbsListView.getFirstVisiblePosition() - ((ListView)paramAbsListView).getHeaderViewsCount();
      if (aNA < 0) {
        aNA = 0;
      }
      QLog.d("ReadinjoySPEventReport", 2, new Object[] { "[onScrollStateChanged] record firstItemPos : ", Integer.valueOf(aNA) });
    }
    
    public static void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramAbsListView == null) || (paramAbsListView.getChildCount() == 0) || (paramAbsListView.getAdapter() == null)) {}
      do
      {
        do
        {
          return;
          h(paramAbsListView, paramInt);
        } while ((lcm.i.tN < 0L) || (lcm.i.duringTime < 0L));
        switch (paramInt)
        {
        default: 
          return;
        }
      } while ((endIndex >= 0) || (endTime >= 0L));
      endIndex = paramAbsListView.getFirstVisiblePosition();
      endTime = NetConnInfoCenter.getServerTimeMillis();
      e(paramAbsListView);
      return;
      aNz = paramAbsListView.getFirstVisiblePosition();
      startTime = NetConnInfoCenter.getServerTimeMillis();
      endIndex = -1;
      endTime = -1L;
    }
    
    public static int ot()
    {
      return aNA;
    }
  }
  
  public static class i
  {
    public static long duringTime = -1L;
    public static List<lcm.j> hq = new ArrayList();
    public static long scrollTime;
    public static long tN = -1L;
    
    public static void a(lcm.j paramj)
    {
      if (!hq.isEmpty())
      {
        lcm.j localj = (lcm.j)hq.get(hq.size() - 1);
        if (paramj.tP - localj.tP > tN) {
          aKi();
        }
      }
      hq.add(paramj);
      scrollTime += paramj.tO;
      if (isNeedReport())
      {
        paramj = new ArrayList();
        paramj.addAll(hq);
        hq.clear();
        lcm.ce(paramj);
      }
    }
    
    public static void aKi()
    {
      hq.clear();
      scrollTime = 0L;
    }
    
    public static boolean isNeedReport()
    {
      return scrollTime > duringTime;
    }
  }
  
  public static class j
  {
    public int aNB;
    int aNC;
    int aND;
    int aNE;
    int aNF;
    int aNG;
    float[] an;
    float[] ao;
    public int count;
    public int direction;
    public int distance;
    public long tO;
    long tP;
    
    public String ji()
    {
      double d1 = this.aNE * 1.0D / this.aNF;
      double d2 = 1000.0D * d1 / this.tO;
      double d3 = this.an[0] / this.aNG;
      double d4 = this.an[1] / this.aNF;
      double d5 = this.ao[0] / this.aNG;
      double d6 = this.ao[1] / this.aNF;
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.direction == 1) {}
      for (int i = 0;; i = 1) {
        return i + "_" + String.format("%.2f", new Object[] { Double.valueOf(d1) }) + "_" + String.format("%.2f", new Object[] { Double.valueOf(d2) }) + "_" + String.format("%.2f", new Object[] { Double.valueOf(d4) }) + "_" + String.format("%.2f", new Object[] { Double.valueOf(d3) }) + "_" + String.format("%.2f", new Object[] { Double.valueOf(d6) }) + "_" + String.format("%.2f", new Object[] { Double.valueOf(d5) });
      }
    }
  }
  
  public class k
    implements AbsListView.e
  {
    private lcm.f a;
    public int aNH;
    private int aNI;
    private int aNJ;
    private int aNK;
    private SparseArray<Integer> aa = new SparseArray();
    public boolean ajn;
    private lcm.f b;
    private HashMap<Long, lcm.a> dE = new HashMap();
    private HashMap<Long, Float> dF = new HashMap();
    public long enterTime;
    private ArrayList<lcm.j> ku = new ArrayList();
    public ArrayList<Long> kv = new ArrayList();
    public ArrayList<Long> kw = new ArrayList();
    private int maxHeight;
    private int maxIndex;
    public long tQ;
    public long tR;
    public long tS;
    public long tT;
    
    public k() {}
    
    private Object a(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramAbsListView == null) || (paramInt < 0) || (paramAbsListView.getAdapter() == null)) {}
      do
      {
        return null;
        paramAbsListView = paramAbsListView.getAdapter();
      } while (paramInt >= paramAbsListView.getCount());
      try
      {
        paramAbsListView = paramAbsListView.getItem(paramInt);
        return paramAbsListView;
      }
      catch (Exception paramAbsListView)
      {
        paramAbsListView.printStackTrace();
      }
      return null;
    }
    
    private lcm.f a(AbsListView paramAbsListView)
    {
      if ((paramAbsListView == null) || (paramAbsListView.getChildCount() <= 0)) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int k = paramAbsListView.getFirstVisiblePosition();
      int i = 0;
      if (i < paramAbsListView.getChildCount())
      {
        Object localObject = a(paramAbsListView, k + i);
        if (((localObject instanceof AdvertisementInfo)) || (!(localObject instanceof BaseArticleInfo))) {}
        label173:
        label187:
        for (;;)
        {
          i += 1;
          break;
          View localView = paramAbsListView.getChildAt(i);
          if (localView.getHeight() > 0)
          {
            int j;
            if (localView.getBottom() > paramAbsListView.getHeight())
            {
              j = paramAbsListView.getHeight();
              label105:
              if (localView.getTop() <= 0) {
                break label173;
              }
            }
            for (float f = (j - localView.getTop()) * 1.0F / localView.getHeight();; f = j * 1.0F / localView.getHeight())
            {
              if (f <= 0.0F) {
                break label187;
              }
              localArrayList.add(new Pair((BaseArticleInfo)localObject, Float.valueOf(f)));
              break;
              j = localView.getBottom();
              break label105;
            }
          }
        }
      }
      paramAbsListView = new lcm.f(lcm.this, null);
      paramAbsListView.kt = localArrayList;
      paramAbsListView.time = System.currentTimeMillis();
      if (this.a == null) {}
      for (long l = System.currentTimeMillis() - this.enterTime;; l = System.currentTimeMillis() - this.a.time)
      {
        paramAbsListView.exposureTime = l;
        this.a = paramAbsListView;
        QLog.d("ReadinjoySPEventReport", 2, new Object[] { paramAbsListView });
        return paramAbsListView;
      }
    }
    
    private lcm.j a(AbsListView paramAbsListView)
    {
      lcm.j localj = new lcm.j();
      localj.aNC = this.aNI;
      localj.aND = this.maxIndex;
      if (this.maxHeight - this.aNK > 0) {}
      for (int i = this.maxHeight - this.aNK;; i = 0)
      {
        localj.aNE = i;
        localj.direction = this.aNJ;
        localj.tO = (this.tS - this.tR);
        localj.aNF = this.aNK;
        localj.aNG = paramAbsListView.getWidth();
        localj.an = ((float[])((ReadInJoyXListView)paramAbsListView).aq.clone());
        localj.ao = ((float[])((ReadInJoyXListView)paramAbsListView).ar.clone());
        return localj;
      }
    }
    
    private void aKk()
    {
      this.maxHeight = 0;
      this.aNI = -1;
      this.maxIndex = -1;
    }
    
    /* Error */
    public void a(int paramInt, AbsListView paramAbsListView)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new 236	java/lang/StringBuilder
      //   5: dup
      //   6: new 236	java/lang/StringBuilder
      //   9: dup
      //   10: invokespecial 237	java/lang/StringBuilder:<init>	()V
      //   13: ldc 239
      //   15: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   18: iload_1
      //   19: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   22: ldc 248
      //   24: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   27: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   30: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   33: astore 5
      //   35: aload_2
      //   36: ifnull +21 -> 57
      //   39: aload_2
      //   40: invokevirtual 98	com/tencent/widget/AbsListView:getChildCount	()I
      //   43: ifle +14 -> 57
      //   46: aload_0
      //   47: getfield 159	lcm$k:enterTime	J
      //   50: lstore_3
      //   51: lload_3
      //   52: lconst_0
      //   53: lcmp
      //   54: ifne +6 -> 60
      //   57: aload_0
      //   58: monitorexit
      //   59: return
      //   60: aload_0
      //   61: getfield 64	lcm$k:kv	Ljava/util/ArrayList;
      //   64: invokevirtual 258	java/util/ArrayList:size	()I
      //   67: ifle +12 -> 79
      //   70: aload_0
      //   71: getfield 260	lcm$k:aNH	I
      //   74: iload_1
      //   75: iand
      //   76: ifne -19 -> 57
      //   79: iload_1
      //   80: iconst_2
      //   81: iand
      //   82: ifeq +15 -> 97
      //   85: aload_0
      //   86: getfield 262	lcm$k:ajn	Z
      //   89: ifeq -32 -> 57
      //   92: aload_0
      //   93: iconst_0
      //   94: putfield 262	lcm$k:ajn	Z
      //   97: aload_0
      //   98: aload_0
      //   99: getfield 260	lcm$k:aNH	I
      //   102: iload_1
      //   103: ior
      //   104: putfield 260	lcm$k:aNH	I
      //   107: aload_0
      //   108: aload_2
      //   109: invokespecial 264	lcm$k:a	(Lcom/tencent/widget/AbsListView;)Llcm$f;
      //   112: astore_2
      //   113: aload_2
      //   114: ifnull -57 -> 57
      //   117: aload_0
      //   118: aload_2
      //   119: invokevirtual 267	lcm$k:a	(Llcm$f;)V
      //   122: aload_0
      //   123: aload_2
      //   124: invokevirtual 271	lcm$f:bd	()Ljava/util/ArrayList;
      //   127: putfield 64	lcm$k:kv	Ljava/util/ArrayList;
      //   130: ldc 164
      //   132: iconst_2
      //   133: iconst_1
      //   134: anewarray 4	java/lang/Object
      //   137: dup
      //   138: iconst_0
      //   139: aload 5
      //   141: aload_2
      //   142: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   145: aastore
      //   146: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
      //   149: goto -92 -> 57
      //   152: astore_2
      //   153: aload_0
      //   154: monitorexit
      //   155: aload_2
      //   156: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	157	0	this	k
      //   0	157	1	paramInt	int
      //   0	157	2	paramAbsListView	AbsListView
      //   50	2	3	l	long
      //   33	107	5	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   2	35	152	finally
      //   39	51	152	finally
      //   60	79	152	finally
      //   85	97	152	finally
      //   97	113	152	finally
      //   117	149	152	finally
    }
    
    public void a(View paramView, AbsListView paramAbsListView, BaseArticleInfo paramBaseArticleInfo)
    {
      if ((paramView == null) || (paramBaseArticleInfo == null) || (paramAbsListView == null)) {
        return;
      }
      float f1 = paramView.getHeight() / 2.0F;
      float f2 = paramView.getTop();
      float f3 = paramAbsListView.getHeight();
      this.dF.put(Long.valueOf(paramBaseArticleInfo.mArticleID), Float.valueOf((f1 + f2) / f3));
    }
    
    public void a(lcm.f paramf)
    {
      if ((paramf == null) || (this.enterTime == 0L)) {
        return;
      }
      Iterator localIterator = paramf.kt.iterator();
      label23:
      Object localObject;
      long l1;
      float f;
      long l2;
      if (localIterator.hasNext())
      {
        localObject = (Pair)localIterator.next();
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Pair)localObject).first;
        l1 = paramf.exposureTime;
        f = ((Float)((Pair)localObject).second).floatValue();
        lcm.a locala = (lcm.a)this.dE.get(Long.valueOf(localBaseArticleInfo.mArticleID));
        localObject = locala;
        if (locala == null)
        {
          localObject = new lcm.a(lcm.this, null);
          ((lcm.a)localObject).seq = localBaseArticleInfo.mRecommendSeq;
          ((lcm.a)localObject).articleID = localBaseArticleInfo.mArticleID;
          ((lcm.a)localObject).title = localBaseArticleInfo.mTitle;
          this.dE.put(Long.valueOf(localBaseArticleInfo.mArticleID), localObject);
        }
        l2 = ((lcm.a)localObject).exposureTime;
        if (f <= 0.8F) {
          break label204;
        }
      }
      for (;;)
      {
        ((lcm.a)localObject).exposureTime = (l1 + l2);
        ((lcm.a)localObject).jk = Math.max(((lcm.a)localObject).jk, f);
        break label23;
        break;
        label204:
        l1 = 0L;
      }
    }
    
    public void aKj()
    {
      this.aa.clear();
    }
    
    public String jj()
    {
      Object localObject = new ArrayList(this.dE.values());
      Collections.sort((List)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localStringBuilder.append((lcm.a)((Iterator)localObject).next()).append("|");
      }
      if (localStringBuilder.length() == 0) {
        return "nil";
      }
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    
    public String jk()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < this.ku.size())
      {
        localStringBuilder.append(((lcm.j)this.ku.get(i)).ji()).append("|");
        i += 1;
      }
      if (localStringBuilder.length() == 0) {
        return "nil";
      }
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    
    public void nm(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        if (this.enterTime != 0L) {}
        for (long l = this.enterTime;; l = System.currentTimeMillis())
        {
          this.enterTime = l;
          return;
        }
      }
      this.tT = System.currentTimeMillis();
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      label70:
      StringBuilder localStringBuilder;
      label96:
      Long localLong;
      lcm.a locala;
      if (this.a != null)
      {
        localArrayList1 = this.a.bd();
        if (this.b == null) {
          break label267;
        }
        localArrayList2 = this.b.bd();
        localStringBuilder = new StringBuilder("exposure info : \n");
        Iterator localIterator = this.dE.keySet().iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localLong = (Long)localIterator.next();
          locala = (lcm.a)this.dE.get(localLong);
        } while (locala == null);
        locala.aNw = 1;
        if (!this.kv.contains(localLong)) {
          break label273;
        }
      }
      for (locala.aNw = 0;; locala.aNw = 2) {
        label267:
        label273:
        do
        {
          if (this.kw.contains(localLong)) {
            locala.ajl = true;
          }
          if ((localArrayList2 != null) && (localArrayList2.contains(localLong))) {
            locala.ajm = true;
          }
          if (this.dF.containsKey(localLong)) {
            locala.aez = String.format("%.2f", new Object[] { this.dF.get(localLong) });
          }
          localStringBuilder.append(locala.toString()).append("\n");
          break label96;
          localArrayList1 = null;
          break;
          localArrayList2 = null;
          break label70;
        } while ((localArrayList1 == null) || (!localArrayList1.contains(localLong)));
      }
      QLog.d("ReadinjoySPEventReport", 2, localStringBuilder.toString());
      lcm.this.b = this;
      lcm.this.a = new k(lcm.this);
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramInt3 = paramInt1 + paramInt2 - 1;
      int i = paramAbsListView.getChildCount();
      if (this.aNI == -1)
      {
        this.aNI = (paramInt1 + 1);
        this.maxIndex = paramInt1;
      }
      int j;
      int k;
      View localView;
      if (paramInt1 < this.aNI)
      {
        this.aNJ = 1;
        j = this.aNI;
        paramInt2 = 0;
        if ((paramInt2 < i) && (paramInt2 < j - paramInt1))
        {
          k = paramInt1 + paramInt2;
          if (this.aa.get(k) != null)
          {
            int m = this.maxHeight;
            this.maxHeight = (((Integer)this.aa.get(k)).intValue() + m);
          }
          for (;;)
          {
            paramInt2 += 1;
            break;
            localView = paramAbsListView.getChildAt(paramInt2);
            if (localView != null)
            {
              this.aa.put(k, Integer.valueOf(localView.getHeight()));
              this.maxHeight += localView.getHeight();
            }
          }
        }
        this.aNI = paramInt1;
      }
      if (paramInt3 > this.maxIndex)
      {
        this.aNJ = 0;
        paramInt2 = this.maxIndex;
        paramInt1 = i - 1;
        if (i - 1 - paramInt1 < paramInt3 - paramInt2)
        {
          j = paramInt3 - (i - 1 - paramInt1);
          if (this.aa.get(j) != null)
          {
            k = this.maxHeight;
            this.maxHeight = (((Integer)this.aa.get(j)).intValue() + k);
          }
          for (;;)
          {
            paramInt1 -= 1;
            break;
            localView = paramAbsListView.getChildAt(paramInt1);
            if (localView != null)
            {
              this.aa.put(j, Integer.valueOf(localView.getHeight()));
              this.maxHeight += localView.getHeight();
            }
          }
        }
        this.maxIndex = paramInt3;
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (paramAbsListView == null) {
        return;
      }
      lcm.j localj;
      int i;
      switch (paramInt)
      {
      case 2: 
      case 3: 
      case 4: 
      default: 
        return;
      case 0: 
        this.tS = System.currentTimeMillis();
        localj = a(paramAbsListView);
        this.ku.add(localj);
        this.a = a(paramAbsListView);
        if ((paramAbsListView instanceof ReadInJoyXListView))
        {
          i = ((ReadInJoyXListView)paramAbsListView).aYI;
          int j = ((ReadInJoyXListView)paramAbsListView).aYJ;
          paramInt = Math.min(i, j);
          i = Math.max(i, j);
          this.kw.clear();
          QLog.d("ReadinjoySPEventReport", 2, "finger touch min :" + paramInt + ", max : " + i);
        }
      case 1: 
        while ((paramInt <= i) && (paramInt < paramAbsListView.getCount()))
        {
          Object localObject = a(paramAbsListView, paramInt);
          if (((localObject instanceof ArticleInfo)) && (!(localObject instanceof AdvertisementInfo))) {
            this.kw.add(Long.valueOf(((ArticleInfo)localObject).mArticleID));
          }
          paramInt += 1;
          continue;
          aKk();
          this.tR = System.currentTimeMillis();
          this.aNK = paramAbsListView.getHeight();
          if (this.tQ == 0L) {
            this.tQ = this.tR;
          }
          this.a = a(paramAbsListView);
          this.b = this.a;
          a(this.a);
          return;
        }
        QLog.d("ReadinjoySPEventReport", 2, "one scroll " + localj.ji());
        return;
      }
      this.a = a(paramAbsListView);
      a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcm
 * JD-Core Version:    0.7.0.1
 */