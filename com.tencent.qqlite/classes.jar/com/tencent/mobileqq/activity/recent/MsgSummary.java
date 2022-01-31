package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.text.QQText;
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
            paramContext = ((Resources)localObject).getDrawable(2130839093);
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
          paramContext = ((Resources)localObject).getDrawable(2130839097);
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
  
  public CharSequence a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int j = 2;
    int k = 1;
    if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.d))) {
      localObject1 = this.d;
    }
    while (paramContext == null) {
      return localObject1;
    }
    Resources localResources = paramContext.getResources();
    if (localResources != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.f == 2)
        {
          localObject1 = localResources.getDrawable(2130839093);
          if (paramInt <= 0) {
            break label616;
          }
          paramInt = paramContext.getResources().getColor(2131427514);
          if (!(this.b instanceof QQText)) {
            break label367;
          }
          paramContext = (QQText)this.b;
          localObject3 = (ImageSpan[])paramContext.getSpans(0, 1, ImageSpan.class);
          if (localObject3.length > 0) {
            paramContext.removeSpan(localObject3[0]);
          }
          localObject3 = paramContext.a(paramString, true, new int[0]);
          if (this.f != 2) {
            break label330;
          }
          paramContext = ((QQText)localObject3).a("F ", true, new int[0]);
          if (this.c == null) {
            break label613;
          }
          paramContext = paramContext.a(this.c.toString(), false, new int[0]);
          if (localObject1 == null) {
            break label607;
          }
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth() * 2 / 3, ((Drawable)localObject1).getIntrinsicHeight() * 2 / 3);
          paramContext.setSpan(new ImageSpan((Drawable)localObject1), 0, 1, 33);
          i = 1;
          if (paramInt > 0)
          {
            localObject1 = new ForegroundColorSpan(paramInt);
            if (i == 0) {
              break label356;
            }
            paramInt = k;
            if (i == 0) {
              break label361;
            }
            i = 2;
            paramContext.setSpan(localObject1, paramInt, i + paramString.length(), 33);
          }
          return paramContext;
        }
        localObject1 = localObject3;
        if (this.f != 1) {
          continue;
        }
        localObject1 = localResources.getDrawable(2130839097);
        continue;
        localObject2 = null;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, localException.toString());
        }
      }
      Object localObject2;
      continue;
      label330:
      paramContext = (Context)localObject3;
      if (this.f == 1)
      {
        paramContext = ((QQText)localObject3).a("S ", true, new int[0]);
        continue;
        label356:
        paramInt = 0;
        continue;
        label361:
        i = 0;
        continue;
        label367:
        paramContext = new StringBuffer(40);
        if (this.f == 2)
        {
          paramContext.append("F ");
          paramContext.append(paramString);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
          {
            paramContext.append(this.jdField_a_of_type_JavaLangCharSequence);
            paramContext.append("：");
          }
          if (!TextUtils.isEmpty(this.b)) {
            paramContext.append(this.b);
          }
          if (this.c != null) {
            paramContext.append(this.c);
          }
          paramContext = new SpannableStringBuilder(paramContext.toString());
          if (localObject2 == null) {
            break label601;
          }
          ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth() * 2 / 3, ((Drawable)localObject2).getIntrinsicHeight() * 2 / 3);
          paramContext.setSpan(new ImageSpan((Drawable)localObject2), 0, 1, 33);
        }
        label545:
        label595:
        label601:
        for (i = 1;; i = 0)
        {
          localObject2 = paramContext;
          if (paramInt <= 0) {
            break;
          }
          localObject2 = new ForegroundColorSpan(paramInt);
          if (i != 0)
          {
            paramInt = 1;
            if (i == 0) {
              break label595;
            }
          }
          for (i = j;; i = 0)
          {
            paramContext.setSpan(localObject2, paramInt, paramString.length() + i, 33);
            return paramContext;
            if (this.f != 1) {
              break;
            }
            paramContext.append("S ");
            break;
            paramInt = 0;
            break label545;
          }
        }
        label607:
        i = 0;
        continue;
        label613:
        continue;
        label616:
        paramInt = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.MsgSummary
 * JD-Core Version:    0.7.0.1
 */