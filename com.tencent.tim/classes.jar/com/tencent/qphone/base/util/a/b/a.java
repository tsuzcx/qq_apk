package com.tencent.qphone.base.util.a.b;

import java.util.ArrayList;
import java.util.Iterator;

public class a
  implements c
{
  ArrayList a = new ArrayList();
  
  public d a(d paramd)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      paramd = ((c)localIterator.next()).a(paramd);
    }
    return paramd;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a();
    }
  }
  
  public void a(c paramc)
  {
    this.a.add(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.b.a
 * JD-Core Version:    0.7.0.1
 */