import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView;
import com.tencent.av.service.RecvMsg;
import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController.1;
import com.tencent.av.smallscreen.SmallScreenVideoController.3;
import com.tencent.av.smallscreen.SmallScreenVideoController.4;
import com.tencent.av.smallscreen.SmallScreenVideoController.MyVideoObserver.1;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import mqq.app.AppRuntime;

public class ivz
  implements iwb.a
{
  String OD = null;
  public boolean Ox = false;
  public boolean Ta = false;
  boolean Td = false;
  boolean VD = false;
  boolean VE = false;
  public VideoController a;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  public SmallScreenVideoControlUI a;
  ill jdField_a_of_type_Ill = new iwa(this);
  ivz.b jdField_a_of_type_Ivz$b = new ivz.b();
  public iwb a;
  ixr jdField_a_of_type_Ixr = null;
  public int auF = -1;
  int auG = 1;
  public int auH = 0;
  int auI = 0;
  CameraUtils b;
  public iya b;
  Bitmap bp = null;
  public Timer m = null;
  public VideoAppInterface mApp = null;
  String mBindId = null;
  int mBindType = 0;
  public Context mContext = null;
  Display mDisplay = null;
  public String mPeerUin = null;
  public int mSessionType = 0;
  int mUinType = -1;
  
  public ivz(SmallScreenService paramSmallScreenService)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_b_of_type_Iya = new ivz.a();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.mContext = paramSmallScreenService.getApplicationContext();
    this.mDisplay = ((WindowManager)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getSystemService("window")).getDefaultDisplay();
  }
  
  public static void a(Context paramContext, VideoController paramVideoController)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "enterVideo start");
    }
    if ((paramContext == null) || (paramVideoController == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "enterVideo context or controller is null.");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "enterVideo end");
      }
      label135:
      iiv localiiv;
      int i;
      label446:
      long l;
      int j;
      do
      {
        Intent localIntent;
        do
        {
          for (;;)
          {
            return;
            if (!MultiIncomingCallsActivity.isShowing) {
              break label135;
            }
            paramVideoController = new Intent(paramContext, MultiIncomingCallsActivity.class);
            paramVideoController.addFlags(262144);
            paramVideoController.addFlags(268435456);
            paramVideoController.addFlags(4194304);
            try
            {
              paramContext.startActivity(paramVideoController);
            }
            catch (Exception paramContext) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + paramContext);
          break;
          localiiv = paramVideoController.b();
          i = localiiv.amI;
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "enterVideo sessionType =" + i);
          }
          if (paramVideoController.OD) {
            i = 1;
          }
          if ((i != 1) && (i != 2)) {
            break label446;
          }
          localIntent = new Intent(paramContext, AVActivity.class);
        } while ((localiiv.uinType == 1011) || (paramVideoController.OD));
        localIntent.addFlags(262144);
        localIntent.addFlags(268435456);
        localIntent.addFlags(4194304);
        if (localiiv.Qw)
        {
          localiiv.uinType = 0;
          localIntent.putExtra("sessionType", localiiv.amI);
          localIntent.putExtra("GroupId", localiiv.peerUin);
          localIntent.putExtra("uin", localiiv.peerUin);
          localIntent.putExtra("isDoubleVideoMeeting", true);
          localIntent.putExtra("uinType", localiiv.uinType);
        }
        for (;;)
        {
          try
          {
            paramContext.startActivity(localIntent);
            localIntent.putExtra("Fromwhere", "SmallScreen");
          }
          catch (Exception paramContext)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + paramContext);
            continue;
          }
          localIntent.putExtra("sessionType", i);
          localIntent.putExtra("uin", localiiv.peerUin);
          try
          {
            paramContext.startActivity(localIntent);
          }
          catch (Exception paramContext) {}
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + paramContext);
          }
        }
        l = localiiv.ll;
        j = localiiv.relationType;
        if ((l == 0L) && (localiiv.a.anA <= 0)) {
          break label695;
        }
        if (localiiv.a.anA <= 0) {
          break label546;
        }
      } while ((localiiv.amI == 1) || (localiiv.a.chatType == 1) || (localiiv.amI == 3) || (localiiv.a.chatType == 3) || (!QLog.isColorLevel()));
      QLog.e("SmallScreenVideoController", 2, "enterVideo status error");
      return;
      label546:
      paramVideoController = new Intent(paramContext, AVActivity.class);
      paramVideoController.addFlags(262144);
      paramVideoController.addFlags(268435456);
      paramVideoController.addFlags(4194304);
      paramVideoController.putExtra("GroupId", String.valueOf(l));
      paramVideoController.putExtra("Type", 2);
      paramVideoController.putExtra("sessionType", i);
      paramVideoController.putExtra("uinType", jll.cM(j));
      paramVideoController.putExtra("isDoubleVideoMeeting", localiiv.Qw);
      paramVideoController.putExtra("MultiAVType", localiiv.anb);
      paramVideoController.putExtra("Fromwhere", "SmallScreen");
      try
      {
        paramContext.startActivity(paramVideoController);
      }
      catch (Exception paramContext) {}
      if (QLog.isColorLevel())
      {
        QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + paramContext);
        continue;
        label695:
        if ((paramVideoController.so()) && (localiiv.tb()))
        {
          paramVideoController = new Intent(paramContext, VideoInviteActivity.class);
          paramVideoController.addFlags(268435456);
          paramVideoController.putExtra("uinType", localiiv.uinType);
          paramVideoController.putExtra("peerUin", localiiv.peerUin);
          paramVideoController.putExtra("extraUin", localiiv.MP);
          if (localiiv.amK == 1) {}
          for (;;)
          {
            paramVideoController.putExtra("isAudioMode", bool);
            paramContext.startActivity(paramVideoController);
            break;
            bool = false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenVideoController", 2, "enterVideo status error");
        }
      }
    }
  }
  
  private void arl()
  {
    this.mApp.getHandler().postDelayed(new SmallScreenVideoController.4(this), 50L);
  }
  
  public static void d(ViewGroup paramViewGroup)
  {
    RedPacketGameSmallScreenView localRedPacketGameSmallScreenView = (RedPacketGameSmallScreenView)paramViewGroup.findViewById(2131374189);
    if (localRedPacketGameSmallScreenView != null)
    {
      localRedPacketGameSmallScreenView.recycle();
      paramViewGroup.removeView(localRedPacketGameSmallScreenView);
    }
  }
  
  private void lR(int paramInt)
  {
    long l = AudioHelper.hG();
    StringBuilder localStringBuilder;
    if (AudioHelper.aCz())
    {
      localStringBuilder = new StringBuilder().append("changeVideoLayoutMode, mode[").append(paramInt).append("], mVideoLayerUI[");
      if (this.jdField_a_of_type_Iwb == null) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("SmallScreenVideoController", 1, bool + "], seq[" + l + "]");
      if ((this.jdField_a_of_type_Iwb != null) && (paramInt != this.jdField_a_of_type_Iwb.lI())) {
        break;
      }
      return;
    }
    if (paramInt == 1) {
      notifyEvent(Integer.valueOf(6101), null, Boolean.valueOf(false));
    }
    this.jdField_a_of_type_Iwb.lS(paramInt);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.cC(l);
  }
  
  public RedPacketGameSmallScreenView a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    RedPacketGameSmallScreenView localRedPacketGameSmallScreenView = (RedPacketGameSmallScreenView)paramViewGroup.findViewById(2131374189);
    if (localRedPacketGameSmallScreenView == null)
    {
      localRedPacketGameSmallScreenView = new RedPacketGameSmallScreenView(paramViewGroup.getContext());
      paramViewGroup.addView(localRedPacketGameSmallScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
    for (paramViewGroup = localRedPacketGameSmallScreenView;; paramViewGroup = localRedPacketGameSmallScreenView)
    {
      paramViewGroup.setAVRedPacketManager((AVRedPacketManager)this.mApp.a(6), paramBoolean);
      return paramViewGroup;
    }
  }
  
  void aqX()
  {
    this.mSessionType = this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
    this.auH = this.jdField_a_of_type_ComTencentAvVideoController.b().amK;
    this.Td = this.jdField_a_of_type_ComTencentAvVideoController.b().Qw;
    this.mUinType = this.jdField_a_of_type_ComTencentAvVideoController.b().uinType;
    this.mPeerUin = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
    this.mBindType = this.jdField_a_of_type_ComTencentAvVideoController.b().bindType;
    this.mBindId = this.jdField_a_of_type_ComTencentAvVideoController.b().MX;
    this.OD = this.jdField_a_of_type_ComTencentAvVideoController.b().MP;
    this.Ta = this.jdField_a_of_type_ComTencentAvVideoController.b().PT;
  }
  
  public void arj()
  {
    if (this.m != null)
    {
      this.m.cancel();
      this.m = null;
    }
    this.m = new Timer();
    SmallScreenVideoController.1 local1 = new SmallScreenVideoController.1(this);
    this.m.schedule(local1, 1000L);
  }
  
  public void ark()
  {
    if (this.Ox) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
    }
  }
  
  void arm()
  {
    if (this.jdField_a_of_type_Ixr == null) {
      this.jdField_a_of_type_Ixr = new ivz.c(this.mContext, 2);
    }
  }
  
  void arn()
  {
    if (this.jdField_a_of_type_Ixr != null) {
      this.jdField_a_of_type_Ixr.enable();
    }
  }
  
  void aro()
  {
    if (this.jdField_a_of_type_Ixr != null) {
      this.jdField_a_of_type_Ixr.disable();
    }
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof VideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onCreate");
      }
      this.mApp = ((VideoAppInterface)paramAppRuntime);
      this.jdField_a_of_type_ComTencentAvVideoController = this.mApp.b();
      this.mApp.addObserver(this.jdField_b_of_type_Iya);
      this.mApp.addObserver(this.jdField_a_of_type_Ivz$b);
      this.jdField_a_of_type_ComTencentAvVideoController.fp();
      arm();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.b().sT()) {
        aqX();
      }
      GraphicRenderMgr.getInstance();
      ji(false);
    }
  }
  
  public boolean ct(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().Rk) {}
    while ((this.auF == paramInt) || (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) || (!(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI instanceof ivp))) {
      return false;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.b().PZ)
    {
      igd.aL("SmallScreenVideoController", "Remote not has video, nOff=" + paramInt);
      return false;
    }
    QLog.d("SmallScreenVideoController", 1, "setGlassSwitch nOff=" + paramInt + ", prior=" + this.auF);
    this.auF = paramInt;
    this.jdField_a_of_type_ComTencentAvVideoController.b().anm = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Iwb.wY();
      this.jdField_a_of_type_ComTencentAvVideoController.cp(0);
      continue;
      this.jdField_a_of_type_Iwb.wX();
      this.jdField_a_of_type_ComTencentAvVideoController.cp(0);
      continue;
      this.jdField_a_of_type_Iwb.wY();
      this.jdField_a_of_type_ComTencentAvVideoController.cp(1);
      continue;
      this.jdField_a_of_type_Iwb.wX();
      this.jdField_a_of_type_ComTencentAvVideoController.cp(1);
    }
  }
  
  public void finish()
  {
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = null;
    ivu localivu;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null)
    {
      localivu = null;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null) {
        break label66;
      }
      label18:
      if ((!this.Ox) || (localivu == null) || (!localivu.vH()) || (localSmallScreenRelativeLayout == null) || (localSmallScreenRelativeLayout.getVisibility() == 8)) {
        break label78;
      }
      localSmallScreenRelativeLayout.hide();
    }
    label66:
    label78:
    while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null)
    {
      return;
      localivu = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
      break;
      localSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
      break label18;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
  }
  
  void ji(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b();
    if ((localObject != null) && (QLog.isColorLevel())) {
      QLog.d("SmallScreenVideoController", 2, "onCreateUI SessionType = " + ((iiv)localObject).amI);
    }
    this.bp = jll.b(this.mContext, 2130842802);
    if (this.jdField_b_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this.mContext);
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils.addObserver(this.jdField_a_of_type_Ill);
      this.jdField_b_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
    }
    View localView = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1).findViewById(2131363166);
    if (this.jdField_a_of_type_Iwb == null)
    {
      this.jdField_a_of_type_Iwb = new iwb(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, localView, this);
      switch (this.mSessionType)
      {
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.OD) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null)) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new ivp(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
      }
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.je(paramBoolean);
      }
      if ((localObject != null) && (((iiv)localObject).state != 4) && (this.mSessionType == 1) && (!this.Ta))
      {
        int i = aqwu.a(this.mApp, this.mApp.getAccount(), 6, true, null);
        if (i > 0)
        {
          int j = aqwu.getResourceType();
          localObject = aqwu.a(this.mApp, i, j, null);
          if (localObject != null)
          {
            localObject = new File((String)localObject);
            if ((localObject != null) && (((File)localObject).exists()) && (this.jdField_a_of_type_Iwb != null)) {
              this.jdField_a_of_type_Iwb.avC();
            }
          }
        }
      }
      return;
      this.jdField_a_of_type_Iwb.requestLayout();
      break;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
        if (this.Td)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
          if (localObject != null)
          {
            this.mSessionType = ((iiv)localObject).amI;
            this.auH = ((iiv)localObject).amK;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new ivp(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
          continue;
          if (this.Td)
          {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
            if (localObject != null)
            {
              this.mSessionType = ((iiv)localObject).amI;
              this.auH = ((iiv)localObject).amK;
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new ivp(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
            continue;
            if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
              if (this.Td)
              {
                this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
                if (localObject != null)
                {
                  this.mSessionType = ((iiv)localObject).amI;
                  this.auH = ((iiv)localObject).amK;
                }
              }
              else if (this.jdField_a_of_type_ComTencentAvVideoController.b().anb == 2)
              {
                this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
              }
              else
              {
                this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
                continue;
                if ((localObject != null) && (((iiv)localObject).a.anA > 0))
                {
                  if (((iiv)localObject).a.chatType == 3) {
                    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
                  } else {
                    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new ivp(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
                  }
                }
                else if ((localObject != null) && (((iiv)localObject).PT) && ((((iiv)localObject).state == 1) || (((iiv)localObject).state == 2))) {
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new ivp(this.mApp, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_b_of_type_Iya);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void lN(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.lN(paramInt);
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    igd.aJ("SmallScreenVideoController", "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.mApp.l(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void onClick()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick start");
    }
    a(this.mContext, this.jdField_a_of_type_ComTencentAvVideoController);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick end");
    }
  }
  
  public void onDestroy(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onDestroy, mActivityState[" + this.auG + "->" + 0 + "], seq[" + paramLong + "]");
    }
    this.auG = 0;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1))
    {
      if (localObject != null)
      {
        View localView = ((SmallScreenRelativeLayout)localObject).findViewById(2131376960);
        if (localView != null) {
          localView.findViewById(2131376965).clearAnimation();
        }
      }
      if (this.m != null)
      {
        this.m.cancel();
        this.m = null;
      }
      if (this.jdField_b_of_type_ComTencentAvCameraCameraUtils != null)
      {
        this.jdField_b_of_type_ComTencentAvCameraCameraUtils.deleteObserver(this.jdField_a_of_type_Ill);
        this.jdField_b_of_type_ComTencentAvCameraCameraUtils = null;
      }
      if (this.jdField_a_of_type_Iwb != null)
      {
        this.jdField_a_of_type_Iwb.onDestroy();
        this.jdField_a_of_type_Iwb = null;
      }
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onDestroy(paramLong);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
      }
      if (this.mApp != null)
      {
        this.mApp.deleteObserver(this.jdField_a_of_type_Ivz$b);
        this.mApp.deleteObserver(this.jdField_b_of_type_Iya);
        this.mApp.b().b().ac("SmallScreen.onDestroy", 0);
      }
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      this.mApp = null;
      this.jdField_a_of_type_Ixr = null;
      this.jdField_b_of_type_Iya = null;
      this.jdField_a_of_type_Ivz$b = null;
      if (localObject != null) {
        d((ViewGroup)localObject);
      }
      return;
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPause");
    }
    aro();
    this.auG = 4;
    if (this.jdField_a_of_type_Iwb != null) {
      this.jdField_a_of_type_Iwb.onPause();
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onPause();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.d(true);
  }
  
  public void onResume()
  {
    long l1 = System.currentTimeMillis();
    this.VE = false;
    this.auG = 5;
    long l2 = AudioHelper.hG();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onResume, seq[" + l2 + "]");
    }
    this.mApp.getHandler().postDelayed(new SmallScreenVideoController.3(this, l2), 200L);
    if (this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.b().isConnected())
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
        bool1 = this.jdField_a_of_type_ComTencentAvVideoController.b().PZ;
        this.jdField_a_of_type_Iwb.b((String)localObject, 1, bool1, false, this.jdField_a_of_type_ComTencentAvVideoController.cl(this.mPeerUin));
        if ((this.jdField_a_of_type_ComTencentAvVideoController.b().PY) && (!this.mApp.sM()))
        {
          this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ca(l2);
          this.jdField_a_of_type_Iwb.d(true, false);
          this.jdField_a_of_type_Iwb.R(l2, this.jdField_b_of_type_ComTencentAvCameraCameraUtils.isFrontCamera());
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController.b().amI != 4) {
      for (;;)
      {
        if (this.jdField_a_of_type_Iwb != null) {
          this.jdField_a_of_type_Iwb.onResume();
        }
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onResume();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.d(false);
        arn();
        l2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel())
        {
          QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onResume(), ts=" + l2);
          QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
        }
        return;
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.b().QU) && (!this.VD))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.b().n(l2, true);
          this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ca(l2);
          this.jdField_a_of_type_Iwb.d(true, false);
          this.jdField_a_of_type_Iwb.R(l2, this.jdField_b_of_type_ComTencentAvCameraCameraUtils.isFrontCamera());
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if;
    int i = 0;
    label422:
    String str;
    int j;
    boolean bool2;
    boolean bool3;
    if (i < ((ArrayList)localObject).size())
    {
      ioa localioa = (ioa)((ArrayList)localObject).get(i);
      str = String.valueOf(localioa.uin);
      j = localioa.videoSrcType;
      bool2 = localioa.Tp;
      bool3 = localioa.isRender;
      if ((localioa.mk != 5L) && (localioa.mk != 14L)) {
        break label542;
      }
    }
    label542:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!str.equals(this.mApp.getCurrentAccountUin())) && (bool3)) {
        this.jdField_a_of_type_Iwb.b(str, j, bool3, bool2, bool1);
      }
      i += 1;
      break label422;
      break;
    }
  }
  
  public void onStart()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ">>>onStart(), ts=" + l1);
    }
    this.auG = 3;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStart");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onStart();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onStart(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void onStop()
  {
    this.auG = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onStop();
    }
  }
  
  class a
    extends iya
  {
    a() {}
    
    protected void arp()
    {
      if (ivz.this.jdField_a_of_type_Iwb != null) {
        ivz.this.jdField_a_of_type_Iwb.f(0, 0, true);
      }
    }
    
    protected void arq()
    {
      if (ivz.this.jdField_a_of_type_ComTencentAvVideoController.OQ)
      {
        ivz.this.jdField_a_of_type_ComTencentAvVideoController.OQ = false;
        ivz.this.Ox = true;
        ivz.this.finish();
      }
    }
    
    protected void arr()
    {
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) {}
      for (Object localObject = null;; localObject = ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1))
      {
        if (localObject != null) {
          imr.a((ViewGroup)localObject);
        }
        return;
      }
    }
    
    public void ars()
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onChangeUI_RecordStateChange:");
      }
      Object localObject1;
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null)
      {
        localObject1 = null;
        if ((ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null) && (ivz.this.jdField_a_of_type_ComTencentAvVideoController != null) && (localObject1 != null)) {
          break label66;
        }
      }
      label305:
      for (;;)
      {
        return;
        localObject1 = ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
        break;
        label66:
        localObject1 = ((SmallScreenRelativeLayout)localObject1).findViewById(2131376960);
        if (localObject1 == null)
        {
          QLog.d("SmallScreenVideoController", 1, "onChangeUI_RecordStateChange view is null");
          return;
        }
        ((View)localObject1).clearAnimation();
        if ((!ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().Qp) && (!ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording)) {
          break label307;
        }
        ((View)localObject1).setVisibility(0);
        Object localObject2 = new jdh.a();
        ((jdh.a)localObject2).setDuration(1000L);
        ((jdh.a)localObject2).setRepeatCount(-1);
        ((View)localObject1).findViewById(2131376965).startAnimation((Animation)localObject2);
        int i;
        if ((ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording) && (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().Qp))
        {
          ((TextView)((View)localObject1).findViewById(2131376973)).setText(2131697990);
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label305;
          }
          localObject2 = Build.MANUFACTURER;
          String str = Build.MODEL;
          if ((!"Xiaomi".equalsIgnoreCase((String)localObject2)) || (!"MI MAX".equalsIgnoreCase(str))) {
            break;
          }
          ((TextView)((View)localObject1).findViewById(2131376973)).setTextSize(1, 8.0F);
          return;
          if (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().isRecording)
          {
            ((TextView)((View)localObject1).findViewById(2131376973)).setText(2131697991);
            i = 0;
          }
          else
          {
            ((TextView)((View)localObject1).findViewById(2131376973)).setText(2131697989);
            i = 1;
          }
        }
      }
      label307:
      ((View)localObject1).setVisibility(8);
    }
    
    protected void b(String paramString1, int paramInt1, String paramString2, int paramInt2) {}
    
    protected void bB(ArrayList<ioa> paramArrayList)
    {
      if ((ivz.this.jdField_a_of_type_Iwb != null) && (paramArrayList != null))
      {
        Object localObject = ivz.this.jdField_a_of_type_ComTencentAvVideoController.f(paramArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoController", 2, "onChangeUI_CloseVideo-->infos=" + (String)localObject);
        }
        int i = 0;
        if (i < paramArrayList.size())
        {
          localObject = (ioa)paramArrayList.get(i);
          String str = String.valueOf(((ioa)localObject).uin);
          boolean bool2 = ((ioa)localObject).Tp;
          int j = ((ioa)localObject).videoSrcType;
          iwb localiwb;
          if (!str.equals(ivz.this.mApp.getCurrentAccountUin()))
          {
            if (ivz.this.jdField_a_of_type_Iwb.i(str, j))
            {
              iwu.a(ivz.this.mApp, 1036);
              iwu.a(ivz.this.mApp, 1037);
            }
            localiwb = ivz.this.jdField_a_of_type_Iwb;
            if ((((ioa)localObject).mk != 5L) && (((ioa)localObject).mk != 14L)) {
              break label218;
            }
          }
          label218:
          for (boolean bool1 = true;; bool1 = false)
          {
            localiwb.b(str, j, false, bool2, bool1);
            i += 1;
            break;
          }
        }
      }
    }
    
    protected void be(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "Qav.Record, onChangeUi_ReceiveRecordMsg, from=" + paramString1 + ", data=" + paramString2);
      }
      if (ivz.this.jdField_a_of_type_ComTencentAvVideoController == null) {}
      for (;;)
      {
        return;
        try
        {
          i = Integer.parseInt(paramString2);
          if (i == -1)
          {
            QLog.d("SmallScreenVideoController", 1, "onChangeUi_ReceiveRecordMsg, parse int failed, try parse SUPPORT, data=" + paramString2);
            if (TextUtils.isEmpty(paramString2)) {
              continue;
            }
            if (!"SUPPORT_TRUE".equals(paramString2)) {
              break label284;
            }
            ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().Qo = true;
            ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().amV = Math.max(ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().amV, 730);
          }
          j = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().amI;
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "onChangeUi_ReceiveRecordMsg, session type=" + j);
          }
          switch (i)
          {
          case 2: 
          case 4: 
          case 6: 
          case 7: 
          default: 
            ars();
            return;
          }
        }
        catch (NumberFormatException paramString1)
        {
          for (;;)
          {
            int j;
            QLog.d("SmallScreenVideoController", 1, "Qav.Record, onChangeUi_ReceiveRecordMsg, " + paramString1.getMessage());
            int i = -1;
            continue;
            label284:
            if (paramString2.startsWith("SUPPORT_TRUE_7.3.5"))
            {
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().Qo = true;
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().amV = Math.max(ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().amV, 735);
              j = jgy.n(paramString2, jgu.a().azj);
              QLog.i("SmallScreenVideoController", 1, "onChangeUi_ReceiveRecordMsg, SUPPORT_735 val=" + j);
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().lh = (j * 60 * 1000L);
              continue;
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.d(8, String.valueOf(2));
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.alZ();
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().Qp = true;
              continue;
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.d(8, String.valueOf(4));
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().Qp = false;
              continue;
              ivz.this.jdField_a_of_type_ComTencentAvVideoController.d(8, String.valueOf(6));
            }
          }
        }
      }
    }
    
    protected void cE(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w("double_2_multi", 1, "onChangeUI_DobuleAudio2MultiAudio, isBackground_Stop[" + ivz.this.mApp.isBackground_Stop + "], seq[" + paramLong + "]");
      }
      if (ivz.this.jdField_a_of_type_ComTencentAvVideoController == null) {}
      do
      {
        do
        {
          return;
          ivz.a(ivz.this, 1);
          localObject = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b();
        } while (((iiv)localObject).switchState == 11);
        if (ivz.this.jdField_a_of_type_Iwb != null) {
          ivz.this.jdField_a_of_type_Iwb.b(((iiv)localObject).peerUin, 1, false, false, false);
        }
        if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
        {
          ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onDestroy(paramLong);
          ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
        }
        ivz.this.Td = false;
        ivz.this.mSessionType = ((iiv)localObject).amI;
        ivz.this.auH = ((iiv)localObject).amK;
        if (!imm.isNormalSharp())
        {
          ivz.this.jdField_a_of_type_Iwb.d(false, false);
          ((iiv)localObject).n(paramLong, false);
        }
        ivz.this.ji(true);
        if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
        {
          ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onStart();
          if (ivz.this.auG != 2) {
            ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onResume();
          }
        }
        if (((iiv)localObject).peerUin != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->Peer uin is null!!!!!!!!!");
      return;
      ((iiv)localObject).lm = Long.valueOf(((iiv)localObject).peerUin).longValue();
      long l = ((iiv)localObject).ll;
      if (((iiv)localObject).uinType == 3000) {
        ((iiv)localObject).f = ivz.this.mApp.a(String.valueOf(l));
      }
      ((iiv)localObject).ac("onChangeUI_DobuleAudio2MultiAudio", 0);
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.hN(false);
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.hO(false);
      ivz.this.mUinType = ((iiv)localObject).uinType;
      if (ivz.this.mSessionType == 4) {
        ivz.this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ivz.this.mSessionType, false, false);
      }
      Object localObject = ivz.this.mApp.b().getChatRoomId(ivz.this.mApp.b().b().peerUin) + "";
      ijw.a(ivz.this.mApp, (String)localObject);
      ijw.Z(2, (String)localObject);
      ijw.stop(2);
    }
    
    protected void cF(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w("normal_2_meeting", 1, "onChangeUI_Normal2Meeting, isBackground_Stop[" + ivz.this.mApp.isBackground_Stop + "], seq[" + paramLong + "], session[" + ivz.this.jdField_a_of_type_ComTencentAvVideoController.b() + "]");
      }
      if (ivz.this.jdField_a_of_type_ComTencentAvVideoController == null) {}
      iiv localiiv;
      do
      {
        do
        {
          return;
          ivz.a(ivz.this, 1);
          localiiv = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b();
        } while (localiiv.switchState == 16);
        if (ivz.this.jdField_a_of_type_Iwb != null) {
          ivz.this.jdField_a_of_type_Iwb.b(localiiv.peerUin, 1, false, false, false);
        }
        if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
        {
          ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onDestroy(paramLong);
          ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
        }
        localiiv.S("onChangeUI_Normal2Meeting", true);
        ivz.this.Td = true;
        ivz.this.mSessionType = 1;
        ivz.this.auH = localiiv.amK;
        if (!imm.isNormalSharp())
        {
          ivz.this.jdField_a_of_type_Iwb.d(false, false);
          localiiv.n(paramLong, false);
        }
        ivz.this.ji(true);
        if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
        {
          ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onStart();
          if (ivz.this.auG != 2) {
            ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onResume();
          }
        }
        if (localiiv.peerUin != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("double_2_multi", 2, "onChangeUI_Normal2Meeting-->Peer uin is null!");
      return;
      localiiv.T("SmallScreen.onChangeUI_Normal2Meeting", false);
      ivz.this.mUinType = 0;
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.a(paramLong, ivz.this.mSessionType, false, true);
    }
    
    protected void cG(long paramLong)
    {
      if (ivz.this.jdField_a_of_type_Iwb != null)
      {
        ivz.this.jdField_a_of_type_Iwb.d(false, false);
        ivz.a(ivz.this, 1);
      }
    }
    
    protected void g(long paramLong, ArrayList<ioa> paramArrayList)
    {
      Object localObject;
      int k;
      int j;
      String str1;
      int m;
      boolean bool2;
      int i;
      label156:
      String str2;
      boolean bool1;
      if ((ivz.this.jdField_a_of_type_Iwb != null) && (paramArrayList != null))
      {
        localObject = ivz.this.jdField_a_of_type_ComTencentAvVideoController.f(paramArrayList);
        k = ivz.this.jdField_a_of_type_ComTencentAvVideoController.getVideoAbilityLevel();
        if (QLog.isColorLevel()) {
          QLog.w("SmallScreenVideoController", 1, "onRequest_ShowVideo, seq[" + paramLong + "], infoLogs[" + (String)localObject + "]");
        }
        j = 0;
        if (j < paramArrayList.size())
        {
          localObject = (ioa)paramArrayList.get(j);
          str1 = String.valueOf(((ioa)localObject).uin);
          m = ((ioa)localObject).videoSrcType;
          bool2 = ((ioa)localObject).Tp;
          i = -1;
          if (ivz.this.mUinType == 3000)
          {
            i = 1004;
            str2 = ivz.this.mApp.getDisplayName(i, str1, String.valueOf(ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().ll));
            if ((!((ioa)localObject).isRender) || (ivz.this.jdField_a_of_type_ComTencentAvVideoController.sz())) {
              break label721;
            }
            if (str1.equals(ivz.this.mApp.getCurrentAccountUin())) {
              break label520;
            }
            iwb localiwb = ivz.this.jdField_a_of_type_Iwb;
            if ((((ioa)localObject).mk != 5L) && (((ioa)localObject).mk != 14L)) {
              break label514;
            }
            bool1 = true;
            label263:
            localiwb.b(str1, m, true, bool2, bool1);
            i = 0;
          }
        }
      }
      for (;;)
      {
        label280:
        if (i == 0) {
          if ((!((ioa)localObject).isRender) && (!((ioa)localObject).Tp) && (k != 4))
          {
            if (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().relationType != 2) {
              break label551;
            }
            anot.a(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
          }
        }
        for (;;)
        {
          ivz.this.jdField_a_of_type_Iwb.a(str1, m, ivz.this.bp, ((ioa)localObject).isRender, ((ioa)localObject).Tp);
          if (!ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().Qw)
          {
            float f = jll.dp2px(ivz.this.mContext, 12.0F);
            if (!str1.equals(ivz.this.mApp.getCurrentAccountUin())) {
              ivz.this.jdField_a_of_type_Iwb.a(str1, m, str2, f, -1);
            }
            ivz.this.jdField_a_of_type_Iwb.at(str1, m);
          }
          j += 1;
          break;
          if (ivz.this.mUinType == 1)
          {
            i = 1000;
            break label156;
          }
          if (ivz.this.mUinType != 0) {
            break label156;
          }
          i = 0;
          break label156;
          label514:
          bool1 = false;
          break label263;
          label520:
          ivz.this.b.ca(paramLong);
          ivz.this.jdField_a_of_type_Iwb.d(true, bool2);
          i = 1;
          break label280;
          label551:
          anot.a(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
        }
        paramArrayList = ivz.this.jdField_a_of_type_Iwb;
        i = ivz.this.auI;
        if (ivz.this.jdField_a_of_type_Ixr == null) {}
        for (bool1 = true;; bool1 = ivz.this.jdField_a_of_type_Ixr.VW)
        {
          paramArrayList.F(i, bool1);
          i = ivz.this.auI;
          j = ivz.this.mDisplay.getRotation();
          if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
            ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.setRotation((i + j * 90) % 360);
          }
          if (ivz.this.b != null) {
            ivz.this.b.setRotation(ivz.this.auI);
          }
          return;
        }
        label721:
        i = 0;
      }
    }
    
    protected void jM(String paramString)
    {
      if ((paramString != null) && (paramString.equals("1")) && (!ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().QG))
      {
        ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().hX(true);
        ivz.a(ivz.this, 2);
      }
    }
    
    protected void o(boolean paramBoolean, long paramLong)
    {
      if (ivz.this.auG == 2) {}
      do
      {
        return;
        if ((ivz.this.b != null) && (!ivz.this.mApp.sM())) {
          ivz.this.b.ca(paramLong);
        }
      } while (ivz.this.jdField_a_of_type_Iwb == null);
      ivz.this.jdField_a_of_type_Iwb.d(true, paramBoolean);
      ivz.this.jdField_a_of_type_Iwb.R(paramLong, ivz.this.b.isFrontCamera());
    }
  }
  
  public class b
    extends iiz
  {
    b() {}
    
    protected void G(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.G(paramBoolean1, paramBoolean2);
      }
    }
    
    protected void H(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 1, "WL_DEBUG showRedPacketFloatWinAni isSend = " + paramBoolean1 + ", show=" + paramBoolean2);
      }
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) {}
      for (Object localObject = null;; localObject = ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1))
      {
        if (localObject != null)
        {
          if (!paramBoolean2) {
            break;
          }
          ivz.this.a((ViewGroup)localObject, paramBoolean1);
        }
        return;
      }
      ivz.d((ViewGroup)localObject);
    }
    
    protected void T(String paramString, int paramInt)
    {
      ivz.this.ct(paramInt);
    }
    
    protected void U(String paramString, int paramInt)
    {
      if (paramInt != ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().ann) {
        QLog.d("SmallScreenVideoController", 1, "setGlassWaitTime nTime=" + paramInt + ", mCurrentVideoGlassWaitTime=" + ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().ann);
      }
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().ann = paramInt;
    }
    
    protected void U(String paramString, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "[random room owner] onDestroyUI isQuit = " + paramBoolean + ", mSessionType = " + ivz.this.mSessionType);
      }
      super.U(paramString, paramBoolean);
      if ((ivz.this.mApp != null) && (ivz.this.mApp.getHandler() != null)) {
        ivz.this.mApp.getHandler().postDelayed(new SmallScreenVideoController.MyVideoObserver.1(this, paramString, paramBoolean), 1500L);
      }
    }
    
    protected void V(String paramString, boolean paramBoolean)
    {
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.V(paramString, paramBoolean);
      }
      ZimuToolbar.sendSupportionToPeer(ivz.this.jdField_a_of_type_ComTencentAvVideoController);
      if ((ivz.this.jdField_a_of_type_Iwb != null) && (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().PZ))
      {
        paramString = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
        paramBoolean = ivz.this.jdField_a_of_type_ComTencentAvVideoController.cl(ivz.this.mPeerUin);
        ivz.this.jdField_a_of_type_Iwb.aa(paramString, paramBoolean);
      }
      jdh.b(ivz.this.jdField_a_of_type_ComTencentAvVideoController);
    }
    
    protected void a(RecvMsg paramRecvMsg)
    {
      super.a(paramRecvMsg);
      if ((ivz.this.jdField_a_of_type_Iwb != null) && (ivz.this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        ivz.this.jdField_a_of_type_Iwb.f(0, 0, true);
      }
    }
    
    protected void aR(String paramString1, String paramString2)
    {
      super.aR(paramString1, paramString2);
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.aR(paramString1, paramString2);
      }
    }
    
    protected void amT()
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenVideoController", 1, "onPauseVideo, seq[" + l + "]");
      }
      if (ivz.this.jdField_a_of_type_Iwb != null)
      {
        ivz.a(ivz.this, 1);
        String str = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
        ivz.this.jdField_a_of_type_Iwb.b(str, 1, false, false, ivz.this.jdField_a_of_type_ComTencentAvVideoController.cl(ivz.this.mPeerUin));
      }
      if ((ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1011) && (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().PY))
      {
        ivz.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.f(l, true);
        if (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().anf == 3) {
          ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().anf = 0;
        }
      }
    }
    
    protected void amU()
    {
      super.amU();
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.amU();
      }
    }
    
    protected void amV()
    {
      super.amV();
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.amV();
      }
    }
    
    protected void amZ()
    {
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.amZ();
      }
    }
    
    protected void ana()
    {
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.ana();
      }
    }
    
    protected void bQ(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenVideoController", 1, "onConnected, seq[" + paramLong + "]");
      }
      ikp.kQ(32);
      if (ivz.this.jdField_a_of_type_Iwb != null) {
        ivz.this.jdField_a_of_type_Iwb.avB();
      }
      Object localObject;
      if (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 2)
      {
        localObject = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b();
        if (ivz.this.VD) {
          break label338;
        }
      }
      label338:
      for (boolean bool = true;; bool = false)
      {
        ((iiv)localObject).n(paramLong, bool);
        if (ivz.this.VD) {
          ivz.this.mApp.l(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        }
        if (ivz.this.jdField_a_of_type_Iwb != null)
        {
          localObject = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
          bool = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().PZ;
          ivz.this.jdField_a_of_type_Iwb.b((String)localObject, 1, bool, false, ivz.this.jdField_a_of_type_ComTencentAvVideoController.cl(ivz.this.mPeerUin));
        }
        if (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().amI == 1) {
          ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().n(paramLong, false);
        }
        if (ivz.this.jdField_a_of_type_Iwb != null) {
          ivz.this.jdField_a_of_type_Iwb.f(0, 0, true);
        }
        if (ivz.this.mApp.isBackground_Stop) {
          ivz.this.jdField_a_of_type_ComTencentAvVideoController.alx();
        }
        if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.onConnected();
        }
        ZimuToolbar.sendSupportionToPeer(ivz.this.jdField_a_of_type_ComTencentAvVideoController);
        jdh.b(ivz.this.jdField_a_of_type_ComTencentAvVideoController);
        return;
      }
    }
    
    protected void bR(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenVideoController", 1, "onResumeVideo, seq[" + paramLong + "]");
      }
      if (ivz.this.jdField_a_of_type_Iwb != null)
      {
        String str = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin;
        ivz.this.jdField_a_of_type_Iwb.b(str, 1, true, false, ivz.this.jdField_a_of_type_ComTencentAvVideoController.cl(ivz.this.mPeerUin));
        ivz.this.jdField_a_of_type_Iwb.a(ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin, 1, ivz.this.bp, true, false);
      }
    }
    
    protected void c(long paramLong, int paramInt, String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenVideoController", 1, "onClose, reason[" + paramInt + "], peerUin[" + paramString + "], seq[" + paramLong + "]");
      }
      if (!TextUtils.equals(paramString, ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().peerUin)) {}
      do
      {
        return;
        ivz.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.f(paramLong, false);
        if (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().uinType == 1011)
        {
          ivz.this.jdField_a_of_type_Iwb.b(paramString, 1, false, false, ivz.this.jdField_a_of_type_ComTencentAvVideoController.cl(ivz.this.mPeerUin));
          ivz.this.jdField_a_of_type_Iwb.d(false, false);
          ivz.this.jdField_a_of_type_Iwb.arv();
        }
      } while (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null);
      ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.lP(paramInt);
    }
    
    protected void hF(boolean paramBoolean)
    {
      super.hF(paramBoolean);
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.hF(paramBoolean);
      }
    }
    
    public void iE(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onRequestVideoMode fromUin = " + paramString);
      }
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().anf = 2;
      ivz.this.onClick();
    }
    
    public void ic(String paramString)
    {
      long l = AudioHelper.hG();
      QLog.w("SmallScreenVideoController", 1, "onAcceptVideoMode, fromUin[" + paramString + "], seq[" + l + "]");
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().anf = 3;
      ivz.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.ca(l);
      if (ivz.this.jdField_a_of_type_Iwb != null)
      {
        ivz.this.jdField_a_of_type_Iwb.d(true, false);
        ivz.this.jdField_a_of_type_Iwb.R(l, ivz.this.jdField_b_of_type_ComTencentAvCameraCameraUtils.isFrontCamera());
      }
    }
    
    public void id(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onRejectVideoMode fromUin = " + paramString);
      }
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().anf = 0;
    }
    
    protected void ie(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onCancelVideoMode fromUin = " + paramString);
      }
      super.ie(paramString);
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().anf = 0;
    }
    
    protected void kJ(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate receive id:" + paramInt);
      }
      int i = aqwu.getResourceType();
      Object localObject = aqwu.a(ivz.this.mApp, paramInt, i, null);
      if (localObject == null) {}
      do
      {
        return;
        localObject = new File((String)localObject);
        if ((localObject != null) && (((File)localObject).exists()) && (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().state != 4) && (ivz.this.mSessionType == 1) && (ivz.this.jdField_a_of_type_Iwb != null)) {
          ivz.this.jdField_a_of_type_Iwb.avC();
        }
      } while (!QLog.isColorLevel());
      QLog.d("SmallScreenVideoController", 2, "yiler onPlayAnnimate finish id:" + paramInt);
    }
    
    protected void kn(int paramInt)
    {
      super.kn(paramInt);
      if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.cv(paramInt);
      }
    }
    
    protected void onFinish(String paramString, boolean paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "peerUin = " + paramString + " # isQuit :" + paramBoolean);
      }
      if ((ivz.this.mSessionType == 1) || (ivz.this.mSessionType == 2))
      {
        if ((ivz.this.mPeerUin != null) && (paramString != null) && (ivz.this.mPeerUin.equals(paramString)))
        {
          ivz.this.Ox = paramBoolean;
          ivz.this.finish();
        }
        if (ivz.this.jdField_a_of_type_Iwb != null)
        {
          paramString = aqmj.j(ivz.this.mContext).edit();
          paramString.putInt("video_position", ivz.this.jdField_a_of_type_Iwb.getPosition());
          paramString.commit();
        }
      }
    }
    
    protected void r(long paramLong, int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.w("SmallScreenVideoController", 1, "onDetectNoDevicePermission, DeviceType[" + paramInt + "], seq[" + paramLong + "]");
      }
      if ((paramInt == 2) || (paramInt == 1))
      {
        ivz.this.jdField_b_of_type_Iya.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(paramLong) });
        paramLong = Long.valueOf(ivz.this.mApp.getCurrentAccountUin()).longValue();
        paramInt = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().b(paramLong, 1);
        if (paramInt != -1) {}
      }
      else
      {
        return;
      }
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().jdField_if.remove(paramInt);
      synchronized (ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().ig)
      {
        paramInt = ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().c(paramLong, 1);
        if (paramInt == -1) {
          return;
        }
      }
      ivz.this.jdField_a_of_type_ComTencentAvVideoController.b().ig.remove(paramInt);
    }
  }
  
  class c
    extends ixr
  {
    public c(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public void E(int paramInt, boolean paramBoolean)
    {
      int j = 0;
      try
      {
        i = (ivz.this.mDisplay.getRotation() * 90 + paramInt) % 360;
        if (ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          ivz.this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.setRotation(i);
        }
        if (ivz.this.jdField_a_of_type_Iwb != null) {
          ivz.this.jdField_a_of_type_Iwb.F(paramInt, paramBoolean);
        }
        if (ivz.this.b != null) {
          ivz.this.b.setRotation(paramInt);
        }
        ivz.this.auI = paramInt;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("SmallScreenVideoController", 2, "onVideoOrientationChanged e = " + localException);
            i = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivz
 * JD-Core Version:    0.7.0.1
 */