package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;

class LogicDataManager$86
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$86(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    if ((!TextUtils.isEmpty(LogicDataManager.access$5300(this.this$0))) && (LogicDataManager.access$5300(this.this$0).length() > 5)) {
      return LogicDataManager.access$5300(this.this$0).substring(5, 6);
    }
    return LogicDataManager.access$900(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.86
 * JD-Core Version:    0.7.0.1
 */