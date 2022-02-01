package com.tencent.mobileqq.filemanager.activity;

import agdo;
import aghq;
import aghw;
import agkh;
import ahao;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button O;
  private View P;
  private aghq jdField_a_of_type_Aghq = new agdo(this);
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private a jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$a;
  private TextView aZ;
  private QQAppInterface app;
  private ImageView gm;
  private ProgressBar mProgressBar;
  View mView = null;
  
  public VerifyPwdView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.app = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app;
  }
  
  private void dfA()
  {
    this.P.setVisibility(8);
    this.mProgressBar.setVisibility(0);
  }
  
  private void dfB()
  {
    this.mProgressBar.setVisibility(8);
  }
  
  private void gb()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$a.onSuccess();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }
  }
  
  private void showVerifyView()
  {
    this.P.setVisibility(0);
    this.mProgressBar.setVisibility(8);
  }
  
  public View a(ViewGroup paramViewGroup, a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$a = parama;
    this.mView = ((LayoutInflater)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSystemService("layout_inflater")).inflate(2131561071, null).findViewById(2131381504);
    return this.mView;
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Aghq != null)
    {
      this.app.a().deleteObserver(this.jdField_a_of_type_Aghq);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView$a = null;
    }
  }
  
  public void ga()
  {
    View localView = this.mView.findViewById(2131377980);
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.P = this.mView.findViewById(2131381507);
    this.mProgressBar = ((ProgressBar)this.mView.findViewById(2131377037));
    this.aZ = ((TextView)this.mView.findViewById(2131373866));
    this.O = ((Button)this.mView.findViewById(2131381505));
    this.O.setOnClickListener(this);
    this.gm = ((ImageView)this.mView.findViewById(2131382211));
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      this.gm.setImageResource(2130845253);
    }
    for (;;)
    {
      this.app.a().addObserver(this.jdField_a_of_type_Aghq);
      if (this.app.a().hasQueriedVerifyPassword() != true) {
        break;
      }
      this.app.a().dfZ();
      return;
      this.gm.setImageResource(2130845252);
    }
    if (aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      dfA();
      this.app.a().dfZ();
      return;
    }
    ahao.JD(BaseApplicationImpl.getContext().getString(2131696270));
  }
  
  public void onClick(View paramView)
  {
    String str = this.aZ.getText().toString();
    if ((str == null) || (str.equals(""))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.app.a().IB(str);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.VerifyPwdView
 * JD-Core Version:    0.7.0.1
 */