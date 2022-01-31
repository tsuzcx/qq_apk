package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import dry;
import drz;
import dsb;
import dsc;
import dsg;
import dsj;

public class SubAccountSettingActivity
  extends SubAccountBaseActivity
{
  public static final int a = 1985;
  Handler jdField_a_of_type_AndroidOsHandler = new dry(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new dsg(this);
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dsj(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new drz(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new dsc(this);
  private SubAccountInfo jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString = "Q.subaccount.SubAccountSettingActivity";
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  private void h()
  {
    setTitle(2131561709);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234568));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234569));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234570));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234571));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131234573);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131234574));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131234575));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131234576));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    boolean bool = SubAccountAssistantImpl.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131234572));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new dsb(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = SubAccountDataControll.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))
      {
        localObject = new Intent(this, SubaccountUgActivity.class);
        ((Intent)localObject).putExtra("from_where", true);
        startActivity((Intent)localObject);
        finish();
      }
      for (;;)
      {
        return;
        localObject = ContactUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin, false);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname)))) {
          this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname = ((String)localObject);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subname);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
        if (this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.isbind == 0) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        while ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin)))
        {
          localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          return;
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        }
      }
    }
    Object localObject = new Intent(this, SubaccountUgActivity.class);
    ((Intent)localObject).putExtra("from_where", true);
    startActivity((Intent)localObject);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904005);
    h();
    i();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  protected void onDestroy()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountSettingActivity
 * JD-Core Version:    0.7.0.1
 */