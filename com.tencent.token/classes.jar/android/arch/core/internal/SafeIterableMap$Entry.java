package android.arch.core.internal;

import android.support.annotation.NonNull;
import java.util.Map.Entry;

class SafeIterableMap$Entry
  implements Map.Entry
{
  @NonNull
  final Object mKey;
  Entry mNext;
  Entry mPrevious;
  @NonNull
  final Object mValue;
  
  SafeIterableMap$Entry(@NonNull Object paramObject1, @NonNull Object paramObject2)
  {
    this.mKey = paramObject1;
    this.mValue = paramObject2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Entry)) {
        return false;
      }
      paramObject = (Entry)paramObject;
    } while ((this.mKey.equals(paramObject.mKey)) && (this.mValue.equals(paramObject.mValue)));
    return false;
  }
  
  @NonNull
  public Object getKey()
  {
    return this.mKey;
  }
  
  @NonNull
  public Object getValue()
  {
    return this.mValue;
  }
  
  public Object setValue(Object paramObject)
  {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public String toString()
  {
    return this.mKey + "=" + this.mValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.arch.core.internal.SafeIterableMap.Entry
 * JD-Core Version:    0.7.0.1
 */