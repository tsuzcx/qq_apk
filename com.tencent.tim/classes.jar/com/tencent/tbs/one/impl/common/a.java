package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;

public final class a
{
  public static TBSOneRuntimeExtension a(Context paramContext, String paramString)
  {
    paramContext = TBSOneManager.getInstance(paramContext, paramString).getLoadedComponent("extension");
    if ((paramContext != null) && ((paramContext.getEntryObject() instanceof TBSOneRuntimeExtension))) {
      return (TBSOneRuntimeExtension)paramContext.getEntryObject();
    }
    return null;
  }
  
  public static TBSOneRuntimeExtension a(Context paramContext, String paramString, boolean paramBoolean)
    throws TBSOneException
  {
    TBSOneManager localTBSOneManager = TBSOneManager.getInstance(paramContext, paramString);
    Object localObject2 = localTBSOneManager.getLoadedComponent("extension");
    Object localObject1 = localObject2;
    if ((localObject2 != null) || (paramBoolean)) {}
    for (;;)
    {
      try
      {
        localObject1 = f.c(f.a(paramContext.getDir("tbs", 0), paramString));
        localObject2 = new Bundle();
        ((Bundle)localObject2).putSerializable("deps", d.a((File)localObject1));
        ((Bundle)localObject2).putInt("time_out", 30000);
        localObject1 = TBSOneManager.getInstance(paramContext, paramString).loadComponentSync("extension", (Bundle)localObject2, 30000L);
        if (localObject1 != null) {
          break;
        }
        throw new TBSOneException(509, "Failed to load runtime extension, unexpected nullpointer return");
      }
      catch (TBSOneException paramContext)
      {
        throw new TBSOneException(503, "Failed to load runtime extension, error: [" + paramContext.getErrorCode() + "] " + paramContext.getMessage(), paramContext.getCause());
      }
      localObject1 = localTBSOneManager.loadComponentSync("extension", 30000L);
    }
    if (!(((TBSOneComponent)localObject1).getEntryObject() instanceof TBSOneRuntimeExtension)) {
      throw new TBSOneException(504, "Failed to cast the entry object of runtime extension");
    }
    return (TBSOneRuntimeExtension)((TBSOneComponent)localObject1).getEntryObject();
  }
  
  public static void a(Context paramContext, TBSOneCallback<TBSOneDebugPlugin> paramTBSOneCallback)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_ignore_flow_control_suggestion", true);
    localBundle.putBoolean("is_ignore_wifi_state", true);
    TBSOneManager.getInstance(paramContext, "debug").loadComponentAsync("debugger", localBundle, new a.1(paramTBSOneCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.a
 * JD-Core Version:    0.7.0.1
 */