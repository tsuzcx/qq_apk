package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

public class GlowCountRecyclerView
  extends RecyclerView
  implements Handler.Callback
{
  int acD;
  int dqX;
  int drq = -1;
  int drr;
  int drs;
  Drawable fj;
  Handler handler = new Handler(this);
  Paint paint;
  boolean show;
  String text = "";
  int textColor = -1;
  int textSize;
  
  public GlowCountRecyclerView(Context paramContext)
  {
    this(paramContext, null);
    init();
  }
  
  public GlowCountRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    init();
  }
  
  public GlowCountRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void dEK()
  {
    Object localObject = new Rect();
    this.paint.getTextBounds(this.text, 0, this.text.length(), (Rect)localObject);
    this.acD = ((Rect)localObject).width();
    localObject = this.paint.getFontMetrics();
    this.dqX = ((int)(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top + 0.5F));
  }
  
  private void init()
  {
    float f = getResources().getDisplayMetrics().density;
    this.drr = ((int)(8.0F * f));
    this.paint = new Paint(1);
    this.paint.setTextAlign(Paint.Align.CENTER);
    this.paint.setColor(-1);
    this.paint.setTextSize(14.0F * f);
    this.drs = ((int)(f * 3.0F));
    this.fj = getResources().getDrawable(2130846574);
  }
  
  public boolean atk()
  {
    boolean bool = false;
    if ((this.show) || (this.handler.hasMessages(0))) {
      bool = true;
    }
    return bool;
  }
  
  public void dEL()
  {
    if (this.show)
    {
      this.handler.removeMessages(0);
      this.handler.sendEmptyMessageDelayed(0, 750L);
      invalidate();
    }
    this.show = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = getLayoutManager();
    int i;
    if ((localObject instanceof LinearLayoutManager)) {
      i = ((LinearLayoutManager)localObject).findFirstCompletelyVisibleItemPosition();
    }
    for (;;)
    {
      if ((atk()) && (i == 0))
      {
        this.fj.setBounds(0, 0, this.acD + this.drs * 2, this.dqX + this.drs * 2);
        i = (int)(getPaddingLeft() + 5.0F * getResources().getDisplayMetrics().density);
        localObject = this.paint.getFontMetrics();
        int j = (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom()) * 0.5F - (this.dqX + this.drs * 2) * 0.5F);
        int k = (int)(j - ((Paint.FontMetrics)localObject).top + this.drs);
        paramCanvas.save();
        paramCanvas.translate(i, j);
        this.fj.draw(paramCanvas);
        paramCanvas.restore();
        paramCanvas.save();
        paramCanvas.translate(i + this.drs, 0.0F);
        paramCanvas.drawText(this.text, this.acD * 0.5F, k, this.paint);
        paramCanvas.restore();
      }
      return;
      if ((localObject instanceof StaggeredGridLayoutManager)) {
        i = ((StaggeredGridLayoutManager)localObject).findFirstCompletelyVisibleItemPositions(null)[0];
      } else {
        i = -1;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      invalidate();
    }
    return false;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.handler.removeCallbacksAndMessages(null);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return bool;
    case 0: 
      this.drq = ((int)paramMotionEvent.getX());
      return bool;
    case 1: 
      dEL();
      this.drq = -1;
      return bool;
    }
    dEL();
    this.drq = -1;
    return bool;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return bool;
        this.drq = ((int)paramMotionEvent.getX());
        return bool;
      } while ((this.drq < 0) || (this.show));
      if ((int)(paramMotionEvent.getX() - this.drq) > this.drr) {
        this.show = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GlowCountRecyclerView", 2, "move show");
      }
      invalidate();
      return bool;
    case 1: 
      dEL();
      this.drq = -1;
      return bool;
    }
    dEL();
    this.drq = -1;
    return bool;
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.equals(paramString, this.text))
    {
      this.text = paramString;
      dEK();
      invalidate();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (paramInt != this.textColor)
    {
      this.textColor = paramInt;
      this.paint.setColor(paramInt);
      invalidate();
    }
  }
  
  public void setTextSizeDp(int paramInt)
  {
    paramInt = (int)(paramInt * getResources().getDisplayMetrics().density);
    if (paramInt != this.textSize)
    {
      this.textSize = paramInt;
      this.paint.setTextSize(paramInt);
      dEK();
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.GlowCountRecyclerView
 * JD-Core Version:    0.7.0.1
 */