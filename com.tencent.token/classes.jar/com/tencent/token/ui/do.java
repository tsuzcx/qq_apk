package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.token.core.bean.c;
import java.util.List;

final class do
  extends BaseAdapter
{
  private List b;
  private EnvirChangeListviewActivity c;
  private LayoutInflater d;
  
  public do(EnvirChangeListviewActivity paramEnvirChangeListviewActivity1, EnvirChangeListviewActivity paramEnvirChangeListviewActivity2, List paramList)
  {
    this.d = LayoutInflater.from(paramEnvirChangeListviewActivity2);
    this.c = paramEnvirChangeListviewActivity2;
    this.b = paramList;
  }
  
  public final void a(int paramInt)
  {
    if (!((c)this.b.get(paramInt)).c())
    {
      ((c)this.b.get(paramInt)).a(true);
      int i = 0;
      while (i < this.b.size())
      {
        if (i != paramInt) {
          ((c)this.b.get(i)).a(false);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
  }
  
  public final int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.d.inflate(2130903076, paramViewGroup, false);
    }
    paramView = (TextView)localView.findViewById(2131296541);
    paramViewGroup = (TextView)localView.findViewById(2131296542);
    RadioButton localRadioButton = (RadioButton)localView.findViewById(2131296543);
    c localc = (c)getItem(paramInt);
    paramView.setText(localc.a());
    paramViewGroup.setText(localc.b());
    localRadioButton.setChecked(localc.c());
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.do
 * JD-Core Version:    0.7.0.1
 */