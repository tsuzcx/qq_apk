package com.tencent.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

public class AdapterView$AdapterDataSetObserver
  extends DataSetObserver
{
  private Parcelable jdField_a_of_type_AndroidOsParcelable = null;
  
  public AdapterView$AdapterDataSetObserver(AdapterView paramAdapterView) {}
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsParcelable = null;
  }
  
  public void onChanged()
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView.p = true;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aC = this.jdField_a_of_type_ComTencentWidgetAdapterView.aB;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aB = this.jdField_a_of_type_ComTencentWidgetAdapterView.a().getCount();
    if ((this.jdField_a_of_type_ComTencentWidgetAdapterView.a().hasStableIds()) && (this.jdField_a_of_type_AndroidOsParcelable != null) && (this.jdField_a_of_type_ComTencentWidgetAdapterView.aC == 0) && (this.jdField_a_of_type_ComTencentWidgetAdapterView.aB > 0))
    {
      AdapterView.a(this.jdField_a_of_type_ComTencentWidgetAdapterView, this.jdField_a_of_type_AndroidOsParcelable);
      this.jdField_a_of_type_AndroidOsParcelable = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAdapterView.w();
      this.jdField_a_of_type_ComTencentWidgetAdapterView.requestLayout();
      return;
      this.jdField_a_of_type_ComTencentWidgetAdapterView.q();
    }
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView.p = true;
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView.a().hasStableIds()) {
      this.jdField_a_of_type_AndroidOsParcelable = AdapterView.a(this.jdField_a_of_type_ComTencentWidgetAdapterView);
    }
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aC = this.jdField_a_of_type_ComTencentWidgetAdapterView.aB;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aB = 0;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.aA = -1;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.d = -9223372036854775808L;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.az = -1;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.c = -9223372036854775808L;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.n = false;
    this.jdField_a_of_type_ComTencentWidgetAdapterView.w();
    this.jdField_a_of_type_ComTencentWidgetAdapterView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterView.AdapterDataSetObserver
 * JD-Core Version:    0.7.0.1
 */