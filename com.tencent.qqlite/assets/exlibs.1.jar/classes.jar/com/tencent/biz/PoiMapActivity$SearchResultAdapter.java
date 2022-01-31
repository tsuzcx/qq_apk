package com.tencent.biz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class PoiMapActivity$SearchResultAdapter
  extends BaseAdapter
{
  public PoiMapActivity$SearchResultAdapter(PoiMapActivity paramPoiMapActivity, Context paramContext) {}
  
  public int getCount()
  {
    if (this.a.a == null) {
      return 0;
    }
    if (this.a.c) {
      return this.a.a.size() + 1;
    }
    return this.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.a.a == null) {
      return null;
    }
    return this.a.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new PoiMapActivity.PoiItemViewHolder(this.a);
      paramView = LayoutInflater.from(this.a).inflate(2130903351, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297798));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297799));
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131297800);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.c = paramView.findViewById(2131297801);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297797);
      paramView.setTag(paramViewGroup);
    }
    while (paramInt == this.a.a.size())
    {
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return paramView;
      paramViewGroup = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
    }
    paramViewGroup.c.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    PoiMapActivity.POI localPOI = (PoiMapActivity.POI)getItem(paramInt);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localPOI.a);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localPOI.b);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */