package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.List;
import java.util.Map;

public class TroopAdminList$AdminListAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public TroopAdminList$AdminListAdapter(TroopAdminList paramTroopAdminList, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_JavaUtilList.size();
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
      paramViewGroup = new TroopAdminList.ViewHolder();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903450, null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131232622));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231000));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131231507));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      Map localMap = (Map)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_a_of_type_JavaUtilList.get(paramInt);
      String str = localMap.get("uin").toString();
      paramViewGroup.jdField_a_of_type_JavaLangString = str;
      paramViewGroup.c.setBackgroundDrawable(ImageUtil.a());
      paramViewGroup.c.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(localMap.get("uin").toString()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMap.get("nick").toString());
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList.jdField_b_of_type_JavaLangString.equals(str)) {
        paramViewGroup.b.setVisibility(0);
      }
      return paramView;
      paramViewGroup = (TroopAdminList.ViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.AdminListAdapter
 * JD-Core Version:    0.7.0.1
 */