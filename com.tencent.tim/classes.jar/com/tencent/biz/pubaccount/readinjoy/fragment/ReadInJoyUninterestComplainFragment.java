package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import jzk;
import kku.a;
import kne;
import kxm;
import mkt;
import mqq.os.MqqHandler;

public class ReadInJoyUninterestComplainFragment
  extends IphoneTitleBarFragment
  implements TextWatcher, View.OnClickListener
{
  private EditText Q;
  private EditText R;
  private Parcelable b;
  private Button bQ;
  private int mFromType;
  private TextView po;
  
  private void aC()
  {
    this.vg.changeBg(true);
    if ((this.leftView == null) || (ThemeUtil.isInNightMode(kxm.getAppRuntime()))) {
      View.inflate(getActivity(), 2131560438, this.titleRoot);
    }
  }
  
  private void bC(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(jzk.Vj, paramString2);
    localBundle.putString(jzk.Vk, paramString1);
    switch (this.mFromType)
    {
    default: 
      return;
    case 1: 
      paramString1 = (AdvertisementInfo)this.b;
      if (kxm.j(paramString1)) {}
      for (int i = jzk.aFB;; i = jzk.aFw)
      {
        jzk.a(new kku.a().a(getActivity()).a(jzk.aEL).b(i).a(paramString1).a(localBundle).a());
        return;
      }
    case 2: 
      paramString1 = (VideoAdInfo)this.b;
      jzk.a(new kku.a().a(getActivity()).a(jzk.aEL).b(jzk.aFA).a(jzk.a(paramString1)).a(paramString1).a(localBundle).a());
      return;
    }
    paramString1 = (AdData)this.b;
    jzk.a(new kku.a().a(getActivity()).a(jzk.aEL).b(jzk.aFv).a(kne.a(paramString1)).a(localBundle).a());
  }
  
  private void initData()
  {
    this.mFromType = getArguments().getInt("key_from_type", 0);
    this.b = getArguments().getParcelable("key_ad_info");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUninterestComplainFragment", 2, "initData fromType:" + this.mFromType + ", adinfo:" + this.b);
    }
    switch (this.mFromType)
    {
    default: 
      onBackEvent();
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.b instanceof AdvertisementInfo));
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not AdvertisementInfo");
        }
        onBackEvent();
        return;
      } while ((this.b instanceof VideoAdInfo));
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not VideoAdInfo");
      }
      onBackEvent();
      return;
    } while ((this.b instanceof AdData));
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyUninterestComplainFragment", 2, "adinfo is not AdData");
    }
    onBackEvent();
  }
  
  private void initViews()
  {
    this.Q = ((EditText)this.mContentView.findViewById(2131365120));
    this.Q.addTextChangedListener(this);
    this.po = ((TextView)this.mContentView.findViewById(2131365468));
    this.R = ((EditText)this.mContentView.findViewById(2131373057));
    this.bQ = ((Button)this.mContentView.findViewById(2131378949));
    this.bQ.setOnClickListener(this);
  }
  
  private void setResult()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_ad_info", this.b);
    getActivity().setResult(-1, localIntent);
  }
  
  private void showKeyboard()
  {
    View localView = getActivity().getCurrentFocus();
    if (((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(localView, 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUninterestComplainFragment", 2, "showKeyboard success");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ReadInJoyUninterestComplainFragment", 2, "showKeyboard fail");
  }
  
  public void aLz()
  {
    View localView = getActivity().getCurrentFocus();
    if (localView != null) {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    this.po.setText(String.valueOf(getResources().getInteger(2131427373) - paramEditable.length()));
    if (paramEditable.trim().length() > 0)
    {
      this.bQ.setEnabled(true);
      return;
    }
    this.bQ.setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    aC();
    initViews();
    initData();
  }
  
  public int getContentLayoutId()
  {
    return 2131560501;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(1);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aLz();
      String str1 = this.Q.getText().toString().trim();
      String str2 = this.R.getText().toString().trim();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUninterestComplainFragment", 2, "onSubmitClick complaints:" + str1);
      }
      bC(str1, str2);
      setResult();
      onBackEvent();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    mkt.a(this);
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyUninterestComplainFragment.1(this), 300L);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyUninterestComplainFragment
 * JD-Core Version:    0.7.0.1
 */