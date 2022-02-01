package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import aqhu;

public class RedTouchTab
  extends RedTouch
{
  public RedTouchTab(Context paramContext)
  {
    super(paramContext);
  }
  
  public RedTouchTab(Context paramContext, View paramView)
  {
    super(paramContext, paramView);
  }
  
  protected TextView b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TextView localTextView = new TextView(this.context);
    try
    {
      if (Integer.parseInt(paramString) > this.maxNum)
      {
        localTextView.setText(this.maxNum + "+");
        localTextView.setTextColor(paramInt1);
        localTextView.setGravity(17);
        localTextView.setSingleLine(true);
        if (paramInt2 == 0) {
          break label210;
        }
        localTextView.setTextSize(11.0F);
        if (!this.czl) {
          break label185;
        }
        localTextView.setIncludeFontPadding(false);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        try
        {
          localTextView.setBackgroundResource(2130851406);
          localTextView.setLayoutParams(c());
          if (this.czi)
          {
            localTextView.measure(0, 0);
            this.leftMargin += localTextView.getMeasuredWidth() / 2;
            dJC();
          }
          return localTextView;
          localTextView.setText(paramString);
          continue;
          localNumberFormatException = localNumberFormatException;
          localTextView.setText(paramString.trim());
        }
        catch (OutOfMemoryError paramString)
        {
          aqhu.a(getResources(), localTextView, 2130851406);
          continue;
        }
        try
        {
          label185:
          localTextView.setBackgroundResource(2130851404);
        }
        catch (OutOfMemoryError paramString)
        {
          aqhu.a(getResources(), localTextView, 2130851404);
        }
        continue;
        label210:
        localTextView.setTextSize(13.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchTab
 * JD-Core Version:    0.7.0.1
 */