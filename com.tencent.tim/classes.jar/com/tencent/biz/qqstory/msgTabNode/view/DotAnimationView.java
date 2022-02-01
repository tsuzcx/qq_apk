package com.tencent.biz.qqstory.msgTabNode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rpq;

public class DotAnimationView
  extends View
{
  private static String TAG = "DotAnimationView";
  private int DEFAULT_OFFSET;
  private int MARGIN_LEFT_RIGHT;
  private int MAX_DOT_SIZE;
  private int MIN_DOT_SIZE;
  private int SCROLL_ANIMATION_CLOSE_END;
  private int SCROLL_ANIMATION_CLOSE_START;
  private int SCROLL_ANIMATION_OPEN_END;
  private int SCROLL_ANIMATION_OPEN_START;
  private boolean hasReset;
  private List<a> mDots = new ArrayList(3);
  private Paint mPaint;
  
  public DotAnimationView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public DotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public DotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawDots(Canvas paramCanvas)
  {
    Iterator localIterator = this.mDots.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramCanvas.drawCircle(getWidth() / 2 + locala.offset, getHeight() / 2, locala.radius, this.mPaint);
    }
  }
  
  private void init()
  {
    this.SCROLL_ANIMATION_OPEN_START = rpq.dip2px(getContext(), -20.0F);
    this.SCROLL_ANIMATION_OPEN_END = rpq.dip2px(getContext(), -50.0F);
    this.SCROLL_ANIMATION_CLOSE_START = rpq.dip2px(getContext(), -70.0F);
    this.SCROLL_ANIMATION_CLOSE_END = rpq.dip2px(getContext(), -95.0F);
    this.MIN_DOT_SIZE = rpq.dip2px(getContext(), 3.0F);
    this.MAX_DOT_SIZE = rpq.dip2px(getContext(), 6.0F);
    this.MARGIN_LEFT_RIGHT = rpq.dip2px(getContext(), 30.0F);
    this.DEFAULT_OFFSET = rpq.dip2px(getContext(), -20.0F);
    this.mPaint = new Paint();
    this.mPaint.setColor(Color.parseColor("#DDDEE2"));
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(0.1F);
    int i = 0;
    while (i < 3)
    {
      this.mDots.add(new a(null));
      i += 1;
    }
  }
  
  public void doOnScroll(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      return;
    }
    this.hasReset = false;
    Object localObject;
    a locala;
    if (paramFloat > this.SCROLL_ANIMATION_OPEN_START)
    {
      localObject = this.mDots.iterator();
      while (((Iterator)localObject).hasNext())
      {
        locala = (a)((Iterator)localObject).next();
        locala.radius = 0.0F;
        locala.offset = 0.0F;
      }
      ((a)this.mDots.get(1)).radius = (this.MAX_DOT_SIZE * (Math.abs(paramFloat) / Math.abs(this.SCROLL_ANIMATION_OPEN_START)));
    }
    for (;;)
    {
      invalidate();
      return;
      if (paramFloat > this.SCROLL_ANIMATION_OPEN_END)
      {
        paramFloat = (this.SCROLL_ANIMATION_OPEN_START - paramFloat) / (this.SCROLL_ANIMATION_OPEN_START - this.SCROLL_ANIMATION_OPEN_END);
        int i = 0;
        label142:
        if (i < this.mDots.size())
        {
          ((a)this.mDots.get(i)).offset = (((a)this.mDots.get(i)).finalOffset * paramFloat);
          if (i != 1) {
            break label242;
          }
        }
        label242:
        for (((a)this.mDots.get(i)).radius = (this.MAX_DOT_SIZE - (this.MAX_DOT_SIZE - this.MIN_DOT_SIZE) * paramFloat);; ((a)this.mDots.get(i)).radius = this.MIN_DOT_SIZE)
        {
          i += 1;
          break label142;
          break;
        }
      }
      if (paramFloat > this.SCROLL_ANIMATION_CLOSE_START)
      {
        localObject = this.mDots.iterator();
        while (((Iterator)localObject).hasNext())
        {
          locala = (a)((Iterator)localObject).next();
          locala.radius = this.MIN_DOT_SIZE;
          locala.offset = locala.finalOffset;
        }
      }
      else
      {
        localObject = this.mDots.iterator();
        while (((Iterator)localObject).hasNext())
        {
          locala = (a)((Iterator)localObject).next();
          locala.offset = locala.finalOffset;
        }
        float f1 = this.SCROLL_ANIMATION_CLOSE_START + (this.SCROLL_ANIMATION_CLOSE_END - this.SCROLL_ANIMATION_CLOSE_START) / 2;
        float f2 = this.SCROLL_ANIMATION_CLOSE_END;
        if (paramFloat > f1)
        {
          paramFloat = (this.SCROLL_ANIMATION_CLOSE_START - paramFloat) / (this.SCROLL_ANIMATION_CLOSE_START - f1);
          localObject = (a)this.mDots.get(0);
          locala = (a)this.mDots.get(2);
          paramFloat = this.MIN_DOT_SIZE - paramFloat * this.MIN_DOT_SIZE;
          locala.radius = paramFloat;
          ((a)localObject).radius = paramFloat;
          ((a)this.mDots.get(1)).radius = this.MIN_DOT_SIZE;
        }
        else if (paramFloat > f2)
        {
          paramFloat = (f1 - paramFloat) / (f1 - f2);
          localObject = (a)this.mDots.get(0);
          ((a)this.mDots.get(2)).radius = 0.0F;
          ((a)localObject).radius = 0.0F;
          ((a)this.mDots.get(1)).radius = (this.MIN_DOT_SIZE - paramFloat * this.MIN_DOT_SIZE);
        }
        else
        {
          localObject = this.mDots.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((a)((Iterator)localObject).next()).radius = 0.0F;
          }
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    drawDots(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.mDots.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      locala.radius = 0.0F;
      locala.offset = 0.0F;
      locala.finalOffset = 0.0F;
    }
    paramInt1 = this.MARGIN_LEFT_RIGHT;
    ((a)this.mDots.get(0)).finalOffset = this.DEFAULT_OFFSET;
    ((a)this.mDots.get(1)).finalOffset = 0.0F;
    ((a)this.mDots.get(2)).finalOffset = (-((a)this.mDots.get(0)).finalOffset);
    this.hasReset = false;
  }
  
  public void resetDots()
  {
    if (this.hasReset) {}
    int i;
    do
    {
      return;
      this.hasReset = true;
      Iterator localIterator = this.mDots.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala.radius != 0.0F) || (locala.offset != 0.0F)) {
          i = 1;
        }
        locala.radius = 0.0F;
        locala.offset = 0.0F;
      }
    } while (i == 0);
    setTranslationY(0.0F);
    invalidate();
  }
  
  class a
  {
    float finalOffset;
    float offset;
    float radius;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.DotAnimationView
 * JD-Core Version:    0.7.0.1
 */