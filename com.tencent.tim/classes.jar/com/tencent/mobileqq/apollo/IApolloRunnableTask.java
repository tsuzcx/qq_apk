package com.tencent.mobileqq.apollo;

public abstract class IApolloRunnableTask
  implements Runnable
{
  public boolean Yq()
  {
    return false;
  }
  
  public boolean Yr()
  {
    int i = getScriptId();
    return (i == 3) || (i == 1) || (i == 2) || (i == 4);
  }
  
  public abstract String aV();
  
  public int getScriptId()
  {
    return hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.IApolloRunnableTask
 * JD-Core Version:    0.7.0.1
 */