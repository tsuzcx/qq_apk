package com.tencent.mobileqq.activity.contact.addcontact;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import obt;
import yop;
import yoq;

public class SearchContactsActivity
  extends SearchBaseActivity
{
  private final MessageQueue.IdleHandler g = new a(this);
  
  private void yV(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("//gettbs")))
    {
      String str4 = WebAccelerateHelper.getInstance().getTBSDpcParam();
      String str2 = "";
      String str3 = "";
      String str1 = str3;
      paramString = str2;
      if (!TextUtils.isEmpty(str4))
      {
        str1 = str3;
        paramString = str2;
        if (str4.length() > 2)
        {
          paramString = String.valueOf(str4.charAt(0));
          str1 = String.valueOf(str4.charAt(2));
        }
      }
      paramString = String.format("tbs_download:%s\ntbs_enable:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d", new Object[] { paramString, str1, Integer.valueOf(QbSdk.getTbsVersion(this)), Integer.valueOf(WebView.getTbsSDKVersion(this)) });
      QQToast.a(getActivity().getApplicationContext(), paramString, 0).show(getTitleBarHeight());
    }
  }
  
  protected SearchBaseFragment a()
  {
    return SearchContactsFragment.a(this.fromType);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Looper.myQueue().removeIdleHandler(this.g);
  }
  
  public void finish()
  {
    super.finish();
    if (!TextUtils.isEmpty(getIntent().getStringExtra("start_search_key"))) {
      return;
    }
    overridePendingTransition(0, 0);
  }
  
  protected void initViews()
  {
    super.initViews();
    this.uo.setVisibility(8);
    String str1 = getIntent().getStringExtra("start_search_key");
    boolean bool = TextUtils.isEmpty(str1);
    if (!bool)
    {
      if (this.fromType == 12)
      {
        this.aN.setHint(acfp.m(2131714095) + obt.a(this.app, getApplicationContext()) + acfp.m(2131714094));
        this.aN.setText(str1);
        this.aN.setSelection(this.aN.getText().length());
        this.ap.setVisibility(0);
      }
    }
    else
    {
      if (this.mFrom == 1) {
        this.aN.setHint(acfp.m(2131714102));
      }
      this.aN.addTextChangedListener(new yop(this, bool));
      String str2 = getResources().getString(2131721058);
      this.eg.setText(str2);
      this.eg.setOnClickListener(new yoq(this));
      if (AppSetting.enableTalkBack)
      {
        this.eg.setContentDescription(str2);
        if (this.fromType != 12) {
          break label266;
        }
        this.aN.setContentDescription(acfp.m(2131714104));
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(str1)) || (getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false))) {
        break label282;
      }
      return;
      this.aN.setHint(acfp.m(2131714101));
      break;
      label266:
      this.aN.setContentDescription(acfp.m(2131714100));
    }
    label282:
    Looper.myQueue().addIdleHandler(this.g);
  }
  
  static final class a
    implements MessageQueue.IdleHandler
  {
    final SearchContactsActivity b;
    
    public a(SearchContactsActivity paramSearchContactsActivity)
    {
      this.b = paramSearchContactsActivity;
    }
    
    public boolean queueIdle()
    {
      this.b.aN.requestFocus();
      ((InputMethodManager)this.b.getSystemService("input_method")).showSoftInput(this.b.aN, 0);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity
 * JD-Core Version:    0.7.0.1
 */