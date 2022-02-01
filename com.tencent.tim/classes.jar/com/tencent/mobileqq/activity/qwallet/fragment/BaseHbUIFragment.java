package com.tencent.mobileqq.activity.qwallet.fragment;

import aaam;
import aabk;
import aabw;
import aabx;
import acfp;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import avor;
import avox;
import avox.a;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.text.DecimalFormat;
import java.util.List;

public abstract class BaseHbUIFragment
  extends BaseHbFragment
{
  protected avox.a a = new avox.a();
  protected EditText aV;
  public EditText aW;
  protected Button cU;
  private DecimalFormat f = new DecimalFormat("0.00");
  protected TextWatcher mTextWatcher = new aaam(this);
  protected EditText numTxt;
  public View view;
  
  public boolean Wa()
  {
    String str = this.numTxt.getText().toString();
    float f1 = getAmount();
    if ((avor.c(str, 0) <= 0) || (f1 <= 0.0F))
    {
      this.cU.setEnabled(false);
      this.cU.setText(getString(2131699008));
      return false;
    }
    this.cU.setEnabled(true);
    this.cU.setText(String.format(acfp.m(2131703105), new Object[] { this.f.format(f1) }));
    return true;
  }
  
  protected boolean Wb()
  {
    if (avor.qH()) {
      return false;
    }
    if (avor.h(this.aV.getText().toString()) <= 0.0F)
    {
      QLog.d("BaseHbUIFragment", 2, "amount error, no input!");
      return false;
    }
    return true;
  }
  
  protected void ao(Bundle paramBundle)
  {
    avox.a(paramBundle, this.a);
    this.numTxt = ((EditText)this.view.findViewById(2131372567));
    this.numTxt.addTextChangedListener(new aabx(this.numTxt));
    this.aV = ((EditText)this.view.findViewById(2131362698));
    this.aV.addTextChangedListener(this.mTextWatcher);
    this.aV.addTextChangedListener(new aabw(this.aV));
    this.cU = ((Button)this.view.findViewById(2131365219));
    this.aW = ((EditText)this.view.findViewById(2131371244));
    if (QLog.isColorLevel()) {
      QLog.i("BaseHbUIFragment", 2, "bundleInfo: " + this.a);
    }
  }
  
  protected void cth()
  {
    QLog.i("BaseHbUIFragment", 2, "recv_type: " + this.a.recv_type);
    if (avox.LH.contains(this.a.recv_type))
    {
      this.numTxt.setText("1");
      ((View)this.numTxt.getParent()).setVisibility(8);
      return;
    }
    if (!TextUtils.isEmpty(this.a.people_num)) {
      this.numTxt.setHint(acfp.m(2131703104) + this.a.people_num + acfp.m(2131703106));
    }
    this.numTxt.addTextChangedListener(this.mTextWatcher);
  }
  
  protected float getAmount()
  {
    return avor.h(this.aV.getText().toString());
  }
  
  public abstract int getLayout();
  
  protected void initData()
  {
    this.aW.setHint(aabk.a(this.channel, this.a, this.mActivity.a(), qf()));
    cth();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    QLog.i("BaseHbUIFragment", 2, "oncreate view enter...");
    this.view = paramLayoutInflater.inflate(getLayout(), null);
    ao(getArguments());
    initData();
    paramLayoutInflater = this.view;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  protected abstract String qf();
  
  protected String qg()
  {
    return aabk.c(this.aW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.BaseHbUIFragment
 * JD-Core Version:    0.7.0.1
 */