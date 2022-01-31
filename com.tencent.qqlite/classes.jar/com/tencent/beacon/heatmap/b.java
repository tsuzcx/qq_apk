package com.tencent.beacon.heatmap;

public final class b
{
  int a = 0;
  private String b = "";
  private int c = 1;
  private int d = 1;
  private String e = "";
  private String f = "";
  
  public b(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, int paramInt3)
  {
    this.b = paramString1;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString2;
    this.f = paramString3;
    this.a = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
      } while (getClass() != paramObject.getClass());
      paramObject = (b)paramObject;
    } while ((this.b == null) || (paramObject.b == null) || (!this.b.equals(paramObject.b)) || (this.c != paramObject.c) || (this.d != paramObject.d) || (!this.e.equals(paramObject.e)) || (!this.f.equals(paramObject.f)));
    return true;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.b).append(",").append(this.c).append(",").append(this.d).append(",").append(this.e).append(",").append(this.a).append(",").append(this.f);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.heatmap.b
 * JD-Core Version:    0.7.0.1
 */