package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.widget.ClearableEditText;
import fso;

public class VerifyPwdActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private ClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText;
  private FMObserver b;
  
  public VerifyPwdActivity()
  {
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fso(this);
  }
  
  private void g()
  {
    this.m.setVisibility(8);
    setTitle(2131558679);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void h()
  {
    this.m.setVisibility(8);
    setTitle(2131558679);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void j()
  {
    startActivityForResult(new Intent(getApplicationContext(), FMCloudActivity.class), 101);
  }
  
  protected String a_()
  {
    if (this.k != null) {
      return this.k.getText().toString();
    }
    return super.a_();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 4) {
      setResult(4, paramIntent);
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((paramView == null) || (paramView.equals(""))) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130903516);
    paramBundle = findViewById(2131232786);
    ViewGroup.LayoutParams localLayoutParams = paramBundle.getLayoutParams();
    localLayoutParams.width = -1;
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle = findViewById(2131232754);
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131232787);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131231066));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131232789));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232791));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c())
    {
      g();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
      return;
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.VerifyPwdActivity
 * JD-Core Version:    0.7.0.1
 */