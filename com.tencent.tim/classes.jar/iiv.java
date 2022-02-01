import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.av.VideoConstants.EmShareState;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.qav_gvideo_sdk_transfer.gVideoDownChannelControl;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class iiv
  extends iiw
{
  public static int ant;
  public static int beautyLevel = -1;
  public HashSet<Integer> D = new HashSet(8);
  public String MN;
  public String MO;
  public String MP;
  public String MQ;
  public String MR;
  public String MS;
  public String MT;
  public String MU;
  public String MV = "";
  public String MW;
  public String MX;
  public String MY;
  public String MZ = "";
  public String Na;
  public boolean PQ;
  public boolean PR;
  public boolean PS;
  public boolean PT;
  public boolean PU;
  public boolean PV;
  public boolean PW;
  public boolean PX = true;
  public boolean PY;
  public boolean PZ;
  public boolean QA;
  public boolean QB;
  public boolean QC;
  public boolean QD;
  public boolean QE;
  public boolean QF;
  public boolean QG;
  public boolean QH;
  public boolean QI;
  @Deprecated
  public boolean QJ;
  @Deprecated
  public boolean QK;
  @Deprecated
  public boolean QL;
  @Deprecated
  public boolean QM;
  @Deprecated
  public boolean QN;
  public boolean QO;
  public boolean QP;
  public volatile boolean QQ;
  public boolean QR;
  public boolean QS;
  public boolean QT = true;
  public boolean QU;
  public boolean QV;
  public boolean QW;
  public boolean QX;
  public boolean QY;
  public boolean QZ;
  public boolean Qa;
  public boolean Qb;
  public boolean Qc = true;
  public boolean Qd = true;
  public boolean Qe;
  public boolean Qf = true;
  public boolean Qg;
  public boolean Qh;
  public boolean Qi;
  public boolean Qj;
  public boolean Qk;
  public boolean Ql;
  public boolean Qm;
  public boolean Qn;
  public boolean Qo;
  public boolean Qp;
  public boolean Qq;
  public boolean Qr;
  public boolean Qs;
  public boolean Qt = true;
  public boolean Qu;
  public boolean Qv;
  public boolean Qw;
  public boolean Qx;
  public boolean Qy;
  public boolean Qz;
  public boolean Ra;
  public boolean Rb;
  public boolean Rc;
  public boolean Rd;
  public boolean Re;
  public boolean Rf;
  public boolean Rg;
  public boolean Rh = true;
  public boolean Ri;
  private boolean Rj;
  public boolean Rk;
  public boolean Rl;
  public boolean Rm = true;
  public boolean Rn;
  public boolean Ro;
  public boolean Rp;
  public boolean Rq;
  public boolean Rr;
  public final String TAG = "SessionInfo_" + AudioHelper.hG();
  public int YN = 0;
  public VideoConstants.EmShareState a;
  public PtvTemplateManager.PtvTemplateInfo a;
  iil jdField_a_of_type_Iil = new iil();
  private iiu jdField_a_of_type_Iiu;
  public iiv.a a;
  public iiv.b a;
  private final ConcurrentHashMap<Long, Boolean> aA = new ConcurrentHashMap();
  public String[] aK;
  public String actId;
  public int amH = 0;
  public int amI = 0;
  public int amJ = 15000;
  public int amK = 0;
  public int amL = 0;
  public int amM = -1;
  private int amN = 0;
  public int amO = 3;
  public int amP;
  public int amQ;
  public int amR = -1;
  public int amS;
  public int amT;
  public int amU = 0;
  public int amV;
  public int amW;
  public int amX = 0;
  public int amY;
  public int amZ;
  public int ama;
  public int ana = -1;
  public int anb = 0;
  public int anc = -1;
  public int and = 0;
  public int ane = 2;
  public int anf = 0;
  @Deprecated
  public int ang = -1;
  public int anh = 7;
  public int ani = 1;
  public int anj;
  public int ank;
  public int anl = -1;
  public int anm;
  public int ann;
  public int ano = 1;
  public int anp = 0;
  public int anq = -1;
  public int anr = -1;
  public int ans = -1;
  public int anu = -1;
  public int anv = -1;
  public int anw = -1;
  private int anx = 0;
  public int any = 0;
  public int anz = 0;
  public int audioStreamType;
  public BitSet b = new BitSet();
  public int bindType;
  private WeakReference<jfk> bj;
  public long colorRingId;
  public String deviceName;
  public int extraType;
  public long[] f;
  public ArrayList<Long> id = new ArrayList();
  public ArrayList<String> ie = new ArrayList();
  public volatile ArrayList<ioa> jdField_if = new ArrayList();
  public ArrayList<ioa> ig = new ArrayList();
  public ArrayList<ioa> ih = new ArrayList();
  public ArrayList<AVPhoneUserInfo> ii = new ArrayList();
  public boolean isBackground;
  public boolean isFriend;
  public boolean isFrontCamera = true;
  public boolean isGameRoom;
  public boolean isRecording;
  public long lg;
  public long lh = -1L;
  public long li = 0L;
  public long lj;
  public long lk;
  public long ll;
  public long lm;
  public long ln;
  public long lo;
  public long lp;
  public String mAudioStateBeforePhoneCall = "DEVICE_NONE";
  public int mShareType = 0;
  public int netType = 1;
  public String peerUin;
  public String phoneNum;
  public int relationType = 0;
  public String senderUin;
  public String sessionId;
  public byte[] signature;
  public int state = 0;
  public int switchState = 0;
  public int uinType = -1;
  public int vipType;
  
  public iiv()
  {
    this.jdField_a_of_type_Iiv$a = new iiv.a();
    this.jdField_a_of_type_Iiv$b = new iiv.b();
    this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState = VideoConstants.EmShareState.NONE;
    QLog.w(this.TAG, 1, "createSession");
  }
  
  private boolean a(ioa paramioa)
  {
    Iterator localIterator = this.ig.iterator();
    while (localIterator.hasNext())
    {
      ioa localioa = (ioa)localIterator.next();
      if ((paramioa.videoSrcType == localioa.videoSrcType) && (paramioa.uin == localioa.uin)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean tk()
  {
    return true;
  }
  
  public void C(long paramLong1, long paramLong2)
  {
    QLog.w(this.TAG, 1, "setConnectedTime, connectedTime[" + this.lj + "->" + paramLong2 + "], seq[" + paramLong1 + "]");
    this.lj = paramLong2;
  }
  
  public void O(String paramString, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.PV != paramBoolean)) {
      QLog.w(this.TAG, 1, "setLocalMuteStatus, from[" + paramString + "], mute[" + paramBoolean + "]");
    }
    this.PV = paramBoolean;
  }
  
  public void P(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.aCz()) || (paramBoolean != this.QB)) {
      QLog.w(this.TAG, 1, "setSpeakerOn, from[" + paramString + "], isSpeakerOn[" + this.QB + "->" + paramBoolean + "]");
    }
    this.QB = paramBoolean;
  }
  
  public void Q(String paramString, boolean paramBoolean)
  {
    if ((AudioHelper.aCz()) || (paramBoolean != this.QI)) {
      QLog.w(this.TAG, 1, "setRoomMicOff[" + paramString + "], isRoomMicOff[" + this.QI + "->" + paramBoolean + "]");
    }
    this.QI = paramBoolean;
  }
  
  public void R(String paramString, boolean paramBoolean)
  {
    if ((this.Qx != paramBoolean) || (QLog.isColorLevel())) {
      QLog.i(this.TAG, 1, "updateInMeetingRoom, from[" + paramString + "], [" + this.Qx + "-->" + paramBoolean + "]");
    }
    if (this.Qx != paramBoolean) {
      this.Qx = paramBoolean;
    }
  }
  
  public void S(String paramString, boolean paramBoolean)
  {
    if ((this.Qw != paramBoolean) || (QLog.isColorLevel())) {
      QLog.i(this.TAG, 1, "updateDoubleMeeting, from[" + paramString + "], [" + this.Qw + "-->" + paramBoolean + "]");
    }
    if (this.Qw != paramBoolean) {
      this.Qw = paramBoolean;
    }
  }
  
  public void T(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("normal_2_meeting", 2, "setSwitch2DoubleMeeting, from[" + paramString + "], [" + this.Rq + "-->" + paramBoolean + "]");
    }
    this.Rq = paramBoolean;
  }
  
  public void Y(String paramString, int paramInt)
  {
    if ((this.state != paramInt) || (QLog.isColorLevel())) {
      QLog.w(this.TAG, 1, "setState[" + paramString + "], state[" + this.state + "->" + paramInt + "]");
    }
    if (this.state != paramInt)
    {
      ird.bJ(this.state, paramInt);
      this.state = paramInt;
    }
  }
  
  public void Z(String paramString, int paramInt)
  {
    if ((QLog.isDevelopLevel()) || (this.amN != paramInt)) {
      QLog.w(this.TAG, 1, "setSpeakerMode, from[" + paramString + "], mode[" + paramInt + "]");
    }
    this.amN = paramInt;
  }
  
  public iiu a()
  {
    if (this.jdField_a_of_type_Iiu == null) {}
    try
    {
      if (this.jdField_a_of_type_Iiu == null) {
        this.jdField_a_of_type_Iiu = new iiu();
      }
      return this.jdField_a_of_type_Iiu;
    }
    finally {}
  }
  
  public void a(int paramInt, ioa paramioa)
  {
    long l = paramioa.uin;
    int i = paramioa.videoSrcType;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addVideoViewInfo-->Uin = " + l + " ,VideoSrcType = " + i + " ,Pos = " + paramInt);
    }
    int j = b(l, i);
    if ((j != -1) && (QLog.isColorLevel())) {
      QLog.e(this.TAG, 2, "addVideoViewInfo Error,The View Info Is Exsit.Uin = " + l + " ,VideoSrcType = " + i + " ,Index = " + j);
    }
    this.jdField_if.add(paramInt, paramioa);
    synchronized (this.ig)
    {
      if (!a(paramioa))
      {
        this.ig.add(paramInt, paramioa);
        amI();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "addVideoViewInfo mMultiVideoTalkList-->Uin = " + l + " ,VideoSrcType = " + i + " ,Pos = " + paramInt);
        }
      }
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "setVideoState[" + paramString + "], startOrStopVideo[" + paramBoolean1 + "], isRemote[" + paramBoolean2 + "], seq[" + paramLong + "]");
    }
    if (paramBoolean1) {
      if (paramBoolean2)
      {
        o(paramLong, true);
        if (this.amI != 1) {
          break label115;
        }
        e(paramLong, "setVideoState.1", 2);
      }
    }
    label115:
    do
    {
      do
      {
        return;
        n(paramLong, true);
        break;
      } while (this.amI != 3);
      e(paramLong, "setVideoState.2", 4);
      return;
      if (paramBoolean2) {
        o(paramLong, false);
      }
      while ((this.amI == 2) && (!this.PZ) && (!this.PY) && (!this.Qa))
      {
        e(paramLong, "setVideoState.3", 1);
        return;
        n(paramLong, false);
      }
    } while ((this.amI != 4) || (this.PZ) || (this.PY) || (this.Qa));
    e(paramLong, "setVideoState.4", 3);
  }
  
  public void a(AVPhoneUserInfo paramAVPhoneUserInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "onPhoneUserInfoInRoom info = " + paramAVPhoneUserInfo.toString());
    }
    this.ii.add(paramAVPhoneUserInfo);
  }
  
  public void a(ioa paramioa)
  {
    long l = paramioa.uin;
    int i = paramioa.videoSrcType;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "addVideoViewInfo-->Uin = " + l + " ,VideoSrcType = " + i);
    }
    int j = b(l, i);
    if ((j != -1) && (QLog.isColorLevel())) {
      QLog.e(this.TAG, 2, "addVideoViewInfo Error,The View Info Is Exsit.Uin = " + l + " ,VideoSrcType = " + i + " ,Index = " + j);
    }
    this.jdField_if.add(paramioa);
    synchronized (this.ig)
    {
      if (!a(paramioa))
      {
        this.ig.add(paramioa);
        amI();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "addVideoViewInfo mMultiVideoTalkList-->Uin = " + l + " ,VideoSrcType = " + i + " ,Pos = ");
        }
      }
      return;
    }
  }
  
  public void a(String paramString, VideoConstants.EmShareState paramEmShareState, int paramInt)
  {
    if (((this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState != paramEmShareState) || (this.mShareType != paramInt)) && (QLog.isColorLevel())) {
      QLog.i("AVShare", 2, "updateShareInfo, state[" + this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState + "-->" + paramEmShareState + "], type[" + this.mShareType + "-->" + paramInt + "], from[" + paramString + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState != paramEmShareState) {
      this.jdField_a_of_type_ComTencentAvVideoConstants$EmShareState = paramEmShareState;
    }
    if (this.mShareType != paramInt) {
      this.mShareType = paramInt;
    }
  }
  
  public void a(jfk paramjfk)
  {
    if ((this.bj != null) && (this.bj.get() != null) && (this.bj.get() == paramjfk)) {
      return;
    }
    this.bj = new WeakReference(paramjfk);
  }
  
  public boolean a(VideoController paramVideoController)
  {
    boolean bool = true;
    if ((this.anw == -1) && (paramVideoController != null)) {
      this.anw = paramVideoController.a(this, this.peerUin);
    }
    if ((this.anv == -1) && (paramVideoController != null)) {
      this.anv = paramVideoController.b(this, this.peerUin);
    }
    if (this.anw == 2) {
      if (this.anv < 100) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "isPeerSupportDMeetingSwitchTroop, end[" + this.anw + "," + this.anv + "," + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      if (this.anw == 4)
      {
        if (this.anv < 101) {
          bool = false;
        }
      }
      else if (this.anw == 5)
      {
        if (this.anv < 5635) {
          bool = false;
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface)
  {
    int i;
    if ((this.anx == 0) && (paramVideoAppInterface != null))
    {
      i = this.uinType;
      if (i != -1) {
        break label210;
      }
      i = jll.cM(this.relationType);
    }
    label67:
    label204:
    label210:
    for (;;)
    {
      String str;
      if (i == 0) {
        str = this.peerUin;
      }
      for (;;)
      {
        boolean bool;
        int j;
        if (i != -1)
        {
          bool = acqh.b(paramVideoAppInterface.getApp(), paramVideoAppInterface.getAccount(), str, i);
          if (bool)
          {
            j = 2;
            this.anx = j;
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "isVideoMsgBlocked ret[" + bool + "], uin[" + str + "], type[" + i + "], flag[" + this.anx + "]");
          }
          if (this.anx == 1)
          {
            return true;
            if (i == 1)
            {
              str = String.valueOf(this.ll);
              break;
            }
            if (i != -1) {
              break label204;
            }
            str = String.valueOf(this.ll);
            break;
            j = 1;
            break label67;
          }
          return false;
          bool = true;
        }
        str = null;
      }
    }
  }
  
  public void aP(String paramString1, String paramString2)
  {
    if ((!TextUtils.equals(this.sessionId, this.sessionId)) || (QLog.isColorLevel())) {
      QLog.i(this.TAG, 1, "setSessionId, [" + this.sessionId + "," + paramString2 + "], from[" + paramString1 + "]");
    }
    this.sessionId = paramString2;
  }
  
  public void aQ(String paramString1, String paramString2)
  {
    if ((AudioHelper.aCz()) || (!TextUtils.equals(paramString2, this.deviceName))) {
      QLog.w(this.TAG, 1, "setDeviceName, from[" + paramString1 + "], deviceName[" + this.deviceName + "->" + paramString2 + "]");
    }
    this.deviceName = paramString2;
  }
  
  public void aa(String paramString, int paramInt)
  {
    boolean bool2 = true;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1) {}
    }
    else
    {
      bool1 = bool2;
      if (this.anc == 2) {
        switch (this.state)
        {
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((QLog.isColorLevel()) || (this.anc != paramInt)) {
        QLog.i(this.TAG, 2, "setGAudioStatusType, from[" + paramString + "], isNeedUpdate[" + bool1 + "], state[" + this.state + "], cur[" + this.anc + "], come[" + paramInt + "]");
      }
      if (bool1) {
        this.anc = paramInt;
      }
      return;
    }
  }
  
  public void ac(String paramString, int paramInt)
  {
    QLog.w(this.TAG, 1, "setSwitchToGAudioMode[" + paramString + "], switchToGAudioMode[" + this.and + "->" + paramInt + "]");
    this.and = paramInt;
  }
  
  public void ad(String paramString, int paramInt)
  {
    if ((AudioHelper.aCz()) || (paramInt != this.ane)) {
      QLog.w(this.TAG, 1, "setMicAuthByAdmin[" + paramString + "], micAuthByAdmin[" + this.ane + "->" + paramInt + "]");
    }
    this.ane = paramInt;
  }
  
  public void amG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoController", 2, "clearRandomSessionInfo sessionId = " + this.sessionId);
    }
    this.jdField_a_of_type_Iiv$a.Rt = false;
    this.jdField_a_of_type_Iiv$a.peerUin = null;
    this.jdField_a_of_type_Iiv$a.headUrl = null;
    this.jdField_a_of_type_Iiv$a.nickName = null;
    this.jdField_a_of_type_Iiv$a.ba = null;
    this.jdField_a_of_type_Iiv$a.Ru = false;
    this.jdField_a_of_type_Iiv$a.Rw = false;
    this.jdField_a_of_type_Iiv$a.anA = 0;
    this.jdField_a_of_type_Iiv$a.bb = null;
    this.jdField_a_of_type_Iiv$a.bc = null;
    this.jdField_a_of_type_Iiv$a.Rv = false;
    this.jdField_a_of_type_Iiv$a.Rx = false;
    this.jdField_a_of_type_Iiv$a.Nc = null;
    this.jdField_a_of_type_Iiv$a.anB = -1;
  }
  
  public void amH()
  {
    this.jdField_a_of_type_Iiv$b = new iiv.b();
  }
  
  public void amI()
  {
    if ((this.bj != null) && (this.bj.get() != null)) {
      ((jfk)this.bj.get()).avE();
    }
  }
  
  public int b(long paramLong, int paramInt)
  {
    int i;
    if (paramInt != 0)
    {
      i = 0;
      while (i < this.jdField_if.size())
      {
        if ((((ioa)this.jdField_if.get(i)).uin == paramLong) && (((ioa)this.jdField_if.get(i)).videoSrcType == paramInt)) {
          return i;
        }
        i += 1;
      }
    }
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= this.jdField_if.size()) {
        break label112;
      }
      i = paramInt;
      if (((ioa)this.jdField_if.get(paramInt)).uin == paramLong) {
        break;
      }
      paramInt += 1;
    }
    label112:
    return -1;
  }
  
  public AVPhoneUserInfo b(long paramLong, ArrayList<AVPhoneUserInfo> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AVPhoneUserInfo localAVPhoneUserInfo = (AVPhoneUserInfo)paramArrayList.next();
      if ((localAVPhoneUserInfo.accountType != 1) && (localAVPhoneUserInfo.account == paramLong)) {
        return localAVPhoneUserInfo;
      }
    }
    return null;
  }
  
  public void b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "resetVideoDisplayListExceptTargetUin-->Uin = " + paramLong + " ,clearRenderFlag" + paramBoolean1 + " ,clearRecvDataFlag" + paramBoolean2);
    }
    int i = 0;
    while (i < this.jdField_if.size())
    {
      if (((ioa)this.jdField_if.get(i)).uin != paramLong)
      {
        if (paramBoolean1) {
          ((ioa)this.jdField_if.get(i)).isRender = false;
        }
        if (paramBoolean2) {
          ((ioa)this.jdField_if.get(i)).Tr = false;
        }
      }
      i += 1;
    }
  }
  
  public boolean b(VideoController paramVideoController)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("double_2_multi", 2, "isPeerSupportDoubleSwitchToTroop, start[" + this.anw + "," + this.anv + "]");
    }
    if ((this.anw == -1) && (paramVideoController != null)) {
      this.anw = paramVideoController.getPeerTerminalType(this.peerUin);
    }
    if ((this.anv == -1) && (paramVideoController != null)) {
      this.anv = paramVideoController.getPeerSdkVersion(this.peerUin);
    }
    if (this.anw == 2) {
      if (this.anv < 100) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("double_2_multi", 2, "isPeerSupportDoubleSwitchToTroop, end[" + this.anw + "," + this.anv + "," + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      if (this.anw == 4)
      {
        if (this.anv < 101) {
          bool = false;
        }
      }
      else if (this.anw == 5) {
        bool = false;
      } else {
        bool = false;
      }
    }
  }
  
  public boolean b(qav_gvideo_sdk_transfer.gVideoDownChannelControl paramgVideoDownChannelControl)
  {
    if (this.jdField_a_of_type_Iil != null) {
      return this.jdField_a_of_type_Iil.a(paramgVideoDownChannelControl);
    }
    return false;
  }
  
  void bM(long paramLong)
  {
    C(paramLong, 0L);
    this.lp = 0L;
    Y("clearSessionInfo", 0);
    this.uinType = -1;
    this.PV = false;
    this.PW = false;
    e(paramLong, "clearSessionInfo", 0);
    this.YN = 0;
    this.anp = 0;
    this.Rl = false;
    this.Rm = true;
    hX(false);
    this.jdField_a_of_type_Iil.Clear();
    this.li = 0L;
    this.senderUin = null;
    this.PU = false;
    this.Qi = false;
    this.Ql = false;
    this.Qm = false;
    this.Qn = false;
    this.Rn = false;
    this.ana = -1;
    this.Rh = true;
    this.MZ = "";
    this.lo = 0L;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo = null;
    this.b.clear();
    n(paramLong, false);
    o(paramLong, false);
    this.ani = 1;
    this.relationType = 0;
    this.ans = -1;
    this.Qo = false;
    this.bj = null;
    this.amX = 0;
    this.aA.clear();
    try
    {
      this.jdField_a_of_type_Iiu = null;
      a("clearSessionInfo", VideoConstants.EmShareState.NONE, 0);
      return;
    }
    finally {}
  }
  
  public void bN(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.TAG, 1, "clearDoubleVideoSessionInfo, sessionId[" + this.sessionId + "], seq[" + paramLong + "]");
    }
    bM(paramLong);
    amH();
  }
  
  public void bO(long paramLong)
  {
    bM(paramLong);
    Q("clearMultiVideoSessionInfo", false);
    this.lm = 0L;
    this.ang = -1;
    this.QJ = false;
    this.QK = false;
    this.QL = false;
    this.QM = false;
    this.QN = false;
    this.QO = false;
    this.jdField_if.clear();
    synchronized (this.ig)
    {
      this.ig.clear();
      amI();
      this.bj = null;
      this.ih.clear();
      kD(0);
      return;
    }
  }
  
  public void bs(int paramInt1, int paramInt2)
  {
    if ((this.switchState != paramInt2) || (QLog.isColorLevel())) {
      QLog.w(this.TAG, 1, "setSwitchState[" + paramInt1 + "], state[" + this.switchState + "->" + paramInt2 + "]");
    }
    this.switchState = paramInt2;
  }
  
  public long bz()
  {
    long l1 = 0L;
    long l2;
    if ((this.Qw) || (this.relationType == 100))
    {
      l2 = this.ll;
      l1 = l2;
      if (l2 != 0L) {}
    }
    else
    {
      do
      {
        do
        {
          try
          {
            l1 = Long.parseLong(this.peerUin);
            return l1;
          }
          catch (Throwable localThrowable1)
          {
            if (QLog.isDevelopLevel()) {
              QLog.i(this.TAG, 4, "getChatRoomUin", localThrowable1);
            }
            return l2;
          }
          if ((this.amI != 1) && (this.amI != 2) && (this.relationType != 3)) {
            break;
          }
          try
          {
            l2 = Long.parseLong(this.peerUin);
            return l2;
          }
          catch (Throwable localThrowable2) {}
        } while (!QLog.isDevelopLevel());
        QLog.i(this.TAG, 4, "getChatRoomUin", localThrowable2);
        return 0L;
      } while ((this.amI != 3) && (this.amI != 4) && (this.relationType != 1) && (this.relationType != 2));
      l2 = this.ll;
      l1 = l2;
      if (l2 == 0L) {
        try
        {
          l1 = Long.parseLong(this.MP);
          return l1;
        }
        catch (Throwable localThrowable3)
        {
          l1 = l2;
          if (QLog.isDevelopLevel())
          {
            QLog.i(this.TAG, 4, "getChatRoomUin", localThrowable3);
            l1 = l2;
          }
        }
      }
    }
    return l1;
  }
  
  public int c(long paramLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    ArrayList localArrayList = this.ig;
    if (paramInt != 0) {
      i = j;
    }
    for (;;)
    {
      try
      {
        if (i < this.ig.size())
        {
          if ((((ioa)this.ig.get(i)).uin != paramLong) || (((ioa)this.ig.get(i)).videoSrcType != paramInt)) {
            break label131;
          }
          return i;
          if (i < this.ig.size())
          {
            if (((ioa)this.ig.get(i)).uin != paramLong) {
              break label140;
            }
            return i;
          }
        }
        return -1;
      }
      finally {}
      label131:
      i += 1;
      continue;
      label140:
      i += 1;
    }
  }
  
  public void c(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.aA.put(Long.valueOf(paramLong), Boolean.valueOf(paramBoolean1));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean cr(String paramString)
  {
    boolean bool2 = false;
    bool1 = bool2;
    try
    {
      l = jjc.A(paramString);
      bool1 = bool2;
      paramString = this.aA.entrySet().iterator();
      Map.Entry localEntry;
      do
      {
        do
        {
          do
          {
            do
            {
              bool1 = bool2;
              if (!paramString.hasNext()) {
                break;
              }
              bool1 = bool2;
              localEntry = (Map.Entry)paramString.next();
              bool1 = bool2;
            } while (localEntry.getValue() == null);
            bool1 = bool2;
          } while (!((Boolean)localEntry.getValue()).booleanValue());
          bool1 = bool2;
        } while (localEntry.getKey() == null);
        bool1 = bool2;
      } while (((Long)localEntry.getKey()).longValue() == l);
      bool1 = true;
      l = ((Long)localEntry.getKey()).longValue();
      bool1 = true;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        long l = 0L;
        continue;
        l = 0L;
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "isOtherUserShareScreenNow, [" + l + "," + bool1 + "]");
    }
    return bool1;
  }
  
  public boolean d(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Iil == null) {
      return tk();
    }
    return this.jdField_a_of_type_Iil.c(paramLong, paramInt);
  }
  
  public void e(long paramLong, String paramString, int paramInt)
  {
    if ((this.amI != paramInt) || (QLog.isColorLevel())) {
      QLog.w(this.TAG, 1, "setSessionType[" + paramString + "], SessionType[" + this.amI + "->" + paramInt + "], seq[" + paramLong + "]");
    }
    this.amI = paramInt;
  }
  
  public boolean e(long paramLong, int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_if.size())
      {
        if ((((ioa)this.jdField_if.get(i)).uin == paramLong) && (((ioa)this.jdField_if.get(i)).videoSrcType == paramInt)) {
          bool1 = ((ioa)this.jdField_if.get(i)).Tr;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String gK()
  {
    return this.phoneNum;
  }
  
  public void hX(boolean paramBoolean)
  {
    QLog.w(this.TAG, 1, "setHasChangeDoubleScreen, hasChangeDoubleScreen[" + this.QG + "->" + paramBoolean + "]");
    this.QG = paramBoolean;
  }
  
  public void hY(boolean paramBoolean)
  {
    this.Rj = paramBoolean;
  }
  
  public boolean isConnected()
  {
    return this.state == 4;
  }
  
  public boolean isConnecting()
  {
    return this.state == 3;
  }
  
  public boolean isVideo()
  {
    return (this.amI == 2) || (this.amI == 4);
  }
  
  public void kD(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "SessionInfo setAvType:" + paramInt);
    }
    this.anb = paramInt;
    ant = paramInt;
  }
  
  public void kE(int paramInt)
  {
    QLog.i(this.TAG, 1, "setPeerSdkVersion [" + paramInt + "]");
    this.anv = paramInt;
  }
  
  public void kF(int paramInt)
  {
    QLog.i(this.TAG, 1, "setPeerTerminalType [" + paramInt + "]");
    this.anw = paramInt;
  }
  
  public int kJ()
  {
    return this.amN;
  }
  
  public int kK()
  {
    int i = 0;
    while (i < this.jdField_if.size())
    {
      if (((ioa)this.jdField_if.get(i)).isRender) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public int kL()
  {
    return this.anv;
  }
  
  public int kM()
  {
    return this.anw;
  }
  
  public int kN()
  {
    int i = 0;
    if ((this.Qw) || (this.relationType == 100)) {
      i = 1;
    }
    do
    {
      return i;
      if ((this.amI == 1) || (this.amI == 2) || (this.relationType == 3)) {
        return 2;
      }
    } while ((this.amI != 3) && (this.amI != 4) && (this.relationType != 1) && (this.relationType != 2));
    return 1;
  }
  
  public void n(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.PY != paramBoolean))
    {
      QLog.w(this.TAG, 1, "setLocalHasVideo, localHasVideo[" + this.PY + "->" + paramBoolean + "], seq[" + paramLong + "]");
      if (!paramBoolean) {
        QLog.w(this.TAG, 1, "why call not local hasVideo, str[1], isVisible[]", new Throwable("打印调用栈"));
      }
    }
    this.PY = paramBoolean;
    if (this.PY)
    {
      iow.va();
      if (VideoController.a().a() != null) {
        iop.h(VideoController.a().a());
      }
    }
    if ((this.PZ) && (this.PY))
    {
      irk.a().resume(1);
      return;
    }
    irk.a().pause(1);
  }
  
  public void o(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.PZ != paramBoolean)) {
      QLog.w(this.TAG, 1, "setRemoteHasVideo, remoteHasVideo[" + this.PZ + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.PZ = paramBoolean;
    if ((this.PZ) && (this.PY))
    {
      irk.a().resume(1);
      return;
    }
    irk.a().pause(1);
  }
  
  public void p(long paramLong, boolean paramBoolean)
  {
    if ((QLog.isDevelopLevel()) || (this.Qa != paramBoolean)) {
      QLog.w(this.TAG, 1, "setRemoteHasVideo, remoteHasVideo[" + this.Qa + "->" + paramBoolean + "], seq[" + paramLong + "]");
    }
    this.Qa = paramBoolean;
  }
  
  public boolean sT()
  {
    return (sU()) || (this.Rq);
  }
  
  public boolean sU()
  {
    return this.and != 0;
  }
  
  public boolean sV()
  {
    return this.and == 2;
  }
  
  public boolean sW()
  {
    return this.relationType == 2;
  }
  
  public boolean sX()
  {
    return this.Rj;
  }
  
  public boolean sY()
  {
    return (this.state == 0) && (this.jdField_a_of_type_Iiv$a.anA <= 0);
  }
  
  public boolean sZ()
  {
    return (this.state == 0) && ((this.jdField_a_of_type_Iiv$a.anA == 1) || (this.jdField_a_of_type_Iiv$a.anA == 2));
  }
  
  public void setPhoneNum(String paramString)
  {
    this.phoneNum = paramString;
    if (QLog.isDevelopLevel()) {
      QLog.i(this.TAG, 4, "setPhoneNum, phoneNum[" + paramString + "]");
    }
  }
  
  public boolean ta()
  {
    return this.state == 1;
  }
  
  public boolean tb()
  {
    return this.state == 2;
  }
  
  public boolean tc()
  {
    return (this.state == 2) || (this.state == 7);
  }
  
  public boolean td()
  {
    return this.state == 10;
  }
  
  public boolean te()
  {
    return this.state == 14;
  }
  
  public boolean tf()
  {
    return this.state == 5;
  }
  
  public boolean tg()
  {
    return this.state == 6;
  }
  
  public boolean th()
  {
    return this.state == 15;
  }
  
  public boolean ti()
  {
    return (this.amI == 3) || (this.amI == 4) || ((this.jdField_a_of_type_Iiv$a.anA > 0) && (this.jdField_a_of_type_Iiv$a.chatType == 3));
  }
  
  public boolean tj()
  {
    int i = 0;
    while (i < this.jdField_if.size())
    {
      if (((ioa)this.jdField_if.get(i)).Tr) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean tl()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_if.size())
      {
        if (((ioa)this.jdField_if.get(i)).Tp) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean tm()
  {
    if (this.anl == -1) {
      if (this.relationType != 2) {
        break label35;
      }
    }
    label35:
    for (this.anl = aqjl.ai(this.ll);; this.anl = 0) {
      return aqjl.mv(this.anl);
    }
  }
  
  public boolean tn()
  {
    return (this.amI == 1) || (this.amI == 2);
  }
  
  public boolean to()
  {
    int i = this.jdField_if.size();
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "isVideoNumReachMaxNow, size[" + i + "]");
    }
    return i >= 16;
  }
  
  public String toString()
  {
    return "[" + this.TAG + "], sessionId[" + this.sessionId + "], SessionType[" + this.amI + "], sessionStatus[" + this.amH + "], relationType[" + this.relationType + "], uinType[" + this.uinType + "], relationId[" + this.ll + "], state[" + this.state + "], switchState[" + this.switchState + "], peerUin[" + this.peerUin + "], peerName[" + this.MO + "], extraUin[" + this.MP + "], extraCode[" + this.MQ + "], multiAVType[" + this.anb + "], localHasVideo[" + this.PY + "], roomId[" + this.roomId + "], isReceiver[" + this.PT + "]";
  }
  
  public boolean tp()
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((this.relationType == 1) || (this.relationType == 2)) {}
    for (bool1 = this.QH;; bool1 = this.Qx)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "canStartScreenShare, relationType[" + this.relationType + "], isDoubleVideoMeeting[" + this.Qw + "], ret[" + bool1 + "]");
        }
        return bool1;
      } while ((this.relationType != 3) && (this.relationType != 0));
      if (!this.Qw) {
        break;
      }
    }
    if (this.state == 4) {}
    for (bool1 = bool2;; bool1 = false) {
      break;
    }
  }
  
  public int w(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_if.size())
    {
      if ((((ioa)this.jdField_if.get(i)).Tq) && (((ioa)this.jdField_if.get(i)).uin != paramLong)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public class a
  {
    public String Nb;
    public String Nc;
    public String Nd;
    public String Ne;
    public boolean Rs = true;
    public boolean Rt;
    public boolean Ru;
    public boolean Rv;
    public boolean Rw;
    public boolean Rx;
    public int anA;
    public int anB = -1;
    public int anC = -1;
    public Bitmap ba;
    public Bitmap bb;
    public Bitmap bc;
    public int chatType;
    public String headUrl;
    public boolean isMask = true;
    public String nickName;
    public String peerUin;
    
    public a() {}
  }
  
  public class b
  {
    public String Nf;
    Map<String, Object> cP = new ConcurrentHashMap();
    public int chatType = 0;
    public long groupId;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iiv
 * JD-Core Version:    0.7.0.1
 */