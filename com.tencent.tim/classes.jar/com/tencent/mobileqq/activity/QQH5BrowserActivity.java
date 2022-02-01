package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqzl;
import arcd;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import jll;

public class QQH5BrowserActivity
  extends QQBrowserActivity
{
  public QQH5BrowserActivity()
  {
    this.s = QQH5BrowserFragment.class;
  }
  
  public static class QQH5BrowserFragment
    extends WebViewFragment
  {
    private void ao(Bundle paramBundle)
    {
      super.getActivity().getWindow().setFlags(1024, 1024);
      this.j.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_Arcd.mLoadingProgressBar.setVisibility(8);
      if ((this.jdField_a_of_type_Aqzl.aK.getLayoutParams() instanceof RelativeLayout.LayoutParams))
      {
        paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Aqzl.aK.getLayoutParams();
        paramBundle.height = ((int)jll.dp2px(BaseApplicationImpl.getApplication(), 60.0F));
        this.jdField_a_of_type_Aqzl.aK.setLayoutParams(paramBundle);
      }
      this.jdField_a_of_type_Aqzl.aK.setPadding(0, 0, 0, 0);
      int i = (int)jll.dp2px(BaseApplicationImpl.getApplication(), 12.0F);
      paramBundle = new RelativeLayout.LayoutParams(-2, -2);
      paramBundle.width = ((int)jll.dp2px(BaseApplicationImpl.getApplication(), 15.0F));
      paramBundle.height = ((int)jll.dp2px(BaseApplicationImpl.getApplication(), 15.0F));
      this.jdField_a_of_type_Aqzl.leftView.setLayoutParams(paramBundle);
      this.jdField_a_of_type_Aqzl.leftView.setBackgroundResource(2130848662);
      this.jdField_a_of_type_Aqzl.leftView.setText("");
      paramBundle = this.jdField_a_of_type_Aqzl.leftView.getParent();
      if ((paramBundle instanceof RelativeLayout))
      {
        ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
        paramBundle.requestLayout();
      }
      paramBundle = super.getActivity().findViewById(2131377501);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(9);
      localLayoutParams.setMargins(i, i, 0, 0);
      paramBundle.setLayoutParams(localLayoutParams);
      paramBundle = this.jdField_a_of_type_Aqzl.rightViewImg.getLayoutParams();
      paramBundle.width = ((int)jll.dp2px(BaseApplicationImpl.getApplication(), 22.0F));
      paramBundle.height = ((int)jll.dp2px(BaseApplicationImpl.getApplication(), 15.0F));
      this.jdField_a_of_type_Aqzl.rightViewImg.setLayoutParams(paramBundle);
      this.jdField_a_of_type_Aqzl.rightViewImg.setImageResource(2130849292);
      paramBundle = this.jdField_a_of_type_Aqzl.rightViewImg.getParent();
      if ((paramBundle instanceof RelativeLayout))
      {
        ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
        paramBundle.requestLayout();
      }
      paramBundle = super.getActivity().findViewById(2131377502);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(11);
      localLayoutParams.setMargins(0, i, i, 0);
      paramBundle.setLayoutParams(localLayoutParams);
    }
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      ao(paramBundle);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQH5BrowserActivity
 * JD-Core Version:    0.7.0.1
 */