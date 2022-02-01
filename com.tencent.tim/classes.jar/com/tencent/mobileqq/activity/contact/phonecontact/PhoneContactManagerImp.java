package com.tencent.mobileqq.activity.contact.phonecontact;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RecommendedContactInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import abdz.b;
import acff;
import acfp;
import ajdo;
import ajdo.a;
import akwk;
import akwl;
import akwm;
import akwn;
import alla;
import alld;
import anaz;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.StaleDataException;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import anot;
import auri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ThemeNoviceGuideActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.selectmember.ContactsInnerFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactBinded;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.LastLoginPhoneInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.mobileqq.data.PhoneNumInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import friendlist.GetOnlineInfoResp;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mobileqq.data.PhoneContact;>;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import yuh;
import yui;
import yuj;
import yuk;
import yul;
import yum;
import yun;
import yuo;
import yup;
import yuq;
import yur;
import yus;
import yuu;
import yuw;

public class PhoneContactManagerImp
  implements ajdo
{
  public static volatile long KA = 120000L;
  static volatile long KB;
  static volatile long KC;
  public static int RESULT_FAIL = 2;
  public static int RESULT_OK;
  public static boolean boN;
  private static final String[] cT = { "data1", "display_name", "contact_id", "data2", "data3" };
  public static int cbg = 20;
  private SharedPreferences A;
  private LinkedList<ajdo.a> D = new LinkedList();
  public volatile long KD = 0L;
  public volatile long KE = 0L;
  public volatile long KF = 0L;
  public long KG;
  private long KH;
  private long KI;
  public abdz.b a;
  private akwk jdField_a_of_type_Akwk;
  private akwm jdField_a_of_type_Akwm = new yuq(this);
  private UploadProgressGenerator jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$b;
  private yuw jdField_a_of_type_Yuw;
  private JSONObject aX;
  private volatile boolean aZC;
  private String aZJ;
  private Boolean af;
  private QQAppInterface app;
  private akwl jdField_b_of_type_Akwl = new yuo(this);
  private ContactBinded jdField_b_of_type_ComTencentMobileqqDataContactBinded;
  private Object bU = new Object();
  public volatile boolean boI = true;
  public volatile boolean boJ = false;
  public volatile boolean boK = false;
  volatile boolean boL;
  public boolean boM;
  private boolean boO;
  private volatile boolean boP;
  public boolean boQ = false;
  private boolean boR;
  private boolean boS;
  private volatile Set<String> bx = new HashSet();
  public volatile int cbf = -1;
  public volatile int cbh;
  private int cbi = -1;
  private final int cbj;
  private ConcurrentHashMap<String, String> dd = new ConcurrentHashMap();
  private ConcurrentHashMap<String, String> de = new ConcurrentHashMap();
  private ConcurrentHashMap<String, PhoneContact> df = new ConcurrentHashMap();
  private ConcurrentHashMap<String, PhoneContact> dg = new ConcurrentHashMap();
  private ConcurrentHashMap<String, PhoneContact> dh = new ConcurrentHashMap();
  private ConcurrentHashMap<String, PhoneContact> di = new ConcurrentHashMap();
  private ConcurrentHashMap<String, PhoneContact> dj;
  private Runnable eL = new PhoneContactManagerImp.6(this);
  private Runnable eM = new PhoneContactManagerImp.9(this);
  private EntityManager em;
  private boolean isPhoneSwitched;
  private final Random mRandom;
  public SharedPreferences pref;
  private ArrayList<ContactMatch> rn;
  private ArrayList<PhoneContactAdd> ro;
  private byte[] sessionId;
  private List<MobileContactsFriendInfo> tf;
  private List<MobileContactsNotFriendInfo> tg;
  private List<String> th;
  private List<PhoneContact> ti;
  private List<PhoneContact> tj;
  private volatile List<PhoneContact> tk;
  public volatile List<PhoneContact> tl;
  List<PhoneContact> tm = new ArrayList();
  private List<PhoneContact> tn;
  private List<PhoneContact> to;
  private List<PhoneContact> tp;
  private List<NotBindContactNotFriendInfo> tq;
  private List<NotBindContactFriendInfo> tr;
  private SharedPreferences z;
  
  public PhoneContactManagerImp(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.A = this.app.getApp().getSharedPreferences("sp_new_friend", 0);
    this.pref = this.app.getApp().getSharedPreferences("contact_bind_info" + this.app.getAccount(), 0);
    this.z = this.app.getApp().getSharedPreferences("contact_bind_info_global", 0);
    this.sessionId = this.pref.getString("session_id", "").getBytes();
    this.KD = this.pref.getLong("contact_last_query_list_time", 0L);
    this.KH = this.pref.getLong("last_unbind_mobile_time", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("init [%s, %s]", new Object[] { Long.valueOf(this.KD), Long.valueOf(this.KH) }));
    }
    clQ();
    this.cbf = a(a());
    this.em = this.app.a().createEntityManager();
    this.app.registObserver(this.jdField_b_of_type_Akwl);
    this.app.addObserver(this.jdField_a_of_type_Akwm);
    this.mRandom = new Random(SystemClock.elapsedRealtime());
    paramQQAppInterface = this.app.getApplication().getResources().getDisplayMetrics();
    if (Math.min(paramQQAppInterface.widthPixels, paramQQAppInterface.heightPixels) >= 1080) {}
    for (int i = 5;; i = 4)
    {
      this.cbj = i;
      ThreadManager.excute(new PhoneContactManagerImp.1(this), 16, null, false);
      return;
    }
  }
  
  private void AL(boolean paramBoolean)
  {
    List localList = cV();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "pushRecommendUnreadCount: beAdded = " + paramBoolean + ", unreadCount = " + localList.size());
    }
    y(paramBoolean, localList);
    if (this.app != null) {
      this.app.cLO();
    }
  }
  
  private void AM(boolean paramBoolean)
  {
    if (this.aZC) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new PhoneContactManagerImp.16(this, paramBoolean));
  }
  
  private void AN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dh.clear();
      this.dg.clear();
    }
    if (this.dj == null) {
      this.dj = new ConcurrentHashMap();
    }
    this.dj.putAll(this.df);
  }
  
  private void AO(boolean paramBoolean)
  {
    if (this.dj != null)
    {
      if (!this.dj.isEmpty())
      {
        EntityTransaction localEntityTransaction = this.em.getTransaction();
        try
        {
          localEntityTransaction.begin();
          Iterator localIterator = this.dj.values().iterator();
          while (localIterator.hasNext())
          {
            PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
            c(localPhoneContact, paramBoolean);
            this.em.update(localPhoneContact);
          }
          this.dj.clear();
        }
        finally
        {
          localEntityTransaction.end();
        }
        localEntityTransaction.commit();
        localEntityTransaction.end();
      }
      this.dj = null;
    }
  }
  
  private void AQ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("queryShowBindPhonePage fromNotBind=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      this.boS = paramBoolean;
      if (this.jdField_a_of_type_Akwk == null) {
        this.jdField_a_of_type_Akwk = ((akwk)this.app.getBusinessHandler(134));
      }
      anot.a(this.app, "dc00898", "", "", "0X80095EE", "0X80095EE", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Akwk.NL(this.app.getCurrentUin());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneContact.Manager", 1, "queryShowBindPhonePage fail.", localException);
    }
  }
  
  private void AR(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("setShowBindPhonePageResult success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    try
    {
      if (this.jdField_a_of_type_Akwk == null) {
        this.jdField_a_of_type_Akwk = ((akwk)this.app.getBusinessHandler(134));
      }
      this.jdField_a_of_type_Akwk.cF(this.app.getCurrentUin(), paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PhoneContact.Manager", 1, "setShowBindPhonePageResult fail.", localException);
    }
  }
  
  private void EE(int paramInt)
  {
    if (this.aZC) {
      return;
    }
    if ((paramInt & 0x1) != 0)
    {
      this.tj = null;
      this.ti = null;
      this.tn = null;
      this.tp = null;
      MqqHandler localMqqHandler = this.app.getHandler(ContactListView.class);
      if (localMqqHandler != null)
      {
        localMqqHandler.removeMessages(1);
        localMqqHandler.sendEmptyMessageDelayed(1, 100L);
      }
      localMqqHandler = this.app.getHandler(ContactsInnerFrame.class);
      if (localMqqHandler != null)
      {
        localMqqHandler.removeMessages(3);
        localMqqHandler.sendEmptyMessageDelayed(3, 100L);
      }
    }
    this.tk = null;
    this.tl = null;
    this.app.runOnUiThread(new PhoneContactManagerImp.7(this, paramInt));
  }
  
  private void EF(int paramInt)
  {
    if (this.aZC) {
      return;
    }
    this.app.runOnUiThread(new PhoneContactManagerImp.11(this, paramInt));
  }
  
  private void F(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, String.format("saveUploadDataForNewGuide [%s, %s, %s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      }
      if (this.aX == null) {
        this.aX = new JSONObject();
      }
      this.aX.put("state", paramInt1);
      if (paramInt2 > 0) {
        this.aX.put("total", paramInt2);
      }
      this.aX.put("curPer", paramInt3);
      this.aX.put("expPer", paramInt4);
      LoginUserGuideHelper.p(this.app.getAccount(), this.aX);
      if ((paramInt1 == 3) || (paramInt1 == 4))
      {
        this.boR = false;
        this.aX = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean Up()
  {
    if (!"3.4.4".equals(this.pref.getString("last_phone_version_popped_notbind", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "poppedForThisVersionNotBind result = " + bool);
      }
      return bool;
    }
  }
  
  private boolean Uq()
  {
    if (!"3.4.4".equals(this.pref.getString("last_phone_version_popped", ""))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "isPhoneContactFirstRun result = " + bool);
      }
      return bool;
    }
  }
  
  private void W(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("saveContactListTimeStamp, [%s,%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    this.pref.edit().putLong("queryContactTimeStamp", paramLong1).putLong("queryRichInfoTimeStamp", paramLong2).apply();
  }
  
  private int a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    if (paramRespondQueryQQBindingStat == null) {}
    do
    {
      return 0;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, String.format("getSelfBindState [%s, %s]", new Object[] { pS(), paramRespondQueryQQBindingStat }));
      }
      if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.mobileNo))
      {
        if (TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
          return 1;
        }
        if (pS().equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
          return 2;
        }
        return 3;
      }
      if ((paramRespondQueryQQBindingStat.originBinder == 2L) || (paramRespondQueryQQBindingStat.originBinder == 3L)) {
        return 5;
      }
    } while (paramRespondQueryQQBindingStat.originBinder != 1L);
    if (paramRespondQueryQQBindingStat.MobileUniqueNo.equals("init padding")) {
      paramRespondQueryQQBindingStat.MobileUniqueNo = null;
    }
    if ((TextUtils.isEmpty(paramRespondQueryQQBindingStat.MobileUniqueNo)) || (paramRespondQueryQQBindingStat.isStopFindMatch)) {
      return 7;
    }
    if (pS().equalsIgnoreCase(paramRespondQueryQQBindingStat.MobileUniqueNo)) {
      return 9;
    }
    return 6;
  }
  
  private void a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat)
  {
    int i = this.cbf;
    int j = a(paramRespondQueryQQBindingStat);
    switch (j)
    {
    }
    for (;;)
    {
      if (this.cbf == 0) {
        this.cbf = j;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "syncBindState newState = " + j + " lastState=" + i + " curState=" + this.cbf);
      }
      if (i != this.cbf) {
        clM();
      }
      return;
      if (this.cbf != j)
      {
        clT();
        this.pref.edit().putBoolean("key_show_contact_banner", true).commit();
      }
      if ((j != 1) || (this.cbf != 4))
      {
        this.cbf = j;
        continue;
        if (paramRespondQueryQQBindingStat.lastUsedFlag == 3L) {
          clT();
        }
        this.cbf = j;
        continue;
        if (this.cbf != 8)
        {
          if (this.cbf != j) {
            clT();
          }
          this.cbf = j;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("PhoneContact", 2, "cur state is uploading");
          continue;
          this.cbf = j;
          continue;
          this.cbf = j;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Resources paramResources, ImageView paramImageView)
  {
    if ((paramQQAppInterface == null) || (paramResources == null) || (paramImageView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("loadIconAsync [%s, %s, %s]", new Object[] { paramQQAppInterface, paramResources, paramImageView }));
      }
      return;
    }
    ThreadManager.excute(new PhoneContactManagerImp.24(paramResources, paramQQAppInterface, paramImageView), 16, null, true);
  }
  
  private boolean a(String paramString, ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    if ((paramString == null) || ((paramArrayList1 == null) && (paramArrayList2 == null)))
    {
      this.boK = false;
      return false;
    }
    int j;
    label39:
    int k;
    label47:
    NewIntent localNewIntent;
    if (QLog.isColorLevel())
    {
      if (paramArrayList1 == null)
      {
        i = 0;
        if (paramArrayList2 != null) {
          break label238;
        }
        j = 0;
        if (paramArrayList != null) {
          break label247;
        }
        k = 0;
        QLog.d("PhoneContact.Manager", 2, String.format("doUpdateContact bind:%s, add:%s, del:%s, rename:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      }
    }
    else
    {
      localNewIntent = new NewIntent(this.app.getApplication(), akwn.class);
      if (!paramBoolean) {
        break label257;
      }
    }
    label257:
    for (int i = 15;; i = 38)
    {
      localNewIntent.putExtra("req_type", i);
      localNewIntent.putExtra("unique_phone_no", paramString);
      localNewIntent.putExtra("add_contact_list", paramArrayList1);
      localNewIntent.putExtra("del_contact_list", paramArrayList2);
      localNewIntent.putExtra("rename_contact_list", paramArrayList);
      localNewIntent.putExtra("next_flag", 0L);
      localNewIntent.putExtra("upload_package_no", 0);
      localNewIntent.putExtra("session_id", new byte[0]);
      localNewIntent.putExtra("is_resend", false);
      this.app.startServlet(localNewIntent);
      return true;
      i = paramArrayList1.size();
      break;
      label238:
      j = paramArrayList2.size();
      break label39;
      label247:
      k = paramArrayList.size();
      break label47;
    }
  }
  
  private boolean aD(boolean paramBoolean)
  {
    if (!this.app.isLogin())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, String.format("showBindPhonePage isLogin return false", new Object[0]));
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("showBindPhonePage fromNotBind=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    boolean bool2 = Uq();
    boolean bool1 = Up();
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = Math.abs(l1 - this.KH);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, String.format("showBindPhonePage [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(this.KH) }));
    }
    if (((BaseActivity.sTopActivity instanceof BindNumberActivity)) || ((BaseActivity.sTopActivity instanceof BindVerifyActivity)))
    {
      QLog.d("PhoneContact.Manager", 2, "showBindPhonePage " + BaseActivity.sTopActivity);
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        i = xy();
        localIntent = null;
        if (!paramBoolean) {
          break label1042;
        }
        if ((i != 3) || (a() == null) || (a().lastUsedFlag != 3L)) {
          break label1037;
        }
        localIntent = new Intent(this.app.getApp().getApplicationContext(), PhoneMatchActivity.class);
        localIntent.putExtra("kSrouce", 16);
        bool1 = false;
        if (!bool1) {
          break label1034;
        }
        localIntent = new Intent(this.app.getApp().getApplicationContext(), BindNumberActivity.class);
        localIntent.putExtra("kSrouce", -1);
        if (localIntent == null) {
          break label925;
        }
        if (l2 >= 3600000L) {
          break label684;
        }
        if (!QLog.isColorLevel()) {
          break label1040;
        }
        QLog.i("PhoneContact.Manager", 2, String.format("showBindPhonePage just last unbind mobile [%s, %s, %s]", new Object[] { Long.valueOf(l1), Long.valueOf(this.KH), Long.valueOf(3600000L) }));
      }
      catch (Exception localException)
      {
        Intent localIntent;
        QLog.e("PhoneContact.Manager", 1, "showBindPhonePage fail.", localException);
        return false;
      }
      if (bool2)
      {
        if (this.pref.getInt("key_bind_style", 0) == 0)
        {
          localIntent = new Intent(this.app.getApp().getApplicationContext(), BindNumberActivity.class);
          localIntent.putExtra("kSrouce", 9);
          anot.a(this.app, "CliOper", "", "", "0X8006EF7", "0X8006EF7", 0, 0, "", "", "", "");
          continue;
        }
        if (this.pref.getInt("key_bind_style", 0) == 1)
        {
          localObject1 = new Intent(this.app.getApp().getApplicationContext(), BindNumberActivity.class);
          ((Intent)localObject1).putExtra("kSrouce", 11);
          anot.a(this.app, "CliOper", "", "", "0X8006EF8", "0X8006EF8", 0, 0, "", "", "", "");
          continue;
          if ((a() != null) && (a().lastUsedFlag == 3L))
          {
            localObject1 = new Intent(this.app.getApp().getApplicationContext(), PhoneMatchActivity.class);
            continue;
            localObject1 = a();
            if ((!Ut()) && (localObject1 != null) && (!((RespondQueryQQBindingStat)localObject1).isStopFindMatch))
            {
              localObject1 = new Intent(this.app.getApp().getApplicationContext(), PhoneMatchActivity.class);
              if (bool2)
              {
                ((Intent)localObject1).putExtra("key_from_contact_first", true);
                continue;
                label684:
                String str2 = ((Intent)localObject1).getComponent().getClassName();
                String str1 = "";
                Object localObject2 = str1;
                if (!TextUtils.isEmpty(str2))
                {
                  if (!str2.equals(BindNumberActivity.class.getName())) {
                    break label835;
                  }
                  localObject2 = "0X80095EB";
                }
                for (;;)
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                    anot.a(this.app, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
                  }
                  localObject2 = BaseActivity.sTopActivity;
                  if ((localObject2 == null) || (((AppActivity)localObject2).isFinishing()) || (((AppActivity)localObject2).getAppRuntime() != this.app)) {
                    break label906;
                  }
                  ((AppActivity)localObject2).startActivity((Intent)localObject1);
                  ((AppActivity)localObject2).overridePendingTransition(2130772367, 2130772002);
                  if ((!paramBoolean) || (!bool1)) {
                    break;
                  }
                  clR();
                  break label1090;
                  label835:
                  localObject2 = str1;
                  if (str2.equals(PhoneMatchActivity.class.getName())) {
                    localObject2 = "0X80095EA";
                  }
                }
                if ((!paramBoolean) && (bool2))
                {
                  clS();
                  break label1090;
                }
                this.pref.edit().putLong("last_pop_time_for_switchphone", System.currentTimeMillis()).commit();
                break label1090;
                label906:
                if (!QLog.isColorLevel()) {
                  break label1094;
                }
                QLog.d("PhoneContact.Manager", 2, "showBindPhonePage topActivity invalid");
                break label1094;
                label925:
                if ((paramBoolean) || (!bool2)) {
                  break;
                }
                localObject1 = this.app.getPreferences();
                if ((localObject1 == null) || (((SharedPreferences)localObject1).getBoolean("THEME_NOVICE_GUIDE_RUNED", false)) || (!BaseApplicationImpl.IS_SUPPORT_THEME)) {
                  break;
                }
                ((SharedPreferences)localObject1).edit().putBoolean("THEME_NOVICE_GUIDE_RUNED", true).commit();
                localObject1 = new Intent(BaseActivity.sTopActivity, ThemeNoviceGuideActivity.class);
                BaseActivity.sTopActivity.startActivity((Intent)localObject1);
                BaseActivity.sTopActivity.overridePendingTransition(2130771991, 2130771992);
                clS();
                return false;
              }
              continue;
              label1034:
              continue;
              label1037:
              continue;
              label1040:
              return false;
              label1042:
              switch (i)
              {
              }
            }
          }
        }
      }
      Object localObject1 = null;
    }
    label1090:
    label1094:
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  private void aT(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("showToast [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(this.boM), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(this.cbf) }));
    }
    if (this.boM)
    {
      this.boM = false;
      if (this.cbf != 1) {
        if (!paramBoolean) {
          break label107;
        }
      }
    }
    label107:
    for (String str = acfp.m(2131709502); Thread.currentThread() == Looper.getMainLooper().getThread(); str = acfp.m(2131709496))
    {
      al(paramBoolean, str);
      return;
    }
    this.app.runOnUiThread(new PhoneContactManagerImp.3(this, paramBoolean, str));
  }
  
  private void al(boolean paramBoolean, String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      QQToast.a(localBaseApplication, i, paramString, 0).show(localBaseApplication.getResources().getDimensionPixelSize(2131299627));
      return;
    }
  }
  
  /* Error */
  private ArrayList<AddressBookItem> bS()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokespecial 1071	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:clJ	()V
    //   10: aload_0
    //   11: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   17: invokevirtual 1075	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   20: getstatic 1081	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   23: getstatic 142	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cT	[Ljava/lang/String;
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokestatic 1087	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 7
    //   34: new 215	java/util/ArrayList
    //   37: dup
    //   38: invokespecial 216	java/util/ArrayList:<init>	()V
    //   41: astore 12
    //   43: aload 7
    //   45: ifnull +780 -> 825
    //   48: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   51: lstore_3
    //   52: aload 7
    //   54: invokeinterface 1092 1 0
    //   59: istore_1
    //   60: aload 12
    //   62: iload_1
    //   63: invokevirtual 1095	java/util/ArrayList:ensureCapacity	(I)V
    //   66: new 167	java/util/concurrent/ConcurrentHashMap
    //   69: dup
    //   70: iload_1
    //   71: invokespecial 1097	java/util/concurrent/ConcurrentHashMap:<init>	(I)V
    //   74: astore 13
    //   76: aload 8
    //   78: astore 6
    //   80: aload 9
    //   82: astore 5
    //   84: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +38 -> 125
    //   90: aload 8
    //   92: astore 6
    //   94: aload 9
    //   96: astore 5
    //   98: ldc_w 297
    //   101: iconst_2
    //   102: new 243	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 1099
    //   112: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload_1
    //   116: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aload 8
    //   127: astore 6
    //   129: aload 9
    //   131: astore 5
    //   133: aload_0
    //   134: getfield 333	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   137: invokevirtual 465	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   140: astore 8
    //   142: aload 8
    //   144: astore 6
    //   146: aload 8
    //   148: astore 5
    //   150: aload 8
    //   152: invokevirtual 470	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   155: aload 8
    //   157: astore 6
    //   159: aload 8
    //   161: astore 5
    //   163: aload 7
    //   165: invokeinterface 1102 1 0
    //   170: pop
    //   171: aload 8
    //   173: astore 6
    //   175: aload 8
    //   177: astore 5
    //   179: aload 7
    //   181: invokeinterface 1105 1 0
    //   186: ifne +601 -> 787
    //   189: aload 8
    //   191: astore 6
    //   193: aload 8
    //   195: astore 5
    //   197: aload 7
    //   199: aload 7
    //   201: ldc 132
    //   203: invokeinterface 1109 2 0
    //   208: invokeinterface 1111 2 0
    //   213: invokestatic 1117	yui:hN	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 10
    //   218: aload 8
    //   220: astore 6
    //   222: aload 8
    //   224: astore 5
    //   226: aload 7
    //   228: aload 7
    //   230: ldc 134
    //   232: invokeinterface 1109 2 0
    //   237: invokeinterface 1111 2 0
    //   242: astore 11
    //   244: aload 11
    //   246: astore 9
    //   248: aload 8
    //   250: astore 6
    //   252: aload 8
    //   254: astore 5
    //   256: aload 11
    //   258: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   261: ifeq +7 -> 268
    //   264: aload 10
    //   266: astore 9
    //   268: aload 8
    //   270: astore 6
    //   272: aload 8
    //   274: astore 5
    //   276: aload 7
    //   278: aload 7
    //   280: ldc 136
    //   282: invokeinterface 1109 2 0
    //   287: invokeinterface 1119 2 0
    //   292: istore_1
    //   293: aload 8
    //   295: astore 6
    //   297: aload 8
    //   299: astore 5
    //   301: aload 7
    //   303: aload 7
    //   305: ldc 138
    //   307: invokeinterface 1109 2 0
    //   312: invokeinterface 1119 2 0
    //   317: istore_2
    //   318: aload 8
    //   320: astore 6
    //   322: aload 8
    //   324: astore 5
    //   326: aload 7
    //   328: aload 7
    //   330: ldc 140
    //   332: invokeinterface 1109 2 0
    //   337: invokeinterface 1111 2 0
    //   342: astore 11
    //   344: aload 8
    //   346: astore 6
    //   348: aload 8
    //   350: astore 5
    //   352: aload 10
    //   354: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifne +19 -> 376
    //   360: aload 8
    //   362: astore 6
    //   364: aload 8
    //   366: astore 5
    //   368: aload 9
    //   370: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   373: ifeq +148 -> 521
    //   376: aload 8
    //   378: astore 6
    //   380: aload 8
    //   382: astore 5
    //   384: aload 7
    //   386: invokeinterface 1122 1 0
    //   391: pop
    //   392: goto -221 -> 171
    //   395: astore 8
    //   397: aload 6
    //   399: astore 5
    //   401: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +19 -> 423
    //   407: aload 6
    //   409: astore 5
    //   411: ldc_w 297
    //   414: iconst_2
    //   415: ldc_w 267
    //   418: aload 8
    //   420: invokestatic 1124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   423: aload 6
    //   425: ifnull +8 -> 433
    //   428: aload 6
    //   430: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   433: aload 7
    //   435: invokeinterface 1127 1 0
    //   440: aload_0
    //   441: aload 13
    //   443: invokespecial 1130	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:d	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   446: aload_0
    //   447: getfield 192	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:df	Ljava/util/concurrent/ConcurrentHashMap;
    //   450: invokevirtual 474	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   453: invokeinterface 480 1 0
    //   458: astore 5
    //   460: aload 5
    //   462: invokeinterface 485 1 0
    //   467: ifeq +358 -> 825
    //   470: aload 5
    //   472: invokeinterface 489 1 0
    //   477: checkcast 491	com/tencent/mobileqq/data/PhoneContact
    //   480: astore 6
    //   482: aload 12
    //   484: new 1132	SecurityAccountServer/AddressBookItem
    //   487: dup
    //   488: aload 6
    //   490: getfield 1133	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   493: aload 6
    //   495: getfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   498: invokespecial 1139	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   504: pop
    //   505: goto -45 -> 460
    //   508: astore 5
    //   510: aload 5
    //   512: invokevirtual 1143	java/lang/Exception:printStackTrace	()V
    //   515: aconst_null
    //   516: astore 7
    //   518: goto -484 -> 34
    //   521: aload 8
    //   523: astore 6
    //   525: aload 8
    //   527: astore 5
    //   529: new 491	com/tencent/mobileqq/data/PhoneContact
    //   532: dup
    //   533: invokespecial 1144	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   536: astore 14
    //   538: aload 8
    //   540: astore 6
    //   542: aload 8
    //   544: astore 5
    //   546: aload 14
    //   548: aload 10
    //   550: putfield 1133	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   553: aload 8
    //   555: astore 6
    //   557: aload 8
    //   559: astore 5
    //   561: aload 14
    //   563: aload 9
    //   565: putfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   568: aload 8
    //   570: astore 6
    //   572: aload 8
    //   574: astore 5
    //   576: aload 14
    //   578: iload_1
    //   579: putfield 1147	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   582: aload 8
    //   584: astore 6
    //   586: aload 8
    //   588: astore 5
    //   590: aload 14
    //   592: iload_2
    //   593: putfield 1150	com/tencent/mobileqq/data/PhoneContact:type	I
    //   596: aload 8
    //   598: astore 6
    //   600: aload 8
    //   602: astore 5
    //   604: aload 14
    //   606: aload 11
    //   608: putfield 1153	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   611: aload 8
    //   613: astore 6
    //   615: aload 8
    //   617: astore 5
    //   619: aload 14
    //   621: lload_3
    //   622: putfield 1156	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   625: aload 8
    //   627: astore 6
    //   629: aload 8
    //   631: astore 5
    //   633: aload 14
    //   635: aload 9
    //   637: iconst_1
    //   638: invokestatic 1162	com/tencent/mobileqq/utils/ChnToSpell:aJ	(Ljava/lang/String;I)Ljava/lang/String;
    //   641: putfield 1165	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   644: aload 8
    //   646: astore 6
    //   648: aload 8
    //   650: astore 5
    //   652: aload 14
    //   654: aload 9
    //   656: iconst_2
    //   657: invokestatic 1162	com/tencent/mobileqq/utils/ChnToSpell:aJ	(Ljava/lang/String;I)Ljava/lang/String;
    //   660: putfield 1168	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   663: aload 8
    //   665: astore 6
    //   667: aload 8
    //   669: astore 5
    //   671: aload 14
    //   673: aload 14
    //   675: getfield 1168	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   678: invokestatic 1171	yui:hO	(Ljava/lang/String;)Ljava/lang/String;
    //   681: putfield 1174	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   684: aload 8
    //   686: astore 6
    //   688: aload 8
    //   690: astore 5
    //   692: aload 14
    //   694: aload 9
    //   696: aload 10
    //   698: invokestatic 1177	yui:az	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   701: putfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   704: aload 8
    //   706: astore 6
    //   708: aload 8
    //   710: astore 5
    //   712: aload 13
    //   714: aload 10
    //   716: aload 14
    //   718: invokevirtual 1183	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   721: pop
    //   722: aload 8
    //   724: astore 6
    //   726: aload 8
    //   728: astore 5
    //   730: aload_0
    //   731: getfield 198	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:di	Ljava/util/concurrent/ConcurrentHashMap;
    //   734: aload 14
    //   736: getfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   739: aload 14
    //   741: invokevirtual 1183	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   744: pop
    //   745: aload 8
    //   747: astore 6
    //   749: aload 8
    //   751: astore 5
    //   753: aload_0
    //   754: getfield 333	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   757: aload 14
    //   759: invokevirtual 1187	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   762: goto -386 -> 376
    //   765: astore 6
    //   767: aload 5
    //   769: ifnull +8 -> 777
    //   772: aload 5
    //   774: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   777: aload 7
    //   779: invokeinterface 1127 1 0
    //   784: aload 6
    //   786: athrow
    //   787: aload 8
    //   789: astore 6
    //   791: aload 8
    //   793: astore 5
    //   795: aload 8
    //   797: invokevirtual 505	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   800: aload 8
    //   802: ifnull +8 -> 810
    //   805: aload 8
    //   807: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   810: aload 7
    //   812: invokeinterface 1127 1 0
    //   817: goto -377 -> 440
    //   820: astore 5
    //   822: goto -382 -> 440
    //   825: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq +34 -> 862
    //   831: ldc_w 297
    //   834: iconst_2
    //   835: new 243	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 1189
    //   845: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: aload 12
    //   850: invokevirtual 854	java/util/ArrayList:size	()I
    //   853: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   859: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   862: aload_0
    //   863: iconst_1
    //   864: putfield 1191	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boL	Z
    //   867: aload 12
    //   869: areturn
    //   870: astore 5
    //   872: goto -432 -> 440
    //   875: astore 5
    //   877: goto -93 -> 784
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	880	0	this	PhoneContactManagerImp
    //   59	520	1	i	int
    //   317	276	2	j	int
    //   51	571	3	l	long
    //   82	389	5	localObject1	Object
    //   508	3	5	localException1	Exception
    //   527	267	5	localStaleDataException1	StaleDataException
    //   820	1	5	localException2	Exception
    //   870	1	5	localException3	Exception
    //   875	1	5	localException4	Exception
    //   78	670	6	localObject2	Object
    //   765	20	6	localObject3	Object
    //   789	1	6	localStaleDataException2	StaleDataException
    //   32	779	7	localCursor	Cursor
    //   4	377	8	localEntityTransaction	EntityTransaction
    //   395	411	8	localStaleDataException3	StaleDataException
    //   1	694	9	localObject4	Object
    //   216	499	10	str1	String
    //   242	365	11	str2	String
    //   41	827	12	localArrayList	ArrayList
    //   74	639	13	localConcurrentHashMap	ConcurrentHashMap
    //   536	222	14	localPhoneContact	PhoneContact
    // Exception table:
    //   from	to	target	type
    //   84	90	395	android/database/StaleDataException
    //   98	125	395	android/database/StaleDataException
    //   133	142	395	android/database/StaleDataException
    //   150	155	395	android/database/StaleDataException
    //   163	171	395	android/database/StaleDataException
    //   179	189	395	android/database/StaleDataException
    //   197	218	395	android/database/StaleDataException
    //   226	244	395	android/database/StaleDataException
    //   256	264	395	android/database/StaleDataException
    //   276	293	395	android/database/StaleDataException
    //   301	318	395	android/database/StaleDataException
    //   326	344	395	android/database/StaleDataException
    //   352	360	395	android/database/StaleDataException
    //   368	376	395	android/database/StaleDataException
    //   384	392	395	android/database/StaleDataException
    //   529	538	395	android/database/StaleDataException
    //   546	553	395	android/database/StaleDataException
    //   561	568	395	android/database/StaleDataException
    //   576	582	395	android/database/StaleDataException
    //   590	596	395	android/database/StaleDataException
    //   604	611	395	android/database/StaleDataException
    //   619	625	395	android/database/StaleDataException
    //   633	644	395	android/database/StaleDataException
    //   652	663	395	android/database/StaleDataException
    //   671	684	395	android/database/StaleDataException
    //   692	704	395	android/database/StaleDataException
    //   712	722	395	android/database/StaleDataException
    //   730	745	395	android/database/StaleDataException
    //   753	762	395	android/database/StaleDataException
    //   795	800	395	android/database/StaleDataException
    //   10	34	508	java/lang/Exception
    //   84	90	765	finally
    //   98	125	765	finally
    //   133	142	765	finally
    //   150	155	765	finally
    //   163	171	765	finally
    //   179	189	765	finally
    //   197	218	765	finally
    //   226	244	765	finally
    //   256	264	765	finally
    //   276	293	765	finally
    //   301	318	765	finally
    //   326	344	765	finally
    //   352	360	765	finally
    //   368	376	765	finally
    //   384	392	765	finally
    //   401	407	765	finally
    //   411	423	765	finally
    //   529	538	765	finally
    //   546	553	765	finally
    //   561	568	765	finally
    //   576	582	765	finally
    //   590	596	765	finally
    //   604	611	765	finally
    //   619	625	765	finally
    //   633	644	765	finally
    //   652	663	765	finally
    //   671	684	765	finally
    //   692	704	765	finally
    //   712	722	765	finally
    //   730	745	765	finally
    //   753	762	765	finally
    //   795	800	765	finally
    //   810	817	820	java/lang/Exception
    //   433	440	870	java/lang/Exception
    //   777	784	875	java/lang/Exception
  }
  
  private String c(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramString;
    }
    paramString = paramString.getBytes();
    int j = paramString.length;
    paramArrayOfByte = s(paramArrayOfByte);
    paramString = s(paramString);
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramString[i] ^ paramArrayOfByte[i]));
      i += 1;
    }
    j = paramArrayOfByte.length;
    i = j - 1;
    if (i >= 0) {
      if (paramArrayOfByte[i] == 0) {}
    }
    for (;;)
    {
      if (i != j - 1)
      {
        paramString = new byte[i + 1];
        System.arraycopy(paramArrayOfByte, 0, paramString, 0, i + 1);
        paramArrayOfByte = paramString;
      }
      for (;;)
      {
        return new String(s(paramArrayOfByte));
        i -= 1;
        break;
      }
      i = 0;
    }
  }
  
  private void c(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramPhoneContact.uin))
    {
      if (!paramBoolean) {
        break label42;
      }
      paramPhoneContact.bindingDate = 0L;
      paramPhoneContact.isRecommend = 0;
      paramPhoneContact.uin = "";
      paramPhoneContact.originBinder = 0L;
      paramPhoneContact.ability = 0;
    }
    label42:
    while (!paramPhoneContact.uin.equals("0")) {
      return;
    }
    paramPhoneContact.netTypeIconId = 0;
    paramPhoneContact.detalStatusFlag = 20;
    paramPhoneContact.iTermType = 0;
    paramPhoneContact.strTermDesc = "";
    paramPhoneContact.eNetworkType = 0;
    paramPhoneContact.abilityBits = 0L;
  }
  
  private void c(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = this.app;
        boolean bool = this.aZC;
        if ((bool) || (localQQAppInterface == null)) {
          return;
        }
        ((yuu)localQQAppInterface.getManager(102)).bpb = true;
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder(200);
          ((StringBuilder)localObject2).append("doQueryContactList, from: ").append(paramLong);
          ((StringBuilder)localObject2).append(", isQueryingContact: ").append(this.boJ);
          ((StringBuilder)localObject2).append(", isUpdatingContact: ").append(this.boK);
          ((StringBuilder)localObject2).append(", mCurrentBindState: ").append(this.cbf);
          ((StringBuilder)localObject2).append(", beForce: ").append(paramBoolean1);
          ((StringBuilder)localObject2).append(", isQueryAll: ").append(paramBoolean2);
          ((StringBuilder)localObject2).append(", lastQueryTime: ").append(this.KD / 1000L);
          ((StringBuilder)localObject2).append(", currentTime: ").append(l1 / 1000L);
          ((StringBuilder)localObject2).append(", bindState: ").append(xy());
          QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject2).toString());
        }
        if ((this.boJ) || (this.cbf == 8) || (this.boK) || (this.cbf == 4)) {
          continue;
        }
        l1 = Math.abs(l1 - this.KD);
        if ((!paramBoolean1) && (l1 < KA))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList [interval:%s, limit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(KA) }));
          continue;
        }
        if (!paramBoolean1) {
          break label387;
        }
      }
      finally {}
      if ((paramLong == 3L) && (l1 < KC))
      {
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList [interval:%s, reconnectLimit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(KC) }));
        }
      }
      else
      {
        label387:
        if ((!paramBoolean1) || (paramLong != 2L) || (l1 >= KB)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, String.format("doQueryContactList [interval:%s, logInLimit:%s]", new Object[] { Long.valueOf(l1), Long.valueOf(KB) }));
        }
      }
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.eL);
    this.boJ = true;
    this.tf = null;
    this.tg = null;
    Object localObject2 = new NewIntent(localObject1.getApplication(), akwn.class);
    ((NewIntent)localObject2).putExtra("req_type", 30);
    ((NewIntent)localObject2).putExtra("next_flag", 0L);
    long l1 = this.pref.getLong("queryContactTimeStamp", 0L);
    long l2 = this.pref.getLong("queryRichInfoTimeStamp", 0L);
    int j = xx();
    ((NewIntent)localObject2).putExtra("time_stamp", l1);
    ((NewIntent)localObject2).putExtra("richinfo_time_stamp", l2);
    ((NewIntent)localObject2).putExtra("session_id", new byte[0]);
    ((NewIntent)localObject2).putExtra("unique_phone_no", pS());
    if (paramBoolean2) {}
    for (int i = 1;; i = 2)
    {
      ((NewIntent)localObject2).putExtra("force_query_list", i);
      ((NewIntent)localObject2).putExtra("param_query_from", paramLong);
      ((NewIntent)localObject2).putExtra("param_bind_state", j);
      localObject1.startServlet((NewIntent)localObject2);
      break;
    }
  }
  
  private List<PhoneContact> cW()
  {
    ArrayList localArrayList = new ArrayList(this.df.size());
    Iterator localIterator = this.df.values().iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if ("0".equals(localPhoneContact.uin)) {
        localArrayList.add(localPhoneContact);
      }
    }
    return localArrayList;
  }
  
  private List<PhoneContact> cX()
  {
    ArrayList localArrayList = new ArrayList(this.df.size());
    Iterator localIterator = this.df.values().iterator();
    while (localIterator.hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
      if (!TextUtils.isEmpty(localPhoneContact.uin)) {
        localArrayList.add(localPhoneContact);
      }
    }
    return localArrayList;
  }
  
  private void clD()
  {
    if (this.aZC) {
      return;
    }
    this.app.execute(new PhoneContactManagerImp.4(this));
  }
  
  private void clE()
  {
    if (this.aZC) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = this.app.a().createEntityManager();
    if (localObject2 != null) {
      localObject1 = ((EntityManager)localObject2).query(LastLoginPhoneInfo.class);
    }
    if (localObject1 == null) {
      localObject1 = new ArrayList(0);
    }
    for (;;)
    {
      localObject2 = new HashSet(((List)localObject1).size());
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        LastLoginPhoneInfo localLastLoginPhoneInfo = (LastLoginPhoneInfo)localIterator.next();
        if (!TextUtils.isEmpty(localLastLoginPhoneInfo.unifiedCode)) {
          ((Set)localObject2).add(localLastLoginPhoneInfo.unifiedCode);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, "initLastLoginList, load for db,size=" + ((List)localObject1).size() + ", tempSet.size=" + ((Set)localObject2).size());
      }
      this.bx = ((Set)localObject2);
      return;
    }
  }
  
  private void clF()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$b = new b(new Handler(this.app.getApp().getMainLooper()));
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$b.f(this);
      this.app.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$b);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
    }
  }
  
  private void clJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "preLoadLocalContact");
    }
    W(0L, 0L);
    this.boL = false;
    this.df.clear();
    this.dh.clear();
    this.dg.clear();
    this.di.clear();
    try
    {
      this.app.getWritableDatabase().delete(new PhoneContact().getTableName(), null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void clM()
  {
    if (this.aZC) {
      return;
    }
    this.app.runOnUiThread(new PhoneContactManagerImp.10(this));
  }
  
  private void clN()
  {
    for (;;)
    {
      synchronized (this.bU)
      {
        if ((this.cbf >= 9) && (xw() == 1))
        {
          if (this.jdField_b_of_type_ComTencentMobileqqDataContactBinded != null) {
            this.jdField_b_of_type_ComTencentMobileqqDataContactBinded = null;
          }
          if ((this.rn != null) && (this.rn.size() > 0)) {
            this.rn.clear();
          }
          EntityTransaction localEntityTransaction1 = this.em.getTransaction();
          try
          {
            localEntityTransaction1.begin();
            this.app.getWritableDatabase().delete(new ContactMatch().getTableName(), null, null);
            this.app.getWritableDatabase().delete(new ContactBinded().getTableName(), null, null);
            localEntityTransaction1.commit();
            localEntityTransaction1.end();
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend with BannerShow");
            }
            return;
          }
          finally
          {
            localObject3 = finally;
            localEntityTransaction1.end();
            throw localObject3;
          }
        }
      }
      if (this.rn != null)
      {
        EntityTransaction localEntityTransaction2 = this.em.getTransaction();
        ContactMatch localContactMatch;
        try
        {
          localEntityTransaction2.begin();
          Iterator localIterator1 = this.rn.iterator();
          while (localIterator1.hasNext())
          {
            localContactMatch = (ContactMatch)localIterator1.next();
            PhoneContact localPhoneContact = b(localContactMatch.mobileNo);
            if ((localPhoneContact == null) || ((localPhoneContact.uin != null) && (!localPhoneContact.uin.equals("0"))) || (this.rn.size() >= cbg))
            {
              localIterator1.remove();
              this.em.remove(localContactMatch);
              if (QLog.isColorLevel()) {
                QLog.d("PhoneContact.Manager", 2, new Object[] { "removeIllegalRecommend remove ContactMatch = ", localContactMatch.mobileNo });
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label396;
          }
        }
        finally
        {
          localEntityTransaction2.end();
        }
        Iterator localIterator2 = this.rn.iterator();
        while (localIterator2.hasNext())
        {
          localContactMatch = (ContactMatch)localIterator2.next();
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend|mobileNo : " + localContactMatch.mobileNo + "|size : " + this.rn.size());
        }
        label396:
        localEntityTransaction2.commit();
        localEntityTransaction2.end();
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "removeIllegalRecommend mContactMatchsize = " + this.rn.size());
        }
      }
    }
  }
  
  /* Error */
  private void clP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +77 -> 82
    //   8: new 243	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 1253	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc_w 1421
    //   22: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 161	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boK	Z
    //   29: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: ldc_w 1423
    //   37: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   44: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 1425
    //   52: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 163	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:KF	J
    //   62: lsub
    //   63: ldc2_w 1271
    //   66: ldiv
    //   67: invokevirtual 1258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc_w 297
    //   74: iconst_2
    //   75: aload_2
    //   76: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 161	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boK	Z
    //   86: ifne +12 -> 98
    //   89: aload_0
    //   90: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   93: istore_1
    //   94: iload_1
    //   95: ifeq +6 -> 101
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   104: aload_0
    //   105: getfield 163	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:KF	J
    //   108: lsub
    //   109: ldc2_w 125
    //   112: lcmp
    //   113: iflt -15 -> 98
    //   116: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +13 -> 132
    //   122: ldc_w 297
    //   125: iconst_2
    //   126: ldc_w 1427
    //   129: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: new 215	java/util/ArrayList
    //   135: dup
    //   136: invokespecial 216	java/util/ArrayList:<init>	()V
    //   139: astore_2
    //   140: new 215	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 216	java/util/ArrayList:<init>	()V
    //   147: astore_3
    //   148: aload_0
    //   149: aload_2
    //   150: aload_3
    //   151: invokespecial 1431	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:h	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   154: astore 4
    //   156: aload_2
    //   157: invokevirtual 1432	java/util/ArrayList:isEmpty	()Z
    //   160: ifeq +10 -> 170
    //   163: aload_3
    //   164: invokevirtual 1432	java/util/ArrayList:isEmpty	()Z
    //   167: ifne -69 -> 98
    //   170: aload_0
    //   171: aload_0
    //   172: aload_0
    //   173: invokevirtual 685	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:pS	()Ljava/lang/String;
    //   176: aload_2
    //   177: aload_3
    //   178: aload 4
    //   180: iconst_1
    //   181: invokespecial 1434	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   184: putfield 161	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boK	Z
    //   187: aload_0
    //   188: iconst_1
    //   189: invokespecial 766	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:EE	(I)V
    //   192: goto -94 -> 98
    //   195: astore_2
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_2
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	PhoneContactManagerImp
    //   93	2	1	bool	boolean
    //   17	160	2	localObject1	Object
    //   195	4	2	localObject2	Object
    //   147	31	3	localArrayList1	ArrayList
    //   154	25	4	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	82	195	finally
    //   82	94	195	finally
    //   101	132	195	finally
    //   132	170	195	finally
    //   170	192	195	finally
  }
  
  private void clQ()
  {
    try
    {
      KA = this.z.getLong("query_contact_list_min_interval", KA);
      KB = this.z.getLong("query_contact_list_min_interval_for_login", KB);
      KC = this.z.getLong("query_contact_list_min_interval_for_reconnect", KC);
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("initQueryInterval  [limit:%s, logInLimit:%s, reconnectLimit:%s]", new Object[] { Long.valueOf(KA), Long.valueOf(KB), Long.valueOf(KC) }));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, localThrowable.getMessage());
        }
      }
    }
  }
  
  private void clR()
  {
    this.pref.edit().putString("last_phone_version_popped_notbind", "3.4.4").commit();
  }
  
  private void clS()
  {
    this.pref.edit().putString("last_phone_version_popped", "3.4.4").commit();
  }
  
  private void clT()
  {
    if (this.aZC) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "deleteLocalData");
    }
    this.boL = false;
    W(0L, 0L);
    this.df.clear();
    this.dh.clear();
    this.dg.clear();
    this.di.clear();
    EE(1);
    AL(false);
    synchronized (this.bU)
    {
      if (this.rn != null)
      {
        this.rn.clear();
        this.rn = null;
      }
      this.jdField_b_of_type_ComTencentMobileqqDataContactBinded = null;
      ??? = this.em.getTransaction();
    }
  }
  
  /* Error */
  private void clV()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +77 -> 82
    //   8: new 243	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 1253	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc_w 1421
    //   22: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 161	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boK	Z
    //   29: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: ldc_w 1423
    //   37: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   44: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: ldc_w 1425
    //   52: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 163	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:KF	J
    //   62: lsub
    //   63: ldc2_w 1271
    //   66: ldiv
    //   67: invokevirtual 1258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc_w 297
    //   74: iconst_2
    //   75: aload_2
    //   76: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 161	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boK	Z
    //   86: ifne +12 -> 98
    //   89: aload_0
    //   90: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   93: istore_1
    //   94: iload_1
    //   95: ifeq +6 -> 101
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   104: aload_0
    //   105: getfield 163	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:KF	J
    //   108: lsub
    //   109: ldc2_w 125
    //   112: lcmp
    //   113: iflt -15 -> 98
    //   116: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +13 -> 132
    //   122: ldc_w 297
    //   125: iconst_2
    //   126: ldc_w 1451
    //   129: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: new 215	java/util/ArrayList
    //   135: dup
    //   136: invokespecial 216	java/util/ArrayList:<init>	()V
    //   139: astore_2
    //   140: new 215	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 216	java/util/ArrayList:<init>	()V
    //   147: astore_3
    //   148: aload_0
    //   149: aload_2
    //   150: aload_3
    //   151: invokespecial 1431	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:h	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   154: astore 4
    //   156: aload_2
    //   157: invokevirtual 1432	java/util/ArrayList:isEmpty	()Z
    //   160: ifeq +10 -> 170
    //   163: aload_3
    //   164: invokevirtual 1432	java/util/ArrayList:isEmpty	()Z
    //   167: ifne -69 -> 98
    //   170: aload_0
    //   171: aload_0
    //   172: aload_0
    //   173: invokevirtual 685	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:pS	()Ljava/lang/String;
    //   176: aload_2
    //   177: aload_3
    //   178: aload 4
    //   180: iconst_0
    //   181: invokespecial 1434	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Z)Z
    //   184: putfield 161	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boK	Z
    //   187: aload_0
    //   188: iconst_1
    //   189: invokespecial 766	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:EE	(I)V
    //   192: goto -94 -> 98
    //   195: astore_2
    //   196: aload_0
    //   197: monitorexit
    //   198: aload_2
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	PhoneContactManagerImp
    //   93	2	1	bool	boolean
    //   17	160	2	localObject1	Object
    //   195	4	2	localObject2	Object
    //   147	31	3	localArrayList1	ArrayList
    //   154	25	4	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	82	195	finally
    //   82	94	195	finally
    //   101	132	195	finally
    //   132	170	195	finally
    //   170	192	195	finally
  }
  
  private void d(ConcurrentHashMap<String, PhoneContact> paramConcurrentHashMap)
  {
    Object localObject1 = this.df.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      PhoneContact localPhoneContact = (PhoneContact)((Map.Entry)localObject2).getValue();
      localObject2 = (PhoneContact)paramConcurrentHashMap.get(((Map.Entry)localObject2).getKey());
      if ((localObject2 != null) && (localPhoneContact != null))
      {
        ((PhoneContact)localObject2).uin = localPhoneContact.uin;
        ((PhoneContact)localObject2).nationCode = localPhoneContact.nationCode;
        ((PhoneContact)localObject2).mobileCode = localPhoneContact.mobileCode;
        ((PhoneContact)localObject2).bindingDate = localPhoneContact.bindingDate;
        ((PhoneContact)localObject2).nickName = localPhoneContact.nickName;
        ((PhoneContact)localObject2).isUploaded = localPhoneContact.isUploaded;
        ((PhoneContact)localObject2).originBinder = localPhoneContact.originBinder;
        ((PhoneContact)localObject2).ability = localPhoneContact.ability;
      }
    }
    localObject1 = this.df;
    this.df = paramConcurrentHashMap;
    ((ConcurrentHashMap)localObject1).clear();
  }
  
  private void gK(List<String> paramList)
  {
    try
    {
      HashSet localHashSet = new HashSet(this.bx.size() + paramList.size());
      localHashSet.addAll(this.bx);
      localHashSet.addAll(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "addContactsToLastLogin, mLastLoginSet.size=" + this.bx.size() + ", tempSet.size=" + localHashSet.size());
      }
      this.bx = localHashSet;
      j(this.bx);
      return;
    }
    catch (OutOfMemoryError paramList)
    {
      QLog.e("PhoneContactManagerImp", 1, "addContactsToLastLoginList oom", paramList);
    }
  }
  
  private void gu(long paramLong)
  {
    this.app.runOnUiThread(new PhoneContactManagerImp.13(this, paramLong));
  }
  
  private void gw(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveContactListTimeStampNotBind" + paramLong);
    }
    this.pref.edit().putLong("queryContactTimeStamp", paramLong).commit();
  }
  
  /* Error */
  private ArrayList<PhoneContact> h(ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2)
  {
    // Byte code:
    //   0: new 1516	java/util/HashMap
    //   3: dup
    //   4: invokespecial 1517	java/util/HashMap:<init>	()V
    //   7: astore 12
    //   9: new 215	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 216	java/util/ArrayList:<init>	()V
    //   16: astore 11
    //   18: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   21: lstore 5
    //   23: aload_0
    //   24: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   30: invokevirtual 1075	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   33: astore 7
    //   35: aload 7
    //   37: getstatic 1081	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   40: getstatic 142	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cT	[Ljava/lang/String;
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokestatic 1087	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 8
    //   51: aload 8
    //   53: ifnull +249 -> 302
    //   56: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +36 -> 95
    //   62: ldc_w 297
    //   65: iconst_2
    //   66: new 243	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 1519
    //   76: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 8
    //   81: invokeinterface 1092 1 0
    //   86: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aconst_null
    //   96: astore 7
    //   98: aload_0
    //   99: getfield 333	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   102: invokevirtual 465	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   105: astore 9
    //   107: aload 9
    //   109: astore 7
    //   111: aload 7
    //   113: invokevirtual 470	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   116: aload 8
    //   118: invokeinterface 1102 1 0
    //   123: pop
    //   124: aload 8
    //   126: invokeinterface 1105 1 0
    //   131: ifne +653 -> 784
    //   134: aload 8
    //   136: aload 8
    //   138: ldc 132
    //   140: invokeinterface 1109 2 0
    //   145: invokeinterface 1111 2 0
    //   150: invokestatic 1117	yui:hN	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore 10
    //   155: aload 8
    //   157: aload 8
    //   159: ldc 134
    //   161: invokeinterface 1109 2 0
    //   166: invokeinterface 1111 2 0
    //   171: astore 9
    //   173: aload 9
    //   175: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifeq +991 -> 1169
    //   181: aload 10
    //   183: astore 9
    //   185: aload 8
    //   187: aload 8
    //   189: ldc 136
    //   191: invokeinterface 1109 2 0
    //   196: invokeinterface 1119 2 0
    //   201: istore_3
    //   202: aload 8
    //   204: aload 8
    //   206: ldc 138
    //   208: invokeinterface 1109 2 0
    //   213: invokeinterface 1119 2 0
    //   218: istore 4
    //   220: aload 8
    //   222: aload 8
    //   224: ldc 140
    //   226: invokeinterface 1109 2 0
    //   231: invokeinterface 1111 2 0
    //   236: astore 13
    //   238: aload 10
    //   240: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   243: ifne +11 -> 254
    //   246: aload 9
    //   248: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   251: ifeq +133 -> 384
    //   254: aload 8
    //   256: invokeinterface 1122 1 0
    //   261: pop
    //   262: goto -138 -> 124
    //   265: astore 9
    //   267: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +15 -> 285
    //   273: ldc_w 297
    //   276: iconst_2
    //   277: ldc_w 267
    //   280: aload 9
    //   282: invokestatic 1124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: aload 7
    //   287: ifnull +8 -> 295
    //   290: aload 7
    //   292: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   295: aload 8
    //   297: invokeinterface 1127 1 0
    //   302: aload_0
    //   303: iconst_0
    //   304: putfield 190	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boQ	Z
    //   307: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +63 -> 373
    //   313: ldc_w 297
    //   316: iconst_2
    //   317: ldc_w 1521
    //   320: iconst_4
    //   321: anewarray 4	java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: aload_1
    //   327: invokevirtual 854	java/util/ArrayList:size	()I
    //   330: invokestatic 613	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_2
    //   337: invokevirtual 854	java/util/ArrayList:size	()I
    //   340: invokestatic 613	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   343: aastore
    //   344: dup
    //   345: iconst_2
    //   346: aload 11
    //   348: invokevirtual 854	java/util/ArrayList:size	()I
    //   351: invokestatic 613	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   354: aastore
    //   355: dup
    //   356: iconst_3
    //   357: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   360: lload 5
    //   362: lsub
    //   363: invokestatic 305	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   366: aastore
    //   367: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   370: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload 11
    //   375: areturn
    //   376: astore 7
    //   378: aconst_null
    //   379: astore 8
    //   381: goto -330 -> 51
    //   384: aload_0
    //   385: getfield 192	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:df	Ljava/util/concurrent/ConcurrentHashMap;
    //   388: aload 10
    //   390: invokevirtual 1472	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   393: checkcast 491	com/tencent/mobileqq/data/PhoneContact
    //   396: astore 14
    //   398: aload 14
    //   400: ifnonnull +174 -> 574
    //   403: new 491	com/tencent/mobileqq/data/PhoneContact
    //   406: dup
    //   407: invokespecial 1144	com/tencent/mobileqq/data/PhoneContact:<init>	()V
    //   410: astore 14
    //   412: aload 14
    //   414: aload 10
    //   416: putfield 1133	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   419: aload 14
    //   421: aload 9
    //   423: putfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   426: aload 14
    //   428: iload_3
    //   429: putfield 1147	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   432: aload 14
    //   434: iload 4
    //   436: putfield 1150	com/tencent/mobileqq/data/PhoneContact:type	I
    //   439: aload 14
    //   441: aload 13
    //   443: putfield 1153	com/tencent/mobileqq/data/PhoneContact:label	Ljava/lang/String;
    //   446: aload 14
    //   448: lload 5
    //   450: putfield 1156	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   453: aload 14
    //   455: aload 9
    //   457: iconst_1
    //   458: invokestatic 1162	com/tencent/mobileqq/utils/ChnToSpell:aJ	(Ljava/lang/String;I)Ljava/lang/String;
    //   461: putfield 1165	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   464: aload 14
    //   466: aload 9
    //   468: iconst_2
    //   469: invokestatic 1162	com/tencent/mobileqq/utils/ChnToSpell:aJ	(Ljava/lang/String;I)Ljava/lang/String;
    //   472: putfield 1168	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   475: aload 14
    //   477: aload 14
    //   479: getfield 1168	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   482: invokestatic 1171	yui:hO	(Ljava/lang/String;)Ljava/lang/String;
    //   485: putfield 1174	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   488: aload_0
    //   489: getfield 192	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:df	Ljava/util/concurrent/ConcurrentHashMap;
    //   492: aload 10
    //   494: aload 14
    //   496: invokevirtual 1183	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   499: pop
    //   500: aload 14
    //   502: aload 9
    //   504: aload 10
    //   506: invokestatic 1177	yui:az	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   509: putfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   512: aload_0
    //   513: getfield 198	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:di	Ljava/util/concurrent/ConcurrentHashMap;
    //   516: aload 14
    //   518: getfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   521: aload 14
    //   523: invokevirtual 1183	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   526: pop
    //   527: aload 11
    //   529: aload 14
    //   531: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   534: pop
    //   535: aload_1
    //   536: new 1132	SecurityAccountServer/AddressBookItem
    //   539: dup
    //   540: aload 10
    //   542: aload 9
    //   544: invokespecial 1139	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   550: pop
    //   551: goto -297 -> 254
    //   554: astore_1
    //   555: aload 7
    //   557: ifnull +8 -> 565
    //   560: aload 7
    //   562: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   565: aload 8
    //   567: invokeinterface 1127 1 0
    //   572: aload_1
    //   573: athrow
    //   574: aload 14
    //   576: iload_3
    //   577: putfield 1147	com/tencent/mobileqq/data/PhoneContact:contactID	I
    //   580: aload 14
    //   582: lload 5
    //   584: putfield 1156	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   587: aload 14
    //   589: getfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   592: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   595: ifeq +33 -> 628
    //   598: aload 14
    //   600: aload 14
    //   602: getfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   605: aload 10
    //   607: invokestatic 1177	yui:az	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   610: putfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   613: aload_0
    //   614: getfield 198	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:di	Ljava/util/concurrent/ConcurrentHashMap;
    //   617: aload 14
    //   619: getfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   622: aload 14
    //   624: invokevirtual 1183	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   627: pop
    //   628: aload 14
    //   630: getfield 1484	com/tencent/mobileqq/data/PhoneContact:isUploaded	Z
    //   633: ifeq +124 -> 757
    //   636: aload 9
    //   638: aload 14
    //   640: getfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   643: invokevirtual 650	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   646: ifne +57 -> 703
    //   649: aload 12
    //   651: aload 10
    //   653: aload 9
    //   655: invokevirtual 1522	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   658: pop
    //   659: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   662: ifeq -408 -> 254
    //   665: ldc_w 297
    //   668: iconst_2
    //   669: ldc_w 1524
    //   672: iconst_3
    //   673: anewarray 4	java/lang/Object
    //   676: dup
    //   677: iconst_0
    //   678: aload 14
    //   680: getfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   683: aastore
    //   684: dup
    //   685: iconst_1
    //   686: aload 9
    //   688: aastore
    //   689: dup
    //   690: iconst_2
    //   691: aload 10
    //   693: aastore
    //   694: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   697: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: goto -446 -> 254
    //   703: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   706: ifeq +40 -> 746
    //   709: aload 12
    //   711: aload 10
    //   713: invokevirtual 1527	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   716: ifeq +30 -> 746
    //   719: ldc_w 297
    //   722: iconst_2
    //   723: ldc_w 1529
    //   726: iconst_2
    //   727: anewarray 4	java/lang/Object
    //   730: dup
    //   731: iconst_0
    //   732: aload 9
    //   734: aastore
    //   735: dup
    //   736: iconst_1
    //   737: aload 10
    //   739: aastore
    //   740: invokestatic 309	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   743: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload 12
    //   748: aload 10
    //   750: invokevirtual 1531	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   753: pop
    //   754: goto -500 -> 254
    //   757: aload_1
    //   758: new 1132	SecurityAccountServer/AddressBookItem
    //   761: dup
    //   762: aload 10
    //   764: aload 9
    //   766: invokespecial 1139	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   772: pop
    //   773: aload 11
    //   775: aload 14
    //   777: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   780: pop
    //   781: goto -527 -> 254
    //   784: aload 12
    //   786: invokevirtual 1534	java/util/HashMap:keySet	()Ljava/util/Set;
    //   789: invokeinterface 1460 1 0
    //   794: astore 9
    //   796: aload 9
    //   798: invokeinterface 485 1 0
    //   803: ifeq +176 -> 979
    //   806: aload 9
    //   808: invokeinterface 489 1 0
    //   813: checkcast 130	java/lang/String
    //   816: astore 10
    //   818: aload_0
    //   819: getfield 192	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:df	Ljava/util/concurrent/ConcurrentHashMap;
    //   822: aload 10
    //   824: invokevirtual 1472	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   827: checkcast 491	com/tencent/mobileqq/data/PhoneContact
    //   830: astore 13
    //   832: aload 13
    //   834: ifnull -38 -> 796
    //   837: aload 12
    //   839: aload 10
    //   841: invokevirtual 1535	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   844: checkcast 130	java/lang/String
    //   847: astore 14
    //   849: aload_2
    //   850: new 1132	SecurityAccountServer/AddressBookItem
    //   853: dup
    //   854: aload 10
    //   856: aload 13
    //   858: getfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   861: invokespecial 1139	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   864: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   867: pop
    //   868: aload_1
    //   869: new 1132	SecurityAccountServer/AddressBookItem
    //   872: dup
    //   873: aload 10
    //   875: aload 14
    //   877: invokespecial 1139	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   880: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   883: pop
    //   884: aload 13
    //   886: aload 14
    //   888: putfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   891: aload 13
    //   893: aload 14
    //   895: iconst_1
    //   896: invokestatic 1162	com/tencent/mobileqq/utils/ChnToSpell:aJ	(Ljava/lang/String;I)Ljava/lang/String;
    //   899: putfield 1165	com/tencent/mobileqq/data/PhoneContact:pinyinAll	Ljava/lang/String;
    //   902: aload 13
    //   904: aload 14
    //   906: iconst_2
    //   907: invokestatic 1162	com/tencent/mobileqq/utils/ChnToSpell:aJ	(Ljava/lang/String;I)Ljava/lang/String;
    //   910: putfield 1168	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   913: aload 13
    //   915: aload 13
    //   917: getfield 1168	com/tencent/mobileqq/data/PhoneContact:pinyinInitial	Ljava/lang/String;
    //   920: invokestatic 1171	yui:hO	(Ljava/lang/String;)Ljava/lang/String;
    //   923: putfield 1174	com/tencent/mobileqq/data/PhoneContact:pinyinFirst	Ljava/lang/String;
    //   926: aload_0
    //   927: getfield 198	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:di	Ljava/util/concurrent/ConcurrentHashMap;
    //   930: aload 13
    //   932: getfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   935: aload 13
    //   937: invokevirtual 1538	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   940: pop
    //   941: aload 13
    //   943: aload 14
    //   945: aload 10
    //   947: invokestatic 1177	yui:az	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   950: putfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   953: aload_0
    //   954: getfield 198	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:di	Ljava/util/concurrent/ConcurrentHashMap;
    //   957: aload 13
    //   959: getfield 1180	com/tencent/mobileqq/data/PhoneContact:md5	Ljava/lang/String;
    //   962: aload 13
    //   964: invokevirtual 1183	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   967: pop
    //   968: aload 11
    //   970: aload 13
    //   972: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   975: pop
    //   976: goto -180 -> 796
    //   979: new 215	java/util/ArrayList
    //   982: dup
    //   983: invokespecial 216	java/util/ArrayList:<init>	()V
    //   986: astore 9
    //   988: aload_0
    //   989: getfield 192	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:df	Ljava/util/concurrent/ConcurrentHashMap;
    //   992: invokevirtual 1459	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   995: invokeinterface 1460 1 0
    //   1000: astore 10
    //   1002: aload 10
    //   1004: invokeinterface 485 1 0
    //   1009: ifeq +105 -> 1114
    //   1012: aload 10
    //   1014: invokeinterface 489 1 0
    //   1019: checkcast 1462	java/util/Map$Entry
    //   1022: invokeinterface 1465 1 0
    //   1027: checkcast 491	com/tencent/mobileqq/data/PhoneContact
    //   1030: astore 12
    //   1032: aload 12
    //   1034: getfield 1156	com/tencent/mobileqq/data/PhoneContact:lastScanTime	J
    //   1037: lload 5
    //   1039: lcmp
    //   1040: ifeq -38 -> 1002
    //   1043: aload 12
    //   1045: getfield 1539	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1048: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1051: ifne +16 -> 1067
    //   1054: aload_0
    //   1055: getfield 194	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:dg	Ljava/util/concurrent/ConcurrentHashMap;
    //   1058: aload 12
    //   1060: getfield 1539	com/tencent/mobileqq/data/PhoneContact:unifiedCode	Ljava/lang/String;
    //   1063: invokevirtual 1540	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1066: pop
    //   1067: aload 10
    //   1069: invokeinterface 1405 1 0
    //   1074: aload_0
    //   1075: getfield 333	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1078: aload 12
    //   1080: invokevirtual 1407	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   1083: pop
    //   1084: aload_2
    //   1085: new 1132	SecurityAccountServer/AddressBookItem
    //   1088: dup
    //   1089: aload 12
    //   1091: getfield 1133	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1094: aload 12
    //   1096: getfield 1136	com/tencent/mobileqq/data/PhoneContact:name	Ljava/lang/String;
    //   1099: invokespecial 1139	SecurityAccountServer/AddressBookItem:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1102: invokevirtual 1142	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1105: pop
    //   1106: aload 9
    //   1108: invokevirtual 1387	java/util/ArrayList:clear	()V
    //   1111: goto -109 -> 1002
    //   1114: aload 7
    //   1116: invokevirtual 505	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1119: aload 7
    //   1121: ifnull +8 -> 1129
    //   1124: aload 7
    //   1126: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1129: aload 8
    //   1131: invokeinterface 1127 1 0
    //   1136: goto -834 -> 302
    //   1139: astore 7
    //   1141: goto -839 -> 302
    //   1144: astore 7
    //   1146: goto -844 -> 302
    //   1149: astore_2
    //   1150: goto -578 -> 572
    //   1153: astore_1
    //   1154: aconst_null
    //   1155: astore 7
    //   1157: goto -602 -> 555
    //   1160: astore_1
    //   1161: goto -606 -> 555
    //   1164: astore 9
    //   1166: goto -899 -> 267
    //   1169: goto -984 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1172	0	this	PhoneContactManagerImp
    //   0	1172	1	paramArrayList1	ArrayList<AddressBookItem>
    //   0	1172	2	paramArrayList2	ArrayList<AddressBookItem>
    //   201	376	3	i	int
    //   218	217	4	j	int
    //   21	1017	5	l	long
    //   33	258	7	localObject1	Object
    //   376	749	7	localThrowable	Throwable
    //   1139	1	7	localException1	Exception
    //   1144	1	7	localException2	Exception
    //   1155	1	7	localObject2	Object
    //   49	1081	8	localCursor	Cursor
    //   105	142	9	localObject3	Object
    //   265	500	9	localStaleDataException1	StaleDataException
    //   794	313	9	localObject4	Object
    //   1164	1	9	localStaleDataException2	StaleDataException
    //   153	915	10	localObject5	Object
    //   16	953	11	localArrayList	ArrayList
    //   7	1088	12	localObject6	Object
    //   236	735	13	localObject7	Object
    //   396	548	14	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   111	124	265	android/database/StaleDataException
    //   124	181	265	android/database/StaleDataException
    //   185	254	265	android/database/StaleDataException
    //   254	262	265	android/database/StaleDataException
    //   384	398	265	android/database/StaleDataException
    //   403	551	265	android/database/StaleDataException
    //   574	628	265	android/database/StaleDataException
    //   628	700	265	android/database/StaleDataException
    //   703	746	265	android/database/StaleDataException
    //   746	754	265	android/database/StaleDataException
    //   757	781	265	android/database/StaleDataException
    //   784	796	265	android/database/StaleDataException
    //   796	832	265	android/database/StaleDataException
    //   837	976	265	android/database/StaleDataException
    //   979	1002	265	android/database/StaleDataException
    //   1002	1067	265	android/database/StaleDataException
    //   1067	1111	265	android/database/StaleDataException
    //   1114	1119	265	android/database/StaleDataException
    //   35	51	376	java/lang/Throwable
    //   111	124	554	finally
    //   124	181	554	finally
    //   185	254	554	finally
    //   254	262	554	finally
    //   384	398	554	finally
    //   403	551	554	finally
    //   574	628	554	finally
    //   628	700	554	finally
    //   703	746	554	finally
    //   746	754	554	finally
    //   757	781	554	finally
    //   784	796	554	finally
    //   796	832	554	finally
    //   837	976	554	finally
    //   979	1002	554	finally
    //   1002	1067	554	finally
    //   1067	1111	554	finally
    //   1114	1119	554	finally
    //   1129	1136	1139	java/lang/Exception
    //   295	302	1144	java/lang/Exception
    //   565	572	1149	java/lang/Exception
    //   98	107	1153	finally
    //   267	285	1160	finally
    //   98	107	1164	android/database/StaleDataException
  }
  
  private String pT()
  {
    String str = this.pref.getString("contact_bind_info_unique", "");
    if ((!TextUtils.isEmpty(str)) && (!str.equals("null|null"))) {
      return str;
    }
    str = pU();
    SharedPreferences.Editor localEditor = this.pref.edit();
    localEditor.putString("contact_bind_info_unique", str);
    localEditor.commit();
    return str;
  }
  
  private String pU()
  {
    Object localObject1 = "";
    String str = auri.getIMEI("73f9b3");
    if (!VersionUtils.isM()) {
      localObject1 = auri.rv("73f9b3");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).equals("02:00:00:00:00:00")) {
        break label120;
      }
    }
    try
    {
      localObject2 = alla.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label58:
      label120:
      break label58;
    }
    QLog.i("PhoneContact", 1, String.format("fallback androidId:%s", new Object[] { localObject1 }));
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new Random();
      localObject2 = ((Random)localObject1).nextLong() + "";
    }
    return str + "|" + (String)localObject2;
  }
  
  private static byte[] s(byte[] paramArrayOfByte)
  {
    int j = 0;
    int k = paramArrayOfByte.length - 1;
    while (k > j * 2)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(k - j)];
      paramArrayOfByte[(k - j)] = i;
      j += 1;
    }
    return paramArrayOfByte;
  }
  
  private void y(boolean paramBoolean, List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "notifyRecommendCountChanged|beAdded = " + paramBoolean + "|list.size = " + paramList.size());
    }
    if (this.aZC) {
      return;
    }
    int i = paramList.size();
    this.app.runOnUiThread(new PhoneContactManagerImp.12(this, paramBoolean, i));
  }
  
  private void z(boolean paramBoolean, List<PhoneContact> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact|listSize = ", Integer.valueOf(paramList.size()) });
    }
    EntityTransaction localEntityTransaction;
    for (;;)
    {
      PhoneContact localPhoneContact;
      synchronized (this.bU)
      {
        if (paramList.size() <= 0) {
          break label398;
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqDataContactBinded == null) || (paramList.size() > cbg)) {
          break label445;
        }
        localEntityTransaction = this.em.getTransaction();
        localEntityTransaction.begin();
        try
        {
          if (this.rn == null) {
            this.rn = new ArrayList(paramList.size());
          }
          Iterator localIterator = paramList.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localPhoneContact = (PhoneContact)localIterator.next();
          localObject2 = this.rn.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            ContactMatch localContactMatch = (ContactMatch)((Iterator)localObject2).next();
            if (!localContactMatch.mobileNo.equals(localPhoneContact.mobileNo)) {
              continue;
            }
            ((Iterator)localObject2).remove();
            this.em.remove(localContactMatch);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact remove uin=", localContactMatch.mobileNo });
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.end();
        }
      }
      Object localObject2 = new ContactMatch();
      ((ContactMatch)localObject2).mobileNo = localPhoneContact.mobileNo;
      ((ContactMatch)localObject2).unifiedCode = localPhoneContact.unifiedCode;
      ((ContactMatch)localObject2).name = localPhoneContact.name;
      ((ContactMatch)localObject2).timestamp = anaz.gQ();
      ((ContactMatch)localObject2).age = ((short)localPhoneContact.age);
      ((ContactMatch)localObject2).gender = ((short)localPhoneContact.sex);
      ((ContactMatch)localObject2).commonFriend = localPhoneContact.samFriend;
      this.rn.add(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, new Object[] { "onNewRecommendContact new uin=", ((ContactMatch)localObject2).mobileNo });
      }
      a((Entity)localObject2);
    }
    localEntityTransaction.commit();
    localEntityTransaction.end();
    a(this.jdField_b_of_type_ComTencentMobileqqDataContactBinded);
    label398:
    if (paramBoolean) {
      if (this.jdField_b_of_type_ComTencentMobileqqDataContactBinded == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqDataContactBinded = new ContactBinded();
        this.jdField_b_of_type_ComTencentMobileqqDataContactBinded.isReaded = paramList.isEmpty();
        a(this.jdField_b_of_type_ComTencentMobileqqDataContactBinded);
      }
    }
    for (;;)
    {
      return;
      label445:
      if (this.jdField_b_of_type_ComTencentMobileqqDataContactBinded == null) {
        this.jdField_b_of_type_ComTencentMobileqqDataContactBinded = new ContactBinded();
      }
      this.jdField_b_of_type_ComTencentMobileqqDataContactBinded.timestamp = anaz.gQ();
      this.jdField_b_of_type_ComTencentMobileqqDataContactBinded.isReaded = false;
      break;
      this.jdField_b_of_type_ComTencentMobileqqDataContactBinded = null;
    }
  }
  
  public void AK(boolean paramBoolean)
  {
    AM(paramBoolean);
  }
  
  public void AP(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = anaz.gQ();; l = 0L)
    {
      this.KI = l;
      this.app.getPreferences().edit().putLong("user_setting_flag_" + this.app.getAccount(), this.KI).apply();
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("markOrClearUserSettingFlag [%s]", new Object[] { Long.valueOf(this.KI) }));
      }
      return;
    }
  }
  
  public void J(int paramInt, List<String> paramList)
  {
    this.cbi = paramInt;
    this.th = paramList;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (localObject != null)
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append("|");
          }
          localStringBuilder.append((String)localObject);
        }
      }
    }
    paramList = this.app.getAccount();
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (localObject != null) {
      ((SharedPreferences)localObject).edit().putInt("frd_has_bind_phone_count_" + paramList, this.cbi).putString("frd_has_bind_phone_some_" + paramList, localStringBuilder.toString()).apply();
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("onGetFriendsHasBindPhone [%s, %s]", new Object[] { Integer.valueOf(this.cbi), localStringBuilder.toString() }));
    }
  }
  
  public void J(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "makePhoneContactAddInfo|unifiedCode : " + paramString1 + "|friendSetting : " + paramInt + "|remark : " + paramString2);
    }
    if ((paramInt != 1) && (paramInt != 4)) {
      return;
    }
    label406:
    label422:
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      int i;
      synchronized (this.bU)
      {
        localEntityTransaction = this.em.getTransaction();
        try
        {
          localEntityTransaction.begin();
          if ((this.ro == null) || (this.ro.isEmpty())) {
            break label422;
          }
          localObject2 = this.ro.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label422;
          }
          PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)((Iterator)localObject2).next();
          if (!localPhoneContactAdd.unifiedCode.equals(paramString1)) {
            continue;
          }
          localPhoneContactAdd.timestamp = anaz.gQ();
          a(localPhoneContactAdd);
          i = 0;
          if (i != 0)
          {
            localObject2 = new PhoneContactAdd();
            ((PhoneContactAdd)localObject2).name = paramString2;
            ((PhoneContactAdd)localObject2).unifiedCode = paramString1;
            ((PhoneContactAdd)localObject2).timestamp = anaz.gQ();
            if (paramInt != 1) {
              break label356;
            }
            ((PhoneContactAdd)localObject2).remindInfo = this.app.getApp().getApplicationContext().getResources().getString(2131696820);
            if (this.ro == null) {
              this.ro = new ArrayList();
            }
            this.ro.add(localObject2);
            a((Entity)localObject2);
          }
          if ((this.rn != null) && (!this.rn.isEmpty()))
          {
            paramString2 = this.rn.iterator();
            if (paramString2.hasNext())
            {
              localObject2 = (ContactMatch)paramString2.next();
              if (!((ContactMatch)localObject2).unifiedCode.equals(paramString1)) {
                continue;
              }
              paramString2.remove();
              this.em.remove((Entity)localObject2);
            }
          }
          localEntityTransaction.commit();
        }
        catch (Resources.NotFoundException paramString1)
        {
          Object localObject2;
          if (!QLog.isColorLevel()) {
            break label406;
          }
          QLog.d("PhoneContact.Manager", 2, "makePhoneContactAddInfo", paramString1);
          localEntityTransaction.end();
          continue;
        }
        finally
        {
          localEntityTransaction.end();
        }
        return;
      }
      label356:
      if (paramInt == 4)
      {
        ((PhoneContactAdd)localObject2).remindInfo = this.app.getApp().getApplicationContext().getResources().getString(2131696821);
        continue;
        i = 1;
      }
    }
  }
  
  public boolean Un()
  {
    return this.boO;
  }
  
  public boolean Uo()
  {
    if (this.tk == null) {
      this.tk = cW();
    }
    return (this.tk == null) || (this.tk.isEmpty());
  }
  
  public boolean Ur()
  {
    int i = xy();
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isBindContactOk = " + i);
    }
    return i >= 9;
  }
  
  public boolean Us()
  {
    if (this.cbf == 4) {}
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    label88:
    do
    {
      return true;
      localRespondQueryQQBindingStat = a();
      String str;
      if (QLog.isColorLevel())
      {
        if (localRespondQueryQQBindingStat != null)
        {
          str = localRespondQueryQQBindingStat.toString();
          QLog.d("PhoneContact.Manager", 2, new Object[] { "isAutoUploadContactsNotBind", str });
        }
      }
      else
      {
        if (this.cbf != 3) {
          continue;
        }
        if (localRespondQueryQQBindingStat == null) {
          break;
        }
        if (a().lastUsedFlag != 2L) {
          break label88;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        return bool;
        str = "";
        break;
      }
    } while ((localRespondQueryQQBindingStat != null) && (localRespondQueryQQBindingStat.continueUploadNotbind));
    return false;
  }
  
  public boolean Ut()
  {
    if (this.cbf == 8) {}
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    do
    {
      do
      {
        return true;
        if (this.cbf != 6) {
          break;
        }
        if (a() == null) {
          break label70;
        }
      } while (a().lastUsedFlag == 2L);
      return false;
      if (this.cbf != 7) {
        break;
      }
      localRespondQueryQQBindingStat = a();
      if (localRespondQueryQQBindingStat == null) {
        break;
      }
    } while (!localRespondQueryQQBindingStat.isStopFindMatch);
    return false;
    label70:
    return false;
  }
  
  /* Error */
  public boolean Uu()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 1075	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   13: getstatic 1081	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   16: iconst_1
    //   17: anewarray 130	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 132
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: ldc_w 1707
    //   30: invokestatic 1087	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: invokeinterface 1092 1 0
    //   47: istore_1
    //   48: iload_1
    //   49: ifle +79 -> 128
    //   52: iconst_1
    //   53: istore_2
    //   54: aload 4
    //   56: ifnull +10 -> 66
    //   59: aload 4
    //   61: invokeinterface 1127 1 0
    //   66: iload_2
    //   67: ireturn
    //   68: astore 5
    //   70: aconst_null
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 5
    //   78: invokevirtual 1143	java/lang/Exception:printStackTrace	()V
    //   81: aload 4
    //   83: ifnull +43 -> 126
    //   86: aload 4
    //   88: invokeinterface 1127 1 0
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_3
    //   96: aload 4
    //   98: ifnull +10 -> 108
    //   101: aload 4
    //   103: invokeinterface 1127 1 0
    //   108: aload_3
    //   109: athrow
    //   110: astore 5
    //   112: aload_3
    //   113: astore 4
    //   115: aload 5
    //   117: astore_3
    //   118: goto -22 -> 96
    //   121: astore 5
    //   123: goto -50 -> 73
    //   126: iconst_0
    //   127: ireturn
    //   128: iconst_0
    //   129: istore_2
    //   130: goto -76 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	PhoneContactManagerImp
    //   47	2	1	i	int
    //   53	77	2	bool	boolean
    //   33	43	3	localObject1	Object
    //   95	18	3	localObject2	Object
    //   117	1	3	localObject3	Object
    //   1	113	4	localObject4	Object
    //   68	9	5	localException1	Exception
    //   110	6	5	localObject5	Object
    //   121	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   3	34	68	java/lang/Exception
    //   3	34	95	finally
    //   40	48	110	finally
    //   76	81	110	finally
    //   40	48	121	java/lang/Exception
  }
  
  public boolean Uv()
  {
    return xy() > 5;
  }
  
  public boolean Uw()
  {
    if (VersionUtils.isM()) {
      this.af = Boolean.valueOf(yuw.ij("android.permission.READ_CONTACTS"));
    }
    for (;;)
    {
      ThreadManager.excute(new PhoneContactManagerImp.21(this), 16, null, true);
      if (QLog.isColorLevel()) {
        QLog.d("contact.PermissionChecker", 2, String.format("hasReadContactPermissionForUI isM=%b has=%b", new Object[] { Boolean.valueOf(VersionUtils.isM()), this.af }));
      }
      return this.af.booleanValue();
      if (this.af == null) {
        this.af = Boolean.valueOf(true);
      }
    }
  }
  
  public boolean Ux()
  {
    boolean bool1;
    boolean bool2;
    if (VersionUtils.isM())
    {
      bool1 = yuw.ij("android.permission.READ_CONTACTS");
      if (!bool1) {
        break label75;
      }
      bool1 = Uu();
      bool2 = true;
    }
    for (;;)
    {
      this.af = Boolean.valueOf(bool1);
      QLog.d("contact.PermissionChecker", 1, String.format("hasReadContactPermission2 isM=%b has=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      return bool1;
      bool1 = Uu();
      bool2 = false;
      continue;
      label75:
      bool2 = true;
    }
  }
  
  public boolean Uy()
  {
    boolean bool1;
    if (VersionUtils.isM()) {
      bool1 = yuw.ij("android.permission.READ_CONTACTS");
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      this.af = Boolean.valueOf(bool1);
      if (QLog.isColorLevel()) {
        QLog.d("contact.PermissionChecker", 2, String.format("hasReadContactPermission3 isM=%b has=%b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      return bool1;
      bool1 = Uu();
    }
  }
  
  public boolean Uz()
  {
    boolean bool = false;
    int i = xy();
    if ((i == 6) || (i == 7) || (i == 5) || (i == 1) || (i == 3)) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "needUploadContact [" + i + ", " + bool + "]");
    }
    return bool;
  }
  
  public Map<String, PhoneContact> W()
  {
    long l;
    ConcurrentHashMap localConcurrentHashMap;
    Object localObject1;
    try
    {
      localCursor = alld.query(this.app.getApp().getContentResolver(), ContactsContract.CommonDataKinds.Phone.CONTENT_URI, cT, null, null, null);
      if (localCursor == null) {
        break label455;
      }
      l = System.currentTimeMillis();
      i = localCursor.getCount();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "load contacs from system db, size=" + i);
      }
      localConcurrentHashMap = new ConcurrentHashMap();
    }
    catch (Exception localException)
    {
      try
      {
        localCursor.moveToFirst();
        for (;;)
        {
          if (localCursor.isAfterLast()) {
            break label411;
          }
          str2 = yui.hN(localCursor.getString(localCursor.getColumnIndex("data1")));
          str3 = localCursor.getString(localCursor.getColumnIndex("display_name"));
          String str1 = str3;
          if (TextUtils.isEmpty(str3)) {
            str1 = str2;
          }
          i = localCursor.getInt(localCursor.getColumnIndex("contact_id"));
          j = localCursor.getInt(localCursor.getColumnIndex("data2"));
          str3 = localCursor.getString(localCursor.getColumnIndex("data3"));
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1))) {
            break;
          }
          localCursor.moveToNext();
        }
      }
      catch (StaleDataException localStaleDataException)
      {
        for (;;)
        {
          Cursor localCursor;
          int i;
          String str2;
          String str3;
          int j;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "cursor query exception=", localStaleDataException);
          }
          return localConcurrentHashMap;
          localException = localException;
          if (QLog.isColorLevel()) {
            QLog.e("PhoneContact.Manager", 2, "can not query data from system contact db.");
          }
          localObject1 = null;
          continue;
          PhoneContact localPhoneContact = new PhoneContact();
          localPhoneContact.mobileNo = str2;
          localPhoneContact.name = localStaleDataException;
          localPhoneContact.contactID = i;
          localPhoneContact.type = j;
          localPhoneContact.label = str3;
          localPhoneContact.lastScanTime = l;
          localPhoneContact.pinyinAll = ChnToSpell.aJ(localStaleDataException, 1);
          localPhoneContact.pinyinInitial = ChnToSpell.aJ(localStaleDataException, 2);
          localPhoneContact.pinyinFirst = yui.hO(localPhoneContact.pinyinInitial);
          localPhoneContact.md5 = yui.az(localStaleDataException, str2);
          localConcurrentHashMap.put(str2, localPhoneContact);
        }
      }
      finally
      {
        localObject1.close();
      }
    }
    label411:
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, new Object[] { "load phone contact from system db cost=", Long.valueOf(System.currentTimeMillis() - l) });
    }
    localObject1.close();
    return localConcurrentHashMap;
    label455:
    return null;
  }
  
  public int a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, ArrayList<NotBindContactFriendInfo> paramArrayList, ArrayList<NotBindContactNotFriendInfo> paramArrayList1)
  {
    if (this.aZC) {
      return 0;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(80);
      ((StringBuilder)localObject1).append("saveContactFromServerNotBind, isSegmented = ").append(paramBoolean);
      ((StringBuilder)localObject1).append(", packageNo = ").append(paramInt);
      ((StringBuilder)localObject1).append(", nextFlag = ").append(paramLong1);
      QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.tr == null)
    {
      this.tr = paramArrayList;
      if (this.tq != null) {
        break label132;
      }
      this.tq = paramArrayList1;
    }
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean)) {
        break label147;
      }
      return 0;
      this.tr.addAll(paramArrayList);
      break;
      label132:
      this.tq.addAll(paramArrayList1);
    }
    label147:
    long l1 = this.pref.getLong("queryContactTimeStamp", 0L);
    long l2 = this.pref.getLong("queryRichInfoTimeStamp", 0L);
    int i;
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder(200);
      paramArrayList.append("saveContactFromServer, localTimeStamp:");
      paramArrayList.append(l1).append(", ").append(l2);
      paramArrayList.append(", remoteTimeStamp: ").append(paramLong2);
      paramArrayList1 = paramArrayList.append(", friendCount:");
      if (this.tr != null)
      {
        i = this.tr.size();
        paramArrayList1.append(i);
        paramArrayList1 = paramArrayList.append(", strangerCount:");
        if (this.tq == null) {
          break label722;
        }
        i = this.tq.size();
        label301:
        paramArrayList1.append(i);
        QLog.d("PhoneContact.Manager", 2, paramArrayList.toString());
      }
    }
    else
    {
      if (!this.boL) {
        clI();
      }
      if (((paramInt == 0) && (paramBoolean)) || (!paramBoolean)) {
        AN(true);
      }
      if ((this.tr == null) || (this.tr.size() <= 0)) {
        break label1373;
      }
      paramArrayList1 = this.em.getTransaction();
      localObject1 = (acff)this.app.getManager(51);
    }
    Object localObject2;
    Object localObject3;
    boolean bool1;
    for (;;)
    {
      try
      {
        paramArrayList1.begin();
        localObject2 = this.tr.iterator();
        paramBoolean = false;
        if (!((Iterator)localObject2).hasNext()) {
          break label784;
        }
        localObject3 = (NotBindContactFriendInfo)((Iterator)localObject2).next();
        paramArrayList = (PhoneContact)this.di.get(((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramArrayList == null) {
          break label728;
        }
        bool1 = true;
        c(paramArrayList, true);
        paramArrayList.uin = String.valueOf(((NotBindContactFriendInfo)localObject3).bindUin);
        paramArrayList.isUploaded = true;
        paramArrayList.unifiedCode = c(((NotBindContactFriendInfo)localObject3).MobileNoMask, paramArrayList.mobileNo);
        paramArrayList.mobileCode = paramArrayList.unifiedCode;
        paramArrayList.nationCode = "";
        if ((!TextUtils.isEmpty(paramArrayList.uin)) && (!paramArrayList.uin.equals("0")))
        {
          localObject3 = ((acff)localObject1).e(paramArrayList.uin);
          if (localObject3 != null) {
            paramArrayList.nickName = ((Friends)localObject3).name;
          }
          this.dh.put(paramArrayList.uin, paramArrayList);
          ((acff)localObject1).bF(paramArrayList.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramArrayList.unifiedCode)) {
          this.dg.put(paramArrayList.unifiedCode, paramArrayList);
        }
        this.dj.remove(paramArrayList.mobileNo);
        this.em.update(paramArrayList);
        paramBoolean = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramArrayList != null) {
          break label774;
        }
        paramArrayList = "null";
        QLog.d("PhoneContact.Manager", 2, paramArrayList);
        paramBoolean = bool1;
        continue;
        i = -1;
      }
      finally
      {
        paramArrayList1.end();
      }
      break;
      label722:
      i = -1;
      break label301;
      label728:
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((NotBindContactFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean;
        continue;
        label774:
        paramArrayList = paramArrayList.toString();
      }
    }
    label784:
    paramArrayList1.commit();
    paramArrayList1.end();
    boolean bool3;
    boolean bool2;
    for (;;)
    {
      if ((this.tq != null) && (this.tq.size() > 0))
      {
        paramArrayList1 = new ArrayList(this.tq.size());
        paramArrayList = this.em.getTransaction();
      }
      for (;;)
      {
        try
        {
          paramArrayList.begin();
          localObject1 = this.tq.iterator();
          bool1 = paramBoolean;
          paramBoolean = false;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (NotBindContactNotFriendInfo)((Iterator)localObject1).next();
            localObject3 = (PhoneContact)this.di.get(((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt.toUpperCase());
            if (localObject3 != null)
            {
              bool3 = true;
              c((PhoneContact)localObject3, true);
              ((PhoneContact)localObject3).uin = "0";
              ((PhoneContact)localObject3).nickName = ((NotBindContactNotFriendInfo)localObject2).nickname;
              ((PhoneContact)localObject3).isUploaded = true;
              ((PhoneContact)localObject3).unifiedCode = c(((NotBindContactNotFriendInfo)localObject2).MobileNoMask, ((PhoneContact)localObject3).mobileNo);
              ((PhoneContact)localObject3).mobileCode = ((PhoneContact)localObject3).unifiedCode;
              ((PhoneContact)localObject3).nationCode = "";
              ((PhoneContact)localObject3).age = ((NotBindContactNotFriendInfo)localObject2).age;
              ((PhoneContact)localObject3).sex = ((NotBindContactNotFriendInfo)localObject2).sex;
              ((PhoneContact)localObject3).samFriend = ((NotBindContactNotFriendInfo)localObject2).sameFriend;
              if (((NotBindContactNotFriendInfo)localObject2).isNew)
              {
                paramBoolean = true;
                ((PhoneContact)localObject3).isNewRecommend = true;
                this.tm.add(localObject3);
              }
              if (((PhoneContact)localObject3).detalStatusFlag != 20) {
                paramArrayList1.add(((PhoneContact)localObject3).unifiedCode);
              }
              ((PhoneContact)localObject3).abilityBits = ((NotBindContactNotFriendInfo)localObject2).uAbiFlag;
              if (!TextUtils.isEmpty(((PhoneContact)localObject3).unifiedCode)) {
                this.dg.put(((PhoneContact)localObject3).unifiedCode, localObject3);
              }
              this.dj.remove(((PhoneContact)localObject3).mobileNo);
              this.em.update((Entity)localObject3);
              bool2 = paramBoolean;
              if (!QLog.isColorLevel()) {
                break label1391;
              }
              QLog.d("PhoneContact.Manager", 2, "MobileContactsNotFriendInfo; mobile=" + ((PhoneContact)localObject3).unifiedCode + " hide=" + ((PhoneContact)localObject3).isHiden);
              bool2 = true;
              bool1 = paramBoolean;
              paramBoolean = bool2;
              break;
            }
            bool3 = bool1;
            bool2 = paramBoolean;
            if (!QLog.isColorLevel()) {
              break label1391;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((NotBindContactNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean;
            break label1391;
          }
          gK(paramArrayList1);
          paramArrayList.commit();
          paramArrayList.end();
          bool2 = paramBoolean;
          paramBoolean = bool1;
          this.tk = null;
          this.tl = null;
          this.tr = null;
          this.tq = null;
          paramInt = 7;
          if (bool2) {
            paramInt = 15;
          }
          if (paramLong1 == 4294967295L)
          {
            AO(true);
            z(paramBoolean, this.tm);
            this.tm.clear();
            clN();
            gw(paramLong2);
          }
          AL(bool2);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "saveContactFromServerNotBind leave");
          }
          return paramInt;
        }
        finally
        {
          paramArrayList.end();
        }
        bool2 = false;
      }
      label1373:
      paramBoolean = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean;
      paramBoolean = bool2;
      break;
      label1391:
      paramBoolean = bool3;
      bool1 = bool2;
    }
  }
  
  public int a(boolean paramBoolean1, int paramInt, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3, List<MobileContactsFriendInfo> paramList, List<MobileContactsNotFriendInfo> paramList1)
  {
    if (this.aZC) {
      return 0;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(80);
      ((StringBuilder)localObject1).append("saveContactFromServer_v2, isSegmented = ").append(paramBoolean1);
      ((StringBuilder)localObject1).append(", packageNo = ").append(paramInt);
      ((StringBuilder)localObject1).append(", nextFlag = ").append(paramLong1);
      QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.tf == null)
    {
      this.tf = paramList;
      if (this.tg != null) {
        break label132;
      }
      this.tg = paramList1;
    }
    for (;;)
    {
      if ((paramLong1 == 4294967295L) || (paramBoolean1)) {
        break label147;
      }
      return 0;
      this.tf.addAll(paramList);
      break;
      label132:
      this.tg.addAll(paramList1);
    }
    label147:
    long l1 = this.pref.getLong("queryContactTimeStamp", 0L);
    long l2 = this.pref.getLong("queryRichInfoTimeStamp", 0L);
    int i;
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder(200);
      paramList.append("saveContactFromServer, localTimeStamp:");
      paramList.append(l1).append(", ").append(l2);
      paramList.append(", remoteTimeStamp: ").append(paramLong2).append(", ").append(paramLong3);
      paramList1 = paramList.append(", friendCount:");
      if (this.tf != null)
      {
        i = this.tf.size();
        paramList1.append(i);
        paramList1 = paramList.append(", strangerCount:");
        if (this.tg == null) {
          break label781;
        }
        i = this.tg.size();
        label312:
        paramList1.append(i);
        paramList.append(", isListChanged:").append(paramBoolean2);
        QLog.d("PhoneContact.Manager", 2, paramList.toString());
      }
    }
    else
    {
      if (!this.boL) {
        clI();
      }
      if (((paramInt == 0) && (paramBoolean1)) || (!paramBoolean1)) {
        AN(paramBoolean2);
      }
      if ((this.tf == null) || (this.tf.size() <= 0)) {
        break label1570;
      }
      if (!paramBoolean2) {}
      paramList1 = this.em.getTransaction();
      localObject1 = (acff)this.app.getManager(51);
    }
    Object localObject2;
    Object localObject3;
    boolean bool1;
    for (;;)
    {
      try
      {
        paramList1.begin();
        localObject2 = this.tf.iterator();
        paramBoolean1 = false;
        if (!((Iterator)localObject2).hasNext()) {
          break label843;
        }
        localObject3 = (MobileContactsFriendInfo)((Iterator)localObject2).next();
        paramList = (PhoneContact)this.di.get(((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt.toUpperCase());
        if (paramList == null) {
          break label787;
        }
        bool1 = true;
        c(paramList, paramBoolean2);
        paramList.uin = ((MobileContactsFriendInfo)localObject3).QQ;
        paramList.bindingDate = ((MobileContactsFriendInfo)localObject3).bindingDate;
        paramList.isUploaded = true;
        paramList.originBinder = ((MobileContactsFriendInfo)localObject3).originBinder;
        paramList.ability = ((MobileContactsFriendInfo)localObject3).accountAbi;
        paramList.unifiedCode = c(((MobileContactsFriendInfo)localObject3).MobileNoMask, paramList.mobileNo);
        paramList.mobileCode = paramList.unifiedCode;
        paramList.nationCode = "";
        if ((!TextUtils.isEmpty(paramList.uin)) && (!paramList.uin.equals("0")))
        {
          localObject3 = ((acff)localObject1).e(paramList.uin);
          if (localObject3 != null) {
            paramList.nickName = ((Friends)localObject3).name;
          }
          this.dh.put(paramList.uin, paramList);
          ((acff)localObject1).bF(paramList.unifiedCode, false);
        }
        if (!TextUtils.isEmpty(paramList.unifiedCode)) {
          this.dg.put(paramList.unifiedCode, paramList);
        }
        this.dj.remove(paramList.mobileNo);
        this.em.update(paramList);
        paramBoolean1 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = new StringBuilder().append("MobileContactsFriendInfo;");
        if (paramList != null) {
          break label833;
        }
        paramList = "null";
        QLog.d("PhoneContact.Manager", 2, paramList);
        paramBoolean1 = bool1;
        continue;
        i = -1;
      }
      finally
      {
        paramList1.end();
      }
      break;
      label781:
      i = -1;
      break label312;
      label787:
      bool1 = paramBoolean1;
      if (QLog.isColorLevel())
      {
        QLog.d("PhoneContact.Manager", 2, "bind friend not found, " + ((MobileContactsFriendInfo)localObject3).contactsInfoEncrypt);
        bool1 = paramBoolean1;
        continue;
        label833:
        paramList = paramList.unifiedCode;
      }
    }
    label843:
    paramList1.commit();
    paramList1.end();
    boolean bool3;
    boolean bool2;
    for (;;)
    {
      if ((this.tg != null) && (this.tg.size() > 0))
      {
        paramList1 = new ArrayList(this.tg.size());
        paramList = this.em.getTransaction();
      }
      for (;;)
      {
        try
        {
          paramList.begin();
          localObject1 = this.tg.iterator();
          bool1 = paramBoolean1;
          paramBoolean1 = false;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MobileContactsNotFriendInfo)((Iterator)localObject1).next();
            localObject3 = (PhoneContact)this.di.get(((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt.toUpperCase());
            if (localObject3 != null)
            {
              bool3 = true;
              c((PhoneContact)localObject3, paramBoolean2);
              bool1 = paramBoolean1;
              if (paramBoolean2)
              {
                ((PhoneContact)localObject3).uin = "0";
                ((PhoneContact)localObject3).bindingDate = ((MobileContactsNotFriendInfo)localObject2).bindingDate;
                ((PhoneContact)localObject3).nickName = ((MobileContactsNotFriendInfo)localObject2).nickname;
                ((PhoneContact)localObject3).isUploaded = true;
                ((PhoneContact)localObject3).originBinder = ((MobileContactsNotFriendInfo)localObject2).originBinder;
                ((PhoneContact)localObject3).ability = ((MobileContactsNotFriendInfo)localObject2).accountAbi;
                ((PhoneContact)localObject3).unifiedCode = c(((MobileContactsNotFriendInfo)localObject2).MobileNoMask, ((PhoneContact)localObject3).mobileNo);
                ((PhoneContact)localObject3).mobileCode = ((PhoneContact)localObject3).unifiedCode;
                ((PhoneContact)localObject3).nationCode = "";
                ((PhoneContact)localObject3).age = ((MobileContactsNotFriendInfo)localObject2).age;
                ((PhoneContact)localObject3).sex = ((MobileContactsNotFriendInfo)localObject2).sex;
                ((PhoneContact)localObject3).samFriend = ((MobileContactsNotFriendInfo)localObject2).sameFriend;
                bool1 = paramBoolean1;
                if (((MobileContactsNotFriendInfo)localObject2).isNew)
                {
                  bool1 = true;
                  ((PhoneContact)localObject3).isNewRecommend = true;
                  this.tm.add(localObject3);
                }
              }
              if (((MobileContactsNotFriendInfo)localObject2).isUpdateSign) {
                ((PhoneContact)localObject3).setRichBuffer(((MobileContactsNotFriendInfo)localObject2).personalSign, ((MobileContactsNotFriendInfo)localObject2).richTime);
              }
              if (((PhoneContact)localObject3).detalStatusFlag != 20) {
                paramList1.add(((PhoneContact)localObject3).unifiedCode);
              }
              ((PhoneContact)localObject3).netTypeIconId = ((MobileContactsNotFriendInfo)localObject2).conType;
              ((PhoneContact)localObject3).detalStatusFlag = ((MobileContactsNotFriendInfo)localObject2).detalStatusFlag;
              ((PhoneContact)localObject3).iTermType = ((MobileContactsNotFriendInfo)localObject2).iTermType;
              ((PhoneContact)localObject3).strTermDesc = ((MobileContactsNotFriendInfo)localObject2).strTermDesc;
              ((PhoneContact)localObject3).eNetworkType = ((MobileContactsNotFriendInfo)localObject2).eNetworkType;
              ((PhoneContact)localObject3).abilityBits = ((MobileContactsNotFriendInfo)localObject2).uAbiFlag;
              if (!TextUtils.isEmpty(((PhoneContact)localObject3).unifiedCode)) {
                this.dg.put(((PhoneContact)localObject3).unifiedCode, localObject3);
              }
              ((PhoneContact)localObject3).isHiden = ((MobileContactsNotFriendInfo)localObject2).isHide;
              this.dj.remove(((PhoneContact)localObject3).mobileNo);
              this.em.update((Entity)localObject3);
              bool2 = bool1;
              if (!QLog.isColorLevel()) {
                break label1588;
              }
              QLog.d("PhoneContact.Manager", 2, "MobileContactsNotFriendInfo; mobile=" + ((PhoneContact)localObject3).unifiedCode + " hide=" + ((PhoneContact)localObject3).isHiden);
              paramBoolean1 = true;
              break;
            }
            bool3 = bool1;
            bool2 = paramBoolean1;
            if (!QLog.isColorLevel()) {
              break label1588;
            }
            QLog.d("PhoneContact.Manager", 2, "bind nofriend not found, " + ((MobileContactsNotFriendInfo)localObject2).contactsInfoEncrypt);
            bool3 = bool1;
            bool2 = paramBoolean1;
            break label1588;
          }
          gK(paramList1);
          paramList.commit();
          paramList.end();
          bool2 = paramBoolean1;
          paramBoolean1 = bool1;
          this.tk = null;
          this.tl = null;
          this.tf = null;
          this.tg = null;
          paramInt = 6;
          if (paramBoolean2) {
            paramInt = 7;
          }
          i = paramInt;
          if (bool2) {
            i = paramInt | 0x8;
          }
          if (paramLong1 == 4294967295L)
          {
            AO(paramBoolean2);
            z(paramBoolean1, this.tm);
            this.tm.clear();
            clN();
            W(paramLong2, paramLong3);
          }
          AL(bool2);
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact.Manager", 2, "saveContactFromServer_v2 leave");
          }
          return i;
        }
        finally
        {
          paramList.end();
        }
        bool2 = false;
      }
      label1570:
      paramBoolean1 = false;
    }
    for (;;)
    {
      bool2 = bool1;
      bool1 = paramBoolean1;
      paramBoolean1 = bool2;
      break;
      label1588:
      paramBoolean1 = bool3;
      bool1 = bool2;
    }
  }
  
  public RespondQueryQQBindingStat a()
  {
    if (this.aZC) {}
    RespondQueryQQBindingStat localRespondQueryQQBindingStat;
    SharedPreferences localSharedPreferences;
    do
    {
      return null;
      localRespondQueryQQBindingStat = new RespondQueryQQBindingStat();
      localSharedPreferences = this.app.getApp().getSharedPreferences("contact_bind_info" + this.app.getAccount(), 0);
    } while (localSharedPreferences == null);
    localRespondQueryQQBindingStat.nationCode = localSharedPreferences.getString("contact_bind_info_nation", null);
    localRespondQueryQQBindingStat.mobileNo = localSharedPreferences.getString("contact_bind_info_mobile", "");
    localRespondQueryQQBindingStat.MobileUniqueNo = localSharedPreferences.getString("contact_bind_info_imei", "");
    localRespondQueryQQBindingStat.isRecommend = localSharedPreferences.getLong("contact_bind_info_recommend", 0L);
    localRespondQueryQQBindingStat.originBinder = localSharedPreferences.getLong("contact_bind_info_origin", 0L);
    localRespondQueryQQBindingStat.bindingTime = localSharedPreferences.getLong("contact_bind_info_time", 0L);
    localRespondQueryQQBindingStat.lastUsedFlag = localSharedPreferences.getLong("contact_bind_info_flag", 0L);
    localRespondQueryQQBindingStat.type = localSharedPreferences.getInt("contact_bind_type", 0);
    localRespondQueryQQBindingStat.isStopFindMatch = localSharedPreferences.getBoolean("contact_bind_stop_find_match", false);
    localRespondQueryQQBindingStat.noBindUploadContacts = localSharedPreferences.getBoolean("contact_bind_nobind_upload", false);
    localRespondQueryQQBindingStat.noBindUploadContactsLocal = localSharedPreferences.getBoolean("contact_bind_nobind_upload_local", false);
    localRespondQueryQQBindingStat.continueUploadNotbind = localSharedPreferences.getBoolean("contact_bind_nobind_continue_upload", false);
    localRespondQueryQQBindingStat.isPhoneSwitched = localSharedPreferences.getBoolean("contact_bind_is_phone_switched", false);
    return localRespondQueryQQBindingStat;
  }
  
  public abdz.b a(List<PhoneContact> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new PhoneContactManagerImp.8(this, paramList));
    return this.jdField_a_of_type_Abdz$b;
  }
  
  public PhoneContact a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (PhoneContact)this.dh.get(paramString);
    }
    return null;
  }
  
  public List<PhoneContact> a(Map<String, PhoneContact> paramMap, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    Object localObject = new ArrayList();
    if (paramMap != null) {
      ((List)localObject).addAll(paramMap.values());
    }
    if (!paramBoolean) {
      Collections.sort((List)localObject, new yun(this));
    }
    ArrayList localArrayList = new ArrayList();
    acff localacff = (acff)this.app.getManager(51);
    label198:
    label233:
    label247:
    String str2;
    int j;
    label323:
    int i;
    label343:
    int k;
    label357:
    int m;
    label379:
    Friends localFriends;
    label387:
    label403:
    int n;
    if (((List)localObject).size() > 0)
    {
      if (a() == null) {
        return null;
      }
      String str1 = a().mobileNo;
      paramMap = null;
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (PhoneContact)localIterator.next();
          if ((str1 == null) || (!str1.endsWith(((PhoneContact)localObject).mobileNo.trim())))
          {
            localObject = (PhoneContact)((PhoneContact)localObject).clone();
            if (paramMap == null)
            {
              paramMap = (Map<String, PhoneContact>)localObject;
              if (!TextUtils.isEmpty(((PhoneContact)localObject).uin))
              {
                if (!((PhoneContact)localObject).uin.equals("0")) {
                  break label233;
                }
                paramMap = null;
                if ((paramMap == null) || (paramMap.groupid < 0)) {
                  break label247;
                }
                ((PhoneContact)localObject).nickName = paramMap.getFriendNick();
                ((PhoneContact)localObject).remark = paramMap.remark;
              }
              for (paramMap = (Map<String, PhoneContact>)localObject;; paramMap = (Map<String, PhoneContact>)localObject)
              {
                break;
                paramMap = localacff.e(((PhoneContact)localObject).uin);
                break label198;
                ((PhoneContact)localObject).uin = "0";
              }
            }
            if ((!paramBoolean) && (((PhoneContact)localObject).contactID == paramMap.contactID))
            {
              str2 = paramMap.mobileNo + "|" + ((PhoneContact)localObject).mobileNo;
              if (!TextUtils.isEmpty(paramMap.uin))
              {
                j = 1;
                if ((j == 0) || (paramMap.uin.equals("0"))) {
                  break label477;
                }
                i = 1;
                if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
                  break label482;
                }
                k = 1;
                if ((k == 0) || (((PhoneContact)localObject).uin.equals("0"))) {
                  break label488;
                }
                m = 1;
                if (m != 0) {
                  break label494;
                }
                localFriends = null;
                if ((localFriends == null) || (localFriends.groupid < 0)) {
                  break label509;
                }
                m = 1;
                n = 2;
                if (i == 0) {
                  break label515;
                }
                i = 0;
                label412:
                if (m == 0) {
                  break label528;
                }
                j = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label420:
      if (i > j)
      {
        paramMap = (Map<String, PhoneContact>)localObject;
        if (k != 0)
        {
          if (m == 0) {
            break label539;
          }
          ((PhoneContact)localObject).nickName = localFriends.getFriendNick();
          ((PhoneContact)localObject).remark = localFriends.remark;
          paramMap = (Map<String, PhoneContact>)localObject;
        }
      }
      for (;;)
      {
        paramMap.mobileNo = str2;
        break;
        j = 0;
        break label323;
        label477:
        i = 0;
        break label343;
        label482:
        k = 0;
        break label357;
        label488:
        m = 0;
        break label379;
        label494:
        localFriends = localacff.e(((PhoneContact)localObject).uin);
        break label387;
        label509:
        m = 0;
        break label403;
        label515:
        i = n;
        if (j == 0) {
          break label412;
        }
        i = 1;
        break label412;
        label528:
        if (k == 0) {
          break label727;
        }
        j = 1;
        break label420;
        label539:
        ((PhoneContact)localObject).uin = "0";
        paramMap = (Map<String, PhoneContact>)localObject;
        continue;
        localArrayList.add(paramMap);
        paramMap = (Map<String, PhoneContact>)localObject;
        if (TextUtils.isEmpty(((PhoneContact)localObject).uin)) {
          break;
        }
        if (((PhoneContact)localObject).uin.equals("0")) {}
        for (paramMap = null;; paramMap = localacff.e(((PhoneContact)localObject).uin))
        {
          if ((paramMap == null) || (paramMap.groupid < 0)) {
            break label639;
          }
          ((PhoneContact)localObject).nickName = paramMap.getFriendNick();
          ((PhoneContact)localObject).remark = paramMap.remark;
          paramMap = (Map<String, PhoneContact>)localObject;
          break;
        }
        label639:
        ((PhoneContact)localObject).uin = "0";
        paramMap = (Map<String, PhoneContact>)localObject;
        break;
        if (paramMap != null) {
          localArrayList.add(paramMap);
        }
        gN(localArrayList);
        Collections.sort(localArrayList, new yup(this));
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "getContactListForContactListView sort contact cost time: " + (System.currentTimeMillis() - l));
        }
        return localArrayList;
      }
      label727:
      j = 2;
    }
  }
  
  public List<PhoneContact> a(int[] paramArrayOfInt)
  {
    long l = System.currentTimeMillis();
    List localList = this.tk;
    Object localObject = localList;
    if (localList == null) {
      localObject = cW();
    }
    localObject = new ArrayList((Collection)localObject);
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {}
    try
    {
      Collections.sort((List)localObject, new yuh(paramArrayOfInt, this.bx, (acff)this.app.getManager(51)));
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "getBindNonfriendList cost: " + (System.currentTimeMillis() - l) + ", size = " + ((List)localObject).size());
      }
      this.tk = ((List)localObject);
      return localObject;
    }
    catch (Exception paramArrayOfInt)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "getBindNonfriendList", paramArrayOfInt);
        }
      }
    }
  }
  
  public yuw a()
  {
    if (this.jdField_a_of_type_Yuw == null) {
      this.jdField_a_of_type_Yuw = new yuw();
    }
    return this.jdField_a_of_type_Yuw;
  }
  
  public void a(ajdo.a parama)
  {
    synchronized (this.D)
    {
      if (!this.D.contains(parama)) {
        this.D.add(parama);
      }
      return;
    }
  }
  
  public void a(ContactMatch paramContactMatch)
  {
    synchronized (this.bU)
    {
      if (this.rn != null)
      {
        this.rn.remove(paramContactMatch);
        this.em.remove(paramContactMatch);
      }
      return;
    }
  }
  
  public void a(PhoneContactAdd paramPhoneContactAdd)
  {
    synchronized (this.bU)
    {
      if (this.ro != null)
      {
        this.ro.remove(paramPhoneContactAdd);
        this.em.remove(paramPhoneContactAdd);
      }
      return;
    }
  }
  
  public void a(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      paramString.detalStatusFlag = ((byte)(int)paramGetOnlineInfoResp.dwStatus);
      paramString.iTermType = ((int)paramGetOnlineInfoResp.iTermType);
      paramString.eNetworkType = paramGetOnlineInfoResp.eNetworkType;
      paramString.netTypeIconId = paramGetOnlineInfoResp.eIconType;
      paramString.strTermDesc = paramGetOnlineInfoResp.strTermDesc;
      paramString.abilityBits = paramGetOnlineInfoResp.uAbiFlag;
      if (((paramGetOnlineInfoResp.iTermType == 67586L) || (paramGetOnlineInfoResp.iTermType == 66566L) || (paramGetOnlineInfoResp.iTermType == 72194L) || (paramGetOnlineInfoResp.iTermType == 65804L) || (paramGetOnlineInfoResp.iTermType == 72706L)) && (paramGetOnlineInfoResp.eNetworkType != 1)) {
        paramString.netTypeIconIdIphoneOrWphoneNoWifi = paramGetOnlineInfoResp.eIconType;
      }
      EE(2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), akwn.class);
    localNewIntent.putExtra("req_type", 35);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.app.startServlet(localNewIntent);
  }
  
  public void a(List<String> paramList, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveLastLoginList, size = " + paramList.size() + ", stamp " + paramLong1 + ", interval = " + paramLong2);
    }
    this.pref.edit().putLong("key_req_last_login_time", System.currentTimeMillis()).putLong("key_login_info_timestamp", paramLong1).putLong("key_req_login_interval", Math.max(43200000L, 1000L * paramLong2)).commit();
    HashSet localHashSet = new HashSet(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      PhoneContact localPhoneContact = (PhoneContact)this.di.get(str.toUpperCase());
      if (localPhoneContact != null) {
        localHashSet.add(localPhoneContact.unifiedCode);
      } else if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "saveLastLoginList, wtf pc null " + str.toUpperCase());
      }
    }
    this.bx = localHashSet;
    j(this.bx);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveLastLoginInfo: tempSet.size=" + localHashSet.size());
    }
  }
  
  public boolean a(RecommendedContactInfo paramRecommendedContactInfo)
  {
    if (!TextUtils.isEmpty(paramRecommendedContactInfo.contactsInfoEncrypt))
    {
      paramRecommendedContactInfo.contactsInfoEncrypt = paramRecommendedContactInfo.contactsInfoEncrypt.toUpperCase();
      PhoneContact localPhoneContact = (PhoneContact)this.di.get(paramRecommendedContactInfo.contactsInfoEncrypt);
      if (localPhoneContact != null)
      {
        paramRecommendedContactInfo.unicode = c(paramRecommendedContactInfo.MobileNoMask, localPhoneContact.mobileNo);
        paramRecommendedContactInfo.name = localPhoneContact.name;
        if ((!TextUtils.isEmpty(paramRecommendedContactInfo.unicode)) && (!TextUtils.isEmpty(paramRecommendedContactInfo.name))) {
          return true;
        }
      }
      else
      {
        QLog.d("newerguide", 2, "test .. fillNewerGuideInfo no contact " + paramRecommendedContactInfo.contactsInfoEncrypt);
      }
    }
    return false;
  }
  
  public boolean a(RespondQueryQQBindingStat paramRespondQueryQQBindingStat, String paramString)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("saveBindInfo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(this.aZC), paramRespondQueryQQBindingStat, Integer.valueOf(this.cbf), paramString }));
    }
    if (this.aZC) {
      return false;
    }
    if (this.cbf == -1) {
      this.cbf = a(a());
    }
    int i = a(paramRespondQueryQQBindingStat);
    if (this.cbf != i) {
      bool = true;
    }
    paramString = paramRespondQueryQQBindingStat;
    if (paramRespondQueryQQBindingStat == null) {
      paramString = new RespondQueryQQBindingStat();
    }
    paramRespondQueryQQBindingStat = this.pref.edit();
    paramRespondQueryQQBindingStat.putString("contact_bind_info_mobile", paramString.mobileNo);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_nation", paramString.nationCode);
    paramRespondQueryQQBindingStat.putString("contact_bind_info_imei", paramString.MobileUniqueNo);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_recommend", paramString.isRecommend);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_origin", paramString.originBinder);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_time", paramString.bindingTime);
    paramRespondQueryQQBindingStat.putLong("contact_bind_info_flag", paramString.lastUsedFlag);
    paramRespondQueryQQBindingStat.putInt("contact_bind_type", paramString.type);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_stop_find_match", paramString.isStopFindMatch);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_nobind_upload", paramString.noBindUploadContacts);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_nobind_upload_local", paramString.noBindUploadContactsLocal);
    paramRespondQueryQQBindingStat.putBoolean("contact_bind_is_phone_switched", paramString.isPhoneSwitched);
    this.isPhoneSwitched = paramString.isPhoneSwitched;
    paramRespondQueryQQBindingStat.commit();
    a(paramString);
    return bool;
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.em.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.em.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.em.update(paramEntity);
      }
    }
    QLog.d("PhoneContact.Manager", 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean aC(boolean paramBoolean)
  {
    int i;
    long l1;
    long l2;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      i = 1;
      l1 = anaz.gQ();
      if (i == 0) {
        this.KI = this.app.getPreferences().getLong("user_setting_flag_" + this.app.getAccount(), 0L);
      }
      l2 = Math.abs(l1 - this.KI);
      if (l2 >= 3600L) {
        break label257;
      }
      boolean bool = Uw();
      if (i == 0) {
        bool = Uy();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, "checkAndUploadContact,  has: " + bool + ",  state: " + xy());
      }
      if (!bool) {
        break label257;
      }
      if (i == 0) {
        break label241;
      }
      ThreadManager.excute(new PhoneContactManagerImp.22(this, paramBoolean), 16, null, false);
    }
    label171:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("checkAndUploadContact [%s, %s, %s, %s]", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(this.KI), Boolean.valueOf(paramBoolean) }));
      }
      AP(false);
      return paramBoolean;
      i = 0;
      break;
      label241:
      clX();
      if (!paramBoolean) {
        break label171;
      }
      this.boM = true;
      break label171;
    }
  }
  
  /* Error */
  public boolean ac(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +40 -> 49
    //   12: ldc_w 297
    //   15: iconst_2
    //   16: new 243	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 2154
    //   26: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 1739
    //   36: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_2
    //   40: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: invokevirtual 1075	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   59: astore 9
    //   61: getstatic 2157	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   64: astore 8
    //   66: new 243	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 2159
    //   76: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 2161
    //   86: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_1
    //   93: aload 9
    //   95: aload 8
    //   97: iconst_4
    //   98: anewarray 130	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: ldc_w 2163
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: ldc_w 2165
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: ldc_w 2167
    //   118: aastore
    //   119: dup
    //   120: iconst_3
    //   121: ldc 132
    //   123: aastore
    //   124: aload_1
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokestatic 1087	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   130: astore 8
    //   132: aload_2
    //   133: astore_1
    //   134: aload 6
    //   136: astore_2
    //   137: aload 8
    //   139: invokeinterface 1122 1 0
    //   144: ifeq +361 -> 505
    //   147: aload 8
    //   149: aload 8
    //   151: ldc_w 2163
    //   154: invokeinterface 1109 2 0
    //   159: invokeinterface 2170 2 0
    //   164: lstore_3
    //   165: getstatic 2157	android/provider/ContactsContract$Data:CONTENT_URI	Landroid/net/Uri;
    //   168: astore 6
    //   170: new 243	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 2172
    //   180: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: lload_3
    //   184: invokevirtual 1258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   187: ldc_w 2174
    //   190: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 2167
    //   196: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 2176
    //   202: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc_w 2178
    //   208: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 2180
    //   214: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 138
    //   219: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 2176
    //   225: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: iconst_2
    //   229: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc_w 2161
    //   235: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore 7
    //   243: aload 9
    //   245: aload 6
    //   247: iconst_5
    //   248: anewarray 130	java/lang/String
    //   251: dup
    //   252: iconst_0
    //   253: ldc_w 2163
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: ldc_w 2165
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: ldc_w 2167
    //   268: aastore
    //   269: dup
    //   270: iconst_3
    //   271: ldc 132
    //   273: aastore
    //   274: dup
    //   275: iconst_4
    //   276: ldc 138
    //   278: aastore
    //   279: aload 7
    //   281: aconst_null
    //   282: aconst_null
    //   283: invokestatic 1087	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   286: astore 6
    //   288: aload 6
    //   290: astore_2
    //   291: aload_2
    //   292: invokeinterface 1102 1 0
    //   297: ifeq +96 -> 393
    //   300: aload_2
    //   301: aload_2
    //   302: ldc 132
    //   304: invokeinterface 1109 2 0
    //   309: invokeinterface 1111 2 0
    //   314: invokestatic 1117	yui:hN	(Ljava/lang/String;)Ljava/lang/String;
    //   317: astore 7
    //   319: aload_1
    //   320: invokestatic 1117	yui:hN	(Ljava/lang/String;)Ljava/lang/String;
    //   323: astore 6
    //   325: aload 6
    //   327: astore_1
    //   328: aload 7
    //   330: aload_1
    //   331: invokestatic 2183	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   334: ifne +35 -> 369
    //   337: new 243	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 2185
    //   347: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload 7
    //   352: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: aload_1
    //   359: invokestatic 2183	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   362: istore 5
    //   364: iload 5
    //   366: ifeq +27 -> 393
    //   369: aload_2
    //   370: ifnull +9 -> 379
    //   373: aload_2
    //   374: invokeinterface 1127 1 0
    //   379: aload 8
    //   381: ifnull +10 -> 391
    //   384: aload 8
    //   386: invokeinterface 1127 1 0
    //   391: iconst_1
    //   392: ireturn
    //   393: aload_2
    //   394: astore 7
    //   396: aload_1
    //   397: astore 6
    //   399: aload_2
    //   400: ifnull +157 -> 557
    //   403: aload_2
    //   404: invokeinterface 1127 1 0
    //   409: aload_2
    //   410: astore 7
    //   412: aload_1
    //   413: astore 6
    //   415: goto +142 -> 557
    //   418: aload_2
    //   419: astore 7
    //   421: aload_1
    //   422: astore 6
    //   424: aload_2
    //   425: ifnull +132 -> 557
    //   428: aload_2
    //   429: invokeinterface 1127 1 0
    //   434: aload_2
    //   435: astore 7
    //   437: aload_1
    //   438: astore 6
    //   440: goto +117 -> 557
    //   443: astore_2
    //   444: aload 8
    //   446: astore_1
    //   447: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +14 -> 464
    //   453: ldc_w 297
    //   456: iconst_2
    //   457: ldc_w 2187
    //   460: aload_2
    //   461: invokestatic 1124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   464: aload_1
    //   465: ifnull +9 -> 474
    //   468: aload_1
    //   469: invokeinterface 1127 1 0
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_1
    //   477: aload_2
    //   478: ifnull +9 -> 487
    //   481: aload_2
    //   482: invokeinterface 1127 1 0
    //   487: aload_1
    //   488: athrow
    //   489: astore_1
    //   490: aload 8
    //   492: astore_2
    //   493: aload_2
    //   494: ifnull +9 -> 503
    //   497: aload_2
    //   498: invokeinterface 1127 1 0
    //   503: aload_1
    //   504: athrow
    //   505: aload 8
    //   507: ifnull -33 -> 474
    //   510: aload 8
    //   512: invokeinterface 1127 1 0
    //   517: goto -43 -> 474
    //   520: astore_1
    //   521: aload 7
    //   523: astore_2
    //   524: goto -31 -> 493
    //   527: astore 6
    //   529: aload_1
    //   530: astore_2
    //   531: aload 6
    //   533: astore_1
    //   534: goto -41 -> 493
    //   537: astore_2
    //   538: aconst_null
    //   539: astore_1
    //   540: goto -93 -> 447
    //   543: astore_1
    //   544: goto -67 -> 477
    //   547: astore 6
    //   549: goto -131 -> 418
    //   552: astore 6
    //   554: goto -136 -> 418
    //   557: aload 7
    //   559: astore_2
    //   560: aload 6
    //   562: astore_1
    //   563: goto -426 -> 137
    //   566: astore 6
    //   568: goto -150 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	PhoneContactManagerImp
    //   0	571	1	paramString1	String
    //   0	571	2	paramString2	String
    //   164	20	3	l	long
    //   362	3	5	bool	boolean
    //   4	435	6	localObject1	Object
    //   527	5	6	localObject2	Object
    //   547	1	6	localException1	Exception
    //   552	9	6	localException2	Exception
    //   566	1	6	localException3	Exception
    //   1	557	7	str	String
    //   64	447	8	localObject3	Object
    //   59	185	9	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   137	165	443	java/lang/Exception
    //   373	379	443	java/lang/Exception
    //   403	409	443	java/lang/Exception
    //   428	434	443	java/lang/Exception
    //   481	487	443	java/lang/Exception
    //   487	489	443	java/lang/Exception
    //   291	325	476	finally
    //   328	364	476	finally
    //   137	165	489	finally
    //   373	379	489	finally
    //   403	409	489	finally
    //   428	434	489	finally
    //   481	487	489	finally
    //   487	489	489	finally
    //   61	132	520	finally
    //   447	464	527	finally
    //   61	132	537	java/lang/Exception
    //   165	288	543	finally
    //   328	364	547	java/lang/Exception
    //   165	288	552	java/lang/Exception
    //   291	325	566	java/lang/Exception
  }
  
  public boolean ad(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "addContactAndUpload " + paramString1 + ", " + paramString2);
    }
    ContentResolver localContentResolver = this.app.getApp().getContentResolver();
    try
    {
      ContentValues localContentValues = new ContentValues();
      long l = ContentUris.parseId(localContentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, localContentValues));
      if (l <= 0L) {
        return false;
      }
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l));
      localContentValues.put("mimetype", "vnd.android.cursor.item/name");
      localContentValues.put("data1", paramString1);
      localContentResolver.insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      localContentValues.clear();
      localContentValues.put("raw_contact_id", Long.valueOf(l));
      localContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
      localContentValues.put("data1", paramString2);
      localContentValues.put("data2", Integer.valueOf(2));
      localContentResolver.insert(ContactsContract.Data.CONTENT_URI, localContentValues);
      AM(false);
      return true;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public void ao(byte[] paramArrayOfByte)
  {
    this.sessionId = paramArrayOfByte;
    this.pref.edit().putString("session_id", new String(paramArrayOfByte)).commit();
  }
  
  public PhoneContact b(String paramString)
  {
    if (this.boL) {
      return (PhoneContact)this.df.get(paramString);
    }
    if (this.em != null) {
      return (PhoneContact)this.em.find(PhoneContact.class, paramString);
    }
    return null;
  }
  
  public void b(ajdo.a parama)
  {
    synchronized (this.D)
    {
      this.D.remove(parama);
      return;
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), akwn.class);
    localNewIntent.putExtra("req_type", 19);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.app.startServlet(localNewIntent);
  }
  
  public ArrayList<PhoneContact> bT()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = a(null);
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("generateRandomList,[%s, %s]", new Object[] { Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return new ArrayList();
    }
    acff localacff = (acff)this.app.getManager(51);
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PhoneContact)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((PhoneContact)localObject2).samFriend > 0) && (!localacff.w(((PhoneContact)localObject2).unifiedCode, true))) {
        localArrayList.add(localObject2);
      }
    }
    if (localArrayList.size() < this.cbj) {
      localObject1 = localArrayList;
    }
    for (;;)
    {
      try
      {
        localObject2 = this.bx;
        Collections.sort((List)localObject1, new yuh(new int[] { 3, 4 }, (Set)localObject2, localacff));
        if (QLog.isColorLevel()) {
          QLog.i("PhoneContact.Manager", 2, String.format("generateRandomList,[%s, %s, %s]", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()), Integer.valueOf(localArrayList.size()), Long.valueOf(System.currentTimeMillis() - l) }));
        }
        return localObject1;
        localObject1 = new ArrayList(this.cbj);
        int i = 0;
        if (i < this.cbj)
        {
          ((ArrayList)localObject1).add((PhoneContact)localArrayList.remove(this.mRandom.nextInt(localArrayList.size())));
          i += 1;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        QLog.e("PhoneContact.Manager", 1, "" + localIllegalArgumentException, localIllegalArgumentException);
      }
    }
  }
  
  public ArrayList<Entity> bU()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.bU)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqDataContactBinded != null) {
        localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqDataContactBinded);
      }
      if ((this.rn != null) && (this.rn.size() > 0))
      {
        localArrayList.addAll(this.rn);
        if (QLog.isColorLevel())
        {
          Iterator localIterator = this.rn.iterator();
          if (localIterator.hasNext())
          {
            ContactMatch localContactMatch = (ContactMatch)localIterator.next();
            QLog.d("PhoneContact.Manager", 2, "getRecommendContact|mobileNo : " + localContactMatch.mobileNo + "|size : " + this.rn.size());
          }
        }
      }
    }
    return localArrayList1;
  }
  
  public ArrayList<PhoneContactAdd> bV()
  {
    return this.ro;
  }
  
  public void bd(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "hideContact mobile=" + paramString + "; hide=" + paramBoolean);
    }
    Object localObject = c(paramString);
    if (localObject != null)
    {
      localObject = new AddressBookItem(((PhoneContact)localObject).mobileNo, ((PhoneContact)localObject).name);
      NewIntent localNewIntent = new NewIntent(this.app.getApplication(), akwn.class);
      localNewIntent.putExtra("req_type", 34);
      localNewIntent.putExtra("param_hiden_mobile", (Serializable)localObject);
      localNewIntent.putExtra("param_hiden_flag", paramBoolean);
      localNewIntent.putExtra("unique_phone_no", paramString);
      this.app.startServlet(localNewIntent);
    }
  }
  
  public void be(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "changeHidenStatus: mobile = " + paramString + ";hide=" + paramBoolean);
    }
    paramString = c(paramString);
    if ((paramString != null) && (paramString.isHiden != paramBoolean))
    {
      paramString.isHiden = paramBoolean;
      this.em.update(paramString);
    }
  }
  
  public void bi(boolean paramBoolean1, boolean paramBoolean2)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if ((localRespondQueryQQBindingStat == null) || (localRespondQueryQQBindingStat.nationCode == null) || (localRespondQueryQQBindingStat.mobileNo == null)) {
      return;
    }
    this.KH = NetConnInfoCenter.getServerTimeMillis();
    this.pref.edit().putLong("last_unbind_mobile_time", this.KH).apply();
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, String.format("unbindMobile [%s]", new Object[] { Long.valueOf(this.KH) }));
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), akwn.class);
    localNewIntent.putExtra("req_type", 20);
    localNewIntent.putExtra("country_code", localRespondQueryQQBindingStat.nationCode);
    localNewIntent.putExtra("phone_number", localRespondQueryQQBindingStat.mobileNo);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.app.startServlet(localNewIntent);
  }
  
  public void bv(int paramInt, String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        if (paramString != null)
        {
          int i = paramString.optInt("all_entrance_num");
          if (i > 0) {
            cbg = i;
          }
          this.A.edit().putInt("all_entrance_num", cbg).commit();
          this.A.edit().putInt("key_config_version", paramInt).commit();
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "updateConfigs error " + paramString.getMessage());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "updateAllEntranceConfig|allEntranceNum = " + cbg);
    }
  }
  
  public PhoneContact c(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact", 2, "queryContactByCodeNumber codeNumber is null");
      }
    }
    do
    {
      return null;
      if (this.boL) {
        return (PhoneContact)this.dg.get(paramString);
      }
    } while (this.em == null);
    return (PhoneContact)this.em.find(PhoneContact.class, "mobileCode=?", new String[] { paramString });
  }
  
  public void c(ArrayList<PhoneContact> paramArrayList, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList1, int paramInt)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("multiMakePhoneContactAddInfo|sourceId : ").append(paramInt);
      if (paramArrayList == null)
      {
        ??? = "|phoneList is null";
        localObject2 = ((StringBuilder)localObject2).append((String)???);
        if (paramArrayList1 != null) {
          break label120;
        }
        ??? = "|addlist is null";
        label52:
        QLog.d("PhoneContact.Manager", 2, (String)???);
      }
    }
    else
    {
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()) && (paramArrayList1 != null) && (!paramArrayList1.isEmpty())) {
        break label148;
      }
    }
    label120:
    while ((paramInt != 3078) && (paramInt != 3079))
    {
      return;
      ??? = "|phoneList.size : " + paramArrayList.size();
      break;
      ??? = "|addlist.size : " + paramArrayList1.size();
      break label52;
    }
    label148:
    synchronized (this.bU)
    {
      localObject2 = this.em.getTransaction();
    }
    for (;;)
    {
      ArrayList localArrayList;
      Object localObject3;
      Object localObject4;
      try
      {
        ((EntityTransaction)localObject2).begin();
        localArrayList = new ArrayList();
        if (this.ro == null) {
          this.ro = new ArrayList(localArrayList.size());
        }
        paramArrayList1 = paramArrayList1.iterator();
        Object localObject5;
        if (paramArrayList1.hasNext())
        {
          localObject3 = (FriendListHandler.AddBatchPhoneFriendResult)paramArrayList1.next();
          if (((FriendListHandler.AddBatchPhoneFriendResult)localObject3).sendResult != 0) {
            continue;
          }
          localObject4 = this.ro.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label675;
          }
          localObject5 = (PhoneContactAdd)((Iterator)localObject4).next();
          if (!((PhoneContactAdd)localObject5).unifiedCode.equals(((FriendListHandler.AddBatchPhoneFriendResult)localObject3).mobile)) {
            continue;
          }
          ((PhoneContactAdd)localObject5).timestamp = anaz.gQ();
          a((Entity)localObject5);
          paramInt = 0;
          if (paramInt == 0) {
            continue;
          }
          localObject4 = new PhoneContactAdd();
          ((PhoneContactAdd)localObject4).unifiedCode = ((FriendListHandler.AddBatchPhoneFriendResult)localObject3).mobile;
          ((PhoneContactAdd)localObject4).timestamp = anaz.gQ();
          ((PhoneContactAdd)localObject4).remindInfo = this.app.getApp().getApplicationContext().getResources().getString(2131696820);
          localArrayList.add(localObject4);
          continue;
        }
        paramArrayList1 = paramArrayList1.name;
      }
      catch (Resources.NotFoundException paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, "multiMakePhoneContactAddInfo", paramArrayList);
        }
        ((EntityTransaction)localObject2).end();
        return;
        paramArrayList = finally;
        throw paramArrayList;
        if (localArrayList.isEmpty()) {
          break label662;
        }
        localObject3 = localArrayList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label544;
        }
        localObject4 = (PhoneContactAdd)((Iterator)localObject3).next();
        localObject5 = paramArrayList.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          paramArrayList1 = (PhoneContact)((Iterator)localObject5).next();
          if (!paramArrayList1.unifiedCode.equals(((PhoneContactAdd)localObject4).unifiedCode)) {
            continue;
          }
          if (paramArrayList1.name == null)
          {
            paramArrayList1 = paramArrayList1.nickName;
            ((PhoneContactAdd)localObject4).name = paramArrayList1;
            a((Entity)localObject4);
          }
        }
        else
        {
          continue;
        }
      }
      finally
      {
        ((EntityTransaction)localObject2).end();
      }
      continue;
      label544:
      this.ro.addAll(localArrayList);
      if ((this.rn != null) && (!this.rn.isEmpty()))
      {
        paramArrayList = this.rn.iterator();
        for (;;)
        {
          if (!paramArrayList.hasNext()) {
            break label662;
          }
          paramArrayList1 = (ContactMatch)paramArrayList.next();
          localObject3 = localArrayList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (PhoneContactAdd)((Iterator)localObject3).next();
            if (!paramArrayList1.unifiedCode.equals(((PhoneContactAdd)localObject4).unifiedCode)) {
              break;
            }
            paramArrayList.remove();
            this.em.remove(paramArrayList1);
          }
        }
      }
      label662:
      ((EntityTransaction)localObject2).commit();
      ((EntityTransaction)localObject2).end();
      continue;
      label675:
      paramInt = 1;
    }
  }
  
  public List<PhoneContact> cT()
  {
    return a(new int[] { 1, 2, 4 });
  }
  
  public List<PhoneContact> cU()
  {
    Object localObject2 = this.tl;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = cX();
    }
    Object localObject1 = new ArrayList((Collection)localObject1);
    try
    {
      localObject2 = this.bx;
      acff localacff = (acff)this.app.getManager(51);
      Collections.sort((List)localObject1, new yuh(new int[] { 6, 5, 1, 4 }, (Set)localObject2, localacff));
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "getBindAllFriendList size = " + ((List)localObject1).size());
      }
      this.tl = ((List)localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhoneContact.Manager", 2, "getBindAllFriendList", localException);
        }
      }
    }
  }
  
  public List<PhoneContact> cV()
  {
    List localList = this.tk;
    if (localList == null) {
      localList = cW();
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (localPhoneContact.isNewRecommend) {
          localArrayList.add(localPhoneContact);
        }
      }
      this.tk = localList;
      return localArrayList;
    }
  }
  
  public List<PhoneContact> cY()
  {
    if (this.boL)
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.addAll(this.df.values());
        return localArrayList;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneContact.Manager", 2, localException.toString());
        }
        return this.em.query(PhoneContact.class);
      }
    }
    return this.em.query(PhoneContact.class);
  }
  
  public List<List<PhoneContact>> cZ()
  {
    Object localObject1 = null;
    long l = System.currentTimeMillis();
    if (this.aZC) {
      localObject1 = new ArrayList(0);
    }
    Object localObject2;
    label353:
    do
    {
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      acff localacff;
      do
      {
        return localObject1;
        if (this.ti != null) {
          break label467;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).addAll(this.df.values());
        Collections.sort((List)localObject2, new yuj(this));
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        localacff = (acff)this.app.getManager(51);
        if (((List)localObject2).size() <= 0) {
          break;
        }
      } while (a() == null);
      String str = a().mobileNo;
      Iterator localIterator = ((List)localObject2).iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = (PhoneContact)localIterator.next();
        if ((str == null) || (!str.endsWith(((PhoneContact)localObject2).mobileNo.trim())))
        {
          PhoneContact localPhoneContact = (PhoneContact)((PhoneContact)localObject2).clone();
          if (TextUtils.isEmpty(localPhoneContact.uin))
          {
            if (localObject1 == null) {
              localObject1 = localPhoneContact;
            }
            for (;;)
            {
              break;
              if (localPhoneContact.contactID == ((PhoneContact)localObject1).contactID)
              {
                ((PhoneContact)localObject1).mobileNo = (((PhoneContact)localObject1).mobileNo + "|" + localPhoneContact.mobileNo);
                if (!QLog.isColorLevel()) {
                  break label394;
                }
                QLog.d("PhoneContact.Manager", 2, "getContactListForDisplay: conbine contact contact name is:" + ((PhoneContact)localObject1).name + "uin is :" + ((PhoneContact)localObject1).uin + "number is:" + ((PhoneContact)localObject1).mobileNo);
              }
              else
              {
                localArrayList2.add(localObject1);
                localObject1 = localPhoneContact;
              }
            }
          }
          if (localPhoneContact.uin.equals("0"))
          {
            localObject2 = null;
            if ((localObject2 == null) || (((Friends)localObject2).groupid < 0)) {
              break label412;
            }
            localPhoneContact.nickName = ((Friends)localObject2).getFriendNick();
            localPhoneContact.remark = ((Friends)localObject2).remark;
          }
          for (;;)
          {
            localArrayList1.add(localPhoneContact);
            break;
            localObject2 = localacff.e(localPhoneContact.uin);
            break label353;
            localPhoneContact.uin = "0";
          }
        }
      }
      if (localObject1 != null) {
        localArrayList2.add(localObject1);
      }
      localObject1 = new yuk(this);
      Collections.sort(localArrayList1, (Comparator)localObject1);
      Collections.sort(localArrayList2, (Comparator)localObject1);
      this.ti = localArrayList1;
      this.tj = localArrayList2;
      localObject2 = new ArrayList();
      gN(this.ti);
      gN(this.tj);
      ((List)localObject2).add(this.ti);
      ((List)localObject2).add(this.tj);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    label394:
    label412:
    label467:
    QLog.d("PhoneContact.Manager", 2, "sort contact cost time: " + (System.currentTimeMillis() - l));
    return localObject2;
  }
  
  void clG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$b != null)
    {
      try
      {
        if (this.aZC) {
          return;
        }
        this.app.getApp().getContentResolver().unregisterContentObserver(this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$b);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$b.f(null);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhoneContact", 2, localThrowable.getMessage(), localThrowable);
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$b = null;
      return;
    }
  }
  
  public void clH()
  {
    i(true, true, 14);
  }
  
  public void clI()
  {
    if (!this.boL)
    {
      this.df.clear();
      this.dh.clear();
      this.dg.clear();
      this.di.clear();
      ??? = this.em.query(PhoneContact.class);
      if (??? != null)
      {
        ??? = ((List)???).iterator();
        while (((Iterator)???).hasNext())
        {
          PhoneContact localPhoneContact = (PhoneContact)((Iterator)???).next();
          localPhoneContact.pinyinFirst = yui.hO(localPhoneContact.pinyinInitial);
          this.df.put(localPhoneContact.mobileNo, localPhoneContact);
          if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!localPhoneContact.uin.equals("0"))) {
            this.dh.put(localPhoneContact.uin, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.unifiedCode)) {
            this.dg.put(localPhoneContact.unifiedCode, localPhoneContact);
          }
          if (!TextUtils.isEmpty(localPhoneContact.md5)) {
            this.di.put(localPhoneContact.md5, localPhoneContact);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "No contacts.");
      }
    }
    synchronized (this.bU)
    {
      this.rn = ((ArrayList)this.em.query(ContactMatch.class, false, null, null, null, null, null, null));
      this.ro = ((ArrayList)this.em.query(PhoneContactAdd.class, false, null, null, null, null, null, null));
      cbg = this.A.getInt("all_entrance_num", 20);
      clE();
      this.boL = true;
      EE(1);
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("initContactCache [%s]", new Object[] { Integer.valueOf(cbg) }));
      }
      return;
    }
  }
  
  public void clK()
  {
    EE(1);
  }
  
  public void clL()
  {
    this.app.execute(this.eM);
  }
  
  /* Error */
  public void clO()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +85 -> 92
    //   10: new 243	java/lang/StringBuilder
    //   13: dup
    //   14: bipush 50
    //   16: invokespecial 1253	java/lang/StringBuilder:<init>	(I)V
    //   19: astore_2
    //   20: aload_2
    //   21: ldc_w 2359
    //   24: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: astore_3
    //   28: aload_0
    //   29: getfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   32: bipush 8
    //   34: if_icmpne +86 -> 120
    //   37: aload_3
    //   38: iload_1
    //   39: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc_w 2361
    //   47: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   54: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_2
    //   59: ldc_w 1425
    //   62: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   68: aload_0
    //   69: getfield 159	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:KE	J
    //   72: lsub
    //   73: ldc2_w 1271
    //   76: ldiv
    //   77: invokevirtual 1258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc_w 297
    //   84: iconst_2
    //   85: aload_2
    //   86: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: getfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   96: bipush 8
    //   98: if_icmpeq +19 -> 117
    //   101: aload_0
    //   102: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   105: ifne +12 -> 117
    //   108: aload_0
    //   109: invokevirtual 685	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:pS	()Ljava/lang/String;
    //   112: astore_2
    //   113: aload_2
    //   114: ifnonnull +11 -> 125
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: iconst_0
    //   121: istore_1
    //   122: goto -85 -> 37
    //   125: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   128: aload_0
    //   129: getfield 159	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:KE	J
    //   132: lsub
    //   133: ldc2_w 125
    //   136: lcmp
    //   137: iflt -20 -> 117
    //   140: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +13 -> 156
    //   146: ldc_w 297
    //   149: iconst_2
    //   150: ldc_w 2363
    //   153: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: getfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   160: iconst_2
    //   161: if_icmpeq +19 -> 180
    //   164: aload_0
    //   165: getfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   168: iconst_3
    //   169: if_icmpeq +11 -> 180
    //   172: aload_0
    //   173: getfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   176: iconst_4
    //   177: if_icmpne +7 -> 184
    //   180: aload_0
    //   181: invokespecial 748	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:clT	()V
    //   184: aload_0
    //   185: bipush 8
    //   187: putfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   190: aload_0
    //   191: invokespecial 745	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:clM	()V
    //   194: aload_0
    //   195: getfield 717	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   198: ifnonnull +23 -> 221
    //   201: aload_0
    //   202: new 8	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator
    //   205: dup
    //   206: aload_0
    //   207: aconst_null
    //   208: invokespecial 2366	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$1;)V
    //   211: putfield 717	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   214: aload_0
    //   215: getfield 717	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   218: invokevirtual 2369	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:start	()V
    //   221: aload_0
    //   222: invokespecial 2371	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:bS	()Ljava/util/ArrayList;
    //   225: astore_3
    //   226: aload_3
    //   227: astore_2
    //   228: aload_3
    //   229: ifnonnull +12 -> 241
    //   232: new 215	java/util/ArrayList
    //   235: dup
    //   236: iconst_0
    //   237: invokespecial 1311	java/util/ArrayList:<init>	(I)V
    //   240: astore_2
    //   241: aload_0
    //   242: getfield 638	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boR	Z
    //   245: ifeq +14 -> 259
    //   248: aload_0
    //   249: iconst_1
    //   250: aload_2
    //   251: invokevirtual 854	java/util/ArrayList:size	()I
    //   254: iconst_0
    //   255: iconst_0
    //   256: invokespecial 769	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:F	(IIII)V
    //   259: new 809	mqq/app/NewIntent
    //   262: dup
    //   263: aload_0
    //   264: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   267: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   270: ldc_w 811
    //   273: invokespecial 814	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   276: astore_3
    //   277: aload_3
    //   278: ldc_w 816
    //   281: bipush 31
    //   283: invokevirtual 820	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   286: pop
    //   287: aload_3
    //   288: ldc_w 822
    //   291: aload_0
    //   292: invokevirtual 685	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:pS	()Ljava/lang/String;
    //   295: invokevirtual 825	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   298: pop
    //   299: aload_3
    //   300: ldc_w 836
    //   303: lconst_0
    //   304: invokevirtual 839	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   307: pop
    //   308: aload_3
    //   309: ldc_w 841
    //   312: iconst_0
    //   313: invokevirtual 820	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   316: pop
    //   317: aload_3
    //   318: ldc_w 2373
    //   321: aload_2
    //   322: invokevirtual 830	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   325: pop
    //   326: aload_3
    //   327: ldc_w 265
    //   330: iconst_0
    //   331: newarray byte
    //   333: invokevirtual 844	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   336: pop
    //   337: aload_3
    //   338: ldc_w 846
    //   341: iconst_0
    //   342: invokevirtual 849	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   345: pop
    //   346: aload_0
    //   347: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   350: aload_3
    //   351: invokevirtual 853	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   354: goto -237 -> 117
    //   357: astore_2
    //   358: aload_0
    //   359: monitorexit
    //   360: aload_2
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	PhoneContactManagerImp
    //   1	121	1	bool	boolean
    //   19	303	2	localObject1	Object
    //   357	4	2	localObject2	Object
    //   27	324	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   4	37	357	finally
    //   37	92	357	finally
    //   92	113	357	finally
    //   125	156	357	finally
    //   156	180	357	finally
    //   180	184	357	finally
    //   184	221	357	finally
    //   221	226	357	finally
    //   232	241	357	finally
    //   241	259	357	finally
    //   259	354	357	finally
  }
  
  /* Error */
  public void clU()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +77 -> 82
    //   8: new 243	java/lang/StringBuilder
    //   11: dup
    //   12: bipush 50
    //   14: invokespecial 1253	java/lang/StringBuilder:<init>	(I)V
    //   17: astore_1
    //   18: aload_1
    //   19: ldc_w 2376
    //   22: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: getfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   29: invokevirtual 417	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_1
    //   34: ldc_w 2378
    //   37: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   44: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_1
    //   49: ldc_w 1425
    //   52: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   58: aload_0
    //   59: getfield 159	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:KE	J
    //   62: lsub
    //   63: ldc2_w 1271
    //   66: ldiv
    //   67: invokevirtual 1258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc_w 297
    //   74: iconst_2
    //   75: aload_1
    //   76: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: getfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   86: iconst_4
    //   87: if_icmpeq +17 -> 104
    //   90: aload_0
    //   91: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   94: ifne +10 -> 104
    //   97: aload_0
    //   98: invokevirtual 685	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:pS	()Ljava/lang/String;
    //   101: ifnonnull +37 -> 138
    //   104: aload_0
    //   105: getfield 155	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boJ	Z
    //   108: ifeq +27 -> 135
    //   111: aload_0
    //   112: getfield 259	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:pref	Landroid/content/SharedPreferences;
    //   115: invokeinterface 667 1 0
    //   120: ldc_w 1956
    //   123: iconst_1
    //   124: invokeinterface 754 3 0
    //   129: invokeinterface 756 1 0
    //   134: pop
    //   135: aload_0
    //   136: monitorexit
    //   137: return
    //   138: invokestatic 984	java/lang/System:currentTimeMillis	()J
    //   141: aload_0
    //   142: getfield 159	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:KE	J
    //   145: lsub
    //   146: ldc2_w 125
    //   149: lcmp
    //   150: iflt -15 -> 135
    //   153: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +13 -> 169
    //   159: ldc_w 297
    //   162: iconst_2
    //   163: ldc_w 2380
    //   166: invokestatic 420	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_0
    //   170: getfield 259	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:pref	Landroid/content/SharedPreferences;
    //   173: invokeinterface 667 1 0
    //   178: ldc_w 1956
    //   181: iconst_0
    //   182: invokeinterface 754 3 0
    //   187: invokeinterface 756 1 0
    //   192: pop
    //   193: aload_0
    //   194: iconst_4
    //   195: putfield 165	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:cbf	I
    //   198: aload_0
    //   199: invokespecial 745	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:clM	()V
    //   202: aload_0
    //   203: getfield 717	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   206: ifnonnull +23 -> 229
    //   209: aload_0
    //   210: new 8	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator
    //   213: dup
    //   214: aload_0
    //   215: aconst_null
    //   216: invokespecial 2366	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$1;)V
    //   219: putfield 717	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   222: aload_0
    //   223: getfield 717	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$UploadProgressGenerator	Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator;
    //   226: invokevirtual 2369	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$UploadProgressGenerator:start	()V
    //   229: aload_0
    //   230: invokespecial 2371	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:bS	()Ljava/util/ArrayList;
    //   233: astore_2
    //   234: aload_2
    //   235: astore_1
    //   236: aload_2
    //   237: ifnonnull +12 -> 249
    //   240: new 215	java/util/ArrayList
    //   243: dup
    //   244: iconst_0
    //   245: invokespecial 1311	java/util/ArrayList:<init>	(I)V
    //   248: astore_1
    //   249: aload_0
    //   250: getfield 638	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:boR	Z
    //   253: ifeq +14 -> 267
    //   256: aload_0
    //   257: iconst_1
    //   258: aload_1
    //   259: invokevirtual 854	java/util/ArrayList:size	()I
    //   262: iconst_0
    //   263: iconst_0
    //   264: invokespecial 769	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:F	(IIII)V
    //   267: new 809	mqq/app/NewIntent
    //   270: dup
    //   271: aload_0
    //   272: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: invokevirtual 358	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   278: ldc_w 811
    //   281: invokespecial 814	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   284: astore_2
    //   285: aload_2
    //   286: ldc_w 816
    //   289: bipush 37
    //   291: invokevirtual 820	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   294: pop
    //   295: aload_2
    //   296: ldc_w 822
    //   299: aload_0
    //   300: invokevirtual 685	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:pS	()Ljava/lang/String;
    //   303: invokevirtual 825	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   306: pop
    //   307: aload_2
    //   308: ldc_w 836
    //   311: lconst_0
    //   312: invokevirtual 839	mqq/app/NewIntent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   315: pop
    //   316: aload_2
    //   317: ldc_w 841
    //   320: iconst_0
    //   321: invokevirtual 820	mqq/app/NewIntent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   324: pop
    //   325: aload_2
    //   326: ldc_w 2373
    //   329: aload_1
    //   330: invokevirtual 830	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   333: pop
    //   334: aload_2
    //   335: ldc_w 265
    //   338: iconst_0
    //   339: newarray byte
    //   341: invokevirtual 844	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   344: pop
    //   345: aload_2
    //   346: ldc_w 846
    //   349: iconst_0
    //   350: invokevirtual 849	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   353: pop
    //   354: aload_0
    //   355: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   358: aload_2
    //   359: invokevirtual 853	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   362: goto -227 -> 135
    //   365: astore_1
    //   366: aload_0
    //   367: monitorexit
    //   368: aload_1
    //   369: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	PhoneContactManagerImp
    //   17	313	1	localObject1	Object
    //   365	4	1	localObject2	Object
    //   233	126	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	82	365	finally
    //   82	104	365	finally
    //   104	135	365	finally
    //   138	169	365	finally
    //   169	229	365	finally
    //   229	234	365	finally
    //   240	249	365	finally
    //   249	267	365	finally
    //   267	362	365	finally
  }
  
  public void clW()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "OnDisableMobileBindSuc");
    }
    this.cbf = 7;
    c(true, true, 22L);
  }
  
  public void clX()
  {
    int i = xy();
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "uploadOrUpdateContact state: " + i);
    }
    if (i > 5)
    {
      if (i == 9)
      {
        clP();
        return;
      }
      clO();
      return;
    }
    if (i == 2)
    {
      clV();
      return;
    }
    clU();
  }
  
  public void clY()
  {
    int i = xy();
    if (i > 5) {
      if (i == 9)
      {
        this.boR = false;
        if (!this.boL) {
          clI();
        }
        F(3, this.df.size(), 100, 100);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, String.format("markAndUploadForNewGuide [%s, %s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.boR) }));
      }
      return;
      this.boR = true;
      clO();
      continue;
      if (i == 2)
      {
        this.boR = false;
        if (!this.boL) {
          clI();
        }
        F(3, this.df.size(), 100, 100);
      }
      else
      {
        this.boR = true;
        clU();
      }
    }
  }
  
  /* Error */
  public void clu()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 174	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:bU	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 333	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   11: invokevirtual 465	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 470	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   19: aload_0
    //   20: getfield 725	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   23: ifnull +11 -> 34
    //   26: aload_0
    //   27: getfield 725	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:jdField_b_of_type_ComTencentMobileqqDataContactBinded	Lcom/tencent/mobileqq/data/ContactBinded;
    //   30: iconst_1
    //   31: putfield 1632	com/tencent/mobileqq/data/ContactBinded:isReaded	Z
    //   34: aload_0
    //   35: getfield 1386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:rn	Ljava/util/ArrayList;
    //   38: ifnull +82 -> 120
    //   41: aload_0
    //   42: getfield 1386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:rn	Ljava/util/ArrayList;
    //   45: invokevirtual 854	java/util/ArrayList:size	()I
    //   48: ifle +72 -> 120
    //   51: aload_0
    //   52: getfield 1386	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:rn	Ljava/util/ArrayList;
    //   55: invokevirtual 1398	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 485 1 0
    //   65: ifeq +55 -> 120
    //   68: aload_3
    //   69: invokeinterface 489 1 0
    //   74: checkcast 1389	com/tencent/mobileqq/data/ContactMatch
    //   77: astore 4
    //   79: aload 4
    //   81: iconst_1
    //   82: putfield 2396	com/tencent/mobileqq/data/ContactMatch:isReaded	Z
    //   85: aload_0
    //   86: aload 4
    //   88: invokevirtual 1628	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   91: pop
    //   92: goto -33 -> 59
    //   95: astore_3
    //   96: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +14 -> 113
    //   102: ldc_w 297
    //   105: iconst_2
    //   106: ldc_w 2398
    //   109: aload_3
    //   110: invokestatic 1124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_2
    //   114: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   117: aload_1
    //   118: monitorexit
    //   119: return
    //   120: aload_2
    //   121: invokevirtual 505	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   124: aload_2
    //   125: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   128: goto -11 -> 117
    //   131: astore_2
    //   132: aload_1
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    //   136: astore_3
    //   137: aload_2
    //   138: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   141: aload_3
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	PhoneContactManagerImp
    //   4	129	1	localObject1	Object
    //   14	111	2	localEntityTransaction	EntityTransaction
    //   131	7	2	localObject2	Object
    //   58	11	3	localIterator	Iterator
    //   95	15	3	localException	Exception
    //   136	6	3	localObject3	Object
    //   77	10	4	localContactMatch	ContactMatch
    // Exception table:
    //   from	to	target	type
    //   15	34	95	java/lang/Exception
    //   34	59	95	java/lang/Exception
    //   59	92	95	java/lang/Exception
    //   120	124	95	java/lang/Exception
    //   7	15	131	finally
    //   113	117	131	finally
    //   117	119	131	finally
    //   124	128	131	finally
    //   132	134	131	finally
    //   137	143	131	finally
    //   15	34	136	finally
    //   34	59	136	finally
    //   59	92	136	finally
    //   96	113	136	finally
    //   120	124	136	finally
  }
  
  public void d(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), akwn.class);
    localNewIntent.putExtra("req_type", 16);
    localNewIntent.putExtra("verify_smscode", paramString);
    localNewIntent.putExtra("session_id", this.sessionId);
    localNewIntent.putExtra("cmd_param_bind_type", paramInt);
    localNewIntent.putExtra("cmd_param_is_from_uni", paramBoolean1);
    localNewIntent.putExtra("cmd_param_is_from_change_bind", paramBoolean2);
    this.app.startServlet(localNewIntent);
  }
  
  public Object[] d()
  {
    if (this.cbi < 0)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
      if (localObject == null) {
        break label201;
      }
      String str = this.app.getAccount();
      this.cbi = ((SharedPreferences)localObject).getInt("frd_has_bind_phone_count_" + str, 0);
      localObject = ((SharedPreferences)localObject).getString("frd_has_bind_phone_some_" + str, "");
      if (((String)localObject).length() > 0)
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 0)
        {
          this.th = new ArrayList(localObject.length);
          Collections.addAll(this.th, (Object[])localObject);
        }
      }
    }
    int i;
    if (QLog.isColorLevel())
    {
      i = this.cbi;
      if (this.th != null) {
        break label214;
      }
    }
    label201:
    label214:
    for (Object localObject = "null";; localObject = TextUtils.join(",", this.th))
    {
      QLog.i("PhoneContact.Manager", 2, String.format("getFriendHasBindPhone [%s, %s]", new Object[] { Integer.valueOf(i), localObject }));
      return new Object[] { Integer.valueOf(this.cbi), this.th };
      this.cbi = 0;
      this.th = null;
      break;
    }
  }
  
  public void dP(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0, false, false);
  }
  
  public void dQ(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), akwn.class);
    localNewIntent.putExtra("req_type", 33);
    localNewIntent.putExtra("country_code", paramString1);
    localNewIntent.putExtra("phone_number", paramString2);
    this.app.startServlet(localNewIntent);
  }
  
  public void dR(String paramString1, String paramString2)
  {
    Object localObject = (String)this.dd.get(paramString1);
    if ((localObject == null) || (!((String)localObject).equals(paramString2)))
    {
      this.dd.put(paramString1, paramString2);
      this.de.put(paramString2, paramString1);
      localObject = this.app.a().createEntityManager();
      PhoneNumInfo localPhoneNumInfo = new PhoneNumInfo();
      localPhoneNumInfo.phoneNum = paramString1;
      localPhoneNumInfo.uin = paramString2;
      if (localObject != null)
      {
        ((EntityManager)localObject).persistOrReplace(localPhoneNumInfo);
        ((EntityManager)localObject).close();
      }
    }
  }
  
  public List<PhoneContact> da()
  {
    long l = System.currentTimeMillis();
    if ((this.tn == null) || (this.tn.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.df.values());
      if (localArrayList.size() > 0)
      {
        if (a() == null) {
          return null;
        }
        localArrayList.remove(b(a().mobileNo));
        Collections.sort(localArrayList, new yul(this));
      }
      this.tn = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForSelector sort contact cost time: " + (System.currentTimeMillis() - l));
    }
    return this.tn;
  }
  
  public List<PhoneContact> db()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = (acff)this.app.getManager(51);
    if ((this.to == null) || (this.to.size() <= 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = this.df.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (TextUtils.isEmpty(localPhoneContact.uin)) {
          localArrayList.add(localPhoneContact);
        } else if ((!localPhoneContact.uin.equals("0")) && (((acff)localObject1).e(localPhoneContact.uin) != null)) {
          localArrayList.add(localPhoneContact);
        }
      }
      if (localArrayList.size() > 0)
      {
        if (a() == null) {
          return null;
        }
        localArrayList.remove(b(a().mobileNo));
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PhoneContact)((Iterator)localObject1).next();
          if (((PhoneContact)localObject2).pinyinFirst == null) {
            ((PhoneContact)localObject2).pinyinFirst = yui.hO(((PhoneContact)localObject2).pinyinInitial);
          }
        }
        Collections.sort(localArrayList, new yum(this));
      }
      this.to = localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getContactListForPhoneSelector sort contact cost time: " + (System.currentTimeMillis() - l));
    }
    return this.to;
  }
  
  public void df(ArrayList<PhoneContact> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "updateRenameList");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    EntityTransaction localEntityTransaction;
    label135:
    do
    {
      for (;;)
      {
        return;
        localEntityTransaction = this.em.getTransaction();
        try
        {
          localEntityTransaction.begin();
          paramArrayList = paramArrayList.iterator();
          for (;;)
          {
            if (!paramArrayList.hasNext()) {
              break label135;
            }
            localPhoneContact = (PhoneContact)paramArrayList.next();
            if (localPhoneContact.getStatus() != 1000) {
              break;
            }
            this.em.persist(localPhoneContact);
          }
        }
        catch (Exception paramArrayList)
        {
          for (;;)
          {
            PhoneContact localPhoneContact;
            if (QLog.isColorLevel()) {
              QLog.d("PhoneContact.Manager", 2, paramArrayList.getMessage());
            }
            return;
            this.em.update(localPhoneContact);
          }
        }
        finally
        {
          if (localEntityTransaction != null) {
            localEntityTransaction.end();
          }
        }
      }
      localEntityTransaction.commit();
    } while (localEntityTransaction == null);
    localEntityTransaction.end();
  }
  
  public String di(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.de.get(paramString);
      localObject = str;
    } while (str != null);
    if (this.app == null) {}
    for (Object localObject = null; localObject == null; localObject = this.app.a().createEntityManager()) {
      return null;
    }
    paramString = (PhoneNumInfo)((EntityManager)localObject).find(PhoneNumInfo.class, "uin=?", new String[] { paramString });
    if (paramString != null) {
      return paramString.phoneNum;
    }
    return null;
  }
  
  public String dv(String paramString)
  {
    if (this.aZC) {}
    for (;;)
    {
      return null;
      if (paramString != null)
      {
        if (!this.dd.containsKey(paramString)) {
          if (this.app != null) {
            break label95;
          }
        }
        label95:
        for (EntityManager localEntityManager = null; localEntityManager != null; localEntityManager = this.app.a().createEntityManager())
        {
          PhoneNumInfo localPhoneNumInfo = (PhoneNumInfo)localEntityManager.find(PhoneNumInfo.class, paramString);
          if (localPhoneNumInfo != null)
          {
            this.dd.put(paramString, localPhoneNumInfo.uin);
            this.de.put(localPhoneNumInfo.uin, paramString);
          }
          localEntityManager.close();
          return (String)this.dd.get(paramString);
        }
      }
    }
  }
  
  public void gL(List<PhoneContact> paramList)
  {
    MqqHandler localMqqHandler = this.app.getHandler(ContactListView.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.removeMessages(4);
      Message localMessage = localMqqHandler.obtainMessage(4);
      localMessage.obj = paramList;
      localMqqHandler.sendMessageDelayed(localMessage, 100L);
    }
  }
  
  public void gM(List<AddressBookItem> paramList)
  {
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = this.aZC;
        if (bool) {
          return;
        }
        if ((paramList == null) || (paramList.isEmpty())) {
          continue;
        }
        localEntityTransaction = this.em.getTransaction();
        try
        {
          localEntityTransaction.begin();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.df.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.em.update((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.end();
        }
        localEntityTransaction.commit();
      }
      finally {}
      localEntityTransaction.end();
      this.cbh += 1;
    }
  }
  
  public void gN(List<PhoneContact> paramList)
  {
    label13:
    HashMap localHashMap;
    Object localObject2;
    Object localObject1;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      return;
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        String str = localPhoneContact.mobileCode;
        if (!TextUtils.isEmpty(localPhoneContact.uin))
        {
          localArrayList.add(str);
        }
        else
        {
          localObject2 = (ArrayList)localHashMap.get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            localHashMap.put(str, localObject1);
          }
          ((ArrayList)localObject1).add(localPhoneContact);
        }
      }
      localObject1 = localArrayList.iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label13;
      }
      localObject2 = (ArrayList)localHashMap.get((String)((Iterator)localObject1).next());
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList.remove((PhoneContact)((Iterator)localObject2).next());
      }
    }
  }
  
  public void gO(List<AddressBookItem> paramList)
  {
    for (;;)
    {
      EntityTransaction localEntityTransaction;
      try
      {
        boolean bool = this.aZC;
        if (bool) {
          return;
        }
        if ((paramList == null) || (paramList.isEmpty())) {
          continue;
        }
        localEntityTransaction = this.em.getTransaction();
        try
        {
          localEntityTransaction.begin();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject = (AddressBookItem)paramList.next();
            localObject = (PhoneContact)this.df.get(((AddressBookItem)localObject).mobileNo);
            if (localObject == null) {
              continue;
            }
            ((PhoneContact)localObject).isUploaded = true;
            this.em.update((Entity)localObject);
            continue;
            paramList = finally;
          }
        }
        finally
        {
          localEntityTransaction.end();
        }
        localEntityTransaction.commit();
      }
      finally {}
      localEntityTransaction.end();
      this.cbh += 1;
    }
  }
  
  public void gv(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveUIBits: newBits = " + paramLong + " localUIBits = " + this.KG);
    }
    if (this.KG != paramLong)
    {
      this.KG = paramLong;
      this.pref.edit().putLong("key_contacts_switches", paramLong);
      gu(paramLong);
    }
  }
  
  /* Error */
  public void i(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 430	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:aZC	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 2494	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$5
    //   19: dup
    //   20: aload_0
    //   21: iload_1
    //   22: iload_2
    //   23: iload_3
    //   24: invokespecial 2497	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp$5:<init>	(Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp;ZZI)V
    //   27: bipush 16
    //   29: aconst_null
    //   30: iconst_0
    //   31: invokestatic 395	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   34: goto -21 -> 13
    //   37: astore 5
    //   39: aload_0
    //   40: monitorexit
    //   41: aload 5
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	PhoneContactManagerImp
    //   0	44	1	paramBoolean1	boolean
    //   0	44	2	paramBoolean2	boolean
    //   0	44	3	paramInt	int
    //   6	3	4	bool	boolean
    //   37	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	37	finally
    //   16	34	37	finally
  }
  
  public boolean ii(String paramString)
  {
    synchronized (this.bU)
    {
      Iterator localIterator = this.ro.iterator();
      while (localIterator.hasNext())
      {
        PhoneContactAdd localPhoneContactAdd = (PhoneContactAdd)localIterator.next();
        if (localPhoneContactAdd.unifiedCode.equals(paramString))
        {
          localIterator.remove();
          this.em.remove(localPhoneContactAdd);
          return true;
        }
      }
      return false;
    }
  }
  
  public boolean isDestroyed()
  {
    return this.aZC;
  }
  
  /* Error */
  public void j(Set<String> paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 430	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:aZC	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +30 -> 41
    //   14: ldc_w 297
    //   17: iconst_2
    //   18: new 243	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   25: ldc_w 2501
    //   28: invokevirtual 250	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 895	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 257	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 313	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 225	com/tencent/mobileqq/activity/contact/phonecontact/PhoneContactManagerImp:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 325	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   48: invokevirtual 331	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnonnull +14 -> 67
    //   56: ldc_w 297
    //   59: iconst_1
    //   60: ldc_w 2503
    //   63: invokestatic 1750	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: return
    //   67: aload_3
    //   68: invokevirtual 465	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 470	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   76: aload_3
    //   77: ldc_w 2505
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 2506	com/tencent/mobileqq/persistence/EntityManager:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   85: pop
    //   86: aload_1
    //   87: invokeinterface 1460 1 0
    //   92: astore_1
    //   93: aload_1
    //   94: invokeinterface 485 1 0
    //   99: ifeq +64 -> 163
    //   102: aload_1
    //   103: invokeinterface 489 1 0
    //   108: checkcast 130	java/lang/String
    //   111: astore 4
    //   113: aload 4
    //   115: invokestatic 695	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne -25 -> 93
    //   121: new 1323	com/tencent/mobileqq/data/LastLoginPhoneInfo
    //   124: dup
    //   125: invokespecial 2507	com/tencent/mobileqq/data/LastLoginPhoneInfo:<init>	()V
    //   128: astore 5
    //   130: aload 5
    //   132: aload 4
    //   134: putfield 1331	com/tencent/mobileqq/data/LastLoginPhoneInfo:unifiedCode	Ljava/lang/String;
    //   137: aload_3
    //   138: aload 5
    //   140: invokevirtual 1187	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   143: goto -50 -> 93
    //   146: astore_1
    //   147: ldc_w 297
    //   150: iconst_1
    //   151: ldc_w 2509
    //   154: aload_1
    //   155: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_2
    //   159: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   162: return
    //   163: aload_2
    //   164: invokevirtual 505	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   167: aload_2
    //   168: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   171: return
    //   172: astore_1
    //   173: aload_2
    //   174: invokevirtual 502	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   177: aload_1
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	PhoneContactManagerImp
    //   0	179	1	paramSet	Set<String>
    //   71	103	2	localEntityTransaction	EntityTransaction
    //   51	87	3	localEntityManager	EntityManager
    //   111	22	4	str	String
    //   128	11	5	localLastLoginPhoneInfo	LastLoginPhoneInfo
    // Exception table:
    //   from	to	target	type
    //   72	93	146	java/lang/Exception
    //   93	143	146	java/lang/Exception
    //   163	167	146	java/lang/Exception
    //   72	93	172	finally
    //   93	143	172	finally
    //   147	158	172	finally
    //   163	167	172	finally
  }
  
  public int k(List<String> paramList)
  {
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = a();
    if (localRespondQueryQQBindingStat == null) {
      return RESULT_FAIL;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$a.cancel(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$a = new a(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$a.gP(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp$a.execute(new RespondQueryQQBindingStat[] { localRespondQueryQQBindingStat });
    return RESULT_OK;
  }
  
  public void n(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong1 == KA) && (paramLong2 == KB) && (paramLong3 == KC)) {
      if (QLog.isColorLevel()) {
        QLog.i("PhoneContact.Manager", 2, String.format("saveQueryInterval not change [limit:%s, logInLimit:%s, reconnectLimit:%s]", new Object[] { Long.valueOf(KA), Long.valueOf(KB), Long.valueOf(KC) }));
      }
    }
    for (;;)
    {
      return;
      try
      {
        KA = Math.max(120000L, paramLong1);
        KB = Math.max(0L, paramLong2);
        KC = Math.max(0L, paramLong3);
        this.z.edit().putLong("query_contact_list_min_interval", KA).putLong("query_contact_list_min_interval_for_login", KB).putLong("query_contact_list_min_interval_for_reconnect", KC).apply();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("PhoneContact.Manager", 2, String.format("saveQueryInterval  [limit:%s, logInLimit:%s, reconnectLimit:%s]", new Object[] { Long.valueOf(KA), Long.valueOf(KB), Long.valueOf(KC) }));
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("PhoneContact.Manager", 2, localThrowable.getMessage());
          }
        }
      }
    }
  }
  
  public List<PhoneContact> o(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    Object localObject2 = this.tk;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = cW();
    }
    localObject2 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject1).next();
      if (localPhoneContact.isHiden) {
        ((List)localObject2).add(localPhoneContact);
      }
    }
    if (paramBoolean) {
      Collections.sort((List)localObject2, new yuh(new int[] { 1, 4 }, null, null));
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "getBindHideNoneFriendList cost: " + (System.currentTimeMillis() - l) + ", size = " + ((List)localObject2).size());
    }
    return localObject2;
  }
  
  public void onDestroy()
  {
    this.aZC = true;
    this.tj = null;
    this.ti = null;
    this.tn = null;
    this.tp = null;
    this.app.unRegistObserver(this.jdField_b_of_type_Akwl);
    this.app.removeObserver(this.jdField_a_of_type_Akwm);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.eL);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "onDestroy");
    }
    clG();
    this.cbf = -1;
    this.boL = false;
    if (this.jdField_a_of_type_Yuw != null) {
      this.jdField_a_of_type_Yuw.onDestroy();
    }
  }
  
  public List<PhoneContact> p(boolean paramBoolean)
  {
    if (this.tp == null) {
      this.tp = a(this.df, paramBoolean);
    }
    return this.tp;
  }
  
  public String pS()
  {
    if (this.aZJ == null) {}
    try
    {
      if (this.aZJ == null) {
        this.aZJ = pT();
      }
      return this.aZJ;
    }
    finally {}
  }
  
  public void r(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "saveBindConfig style:" + paramInt + " wording:" + paramString1 + " blockMsg:" + paramString2);
    }
    SharedPreferences.Editor localEditor = this.pref.edit();
    localEditor.putInt("key_bind_style", paramInt);
    localEditor.putString("key_bind_wording", paramString1);
    localEditor.putString("key_block_msg", paramString2);
    localEditor.commit();
  }
  
  public int xA()
  {
    return this.A.getInt("key_config_version", 0);
  }
  
  public int xv()
  {
    return cV().size();
  }
  
  public int xw()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (QLog.isColorLevel())
    {
      localStringBuffer.append("getBannerState bind state = ");
      localStringBuffer.append(xy());
    }
    int i;
    if (xy() == 9)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" isCacheInited=");
        localStringBuffer.append(this.boL);
      }
      if (this.boL) {
        if (this.df.size() == 0) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localStringBuffer.append(" ret=");
        localStringBuffer.append(i);
        QLog.d("PhoneContact.Manager", 2, localStringBuffer.toString());
      }
      return i;
      i = 2;
      continue;
      i = 0;
      continue;
      i = 2;
    }
  }
  
  public int xx()
  {
    if (xy() <= 5) {
      return 2;
    }
    return 1;
  }
  
  public int xy()
  {
    switch (this.cbf)
    {
    case 0: 
    default: 
      return 0;
    case -1: 
      this.cbf = a(a());
      return xy();
    case 8: 
      return 8;
    case 9: 
      return 9;
    }
    return this.cbf;
  }
  
  public int xz()
  {
    return this.cbf;
  }
  
  public void z(ArrayList<PhoneContact> paramArrayList, int paramInt)
  {
    Iterator localIterator = this.df.values().iterator();
    for (;;)
    {
      PhoneContact localPhoneContact;
      if (localIterator.hasNext())
      {
        localPhoneContact = (PhoneContact)localIterator.next();
        if (paramInt != 0) {}
      }
      else
      {
        return;
      }
      if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!paramArrayList.contains(localPhoneContact)))
      {
        paramInt -= 1;
        paramArrayList.add(localPhoneContact);
      }
    }
  }
  
  public class UploadProgressGenerator
    implements Runnable
  {
    volatile boolean boY = false;
    int cbl = 0;
    volatile int cbm = 0;
    volatile int cbn = 5;
    volatile boolean isCanceled;
    
    private UploadProgressGenerator() {}
    
    public void cancel()
    {
      this.isCanceled = true;
      BaseApplicationImpl.sUiHandler.removeCallbacks(this);
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "run progress, isCanceled = " + this.isCanceled + ", bindState = " + PhoneContactManagerImp.this.cbf);
      }
      Object localObject;
      if ((!this.isCanceled) && ((PhoneContactManagerImp.this.cbf == 8) || (PhoneContactManagerImp.this.cbf == 4)) && (this.cbl + 1 < this.cbn))
      {
        localObject = PhoneContactManagerImp.this;
        int i = this.cbl;
        this.cbl = (i + 1);
        PhoneContactManagerImp.b((PhoneContactManagerImp)localObject, i);
        if (this.boY)
        {
          PhoneContactManagerImp.a(PhoneContactManagerImp.this, 7);
          this.boY = false;
        }
        localObject = BaseApplicationImpl.sUiHandler;
        if (this.cbl >= this.cbm) {
          break label166;
        }
      }
      label166:
      for (long l = 20L;; l = 100L)
      {
        ((MqqHandler)localObject).postDelayed(this, l);
        return;
      }
    }
    
    public void setProgress(int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "set progress, actual = " + paramInt1 + ", expected = " + paramInt2);
      }
      this.boY = true;
      this.cbm = paramInt1;
      this.cbn = paramInt2;
      BaseApplicationImpl.sUiHandler.removeCallbacks(this);
      BaseApplicationImpl.sUiHandler.postDelayed(this, 20L);
    }
    
    public void start()
    {
      this.isCanceled = false;
      BaseApplicationImpl.sUiHandler.postDelayed(this, 100L);
    }
  }
  
  public class a
    extends AsyncTask<RespondQueryQQBindingStat, Void, List<PhoneContact>>
  {
    private List<String> ts;
    
    private a() {}
    
    protected List<PhoneContact> a(RespondQueryQQBindingStat... paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager.ContactFriendTask", 2, "doInBackground");
      }
      Object localObject = paramVarArgs[0];
      paramVarArgs = new ArrayList();
      paramVarArgs.addAll(PhoneContactManagerImp.a(PhoneContactManagerImp.this).values());
      Collections.sort(paramVarArgs, new yur(this));
      ArrayList localArrayList = new ArrayList();
      acff localacff = (acff)PhoneContactManagerImp.a(PhoneContactManagerImp.this).getManager(51);
      Iterator localIterator;
      if (paramVarArgs.size() > 0)
      {
        localObject = ((RespondQueryQQBindingStat)localObject).mobileNo;
        localIterator = paramVarArgs.iterator();
      }
      PhoneContact localPhoneContact;
      do
      {
        do
        {
          if (localIterator.hasNext())
          {
            paramVarArgs = (PhoneContact)localIterator.next();
            if (!isCancelled()) {}
          }
          else
          {
            Collections.sort(localArrayList, new yus(this));
            return localArrayList;
          }
        } while ((localObject != null) && (((String)localObject).endsWith(paramVarArgs.mobileNo.trim())));
        localPhoneContact = (PhoneContact)paramVarArgs.clone();
      } while (TextUtils.isEmpty(localPhoneContact.uin));
      if (localPhoneContact.uin.equals("0"))
      {
        paramVarArgs = null;
        label201:
        if ((paramVarArgs == null) || (paramVarArgs.groupid < 0)) {
          break label260;
        }
        localPhoneContact.nickName = paramVarArgs.getFriendNick();
        localPhoneContact.remark = paramVarArgs.remark;
        localPhoneContact.sortWeight = 262144;
      }
      for (;;)
      {
        localArrayList.add(localPhoneContact);
        break;
        paramVarArgs = localacff.e(localPhoneContact.uin);
        break label201;
        label260:
        localPhoneContact.uin = "0";
        if (localacff.kd(localPhoneContact.nationCode + localPhoneContact.mobileCode))
        {
          localPhoneContact.sortWeight = 131072;
          localPhoneContact.hasSendAddReq = true;
        }
        else if ((this.ts != null) && (this.ts.contains(localPhoneContact.mobileNo)))
        {
          localPhoneContact.sortWeight = this.ts.indexOf(localPhoneContact.mobileNo);
        }
        else
        {
          localPhoneContact.sortWeight = 65536;
        }
      }
    }
    
    public void gP(List<String> paramList)
    {
      this.ts = paramList;
    }
    
    protected void onCancelled()
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager.ContactFriendTask", 2, "on cancelled");
      }
      PhoneContactManagerImp.a(PhoneContactManagerImp.this, null);
    }
    
    protected void onPostExecute(List<PhoneContact> paramList)
    {
      if (!isCancelled()) {
        PhoneContactManagerImp.this.gL(paramList);
      }
    }
  }
  
  static class b
    extends ContentObserver
  {
    WeakReference<PhoneContactManagerImp> mRef;
    
    public b(Handler paramHandler)
    {
      super();
    }
    
    public void f(PhoneContactManagerImp paramPhoneContactManagerImp)
    {
      if (this.mRef != null) {
        this.mRef.clear();
      }
      if (paramPhoneContactManagerImp != null) {
        this.mRef = new WeakReference(paramPhoneContactManagerImp);
      }
    }
    
    public void onChange(boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, "Contact changed.");
      }
      if (this.mRef == null) {}
      for (PhoneContactManagerImp localPhoneContactManagerImp = null;; localPhoneContactManagerImp = (PhoneContactManagerImp)this.mRef.get())
      {
        if (localPhoneContactManagerImp != null) {
          localPhoneContactManagerImp.boQ = true;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp
 * JD-Core Version:    0.7.0.1
 */