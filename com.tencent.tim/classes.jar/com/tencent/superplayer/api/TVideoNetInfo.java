package com.tencent.superplayer.api;

import java.util.ArrayList;
import java.util.Iterator;

public class TVideoNetInfo
  implements Cloneable
{
  private DefinitionInfo mCurrentDefinition;
  private ArrayList<DefinitionInfo> mDefinitionList;
  private boolean mHasWatermark = false;
  private long mUpdateTimeMillis;
  private long mVideoDurationMs;
  private long mVideoSize;
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public DefinitionInfo getCurrentDefinition()
  {
    return this.mCurrentDefinition;
  }
  
  public String getCurrentDefinitionStr()
  {
    if (this.mCurrentDefinition != null) {
      return this.mCurrentDefinition.getDefn();
    }
    return "";
  }
  
  public ArrayList<DefinitionInfo> getDefinitionList()
  {
    return this.mDefinitionList;
  }
  
  public ArrayList<String> getDefinitionStrList()
  {
    if (this.mDefinitionList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mDefinitionList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((DefinitionInfo)localIterator.next()).getDefn());
    }
    return localArrayList;
  }
  
  public long getUpdateTimeMillis()
  {
    return this.mUpdateTimeMillis;
  }
  
  public long getVideoDuration()
  {
    return this.mVideoDurationMs;
  }
  
  public long getVideoSize()
  {
    return this.mVideoSize;
  }
  
  public boolean isHasWatermark()
  {
    return this.mHasWatermark;
  }
  
  public void setCurrentDefinition(DefinitionInfo paramDefinitionInfo)
  {
    this.mCurrentDefinition = paramDefinitionInfo;
  }
  
  public void setDefinitionList(ArrayList<DefinitionInfo> paramArrayList)
  {
    this.mDefinitionList = paramArrayList;
  }
  
  public void setHasWatermark(boolean paramBoolean)
  {
    this.mHasWatermark = paramBoolean;
  }
  
  public void setUpdateTimeMillis(long paramLong)
  {
    this.mUpdateTimeMillis = paramLong;
  }
  
  public void setVideoDuration(long paramLong)
  {
    this.mVideoDurationMs = paramLong;
  }
  
  public void setVideoSize(long paramLong)
  {
    this.mVideoSize = paramLong;
  }
  
  public static class DefinitionInfo
    implements Cloneable
  {
    private String mDefn = "";
    private String mDefnName = "";
    private String mDefnRate = "";
    private String mDefnShowName = "";
    
    public DefinitionInfo(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.mDefn = paramString1;
      this.mDefnName = paramString2;
      this.mDefnRate = paramString3;
      this.mDefnShowName = paramString4;
    }
    
    public Object clone()
      throws CloneNotSupportedException
    {
      return super.clone();
    }
    
    public String getDefn()
    {
      return this.mDefn;
    }
    
    public String getDefnName()
    {
      return this.mDefnName;
    }
    
    public String getDefnRate()
    {
      return this.mDefnRate;
    }
    
    public String getDefnShowName()
    {
      return this.mDefnShowName;
    }
    
    public void setDefn(String paramString)
    {
      this.mDefn = paramString;
    }
    
    public void setDefnName(String paramString)
    {
      this.mDefnName = paramString;
    }
    
    public void setDefnRate(String paramString)
    {
      this.mDefnRate = paramString;
    }
    
    public void setDefnShowName(String paramString)
    {
      this.mDefnShowName = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.TVideoNetInfo
 * JD-Core Version:    0.7.0.1
 */