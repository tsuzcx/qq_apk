package com.tencent.av.ui.funchat.filter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.ui.AVActivity.AnimationTrigger;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import iiv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EffectFilterTextPager
  extends EffectCycleViewPager
  implements View.OnTouchListener
{
  AVActivity.AnimationTrigger jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = null;
  FilterTextAdapter jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter;
  private int ayV;
  float downX = 0.0F;
  float downY = 0.0F;
  VideoAppInterface mApp = null;
  Handler mHandler;
  long pd = 0L;
  
  public EffectFilterTextPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter = new FilterTextAdapter(paramContext);
    setAdapter(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter);
    this.mHandler = new a(this);
    setOnTouchListener(this);
    this.ayV = -1;
  }
  
  void awc()
  {
    this.mHandler.removeMessages(1);
    igd.aJ("EffectFilterTextPager", "showPromotionText ");
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).setVisibility(0);
      i += 1;
    }
  }
  
  void awd()
  {
    View localView = getCurrentView();
    igd.aJ("EffectFilterTextPager", "dispearPromotionText_internal view:" + getCurrentItem() + "|" + localView);
    if ((localView != null) && (localView.getVisibility() == 0))
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(450L);
      localAlphaAnimation.setAnimationListener(new c(localView));
      localView.startAnimation(localAlphaAnimation);
    }
  }
  
  public void bD(List<FilterItem> paramList)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.bD(paramList);
  }
  
  @TargetApi(11)
  public void kM(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.kM(paramBoolean);
    int j = getChildCount();
    float f1;
    if (paramBoolean)
    {
      f1 = 0.6F;
      if (!paramBoolean) {
        break label172;
      }
    }
    label172:
    for (int i = 2131298125;; i = 2131298124)
    {
      float f2 = getContext().getResources().getDimension(i);
      igd.aJ("EffectFilterTextPager", "changeLayout: " + paramBoolean + "|" + j + "|" + f1);
      i = 0;
      while (i < j)
      {
        ImageView localImageView = (ImageView)((ViewGroup)getChildAt(i)).findViewById(2131373982);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
        localLayoutParams.setMargins(localLayoutParams.leftMargin, (int)f2, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
        localImageView.setScaleX(f1);
        localImageView.setScaleY(f1);
        i += 1;
      }
      f1 = 1.0F;
      break;
    }
  }
  
  void nx(int paramInt)
  {
    igd.aJ("EffectFilterTextPager", "dispearPromotionText view:");
    this.mHandler.removeMessages(1);
    Message localMessage = this.mHandler.obtainMessage(1);
    this.mHandler.sendMessageDelayed(localMessage, paramInt);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = Boolean.valueOf(VideoController.a().b().Ql);
    if (paramMotionEvent.getAction() == 0)
    {
      this.downX = 0.0F;
      this.downY = 0.0F;
      this.pd = System.currentTimeMillis();
      this.downX = paramMotionEvent.getX();
      this.downY = paramMotionEvent.getY();
      if (QLog.isColorLevel()) {
        QLog.e("EffectFilterTextPager", 2, "[childLock] touch onDown: " + this.downX + " x " + this.downY + " ==========");
      }
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger != null)
      {
        if (!VideoController.a().b().Ql) {
          break label380;
        }
        this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.arQ();
      }
    }
    for (;;)
    {
      if (!paramView.booleanValue()) {
        awc();
      }
      Object localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        EditText localEditText = (EditText)((Activity)localObject).findViewById(2131369279);
        if (localEditText != null)
        {
          localEditText.clearFocus();
          ((InputMethodManager)((Activity)localObject).getSystemService("input_method")).hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
        }
      }
      if ((!VideoController.a().b().Ql) && ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getPointerCount() > 1) || ((paramMotionEvent.getAction() == 2) && ((Math.abs(paramMotionEvent.getX() - this.downX) > 70.0F) || (Math.abs(paramMotionEvent.getY() - this.downY) > 70.0F)))))
      {
        this.mApp.getHandler().removeCallbacks(this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger);
        if ((this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger != null) && (this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.vZ())) {
          this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.cancel();
        }
        if (QLog.isColorLevel()) {
          QLog.e("EffectFilterTextPager", 2, "[childLock] touch end ==========");
        }
      }
      if (!paramView.booleanValue()) {
        break;
      }
      if ((paramMotionEvent.getAction() == 1) && (System.currentTimeMillis() - this.pd < 200L) && (this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger != null)) {
        this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.arR();
      }
      awd();
      return true;
      label380:
      this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger.u(this.downX, this.downY);
    }
    return false;
  }
  
  public void setAnimationTrigger(AVActivity.AnimationTrigger paramAnimationTrigger)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity$AnimationTrigger = paramAnimationTrigger;
  }
  
  public void setApp(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void setCurrentFilter(FilterItem paramFilterItem)
  {
    int i = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$FilterTextAdapter.a(paramFilterItem);
    this.ayV = i;
    setCurrentItem(i + 1, false);
  }
  
  public void setOnFilterListenner(d paramd)
  {
    setOnPageChangeListener(new b(paramd));
  }
  
  public void setVisibility(int paramInt)
  {
    int i;
    if (paramInt == 0)
    {
      awc();
      if (VideoController.a().b().Rh)
      {
        i = 4000;
        nx(i);
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      i = 1300;
      break;
      this.mHandler.removeMessages(1);
      View localView = getCurrentView();
      if (localView != null) {
        localView.clearAnimation();
      }
    }
  }
  
  public static class FilterTextAdapter
    extends PagerAdapter
  {
    private boolean Xv;
    private ColorDrawable b = new ColorDrawable(0);
    WeakReference<Context> bG;
    ArrayList<FilterItem> mList;
    
    public FilterTextAdapter(Context paramContext)
    {
      this.bG = new WeakReference(paramContext);
      this.mList = new ArrayList();
    }
    
    public int a(FilterItem paramFilterItem)
    {
      if (paramFilterItem == null) {
        return 0;
      }
      Iterator localIterator = this.mList.iterator();
      int i = 0;
      for (;;)
      {
        if ((!localIterator.hasNext()) || (((FilterItem)localIterator.next()).getId().equals(paramFilterItem.getId()))) {
          return i;
        }
        i += 1;
      }
    }
    
    FilterItem a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mList.size())) {
        return (FilterItem)this.mList.get(paramInt);
      }
      return null;
    }
    
    public void bD(List<FilterItem> paramList)
    {
      this.mList.addAll(paramList);
      notifyDataSetChanged();
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      return this.mList.size();
    }
    
    @TargetApi(11)
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      Object localObject = (FilterItem)this.mList.get(paramInt);
      Context localContext = (Context)this.bG.get();
      if (localContext != null)
      {
        ViewGroup localViewGroup = (ViewGroup)((LayoutInflater)localContext.getSystemService("layout_inflater")).inflate(2131559987, null);
        ImageView localImageView = (ImageView)localViewGroup.findViewById(2131373982);
        localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (localObject != null) {}
        for (localObject = ((FilterItem)localObject).getIconurl();; localObject = null)
        {
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            igd.aJ("EffectFilterTextPager", "decodeFile url is null.");
            localImageView.setImageDrawable(null);
          }
          for (;;)
          {
            if (this.Xv)
            {
              localObject = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
              float f = localContext.getResources().getDimension(2131298125);
              ((LinearLayout.LayoutParams)localObject).setMargins(((LinearLayout.LayoutParams)localObject).leftMargin, (int)f, ((LinearLayout.LayoutParams)localObject).rightMargin, ((LinearLayout.LayoutParams)localObject).bottomMargin);
              localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              localImageView.setScaleX(0.6F);
              localImageView.setScaleY(0.6F);
            }
            paramViewGroup.addView(localViewGroup);
            return localViewGroup;
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mFailedDrawable = this.b;
            localURLDrawableOptions.mLoadingDrawable = this.b;
            localURLDrawableOptions.mRequestWidth = localContext.getResources().getDimensionPixelSize(2131298130);
            localURLDrawableOptions.mRequestHeight = localContext.getResources().getDimensionPixelSize(2131298129);
            localImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject, localURLDrawableOptions));
          }
        }
      }
      return null;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void kM(boolean paramBoolean)
    {
      this.Xv = paramBoolean;
    }
  }
  
  static class a
    extends Handler
  {
    WeakReference<EffectFilterTextPager> bs;
    
    public a(EffectFilterTextPager paramEffectFilterTextPager)
    {
      this.bs = new WeakReference(paramEffectFilterTextPager);
    }
    
    public void handleMessage(Message paramMessage)
    {
      EffectFilterTextPager localEffectFilterTextPager = (EffectFilterTextPager)this.bs.get();
      if (localEffectFilterTextPager == null) {
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        localEffectFilterTextPager.awd();
      }
    }
  }
  
  class b
    implements ViewPager.OnPageChangeListener
  {
    private WeakReference<EffectFilterTextPager.d> bH;
    
    public b(EffectFilterTextPager.d paramd)
    {
      this.bH = new WeakReference(paramd);
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      long l = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w("EffectFilterTextPager", 1, "onPageScrollStateChanged, arg0[" + paramInt + "], seq[" + l + "]");
      }
      if (paramInt == 0)
      {
        EffectFilterTextPager.this.nx(1300);
        if (EffectFilterTextPager.this.mApp != null) {
          EffectFilterTextPager.this.mApp.l(new Object[] { Integer.valueOf(110), Long.valueOf(l) });
        }
      }
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
    
    public void onPageSelected(int paramInt)
    {
      long l = AudioHelper.hG();
      if (AudioHelper.aCz()) {
        QLog.w("EffectFilterTextPager", 1, "onPageSelected, pos[" + paramInt + "], mProgramingPos[" + EffectFilterTextPager.a(EffectFilterTextPager.this) + "], seq[" + l + "]");
      }
      if ((EffectFilterTextPager.a(EffectFilterTextPager.this) != paramInt) && (this.bH != null) && (this.bH.get() != null))
      {
        FilterItem localFilterItem = EffectFilterTextPager.this.a.a(paramInt);
        if (localFilterItem != null) {
          ((EffectFilterTextPager.d)this.bH.get()).f(l, paramInt, localFilterItem.getId());
        }
        EffectFilterTextPager.a(EffectFilterTextPager.this, -1);
      }
    }
  }
  
  class c
    implements Animation.AnimationListener
  {
    private WeakReference<View> bF;
    
    c(View paramView)
    {
      this.bF = new WeakReference(paramView);
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      View localView = (View)this.bF.get();
      igd.aJ("EffectFilterTextPager", "onAnimationEnd :" + localView + "|" + paramAnimation);
      if (localView != null) {
        localView.setVisibility(4);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  public static abstract interface d
  {
    public abstract void f(long paramLong, int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.filter.EffectFilterTextPager
 * JD-Core Version:    0.7.0.1
 */