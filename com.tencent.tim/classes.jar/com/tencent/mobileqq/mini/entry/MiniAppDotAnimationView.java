package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import aqnm;
import com.tencent.mobileqq.mini.util.ColorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MiniAppDotAnimationView
  extends View
{
  private static final int DEFAULT_OFFSET = aqnm.dpToPx(-20.0F);
  private static final int MARGIN_LEFT_RIGHT;
  private static final int MAX_DOT_SIZE;
  private static final int MIN_DOT_SIZE;
  private static final int SCROLL_ANIMATION_CLOSE_END;
  private static final int SCROLL_ANIMATION_CLOSE_START;
  private static final int SCROLL_ANIMATION_OPEN_END;
  private static final int SCROLL_ANIMATION_OPEN_START;
  private static String TAG = "MiniAppDotAnimationView";
  private boolean hasReset;
  private List<Dot> mDots = new ArrayList(3);
  private Paint mPaint;
  
  static
  {
    SCROLL_ANIMATION_OPEN_START = aqnm.dpToPx(-20.0F);
    SCROLL_ANIMATION_OPEN_END = aqnm.dpToPx(-50.0F);
    SCROLL_ANIMATION_CLOSE_START = aqnm.dpToPx(-70.0F);
    SCROLL_ANIMATION_CLOSE_END = aqnm.dpToPx(-95.0F);
    MIN_DOT_SIZE = aqnm.dpToPx(3.0F);
    MAX_DOT_SIZE = aqnm.dpToPx(6.0F);
    MARGIN_LEFT_RIGHT = aqnm.dpToPx(30.0F);
  }
  
  public MiniAppDotAnimationView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MiniAppDotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MiniAppDotAnimationView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void drawDots(Canvas paramCanvas)
  {
    Iterator localIterator = this.mDots.iterator();
    while (localIterator.hasNext())
    {
      Dot localDot = (Dot)localIterator.next();
      paramCanvas.drawCircle(getWidth() / 2 + localDot.offset, getHeight() / 2, localDot.radius, this.mPaint);
    }
  }
  
  private void init()
  {
    this.mPaint = new Paint();
    this.mPaint.setColor(ColorUtils.parseColor("#DDDEE2"));
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setStrokeWidth(0.1F);
    this.mPaint.setAntiAlias(true);
    int i = 0;
    while (i < 3)
    {
      this.mDots.add(new Dot(null));
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
    Dot localDot;
    if (paramFloat > SCROLL_ANIMATION_OPEN_START)
    {
      localObject = this.mDots.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDot = (Dot)((Iterator)localObject).next();
        localDot.radius = 0.0F;
        localDot.offset = 0.0F;
      }
      ((Dot)this.mDots.get(1)).radius = (MAX_DOT_SIZE * (Math.abs(paramFloat) / Math.abs(SCROLL_ANIMATION_OPEN_START)));
    }
    for (;;)
    {
      invalidate();
      return;
      if (paramFloat > SCROLL_ANIMATION_OPEN_END)
      {
        paramFloat = (SCROLL_ANIMATION_OPEN_START - paramFloat) / (SCROLL_ANIMATION_OPEN_START - SCROLL_ANIMATION_OPEN_END);
        int i = 0;
        label135:
        if (i < this.mDots.size())
        {
          ((Dot)this.mDots.get(i)).offset = (((Dot)this.mDots.get(i)).finalOffset * paramFloat);
          if (i != 1) {
            break label232;
          }
        }
        label232:
        for (((Dot)this.mDots.get(i)).radius = (MAX_DOT_SIZE - (MAX_DOT_SIZE - MIN_DOT_SIZE) * paramFloat);; ((Dot)this.mDots.get(i)).radius = MIN_DOT_SIZE)
        {
          i += 1;
          break label135;
          break;
        }
      }
      if (paramFloat > SCROLL_ANIMATION_CLOSE_START)
      {
        localObject = this.mDots.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDot = (Dot)((Iterator)localObject).next();
          localDot.radius = MIN_DOT_SIZE;
          localDot.offset = localDot.finalOffset;
        }
      }
      else
      {
        localObject = this.mDots.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localDot = (Dot)((Iterator)localObject).next();
          localDot.offset = localDot.finalOffset;
        }
        float f1 = SCROLL_ANIMATION_CLOSE_START + (SCROLL_ANIMATION_CLOSE_END - SCROLL_ANIMATION_CLOSE_START) / 2;
        float f2 = SCROLL_ANIMATION_CLOSE_END;
        if (paramFloat > f1)
        {
          paramFloat = (SCROLL_ANIMATION_CLOSE_START - paramFloat) / (SCROLL_ANIMATION_CLOSE_START - f1);
          localObject = (Dot)this.mDots.get(0);
          localDot = (Dot)this.mDots.get(2);
          paramFloat = MIN_DOT_SIZE - paramFloat * MIN_DOT_SIZE;
          localDot.radius = paramFloat;
          ((Dot)localObject).radius = paramFloat;
          ((Dot)this.mDots.get(1)).radius = MIN_DOT_SIZE;
        }
        else if (paramFloat > f2)
        {
          paramFloat = (f1 - paramFloat) / (f1 - f2);
          localObject = (Dot)this.mDots.get(0);
          ((Dot)this.mDots.get(2)).radius = 0.0F;
          ((Dot)localObject).radius = 0.0F;
          ((Dot)this.mDots.get(1)).radius = (MIN_DOT_SIZE - paramFloat * MIN_DOT_SIZE);
        }
        else
        {
          localObject = this.mDots.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((Dot)((Iterator)localObject).next()).radius = 0.0F;
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
      Dot localDot = (Dot)localIterator.next();
      localDot.radius = 0.0F;
      localDot.offset = 0.0F;
      localDot.finalOffset = 0.0F;
    }
    paramInt1 = MARGIN_LEFT_RIGHT;
    ((Dot)this.mDots.get(0)).finalOffset = DEFAULT_OFFSET;
    ((Dot)this.mDots.get(1)).finalOffset = 0.0F;
    ((Dot)this.mDots.get(2)).finalOffset = (-((Dot)this.mDots.get(0)).finalOffset);
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
        Dot localDot = (Dot)localIterator.next();
        if ((localDot.radius != 0.0F) || (localDot.offset != 0.0F)) {
          i = 1;
        }
        localDot.radius = 0.0F;
        localDot.offset = 0.0F;
      }
    } while (i == 0);
    setTranslationY(0.0F);
    invalidate();
  }
  
  class Dot
  {
    float finalOffset;
    float offset;
    float radius;
    
    private Dot() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppDotAnimationView
 * JD-Core Version:    0.7.0.1
 */