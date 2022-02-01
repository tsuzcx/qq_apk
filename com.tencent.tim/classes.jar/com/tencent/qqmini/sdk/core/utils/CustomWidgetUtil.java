package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R.drawable;
import com.tencent.qqmini.sdk.R.id;

public class CustomWidgetUtil
{
  public static final int MAX_NOTE_NUM = 99;
  public static final int NOTETXT_STYLE_REDDOT_WITHNUM = 7;
  
  public static boolean equalsWithNullCheck(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    updateCustomNoteTxt(paramTextView, paramInt1, paramInt2, paramInt3, 99, null);
  }
  
  public static void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    paramString = "";
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      if (paramString == null) {
        paramString = "";
      }
      break;
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(paramString)) && (paramInt1 == 0))
      {
        paramTextView.setVisibility(8);
        return;
        if (paramInt3 > 0) {}
        for (paramInt1 = paramInt3;; paramInt1 = R.drawable.mini_sdk_skin_tips_newmessage)
        {
          if (paramInt2 <= paramInt4) {
            break label105;
          }
          paramString = String.valueOf(paramInt4) + "+";
          break;
        }
        label105:
        paramString = String.valueOf(paramInt2);
        break;
      }
      Object localObject = paramTextView.getTag(R.id.mini_sdk_unreadmsg);
      if (localObject == null) {}
      for (;;)
      {
        paramTextView.setBackgroundResource(paramInt1);
        if (!equalsWithNullCheck(paramTextView.getText().toString(), paramString))
        {
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          paramTextView.setText(paramString);
        }
        paramTextView.setVisibility(0);
        return;
        if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() != 0))
        {
          paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          paramTextView.setTag(R.id.mini_sdk_unreadmsg, Integer.valueOf(0));
          paramTextView.setText(paramString);
          paramTextView.setPadding(0, 0, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.CustomWidgetUtil
 * JD-Core Version:    0.7.0.1
 */