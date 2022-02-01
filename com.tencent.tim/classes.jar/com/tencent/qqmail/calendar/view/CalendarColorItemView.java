package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.content.res.Resources;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

public class CalendarColorItemView
  extends UITableItemView
{
  private CalColorView mCalColorView;
  
  public CalendarColorItemView(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString);
    this.mCalColorView = new CalColorView(getContext(), paramInt);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.rightMargin = getResources().getDimensionPixelSize(2131296760);
    paramContext.gravity = 16;
    this.mCalColorView.setLayoutParams(paramContext);
  }
  
  public void drawViews()
  {
    super.drawViews();
    addView(this.mCalColorView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.CalendarColorItemView
 * JD-Core Version:    0.7.0.1
 */