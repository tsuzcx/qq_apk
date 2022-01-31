package com.tencent.tencentmap.mapsdk.map;

import java.util.ArrayList;

final class u
  extends c<ArrayList<v.a>, Boolean>
{
  public q.b d = q.b.a;
  private w e = null;
  private byte[] f = new byte[1024];
  
  public u(ArrayList<v.a> paramArrayList)
  {
    super(paramArrayList);
  }
  
  private boolean a(byte[] paramArrayOfByte, v.a parama)
  {
    if (paramArrayOfByte == null) {}
    StringBuilder localStringBuilder;
    do
    {
      return false;
      if (paramArrayOfByte.length <= 0) {
        return true;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(parama.a);
      localStringBuilder.append("-");
      localStringBuilder.append(parama.b);
      localStringBuilder.append("-");
      localStringBuilder.append(parama.c);
    } while (!this.e.u.a(paramArrayOfByte, localStringBuilder.toString()));
    if (this.e != null) {
      this.e.a(parama);
    }
    if ((this.e.m == true) && (this.e != null) && (this.e.v != null)) {
      this.e.v.a(paramArrayOfByte, parama.a, parama.b, parama.c);
    }
    return true;
  }
  
  protected final String a()
  {
    int j = ((ArrayList)this.a).size();
    if (j <= 0) {
      return null;
    }
    int[] arrayOfInt = new int[((ArrayList)this.a).size() * 3];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[(i * 3)] = ((v.a)((ArrayList)this.a).get(i)).a;
      arrayOfInt[(i * 3 + 1)] = ((v.a)((ArrayList)this.a).get(i)).b;
      arrayOfInt[(i * 3 + 2)] = ((v.a)((ArrayList)this.a).get(i)).c;
      i += 1;
    }
    return this.e.t.a(this.e.e(), arrayOfInt);
  }
  
  public final void a(w paramw)
  {
    this.e = paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.u
 * JD-Core Version:    0.7.0.1
 */