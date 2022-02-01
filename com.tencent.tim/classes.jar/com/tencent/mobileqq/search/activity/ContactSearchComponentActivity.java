package com.tencent.mobileqq.search.activity;

import acbn;
import amlh;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ContactSearchComponentActivity
  extends ContactSearchActivity
{
  private static long lastLaunchTime;
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (l - lastLaunchTime < 1500L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchComponentActivity", 2, "ContactSearchComponentActivity launch failed! Too frequently.");
      }
      return;
    }
    lastLaunchTime = l;
    Intent localIntent = new Intent(paramActivity, ContactSearchComponentActivity.class);
    localIntent.putExtra("keyword", paramString);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    if (paramLong > 0L) {
      localIntent.putExtra("contactSearchResultFilterType", paramLong);
    }
    paramActivity.startActivityForResult(localIntent, paramInt3);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    if (l - lastLaunchTime < 1500L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchComponentActivity", 2, "ContactSearchComponentActivity launch failed! Too frequently.");
      }
      return;
    }
    lastLaunchTime = l;
    Intent localIntent = new Intent(paramActivity, ContactSearchComponentActivity.class);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("fromType", paramInt1);
    localIntent.putExtra("contactSearchSource", paramInt2);
    localIntent.putExtra("specifiedTroopUin", paramString2);
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramActivity.startActivityForResult(localIntent, paramInt3);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramActivity, paramString, paramInt1, paramInt2, paramInt3, -1L);
  }
  
  protected BaseSearchFragment a()
  {
    int i = getIntent().getIntExtra("fromType", -1);
    int j = getIntent().getIntExtra("contactSearchSource", 197437);
    String str = getIntent().getStringExtra("specifiedTroopUin");
    ArrayList localArrayList = new ArrayList();
    if ((i == 7) || (i == 6) || (i == 23))
    {
      localArrayList.add(acbn.blz);
      return ContactSearchFragment.a(i, j, str, localArrayList, null, false, 0, getIntent().getLongExtra("contactSearchResultFilterType", -1L));
    }
    return super.a();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.Dt.setVisibility(8);
    findViewById(2131377814).setOnTouchListener(new amlh(this));
    return true;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ContactSearchComponentActivity
 * JD-Core Version:    0.7.0.1
 */