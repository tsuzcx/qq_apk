package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

final class aag
  extends BaseAdapter
{
  private List b = new ArrayList();
  
  private aag(ShowLogActivity paramShowLogActivity, byte paramByte) {}
  
  public final void a(aad paramaad)
  {
    this.b.clear();
    if (paramaad != null) {
      paramaad.a(this.b);
    }
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    return this.b.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2130903199, null);
      paramViewGroup = new aai(this);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131297096));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      CharSequence localCharSequence = (CharSequence)this.b.get(paramInt);
      paramViewGroup = paramViewGroup.a;
      paramViewGroup.setText(localCharSequence);
      paramViewGroup.setOnLongClickListener(new aah(this));
      return paramView;
      paramViewGroup = (aai)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aag
 * JD-Core Version:    0.7.0.1
 */