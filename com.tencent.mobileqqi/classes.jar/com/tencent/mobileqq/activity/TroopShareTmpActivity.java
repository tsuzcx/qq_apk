package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import dsw;

public class TroopShareTmpActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final int a = 20131022;
  public static final String a = "troop_uin";
  public static final int b = 20131023;
  public static final String b = "troop_name";
  public static final int c = 20131024;
  public static final String c = "troop_intro";
  public static final String d = "user_input";
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dsw(this);
  private String e;
  
  protected boolean a()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    setResult(20131023, null);
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      finish();
      return;
      setResult(20131023, null);
      continue;
      paramView = new Intent();
      paramView.putExtra("user_input", this.jdField_a_of_type_AndroidWidgetEditText.getText());
      setResult(20131024, paramView);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(2);
    setContentView(2130904041);
    Object localObject = getIntent();
    this.e = ((Intent)localObject).getExtras().getString("troop_uin");
    paramBundle = ((Intent)localObject).getExtras().getString("troop_name");
    localObject = ((Intent)localObject).getExtras().getString("troop_intro");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131230940));
    TextView localTextView1 = (TextView)findViewById(2131231090);
    TextView localTextView2 = (TextView)findViewById(2131234634);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231206));
    TextView localTextView3 = (TextView)findViewById(2131231619);
    TextView localTextView4 = (TextView)findViewById(2131234635);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.b.a(this.e));
    localTextView1.setText(paramBundle);
    localTextView2.setText((CharSequence)localObject);
    localTextView3.setOnClickListener(this);
    localTextView4.setOnClickListener(this);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopShareTmpActivity
 * JD-Core Version:    0.7.0.1
 */