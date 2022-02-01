package com.tencent.mobileqq.app.proxy;

import acxt;
import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class DataLineMsgProxy$9
  implements Runnable
{
  public DataLineMsgProxy$9(acxt paramacxt, long paramLong, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.this$0.b(this.ad);
    ContentValues localContentValues = new ContentValues();
    if (!TextUtils.isEmpty(this.bra)) {
      localContentValues.put("serverPath", this.bra);
    }
    if ((this.cz != null) && (this.cz.length > 0)) {
      localContentValues.put("md5", this.cz);
    }
    if (localDataLineMsgRecord != null) {
      this.this$0.a(this.this$0.bqX, localContentValues, "msgId=?", new String[] { String.valueOf(localDataLineMsgRecord.msgId) }, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.DataLineMsgProxy.9
 * JD-Core Version:    0.7.0.1
 */