package com.tencent.mobileqq.activity.aio.item;

import efy;
import java.util.ArrayList;
import java.util.HashMap;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(efy paramefy)
  {
    if (paramefy == null) {
      return;
    }
    get(paramefy.a).add(paramefy);
  }
  
  public ArrayList get(String paramString)
  {
    ArrayList localArrayList2 = (ArrayList)super.get(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      put(paramString, localArrayList1);
    }
    return localArrayList1;
  }
  
  public void remove(efy paramefy)
  {
    if ((paramefy == null) || (paramefy.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramefy.a);
      localArrayList.remove(paramefy);
    } while (!localArrayList.isEmpty());
    remove(paramefy.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */