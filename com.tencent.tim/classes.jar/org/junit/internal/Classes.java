package org.junit.internal;

public class Classes
{
  public static Class<?> getClass(String paramString)
    throws ClassNotFoundException
  {
    return Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.Classes
 * JD-Core Version:    0.7.0.1
 */