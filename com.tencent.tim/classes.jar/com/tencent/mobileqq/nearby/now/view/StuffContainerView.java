package com.tencent.mobileqq.nearby.now.view;

import ajvk;
import ajvn;
import ajzc;
import ajzd;
import ajze;
import ajzf;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import jll;

public class StuffContainerView
  extends RelativeLayout
  implements View.OnClickListener
{
  public ajvk a;
  public ajvn a;
  public StoryPlayController a;
  protected a a;
  public b a;
  public VideoPlayerPagerAdapter a;
  private long adH;
  public QQAppInterface app;
  public CustomViewPager b;
  public QQStoryVideoPlayerErrorView b;
  protected SplitedProgressBar b;
  public ImageView closeBtn;
  public boolean cqQ;
  public Activity mActivity;
  private long mPlayTime;
  private int mStatusBarHeight;
  
  public StuffContainerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StuffContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StuffContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mActivity = ((Activity)paramContext);
    init(paramContext);
  }
  
  public void Mw(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter = new VideoPlayerPagerAdapter(getContext(), paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.app = this.app;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setPageMargin(1);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter);
  }
  
  public void Mx(boolean paramBoolean)
  {
    SplitedProgressBar localSplitedProgressBar = this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localSplitedProgressBar.setVisibility(i);
      return;
    }
  }
  
  public VideoData a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter != null) && (this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem());
    }
    return null;
  }
  
  public void dAh() {}
  
  public void de(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController = new StoryPlayController(getContext(), this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter, paramBundle, this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView, this.app, this.jdField_a_of_type_Ajvk);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController, paramBundle);
    setGestureListener(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController);
  }
  
  public void df(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.g(paramBundle);
  }
  
  public void init(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131561468, this, true);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager = ((CustomViewPager)localView.findViewById(2131381867));
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar = ((SplitedProgressBar)localView.findViewById(2131381811));
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)localView.findViewById(2131372766));
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getLayoutParams();
    localLayoutParams.height = jll.getScreenHeight(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    localLayoutParams.width = jll.getScreenWidth(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.requestLayout();
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new ajzc(this));
    this.closeBtn = ((ImageView)localView.findViewById(2131364694));
    this.closeBtn.setOnClickListener(new ajzd(this));
    this.jdField_a_of_type_Ajvn = new ajvn(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar);
    paramContext = new GestureDetector(paramContext, new c(null));
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setOnTouchListener(new ajze(this, paramContext));
    ((Activity)getContext()).getWindow().getDecorView().addOnLayoutChangeListener(new ajzf(this));
    this.mPlayTime = System.currentTimeMillis();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131364694) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b.lP(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b.lP(0);
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.doOnDestroy();
    this.mPlayTime = (System.currentTimeMillis() - this.mPlayTime);
    int j = this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem();
    int i;
    VideoData localVideoData;
    String str;
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem() >= this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.getCount() - 1)
    {
      i = 0;
      localVideoData = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a(this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem());
      if (localVideoData == null) {
        break label172;
      }
      str = localVideoData.id;
      label76:
      if (localVideoData == null) {
        break label180;
      }
    }
    label172:
    label180:
    for (long l = localVideoData.ads;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Native_ShortVideo_Report", 2, "player quit report module=short_video, action=view_quit, obj1=" + (j + 1) + ", obj3=" + i + ", obj4=" + this.mPlayTime + ", res2=" + str + ", anchor=" + l);
      }
      return;
      i = 1;
      break;
      str = "0";
      break label76;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    this.cqQ = false;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.doOnPause();
  }
  
  public void onResume()
  {
    this.cqQ = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.doOnResume();
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void setCallBack(ajvk paramajvk)
  {
    this.jdField_a_of_type_Ajvk = paramajvk;
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.setCurrentItem(paramInt, paramBoolean);
  }
  
  public void setGestureListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$a = parama;
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView$b = paramb;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.setOnCloseListener(paramb);
    }
  }
  
  public void setStatusBarHeight(int paramInt)
  {
    this.mStatusBarHeight = paramInt;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowViewSplitedProgressBar.setLayoutParams(localLayoutParams);
  }
  
  public static abstract interface a
  {
    public abstract void dzG();
    
    public abstract void dzH();
    
    public abstract void dzI();
    
    public abstract void dzJ();
    
    public abstract void dzK();
  }
  
  public static abstract interface b
  {
    public abstract void lP(int paramInt);
  }
  
  class c
    extends GestureDetector.SimpleOnGestureListener
  {
    private c() {}
    
    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (StuffContainerView.this.a == null) {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      float f2;
      if ((paramMotionEvent2 != null) && (paramMotionEvent1 != null))
      {
        float f1 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
        f2 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
        if (Math.abs(f1) <= Math.abs(f2)) {
          break label143;
        }
        if (Math.abs(Math.asin(Math.abs(f2) / Math.sqrt(f2 * f2 + f1 * f1))) < 0.5235987755982988D)
        {
          if (f1 >= 0.0F) {
            break label128;
          }
          StuffContainerView.this.a.dzH();
        }
      }
      for (;;)
      {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label128:
        StuffContainerView.this.a.dzK();
        continue;
        label143:
        if (f2 > 0.0F) {
          StuffContainerView.this.a.dzI();
        } else {
          StuffContainerView.this.a.dzJ();
        }
      }
    }
    
    public boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      if (StuffContainerView.this.a != null) {
        StuffContainerView.this.a.dzG();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.StuffContainerView
 * JD-Core Version:    0.7.0.1
 */