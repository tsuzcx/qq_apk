package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class RecentEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private int a = 0;
  private int b = 0;
  private int j = 0;
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramDrawable = paramView;
    if (paramView == null)
    {
      paramDrawable = View.inflate(paramContext, 2130903128, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131492950);
      this.a = paramContext.getResources().getDimensionPixelSize(2131492949);
      this.j = paramContext.getResources().getDimensionPixelSize(2131492952);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.j)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramDrawable.setLayoutParams(paramView);
      paramDrawable.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramDrawable.findViewById(2131296884);
      if (!(paramObject instanceof Integer)) {
        break label278;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label216;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838157, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131364063);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131427499));
    }
    label278:
    for (;;)
    {
      paramDrawable.setTag(-1, Integer.valueOf(paramInt));
      return paramDrawable;
      i = this.j;
      break;
      label216:
      if (i == 0)
      {
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838157, 0, 0);
        paramView.setVisibility(0);
        paramView.setText(2131363490);
        paramView.setTextColor(paramContext.getResources().getColorStateList(2131427499));
      }
      else
      {
        paramView.setVisibility(4);
        paramView.setText("");
        continue;
        paramView.setVisibility(8);
        paramView.setText("");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */