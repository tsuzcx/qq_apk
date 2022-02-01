package com.tencent.mobileqq.troop.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import aoff;
import aofk;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class LimitTextView
  extends AnimationTextView
{
  private boolean cSx = true;
  private CharSequence s;
  private Field u;
  private Field v;
  private Field w;
  
  public LimitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LimitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void ecd()
  {
    try
    {
      this.u = TextView.class.getDeclaredField("mMaxMode");
      this.v = TextView.class.getDeclaredField("mMaximum");
      this.w = TextView.class.getDeclaredField("LINES");
      this.u.setAccessible(true);
      this.v.setAccessible(true);
      this.w.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      this.cSx = false;
    }
  }
  
  @TargetApi(16)
  public int getMaxLines()
  {
    int i = -1;
    if (Build.VERSION.SDK_INT >= 16) {
      i = super.getMaxLines();
    }
    do
    {
      return i;
      if ((this.cSx) && ((this.u == null) || (this.v == null) || (this.w == null))) {
        ecd();
      }
    } while (!this.cSx);
    try
    {
      int j = this.u.getInt(this);
      i = this.v.getInt(this);
      int k = this.w.getInt(this);
      if (j == k) {}
      for (;;)
      {
        return i;
        i = -1;
      }
      return -1;
    }
    catch (IllegalAccessException localIllegalAccessException) {}
  }
  
  @SuppressLint({"NewApi"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMaxLines();
    Object localObject;
    String str;
    if ((paramInt1 > 0) && (super.getLineCount() > paramInt1))
    {
      paramInt1 = super.getLayout().getLineVisibleEnd(paramInt1 - 1);
      this.s = getText();
      localObject = this.s.toString();
      paramInt2 = ((String)localObject).codePointAt(paramInt1 - 2);
      paramInt3 = ((String)localObject).codePointAt(paramInt1 - 1);
      if (((paramInt2 != 20) || (paramInt3 < 0) || (paramInt3 >= aoff.dOp)) && (paramInt2 <= 65535)) {
        break label164;
      }
      str = this.s.subSequence(0, paramInt1 - 2) + "…";
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.e("QQText", 2, "截取的是系统表情或者emoji表情------------");
        localObject = str;
      }
    }
    for (;;)
    {
      setText((CharSequence)localObject);
      return;
      label164:
      str = this.s.subSequence(0, paramInt1 - 1) + "…";
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.e("QQText", 2, "截取正常文本------------");
        localObject = str;
      }
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(new aofk(paramCharSequence, 13, 32, 1), TextView.BufferType.SPANNABLE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LimitTextView
 * JD-Core Version:    0.7.0.1
 */