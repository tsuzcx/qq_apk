package dov.com.qq.im;

import acfp;
import alwn;
import alwp;
import alwq;
import alwx;
import alwy;
import alxg;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anhq;
import anjo;
import anki;
import ankq;
import anot;
import awrq;
import awrz;
import awsa;
import awsb;
import awsc;
import awsd;
import awse;
import awsf;
import awsg;
import awsh;
import awsi;
import awsz;
import awte;
import axom;
import axoo;
import axov;
import axpa;
import axpk;
import axpr;
import axqo;
import axro;
import axsu;
import axvu;
import axvv;
import axxe;
import aybv;
import ayca;
import aycb;
import aycm;
import aypi;
import aytu;
import ayva;
import ayva.c;
import aywa;
import ayzs;
import azbh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.b;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.h;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.c;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.e;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import com.tencent.mobileqq.shortvideo.dancemachine.DisplayUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager;
import com.tencent.mobileqq.shortvideo.filter.QQDanceEventHandler;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.CosFunHelper;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil.SHADER_TYPE;
import com.tencent.ttpic.openapi.view.LazyLoadAnimationDrawable;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.mode.CaptureModeController;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.capture.view.QIMProviderContainerView.b;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.a;
import dov.com.tencent.mobileqq.richmedia.capture.view.BeautyBar.a;
import dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager.c;
import dov.com.tencent.mobileqq.richmedia.capture.view.GuideVideoView;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import rar;
import rpq;
import wja;

