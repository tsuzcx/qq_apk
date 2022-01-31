package com.tencent.securemodule;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class e
  extends JceStruct
  implements Cloneable
{
  private static a e;
  private static o f;
  private static p g;
  private static ArrayList<c> h;
  private a a = null;
  private o b = null;
  private p c = null;
  private ArrayList<c> d = null;
  
  static
  {
    if (!e.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      return;
    }
  }
  
  public final o a()
  {
    return this.b;
  }
  
  public final p b()
  {
    return this.c;
  }
  
  public final ArrayList<c> c()
  {
    return this.d;
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (i) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (e)paramObject;
    } while ((!JceUtil.equals(this.a, paramObject.a)) || (!JceUtil.equals(this.b, paramObject.b)) || (!JceUtil.equals(this.c, paramObject.c)) || (!JceUtil.equals(this.d, paramObject.d)));
    return true;
  }
  
  public final int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (e == null) {
      e = new a();
    }
    this.a = ((a)paramJceInputStream.read(e, 0, true));
    if (f == null) {
      f = new o();
    }
    this.b = ((o)paramJceInputStream.read(f, 1, true));
    if (g == null) {
      g = new p();
    }
    this.c = ((p)paramJceInputStream.read(g, 2, false));
    if (h == null)
    {
      h = new ArrayList();
      c localc = new c();
      h.add(localc);
    }
    this.d = ((ArrayList)paramJceInputStream.read(h, 3, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.e
 * JD-Core Version:    0.7.0.1
 */