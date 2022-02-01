package com.tencent.ttpic.openapi.model.cosfun;

import java.util.List;

public class CosFun
{
  private List<CosFunGroupItem> cosFunGroupItem;
  private int startInterval;
  private String tipsAnim;
  private int tipsAnimFrameDuration;
  private int tipsAnimFrames;
  
  public List<CosFunGroupItem> getCosFunGroupItem()
  {
    return this.cosFunGroupItem;
  }
  
  public int getStartInterval()
  {
    return this.startInterval;
  }
  
  public String getTipsAnim()
  {
    return this.tipsAnim;
  }
  
  public int getTipsAnimFrameDuration()
  {
    return this.tipsAnimFrameDuration;
  }
  
  public int getTipsAnimFrames()
  {
    return this.tipsAnimFrames;
  }
  
  public void setCosFunGroupItem(List<CosFunGroupItem> paramList)
  {
    this.cosFunGroupItem = paramList;
  }
  
  public void setStartInterval(int paramInt)
  {
    this.startInterval = paramInt;
  }
  
  public void setTipsAnim(String paramString)
  {
    this.tipsAnim = paramString;
  }
  
  public void setTipsAnimFrameDuration(int paramInt)
  {
    this.tipsAnimFrameDuration = paramInt;
  }
  
  public void setTipsAnimFrames(int paramInt)
  {
    this.tipsAnimFrames = paramInt;
  }
  
  public static class CosFunGroupItem
  {
    private List<CosFun.CosFunItem> cosFunItems;
    private String loopMode;
    
    public List<CosFun.CosFunItem> getCosFunItems()
    {
      return this.cosFunItems;
    }
    
    public String getLoopMode()
    {
      return this.loopMode;
    }
    
    public void setCosFunItems(List<CosFun.CosFunItem> paramList)
    {
      this.cosFunItems = paramList;
    }
    
    public void setLoopMode(String paramString)
    {
      this.loopMode = paramString;
    }
  }
  
  public static class CosFunItem
  {
    private int backgroundMode1;
    private int backgroundMode2;
    private String crazyFacePath;
    private int duration;
    public String externalTriggerWords;
    private int freezeDuration;
    private int freezeStart;
    private String id;
    private CosFun.PagIndexList pagIndexList;
    private String pagPath;
    private int transDuration;
    private int transReverseDuration;
    private int transReverseStart;
    private int transStart;
    private int triggerType;
    private int waitInterval;
    
    public int getBackgroundMode1()
    {
      return this.backgroundMode1;
    }
    
    public int getBackgroundMode2()
    {
      return this.backgroundMode2;
    }
    
    public String getCrazyFacePath()
    {
      return this.crazyFacePath;
    }
    
    public int getDuration()
    {
      return this.duration;
    }
    
    public int getFreezeDuration()
    {
      return this.freezeDuration;
    }
    
    public int getFreezeStart()
    {
      return this.freezeStart;
    }
    
    public String getId()
    {
      return this.id;
    }
    
    public CosFun.PagIndexList getPagIndexList()
    {
      return this.pagIndexList;
    }
    
    public String getPagPath()
    {
      return this.pagPath;
    }
    
    public int getTransDuration()
    {
      return this.transDuration;
    }
    
    public int getTransReverseDuration()
    {
      return this.transReverseDuration;
    }
    
    public int getTransReverseStart()
    {
      return this.transReverseStart;
    }
    
    public int getTransStart()
    {
      return this.transStart;
    }
    
    public int getTriggerType()
    {
      return this.triggerType;
    }
    
    public int getWaitInterval()
    {
      return this.waitInterval;
    }
    
    public void setBackgroundMode1(int paramInt)
    {
      this.backgroundMode1 = paramInt;
    }
    
    public void setBackgroundMode2(int paramInt)
    {
      this.backgroundMode2 = paramInt;
    }
    
    public void setCrazyFacePath(String paramString)
    {
      this.crazyFacePath = paramString;
    }
    
    public void setDuration(int paramInt)
    {
      this.duration = paramInt;
    }
    
    public void setExternalTriggerWords(String paramString)
    {
      this.externalTriggerWords = paramString;
    }
    
    public void setFreezeDuration(int paramInt)
    {
      this.freezeDuration = paramInt;
    }
    
    public void setFreezeStart(int paramInt)
    {
      this.freezeStart = paramInt;
    }
    
    public void setId(String paramString)
    {
      this.id = paramString;
    }
    
    public void setPagIndexList(CosFun.PagIndexList paramPagIndexList)
    {
      this.pagIndexList = paramPagIndexList;
    }
    
    public void setPagPath(String paramString)
    {
      this.pagPath = paramString;
    }
    
    public void setTransDuration(int paramInt)
    {
      this.transDuration = paramInt;
    }
    
    public void setTransReverseDuration(int paramInt)
    {
      this.transReverseDuration = paramInt;
    }
    
    public void setTransReverseStart(int paramInt)
    {
      this.transReverseStart = paramInt;
    }
    
    public void setTransStart(int paramInt)
    {
      this.transStart = paramInt;
    }
    
    public void setTriggerType(int paramInt)
    {
      this.triggerType = paramInt;
    }
    
    public void setWaitInterval(int paramInt)
    {
      this.waitInterval = paramInt;
    }
  }
  
  public static class PagIndexList
  {
    private List<Integer> cosFun;
    private String freeze;
    
    public List<Integer> getCosFun()
    {
      return this.cosFun;
    }
    
    public String getFreeze()
    {
      return this.freeze;
    }
    
    public void setCosFun(List<Integer> paramList)
    {
      this.cosFun = paramList;
    }
    
    public void setFreeze(String paramString)
    {
      this.freeze = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.cosfun.CosFun
 * JD-Core Version:    0.7.0.1
 */