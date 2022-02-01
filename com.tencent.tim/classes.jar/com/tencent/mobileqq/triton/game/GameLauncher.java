package com.tencent.mobileqq.triton.game;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.bridge.TTJSBridge;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.callback.GameLaunchCallback;
import com.tencent.mobileqq.triton.sdk.game.GamePluginInfo;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.mobileqq.triton.sdk.statics.EngineInitStatistic;
import com.tencent.mobileqq.triton.sdk.statics.FirstRenderStatistic;
import com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic;
import com.tencent.mobileqq.triton.sdk.statics.NativeLibraryLoadStatistic;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadResult;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadStatics;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameLauncher
  implements IGameLauncher
{
  private static Map<String, String> k = new HashMap();
  private final Map<String, GamePluginInfo> a = new HashMap();
  private final ArrayList<ScriptLoadStatics> b = new ArrayList();
  private TTEngine c;
  private TTJSBridge d;
  private MiniGameInfo e;
  private long f;
  private volatile EngineInitStatistic g;
  private GameLaunchCallback h;
  private Runnable i;
  private String j;
  
  public GameLauncher(TTEngine paramTTEngine, TTJSBridge paramTTJSBridge, String paramString)
  {
    this.c = paramTTEngine;
    this.d = paramTTJSBridge;
    this.j = paramString;
  }
  
  private void a(MiniGameInfo paramMiniGameInfo)
  {
    if (paramMiniGameInfo == null) {
      return;
    }
    TTLog.c("GameLauncher", "launch game [" + paramMiniGameInfo.gameId + "] mainContext");
    String str = paramMiniGameInfo.getGamePath() + File.separator + "game.js";
    File localFile = new File(str);
    if (!localFile.exists())
    {
      TTLog.b("GameLauncher", "launch game [" + paramMiniGameInfo.gameId + "] fail, missing game.js");
      return;
    }
    this.b.add(this.c.a(1, localFile.getAbsolutePath(), getGameDebugPath(str), localFile.getAbsolutePath() + ".cc"));
  }
  
  private static boolean a(List<ScriptLoadStatics> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
    } while (((ScriptLoadStatics)paramList.next()).loadResult.isSuccess());
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static Map<String, String> b()
  {
    return k;
  }
  
  private void b(MiniGameInfo paramMiniGameInfo)
  {
    if (paramMiniGameInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramMiniGameInfo.openDataPath))
    {
      TTLog.c("GameLauncher", "launch game [" + paramMiniGameInfo.gameId + "] openDataContext abort, 游戏未配置开放域");
      return;
    }
    TTLog.c("GameLauncher", "launch game [" + paramMiniGameInfo.gameId + "] openDataContext");
    String str = paramMiniGameInfo.gameId;
    Object localObject = paramMiniGameInfo.openDataPath;
    localObject = new File(paramMiniGameInfo.getGamePath() + File.separator + (String)localObject + File.separator + "index.js");
    paramMiniGameInfo = new File(paramMiniGameInfo.getGamePath() + File.separator + "subContext.js");
    if (((File)localObject).exists())
    {
      TTLog.c("GameLauncher", "launch  game [" + str + "] openData from openDataContext/index.js");
      paramMiniGameInfo = (MiniGameInfo)localObject;
    }
    for (;;)
    {
      paramMiniGameInfo = this.c.a(2, paramMiniGameInfo.getAbsolutePath(), getGameDebugPath(paramMiniGameInfo.getAbsolutePath()), paramMiniGameInfo.getAbsolutePath() + ".cc");
      this.b.add(paramMiniGameInfo);
      if (paramMiniGameInfo.loadResult.isSuccess()) {
        break;
      }
      TTLog.b("GameLauncher", "launch  game [" + str + "] openData fail, loadResult:" + paramMiniGameInfo.loadResult);
      return;
      if (!paramMiniGameInfo.exists()) {
        break label353;
      }
      TTLog.c("GameLauncher", "launch  game [" + str + "] openData from subContext.js");
    }
    label353:
    TTLog.b("GameLauncher", "launch  game [" + str + "] openData fail,  no entry openData js file");
  }
  
  private void c(MiniGameInfo paramMiniGameInfo)
  {
    this.e = paramMiniGameInfo;
    this.a.clear();
    if (paramMiniGameInfo != null)
    {
      paramMiniGameInfo = paramMiniGameInfo.gamePluginInfo;
      if (paramMiniGameInfo != null)
      {
        paramMiniGameInfo = paramMiniGameInfo.iterator();
        while (paramMiniGameInfo.hasNext())
        {
          GamePluginInfo localGamePluginInfo = (GamePluginInfo)paramMiniGameInfo.next();
          this.a.put(localGamePluginInfo.name, localGamePluginInfo);
        }
      }
    }
    k.clear();
  }
  
  public GamePluginInfo a(String paramString)
  {
    return (GamePluginInfo)this.a.get(paramString);
  }
  
  public void a()
  {
    this.h.onFirstRender(new FirstRenderStatistic(SystemClock.uptimeMillis() - this.f, this.c.getCurrentDrawCount()));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ArrayList<ScriptLoadStatics> paramArrayList, ArrayList<NativeLibraryLoadStatistic> paramArrayList1)
  {
    for (;;)
    {
      boolean bool2;
      try
      {
        bool2 = a(paramArrayList);
        boolean bool1;
        if ((bool2) && (paramInt == 0))
        {
          bool1 = true;
          break label95;
          this.g = new EngineInitStatistic(bool1, paramInt, paramLong1, paramLong2, paramLong3, paramLong4, paramArrayList, paramArrayList1);
          paramArrayList = this.i;
          if (paramArrayList != null)
          {
            paramArrayList.run();
            this.i = null;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
      paramInt = 1005;
      continue;
      label95:
      if (!bool2) {}
    }
  }
  
  public void a(long paramLong, @NonNull List<ScriptLoadStatics> paramList)
  {
    this.f = SystemClock.uptimeMillis();
    GameLaunchCallback localGameLaunchCallback = this.h;
    if ((a(paramList)) && (this.g.success)) {}
    for (boolean bool = true;; bool = false)
    {
      localGameLaunchCallback.onGameLaunched(new GameLaunchStatistic(bool, paramLong, paramList, this.g));
      this.g = null;
      return;
    }
  }
  
  @TTNativeCall
  public String getBaseEnginePath()
  {
    return this.j;
  }
  
  public MiniGameInfo getCurrentGame()
  {
    return this.e;
  }
  
  @TTNativeCall
  public String getGameConfig(String paramString)
  {
    return this.c.l().getGameConfig(this.c.j(), paramString);
  }
  
  @TTNativeCall
  public String getGameDebugPath(String paramString)
  {
    Object localObject = this.c.j();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((MiniGameInfo)localObject).getGamePath())
    {
      String str = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          str = paramString;
          if (paramString.startsWith((String)localObject))
          {
            paramString = paramString.substring(((String)localObject).length());
            str = "/game" + paramString;
          }
        }
      }
      return str;
    }
  }
  
  @TTNativeCall
  public String getGamePluginDebugPath(String paramString)
  {
    String str = null;
    if (this.c.getGameLauncher() != null) {}
    for (paramString = this.c.getGameLauncher().a(paramString);; paramString = null)
    {
      if (paramString != null) {
        str = "/game_plugin/" + paramString.name + "/" + paramString.version + "/plugin.js";
      }
      return str;
    }
  }
  
  @TTNativeCall
  public String getGamePluginId(String paramString)
  {
    String str = null;
    if (this.c.getGameLauncher() != null) {}
    for (paramString = this.c.getGameLauncher().a(paramString);; paramString = null)
    {
      if (paramString != null) {
        str = paramString.id;
      }
      return str;
    }
  }
  
  @TTNativeCall
  public String getGamePluginPath(String paramString)
  {
    String str = null;
    if (this.c.getGameLauncher() != null) {}
    for (paramString = this.c.getGameLauncher().a(paramString);; paramString = null)
    {
      if (paramString != null) {
        str = paramString.path;
      }
      return str;
    }
  }
  
  @TTNativeCall
  public String getResPath(String paramString1, String paramString2)
  {
    String str = paramString1 + "_" + paramString2;
    if (!k.containsKey(str))
    {
      if (this.c.getGameLauncher() != null) {}
      for (Object localObject = this.c.getGameLauncher().getCurrentGame();; localObject = null)
      {
        localObject = this.c.l().getResPath(paramString1, paramString2, (MiniGameInfo)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k.put(str, localObject);
          TTLog.a("GameLauncher", "getResPath() name:" + paramString1 + ",type:" + paramString2 + ",resPath:" + (String)localObject);
        }
        return localObject;
      }
    }
    return (String)k.get(str);
  }
  
  @TTNativeCall
  public String getTmpFilePath(String paramString)
  {
    if (!k.containsKey(paramString))
    {
      String str = this.c.l().getTmpFilePath(this.c.j(), paramString);
      if (!TextUtils.isEmpty(str))
      {
        k.put(paramString, str);
        TTLog.a("GameRender", "getTmpFilePath() path:" + paramString + ", resPath:" + str);
      }
      return str;
    }
    return (String)k.get(paramString);
  }
  
  /* Error */
  public void launchGame(@NonNull com.tencent.mobileqq.triton.sdk.game.GameLaunchParam paramGameLaunchParam)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 373	com/tencent/mobileqq/triton/game/GameLauncher$a
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 376	com/tencent/mobileqq/triton/game/GameLauncher$a:<init>	(Lcom/tencent/mobileqq/triton/game/GameLauncher;Lcom/tencent/mobileqq/triton/sdk/game/GameLaunchParam;)V
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 198	com/tencent/mobileqq/triton/game/GameLauncher:g	Lcom/tencent/mobileqq/triton/sdk/statics/EngineInitStatistic;
    //   16: ifnonnull +11 -> 27
    //   19: aload_0
    //   20: aload_1
    //   21: putfield 260	com/tencent/mobileqq/triton/game/GameLauncher:i	Ljava/lang/Runnable;
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_1
    //   28: invokeinterface 265 1 0
    //   33: goto -9 -> 24
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	GameLauncher
    //   0	41	1	paramGameLaunchParam	com.tencent.mobileqq.triton.sdk.game.GameLaunchParam
    // Exception table:
    //   from	to	target	type
    //   2	24	36	finally
    //   27	33	36	finally
  }
  
  public ScriptLoadResult launchSubpackage(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return ScriptLoadResult.FAIL_READ_SCRIPT;
    }
    MiniGameInfo localMiniGameInfo = this.c.j();
    this.c.l().reportDC04266(1009, null);
    Object localObject = paramString;
    String str;
    if (!paramString.endsWith(".js"))
    {
      localObject = new StringBuilder().append(paramString);
      if (paramString.endsWith(File.separator))
      {
        paramString = "";
        localObject = paramString + "game.js";
      }
    }
    else
    {
      TTLog.c("GameLauncher[subpackage]", "try loadSubPackageEnter subPath:" + (String)localObject);
      str = localMiniGameInfo.getGamePath() + File.separator + (String)localObject;
      if (!new File(str).exists()) {
        break label239;
      }
      paramString = (String)localObject;
      localObject = str;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
      {
        localObject = new File((String)localObject);
        if (((File)localObject).length() == 0L)
        {
          TTLog.c("GameLauncher[subpackage]", "分包入口文件为空文件, entryPath:" + paramString);
          return ScriptLoadResult.SUCCESS_WITHOUT_CACHE;
          paramString = File.separator;
          break;
          label239:
          paramString = (String)localObject;
          if (!str.endsWith("game.js"))
          {
            str = ((String)localObject).substring(0, ((String)localObject).lastIndexOf("/") + 1) + "game.js";
            localObject = localMiniGameInfo.getGamePath() + File.separator + str;
            paramString = str;
            if (new File((String)localObject).exists())
            {
              TTLog.d("GameLauncher[subpackage]", "config entry file not found, switch entryPath to:" + str);
              paramString = str;
              continue;
            }
          }
          localObject = null;
          continue;
        }
        localObject = this.c.a(1, ((File)localObject).getAbsolutePath(), this.c.getGameLauncher().getGameDebugPath(((File)localObject).getAbsolutePath()), ((File)localObject).getAbsolutePath() + ".cc");
        this.b.add(localObject);
        if (((ScriptLoadStatics)localObject).loadResult.isSuccess()) {
          this.c.l().reportDC04266(1010, null);
        }
        for (;;)
        {
          return ((ScriptLoadStatics)localObject).loadResult;
          TTLog.b("GameLauncher[subpackage]", "加载分包的启动js失败, loadResult:" + ((ScriptLoadStatics)localObject).loadResult + ", entryPath:" + paramString);
        }
      }
    }
    TTLog.b("GameLauncher[subpackage]", "加载分包的启动js失败, entryPath file not found:" + paramString);
    return ScriptLoadResult.FAIL_READ_SCRIPT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher
 * JD-Core Version:    0.7.0.1
 */