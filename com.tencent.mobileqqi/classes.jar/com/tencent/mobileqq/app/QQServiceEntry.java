package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import ffz;
import fga;
import fgb;
import java.util.List;

public class QQServiceEntry
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final int a = 1;
  public static final fga[] a;
  public static final int b = 4;
  public static final int c = 8;
  public static final int d = 16;
  public static final int e = 32;
  public static final int f = 64;
  public static final int g = 128;
  public static final int h = 13;
  public float a;
  public Context a;
  public QQServiceEntry.Tag a;
  public List a;
  public boolean a;
  public int i;
  private int j;
  private int k;
  
  static
  {
    jdField_a_of_type_ArrayOfFga = new fga[6];
  }
  
  public QQServiceEntry(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  public QQServiceEntry.Tag a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag == paramView.getTag()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.getVisibility() == 0)) {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag = ((QQServiceEntry.Tag)paramView.getTag());
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_JavaLangString.equals(String.valueOf(AppConstants.U)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setFocusableInTouchMode(false);
    this.j = ((int)(52.0F * this.jdField_a_of_type_Float));
    this.i = ((int)(38.0F * this.jdField_a_of_type_Float));
    this.k = ((int)(5.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.j);
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setAdapter(new fgb(this, this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.b));
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQServiceEntry$Tag.jdField_a_of_type_AndroidWidgetGridView.setVisibility(0);
    paramView.post(new ffz(this));
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQServiceEntry
 * JD-Core Version:    0.7.0.1
 */