package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anon;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase.a;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.ui.AVActivity.AnimationTrigger;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import iju;
import java.lang.ref.WeakReference;

public class EffectFilterPanel
  extends RelativeLayout
  implements EffectConfigBase.a<FilterItem>
{
  private boolean Xv;
  private MyScroolTextDispearRunnable jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable;
  a jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$a;
  private EffectFilterTextPager jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager;
  private iju jdField_a_of_type_Iju;
  private ImageView gT;
  private VideoAppInterface mApp;
  private Handler mHandler;
  
  public EffectFilterPanel(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext);
    this.mApp = paramVideoAppInterface;
    this.mHandler = new Handler();
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable = new MyScroolTextDispearRunnable(this);
    this.jdField_a_of_type_Iju = ((iju)paramVideoAppInterface.a(1));
    this.jdField_a_of_type_Iju.a(-1043L, this);
    a(paramContext, paramVideoAppInterface);
  }
  
  @TargetApi(11)
  public void N(boolean paramBoolean1, boolean paramBoolean2)
  {
    igd.aJ("EffectFilterPanel", "changeLayoutStyle: " + this.Xv + "|" + paramBoolean1 + "|" + paramBoolean2);
    Object localObject;
    int i;
    if (this.Xv != paramBoolean1)
    {
      this.Xv = paramBoolean1;
      if (!paramBoolean1) {
        break label241;
      }
      localObject = getContext().getResources().getDisplayMetrics();
      igd.aJ("EffectFilterPanel", "changeLayoutStyle 22: " + ((DisplayMetrics)localObject).widthPixels);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject).widthPixels / 2, -1);
      if (!paramBoolean2) {
        break label229;
      }
      i = 11;
      localLayoutParams.addRule(i);
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setLayoutParams(localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(((DisplayMetrics)localObject).widthPixels / 2, -1);
      if (!paramBoolean2) {
        break label235;
      }
      i = 11;
      label165:
      ((RelativeLayout.LayoutParams)localObject).addRule(i);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, -(int)getContext().getResources().getDimension(2131298128), 0, 0);
      this.gT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.gT.setScaleX(0.9F);
      this.gT.setScaleY(0.9F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.kM(paramBoolean1);
      return;
      label229:
      i = 9;
      break;
      label235:
      i = 9;
      break label165;
      label241:
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = -1;
      ((RelativeLayout.LayoutParams)localObject).height = -1;
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, (int)getContext().getResources().getDimension(2131298127), 0, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.gT.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.gT.setScaleX(1.0F);
      this.gT.setScaleY(1.0F);
    }
  }
  
  public void a(long paramLong, FilterItem paramFilterItem)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onItemSelectedChanged, seq[").append(paramLong).append("], mFilterPager[");
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("EffectFilterPanel", 1, bool + "], current[" + paramFilterItem + "]");
      if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager != null) {
        this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setCurrentFilter(paramFilterItem);
      }
      paramFilterItem = (EffectOperateManager)this.mApp.a(8);
      if ((paramFilterItem != null) && (paramFilterItem.tv())) {
        paramFilterItem.ie(false);
      }
      return;
    }
  }
  
  public void a(long paramLong, FilterItem paramFilterItem, boolean paramBoolean) {}
  
  void a(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    long l = AudioHelper.hG();
    paramContext = (ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559988, this);
    this.gT = ((ImageView)paramContext.findViewById(2131373983));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager = ((EffectFilterTextPager)paramContext.findViewById(2131381662));
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setApp(paramVideoAppInterface);
    setOnFilterListenner(null);
    paramContext = (FilterItem)this.jdField_a_of_type_Iju.a();
    paramVideoAppInterface = this.jdField_a_of_type_Iju.y(null);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.bD(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setCurrentFilter(paramContext);
    this.jdField_a_of_type_Iju.a(l, paramContext);
  }
  
  public void a(FilterItem paramFilterItem, int paramInt) {}
  
  void awb()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setAnimationListener(new b(this.gT));
    this.gT.startAnimation(localAlphaAnimation);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.Xv)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.dispatchTouchEvent(paramMotionEvent);
      igd.aJ("EffectFilterPanel", "onTouchEvent: " + paramMotionEvent.toString());
      return true;
    }
    return false;
  }
  
  public void setAnimationTrigger(AVActivity.AnimationTrigger paramAnimationTrigger)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setAnimationTrigger(paramAnimationTrigger);
  }
  
  public void setOnFilterListenner(EffectFilterTextPager.d paramd)
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$a == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$a = new a(paramd);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setOnFilterListenner(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$a);
      return;
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$a.a(paramd);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.setVisibility(paramInt);
    iiv localiiv = VideoController.a().b();
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = localiiv.a;
    if ((localPtvTemplateInfo != null) && (!TextUtils.isEmpty(localPtvTemplateInfo.filtername))) {}
    for (int i = 1;; i = 0)
    {
      if ((localiiv.Rh) && (i == 0))
      {
        localiiv.Rh = false;
        this.gT.setVisibility(0);
        this.mHandler.postDelayed(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel$MyScroolTextDispearRunnable, 4000L);
      }
      super.setVisibility(paramInt);
      return;
    }
  }
  
  static class MyScroolTextDispearRunnable
    implements Runnable
  {
    WeakReference<EffectFilterPanel> bE;
    
    MyScroolTextDispearRunnable(EffectFilterPanel paramEffectFilterPanel)
    {
      this.bE = new WeakReference(paramEffectFilterPanel);
    }
    
    public void run()
    {
      EffectFilterPanel localEffectFilterPanel = (EffectFilterPanel)this.bE.get();
      if (localEffectFilterPanel != null) {
        localEffectFilterPanel.awb();
      }
    }
  }
  
  class a
    implements EffectFilterTextPager.d
  {
    EffectFilterTextPager.d a;
    
    a(EffectFilterTextPager.d paramd)
    {
      a(paramd);
    }
    
    public void a(EffectFilterTextPager.d paramd)
    {
      this.a = paramd;
    }
    
    public void f(long paramLong, int paramInt, String paramString)
    {
      if (AudioHelper.aCz()) {
        QLog.w("EffectFilterPanel", 1, "OnItemSelected, id[" + paramInt + "], name[" + paramString + "], seq[" + paramLong + "], Visibility[" + EffectFilterPanel.a(EffectFilterPanel.this).getVisibility() + "], mlistener[" + this.a + "]");
      }
      if (EffectFilterPanel.a(EffectFilterPanel.this).getVisibility() == 0)
      {
        EffectFilterPanel.a(EffectFilterPanel.this).removeCallbacks(EffectFilterPanel.a(EffectFilterPanel.this));
        EffectFilterPanel.a(EffectFilterPanel.this).clearAnimation();
        EffectFilterPanel.a(EffectFilterPanel.this).setVisibility(8);
      }
      paramString = (FilterItem)EffectFilterPanel.a(EffectFilterPanel.this).a(paramString);
      EffectFilterPanel.a(EffectFilterPanel.this).a(paramLong, paramString);
      if (paramString != null)
      {
        if (!paramString.isUsable()) {
          EffectFilterPanel.a(EffectFilterPanel.this).a(paramLong, paramString);
        }
        anon.QW(paramString.getId());
        if ((paramString.getId() != null) && (paramString.getId().compareToIgnoreCase("MANHUA") == 0)) {
          EffectFilterPanel.a(EffectFilterPanel.this).b().lockVideoMaxQP(51, paramString.getId());
        }
      }
      else
      {
        return;
      }
      EffectFilterPanel.a(EffectFilterPanel.this).b().lockVideoMaxQP(0, paramString.getId());
    }
  }
  
  class b
    implements Animation.AnimationListener
  {
    private WeakReference<View> bF;
    
    b(View paramView)
    {
      this.bF = new WeakReference(paramView);
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      View localView = (View)this.bF.get();
      igd.aJ("EffectFilterPanel", "MyTextAlphaAnimationListener onAnimationEnd :" + localView + "|" + paramAnimation);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterPanel
 * JD-Core Version:    0.7.0.1
 */