package com.tencent.mobileqq.loginwelcome;

import SecurityAccountServer.RecommendedContactInfo;
import acbn;
import acci;
import accn;
import acms;
import acnd;
import acxw;
import aeif;
import aivv;
import aivw;
import aivx;
import aivy;
import aivz;
import aiwa;
import aiwb;
import aiwc;
import ajdo.a;
import ajrs;
import ajrw;
import akwk;
import akwm;
import akwn;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import anot;
import aqek;
import aqep;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import ocp;
import org.json.JSONArray;
import rex;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.BindContactInfo;

public class LoginWelcomeManager
  implements acci, ajdo.a, Runnable, Manager
{
  public static int dfp;
  URLDrawable D;
  private accn jdField_a_of_type_Accn = new aivz(this);
  private aivv jdField_a_of_type_Aivv;
  a jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$a = null;
  b jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$b = null;
  public d a;
  e jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e;
  private WeakReference<MessengerService> aL;
  private long abW;
  public acnd b;
  public ajrw b;
  private akwm b;
  public String bPJ;
  private String bPK;
  private String bPL;
  private Bundle bj;
  public boolean cmb;
  private boolean cmc;
  private boolean cmd;
  public boolean cme;
  public boolean cmf;
  private PhoneContactManagerImp i;
  private QQAppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private SharedPreferences mPreferences;
  private Bundle mReqBundle;
  private int mRetryCount;
  
  public LoginWelcomeManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Ajrw = new aivw(this);
    this.jdField_b_of_type_Acnd = new aivx(this);
    this.jdField_b_of_type_Akwm = new aiwa(this);
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Aivv = ((aivv)paramQQAppInterface.getBusinessHandler(84));
    this.mApp.addObserver(this, true);
  }
  
  public static void C(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((akwk)paramQQAppInterface.getBusinessHandler(134)).fv(paramQQAppInterface.getCurrentAccountUin(), paramInt);
  }
  
  public static void H(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "saveContactsGuidePopWindowState，hasAlert=" + paramBoolean);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("sp_key_contactsguide_popwindow_state", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static LoginWelcomeManager a(QQAppInterface paramQQAppInterface)
  {
    return (LoginWelcomeManager)paramQQAppInterface.getManager(146);
  }
  
  public static boolean aU(QQAppInterface paramQQAppInterface)
  {
    boolean bool1;
    if (paramQQAppInterface == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = paramQQAppInterface.getPreferences().getBoolean("sp_key_contactsguide_popwindow_state", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "hasContactsGuidePopWindow，hasAlert=" + bool2);
    return bool2;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    boolean bool;
    if ((paramQQAppInterface == null) || (paramRecentUser == null) || (paramRecentUser.extraInfo == null) || (!(paramRecentUser.extraInfo instanceof c))) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "contactsGuideRecenUserUiReady, result=" + bool);
      }
      return bool;
      paramQQAppInterface = (c)paramRecentUser.extraInfo;
      if ((paramQQAppInterface.cmi) && (paramQQAppInterface.E != null) && (paramQQAppInterface.E.getStatus() == 1)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private void cV(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("path");
    boolean bool = paramBundle.getBoolean("PhotoConst.SYNCQZONE", false);
    String str2 = paramBundle.getString("PhotoConst.SOURCE_FROM");
    this.bPL = lF(str1);
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SYNCQZONE", bool);
    localIntent.putExtra("PhotoConst.SOURCE_FROM", str2);
    if (aqep.a(this.mApp, str1, localIntent))
    {
      this.mApp.addObserver(this.jdField_a_of_type_Accn);
      return;
    }
    paramBundle.putInt("result", 0);
    duU();
  }
  
  public static void de(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ((akwk)paramQQAppInterface.getBusinessHandler(134)).NM(paramQQAppInterface.getCurrentAccountUin());
    H(paramQQAppInterface, true);
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X8009F49", "0X8009F49", 0, 0, "", "", "", "");
  }
  
  public static void df(QQAppInterface paramQQAppInterface)
  {
    if (dfp > 0) {
      anot.b(paramQQAppInterface, "dc00898", "", "", "0X8009F4B", "0X8009F4B", 0, dfp, 0, "", "", "", "");
    }
    dfp = 0;
  }
  
  private void g(RecentUser paramRecentUser)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realShowCGRU");
    }
    acxw localacxw = this.mApp.a().a();
    paramRecentUser.lastmsgtime = -1L;
    paramRecentUser.lastmsgdrafttime = -1L;
    paramRecentUser.opTime = -1L;
    paramRecentUser.showUpTime = -1L;
    localacxw.e(paramRecentUser);
    paramRecentUser = this.mApp.getHandler(Conversation.class);
    if (paramRecentUser != null) {
      paramRecentUser.sendEmptyMessage(1009);
    }
  }
  
  /* Error */
  private String lF(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 352	java/io/File
    //   6: dup
    //   7: getstatic 357	acbn:bnE	Ljava/lang/String;
    //   10: invokespecial 359	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 362	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_2
    //   22: invokevirtual 365	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 352	java/io/File
    //   29: dup
    //   30: aload_2
    //   31: ldc_w 367
    //   34: invokespecial 370	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload 5
    //   41: invokevirtual 362	java/io/File:exists	()Z
    //   44: ifeq +9 -> 53
    //   47: aload 5
    //   49: invokevirtual 373	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_1
    //   54: invokestatic 379	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   57: sipush 200
    //   60: sipush 200
    //   63: iconst_1
    //   64: invokestatic 385	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   67: astore 7
    //   69: new 387	java/io/FileOutputStream
    //   72: dup
    //   73: aload 5
    //   75: invokespecial 390	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   78: astore_2
    //   79: new 392	java/io/BufferedOutputStream
    //   82: dup
    //   83: aload_2
    //   84: invokespecial 395	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   87: astore_1
    //   88: aload_1
    //   89: astore 4
    //   91: aload_2
    //   92: astore_3
    //   93: aload 7
    //   95: getstatic 401	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   98: bipush 100
    //   100: aload_1
    //   101: invokevirtual 405	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   104: pop
    //   105: aload_1
    //   106: astore 4
    //   108: aload_2
    //   109: astore_3
    //   110: aload_1
    //   111: invokevirtual 408	java/io/BufferedOutputStream:flush	()V
    //   114: aload_1
    //   115: astore 4
    //   117: aload_2
    //   118: astore_3
    //   119: aload 5
    //   121: invokevirtual 411	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: astore 5
    //   126: aload 5
    //   128: astore_3
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 414	java/io/FileOutputStream:close	()V
    //   137: aload_3
    //   138: astore_2
    //   139: aload_1
    //   140: ifnull +9 -> 149
    //   143: aload_1
    //   144: invokevirtual 415	java/io/BufferedOutputStream:close	()V
    //   147: aload_3
    //   148: astore_2
    //   149: aload_2
    //   150: areturn
    //   151: astore 5
    //   153: aconst_null
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_2
    //   157: aload_1
    //   158: astore 4
    //   160: aload_2
    //   161: astore_3
    //   162: ldc 150
    //   164: iconst_1
    //   165: ldc_w 417
    //   168: aload 5
    //   170: invokestatic 420	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 414	java/io/FileOutputStream:close	()V
    //   181: aload 6
    //   183: astore_2
    //   184: aload_1
    //   185: ifnull -36 -> 149
    //   188: aload_1
    //   189: invokevirtual 415	java/io/BufferedOutputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: aconst_null
    //   196: areturn
    //   197: astore_1
    //   198: aconst_null
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_2
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 414	java/io/FileOutputStream:close	()V
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 415	java/io/BufferedOutputStream:close	()V
    //   221: aload_1
    //   222: athrow
    //   223: astore_2
    //   224: goto -87 -> 137
    //   227: astore_1
    //   228: aload_3
    //   229: areturn
    //   230: astore_2
    //   231: goto -50 -> 181
    //   234: astore_2
    //   235: goto -24 -> 211
    //   238: astore_2
    //   239: goto -18 -> 221
    //   242: astore_1
    //   243: aconst_null
    //   244: astore 4
    //   246: goto -43 -> 203
    //   249: astore_1
    //   250: aload_3
    //   251: astore_2
    //   252: goto -49 -> 203
    //   255: astore 5
    //   257: aconst_null
    //   258: astore_1
    //   259: goto -102 -> 157
    //   262: astore 5
    //   264: goto -107 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	LoginWelcomeManager
    //   0	267	1	paramString	String
    //   13	195	2	localObject1	Object
    //   223	1	2	localException1	Exception
    //   230	1	2	localException2	Exception
    //   234	1	2	localException3	Exception
    //   238	1	2	localException4	Exception
    //   251	1	2	localObject2	Object
    //   92	159	3	localObject3	Object
    //   89	156	4	str	String
    //   37	90	5	localObject4	Object
    //   151	18	5	localException5	Exception
    //   255	1	5	localException6	Exception
    //   262	1	5	localException7	Exception
    //   1	181	6	localObject5	Object
    //   67	27	7	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   3	26	151	java/lang/Exception
    //   26	53	151	java/lang/Exception
    //   53	79	151	java/lang/Exception
    //   188	192	194	java/lang/Exception
    //   3	26	197	finally
    //   26	53	197	finally
    //   53	79	197	finally
    //   133	137	223	java/lang/Exception
    //   143	147	227	java/lang/Exception
    //   177	181	230	java/lang/Exception
    //   207	211	234	java/lang/Exception
    //   216	221	238	java/lang/Exception
    //   79	88	242	finally
    //   93	105	249	finally
    //   110	114	249	finally
    //   119	126	249	finally
    //   162	173	249	finally
    //   79	88	255	java/lang/Exception
    //   93	105	262	java/lang/Exception
    //   110	114	262	java/lang/Exception
    //   119	126	262	java/lang/Exception
  }
  
  public void LA(boolean paramBoolean)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onUploadContactsCompleted success=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (this.bj == null) {
      return;
    }
    Object localObject = this.bj.getBundle("request");
    if (localObject != null) {
      if (!paramBoolean) {
        break label90;
      }
    }
    for (;;)
    {
      ((Bundle)localObject).putInt("result", j);
      localObject = (MessengerService)this.aL.get();
      if (localObject == null) {
        break;
      }
      ((MessengerService)localObject).cp(this.bj);
      return;
      label90:
      j = 0;
    }
  }
  
  public void Lz(boolean paramBoolean)
  {
    this.abW = SystemClock.uptimeMillis();
    this.cmc = paramBoolean;
    if (this.i == null) {
      this.i = ((PhoneContactManagerImp)this.mApp.getManager(11));
    }
    boolean bool = this.i.Uy();
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("getRecommendedList uploadContactsOnly=%s hasPermission=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) }));
    }
    if (bool)
    {
      this.i.a(this);
      if (this.i.Uv())
      {
        if (this.i.xy() == 9)
        {
          if (this.cmc)
          {
            LA(true);
            return;
          }
          duV();
          return;
        }
        this.i.clO();
        return;
      }
      this.i.clU();
      return;
    }
    if (this.cmc)
    {
      LA(false);
      return;
    }
    ln(null);
  }
  
  public void T(boolean paramBoolean, int paramInt) {}
  
  public a a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$a = new a();
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$a.dfq = 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$a;
  }
  
  public b a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$b == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$b = new b();
      if (this.mPreferences == null) {
        this.mPreferences = this.mApp.getApplication().getSharedPreferences("loginwelcome_" + this.mApp.getCurrentUin(), 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$b.cmh = this.mPreferences.getBoolean("sp_key_show_convguide_entrance", false);
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "getContactsGuideInfo, \n" + this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$b);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$b;
  }
  
  public e a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e = ((e)aeif.a().o(454));
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "getWelcomeIntervalConfig, \n" + this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e;
  }
  
  public void a(MessengerService paramMessengerService, Bundle paramBundle)
  {
    if ((this.aL == null) || (this.aL.get() != paramMessengerService)) {
      this.aL = new WeakReference(paramMessengerService);
    }
    paramMessengerService = paramBundle.getBundle("request");
    String str = paramMessengerService.getString("key_action");
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "handleWebRequest method=" + str);
    }
    if ((str.equals("uploadContacts")) || (str.equals("getRecommendedList")))
    {
      this.bj = paramBundle;
      Lz(str.equals("uploadContacts"));
    }
    do
    {
      do
      {
        return;
        if (this.mReqBundle == null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LoginWelcomeManager", 2, "last request has not return.");
      return;
      this.mReqBundle = paramBundle;
      if (str.equals("followPublicAccount"))
      {
        cU(paramMessengerService);
        return;
      }
      if (str.equals("joinTroop"))
      {
        cT(paramMessengerService);
        return;
      }
      if (str.equals("joinTroopByTap"))
      {
        cW(paramMessengerService);
        return;
      }
      if (str.equals("sayHi"))
      {
        cS(paramMessengerService);
        return;
      }
      if (str.equals("setAvatar"))
      {
        cV(paramMessengerService);
        return;
      }
    } while (!str.equals("getRecommendedListNew"));
    cX(paramMessengerService);
  }
  
  public void a(d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d = paramd;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "setConvListener, listener=" + paramd);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d != null) {
      ThreadManagerV2.postImmediately(new LoginWelcomeManager.6(this), null, true);
    }
  }
  
  public void a(e parame)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onUpdateConfig, \n" + parame);
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e = parame;
  }
  
  public boolean apM()
  {
    if (!a().cmh)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, needShow is false");
      }
      return false;
    }
    if (((PhoneContactManagerImp)this.mApp.getManager(11)).Uw())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU, has ReadContactPer");
      }
      return false;
    }
    Object localObject = this.mApp.a().a();
    RecentUser localRecentUser = ((acxw)localObject).b(acbn.bld, 8111);
    localObject = ((acxw)localObject).b("sp_uin_for_title", 8112);
    if ((localRecentUser != null) || (localObject != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowShowCGRU， mayKnowFriend has show");
      }
      return false;
    }
    return true;
  }
  
  public boolean apN()
  {
    if (aU(this.mApp)) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=false, hasPopWindow");
      }
    }
    do
    {
      return false;
      Object localObject = a();
      boolean bool = ((b)localObject).cmg;
      localObject = ((b)localObject).url;
      if ((bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=true, showWelcomepage");
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "allowCGPopWin，result=false");
    return false;
  }
  
  public boolean apO()
  {
    if (a().dfq == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "NotCommonGuideWeb, showType is 0");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "allowCommonGuideWeb，result=true");
    }
    return true;
  }
  
  public void bA(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length >= 2) && (paramObject[1] != null) && ((paramObject[1] instanceof a)))
      {
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$a = ((a)paramObject[1]);
        dvb();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onGetCommonGuide，isSuccess=" + paramBoolean + ", mCommonGuideInfo=" + a());
    }
  }
  
  public void bB(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length >= 3) && (paramObject[2].equals(Boolean.FALSE)))
      {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        localEditor.putBoolean("request_state", false);
        localEditor.commit();
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "onSetRequestOpen，reqOpen=" + paramObject[2]);
      }
    }
  }
  
  public void bz(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length >= 1) && (paramObject[0] != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$b = ((b)paramObject[0]);
        dva();
        duX();
        paramObject = this.mPreferences.edit();
        paramObject.putBoolean("sp_key_show_convguide_entrance", this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$b.cmh);
        paramObject.commit();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "onGetContactsGuide，isSuccess=" + paramBoolean + ", mContactsGuideInfo=" + a());
    }
  }
  
  public void cS(Bundle paramBundle)
  {
    this.mApp.addObserver(this.jdField_b_of_type_Ajrw);
    ajrs localajrs = (ajrs)this.mApp.getBusinessHandler(60);
    long l = paramBundle.getLong("tinyId");
    aqek.a(localajrs, this.mApp, l, "", 100, null, 0L, false, 0L, false, 0L, 0);
  }
  
  public void cT(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("uin");
    acms localacms = (acms)this.mApp.getBusinessHandler(20);
    if (localacms != null) {}
    try
    {
      this.mApp.addObserver(this.jdField_b_of_type_Acnd);
      localacms.aA(Long.parseLong(paramBundle), 8390784);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("LoginWelcomeManager", 2, "joinTroop err", paramBundle);
    }
  }
  
  public void cU(Bundle paramBundle)
  {
    String str = paramBundle.getString("uin");
    ocp.a(this.mApp, this.mApp.getApp(), str, new aivy(this, paramBundle), true, 15);
  }
  
  public void cW(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "joinGroupByTap");
    }
    this.mApp.addObserver(this.jdField_a_of_type_Accn);
    ((CardHandler)this.mApp.getBusinessHandler(2)).a(this.mApp.getCurrentAccountUin(), this.mApp.getCurrentUin(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
  }
  
  public void cX(Bundle paramBundle)
  {
    try
    {
      long l = paramBundle.getLong("uin");
      int j = paramBundle.getInt("startIndex");
      int k = paramBundle.getInt("num");
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("getRecommendedListNew uin=%s startIndex=%s num=%s", new Object[] { Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k) }));
      }
      this.mApp.addObserver(this.jdField_b_of_type_Akwm);
      paramBundle = (akwk)this.mApp.getBusinessHandler(134);
      if (paramBundle != null) {
        paramBundle.M(l, j, k);
      }
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("LoginWelcomeManager", 1, "getRecommendedListNew fail.", paramBundle);
    }
  }
  
  public void duT()
  {
    this.mPreferences = this.mApp.getApplication().getSharedPreferences("loginwelcome_" + this.mApp.getCurrentUin(), 0);
    int j = this.mPreferences.getInt("first_login", 0);
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "requestIsFirstLogin state=" + j);
    }
    if (j != 1)
    {
      this.jdField_a_of_type_Aivv.Ly(true);
      SharedPreferences.Editor localEditor = this.mPreferences.edit();
      localEditor.putBoolean("first_device", false);
      localEditor.putInt("bubble_tips_time", 0);
      localEditor.putInt("first_login", 1);
      localEditor.commit();
    }
    label323:
    label329:
    label334:
    for (;;)
    {
      return;
      a();
      long l1 = this.mPreferences.getLong("sp_key_contactsguide_last_req_time", 0L);
      long l2;
      boolean bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e != null)
      {
        j = this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e.dft;
        l2 = System.currentTimeMillis();
        if (Math.abs(l2 - l1) <= j * 60 * 1000) {
          break label323;
        }
        bool1 = true;
        label218:
        boolean bool2 = this.mPreferences.getBoolean("request_state", true);
        if ((!bool1) || (!bool2)) {
          break label329;
        }
        this.jdField_a_of_type_Aivv.Ly(false);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label334;
        }
        QLog.d("LoginWelcomeManager", 2, "requestIsFirstLogin, doReq=" + bool1 + ",curTime=" + l2 + ",lastReqTime=" + l1 + ",reqInternal=" + j);
        return;
        j = 360;
        break;
        bool1 = false;
        break label218;
        duX();
      }
    }
  }
  
  public void duU()
  {
    MessengerService localMessengerService = (MessengerService)this.aL.get();
    if (localMessengerService != null)
    {
      localMessengerService.cp(this.mReqBundle);
      this.mReqBundle = null;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LoginWelcomeManager", 2, "respToWeb no service");
  }
  
  public void duV()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedList");
    }
    if (this.bj == null) {
      return;
    }
    Object localObject = this.bj.getBundle("request");
    if (localObject != null) {}
    for (int j = ((Bundle)localObject).getInt("wantCount");; j = 0)
    {
      if (j > 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedList wantCount=%s", new Object[] { Integer.valueOf(j) }));
        }
        localObject = new NewIntent(this.mApp.getApplication(), akwn.class);
        ((NewIntent)localObject).putExtra("req_type", 36);
        ((NewIntent)localObject).putExtra("unique_phone_no", this.i.pS());
        ((NewIntent)localObject).putExtra("wantCount", j);
        this.mApp.startServlet((NewIntent)localObject);
        return;
        j = 21;
      }
    }
  }
  
  public void duW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realGetRecommendedListNotBind");
    }
    if (this.bj == null) {
      return;
    }
    Object localObject = this.bj.getBundle("request");
    if (localObject != null) {}
    for (int j = ((Bundle)localObject).getInt("wantCount");; j = 0)
    {
      if (j > 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, String.format("realGetRecommendedListNotBind wantCount=%s", new Object[] { Integer.valueOf(j) }));
        }
        localObject = new NewIntent(this.mApp.getApplication(), akwn.class);
        ((NewIntent)localObject).putExtra("req_type", 40);
        ((NewIntent)localObject).putExtra("unique_phone_no", this.i.pS());
        ((NewIntent)localObject).putExtra("wantCount", j);
        this.mApp.startServlet((NewIntent)localObject);
        return;
        j = 21;
      }
    }
  }
  
  public void duX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryShowCGRU");
    }
    if (!apM())
    {
      duY();
      return;
    }
    a();
    RecentUser localRecentUser = this.mApp.a().a().b(acbn.blQ, 8114);
    if (localRecentUser == null) {
      localRecentUser = new RecentUser(acbn.blQ, 8114);
    }
    for (;;)
    {
      c localc;
      Object localObject;
      if ((localRecentUser.extraInfo != null) && ((localRecentUser.extraInfo instanceof c)))
      {
        localc = (c)localRecentUser.extraInfo;
        localRecentUser.extraInfo = localc;
        localObject = localc.E;
        if (localObject != null) {
          break label309;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e.fixed_entrance_url))) {
          break label293;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = rex.b(BaseApplicationImpl.getApplication().getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)(((URLDrawable.URLDrawableOptions)localObject).mRequestWidth * 0.5D + 0.5D));
        ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = false;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$e.fixed_entrance_url, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setURLDrawableListener(new aiwb(this, localc, localRecentUser));
        j = ((URLDrawable)localObject).getStatus();
        if (j != 1) {
          break label284;
        }
        localc.cmi = true;
        localc.E = ((URLDrawable)localObject);
        localc.E.setURLDrawableListener(null);
        g(localRecentUser);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label291;
        }
        QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable need init, drawableStatus" + j);
        return;
        localc = new c();
        break;
        label284:
        ((URLDrawable)localObject).downloadImediatly(true);
      }
      label291:
      break;
      label293:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LoginWelcomeManager", 2, "tryShowCGRU, url is empty");
      return;
      label309:
      int j = ((URLDrawable)localObject).getStatus();
      if ((j == 2) || (j == 3)) {
        ((URLDrawable)localObject).restartDownload();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("LoginWelcomeManager", 2, "tryShowCGRU drawable is not null, drawableStatus" + j);
        return;
        if (j == 1)
        {
          localc.cmi = true;
          localc.E = ((URLDrawable)localObject);
          localc.E.setURLDrawableListener(null);
          g(localRecentUser);
        }
      }
      break;
    }
  }
  
  public void duY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "removeCGRU");
    }
    Object localObject = this.mApp.a().a();
    if (((acxw)localObject).b(acbn.blQ, 8114) != null)
    {
      ((acxw)localObject).Jn(8114);
      localObject = this.mApp.getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(1009);
      }
    }
  }
  
  public void duZ()
  {
    if (this.D != null)
    {
      this.D.setURLDrawableListener(null);
      this.D = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "relCGDrawable");
    }
  }
  
  public void dva()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer");
    }
    if (!apN()) {}
    for (;;)
    {
      return;
      this.cme = true;
      int j;
      if (this.D == null)
      {
        e locale = a();
        if ((locale != null) && (!TextUtils.isEmpty(locale.bPM)))
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mUseAutoScaleParams = false;
          this.D = URLDrawable.getDrawable(locale.bPM, localURLDrawableOptions);
          this.D.setURLDrawableListener(new aiwc(this));
          j = this.D.getStatus();
          if (j == 1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d != null) {
              this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d.q(this.D);
            }
            duZ();
          }
          while (QLog.isColorLevel())
          {
            QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer drawable need init, drawableStatus" + j);
            return;
            this.D.downloadImediatly(true);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer, url is empty");
        }
      }
      else
      {
        j = this.D.getStatus();
        if ((j == 2) || (j == 3)) {
          this.D.restartDownload();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("LoginWelcomeManager", 2, "tryToShowCGLayer restartDownload, drawableStatus" + j);
          return;
          if (j == 1)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d != null) {
              this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d.q(this.D);
            }
            duZ();
          }
        }
      }
    }
  }
  
  public void dvb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "tryToShowCommonGuide");
    }
    if (!apO()) {}
    do
    {
      return;
      this.cmf = true;
    } while (this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d == null);
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$d.a(this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeLoginWelcomeManager$a);
  }
  
  public void eH(long paramLong) {}
  
  public void ez(Context paramContext)
  {
    String str = this.bPK + String.format(Locale.getDefault(), "&appid=%d", new Object[] { Integer.valueOf(AppSetting.getAppId()) });
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("startNewerGuideWebPage url=%s", new Object[] { str }));
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_title_left_arrow", true);
    localIntent.putExtra("url", str);
    paramContext.startActivity(localIntent);
  }
  
  public void ln(List<RecommendedContactInfo> paramList)
  {
    int j = 0;
    if (QLog.isColorLevel())
    {
      if (paramList != null) {
        j = paramList.size();
      }
      QLog.d("LoginWelcomeManager", 2, String.format("onGetNewerGuideRecommended list=%s, count=%s", new Object[] { paramList, Integer.valueOf(j) }));
    }
    if (this.bj == null) {}
    do
    {
      return;
      Object localObject = "";
      if (paramList != null)
      {
        localObject = ((FriendListHandler)this.mApp.getBusinessHandler(1)).a();
        JSONArray localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          RecommendedContactInfo localRecommendedContactInfo = (RecommendedContactInfo)paramList.next();
          String str = MsfSdkUtils.insertMtype("QQHeadIcon", localRecommendedContactInfo.faceUrl + ((QQHeadDownloadHandler)localObject).c((byte)(int)localRecommendedContactInfo.faceFlag));
          localRecommendedContactInfo.url = (str + "&t=" + System.currentTimeMillis());
          localJSONArray.put(localRecommendedContactInfo.toJson());
        }
        localObject = localJSONArray.toString();
      }
      paramList = this.bj.getBundle("request");
      if (paramList != null) {
        paramList.putString("op_result", (String)localObject);
      }
      paramList = (MessengerService)this.aL.get();
    } while (paramList == null);
    paramList.cp(this.bj);
  }
  
  public void onDestroy()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this);
    }
    dfp = 0;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object localObject;
    if (paramInt == 558)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginWelcomeManager", 2, String.format("TYPE_GET_REQUEST_GUIDE_FIRST [%s, %s]", new Object[] { Boolean.valueOf(paramBoolean), paramObject }));
      }
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length >= 4)
        {
          boolean bool = false;
          localObject = paramObject[0];
          if ((localObject instanceof String)) {
            this.bPJ = ((String)localObject);
          }
          localObject = paramObject[1];
          paramBoolean = bool;
          if ((localObject instanceof oidb_0x59f.BindContactInfo))
          {
            localObject = (oidb_0x59f.BindContactInfo)localObject;
            paramBoolean = bool;
            if (((oidb_0x59f.BindContactInfo)localObject).str_mobile.has())
            {
              paramBoolean = bool;
              if (!TextUtils.isEmpty(((oidb_0x59f.BindContactInfo)localObject).str_mobile.get()))
              {
                anot.a(this.mApp, "dc00898", "", "", "0X8006E3A", "0X8006E3A", 0, 0, "", "", "", "");
                paramBoolean = true;
              }
            }
          }
          localObject = paramObject[2];
          if (!(localObject instanceof Integer)) {
            break label366;
          }
        }
      }
    }
    label366:
    for (paramInt = ((Integer)localObject).intValue();; paramInt = 0)
    {
      paramObject = paramObject[3];
      if ((paramObject instanceof String)) {}
      for (paramObject = (String)paramObject;; paramObject = null)
      {
        localObject = paramObject;
        if (TextUtils.isEmpty(paramObject)) {
          localObject = "https://ti.qq.com/newguide/index.html?_wv=16777217";
        }
        if (QLog.isColorLevel()) {
          QLog.d("LoginWelcomeManager", 2, String.format("onUpdate bind=%s grayFlag=%s guideUrl=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), localObject }));
        }
        paramObject = this.mPreferences.edit();
        paramObject.putBoolean("first_device", true);
        paramObject.commit();
        do
        {
          return;
        } while (paramInt != 559);
        bz(paramBoolean, paramObject);
        bA(paramBoolean, paramObject);
        bB(paramBoolean, paramObject);
        this.mPreferences.edit().putLong("sp_key_contactsguide_last_req_time", System.currentTimeMillis()).commit();
        return;
      }
    }
  }
  
  public void run()
  {
    int j;
    BaseActivity localBaseActivity;
    try
    {
      j = this.mRetryCount + 1;
      this.mRetryCount = j;
      if (j > 10)
      {
        QLog.d("LoginWelcomeManager", 1, "handleNewerGuide retry max");
        return;
      }
      localBaseActivity = BaseActivity.sTopActivity;
      if ((localBaseActivity != null) && ((localBaseActivity instanceof RegisterQQNumberActivity)))
      {
        this.mHandler.postDelayed(this, 200L);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("LoginWelcomeManager", 2, "handleNewerGuide fail.", localException);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("handleNewerGuide real start guide, mBind=%s", new Object[] { Boolean.valueOf(this.cmd) }));
    }
    this.i = ((PhoneContactManagerImp)this.mApp.getManager(11));
    if (!this.i.Uy()) {
      j = 0;
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00898", "", "", localException, localException, 0, 0, "", "", "", "");
      ez(localBaseActivity);
      return;
      do
      {
        str = "0X8006E39";
        break;
        j = 1;
      } while (j == 0);
      String str = "0X8006E38";
    }
  }
  
  public void sc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onBindStateChanged bindState=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((paramInt != 8) && (paramInt != 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onBindStateChanged upload end, time cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.abW) }));
      }
      if (this.i != null)
      {
        if (paramInt != 9) {
          break label122;
        }
        if (!this.cmc) {
          break label115;
        }
        LA(true);
      }
    }
    for (;;)
    {
      this.i.b(this);
      this.i = null;
      return;
      label115:
      duV();
      continue;
      label122:
      if (paramInt == 2)
      {
        if (this.cmc) {
          LA(true);
        } else {
          duW();
        }
      }
      else if (this.cmc) {
        LA(false);
      } else {
        ln(null);
      }
    }
  }
  
  public void sd(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress percentage=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    if ((this.i != null) && (this.i.cbh >= 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, String.format("onUpdateMatchProgress upload packages >= 2, time cost:%sms", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - this.abW) }));
      }
      paramInt = this.i.xy();
      if ((paramInt != 8) && (paramInt != 9)) {
        break label136;
      }
      if (!this.cmc) {
        break label129;
      }
      LA(true);
    }
    for (;;)
    {
      this.i.b(this);
      this.i = null;
      return;
      label129:
      duV();
      continue;
      label136:
      if ((paramInt == 4) || (paramInt == 2)) {
        if (this.cmc) {
          LA(true);
        } else {
          duW();
        }
      }
    }
  }
  
  public void se(int paramInt) {}
  
  public static class a
  {
    public int dfq = 0;
    public String url;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CommonGuideInfo|").append("webUrl=").append(this.url).append(",type=").append(this.dfq);
      return localStringBuilder.toString();
    }
  }
  
  public static class b
  {
    public boolean cmg;
    public boolean cmh;
    public int dfr = -1;
    public int dfs = -1;
    public String url = "";
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ContactsGuideInfo|showWelcomepage=").append(this.cmg).append(",showConvGuideEntrance=").append(this.cmh).append(",friends_recomm_flag=").append(this.dfr).append(",groups_recomm_flag=").append(this.dfs).append(",url=").append(this.url);
      return localStringBuilder.toString();
    }
  }
  
  public static class c
  {
    public URLDrawable E;
    public boolean cmi;
  }
  
  public static abstract interface d
  {
    public abstract void a(LoginWelcomeManager.a parama);
    
    public abstract void q(URLDrawable paramURLDrawable);
  }
  
  public static class e
  {
    public String bPM = "https://qzonestyle.gtimg.cn/aoi/sola/20190530121837_iSfyMAuKAV.png";
    public int dft = 360;
    public String fixed_entrance_url = "https://qzonestyle.gtimg.cn/aoi/sola/20190530121848_eHHesyqska.png";
    
    public String toString()
    {
      return "popup_url=" + this.bPM + "\nfixed_entrance_url=" + this.fixed_entrance_url + "\nrequest_interval=" + this.dft;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.LoginWelcomeManager
 * JD-Core Version:    0.7.0.1
 */