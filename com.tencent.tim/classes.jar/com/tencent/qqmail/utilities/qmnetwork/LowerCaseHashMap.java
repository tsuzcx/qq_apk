package com.tencent.qqmail.utilities.qmnetwork;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class LowerCaseHashMap
  extends HashMap<String, List<String>>
{
  private static final long serialVersionUID = 1L;
  
  public boolean containsKey(Object paramObject)
  {
    boolean bool2 = super.containsKey(paramObject);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = super.containsKey(((String)paramObject).toLowerCase(Locale.getDefault()));
    }
    return bool1;
  }
  
  public List<String> get(Object paramObject)
  {
    List localList2 = (List)super.get(paramObject);
    List localList1 = localList2;
    if (localList2 == null) {
      localList1 = (List)super.get(((String)paramObject).toLowerCase(Locale.getDefault()));
    }
    return localList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.LowerCaseHashMap
 * JD-Core Version:    0.7.0.1
 */