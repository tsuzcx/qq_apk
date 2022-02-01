import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class asvo
{
  public static ArrayList<com.tencent.mobileqq.mini.apkg.ExtConfigInfo> V(ArrayList<com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(a((com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)paramArrayList.next()));
    }
    return localArrayList;
  }
  
  /* Error */
  public static void Vi(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 43
    //   5: iconst_1
    //   6: new 45	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   13: ldc 48
    //   15: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_0
    //   19: invokevirtual 55	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   22: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: iload_0
    //   29: ifeq +60 -> 89
    //   32: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   35: new 45	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   42: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   45: invokevirtual 75	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   48: invokevirtual 80	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   51: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 82
    //   56: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: iconst_4
    //   63: invokevirtual 86	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   66: invokeinterface 92 1 0
    //   71: ldc 94
    //   73: iconst_1
    //   74: invokeinterface 100 3 0
    //   79: invokeinterface 103 1 0
    //   84: pop
    //   85: ldc 2
    //   87: monitorexit
    //   88: return
    //   89: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   92: new 45	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   99: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   102: invokevirtual 75	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   105: invokevirtual 80	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   108: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 82
    //   113: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: iconst_4
    //   120: invokevirtual 86	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   123: invokeinterface 92 1 0
    //   128: ldc 94
    //   130: iconst_0
    //   131: invokeinterface 100 3 0
    //   136: invokeinterface 103 1 0
    //   141: pop
    //   142: goto -57 -> 85
    //   145: astore_1
    //   146: ldc 2
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramBoolean	boolean
    //   145	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	28	145	finally
    //   32	85	145	finally
    //   89	142	145	finally
  }
  
  public static com.tencent.mobileqq.mini.apkg.ExtConfigInfo a(com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo paramExtConfigInfo)
  {
    if (paramExtConfigInfo == null) {
      return null;
    }
    com.tencent.mobileqq.mini.apkg.ExtConfigInfo localExtConfigInfo = new com.tencent.mobileqq.mini.apkg.ExtConfigInfo();
    localExtConfigInfo.configKey = paramExtConfigInfo.configKey;
    localExtConfigInfo.configVersion = paramExtConfigInfo.configVersion;
    Object localObject1;
    Object localObject2;
    if (paramExtConfigInfo.userAuthScopes != null)
    {
      localExtConfigInfo.userAuthScopes = new ArrayList();
      localObject1 = paramExtConfigInfo.userAuthScopes.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.UserAuthScope)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          com.tencent.mobileqq.mini.apkg.UserAuthScope localUserAuthScope = new com.tencent.mobileqq.mini.apkg.UserAuthScope();
          localExtConfigInfo.userAuthScopes.add(localUserAuthScope);
          localUserAuthScope.scope = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).scope;
          localUserAuthScope.authType = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).authType;
          localUserAuthScope.desc = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).desc;
          localUserAuthScope.settingPageTitle = ((com.tencent.qqmini.sdk.launcher.model.UserAuthScope)localObject2).settingPageTitle;
        }
      }
    }
    if (paramExtConfigInfo.apiScopeEntries != null)
    {
      localExtConfigInfo.apiScopeEntries = new ArrayList();
      paramExtConfigInfo = paramExtConfigInfo.apiScopeEntries.iterator();
      while (paramExtConfigInfo.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)paramExtConfigInfo.next();
        if (localObject1 != null)
        {
          localObject2 = new com.tencent.mobileqq.mini.apkg.ApiScopeEntry();
          localExtConfigInfo.apiScopeEntries.add(localObject2);
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).scope = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).scope;
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).eventName = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).eventName;
          ((com.tencent.mobileqq.mini.apkg.ApiScopeEntry)localObject2).apiName = ((com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry)localObject1).apiName;
        }
      }
    }
    return localExtConfigInfo;
  }
  
  public static MiniAppConfig a(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    MiniAppConfig localMiniAppConfig = new MiniAppConfig(convert(paramMiniAppInfo));
    localMiniAppConfig.entryPath = paramMiniAppInfo.launchParam.entryPath;
    localMiniAppConfig.linkType = paramMiniAppInfo.linkType;
    localMiniAppConfig.link = paramMiniAppInfo.link;
    localMiniAppConfig.isFromShowInfo = false;
    localMiniAppConfig.forceReroad = paramMiniAppInfo.forceReroad;
    localMiniAppConfig.launchParam = a(paramMiniAppInfo.launchParam);
    if (paramMiniAppInfo.baseLibInfo != null) {
      localMiniAppConfig.baseLibInfo = new com.tencent.mobileqq.mini.sdk.BaseLibInfo(paramMiniAppInfo.baseLibInfo.baseLibUrl, paramMiniAppInfo.baseLibInfo.baseLibKey, paramMiniAppInfo.baseLibInfo.baseLibVersion, paramMiniAppInfo.baseLibInfo.baseLibDesc, paramMiniAppInfo.baseLibInfo.baseLibType);
    }
    return localMiniAppConfig;
  }
  
  public static com.tencent.mobileqq.mini.sdk.EntryModel a(com.tencent.qqmini.sdk.launcher.model.EntryModel paramEntryModel)
  {
    if (paramEntryModel == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
    localEntryModel.reportData = paramEntryModel.reportData;
    return localEntryModel;
  }
  
  public static com.tencent.mobileqq.mini.sdk.LaunchParam a(com.tencent.qqmini.sdk.launcher.model.LaunchParam paramLaunchParam)
  {
    if (paramLaunchParam == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.LaunchParam localLaunchParam = new com.tencent.mobileqq.mini.sdk.LaunchParam();
    localLaunchParam.scene = paramLaunchParam.scene;
    localLaunchParam.miniAppId = paramLaunchParam.miniAppId;
    localLaunchParam.extraKey = paramLaunchParam.extraKey;
    localLaunchParam.entryPath = paramLaunchParam.entryPath;
    localLaunchParam.navigateExtData = paramLaunchParam.navigateExtData;
    localLaunchParam.fromMiniAppId = paramLaunchParam.fromMiniAppId;
    localLaunchParam.launchClickTimeMillis = paramLaunchParam.launchClickTimeMillis;
    localLaunchParam.tempState = paramLaunchParam.tempState;
    localLaunchParam.timestamp = paramLaunchParam.timestamp;
    localLaunchParam.shareTicket = paramLaunchParam.shareTicket;
    localLaunchParam.envVersion = paramLaunchParam.envVersion;
    localLaunchParam.reportData = paramLaunchParam.reportData;
    localLaunchParam.extendData = paramLaunchParam.extendData;
    localLaunchParam.entryModel = b(paramLaunchParam.entryModel);
    localLaunchParam.fromBackToMiniApp = paramLaunchParam.fromBackToMiniApp;
    return localLaunchParam;
  }
  
  /* Error */
  public static boolean aIH()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8: new 45	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   15: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: invokevirtual 75	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   21: invokevirtual 80	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   24: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 82
    //   29: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: iconst_4
    //   36: invokevirtual 86	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   39: ldc 94
    //   41: iconst_m1
    //   42: invokeinterface 328 3 0
    //   47: istore_0
    //   48: iload_0
    //   49: iconst_1
    //   50: if_icmpne +8 -> 58
    //   53: ldc 2
    //   55: monitorexit
    //   56: iload_1
    //   57: ireturn
    //   58: iconst_0
    //   59: istore_1
    //   60: goto -7 -> 53
    //   63: astore_2
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	4	0	i	int
    //   1	59	1	bool	boolean
    //   63	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	48	63	finally
  }
  
  public static boolean aII()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_minigame_", 4).getBoolean("_minigame_enable_jank_canary_brief", false);
  }
  
  public static com.tencent.mobileqq.mini.sdk.EntryModel b(com.tencent.qqmini.sdk.launcher.model.EntryModel paramEntryModel)
  {
    if (paramEntryModel == null) {
      return null;
    }
    com.tencent.mobileqq.mini.sdk.EntryModel localEntryModel = new com.tencent.mobileqq.mini.sdk.EntryModel(paramEntryModel.type, paramEntryModel.uin, paramEntryModel.name, paramEntryModel.isAdmin);
    localEntryModel.reportData = paramEntryModel.reportData;
    return localEntryModel;
  }
  
  public static boolean bG(boolean paramBoolean)
  {
    return true;
  }
  
  public static com.tencent.mobileqq.mini.apkg.MiniAppInfo convert(com.tencent.qqmini.sdk.launcher.model.MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    com.tencent.mobileqq.mini.apkg.MiniAppInfo localMiniAppInfo = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
    localMiniAppInfo.topType = paramMiniAppInfo.topType;
    localMiniAppInfo.extraData = paramMiniAppInfo.extraData;
    localMiniAppInfo.recommend = paramMiniAppInfo.recommend;
    localMiniAppInfo.isSupportOffline = paramMiniAppInfo.isSupportOffline;
    localMiniAppInfo.openId = paramMiniAppInfo.openId;
    localMiniAppInfo.tinyId = paramMiniAppInfo.tinyId;
    localMiniAppInfo.position = paramMiniAppInfo.position;
    localMiniAppInfo.isSupportBlueBar = paramMiniAppInfo.isSupportBlueBar;
    localMiniAppInfo.recommendAppIconUrl = paramMiniAppInfo.recommendAppIconUrl;
    localMiniAppInfo.extendData = paramMiniAppInfo.extendData;
    localMiniAppInfo.clearAuths = paramMiniAppInfo.clearAuths;
    localMiniAppInfo.appStoreAnimPicUrl = paramMiniAppInfo.appStoreAnimPicUrl;
    localMiniAppInfo.setEngineType(paramMiniAppInfo.getEngineType());
    localMiniAppInfo.setReportType(paramMiniAppInfo.getReportType());
    if (paramMiniAppInfo.commonExt != null)
    {
      localMiniAppInfo.commonExt = new byte[paramMiniAppInfo.commonExt.length];
      System.arraycopy(paramMiniAppInfo.commonExt, 0, localMiniAppInfo.commonExt, 0, paramMiniAppInfo.commonExt.length);
    }
    Object localObject1;
    Object localObject2;
    if (paramMiniAppInfo.motionPics != null)
    {
      localMiniAppInfo.motionPics = new ArrayList();
      localObject1 = paramMiniAppInfo.motionPics.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localMiniAppInfo.motionPics.add(localObject2);
      }
    }
    if (paramMiniAppInfo.extConfigInfoList != null)
    {
      localMiniAppInfo.extConfigInfoList = new ArrayList();
      localObject1 = paramMiniAppInfo.extConfigInfoList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)((Iterator)localObject1).next();
        localMiniAppInfo.extConfigInfoList.add(a((com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo)localObject2));
      }
    }
    if (paramMiniAppInfo.preCacheList != null)
    {
      localMiniAppInfo.preCacheList = new ArrayList();
      localObject1 = paramMiniAppInfo.preCacheList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)((Iterator)localObject1).next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.PreCacheInfo(((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).getDataUrl, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).preCacheKey, ((com.tencent.qqmini.sdk.launcher.model.PreCacheInfo)localObject2).expireTime, 0, 0);
        localMiniAppInfo.preCacheList.add(localObject2);
      }
    }
    localMiniAppInfo.appId = paramMiniAppInfo.appId;
    localMiniAppInfo.name = paramMiniAppInfo.name;
    localMiniAppInfo.iconUrl = paramMiniAppInfo.iconUrl;
    localMiniAppInfo.downloadUrl = paramMiniAppInfo.downloadUrl;
    localMiniAppInfo.version = paramMiniAppInfo.version;
    localMiniAppInfo.versionId = paramMiniAppInfo.versionId;
    localMiniAppInfo.desc = paramMiniAppInfo.desc;
    localMiniAppInfo.verType = paramMiniAppInfo.verType;
    localMiniAppInfo.timestamp = paramMiniAppInfo.timestamp;
    localMiniAppInfo.baselibMiniVersion = paramMiniAppInfo.baselibMiniVersion;
    localMiniAppInfo.fileSize = paramMiniAppInfo.fileSize;
    localMiniAppInfo.developerDesc = paramMiniAppInfo.developerDesc;
    localMiniAppInfo.skipDomainCheck = paramMiniAppInfo.skipDomainCheck;
    localMiniAppInfo.usrFileSizeLimit = paramMiniAppInfo.usrFileSizeLimit;
    localMiniAppInfo.noNeedRealRecommend = paramMiniAppInfo.noNeedRealRecommend;
    localMiniAppInfo.versionUpdateTime = paramMiniAppInfo.versionUpdateTime;
    localMiniAppInfo.engineType = paramMiniAppInfo.engineType;
    localMiniAppInfo.shareId = paramMiniAppInfo.shareId;
    localMiniAppInfo.via = paramMiniAppInfo.via;
    if (paramMiniAppInfo.whiteList != null)
    {
      localMiniAppInfo.whiteList = new ArrayList();
      localMiniAppInfo.whiteList.addAll(paramMiniAppInfo.whiteList);
    }
    if (paramMiniAppInfo.blackList != null)
    {
      localMiniAppInfo.blackList = new ArrayList();
      localMiniAppInfo.blackList.addAll(paramMiniAppInfo.blackList);
    }
    if (paramMiniAppInfo.requestDomainList != null)
    {
      localMiniAppInfo.requestDomainList = new ArrayList();
      localMiniAppInfo.requestDomainList.addAll(paramMiniAppInfo.requestDomainList);
    }
    if (paramMiniAppInfo.socketDomainList != null)
    {
      localMiniAppInfo.socketDomainList = new ArrayList();
      localMiniAppInfo.socketDomainList.addAll(paramMiniAppInfo.socketDomainList);
    }
    if (paramMiniAppInfo.uploadFileDomainList != null)
    {
      localMiniAppInfo.uploadFileDomainList = new ArrayList();
      localMiniAppInfo.uploadFileDomainList.addAll(paramMiniAppInfo.uploadFileDomainList);
    }
    if (paramMiniAppInfo.downloadFileDomainList != null)
    {
      localMiniAppInfo.downloadFileDomainList = new ArrayList();
      localMiniAppInfo.downloadFileDomainList.addAll(paramMiniAppInfo.downloadFileDomainList);
    }
    if (paramMiniAppInfo.businessDomainList != null)
    {
      localMiniAppInfo.businessDomainList = new ArrayList();
      localMiniAppInfo.businessDomainList.addAll(paramMiniAppInfo.businessDomainList);
    }
    if (paramMiniAppInfo.udpIpList != null) {
      localMiniAppInfo.udpIpList.addAll(paramMiniAppInfo.udpIpList);
    }
    if (paramMiniAppInfo.debugInfo != null)
    {
      localMiniAppInfo.debugInfo = new com.tencent.mobileqq.mini.apkg.DebugInfo();
      localMiniAppInfo.debugInfo.roomId = paramMiniAppInfo.debugInfo.roomId;
      localMiniAppInfo.debugInfo.wsUrl = paramMiniAppInfo.debugInfo.wsUrl;
    }
    if (paramMiniAppInfo.subpkgs != null)
    {
      localMiniAppInfo.subpkgs = new ArrayList();
      paramMiniAppInfo = paramMiniAppInfo.subpkgs.iterator();
      while (paramMiniAppInfo.hasNext())
      {
        localObject1 = (com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)paramMiniAppInfo.next();
        localObject2 = new com.tencent.mobileqq.mini.apkg.SubPkgInfo();
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).downloadUrl = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).downloadUrl;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).fileSize = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).fileSize;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).independent = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).independent;
        ((com.tencent.mobileqq.mini.apkg.SubPkgInfo)localObject2).subPkgName = ((com.tencent.qqmini.sdk.launcher.model.SubPkgInfo)localObject1).subPkgName;
        localMiniAppInfo.subpkgs.add(localObject2);
      }
    }
    return localMiniAppInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asvo
 * JD-Core Version:    0.7.0.1
 */