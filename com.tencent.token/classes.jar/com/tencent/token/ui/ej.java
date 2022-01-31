package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.token.core.bean.b;
import java.util.List;

class ej
  extends BaseAdapter
{
  private List b;
  private EnvirChangeListviewActivity c;
  private LayoutInflater d;
  
  public ej(EnvirChangeListviewActivity paramEnvirChangeListviewActivity1, EnvirChangeListviewActivity paramEnvirChangeListviewActivity2, List paramList)
  {
    this.d = LayoutInflater.from(paramEnvirChangeListviewActivity2);
    this.c = paramEnvirChangeListviewActivity2;
    this.b = paramList;
  }
  
  public void a(int paramInt)
  {
    if (!((b)this.b.get(paramInt)).c())
    {
      ((b)this.b.get(paramInt)).a(true);
      int i = 0;
      while (i < this.b.size())
      {
        if (i != paramInt) {
          ((b)this.b.get(i)).a(false);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.d.inflate(2130968641, paramViewGroup, false);
    }
    paramView = (TextView)localView.findViewById(2131558827);
    paramViewGroup = (TextView)localView.findViewById(2131558828);
    RadioButton localRadioButton = (RadioButton)localView.findViewById(2131558829);
    b localb = (b)getItem(paramInt);
    paramView.setText(localb.a());
    paramViewGroup.setText(localb.b());
    localRadioButton.setChecked(localb.c());
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ej
 * JD-Core Version:    0.7.0.1
 */