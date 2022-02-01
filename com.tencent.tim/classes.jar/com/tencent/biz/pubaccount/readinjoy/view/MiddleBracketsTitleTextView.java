package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class MiddleBracketsTitleTextView
  extends TextView
{
  private int JO;
  private int acA = 2;
  private boolean arp;
  private Paint mPaint;
  private String title;
  
  public MiddleBracketsTitleTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MiddleBracketsTitleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MiddleBracketsTitleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void af(Canvas paramCanvas)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.JO = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
        if (this.mPaint.measureText(this.title) > this.acA * this.JO)
        {
          float f1 = this.mPaint.measureText("...]");
          float f2 = this.acA * this.JO;
          if (i < this.title.length())
          {
            String str = this.title.substring(0, i + 1);
            if (this.mPaint.measureText(str) <= f2 - 1.8F * f1) {
              break label183;
            }
            this.title = (this.title.substring(0, i) + "...]");
            setText(this.title);
          }
        }
        else
        {
          super.onDraw(paramCanvas);
          return;
        }
      }
      catch (Exception localException)
      {
        super.onDraw(paramCanvas);
        if (QLog.isColorLevel()) {
          QLog.d("MiddleBracketsTitleTextView", 2, "drawTitle", localException);
        }
      }
      return;
      label183:
      i += 1;
    }
  }
  
  private void init()
  {
    this.mPaint = getPaint();
    this.mPaint.setTextSize(getTextSize());
    this.mPaint.setColor(getCurrentTextColor());
    this.mPaint.setAntiAlias(true);
    this.mPaint.setTextAlign(Paint.Align.LEFT);
    this.mPaint.setStyle(Paint.Style.STROKE);
  }
  
  public boolean Fn()
  {
    try
    {
      Object localObject = getClass().getSuperclass().getDeclaredField("mLayout");
      ((Field)localObject).setAccessible(true);
      localObject = (Layout)((Field)localObject).get(this);
      if (localObject == null) {
        return false;
      }
      int i = ((Layout)localObject).getEllipsisCount(this.acA - 1);
      if (i > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiddleBracketsTitleTextView", 2, "checkOverLine", localException);
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.title != null) && (getText() != null) && (this.arp) && (Fn()))
    {
      af(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setNeedAddBrackets(boolean paramBoolean)
  {
    this.arp = paramBoolean;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.MiddleBracketsTitleTextView
 * JD-Core Version:    0.7.0.1
 */