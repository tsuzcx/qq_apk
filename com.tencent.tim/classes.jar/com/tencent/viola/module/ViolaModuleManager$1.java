package com.tencent.viola.module;

import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Map;

final class ViolaModuleManager$1
  implements Runnable
{
  ViolaModuleManager$1(String paramString, boolean paramBoolean, IModuleHolder paramIModuleHolder) {}
  
  public void run()
  {
    if (ViolaModuleManager.access$000().containsKey(this.val$moduleName)) {
      ViolaLogUtils.w("ViolaModuleManager", "Registry Duplicate the Module name: " + this.val$moduleName);
    }
    if (this.val$global) {}
    try
    {
      BaseModule localBaseModule = this.val$holder.buildInstance();
      localBaseModule.setModuleName(this.val$moduleName);
      ViolaModuleManager.sGlobalModuleMap.put(this.val$moduleName, localBaseModule);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          ViolaModuleManager.registerNativeModule(this.val$moduleName, this.val$holder);
          ViolaModuleManager.registerJSModule(this.val$moduleName, this.val$holder);
          return;
          localException1 = localException1;
          ViolaLogUtils.e("ViolaModuleManager", this.val$moduleName + " class must have a default constructor without params. " + localException1);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ViolaLogUtils.e("ViolaModuleManager", localException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.module.ViolaModuleManager.1
 * JD-Core Version:    0.7.0.1
 */