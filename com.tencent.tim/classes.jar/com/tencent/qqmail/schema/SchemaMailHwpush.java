package com.tencent.qqmail.schema;

import android.content.Context;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;

public class SchemaMailHwpush
  extends SchemaBase
{
  private static final String TAG = "SchemaMailHwpush";
  private String mMsg;
  
  public SchemaMailHwpush(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    QMPushManager.handleMessage(this.mMsg, -1, 1);
    return true;
  }
  
  public void parseParams()
  {
    if (this.params != null)
    {
      this.mMsg = this.params.substring(this.params.indexOf('=') + 1);
      QMLog.log(4, "SchemaMailHwpush", "msg: " + this.mMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaMailHwpush
 * JD-Core Version:    0.7.0.1
 */