package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.widget.ClearableEditText;
import cpr;
import cps;
import cpt;
import cpu;
import cpv;
import java.io.UnsupportedEncodingException;

public class EditActivity
  extends IphoneTitleBarActivity
  implements EmoticonCallback
{
  public static final int a = 210;
  public static final String a = "editType";
  public static final int b = 150;
  public static final String b = "leftBtn_type";
  public static final int c = 96;
  public static final String c = "leftBtn_text";
  public static final int d = 210;
  public static final String d = "rightBtn_show";
  public static final int e = 48;
  public static final String e = "rightBtn_text";
  public static final int f = 24;
  public static final String f = "support_emotion";
  public static final int g = 30;
  public static final int h = 900;
  public static final int i = 150;
  public static final int j = -1;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 0;
  public static final int n = 1;
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 100;
  public static final int r = 101;
  float jdField_a_of_type_Float = 1.5F;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new cpv(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  public ClearableEditText a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b;
  private boolean c = true;
  private String g;
  public int s;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  
  public EditActivity()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131231762));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new cpr(this));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this, this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231764));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setOnClickListener(new cps(this));
  }
  
  private void i()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231761));
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setEditableFactory(QQTextBuilder.a);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.requestFocus();
    setTitle(this.t);
    b(2131561977, new cpt(this));
    d(true);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getLayoutParams();
    int i1;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.g);
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i1, i1);
      if (localLayoutParams != null) {
        localLayoutParams.height = ((int)(74.0F * this.jdField_a_of_type_Float));
      }
    }
    for (;;)
    {
      if (localLayoutParams != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setLayoutParams(localLayoutParams);
      }
      new Handler().postDelayed(new cpu(this), 500L);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSingleLine(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText(this.g);
      i1 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().length();
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setSelection(i1, i1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setGravity(48);
      if (localLayoutParams != null) {
        localLayoutParams.height = ((int)(150.0F * this.jdField_a_of_type_Float));
      }
    }
  }
  
  public void a()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, null);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void b() {}
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  protected boolean b()
  {
    f();
    return super.b();
  }
  
  public void d() {}
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.a();
    }
    super.doOnDestroy();
  }
  
  public void e()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText, 2);
  }
  
  public void f()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getWindowToken(), 0);
  }
  
  public void g()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if (!android.text.TextUtils.isEmpty(str2))
    {
      Object localObject1 = new byte[0];
      try
      {
        localObject2 = str2.getBytes("utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2;
          localUnsupportedEncodingException.printStackTrace();
          continue;
          String str1 = i1 + "/" + this.u;
          localObject1 = getResources().getColorStateList(2131362099);
        }
        if ((i1 > 0) && (i1 <= this.u))
        {
          d(true);
          return;
        }
        if ((i1 == 0) && (this.c))
        {
          d(true);
          return;
        }
        d(false);
        return;
      }
    }
    for (int i1 = localObject1.length;; i1 = 0) {
      if (i1 > this.u)
      {
        localObject2 = getString(2131563294) + "！ " + i1 + "/" + this.u;
        localObject1 = getResources().getColorStateList(2131362115);
        if (localObject1 != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor((ColorStateList)localObject1);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        if ((this.s != 101) || (!android.text.TextUtils.isEmpty(str2.trim()))) {
          continue;
        }
        d(false);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.v = paramBundle.getIntExtra("support_emotion", 0);
    setContentView(2130903244);
    j(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText = ((ClearableEditText)findViewById(2131231760));
    if (this.v == 1) {
      h();
    }
    this.t = paramBundle.getIntExtra("title", 0);
    this.u = paramBundle.getIntExtra("limit", 0);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("multiLine", false);
    this.s = paramBundle.getIntExtra("action", 0);
    this.c = paramBundle.getBooleanExtra("canPostNull", true);
    this.g = paramBundle.getStringExtra("current");
    if (this.g == null) {
      this.g = "";
    }
    i();
  }
  
  protected void onPause()
  {
    f();
    super.onPause();
  }
  
  protected void onResume()
  {
    if (!this.jdField_a_of_type_Boolean) {
      e();
    }
    super.onResume();
  }
  
  public void u_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditActivity
 * JD-Core Version:    0.7.0.1
 */