package com.tencent.moai.mailsdk.protocol.model;

public abstract class Folder
{
  public static final int MODE_CLOSE = 0;
  public static final int MODE_READ_ONLY = 1;
  public static final int MODE_READ_WRITE = 2;
  
  public abstract void close(boolean paramBoolean);
  
  public abstract boolean exists();
  
  public int getDeleteMessageCount()
  {
    int j = 0;
    Message[] arrayOfMessage = getMessage();
    int m = arrayOfMessage.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (arrayOfMessage[i].isFlag(Flags.Flag.DELETED)) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public abstract String getFullName();
  
  public abstract Message getMessage(int paramInt);
  
  public Message[] getMessage()
  {
    int j = getMessageCount();
    Message[] arrayOfMessage = new Message[j];
    int i = 0;
    while (i < j)
    {
      arrayOfMessage[i] = getMessage(i);
      i += 1;
    }
    return arrayOfMessage;
  }
  
  public Message[] getMessage(int paramInt1, int paramInt2)
  {
    Message[] arrayOfMessage = new Message[paramInt2 - paramInt1];
    int i = 0;
    while (i < paramInt2 - paramInt1)
    {
      arrayOfMessage[i] = getMessage(i + paramInt1);
      i += 1;
    }
    return arrayOfMessage;
  }
  
  public abstract int getMessageCount();
  
  public abstract String getName();
  
  public abstract Folder getParent();
  
  public int getRecentMessageCount()
  {
    int j = 0;
    Message[] arrayOfMessage = getMessage();
    int m = arrayOfMessage.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (arrayOfMessage[i].isFlag(Flags.Flag.RECENT)) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public int getSeenMessageCount()
  {
    int j = 0;
    Message[] arrayOfMessage = getMessage();
    int m = arrayOfMessage.length;
    int i = 0;
    while (i < m)
    {
      int k = j;
      if (arrayOfMessage[i].isFlag(Flags.Flag.SEEN)) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public abstract int getType();
  
  public abstract boolean isOpen();
  
  public abstract void open(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.model.Folder
 * JD-Core Version:    0.7.0.1
 */