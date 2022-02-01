package com.tencent.mobileqq.activity;

import acfp;
import aluh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aprg;
import apuh;
import aqiw;
import arhz;
import auru;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResultItem;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import udq;
import yob;
import yob.a;
import yow;

public class AddFriendActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener
{
  private TextView BD;
  private EditText K;
  private final Pattern Q = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$", 2);
  private final Pattern R = Pattern.compile("[^0-9]");
  String Tl = "";
  yob.a jdField_a_of_type_Yob$a = new udq(this);
  private yob jdField_a_of_type_Yob;
  String aKE;
  private boolean aRc;
  private boolean aRd = true;
  private boolean aRe;
  private boolean aRf;
  private InputMethodManager e;
  private Handler handler = new auru(this);
  arhz u;
  
  private void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    bFC();
    if ((!paramBoolean) || (paramInt2 != 0))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        uQ(paramString);
        return;
      }
      zH(2131693730);
      return;
    }
    label289:
    label342:
    label348:
    label360:
    for (;;)
    {
      yow localyow;
      int i;
      try
      {
        paramString = (ArrayList)paramObject;
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label342;
        }
        Iterator localIterator1 = paramString.iterator();
        paramString = null;
        if (!localIterator1.hasNext()) {
          break label360;
        }
        localyow = (yow)localIterator1.next();
        if ((localyow == null) || (localyow.resultType != 80000000) || (localyow.sS == null) || (localyow.sS.size() == 0)) {
          continue;
        }
        Iterator localIterator2 = localyow.sS.iterator();
        i = 0;
        if (!localIterator2.hasNext()) {
          break label348;
        }
        AccountSearchPb.record localrecord = (AccountSearchPb.record)localIterator2.next();
        if ((localrecord == null) || (localrecord.uin.get() == 0L)) {
          continue;
        }
        i += 1;
        continue;
        if ((paramString != null) && (paramString.sS != null) && (paramString.sS.size() != 0)) {
          break label289;
        }
        zH(2131719293);
        return;
      }
      catch (Exception paramString)
      {
        zH(2131693730);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AddFriendActivity", 2, "onSearchResult | searchType = " + paramInt1 + " | isSuccess = " + paramBoolean + " | rsCode = " + paramInt2 + " | data = " + paramObject, paramString);
      return;
      if (paramString.sS.size() == 1)
      {
        a(this, new SearchResultItem((AccountSearchPb.record)paramString.sS.get(0)), this.app, false, 1);
        return;
      }
      a(paramString);
      return;
      paramString = null;
      continue;
      if (i != 0) {
        paramString = localyow;
      }
    }
  }
  
  public static void a(Activity paramActivity, SearchResultItem paramSearchResultItem, QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    if (paramSearchResultItem == null) {
      return;
    }
    long l3 = paramSearchResultItem.lUIN;
    if ((paramQQAppInterface != null) && (aprg.V(paramQQAppInterface, String.valueOf(l3))))
    {
      aprg.H(paramActivity, null, String.valueOf(l3));
      return;
    }
    long l1 = 0L;
    Object localObject;
    if (paramQQAppInterface == null) {
      localObject = "";
    }
    try
    {
      long l2 = Long.parseLong((String)localObject);
      l1 = l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int j;
        localThrowable.printStackTrace();
        continue;
        if (paramSearchResultItem.bIsFriend == 1)
        {
          j = 1;
        }
        else if (paramBoolean)
        {
          j = 37;
          i = 3020;
        }
        else
        {
          j = 35;
          i = 3001;
          continue;
          if (paramSearchResultItem.bInContact == 1) {}
          for (i = 31;; i = 36)
          {
            localAllInOne = new ProfileActivity.AllInOne(paramSearchResultItem.strMobile, i);
            if (paramSearchResultItem.bInContact != 1) {
              break label390;
            }
            i = 3001;
            break;
          }
          paramQQAppInterface = paramQQAppInterface.a();
        }
      }
      ProfileActivity.a(paramActivity, localAllInOne, 100);
      return;
    }
    int i = 0;
    if (l3 != 0L) {
      if (l3 == l1)
      {
        j = 0;
        localObject = new ProfileActivity.AllInOne(String.valueOf(l3), j);
      }
    }
    label390:
    for (;;)
    {
      if ((l3 != 0L) && (i != 0) && (paramInt != 0) && (paramSearchResultItem.cs != null) && (paramSearchResultItem.cs.length > 0) && (paramQQAppInterface != null))
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
        if (paramQQAppInterface != null) {
          break label373;
        }
        paramQQAppInterface = null;
        if (paramQQAppInterface != null) {
          paramQQAppInterface.c(String.valueOf(l3), i, paramInt, paramSearchResultItem.cs);
        }
      }
      ((ProfileActivity.AllInOne)localObject).bJa = 98;
      ((ProfileActivity.AllInOne)localObject).nickname = paramSearchResultItem.strNick;
      ((ProfileActivity.AllInOne)localObject).cf = paramSearchResultItem.cr;
      ((ProfileActivity.AllInOne)localObject).bJb = i;
      ((ProfileActivity.AllInOne)localObject).subSourceId = paramInt;
      if (paramActivity.getIntent().getStringExtra("param_return_addr") != null)
      {
        paramSearchResultItem = ProfileActivity.a(paramActivity, (ProfileActivity.AllInOne)localObject);
        paramSearchResultItem.putExtra("param_return_addr", paramActivity.getIntent().getStringExtra("param_return_addr"));
        paramSearchResultItem.putExtra("AllInOne", (Parcelable)localObject);
        paramActivity.startActivity(paramSearchResultItem);
        return;
        localObject = paramQQAppInterface.getCurrentAccountUin();
        break;
      }
      ProfileActivity.AllInOne localAllInOne;
      label373:
      i = 0;
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(paramContext, AddFriendActivity.class);
    localIntent.putExtra("btroop", paramBoolean1);
    localIntent.putExtra("performAutoAction", paramBoolean2);
    if (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity)))
    {
      localIntent.addFlags(1073741824);
      localIntent.putExtra("needFinish", true);
    }
    if (paramString != null)
    {
      if (!paramBoolean1) {
        break label90;
      }
      localIntent.putExtra("troopuin", paramString);
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      label90:
      localIntent.putExtra("uin", paramString);
    }
  }
  
  private void b(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    bFC();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof ArrayList)))
    {
      paramString = (ArrayList)paramObject;
      if (paramString.size() == 1)
      {
        paramObject = ((yow)paramString.get(0)).sS;
        if ((paramObject != null) && (paramObject.size() == 1))
        {
          paramObject = (AccountSearchPb.record)paramObject.get(0);
          paramInt1 = ((yow)paramString.get(0)).resultType;
          paramString = String.valueOf(paramObject.code.get());
          if ((paramInt1 == 80000001) && (!TextUtils.isEmpty(paramString)) && (TextUtils.equals(this.aKE, paramString)))
          {
            paramString = paramObject.bytes_join_group_auth.get().toStringUtf8();
            apuh.a(this, TroopInfoActivity.a(String.valueOf(paramObject.code.get()), paramString, 105), 2);
            finish();
            overridePendingTransition(0, 0);
            return;
          }
        }
      }
    }
    if (!paramBoolean)
    {
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        zH(2131696275);
        return;
      }
      zH(2131693730);
      return;
    }
    zH(2131721442);
  }
  
  private void bFA()
  {
    this.aKE = this.K.getEditableText().toString();
    if (this.aKE.trim().equals("")) {
      zH(2131719285);
    }
    do
    {
      return;
      if (!aqiw.isNetSupport(this)) {
        break;
      }
      yC(2131719312);
      bFB();
    } while (this.e == null);
    this.e.hideSoftInputFromWindow(this.K.getWindowToken(), 0);
    return;
    QQToast.a(this, 2131696272, 0).show(getTitleBarHeight());
  }
  
  private void bFB()
  {
    if (hb(this.aKE))
    {
      this.jdField_a_of_type_Yob.a(this.aKE, 80000001, 0.0D, 0.0D, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AddFriendActivity", 2, "少于5位数字，直接显示找不到群号");
    }
    bFC();
    zH(2131721442);
  }
  
  private void bFC()
  {
    if ((this.u != null) && (this.u.isShowing())) {
      this.u.dismiss();
    }
  }
  
  private void bFz()
  {
    this.Tl = this.K.getEditableText().toString().trim();
    this.Tl = this.Tl.trim();
    if (this.Tl.equals("")) {
      zH(2131693142);
    }
    do
    {
      return;
      if (this.Tl.length() < 5)
      {
        zH(2131693272);
        return;
      }
      if (this.Tl.indexOf("@") != -1)
      {
        if (!this.Q.matcher(this.Tl).matches()) {
          uQ(acfp.m(2131702079));
        }
      }
      else
      {
        this.Tl = this.R.matcher(this.Tl).replaceAll("");
        if (this.Tl.length() < 5)
        {
          zH(2131693142);
          return;
        }
      }
      if (!aqiw.isNetSupport(this)) {
        break;
      }
      this.jdField_a_of_type_Yob.a(this.Tl, 80000000, 0.0D, 0.0D, 0);
      yC(2131693741);
    } while (this.e == null);
    this.e.hideSoftInputFromWindow(this.K.getWindowToken(), 0);
    return;
    QQToast.a(this, 2131696272, 0).show(getTitleBarHeight());
  }
  
  private static boolean hb(String paramString)
  {
    boolean bool = false;
    if (paramString != null) {
      bool = paramString.matches("^\\d{5,}$");
    }
    return bool;
  }
  
  private void initParams()
  {
    Intent localIntent = getIntent();
    this.Tl = localIntent.getStringExtra("uin");
    this.aKE = localIntent.getStringExtra("troopuin");
    this.aRc = localIntent.getBooleanExtra("btroop", false);
    this.aRd = localIntent.getBooleanExtra("performAutoAction", true);
    this.aRe = localIntent.getBooleanExtra("needFinish", false);
  }
  
  private void initUI()
  {
    Button localButton = (Button)findViewById(2131363982);
    TextView localTextView = (TextView)findViewById(2131380764);
    this.K = ((EditText)findViewById(2131366535));
    this.K.addTextChangedListener(this);
    this.BD = ((TextView)findViewById(2131380682));
    if (this.aRc)
    {
      setTitle(2131719297);
      localTextView.setText(2131719285);
      this.K.setFilters(new InputFilter[] { new InputFilter.LengthFilter(25) });
      localTextView.setVisibility(8);
      findViewById(2131377844).setVisibility(8);
      Object localObject1 = findViewById(2131362209);
      Object localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = findViewById(2131362215);
      localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).height = -1;
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (RelativeLayout.LayoutParams)this.BD.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      this.BD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (;;)
    {
      this.BD.setVisibility(4);
      localButton.setOnClickListener(this);
      if (TextUtils.isEmpty(this.Tl)) {
        break;
      }
      this.K.setText(this.Tl);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
      setTitle(2131719296);
      this.K.setHint(2131719283);
      localTextView.setText(2131719283);
    }
    if ((this.aRc) && (!TextUtils.isEmpty(this.aKE)))
    {
      this.K.setText(this.aKE);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      localTextView.requestFocus();
      return;
    }
    this.K.setText("");
    this.K.requestFocus();
  }
  
  private void yC(int paramInt)
  {
    if (this.u == null) {
      this.u = new arhz(this, getTitleBarHeight());
    }
    this.u.setMessage(paramInt);
    this.u.show();
  }
  
  void a(yow paramyow)
  {
    if ((paramyow == null) || (paramyow.sS == null) || (paramyow.sS.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList(paramyow.sS.size());
      paramyow = paramyow.sS.iterator();
      while (paramyow.hasNext())
      {
        AccountSearchPb.record localrecord = (AccountSearchPb.record)paramyow.next();
        if (localrecord != null) {
          localArrayList.add(new SearchResultItem(localrecord));
        }
      }
    } while (localArrayList.size() == 0);
    paramyow = new Intent(this, SearchFriendListActivity.class);
    paramyow.putParcelableArrayListExtra("param_search_result_item_list", localArrayList);
    paramyow.putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
    startActivity(paramyow);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.BD.setVisibility(4);
  }
  
  void bFy()
  {
    if ((!TextUtils.isEmpty(this.Tl)) && (this.aRd)) {
      bFz();
    }
    if ((this.aRc) && (!TextUtils.isEmpty(this.aKE)) && (this.aRd)) {
      bFA();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt2)
    {
    }
    do
    {
      return;
    } while (paramInt1 != 100);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    initParams();
    paramBundle = getActivity().getWindow();
    if ((!TextUtils.isEmpty(this.Tl)) || ((this.aRc) && (!TextUtils.isEmpty(this.aKE)))) {
      paramBundle.setSoftInputMode(2);
    }
    for (;;)
    {
      this.jdField_a_of_type_Yob = new yob(this.app);
      this.jdField_a_of_type_Yob.a(this.jdField_a_of_type_Yob$a);
      this.e = ((InputMethodManager)getSystemService("input_method"));
      super.setContentView(View.inflate(this, 2131558536, null));
      setContentBackgroundResource(2130838900);
      initUI();
      return true;
      paramBundle.setSoftInputMode(4);
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendActivity", 2, "onDestroy");
    }
    this.jdField_a_of_type_Yob.destory();
    this.jdField_a_of_type_Yob = null;
    super.doOnDestroy();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.aRf))
    {
      this.aRf = true;
      this.handler.sendEmptyMessage(1);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.e != null)
    {
      this.e.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
      this.e = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      bFy();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363982)
    {
      this.BD.setVisibility(4);
      if (!isFinishing())
      {
        if (this.aRc) {
          break label44;
        }
        bFz();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label44:
      bFA();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public String setLastActivityName()
  {
    if ((this.centerView == null) || (this.centerView.getText() == null) || (this.centerView.getText().length() == 0) || (this.aRe)) {
      return getString(2131691039);
    }
    return this.centerView.getText().toString();
  }
  
  void uQ(String paramString)
  {
    runOnUiThread(new AddFriendActivity.3(this, paramString));
  }
  
  void zH(int paramInt)
  {
    runOnUiThread(new AddFriendActivity.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendActivity
 * JD-Core Version:    0.7.0.1
 */