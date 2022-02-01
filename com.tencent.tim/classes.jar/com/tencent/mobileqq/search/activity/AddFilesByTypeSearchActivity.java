package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;

public class AddFilesByTypeSearchActivity
  extends AddFilesSearchActivity
{
  public static void a(Activity paramActivity, String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    mFromType = paramInt;
    Intent localIntent = new Intent(paramActivity, AddFilesByTypeSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt);
    localIntent.putExtra("dirKey", paramArrayOfByte);
    paramActivity.startActivity(localIntent);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    if (this.GQ != null) {
      this.GQ.setVisibility(8);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    switch (mFromType)
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
    switch (mFromType)
    {
    default: 
      return "";
    case 37: 
      return "搜索腾讯文档";
    case 38: 
      return "搜索文档";
    case 39: 
      return "搜索视频";
    case 40: 
      return "搜索图片";
    }
    return "搜索压缩包";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.AddFilesByTypeSearchActivity
 * JD-Core Version:    0.7.0.1
 */