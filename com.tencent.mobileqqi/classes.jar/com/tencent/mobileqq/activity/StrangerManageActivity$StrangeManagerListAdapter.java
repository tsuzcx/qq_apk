package com.tencent.mobileqq.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.widget.XListView;
import dkp;
import java.util.ArrayList;

public class StrangerManageActivity$StrangeManagerListAdapter
  extends FacePreloadBaseAdapter
{
  public static final String a = "  ";
  String b;
  
  public StrangerManageActivity$StrangeManagerListAdapter(StrangerManageActivity paramStrangerManageActivity, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 1, true);
    this.b = paramContext.getString(2131561415);
  }
  
  protected Object a(int paramInt)
  {
    Stranger localStranger = (Stranger)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (localStranger == null) {
      return null;
    }
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = localStranger.uin;
    localFaceInfo.jdField_a_of_type_Int = 1;
    return localFaceInfo;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Stranger localStranger = (Stranger)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130903446, null);
      paramViewGroup = new dkp();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230940));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(16908308));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131230943));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131232614));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131231984));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232615));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this.a);
      paramViewGroup.jdField_a_of_type_Long = localStranger.time;
      paramViewGroup.jdField_a_of_type_JavaLangString = localStranger.uin;
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      if (!TextUtils.isEmpty(localStranger.name)) {
        break label398;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localStranger.uin);
      label179:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(1, localStranger.uin));
      if (!this.a.jdField_a_of_type_Boolean) {
        break label413;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      label214:
      if (!localStranger.uiSelected) {
        break label425;
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838085);
      label231:
      if (!TextUtils.isEmpty(localStranger.remark)) {
        break label437;
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("");
      label260:
      switch (localStranger.gender)
      {
      default: 
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localStranger.age);
      localStringBuilder.append(this.b);
      localStringBuilder.append("  ");
      if (!TextUtils.isEmpty(localStranger.groupName))
      {
        localStringBuilder.append(localStranger.groupName);
        localStringBuilder.append("  ");
      }
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localStringBuilder.toString());
      this.a.a(paramViewGroup);
      return paramView;
      paramViewGroup = (dkp)paramView.getTag();
      break;
      label398:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localStranger.name);
      break label179;
      label413:
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label214;
      label425:
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838084);
      break label231;
      label437:
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setText("(" + localStranger.remark + ")");
      break label260;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838069);
      continue;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838068);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.StrangerManageActivity.StrangeManagerListAdapter
 * JD-Core Version:    0.7.0.1
 */