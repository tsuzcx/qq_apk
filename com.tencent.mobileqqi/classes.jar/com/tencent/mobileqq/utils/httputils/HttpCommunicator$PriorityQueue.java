package com.tencent.mobileqq.utils.httputils;

import java.util.ArrayList;
import java.util.LinkedList;

public class HttpCommunicator$PriorityQueue
{
  public static final int a = 200;
  public static final int b = 200;
  public static final int c = 201;
  public static final int d = 202;
  public static final int e = 3;
  private ArrayList a = new ArrayList();
  public int f = 0;
  
  public HttpCommunicator$PriorityQueue()
  {
    while (i < 3)
    {
      this.a.add(new LinkedList());
      i += 1;
    }
  }
  
  public int a()
  {
    return this.f;
  }
  
  public HttpMsg a(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.a.size())
    {
      if (((LinkedList)this.a.get(i)).size() != 0)
      {
        if (paramBoolean)
        {
          HttpMsg localHttpMsg = (HttpMsg)((LinkedList)this.a.get(i)).remove(0);
          this.f -= 1;
          return localHttpMsg;
        }
        return (HttpMsg)((LinkedList)this.a.get(i)).get(0);
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.a.size())
    {
      ((LinkedList)this.a.get(i)).clear();
      i += 1;
    }
    this.f = 0;
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {}
    int i;
    do
    {
      return;
      i = paramHttpMsg.b() - 200;
    } while ((i < 0) || (i >= this.a.size()));
    ((LinkedList)this.a.get(i)).add(paramHttpMsg);
    this.f += 1;
  }
  
  public boolean a(HttpMsg paramHttpMsg)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.a.size())
      {
        if (((LinkedList)this.a.get(i)).remove(paramHttpMsg))
        {
          this.f -= 1;
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator.PriorityQueue
 * JD-Core Version:    0.7.0.1
 */