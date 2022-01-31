package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Pair
{
  @Nullable
  public final Object first;
  @Nullable
  public final Object second;
  
  public Pair(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    this.first = paramObject1;
    this.second = paramObject2;
  }
  
  @NonNull
  public static Pair create(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return new Pair(paramObject1, paramObject2);
  }
  
  private static boolean objectsEqual(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Pair)) {}
    do
    {
      return false;
      paramObject = (Pair)paramObject;
    } while ((!objectsEqual(paramObject.first, this.first)) || (!objectsEqual(paramObject.second, this.second)));
    return true;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.first == null)
    {
      i = 0;
      if (this.second != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.first.hashCode();
      break;
      label33:
      j = this.second.hashCode();
    }
  }
  
  public String toString()
  {
    return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.Pair
 * JD-Core Version:    0.7.0.1
 */