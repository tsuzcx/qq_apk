package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.FunctionSearchFragment;

public class FunctionSearchActivity
  extends BaseSearchActivity
{
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, FunctionSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return FunctionSearchFragment.a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.cDg = true;
    super.doOnCreate(paramBundle);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.FunctionSearchActivity
 * JD-Core Version:    0.7.0.1
 */