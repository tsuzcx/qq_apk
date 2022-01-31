package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bvz;
import bwa;
import bwb;
import bwc;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FakeTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.OnSelectListener;

public abstract class AbstractImageListScene
  extends ImageScene
  implements AnimationLister
{
  int jdField_a_of_type_Int;
  protected Activity a;
  protected Dialog a;
  protected View a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected AbstractAnimationManager a;
  public AbstractImageAdapter a;
  protected AbstractImageListModel a;
  AnimationLister jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister = new bwc(this);
  protected QQCustomDialog a;
  protected GestureSelectGridView a;
  protected boolean a;
  int b;
  protected ImageView b;
  protected TextView b;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d;
  private int e;
  
  public AbstractImageListScene(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = paramAbstractImageListModel;
  }
  
  private void a(String paramString)
  {
    try
    {
      ((ActionBarActivity)this.jdField_a_of_type_AndroidAppActivity).getSupportActionBar().setTitle(paramString);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903541, null));
    if (paramViewGroup == null) {
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131230941));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131232869));
      this.jdField_b_of_type_AndroidWidgetTextView = new FakeTextView(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_b_of_type_AndroidWidgetTextView.setId(2131232870);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131561810);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131232872));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131232873));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131232871);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131232874));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setGravity(17);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.d);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.e, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.e, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(a());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(a());
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(2131561801);
      p();
      q();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      a(this.jdField_c_of_type_AndroidWidgetTextView.getText().toString());
      return;
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
    }
  }
  
  private void o()
  {
    Display localDisplay = ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    this.e = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131427458);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131427456);
    this.d = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131427457);
    this.jdField_a_of_type_Int = ((localDisplay.getWidth() - this.e * 2 - this.jdField_c_of_type_Int * 3) / 4);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131561843);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bvz(this));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131561810);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(a());
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bwa(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bwb(this));
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public Rect a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q();
    int j = this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.b();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(j - i);
    if (localView != null) {
      return AnimationUtils.a(localView);
    }
    return null;
  }
  
  protected abstract View.OnClickListener a();
  
  protected abstract AbstractImageAdapter a(Activity paramActivity, int paramInt);
  
  protected abstract AdapterView.OnItemClickListener a();
  
  protected abstract GestureSelectGridView.OnSelectListener a();
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractAnimationManager = this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    o();
    c(paramViewGroup);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(Menu paramMenu)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetTextView.getText() != null) && (!this.jdField_b_of_type_AndroidWidgetTextView.getText().toString().equals("")))
    {
      MenuItem localMenuItem = paramMenu.findItem(this.jdField_b_of_type_AndroidWidgetTextView.getId());
      if (localMenuItem == null) {
        break label98;
      }
      localMenuItem.setTitle(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramMenu = localMenuItem;
    }
    for (;;)
    {
      paramMenu.setEnabled(this.jdField_b_of_type_AndroidWidgetTextView.isEnabled());
      return true;
      label98:
      paramMenu = paramMenu.add(0, this.jdField_b_of_type_AndroidWidgetTextView.getId(), 0, this.jdField_b_of_type_AndroidWidgetTextView.getText());
      MenuItemCompat.setShowAsAction(paramMenu, 1);
    }
  }
  
  public boolean a(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    case 16908332: 
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return true;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.performClick();
    return true;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public boolean d()
  {
    i();
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130968589, 2130968590);
    return true;
  }
  
  public void e() {}
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = null;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel = null;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().a(this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationLister);
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131561802), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListModel.a()) }));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onstart");
    }
  }
  
  public void k()
  {
    super.k();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onStop");
    }
  }
  
  public abstract void l();
  
  public abstract void m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene
 * JD-Core Version:    0.7.0.1
 */