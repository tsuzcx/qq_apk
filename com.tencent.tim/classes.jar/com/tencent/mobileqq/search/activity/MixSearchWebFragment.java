package com.tencent.mobileqq.search.activity;

import amli;
import amlj;
import amlk;
import amll;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import aqzl;
import arcd;
import arju;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;
import rpq;

public class MixSearchWebFragment
  extends WebViewFragment
  implements TextWatcher, TextView.OnEditorActionListener
{
  protected Button C;
  protected ImageView Dt;
  protected ImageButton as;
  public QuickPinyinEditText b;
  public String keyword;
  protected RelativeLayout lT;
  
  private void ao(Bundle paramBundle)
  {
    View localView;
    if ("1".equals(getIntent().getStringExtra("showloadingbar")))
    {
      this.jdField_a_of_type_Arcd.mProgressBarController.xW(true);
      if ((this.jdField_a_of_type_Aqzl.aK.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        Object localObject = BaseApplicationImpl.getApplication();
        this.jdField_a_of_type_Aqzl.aK.setVisibility(8);
        paramBundle = (ViewGroup)this.jdField_a_of_type_Aqzl.aK.getParent();
        localView = LayoutInflater.from((Context)localObject).inflate(2131561658, null);
        int i = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
        localObject = new RelativeLayout.LayoutParams(-1, (int)((Context)localObject).getResources().getDimension(2131299627));
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = i;
        paramBundle.addView(localView, (ViewGroup.LayoutParams)localObject);
        this.b = ((QuickPinyinEditText)localView.findViewById(2131366542));
        this.b.setOnEditorActionListener(this);
        this.b.addTextChangedListener(this);
        this.b.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
        this.b.dEb = 50;
        this.b.setImeOptions(3);
        this.b.setHint(getIntent().getStringExtra("placeholder"));
        this.keyword = getIntent().getStringExtra("searchword");
        this.as = ((ImageButton)localView.findViewById(2131368696));
        this.as.setOnClickListener(new amli(this));
        this.C = ((Button)localView.findViewById(2131363801));
        this.C.setText(2131721058);
        this.C.setOnClickListener(new amlj(this));
        if (!"1".equals(getIntent().getStringExtra("hiderightbtn"))) {
          break label503;
        }
        this.C.setVisibility(8);
        label325:
        this.Dt = ((ImageView)localView.findViewById(2131369671));
        if (!"1".equals(getIntent().getStringExtra("hideleftarrow"))) {
          break label514;
        }
        this.Dt.setVisibility(8);
      }
    }
    for (;;)
    {
      if ((this.C.getVisibility() == 8) && (this.Dt.getVisibility() == 8)) {
        this.C.setVisibility(0);
      }
      this.Dt.setOnClickListener(new amlk(this));
      this.b.getViewTreeObserver().addOnGlobalLayoutListener(new amll(this));
      if (!TextUtils.isEmpty(this.keyword))
      {
        if (this.keyword.length() > 50) {
          this.keyword = this.keyword.substring(0, 50);
        }
        this.b.setText(this.keyword);
      }
      this.lT = ((RelativeLayout)localView);
      dOe();
      return;
      this.jdField_a_of_type_Arcd.mProgressBarController.xW(false);
      break;
      label503:
      this.C.setVisibility(0);
      break label325;
      label514:
      this.Dt.setVisibility(0);
    }
  }
  
  private void dOe()
  {
    if (this.lT == null) {
      return;
    }
    this.lT.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851332));
    this.C.setTextColor(Color.parseColor("#777777"));
    this.C.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851335));
    this.b.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130851343));
    this.b.setCompoundDrawablesWithIntrinsicBounds(SkinEngine.getInstances().getDefaultThemeDrawable(2130851339), null, null, null);
    this.b.setPadding(rpq.dip2px(getActivity(), 10.0F), this.b.getPaddingTop(), this.b.getPaddingRight(), this.b.getPaddingBottom());
    this.b.setTextColor(-16777216);
    this.b.setHintTextColor(Color.parseColor("#a6a6a6"));
  }
  
  public void Ux(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 3)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramInt);
      getWebView().callJs("MixSearchBackClicked", new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("WebLog_WebViewFragment", 1, "callJsOnBackClicked, type = " + paramInt + ", e = " + localJSONException);
      }
    }
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    ao(paramBundle);
    return i;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(paramEditable)) {
      this.as.setVisibility(8);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("searchWord", paramEditable.toString());
        getWebView().callJs("MixSearchWordDidChange", new String[] { localJSONObject.toString() });
        return;
        this.as.setVisibility(0);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("WebLog_WebViewFragment", 1, "afterTextChanged, searchWord = " + paramEditable.toString() + ", e = " + localJSONException);
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void biT()
  {
    if (getWebView() != null) {
      Ux(2);
    }
    super.biT();
    if (!"1".equals(getIntent().getStringExtra("openanimtype"))) {
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void hm(String paramString1, String paramString2)
  {
    if (this.b != null)
    {
      this.b.setHint(paramString2);
      this.b.setText(paramString1);
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (this.b.getText() == null) {
        paramTextView = "";
      }
      for (;;)
      {
        JSONObject localJSONObject;
        if (this.b.getHint() == null)
        {
          paramKeyEvent = "";
          localJSONObject = new JSONObject();
        }
        try
        {
          localJSONObject.put("searchWord", paramTextView);
          localJSONObject.put("placeholder", paramKeyEvent);
          getWebView().callJs("MixSearchButtonClicked", new String[] { localJSONObject.toString() });
          paramTextView = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
          if (paramTextView != null) {
            paramTextView.hideSoftInputFromWindow(this.b.getWindowToken(), 0);
          }
          this.b.clearFocus();
          return true;
          paramTextView = this.b.getText().toString().trim();
          continue;
          paramKeyEvent = this.b.getHint().toString().trim();
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("WebLog_WebViewFragment", 1, "onEditorAction, searchWord = " + paramTextView + ", placeholder = " + paramKeyEvent + ", e = " + localJSONException);
          }
        }
      }
    }
    return false;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    dOe();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MixSearchWebFragment
 * JD-Core Version:    0.7.0.1
 */