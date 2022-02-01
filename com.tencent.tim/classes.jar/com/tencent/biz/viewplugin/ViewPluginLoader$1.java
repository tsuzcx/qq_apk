package com.tencent.biz.viewplugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqhq;
import ardq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import jpa;
import ssf;

public class ViewPluginLoader$1
  implements Runnable
{
  public void run()
  {
    String str;
    synchronized (this.this$0.lock)
    {
      str = ssf.a(this.this$0) + this.this$0.mPluginName;
      if (!new File(str).exists())
      {
        this.a.notifyUI(3, true, Integer.valueOf(1));
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = new File(this.this$0.aoF);
        if (!this.this$0.k.getString("sp_key_version_prefix" + this.this$0.mPluginName, "-1").equals(this.this$0.aGf))
        {
          if (!((File)localObject3).exists()) {
            continue;
          }
          aqhq.cn(((File)localObject3).getAbsolutePath());
          this.this$0.k.edit().putString("sp_key_version_prefix" + this.this$0.mPluginName, jpa.dL(this.this$0.mBid)).commit();
          ((File)localObject3).mkdirs();
        }
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        localObject3 = PluginUtils.getPluginLibPath(BaseApplicationImpl.getContext(), this.this$0.mPluginName).getCanonicalPath();
        if (this.this$0.mClassLoader == null) {
          this.this$0.mClassLoader = new DexClassLoader(str, this.this$0.aoF, (String)localObject3, BaseApplicationImpl.getContext().getClassLoader());
        }
        this.this$0.aGh = str;
        if (QLog.isColorLevel()) {
          QLog.i("ViewPluginLoader", 2, "load werewolves local plugin success,path = " + str);
        }
        this.this$0.aMP = true;
        this.a.notifyUI(3, true, Integer.valueOf(0));
      }
      catch (Exception localException)
      {
        Object localObject3;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ViewPluginLoader", 2, "load error msg = " + localException.getMessage(), localException);
        this.a.notifyUI(3, true, Integer.valueOf(3));
        continue;
      }
      return;
      localObject2 = finally;
      throw localObject2;
      ((File)localObject3).mkdirs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.viewplugin.ViewPluginLoader.1
 * JD-Core Version:    0.7.0.1
 */