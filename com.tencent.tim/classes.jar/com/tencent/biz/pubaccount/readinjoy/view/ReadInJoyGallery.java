package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.widget.Gallery;

public class ReadInJoyGallery
  extends Gallery
{
  public static final String TAG = "Q.readinjoy.atlas." + ReadInJoyGallery.class.getSimpleName();
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  protected a a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$b;
  private int aYn = 1;
  private boolean arL;
  boolean arM = false;
  private boolean arN;
  float mDownX;
  float mDownY;
  int mTouchSlop;
  boolean result = false;
  
  public ReadInJoyGallery(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    case 3: 
    default: 
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    do
    {
      return bool;
      this.arM = false;
      this.mDownX = paramMotionEvent.getX();
      this.mDownY = paramMotionEvent.getY();
      this.arL = false;
      break;
      if (this.arM)
      {
        if (this.result)
        {
          super.dispatchTouchEvent(paramMotionEvent);
          return true;
        }
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      f1 = paramMotionEvent.getX() - this.mDownX;
      f2 = paramMotionEvent.getY() - this.mDownY;
    } while ((Math.abs(f1) <= this.mTouchSlop) && (Math.abs(f2) <= this.mTouchSlop));
    this.arM = true;
    if (Math.abs(f1) > Math.abs(f2))
    {
      this.result = true;
      this.arL = true;
      if (f1 < 0.0F) {}
      for (int i = 1;; i = 2)
      {
        this.aYn = i;
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
      }
    }
    if (this.mIsScaling)
    {
      this.result = true;
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    this.result = false;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void forceLayout()
  {
    super.forceLayout();
  }
  
  protected void init()
  {
    setMaxScale(2.147484E+009F);
    this.mTouchSlop = (ViewConfiguration.get(getContext()).getScaledTouchSlop() / 3);
  }
  
  public boolean isNeedSetLongPicAction()
  {
    return true;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$a.aWq();
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.arN)
    {
      if (paramMotionEvent.getPointerCount() >= 2) {}
      do
      {
        do
        {
          return false;
          switch (paramMotionEvent.getAction())
          {
          case 3: 
          default: 
            return super.onInterceptTouchEvent(paramMotionEvent);
          case 0: 
            onTouchEvent(paramMotionEvent);
            return false;
          case 1: 
            if (this.arM)
            {
              if (this.arL) {
                return super.onInterceptTouchEvent(paramMotionEvent);
              }
              onTouchEvent(paramMotionEvent);
              return false;
            }
            paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
            paramMotionEvent.setAction(3);
            onTouchEvent(paramMotionEvent);
            return false;
          }
        } while (!this.arM);
        if (!this.arN) {
          break;
        }
      } while ((!this.arL) || (this.aYn != 2));
      return super.onInterceptTouchEvent(paramMotionEvent);
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    super.requestLayout();
  }
  
  public void setIsListPage(boolean paramBoolean)
  {
    this.arN = paramBoolean;
  }
  
  public void setOnDoubleTapListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$a = parama;
  }
  
  public void setOnScrollChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$b = paramb;
  }
  
  public void trackMotionScroll(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super.trackMotionScroll(paramInt1, paramInt2, paramBoolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$b != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyGallery$b.dh(paramInt1, paramInt2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void aWq();
  }
  
  public static abstract interface b
  {
    public abstract void dh(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyGallery
 * JD-Core Version:    0.7.0.1
 */