package com.facebook.stetho.inspector.network;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class MimeMatcher<T>
{
  private final ArrayList<MimeMatcher<T>.MimeMatcherRule> mRuleMap = new ArrayList();
  
  public void addRule(String paramString, T paramT)
  {
    this.mRuleMap.add(new MimeMatcherRule(paramString, paramT));
  }
  
  public void clear()
  {
    this.mRuleMap.clear();
  }
  
  @Nullable
  public T match(String paramString)
  {
    int j = this.mRuleMap.size();
    int i = 0;
    while (i < j)
    {
      MimeMatcherRule localMimeMatcherRule = (MimeMatcherRule)this.mRuleMap.get(i);
      if (localMimeMatcherRule.match(paramString)) {
        return localMimeMatcherRule.getResultIfMatched();
      }
      i += 1;
    }
    return null;
  }
  
  @SuppressLint({"BadMethodUse-java.lang.String.length"})
  class MimeMatcherRule
  {
    private final boolean mHasWildcard;
    private final String mMatchPrefix;
    private final T mResultIfMatched;
    
    public MimeMatcherRule(T paramT)
    {
      if (paramT.endsWith("*")) {
        this.mHasWildcard = true;
      }
      for (this.mMatchPrefix = paramT.substring(0, paramT.length() - 1); this.mMatchPrefix.contains("*"); this.mMatchPrefix = paramT)
      {
        throw new IllegalArgumentException("Multiple wildcards present in rule expression " + paramT);
        this.mHasWildcard = false;
      }
      Object localObject;
      this.mResultIfMatched = localObject;
    }
    
    public T getResultIfMatched()
    {
      return this.mResultIfMatched;
    }
    
    public boolean match(String paramString)
    {
      if (!paramString.startsWith(this.mMatchPrefix)) {}
      while ((!this.mHasWildcard) && (paramString.length() != this.mMatchPrefix.length())) {
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.MimeMatcher
 * JD-Core Version:    0.7.0.1
 */