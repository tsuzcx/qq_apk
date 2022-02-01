package com.tencent.tim.filemanager.data.provider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import audx.d;
import com.tencent.mobileqq.app.BaseActivity;

public class FileDelegateActivity
  extends BaseActivity
  implements audx.d
{
  public void euA()
  {
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    super.onCreate(paramBundle);
    setTitle(null);
    try
    {
      new Handler().post(new FileDelegateActivity.1(this));
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle = paramBundle;
      paramBundle.printStackTrace();
      finish();
      return;
    }
    finally {}
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.data.provider.FileDelegateActivity
 * JD-Core Version:    0.7.0.1
 */