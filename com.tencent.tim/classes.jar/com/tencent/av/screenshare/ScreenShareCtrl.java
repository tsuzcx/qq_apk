package com.tencent.av.screenshare;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import anot;
import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoConstants.EmShareOpsRet;
import com.tencent.av.VideoConstants.EmShareState;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.QQGAudioCtrl;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.PopupDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igv;
import ihm;
import iiv;
import iot.b;
import itn;
import ito;
import itq;
import jds;
import jds.a;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class ScreenShareCtrl
{
  private DoubleMeetingInviteTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask;
  private ShareOpsTimeOutTask jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask;
  private a jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$a;
  private int atC;
  private int atD;
  private Runnable bx;
  private final itn c = new itn();
  private final VideoController e;
  
  public ScreenShareCtrl(VideoController paramVideoController)
  {
    this.e = paramVideoController;
  }
  
  private VideoConstants.EmShareOpsRet a(iiv paramiiv, VideoConstants.EmShareOps paramEmShareOps, int paramInt)
  {
    Object localObject2 = this.e.a();
    Object localObject1 = this.e.mApp;
    if ((localObject2 == null) || (localObject1 == null)) {
      localObject1 = VideoConstants.EmShareOpsRet.UNKNOWN;
    }
    label124:
    do
    {
      return localObject1;
      VideoConstants.EmShareOpsRet localEmShareOpsRet = VideoConstants.EmShareOpsRet.UNKNOWN;
      if (paramEmShareOps == VideoConstants.EmShareOps.START)
      {
        paramiiv.a("executeShareScreenOps", VideoConstants.EmShareState.REQUESTING_START, paramInt);
        if (paramEmShareOps != VideoConstants.EmShareOps.STOP) {
          break label124;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (((QQGAudioCtrl)localObject2).StartOrStopShareSend(bool, paramInt)) {
          break label154;
        }
        localObject2 = VideoConstants.EmShareOpsRet.REQUESTING_FAIL;
        if (paramEmShareOps != VideoConstants.EmShareOps.START) {
          break label130;
        }
        paramiiv.a("executeShareScreenOps", VideoConstants.EmShareState.START_FAIL, paramInt);
        return localObject2;
        if (paramEmShareOps != VideoConstants.EmShareOps.STOP) {
          break;
        }
        paramiiv.a("executeShareScreenOps", VideoConstants.EmShareState.REQUESTING_STOP, paramInt);
        break;
      }
      localObject1 = localObject2;
    } while (paramEmShareOps != VideoConstants.EmShareOps.STOP);
    label130:
    paramiiv.a("executeShareScreenOps", VideoConstants.EmShareState.STOP_FAIL, paramInt);
    return localObject2;
    label154:
    localObject2 = VideoConstants.EmShareOpsRet.SUC;
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
    {
      ((VideoAppInterface)localObject1).getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = new ShareOpsTimeOutTask(this.e, paramiiv, paramEmShareOps, paramInt);
    ((VideoAppInterface)localObject1).getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask, 30000L);
    return localObject2;
  }
  
  @TargetApi(21)
  private void a(AVActivity paramAVActivity, long paramLong)
  {
    if ((paramAVActivity == null) || (paramAVActivity.isFinishing()) || (paramAVActivity.isDestroyed())) {
      return;
    }
    int i = itq.getFriendType();
    PopupDialog.b(paramAVActivity, 230, null, itq.getTips(), 2131697810, 2131697810, null, new ito(this, paramAVActivity, paramLong));
    anot.a(null, "dc00898", "", "", "0X800B48D", "0X800B48D", i, 0, "", "", "", "");
  }
  
  private void aqF()
  {
    if (this.bx == null)
    {
      this.bx = new ScreenShareCtrl.2(this);
      if ((this.e.mApp != null) && (this.bx != null)) {
        this.e.mApp.getHandler().postDelayed(this.bx, 20000L);
      }
    }
  }
  
  public static void showTips(int paramInt)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Resources localResources = localBaseApplication.getResources();
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        QQToast.a(localBaseApplication, -1, (CharSequence)localObject, 0).show();
      }
      return;
      localObject = localResources.getString(2131698068);
      continue;
      localObject = localResources.getString(2131698067);
      continue;
      localObject = localResources.getString(2131698069);
    }
  }
  
  public VideoConstants.EmShareOpsRet a(VideoConstants.EmShareOps paramEmShareOps)
  {
    if (this.e.a() == null) {
      return VideoConstants.EmShareOpsRet.CTRL_NULL;
    }
    iiv localiiv = this.e.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "requestShareScreenOps, emShareOps[" + paramEmShareOps + "], cur[" + localiiv.a + "," + localiiv.mShareType + "]");
    }
    if ((localiiv.mShareType != 1) && (localiiv.mShareType != 0)) {
      return VideoConstants.EmShareOpsRet.INVALID_SHARE_TYPE;
    }
    VideoConstants.EmShareOpsRet localEmShareOpsRet = VideoConstants.EmShareOpsRet.UNKNOWN;
    switch (itp.cE[paramEmShareOps.ordinal()])
    {
    default: 
      return localEmShareOpsRet;
    case 1: 
      switch (itp.cD[localiiv.a.ordinal()])
      {
      default: 
        return localEmShareOpsRet;
      case 1: 
      case 2: 
        return VideoConstants.EmShareOpsRet.SUC;
      }
      return a(localiiv, paramEmShareOps, 1);
    }
    switch (itp.cD[localiiv.a.ordinal()])
    {
    default: 
      return localEmShareOpsRet;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
      return a(localiiv, paramEmShareOps, 1);
    }
    return VideoConstants.EmShareOpsRet.SUC;
  }
  
  public a a()
  {
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$a == null) {
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$a = new a(this);
    }
    return this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$a;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5)
  {
    VideoAppInterface localVideoAppInterface = this.e.mApp;
    if (localVideoAppInterface == null) {}
    for (;;)
    {
      return;
      iiv localiiv = this.e.b();
      if ((localiiv.relationType != paramInt3) || (localiiv.ll != paramLong))
      {
        QLog.i("AVShare", 1, "onShareOpsCallback, error session, session[" + localiiv + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "onShareOpsCallback, session[" + localiiv + "], [" + paramInt3 + "," + paramLong + "," + paramInt4 + "," + paramInt5 + "], actionResult[" + paramInt1 + "], shareType[" + paramInt2 + "]");
      }
      if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask != null)
      {
        localVideoAppInterface.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask);
        this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$ShareOpsTimeOutTask = null;
      }
      VideoConstants.EmShareState localEmShareState = localiiv.a;
      switch (paramInt1)
      {
      }
      while (localEmShareState != localiiv.a)
      {
        localiiv.a("onShareOpsCallback", localEmShareState, paramInt2);
        localVideoAppInterface.l(new Object[] { Integer.valueOf(519), localEmShareState, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong), Integer.valueOf(paramInt4) });
        return;
        if (localiiv.a == VideoConstants.EmShareState.REQUESTING_START)
        {
          localEmShareState = VideoConstants.EmShareState.START_SUC;
          continue;
          if (localiiv.a == VideoConstants.EmShareState.REQUESTING_START)
          {
            localEmShareState = VideoConstants.EmShareState.START_FAIL;
            continue;
            if (localiiv.a == VideoConstants.EmShareState.REQUESTING_STOP)
            {
              localEmShareState = VideoConstants.EmShareState.STOP_SUC;
              continue;
              if (localiiv.a == VideoConstants.EmShareState.REQUESTING_STOP) {
                localEmShareState = VideoConstants.EmShareState.STOP_FAIL;
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(21)
  public void a(int paramInt, long paramLong, itn paramitn)
  {
    if (paramitn == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.e.b();
        } while ((((iiv)localObject).relationType != paramInt) || (((iiv)localObject).ll != paramLong));
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onRecSharePushEncParam, param[" + paramitn + "], session[" + localObject + "]");
        }
      } while (((iiv)localObject).a != VideoConstants.EmShareState.START_SUC);
      localObject = this.e.a();
    } while (localObject == null);
    ((jds)localObject).I(paramitn.width, paramitn.height, paramitn.fps);
  }
  
  public void a(itn paramitn, int paramInt1, int paramInt2)
  {
    QQGAudioCtrl localQQGAudioCtrl = this.e.a();
    if ((localQQGAudioCtrl == null) || (paramitn == null)) {
      return;
    }
    this.c.a(paramitn);
    if (paramInt1 != 0) {
      this.atC = paramInt1;
    }
    if (paramInt2 != 0) {
      this.atD = paramInt2;
    }
    localQQGAudioCtrl.SetShareEncParam(this.c, this.atC, this.atD, 0);
  }
  
  public void b(Bitmap paramBitmap, itn paramitn)
  {
    if (paramitn == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.e.a();
    } while (localQQGAudioCtrl == null);
    if (!this.c.equals(paramitn))
    {
      this.c.a(paramitn);
      localQQGAudioCtrl.SetShareEncParam(this.c, this.atC, this.atD, 1);
    }
    localQQGAudioCtrl.SendShareFrame2Native(paramBitmap, paramitn.width, paramitn.height);
  }
  
  @TargetApi(21)
  public void b(AVActivity paramAVActivity, long paramLong)
  {
    Object localObject = null;
    int i = 2;
    if (Build.VERSION.SDK_INT < 21) {}
    for (;;)
    {
      return;
      iiv localiiv = this.e.b();
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "startOrStopScreenShare, seq[" + paramLong + "]");
      }
      if ((localiiv.a == VideoConstants.EmShareState.START_SUC) || (localiiv.a == VideoConstants.EmShareState.REQUESTING_START))
      {
        if (a(VideoConstants.EmShareOps.STOP) == VideoConstants.EmShareOpsRet.SUC)
        {
          showTips(i);
          if (paramAVActivity != null) {
            break label125;
          }
        }
        label125:
        for (paramAVActivity = localObject;; paramAVActivity = paramAVActivity.a())
        {
          if (paramAVActivity == null) {
            break label131;
          }
          paramAVActivity.stop(1);
          return;
          i = 3;
          break;
        }
      }
      else
      {
        label131:
        if (localiiv.cr(this.e.mApp.getCurrentAccountUin()))
        {
          showTips(1);
          return;
        }
        if (localiiv.to())
        {
          showTips(8);
          return;
        }
        if ((paramAVActivity != null) && ((itq.getFriendType() == 1) || (itq.getFriendType() == 2)))
        {
          a(paramAVActivity, paramLong);
          return;
        }
        if (paramAVActivity == null) {}
        for (paramAVActivity = null; paramAVActivity != null; paramAVActivity = paramAVActivity.a())
        {
          paramAVActivity.a(a());
          paramAVActivity.a(a());
          paramAVActivity.auK();
          return;
        }
      }
    }
  }
  
  public void b(iiv paramiiv)
  {
    if (paramiiv == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "startDoubleMeetingTimeOutTask, info[" + paramiiv + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) {
      this.e.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
    }
    this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = new DoubleMeetingInviteTimeOutTask(this.e, paramiiv);
    this.e.mApp.getHandler().postDelayed(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask, 15000L);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, itn paramitn)
  {
    if (paramitn == null) {}
    QQGAudioCtrl localQQGAudioCtrl;
    do
    {
      return;
      localQQGAudioCtrl = this.e.a();
    } while (localQQGAudioCtrl == null);
    if (!this.c.equals(paramitn))
    {
      this.c.a(paramitn);
      localQQGAudioCtrl.SetShareEncParam(this.c, this.atC, this.atD, 1);
    }
    localQQGAudioCtrl.SendShareFrame2Native(paramArrayOfByte, paramInt1, paramitn.width, paramitn.height, paramInt2);
  }
  
  public void c(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("normal_2_meeting", 2, "onSwitch2DoubleMeeting, seq[" + paramLong1 + "], uin[" + paramLong2 + "], avtype[" + paramInt1 + "], subType[" + paramInt2 + "]");
    }
    if (this.bx != null)
    {
      this.e.mApp.getHandler().removeCallbacks(this.bx);
      this.bx = null;
    }
    Object localObject = igv.a(100, String.valueOf(paramLong2), new int[0]);
    iiv localiiv = this.e.b();
    localObject = igv.a().c((String)localObject);
    ((iiv)localObject).QE = true;
    ((iiv)localObject).amK = 2;
    ((iiv)localObject).MP = null;
    ((iiv)localObject).PT = true;
    ((iiv)localObject).senderUin = String.valueOf(paramLong2);
    ((iiv)localObject).peerUin = localiiv.peerUin;
    ((iiv)localObject).MO = localiiv.MO;
    ((iiv)localObject).Rr = localiiv.PY;
    ((iiv)localObject).n(paramLong1, false);
    ((iiv)localObject).PV = localiiv.PV;
    ((iiv)localObject).P("onSwitch2DoubleMeeting", localiiv.QB);
    ((iiv)localObject).aQ("onSwitch2DoubleMeeting", localiiv.deviceName);
    ((iiv)localObject).Rp = true;
    if (localiiv.amI == 1)
    {
      ((iiv)localObject).e(paramLong1, "onSwitch2DoubleMeeting.1", 3);
      ((iiv)localObject).uinType = localiiv.uinType;
      ((iiv)localObject).ll = paramLong2;
      ((iiv)localObject).relationType = 3;
      ((iiv)localObject).anb = 8;
      ((iiv)localObject).S("onSwitch2DoubleMeeting", true);
      ((iiv)localObject).T("onSwitch2DoubleMeeting", true);
      ((iiv)localObject).bs(5, 17);
      ((iiv)localObject).Y("onSwitch2DoubleMeeting", 2);
      igv localigv = igv.a();
      ihm localihm = this.e.mApp.a();
      if (localihm != null) {
        localihm.kA(262);
      }
      this.e.P(localiiv.peerUin, 72);
      if ((!TextUtils.isEmpty(localiiv.sessionId)) && (localigv.ci(localiiv.sessionId)))
      {
        boolean bool = localigv.c(paramLong1, localiiv.sessionId);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double remove ret[" + bool + "]");
        }
      }
      if (this.e.b() != localObject)
      {
        localigv.cj(((iiv)localObject).sessionId);
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "onSwitch2DoubleMeeting, need double set main session. ");
        }
      }
      ((iiv)localObject).aa("onSwitch2DoubleMeeting", 1);
      if (this.e.mApp.countObservers() <= 0) {
        break label572;
      }
      this.e.mApp.l(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong1) });
    }
    for (;;)
    {
      this.e.a(((iiv)localObject).sessionId, ((iiv)localObject).amI, false, false, true);
      return;
      ((iiv)localObject).e(paramLong1, "onSwitch2DoubleMeeting.2", 4);
      break;
      label572:
      if (this.e.mApp.isBackground_Stop) {
        this.e.a(paramLong1, 3, paramLong2, new long[] { paramLong2 }, false);
      }
    }
  }
  
  public void cy(long paramLong)
  {
    iiv localiiv1 = this.e.b();
    long l2;
    int i;
    iiv localiiv2;
    try
    {
      l1 = Long.parseLong(localiiv1.peerUin);
      l2 = l1;
      if (l1 == 0L)
      {
        l2 = l1;
        if (localiiv1.ll != 0L) {
          l2 = localiiv1.ll;
        }
      }
      if (l2 == 0L)
      {
        QLog.i("normal_2_meeting", 1, "switchToDoubleMeeting relationId illegal.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        long l1 = 0L;
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, session[" + localiiv1 + "]");
      }
      igv localigv = igv.a();
      i = localiiv1.amI;
      String str1 = localiiv1.sessionId;
      String str2 = igv.a(100, String.valueOf(l2), new int[0]);
      localiiv2 = localigv.a(str2, false);
      localiiv2.n(paramLong, localiiv1.PY);
      localiiv2.PV = localiiv1.PV;
      localiiv2.Rr = localiiv1.PY;
      localiiv2.P("switchToDoubleMeeting", localiiv1.QB);
      localiiv2.aQ("switchToDoubleMeeting", localiiv1.deviceName);
      localiiv2.peerUin = localiiv1.peerUin;
      if (TextUtils.isEmpty(localiiv2.peerUin)) {
        localiiv2.peerUin = String.valueOf(l2);
      }
      localiiv2.MO = localiiv1.MO;
      localiiv2.anb = 8;
      localiiv2.Rp = true;
      localiiv2.relationType = 3;
      localiiv2.ll = l2;
      localiiv2.uinType = 0;
      localiiv2.T("switchToDoubleMeeting", true);
      localiiv2.kE(localiiv1.kL());
      localiiv2.kF(localiiv1.kM());
      localiiv2.any = 5;
      this.e.hP(true);
      this.e.O(localiiv1.peerUin, 8);
      this.e.ko(262);
      this.e.P(localiiv1.peerUin, 72);
      this.e.alv = 3;
      if (localigv.ci(str1))
      {
        boolean bool = localigv.c(paramLong, str1);
        QLog.i("AVShare", 2, "switchToDoubleMeeting, need double remove. ret[" + bool + "]");
      }
      if (localigv.a() != localiiv2) {
        localigv.cj(str2);
      }
      if (QLog.isColorLevel()) {
        QLog.i("normal_2_meeting", 2, "switchToDoubleMeeting, after close pre one. cur[" + this.e.b() + "]");
      }
      localiiv2.ana = -1;
      if (i != 1) {
        break label574;
      }
    }
    localiiv2.e(paramLong, "switchToDoubleMeeting.1", 3);
    for (;;)
    {
      localiiv2.uinType = 0;
      localiiv2.ll = l2;
      localiiv2.aa("switchToDoubleMeeting", 0);
      this.e.mApp.l(new Object[] { Integer.valueOf(174), Long.valueOf(paramLong) });
      return;
      label574:
      if (i == 2) {
        localiiv2.e(paramLong, "switchToDoubleMeeting.2", 4);
      }
    }
  }
  
  public void cz(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "removeDoubleMeetingTimeOutTask, info[" + paramLong + "]");
    }
    if ((this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask != null) && (this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask.f.ll == paramLong))
    {
      this.e.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask);
      this.jdField_a_of_type_ComTencentAvScreenshareScreenShareCtrl$DoubleMeetingInviteTimeOutTask = null;
    }
  }
  
  public void d(String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    long l = AudioHelper.hG();
    paramArrayOfByte = this.e.b();
    if (QLog.isColorLevel()) {
      QLog.w("normal_2_meeting", 2, "onSwitchMeeting, fromUin[" + paramString + "], flag[" + paramLong + "], session[" + paramArrayOfByte + "], seq[" + l + "]");
    }
    if (paramArrayOfByte.Qw) {}
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramArrayOfByte.peerUin))) {
      return;
    }
    paramArrayOfByte.T("onSwitchMeeting", true);
    paramArrayOfByte.ll = 0L;
    paramArrayOfByte.bs(6, 16);
    this.e.mApp.l(new Object[] { Integer.valueOf(174), Long.valueOf(l) });
    aqF();
  }
  
  static class DoubleMeetingInviteTimeOutTask
    implements Runnable
  {
    public final iiv f;
    private final WeakReference<VideoController> j;
    
    public DoubleMeetingInviteTimeOutTask(VideoController paramVideoController, @NotNull iiv paramiiv)
    {
      this.j = new WeakReference(paramVideoController);
      this.f = paramiiv;
    }
    
    public void run()
    {
      long l = AudioHelper.hG();
      VideoController localVideoController = (VideoController)this.j.get();
      if ((localVideoController != null) && (this.f.state == 9))
      {
        if (localVideoController.mApp.countObservers() <= 0) {
          break label82;
        }
        localVideoController.mApp.l(new Object[] { Integer.valueOf(404), Long.valueOf(l), Long.valueOf(this.f.ll) });
      }
      label82:
      while (!localVideoController.mApp.isBackground_Stop) {
        return;
      }
      localVideoController.b(l, this.f.ll, true, 0);
    }
  }
  
  static class ShareOpsTimeOutTask
    implements Runnable
  {
    private final VideoConstants.EmShareOps a;
    private final iiv f;
    private final WeakReference<VideoController> j;
    private final int mShareType;
    
    public ShareOpsTimeOutTask(VideoController paramVideoController, iiv paramiiv, VideoConstants.EmShareOps paramEmShareOps, int paramInt)
    {
      this.j = new WeakReference(paramVideoController);
      this.f = paramiiv;
      this.a = paramEmShareOps;
      this.mShareType = paramInt;
    }
    
    public void run()
    {
      VideoController localVideoController = (VideoController)this.j.get();
      int i;
      if ((localVideoController != null) && (this.f != null))
      {
        if (this.a != VideoConstants.EmShareOps.START) {
          break label136;
        }
        i = 86;
        if (!this.f.PY) {
          break label142;
        }
      }
      label136:
      label142:
      for (int k = 2;; k = 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AVShare", 2, "ShareOpsTimeOutTask, actionResult[" + i + "], session[" + this.f + "], multiAVSubType[" + k + "]");
        }
        localVideoController.a(i, this.mShareType, this.f.relationType, this.f.ll, this.f.anb, k);
        return;
        i = 89;
        break;
      }
    }
  }
  
  static class a
    implements iot.b, jds.a
  {
    private final ScreenShareCtrl.b a = new ScreenShareCtrl.b();
    private final WeakReference<ScreenShareCtrl> j;
    
    public a(ScreenShareCtrl paramScreenShareCtrl)
    {
      this.j = new WeakReference(paramScreenShareCtrl);
    }
    
    public void a(Bitmap paramBitmap, itn paramitn)
    {
      ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.j.get();
      if (localScreenShareCtrl != null) {
        localScreenShareCtrl.b(paramBitmap, paramitn);
      }
    }
    
    public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, itn paramitn)
    {
      this.a.a(1, paramArrayOfByte, paramInt1, paramInt2, paramitn);
      ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.j.get();
      if (localScreenShareCtrl != null) {
        localScreenShareCtrl.b(paramArrayOfByte, paramInt1, paramInt2, paramitn);
      }
    }
    
    @TargetApi(21)
    public void b(itn paramitn, int paramInt1, int paramInt2)
    {
      ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.j.get();
      if (localScreenShareCtrl == null) {}
      do
      {
        return;
        localScreenShareCtrl.a(paramitn, paramInt1, paramInt2);
        if (localScreenShareCtrl.a(VideoConstants.EmShareOps.START) == VideoConstants.EmShareOpsRet.SUC)
        {
          ScreenShareCtrl.showTips(4);
          return;
        }
        ScreenShareCtrl.showTips(6);
        paramitn = VideoController.a().a();
      } while (paramitn == null);
      paramitn.stop(1);
    }
    
    public void cA(long paramLong) {}
    
    @TargetApi(21)
    public void lJ(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "onMediaProjectionEnd fromType:=" + paramInt);
      }
      ScreenShareCtrl localScreenShareCtrl = (ScreenShareCtrl)this.j.get();
      if (localScreenShareCtrl == null) {}
      while (paramInt != 2) {
        return;
      }
      if (localScreenShareCtrl.a(VideoConstants.EmShareOps.STOP) == VideoConstants.EmShareOpsRet.SUC) {}
      for (paramInt = 2;; paramInt = 3)
      {
        ScreenShareCtrl.showTips(paramInt);
        return;
      }
    }
    
    public void lK(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "onMediaProjectionReady errorReason:=" + paramInt);
      }
    }
  }
  
  static class b
  {
    public int angle;
    public int atE;
    public final itn d = new itn();
    private int frameIndex;
    public int shareType;
    
    public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, itn paramitn)
    {
      this.frameIndex += 1;
      StringBuilder localStringBuilder;
      if ((this.shareType != paramInt1) || (this.atE != paramInt2) || (!this.d.equals(paramitn)) || (this.angle != paramInt3)) {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("updateFrame, frameIndex[").append(this.frameIndex).append("], data[");
          if (paramArrayOfByte != null) {
            break label198;
          }
        }
      }
      label198:
      for (paramArrayOfByte = "null";; paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length))
      {
        QLog.i("AVShare", 2, paramArrayOfByte + "], imgFormat[" + this.atE + "-->" + paramInt2 + "], recordParam[" + this.d + "--->" + paramitn + "], angle[" + this.angle + "-->" + paramInt3 + "]");
        this.shareType = paramInt1;
        this.atE = paramInt2;
        this.d.a(paramitn);
        this.angle = paramInt3;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl
 * JD-Core Version:    0.7.0.1
 */