package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import kt;
import ku;
import ku.a;
import ram;
import rom;
import rpq;

public class ETTextViewPlus
  extends ETTextView
  implements ku.a
{
  private final ku b;
  private int mFontId = -1;
  private int mFontType = -1;
  private String mUin;
  
  public ETTextViewPlus(Context paramContext)
  {
    super(paramContext);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.b = ((ku)localQQAppInterface.getManager(42));
    this.mUin = localQQAppInterface.getCurrentUin();
    super.setSingleLine(true);
    setMaxWidth(rpq.getWindowScreenWidth(getContext()) - rpq.dip2px(paramContext, 24.0F));
  }
  
  public ETTextViewPlus(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.b = ((ku)paramAttributeSet.getManager(42));
    this.mUin = paramAttributeSet.getCurrentUin();
    super.setSingleLine(true);
    setMaxWidth(rpq.getWindowScreenWidth(getContext()) - rpq.dip2px(paramContext, 24.0F));
  }
  
  public void eU()
  {
    ram.w("DIYProfileTemplate.ETTextViewPlus", "setFontAsync download completed");
    kt localkt = this.b.a(this.mFontId, this.mFontType, false, this.mUin, 0);
    if ((localkt != null) && (localkt.b != null))
    {
      ram.w("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + this.mFontId + "] download completed");
      setFont(localkt.b, System.currentTimeMillis());
      setText(getText());
      this.b.b(this);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ram.w("DIYProfileTemplate.ETTextViewPlus", "onDetachedFromWindow");
    this.b.b(this);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    this.mMsgId = System.currentTimeMillis();
  }
  
  public void setFontAsync(int paramInt1, int paramInt2)
  {
    if (this.mFontId > 0)
    {
      rom.fail("DIYProfileTemplate.ETTextViewPluserror: it is not allow set font id multiple time! orig=" + this.mFontId + " set " + paramInt1, new Object[0]);
      ram.e("DIYProfileTemplate.ETTextViewPlus", "error: it is not allow set font id multiple time! orig=" + this.mFontId + " set " + paramInt1);
      return;
    }
    this.mFontId = paramInt1;
    this.mFontType = paramInt2;
    kt localkt = this.b.a(this.mFontId, this.mFontType, false, this.mUin, 0);
    if (localkt != null)
    {
      ram.w("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] success");
      setFont(localkt.b, System.currentTimeMillis());
      return;
    }
    ram.w("DIYProfileTemplate.ETTextViewPlus", "setFontAsync [" + paramInt1 + "] need download");
    this.b.a(this);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    String str = paramCharSequence.toString();
    float f = getPaint().measureText(str);
    if ((this.mMaxWidth > 0) && (this.mMaxWidth < f))
    {
      int i = (int)((f - this.mMaxWidth) / (f / str.length()));
      super.setText(str.substring(0, str.length() - i - 2) + "...", paramBufferType);
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.ETTextViewPlus
 * JD-Core Version:    0.7.0.1
 */