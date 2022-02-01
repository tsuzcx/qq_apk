package com.tencent.tim.filemanager.activity;

import aghw;
import agkh;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqiw;
import atpg;
import atsn;
import auds;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VerifyPwdView
  extends LinearLayout
  implements View.OnClickListener
{
  private Button O;
  private View P;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity;
  private a jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView$a;
  private TextView aZ;
  private QQAppInterface app;
  private atsn d = new atpg(this);
  private ProgressBar mProgressBar;
  View mView = null;
  
  public VerifyPwdView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity = ((BaseFileAssistantActivity)paramContext);
    this.app = this.jdField_a_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.app;
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
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView$a != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView$a.onSuccess();
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.getSystemService("input_method");
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
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView$a = parama;
    this.mView = ((LayoutInflater)this.jdField_a_of_type_ComTencentTimFilemanagerActivityBaseFileAssistantActivity.getSystemService("layout_inflater")).inflate(2131561071, null).findViewById(2131381504);
    return this.mView;
  }
  
  public void finish()
  {
    if (this.d != null)
    {
      this.app.a().deleteObserver(this.d);
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityVerifyPwdView$a = null;
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
    this.app.a().addObserver(this.d);
    if (this.app.a().hasQueriedVerifyPassword() == true)
    {
      this.app.a().dfZ();
      return;
    }
    if (aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      dfA();
      this.app.a().dfZ();
      return;
    }
    auds.JD(BaseApplicationImpl.getContext().getString(2131696270));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.activity.VerifyPwdView
 * JD-Core Version:    0.7.0.1
 */