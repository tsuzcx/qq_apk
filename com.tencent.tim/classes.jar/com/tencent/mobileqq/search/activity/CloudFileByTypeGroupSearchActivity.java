package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

public class CloudFileByTypeGroupSearchActivity
  extends CloudFileGroupSearchActivity
{
  public static void p(Activity paramActivity, String paramString, int paramInt)
  {
    dCG = paramInt;
    Intent localIntent = new Intent(paramActivity, CloudFileByTypeGroupSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    this.GQ.setVisibility(8);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    switch (dCG)
    {
    }
    for (;;)
    {
      return super.doOnCreate(paramBundle);
      this.cDh = true;
    }
  }
  
  protected void initView()
  {
    super.initView();
    if (this.GQ != null) {
      this.GQ.setVisibility(8);
    }
  }
  
  protected String vm()
  {
    switch (dCG)
    {
    default: 
      return "";
    case 28: 
      return "搜索文档";
    case 29: 
      return "搜索视频";
    }
    return "搜索图片";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.CloudFileByTypeGroupSearchActivity
 * JD-Core Version:    0.7.0.1
 */