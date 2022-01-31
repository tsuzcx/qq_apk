package com.tencent.token;

import android.content.ContentValues;
import android.os.Handler;
import com.tencent.token.core.protocolcenter.h;
import java.io.File;
import java.util.HashMap;

public class ev
{
  public String a;
  public int b;
  public HashMap c = new HashMap();
  public Handler d;
  public boolean e = false;
  public int f;
  public boolean g = false;
  public int h = 90000;
  public String i;
  public int j;
  public boolean k;
  public h l;
  public int m = 0;
  public ContentValues n;
  public File o;
  public String p;
  public byte[] q;
  
  public ev() {}
  
  public ev(String paramString, int paramInt1, Handler paramHandler, int paramInt2)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.d = paramHandler;
    this.f = paramInt2;
    if (paramHandler != null) {
      this.i = paramHandler.getClass().getName();
    }
  }
  
  public void a()
  {
    this.d = null;
    this.l = null;
    this.c.clear();
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ev
 * JD-Core Version:    0.7.0.1
 */