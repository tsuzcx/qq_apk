package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bty;
import btz;
import bua;
import bub;
import buc;
import bud;
import bue;
import buf;
import bug;
import buh;
import bui;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements View.OnTouchListener
{
  static final int jdField_a_of_type_Int = 30;
  public static final String a = "AddFriendVerifyActivity";
  public static final boolean a = true;
  private static final int jdField_b_of_type_Int = 0;
  private static final String jdField_b_of_type_JavaLangString = "last_verify_msg";
  private static final String jdField_c_of_type_JavaLangString = "last_add_friend_verify_";
  private static final String d = "last_add_troop_verfity_";
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new buh(this);
  public EditText a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new bui(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new btz(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new bua(this);
  public QQProgressDialog a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int = 0;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  
  private String a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean) {
      return localSharedPreferences.getString("last_add_troop_verfity_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null);
    }
    return localSharedPreferences.getString("last_add_friend_verify_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null);
  }
  
  private boolean c()
  {
    int i = getIntent().getExtras().getInt("source_id", 10004);
    return (i == 3003) || (i == 3006) || (i == 3007) || (i == 3009) || (i == 3013);
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2, String paramString3, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent(this, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("friend_setting", paramInt1);
    localIntent.putExtra("allow_flag", true);
    localIntent.putExtra("msg", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("friend_mobile_number", paramString3);
    localIntent.putExtra("sig", paramArrayOfByte);
    localIntent.putExtra("friend_mobile_name", getIntent().getStringExtra("friend_mobile_name"));
    localIntent.putExtra("k_add_friend_by_mobile", getIntent().getBooleanExtra("k_add_friend_by_mobile", false));
    localIntent.putExtra("nick_name", getIntent().getStringExtra("nick_name"));
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "startAutoRemarkActivity | put mobile name: " + getIntent().getStringExtra("friend_mobile_name"));
    }
    if (3004 == paramInt2) {
      localIntent.putExtra("troop_uin", getIntent().getStringExtra("troop_uin"));
    }
    localIntent.putExtra("sub_source_id", getIntent().getIntExtra("sub_source_id", 0));
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      localIntent.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity(localIntent);
      return;
    }
    startActivityForResult(localIntent, 0);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localSharedPreferences.edit().putString("last_add_troop_verfity_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString).commit();
      return;
    }
    localSharedPreferences.edit().putString("last_add_friend_verify_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString).commit();
  }
  
  protected boolean b()
  {
    int i = getIntent().getExtras().getInt("friend_setting");
    if (1 == i) {
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), false);
    }
    for (;;)
    {
      return super.b();
      if (9 == i) {
        a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), true);
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    c(2130903084);
    j(2130837729);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131561586);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231091));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231092));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231094));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131231095));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231096));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231098));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131231099));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231100));
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_c_of_type_Int = getIntent().getExtras().getInt("friend_setting");
    String str2 = getIntent().getExtras().getString("uin");
    ArrayList localArrayList = getIntent().getExtras().getStringArrayList("user_question");
    Object localObject1 = getIntent().getExtras().getString("nick_name");
    int j = getIntent().getExtras().getInt("source_id", 10004);
    String str1 = getIntent().getExtras().getString("friend_mobile_number");
    Object localObject2 = getIntent().getExtras().getString("friend_mobile_name");
    boolean bool = getIntent().getBooleanExtra("k_add_friend_by_mobile", false);
    int i = getIntent().getExtras().getShort("group_option", (short)2);
    Object localObject4 = getIntent().getExtras().getString("troop_question");
    Object localObject5 = (ImageView)findViewById(2131231089);
    TextView localTextView1;
    TextView localTextView2;
    Object localObject3;
    if (this.jdField_c_of_type_Int == 9)
    {
      setTitle(2131562780);
      paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(str2);
      ((ImageView)localObject5).setImageDrawable(paramBundle);
      localTextView1 = (TextView)findViewById(2131231090);
      localTextView2 = (TextView)findViewById(2131230990);
      localTextView2.setVisibility(0);
      localObject3 = ((FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).d(str2);
      new TextPaint().setTextSize(DisplayUtils.a(this, 15.0F));
      if (!bool) {
        break label585;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label579;
      }
      paramBundle = str1;
      label461:
      localTextView1.setText(paramBundle);
      localTextView2.setText(str1);
    }
    label474:
    switch (this.jdField_c_of_type_Int)
    {
    case 0: 
    case 2: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
    case 1: 
    case 3: 
    case 4: 
      for (;;)
      {
        d(true);
        return true;
        setTitle(2131562779);
        if (bool)
        {
          paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(str1, (byte)3);
          break;
        }
        paramBundle = FaceDrawable.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 1, str2);
        break;
        paramBundle = (Bundle)localObject2;
        break label461;
        if (c())
        {
          if (localObject1 == null) {
            break label474;
          }
          localTextView1.setText((CharSequence)localObject1);
          break label474;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (paramBundle = (Bundle)localObject3;; paramBundle = (Bundle)localObject1)
        {
          localTextView1.setText(paramBundle);
          localTextView2.setText((CharSequence)localObject3);
          break;
        }
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(getString(2131562032));
        this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
        paramBundle = a(false);
        if (paramBundle != null)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.setText(paramBundle);
          this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramBundle.length());
        }
        b(2131562463, new bty(this, str2, j, str1));
        getWindow().setSoftInputMode(5);
        continue;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        paramBundle = (String)localArrayList.get(0);
        localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131231293);
        localObject2 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131232845);
        ((TextView)localObject1).setText(getString(2131562694) + ":" + paramBundle);
        ((EditText)localObject2).setSingleLine(true);
        ((EditText)localObject2).setContentDescription(getString(2131561094));
        b(2131562463, new bub(this, (EditText)localObject2, str2, j, str1));
        getWindow().setSoftInputMode(5);
        continue;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        localObject1 = new InputFilter.LengthFilter(10);
        findViewById(2131231093).setVisibility(0);
        localObject2 = new StringBuffer();
        i = 0;
        if (i < localArrayList.size())
        {
          switch (i)
          {
          default: 
            paramBundle = getResources().getString(2131562694);
          }
          for (;;)
          {
            localObject3 = getLayoutInflater().inflate(2130903539, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            localObject4 = getLayoutInflater().inflate(2130903538, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
            if (i > 0)
            {
              localObject5 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
              if (localObject5 != null)
              {
                ((LinearLayout.LayoutParams)localObject5).topMargin = ((int)DisplayUtils.a(getApplication(), 20.0F));
                ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject5);
              }
            }
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
            localObject5 = (String)localArrayList.get(i);
            ((TextView)((View)localObject3).findViewById(2131231293)).setText(paramBundle + (String)localObject5);
            paramBundle = (EditText)((View)localObject4).findViewById(2131232845);
            paramBundle.setFilters(new InputFilter[] { localObject1 });
            paramBundle.setSingleLine(false);
            this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
            ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setContentDescription(getString(2131561094));
            int k = i + 1;
            ((StringBuffer)localObject2).append(getString(2131562694) + k + ":" + (String)localObject5);
            ((StringBuffer)localObject2).append("\n");
            ((StringBuffer)localObject2).append(getString(2131562766) + ":" + "${answer}");
            if (k != localArrayList.size()) {
              ((StringBuffer)localObject2).append("\n");
            }
            i += 1;
            break;
            paramBundle = getResources().getString(2131562695);
            continue;
            paramBundle = getResources().getString(2131562696);
            continue;
            paramBundle = getResources().getString(2131562697);
            continue;
            paramBundle = getResources().getString(2131562698);
            continue;
            paramBundle = getResources().getString(2131562699);
          }
        }
        b(2131562463, new buc(this, (StringBuffer)localObject2, str2, j, str1));
        findViewById(2131231088).setOnTouchListener(new bud(this));
        getWindow().setSoftInputMode(4);
      }
    }
    label579:
    label585:
    ((ImageView)localObject5).setVisibility(8);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    switch (i)
    {
    }
    for (;;)
    {
      getWindow().setSoftInputMode(5);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(92.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(false);
      this.jdField_b_of_type_AndroidWidgetEditText.setGravity(48);
      this.jdField_b_of_type_AndroidWidgetEditText.setBackgroundResource(2130840178);
      i = AIOUtils.a(10.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetEditText.setPadding(i, i, i, i);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("30");
      paramBundle = a(true);
      if (paramBundle != null)
      {
        this.jdField_b_of_type_AndroidWidgetEditText.setText(paramBundle);
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramBundle.length());
        this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131561094));
      }
      b(2131562857, new bue(this, str2));
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131562694) + ":" + (String)localObject4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(getString(2131561660));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setMinHeight((int)DisplayUtils.a(a(), 44.0F));
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(44.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131561094));
      b(2131562857, new buf(this, str2));
      continue;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131562694) + ":" + (String)localObject4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(getString(2131561660));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setMinHeight((int)DisplayUtils.a(a(), 44.0F));
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(44.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131561094));
      b(2131562857, new bug(this, str2));
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
  }
  
  public void finish()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.k.getWindowToken(), 2);
    super.finish();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131232845) {}
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return false;
    case 0: 
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      return false;
    }
    paramView.getParent().requestDisallowInterceptTouchEvent(false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity
 * JD-Core Version:    0.7.0.1
 */