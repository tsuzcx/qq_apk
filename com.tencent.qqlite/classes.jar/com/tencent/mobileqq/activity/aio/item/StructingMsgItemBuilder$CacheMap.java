package com.tencent.mobileqq.activity.aio.item;

import bxd;
import java.util.ArrayList;
import java.util.HashMap;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(bxd parambxd)
  {
    if (parambxd == null) {
      return;
    }
    get(parambxd.a).add(parambxd);
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
  
  public void remove(bxd parambxd)
  {
    if ((parambxd == null) || (parambxd.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(parambxd.a);
      localArrayList.remove(parambxd);
    } while (!localArrayList.isEmpty());
    remove(parambxd.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */