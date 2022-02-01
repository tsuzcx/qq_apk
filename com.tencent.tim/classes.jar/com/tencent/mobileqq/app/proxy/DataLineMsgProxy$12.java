package com.tencent.mobileqq.app.proxy;

import acxt;
import android.content.ContentValues;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class DataLineMsgProxy$12
  implements Runnable
{
  public DataLineMsgProxy$12(acxt paramacxt, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.b(this.ad);
    if (localDataLineMsgRecord != null)
    {
      localDataLineMsgRecord.issuc = false;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("issuc", Boolean.valueOf(false));
      this.this$0.a(this.this$0.bqX, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.12
 * JD-Core Version:    0.7.0.1
 */