package com.tencent.qqmail.utilities;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class TextUtil
{
  public static CharSequence makeCalendarMonthFirstDayTextStyle(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    int i = paramString1.length();
    int j = paramString1.length();
    int k = paramString2.length();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString1);
    localSpannableStringBuilder.append(paramString2);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(paramInt1, false), 0, i, 18);
    localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(paramInt2, false), j, k + j, 18);
    return localSpannableStringBuilder;
  }
  
  public static void setFileInfoTextStyle(TextView paramTextView, String paramString1, String paramString2)
  {
    if (paramTextView == null) {
      return;
    }
    int i = paramString1.length() + "    ".length();
    int j = paramString2.length();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramString1);
    localSpannableStringBuilder.append("    ");
    localSpannableStringBuilder.append(paramString2);
    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-16777216), i, j + i, 18);
    paramTextView.setText(localSpannableStringBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.TextUtil
 * JD-Core Version:    0.7.0.1
 */