package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@GwtIncompatible
final class JdkPattern
  extends CommonPattern
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final Pattern pattern;
  
  JdkPattern(Pattern paramPattern)
  {
    this.pattern = ((Pattern)Preconditions.checkNotNull(paramPattern));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof JdkPattern)) {
      return false;
    }
    return this.pattern.equals(((JdkPattern)paramObject).pattern);
  }
  
  int flags()
  {
    return this.pattern.flags();
  }
  
  public int hashCode()
  {
    return this.pattern.hashCode();
  }
  
  CommonMatcher matcher(CharSequence paramCharSequence)
  {
    return new JdkMatcher(this.pattern.matcher(paramCharSequence));
  }
  
  String pattern()
  {
    return this.pattern.pattern();
  }
  
  public String toString()
  {
    return this.pattern.toString();
  }
  
  static final class JdkMatcher
    extends CommonMatcher
  {
    final Matcher matcher;
    
    JdkMatcher(Matcher paramMatcher)
    {
      this.matcher = ((Matcher)Preconditions.checkNotNull(paramMatcher));
    }
    
    int end()
    {
      return this.matcher.end();
    }
    
    boolean find()
    {
      return this.matcher.find();
    }
    
    boolean find(int paramInt)
    {
      return this.matcher.find(paramInt);
    }
    
    boolean matches()
    {
      return this.matcher.matches();
    }
    
    String replaceAll(String paramString)
    {
      return this.matcher.replaceAll(paramString);
    }
    
    int start()
    {
      return this.matcher.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.JdkPattern
 * JD-Core Version:    0.7.0.1
 */