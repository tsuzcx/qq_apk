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
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public PoiMapActivity$SearchResultAdapter(PoiMapActivity paramPoiMapActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.c) {
      return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size() + 1;
    }
    return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.a == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new PoiMapActivity.PoiItemViewHolder(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903348, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297798));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297799));
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131297800);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.c = paramView.findViewById(2131297801);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297797);
      paramView.setTag(paramViewGroup);
    }
    while (paramInt == this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.size())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.SearchResultAdapter
 * JD-Core Version:    0.7.0.1
 */