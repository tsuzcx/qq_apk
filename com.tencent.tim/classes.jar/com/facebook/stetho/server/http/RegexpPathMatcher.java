package com.facebook.stetho.server.http;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpPathMatcher
  implements PathMatcher
{
  private final Pattern mPattern;
  
  public RegexpPathMatcher(Pattern paramPattern)
  {
    this.mPattern = paramPattern;
  }
  
  public boolean match(String paramString)
  {
    return this.mPattern.matcher(paramString).matches();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.http.RegexpPathMatcher
 * JD-Core Version:    0.7.0.1
 */