import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiIncomingCallUICtr.2;
import com.tencent.av.ui.MultiIncomingCallUICtr.5;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class izr
  extends ixs
{
  String OG = "";
  String QK = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  boolean Td = false;
  boolean WT;
  boolean WU = false;
  public VideoController a;
  iid jdField_a_of_type_Iid = new izt(this);
  iiz jdField_a_of_type_Iiz = new izu(this);
  jko jdField_a_of_type_Jko;
  int aqD = -1;
  igv b = igv.a();
  Runnable bU = null;
  Runnable bf = new MultiIncomingCallUICtr.5(this);
  int mBindType = 0;
  private BroadcastReceiver mBroadcastReceiver = new izs(this);
  Intent mIntent;
  
  public izr(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.mIntent = paramIntent;
  }
  
  void H(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Long localLong;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("MultiIncomingCallUICtr", 1, "closeSession, reason[" + paramInt + "], seq[" + paramLong + "]");
      }
      localLong = Long.valueOf(jji.B(this.mPeerUin));
      if (!this.Td) {
        break;
      }
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, localLong.longValue(), 7);
        return;
      }
    } while (paramInt != 2);
    this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, localLong.longValue(), 2);
    return;
    this.jdField_a_of_type_ComTencentAvVideoController.O(this.e.peerUin, 243);
    this.jdField_a_of_type_ComTencentAvVideoController.ko(243);
  }
  
  void a(long paramLong1, int paramInt1, long paramLong2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (!paramBoolean2) {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, 10, false);
    }
    for (;;)
    {
      if ((paramBoolean1) && (this.mApp != null)) {
        this.mApp.l(new Object[] { Integer.valueOf(67), Long.valueOf(paramLong2), Integer.valueOf(3) });
      }
      anot.a(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
      onDestroy();
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong1, paramInt1, paramLong2, paramInt2, false);
    }
  }
  
  void a(long paramLong, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.mPeerUin = paramIntent.getStringExtra("peerUin");
    this.OD = paramIntent.getStringExtra("extraUin");
    this.Td = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    this.mUinType = paramIntent.getIntExtra("uinType", 0);
    this.aqx = paramIntent.getIntExtra("relationType", 3);
    this.aqD = paramIntent.getIntExtra("memberType", -1);
    this.WT = paramIntent.getBooleanExtra("hasGVideoJoined", false);
    this.VL = paramIntent.getBooleanExtra("isAudioMode", false);
    this.mBindType = paramIntent.getIntExtra("bindType", 0);
    if (jjc.co(this.mUinType)) {
      if (paramIntent.getIntExtra("MultiAVType", -1) == 2)
      {
        this.VL = false;
        label128:
        this.mf = paramIntent.getLongExtra("friendUin", 0L);
        this.OG = paramIntent.getStringExtra("inviteId");
        this.mGroupId = paramIntent.getLongExtra("discussId", 0L);
        String str = igv.a(this.aqx, String.valueOf(this.mGroupId), new int[0]);
        this.e = this.b.c(str);
        this.o = paramIntent.getLongArrayExtra("memberList");
        this.mApp.addObserver(this.jdField_a_of_type_Iid);
      }
    }
    for (;;)
    {
      jw(true);
      if ((this.e != null) || (this.mUinType == 1)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "session info null!");
      }
      onDestroy();
      return;
      this.VL = true;
      break label128;
      if (!this.Td) {
        break label403;
      }
      paramIntent = igv.a(100, this.mPeerUin, new int[0]);
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "sessionId : " + paramIntent);
      }
      this.VL = false;
      this.e = igv.a().c(paramIntent);
      this.e.e(paramLong, "processIntent.1", 4);
      this.e.S("processIntent", true);
      this.e.Ra = true;
      this.e.PT = true;
      this.e.isFriend = this.mApp.isFriend(this.mPeerUin);
      this.mApp.addObserver(this.jdField_a_of_type_Iid);
    }
    label403:
    paramIntent = igv.a(3, this.mPeerUin, new int[0]);
    this.e = igv.a().c(paramIntent);
    if (this.VL)
    {
      this.e.e(paramLong, "processIntent.2", 1);
      this.e.n(paramLong, false);
    }
    for (;;)
    {
      this.e.PT = true;
      this.e.isFriend = this.mApp.isFriend(this.mPeerUin);
      this.mApp.addObserver(this.jdField_a_of_type_Iiz);
      break;
      this.e.e(paramLong, "processIntent.3", 2);
      this.e.n(paramLong, true);
    }
  }
  
  void a(long paramLong, iiv paramiiv)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "acceptRequest, seq[" + paramLong + "]");
    }
    this.WU = true;
    iiv localiiv = igv.a().a();
    if (this.jdField_a_of_type_ComTencentAvVideoController.OD)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.hI(true);
      if (this.e == null) {
        break label591;
      }
      if (this.e.tc()) {
        break label310;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "Session already destroyed, id:" + this.e.sessionId + ", status = " + this.e.state);
      }
      if (this.jdField_a_of_type_Jet != null) {
        this.jdField_a_of_type_Jet.setMessage(acfp.m(2131708579));
      }
    }
    label310:
    label374:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return;
        if ((paramiiv != null) && (localiiv == paramiiv))
        {
          if (igv.a().kv() >= 2)
          {
            if (paramiiv.tc()) {
              a(paramLong, false, paramiiv);
            }
            for (;;)
            {
              c(paramiiv);
              break;
              this.jdField_a_of_type_ComTencentAvVideoController.a(true, 201, new int[] { localiiv.anb });
              this.jdField_a_of_type_ComTencentAvVideoController.ko(201);
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MultiIncomingCallUICtr", 2, "no need to close main session because there is only one session");
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("mainSession invalid when accept 3rd request, currMainSession == mainSessionInfo:");
        if (localiiv == paramiiv) {}
        for (boolean bool = true;; bool = false)
        {
          QLog.d("MultiIncomingCallUICtr", 2, bool);
          break;
        }
        if (!jjc.co(this.mUinType)) {
          break label374;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.aqx, this.e.ll, this.o, false);
        anot.a(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      int i = 1;
      if (this.VL) {
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "appType :" + i);
      }
      if (this.Td)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiIncomingCallUICtr", 2, "acceptVideoRequest isDoubleVideoMeeting");
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, Long.valueOf(this.e.peerUin).longValue(), null, false);
        anot.a(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        asb();
        break;
        int j = jll.cN(this.aqx);
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.mPeerUin, i, j);
        if (this.VL) {
          anot.a(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
        } else {
          anot.a(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
        }
      }
    }
    label591:
    QLog.d("MultiIncomingCallUICtr", 2, "session invalid when accept request");
  }
  
  void a(long paramLong, boolean paramBoolean, iiv paramiiv)
  {
    a(paramLong, paramBoolean, paramiiv, -1);
  }
  
  void a(long paramLong, boolean paramBoolean, iiv paramiiv, int paramInt)
  {
    boolean bool3 = false;
    if (paramBoolean) {
      this.WU = false;
    }
    TraeHelper.t(this.mApp);
    Object localObject = this.mPeerUin;
    boolean bool1 = this.Td;
    int i = this.aqx;
    long l = this.mGroupId;
    if (!paramBoolean) {
      if (paramiiv != null)
      {
        String str = paramiiv.peerUin;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = paramiiv.senderUin;
        }
        bool1 = paramiiv.Qw;
        i = paramiiv.relationType;
        l = paramiiv.ll;
      }
    }
    for (;;)
    {
      int j = jll.cM(i);
      boolean bool2 = bool3;
      if (!paramBoolean) {
        if (!bool1)
        {
          bool2 = bool3;
          if (!cw(j)) {}
        }
        else
        {
          bool2 = true;
        }
      }
      if (jjc.co(j))
      {
        a(paramLong, i, l, bool2, paramInt, paramBoolean);
        return;
      }
      a(paramLong, bool1, (String)localObject, bool2, paramBoolean);
      return;
    }
  }
  
  void a(long paramLong, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "refuseDoubleCall, isDoubleVideoMeeting[" + paramBoolean1 + "], peerUin[" + paramString + "], notifyDestroyUI[" + paramBoolean2 + "], refuse3rd[" + paramBoolean3 + "], seq[" + paramLong + "]");
    }
    long l2;
    if (this.e.QE)
    {
      anot.a(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
      if (!paramBoolean1) {
        break label317;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, paramString, 1, true);
      l2 = -1L;
    }
    for (;;)
    {
      try
      {
        l1 = jji.B(paramString);
        if (!paramBoolean3)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, l1, 10, false);
          this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, l1, 23);
          onDestroy();
          if ((!paramBoolean2) || (this.mApp == null)) {
            break;
          }
          this.mApp.l(new Object[] { Integer.valueOf(28), paramString, Boolean.valueOf(true) });
          return;
          anot.a(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        long l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MultiIncomingCallUICtr", 2, "", localNumberFormatException);
        l1 = l2;
        continue;
        this.jdField_a_of_type_ComTencentAvVideoController.c(paramLong, 3, l1);
        this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, l1, 1);
        onDestroy();
        continue;
      }
      label317:
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.a(paramLong, paramString, 1, false, new MultiIncomingCallUICtr.2(this, localVideoController, paramString, paramBoolean3));
    }
  }
  
  public void asV()
  {
    Intent localIntent = new Intent("tencent.video.v2q.ACTION_ENTER_GROUP_VEDIO");
    localIntent.putExtra("relationId", this.mGroupId + "");
    localIntent.putExtra("enterType", 1);
    localIntent.setPackage(this.mApp.getApp().getPackageName());
    this.mApp.getApp().sendBroadcast(localIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "sendBroadcast, qav_gaudio_answer");
    }
    this.mApp.l(new Object[] { Integer.valueOf(514), Long.valueOf(this.mGroupId) });
    cx(1);
  }
  
  void asW()
  {
    if (this.jdField_a_of_type_Jko == null) {
      this.jdField_a_of_type_Jko = jko.a(this.mApp);
    }
    Object localObject;
    if (!jjc.co(this.mUinType))
    {
      localObject = this.mApp.a(this.mUinType, this.mPeerUin, this.OD, true, true);
      if ((!this.VL) && (!this.Td)) {
        this.jdField_a_of_type_Jko.a(this.e.sessionId, this.OE, (Bitmap)localObject, null, 56, this.mUinType, 2);
      }
    }
    Bitmap localBitmap;
    String str;
    do
    {
      return;
      this.jdField_a_of_type_Jko.a(this.e.sessionId, this.OE, (Bitmap)localObject, null, 55, this.mUinType, 1);
      return;
      localObject = String.valueOf(this.mGroupId);
      localBitmap = this.mApp.a(this.mUinType, (String)localObject, null, true, true);
      int i = jjc.cI(this.mUinType);
      str = this.mApp.getDisplayName(i, Long.toString(this.mf), (String)localObject);
    } while (this.e == null);
    this.jdField_a_of_type_Jko.a(this.e.sessionId, str, localBitmap, (String)localObject, 57, this.mUinType, 3);
  }
  
  void asc()
  {
    if (!cx(0)) {
      a(-1036L, true, null);
    }
  }
  
  public int b(Intent paramIntent)
  {
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onStartCommand, seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    uu();
    a(l, paramIntent);
    return 2;
  }
  
  void c(iiv paramiiv)
  {
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (paramiiv != null))
    {
      Intent localIntent = new Intent();
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      localIntent.setAction("tencent.av.v2q.StopVideoChat");
      localIntent.putExtra("stopReason3rd", 1);
      localIntent.putExtra("groupId", paramiiv.ll);
      localIntent.putExtra("peerUin", paramiiv.peerUin);
      this.mApp.getApp().sendBroadcast(localIntent);
    }
  }
  
  boolean cw(int paramInt)
  {
    return paramInt == 3000;
  }
  
  boolean cx(int paramInt)
  {
    if ((this.mUinType == 1) && (!TextUtils.isEmpty(this.OG)))
    {
      Intent localIntent = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
      localIntent.putExtra("relationId", this.mGroupId + "");
      localIntent.putExtra("dealResult", paramInt);
      localIntent.putExtra("inviteId", this.OG);
      localIntent.putExtra("friendUin", this.mf);
      localIntent.setPackage(this.mApp.getApp().getPackageName());
      this.mApp.getApp().sendBroadcast(localIntent);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "sendBroadcast, qav_gaudio_join");
      }
      return true;
    }
    return false;
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onCreate start");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
    localIntentFilter.addAction("tencent.video.invite.multiaccept");
    localIntentFilter.addAction("tencent.video.invite.multirefuse");
    localIntentFilter.addAction("tencent.av.EXIT_QZONE_LIVE_RSP_ACTION");
    localIntentFilter.addAction("tencent.video.destroyService");
    this.mApp.getApplication().registerReceiver(this.mBroadcastReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mApp != null) {}
    try
    {
      this.mApp.getApplication().unregisterReceiver(this.mBroadcastReceiver);
      this.mApp.deleteObserver(this.jdField_a_of_type_Iid);
      this.mApp.deleteObserver(this.jdField_a_of_type_Iiz);
      if (this.bU != null)
      {
        this.mApp.getHandler().removeCallbacks(this.bU);
        this.bU = null;
      }
      if (this.bf != null)
      {
        this.mApp.getHandler().removeCallbacks(this.bf);
        this.bf = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiIncomingCallUICtr", 2, "onDestroy error : " + localException);
        }
      }
    }
  }
  
  boolean uu()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam");
    }
    boolean bool1 = bool2;
    if (this.mApp != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().tf()) || (this.jdField_a_of_type_ComTencentAvVideoController.b().tg()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiIncomingCallUICtr", 2, "initEnvParam closeSession");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.P(this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin, 2);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     izr
 * JD-Core Version:    0.7.0.1
 */