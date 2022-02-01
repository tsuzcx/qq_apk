package com.tencent.biz.pubaccount.assistant;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class PubAccountAssistantEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private static final String jdField_b_of_type_JavaLangString = "PubAccountAssistantEmptyItemBuilder";
  private int a = 0;
  private int jdField_b_of_type_Int;
  private int l = 0;
  
  public PubAccountAssistantEmptyItemBuilder()
  {
    this.b = 0;
  }
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragRelativeLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i;
    if (paramView == null)
    {
      paramDrawable = null;
      if (!"PubAccountAssistantEmptyItemBuilder".equals(paramDrawable))
      {
        paramView = View.inflate(paramContext, 2130903431, null);
        paramView.setTag("PubAccountAssistantEmptyItemBuilder");
        this.b = paramContext.getResources().getDimensionPixelSize(2131427452);
        this.a = paramContext.getResources().getDimensionPixelSize(2131427453);
        this.l = paramContext.getResources().getDimensionPixelSize(2131427454);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10;
      if (i <= this.l) {
        break label191;
      }
      label104:
      paramDrawable = new AbsListView.LayoutParams(-1, -1);
      paramDrawable.width = -1;
      paramDrawable.height = i;
      paramView.setLayoutParams(paramDrawable);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramDrawable = (TextView)paramView.findViewById(2131232573);
        if (paramObject.intValue() != 9) {
          break label200;
        }
        paramDrawable.setText(2131560560);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramDrawable = paramView.getTag();
      break;
      label191:
      i = this.l;
      break label104;
      label200:
      paramDrawable.setText(2131562291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */