package com.tencent.mobileqq.filemanager.data;

import agne;
import android.content.ContentValues;

public class FileManagerProxy$3
  implements Runnable
{
  public FileManagerProxy$3(agne paramagne, ContentValues paramContentValues, long paramLong) {}
  
  public void run()
  {
    try
    {
      this.this$0.a(FileManagerEntity.tableName(), this.a, "nSessionId=?", new String[] { String.valueOf(this.Zh) }, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileManagerProxy.3
 * JD-Core Version:    0.7.0.1
 */