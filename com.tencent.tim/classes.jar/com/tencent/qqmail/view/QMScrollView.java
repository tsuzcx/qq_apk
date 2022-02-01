package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ScrollView;

public class QMScrollView
  extends ScrollView
{
  public static final int DRAG = 1;
  public static final int HDRAG = 3;
  public static final int NONE = 0;
  public static final int VDRAG = 4;
  public static final int ZOOM = 2;
  private int distanceX;
  private int distanceY;
  private int mLastX;
  private int mLastY;
  private int mTouchSlop;
  public int mode = 0;
  private WebView webView;
  
  public QMScrollView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QMScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QMScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  private float spacing(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public void initSubWebView(WebView paramWebView)
  {
    this.webView = paramWebView;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = false;
      label284:
      do
      {
        return bool;
        this.webView.getSettings().setUseWideViewPort(true);
        this.distanceX = 0;
        this.distanceY = 0;
        this.mLastX = ((int)paramMotionEvent.getX());
        this.mLastY = ((int)paramMotionEvent.getY());
        this.mode = 1;
        break;
        if (((this.distanceY > this.mTouchSlop) || (this.distanceX > this.mTouchSlop)) && ((this.mode == 1) || (this.mode == 3) || (this.mode == 4)))
        {
          if (this.distanceY <= this.distanceX) {
            break label284;
          }
          this.webView.loadUrl("javascript:getHeight()");
        }
        for (this.mode = 4;; this.mode = 3)
        {
          this.webView.getSettings().setUseWideViewPort(false);
          int i = Math.abs((int)(this.mLastX - paramMotionEvent.getX()));
          this.mLastX = ((int)paramMotionEvent.getX());
          this.distanceX = (i + this.distanceX);
          i = Math.abs((int)(this.mLastY - paramMotionEvent.getY()));
          this.mLastY = ((int)paramMotionEvent.getY());
          this.distanceY = (i + this.distanceY);
          break;
        }
        if (spacing(paramMotionEvent) <= 10.0F) {
          break;
        }
        this.mode = 2;
        break;
        if (spacing(paramMotionEvent) <= 10.0F) {
          break;
        }
        this.mode = 2;
        break;
        this.mode = 0;
        break;
      } while ((this.distanceY > this.mTouchSlop) && (this.distanceX < this.mTouchSlop));
      this.distanceX = 0;
      this.distanceY = 0;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMScrollView
 * JD-Core Version:    0.7.0.1
 */