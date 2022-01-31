package com.tencent.open.agent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.AgentBaseAdapter;
import java.util.List;

public class CardContainer$PermissionAdapter
  extends AgentBaseAdapter
{
  protected CardContainer$PermissionAdapter(CardContainer paramCardContainer) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903281, paramViewGroup, false);
      paramViewGroup = new BindGroupActivity.ViewHolder();
      paramViewGroup.a = ((TextView)paramView.findViewById(2131297489));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      CardContainer.Permission localPermission = (CardContainer.Permission)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.a.setText("● " + localPermission.a);
      return paramView;
      paramViewGroup = (BindGroupActivity.ViewHolder)paramView.getTag();
    }
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer.PermissionAdapter
 * JD-Core Version:    0.7.0.1
 */