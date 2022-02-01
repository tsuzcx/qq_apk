package com.tencent.tim.filemanager.util;

import ahav;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import aopl;
import auds;
import audx;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dz;
import java.io.File;

public final class FileManagerUtil$2
  implements Runnable
{
  public FileManagerUtil$2(String paramString, Activity paramActivity, File paramFile) {}
  
  public void run()
  {
    try
    {
      String str1 = ahav.getFileName(this.val$filePath);
      Uri localUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
      String str2 = aopl.F(this.val$activity, str1);
      int i = dz.l(this.val$filePath);
      ContentValues localContentValues = new ContentValues(7);
      localContentValues.put("title", str1);
      localContentValues.put("_display_name", this.val$file.getName());
      localContentValues.put("date_modified", Long.valueOf(this.val$file.lastModified() / 1000L));
      localContentValues.put("mime_type", str2);
      localContentValues.put("_data", this.val$filePath);
      localContentValues.put("_size", Long.valueOf(this.val$file.length()));
      int j = audx.fM(str1);
      if (j == 0)
      {
        localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("orientation", Integer.valueOf(i));
      }
      for (;;)
      {
        this.val$activity.getContentResolver().insert(localUri, localContentValues);
        auds.OT(2131694150);
        return;
        if (j == 2)
        {
          long l = ShortVideoUtils.getDuration(this.val$filePath);
          localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
          localContentValues.put("duration", Long.valueOf(l));
          localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      auds.JD("手机内存不足，保存本地失败。");
      return;
    }
    catch (Exception localException)
    {
      auds.OS(2131694149);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.util.FileManagerUtil.2
 * JD-Core Version:    0.7.0.1
 */