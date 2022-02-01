package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.Window;
import java.util.List;

public class ForwardRecentTranslucentActivity
  extends ForwardRecentActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.ZO = getIntent().getIntExtra("key_req", -1);
    if (bGT == this.ZO)
    {
      getWindow().addFlags(24);
      ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("PARAM_ActivityResultReceiver");
      if (localResultReceiver != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_req", ForwardRecentActivity.bGT);
        localBundle.putParcelable("receiver", new ForwardRecentTranslucentActivity.1(this, new Handler(Looper.getMainLooper())));
        localResultReceiver.send(100, localBundle);
      }
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void requestWindowFeature(Intent paramIntent) {}
  
  protected boolean v(Bundle paramBundle)
  {
    boolean bool = super.v(paramBundle);
    if ((bGT == this.ZO) && ((this.qK == null) || (this.qK.isEmpty())))
    {
      setResult(-1);
      finish();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity
 * JD-Core Version:    0.7.0.1
 */