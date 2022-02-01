package com.huawei.hms.common.internal;

public final class Asserter
{
  private Asserter()
  {
    throw new AssertionError("Cannot use constructor to make a new instance");
  }
  
  public static void checkNotNull(Object paramObject)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException(paramObject.toString() + " is null");
    }
  }
  
  public static void checkNotNull(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new IllegalArgumentException(paramObject2.toString());
    }
  }
  
  public static void checkNull(Object paramObject)
  {
    if (paramObject != null) {
      throw new IllegalArgumentException(paramObject.toString() + " is not null");
    }
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      throw new IllegalStateException(paramObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.Asserter
 * JD-Core Version:    0.7.0.1
 */