package com.tencent.thumbplayer.core.richmedia;

public class TPNativeRichMediaFeatureData
{
  private String mEnv;
  private TPNativeRichMediaFeatureContent[] mFeatureContents = new TPNativeRichMediaFeatureContent[0];
  private String mFeatureType;
  private String mVersion;
  
  public String getEnv()
  {
    return this.mEnv;
  }
  
  public TPNativeRichMediaFeatureContent[] getFeatureContents()
  {
    return this.mFeatureContents;
  }
  
  public String getFeatureType()
  {
    return this.mFeatureType;
  }
  
  public String getVersion()
  {
    return this.mVersion;
  }
  
  public void setEnv(String paramString)
  {
    this.mEnv = paramString;
  }
  
  public void setFeatureContents(TPNativeRichMediaFeatureContent[] paramArrayOfTPNativeRichMediaFeatureContent)
  {
    this.mFeatureContents = paramArrayOfTPNativeRichMediaFeatureContent;
  }
  
  public void setFeatureType(String paramString)
  {
    this.mFeatureType = paramString;
  }
  
  public void setVersion(String paramString)
  {
    this.mVersion = paramString;
  }
  
  public static class TPNativeRichMediaFeatureContent
  {
    private String mContent = "";
    private long mEndTimeMs = -1L;
    private long mStartTimeMs = -1L;
    
    public String getContent()
    {
      return this.mContent;
    }
    
    public long getEndTimeMs()
    {
      return this.mEndTimeMs;
    }
    
    public long getStartTimeMs()
    {
      return this.mStartTimeMs;
    }
    
    public void setContent(String paramString)
    {
      this.mContent = paramString;
    }
    
    public void setEndTimeMs(long paramLong)
    {
      this.mEndTimeMs = paramLong;
    }
    
    public void setStartTimeMs(long paramLong)
    {
      this.mStartTimeMs = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData
 * JD-Core Version:    0.7.0.1
 */