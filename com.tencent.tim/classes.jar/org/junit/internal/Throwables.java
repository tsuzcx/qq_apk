package org.junit.internal;

public final class Throwables
{
  private static <T extends Throwable> void rethrow(Throwable paramThrowable)
    throws Throwable
  {
    throw paramThrowable;
  }
  
  public static Exception rethrowAsException(Throwable paramThrowable)
    throws Exception
  {
    rethrow(paramThrowable);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.Throwables
 * JD-Core Version:    0.7.0.1
 */