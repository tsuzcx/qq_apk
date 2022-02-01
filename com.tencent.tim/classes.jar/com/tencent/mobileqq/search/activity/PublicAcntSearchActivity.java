package com.tencent.mobileqq.search.activity;

import acfp;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment;
import obt;

public class PublicAcntSearchActivity
  extends BaseSearchActivity
{
  static int fromType = -1;
  
  public static void v(Context paramContext, String paramString, int paramInt)
  {
    fromType = paramInt;
    Intent localIntent = new Intent(paramContext, PublicAcntSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return PublicAcntSearchFragment.a(fromType);
  }
  
  protected String vm()
  {
    if (fromType == 12) {
      return acfp.m(2131710204) + obt.a(this.app, getApplicationContext());
    }
    return acfp.m(2131710235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.PublicAcntSearchActivity
 * JD-Core Version:    0.7.0.1
 */