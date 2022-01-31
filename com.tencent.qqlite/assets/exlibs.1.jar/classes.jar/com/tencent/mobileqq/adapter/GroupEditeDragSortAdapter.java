package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import java.util.List;

public class GroupEditeDragSortAdapter
  extends DragSortAdapter
{
  public GroupEditeDragSortAdapter(Context paramContext, List paramList)
  {
    super(paramContext, paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = View.inflate(this.mContext, 2130903499, null);
    }
    paramViewGroup.setVisibility(0);
    paramViewGroup.findViewById(2131296441).setVisibility(8);
    ((TextView)paramViewGroup.findViewById(2131298234)).setText(((Groups)this.mData.get(paramInt)).group_name);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter
 * JD-Core Version:    0.7.0.1
 */