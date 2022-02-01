package com.tencent.mobileqq.extendfriend.wiget;

import afyo;
import afyp;
import afyq;
import afyr;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import jll;

public class ExtendFriendSearchBarView
  extends FrameLayout
  implements View.OnClickListener, ExtendFriendHorizontalTagsView.a
{
  private a jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView$a;
  private InterceptHorizontalScrollView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView;
  private Animator.AnimatorListener jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ExtendFriendHorizontalTagsView jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView;
  private Animator.AnimatorListener jdField_c_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator;
  private int cVr = -1;
  private boolean cbO = true;
  private boolean cbP;
  private ValueAnimator d;
  private ViewGroup ee;
  private Interpolator mInterpolator = new LinearInterpolator();
  private ImageView zq;
  
  public ExtendFriendSearchBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendSearchBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendSearchBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131561341, this);
    initViews();
  }
  
  private void gD(View paramView)
  {
    this.cVr = (((FrameLayout.LayoutParams)paramView.getLayoutParams()).topMargin + paramView.getHeight());
    this.cbP = true;
  }
  
  private void gE(View paramView)
  {
    if (!this.cbP) {
      gD(paramView);
    }
    if (this.cVr <= 0) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    if (this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(200L);
      this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.mInterpolator);
      this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new afyo(this, localLayoutParams, paramView));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new afyp(this);
    }
    if ((this.d != null) && (this.d.isRunning()))
    {
      this.d.cancel();
      this.d.removeAllListeners();
    }
    this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  private void gF(View paramView)
  {
    if (!this.cbP) {
      gD(paramView);
    }
    if (this.cVr <= 0) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    if (this.d == null)
    {
      this.d = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.d.setDuration(200L);
      this.d.setInterpolator(this.mInterpolator);
      this.d.addUpdateListener(new afyq(this, localLayoutParams, paramView));
      this.jdField_c_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new afyr(this, paramView);
    }
    if ((this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.d.removeAllListeners();
    this.d.cancel();
    this.d.addListener(this.jdField_c_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.d.start();
  }
  
  private void initViews()
  {
    this.ee = ((ViewGroup)findViewById(2131377784));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView = ((InterceptHorizontalScrollView)findViewById(2131377857));
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView = ((ExtendFriendHorizontalTagsView)findViewById(2131377852));
    this.zq = ((ImageView)findViewById(2131377803));
    if (this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView != null) {
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.setOnItemClickListener(this);
    }
    if (this.zq != null)
    {
      this.zq.setOnClickListener(this);
      this.zq.setOnTouchListener(jll.a);
    }
  }
  
  public void Im()
  {
    if (this.cbO)
    {
      if ((this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (!this.jdField_c_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) && (((FrameLayout.LayoutParams)this.ee.getLayoutParams()).topMargin != 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSearchBarView", 2, "showSearchBar catch a display exception");
        }
        ddT();
      }
      return;
    }
    this.cbO = true;
    gE(this.ee);
  }
  
  public void In()
  {
    if (!this.cbO) {
      return;
    }
    this.cbO = false;
    gF(this.ee);
  }
  
  public void Iv(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      localObject1 = localObject2;
      if (i < this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.getChildCount())
      {
        localObject1 = (TextView)this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.getChildAt(i);
        if ((!(((TextView)localObject1).getTag() instanceof ExtendFriendHorizontalTagsView.b)) || (!paramString.equals(((ExtendFriendHorizontalTagsView.b)((TextView)localObject1).getTag()).tag))) {}
      }
    }
    for (int i = ((TextView)localObject1).getRight();; i = 0)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView.getWidth();
      if ((i > j) && (j > 0) && (localObject1 != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetInterceptHorizontalScrollView.scrollTo(i - j, 0);
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void NG(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[1];
    int k = getHeight();
    int j = paramInt + i;
    if ((j > i) && (i > 0))
    {
      paramInt = k;
      if (k > 0) {}
    }
    else
    {
      j = 1920;
      i = 223;
      paramInt = 105;
    }
    int m = i * 36 / j;
    k = (i + paramInt) * 36 / j;
    int n = i * -35 / j;
    paramInt = (paramInt + i) * -35 / j;
    i = Color.argb(255, 79 - m, 127 - n, 255);
    paramInt = Color.argb(255, 79 - k, 127 - paramInt, 255);
    setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, paramInt }));
  }
  
  public void ddT()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ee.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.ee.setLayoutParams(localLayoutParams);
  }
  
  public void eA(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView$a.ez(paramString, paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView$a.dcn();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setItemClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView$a = parama;
  }
  
  public void setSearchButtonEnable(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.zq != null)
    {
      localImageView = this.zq;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void setSearchTags(ArrayList<String> paramArrayList, int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView != null) {
      this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendHorizontalTagsView.setSearchTags(paramArrayList, paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dcn();
    
    public abstract void ez(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView
 * JD-Core Version:    0.7.0.1
 */