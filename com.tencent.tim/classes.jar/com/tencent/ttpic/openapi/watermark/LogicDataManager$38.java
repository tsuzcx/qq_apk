package com.tencent.ttpic.openapi.watermark;

import com.tencent.ttpic.openapi.model.WMElement;
import java.util.HashMap;

class LogicDataManager$38
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$38(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    return getValue(null);
  }
  
  public String getValue(WMElement paramWMElement)
  {
    int i = 0;
    if (LogicDataManager.access$3000(this.this$0) != null) {
      i = LogicDataManager.access$3000(this.this$0).onGetQQNumber();
    }
    if (paramWMElement != null)
    {
      if (LogicDataManager.access$3100(this.this$0) != i)
      {
        LogicDataManager.access$3102(this.this$0, i);
        this.this$0.mFollowData.put(paramWMElement.id, String.valueOf(LogicDataManager.access$3100(this.this$0)));
      }
      if (LogicDataManager.access$3100(this.this$0) == 0) {
        this.this$0.mFollowData.put(paramWMElement.id, "-1");
      }
    }
    if (LogicDataManager.access$3100(this.this$0) != 0) {
      return String.valueOf(LogicDataManager.access$3100(this.this$0));
    }
    return "------";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.38
 * JD-Core Version:    0.7.0.1
 */