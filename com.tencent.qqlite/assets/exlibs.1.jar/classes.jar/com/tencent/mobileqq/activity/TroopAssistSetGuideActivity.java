package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import blu;
import blv;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import java.util.Observable;
import java.util.Observer;

public class TroopAssistSetGuideActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public static final String a = "troop_uin";
  public static final String b = "troop_name";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new blu(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Button b;
  private String c;
  private String d;
  
  private void d()
  {
    setTitle(this.d);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131298926));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298928));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
    if (!TextUtils.isEmpty(this.c))
    {
      Drawable localDrawable = this.app.a(this.c);
      if (localDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298931));
    this.b = ((Button)findViewById(2131298930));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.b.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    c();
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().addObserver(this);
    }
  }
  
  private void e()
  {
    TroopAssistantManager.a().a(this.app, this.c);
    setResult(0);
    finish();
  }
  
  private void f()
  {
    this.app.a(this.c, Integer.valueOf(2));
    TroopAssistantManager.a().a(this.app, this.c);
    setResult(-1);
    finish();
  }
  
  protected boolean a()
  {
    e();
    return super.a();
  }
  
  public void c()
  {
    int i;
    if (this.h != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.e();
        if (i <= 0) {
          break label117;
        }
        if (i <= 99) {
          break label76;
        }
        this.h.setText(getString(2131362957) + "(" + "99+" + ")");
      }
    }
    return;
    label76:
    this.h.setText(getString(2131362957) + "(" + i + ")");
    return;
    label117:
    this.h.setText(getString(2131362957));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903694);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      this.c = paramBundle.getStringExtra("troop_uin");
      this.d = paramBundle.getStringExtra("troop_name");
    }
    d();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new blv(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistSetGuideActivity
 * JD-Core Version:    0.7.0.1
 */