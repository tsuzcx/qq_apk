package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import awit;
import awta;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView.a;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import kxm;
import qmc;
import qmc.f;
import rex;
import rnl;
import rnm;
import rnn;
import rpq;

public class ScrollFrameSelectBar
  extends FrameLayout
  implements TrimTextureVideoView.a, RangeSelectBar.a, qmc.f
{
  public static int PADDING_LEFT_DP = 15;
  public static int PADDING_RIGHT_DP = 15;
  private ProgressPointer jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer;
  private RangeSelectBar jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar;
  private a jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$a;
  private rnl jdField_a_of_type_Rnl;
  private rnm jdField_a_of_type_Rnm;
  private TrimTextureVideoView b;
  private int btC = 1000;
  private int btD;
  private int btE;
  private int btF;
  private int btG;
  private int btH = 20000;
  private int btI = 1000;
  private int btJ;
  private int btK = this.btI * 10;
  private HorizontalListView i;
  private int mDuration;
  private int mHeight;
  private int mPaddingLeft;
  private int mPaddingRight;
  private int mScreenWidth;
  private int mWidth;
  
  public ScrollFrameSelectBar(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ScrollFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ScrollFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  @TargetApi(10)
  private void init()
  {
    this.mScreenWidth = rpq.getWindowScreenWidth(getContext());
    this.mPaddingLeft = rpq.dip2px(getContext(), PADDING_LEFT_DP);
    this.mPaddingRight = rpq.dip2px(getContext(), PADDING_RIGHT_DP);
    LayoutInflater.from(getContext()).inflate(2131563005, this);
    this.i = ((HorizontalListView)findViewById(2131377760));
    this.i.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar = ((RangeSelectBar)findViewById(2131377761));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer = ((ProgressPointer)findViewById(2131375158));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setRangeChangeListener(this);
    this.btE = this.i.getPaddingLeft();
    this.btF = this.i.getPaddingRight();
    this.btG = ((FrameLayout.LayoutParams)this.i.getLayoutParams()).rightMargin;
    this.i.setOnScrollStateChangedListener(new rnn(this));
    if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {
      this.btI = (awta.eCL / 10);
    }
  }
  
  public int[] B()
  {
    View localView = this.i.getChildAt(0);
    if (localView == null) {
      return null;
    }
    int j = this.i.getFirstVisiblePosition();
    int k = localView.getLeft() - this.btE;
    float f1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.getStartIndex();
    float f2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.getEndIndex();
    float f3 = this.btI;
    float f4 = -k / localView.getWidth();
    float f5 = j;
    int m = (int)((f1 - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.tH()) / this.btD * f3 + (f4 * f3 + f5 * f3));
    int n = (int)(-k / localView.getWidth() * f3 + j * f3 + (f2 - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.tH()) / this.btD * f3);
    j = n;
    k = m;
    if (n - m < this.btC)
    {
      if (m < this.btC) {
        break label208;
      }
      k = n - this.btC;
      j = n;
    }
    for (;;)
    {
      return new int[] { k, j };
      label208:
      j = this.btC + m;
      k = m;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    if ((paramInt2 >= 0) && (paramInt3 > 0) && (paramInt1 >= 0))
    {
      this.i.scrollBy2(paramInt1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setStartIndex(paramInt2);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setEndIndex(paramInt3);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.frameWidget.ScrollFrameSelectBar", 2, "changeSelectBarState rememberUI startIndex : " + paramInt2 + " endIndex : " + paramInt3 + " scrollX : " + paramInt1);
      }
    }
    while ((paramLong2 >= 20L) || (paramLong1 <= paramLong2)) {
      return;
    }
    paramInt1 = (int)((float)paramLong1 / this.btI * this.btD + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.tH());
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.frameWidget.ScrollFrameSelectBar", 2, "changeSelectBarState startTime : " + paramLong2 + " endIndex : " + paramInt1 + " endTime : " + paramLong1);
    }
    this.i.scrollBy2(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setStartIndex(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setEndIndex(paramInt1);
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_Rnl == null) {
      return;
    }
    this.jdField_a_of_type_Rnl.a(paramLocalMediaInfo);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4)
  {
    int j = getResources().getDisplayMetrics().widthPixels;
    j = getResources().getDisplayMetrics().heightPixels;
    j = this.mWidth;
    this.mDuration = paramInt1;
    float f;
    switch (paramInt4)
    {
    default: 
      if (paramBoolean2) {
        if (this.mDuration > 60000)
        {
          this.btI = 6000;
          paramInt4 = (int)Math.ceil(this.mDuration * 1.0F / this.btI);
          f = this.mDuration * 1.0F / this.btI;
          this.btD = ((j - this.mPaddingLeft - this.mPaddingRight) / 10);
          paramInt3 = (int)(paramInt3 / paramInt2 * this.btD);
          paramInt2 = (int)(this.btD * rex.a(getResources()));
          this.jdField_a_of_type_Rnl = new rnl(getContext(), paramInt4, this.btD, paramInt2);
          this.jdField_a_of_type_Rnm = new rnm("frame_loader", this.btD, paramInt3, paramBoolean1);
          this.jdField_a_of_type_Rnm.y(paramString, paramInt1, this.btI);
          this.jdField_a_of_type_Rnl.a(this.jdField_a_of_type_Rnm);
          if (paramInt4 <= 10) {
            break label609;
          }
        }
      }
      break;
    }
    label609:
    for (paramInt1 = 10;; paramInt1 = paramInt4)
    {
      ((FrameLayout.LayoutParams)this.i.getLayoutParams()).rightMargin = (j - this.mPaddingLeft - this.mPaddingRight - paramInt1 * this.btD);
      this.i.setAdapter(this.jdField_a_of_type_Rnl);
      if (f > 10.0F) {
        f = 10.0F;
      }
      for (;;)
      {
        if (paramInt2 <= 0) {}
        for (paramInt1 = 100;; paramInt1 = paramInt2)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setFrameSize(paramInt1, this.btD, this.btI, f, this.btC);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setFrameSize(paramInt1, this.btD);
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.setVisibility(0);
          bvD();
          return;
          paramInt4 = awit.k(kxm.getAppRuntime());
          if (this.mDuration > paramInt4 * 1000)
          {
            this.btI = (paramInt4 * 100);
            paramInt4 = (int)Math.ceil(this.mDuration * 1.0F / this.btI);
            f = this.mDuration * 1.0F / this.btI;
            break;
          }
          this.btI = ((int)Math.ceil(this.mDuration * 1.0F / 10.0F));
          f = 10;
          paramInt4 = 10;
          break;
          this.btI = ((int)Math.ceil(this.mDuration * 1.0F / 10.0F));
          f = 10;
          this.mPaddingRight = 0;
          paramInt4 = 10;
          break;
          if ("tribe".equals(((Activity)getContext()).getIntent().getStringExtra("video_refer"))) {}
          for (this.btI = (awta.eCL / 10);; this.btI = (this.btH / 10))
          {
            paramInt4 = (int)Math.ceil(this.mDuration * 1.0F / this.btI);
            f = this.mDuration * 1.0F / this.btI;
            if (paramInt4 <= 10) {
              this.btI = ((int)Math.ceil(this.mDuration * 1.0F / paramInt4));
            }
            break;
          }
        }
      }
    }
  }
  
  public void boS()
  {
    if (this.b != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setRange(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.getStartIndex(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.getEndIndex(), this.btK - this.b.sJ());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.reset();
  }
  
  public void bvC()
  {
    bvE();
  }
  
  public void bvD()
  {
    int[] arrayOfInt = B();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      return;
    }
    this.btJ = arrayOfInt[0];
    this.btK = arrayOfInt[1];
    if (this.b.isPlaying()) {
      this.b.pausePlay();
    }
    this.b.setPlayRange(this.btJ, this.btK);
    this.b.sJ(true);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$a != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$a.ee(this.btJ, this.btK);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.setRange(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.getStartIndex(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.getEndIndex(), this.btK - this.b.sJ());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.reset();
  }
  
  public void bvE()
  {
    int[] arrayOfInt = B();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {}
    while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$a == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$a.ef(arrayOfInt[0], arrayOfInt[1]);
  }
  
  public void c(qmc paramqmc)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarProgressPointer.bvB();
  }
  
  @TargetApi(10)
  public void detach()
  {
    if (this.jdField_a_of_type_Rnl != null) {
      this.jdField_a_of_type_Rnl.release();
    }
    if (this.jdField_a_of_type_Rnm != null) {
      this.jdField_a_of_type_Rnm.release();
    }
  }
  
  public void es(int paramInt1, int paramInt2)
  {
    bvD();
  }
  
  public int getEndIndex()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.getEndIndex();
  }
  
  public int getStartIndex()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarRangeSelectBar.getStartIndex();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mWidth = View.MeasureSpec.getSize(paramInt1);
    this.mHeight = View.MeasureSpec.getSize(paramInt2);
  }
  
  public void setLocalVideoView(TrimTextureVideoView paramTrimTextureVideoView)
  {
    this.b = paramTrimTextureVideoView;
    paramTrimTextureVideoView.setOnRecyclePlayListener(this);
    paramTrimTextureVideoView.setOnSeekCompleteListener(this);
  }
  
  public void setMaxVideoDuration(int paramInt)
  {
    this.btH = paramInt;
  }
  
  public void setMinDuration(int paramInt)
  {
    this.btC = paramInt;
  }
  
  public void setOnRangeValueChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetFrameSelectBarScrollFrameSelectBar$a = parama;
  }
  
  public int tI()
  {
    return this.btJ;
  }
  
  public int tJ()
  {
    return this.btK;
  }
  
  public int tK()
  {
    View localView = this.i.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int j = this.i.getFirstVisiblePosition();
    int k = -(localView.getLeft() - this.btE);
    return j * localView.getWidth() + k;
  }
  
  public static abstract interface a
  {
    public abstract void ee(int paramInt1, int paramInt2);
    
    public abstract void ef(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */