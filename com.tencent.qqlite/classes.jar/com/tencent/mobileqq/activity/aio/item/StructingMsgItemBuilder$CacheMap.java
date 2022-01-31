package com.tencent.mobileqq.activity.aio.item;

import byb;
import java.util.ArrayList;
import java.util.HashMap;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(byb parambyb)
  {
    if (parambyb == null) {
      return;
    }
    get(parambyb.a).add(parambyb);
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
  
  public void remove(byb parambyb)
  {
    if ((parambyb == null) || (parambyb.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(parambyb.a);
      localArrayList.remove(parambyb);
    } while (!localArrayList.isEmpty());
    remove(parambyb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */