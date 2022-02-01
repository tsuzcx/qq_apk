package com.tencent.bugly.proguard;

public final class ah
  extends k
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  private String d = "";
  private String e = "";
  
  public final void a(i parami)
  {
    this.a = parami.b(0, true);
    this.d = parami.b(1, false);
    this.b = parami.b(2, false);
    this.e = parami.b(3, false);
    this.c = parami.b(4, false);
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    if (this.d != null) {
      paramj.a(this.d, 1);
    }
    if (this.b != null) {
      paramj.a(this.b, 2);
    }
    if (this.e != null) {
      paramj.a(this.e, 3);
    }
    if (this.c != null) {
      paramj.a(this.c, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.ah
 * JD-Core Version:    0.7.0.1
 */