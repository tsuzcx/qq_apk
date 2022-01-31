package com.tencent.mobileqq.magicface.magicfaceaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionProcess
{
  public static final String a = "stop";
  public static final String b = "record";
  public int a;
  public List a = new ArrayList();
  public int b = -1;
  public String c;
  public String d;
  
  public int a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      RecordCondition localRecordCondition = (RecordCondition)localIterator.next();
      if ((localRecordCondition.a <= paramInt) && (localRecordCondition.b > paramInt)) {
        return localRecordCondition.c;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.magicfaceaction.ActionProcess
 * JD-Core Version:    0.7.0.1
 */