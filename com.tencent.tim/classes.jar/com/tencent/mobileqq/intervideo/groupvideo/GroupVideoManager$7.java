package com.tencent.mobileqq.intervideo.groupvideo;

import aicu;
import aicu.a;
import aida;
import aidq;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import java.util.List;

public final class GroupVideoManager$7
  implements Runnable
{
  public GroupVideoManager$7(String paramString, aicu.a parama) {}
  
  public void run()
  {
    try
    {
      if ("huiyin2".equalsIgnoreCase(this.val$appName)) {}
      for (List localList = new UpgradeablePluginManager(aidq.f(BaseApplicationImpl.getContext()), "huiyin2", aida.aoS()).getCachedLatestPlugin(this.val$appName);; localList = aicu.a().getCachedLatestPlugin(this.val$appName))
      {
        new Handler(Looper.getMainLooper()).post(new GroupVideoManager.7.1(this, localList));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager.7
 * JD-Core Version:    0.7.0.1
 */