package com.tencent.token;

public final class aqe
{
  public volatile String a = "";
  public volatile String b = "";
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSessionId: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mEncodeKey: ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqe
 * JD-Core Version:    0.7.0.1
 */