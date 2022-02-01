package com.tencent.qqmini.sdk.launcher.core.model;

public class AppPageInfo
{
  public static final int FLAG_GET_ALL = -1;
  public static final int FLAG_GET_NONE = 0;
  public static final int FLAG_GET_PAGE_ID = 1;
  public static final int FLAG_GET_PAGE_URL = 2;
  public static final int FLAG_GET_PAGE_WINDOW_HEIGHT = 8;
  public static final int FLAG_GET_PAGE_WINDOW_WIDTH = 4;
  public static final int FLAG_GET_SURFACE_VIEW_HEIGHT = 32;
  public static final int FLAG_GET_SURFACE_VIEW_WIDTH = 16;
  public int pageId;
  public String pageUrl;
  public int surfaceViewHeight;
  public int surfaceViewWidth;
  public int windowHeight;
  public int windowWidth;
  
  public static boolean enableGetAll(int paramInt)
  {
    return paramInt == -1;
  }
  
  public static boolean enableGetPageId(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static boolean enableGetPageUrl(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean enableGetPageWindowHeight(int paramInt)
  {
    return (paramInt & 0x8) != 0;
  }
  
  public static boolean enableGetPageWindowWidth(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static class Builder
  {
    private AppPageInfo appPageInfo = new AppPageInfo();
    
    public AppPageInfo build()
    {
      return this.appPageInfo;
    }
    
    public Builder setPageId(int paramInt)
    {
      this.appPageInfo.pageId = paramInt;
      return this;
    }
    
    public Builder setPageUrl(String paramString)
    {
      this.appPageInfo.pageUrl = paramString;
      return this;
    }
    
    public Builder setSurfaceViewHeight(int paramInt)
    {
      this.appPageInfo.surfaceViewHeight = paramInt;
      return this;
    }
    
    public Builder setSurfaceViewWidth(int paramInt)
    {
      this.appPageInfo.surfaceViewWidth = paramInt;
      return this;
    }
    
    public Builder setWindowHeight(int paramInt)
    {
      this.appPageInfo.windowHeight = paramInt;
      return this;
    }
    
    public Builder setWindowWidth(int paramInt)
    {
      this.appPageInfo.windowWidth = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo
 * JD-Core Version:    0.7.0.1
 */