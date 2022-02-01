package com.tencent.biz.pubaccount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class PublicAccountBrowser$ActionSheetItemAdapter
  extends ArrayAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private List jdField_a_of_type_JavaUtilList;
  
  public PublicAccountBrowser$ActionSheetItemAdapter(Context paramContext, int paramInt, List paramList)
  {
    super(paramContext, paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public PublicAccountBrowser.ActionSheetItem a(int paramInt)
  {
    return (PublicAccountBrowser.ActionSheetItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903226, null);
      paramViewGroup = new PublicAccountBrowser.ActionSheetItemViewHolder();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131231674));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231675));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      PublicAccountBrowser.ActionSheetItem localActionSheetItem = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentBizPubaccountPublicAccountBrowser$ActionSheetItem = localActionSheetItem;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localActionSheetItem.a);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(localActionSheetItem.k);
      return paramView;
      paramViewGroup = (PublicAccountBrowser.ActionSheetItemViewHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemAdapter
 * JD-Core Version:    0.7.0.1
 */