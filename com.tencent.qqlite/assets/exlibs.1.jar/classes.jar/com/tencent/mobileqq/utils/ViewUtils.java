package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class ViewUtils
{
  private static TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private static DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics;
  
  public static void a(Context paramContext, TextView paramTextView, String paramString, int paramInt)
  {
    if (jdField_a_of_type_AndroidUtilDisplayMetrics == null) {
      jdField_a_of_type_AndroidUtilDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    }
    int i = (int)(jdField_a_of_type_AndroidUtilDisplayMetrics.widthPixels / jdField_a_of_type_AndroidUtilDisplayMetrics.density);
    jdField_a_of_type_AndroidTextTextPaint = paramTextView.getPaint();
    float f = jdField_a_of_type_AndroidTextTextPaint.measureText(paramString);
    if (f > i - paramInt)
    {
      paramTextView.setWidth(i - paramInt);
      return;
    }
    paramTextView.setWidth((int)(5.0F + f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ViewUtils
 * JD-Core Version:    0.7.0.1
 */