package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class GroupAreaWrapper$TopicInfo
  extends GroupAreaWrapper.BaseInfo
{
  public GroupAreaWrapper$TopicInfo(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  protected void a(View paramView)
  {
    ((NearbyTroops.ActivityAndTopicViewHolder)paramView.getTag()).a.setTextColor(paramView.getContext().getResources().getColor(2131361941));
    paramView.findViewById(2131232394).setBackgroundResource(2130838405);
  }
  
  protected void a(TextView paramTextView)
  {
    paramTextView.setText(paramTextView.getContext().getString(2131559304, new Object[] { Integer.valueOf(this.b) }));
    paramTextView.setCompoundDrawablePadding(8);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(2130838464, 0, 0, 0);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131232388) {
      ReportController.b(this.a, "P_CliOper", "Grp_nearby", "", "post", "Clk_list", 0, 0, "", "", "", "");
    }
    while (i != 2131232392) {
      return;
    }
    ReportController.b(this.a, "P_CliOper", "Grp_nearby", "", "post", "Clk_detail", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.GroupAreaWrapper.TopicInfo
 * JD-Core Version:    0.7.0.1
 */