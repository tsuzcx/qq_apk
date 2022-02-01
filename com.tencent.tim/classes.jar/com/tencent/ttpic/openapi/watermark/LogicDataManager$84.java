package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;

class LogicDataManager$84
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$84(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    if ((!TextUtils.isEmpty(LogicDataManager.access$5300(this.this$0))) && (LogicDataManager.access$5300(this.this$0).length() > 2)) {
      return LogicDataManager.access$5300(this.this$0).substring(2, 3);
    }
    return LogicDataManager.access$400(this.this$0, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.84
 * JD-Core Version:    0.7.0.1
 */