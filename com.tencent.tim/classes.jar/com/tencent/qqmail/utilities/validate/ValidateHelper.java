package com.tencent.qqmail.utilities.validate;

public final class ValidateHelper
{
  public static void assertInDebug(String paramString, boolean paramBoolean)
  {
    assertInDebug(paramString, paramBoolean, null);
  }
  
  public static void assertInDebug(String paramString, boolean paramBoolean, Throwable paramThrowable) {}
  
  public static void checkMainProcess() {}
  
  public static void checkNotSynchronized(Object paramObject) {}
  
  public static void checkPushProcess() {}
  
  public static void checkSynchronized(Object paramObject) {}
  
  public static void mainThread() {}
  
  public static void nonNegative(int paramInt) {}
  
  public static void notMainThread() {}
  
  public static void notNull(Object paramObject)
    throws IllegalArgumentException
  {}
  
  public static void notNullAndNotEmpty(String paramString)
    throws IllegalArgumentException
  {}
  
  public static void positive(int paramInt) {}
  
  public static void throwExceptionInDebug(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.validate.ValidateHelper
 * JD-Core Version:    0.7.0.1
 */