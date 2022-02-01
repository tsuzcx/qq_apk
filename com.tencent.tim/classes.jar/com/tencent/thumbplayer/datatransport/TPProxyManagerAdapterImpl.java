package com.tencent.thumbplayer.datatransport;

import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;

public class TPProxyManagerAdapterImpl
  implements ITPProxyManagerAdapter
{
  private ITPDownloadProxy mDownloadProxy;
  
  public TPProxyManagerAdapterImpl(ITPDownloadProxy paramITPDownloadProxy)
  {
    this.mDownloadProxy = paramITPDownloadProxy;
  }
  
  public ITPDownloadProxy getDownloadProxy()
  {
    return this.mDownloadProxy;
  }
  
  public void pushEvent(int paramInt)
  {
    this.mDownloadProxy.pushEvent(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.TPProxyManagerAdapterImpl
 * JD-Core Version:    0.7.0.1
 */