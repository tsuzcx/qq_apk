package com.tencent.thumbplayer.api.richmedia;

import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent;
import java.util.ArrayList;
import java.util.List;

public class TPRichMediaFeatureData
{
  private String mEnv = "";
  private List<TPRichMediaFeatureContent> mFeatureContents;
  private String mFeatureType = "";
  private String mVersion = "";
  
  public TPRichMediaFeatureData(TPNativeRichMediaFeatureData paramTPNativeRichMediaFeatureData)
  {
    this.mFeatureType = paramTPNativeRichMediaFeatureData.getFeatureType();
    this.mEnv = paramTPNativeRichMediaFeatureData.getEnv();
    this.mVersion = paramTPNativeRichMediaFeatureData.getVersion();
    this.mFeatureContents = new ArrayList();
    if (paramTPNativeRichMediaFeatureData.getFeatureContents() != null)
    {
      paramTPNativeRichMediaFeatureData = paramTPNativeRichMediaFeatureData.getFeatureContents();
      int j = paramTPNativeRichMediaFeatureData.length;
      int i = 0;
      while (i < j)
      {
        TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent localTPNativeRichMediaFeatureContent = paramTPNativeRichMediaFeatureData[i];
        this.mFeatureContents.add(new TPRichMediaFeatureContent(localTPNativeRichMediaFeatureContent));
        i += 1;
      }
    }
  }
  
  public String getEnv()
  {
    return this.mEnv;
  }
  
  public List<TPRichMediaFeatureContent> getFeatureContents()
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
  
  public static class TPRichMediaFeatureContent
  {
    private String mContent = "";
    private long mEndTimeMs = -1L;
    private long mStartTimeMs = -1L;
    
    TPRichMediaFeatureContent(TPNativeRichMediaFeatureData.TPNativeRichMediaFeatureContent paramTPNativeRichMediaFeatureContent)
    {
      this.mStartTimeMs = paramTPNativeRichMediaFeatureContent.getStartTimeMs();
      this.mEndTimeMs = paramTPNativeRichMediaFeatureContent.getEndTimeMs();
      this.mContent = paramTPNativeRichMediaFeatureContent.getContent();
    }
    
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData
 * JD-Core Version:    0.7.0.1
 */