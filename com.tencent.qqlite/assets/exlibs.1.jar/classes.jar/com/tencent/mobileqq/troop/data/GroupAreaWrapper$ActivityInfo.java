package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class GroupAreaWrapper$ActivityInfo
  extends GroupAreaWrapper.BaseInfo
{
  public GroupAreaWrapper$ActivityInfo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a(View paramView)
  {
    ((NearbyTroops.ActivityAndTopicViewHolder)paramView.getTag()).a.setTextColor(paramView.getContext().getResources().getColor(2131427431));
    paramView.findViewById(2131297680).setBackgroundResource(2130838272);
  }
  
  protected void a(TextView paramTextView)
  {
    paramTextView.setText("" + this.b + "人报名");
    paramTextView.setCompoundDrawablePadding(8);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(2130838326, 0, 0, 0);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131297674) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "ac", "Clk_list", 0, 0, "", "", "", "");
    }
    while (i != 2131297678) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_nearby", "", "ac", "Clk_detail", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.GroupAreaWrapper.ActivityInfo
 * JD-Core Version:    0.7.0.1
 */