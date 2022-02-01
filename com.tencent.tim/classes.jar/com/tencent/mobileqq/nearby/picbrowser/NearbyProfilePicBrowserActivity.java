package com.tencent.mobileqq.nearby.picbrowser;

import akbk;
import akbm;
import akbt;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import sxg;
import sxi;
import sxm;
import sxn;
import sxz;

public class NearbyProfilePicBrowserActivity
  extends PicBrowserActivity
{
  boolean crl = false;
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.crl = getIntent().getBooleanExtra("intent_param_show_del_pic_and_set_head", false);
    if (this.crl) {}
    for (this.b = new a();; this.b = new akbk(this)) {
      return super.doOnCreate(paramBundle);
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  class a
    extends sxz
  {
    a() {}
    
    public sxg a(Activity paramActivity, sxm paramsxm)
    {
      return super.a(paramActivity, paramsxm);
    }
    
    public sxi a(Activity paramActivity, sxm paramsxm)
    {
      return new akbm((PicBrowserActivity)paramActivity, paramsxm);
    }
    
    public sxm a(Activity paramActivity)
    {
      paramActivity = new akbt(NearbyProfilePicBrowserActivity.this, NearbyProfilePicBrowserActivity.this.mPicInfos);
      paramActivity.setSelectedIndex(NearbyProfilePicBrowserActivity.this.mIndex);
      return paramActivity;
    }
    
    public sxn a(Activity paramActivity, sxm paramsxm)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity
 * JD-Core Version:    0.7.0.1
 */