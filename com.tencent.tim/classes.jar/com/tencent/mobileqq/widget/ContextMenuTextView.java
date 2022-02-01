package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import aofk;
import aofk.a;
import aqgq;
import aqoa;
import arfa;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.BubblePopupWindow.b;

public class ContextMenuTextView
  extends TextView
{
  b jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView$b;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  View.OnClickListener cp = new arfa(this);
  private Drawable[] hold;
  private boolean mBlockRelayout;
  private Context mContext;
  
  public ContextMenuTextView(Context paramContext)
  {
    super(paramContext);
    this.a = new b(null);
    this.mContext = paramContext;
    setOnLongClickListener(this.a);
    setSelectAllOnFocus(true);
  }
  
  public ContextMenuTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new b(null);
    this.mContext = paramContext;
    setOnLongClickListener(this.a);
    setSelectAllOnFocus(true);
    setOnTouchListener(this.a);
  }
  
  private void invlidateSpan(Object paramObject)
  {
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int j = ((Spannable)localObject).getSpanStart(paramObject);
      int k = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(j, k, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int m = arrayOfSpanWatcher.length;
        int i = 0;
        while (i < m)
        {
          arrayOfSpanWatcher[i].onSpanChanged((Spannable)localObject, paramObject, j, k, j, k);
          i += 1;
        }
      }
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    Object localObject1 = getText();
    if ((localObject1 instanceof Spannable))
    {
      localObject1 = (Spannable)localObject1;
      localObject1 = (aofk.a[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), aofk.a.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.mBlockRelayout = true;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getDrawable() == paramDrawable) {
            invlidateSpan(localObject2);
          }
          i += 1;
        }
        this.mBlockRelayout = false;
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockRelayout) {
      super.requestLayout();
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    int i = 0;
    if (!getText().equals(paramCharSequence))
    {
      super.setText(paramCharSequence, paramBufferType);
      if ((getText() instanceof aofk))
      {
        paramCharSequence = (Spannable)getText();
        paramCharSequence = (aofk.a[])paramCharSequence.getSpans(0, paramCharSequence.length(), aofk.a.class);
        paramBufferType = new Drawable[paramCharSequence.length];
        while (i < paramCharSequence.length)
        {
          paramBufferType[i] = paramCharSequence[i].getDrawable();
          paramBufferType[i].setCallback(this);
          i += 1;
        }
        this.hold = paramBufferType;
      }
    }
  }
  
  @TargetApi(16)
  class a
    implements BubblePopupWindow.b
  {
    a() {}
    
    public void onDismiss()
    {
      if (Build.VERSION.SDK_INT < 16) {
        ContextMenuTextView.a(ContextMenuTextView.this, null);
      }
      for (;;)
      {
        ContextMenuTextView.this.a = null;
        return;
        ContextMenuTextView.b(ContextMenuTextView.this, null);
      }
    }
  }
  
  class b
    implements View.OnLongClickListener, View.OnTouchListener
  {
    private PointF downPoint = new PointF();
    
    private b() {}
    
    protected void ez(View paramView)
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
      paramView.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      ContextMenuTextView.this.setBackgroundColor(-1);
    }
    
    public boolean onLongClick(View paramView)
    {
      ContextMenuTextView.this.setBackgroundColor(-7829368);
      if ((ContextMenuTextView.this.a != null) && (ContextMenuTextView.this.a.isShowing()))
      {
        ez(paramView);
        return false;
      }
      aqoa localaqoa = new aqoa();
      localaqoa.Z(2131365509, ContextMenuTextView.a(ContextMenuTextView.this).getString(2131692330), 2130839077);
      ContextMenuTextView.this.a = aqgq.a(paramView, (int)this.downPoint.x, (int)this.downPoint.y, localaqoa, ContextMenuTextView.this.cp);
      if (ContextMenuTextView.this.a != null) {
        ContextMenuTextView.this.a.a(new ContextMenuTextView.a(ContextMenuTextView.this));
      }
      ez(paramView);
      return true;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0)
      {
        this.downPoint.x = paramMotionEvent.getRawX();
        this.downPoint.y = paramMotionEvent.getRawY();
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContextMenuTextView
 * JD-Core Version:    0.7.0.1
 */