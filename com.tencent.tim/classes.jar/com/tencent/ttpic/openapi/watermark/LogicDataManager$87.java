package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;

class LogicDataManager$87
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$87(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    if ((!TextUtils.isEmpty(LogicDataManager.access$5300(this.this$0))) && (LogicDataManager.access$5300(this.this$0).length() > 6)) {
      return LogicDataManager.access$5300(this.this$0).substring(6, 7);
    }
    return LogicDataManager.access$900(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.87
 * JD-Core Version:    0.7.0.1
 */