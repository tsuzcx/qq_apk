package com.tencent.qqmail.launcher.third;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.activity.wework.WeWorkAuthActivity;

public class LaunchWeWorkAuthActivity
  extends ThirdLauncherActivity
{
  public static final int REQUEST_CODE = 101;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  protected void route()
  {
    Bundle localBundle = getIntent().getExtras();
    Intent localIntent = new Intent(this, WeWorkAuthActivity.class);
    localIntent.putExtras(localBundle);
    startActivityForResult(localIntent, 101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchWeWorkAuthActivity
 * JD-Core Version:    0.7.0.1
 */