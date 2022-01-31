package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import dnx;
import dny;
import dnz;

public class ShortcutGuideDialogActivity
  extends BaseActivity
{
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setDividerGone();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131561592), new dny(this)).setNegativeButton(getString(2131561746), new dnx(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new dnz(this));
    View localView = getLayoutInflater().inflate(2130903628, null);
    ImageView localImageView = (ImageView)localView.findViewById(2131233162);
    TextView localTextView = (TextView)localView.findViewById(2131233163);
    localImageView.setImageDrawable(FaceDrawable.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_JavaLangString));
    localTextView.setText(String.format(getString(2131562226), new Object[] { this.jdField_b_of_type_JavaLangString }));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.addView(localView);
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("nick");
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      d();
      return true;
    }
    finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShortcutGuideDialogActivity
 * JD-Core Version:    0.7.0.1
 */