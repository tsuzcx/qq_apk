package com.tencent.mobileqq.app.proxy;

import acxt;
import android.content.ContentValues;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class DataLineMsgProxy$7
  implements Runnable
{
  public DataLineMsgProxy$7(acxt paramacxt, long paramLong, String paramString) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.b(this.ad);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("path", this.val$path);
    if (localDataLineMsgRecord != null) {
      this.this$0.a(this.this$0.bqX, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.7
 * JD-Core Version:    0.7.0.1
 */