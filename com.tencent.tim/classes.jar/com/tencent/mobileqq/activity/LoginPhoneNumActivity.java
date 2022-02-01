package com.tencent.mobileqq.activity;

import akwp;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import aqiw;
import aqje;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import vgr;
import vgs;
import vgt;
import vgu;
import vgv;
import vgy;

public class LoginPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private TextView Eo;
  private TextView Ep;
  private ConfigClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText;
  private vgy jdField_a_of_type_Vgy;
  private String aOa;
  private boolean aYs;
  MqqHandler b = new vgr(this);
  WtloginObserver c = new vgv(this);
  private Button dm;
  private ImageView qE;
  
  private boolean Qd()
  {
    boolean bool = true;
    this.phoneNum = hh(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString());
    if (this.phoneNum == null)
    {
      J(2131717079, 1);
      bool = false;
    }
    return bool;
  }
  
  private void bRq()
  {
    if (!Qd()) {}
    do
    {
      return;
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        J(2131693404, 0);
        return;
      }
      Bv(2131717125);
    } while (akwp.a().a(this.app, this.phoneNum, this.countryCode, this.c) == 0);
    gV();
    cq(getString(2131717096), 1);
  }
  
  private String hh(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.countryCode)) {
          break label170;
        }
        if ("853".equals(this.countryCode))
        {
          break label170;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.countryCode)) {
            i = 0;
          }
        }
        if (!"86".equals(this.countryCode)) {
          break label162;
        }
        j = paramString.length();
        if (j == 11) {
          break label162;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label145;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.countryCode);
      if (bool)
      {
        i = 9;
        continue;
        label145:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label162:
        continue;
        label170:
        i = 6;
      }
    }
  }
  
  private void initViews()
  {
    tK(2131721669);
    bVd();
    xW(false);
    this.Eo = ((TextView)findViewById(2131381073));
    this.Eo.setOnClickListener(this);
    this.qE = ((ImageView)findViewById(2131362985));
    this.qE.setOnClickListener(this);
    this.Ep = ((TextView)findViewById(2131381072));
    this.countryCode = aqje.bg(this);
    this.Ep.setText("+" + this.countryCode);
    if ("86".equals(this.countryCode)) {
      this.Eo.setText(getString(2131717023));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText = ((ConfigClearableEditText)findViewById(2131372579));
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.addTextChangedListener(this);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setCustomSelectionActionModeCallback(new vgt(this));
    }
    for (;;)
    {
      this.dm = ((Button)findViewById(2131363918));
      this.dm.setOnClickListener(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setOnCreateContextMenuListener(new vgu(this));
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (hh(paramEditable.toString()) != null)
    {
      this.dm.setEnabled(true);
      return;
    }
    this.dm.setEnabled(false);
  }
  
  public void bRp()
  {
    boolean bool = getIntent().getBooleanExtra("login_from_account_change", false);
    Intent localIntent = new Intent(this, LoginVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.phoneNum);
    localIntent.putExtra("key", this.countryCode);
    localIntent.putExtra("isSubaccount", this.aYs);
    localIntent.putExtra("fromWhere", this.aOa);
    localIntent.putExtra("login_from_account_change", bool);
    if (bool)
    {
      startActivityForResult(localIntent, 20140319);
      return;
    }
    startActivity(localIntent);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561415);
    paramBundle = getIntent();
    if (paramBundle != null) {
      this.aYs = paramBundle.getBooleanExtra("isSubaccount", false);
    }
    if (this.app != null) {
      this.app.setHandler(getClass(), this.b);
    }
    initViews();
    this.jdField_a_of_type_Vgy = new vgy();
    paramBundle = new vgs(this);
    this.jdField_a_of_type_Vgy.a(paramBundle);
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.Eo.setText(str);
      this.countryCode = paramIntent.getStringExtra("k_code");
      this.Ep.setText("+" + this.countryCode);
      try
      {
        if (hh(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString()) != null)
        {
          this.dm.setEnabled(true);
          return;
        }
        this.dm.setEnabled(false);
        return;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if ((paramInt1 == 20140319) && (paramInt2 == -1)) {
      finish();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      startActivityForResult(new Intent(this, NewStyleCountryActivity.class), 1);
      continue;
      bRq();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    gV();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */