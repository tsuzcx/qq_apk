package com.tencent.qqmail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;

public class EditTextInWebView
  extends EditText
{
  private static final String TAG = EditTextInWebView.class.getSimpleName();
  private boolean mScrolling = false;
  private TitleBarWebView2 mTitlebarWebView;
  private ArrayList<MotionEvent> mTouchEvent = new ArrayList();
  
  public EditTextInWebView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EditTextInWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EditTextInWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void releaseTouchEvent()
  {
    Iterator localIterator = this.mTouchEvent.iterator();
    while (localIterator.hasNext()) {
      ((MotionEvent)localIterator.next()).recycle();
    }
    this.mTouchEvent.clear();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mScrolling) {
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((bool) && (this.mTitlebarWebView != null)) {
      this.mTouchEvent.add(MotionEvent.obtain(paramMotionEvent));
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    if ((!bool) || (i == 3) || (i == 1)) {
      releaseTouchEvent();
    }
    return bool;
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (this.mScrolling) {
      return;
    }
    this.mScrolling = true;
    if (!hasSelection())
    {
      paramInt1 = getWidth();
      Iterator localIterator = this.mTouchEvent.iterator();
      while (localIterator.hasNext())
      {
        MotionEvent localMotionEvent = (MotionEvent)localIterator.next();
        localMotionEvent.setLocation(paramInt1 * 10, localMotionEvent.getY());
        if (this.mTitlebarWebView != null) {
          this.mTitlebarWebView.dispatchSuperTouchEvent(localMotionEvent);
        }
      }
    }
    this.mScrolling = false;
    if (this.mTouchEvent.size() > 0) {
      cancelLongPress();
    }
    releaseTouchEvent();
  }
  
  public void setTitleBarWebView(TitleBarWebView2 paramTitleBarWebView2)
  {
    this.mTitlebarWebView = paramTitleBarWebView2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.EditTextInWebView
 * JD-Core Version:    0.7.0.1
 */