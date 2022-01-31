package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

class zc
  extends BaseAdapter
{
  private List b = new ArrayList();
  
  private zc(ShowLogActivity paramShowLogActivity) {}
  
  public CharSequence a(int paramInt)
  {
    return (CharSequence)this.b.get(paramInt);
  }
  
  public void a(yz paramyz)
  {
    this.b.clear();
    if (paramyz != null) {
      paramyz.a(this.b);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2130968762, null);
      paramViewGroup = new ze(this, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131559266));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      CharSequence localCharSequence = a(paramInt);
      paramViewGroup = paramViewGroup.a;
      paramViewGroup.setText(localCharSequence);
      paramViewGroup.setOnLongClickListener(new zd(this));
      return paramView;
      paramViewGroup = (ze)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zc
 * JD-Core Version:    0.7.0.1
 */