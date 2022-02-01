package com.tencent.biz.qqstory.view.widget.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import rpq;
import rta;

public class BubbleTextView
  extends TextView
{
  private rta a;
  public boolean aJG = true;
  public int bva = getResources().getColor(2131166744);
  public int bvb = 3;
  public float mAngle = rpq.dip2px(BaseApplicationImpl.getContext(), 3.0F);
  public int mBubbleType = 0;
  public float nX = rpq.dip2px(BaseApplicationImpl.getContext(), 11.0F);
  public float nY = rpq.dip2px(BaseApplicationImpl.getContext(), 5.0F);
  public float nZ = 50.0F;
  
  public BubbleTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public BubbleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void bwn()
  {
    int m = getPaddingLeft();
    int k = getPaddingRight();
    int j = getPaddingTop();
    int i = getPaddingBottom();
    switch (this.bvb)
    {
    }
    for (;;)
    {
      setPadding(m, j, k, i);
      return;
      m = (int)(m + this.nX);
      continue;
      k = (int)(k + this.nX);
      continue;
      j = (int)(j + this.nY);
      continue;
      i = (int)(i + this.nY);
    }
  }
  
  private void ew(int paramInt1, int paramInt2)
  {
    v(0, paramInt1, 0, paramInt2);
  }
  
  private void setup()
  {
    ew(getWidth(), getHeight());
  }
  
  private void v(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = new rta();
    this.a.mRect = new RectF(paramInt1, paramInt3, paramInt2, paramInt4);
    this.a.bvb = this.bvb;
    this.a.bvc = this.mBubbleType;
    this.a.mAngle = this.mAngle;
    this.a.nY = this.nY;
    this.a.nX = this.nX;
    this.a.bva = this.bva;
    this.a.nZ = this.nZ;
    this.a.aJG = this.aJG;
  }
  
  protected void bwm() {}
  
  public void initView()
  {
    bwm();
    bwn();
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a != null) {
      this.a.draw(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      ew(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView
 * JD-Core Version:    0.7.0.1
 */