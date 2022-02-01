package com.tencent.mobileqq.businessCard.views;

import adzz;
import aeaa;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;

public class ClearEllipsisEditText
  extends ClearableEditText
{
  private boolean bSA;
  private boolean bSy;
  private boolean bSz;
  private String bws = "";
  private int cLH = 2;
  private int mHeight;
  private int mWidth;
  private int maxLength = 2147483647;
  
  public ClearEllipsisEditText(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ClearEllipsisEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ClearEllipsisEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private String ag(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      TextPaint localTextPaint = getPaint();
      return (String)TextUtils.ellipsize(paramString, localTextPaint, paramInt - 20 - (int)localTextPaint.measureText("B"), TextUtils.TruncateAt.END);
    }
    return "";
  }
  
  private void init()
  {
    addTextChangedListener(new adzz(this));
    setOnTouchListener(new aeaa(this));
  }
  
  private String kd(String paramString)
  {
    if ((paramString != null) && (this.bSA))
    {
      int i = paramString.length();
      String str1 = paramString;
      if (this.cLH == 1)
      {
        i = paramString.getBytes().length;
        str1 = paramString;
      }
      for (;;)
      {
        str2 = str1;
        if (i <= this.maxLength) {
          break;
        }
        paramString = str1.substring(0, str1.length() - 1);
        i = paramString.length();
        str1 = paramString;
        if (this.cLH == 1)
        {
          i = paramString.getBytes().length;
          str1 = paramString;
        }
      }
    }
    String str2 = paramString;
    if (paramString == null) {
      str2 = "";
    }
    return str2;
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {}
    try
    {
      this.bSy = false;
      this.bws = getText().toString();
      setEllipsisText(getText().toString());
      return;
    }
    catch (Throwable paramRect)
    {
      QLog.e("ClearEllipsisEditText", 1, "onFocusChanged fail!", paramRect);
    }
    this.bSy = true;
    setText(this.bws);
    return;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mHeight = getMeasuredHeight();
    this.mWidth = getMeasuredWidth();
  }
  
  public String sZ()
  {
    return this.bws;
  }
  
  public void setEllipsisText(String paramString)
  {
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      this.bws = kd(paramString);
      if (this.mWidth <= 0)
      {
        post(new ClearEllipsisEditText.3(this, str));
        return;
      }
      this.bSz = true;
      setText(ag(str, this.mWidth));
      return;
    }
  }
  
  public void setMaxLength(int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 1) || (paramInt2 == 2)) {}
    for (this.cLH = paramInt2;; this.cLH = 2)
    {
      this.bSA = true;
      this.maxLength = paramInt1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText
 * JD-Core Version:    0.7.0.1
 */