package com.tencent.qqlive.module.videoreport;

import java.util.Map;

public class PageParams
{
  private Map<String, ?> mBasicParams;
  private Map<String, ?> mRefElementParams;
  private Map<String, ?> mRootRefElementParams;
  
  private PageParams(Builder paramBuilder)
  {
    this.mBasicParams = paramBuilder.mBasicParams;
    this.mRefElementParams = paramBuilder.mRefElementParams;
    this.mRootRefElementParams = paramBuilder.mRootRefElementParams;
  }
  
  public PageParams(Map<String, ?> paramMap)
  {
    this.mBasicParams = paramMap;
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public Map<String, ?> getBasicParams()
  {
    return this.mBasicParams;
  }
  
  public Map<String, ?> getRefElementParams()
  {
    return this.mRefElementParams;
  }
  
  public Map<String, ?> getRootRefElementParams()
  {
    return this.mRootRefElementParams;
  }
  
  public static class Builder
  {
    private Map<String, ?> mBasicParams;
    private Map<String, ?> mRefElementParams;
    private Map<String, ?> mRootRefElementParams;
    
    public PageParams build()
    {
      return new PageParams(this, null);
    }
    
    public Builder setBasicParams(Map<String, ?> paramMap)
    {
      this.mBasicParams = paramMap;
      return this;
    }
    
    public Builder setRefElementParams(Map<String, ?> paramMap)
    {
      this.mRefElementParams = paramMap;
      return this;
    }
    
    public Builder setRootRefElementParams(Map<String, ?> paramMap)
    {
      this.mRootRefElementParams = paramMap;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.PageParams
 * JD-Core Version:    0.7.0.1
 */