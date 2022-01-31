package com.tencent.mobileqq.activity.aio.item;

import bxe;
import java.util.ArrayList;
import java.util.HashMap;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(bxe parambxe)
  {
    if (parambxe == null) {
      return;
    }
    get(parambxe.a).add(parambxe);
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
  
  public void remove(bxe parambxe)
  {
    if ((parambxe == null) || (parambxe.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(parambxe.a);
      localArrayList.remove(parambxe);
    } while (!localArrayList.isEmpty());
    remove(parambxe.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */