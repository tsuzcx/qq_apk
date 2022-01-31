package com.tencent.theme;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.util.LongSparseArray;

@TargetApi(16)
class f
  extends d
{
  public f(SkinEngine paramSkinEngine, Resources paramResources, LongSparseArray paramLongSparseArray, Class paramClass, int paramInt)
  {
    super(paramSkinEngine, paramResources, paramLongSparseArray, paramClass, paramInt);
  }
  
  public Object get(long paramLong)
  {
    Object localObject = (Integer)this.a.get(paramLong);
    if (localObject == null) {
      return this.b.get(paramLong);
    }
    localObject = this.c.b(((Integer)localObject).intValue());
    if (localObject != null) {
      return ((SkinnableColorStateList)localObject).a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.theme.f
 * JD-Core Version:    0.7.0.1
 */