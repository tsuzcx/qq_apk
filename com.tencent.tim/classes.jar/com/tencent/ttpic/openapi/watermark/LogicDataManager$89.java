package com.tencent.ttpic.openapi.watermark;

import android.text.TextUtils;

class LogicDataManager$89
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$89(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    if ((!TextUtils.isEmpty(LogicDataManager.access$5300(this.this$0))) && (LogicDataManager.access$5300(this.this$0).length() > 9)) {
      return LogicDataManager.access$5300(this.this$0).substring(9, 10);
    }
    return LogicDataManager.access$1400(this.this$0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.89
 * JD-Core Version:    0.7.0.1
 */