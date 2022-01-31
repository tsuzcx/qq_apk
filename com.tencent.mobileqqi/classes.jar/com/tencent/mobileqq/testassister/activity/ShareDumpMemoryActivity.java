package com.tencent.mobileqq.testassister.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class ShareDumpMemoryActivity
  extends IphoneTitleBarActivity
{
  public void a(String paramString)
  {
    try
    {
      Object localObject1 = new FileInfo(paramString);
      Object localObject2 = FileManagerUtil.a((FileInfo)localObject1);
      paramString = new ForwardFileInfo();
      paramString.b(((FileManagerEntity)localObject2).nSessionId);
      paramString.c(3);
      paramString.a(10000);
      paramString.a(((FileInfo)localObject1).c());
      paramString.d(((FileInfo)localObject1).d());
      paramString.d(((FileInfo)localObject1).a());
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("forward_type", 0);
      ((Bundle)localObject1).putParcelable("fileinfo", paramString);
      ((Bundle)localObject1).putBoolean("not_forward", true);
      localObject2 = new Intent(this, ForwardRecentActivity.class);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtra("forward_text", paramString.d());
      ((Intent)localObject2).putExtra("forward_type", 0);
      startActivityForResult((Intent)localObject2, 103);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      finish();
      return;
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = new Intent(this, ChatActivity.class);
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getIntent().getStringExtra("dumpFilePath"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.activity.ShareDumpMemoryActivity
 * JD-Core Version:    0.7.0.1
 */