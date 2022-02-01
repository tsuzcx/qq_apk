package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import rpq;
import rse;

public abstract class AbsEmptyView
  extends FrameLayout
{
  private Button cv;
  private int mHeight;
  private View mLoadingView;
  private int mMode = 0;
  private TextView mTipView;
  private int mWidth;
  private ImageView nz;
  private View pf;
  private View pg;
  private View ph;
  
  public AbsEmptyView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public AbsEmptyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void at(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (this.mMode != paramInt) {}
    }
    do
    {
      do
      {
        return;
      } while ((this.mMode == 0) && (paramInt == 3));
      this.mMode = paramInt;
      this.ph.setVisibility(8);
      if (paramInt == 0)
      {
        this.mLoadingView.setVisibility(8);
        this.pf.setVisibility(8);
        this.pg.setVisibility(8);
        return;
      }
      if (paramInt == 3)
      {
        this.mLoadingView.setVisibility(0);
        this.pf.setVisibility(8);
        this.pg.setVisibility(8);
        return;
      }
      if (paramInt == 1)
      {
        this.pg.setVisibility(0);
        this.pf.setVisibility(8);
        this.mLoadingView.setVisibility(8);
        this.mTipView = ((TextView)super.findViewById(2131382266));
        this.nz = ((ImageView)super.findViewById(2131382250));
        return;
      }
      if (paramInt == 2)
      {
        this.mLoadingView.setVisibility(8);
        this.pf.setVisibility(0);
        this.pg.setVisibility(8);
        this.mTipView = ((TextView)super.findViewById(2131379724));
        this.nz = ((ImageView)super.findViewById(2131363563));
        return;
      }
    } while (paramInt != 4);
    this.mLoadingView.setVisibility(8);
    this.pf.setVisibility(8);
    this.pg.setVisibility(8);
    this.ph.setVisibility(0);
  }
  
  private void init(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561948, this);
    this.mLoadingView = super.findViewById(2131370805);
    this.pf = super.findViewById(2131379716);
    this.pg = super.findViewById(2131379715);
    this.cv = ((Button)super.findViewById(2131377225));
    this.mTipView = ((TextView)super.findViewById(2131379724));
    this.nz = ((ImageView)super.findViewById(2131363563));
    this.ph = super.findViewById(2131380262);
    this.mWidth = rpq.getWindowScreenWidth(getContext());
    this.mHeight = getViewHeight();
    at(0, true);
    super.postDelayed(new AbsEmptyView.2(this), 500L);
  }
  
  public abstract int getViewHeight();
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
  }
  
  public void setRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.cv.setOnClickListener(null);
      return;
    }
    this.cv.setOnClickListener(new rse(this, paramOnClickListener));
  }
  
  public void xU(int paramInt)
  {
    at(paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.AbsEmptyView
 * JD-Core Version:    0.7.0.1
 */