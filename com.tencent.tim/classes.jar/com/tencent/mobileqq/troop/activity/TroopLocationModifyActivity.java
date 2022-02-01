package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.widget.QQToast;

public class TroopLocationModifyActivity
  extends TroopCreateMapViewSupportActivity
{
  Boolean aH = Boolean.valueOf(true);
  long troopUin = 0L;
  
  public static void g(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void h(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, TroopLocationModifyActivity.class);
    localIntent.putExtra("url", "https://admin.qun.qq.com/mcreatev3/location.html?_bid=206&from=edit&_wv=2097152");
    localIntent.putExtra("saveDirect", false);
    localIntent.putExtra("troopUin", paramString1);
    localIntent.putExtra("troopLocation", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    int i = paramIntent.getIntExtra("errCode", -1);
    boolean bool = paramIntent.getBooleanExtra("isClear", false);
    String str = paramIntent.getStringExtra("location");
    int j = paramIntent.getIntExtra("lat", 0);
    int k = paramIntent.getIntExtra("lon", 0);
    if (i == 0)
    {
      if (bool) {
        QQToast.a(this, 2131721479, 0).show(getTitleBarHeight());
      }
      for (;;)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("location", str);
        localIntent.putExtra("lat", j);
        localIntent.putExtra("lon", k);
        setResult(-1, localIntent);
        finish();
        break;
        QQToast.a(this, 2131721484, 0).show(getTitleBarHeight());
      }
    }
    if (i == 1002) {
      str = getString(2131721492);
    }
    for (;;)
    {
      QQToast.a(this, str, 0).show(getTitleBarHeight());
      break;
      if (bool) {
        str = getString(2131721478);
      } else {
        str = getString(2131721483);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getExtras();
    String str = paramBundle.getString("troopUin");
    this.aH = Boolean.valueOf(paramBundle.getBoolean("saveDirect", true));
    this.troopUin = Long.parseLong(str);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopLocationModifyActivity
 * JD-Core Version:    0.7.0.1
 */