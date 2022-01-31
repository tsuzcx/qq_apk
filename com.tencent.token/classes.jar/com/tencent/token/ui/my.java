package com.tencent.token.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.token.core.bean.JLAppealInfo;
import java.util.ArrayList;

final class my
  extends BaseAdapter
{
  private LayoutInflater b;
  
  public my(JLAppealListActivity paramJLAppealListActivity, Context paramContext)
  {
    this.b = LayoutInflater.from(paramContext);
  }
  
  public final int getCount()
  {
    if (JLAppealListActivity.access$000(this.a) == null) {
      return 0;
    }
    return JLAppealListActivity.access$000(this.a).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.b.inflate(2130903113, null);
      paramViewGroup = new mz(this);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131296728));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131296729));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((JLAppealInfo)JLAppealListActivity.access$000(this.a).get(paramInt)).title);
      paramViewGroup.b.setText(((JLAppealInfo)JLAppealListActivity.access$000(this.a).get(paramInt)).subTitle);
      return paramView;
      paramViewGroup = (mz)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.my
 * JD-Core Version:    0.7.0.1
 */