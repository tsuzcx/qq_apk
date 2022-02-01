import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
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
import com.tencent.av.ui.VideoInviteUIFull.1;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class jez
  extends jey
{
  private ivm b;
  
  public jez(VideoInviteActivity paramVideoInviteActivity)
  {
    super(paramVideoInviteActivity);
    this.oR = 2;
  }
  
  private void avo()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131363164);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
    int i = jll.getScreenWidth(this.a);
    if (i <= 320)
    {
      localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131298155);
      localLayoutParams.width = super.getResources().getDimensionPixelSize(2131298151);
      localLayoutParams.height = super.getResources().getDimensionPixelSize(2131298151);
    }
    for (;;)
    {
      localImageView.setLayoutParams(localLayoutParams);
      return;
      if (i <= 480)
      {
        localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131298156);
        localLayoutParams.width = super.getResources().getDimensionPixelSize(2131298152);
        localLayoutParams.height = super.getResources().getDimensionPixelSize(2131298152);
      }
      else
      {
        localLayoutParams.topMargin = super.getResources().getDimensionPixelSize(2131298158);
        localLayoutParams.width = super.getResources().getDimensionPixelSize(2131298154);
        localLayoutParams.height = super.getResources().getDimensionPixelSize(2131298154);
      }
    }
  }
  
  private void kB(boolean paramBoolean)
  {
    long l = AudioHelper.hG();
    igd.aK("VideoInviteUIFull", "DestroyUI isQuit[" + paramBoolean + "], mPeerUin[" + this.a.mPeerUin + "], mIsDoubleVideoMeeting[" + this.a.Td + "], seq[" + l + "]");
    VideoController localVideoController = this.a.b();
    if (localVideoController == null) {}
    iiv localiiv;
    do
    {
      return;
      localiiv = localVideoController.b();
      this.a.Ox = paramBoolean;
      localVideoController.d(true);
      localVideoController.hJ(false);
      if (this.b != null) {
        this.b.x(l, this.a.Ox);
      }
      this.a.finish();
    } while (paramBoolean);
    int i = ivv.cu(localiiv.anh);
    this.a.overridePendingTransition(0, i);
  }
  
  private boolean wQ()
  {
    boolean bool = false;
    if (this.a.mApp.sM())
    {
      jjk.S(false, true);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteUIFull", 2, "startVideo phone is calling!");
      }
      String str1 = getString(2131697637);
      String str2 = getString(2131697640);
      PopupDialog.b(this.a.getApplicationContext(), 230, str2, str1, 2131721058, 2131721079, new jfa(this), null);
      bool = true;
    }
    return bool;
  }
  
  public void BtnOnClick(View paramView)
  {
    long l = AudioHelper.hG();
    QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, id[" + izq.aT(paramView.getId()) + "], seq[" + l + "]");
    boolean bool = this.a.Td;
    switch (paramView.getId())
    {
    default: 
    case 2131374106: 
    case 2131363158: 
    case 2131363170: 
      do
      {
        do
        {
          return;
          QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, REFUSE");
          this.a.WU = false;
          this.a.O(l, true);
          if (bool)
          {
            report("0X80051FF");
            return;
          }
          if (this.a.VL)
          {
            report("0X8004398");
            return;
          }
          report("0X80043F6");
          return;
        } while (wQ());
        QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, ACCEPT");
        this.a.WU = true;
        AVReport.a().ob = SystemClock.elapsedRealtime();
        this.a.dP(l);
        if (bool)
        {
          report("0X80051FE");
          return;
        }
        if (this.a.VL)
        {
          report("0X8004397");
          return;
        }
        report("0X80043F5");
        return;
        QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, ACCEPT_BY_AUDIO");
      } while (wQ());
      this.a.VD = true;
      this.a.WU = true;
      this.a.dP(l);
      report("0X80043F7");
      return;
    case 2131363169: 
      QLog.d("VideoInviteUIFull", 1, "avideo BtnOnClick, MSG_REPLY");
      this.a.a(l, this.a, false);
      if (bool) {
        paramView = "0X8005200";
      }
      for (;;)
      {
        report(paramView);
        return;
        if (this.a.VL) {
          paramView = "0X80043A5";
        } else {
          paramView = "0X80043AB";
        }
      }
    }
    QLog.d("VideoInviteUIFull", 1, "onClick HIDE ");
    paramView = this.a.b();
    if (paramView != null) {
      paramView.a("backgroundReason", "3");
    }
    onBackPressed();
  }
  
  public void a(Context paramContext, String paramString, Intent paramIntent)
  {
    if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramString))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if (paramContext != null)
      {
        TraeHelper.t(this.a.mApp);
        if (paramContext.equals("homekey"))
        {
          if (!this.a.VL) {
            break label83;
          }
          report("0X8004399");
          this.a.b().a("backgroundReason", "1");
          com.tencent.av.VideoConstants.a.Mm = "1";
        }
      }
    }
    label83:
    while (!"android.intent.action.SCREEN_OFF".equals(paramString)) {
      for (;;)
      {
        return;
        report("0X80043F8");
      }
    }
    this.a.b().a("backgroundReason", "4");
    com.tencent.av.VideoConstants.a.Mm = "4";
    this.a.Yl = true;
    this.a.kj("ACTION_SCREEN_OFF");
  }
  
  public void a(jey paramjey)
  {
    super.a(paramjey);
    AVReport.a().nA = this.mBegin;
    AVReport.a().nB = this.oY;
  }
  
  public void avi()
  {
    this.a.runOnUiThread(new VideoInviteUIFull.1(this));
  }
  
  public void initUI()
  {
    super.initUI();
    this.a.setContentView(2131559990);
    this.a.getWindow().addFlags(2097152);
    this.a.getWindow().addFlags(128);
    this.a.getWindow().clearFlags(524288);
    this.a.getWindow().clearFlags(1024);
    this.a.initUI();
    if (ThemeUtil.isInNightMode(this.a.mApp)) {
      this.a.findViewById(2131374146).setVisibility(0);
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.atY();
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.dz(-1046L);
    }
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel = ((QavPanel)super.findViewById(2131374149));
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel.mG(2131559947);
    this.a.jdField_a_of_type_ComTencentAvUiQavPanel.atX();
    this.a.b().n(this.a.mPeerUin);
    this.a.gL = ((ImageView)super.findViewById(2131363164));
    this.a.mNameView = ((TextView)super.findViewById(2131363167));
    this.a.nc.setText(2131721759);
    this.a.avd();
    Object localObject;
    label411:
    int i;
    if (this.a.e.uinType == 9500)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363170, 8);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363169, 8);
      this.a.refreshUI();
      if (!this.a.VL) {
        break label866;
      }
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131374106, super.getString(2131690635), this.a.e.anb);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.a(2131363158, super.getString(2131690615), this.a.e.anb);
      localObject = this.a.OE + super.getString(2131690633);
      jll.b(this.a.mNameView, (String)localObject);
      this.a.setTitle((CharSequence)localObject);
      if (this.a.jdField_a_of_type_Jcr != null) {
        this.a.jdField_a_of_type_Jcr.destroy();
      }
      this.a.jdField_a_of_type_Jcr = new jcr(this.a, this.a.b(), 1, this.a.jdField_a_of_type_ComTencentAvUiQavPanel, null, null, this.a.gL, this.a.mNameView, this.a.nc, null);
      if (QLog.isColorLevel()) {
        QLog.d("VideoInviteUIFull", 2, "video invite full onCreate OK");
      }
      if (!this.a.VL) {
        break label953;
      }
      i = 1;
      label523:
      if (this.a.b().b().state != 2) {
        break label958;
      }
    }
    label953:
    label958:
    for (int j = 2;; j = 3)
    {
      anot.a(null, "CliOper", "", "", "0X8009ED8", "0X8009ED8", i, j, "", "", "", "");
      this.a.jA(true);
      this.b = ivm.a(this.a.mApp);
      new VideoControlUI.d((RelativeLayout)findViewById(2131374241)).e(this.a);
      if (acej.aV() >= 17.0F)
      {
        localObject = (RelativeLayout.LayoutParams)this.a.nc.getLayoutParams();
        if (this.mScreenWidth <= 540)
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131298378);
          this.a.nc.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        if ((this.mScreenHeight <= 800) || ((jll.hasSmartBar()) && (this.mScreenHeight <= 1280)))
        {
          localObject = (RelativeLayout)super.findViewById(2131363147);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = 0;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
          localObject = (RelativeLayout)super.findViewById(2131363154);
          localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = 0;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
      }
      avo();
      if (!this.a.VL) {
        break label963;
      }
      report("0X8004396");
      return;
      if (!this.a.VL) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363170, 4);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131363169, 0);
      this.a.nc.setText(2131698157);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setAcceptDrawableTop(super.getResources().getDrawable(2130842805));
      break;
      label866:
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131374106, super.getString(2131690635));
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.g(2131363158, super.getString(2131690615));
      localObject = this.a.OE + super.getString(2131690633);
      jll.b(this.a.mNameView, (String)localObject);
      break label411;
      i = 2;
      break label523;
    }
    label963:
    report("0X80043F4");
  }
  
  public void kA(boolean paramBoolean)
  {
    super.kA(paramBoolean);
    if (paramBoolean)
    {
      AVReport.a().nA = SystemClock.elapsedRealtime();
      return;
    }
    AVReport.a().nB = SystemClock.elapsedRealtime();
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteUIFull", 2, "onBackPressed");
    }
    if (!this.a.WU)
    {
      VideoController localVideoController = this.a.b();
      if (localVideoController != null) {
        localVideoController.alx();
      }
      com.tencent.av.VideoConstants.a.Mm = "3";
      if (this.b != null) {
        this.b.onBackPressed();
      }
      kB(false);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.d("VideoInviteUIFull", 1, "onDestroy");
    if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.atY();
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.dz(-1045L);
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
    if (paramInt == 4)
    {
      if (!this.a.VL) {
        break label24;
      }
      report("0X800439A");
    }
    for (;;)
    {
      return false;
      label24:
      report("0X80043F9");
    }
  }
  
  public void updateUI()
  {
    if (this.a.WU)
    {
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131374106, false);
      this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewEnable(2131363170, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jez
 * JD-Core Version:    0.7.0.1
 */