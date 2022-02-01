package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoop;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.MessageProgressView;
import puh;
import pvr;
import ram;
import rpq;
import wja;

public class StoryMsgNodeFrameLayout
  extends FrameLayout
  implements URLDrawable.URLDrawableListener
{
  public RoundBorderImageView a;
  public MessageProgressView a;
  private Handler aH;
  public int bkQ = wja.dp2px(77.0F, getResources());
  public int bkR = wja.dp2px(58.0F, getResources());
  public int bkS;
  public int bkT;
  public int bkU = -1;
  private Runnable dn = new StoryMsgNodeFrameLayout.1(this);
  public View id;
  public ImageView my;
  public ImageView mz;
  public View oc;
  public TextView xa;
  public TextView xb;
  
  public StoryMsgNodeFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryMsgNodeFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private boolean i(puh parampuh)
  {
    ram.a("StoryMsgNodeFrameLayout", "checkNeedShowRedPoint, uid:%s, feedId:%s, redPoint:%s", Long.valueOf(parampuh.uid), parampuh.nodeFeedId, Boolean.valueOf(parampuh.redPoint));
    return parampuh.redPoint;
  }
  
  private void wa(int paramInt)
  {
    if (paramInt <= 0)
    {
      vZ(8);
      return;
    }
    if (paramInt < 10)
    {
      localLayoutParams = this.xa.getLayoutParams();
      localLayoutParams.width = rpq.dip2px(getContext(), 10.0F);
      this.xa.setLayoutParams(localLayoutParams);
      this.xa.setBackgroundResource(2130847497);
      this.xa.setText(String.valueOf(paramInt));
      return;
    }
    if (paramInt < 100)
    {
      localLayoutParams = this.xa.getLayoutParams();
      localLayoutParams.width = rpq.dip2px(getContext(), 14.0F);
      this.xa.setLayoutParams(localLayoutParams);
      this.xa.setBackgroundResource(2130847498);
      this.xa.setText(String.valueOf(paramInt));
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.xa.getLayoutParams();
    localLayoutParams.width = rpq.dip2px(getContext(), 19.0F);
    this.xa.setLayoutParams(localLayoutParams);
    this.xa.setBackgroundResource(2130847499);
    this.xa.setText("99+");
  }
  
  public void bne()
  {
    ram.d("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation()");
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    this.aH.post(this.dn);
  }
  
  public void bnf()
  {
    ram.d("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation()");
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, QQStoryContext.a().getCurrentUid());
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new pvr(this));
    this.aH.removeCallbacksAndMessages(null);
  }
  
  public void dR(int paramInt1, int paramInt2)
  {
    this.bkS = paramInt1;
    this.bkT = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setSegmentCount(this.bkS, this.bkT);
  }
  
  public void init(Context paramContext)
  {
    inflate(paramContext, 2131563368, this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView = ((RoundBorderImageView)findViewById(2131372026));
    this.my = ((ImageView)findViewById(2131372023));
    this.xb = ((TextView)findViewById(2131372028));
    this.xa = ((TextView)findViewById(2131372022));
    this.oc = findViewById(2131372029);
    this.id = findViewById(2131372027);
    this.mz = ((ImageView)findViewById(2131372025));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)findViewById(2131372024));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.bkH, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setBreathingCircleRadius(16.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    setDisplayState(0);
    this.aH = new Handler(Looper.getMainLooper());
  }
  
  public void n(puh parampuh)
  {
    int j = 0;
    int i = 0;
    switch (parampuh.nodeType)
    {
    case 8: 
    default: 
      vZ(8);
      this.mz.setVisibility(8);
      return;
    case 6: 
    case 7: 
      vZ(0);
      wa(parampuh.unreadCount);
      localImageView = this.mz;
      if (i(parampuh)) {}
      for (;;)
      {
        localImageView.setVisibility(i);
        return;
        i = 8;
      }
    }
    vZ(8);
    ImageView localImageView = this.mz;
    if (i(parampuh)) {}
    for (i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ram.d("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadFialed!");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ram.d("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadFialed!");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    ram.d("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadCanceled!");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ram.d("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadSuccessed!");
    if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      ram.d("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation reset drawable!");
      AbstractGifImage.resumeAll();
    }
  }
  
  public void setDisplayState(int paramInt)
  {
    if (paramInt == this.bkU) {}
    for (;;)
    {
      return;
      int i = wja.dp2px(56.0F, getResources());
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.su(false);
      switch (paramInt)
      {
      }
      while (i != this.bkR)
      {
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new RelativeLayout.LayoutParams(i, this.bkQ);
        }
        localLayoutParams1.width = i;
        localLayoutParams1.height = this.bkQ;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setLayoutParams(localLayoutParams1);
        this.bkR = i;
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.bmY();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.my.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setBadgeIcon(2130847518, true);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.su(true);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.my.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.bmY();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.my.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageResource(2130847521);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.Y(1.0F);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.bmY();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.my.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageResource(2130847521);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.bmY();
        this.my.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(8);
        this.my.setImageResource(2130847519);
        this.my.setVisibility(0);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.bmY();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.my.setVisibility(8);
      }
    }
  }
  
  public void setNodeName(String paramString, @DrawableRes int paramInt)
  {
    this.xb.setText(paramString);
    if (paramInt != 0) {
      this.xb.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(paramInt), null);
    }
    for (;;)
    {
      paramInt = getContext().getResources().getColor(2131167311);
      this.xb.setTextColor(paramInt);
      return;
      this.xb.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
  }
  
  public void setNodeName(String paramString1, String paramString2)
  {
    this.xb.setText(paramString1);
    paramString1 = aoop.am();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString1;
    localURLDrawableOptions.mFailedDrawable = paramString1;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    localURLDrawableOptions.mRequestWidth = rpq.dip2px(getContext(), 12.0F);
    localURLDrawableOptions.mRequestHeight = rpq.dip2px(getContext(), 12.0F);
    paramString1 = URLDrawable.getDrawable(paramString2, localURLDrawableOptions);
    this.xb.setCompoundDrawablesWithIntrinsicBounds(null, null, paramString1, null);
    int i = getContext().getResources().getColor(2131167311);
    this.xb.setTextColor(i);
  }
  
  public void setNodeName(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setNodeName(paramString, 2130847522);
      return;
    }
    setNodeName(paramString, 0);
  }
  
  protected void vZ(int paramInt)
  {
    this.id.setVisibility(paramInt);
    this.oc.setVisibility(paramInt);
    this.xa.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout
 * JD-Core Version:    0.7.0.1
 */