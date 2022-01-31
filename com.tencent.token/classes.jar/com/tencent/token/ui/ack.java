package com.tencent.token.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

final class ack
  extends BaseAdapter
{
  private Context a;
  private LayoutInflater b;
  private List c;
  
  public ack(Context paramContext, List paramList)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.c = paramList;
  }
  
  public final int getCount()
  {
    return this.c.size();
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
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.b.inflate(2130903195, null);
    }
    ((TextView)paramViewGroup.findViewById(2131297086)).setText((String)((Map)this.c.get(paramInt)).get("setting_op_name"));
    paramViewGroup.setOnClickListener(new acl(this, paramInt));
    paramViewGroup.setOnTouchListener(new acm(this));
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ack
 * JD-Core Version:    0.7.0.1
 */