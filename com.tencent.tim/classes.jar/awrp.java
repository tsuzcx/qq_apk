import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class awrp
  extends QIMEffectCameraCaptureUnit
{
  public static long Mp = -1L;
  private SessionWrap a;
  private String cSm;
  private String cSn;
  private boolean drh;
  private boolean dri = false;
  public boolean drj = false;
  private int eCt;
  
  public awrp(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.jdField_b_of_type_Aybv = new aybv(10000, 100, 2);
    this.byT = 1;
    eER();
  }
  
  public static Bundle a(SessionWrap paramSessionWrap, String paramString, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putInt("edit_video_type", paramInt1);
    localBundle.putInt("entrance_type", paramInt2);
    localBundle.putString("ARG_AIO_CLASS", paramString);
    if (paramInt1 == 10000) {
      localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    }
    localBundle.putBoolean("enable_local_video", false);
    return localBundle;
  }
  
  public static Bundle a(SessionWrap paramSessionWrap, String paramString1, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("ARG_SESSION_INFO", paramSessionWrap);
    localBundle.putInt("edit_video_type", paramInt1);
    localBundle.putInt("entrance_type", paramInt2);
    localBundle.putString("ARG_AIO_CLASS", paramString1);
    localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
    localBundle.putBoolean("enable_local_video", false);
    localBundle.putBoolean("ARG_UNFOLD_DD", paramBoolean);
    localBundle.putInt("ARG_DD_CATEGORY_ID", paramInt3);
    localBundle.putString("ARG_DD_ITEM_ID", paramString2);
    return localBundle;
  }
  
  private void eER()
  {
    int i = getActivity().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", -1);
    String str = getActivity().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    axip.a().eI(i, str);
    str = getActivity().getIntent().getStringExtra("intent_key_uid_for_report");
    axip.a().setUin(str);
    axip.a().Yl(true);
    axip.a().eLr();
    axip.a().eLs();
    axip.a().acR(axbk.bS(getActivity()));
    axim.a().eLh();
  }
  
  public int Qv()
  {
    if (this.jdField_a_of_type_DovComQqImAeSessionWrap.cZ == 0) {
      return 1;
    }
    if ((this.jdField_a_of_type_DovComQqImAeSessionWrap.cZ == 3000) || (this.jdField_a_of_type_DovComQqImAeSessionWrap.cZ == 1)) {
      return 2;
    }
    return 3;
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    j(paramLocalMediaInfo);
    ayby localayby = new ayby.a().c(true).e(false).a(true).l(true).b(1).b();
    this.jdField_b_of_type_Aybv.a(localayby);
    aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_b_of_type_Aybv, this.bO, this.byT);
    rar.a("clk_shoot", rar.ea(this.jdField_b_of_type_Aybv.RI()), 3, false, new String[0]);
    axip.a().ob(2L);
    axim.a().oa(paramLocalMediaInfo.mDuration);
    rar.a("check_beacon_Android", 14, 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    super.a(paramh);
    aybw localaybw = new aybw.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is()).a(this.jdField_a_of_type_DovComQqImAeSessionWrap).a(this.cSm).a(1).b(106).b();
    this.jdField_b_of_type_Aybv.a(localaybw);
    aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramh, this.jdField_b_of_type_Aybv, this.bO, this.byT);
    rar.a("clk_shoot", rar.ea(this.jdField_b_of_type_Aybv.RI()), 1, false, new String[0]);
    axip.a().ob(1L);
    axim.a().oa(-1L);
    rar.a("check_beacon_Android", 14, 0, new String[] { String.valueOf(UserAction.getQIMEI()) });
  }
  
  protected void a(CameraCaptureView paramCameraCaptureView)
  {
    if (paramCameraCaptureView != null) {
      paramCameraCaptureView.Ot(true);
    }
  }
  
  public void acW(int paramInt)
  {
    if (this.f != null) {
      this.f.setVisibility(8);
    }
  }
  
  public void bST()
  {
    super.bST();
    axvu.a.ay(3, System.currentTimeMillis());
    axvu.eOW();
    if (anfe.akQ != 0L)
    {
      anfe.akR = System.currentTimeMillis();
      QLog.d("CAM_START_MONITOR", 1, new Object[] { "aio cost: ", Long.valueOf(anfe.akR - anfe.akI), "\nStartClick cost: ", Long.valueOf(anfe.akI - anfe.akH), "\nStartActiv cost: ", Long.valueOf(anfe.akJ - anfe.akI), "\nStartProce cost: ", Long.valueOf(anfe.akK - anfe.akJ), "\nCreateBase cost: ", Long.valueOf(anfe.akL - anfe.akK), "\nCreateQimA cost: ", Long.valueOf(anfe.akM - anfe.akL), "\nStartBaseA cost: ", Long.valueOf(anfe.akN - anfe.akM), "\nStartQimAc cost: ", Long.valueOf(anfe.akO - anfe.akN), "\nResumeBase cost: ", Long.valueOf(anfe.akP - anfe.akO), "\nResumeQimA cost: ", Long.valueOf(anfe.akQ - anfe.akP), "\nFirstFrame cost: ", Long.valueOf(anfe.akR - anfe.akQ), "\nPeakCreatS cost: ", Long.valueOf(anfe.akS - anfe.akK), "\nPeakCreatT cost: ", Long.valueOf(anfe.akT - anfe.akS) });
    }
  }
  
  public void coA()
  {
    if (this.eCw == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().eQg();
    }
    super.coA();
    Mp = System.currentTimeMillis();
    if (!this.drj)
    {
      this.drj = true;
      if (this.aBw == -1L) {
        break label106;
      }
    }
    label106:
    for (int i = (int)(System.currentTimeMillis() - this.aBw);; i = 0)
    {
      rar.a("video_shoot_new", "time_waitshoot", rar.ea(10000), i, new String[] { "", "0", "", "" });
      return;
    }
  }
  
  public void coy()
  {
    super.coy();
    this.yh.setVisibility(8);
  }
  
  public void dKK()
  {
    if (this.eCw == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().eQi();
    }
    super.dKK();
    Mp = System.currentTimeMillis();
    if (!this.drj)
    {
      this.drj = true;
      if (this.aBw == -1L) {
        break label106;
      }
    }
    label106:
    for (int i = (int)(System.currentTimeMillis() - this.aBw);; i = 0)
    {
      rar.a("video_shoot_new", "time_waitshoot", rar.ea(10000), i, new String[] { "", "0", "", "" });
      return;
    }
  }
  
  public void eES()
  {
    Bundle localBundle = this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras();
    this.drh = localBundle.getBoolean("ARG_UNFOLD_DD", false);
    this.eCt = localBundle.getInt("ARG_DD_CATEGORY_ID");
    this.cSn = localBundle.getString("ARG_DD_ITEM_ID");
    this.dri = localBundle.getBoolean("input_full_screen_mode");
  }
  
  public int getLayoutId()
  {
    return 2131561111;
  }
  
  protected List<View> hE()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.yh);
    return localArrayList;
  }
  
  public void initContainerView()
  {
    super.initContainerView();
    if (this.drh) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.S(102, this.eCt, this.cSn);
    }
  }
  
  public void nW(long paramLong)
  {
    int j = 0;
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    int k = localActivity.getIntent().getIntExtra("entrance_type", 1);
    String str;
    Object localObject2;
    int i;
    if (localActivity.getIntent().hasExtra("pendingIntentClass"))
    {
      str = "1";
      localObject2 = "0";
      i = j;
      if (this.aBw != -1L)
      {
        i = j;
        if (str.equals("0")) {
          i = (int)(paramLong - this.aBw);
        }
      }
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT < 23) {}
    }
    for (;;)
    {
      try
      {
        if (localActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
          continue;
        }
        bool1 = true;
        if (localActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
          continue;
        }
        bool2 = true;
        if (localActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
          continue;
        }
        bool3 = true;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AIOEffectsCameraCaptureFragment", 2, new Object[] { "checkSelfPermission ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool3) });
      }
      catch (Exception localException)
      {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        localObject1 = "4";
        QLog.e("AIOEffectsCameraCaptureFragment", 1, "checkSelfPermission error, ", localException);
        continue;
        if ((bool1) || (bool2)) {
          continue;
        }
        localObject1 = localException;
        if (!bool3) {
          continue;
        }
        continue;
      }
      localObject1 = "";
      if (bool1) {
        localObject1 = "".concat("1");
      }
      localObject2 = localObject1;
      if (bool2) {
        localObject2 = ((String)localObject1).concat(",3");
      }
      localObject1 = localObject2;
      if (bool3) {
        localObject1 = ((String)localObject2).concat(",2");
      }
      rar.a("video_shoot_new", "time_openshoot", rar.ea(10000), i, new String[] { str, localObject1, "", String.valueOf(k) });
      return;
      str = "0";
      break;
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      bool3 = false;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = false;
    if ((paramIntent != null) && (this.jdField_a_of_type_DovComQqImAeSessionWrap != null)) {
      paramIntent.putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_DovComQqImAeSessionWrap.c());
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10000) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.Xx(false);
      awtf.a(this.jdField_a_of_type_Aycb.getActivity(), paramIntent, this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_Ayca, null);
    }
    while ((paramInt1 != 1012) || (paramInt2 != -1)) {
      return;
    }
    if (paramIntent != null) {}
    for (String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");; str = "")
    {
      boolean bool1 = bool2;
      if (paramIntent != null)
      {
        bool1 = bool2;
        if (paramIntent.getBooleanExtra("input_full_screen_mode", false)) {
          bool1 = true;
        }
      }
      paramIntent = new Intent();
      paramIntent.putExtra("input_full_screen_mode_result", str);
      paramIntent.putExtra("input_full_screen_mode", bool1);
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
      return;
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    axvu.a.ay(2, System.currentTimeMillis());
    if (anfe.akI != 0L)
    {
      anfe.akQ = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONRESUME ", Long.valueOf(anfe.akQ) });
    }
  }
  
  public void onActivityStart()
  {
    super.onActivityStart();
    if (anfe.akI != 0L)
    {
      anfe.akO = System.currentTimeMillis();
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONSTART ", Long.valueOf(anfe.akO) });
    }
  }
  
  public boolean onBackPressed()
  {
    boolean bool = super.onBackPressed();
    if ((!this.drj) && (bool))
    {
      this.drj = true;
      if (this.aBw == -1L) {
        break label88;
      }
    }
    label88:
    for (int i = (int)(System.currentTimeMillis() - this.aBw);; i = 0)
    {
      rar.a("video_shoot_new", "time_waitshoot", rar.ea(10000), i, new String[] { "", "1", "", "" });
      return bool;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = ((SessionWrap)this.jdField_a_of_type_Aycb.getActivity().getIntent().getParcelableExtra("ARG_SESSION_INFO"));
    this.cSm = this.jdField_a_of_type_Aycb.getActivity().getIntent().getStringExtra("ARG_AIO_CLASS");
    paramBundle = this.jdField_a_of_type_Aycb.getActivity().getIntent();
    long l = paramBundle.getLongExtra("ACTIVITY_START_TIME", -1L);
    int i = paramBundle.getIntExtra("edit_video_type", 10000);
    if ((axvu.dwM) && (i == 10000)) {}
    for (boolean bool = true;; bool = false)
    {
      axvu.dwN = bool;
      if (axvu.dwN)
      {
        axvu.a.startMonitor();
        axvu.a.ay(0, l);
        axvu.a.ay(1, System.currentTimeMillis());
      }
      l = this.jdField_a_of_type_Aycb.getActivity().getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L);
      if (l != 0L)
      {
        anfe.akK = QLog.sInitLogTime;
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_PEAK_ATTACH ", Long.valueOf(anfe.akK) });
        anfe.akH = this.jdField_a_of_type_Aycb.getActivity().getIntent().getLongExtra("TIMESTAMP_PRELOAD_PEAK", 0L);
        anfe.akI = this.jdField_a_of_type_Aycb.getActivity().getIntent().getLongExtra("TIMESTAMP_CLICK_CAMERA", 0L);
        anfe.akJ = l;
        anfe.akM = System.currentTimeMillis();
        QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_ONCREATE ", Long.valueOf(anfe.akM) });
      }
      return;
    }
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    this.yh.setOnClickListener(this);
    if (this.dri) {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setFunctionFlag(2);
    }
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axip.a().Yl(false);
    anhi.a(this.drz, this.cSp, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.frameCount, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is(), this.jdField_c_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.auX(), this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.ahT, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dzo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrp
 * JD-Core Version:    0.7.0.1
 */