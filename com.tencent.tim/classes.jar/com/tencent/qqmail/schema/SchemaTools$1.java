package com.tencent.qqmail.schema;

import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.log.FeedbackManager;
import com.tencent.qqmail.utilities.log.QMLog;

class SchemaTools$1
  implements Runnable
{
  SchemaTools$1(SchemaTools paramSchemaTools, long paramLong) {}
  
  public void run()
  {
    QMLog.log(4, "SchemaTools", "run uploadDebugLog. duration:" + this.val$duration);
    QMPushConfigUtil.setPushLogTime();
    FeedbackManager.uploadDebugLog(this.val$duration, SchemaTools.access$000(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaTools.1
 * JD-Core Version:    0.7.0.1
 */