package com.tencent.biz;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import java.util.ArrayList;

public class PoiMapActivity$PoiItemAdapter
  extends BaseAdapter
{
  public int a;
  protected TextView a;
  public ArrayList a;
  public boolean a;
  public int b;
  public boolean b;
  
  public PoiMapActivity$PoiItemAdapter(PoiMapActivity paramPoiMapActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public PoiMapActivity.POI a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    if ((i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (i < 0)) {
      return null;
    }
    return (PoiMapActivity.POI)this.jdField_a_of_type_JavaUtilArrayList.get(i);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {}
    PoiMapActivity.POI localPOI;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt == this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = paramInt;
        notifyDataSetChanged();
      } while ((paramInt == -1) || (!paramBoolean));
      localPOI = a(paramInt);
    } while (localPOI == null);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.o = localPOI.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.p = localPOI.jdField_b_of_type_JavaLangString;
    PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localPOI.f);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_JavaLangString = localPOI.c;
    PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity).animateTo(new GeoPoint(localPOI.jdField_a_of_type_Int, localPOI.jdField_b_of_type_Int));
  }
  
  public void a(PoiMapActivity.POI paramPOI)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    paramPOI.jdField_a_of_type_Boolean = true;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPOI);
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 1;
    if (i < j)
    {
      PoiMapActivity.POI localPOI = (PoiMapActivity.POI)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localPOI == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (((TextUtils.isEmpty(localPOI.jdField_a_of_type_JavaLangString)) || (!localPOI.jdField_a_of_type_JavaLangString.equals(paramPOI.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localPOI.jdField_b_of_type_JavaLangString)) || (!localPOI.jdField_b_of_type_JavaLangString.equals(paramPOI.jdField_b_of_type_JavaLangString))) && (!localPOI.jdField_a_of_type_Boolean)) {
          localArrayList.add(localPOI);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_Int += 1;
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    int j = 1;
    int i = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        return i + (j - 1);
        i = 0;
      }
    }
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.jdField_b_of_type_Boolean) {}
    for (i = j;; i = 0) {
      return i + k;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new PoiMapActivity.PoiItemViewHolder(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPoiMapActivity).inflate(2130903351, null);
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297798));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297799));
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131297800);
      paramViewGroup.c = paramView.findViewById(2131297801);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297797);
      paramView.setTag(paramViewGroup);
    }
    while ((paramInt == this.jdField_a_of_type_JavaUtilArrayList.size()) || ((this.jdField_a_of_type_Boolean) && (paramInt == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)))
    {
      paramViewGroup.c.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return paramView;
      paramViewGroup = (PoiMapActivity.PoiItemViewHolder)paramView.getTag();
    }
    Object localObject = a(paramInt);
    if ((paramInt == 0) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup.jdField_b_of_type_AndroidWidgetTextView;
    }
    if (localObject == null) {
      return null;
    }
    paramViewGroup.c.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.POI)localObject).jdField_a_of_type_JavaLangString);
    paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(((PoiMapActivity.POI)localObject).jdField_b_of_type_JavaLangString);
    localObject = ((PoiMapActivity.POI)localObject).jdField_a_of_type_JavaLangString + ((PoiMapActivity.POI)localObject).jdField_b_of_type_JavaLangString;
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.c);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.c);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (paramViewGroup = (String)localObject + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131362645);; paramViewGroup = (String)localObject + this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131362646))
    {
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Int);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_Int);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiItemAdapter
 * JD-Core Version:    0.7.0.1
 */