package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import kg;
import kh;

public class PoiMapActivity$PoiTab
{
  final int a;
  public TextView a;
  public PoiMapActivity.PoiItemAdapter a;
  public PoiMapActivity.TabView a;
  public XListView a;
  final int b;
  final int c = 3;
  public int d;
  public int e;
  public int f;
  
  public PoiMapActivity$PoiTab(PoiMapActivity paramPoiMapActivity, Context paramContext, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.d = paramInt;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((PoiMapActivity)paramContext).findViewById(2131298580));
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusableInTouchMode(false);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView = new PoiMapActivity.TabView(paramPoiMapActivity, paramContext, paramString, paramInt);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(paramContext);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter = new PoiMapActivity.PoiItemAdapter(paramPoiMapActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(paramContext.getResources().getDrawable(2130837660));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new kg(this, paramPoiMapActivity));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new kh(this, paramPoiMapActivity));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131364329));
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131364328));
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131364377));
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt, paramBoolean);
      return;
    }
    if (this.d == 0) {
      if ((paramInt > 0) && (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean))
      {
        if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_f_of_type_Boolean) {
          break label69;
        }
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_f_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt, paramBoolean);
      return;
      label69:
      PoiMapActivity.POI localPOI = this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt);
      if (localPOI == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.o = localPOI.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.p = localPOI.jdField_b_of_type_JavaLangString;
      PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity, localPOI.f);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_JavaLangString = localPOI.c;
      PoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity).animateTo(new GeoPoint(localPOI.jdField_a_of_type_Int, localPOI.jdField_b_of_type_Int));
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Int = (paramInt - 1);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.notifyDataSetChanged();
      return;
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.a[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.a[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramString);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      a(3);
    }
    do
    {
      return;
      if (paramArrayList == null)
      {
        a(1);
        return;
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramArrayList, paramBoolean1, paramInt);
    } while (this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_f_of_type_Int != this.d);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.getCount() > 0) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.setSelect(paramBoolean);
      return;
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "POI list update isfirst = " + paramBoolean);
    }
    if ((this.e != this.jdField_a_of_type_ComTencentBizPoiMapActivity.d) || (this.jdField_f_of_type_Int != this.jdField_a_of_type_ComTencentBizPoiMapActivity.e) || (!paramBoolean))
    {
      if (paramBoolean)
      {
        a(2);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.notifyDataSetChanged();
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity.d, this.jdField_a_of_type_ComTencentBizPoiMapActivity.e, "", this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.jdField_a_of_type_Int], this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Int, 10);
      this.e = this.jdField_a_of_type_ComTencentBizPoiMapActivity.d;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentBizPoiMapActivity.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiTab
 * JD-Core Version:    0.7.0.1
 */