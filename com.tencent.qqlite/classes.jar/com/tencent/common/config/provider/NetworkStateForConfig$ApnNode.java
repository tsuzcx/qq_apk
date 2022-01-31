package com.tencent.common.config.provider;

public class NetworkStateForConfig$ApnNode
{
  private static final String c = ApnNode.class.getName();
  String a;
  String b;
  
  public String a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" apn = " + this.a);
    localStringBuilder.append(" name = " + this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.NetworkStateForConfig.ApnNode
 * JD-Core Version:    0.7.0.1
 */