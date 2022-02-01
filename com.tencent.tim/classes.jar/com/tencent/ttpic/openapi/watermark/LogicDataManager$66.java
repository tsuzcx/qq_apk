package com.tencent.ttpic.openapi.watermark;

import com.tencent.ttpic.openapi.model.WMElement;
import java.util.HashMap;

class LogicDataManager$66
  extends LogicDataManager.LogicValueProvider
{
  LogicDataManager$66(LogicDataManager paramLogicDataManager)
  {
    super(paramLogicDataManager, null);
  }
  
  public String getValue()
  {
    return super.getValue();
  }
  
  public String getValue(WMElement paramWMElement)
  {
    if (paramWMElement.textSource.equals("")) {
      paramWMElement = getValue();
    }
    String str;
    do
    {
      return paramWMElement;
      str = (String)this.this$0.mFollowData.get(paramWMElement.textSource);
      paramWMElement = str;
    } while (str != null);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.watermark.LogicDataManager.66
 * JD-Core Version:    0.7.0.1
 */