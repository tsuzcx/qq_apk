package me.ele.uetool.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import me.ele.uetool.UETool;
import me.ele.uetool.base.DimenUtil;

public class GriddingLayout
  extends LinearLayout
{
  public static final int LINE_INTERVAL = DimenUtil.dip2px(5.0F);
  private Activity bindActivity = UETool.getInstance().getTargetActivity();
  private Paint paint = new GriddingLayout.1(this);
  private RecyclerView recyclerView;
  private final int screenHeight = DimenUtil.getScreenHeight();
  private final int screenWidth = DimenUtil.getScreenWidth();
  
  public GriddingLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public GriddingLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GriddingLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.bindActivity.dispatchTouchEvent(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.bindActivity = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    super.onDraw(paramCanvas);
    int j;
    for (int i = 0;; i = LINE_INTERVAL + i)
    {
      j = k;
      if (i >= this.screenWidth) {
        break;
      }
      paramCanvas.drawLine(i, 0.0F, i, this.screenHeight, this.paint);
    }
    while (j < this.screenHeight)
    {
      paramCanvas.drawLine(0.0F, j, this.screenWidth, j, this.paint);
      j += LINE_INTERVAL;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.view.GriddingLayout
 * JD-Core Version:    0.7.0.1
 */