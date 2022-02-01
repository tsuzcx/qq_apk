package com.tencent.biz.qqstory.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import ram;
import rpq;

public class StoryCoverView
  extends FrameLayout
{
  public InteractContainerLayout b;
  public PollContainerLayout b;
  public ImageView mImageView;
  
  public StoryCoverView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryCoverView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mImageView = new ImageView(paramContext);
    this.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -1);
    FrameLayout.LayoutParams localLayoutParams3 = new FrameLayout.LayoutParams(-1, -1);
    addView(this.mImageView, localLayoutParams1);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetPollContainerLayout = new PollContainerLayout(paramContext);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.ac(true);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.setClickable(false);
    addView(this.jdField_b_of_type_ComTencentBizQqstoryWidgetPollContainerLayout, localLayoutParams2);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout = new InteractContainerLayout(paramContext);
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout.setClickable(false);
    addView(this.jdField_b_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout, localLayoutParams3);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 0 });
    int i = paramContext.getInt(0, -1);
    if (i >= 0)
    {
      paramAttributeSet = ImageView.ScaleType.values();
      if (paramAttributeSet.length > i) {
        this.mImageView.setScaleType(paramAttributeSet[i]);
      }
    }
    paramContext.recycle();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ram.b("StoryCoverView", "onLayout wh(%d, %d)", Integer.valueOf(paramInt3 - paramInt1), Integer.valueOf(paramInt4 - paramInt2));
  }
  
  public void setCoverUrl(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    rpq.a(this.mImageView, paramString, paramInt1, paramInt2, paramInt3, null, "Qim_Profile_Story" + paramInt1 + "_" + paramInt2 + "_" + paramInt3);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.mImageView.setImageDrawable(paramDrawable);
  }
  
  public void setPollLayout(StoryVideoItem.b paramb, int paramInt, int[] paramArrayOfInt)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetPollContainerLayout.a(paramb, paramInt, paramArrayOfInt);
  }
  
  public void setRateLayout(StoryVideoItem.a parama, int paramInt1, long paramLong, int paramInt2)
  {
    ram.a("StoryCoverView", "setRateLayout, layout=%s, rateResult=%s, totalScore=%s, totalCount=%s", parama, Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2));
    this.jdField_b_of_type_ComTencentBizQqstoryWidgetInteractContainerLayout.a(parama, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.StoryCoverView
 * JD-Core Version:    0.7.0.1
 */