import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.asyncdb.DBDelayManager;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class aagv
  implements Handler.Callback, Manager
{
  private static int cgF = -1;
  private long LS;
  private acoi jdField_a_of_type_Acoi;
  private adag jdField_a_of_type_Adag;
  private adah jdField_a_of_type_Adah = new aagw(this);
  private boolean aOD;
  private boolean bvy;
  private aqgw c;
  private DBDelayManager dbDelayManager;
  private int duration;
  private long et;
  private volatile boolean isInited;
  private ausj mActionSheet;
  private QQAppInterface mApp;
  private String wording;
  
  @Deprecated
  public aagv() {}
  
  public aagv(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.dbDelayManager = new DBDelayManager(this.mApp);
    this.dbDelayManager.start();
    this.jdField_a_of_type_Adag = ((adag)this.mApp.getBusinessHandler(148));
    this.jdField_a_of_type_Acoi = new acoi(this.mApp, this.dbDelayManager);
    this.c = new aqgw(ThreadManagerV2.getSubThreadLooper(), this);
    this.c.sendEmptyMessage(1);
    this.LS = eH();
    this.aOD = Wl();
    this.mApp.addObserver(this.jdField_a_of_type_Adah);
    cuh();
    aG(true);
  }
  
  /* Error */
  public static com.tencent.mobileqq.applets.data.AppletInfo a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 132	java/io/ObjectInputStream
    //   3: dup
    //   4: new 134	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 137	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: invokespecial 140	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_1
    //   16: aload_1
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 144	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_1
    //   24: astore_0
    //   25: aload_2
    //   26: instanceof 146
    //   29: ifeq +27 -> 56
    //   32: aload_1
    //   33: astore_0
    //   34: aload_2
    //   35: checkcast 146	com/tencent/mobileqq/applets/data/AppletInfo
    //   38: astore_2
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 149	java/io/ObjectInputStream:close	()V
    //   47: aload_2
    //   48: areturn
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   54: aload_2
    //   55: areturn
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 149	java/io/ObjectInputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   71: goto -7 -> 64
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: aload_2
    //   80: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 149	java/io/ObjectInputStream:close	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   98: goto -7 -> 91
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: invokevirtual 153	java/lang/ClassNotFoundException:printStackTrace	()V
    //   110: aload_1
    //   111: ifnull -20 -> 91
    //   114: aload_1
    //   115: invokevirtual 149	java/io/ObjectInputStream:close	()V
    //   118: goto -27 -> 91
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   126: goto -35 -> 91
    //   129: astore_1
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: ifnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 149	java/io/ObjectInputStream:close	()V
    //   140: aload_1
    //   141: athrow
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   147: goto -7 -> 140
    //   150: astore_1
    //   151: goto -19 -> 132
    //   154: astore_2
    //   155: goto -51 -> 104
    //   158: astore_2
    //   159: goto -82 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramArrayOfByte	byte[]
    //   15	100	1	localObjectInputStream	java.io.ObjectInputStream
    //   129	12	1	localObject1	Object
    //   150	1	1	localObject2	Object
    //   22	33	2	localObject3	Object
    //   74	6	2	localIOException1	java.io.IOException
    //   101	6	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   154	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   158	1	2	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   43	47	49	java/io/IOException
    //   60	64	66	java/io/IOException
    //   0	16	74	java/io/IOException
    //   87	91	93	java/io/IOException
    //   0	16	101	java/lang/ClassNotFoundException
    //   114	118	121	java/io/IOException
    //   0	16	129	finally
    //   136	140	142	java/io/IOException
    //   18	23	150	finally
    //   25	32	150	finally
    //   34	39	150	finally
    //   79	83	150	finally
    //   106	110	150	finally
    //   18	23	154	java/lang/ClassNotFoundException
    //   25	32	154	java/lang/ClassNotFoundException
    //   34	39	154	java/lang/ClassNotFoundException
    //   18	23	158	java/io/IOException
    //   25	32	158	java/io/IOException
    //   34	39	158	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(com.tencent.mobileqq.applets.data.AppletInfo paramAppletInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_1
    //   10: aload_1
    //   11: areturn
    //   12: new 160	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: invokespecial 161	java/io/ByteArrayOutputStream:<init>	()V
    //   19: astore_3
    //   20: new 163	java/io/ObjectOutputStream
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 166	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: invokevirtual 170	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   36: aload_2
    //   37: astore_1
    //   38: aload_3
    //   39: invokevirtual 174	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore_0
    //   43: aload_0
    //   44: astore_1
    //   45: aload_2
    //   46: ifnull -36 -> 10
    //   49: aload_2
    //   50: invokevirtual 175	java/io/ObjectOutputStream:close	()V
    //   53: aload_0
    //   54: areturn
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   60: aload_0
    //   61: areturn
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   71: aload 4
    //   73: astore_1
    //   74: aload_0
    //   75: ifnull -65 -> 10
    //   78: aload_0
    //   79: invokevirtual 175	java/io/ObjectOutputStream:close	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: ifnull +7 -> 102
    //   98: aload_1
    //   99: invokevirtual 175	java/io/ObjectOutputStream:close	()V
    //   102: aload_0
    //   103: athrow
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   109: goto -7 -> 102
    //   112: astore_0
    //   113: goto -19 -> 94
    //   116: astore_3
    //   117: aload_2
    //   118: astore_0
    //   119: goto -54 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramAppletInfo	com.tencent.mobileqq.applets.data.AppletInfo
    //   9	36	1	localObject1	Object
    //   55	2	1	localIOException1	java.io.IOException
    //   66	33	1	localObject2	Object
    //   104	2	1	localIOException2	java.io.IOException
    //   28	90	2	localObjectOutputStream	java.io.ObjectOutputStream
    //   19	20	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   62	6	3	localIOException3	java.io.IOException
    //   116	1	3	localIOException4	java.io.IOException
    //   1	71	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	53	55	java/io/IOException
    //   12	29	62	java/io/IOException
    //   78	82	84	java/io/IOException
    //   12	29	91	finally
    //   98	102	104	java/io/IOException
    //   31	36	112	finally
    //   38	43	112	finally
    //   67	71	112	finally
    //   31	36	116	java/io/IOException
    //   38	43	116	java/io/IOException
  }
  
  public static boolean aG(boolean paramBoolean)
  {
    int i;
    if ((cgF == -1) || (paramBoolean))
    {
      aeiw localaeiw = (aeiw)aeif.a().o(597);
      if (localaeiw == null) {
        break label85;
      }
      if (!localaeiw.bUi) {
        break label80;
      }
      i = 1;
      cgF = i;
      if (QLog.isColorLevel()) {
        QLog.d("AppletsFolderManager", 2, new Object[] { "mNeedShowInConversionStatus=", Integer.valueOf(cgF) });
      }
    }
    for (;;)
    {
      if (cgF != 1) {
        break label102;
      }
      return true;
      label80:
      i = 0;
      break;
      label85:
      if (QLog.isColorLevel()) {
        QLog.d("AppletsFolderManager", 2, "get config fail, use default");
      }
    }
    label102:
    return false;
  }
  
  private QQAppInterface getQQAppInterface()
  {
    localObject1 = this.mApp;
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = BaseApplicationImpl.getApplication();
      if (localObject2 == null) {
        break label69;
      }
      localObject2 = ((BaseApplicationImpl)localObject2).getRuntime();
      if (!(localObject2 instanceof QQAppInterface)) {
        break label69;
      }
      localObject2 = (QQAppInterface)localObject2;
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AppletsFolderManager", 2, "getQQAppInterface error!: ", localThrowable);
        Object localObject3 = localObject1;
      }
    }
    localObject2 = localObject1;
    if (localObject2 == null) {
      QLog.e("AppletsFolderManager", 2, "getQQAppInterface error: return null!");
    }
    return localObject2;
  }
  
  private SharedPreferences getSharedPreferences()
  {
    SharedPreferences localSharedPreferences = null;
    try
    {
      QQAppInterface localQQAppInterface = getQQAppInterface();
      if (localQQAppInterface != null) {
        localSharedPreferences = localQQAppInterface.getApp().getSharedPreferences("AppletsFolderManager" + localQQAppInterface.getCurrentAccountUin(), 0);
      }
      return localSharedPreferences;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AppletsFolderManager", 2, "getSharedPreferences error!: ", localThrowable);
    }
    return null;
  }
  
  public static boolean iN(String paramString)
  {
    if (TextUtils.equals(paramString, QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735"))) {
      return aG(false);
    }
    return true;
  }
  
  public Set<String> A()
  {
    Object localObject1 = null;
    Object localObject2 = getSharedPreferences();
    if (localObject2 == null) {}
    do
    {
      return localObject1;
      localObject2 = ((SharedPreferences)localObject2).getStringSet("applets_app_list_unreceive_msg_appids", null);
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("AppletsFolderManager", 2, "getAppletsSettingUnReceiveMsgAppids: " + localObject2);
    return localObject2;
  }
  
  public void An(String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_main_des", paramString).apply();
  }
  
  public void Ao(String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_app_list_des", paramString).apply();
  }
  
  public void Ap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Set localSet = A();
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet();
    }
    if (QLog.isColorLevel()) {
      QLog.i("AppletsFolderManager", 2, "addAppletsSettingUnReceiveMsgAppid: " + paramString);
    }
    ((Set)localObject).add(paramString);
    l((Set)localObject);
  }
  
  public void Aq(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Set localSet;
    do
    {
      do
      {
        return;
        localSet = A();
      } while ((localSet == null) || (localSet.size() < 1));
      if (QLog.isColorLevel()) {
        QLog.i("AppletsFolderManager", 2, "removeAppletsSettingUnReceiveMsgAppid: " + paramString);
      }
    } while (!localSet.remove(paramString));
    l(localSet);
  }
  
  public void Ar(String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().putString("applets_main_title", paramString).apply();
  }
  
  public void Ci(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return;
    }
    this.LS = NetConnInfoCenter.getServerTime();
    this.aOD = paramBoolean;
    localSharedPreferences.edit().putBoolean("applets_setting_main_switch", paramBoolean).putLong("applets_setting_main_switch_time", NetConnInfoCenter.getServerTime()).apply();
  }
  
  public boolean Wl()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return false;
    }
    this.aOD = localSharedPreferences.getBoolean("applets_setting_main_switch", false);
    return this.aOD;
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    int j = 1;
    int i = j;
    String str;
    if (paramMessage != null)
    {
      str = paramMessage.getExtInfoFromExtStr(anbb.cdj);
      if (TextUtils.isEmpty(str)) {
        break label61;
      }
    }
    label61:
    for (i = Integer.valueOf(str).intValue();; i = 1)
    {
      if (paramMessage.time < this.LS)
      {
        i = j;
        if (this.aOD) {
          i = 2;
        }
        return i;
      }
      return i;
    }
  }
  
  public int a(QQMessageFacade.Message paramMessage, RecentUser paramRecentUser)
  {
    int j = 1;
    int i = j;
    if (paramMessage != null)
    {
      paramMessage = paramMessage.getExtInfoFromExtStr(anbb.cdj);
      if (TextUtils.isEmpty(paramMessage)) {
        break label65;
      }
    }
    label65:
    for (i = Integer.valueOf(paramMessage).intValue();; i = 1)
    {
      if ((paramRecentUser != null) && (paramRecentUser.lastmsgtime < this.LS))
      {
        i = j;
        if (this.aOD) {
          i = 2;
        }
        return i;
      }
      return i;
    }
  }
  
  public AppletsAccountInfo a(String paramString)
  {
    paramString = this.jdField_a_of_type_Acoi.b(paramString);
    if ((paramString != null) && (paramString.appInfoDetail != null)) {
      paramString.appInfo = a(paramString.appInfoDetail);
    }
    return paramString;
  }
  
  public void a(AppletsAccountInfo paramAppletsAccountInfo)
  {
    if (paramAppletsAccountInfo != null)
    {
      paramAppletsAccountInfo.appInfoDetail = a(paramAppletsAccountInfo.appInfo);
      this.jdField_a_of_type_Acoi.b(paramAppletsAccountInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppletsFolderManager", 2, "putAppletAccountInfo: " + paramAppletsAccountInfo);
    }
  }
  
  public void c(RecentUser paramRecentUser)
  {
    if (paramRecentUser != null)
    {
      paramRecentUser = paramRecentUser.uin;
      this.c.obtainMessage(3, 0, 0, paramRecentUser).sendToTarget();
    }
  }
  
  public void cV(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return;
    }
    this.duration = paramInt;
    this.wording = paramString;
    localSharedPreferences.edit().putString("applets_detail_request_answer", paramString).putInt("applets_detail_request_duration", this.duration).apply();
  }
  
  public void cuh()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return;
    }
    this.wording = localSharedPreferences.getString("applets_detail_request_answer", "");
    this.duration = localSharedPreferences.getInt("applets_detail_request_duration", 0);
    this.et = localSharedPreferences.getLong("applets_detail_last_request_time", 0L);
  }
  
  public void doInit()
  {
    if (!this.isInited)
    {
      this.jdField_a_of_type_Acoi.doInit();
      this.isInited = true;
    }
  }
  
  public long eH()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return 0L;
    }
    this.LS = localSharedPreferences.getLong("applets_setting_main_switch_time", 0L);
    return this.LS;
  }
  
  public void gF(long paramLong)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return;
    }
    this.et = paramLong;
    localSharedPreferences.edit().putLong("applets_detail_last_request_time", paramLong).apply();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      doInit();
      return true;
      paramMessage = ((List)paramMessage.obj).iterator();
      while (paramMessage.hasNext()) {
        a((AppletsAccountInfo)paramMessage.next());
      }
      paramMessage = (String)paramMessage.obj;
      if (!this.isInited)
      {
        this.jdField_a_of_type_Acoi.doInit();
        this.isInited = true;
      }
    } while ((a(paramMessage) != null) && (this.et + this.duration > NetConnInfoCenter.getServerTime()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramMessage));
    this.jdField_a_of_type_Adag.jv(localArrayList);
    gF(NetConnInfoCenter.getServerTime());
    return true;
  }
  
  public void l(Set<String> paramSet)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {}
    for (;;)
    {
      return;
      if ((paramSet == null) || (paramSet.size() < 1)) {
        localSharedPreferences.edit().remove("applets_app_list_unreceive_msg_appids").apply();
      }
      while (QLog.isColorLevel())
      {
        QLog.i("AppletsFolderManager", 2, "updateAppletsSettingUnReceiveMsgAppids: " + paramSet);
        return;
        localSharedPreferences.edit().putStringSet("applets_app_list_unreceive_msg_appids", paramSet).apply();
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsFolderManager", 2, "onDestroy.");
    }
    cgF = -1;
    this.c.removeCallbacksAndMessages(null);
    if (this.dbDelayManager != null) {
      this.dbDelayManager.onDestroy();
    }
    if (this.mApp != null) {
      this.mApp.removeObserver(this.jdField_a_of_type_Adah);
    }
    if (this.jdField_a_of_type_Acoi != null) {
      this.jdField_a_of_type_Acoi.clearCache();
    }
    this.mApp = null;
  }
  
  public String qu()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_main_des", "");
  }
  
  public String qv()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_app_list_des", "");
  }
  
  public String qw()
  {
    SharedPreferences localSharedPreferences = getSharedPreferences();
    if (localSharedPreferences == null) {
      return "";
    }
    return localSharedPreferences.getString("applets_main_title", "");
  }
  
  public void u(Context paramContext, String paramString1, String paramString2)
  {
    QQAppInterface localQQAppInterface = getQQAppInterface();
    if (localQQAppInterface == null) {
      return;
    }
    localQQAppInterface.runOnUiThread(new AppletsFolderManager.2(this, paramContext, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagv
 * JD-Core Version:    0.7.0.1
 */