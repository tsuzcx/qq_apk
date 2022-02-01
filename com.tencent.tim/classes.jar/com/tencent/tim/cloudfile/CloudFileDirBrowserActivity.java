package com.tencent.tim.cloudfile;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.fragment.BaseFragmentActivity;

public class CloudFileDirBrowserActivity
  extends BaseFragmentActivity
{
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_local_file_upload_finisth", false))) {
      finish();
    }
    while ((paramIntent == null) || (paramInt2 != -1) || (!paramIntent.getBooleanExtra("key_mail_attach_select_finish", false))) {
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    Object localObject = getIntent().getExtras();
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new Bundle(CloudFileDirBrowserActivity.class.getClassLoader());
    }
    paramBundle.putBoolean("key_top_level_dir", true);
    localObject = (FileInfo)paramBundle.getParcelable("key_file_info");
    if (localObject != null) {}
    for (localObject = ((FileInfo)localObject).getName();; localObject = "")
    {
      a(CloudFileListFragment.class, paramBundle, (CharSequence)localObject, true, 6, true);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileDirBrowserActivity
 * JD-Core Version:    0.7.0.1
 */