package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;

public class CustomWidgetUtil
{
  public static final int a = 99;
  public static final int b = 99;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static final int h = 5;
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramTextView, paramInt1, paramInt2, paramInt3, 99);
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramTextView == null) {
      return;
    }
    int i;
    String str;
    switch (paramInt1)
    {
    default: 
      paramInt3 = 0;
      i = 0;
      str = "";
    }
    while ((TextUtils.isEmpty(str)) && (paramInt3 == 0) && (i == 0))
    {
      paramTextView.setVisibility(8);
      return;
      if (paramInt3 > 0)
      {
        i = 0;
        str = "";
      }
      else
      {
        paramInt3 = 2130840209;
        i = 0;
        str = "";
        continue;
        if (paramInt3 > 0)
        {
          i = 0;
          str = "";
        }
        else
        {
          paramInt3 = 2130840212;
          i = 0;
          str = "";
          continue;
          if (paramInt3 > 0) {}
          for (;;)
          {
            if (paramInt2 <= paramInt4) {
              break label180;
            }
            str = String.valueOf(paramInt4) + "+";
            j = 0;
            i = paramInt3;
            paramInt3 = j;
            break;
            paramInt3 = 2130840213;
          }
          label180:
          int j = 0;
          str = String.valueOf(paramInt2);
          i = paramInt3;
          paramInt3 = j;
          continue;
          if (paramInt3 > 0) {}
          for (;;)
          {
            if (paramInt2 <= 99) {
              break label230;
            }
            j = 0;
            str = "";
            i = paramInt3;
            paramInt3 = j;
            break;
            paramInt3 = 2130840213;
          }
          label230:
          j = 0;
          str = String.valueOf(paramInt2);
          i = paramInt3;
          paramInt3 = j;
        }
      }
    }
    Object localObject = paramTextView.getTag(2131234179);
    if (((localObject == null) && (paramInt3 == 0)) || (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == paramInt3))) {}
    float f1;
    for (;;)
    {
      if (paramInt1 == 5) {
        if (paramInt2 == 0)
        {
          paramTextView.setVisibility(8);
          return;
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramInt3, 0, 0, 0);
          paramTextView.setTag(2131234179, Integer.valueOf(paramInt3));
        }
        else
        {
          f1 = paramTextView.getContext().getResources().getDisplayMetrics().density;
          if (f1 >= 2.0F) {
            if (paramInt2 > paramInt4)
            {
              paramTextView.setPadding(0, 0, -(int)f1, 0);
              paramTextView.setBackgroundResource(0);
              paramTextView.setTextSize(15.0F);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (!Utils.a(paramTextView.getText().toString(), str)) {
        paramTextView.setText(str);
      }
      paramTextView.setVisibility(0);
      return;
      if (paramInt2 < 10)
      {
        paramTextView.setPadding(0, 0, (int)(f1 * 15.0F), 0);
        break;
      }
      paramTextView.setPadding(0, 0, (int)(f1 * 7.0F), 0);
      break;
      if (f1 == 1.5D)
      {
        if (paramInt2 > paramInt4)
        {
          paramTextView.setPadding(0, 0, -(int)(f1 * 5.0F), 0);
          break;
        }
        if (paramInt2 < 10)
        {
          paramTextView.setPadding(0, 0, (int)(f1 * 11.0F), 0);
          break;
        }
        paramTextView.setPadding(0, 0, (int)(f1 * 3.0F), 0);
        break;
      }
      if (f1 > 1.0F) {
        break;
      }
      if (paramInt2 > paramInt4)
      {
        paramTextView.setPadding(0, 0, -(int)(f1 * 3.0F), 0);
        break;
      }
      if (paramInt2 < 10)
      {
        paramTextView.setPadding(0, 0, (int)(f1 * 7.0F), 0);
        break;
      }
      paramTextView.setPadding(0, 0, -(int)f1, 0);
      break;
      paramTextView.setBackgroundResource(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.CustomWidgetUtil
 * JD-Core Version:    0.7.0.1
 */