import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.report.AVReport;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI.d;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jfb
  extends jey
{
  public jfb(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.oR = 1;
  }
  
  private boolean wQ()
  {
    boolean bool = false;
    if (this.a.mApp.sM())
    {
      jjk.S(false, true);
      aqha.b(this.a, getString(2131697640), getString(2131697637), null, new jfd(this), null);
      bool = true;
    }
    return bool;
  }
  
  public void BtnOnClick(View paramView)
  {
    boolean bool = this.a.getIntent().getBooleanExtra("isDoubleVideoMeeting", false);
    long l = AudioHelper.hG();
    QLog.d("VideoInviteUILock", 1, "avideo BtnOnClick, id[" + izq.aT(paramView.getId()) + "], isDoubleVideoMeeting[" + bool + "], seq[" + l + "]");
    switch (paramView.getId())
    {
    default: 
    case 2131374106: 
    case 2131363158: 
    case 2131363170: 
      do
      {
        return;
        this.a.WU = false;
        this.a.O(l, true);
        if (bool)
        {
          report("0X80051FF");
          return;
        }
        if (this.a.VL)
        {
          report("0X8004202");
          return;
        }
        report("0X8004206");
        return;
        this.a.WU = true;
        AVReport.a().ob = SystemClock.elapsedRealtime();
        this.a.dP(l);
        return;
      } while (wQ());
      this.a.VD = true;
      this.a.WU = true;
      this.a.dP(l);
      report("0X8004207");
      return;
    }
    this.a.a(l, this.a, true);
    if (bool) {
      paramView = "0X8005200";
    }
    for (;;)
    {
      report(paramView);
      return;
      if (this.a.VL) {
        paramView = "0X800439F";
      } else {
        paramView = "0X80043B1";
      }
    }
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramString)) {}
    do
    {
      return;
      if ("android.intent.action.SCREEN_OFF".equals(paramString))
      {
        l = AudioHelper.hG();
        if (QLog.isColorLevel()) {
          QLog.w("VideoInviteUILock", 2, "ACTION_SCREEN_OFF, seq[" + l + "]");
        }
        this.a.b().a("backgroundReason", "4");
        com.tencent.av.VideoConstants.a.Mm = "4";
        if (jkg.isRingerNormal(this.a))
        {
          this.a.dN(l);
          if ((TraeHelper.a() != null) && (!this.a.b().OB)) {
            TraeHelper.a().axI();
          }
        }
        if (this.a.mApp == null) {}
        for (paramContext = null;; paramContext = this.a.mApp.getCurrentAccountUin())
        {
          boolean bool = jjc.cJ(paramContext);
          if (QLog.isColorLevel()) {
            QLog.w("VideoInviteUILock", 1, "ACTION_SCREEN_OFF avCallBtnState[" + bool + "], seq[" + l + "]");
          }
          if (bool) {
            TraeHelper.a(this.a.mApp, false, l);
          }
          if (!this.a.VL) {
            break;
          }
          report("0X8004208");
          return;
        }
        report("0X8004209");
        return;
      }
    } while (!"android.intent.action.SCREEN_ON".equals(paramString));
    long l = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("VideoInviteUILock", 2, "ACTION_SCREEN_ON, seq[" + l + "]");
    }
    if ((this.a.VL) && (!this.a.Td)) {
      TraeHelper.a().startService("DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
    for (;;)
    {
      this.a.dO(l);
      if ((Build.VERSION.SDK_INT > 19) || (VideoController.isScreenLocked(this.a))) {
        break;
      }
      this.a.kj("ACTION_SCREEN_ON");
      return;
      TraeHelper.a().startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
    }
  }
  
  public void a(jey paramjey)
  {
    super.a(paramjey);
    AVReport.a().ny = this.mBegin;
    AVReport.a().nz = this.oY;
  }
  
  void avo()
  {
    ImageView localImageView = (ImageView)this.a.findViewById(2131381752);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = jll.getScreenWidth(this.a);
    if (i <= 320)
    {
      localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131298155);
      localLayoutParams.width = getResources().getDimensionPixelSize(2131298151);
      localLayoutParams.height = getResources().getDimensionPixelSize(2131298151);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (i <= 480)
      {
        localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131298156);
        localLayoutParams.width = getResources().getDimensionPixelSize(2131298152);
        localLayoutParams.height = getResources().getDimensionPixelSize(2131298152);
      }
      else
      {
        localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131298158);
        localLayoutParams.width = getResources().getDimensionPixelSize(2131298154);
        localLayoutParams.height = getResources().getDimensionPixelSize(2131298154);
      }
    }
  }
  
  public void initUI()
  {
    super.initUI();
    long l = AudioHelper.hG();
    this.a.setContentView(2131559991);
    this.a.getWindow().addFlags(524288);
    this.a.getWindow().addFlags(128);
    this.a.getWindow().addFlags(1024);
    if (!this.a.Yl) {
      this.a.getWindow().addFlags(2097152);
    }
    this.a.initUI();
    new VideoControlUI.d((RelativeLayout)findViewById(2131374241)).e(this.a);
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.dz(l);
    }
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)this.a.findViewById(2131374149));
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel.mG(2131559946);
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setWaveVisibility(8);
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(new jfc(this, l));
    this.a.gL = ((ImageView)this.a.findViewById(2131381752));
    this.a.mNameView = ((TextView)this.a.findViewById(2131381753));
    this.a.avd();
    if (this.a.e.uinType == 9500)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363170, 8);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363169, 8);
      this.a.refreshUI();
      Object localObject = this.a.OE + getString(2131690633);
      this.a.setTitle((CharSequence)localObject);
      if (this.a.jdField_a_of_type_Jcr != null) {
        this.a.jdField_a_of_type_Jcr.destroy();
      }
      this.a.jdField_a_of_type_Jcr = new jcr(this.a, this.a.b(), 1, this.a.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.a.gL, this.a.mNameView, this.a.nc, null);
      this.a.jA(true);
      if ((acej.aV() == 20.0F) || (acej.aV() == 18.0F) || (acej.aV() == 17.0F))
      {
        localObject = (RelativeLayout.LayoutParams)this.a.nc.getLayoutParams();
        if (this.mScreenHeight <= 540)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131298378);
          this.a.nc.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((acej.aV() == 20.0F) && (!this.a.VL))
        {
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.f(2131374106, 1, getResources().getDimensionPixelSize(2131298026));
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.f(2131363170, 2, getResources().getDimensionPixelSize(2131298026));
        }
        if ((this.mScreenHeight <= 800) || ((jll.hasSmartBar()) && (this.mScreenHeight <= 1280))) {
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.f(2131374102, 4, 0);
        }
      }
      avo();
      if (!this.a.VL) {
        break label785;
      }
      report("0X800439D");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteUILock", 2, "video invite Lock onCreate OK");
      }
      return;
      if (this.a.VL)
      {
        this.a.nc.setText(2131698157);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363170, 8);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.O(2131363169, 11);
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.f(2131363169, 2, getResources().getDimensionPixelSize(2131298206));
        this.a.jdField_a_of_type_ComTencentAvUiQavPanel.N(2131374103, 2130842806);
        jll.b(this.a.nc, getString(2131698156));
        break;
      }
      jll.b(this.a.nc, getString(2131721758));
      break;
      label785:
      report("0X80043FC");
    }
  }
  
  public void kA(boolean paramBoolean)
  {
    super.kA(paramBoolean);
    if (paramBoolean)
    {
      AVReport.a().ny = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().nz = SystemClock.elapsedRealtime();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("VideoInviteUILock", 1, "onDestroy");
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.dz(-1047L);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel = null;
    }
    if (this.a.jdField_a_of_type_Jcr != null)
    {
      this.a.jdField_a_of_type_Jcr.destroy();
      this.a.jdField_a_of_type_Jcr = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      if (this.a.VL) {
        anot.a(null, "CliOper", "", "", "0X8004200", "0X8004200", 0, 0, Integer.toString(this.a.mOnlineStatus), Integer.toString(this.a.axP), Integer.toString(this.a.axQ), "");
      } else {
        anot.a(null, "CliOper", "", "", "0X8004204", "0X8004204", 0, 0, Integer.toString(this.a.mOnlineStatus), Integer.toString(this.a.axP), Integer.toString(this.a.axQ), "");
      }
    }
  }
  
  public void updateUI()
  {
    if (this.a.WU)
    {
      if (this.a.M != null) {
        this.a.M.setEnabled(false);
      }
      if (this.a.N != null) {
        this.a.N.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfb
 * JD-Core Version:    0.7.0.1
 */