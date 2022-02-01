package com.tencent.map.sdk.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;

public final class oz
{
  private int a = 100;
  private a<String> b = new a();
  private Hashtable<String, Integer> c = new Hashtable();
  private IntBuffer d;
  
  public oz()
  {
    if (this.d == null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.a * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.d = localByteBuffer.asIntBuffer();
    }
  }
  
  public final void a()
  {
    int i = 0;
    try
    {
      this.c.clear();
      a locala = this.b;
      locala.c = 0;
      locala.b = 0;
      while (i < locala.a.length)
      {
        locala.a[i] = null;
        i += 1;
      }
      if (this.d != null) {
        this.d.clear();
      }
      return;
    }
    finally {}
  }
  
  public static final class a<E>
  {
    Object[] a = new Object[100];
    int b = 0;
    int c = 0;
    private int d = 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.oz
 * JD-Core Version:    0.7.0.1
 */