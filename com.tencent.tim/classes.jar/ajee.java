import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.1;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager.5;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupCompleteFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCConfirmFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPcBaseFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime.InterceptKickListener;
import mqq.app.AppRuntime.KickParams;
import mqq.os.MqqHandler;

public class ajee
  implements ajdy
{
  private static volatile ajee jdField_a_of_type_Ajee;
  public static String bQR;
  public static String bQS;
  public static String bQT;
  public static String bQU;
  public static boolean cnG;
  public static boolean cnH;
  public static boolean cnI;
  public static volatile boolean cnJ;
  public static boolean cnK;
  public static boolean cnL = true;
  public static boolean cnM;
  public static int din;
  public static int dio;
  public static int dip;
  public static ConcurrentHashMap<String, String> fY = new ConcurrentHashMap();
  protected ajdu a;
  private ajdw jdField_a_of_type_Ajdw;
  private ajdx jdField_a_of_type_Ajdx;
  private ajea jdField_a_of_type_Ajea = new ajeh(this);
  private ajeb jdField_a_of_type_Ajeb = new ajeb(this.mApp);
  private ajgp jdField_a_of_type_Ajgp = ajgp.b();
  private AppRuntime.KickParams jdField_a_of_type_MqqAppAppRuntime$KickParams;
  private long ach;
  private ajdt jdField_b_of_type_Ajdt;
  public ajea b;
  private ajer jdField_b_of_type_Ajer;
  public HashSet<RecentBaseData> bi = new HashSet();
  private int bizType = 3;
  private int diq;
  private final AtomicBoolean dr = new AtomicBoolean();
  public ConcurrentHashMap<String, ajew> fZ = new ConcurrentHashMap();
  public ConcurrentHashMap<String, ajew> ga = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, ajgs.b> gb = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, ajgs.b> gc = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, ajex> gd = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, ajex> ge = new ConcurrentHashMap();
  public CopyOnWriteArraySet<Long> k = new CopyOnWriteArraySet();
  private QQAppInterface mApp = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  private AppRuntime.InterceptKickListener mInterceptKickListener;
  private String mSelfUin = this.mApp.getCurrentUin();
  private int mTotalCount;
  
  private ajee()
  {
    this.jdField_a_of_type_Ajdu = new ajef(this);
    cnM = true;
  }
  
  private void QF(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aFailed: " + paramInt);
    }
    if (paramInt == 6) {
      if (this.jdField_a_of_type_Ajdw != null) {
        this.jdField_a_of_type_Ajdw.dwt();
      }
    }
    while (paramInt != 20) {
      return;
    }
  }
  
  public static ajee a()
  {
    if (jdField_a_of_type_Ajee == null) {}
    try
    {
      if (jdField_a_of_type_Ajee == null) {
        jdField_a_of_type_Ajee = new ajee();
      }
      return jdField_a_of_type_Ajee;
    }
    finally {}
  }
  
  private void a(ajeo paramajeo)
  {
    if (paramajeo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11a, data is null!");
      }
    }
    String str1;
    String str2;
    int i;
    MsgBackupEndPoint localMsgBackupEndPoint1;
    MsgBackupEndPoint localMsgBackupEndPoint2;
    List localList;
    do
    {
      return;
      str1 = paramajeo.xl();
      str2 = paramajeo.getToken();
      i = paramajeo.Gi();
      localMsgBackupEndPoint1 = new MsgBackupEndPoint();
      localMsgBackupEndPoint2 = new MsgBackupEndPoint();
      int j = ajgv.dB(paramajeo.a().getIp());
      localMsgBackupEndPoint1.ipv4 = j;
      localMsgBackupEndPoint2.ipv4 = j;
      localList = paramajeo.a().fE();
    } while (localList.size() != 2);
    localMsgBackupEndPoint2.port = ((Integer)localList.get(0)).intValue();
    localMsgBackupEndPoint1.port = ((Integer)localList.get(1)).intValue();
    ajgp localajgp = a();
    localajgp.Mw(str1);
    b().setToken(str2);
    b().QE(i);
    localajgp.b(localMsgBackupEndPoint2);
    localajgp.a(localMsgBackupEndPoint1);
    if (i == 1)
    {
      localajgp.QM(2);
      localajgp.QL(2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "processPush0x11aSucc: client ip = " + paramajeo.a().getIp() + ", udpport = " + localList.get(1) + ", tcpport = " + localList.get(0));
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "pc端已经确认了，客户端收到了0x11a的push了--------> bizType= " + i);
      }
      paramajeo = new Intent();
      if (BaseActivity.sTopActivity != null) {
        break;
      }
      ajgv.b("MsgBackup.BackupAndMigrateManager", "activity is null! please check whether is assigned!", new Object[0]);
      return;
      if (i == 2)
      {
        localajgp.QM(1);
        localajgp.QL(1);
      }
    }
    PublicFragmentActivity.startForResult(BaseActivity.sTopActivity, paramajeo, MsgBackupPCConfirmFragment.class, 1000);
  }
  
  private boolean aqw()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime$KickParams != null;
  }
  
  public static void dwH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar <=======");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134067));
        ajgp.b().b(null);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar: send msg MSG_MUSIC_PLAYER_HIDE");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar app = null!");
  }
  
  public int Gj()
  {
    return this.diq;
  }
  
  public void LV(boolean paramBoolean)
  {
    int i = 3;
    if (paramBoolean) {
      i = 1;
    }
    for (;;)
    {
      b().QE(i);
      this.jdField_a_of_type_Ajgp.cw(this.mSelfUin, paramBoolean);
      return;
      this.jdField_b_of_type_Ajer = null;
      this.mApp.addObserver(this.jdField_a_of_type_Ajdu);
    }
  }
  
  public void Mt(String paramString)
  {
    if (paramString != null) {
      ((ajds)this.mApp.getBusinessHandler(162)).Mq(paramString);
    }
  }
  
  public ajer a()
  {
    return this.jdField_b_of_type_Ajer;
  }
  
  public ajgp a()
  {
    if (this.jdField_a_of_type_Ajgp == null) {
      this.jdField_a_of_type_Ajgp = ajgp.b();
    }
    return this.jdField_a_of_type_Ajgp;
  }
  
  public void a(int paramInt, ajek paramajek, Object paramObject)
  {
    if (paramajek.dir == 0) {}
    while (paramajek.dir != 2) {
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar----------> bizType = " + paramInt2 + ", finishedCount" + paramInt1 + ", sessionCount = " + dio);
    }
    this.mTotalCount = dio;
    this.bizType = paramInt2;
    this.ach = paramLong;
    this.diq = paramInt1;
    int i = paramInt1;
    if (paramInt1 != dio) {
      i = paramInt1 + 1;
    }
    MqqHandler localMqqHandler = this.mApp.getHandler(Conversation.class);
    Message localMessage;
    String str2;
    String str1;
    if (localMqqHandler != null)
    {
      localMessage = localMqqHandler.obtainMessage(1134066);
      if (paramInt2 != 1) {
        break label266;
      }
      str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690759);
      str1 = i + "/" + dio;
    }
    for (;;)
    {
      localMessage.obj = String.format(str2, new Object[] { str1, ajgv.bw(paramLong) + "B/s" });
      localMessage.arg1 = paramInt2;
      ajdt.a().QE(paramInt2);
      localMqqHandler.sendMessage(localMessage);
      ajgp.b().b(null);
      ajgp.b().b(this.jdField_a_of_type_Ajea);
      v(paramBaseActivity);
      paramBaseActivity.finish();
      return;
      label266:
      if (paramInt2 == 3)
      {
        str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690761);
        str1 = i + "/" + dio;
      }
      else
      {
        str2 = BaseApplicationImpl.getApplication().getResources().getString(2131690761);
        str1 = i + "/" + dio;
      }
    }
  }
  
  public void a(ajdw paramajdw)
  {
    this.jdField_a_of_type_Ajdw = paramajdw;
  }
  
  public void a(ajdx paramajdx)
  {
    this.jdField_a_of_type_Ajdx = paramajdx;
  }
  
  public void a(ajea paramajea)
  {
    this.jdField_b_of_type_Ajea = paramajea;
  }
  
  public void a(ajek paramajek, Object paramObject)
  {
    if (paramajek.dir == 0) {
      if ((paramObject != null) && ((paramObject instanceof ajew)))
      {
        paramajek = (ajew)paramObject;
        paramObject = new File(ajgv.j(paramajek.uin, ajgv.cS(paramajek.uinType), paramajek.bQY));
        if (paramObject.exists()) {
          break label72;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! file is not exist!");
        }
      }
    }
    label72:
    while ((paramajek.dir != 2) || (this.jdField_b_of_type_Ajea == null))
    {
      return;
      paramajek.dbSize = paramObject.length();
      this.fZ.put(ajgv.aq(paramajek.uin, ajgv.cS(paramajek.uinType)), paramajek);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProgress, db prepared! result = 0, sessionInfo.uin = " + paramajek.uin);
      }
      a().QN(257);
      return;
    }
    this.jdField_b_of_type_Ajea.iD(paramajek.curIndex + 1, paramajek.totalCount);
  }
  
  public void a(ajet paramajet)
  {
    if (cnH) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11b: now is phone to phone transfer, so please wait the transfer done!");
      }
    }
    while (paramajet == null) {
      return;
    }
    cnI = true;
    Intent localIntent = new Intent();
    int i = paramajet.Gi();
    b().QE(i);
    paramajet = paramajet.xn();
    b().Mr(paramajet);
    localIntent.putExtra("0x11bpush_extra", paramajet);
    localIntent.putExtra("BIZ_TYPE", i);
    localIntent.addFlags(268435456);
    PublicFragmentActivity.start(BaseApplicationImpl.getApplication(), localIntent, MsgBackupPCConfirmFragment.class);
  }
  
  public ajdt b()
  {
    if (this.jdField_b_of_type_Ajdt == null) {
      this.jdField_b_of_type_Ajdt = ajdt.a();
    }
    return this.jdField_b_of_type_Ajdt;
  }
  
  public void bY(Activity paramActivity)
  {
    try
    {
      paramActivity.getWindow().addFlags(128);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgBackup.BackupAndMigrateManager", 2, "acquireBrightWakeLock:" + paramActivity.toString());
    }
  }
  
  public void bZ(Activity paramActivity)
  {
    try
    {
      paramActivity.getWindow().clearFlags(128);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgBackup.BackupAndMigrateManager", 2, "acquireBrightWakeLock:" + paramActivity.toString());
    }
  }
  
  public void br(Object paramObject)
  {
    if ((paramObject instanceof ajeo))
    {
      paramObject = (ajeo)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "onProcessPush0x11a: " + paramObject);
      }
      a(paramObject);
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    QF(((Integer)paramObject).intValue());
  }
  
  public void c(BaseActivity paramBaseActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory show msgtab bar----------> bizType = " + paramInt + ", hasFinishedCount = " + this.diq + ", sessionCount = " + dio);
    }
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.BackupAndMigrateManager", 2, "gotoSpecialPage------------------");
      }
      if (this.mTotalCount == this.diq)
      {
        MsgBackupCompleteFragment.s(paramBaseActivity, this.mTotalCount, this.diq);
        return;
      }
      MsgBackupPcBaseFragment.aq(paramBaseActivity, paramInt);
      return;
    }
    if (paramInt == 3)
    {
      Intent localIntent = new Intent();
      if (this.mTotalCount == this.diq)
      {
        if (ajgp.b().getRole() == 2)
        {
          MsgBackupCompleteFragment.n(paramBaseActivity, this.mTotalCount, this.diq);
          return;
        }
        MsgBackupCompleteFragment.q(paramBaseActivity, this.mTotalCount, this.diq);
        return;
      }
      localIntent.putExtra("param_start", 5);
      PublicFragmentActivity.start(paramBaseActivity, localIntent, MsgBackupTransportFragment.class);
      return;
    }
    if (this.mTotalCount == this.diq)
    {
      MsgBackupCompleteFragment.w(paramBaseActivity, this.mTotalCount, this.diq);
      return;
    }
    MsgBackupPcBaseFragment.aq(paramBaseActivity, paramInt);
  }
  
  public void clear()
  {
    this.bi.clear();
  }
  
  public void clearSessionData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "clearSessionData ->>>>>>>>>>");
    }
    dio = 0;
    bQU = null;
    dip = 0;
    this.fZ.clear();
    this.k.clear();
    this.gb.clear();
    this.gc.clear();
    this.gd.clear();
    this.ge.clear();
    cnI = false;
    this.jdField_b_of_type_Ajer = null;
    removeObserver();
    cnK = false;
  }
  
  public void d(ajek paramajek)
  {
    if (paramajek == null) {
      return;
    }
    paramajek.a = this;
    this.jdField_a_of_type_Ajeb.a(paramajek, 10000);
  }
  
  public void ds(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Ajgp.T(this.mSelfUin, paramInt, paramString);
  }
  
  public void dt(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.BackupAndMigrateManager", 2, "msg memory update msgtab bar----------> content = " + paramString + "., bizType = " + paramInt);
    }
    MqqHandler localMqqHandler = this.mApp.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(1134066);
      localMessage.obj = paramString;
      localMessage.arg1 = paramInt;
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  public void dwA()
  {
    bQR = null;
    bQS = null;
    bQT = null;
    fY.clear();
    din = 0;
  }
  
  public void dwB() {}
  
  public void dwC()
  {
    ((ajds)this.mApp.getBusinessHandler(162)).dwr();
  }
  
  public void dwD()
  {
    ajgv.c("MsgBackup.BackupAndMigrateManager", "sFileMeta = %s", new Object[] { bQR });
    if (TextUtils.isEmpty(bQR)) {}
    ((ajds)this.mApp.getBusinessHandler(162)).Mp(bQR);
  }
  
  public void dwE()
  {
    this.jdField_a_of_type_Ajgp.Mv(this.mSelfUin);
  }
  
  public void dwF()
  {
    this.dr.set(true);
    this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    if (this.mInterceptKickListener == null) {
      this.mInterceptKickListener = new ajeg(this);
    }
    this.mApp.setInterceptKickListener(this.mInterceptKickListener);
  }
  
  public void dwG()
  {
    this.dr.set(false);
    if (aqw())
    {
      this.mApp.kick(this.jdField_a_of_type_MqqAppAppRuntime$KickParams);
      this.jdField_a_of_type_MqqAppAppRuntime$KickParams = null;
    }
    this.mApp.setInterceptKickListener(null);
  }
  
  public void dwI()
  {
    ThreadManager.getSubThreadHandler().post(new MsgBackupManager.5(this));
  }
  
  public void dwJ() {}
  
  public void e(ajek paramajek)
  {
    if (paramajek == null) {
      return;
    }
    paramajek.a = this;
    this.jdField_a_of_type_Ajeb.a(paramajek, 10001);
  }
  
  public void f(ajek paramajek)
  {
    if (paramajek == null) {
      return;
    }
    paramajek.a = this;
    this.jdField_a_of_type_Ajeb.a(paramajek, -1);
  }
  
  public long gn()
  {
    return this.ach;
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    ajgt.dxt();
    onDestroy();
    try
    {
      release();
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    ajgv.b("MsgBackup.BackupAndMigrateManager", "onDestory ......", new Object[0]);
    this.jdField_a_of_type_Ajgp.onDestroy();
    clearSessionData();
    cnH = false;
    this.jdField_a_of_type_Ajeb.onDestroy();
    ajgt.dxu();
    ThreadManager.getFileThreadHandler().post(new MsgBackupManager.1(this));
  }
  
  public void release()
  {
    this.jdField_a_of_type_Ajeb.release();
    cnM = false;
    jdField_a_of_type_Ajee = null;
  }
  
  public void removeObserver()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_Ajdu);
  }
  
  public void v(BaseActivity paramBaseActivity)
  {
    Intent localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(67108864);
    paramBaseActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajee
 * JD-Core Version:    0.7.0.1
 */