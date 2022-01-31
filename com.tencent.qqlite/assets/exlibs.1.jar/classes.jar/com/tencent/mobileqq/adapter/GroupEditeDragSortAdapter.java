package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import java.util.List;

public class GroupEditeDragSortAdapter
  extends DragSortAdapter
{
  private Context a;
  
  public GroupEditeDragSortAdapter(Context paramContext, List paramList)
  {
    super(paramContext, paramList);
    this.a = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.a, 2130903487, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.findViewById(2131296441).setVisibility(8);
    paramView = (TextView)paramViewGroup.findViewById(2131298194);
    Groups localGroups = (Groups)this.mData.get(paramInt);
    paramView.setText(localGroups.group_name);
    paramView.setTag(localGroups);
    if ((this.a instanceof GroupManagerActivity)) {
      paramView.setOnClickListener(((GroupManagerActivity)this.a).a);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter
 * JD-Core Version:    0.7.0.1
 */