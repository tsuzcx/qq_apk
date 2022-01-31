package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import doh;
import doi;
import java.util.Observable;
import java.util.Observer;

public class TroopAssistSetGuideActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static final String a = "troop_uin";
  public static final String b = "troop_name";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new doh(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Button b;
  private String c;
  private String d;
  
  private void e()
  {
    setTitle(this.d);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131234636));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234638));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
    if (!TextUtils.isEmpty(this.c))
    {
      Drawable localDrawable = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.c);
      if (localDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131234641));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131234640));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    d();
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    }
  }
  
  private void f()
  {
    TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
    setResult(0);
    finish();
  }
  
  private void g()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.c, Integer.valueOf(2));
    TroopAssistantManager.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
    setResult(-1);
    finish();
  }
  
  protected boolean b()
  {
    f();
    return super.b();
  }
  
  public void d()
  {
    int i;
    if (this.k != null)
    {
      QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.f();
        if (i <= 0) {
          break label117;
        }
        if (i <= 99) {
          break label76;
        }
        this.k.setText(getString(2131561807) + "(" + "99+" + ")");
      }
    }
    return;
    label76:
    this.k.setText(getString(2131561807) + "(" + i + ")");
    return;
    label117:
    this.k.setText(getString(2131561807));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130904042);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.c = paramBundle.getStringExtra("troop_uin");
      this.d = paramBundle.getStringExtra("troop_name");
    }
    e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new doi(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistSetGuideActivity
 * JD-Core Version:    0.7.0.1
 */