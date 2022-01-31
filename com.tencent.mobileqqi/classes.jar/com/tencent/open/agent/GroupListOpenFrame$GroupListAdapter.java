package com.tencent.open.agent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.FriendDataManager;
import hnl;

public class GroupListOpenFrame$GroupListAdapter
  extends BaseAdapter
{
  protected GroupListOpenFrame$GroupListAdapter(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.b();
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
    String str;
    int i;
    if (paramView == null)
    {
      paramViewGroup = new GroupListOpenFrame.GroupListAdapter.ViewHolder(this);
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903343, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232177));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131232178));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131232176));
      paramView.setTag(paramViewGroup);
      str = this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramViewGroup.b.setText(String.valueOf(this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramInt)));
      i = (int)(10.0F * this.a.jdField_a_of_type_ComTencentOpenAgentSocialFriendChooser.a);
      if (paramInt != 0) {
        break label194;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837880);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, 0, i, 0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new hnl(this, paramInt, str));
      return paramView;
      paramViewGroup = (GroupListOpenFrame.GroupListAdapter.ViewHolder)paramView.getTag();
      break;
      label194:
      if (paramInt == getCount() - 1) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837877);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130837879);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.GroupListOpenFrame.GroupListAdapter
 * JD-Core Version:    0.7.0.1
 */