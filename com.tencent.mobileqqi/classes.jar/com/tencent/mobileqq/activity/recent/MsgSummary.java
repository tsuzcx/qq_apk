package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.tencent.qphone.base.util.QLog;

public class MsgSummary
{
  public static final int a = 0;
  public static final String a = "F ";
  public static final int b = 1;
  public static final String b = "S ";
  public static final int c = 2;
  public static final int d = 0;
  public static final int e = 1;
  public CharSequence a;
  public boolean a;
  public CharSequence b;
  public CharSequence c;
  public CharSequence d;
  public int f;
  public int g;
  
  public CharSequence a(Context paramContext)
  {
    SpannableStringBuilder localSpannableStringBuilder2 = null;
    Object localObject;
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.d)))
    {
      localObject = this.d;
      return localObject;
    }
    StringBuffer localStringBuffer = new StringBuffer(40);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      localStringBuffer.append(this.jdField_a_of_type_JavaLangCharSequence);
      localStringBuffer.append(": ");
    }
    for (int i = this.jdField_a_of_type_JavaLangCharSequence.length();; i = 0)
    {
      if (this.f == 2)
      {
        localStringBuffer.append("F ");
        label92:
        if (!TextUtils.isEmpty(this.b)) {
          localStringBuffer.append(this.b);
        }
        if (this.c != null) {
          localStringBuffer.append(this.c);
        }
        if (paramContext != null) {
          break label253;
        }
        localObject = null;
        label135:
        paramContext = localSpannableStringBuilder2;
        if (localObject == null) {}
      }
      for (;;)
      {
        try
        {
          if (this.f == 2)
          {
            paramContext = ((Resources)localObject).getDrawable(2130839632);
            if ((TextUtils.isEmpty(this.b)) || (!(this.b instanceof Spannable))) {
              continue;
            }
            if (paramContext != null)
            {
              paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth() * 2 / 3, paramContext.getIntrinsicHeight() * 2 / 3);
              ((Spannable)this.b).setSpan(new ImageSpan(paramContext), i, i + 1, 33);
            }
            return this.b;
            if (this.f != 1) {
              break label92;
            }
            localStringBuffer.append("S ");
            break label92;
            label253:
            localObject = paramContext.getResources();
            break label135;
          }
          if (this.f != 1) {
            break label370;
          }
          paramContext = ((Resources)localObject).getDrawable(2130839636);
          continue;
        }
        catch (Exception localException)
        {
          paramContext = localSpannableStringBuilder2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.recent", 2, localException.toString());
          paramContext = localSpannableStringBuilder2;
          continue;
          localSpannableStringBuilder2 = new SpannableStringBuilder(localStringBuffer.toString());
          SpannableStringBuilder localSpannableStringBuilder1 = localSpannableStringBuilder2;
        }
        if (paramContext == null) {
          break;
        }
        paramContext.setBounds(0, 0, paramContext.getIntrinsicWidth() * 2 / 3, paramContext.getIntrinsicHeight() * 2 / 3);
        localSpannableStringBuilder2.setSpan(new ImageSpan(paramContext), i, i + 1, 33);
        return localSpannableStringBuilder2;
        label370:
        paramContext = null;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.f = 0;
    this.b = null;
    this.c = null;
    this.g = 0;
    this.jdField_a_of_type_Boolean = false;
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.MsgSummary
 * JD-Core Version:    0.7.0.1
 */