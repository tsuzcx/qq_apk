package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.LockPatternView;
import com.tencent.mobileqq.gesturelock.LockPatternView.Cell;
import com.tencent.mobileqq.widget.QQToast;
import cor;
import cos;
import java.util.Iterator;
import java.util.List;

public class GesturePWDCreateActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 3;
  private static final String jdField_b_of_type_JavaLangString = "Q.gesturelock.creat";
  static final int jdField_c_of_type_Int = 0;
  static final int jdField_d_of_type_Int = 1;
  public Handler a;
  private View a;
  public TextView a;
  public LockPatternView a;
  public String a;
  public int[] a;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private View jdField_c_of_type_AndroidViewView;
  private View jdField_d_of_type_AndroidViewView;
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  
  public GesturePWDCreateActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ArrayOfInt = new int[9];
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = 0;
    f();
  }
  
  private void e()
  {
    setTitle(2131562889);
    a(2131561746, new cor(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231737));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView = ((LockPatternView)findViewById(2131231739));
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setFillInGapCell(false);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setTactileFeedbackEnabled(true);
    this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setOnPatternListener(new cos(this));
    if (this.jdField_c_of_type_Float <= 1.0D)
    {
      ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.getLayoutParams();
      localLayoutParams.height = ((int)(this.jdField_c_of_type_Float * 240.0F));
      localLayoutParams.width = ((int)(this.jdField_c_of_type_Float * 240.0F));
      this.jdField_a_of_type_ComTencentMobileqqGesturelockLockPatternView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131231727);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131231728);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131231729);
    this.d = findViewById(2131231730);
    this.e = findViewById(2131231731);
    this.f = findViewById(2131231732);
    this.g = findViewById(2131231733);
    this.h = findViewById(2131231734);
    this.i = findViewById(2131231735);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = new int[9];
    }
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfInt.length)
    {
      this.jdField_a_of_type_ArrayOfInt[j] = 0;
      j += 1;
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length == 9))
    {
      if (this.jdField_a_of_type_ArrayOfInt[0] != 1) {
        break label192;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838943);
      if (this.jdField_a_of_type_ArrayOfInt[1] != 1) {
        break label204;
      }
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838943);
      label55:
      if (this.jdField_a_of_type_ArrayOfInt[2] != 1) {
        break label216;
      }
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838943);
      label74:
      if (this.jdField_a_of_type_ArrayOfInt[3] != 1) {
        break label228;
      }
      this.d.setBackgroundResource(2130838943);
      label93:
      if (this.jdField_a_of_type_ArrayOfInt[4] != 1) {
        break label240;
      }
      this.e.setBackgroundResource(2130838943);
      label112:
      if (this.jdField_a_of_type_ArrayOfInt[5] != 1) {
        break label252;
      }
      this.f.setBackgroundResource(2130838943);
      label131:
      if (this.jdField_a_of_type_ArrayOfInt[6] != 1) {
        break label264;
      }
      this.g.setBackgroundResource(2130838943);
      label151:
      if (this.jdField_a_of_type_ArrayOfInt[7] != 1) {
        break label276;
      }
      this.h.setBackgroundResource(2130838943);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ArrayOfInt[8] != 1) {
        break label288;
      }
      this.i.setBackgroundResource(2130838943);
      return;
      label192:
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838942);
      break;
      label204:
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838942);
      break label55;
      label216:
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838942);
      break label74;
      label228:
      this.d.setBackgroundResource(2130838942);
      break label93;
      label240:
      this.e.setBackgroundResource(2130838942);
      break label112;
      label252:
      this.f.setBackgroundResource(2130838942);
      break label131;
      label264:
      this.g.setBackgroundResource(2130838942);
      break label151;
      label276:
      this.h.setBackgroundResource(2130838942);
    }
    label288:
    this.i.setBackgroundResource(2130838942);
  }
  
  public void a(int paramInt, String paramString)
  {
    QQToast.a(this, paramInt, paramString, 0).b(d());
  }
  
  public void a(List paramList)
  {
    f();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        LockPatternView.Cell localCell = (LockPatternView.Cell)paramList.next();
        if (localCell != null)
        {
          int j = localCell.a();
          j = localCell.b() + j * 3;
          if ((j >= 0) && (j < this.jdField_a_of_type_ArrayOfInt.length)) {
            this.jdField_a_of_type_ArrayOfInt[j] = 1;
          }
        }
      }
    }
    g();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903240);
    d();
    e();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968595, 2130968599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDCreateActivity
 * JD-Core Version:    0.7.0.1
 */