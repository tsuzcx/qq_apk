package com.facebook.stetho.server.http;

public class ExactPathMatcher
  implements PathMatcher
{
  private final String mPath;
  
  public ExactPathMatcher(String paramString)
  {
    this.mPath = paramString;
  }
  
  public boolean match(String paramString)
  {
    return this.mPath.equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.http.ExactPathMatcher
 * JD-Core Version:    0.7.0.1
 */