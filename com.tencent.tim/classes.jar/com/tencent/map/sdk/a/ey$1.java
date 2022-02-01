package com.tencent.map.sdk.a;

import java.io.IOException;
import java.lang.reflect.Field;

final class ey$1
  extends ey.b
{
  final ee<?> a = this.b.a(this.c);
  
  ey$1(ey paramey, String paramString, boolean paramBoolean1, boolean paramBoolean2, dn paramdn, fd paramfd, Field paramField, boolean paramBoolean3)
  {
    super(paramString, paramBoolean1, paramBoolean2);
  }
  
  final void a(fe paramfe, Object paramObject)
    throws IOException, IllegalAccessException
  {
    paramfe = this.a.a(paramfe);
    if ((paramfe != null) || (!this.e)) {
      this.d.set(paramObject, paramfe);
    }
  }
  
  final void a(fg paramfg, Object paramObject)
    throws IOException, IllegalAccessException
  {
    paramObject = this.d.get(paramObject);
    new fb(this.b, this.a, this.c.b).a(paramfg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ey.1
 * JD-Core Version:    0.7.0.1
 */