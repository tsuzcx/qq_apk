package com.tencent.mobileqq.search.activity;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import anot;
import apuh;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;

public class ContactSearchActivity
  extends BaseSearchActivity
{
  private boolean cDi;
  private int dCH;
  private int dCI;
  private int fromType;
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ContactSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    localIntent.putExtra("ContactCombineType", paramInt3);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ContactSearchActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    localIntent.putExtra("isApproximate", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  protected BaseSearchFragment a()
  {
    return ContactSearchFragment.a(this.fromType, this.dCH, this.cDi, this.dCI);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1300) && (-1 == paramInt2) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("roomId");
      if (paramIntent != null)
      {
        apuh.f(this, paramIntent, true);
        anot.a(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.cDg = true;
    this.fromType = getIntent().getIntExtra("fromType", -1);
    this.dCH = getIntent().getIntExtra("contactSearchSource", 197437);
    this.cDi = getIntent().getBooleanExtra("isApproximate", false);
    this.dCI = getIntent().getIntExtra("ContactCombineType", 0);
    super.doOnCreate(paramBundle);
    return true;
  }
  
  protected String vm()
  {
    switch (this.dCH)
    {
    default: 
      return acfp.m(2131704461);
    }
    return acfp.m(2131704444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchActivity
 * JD-Core Version:    0.7.0.1
 */