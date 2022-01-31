package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class TroopAssistantEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private static final String jdField_b_of_type_JavaLangString = "TroopAssistantEmptyItemBuilder";
  private int a = 0;
  private int jdField_b_of_type_Int;
  private int l = 0;
  private int m = 0;
  
  public TroopAssistantEmptyItemBuilder()
  {
    this.b = 0;
  }
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragRelativeLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i;
    if (paramView == null)
    {
      paramDrawable = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramDrawable))
      {
        paramView = View.inflate(paramContext, 2130904019, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramDrawable = paramContext.getResources();
        this.b = paramDrawable.getDimensionPixelSize(2131427449);
        this.a = paramDrawable.getDimensionPixelSize(2131427450);
        this.l = paramDrawable.getDimensionPixelSize(2131427451);
        i = paramDrawable.getDimensionPixelSize(2131427528);
        this.m = (paramDrawable.getDimensionPixelSize(2131427529) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.m;
      if (i <= this.l) {
        break label210;
      }
      label124:
      paramDrawable = new AbsListView.LayoutParams(-1, -1);
      paramDrawable.width = -1;
      paramDrawable.height = i;
      paramView.setLayoutParams(paramDrawable);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramDrawable = (TextView)paramView.findViewById(2131234590);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramDrawable.setText(2131562485);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramDrawable = paramView.getTag();
      break;
      label210:
      i = this.l;
      break label124;
      label219:
      paramDrawable.setText(2131562291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TroopAssistantEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */