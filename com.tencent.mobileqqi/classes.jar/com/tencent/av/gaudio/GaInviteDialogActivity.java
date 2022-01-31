package com.tencent.av.gaudio;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class GaInviteDialogActivity
  extends GaInviteActivity
{
  static String jdField_b_of_type_JavaLangString = "GaInviteDialogActivity";
  View jdField_a_of_type_AndroidViewView = null;
  Button jdField_a_of_type_AndroidWidgetButton = null;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  int c = 0;
  int jdField_d_of_type_Int = 0;
  TextView jdField_d_of_type_AndroidWidgetTextView = null;
  boolean e = true;
  
  public void BtnOnClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232229: 
      super.c();
      ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_ignore ", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "Multi_call", "Multi_call_join", 0, 0, "", "", "", "");
    super.b();
  }
  
  protected void a()
  {
    if ((!NetworkUtil.g(super.getApplicationContext())) && ((NetworkUtil.d(super.getApplicationContext())) || (NetworkUtil.c(super.getApplicationContext())))) {
      this.e = false;
    }
    this.jdField_a_of_type_Int = UITools.a(super.getApplicationContext());
    this.jdField_b_of_type_Int = UITools.b(super.getApplicationContext());
    this.jdField_d_of_type_Int = super.getResources().getDimensionPixelSize(2131427660);
    this.c = super.getResources().getDimensionPixelSize(2131427661);
    RelativeLayout localRelativeLayout = (RelativeLayout)super.findViewById(2131232223);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    localLayoutParams.width = this.jdField_d_of_type_Int;
    localLayoutParams.height = this.c;
    int j;
    if (this.jdField_b_of_type_Int > this.jdField_a_of_type_Int) {
      j = this.jdField_b_of_type_Int;
    }
    for (int i = this.jdField_a_of_type_Int;; i = this.jdField_b_of_type_Int)
    {
      localLayoutParams.setMargins((i - this.jdField_d_of_type_Int) / 2, (j - this.c) / 3, 0, 0);
      localRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232226));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232225));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131232224));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232229));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131232230));
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131231467);
      if (!this.e)
      {
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131232228));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      super.a();
      return;
      j = this.jdField_a_of_type_Int;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "onCreate");
    }
    super.onCreate(paramBundle);
    super.setContentView(2130903349);
    a();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteDialogActivity
 * JD-Core Version:    0.7.0.1
 */