package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.utils.TroopBarUtils.MyLBSApiPOI;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;

public class TroopBarPublishLocationSelectActivity$LocationAdapter
  extends XBaseAdapter
{
  protected LayoutInflater a;
  
  public TroopBarPublishLocationSelectActivity$LocationAdapter(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.size();
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
    TroopBarUtils.MyLBSApiPOI localMyLBSApiPOI;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903734, null);
      paramViewGroup = new TroopBarPublishLocationSelectActivity.LocationAdapter.ViewHolder(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131233618));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231327));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233619));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131233620));
      paramView.setTag(paramViewGroup);
      localMyLBSApiPOI = (TroopBarUtils.MyLBSApiPOI)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.a.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMyLBSApiPOI.j);
      ImageView localImageView = paramViewGroup.jdField_b_of_type_AndroidWidgetImageView;
      if (!localMyLBSApiPOI.equals(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity.c)) {
        break label201;
      }
      paramInt = 0;
      label132:
      localImageView.setVisibility(paramInt);
      if (TextUtils.isEmpty(localMyLBSApiPOI.k)) {
        break label207;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localMyLBSApiPOI.k);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      paramView.setContentDescription(localMyLBSApiPOI.j);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      return paramView;
      paramViewGroup = (TroopBarPublishLocationSelectActivity.LocationAdapter.ViewHolder)paramView.getTag();
      break;
      label201:
      paramInt = 8;
      break label132;
      label207:
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.LocationAdapter
 * JD-Core Version:    0.7.0.1
 */