package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract interface Pools$Pool
{
  @Nullable
  public abstract Object acquire();
  
  public abstract boolean release(@NonNull Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.Pools.Pool
 * JD-Core Version:    0.7.0.1
 */