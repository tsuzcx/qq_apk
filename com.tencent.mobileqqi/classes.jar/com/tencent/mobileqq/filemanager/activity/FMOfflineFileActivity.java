package com.tencent.mobileqq.filemanager.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import fvh;

public class FMOfflineFileActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static String a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  static
  {
    jdField_a_of_type_JavaLangString = "FileAssistantActivity<FileAssistant>";
  }
  
  private void d()
  {
    setTitle(2131558682);
    TextView localTextView = this.m;
    localTextView.setVisibility(0);
    localTextView.setText(getString(2131558675));
    localTextView.setOnClickListener(new fvh(this));
    if (this.k.getText().toString().contains(getString(2131561807))) {
      this.jdField_a_of_type_AndroidWidgetTextView = this.k;
    }
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "cloudlet file");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903493);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMOfflineFileActivity
 * JD-Core Version:    0.7.0.1
 */