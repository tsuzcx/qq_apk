package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.base.LengthInputFilter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.widget.IKeyboardChanged;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import hna;

public class BragActivity
  extends ChallengeBragBase
  implements IKeyboardChanged
{
  protected static final int a = 100;
  protected static final String a;
  public static final int b = 10;
  public static final int c = 10;
  public static final int d = 255;
  public static final int e = 20;
  public static final int f = 90;
  public static final int g = 10;
  public static final int h = 145;
  public ImageView a;
  protected ScrollView a;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = BragActivity.class.getName();
  }
  
  public void a(int paramInt)
  {
    paramInt = super.b(this, paramInt) - 10 - 10;
    if ((this.jdField_a_of_type_AndroidWidgetScrollView != null) && (paramInt < 255))
    {
      paramInt = paramInt - 20 - 145;
      if ((paramInt <= 0) || (paramInt >= 90)) {
        break label81;
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = super.a(this, paramInt);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
    }
    label81:
    while (paramInt > 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131232135));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131232134));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232137));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131232139));
    this.b = ((TextView)super.findViewById(2131231473));
    this.c = ((TextView)super.findViewById(2131231472));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232138));
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new LengthInputFilter(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.j);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    try
    {
      a(this.i);
      Bitmap localBitmap = ImageLoader.a().a(this.k);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "getNickName error. " + localException.getMessage(), localException);
      f();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838008);
    ImageLoader.a().a(this.k, new hna(this));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = super.a(this, 90.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.getWindow().requestFeature(1);
    super.setContentView(2130903337);
    super.c();
    d();
    StaticAnalyz.a("100", "ANDROIDQQ.BRAG.FS", this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.BragActivity
 * JD-Core Version:    0.7.0.1
 */