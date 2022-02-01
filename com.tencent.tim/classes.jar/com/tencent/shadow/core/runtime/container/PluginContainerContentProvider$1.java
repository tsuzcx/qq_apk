package com.tencent.shadow.core.runtime.container;

import android.util.Log;

class PluginContainerContentProvider$1
  implements ContentProviderDelegateProviderHolder.DelegateProviderHolderPrepareListener
{
  PluginContainerContentProvider$1(PluginContainerContentProvider paramPluginContainerContentProvider) {}
  
  public void onPrepare()
  {
    HostContentProviderDelegate localHostContentProviderDelegate;
    if (ContentProviderDelegateProviderHolder.contentProviderDelegateProvider != null)
    {
      localHostContentProviderDelegate = ContentProviderDelegateProviderHolder.contentProviderDelegateProvider.getHostContentProviderDelegate();
      localHostContentProviderDelegate.onCreate();
    }
    for (;;)
    {
      PluginContainerContentProvider.access$002(this.this$0, localHostContentProviderDelegate);
      return;
      Log.e("ContentProvider_", "PluginContainerContentProvider: DelegateProviderHolder没有初始化");
      localHostContentProviderDelegate = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.container.PluginContainerContentProvider.1
 * JD-Core Version:    0.7.0.1
 */