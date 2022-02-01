package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.concurrent.ConcurrentHashMap;

public class BottomHorizonLineView
  extends RelativeLayout
{
  private static final int FIX_RIGHT_MAX_COUNT = 1;
  private Context context;
  private View mDivder;
  private int mRightFixWidth;
  private PressableImageView mRightFixedView;
  private BottomHorizontalLineScrollView mScrollView;
  private ConcurrentHashMap<Integer, PressableImageView> pressableImageViewHashMap = new ConcurrentHashMap();
  
  public BottomHorizonLineView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public BottomHorizonLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public BottomHorizonLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void handleRightViewWidth(int paramInt)
  {
    int i = this.mScrollView.getViewCount();
    if (i <= 1) {}
    for (this.mRightFixedView.getLayoutParams().width = (paramInt / (i + 1));; this.mRightFixedView.getLayoutParams().width = this.mRightFixWidth)
    {
      this.mRightFixedView.requestLayout();
      return;
    }
  }
  
  public void addItem(int paramInt, View.OnClickListener paramOnClickListener)
  {
    addItem(paramInt, paramOnClickListener, false);
  }
  
  public void addItem(int paramInt, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mRightFixedView.setImageResource(paramInt);
      this.mRightFixedView.setOnClickListener(paramOnClickListener);
      this.pressableImageViewHashMap.put(Integer.valueOf(paramInt), this.mRightFixedView);
      return;
    }
    PressableImageView localPressableImageView = new PressableImageView(this.context);
    localPressableImageView.setImageResource(paramInt);
    localPressableImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localPressableImageView.setOnClickListener(paramOnClickListener);
    this.mScrollView.addItem(localPressableImageView);
    handleRightViewWidth(getWidth());
    this.pressableImageViewHashMap.put(Integer.valueOf(paramInt), localPressableImageView);
  }
  
  public PressableImageView getPressableImageViewByResourcesId(int paramInt)
  {
    return (PressableImageView)this.pressableImageViewHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
    LayoutInflater.from(paramContext).inflate(2131558782, this, true);
    this.mScrollView = ((BottomHorizontalLineScrollView)findViewById(2131377772));
    this.mRightFixedView = ((PressableImageView)findViewById(2131377300));
    this.mDivder = findViewById(2131365990);
    this.mRightFixWidth = getResources().getDimensionPixelSize(2131296711);
    addOnLayoutChangeListener(new BottomHorizonLineView.1(this));
    if (getWidth() > 0) {
      handleRightViewWidth(getWidth());
    }
  }
  
  public void toggleRightFixedViewVisiable(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mScrollView.getLayoutParams();
    if (!paramBoolean)
    {
      this.mRightFixedView.setVisibility(8);
      this.mDivder.setVisibility(8);
      localLayoutParams.addRule(0, 0);
      localLayoutParams.addRule(11, -1);
      this.mScrollView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      invalidate();
      return;
      this.mRightFixedView.setVisibility(0);
      this.mDivder.setVisibility(0);
      localLayoutParams.addRule(0, this.mDivder.getId());
      localLayoutParams.addRule(11, 0);
      this.mScrollView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.BottomHorizonLineView
 * JD-Core Version:    0.7.0.1
 */