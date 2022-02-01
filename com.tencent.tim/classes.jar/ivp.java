import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.1;
import com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.2;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ivp
  extends SmallScreenVideoControlUI
{
  boolean Vu = false;
  Runnable bB = new SmallScreenDoubleVideoControlUI.2(this);
  
  public ivp(VideoAppInterface paramVideoAppInterface, SmallScreenService paramSmallScreenService, iya paramiya)
  {
    super(paramVideoAppInterface, paramSmallScreenService, paramiya);
  }
  
  public void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if ((!paramBoolean1) && (this.a != null))
    {
      str = this.a.b().peerUin;
      if (!paramBoolean2) {
        break label50;
      }
      if (!this.a.b().PV) {
        this.a.b(true, str);
      }
    }
    label50:
    while (this.a.b().PV) {
      return;
    }
    this.a.b(false, str);
  }
  
  public void V(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onPeerSwitchTerminal, bStartSwitch : " + paramBoolean);
    }
    paramString = imp.a();
    if (paramBoolean)
    {
      paramString.SB = false;
      paramString.apV = 0;
      if (QLog.isColorLevel()) {
        QLog.e("SmallScreenDoubleVideoControlUI", 2, "WL_DEBUG onPeerSwitchTerminal mPeerVersion = " + paramString.apV + ", mIsPeerSupport = " + paramString.SB);
      }
      ivv.arh();
      this.mApp.l(new Object[] { Integer.valueOf(127) });
      return;
    }
    paramString.aoj();
  }
  
  public void aR(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onInviteReached remotePhoneState = " + this.a.b().amR + " # remoteTerminal = " + this.a.b().amO + " # phoneOnLine = " + this.a.b().amQ + " # pcOnLine = " + this.a.b().amP + " # subState = " + this.a.b().li + " # isPeerNetworkWell = " + this.a.b().Qf);
    }
    if ((this.a == null) || (!this.a.b().ta()) || (this.a.b().QU) || (this.a.b().uinType == 1011)) {}
    while ((!this.a.b().peerUin.contains(paramString1)) || (this.a.b().amR < 0) || (this.mTitleView == null)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      this.mTitleView.setText(2131698196);
      return;
    }
    this.mTitleView.setText(paramString2);
  }
  
  public void amZ()
  {
    String str = this.a.b().peerUin;
    int i = this.a.getPeerTerminalType(str);
    int j = this.a.getPeerSdkVersion(str);
    if ((i == 5) || (i == 0))
    {
      if (this.Vu) {
        this.mApp.getHandler().removeCallbacks(this.bB);
      }
      if (this.a.b().li != 1L) {
        startTimer();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.a.sp()) {
                break;
              }
              if (this.Vu) {
                this.mApp.getHandler().removeCallbacks(this.bB);
              }
            } while (this.a.b().li == 1L);
            startTimer();
            return;
          } while (!this.a.b().isConnected());
          if (j <= 18) {
            break;
          }
        } while (!this.a.b().QZ);
        if (this.Vu) {
          this.mApp.getHandler().removeCallbacks(this.bB);
        }
      } while (this.a.b().li == 1L);
      startTimer();
      return;
      if (this.Vu) {
        this.mApp.getHandler().removeCallbacks(this.bB);
      }
    } while (this.a.b().li == 1L);
    startTimer();
  }
  
  public void ana()
  {
    String str = this.a.b().peerUin;
    int i = this.a.getPeerTerminalType(str);
    int j = this.a.getPeerSdkVersion(str);
    if ((i == 5) || (i == 0)) {}
    while ((!this.a.sp()) || (!this.a.b().isConnected()) || (j <= 18) || (!this.a.b().QY)) {
      return;
    }
    if (this.Vu) {
      this.mApp.getHandler().removeCallbacks(this.bB);
    }
    startTimer();
  }
  
  public void hF(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenDoubleVideoControlUI", 2, "onNotRecvAudioData bNotRecv = " + paramBoolean);
    }
    if (paramBoolean) {}
    do
    {
      return;
      if (this.Vu) {
        this.mApp.getHandler().removeCallbacks(this.bB);
      }
    } while (this.a.b().li == 1L);
    startTimer();
  }
  
  public void je(boolean paramBoolean)
  {
    int i = 2131698196;
    int j = 2131698082;
    super.je(paramBoolean);
    iiv localiiv = this.a.b();
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenDoubleVideoControlUI", 1, "onCreate, matchStatus[" + localiiv.a.anA + "], seq[" + l + "]");
    }
    if (this.a.OD) {
      this.mTitleView.setText(2131698081);
    }
    do
    {
      return;
      if ((localiiv.a.anA > 0) && (localiiv.a.anA != 5))
      {
        this.mTitleView.setText(2131698091);
        return;
      }
    } while (localiiv.isConnected());
    if (localiiv.isConnecting())
    {
      if (localiiv.QE) {}
      for (i = 2131697696;; i = 2131721776)
      {
        this.mTitleView.setText(i);
        return;
      }
    }
    if (localiiv.ta())
    {
      if (localiiv.QU) {
        i = 2131698082;
      }
      if (localiiv.uinType != 1011) {
        break label344;
      }
      i = j;
    }
    label275:
    label344:
    for (;;)
    {
      this.mTitleView.setText(i);
      return;
      if (localiiv.tc())
      {
        if ((localiiv.amI == 0) && (localiiv.PT))
        {
          j = i;
          if (localiiv.amK != 1) {
            if (localiiv.amK != 2) {
              break label275;
            }
          }
        }
        for (j = i;; j = 2131697885)
        {
          this.mTitleView.setText(j);
          return;
        }
      }
      if ((!localiiv.tf()) && (!localiiv.tg())) {
        break;
      }
      if (localiiv.uinType == 1011) {
        this.mTitleView.setText(2131698098);
      }
      this.mApp.getHandler().postDelayed(new SmallScreenDoubleVideoControlUI.1(this, l), 150L);
      return;
    }
  }
  
  public void lM(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<setInvitingState(), resId =" + paramInt);
    }
    if ((this.a.b().uinType == 1011) && (paramInt != 2131698082) && (paramInt != 2131721705) && (!this.a.OD)) {}
    while ((this.mTitleView == null) || (paramInt <= 0)) {
      return;
    }
    this.mTitleView.setText(paramInt);
  }
  
  public void onConnected()
  {
    super.onConnected();
    if (this.mTitleView != null) {
      this.mTitleView.setText(2131698082);
    }
    String str = this.a.b().peerUin;
    int i = this.a.getPeerTerminalType(str);
    int j = this.a.getPeerSdkVersion(str);
    if (i == 5)
    {
      if (this.a.b().QY)
      {
        startTimer();
        return;
      }
      this.mApp.getHandler().postDelayed(this.bB, 5000L);
      this.Vu = true;
      return;
    }
    if (!this.a.sp())
    {
      if (this.a.b().QY)
      {
        startTimer();
        return;
      }
      this.mApp.getHandler().postDelayed(this.bB, 5000L);
      this.Vu = true;
      return;
    }
    if (!this.a.b().isConnected())
    {
      this.mApp.getHandler().postDelayed(this.bB, 5000L);
      this.Vu = true;
      return;
    }
    if (j > 18)
    {
      if ((this.a.b().QY) && (this.a.b().QZ))
      {
        startTimer();
        return;
      }
      this.mApp.getHandler().postDelayed(this.bB, 5000L);
      this.Vu = true;
      return;
    }
    if (this.a.b().QY)
    {
      startTimer();
      return;
    }
    this.mApp.getHandler().postDelayed(this.bB, 5000L);
    this.Vu = true;
  }
  
  public void onDestroy(long paramLong)
  {
    if ((this.Vu) && (this.mApp != null)) {
      this.mApp.getHandler().removeCallbacks(this.bB);
    }
    super.onDestroy(paramLong);
  }
  
  public void onResume()
  {
    super.onResume();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onResume(), ts=" + System.currentTimeMillis());
    }
    if ((this.a != null) && (this.a.b().isConnected()) && (this.a.b().li != 1L)) {
      startTimer();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onResume(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void onStart()
  {
    super.onStart();
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, ">>>onStart(), ts=" + l1);
    }
    if ((this.a != null) && (this.a.b().ta()) && (this.a.b().amR >= 0) && (this.mTitleView != null))
    {
      if (this.a.b().uinType != 1011) {
        break label170;
      }
      this.mTitleView.setText(2131698082);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, "<<<onStart(), ts=" + l2);
        QLog.d("IVR_TS_SmallScreenDoubleVideoControlUI", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
      }
      return;
      label170:
      this.mTitleView.setText(2131698196);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivp
 * JD-Core Version:    0.7.0.1
 */