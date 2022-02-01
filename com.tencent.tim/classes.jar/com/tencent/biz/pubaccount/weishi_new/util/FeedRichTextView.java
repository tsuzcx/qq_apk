package com.tencent.biz.pubaccount.weishi_new.util;

import android.content.Context;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView.BufferType;
import com.tencent.biz.subscribe.widget.textview.SafeTextView;
import com.tencent.mobileqq.app.ThreadManager;
import ooi.a;

public class FeedRichTextView
  extends SafeTextView
  implements Handler.Callback
{
  private a a;
  private Handler mHandler = new Handler(Looper.getMainLooper(), this);
  
  public FeedRichTextView(Context paramContext)
  {
    super(paramContext, null);
    c(null);
  }
  
  public FeedRichTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramAttributeSet);
  }
  
  public FeedRichTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramAttributeSet);
  }
  
  private void c(AttributeSet paramAttributeSet) {}
  
  protected void a(CharSequence paramCharSequence, a parama, Drawable.Callback paramCallback)
  {
    ThreadManager.post(new FeedRichTextView.1(this, paramCharSequence, parama, paramCallback), 8, null, true);
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return LinkMovementMethod.getInstance();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    while ((paramMessage.what != 1001) || (!(paramMessage.obj instanceof ooi.a))) {
      return false;
    }
    super.setText((ooi.a)paramMessage.obj, null);
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    CharSequence localCharSequence = getText();
    if ((localCharSequence instanceof SpannableStringBuilder)) {
      ((SpannableStringBuilder)localCharSequence).clearSpans();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setFocusable(false);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnElementClickListener(a parama)
  {
    this.a = parama;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || ((!TextUtils.isEmpty(paramCharSequence)) && ((paramCharSequence instanceof ooi.a))))
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    a(paramCharSequence, this.a, null);
  }
  
  public static abstract interface a
  {
    public abstract void pF(String paramString);
    
    public abstract void pG(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView
 * JD-Core Version:    0.7.0.1
 */