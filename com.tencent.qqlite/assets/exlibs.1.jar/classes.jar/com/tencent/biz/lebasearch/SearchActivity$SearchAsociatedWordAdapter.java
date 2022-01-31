package com.tencent.biz.lebasearch;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity$SearchAsociatedWordAdapter
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public SearchActivity$SearchAsociatedWordAdapter(SearchActivity paramSearchActivity, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new TextView(this.jdField_a_of_type_ComTencentBizLebasearchSearchActivity);
      paramView = paramViewGroup;
      paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentBizLebasearchSearchActivity, 44.0F)));
      paramViewGroup.setTextSize(16.0F);
      paramViewGroup.setPadding((int)DisplayUtils.a(this.jdField_a_of_type_ComTencentBizLebasearchSearchActivity, 15.0F), 0, 0, 0);
      paramViewGroup.setGravity(16);
      paramViewGroup.setTextColor(Color.parseColor("#000000"));
      paramViewGroup.setBackgroundColor(Color.parseColor("#ffffff"));
      if (paramInt == 0) {
        break label128;
      }
      paramViewGroup.setText(str);
    }
    for (;;)
    {
      paramViewGroup.setTag(str);
      return paramView;
      paramViewGroup = (TextView)paramView;
      break;
      label128:
      Object localObject = this.jdField_a_of_type_ComTencentBizLebasearchSearchActivity.getString(2131362654, new Object[] { str });
      paramInt = ((String)localObject).indexOf(str);
      if (paramInt != -1)
      {
        localObject = new SpannableString((CharSequence)localObject);
        ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), paramInt, str.length() + paramInt, 34);
        paramViewGroup.setText((CharSequence)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchActivity.SearchAsociatedWordAdapter
 * JD-Core Version:    0.7.0.1
 */