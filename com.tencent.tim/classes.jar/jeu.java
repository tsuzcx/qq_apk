import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.VideoInviteFloatBarUICtr.4;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class jeu
  extends ixs
{
  String OG = "";
  String QK = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  boolean Td = false;
  public boolean VD;
  public VideoController a;
  iid jdField_a_of_type_Iid = new jex(this);
  iiz jdField_a_of_type_Iiz = new jew(this);
  jlp jdField_a_of_type_Jlp;
  int aqD = -1;
  Runnable bf = new VideoInviteFloatBarUICtr.4(this);
  BroadcastReceiver mBroadcastReceiver = new jev(this);
  Intent mIntent;
  
  public jeu(VideoController paramVideoController, VideoAppInterface paramVideoAppInterface, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.mIntent = paramIntent;
  }
  
  private boolean cE(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.aqx == 1)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.OG))
      {
        localObject = new Intent("tencent.video.v2q.ACTION_DEAL_INVITE_TO_ENTER_GROUP_VEDIO");
        ((Intent)localObject).putExtra("relationId", this.mGroupId + "");
        ((Intent)localObject).putExtra("dealResult", paramInt);
        ((Intent)localObject).putExtra("inviteId", this.OG);
        ((Intent)localObject).putExtra("friendUin", this.mf);
        ((Intent)localObject).setPackage(this.mApp.getApp().getPackageName());
        this.mApp.getApp().sendBroadcast((Intent)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.d("VideoInviteFloatBarUICtr", 2, "sendBroadcast, qav_gaudio_join");
        }
        if (paramInt != 1) {
          break label208;
        }
      }
    }
    label208:
    for (Object localObject = "tip_in";; localObject = "tip_no")
    {
      anot.a(null, "dc00899", "Grp_video", "", "invite", (String)localObject, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.b().ll), this.aqD + "", "", "");
      bool1 = true;
      return bool1;
    }
  }
  
  public int a(long paramLong, Intent paramIntent)
  {
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      QLog.w("VideoInviteFloatBarUICtr", 1, "onStartCommand, seq[" + paramLong + "]");
      AudioHelper.I("VideoInviteFloatBarUICtr.onStartCommand", paramIntent.getExtras());
    }
    this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
    this.mUinType = paramIntent.getIntExtra("uinType", 0);
    this.aqx = paramIntent.getIntExtra("relationType", 0);
    if (jjc.co(this.mUinType))
    {
      this.mf = paramIntent.getLongExtra("friendUin", 0L);
      this.OG = paramIntent.getStringExtra("inviteId");
      this.mGroupId = paramIntent.getLongExtra("discussId", 0L);
      this.aqD = paramIntent.getIntExtra("memberType", -1);
      this.o = paramIntent.getLongArrayExtra("memberList");
      this.mApp.addObserver(this.jdField_a_of_type_Iid);
      paramIntent = igv.a(this.aqx, String.valueOf(this.mGroupId), new int[0]);
      if (igv.a().ci(paramIntent))
      {
        this.e = igv.a().c(paramIntent);
        return 2;
      }
      this.e = igv.a().a();
      return 2;
    }
    this.mPeerUin = paramIntent.getStringExtra("peerUin");
    this.OD = paramIntent.getStringExtra("extraUin");
    this.VL = paramIntent.getBooleanExtra("isAudioMode", false);
    this.VD = paramIntent.getBooleanExtra("shutCamera", false);
    this.Td = paramIntent.getBooleanExtra("isDoubleVideoMeeting", false);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onStartCommand  mIsAudioMode = " + this.VL + ", isDoubleVideoMeeting = " + this.Td);
    }
    if (TextUtils.isEmpty(this.mPeerUin))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoInviteFloatBarUICtr", 2, "mPeerUin is empty!");
      }
      onDestroy();
    }
    while (this.Td)
    {
      paramIntent = igv.a(100, this.mPeerUin, new int[0]);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "sessionId : " + paramIntent);
      }
      this.e = igv.a().c(paramIntent);
      this.e.e(paramLong, "onStartCommand.1", 4);
      this.e.S("onStartCommand", true);
      this.e.Ra = true;
      this.e.PT = true;
      this.e.isFriend = this.mApp.isFriend(this.mPeerUin);
      this.mApp.addObserver(this.jdField_a_of_type_Iid);
      return 2;
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteFloatBarUICtr", 2, "mPeerUin : " + this.mPeerUin);
      }
    }
    paramIntent = igv.a(3, this.mPeerUin, new int[0]);
    this.e = igv.a().c(paramIntent);
    if (this.VL)
    {
      this.e.e(paramLong, "onStartCommand.2", 1);
      this.e.n(paramLong, false);
    }
    for (;;)
    {
      this.e.PT = true;
      this.e.isFriend = this.mApp.isFriend(this.mPeerUin);
      this.mApp.addObserver(this.jdField_a_of_type_Iiz);
      return 2;
      this.e.e(paramLong, "onStartCommand.3", 2);
      paramIntent = this.e;
      if (!this.VD) {
        bool = true;
      }
      paramIntent.n(paramLong, bool);
    }
  }
  
  void asc()
  {
    dR(-1039L);
  }
  
  public void dP(long paramLong)
  {
    if (!wM())
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 1");
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest return 2");
      return;
    }
    QLog.w("VideoInviteFloatBarUICtr", 1, "acceptVideoRequest, seq[" + paramLong + "], mIsDoubleVideoMeeting[" + this.Td + "]");
    int j = 1;
    if (this.e.QE) {
      j = 0;
    }
    int i = 1;
    if (!this.e.isFriend) {
      i = 4;
    }
    if (1008 == this.e.uinType) {
      i = 4;
    }
    for (;;)
    {
      if (this.Td) {
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, 3, Long.valueOf(this.e.peerUin).longValue(), null, false);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Jet != null) {
          this.jdField_a_of_type_Jet.setMessage(acfp.m(2131716402));
        }
        if (!this.e.QE) {
          break;
        }
        anot.a(null, "CliOper", "", "", "0X8008B24", "0X8008B24", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.e.peerUin, j, i);
      }
      anot.a(null, "CliOper", "", "", "0X8008B27", "0X8008B27", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void dQ(long paramLong)
  {
    QLog.w("VideoInviteFloatBarUICtr", 1, "refuseVideoRequest, seq[" + paramLong + "]");
    if (this.e.QE) {
      anot.a(null, "CliOper", "", "", "0X8008B25", "0X8008B25", 0, 0, "", "", "", "");
    }
    while (this.Td)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.mPeerUin, 1, true);
      long l = jji.B(this.mPeerUin);
      this.jdField_a_of_type_ComTencentAvVideoController.c(paramLong, 3, l);
      this.jdField_a_of_type_ComTencentAvVideoController.f(paramLong, l, 1);
      onDestroy();
      return;
      anot.a(null, "CliOper", "", "", "0X8008B28", "0X8008B28", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.mPeerUin, 1, false);
    this.jdField_a_of_type_ComTencentAvVideoController.O(this.mPeerUin, 252);
    this.jdField_a_of_type_ComTencentAvVideoController.ko(252);
    this.jdField_a_of_type_ComTencentAvVideoController.P(this.mPeerUin, 1);
  }
  
  public void dR(long paramLong)
  {
    QLog.w("VideoInviteFloatBarUICtr", 1, "ignoreGAInvite, seq[" + paramLong + "]");
    anot.a(null, "CliOper", "", "", "0X8008B2C", "0X8008B2C", 0, 0, "", "", "", "");
    if (!cE(0)) {
      this.jdField_a_of_type_ComTencentAvVideoController.c(paramLong, this.aqx, this.mGroupId);
    }
    onDestroy();
  }
  
  public void dS(long paramLong)
  {
    QLog.w("VideoInviteFloatBarUICtr", 1, "acceptGAudioChat, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_Jet != null) {
      this.jdField_a_of_type_Jet.setMessage(acfp.m(2131716403));
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, this.aqx, this.e.ll, this.o, false);
    anot.a(null, "CliOper", "", "", "0X8008B2B", "0X8008B2B", 0, 0, "", "", "", "");
    asb();
  }
  
  void jw(boolean paramBoolean)
  {
    super.jw(paramBoolean);
    this.jdField_a_of_type_ComTencentAvVideoController.alx();
  }
  
  public void onCreate()
  {
    QLog.d("VideoInviteFloatBarUICtr", 1, "onCreate start");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
    localIntentFilter.addAction("tencent.video.invite.accept");
    localIntentFilter.addAction("tencent.video.invite.refuse");
    localIntentFilter.addAction("tencent.video.invite.gaaccept");
    localIntentFilter.addAction("tencent.video.invite.gaignore");
    localIntentFilter.addAction("tencent.video.q2v.sdk.onRequestVideo");
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
        QLog.d("VideoInviteFloatBarUICtr", 1, "onDestroy error : " + localException);
      }
    }
  }
  
  protected boolean wM()
  {
    if (this.jdField_a_of_type_Jlp == null) {
      this.jdField_a_of_type_Jlp = new jlp(this.mApp.getApplication().getApplicationContext(), 1, "video wifi lock");
    }
    if ((jkg.isWifiEnv(this.mApp.getApplication().getApplicationContext())) && (this.jdField_a_of_type_Jlp != null)) {
      this.jdField_a_of_type_Jlp.xS();
    }
    return true;
  }
  
  protected boolean wO()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mVideoController = null, return !");
      return false;
    }
    if (this.mPeerUin == null)
    {
      QLog.d("VideoInviteFloatBarUICtr", 1, "VideoInviteFloatBarUICtr_quaReport mPeerUin = null, return !");
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvVideoController.co(this.mPeerUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jeu
 * JD-Core Version:    0.7.0.1
 */