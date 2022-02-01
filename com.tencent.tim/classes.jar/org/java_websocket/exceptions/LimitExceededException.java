package org.java_websocket.exceptions;

public class LimitExceededException
  extends InvalidDataException
{
  private static final long serialVersionUID = 6908339749836826785L;
  private final int limit;
  
  public LimitExceededException()
  {
    this(2147483647);
  }
  
  public LimitExceededException(int paramInt)
  {
    super(1009);
    this.limit = paramInt;
  }
  
  public LimitExceededException(String paramString)
  {
    this(paramString, 2147483647);
  }
  
  public LimitExceededException(String paramString, int paramInt)
  {
    super(1009, paramString);
    this.limit = paramInt;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.exceptions.LimitExceededException
 * JD-Core Version:    0.7.0.1
 */