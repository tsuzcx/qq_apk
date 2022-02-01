package com.tencent.mobileqq.ark.setting;

import adtp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.FormSimpleItem;
import wja;

public class ArkAppListActivity
  extends IphoneTitleBarActivity
{
  private ViewGroup bD;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int i = 0;
    super.doOnCreate(paramBundle);
    paramBundle = new LinearLayout(this);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.setBackgroundResource(2130838901);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle.setOrientation(1);
    paramBundle.setPadding(0, wja.dp2px(20.0F, getResources()), 0, 0);
    this.bD = paramBundle;
    paramBundle = getIntent().getStringArrayExtra("intent_extra_authority_app_list");
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      int j = paramBundle.length;
      while (i < j)
      {
        localLayoutParams = paramBundle[i];
        if (!TextUtils.isEmpty(localLayoutParams))
        {
          FormSimpleItem localFormSimpleItem = new FormSimpleItem(this);
          localFormSimpleItem.setLeftText(localLayoutParams);
          localFormSimpleItem.showArrow(true);
          localFormSimpleItem.setOnClickListener(new adtp(this, localLayoutParams));
          this.bD.addView(localFormSimpleItem);
        }
        i += 1;
      }
    }
    super.setContentView(this.bD);
    super.setTitle(2131690466);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.setting.ArkAppListActivity
 * JD-Core Version:    0.7.0.1
 */