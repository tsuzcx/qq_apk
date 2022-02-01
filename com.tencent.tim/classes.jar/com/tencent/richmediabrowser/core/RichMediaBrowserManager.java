package com.tencent.richmediabrowser.core;

import com.tencent.richmediabrowser.listener.IBrowserAnimationListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserAnimation;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.presenter.IProvider;

public class RichMediaBrowserManager
{
  private IBrowserAnimationListener animationListener;
  private IMvpFactory mvpFactory;
  private IProvider provider;
  
  public static RichMediaBrowserManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public IBrowserAnimationListener getAnimationListener()
  {
    return this.animationListener;
  }
  
  public BrowserAnimation getBrowserAnimation(RichMediaBaseData paramRichMediaBaseData)
  {
    if (this.animationListener != null) {
      return this.animationListener.getBrowserAnimation(paramRichMediaBaseData);
    }
    return null;
  }
  
  public IMvpFactory getMvpFactory()
  {
    return this.mvpFactory;
  }
  
  public IProvider getProvider()
  {
    return this.provider;
  }
  
  public void onDestroy()
  {
    setMvpFactory(null);
    setProvider(null);
    setAnimationListener(null);
    setLogProxy(null);
  }
  
  public void setAnimationListener(IBrowserAnimationListener paramIBrowserAnimationListener)
  {
    this.animationListener = paramIBrowserAnimationListener;
  }
  
  public void setLogProxy(IBrowserLog paramIBrowserLog)
  {
    BrowserLogHelper.getInstance().setLogProxy(paramIBrowserLog);
  }
  
  public void setMvpFactory(IMvpFactory paramIMvpFactory)
  {
    this.mvpFactory = paramIMvpFactory;
  }
  
  public void setProvider(IProvider paramIProvider)
  {
    this.provider = paramIProvider;
  }
  
  static class SingletonHolder
  {
    private static final RichMediaBrowserManager INSTANCE = new RichMediaBrowserManager(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.RichMediaBrowserManager
 * JD-Core Version:    0.7.0.1
 */