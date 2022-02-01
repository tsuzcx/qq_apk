import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.e;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.QIMStoryEffectCameraCaptureUnit.1;
import dov.com.qq.im.QIMStoryEffectCameraCaptureUnit.2;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.StoryImageToastView;
import dov.com.qq.im.capture.view.StoryTextToastView;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout.a;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class awsy
  extends QIMEffectCameraCaptureUnit
  implements QIMCameraStoryCaptureButtonLayout.a
{
  public static long Mp = -1L;
  public static HashSet<Integer> bV = new HashSet();
  public static String cSx;
  public static boolean dsn;
  public static boolean dso;
  public StoryImageToastView a;
  private StoryTextToastView a;
  public QIMCameraStoryCaptureButtonLayout a;
  public HashSet<Integer> bW = new HashSet();
  public long dj;
  public boolean drj;
  private BroadcastReceiver mReceiver;
  
  public awsy(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
    this.byT = 3;
  }
  
  private void XD(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.XD(paramBoolean);
    if (this.Gm.getTranslationY() != 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.c(this.Gm, null);
      }
    }
    else {
      return;
    }
    this.Gm.setTranslationY(0.0F);
    this.Gm.setAlpha(1.0F);
  }
  
  private void XE(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.XE(paramBoolean);
    if (this.Gm.getTranslationY() == 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.d(this.Gm, null);
      }
    }
    else {
      return;
    }
    this.Gm.setTranslationY(-this.Gm.getHeight());
    this.Gm.setAlpha(0.0F);
  }
  
  private void cN(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.putExtra("show_story_msg_tab", true);
    localIntent.setFlags(335544320);
    paramActivity.startActivity(localIntent);
  }
  
  private void eFN()
  {
    Activity localActivity = getActivity();
    if ((localActivity != null) && (localActivity.getIntent().getIntExtra("key_finish_jump_to_page", 1) == 0))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("back_when_cancel_from_shot", true);
      localActivity.setResult(0, localIntent);
    }
  }
  
  private void eu(Intent paramIntent)
  {
    Activity localActivity = getActivity();
    if (localActivity != null) {}
    switch (localActivity.getIntent().getIntExtra("key_finish_jump_to_page", 1))
    {
    default: 
      return;
    case 0: 
    case 1: 
      localActivity.setResult(-1, paramIntent);
      localActivity.finish();
      return;
    case 2: 
      cN(localActivity);
      localActivity.finish();
      return;
    }
    paramIntent = localActivity.getIntent().getStringExtra("web_dispatch_event");
    if (!TextUtils.isEmpty(paramIntent))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("*");
      aija.a(paramIntent, null, localArrayList, null);
    }
    localActivity.finish();
  }
  
  public static void gD(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("dov.com.qq.im.finish_capture_action");
    localIntent.setPackage("com.tencent.mobileqq");
    paramContext.sendBroadcast(localIntent);
  }
  
  public int QD()
  {
    return this.eCw;
  }
  
  public int Qv()
  {
    return 5;
  }
  
  public int Qw()
  {
    int i = 0;
    int k = this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras().getInt("capture_intent_mode", 0);
    int j = axqq.lM(k);
    boolean bool = this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.or(j);
    if (!bool) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMStoryEffectCameraCaptureUnit", 2, "getIntentCaptureMode intentIndex:" + k + ", isSupport:" + bool);
      }
      return i;
      i = j;
    }
  }
  
  public void Xp(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryEffectCameraCaptureUnit", 2, new Object[] { "handleSegmentCaptureMode", Boolean.valueOf(paramBoolean) });
    }
    if (this.cAD != paramBoolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setSegmentMode(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dLa();
      if (paramBoolean)
      {
        this.cAD = true;
        this.eI.set(true);
      }
    }
    else
    {
      return;
    }
    this.cAD = false;
    this.LX.clear();
    this.LY.clear();
    if (this.drt) {
      Xq(false);
    }
    this.eI.set(false);
  }
  
  public void Xr(boolean paramBoolean)
  {
    super.Xr(paramBoolean);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(paramBoolean);
  }
  
  public void Xu(boolean paramBoolean)
  {
    super.Xu(paramBoolean);
    if (paramBoolean)
    {
      this.hS.setAlpha(0.0F);
      this.yh.setVisibility(0);
      if ((this.jdField_a_of_type_Axoo != null) && (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.dwg)) {
        this.jdField_a_of_type_Axoo.apk();
      }
      if (this.LR != null) {
        this.LR.setVisibility(4);
      }
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Oq(true);
      eFJ();
      return;
    }
    this.hS.setAlpha(1.0F);
    this.jdField_a_of_type_Axoo.eNp();
    if (this.LR != null) {
      this.LR.setVisibility(0);
    }
    this.c.setFaceEffect("");
    this.LO.setVisibility(8);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Oq(false);
    eFI();
  }
  
  public void Xv(boolean paramBoolean)
  {
    super.Xv(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
  }
  
  public void Xw(boolean paramBoolean)
  {
    super.Xw(paramBoolean);
    ImageView localImageView = this.HK;
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.5F)
    {
      localImageView.setAlpha(f);
      return;
    }
  }
  
  protected CameraCaptureView.e a()
  {
    CameraCaptureView.e locale = super.a();
    locale.Ow(false);
    return locale;
  }
  
  public GuideVideoView a(Activity paramActivity, MqqHandler paramMqqHandler)
  {
    return new GuideVideoView(paramActivity, paramMqqHandler);
  }
  
  public void a(int paramInt, axqo paramaxqo)
  {
    super.a(paramInt, paramaxqo);
    int i = paramaxqo.PQ();
    paramaxqo = rar.bY(QC());
    bV.add(Integer.valueOf(paramaxqo));
    if ((i == 2) || (i == 4) || (i == 5))
    {
      Mp = System.currentTimeMillis();
      if (!this.drj)
      {
        this.drj = true;
        if (this.aBw == -1L) {
          break label143;
        }
      }
    }
    label143:
    for (paramInt = (int)(Mp - this.aBw);; paramInt = 0)
    {
      paramaxqo = "3";
      if (i == 5) {
        paramaxqo = "4";
      }
      if (i == 4) {
        paramaxqo = "5";
      }
      rar.a("time_waitshoot", 10002, paramInt, new String[] { "", paramaxqo, "", "" });
      return;
    }
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    boolean bool = this.dru;
    super.a(paramLocalMediaInfo, paramBoolean);
    ThreadManager.getUIHandler().post(new QIMStoryEffectCameraCaptureUnit.2(this, paramBoolean, bool));
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.d("QIMStoryEffectCameraCaptureUnit", 2, "onVideoCaptured final");
    }
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().stopPlayAudio();
    boolean bool1;
    boolean bool2;
    label64:
    boolean bool3;
    label75:
    boolean bool4;
    if (this.jdField_b_of_type_Aybv.mEntranceType != 102)
    {
      bool1 = true;
      if (this.jdField_b_of_type_Aybv.mEntranceType == 102) {
        break label419;
      }
      bool2 = true;
      if (this.eCw == 5) {
        break label425;
      }
      bool3 = true;
      if (this.eCw == 5) {
        eFP();
      }
      if ((this.jdField_b_of_type_Aybv.th() == 108) || (!this.cAD)) {
        break label431;
      }
      bool4 = true;
      label109:
      Bundle localBundle = this.jdField_a_of_type_Aycb.getActivity().getIntent().getExtras();
      Object localObject = new ayby.a().a(false).e(bool1).f(bool2).g(true).h(bool4).i(bool3).c(QC()).j(true);
      this.jdField_b_of_type_Aybv.a(((ayby.a)localObject).b());
      if (!this.cAD) {
        break label437;
      }
      i = 2;
      label195:
      localBundle.putInt("extra_transiton_src_from", i);
      localBundle.putString("extra_text_filter_text", this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getCurrentText());
      localObject = this.jdField_a_of_type_Aycb.getActivity().getIntent();
      i = j;
      if (this.cAD) {
        i = 2;
      }
      ((Intent)localObject).putExtra("extra_transiton_src_from", i);
      aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramVideoCaptureResult, paramLocalMediaInfo, this.jdField_b_of_type_Aybv, this.bO, this.byT, localBundle);
      if (!dsn)
      {
        dsn = true;
        rar.a("clk_mode", 10002, 0, new String[] { ShortVideoUtils.a(bV), "0", "", "" });
      }
      if (!dso)
      {
        dso = true;
        if (Mp == -1L) {
          break label442;
        }
      }
    }
    label419:
    label425:
    label431:
    label437:
    label442:
    for (int i = (int)(System.currentTimeMillis() - Mp);; i = 0)
    {
      rar.a("time_shoot", 10002, i, new String[] { rar.bY(QC()), String.valueOf(paramLocalMediaInfo.mDuration), "", "" });
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label64;
      bool3 = false;
      break label75;
      bool4 = false;
      break label109;
      i = -1;
      break label195;
    }
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    super.a(paramh);
    boolean bool1;
    boolean bool2;
    label34:
    boolean bool3;
    label45:
    boolean bool4;
    if (this.jdField_b_of_type_Aybv.mEntranceType != 102)
    {
      bool1 = true;
      if (this.jdField_b_of_type_Aybv.mEntranceType == 102) {
        break label301;
      }
      bool2 = true;
      if (this.eCw == 5) {
        break label307;
      }
      bool3 = true;
      if (this.eCw == 5) {
        break label313;
      }
      bool4 = true;
      label56:
      Object localObject = new aybw.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is()).b(bool1).c(bool2).d(true).a(bool4).e(bool3).c(QC()).a(11).b();
      this.jdField_b_of_type_Aybv.a((aybw)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putString("extra_text_filter_text", this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().getCurrentText());
      aywz.a(this.jdField_a_of_type_Aycb.getActivity(), paramh, this.jdField_b_of_type_Aybv, this.bO, this.byT, (Bundle)localObject);
      if (!dsn)
      {
        dsn = true;
        rar.a("clk_mode", 10002, 0, new String[] { ShortVideoUtils.a(bV), "0", "", "" });
      }
      if (!dso)
      {
        dso = true;
        if (Mp == -1L) {
          break label319;
        }
      }
    }
    label301:
    label307:
    label313:
    label319:
    for (int i = (int)(System.currentTimeMillis() - Mp);; i = 0)
    {
      rar.a("time_shoot", 10002, i, new String[] { rar.bY(QC()), "0", "", "" });
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label34;
      bool3 = false;
      break label45;
      bool4 = false;
      break label56;
    }
  }
  
  public void adi(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      Xp(true);
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.hide();
      return;
    case 2: 
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.hide();
      return;
    case 3: 
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.a(acfp.m(2131711256)).a(2130845513).show(false);
      return;
    case 4: 
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.a(acfp.m(2131711263)).a(2130845512).show(false);
      return;
    case 5: 
      this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.hide();
      return;
    }
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.hide();
  }
  
  public void cN(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
    if (!paramBoolean1)
    {
      paramBoolean2 = true;
      ((CameraCaptureView)localObject).cAF = paramBoolean2;
      localObject = this.jdField_a_of_type_Axoo;
      if (paramBoolean1) {
        break label206;
      }
      paramBoolean2 = true;
      label30:
      ((axoo)localObject).YL(paramBoolean2);
      if (!paramBoolean1) {
        break label211;
      }
      if (this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.dwg) {
        this.jdField_a_of_type_Axoo.apk();
      }
      coy();
      eFo();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
      this.eZ.setVisibility(0);
      if (this.drm) {
        this.HK.setVisibility(0);
      }
      XB(false);
      this.yh.setVisibility(0);
      if ((this.nQ != null) && (this.LR != null))
      {
        this.nQ.removeView(this.LR);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131367583);
        i = rpq.dip2px(this.jdField_a_of_type_Aycb.getActivity(), 88.0F);
        this.LR.setTranslationY(i);
        this.nQ.addView(this.LR, (ViewGroup.LayoutParams)localObject);
        this.LR.bringToFront();
      }
    }
    label206:
    label211:
    do
    {
      return;
      paramBoolean2 = false;
      break;
      paramBoolean2 = false;
      break label30;
      this.jdField_a_of_type_Axoo.eNp();
      cox();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setEnabled(true);
      this.HK.setEnabled(true);
      this.HK.setAlpha(1.0F);
      XB(true);
    } while ((this.nQ == null) || (this.LR == null));
    this.nQ.removeView(this.LR);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131373718);
    int i = rpq.dip2px(this.jdField_a_of_type_Aycb.getActivity(), 88.0F);
    this.LR.setTranslationY(i);
    this.nQ.addView(this.LR, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.eNX();
  }
  
  public void cO(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.aRx()) {
      XD(true);
    }
  }
  
  public void cP(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.eCw == 5)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().Zj(paramBoolean2);
      this.HK.setVisibility(0);
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
        break label174;
      }
    }
    label174:
    for (int i = (int)(System.currentTimeMillis() - this.aBw);; i = 0)
    {
      rar.a("time_waitshoot", 10002, i, new String[] { "", "0", "", "" });
      if (!this.bW.contains(Integer.valueOf(this.eCw)))
      {
        this.bW.add(Integer.valueOf(this.eCw));
        rar.a("start_shoot", 10002, 0, new String[] { rar.bY(QC()), "0", "", cSx });
      }
      return;
    }
  }
  
  public void coB()
  {
    if (this.eCw == 5)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().eQh();
      this.yh.setVisibility(0);
      this.HK.setVisibility(0);
    }
    super.coB();
  }
  
  public void coy()
  {
    super.coy();
  }
  
  public void coz()
  {
    super.coz();
    if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.aRw()) || (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.aRx())) {
      rar.a("clk_shoot", rar.ea(alwx.dyy), 1, new String[0]);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new QIMStoryEffectCameraCaptureUnit.1(this));
      return;
      rar.a("clk_shoot", rar.ea(alwx.dyy), 3, new String[0]);
    }
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
        break label174;
      }
    }
    label174:
    for (int i = (int)(System.currentTimeMillis() - this.aBw);; i = 0)
    {
      rar.a("time_waitshoot", 10002, i, new String[] { "", "0", "", "" });
      if (!this.bW.contains(Integer.valueOf(this.eCw)))
      {
        this.bW.add(Integer.valueOf(this.eCw));
        rar.a("start_shoot", 10002, 0, new String[] { rar.bY(QC()), "0", "", cSx });
      }
      return;
    }
  }
  
  protected void eEW()
  {
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout = ((QIMCameraStoryCaptureButtonLayout)this.rootView.findViewById(2131364256));
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.a(this, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setCaptureStatusChangeListener(this);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout;
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout;
    this.jdField_b_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout = this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout;
    ((ViewStub)this.rootView.findViewById(2131374665)).inflate();
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView = ((StoryImageToastView)this.rootView.findViewById(2131374664));
    this.jdField_a_of_type_DovComQqImCaptureViewStoryTextToastView = ((StoryTextToastView)this.rootView.findViewById(2131374655));
  }
  
  public void eFO()
  {
    Mp = System.currentTimeMillis();
    if (!this.bW.contains(Integer.valueOf(this.eCw)))
    {
      this.bW.add(Integer.valueOf(this.eCw));
      rar.a("start_shoot", 10002, 0, new String[] { rar.bY(QC()), "0", "", cSx });
    }
  }
  
  /* Error */
  void eFP()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	awsy:jdField_a_of_type_DovComQqImCaptureModeCaptureModeController	Ldov/com/qq/im/capture/mode/CaptureModeController;
    //   4: invokevirtual 512	dov/com/qq/im/capture/mode/CaptureModeController:a	()Laycm;
    //   7: invokevirtual 841	aycm:Io	()Ljava/lang/String;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +231 -> 243
    //   15: new 843	java/io/File
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 845	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 848	java/io/File:exists	()Z
    //   26: ifeq +217 -> 243
    //   29: new 850	android/media/MediaMetadataRetriever
    //   32: dup
    //   33: invokespecial 851	android/media/MediaMetadataRetriever:<init>	()V
    //   36: astore 4
    //   38: sipush 5000
    //   41: istore_1
    //   42: aload 4
    //   44: aload_3
    //   45: invokevirtual 854	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   48: aload 4
    //   50: bipush 9
    //   52: invokevirtual 857	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   55: invokestatic 861	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   58: istore_2
    //   59: iload_2
    //   60: istore_1
    //   61: aload 4
    //   63: invokevirtual 864	android/media/MediaMetadataRetriever:release	()V
    //   66: new 866	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo
    //   69: dup
    //   70: invokespecial 867	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:<init>	()V
    //   73: astore 4
    //   75: aload 4
    //   77: iconst_1
    //   78: putfield 870	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   81: aload 4
    //   83: aload_3
    //   84: invokevirtual 873	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:setPath	(Ljava/lang/String;)V
    //   87: aload 4
    //   89: ldc_w 874
    //   92: invokestatic 662	acfp:m	(I)Ljava/lang/String;
    //   95: putfield 877	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mMusicName	Ljava/lang/String;
    //   98: aload 4
    //   100: ldc_w 386
    //   103: putfield 880	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mSingername	Ljava/lang/String;
    //   106: aload 4
    //   108: aconst_null
    //   109: putfield 883	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mUrl	Ljava/lang/String;
    //   112: aload 4
    //   114: aconst_null
    //   115: putfield 886	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mTagName	Ljava/lang/String;
    //   118: aload 4
    //   120: iconst_0
    //   121: putfield 889	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicStart	I
    //   124: aload 4
    //   126: iload_1
    //   127: putfield 892	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:musicDuration	I
    //   130: aload 4
    //   132: aconst_null
    //   133: putfield 895	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mSongMid	Ljava/lang/String;
    //   136: aload 4
    //   138: ldc_w 896
    //   141: putfield 900	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mRecognitionOffset	F
    //   144: aload 4
    //   146: iconst_0
    //   147: putfield 903	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mHasCopyright	Z
    //   150: aload 4
    //   152: iconst_0
    //   153: putfield 906	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mAccuracy	I
    //   156: aload 4
    //   158: aconst_null
    //   159: putfield 909	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:jumpWs	Ljava/lang/String;
    //   162: aload_0
    //   163: getfield 582	awsy:bO	Landroid/os/Bundle;
    //   166: ldc_w 911
    //   169: invokevirtual 915	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   172: astore_3
    //   173: aload_3
    //   174: ldc_w 917
    //   177: invokevirtual 922	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   180: invokevirtual 915	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   183: astore 5
    //   185: aload 5
    //   187: ldc_w 924
    //   190: aload 4
    //   192: invokevirtual 928	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   195: aload 5
    //   197: ldc_w 930
    //   200: aload 4
    //   202: invokevirtual 933	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:getLocalPath	()Ljava/lang/String;
    //   205: invokevirtual 578	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 5
    //   210: ldc_w 935
    //   213: aload_0
    //   214: getfield 209	awsy:eCw	I
    //   217: invokevirtual 569	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   220: aload_3
    //   221: ldc_w 917
    //   224: invokevirtual 922	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   227: aload 5
    //   229: invokevirtual 939	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   232: aload_0
    //   233: getfield 582	awsy:bO	Landroid/os/Bundle;
    //   236: ldc_w 911
    //   239: aload_3
    //   240: invokevirtual 939	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   243: return
    //   244: astore 5
    //   246: aload 4
    //   248: invokevirtual 864	android/media/MediaMetadataRetriever:release	()V
    //   251: goto -185 -> 66
    //   254: astore_3
    //   255: aload 4
    //   257: invokevirtual 864	android/media/MediaMetadataRetriever:release	()V
    //   260: aload_3
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	awsy
    //   41	86	1	i	int
    //   58	2	2	j	int
    //   10	230	3	localObject1	Object
    //   254	7	3	localObject2	Object
    //   36	220	4	localObject3	Object
    //   183	45	5	localBundle	Bundle
    //   244	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   42	59	244	java/lang/Exception
    //   42	59	254	finally
  }
  
  public void eFQ()
  {
    XE(true);
    if (this.eCw == 5)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().eQH();
      this.HK.setVisibility(8);
    }
  }
  
  protected void eFc()
  {
    super.eFc();
    Xp(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setLockStatus(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setSegment(false);
  }
  
  public void eFi()
  {
    super.eFi();
    XD(false);
  }
  
  public void eFm()
  {
    if ((this.LX.size() == 0) || (this.LY.size() == 0))
    {
      if (this.cAD) {
        Xp(false);
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setSegment(false);
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setEnableSegment(true);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setLockStatus(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.ZZ(false);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setDrawCenterCircle(true);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.setCurrentAnimatorValue(1.0F);
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.hide();
    super.eFm();
  }
  
  public void eFp()
  {
    super.eFp();
    coA();
    this.yh.clearAnimation();
    this.yh.setVisibility(8);
    this.HK.setVisibility(8);
  }
  
  public void eFq()
  {
    super.eFq();
    this.jdField_a_of_type_Axoo.eNy();
    eFb();
  }
  
  public void eFr()
  {
    super.eFr();
    this.jdField_a_of_type_Axoo.apk();
    this.jdField_a_of_type_Axoo.onResume();
    coy();
    this.eZ.setVisibility(0);
    this.yh.setVisibility(0);
    if (this.drm) {
      this.HK.setVisibility(0);
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.onResume();
  }
  
  public ArrayList<Integer> eG()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(5));
    localArrayList.add(Integer.valueOf(0));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131561134;
  }
  
  public void nW(long paramLong)
  {
    super.nW(paramLong);
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    int k = localActivity.getIntent().getIntExtra("entrance_type", 1);
    String str;
    Object localObject2;
    int i;
    if (localActivity.getIntent().hasExtra("pendingIntentClass"))
    {
      str = "1";
      localObject2 = "0";
      int j = 0;
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
        QLog.e("QIMStoryEffectCameraCaptureUnit", 2, new Object[] { "checkSelfPermission ", Boolean.valueOf(bool1), " ", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool3) });
      }
      catch (Exception localException)
      {
        boolean bool1;
        boolean bool2;
        boolean bool3;
        localObject1 = "4";
        QLog.e("QIMStoryEffectCameraCaptureUnit", 1, "checkSelfPermission error, ", localException);
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
      rar.a("time_openshoot", 10002, i, new String[] { str, localObject1, "", String.valueOf(k) });
      if (anfe.akQ != 0L)
      {
        anfe.akR = System.currentTimeMillis();
        QLog.d("CAM_START_MONITOR", 1, new Object[] { "story cost: ", Long.valueOf(anfe.akR - anfe.akI), "\nStartClick cost: ", Long.valueOf(anfe.akI - anfe.akH), "\nStartActiv cost: ", Long.valueOf(anfe.akJ - anfe.akI), "\nStartProce cost: ", Long.valueOf(anfe.akK - anfe.akJ), "\nCreateBase cost: ", Long.valueOf(anfe.akL - anfe.akK), "\nCreateQimA cost: ", Long.valueOf(anfe.akM - anfe.akL), "\nStartBaseA cost: ", Long.valueOf(anfe.akN - anfe.akM), "\nStartQimAc cost: ", Long.valueOf(anfe.akO - anfe.akN), "\nResumeBase cost: ", Long.valueOf(anfe.akP - anfe.akO), "\nResumeQimA cost: ", Long.valueOf(anfe.akQ - anfe.akP), "\nFirstFrame cost: ", Long.valueOf(anfe.akR - anfe.akQ), "\nPeakCreatS cost: ", Long.valueOf(anfe.akS - anfe.akK), "\nPeakCreatT cost: ", Long.valueOf(anfe.akT - anfe.akS) });
      }
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
  
  public void onActivityPause()
  {
    super.onActivityPause();
    rar.R(1, this.dj);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.eCw == 5) {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().E(paramInt1, paramInt2, paramIntent);
    }
    if (paramIntent != null)
    {
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.BUNDLE_EXTRA_KEY);
      if (localPublishParam != null) {
        paramIntent.putExtra("new_video_extra_info", localPublishParam.thumbPath);
      }
      this.jdField_a_of_type_Aycb.getActivity().setResult(paramInt2, paramIntent);
    }
    if ((paramInt2 == -1) && ((paramInt1 == 10002) || (paramInt1 == 1012) || (paramInt1 == 10006))) {
      eu(paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    this.dj = SystemClock.uptimeMillis();
    super.onActivityResume();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.onResume();
    this.jdField_a_of_type_DovComQqImCaptureViewStoryImageToastView.hide();
    String str = rar.bY(QC());
    bV.add(Integer.valueOf(str));
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
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraStoryCaptureButtonLayout.aRx()) {
      return false;
    }
    eFN();
    boolean bool = super.onBackPressed();
    if ((!this.drj) && (bool))
    {
      this.drj = true;
      if (this.aBw == -1L) {
        break label153;
      }
    }
    label153:
    for (int i = (int)(System.currentTimeMillis() - this.aBw);; i = 0)
    {
      rar.a("time_waitshoot", 10002, i, new String[] { "", "1", "", "" });
      if ((!dsn) && (bool))
      {
        dsn = true;
        rar.a("clk_mode", 10002, 0, new String[] { ShortVideoUtils.a(bV), "1", "", "" });
      }
      return bool;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.eCw != 5) || (!this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().aQp())) {
        if (!this.drq) {
          break;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("entrance_type", 1);
    this.jdField_b_of_type_Aybv = new aybv(10002, i, 1);
    super.onCreate(paramBundle);
    if (i == 104) {
      rar.a("video_shoot_fromweb", "exp_cam", 0, 0, new String[0]);
    }
    if (i == 18) {
      rar.a("video_shoot_new", "shoot_exp", 1, 0, new String[] { "", "", "", "18" });
    }
    Mp = -1L;
    dsn = false;
    bV = new HashSet();
    cSx = String.valueOf(i);
    dso = false;
    long l = this.jdField_a_of_type_Aycb.getActivity().getIntent().getLongExtra("TIMESTAMP_START_ACTIVITY", 0L);
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
  }
  
  public View onCreateView()
  {
    View localView = super.onCreateView();
    this.yh.setOnClickListener(this);
    this.c.setIntercepPreviewCheck(true);
    if (this.eCw == 5)
    {
      coy();
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(8);
    }
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mReceiver != null) {}
    try
    {
      this.jdField_a_of_type_Aycb.getActivity().unregisterReceiver(this.mReceiver);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awsy
 * JD-Core Version:    0.7.0.1
 */