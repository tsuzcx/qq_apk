package com.tencent.mobileqq.config;

public class Command
{
  public static final int a = 1;
  public static final int b = 2;
  private String a;
  
  public Command(String paramString, int paramInt1, int paramInt2)
  {
    this.a = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof Command))) {}
    while (!toString().equals(paramObject.toString())) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.Command
 * JD-Core Version:    0.7.0.1
 */