package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import java.util.concurrent.Callable;

class ComposeMailActivity$3
  implements Callable<Object>
{
  ComposeMailActivity$3(ComposeMailActivity paramComposeMailActivity, String paramString1, String paramString2) {}
  
  public Object call()
    throws Exception
  {
    try
    {
      String str = MediaStore.Images.Media.insertImage(this.this$0.getContentResolver(), this.val$filePath, this.val$fileName, null);
      if (str != null) {
        this.this$0.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(str)));
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.3
 * JD-Core Version:    0.7.0.1
 */