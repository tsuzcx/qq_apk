package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;

@MiniKeep
public class PageAction
  implements Action<AppPageInfo>
{
  private static final int GET_APP_PAGE_INFO = 1;
  private int action = 1;
  private int flag;
  private IMiniAppContext miniAppContext;
  
  public static PageAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    PageAction localPageAction = new PageAction();
    localPageAction.miniAppContext = paramIMiniAppContext;
    return localPageAction;
  }
  
  public int getPageId()
  {
    this.action = 1;
    this.flag = 1;
    AppPageInfo localAppPageInfo = (AppPageInfo)this.miniAppContext.performAction(this);
    if (localAppPageInfo != null) {
      return localAppPageInfo.pageId;
    }
    return 0;
  }
  
  public String getPageUrl()
  {
    this.action = 1;
    this.flag = 2;
    AppPageInfo localAppPageInfo = (AppPageInfo)this.miniAppContext.performAction(this);
    if (localAppPageInfo != null) {
      return localAppPageInfo.pageUrl;
    }
    return null;
  }
  
  public int getSurfaceViewHeight()
  {
    this.action = 1;
    this.flag = 32;
    AppPageInfo localAppPageInfo = (AppPageInfo)this.miniAppContext.performAction(this);
    if (localAppPageInfo != null) {
      return localAppPageInfo.surfaceViewHeight;
    }
    return 0;
  }
  
  public int getSurfaceViewWidth()
  {
    this.action = 1;
    this.flag = 16;
    AppPageInfo localAppPageInfo = (AppPageInfo)this.miniAppContext.performAction(this);
    if (localAppPageInfo != null) {
      return localAppPageInfo.surfaceViewWidth;
    }
    return 0;
  }
  
  public int getWindowHeight()
  {
    this.action = 1;
    this.flag = 8;
    AppPageInfo localAppPageInfo = (AppPageInfo)this.miniAppContext.performAction(this);
    if (localAppPageInfo != null) {
      return localAppPageInfo.windowHeight;
    }
    return 0;
  }
  
  public AppPageInfo perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null) {
      return null;
    }
    switch (this.action)
    {
    default: 
      return null;
    }
    return paramBaseRuntime.getPageInfo(this.flag);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.PageAction
 * JD-Core Version:    0.7.0.1
 */