@TargetApi(9)
public abstract class QIMEffectCameraCaptureUnit
  extends awrq
  implements ayva.c, CameraCaptureView.b, EffectsCameraCaptureView.c, EffectsCameraCaptureView.e, QQDanceEventHandler, QIMProviderContainerView.b, VideoFilterViewPager.a, BeautyBar.a, CaptureVideoFilterViewPager.c
{
  private static boolean byq = true;
  public static boolean drT;
  public static boolean drV;
  private Animation.AnimationListener A = new awsa(this);
  private Animation.AnimationListener B = new awsb(this);
  private Animation.AnimationListener C = new awsc(this);
  public AlphaAnimation D = new AlphaAnimation(1.0F, 0.0F);
  public AlphaAnimation E = new AlphaAnimation(0.0F, 1.0F);
  public AlphaAnimation F = new AlphaAnimation(1.0F, 0.0F);
  private ImageView HM;
  private ImageView HN;
  ImageView HO;
  private ImageView HP;
  private View LP;
  protected View LQ;
  protected View LR;
  protected List<Integer> LZ = new ArrayList();
  protected alwn a;
  protected alwp a;
  protected alwq a;
  protected axoo a;
  private final ReplayTips jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit$ReplayTips = new ReplayTips(null);
  QIMFilterCategoryItem jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = null;
  private ProviderViewEditContainer jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer;
  public VideoFilterViewPager a;
  private GuideVideoView jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView;
  private TextView agH;
  private TextView agI;
  private TextView agJ;
  private TextView agK;
  private TextView agL;
  private TextView agM;
  private TextView agN;
  public QIMProviderContainerView b;
  private ObjectAnimator bL;
  protected Bundle bO;
  private ObjectAnimator bR;
  public EffectsCameraCaptureView c;
  private boolean cAW;
  public boolean cAX = true;
  public boolean cAi = true;
  public boolean cAj = true;
  public boolean cAk = true;
  protected String cSq;
  protected String cSr;
  protected String cSs;
  public Handler cf = new awsd(this, Looper.getMainLooper());
  private boolean drE;
  private boolean drF;
  private boolean drG;
  private boolean drH;
  private boolean drI = true;
  private boolean drJ;
  private boolean drK;
  private boolean drL;
  private boolean drM;
  private boolean drN;
  private boolean drO = true;
  public boolean drP = true;
  public boolean drQ = true;
  public boolean drR = true;
  public volatile boolean drS;
  private boolean drU;
  private boolean drW;
  private boolean drX;
  private boolean drY;
  private boolean drZ;
  private boolean dsa;
  protected int eCA;
  private int eCB = 0;
  private int eCC;
  private int eCD = 50;
  private int eCE;
  private int eCz = -1;
  protected RedDotImageView f;
  protected ViewGroup fa;
  public Runnable iG;
  private Runnable iH;
  protected String mName;
  protected String mSourceName;
  protected String mText;
  protected String mUrl;
  private LinearLayout mp;
  protected String overPercent;
  private Map<String, String> qv = new HashMap();
  private Map<String, String> qw = new HashMap();
  protected String scoreRate;
  protected TextView yh;
  
  public QIMEffectCameraCaptureUnit(aycb paramaycb, ayca paramayca)
  {
    super(paramaycb, paramayca);
  }
  
  private void XA(boolean paramBoolean)
  {
    Message localMessage = this.cf.obtainMessage(1000, Boolean.valueOf(paramBoolean));
    this.cf.sendMessageDelayed(localMessage, 2000L);
  }
  
  private void Xy(boolean paramBoolean)
  {
    if ((this.drI) || (this.f.rL()))
    {
      this.drI = false;
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.a(this.f);
    }
    ThreadManager.excute(new QIMEffectCameraCaptureUnit.3(this, paramBoolean), 64, null, true);
  }
  
  private void Xz(boolean paramBoolean)
  {
    int i;
    ObjectAnimator localObjectAnimator;
    if (this.HO != null)
    {
      if (paramBoolean) {
        break label146;
      }
      if (this.eCB != 1) {
        break label118;
      }
      if (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.aPV()) {
        break label108;
      }
      this.HO.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "visible == false, Container opened operation invisible");
      }
      i = DisplayUtils.pixelToRealPixel(98.0F);
      this.eCB = 2;
      localObjectAnimator = ObjectAnimator.ofFloat(this.HO, "translationX", new float[] { this.HO.getTranslationX(), i });
      localObjectAnimator.setDuration(500L);
      localObjectAnimator.start();
    }
    label108:
    label118:
    label255:
    do
    {
      do
      {
        do
        {
          return;
          this.eCB = 3;
          i = 0;
          break;
        } while ((this.eCB != 3) || (this.bR == null));
        this.bR.start();
        this.eCB = 2;
        return;
        if ((!this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.aPV()) || (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.getVisibility() != 0)) {
          break label255;
        }
        this.HO.setVisibility(0);
        if (this.eCB == 0)
        {
          localObjectAnimator = ObjectAnimator.ofFloat(this.HO, "translationX", new float[] { 0.0F, DisplayUtils.pixelToRealPixel(-139.0F) });
          localObjectAnimator.setDuration(500L);
          localObjectAnimator.start();
          this.eCB = 1;
          return;
        }
      } while ((this.eCB != 2) || (this.bL == null));
      this.bL.start();
      this.eCB = 3;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "visible == true, Container opened operation invisible");
      }
      this.HO.setVisibility(8);
    } while ((this.eCB != 3) || (this.bR == null));
    label146:
    this.bR.start();
    this.eCB = 2;
  }
  
  private void a(LazyLoadAnimationDrawable paramLazyLoadAnimationDrawable)
  {
    stopAnim();
    if (paramLazyLoadAnimationDrawable == null) {
      return;
    }
    this.iH = new QIMEffectCameraCaptureUnit.13(this);
    this.cf.post(new QIMEffectCameraCaptureUnit.14(this, paramLazyLoadAnimationDrawable));
  }
  
  private void adc(int paramInt)
  {
    if (paramInt == 0) {
      this.agN.setText(acfp.m(2131711199));
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        this.agN.setText(acfp.m(2131711197));
        return;
      }
    } while (paramInt != 2);
    this.agN.setText(acfp.m(2131711198));
  }
  
  private void dP(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.F.setAnimationListener(null);
      this.F.cancel();
      this.agM.clearAnimation();
      this.agM.setVisibility(8);
      return;
    }
    this.F.reset();
    this.agM.setVisibility(0);
    this.agM.setText(paramString);
    this.F.setAnimationListener(this.A);
    this.F.setStartOffset(2000L);
    this.F.setDuration(200L);
    this.agM.setAnimation(this.F);
    this.F.startNow();
  }
  
  private void eFA()
  {
    this.cf.post(new QIMEffectCameraCaptureUnit.28(this));
  }
  
  private void eFB()
  {
    this.drW = false;
    coB();
  }
  
  private void eFC()
  {
    this.HP = new ImageView(this.fa.getContext());
    int i = DisplayUtils.pixelToRealPixel(47.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.topMargin = DisplayUtils.pixelToRealPixel(110.0F);
    localLayoutParams.rightMargin = DisplayUtils.pixelToRealPixel(40.0F);
    localLayoutParams.addRule(11, -1);
    this.HP.setVisibility(8);
    this.HP.setEnabled(false);
    this.HP.setImageResource(2130846904);
    this.HP.setOnClickListener(new awsi(this));
    if (aNB())
    {
      if (this.dro) {
        this.nQ.addView(this.HP, localLayoutParams);
      }
    }
    else {
      return;
    }
    this.fa.addView(this.HP, localLayoutParams);
  }
  
  private void eFD()
  {
    this.agN = ((TextView)this.fa.findViewById(2131365577));
  }
  
  private void eFE()
  {
    if (!this.drZ) {
      return;
    }
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.aRi()) && (this.drO)) {}
    for (int i = 1;; i = 0)
    {
      this.LP.setVisibility(8);
      this.agH.setVisibility(8);
      if (i == 0) {
        break;
      }
      this.agI.setVisibility(8);
      return;
    }
    eFF();
  }
  
  private void eFF()
  {
    this.dsa = true;
    this.agI.setVisibility(0);
    this.agI.setText(2131720283);
    XA(true);
  }
  
  private void eFv()
  {
    this.agK.setText("");
    this.HN.setImageBitmap(null);
    this.mp.setVisibility(8);
  }
  
  private void eFw()
  {
    if (this.HO != null)
    {
      this.HO.clearAnimation();
      this.HO.setVisibility(8);
      this.HO = null;
    }
  }
  
  private void eFz()
  {
    if (this.drY) {
      return;
    }
    if (this.dro) {
      this.bottom_blackLH.setVisibility(4);
    }
    if (QLog.isColorLevel()) {
      QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "now showDGVideoGuide and animation,  mGuideVideoView : " + this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView == null)
    {
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView = a(this.jdField_a_of_type_Aycb.getActivity(), ThreadManager.getUIHandler());
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCloseListener(new awsf(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnCompleteListener(new awsg(this));
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.setOnErrorListener(new awsh(this));
    }
    Object localObject = (ViewGroup)this.rootView;
    ((ViewGroup)localObject).removeView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView);
    this.HP.setVisibility(8);
    this.HP.setEnabled(false);
    localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(500L);
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.clearAnimation();
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.startAnimation((Animation)localObject);
    this.drY = true;
  }
  
  private void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.drE = true;
    this.drF = paramBoolean1;
    this.drG = paramBoolean2;
    this.drH = paramBoolean3;
    this.cAW = paramBoolean4;
    if (this.drZ)
    {
      if (!this.dsa) {
        eFF();
      }
      return;
    }
    int j;
    label72:
    boolean bool;
    label98:
    int i;
    if ((this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager != null) && (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.aRi()) && (this.drO))
    {
      j = 1;
      bool = paramBoolean1;
      if (paramBoolean1)
      {
        if ((!aNy()) || (!this.c.auW())) {
          break label172;
        }
        paramBoolean1 = true;
        bool = paramBoolean1;
      }
      if ((!bool) || (paramBoolean3)) {
        break label177;
      }
      i = 0;
    }
    for (;;)
    {
      dP(null, false);
      if (i == 0)
      {
        if ((bool) && (!paramBoolean2))
        {
          if (j != 0)
          {
            this.LP.setVisibility(8);
            this.agH.setVisibility(8);
            this.agI.setVisibility(8);
            return;
            j = 0;
            break label72;
            label172:
            paramBoolean1 = false;
            break label98;
            label177:
            if ((!bool) && (paramBoolean3))
            {
              i = 1;
              continue;
            }
            if ((!bool) || (!paramBoolean3)) {
              break label532;
            }
            i = 2;
            continue;
          }
          this.LP.setVisibility(0);
          this.agH.setVisibility(0);
          this.agH.setText(2131693775);
          this.agI.setVisibility(8);
          return;
        }
        if ((bool) && (paramBoolean2))
        {
          this.LP.setVisibility(8);
          this.agH.setVisibility(8);
          this.agI.setVisibility(8);
          String str = this.c.yJ();
          if ((TextUtils.isEmpty(str)) || (this.drJ)) {
            break;
          }
          this.drJ = true;
          dP(str, true);
          return;
        }
        this.LP.setVisibility(8);
        this.agH.setVisibility(8);
        this.agI.setVisibility(8);
        return;
      }
      if (i == 1)
      {
        this.LP.setVisibility(8);
        this.agH.setVisibility(8);
        this.agI.setVisibility(8);
        return;
      }
      if (i != 2) {
        break;
      }
      if (paramBoolean4)
      {
        this.LP.setVisibility(8);
        this.agH.setVisibility(8);
        this.agI.setVisibility(8);
        return;
      }
      if ((!paramBoolean4) && (paramBoolean2))
      {
        this.LP.setVisibility(8);
        this.agH.setVisibility(8);
        this.agI.setVisibility(8);
        return;
      }
      if ((paramBoolean4) || (paramBoolean2)) {
        break;
      }
      if (j != 0)
      {
        this.LP.setVisibility(8);
        this.agH.setVisibility(8);
        this.agI.setVisibility(8);
        return;
      }
      this.LP.setVisibility(0);
      this.agH.setText(2131693775);
      this.agH.setVisibility(0);
      this.agI.setVisibility(8);
      return;
      label532:
      i = 0;
    }
  }
  
  private void stopAnim()
  {
    if (this.iH != null)
    {
      this.cf.removeCallbacks(this.iH);
      this.iH = null;
    }
    this.cf.post(new QIMEffectCameraCaptureUnit.15(this));
  }
  
  public void CT(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (!drV)
    {
      drV = true;
      this.jdField_a_of_type_Aycb.getActivity().runOnUiThread(new QIMEffectCameraCaptureUnit.7(this));
      return;
    }
    this.jdField_a_of_type_Aycb.getActivity().runOnUiThread(new QIMEffectCameraCaptureUnit.8(this));
  }
  
  public void OB(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.4(this));
    eFu();
    int i = this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("edit_video_type", 10002);
    PeakAppInterface.a.y(axpk.cVE, new Object[] { this, Integer.valueOf(i) });
  }
  
  public void OC(boolean paramBoolean)
  {
    this.drZ = paramBoolean;
    this.dsa = false;
    this.cf.removeMessages(1000);
    eFE();
  }
  
  public void OD(boolean paramBoolean)
  {
    if (this.agL != null) {
      this.jdField_a_of_type_Aycb.getActivity().runOnUiThread(new QIMEffectCameraCaptureUnit.5(this, paramBoolean));
    }
  }
  
  public void Oy(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.11(this, paramBoolean));
  }
  
  public int QC()
  {
    if ((this instanceof awsz)) {
      return 6;
    }
    return this.eCw;
  }
  
  protected int Qv()
  {
    return 7;
  }
  
  public void XB(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwr);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwm);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwq);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwo);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwn);
      GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwp);
      return;
    }
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwr);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwm);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwq);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwo);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwn);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwp);
  }
  
  public void Xq(boolean paramBoolean)
  {
    super.Xq(paramBoolean);
    if (this.jdField_a_of_type_Axoo != null) {
      this.jdField_a_of_type_Axoo.YJ(paramBoolean);
    }
    if (!paramBoolean)
    {
      this.LZ.clear();
      axro localaxro = (axro)axov.a().c(8);
      if (localaxro != null) {
        localaxro.a(localaxro.b(), true, 0);
      }
    }
  }
  
  public void Xs(boolean paramBoolean)
  {
    if (paramBoolean) {
      eFn();
    }
    View localView = this.Gm;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void Xt(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      eFn();
      this.Gm.setVisibility(4);
      return;
    }
    this.Gm.setVisibility(0);
  }
  
  public IntentFilter a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("new_qq_android_native_short_filter_");
    localIntentFilter.addAction("new_qq_android_native_ptu_res_");
    return localIntentFilter;
  }
  
  protected GuideVideoView a(Activity paramActivity, MqqHandler paramMqqHandler)
  {
    return new GuideVideoView(paramActivity, paramMqqHandler);
  }
  
  public void a(int paramInt, axqo paramaxqo)
  {
    super.a(paramInt, paramaxqo);
    if (!paramaxqo.aPA()) {
      resumeMusic();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Axoo != null) {
        this.jdField_a_of_type_Axoo.setIsGuideMode(paramaxqo.aPA());
      }
      eFw();
      return;
      Zx();
    }
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    this.jdField_a_of_type_Axoo.eNy();
    this.bO = axom.a(this.jdField_a_of_type_Axoo);
    super.a(paramVideoCaptureResult);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((axvu.dwO) && (paramLocalMediaInfo.mDuration > 0L))
    {
      File localFile = new File(paramLocalMediaInfo.path);
      if (localFile.exists()) {
        paramLocalMediaInfo.fileSize = (localFile.length() / 1024L);
      }
      float f1 = paramVideoCaptureResult.videoFrameCount / (float)paramLocalMediaInfo.mDuration;
      rar.a("CamRecordFreq", true, 0L, new String[] { String.valueOf(this.jdField_b_of_type_Aybv.EP), String.valueOf(f1 * 1000.0F), String.valueOf(paramLocalMediaInfo.fileSize), String.valueOf(paramLocalMediaInfo.mDuration), rar.bY(QC()) });
    }
    this.jdField_b_of_type_Aybv.aeY(QC());
    anhq.a().PK(false);
  }
  
  public void a(CameraCaptureView.h paramh)
  {
    this.bO = axom.a(this.jdField_a_of_type_Axoo);
    this.jdField_b_of_type_Aybv.aeY(QC());
    this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().eQj();
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onPhotoCaptured");
    }
  }
  
  public void a(QQFilterRenderManager.ChainBuilder paramChainBuilder) {}
  
  public void a(VideoMaterial paramVideoMaterial)
  {
    boolean bool1 = false;
    stopAnim();
    if (paramVideoMaterial == null) {}
    boolean bool2;
    do
    {
      return;
      this.drJ = false;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.AR_PARTICLE.value) {
        bool1 = true;
      }
      bool2 = paramVideoMaterial.isSupportTouchEvent();
    } while (((this.drS) && (bool1)) || ((!this.drS) && (!bool1)));
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.12(this, bool1, bool2));
  }
  
  public boolean aNA()
  {
    boolean bool = false;
    if (!this.drY)
    {
      if (this.drX)
      {
        this.c.dLl();
        bool = true;
      }
      return bool;
    }
    eFA();
    return false;
  }
  
  public boolean aNB()
  {
    return this.eCw != 7;
  }
  
  protected boolean aNy()
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = ((ayzs)axov.a(3)).a();
    if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 7)) {
      return this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is() == 1;
    }
    return true;
  }
  
  public boolean aNz()
  {
    return this.eCw != 7;
  }
  
  public void ac(boolean paramBoolean, String paramString)
  {
    super.ac(paramBoolean, paramString);
    int j = this.c.Is();
    int k = AdvancedProviderView.QU();
    int i = AdvancedProviderView.QV();
    if (QLog.isColorLevel()) {
      QLog.d("sv_beauty_level", 2, "onCameraStarted beauty level : " + k + ", sharp level:" + i);
    }
    this.jdField_a_of_type_Axoo.aev(k);
    paramString = this.jdField_a_of_type_Axoo;
    if (this.c.cAX) {}
    for (;;)
    {
      paramString.aew(i);
      if (this.eCz != j) {
        this.jdField_a_of_type_Axoo.aez(j);
      }
      this.eCz = this.c.Is();
      return;
      i = -1;
    }
  }
  
  public void acW(int paramInt)
  {
    if (this.f != null) {
      this.f.setVisibility(paramInt);
    }
  }
  
  public void ada(int paramInt)
  {
    this.c.setBeauty(paramInt);
  }
  
  public void adb(int paramInt)
  {
    View localView = this.rootView.findViewById(2131367272);
    if ((localView != null) && ((localView instanceof VideoFilterViewPager)))
    {
      ((VideoFilterViewPager)localView).setVisibility(paramInt);
      QLog.i("QIMEffectCameraCaptureUnit", 2, "yes to domVideoFilterViewPager setVisibility: " + paramInt);
    }
  }
  
  public void auC()
  {
    super.auC();
  }
  
  public boolean auZ()
  {
    ayzs localayzs = (ayzs)axov.a(3);
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = localayzs.a();
    if ((localPtvTemplateInfo != null) && (localPtvTemplateInfo.kind == 20))
    {
      localayzs.aq("0", axpa.eGs, "");
      axpa.eGt = 0;
      this.c.setFaceEffect(null);
      return true;
    }
    return false;
  }
  
  public void bST()
  {
    super.bST();
    axpk.dvQ = true;
    nW(System.currentTimeMillis());
  }
  
  public void bSU()
  {
    this.jdField_a_of_type_Axoo.setVisible(8);
    if (this.LR != null) {
      this.LR.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onPhotoCaptureStart");
    }
  }
  
  public void bSV()
  {
    super.bSV();
    if (!this.cAD) {
      this.jdField_a_of_type_Axoo.eNx();
    }
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.9(this));
  }
  
  public boolean bk(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = ayva.a().c(0);
      if ((localObject != null) && (((QIMFilterCategoryItem)localObject).categoryId != 100)) {
        ((axpr)axov.a(5)).a((Activity)getView().getContext(), this, 0);
      }
    }
    int i;
    if (paramBoolean)
    {
      i = 4;
      localObject = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
      if (paramBoolean) {
        break label85;
      }
    }
    label85:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((VideoFilterViewPager)localObject).setEnabled(paramBoolean);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(i);
      return false;
      i = 0;
      break;
    }
  }
  
  public boolean changeDanceStatus(boolean paramBoolean, String paramString)
  {
    this.drX = paramBoolean;
    int i;
    label198:
    Object localObject1;
    boolean bool;
    if (this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "changeDanceStatus " + paramBoolean + " " + paramString);
      }
      if (paramBoolean)
      {
        coy();
        this.HP.setVisibility(0);
        this.HP.setEnabled(true);
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(4);
        if (this.LP.getVisibility() == 0) {
          this.LP.setVisibility(8);
        }
        if (this.agH.getVisibility() == 0) {
          this.agH.setVisibility(8);
        }
        if (this.agI.getVisibility() == 0) {
          this.agI.setVisibility(8);
        }
        this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = ((axpr)axov.a(5)).a((Activity)getView().getContext(), this, 0);
        if ((paramBoolean) && (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is() == 2)) {
          this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dKT();
        }
        if (!paramBoolean) {
          break label514;
        }
        i = 4;
        localObject1 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
        if (paramBoolean) {
          break label519;
        }
        bool = true;
        label211:
        ((VideoFilterViewPager)localObject1).setEnabled(bool);
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(i);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label1033;
      }
      if ((!this.qv.containsKey(paramString)) || (TextUtils.isEmpty((CharSequence)this.qv.get(paramString)))) {
        break label525;
      }
      this.cSq = ((String)this.qv.get(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "has parsed shareWebUrl : " + this.cSq);
      }
      label315:
      if (!this.drY) {
        break label662;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "DGVideoGuide is showing, now start ");
      }
      this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.eUn();
      bool = false;
      if (this.drY) {
        break label1007;
      }
      this.HP.setVisibility(0);
      this.HP.setEnabled(true);
    }
    for (;;)
    {
      for (;;)
      {
        label371:
        if ((this.dro) && (paramBoolean) && (bool)) {
          this.bottom_blackLH.setVisibility(4);
        }
        return bool;
        if ((aNv()) && (!this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.a().aPA())) {
          cox();
        }
        for (;;)
        {
          if (this.eCw != 5) {
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
          }
          this.HP.setVisibility(8);
          this.HP.setEnabled(false);
          if (this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem == null) {
            break;
          }
          ((axpr)axov.a(5)).a((Activity)getView().getContext(), 0, this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem);
          this.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = null;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("QIMEffectCameraCaptureUnit", 2, "changeDanceStatus showButtons deny, is capturing");
          }
        }
        label514:
        i = 0;
        break label198;
        label519:
        bool = false;
        break label211;
        try
        {
          label525:
          localObject1 = new JSONObject(ResourceManager.readFileContent(paramString + "params.json")).getJSONObject("postureParam");
          this.cSq = ((JSONObject)localObject1).getString("shareWebUrl");
          localObject1 = ((JSONObject)localObject1).getString("guideVideoUrl");
          this.qv.put(paramString, this.cSq);
          this.qw.put(paramString, localObject1);
          if (!QLog.isColorLevel()) {
            break label315;
          }
          QLog.d("QIMEffectCameraCaptureUnit", 2, "has not parsed shareWebUrl, now parse  ; " + this.cSq);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      label662:
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      if (this.jdField_b_of_type_Aybv.RI() != 10007)
      {
        bool = localSharedPreferences.getBoolean("hasShowDGVideoGuide", false);
        if (QLog.isColorLevel()) {
          QLog.d("DANCE_MACHINE_GUIDE_VIDEO_VIEW", 2, "hasShowDGVideoGuide : " + bool);
        }
        localObject2 = (ayzs)axov.a(3);
        if (localObject2 == null) {
          break label1027;
        }
      }
      label1027:
      for (Object localObject2 = ((ayzs)localObject2).a();; localObject2 = null)
      {
        if ((!bool) && (aNz()) && ((localObject2 == null) || (((PtvTemplateManager.PtvTemplateInfo)localObject2).kind != 6)))
        {
          eFz();
          if ((this.qw.containsKey(paramString)) && (!TextUtils.isEmpty((CharSequence)this.qw.get(paramString))))
          {
            localObject2 = (String)this.qw.get(paramString);
            paramString = (String)localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("QIMEffectCameraCaptureUnit", 2, "has parsed guideVideoUrl : " + (String)localObject2);
              paramString = (String)localObject2;
            }
          }
          for (;;)
          {
            if (!TextUtils.isEmpty(paramString)) {
              this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.adH(paramString);
            }
            this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.eUm();
            localSharedPreferences.edit().putBoolean("hasShowDGVideoGuide", true).commit();
            bool = false;
            break;
            try
            {
              paramString = new JSONObject(ResourceManager.readFileContent(paramString + "params.json")).getJSONObject("postureParam").getString("guideVideoUrl");
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              paramString = null;
            }
          }
          localSharedPreferences.edit().putBoolean("hasShowDGVideoGuide", true).commit();
        }
        bool = true;
        break;
        label1007:
        this.HP.setVisibility(8);
        this.HP.setEnabled(false);
        break label371;
      }
      label1033:
      bool = true;
    }
  }
  
  public void closeEvent(boolean paramBoolean)
  {
    this.cf.post(new QIMEffectCameraCaptureUnit.24(this, paramBoolean));
  }
  
  public void coA()
  {
    super.coA();
    ((axpr)axov.a(5)).YP(true);
    adb(8);
    if (this.cAD)
    {
      if (this.LZ.size() <= 0) {
        break label99;
      }
      this.jdField_a_of_type_Axoo.YK(true);
      axro localaxro = (axro)axov.a().c(8);
      if (localaxro != null)
      {
        localaxro.setCurrentPosition(((Integer)this.LZ.get(this.LZ.size() - 1)).intValue());
        localaxro.resumeMusic();
      }
    }
    return;
    label99:
    this.jdField_a_of_type_Axoo.eNx();
  }
  
  public void coB()
  {
    super.coB();
    ((axpr)axov.a(5)).YP(false);
    adb(0);
    this.jdField_a_of_type_Axoo.YK(false);
    axro localaxro;
    if (this.cAD)
    {
      localaxro = (axro)axov.a().c(8);
      if (localaxro != null)
      {
        int i = localaxro.getCurrentPosition();
        if (i < 0) {
          break label120;
        }
        this.LZ.add(Integer.valueOf(i));
      }
    }
    for (;;)
    {
      localaxro.Zx();
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onCaptureButtonVideoStop, segmentMusicTimePoints size = " + this.LZ.size());
      }
      return;
      label120:
      if (this.LZ.size() > 0) {
        this.LZ.add(this.LZ.get(this.LZ.size() - 1));
      } else {
        this.LZ.add(Integer.valueOf(0));
      }
    }
  }
  
  public void cox()
  {
    super.cox();
    if ((ankq.awy()) && (ankq.by(getActivity()))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.drR) && (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.getCount() != 0) && (i != 0)) {
        acW(0);
      }
      this.jdField_a_of_type_Axoo.setVisible(0);
      Xz(true);
      this.yh.setVisibility(0);
      if ((this.LR != null) && (this.eCw != 7)) {
        this.LR.setVisibility(0);
      }
      return;
    }
  }
  
  public void coy()
  {
    super.coy();
    acW(4);
    this.agH.setVisibility(8);
    this.agI.setVisibility(8);
    this.jdField_a_of_type_Axoo.setVisible(8);
    Xz(false);
    if (this.LR != null) {
      this.LR.setVisibility(8);
    }
  }
  
  public void dLb()
  {
    if (this.drE) {
      f(this.drF, this.drG, this.drH, this.cAW);
    }
    ThreadManager.getUIHandler().postDelayed(new QIMEffectCameraCaptureUnit.22(this), 300L);
  }
  
  public void dLn() {}
  
  public void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ThreadManager.getUIHandler().post(new QIMEffectCameraCaptureUnit.10(this, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4));
  }
  
  protected void eES() {}
  
  public void eEV()
  {
    if (this.jdField_a_of_type_Axoo != null) {
      this.jdField_a_of_type_Axoo.apk();
    }
    super.eEV();
  }
  
  public void eEX()
  {
    super.eEX();
    this.f = ((RedDotImageView)this.rootView.findViewById(2131381664));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    localLayoutParams.bottomMargin = wja.dp2px(50.0F, this.f.getResources());
    this.f.setLayoutParams(localLayoutParams);
  }
  
  @TargetApi(11)
  protected void eFG()
  {
    if ((this.jdField_a_of_type_Aycb == null) || (this.jdField_a_of_type_Aycb.getActivity() == null)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = this.jdField_a_of_type_Aycb.getActivity().getIntent();
      } while (localObject1 == null);
      localObject1 = ((Intent)localObject1).getExtras();
    } while ((localObject1 == null) || (((Bundle)localObject1).getString("share_url_target_url") == null));
    Object localObject3;
    String str3;
    String str2;
    Object localObject2;
    String str1;
    Object localObject4;
    if (this.mUrl != null)
    {
      localObject3 = this.mUrl;
      str3 = this.mName;
      str2 = this.mText;
      localObject2 = this.cSr;
      str1 = this.mSourceName;
      localObject1 = this.cSs;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initSharedLinkerView : url = ");
        if (localObject3 != null) {
          break label551;
        }
        localObject4 = "null";
        label127:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , name = ");
        if (str3 != null) {
          break label558;
        }
        localObject4 = "null";
        label152:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , text = ");
        if (str2 != null) {
          break label565;
        }
        localObject4 = "null";
        label177:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , thumUrl = ");
        if (localObject2 != null) {
          break label572;
        }
        localObject4 = "null";
        label201:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , sourceName = ");
        if (str1 != null) {
          break label578;
        }
        localObject4 = "null";
        label225:
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , sourceIconUrl = ");
        if (localObject1 != null) {
          break label584;
        }
        localObject4 = "null";
        label249:
        QLog.d("QIMEffectCameraCaptureUnit", 2, (String)localObject4);
      }
      if (this.nQ != null)
      {
        if (this.nQ.findViewById(2131381661) != null) {
          this.nQ.removeView(this.nQ.findViewById(2131381661));
        }
        localObject3 = new aypi((String)localObject3);
        ((aypi)localObject3).zc = str3;
        ((aypi)localObject3).aue = str2;
        ((aypi)localObject3).auf = ((String)localObject2);
        localObject2 = new LinkerSummaryView(this.rootView.getContext());
        ((LinkerSummaryView)localObject2).setReadOnly();
        ((LinkerSummaryView)localObject2).cXN = str1;
        ((LinkerSummaryView)localObject2).cXM = ((String)localObject1);
        ((LinkerSummaryView)localObject2).setShowShare(true);
        ((LinkerSummaryView)localObject2).setLinkerObject((aypi)localObject3);
        this.LR = ((View)localObject2);
        ((LinkerSummaryView)localObject2).setId(2131381661);
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131373718);
        ((LinkerSummaryView)localObject2).setTranslationY(rpq.dip2px(this.jdField_a_of_type_Aycb.getActivity(), 88.0F));
        this.nQ.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        rar.a("video_shoot", "exp_linkbar", 0, 0, new String[] { "", "", "", "" });
        if (this.eCw != 7) {
          break label590;
        }
        this.LR.setVisibility(4);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.eNX();
      return;
      localObject3 = ((Bundle)localObject1).getString("share_url_target_url");
      str3 = ((Bundle)localObject1).getString("share_url_name");
      str2 = ((Bundle)localObject1).getString("share_url_text");
      localObject2 = ((Bundle)localObject1).getString("share_url_thumb_url");
      str1 = ((Bundle)localObject1).getString("struct_share_key_source_name");
      localObject1 = ((Bundle)localObject1).getString("struct_share_key_source_icon");
      break;
      label551:
      localObject4 = localObject3;
      break label127;
      label558:
      localObject4 = str3;
      break label152;
      label565:
      localObject4 = str2;
      break label177;
      label572:
      localObject4 = localObject2;
      break label201;
      label578:
      localObject4 = str1;
      break label225;
      label584:
      localObject4 = localObject1;
      break label249;
      label590:
      this.LR.setVisibility(0);
    }
  }
  
  @TargetApi(11)
  protected void eFH()
  {
    if ((this.jdField_a_of_type_Aycb == null) || (this.jdField_a_of_type_Aycb.getActivity() == null)) {}
    String str3;
    String str2;
    String str1;
    Object localObject4;
    label127:
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = this.jdField_a_of_type_Aycb.getActivity().getIntent();
        } while (localObject1 == null);
        localObject1 = ((Intent)localObject1).getExtras();
      } while ((localObject1 == null) || (((Bundle)localObject1).getString("share_url_target_url") == null));
      if (this.mUrl == null) {
        break;
      }
      localObject3 = this.mUrl;
      str3 = this.mName;
      str2 = this.mText;
      localObject2 = this.cSr;
      str1 = this.mSourceName;
      localObject1 = this.cSs;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("updateSharedLinkerView : url = ");
        if (localObject3 != null) {
          break label512;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , name = ");
        if (str3 != null) {
          break label519;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , text = ");
        if (str2 != null) {
          break label526;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , thumUrl = ");
        if (localObject2 != null) {
          break label533;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , sourceName = ");
        if (str1 != null) {
          break label539;
        }
        localObject4 = "null";
        localStringBuilder = localStringBuilder.append((String)localObject4).append(" , sourceIconUrl = ");
        if (localObject1 != null) {
          break label545;
        }
        localObject4 = "null";
        QLog.d("QIMEffectCameraCaptureUnit", 2, (String)localObject4);
      }
    } while (this.nQ == null);
    label152:
    label177:
    label201:
    label225:
    label249:
    if (this.nQ.findViewById(2131381661) != null) {
      this.nQ.removeView(this.nQ.findViewById(2131381661));
    }
    Object localObject3 = new aypi((String)localObject3);
    ((aypi)localObject3).zc = str3;
    ((aypi)localObject3).aue = str2;
    ((aypi)localObject3).auf = ((String)localObject2);
    Object localObject2 = new LinkerSummaryView(this.rootView.getContext());
    ((LinkerSummaryView)localObject2).setReadOnly();
    ((LinkerSummaryView)localObject2).cXN = str1;
    ((LinkerSummaryView)localObject2).cXM = ((String)localObject1);
    ((LinkerSummaryView)localObject2).setShowShare(true);
    ((LinkerSummaryView)localObject2).setLinkerObject((aypi)localObject3);
    this.LR = ((View)localObject2);
    ((LinkerSummaryView)localObject2).setId(2131381661);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(2, 2131373718);
    ((LinkerSummaryView)localObject2).setTranslationY(rpq.dip2px(this.jdField_a_of_type_Aycb.getActivity(), 88.0F));
    this.nQ.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    if (this.eCw == 7) {
      this.LR.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.eNX();
      return;
      localObject3 = ((Bundle)localObject1).getString("share_url_target_url");
      str3 = ((Bundle)localObject1).getString("share_url_name");
      str2 = ((Bundle)localObject1).getString("share_url_text");
      localObject2 = ((Bundle)localObject1).getString("share_url_thumb_url");
      str1 = ((Bundle)localObject1).getString("struct_share_key_source_name");
      localObject1 = ((Bundle)localObject1).getString("struct_share_key_source_icon");
      break;
      label512:
      localObject4 = localObject3;
      break label127;
      label519:
      localObject4 = str3;
      break label152;
      label526:
      localObject4 = str2;
      break label177;
      label533:
      localObject4 = localObject2;
      break label201;
      label539:
      localObject4 = str1;
      break label225;
      label545:
      localObject4 = localObject1;
      break label249;
      this.LR.setVisibility(0);
    }
  }
  
  public void eFI()
  {
    boolean bool2 = false;
    Object localObject;
    axoo localaxoo;
    int i;
    boolean bool3;
    int j;
    if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView))
    {
      localObject = (EffectsCameraCaptureView)this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
      ((EffectsCameraCaptureView)localObject).setFaceEffect("");
      localaxoo = this.jdField_a_of_type_Axoo;
      if (localaxoo != null)
      {
        if ((!alwy.auM()) || (!ankq.axZ())) {
          break label195;
        }
        i = 1;
        bool3 = ankq.axZ();
        if (anki.axM()) {
          break label200;
        }
        j = 1;
        label68:
        if ((!this.cAi) || (i == 0) || (j == 0)) {
          break label205;
        }
        bool1 = true;
        label85:
        ((EffectsCameraCaptureView)localObject).setBeautyEnable(bool1);
        if ((!bool3) || (j == 0)) {
          break label210;
        }
        bool1 = true;
        label102:
        com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceOpen = bool1;
        if ((!bool3) || (j == 0)) {
          break label215;
        }
      }
    }
    label195:
    label200:
    label205:
    label210:
    label215:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).setSharpFaceEnable(bool1);
      bool1 = bool2;
      if (this.cAk)
      {
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (j != 0) {
            bool1 = true;
          }
        }
      }
      ((EffectsCameraCaptureView)localObject).setFaceEffectEnable(bool1);
      localObject = EffectsCameraCaptureView.b();
      if (localObject != null) {
        ((QQFilterRenderManager)localObject).setFaceDetectFlags(true);
      }
      localaxoo.aev(this.eCD);
      localaxoo.aew(this.eCE);
      return;
      i = 0;
      break;
      j = 0;
      break label68;
      bool1 = false;
      break label85;
      bool1 = false;
      break label102;
    }
  }
  
  public void eFJ()
  {
    this.eCD = AdvancedProviderView.QU();
    this.eCE = AdvancedProviderView.QV();
    if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView instanceof EffectsCameraCaptureView))
    {
      EffectsCameraCaptureView localEffectsCameraCaptureView = (EffectsCameraCaptureView)this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView;
      localEffectsCameraCaptureView.setFaceEffect("");
      axoo localaxoo = this.jdField_a_of_type_Axoo;
      if (localaxoo != null)
      {
        QQFilterRenderManager localQQFilterRenderManager = EffectsCameraCaptureView.b();
        if (localQQFilterRenderManager != null) {
          localQQFilterRenderManager.setFaceDetectFlags(false);
        }
        localaxoo.aev(0);
        localaxoo.aew(-1);
        localEffectsCameraCaptureView.setBeautyEnable(false);
        localEffectsCameraCaptureView.setSharpFaceEnable(false);
        com.tencent.mobileqq.shortvideo.ptvfilter.QQSharpFaceFilter.sSharpFaceOpen = false;
        localEffectsCameraCaptureView.setFaceEffectEnable(false);
      }
    }
  }
  
  public void eFb()
  {
    super.eFb();
    if (this.LZ.size() > 0) {
      this.LZ.remove(this.LZ.size() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureDelete, segmentMusicTimePoints size = " + this.LZ.size());
    }
    this.jdField_a_of_type_Axoo.eNz();
  }
  
  public void eFd()
  {
    super.eFd();
    this.jdField_a_of_type_Axoo.eNt();
  }
  
  public void eFk()
  {
    super.eFk();
    this.jdField_a_of_type_Axoo.eNz();
    if (this.LZ.size() > 0) {
      this.LZ.remove(this.LZ.size() - 1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "[segmentCapture] onSegmentCaptureError, segmentMusicTimePoints size = " + this.LZ.size());
    }
  }
  
  public void eFm()
  {
    super.eFm();
    this.c.dLk();
  }
  
  public void eFn()
  {
    super.eFn();
    if (this.LQ != null) {
      this.LQ.setVisibility(4);
    }
    if (this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(4);
    }
  }
  
  public void eFo()
  {
    super.eFo();
    if (this.LQ != null) {
      this.LQ.setVisibility(0);
    }
    if ((this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer != null) && (this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer.getVisibility() != 0)) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setVisibility(0);
    }
  }
  
  public void eFs()
  {
    this.jdField_a_of_type_Axoo.dLp();
    super.eFs();
    if (this.dro) {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setBottomTabParentLH(this.bottom_blackLH);
    }
    for (;;)
    {
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCaptureControllerAndPreloadView(this.jdField_a_of_type_Axoo);
      if (this.drY) {
        eFA();
      }
      return;
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setBottomTabParentLH(null);
    }
  }
  
  public void eFt()
  {
    Xy(false);
  }
  
  protected void eFu()
  {
    int i = AdvancedProviderView.QU();
    int j = AdvancedProviderView.QV();
    if (QLog.isColorLevel()) {
      QLog.d("sv_beauty_level", 2, "initBeautyAndSharpFace beauty level : " + i + ", sharp level:" + j);
    }
    this.jdField_a_of_type_Axoo.aev(i);
    axoo localaxoo = this.jdField_a_of_type_Axoo;
    if (this.c.cAX) {}
    for (i = AdvancedProviderView.QV();; i = -1)
    {
      localaxoo.aew(i);
      return;
    }
  }
  
  public void eFx() {}
  
  protected void eFy()
  {
    if (!this.drY)
    {
      if (this.drX)
      {
        ((ayzs)axov.a(3)).aq("0", axpa.eGs, "");
        axpa.eGt = 0;
        this.jdField_a_of_type_Axoo.eNA();
        this.c.setFaceEffect("");
        this.drX = false;
        this.cf.removeCallbacks(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit$ReplayTips);
        this.agN.setVisibility(8);
        if (this.dro) {
          this.bottom_blackLH.setVisibility(0);
        }
      }
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.onResume();
  }
  
  public void enterSilhouette() {}
  
  public int getLayoutId()
  {
    return 2131561110;
  }
  
  public void hg(String paramString1, String paramString2)
  {
    if (this.mp != null) {
      this.jdField_a_of_type_Aycb.getActivity().runOnUiThread(new QIMEffectCameraCaptureUnit.6(this, paramString1, paramString2));
    }
  }
  
  protected void initContainerView()
  {
    this.jdField_a_of_type_Axoo.eGZ();
    this.jdField_a_of_type_Axoo.eNq();
  }
  
  protected void j(LocalMediaInfo paramLocalMediaInfo)
  {
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    if (anjo.lC(this.jdField_b_of_type_Aybv.RI()))
    {
      localPtvTemplateInfo = ((ayzs)axov.a(3)).a();
      if ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET)) {
        break label56;
      }
      paramLocalMediaInfo.redBagType = LocalMediaInfo.REDBAG_TYPE_GET;
      QLog.d("QIMEffectCameraCaptureUnit", 1, "VideoRedbag, onVideoCaptured, LocalMediaInfo take redbag flag ");
    }
    label56:
    do
    {
      do
      {
        return;
      } while ((localPtvTemplateInfo == null) || (localPtvTemplateInfo.kind != 5));
      paramLocalMediaInfo.specialVideoType = 2;
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "checkMediaInfoPreJump specialVideoType dancegame!");
  }
  
  public void kR(long paramLong)
  {
    if ((this.jdField_a_of_type_Axoo != null) && (this.jdField_a_of_type_Axoo.a() != null)) {
      this.jdField_a_of_type_Axoo.a().setTimeStamp(paramLong, false);
    }
  }
  
  public void nW(long paramLong)
  {
    long l1;
    if (this.aBw != -1L)
    {
      l1 = this.aBw;
      aytu.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.Is(), paramLong - l1, this.jdField_b_of_type_Aybv.RI() + "", byq);
      byq = false;
    }
    long l2;
    long l3;
    if (axvu.dwO)
    {
      boolean bool = this.jdField_a_of_type_Aycb.getActivity().getIntent().getBooleanExtra("camera_peak_is_alive", false);
      axvu.e.ay(3, paramLong);
      if (axvu.e.isEnabled())
      {
        paramLong -= axvu.e.t[0];
        l1 = axvu.e.t[1] - axvu.e.t[0];
        l2 = axvu.e.t[2] - axvu.e.t[1];
        l3 = axvu.e.t[3] - axvu.e.t[2];
        if (!Boolean.valueOf(bool).booleanValue()) {
          break label299;
        }
      }
    }
    label299:
    for (int i = 1;; i = 0)
    {
      if ((rar.d(paramLong, 0L, 10000L)) && (rar.d(l1, 0L, 10000L)) && (rar.d(l2, 0L, 10000L)) && (rar.d(l3, 0L, 10000L))) {
        rar.a("CamCaptureCost", true, paramLong, new String[] { String.valueOf(this.jdField_b_of_type_Aybv.EP), String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(i) });
      }
      axvu.e.stopMonitor();
      return;
    }
  }
  
  public void onActivityPause()
  {
    super.onActivityPause();
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwn);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwq);
    GLGestureProxy.getInstance().removeListener(this.jdField_a_of_type_Alwp);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.clearState();
    this.jdField_a_of_type_Axoo.onStop();
    if (this.drX)
    {
      if (this.drW)
      {
        this.drx = true;
        eFB();
      }
      if ((this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView != null) && (this.drY)) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewGuideVideoView.onPause();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onActivityResult:requestCode=" + paramInt1 + " resultCode=" + paramInt2 + " data=" + paramIntent + " publishStoryFlag=" + drT);
    }
    Activity localActivity = this.jdField_a_of_type_Aycb.getActivity();
    alxg.f(localActivity, paramInt1, paramInt2);
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      if (QLog.isColorLevel())
      {
        if (localActivity == null) {
          bool = true;
        }
        QLog.d("QIMEffectCameraCaptureUnit", 2, new Object[] { "activity is finishing, ", Boolean.valueOf(bool) });
      }
      return;
    }
    if ((paramIntent != null) && (paramInt2 == -1))
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setBlockCameraFlag(drT);
      if (QLog.isColorLevel()) {
        QLog.i("QIMEffectCameraCaptureUnit", 2, "cameraCaptureView setBlockCameraFlag");
      }
      label181:
      if (paramInt1 != 10006) {
        break label361;
      }
      if (paramInt2 != -1) {
        break label354;
      }
      this.jdField_a_of_type_Axoo.apk();
      this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.Xx(false);
    }
    for (;;)
    {
      if (paramInt2 == 0) {
        awte.a(null);
      }
      if (this.jdField_a_of_type_Axoo != null)
      {
        if (paramIntent != null) {
          paramIntent.putExtra("story_video_publishing", drT);
        }
        this.jdField_a_of_type_Axoo.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      if (paramIntent == null) {
        break;
      }
      this.mUrl = paramIntent.getStringExtra("share_url_target_url");
      this.mName = paramIntent.getStringExtra("share_url_name");
      this.mText = paramIntent.getStringExtra("share_url_text");
      this.cSr = paramIntent.getStringExtra("share_url_thumb_url");
      this.mSourceName = paramIntent.getStringExtra("struct_share_key_source_name");
      this.cSs = paramIntent.getStringExtra("struct_share_key_source_icon");
      return;
      if ((paramIntent != null) || (paramInt2 != 0) || (!drT)) {
        break label181;
      }
      drT = false;
      this.iG = new QIMEffectCameraCaptureUnit.1(this, localActivity, paramInt2, paramIntent);
      return;
      label354:
      if (paramInt2 == 0)
      {
        continue;
        label361:
        if ((paramInt1 == 1012) && (paramInt2 == -1))
        {
          this.jdField_a_of_type_Axoo.apk();
          this.jdField_a_of_type_DovComQqImCaptureModeCaptureModeController.Xx(false);
        }
      }
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwn);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwq);
    GLGestureProxy.getInstance().addListener(this.jdField_a_of_type_Alwp);
    if (this.iG != null) {
      this.iG.run();
    }
    this.jdField_a_of_type_Axoo.onResume();
    eFy();
    eFH();
    Xy(false);
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setContainerViewListener(this);
    if (axvu.dwO) {
      axvu.e.ay(2, System.currentTimeMillis());
    }
  }
  
  public void onActivityStop()
  {
    super.onActivityStop();
    azbh.nq.clear();
  }
  
  public boolean onBackPressed()
  {
    if (this.jdField_a_of_type_Axoo == null) {}
    while ((this.jdField_a_of_type_Axoo.aPm()) || (aNA()) || (this.jdField_a_of_type_Axoo.aOc())) {
      return false;
    }
    boolean bool = super.onBackPressed();
    if ((!this.drt) || (!this.cAD))
    {
      this.jdField_a_of_type_Axoo.onStop();
      this.drU = true;
      this.jdField_a_of_type_Axoo.apk();
      this.drU = false;
    }
    return bool;
  }
  
  public void onCaptureError(int paramInt)
  {
    super.onCaptureError(paramInt);
    this.c.dLk();
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Axoo.bta();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      axxe.a(this.f, 200L, null);
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.f(this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.eIC, 0, null, false);
      anot.a(null, "dc00898", "", "", "0X8009ED3", "0X8009ED3", Qv(), 0, "", "", "", "");
      rar.a("clk_enter_all", rar.ea(this.jdField_a_of_type_Aycb.getActivity().getIntent().getIntExtra("edit_video_type", 10000)), 0, false, new String[0]);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    atao.dgW = true;
    alwx.aCD();
    alwx.cAd = true;
    alwx.dyy = this.jdField_b_of_type_Aybv.RI();
    alwx.dKr();
    alwy.cAg = false;
    drT = false;
    ayva.a().ZP(true);
    ((awrz)axov.a(13)).Gf(this.jdField_b_of_type_Aybv.EP);
    if (axvu.dwO)
    {
      boolean bool = this.jdField_a_of_type_Aycb.getActivity().getIntent().hasExtra("pendingIntentClass");
      if ((this.aBw == -1L) || (bool)) {
        break label132;
      }
    }
    label132:
    for (long l = this.aBw;; l = System.currentTimeMillis())
    {
      axvu.e.startMonitor();
      axvu.e.ay(0, l);
      axvu.e.ay(1, System.currentTimeMillis());
      return;
    }
  }
  
  public View onCreateView()
  {
    boolean bool3 = false;
    eES();
    this.fa = ((ViewGroup)super.onCreateView());
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager = ((VideoFilterViewPager)this.fa.findViewById(2131367272));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setVisibility(8);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setScrollCallBack(this);
    this.fa.setOnTouchListener(this);
    this.c = ((EffectsCameraCaptureView)this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView);
    this.c.setFaceEffectListener(this);
    this.c.setDanceFilterEventHandler(this);
    this.c.setCameraChangeListener(this);
    this.c.setFiltersChainListener(this);
    this.jdField_a_of_type_Axoo = new axoo(this.jdField_a_of_type_Aycb.getAppInterface(), getView(), this.jdField_a_of_type_Ayca);
    this.jdField_a_of_type_Axoo.busType = this.jdField_b_of_type_Aybv.EP;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager.setProviderViewListener(this.jdField_a_of_type_Axoo);
    this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView = ((QIMProviderContainerView)this.fa.findViewById(2131373718));
    this.jdField_a_of_type_DovComQqImCaptureViewProviderViewEditContainer = ((ProviderViewEditContainer)this.fa.findViewById(2131373720));
    boolean bool4 = ankq.axZ();
    int i;
    label216:
    Object localObject;
    boolean bool2;
    if ((alwy.auM()) && (bool4))
    {
      i = 1;
      if (anki.axM()) {
        break label922;
      }
      bool1 = true;
      if (this.dro) {
        this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setBottomTabParentLH(this.bottom_blackLH);
      }
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setDpcEnable(bool1);
      localObject = this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if ((!this.cAi) || (i == 0)) {
        break label927;
      }
      bool2 = true;
      label261:
      ((QIMProviderContainerView)localObject).setBeautyEnable(bool2);
      localObject = this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if (!this.cAj) {
        break label932;
      }
      bool2 = true;
      label282:
      ((QIMProviderContainerView)localObject).setFilterEnable(bool2);
      localObject = this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView;
      if ((!this.cAk) || (!bool4)) {
        break label937;
      }
      bool2 = true;
      label308:
      ((QIMProviderContainerView)localObject).setFaceEffectEnable(bool2);
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setComboEnable(this.drP);
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.setMusicEnable(this.drQ);
      localObject = this.c;
      if ((!this.cAi) || (i == 0) || (!bool1)) {
        break label942;
      }
      bool2 = true;
      label359:
      ((EffectsCameraCaptureView)localObject).setBeautyEnable(bool2);
      localObject = this.c;
      if ((!this.cAX) || (!bool4) || (!bool1)) {
        break label947;
      }
      bool2 = true;
      label389:
      ((EffectsCameraCaptureView)localObject).setSharpFaceEnable(bool2);
      localObject = this.c;
      if ((!this.cAj) || (!bool1)) {
        break label952;
      }
      bool2 = true;
      label414:
      ((EffectsCameraCaptureView)localObject).setFilterEnable(bool2);
      localObject = this.c;
      if ((!this.cAk) || (!bool4) || (!bool1)) {
        break label957;
      }
    }
    label922:
    label927:
    label932:
    label937:
    label942:
    label947:
    label952:
    label957:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((EffectsCameraCaptureView)localObject).setFaceEffectEnable(bool1);
      this.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView.ces();
      this.agK = ((TextView)this.fa.findViewById(2131367335));
      this.HN = ((ImageView)this.fa.findViewById(2131367337));
      this.mp = ((LinearLayout)this.fa.findViewById(2131367336));
      this.agL = ((TextView)this.fa.findViewById(2131367259));
      this.LP = this.fa.findViewById(2131366638);
      this.LP.setVisibility(8);
      this.agH = ((TextView)this.fa.findViewById(2131366637));
      this.agH.setVisibility(8);
      this.HM = ((ImageView)this.fa.findViewById(2131362724));
      this.HM.setVisibility(8);
      this.HM.setScaleType(ImageView.ScaleType.FIT_CENTER);
      CosFunHelper.setCountDownListener(new awse(this));
      this.agI = ((TextView)this.fa.findViewById(2131379323));
      this.agI.setVisibility(8);
      this.agJ = ((TextView)this.fa.findViewById(2131367339));
      this.agJ.setVisibility(8);
      this.D.setDuration(1000L);
      this.E.setDuration(200L);
      this.agM = ((TextView)this.fa.findViewById(2131367338));
      this.agM.setVisibility(8);
      this.jdField_a_of_type_Alwn = new alwn(this.jdField_a_of_type_Axoo.jdField_b_of_type_DovComQqImCaptureViewQIMProviderContainerView);
      this.jdField_a_of_type_Alwq = new alwq(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager);
      this.jdField_a_of_type_Alwp = new alwp();
      this.LQ = this.rootView.findViewById(2131367263);
      this.yh = ((TextView)this.rootView.findViewById(2131364221));
      this.f = ((RedDotImageView)this.rootView.findViewById(2131381664));
      this.f.setOnClickListener(this);
      eFD();
      eFG();
      bool1 = bool3;
      if (this.top_blackLH != null)
      {
        bool1 = bool3;
        if (this.top_blackLH.getVisibility() == 0) {
          bool1 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("QIMEffectCameraCaptureUnit", 1, "onCreateView needLiuHaiTop:" + bool1);
      }
      localObject = this.fa;
      if ((this.dro) || (bool1)) {
        this.fa = this.nQ;
      }
      eFC();
      return localObject;
      i = 0;
      break;
      bool1 = false;
      break label216;
      bool2 = false;
      break label261;
      bool2 = false;
      break label282;
      bool2 = false;
      break label308;
      bool2 = false;
      break label359;
      bool2 = false;
      break label389;
      bool2 = false;
      break label414;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((axsu)axov.a().c(4)).clear();
    aywa.destroyInstance();
    this.jdField_a_of_type_Axoo.onDestroy();
    VideoMemoryManager.getInstance().clear();
    alwx.aCD();
    if ((axvu.dwO) && (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dzo > 100) && (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.ahT > 0L))
    {
      float f1 = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dzo / (float)this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.ahT * 1000.0F;
      if (rar.d((int)f1, 0L, 30L)) {
        rar.a("CamRenderFreq", true, 0L, new String[] { String.valueOf(this.jdField_b_of_type_Aybv.EP), String.valueOf(f1), String.valueOf(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.dzo), String.valueOf(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.ahT) });
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.release();
    ayzk.cYq = null;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.c.auV()) {
      hg(null, null);
    }
    if (this.drX) {
      return true;
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public void playSceneEndEvent(BoyDataReport paramBoyDataReport)
  {
    this.cf.post(new QIMEffectCameraCaptureUnit.21(this));
    alwx.a(paramBoyDataReport);
  }
  
  public void readySceneBegin(long paramLong)
  {
    this.cf.post(new QIMEffectCameraCaptureUnit.20(this));
  }
  
  public void scoreSceneEnd(int paramInt, String paramString1, String paramString2)
  {
    this.scoreRate = paramString1;
    this.eCA = paramInt;
    this.overPercent = paramString2;
    this.cf.post(new QIMEffectCameraCaptureUnit.23(this));
  }
  
  class ReplayTips
    implements Runnable
  {
    private ReplayTips() {}
    
    public void run()
    {
      QIMEffectCameraCaptureUnit.b(QIMEffectCameraCaptureUnit.this);
      if (QIMEffectCameraCaptureUnit.a(QIMEffectCameraCaptureUnit.this) >= 3) {
        QIMEffectCameraCaptureUnit.a(QIMEffectCameraCaptureUnit.this, 0);
      }
      QIMEffectCameraCaptureUnit.a(QIMEffectCameraCaptureUnit.this, QIMEffectCameraCaptureUnit.a(QIMEffectCameraCaptureUnit.this));
      QIMEffectCameraCaptureUnit.this.cf.postDelayed(QIMEffectCameraCaptureUnit.a(QIMEffectCameraCaptureUnit.this), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit
 * JD-Core Version:    0.7.0.1
 */