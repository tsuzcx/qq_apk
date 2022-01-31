package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyBar;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;

public class TroopBarPublishBarSelectActivity$MyBarListAdapter
  extends XBaseAdapter
{
  protected LayoutInflater a;
  
  public TroopBarPublishBarSelectActivity$MyBarListAdapter(TroopBarPublishBarSelectActivity paramTroopBarPublishBarSelectActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903408, null);
      paramViewGroup = new TroopBarPublishBarSelectActivity.MyBarListAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231604));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231000));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131232523));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      TroopBarUtils.MyBar localMyBar = (TroopBarUtils.MyBar)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMyBar.q);
      paramView.setContentDescription(localMyBar.q);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(localMyBar.r);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localURLDrawable);
        label134:
        if (localMyBar.equals(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishBarSelectActivity.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBarUtils$MyBar))
        {
          paramViewGroup.b.setVisibility(0);
          return paramView;
          paramViewGroup = (TroopBarPublishBarSelectActivity.MyBarListAdapter.ViewHolder)paramView.getTag();
          continue;
        }
        paramViewGroup.b.setVisibility(4);
        return paramView;
      }
      catch (Exception localException)
      {
        break label134;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishBarSelectActivity.MyBarListAdapter
 * JD-Core Version:    0.7.0.1
 */