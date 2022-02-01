package dov.com.qq.im.capture.mode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqnm;
import asgf;
import awrq;
import awsy;
import awsz;
import axqo;
import axqp;
import axqq;
import axqs;
import axqw;
import axra;
import axyc;
import ayce;
import ayce.a;
import aycm;
import azbx;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.d;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter.a;
import dov.com.qq.im.capture.adapter.CaptureModeAdapter.b;
import dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraStoryCaptureButtonLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import pmi;
import rar;

public class CaptureModeController
  implements ViewPager.OnPageChangeListener, EffectsCameraCaptureView.d, CaptureModeAdapter.b
{
  private List<CaptureModeAdapter.a> Nh = new ArrayList();
  private axqo jdField_a_of_type_Axqo;
  private ayce jdField_a_of_type_Ayce;
  public awrq b;
  private CaptureModeAdapter b;
  private boolean dwf;
  public boolean dwg;
  protected int eGH = 0;
  public ViewGroup eZ;
  private ViewPager l;
  private HashMap<Integer, axqo> rt = new HashMap();
  
  public CaptureModeController(awrq paramawrq)
  {
    this.jdField_b_of_type_Awrq = paramawrq;
  }
  
  public void OE(boolean paramBoolean)
  {
    if (asgf.isSoLoaded.get()) {
      pmi.a().dispatch(new ayce.a(1, paramBoolean));
    }
    pmi.a().dispatch(new ayce.a(3, true));
  }
  
  public void XD(boolean paramBoolean)
  {
    if (this.eZ.getTranslationY() != 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.a(this.eZ, null);
      }
    }
    else {
      return;
    }
    this.eZ.setTranslationY(0.0F);
    this.eZ.setAlpha(1.0F);
  }
  
  public void XE(boolean paramBoolean)
  {
    if (this.eZ.getTranslationY() == 0.0F)
    {
      if (paramBoolean) {
        DragAnimationMgr.b(this.eZ, null);
      }
    }
    else {
      return;
    }
    this.eZ.setTranslationY(this.eZ.getHeight());
    this.eZ.setAlpha(0.0F);
  }
  
  public void Xx(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "setSegmentModeEnabled, ", Boolean.valueOf(paramBoolean) });
    }
    if ((this.jdField_b_of_type_Awrq instanceof awsy))
    {
      if ((this.jdField_b_of_type_Awrq instanceof awsz)) {
        paramBoolean = false;
      }
      ((awsy)this.jdField_b_of_type_Awrq).a.setEnableSegment(paramBoolean);
      return;
    }
    int i = this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.lL(0);
    int j = this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.lL(1);
    Object localObject = this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter;
    if (!paramBoolean)
    {
      ((CaptureModeAdapter)localObject).cy(i, bool);
      this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.cy(j, paramBoolean);
      localObject = this.l;
      if (!paramBoolean) {
        break label139;
      }
      i = j;
    }
    label139:
    for (;;)
    {
      ((ViewPager)localObject).setCurrentItem(i, false);
      return;
      bool = false;
      break;
    }
  }
  
  public axqo a()
  {
    return this.jdField_a_of_type_Axqo;
  }
  
  public axqs a()
  {
    if ((this.jdField_b_of_type_Awrq instanceof awsy)) {}
    for (axqs localaxqs1 = (axqs)this.rt.get(Integer.valueOf(0));; localaxqs1 = (axqs)this.rt.get(Integer.valueOf(1)))
    {
      axqs localaxqs2 = localaxqs1;
      if (localaxqs1 == null) {
        localaxqs2 = new axqs(this);
      }
      return localaxqs2;
    }
  }
  
  public axqw a()
  {
    axqw localaxqw2 = (axqw)this.rt.get(Integer.valueOf(2));
    axqw localaxqw1 = localaxqw2;
    if (localaxqw2 == null) {
      localaxqw1 = new axqw(this);
    }
    return localaxqw1;
  }
  
  public axra a()
  {
    axra localaxra2 = (axra)this.rt.get(Integer.valueOf(4));
    axra localaxra1 = localaxra2;
    if (localaxra2 == null) {
      localaxra1 = new axra(this);
    }
    return localaxra1;
  }
  
  public ayce a()
  {
    return this.jdField_a_of_type_Ayce;
  }
  
  public aycm a()
  {
    aycm localaycm2 = (aycm)this.rt.get(Integer.valueOf(5));
    aycm localaycm1 = localaycm2;
    if (localaycm2 == null) {
      localaycm1 = new aycm(this);
    }
    return localaycm1;
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    this.eZ = ((ViewGroup)paramView.findViewById(2131364266));
    if (paramBoolean)
    {
      ((ViewGroup)this.eZ.getParent()).removeView(this.eZ);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.eZ.getLayoutParams();
      localLayoutParams.topMargin = aqnm.dip2px(8.0F);
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(12, 0);
      paramRelativeLayout.addView(this.eZ, localLayoutParams);
      paramRelativeLayout = (ImageView)paramView.findViewById(2131377581);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
      paramRelativeLayout = (ImageView)paramView.findViewById(2131377579);
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(0);
      }
    }
    this.l = ((ViewPager)paramView.findViewById(2131364261));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (azbx.bG(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - aqnm.dip2px(53.0F)) / 2;
    this.l.setPadding(i, 0, i, 0);
    this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter = new CaptureModeAdapter(paramView.getContext());
    this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.setData(this.Nh, this.eGH);
    this.l.setAdapter(this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter);
    this.l.setOffscreenPageLimit(this.Nh.size());
    this.l.setOnPageChangeListener(this);
    this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.a(this);
    paramRelativeLayout = this.rt.entrySet().iterator();
    while (paramRelativeLayout.hasNext()) {
      ((axqo)((Map.Entry)paramRelativeLayout.next()).getValue()).jy(paramView);
    }
    paramBoolean = this.rt.containsKey(Integer.valueOf(5));
    boolean bool = this.rt.containsKey(Integer.valueOf(7));
    if ((paramBoolean) || (bool))
    {
      this.jdField_a_of_type_Ayce = new ayce();
      this.jdField_a_of_type_Ayce.eQc();
      if ((this.jdField_b_of_type_Awrq.a() instanceof EffectsCameraCaptureView))
      {
        paramRelativeLayout = (EffectsCameraCaptureView)this.jdField_b_of_type_Awrq.a();
        paramRelativeLayout.setFilterInitedListener(this);
        if (paramRelativeLayout.eglContext == null) {
          break label527;
        }
        pmi.a().dispatch(new ayce.a(2, true));
      }
    }
    for (;;)
    {
      if ((this.Nh.size() == 1) && ((((CaptureModeAdapter.a)this.Nh.get(0)).PQ() == 0) || (((CaptureModeAdapter.a)this.Nh.get(0)).PQ() == 10)))
      {
        ((ImageView)paramView.findViewById(2131364262)).setVisibility(4);
        this.l.setVisibility(4);
        this.eZ.setVisibility(4);
        this.jdField_b_of_type_Awrq.eEX();
      }
      return;
      label527:
      paramRelativeLayout.setOnSurfaceCreatedListener(new axqp(this));
    }
  }
  
  public void a(View paramView, RelativeLayout paramRelativeLayout1, boolean paramBoolean, RelativeLayout paramRelativeLayout2)
  {
    this.eZ = ((ViewGroup)paramView.findViewById(2131364266));
    if (paramBoolean)
    {
      ((ViewGroup)this.eZ.getParent()).removeView(this.eZ);
      paramRelativeLayout2 = (RelativeLayout.LayoutParams)this.eZ.getLayoutParams();
      paramRelativeLayout2.topMargin = aqnm.dip2px(8.0F);
      paramRelativeLayout2.addRule(10, -1);
      paramRelativeLayout2.addRule(12, 0);
      paramRelativeLayout1.addView(this.eZ, paramRelativeLayout2);
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131377581);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131377579);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(0);
      }
    }
    while ((this.Nh.size() == 1) && (((CaptureModeAdapter.a)this.Nh.get(0)).PQ() == 0))
    {
      ((ImageView)paramView.findViewById(2131364262)).setVisibility(4);
      this.l.setVisibility(4);
      this.eZ.setVisibility(4);
      this.jdField_b_of_type_Awrq.eEX();
      return;
      ((ViewGroup)this.eZ.getParent()).removeView(this.eZ);
      paramRelativeLayout1 = (RelativeLayout.LayoutParams)this.eZ.getLayoutParams();
      paramRelativeLayout1.topMargin = aqnm.dip2px(0.0F);
      paramRelativeLayout1.bottomMargin = aqnm.dip2px(0.0F);
      paramRelativeLayout1.addRule(10, 0);
      paramRelativeLayout1.addRule(12, -1);
      paramRelativeLayout2.addView(this.eZ, paramRelativeLayout1);
      this.eZ.bringToFront();
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131377581);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
      paramRelativeLayout1 = (ImageView)paramView.findViewById(2131377579);
      if (paramRelativeLayout1 != null) {
        paramRelativeLayout1.setVisibility(8);
      }
    }
    ((ImageView)paramView.findViewById(2131364262)).setVisibility(0);
    this.l.setVisibility(0);
    this.eZ.setVisibility(0);
  }
  
  public void eNV()
  {
    Object localObject2 = this.jdField_b_of_type_Awrq.getActivity().getIntent().getIntegerArrayListExtra("support_intent_mode");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(axqq.lM(((Integer)((Iterator)localObject2).next()).intValue())));
      }
    }
    long l1;
    for (;;)
    {
      l1 = System.currentTimeMillis();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Integer)((Iterator)localObject1).next();
        axqo localaxqo = axqq.a(((Integer)localObject2).intValue(), this);
        if (localaxqo.isSupport())
        {
          this.Nh.add(new CaptureModeAdapter.a(((Integer)localObject2).intValue()));
          this.rt.put(localObject2, localaxqo);
        }
      }
      localObject1 = this.jdField_b_of_type_Awrq.eG();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, "initCaptureMode use = " + (System.currentTimeMillis() - l1));
    }
    this.eGH = this.jdField_b_of_type_Awrq.Qw();
    if ((this.eGH == 5) && (!this.rt.containsKey(Integer.valueOf(5)))) {
      this.eGH = 0;
    }
    this.jdField_b_of_type_Awrq.eCw = this.eGH;
    this.jdField_a_of_type_Axqo = ((axqo)this.rt.get(Integer.valueOf(this.eGH)));
    this.rt.remove(Integer.valueOf(7));
  }
  
  public void eNW()
  {
    this.l.setCurrentItem(this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.lL(this.eGH));
    if ((this.dwf) && (this.eGH == 7)) {}
    CaptureModeAdapter.a locala;
    do
    {
      do
      {
        return;
      } while (this.Nh.size() <= 0);
      locala = (CaptureModeAdapter.a)this.Nh.get(0);
    } while (this.eGH != locala.PQ());
    onPageSelected(0);
  }
  
  public void eNX()
  {
    Object localObject = a();
    if ((localObject != null) && (((axqw)localObject).MQ != null)) {
      ((axqw)localObject).MQ.bringToFront();
    }
    localObject = a();
    if ((localObject != null) && (((axra)localObject).a != null)) {
      ((axra)localObject).a.t().bringToFront();
    }
    if (this.eZ != null) {
      this.eZ.bringToFront();
    }
  }
  
  public Activity getActivity()
  {
    return this.jdField_b_of_type_Awrq.getActivity();
  }
  
  public void j(int paramInt, View paramView)
  {
    this.dwg = true;
    this.l.setCurrentItem(paramInt);
  }
  
  public void onActivityResume()
  {
    this.dwf = false;
    this.jdField_a_of_type_Axqo.onActivityResume();
  }
  
  public void onActivityStart()
  {
    this.jdField_a_of_type_Axqo.onActivityStart();
  }
  
  public void onActivityStop()
  {
    this.jdField_a_of_type_Axqo.onActivityStop();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Axqo.onActivityDestroy();
    if (this.jdField_a_of_type_Ayce != null)
    {
      this.jdField_a_of_type_Ayce.onDestroy();
      this.jdField_a_of_type_Ayce = null;
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.onPageScrollStateChanged(paramInt);
  }
  
  @Deprecated
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.x(paramInt1, paramFloat);
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_b_of_type_DovComQqImCaptureAdapterCaptureModeAdapter.aeA(paramInt);
    CaptureModeAdapter.a locala = (CaptureModeAdapter.a)this.Nh.get(paramInt);
    int i = locala.PQ();
    if ((i == this.eGH) && (this.dwg)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CaptureModeController", 2, new Object[] { "onPageSelected, mLastCaptureMode:", Integer.valueOf(this.eGH), " current:", Integer.valueOf(i) });
    }
    this.jdField_a_of_type_Axqo.YQ(false);
    switch (this.eGH)
    {
    case 3: 
    case 6: 
    case 8: 
    case 9: 
    default: 
      label160:
      this.jdField_a_of_type_Axqo = ((axqo)this.rt.get(Integer.valueOf(i)));
      int j = this.eGH;
      this.jdField_b_of_type_Awrq.eCw = i;
      this.eGH = i;
      this.jdField_b_of_type_Awrq.a(j, this.jdField_a_of_type_Axqo);
      this.jdField_a_of_type_Axqo.YQ(true);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      rar.a("video_shoot_navi", "clk_mode", 0, 0, new String[] { String.valueOf(locala.PQ()) });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CaptureModeController", 2, "onPageSelected:" + paramInt);
      return;
      this.jdField_b_of_type_Awrq.cN(false, true);
      break label160;
      this.jdField_b_of_type_Awrq.Xp(false);
      break label160;
      this.jdField_b_of_type_Awrq.Xt(false);
      break label160;
      this.jdField_b_of_type_Awrq.Xs(false);
      break label160;
      this.jdField_b_of_type_Awrq.Xu(false);
      break label160;
      this.jdField_b_of_type_Awrq.Xr(false);
      break label160;
      this.jdField_b_of_type_Awrq.Xp(false);
      break label160;
      this.jdField_b_of_type_Awrq.cN(true, true);
      continue;
      this.jdField_b_of_type_Awrq.Xp(true);
      continue;
      this.jdField_b_of_type_Awrq.Xr(true);
      continue;
      this.jdField_b_of_type_Awrq.Xt(true);
      continue;
      this.jdField_b_of_type_Awrq.Xs(true);
      continue;
      this.jdField_b_of_type_Awrq.Xu(true);
      continue;
      this.jdField_b_of_type_Awrq.Xp(false);
    }
  }
  
  public boolean or(int paramInt)
  {
    return this.rt.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.mode.CaptureModeController
 * JD-Core Version:    0.7.0.1
 */