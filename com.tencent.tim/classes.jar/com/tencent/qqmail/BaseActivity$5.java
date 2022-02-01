package com.tencent.qqmail;

import android.content.Intent;
import android.os.Bundle;

class BaseActivity$5
  implements BaseActivityImpl.PrivateAccess
{
  BaseActivity$5(BaseActivity paramBaseActivity) {}
  
  public boolean checkGesturePassword()
  {
    return this.this$0.checkGesturePassword();
  }
  
  public boolean checkWelcomePopularize()
  {
    return this.this$0.checkWelcomePopularize();
  }
  
  public Object getPage()
  {
    return this.this$0;
  }
  
  public boolean isMultiStartAllowed()
  {
    return this.this$0.isMultiStartAllowed();
  }
  
  public void removeSelf()
  {
    BaseActivity.access$1201(this.this$0);
  }
  
  public void super_finish()
  {
    BaseActivity.access$1001(this.this$0);
  }
  
  public void super_finishActivity(int paramInt)
  {
    BaseActivity.access$1101(this.this$0, paramInt);
  }
  
  public void super_onCreate(Bundle paramBundle)
  {
    BaseActivity.access$201(this.this$0, paramBundle);
  }
  
  public void super_onDestroy()
  {
    BaseActivity.access$301(this.this$0);
  }
  
  public void super_onPause()
  {
    BaseActivity.access$701(this.this$0);
  }
  
  public void super_onResume()
  {
    BaseActivity.access$601(this.this$0);
  }
  
  public void super_onStart()
  {
    BaseActivity.access$401(this.this$0);
  }
  
  public void super_onStop()
  {
    BaseActivity.access$501(this.this$0);
  }
  
  public void super_startActivity(Intent paramIntent)
  {
    BaseActivity.access$801(this.this$0, paramIntent);
  }
  
  public void super_startActivityForResult(Intent paramIntent, int paramInt)
  {
    BaseActivity.access$901(this.this$0, paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivity.5
 * JD-Core Version:    0.7.0.1
 */