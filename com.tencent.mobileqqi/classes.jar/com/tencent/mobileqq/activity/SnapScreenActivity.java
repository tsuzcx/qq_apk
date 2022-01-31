package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import dim;
import din;
import dio;
import dip;
import mqq.util.NativeUtil;

public class SnapScreenActivity
  extends Activity
{
  public static final String a;
  static final int b = -16847;
  public int a;
  public Context a;
  public Bitmap a;
  public Drawable a;
  private ViewGroup a;
  public Window a;
  public Button a;
  public dip a;
  public Bitmap b;
  public Drawable b;
  public Button b;
  public Bitmap c;
  public Button c;
  public Button d;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.al + "/QQ_Screenshot/";
  }
  
  public static final Uri a()
  {
    String str = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("LastScreenShotUri", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return Uri.parse(str);
  }
  
  private void a(Context paramContext, Window paramWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      for (paramWindow = (Activity)this.jdField_a_of_type_AndroidContentContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
    }
    for (this.jdField_a_of_type_AndroidViewWindow = paramWindow.getWindow();; this.jdField_a_of_type_AndroidViewWindow = paramWindow)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839692);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839691);
      paramContext = (LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater");
      this.jdField_a_of_type_Dip = new dip(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Dip, 0);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234396));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234397));
      this.d = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234395));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131234394));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new dim(this));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new din(this));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new dio(this));
      return;
    }
  }
  
  private void d() {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.d.setVisibility(8);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.getParent() != null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation;
    this.jdField_a_of_type_Dip.k = 0;
    this.jdField_a_of_type_Dip.a.setEmpty();
    Bitmap localBitmap = NativeUtil.screenshot(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_c_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    a(false);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      d();
    }
    while (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    d();
  }
  
  public void c()
  {
    a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903943);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131231116));
    a(this, getWindow());
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SnapScreenActivity
 * JD-Core Version:    0.7.0.1
 */