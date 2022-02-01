package com.tencent.mobileqq.activity.aio.item;

import eav;
import java.util.ArrayList;
import java.util.HashMap;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(eav parameav)
  {
    if (parameav == null) {
      return;
    }
    get(parameav.a).add(parameav);
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
  
  public void remove(eav parameav)
  {
    if ((parameav == null) || (parameav.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(parameav.a);
      localArrayList.remove(parameav);
    } while (!localArrayList.isEmpty());
    remove(parameav.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */