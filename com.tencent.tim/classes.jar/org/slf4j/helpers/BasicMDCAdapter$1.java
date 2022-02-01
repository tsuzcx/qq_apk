package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;

class BasicMDCAdapter$1
  extends InheritableThreadLocal<Map<String, String>>
{
  BasicMDCAdapter$1(BasicMDCAdapter paramBasicMDCAdapter) {}
  
  protected Map<String, String> childValue(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    return new HashMap(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.slf4j.helpers.BasicMDCAdapter.1
 * JD-Core Version:    0.7.0.1
 */