package com.tencent.qphone.base.util.a.b;

import java.util.zip.Deflater;

public class b
  implements c
{
  private static final int d = 10;
  public d a = new d(2058);
  Deflater b = new Deflater();
  private final boolean e;
  
  public b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.b.setStrategy(1);
    this.b.setLevel(1);
  }
  
  public d a(d paramd)
  {
    d locald = paramd;
    if (this.e)
    {
      this.b.setInput(paramd.a, paramd.c, paramd.d);
      this.a.d = this.b.deflate(this.a.a, 0, this.a.b, 2);
      this.a.c = 0;
      locald = this.a;
    }
    return locald;
  }
  
  public void a()
  {
    this.b.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.b.b
 * JD-Core Version:    0.7.0.1
 */