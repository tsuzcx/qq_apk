package com.tencent.mobileqq.mail;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import atgc;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.cloudfile.CloudFileDirBrowserActivity;

public class MailPluginSelectAttachActivity
  extends BaseActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = new Intent(this, CloudFileDirBrowserActivity.class);
    Object localObject = new FileInfo();
    ((FileInfo)localObject).bf(((atgc)this.app.getManager(373)).aE());
    ((FileInfo)localObject).setName(getString(2131691665));
    paramBundle.putExtra("key_file_info", (Parcelable)localObject);
    paramBundle.putExtra("key_top_level_dir", true);
    paramBundle.putExtra("key_file_browser_mode", 2);
    paramBundle.putExtra("key_bottom_bar_left_action", 2);
    paramBundle.putExtra("key_bottom_bar_right_action", 6);
    localObject = new SessionInfo();
    ((SessionInfo)localObject).cZ = 8001;
    paramBundle.putExtra("sessioninfo", (Parcelable)localObject);
    startActivityForResult(paramBundle, 1);
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(paramInt2, paramIntent);
    finish();
    overridePendingTransition(2130772077, 2130772079);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mail.MailPluginSelectAttachActivity
 * JD-Core Version:    0.7.0.1
 */