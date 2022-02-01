package com.tencent.mobileqq.ark.setting;

import adnq.c;
import adtq;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class ArkAuthorityInfoActivity
  extends IphoneTitleBarActivity
{
  private static final String[] et = { "ark_authority_api_user_info", "ark_authority_api_location", "ark_authority_api_relationship", "ark_authority_api_login", "ark_authority_api_phone_number" };
  private String mAppName;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558745);
    super.setTitle(2131690466);
    this.mAppName = getIntent().getStringExtra("intent_extra_authority_app_name");
    ((TextView)super.findViewById(2131362957)).setText(getString(2131690478, new Object[] { this.mAppName }));
    int i = 0;
    while (i < et.length)
    {
      paramBundle = (FormSwitchItem)super.findViewById(new int[] { 2131362951, 2131362947, 2131362950, 2131362948, 2131362949 }[i]);
      int j = adnq.c.i(this.mAppName, et[i], this.app.getCurrentAccountUin());
      if (j == 0)
      {
        paramBundle.setVisibility(8);
        i += 1;
      }
      else
      {
        paramBundle.setVisibility(0);
        if (1 == j) {}
        for (boolean bool = true;; bool = false)
        {
          paramBundle.setChecked(bool);
          paramBundle.setOnCheckedChangeListener(new adtq(this, i));
          break;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.setting.ArkAuthorityInfoActivity
 * JD-Core Version:    0.7.0.1
 */