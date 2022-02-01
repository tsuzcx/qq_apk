package com.tencent.qqmini.sdk.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class GetPageIntAction
  implements Action<Integer>
{
  private static final int GET_NAVIBAR_TEXT_STYLE = 3;
  private static final int GET_NAVIBAR_VISIBILITY = 2;
  private static final int GET_TABBAR_VISIBILITY = 1;
  private int action = -1;
  private IMiniAppContext miniAppContext;
  
  public static GetPageIntAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    GetPageIntAction localGetPageIntAction = new GetPageIntAction();
    localGetPageIntAction.miniAppContext = paramIMiniAppContext;
    return localGetPageIntAction;
  }
  
  public int getNaviBarTextStyle()
  {
    this.action = 3;
    return ((Integer)this.miniAppContext.performAction(this)).intValue();
  }
  
  public int getNaviBarVisibility()
  {
    this.action = 2;
    return ((Integer)this.miniAppContext.performAction(this)).intValue();
  }
  
  public int getTabBarVisibility()
  {
    this.action = 1;
    return ((Integer)this.miniAppContext.performAction(this)).intValue();
  }
  
  public Integer perform(BaseRuntime paramBaseRuntime)
  {
    paramBaseRuntime = paramBaseRuntime.getPage();
    if (paramBaseRuntime == null) {
      return null;
    }
    int i = -1;
    switch (this.action)
    {
    }
    for (;;)
    {
      return Integer.valueOf(i);
      i = paramBaseRuntime.getTabBarVisibility();
      continue;
      i = paramBaseRuntime.getNaviBarVisibility();
      continue;
      i = paramBaseRuntime.getNaviBarTextStyle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.GetPageIntAction
 * JD-Core Version:    0.7.0.1
 */