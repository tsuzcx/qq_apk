package com.tencent.viola.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SingleFunctionParser$1
  implements FunctionParser.Mapper<String, List<V>>
{
  SingleFunctionParser$1(SingleFunctionParser.FlatMapper paramFlatMapper) {}
  
  public Map<String, List<V>> map(String paramString, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localLinkedList.add(this.val$mapper.map(str));
    }
    localHashMap.put(paramString, localLinkedList);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.utils.SingleFunctionParser.1
 * JD-Core Version:    0.7.0.1
 */