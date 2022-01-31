package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.util.ArrayList;
import ww;
import wx;
import wy;
import wz;
import xa;
import xb;
import xc;
import xd;
import xe;
import xf;
import xg;

public class AddFriendVerifyActivity
  extends IphoneTitleBarActivity
  implements View.OnTouchListener
{
  public static final int a = 30;
  public static final String a = "AddFriendVerifyActivity";
  private static final int jdField_b_of_type_Int = 0;
  public static final boolean b = true;
  private static final String jdField_d_of_type_JavaLangString = "last_verify_msg";
  private static final String e = "last_add_friend_verify_";
  private static final String f = "last_add_troop_verfity_";
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new xf(this);
  public EditText a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new xg(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wx(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new wy(this);
  protected FormSwitchItem a;
  public QQProgressDialog a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean a;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  protected String b;
  private int jdField_c_of_type_Int;
  protected LinearLayout c;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected String c;
  protected boolean c;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String g;
  
  public AddFriendVerifyActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private String a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean) {
      return localSharedPreferences.getString("last_add_troop_verfity_" + this.app.getAccount(), null);
    }
    return localSharedPreferences.getString("last_add_friend_verify_" + this.app.getAccount(), null);
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    ((TroopHandler)this.app.a(17)).a(paramString1, paramString2, paramInt);
    ReportController.b(this.app, "P_CliOper", "Grp_join", "", "send", "set_close", 0, 0, paramString1, "", "", "");
  }
  
  private boolean c()
  {
    int i = getIntent().getExtras().getInt("source_id", 10004);
    return (i == 3003) || (i == 3006) || (i == 3007) || (i == 3009) || (i == 3013);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getActivity().getSharedPreferences("last_verify_msg", 0);
    if (paramBoolean)
    {
      localSharedPreferences.edit().putString("last_add_troop_verfity_" + this.app.getAccount(), paramString).commit();
      return;
    }
    localSharedPreferences.edit().putString("last_add_friend_verify_" + this.app.getAccount(), paramString).commit();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent(this, AutoRemarkActivity.class);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("msg", paramString);
    localIntent.putExtra("sig", paramArrayOfByte);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      localIntent.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity(localIntent);
      return;
    }
    startActivityForResult(localIntent, 0);
  }
  
  protected boolean a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (4 == this.jdField_c_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      a(str, bool);
      return super.a();
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
    setContentViewB(2130903059);
    d(2130837660);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363491);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296536));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296537));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296539));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131296540));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296541));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296543));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131296544));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296545));
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    Object localObject4 = getIntent();
    this.g = ((Intent)localObject4).getStringExtra("uin");
    this.jdField_c_of_type_Int = ((Intent)localObject4).getIntExtra("k_uin_type", 1);
    paramBundle = getIntent().getExtras().getString("nick_name");
    Object localObject2 = (ImageView)findViewById(2131296534);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296535));
    Object localObject3 = (TextView)findViewById(2131296447);
    Object localObject1;
    int i;
    if (this.jdField_c_of_type_Int == 4)
    {
      setTitle(2131364182);
      ((ImageView)localObject2).setImageDrawable(this.app.a(this.g));
      localObject4 = this.jdField_d_of_type_AndroidWidgetTextView;
      localObject1 = paramBundle;
      if (TextUtils.isEmpty(paramBundle)) {
        localObject1 = this.g;
      }
      ((TextView)localObject4).setText((CharSequence)localObject1);
      ((TextView)localObject3).setText(this.g);
      this.jdField_b_of_type_JavaLangString = this.g;
      this.jdField_c_of_type_JavaLangString = getIntent().getExtras().getString("troop_code");
      paramBundle = (TroopHandler)this.app.a(17);
      if (paramBundle != null) {
        paramBundle.a(this.jdField_b_of_type_JavaLangString);
      }
      ((ImageView)localObject2).setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      ((TextView)localObject3).setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      i = getIntent().getExtras().getShort("group_option", (short)2);
      paramBundle = getIntent().getExtras().getString("troop_question");
      switch (i)
      {
      case 3: 
      default: 
        getWindow().setSoftInputMode(5);
      }
    }
    for (;;)
    {
      c(true);
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(92.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(false);
      this.jdField_b_of_type_AndroidWidgetEditText.setGravity(48);
      this.jdField_b_of_type_AndroidWidgetEditText.setBackgroundResource(2130839380);
      i = AIOUtils.a(10.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetEditText.setPadding(i, i, i, i);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("30");
      paramBundle = a(true);
      if (paramBundle != null)
      {
        this.jdField_b_of_type_AndroidWidgetEditText.setText(paramBundle);
        this.jdField_b_of_type_AndroidWidgetEditText.setSelection(paramBundle.length());
        this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131364507));
      }
      a(2131363082, new ww(this));
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131363401) + ":" + paramBundle);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(getString(2131363402));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setMinHeight((int)DisplayUtils.a(this, 44.0F));
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(44.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131364507));
      a(2131363082, new wz(this));
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131363401) + ":" + paramBundle);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetEditText.setHint(getString(2131363402));
      this.jdField_b_of_type_AndroidWidgetEditText.setSingleLine(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setMinHeight((int)DisplayUtils.a(this, 44.0F));
      this.jdField_b_of_type_AndroidWidgetEditText.setHeight(AIOUtils.a(44.0F, getResources()));
      this.jdField_b_of_type_AndroidWidgetEditText.setTextColor(-16777216);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetEditText.setContentDescription(getString(2131364507));
      a(2131363082, new xa(this));
      break;
      setTitle(2131363329);
      ((TextView)localObject3).setVisibility(0);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      i = getIntent().getExtras().getInt("source_id", 10004);
      if (this.jdField_c_of_type_Int == 2)
      {
        ((ImageView)localObject2).setImageDrawable(FaceDrawable.a(this.app, 11, this.g));
        localObject2 = this.jdField_d_of_type_AndroidWidgetTextView;
        localObject1 = paramBundle;
        if (TextUtils.isEmpty(paramBundle)) {
          localObject1 = this.g;
        }
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject3).setText(this.g);
      }
      int j;
      label1462:
      Object localObject5;
      for (;;)
      {
        j = ((Intent)localObject4).getIntExtra("friend_setting", 0);
        localObject1 = getIntent().getExtras().getStringArrayList("user_question");
        switch (j)
        {
        case 0: 
        case 2: 
        default: 
          break;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetEditText.setHint(getString(2131363400));
          this.jdField_a_of_type_AndroidWidgetEditText.setVisibility(0);
          paramBundle = null;
          if (this.jdField_c_of_type_Int == 3) {
            paramBundle = ((Intent)localObject4).getStringExtra("msg");
          }
          localObject1 = paramBundle;
          if (TextUtils.isEmpty(paramBundle)) {
            localObject1 = a(false);
          }
          if (localObject1 != null)
          {
            this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
            this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject1).length());
          }
          a(2131363519, new xb(this));
          getWindow().setSoftInputMode(5);
          break;
          if (this.jdField_c_of_type_Int == 3)
          {
            localObject1 = ((Intent)localObject4).getStringExtra("extra");
            ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(FaceDrawable.a(this.g, (String)localObject1)));
            ((TextView)localObject3).setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
            ((FriendListHandler)this.app.a(1)).a(this.g, getIntent().getStringExtra("extra"));
          }
          else
          {
            if ((i == 3007) || (i == 2007) || (i == 3019) || (i == 2019)) {
              ((ImageView)localObject2).setImageDrawable(FaceDrawable.a(this.app, 3000, this.g, true));
            }
            for (;;)
            {
              localObject2 = ((FriendManager)this.app.getManager(8)).d(this.g);
              if (!c()) {
                break label1462;
              }
              if (paramBundle == null) {
                break;
              }
              this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
              break;
              ((ImageView)localObject2).setImageDrawable(FaceDrawable.a(this.app, 1, this.g));
            }
            localObject5 = this.jdField_d_of_type_AndroidWidgetTextView;
            localObject1 = paramBundle;
            if (TextUtils.isEmpty(paramBundle)) {
              localObject1 = localObject2;
            }
            ((TextView)localObject5).setText((CharSequence)localObject1);
            ((TextView)localObject3).setText((CharSequence)localObject2);
          }
          break;
        }
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramBundle = (String)((ArrayList)localObject1).get(0);
      localObject1 = (TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131296761);
      localObject2 = (EditText)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131298104);
      ((TextView)localObject1).setText(getString(2131363401) + ":" + paramBundle);
      ((EditText)localObject2).setSingleLine(true);
      ((EditText)localObject2).setContentDescription(getString(2131364507));
      a(2131363519, new xc(this, (EditText)localObject2, j, i));
      getWindow().setSoftInputMode(5);
      continue;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject2 = new InputFilter.LengthFilter(10);
      findViewById(2131296538).setVisibility(0);
      localObject3 = new StringBuffer();
      i = 0;
      if (i < ((ArrayList)localObject1).size())
      {
        switch (i)
        {
        default: 
          paramBundle = getResources().getString(2131363401);
        }
        for (;;)
        {
          localObject4 = getLayoutInflater().inflate(2130903464, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
          localObject5 = getLayoutInflater().inflate(2130903463, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
          if (i > 0)
          {
            localObject6 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
            if (localObject6 != null)
            {
              ((LinearLayout.LayoutParams)localObject6).topMargin = ((int)DisplayUtils.a(getApplication(), 20.0F));
              ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject6);
            }
          }
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject5);
          Object localObject6 = (String)((ArrayList)localObject1).get(i);
          ((TextView)((View)localObject4).findViewById(2131296761)).setText(paramBundle + (String)localObject6);
          paramBundle = (EditText)((View)localObject5).findViewById(2131298104);
          paramBundle.setFilters(new InputFilter[] { localObject2 });
          paramBundle.setSingleLine(false);
          this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
          ((EditText)this.jdField_a_of_type_JavaUtilArrayList.get(i)).setContentDescription(getString(2131364507));
          j = i + 1;
          ((StringBuffer)localObject3).append(getString(2131363401) + j + ":" + (String)localObject6);
          ((StringBuffer)localObject3).append("\n");
          ((StringBuffer)localObject3).append(getString(2131363404) + ":" + "${answer}");
          if (j != ((ArrayList)localObject1).size()) {
            ((StringBuffer)localObject3).append("\n");
          }
          i += 1;
          break;
          paramBundle = getResources().getString(2131363492);
          continue;
          paramBundle = getResources().getString(2131363493);
          continue;
          paramBundle = getResources().getString(2131363494);
          continue;
          paramBundle = getResources().getString(2131363495);
          continue;
          paramBundle = getResources().getString(2131363496);
        }
      }
      a(2131363519, new xd(this, (StringBuffer)localObject3));
      findViewById(2131296533).setOnTouchListener(new xe(this));
      getWindow().setSoftInputMode(4);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  public void finish()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.h.getWindowToken(), 2);
    super.finish();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView.getId() == 2131298104) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity
 * JD-Core Version:    0.7.0.1
 */