package com.tencent.token;

import java.lang.reflect.Field;

public final class adi
  extends adj.b
{
  public adi(String paramString, boolean paramBoolean1, Field paramField, boolean paramBoolean2, ahh paramahh, ahx paramahx, aek paramaek)
  {
    super(paramString, paramBoolean1);
  }
  
  public final void a(aep paramaep, Object paramObject)
  {
    Object localObject = this.a.get(paramObject);
    if (this.b) {
      paramObject = this.c;
    } else {
      paramObject = new adu(this.d, this.c, this.e.b);
    }
    paramObject.a(paramaep, localObject);
  }
  
  public final boolean a(Object paramObject)
  {
    if (!this.g) {
      return false;
    }
    return this.a.get(paramObject) != paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adi
 * JD-Core Version:    0.7.0.1
 */