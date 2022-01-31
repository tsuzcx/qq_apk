package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import bng;
import bnh;
import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.widget.XListView;
import java.util.ArrayList;

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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((PoiMapActivity)paramContext).findViewById(2131233260));
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView = new PoiMapActivity.TabView(paramPoiMapActivity, paramContext, paramString, paramInt);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(paramContext);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter = new PoiMapActivity.PoiItemAdapter(paramPoiMapActivity);
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundColor(paramContext.getResources().getColor(2131361818));
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new bng(this, paramPoiMapActivity));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bnh(this, paramPoiMapActivity));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131562066));
      return;
    case 2: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131562298));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getString(2131562478));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPoiMapActivity.c)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(paramInt, paramBoolean);
      return;
    }
    if (this.d == 0) {
      if ((paramInt > 0) && (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean))
      {
        if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity.g) {
          break label69;
        }
        this.jdField_a_of_type_ComTencentBizPoiMapActivity.g = false;
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
    } while (this.jdField_a_of_type_ComTencentBizPoiMapActivity.f != this.d);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.getCount() <= 0) {}
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
    if ((this.e != this.jdField_a_of_type_ComTencentBizPoiMapActivity.d) || (this.f != this.jdField_a_of_type_ComTencentBizPoiMapActivity.e) || (!paramBoolean))
    {
      if (paramBoolean)
      {
        a(2);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity.d, this.jdField_a_of_type_ComTencentBizPoiMapActivity.e, "", this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_b_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.jdField_a_of_type_Int], this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_b_of_type_Int, 10);
      this.e = this.jdField_a_of_type_ComTencentBizPoiMapActivity.d;
      this.f = this.jdField_a_of_type_ComTencentBizPoiMapActivity.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiTab
 * JD-Core Version:    0.7.0.1
 */