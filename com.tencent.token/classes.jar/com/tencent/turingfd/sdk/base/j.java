package com.tencent.turingfd.sdk.base;

import android.os.Handler;
import android.util.SparseArray;
import java.util.List;

public final class j
  implements by
{
  public void a(int paramInt)
  {
    Object localObject = i.d(this.a).f;
    if (localObject != null) {
      localObject = (dr)localObject;
    }
  }
  
  public void a(et paramet, List paramList, SparseArray paramSparseArray)
  {
    int i = paramet.a;
    i.a(this.a, false);
    i.c(this.a).post(new g(this, "saveSensorFile", i, paramSparseArray, paramList, paramet));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.j
 * JD-Core Version:    0.7.0.1
 */