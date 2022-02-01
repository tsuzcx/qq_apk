package com.tencent.qphone.base.util.a.c;

import java.nio.MappedByteBuffer;

public class b
{
  public static final int a = 8;
  public static final int b = -21937241;
  public static final int c = -20190711;
  public static final byte d = 1;
  public static final int e = -18239;
  private static final String h = "MagicHeadWriter";
  final boolean f;
  MappedByteBuffer g;
  
  public b(MappedByteBuffer paramMappedByteBuffer, boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.g = paramMappedByteBuffer;
  }
  
  public void a()
  {
    MappedByteBuffer localMappedByteBuffer = this.g;
    if (this.f) {}
    for (int i = -21937241;; i = -18239)
    {
      localMappedByteBuffer.putInt(0, i);
      this.g.putInt(4, this.g.position() - 8);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g.flip();
    if (!paramBoolean) {
      this.g.position(8);
    }
  }
  
  public void b()
  {
    MappedByteBuffer localMappedByteBuffer = this.g;
    if (this.f) {}
    for (int i = -21937241;; i = -18239)
    {
      localMappedByteBuffer.putInt(i);
      this.g.putInt(this.g.position() - 8);
      return;
    }
  }
  
  public boolean c()
  {
    boolean bool = false;
    int i = this.g.getInt(0);
    int j = this.g.getInt(4);
    if ((j > 0) && (j < this.g.capacity() - 8) && ((i == -21937241) || (i == -18239)))
    {
      this.g.position(j + 8);
      if (i == -21937241) {
        bool = true;
      }
      a(bool);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.c.b
 * JD-Core Version:    0.7.0.1
 */