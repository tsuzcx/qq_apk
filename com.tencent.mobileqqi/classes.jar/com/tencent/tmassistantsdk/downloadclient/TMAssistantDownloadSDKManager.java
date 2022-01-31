package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import com.tencent.tmassistantsdk.f.j;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKManager
{
  protected static TMAssistantDownloadSDKManager mInstance = null;
  protected static ArrayList mOpenSDKClientList = new ArrayList();
  protected static ArrayList mSDKClientList = new ArrayList();
  protected static TMAssistantDownloadSDKSettingClient mSDKSettingClient = null;
  protected Context mContext = null;
  
  protected TMAssistantDownloadSDKManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static String about()
  {
    return "TMAssistantDownloadSDKManager_2014_03_04_17_55_release_25406";
  }
  
  public static void closeAllService(Context paramContext)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        j.b("TMAssistantDownloadSDKManager", "closeAllService method!");
        if (mInstance == null)
        {
          j.b("TMAssistantDownloadSDKManager", "manager minstance == null");
          return;
        }
        if ((mSDKClientList != null) && (mSDKClientList.size() > 0))
        {
          localObject = mSDKClientList.iterator();
          if (((Iterator)localObject).hasNext())
          {
            TMAssistantDownloadSDKClient localTMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient)((Iterator)localObject).next();
            if (localTMAssistantDownloadSDKClient == null) {
              continue;
            }
            localTMAssistantDownloadSDKClient.unInitTMAssistantDownloadSDK();
            continue;
          }
          mSDKClientList.clear();
        }
      }
      finally {}
      MobileQQCloseServiceReceiver.a().b(paramContext);
      if (mSDKSettingClient != null)
      {
        mSDKSettingClient.unInitTMAssistantDownloadSDK();
        mSDKSettingClient = null;
      }
      paramContext = mOpenSDKClientList.iterator();
      while (paramContext.hasNext())
      {
        localObject = (c)paramContext.next();
        if (localObject != null) {
          ((c)localObject).unInitTMAssistantDownloadSDK();
        }
      }
      mInstance = null;
    }
  }
  
  public static TMAssistantDownloadSDKManager getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
      {
        mInstance = new TMAssistantDownloadSDKManager(paramContext);
        MobileQQCloseServiceReceiver.a().a(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public c getDownloadOpenSDKClient(String paramString)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = mOpenSDKClientList.iterator();
        if (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          boolean bool = localc.mClientKey.equals(paramString);
          if (bool == true)
          {
            paramString = localc;
            return paramString;
          }
        }
        else
        {
          paramString = new c(this.mContext, paramString, "com.tencent.android.qqdownloader.SDKService");
          if (paramString.initTMAssistantDownloadSDK()) {
            mOpenSDKClientList.add(paramString);
          } else {
            paramString = null;
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public TMAssistantDownloadSDKClient getDownloadSDKClient(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +12 -> 15
    //   6: aload_1
    //   7: invokevirtual 124	java/lang/String:length	()I
    //   10: istore_2
    //   11: iload_2
    //   12: ifgt +9 -> 21
    //   15: aconst_null
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: getstatic 24	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKClientList	Ljava/util/ArrayList;
    //   24: invokevirtual 58	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 64 1 0
    //   36: ifeq +31 -> 67
    //   39: aload 4
    //   41: invokeinterface 68 1 0
    //   46: checkcast 70	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient
    //   49: astore_3
    //   50: aload_3
    //   51: getfield 125	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:mClientKey	Ljava/lang/String;
    //   54: aload_1
    //   55: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: iconst_1
    //   59: if_icmpne -30 -> 29
    //   62: aload_3
    //   63: astore_1
    //   64: goto -47 -> 17
    //   67: new 70	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient
    //   70: dup
    //   71: aload_0
    //   72: getfield 33	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mContext	Landroid/content/Context;
    //   75: aload_1
    //   76: invokespecial 128	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   79: astore_1
    //   80: aload_1
    //   81: invokevirtual 129	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:initTMAssistantDownloadSDK	()Z
    //   84: pop
    //   85: getstatic 24	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKClientList	Ljava/util/ArrayList;
    //   88: aload_1
    //   89: invokevirtual 119	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -76 -> 17
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	TMAssistantDownloadSDKManager
    //   0	101	1	paramString	String
    //   10	2	2	i	int
    //   49	14	3	localTMAssistantDownloadSDKClient	TMAssistantDownloadSDKClient
    //   27	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   6	11	96	finally
    //   21	29	96	finally
    //   29	62	96	finally
    //   67	93	96	finally
  }
  
  public TMAssistantDownloadSDKSettingClient getDownloadSDKSettingClient()
  {
    try
    {
      if (mSDKSettingClient == null)
      {
        localTMAssistantDownloadSDKSettingClient = new TMAssistantDownloadSDKSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
        mSDKSettingClient = localTMAssistantDownloadSDKSettingClient;
        localTMAssistantDownloadSDKSettingClient.initTMAssistantDownloadSDK();
      }
      TMAssistantDownloadSDKSettingClient localTMAssistantDownloadSDKSettingClient = mSDKSettingClient;
      return localTMAssistantDownloadSDKSettingClient;
    }
    finally {}
  }
  
  /* Error */
  public boolean releaseDownloadSDKClient(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 24	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKClientList	Ljava/util/ArrayList;
    //   5: invokevirtual 58	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   8: astore_3
    //   9: aload_3
    //   10: invokeinterface 64 1 0
    //   15: ifeq +49 -> 64
    //   18: aload_3
    //   19: invokeinterface 68 1 0
    //   24: checkcast 70	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull -22 -> 9
    //   34: aload 4
    //   36: getfield 125	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:mClientKey	Ljava/lang/String;
    //   39: aload_1
    //   40: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: iconst_1
    //   44: if_icmpne -35 -> 9
    //   47: aload 4
    //   49: invokevirtual 73	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKClient:unInitTMAssistantDownloadSDK	()V
    //   52: aload_3
    //   53: invokeinterface 138 1 0
    //   58: iconst_1
    //   59: istore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_2
    //   63: ireturn
    //   64: getstatic 26	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   67: ifnull +32 -> 99
    //   70: getstatic 26	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   73: getfield 139	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient:mClientKey	Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: iconst_1
    //   81: if_icmpne +18 -> 99
    //   84: getstatic 26	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   87: invokevirtual 87	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient:unInitTMAssistantDownloadSDK	()V
    //   90: aconst_null
    //   91: putstatic 26	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mSDKSettingClient	Lcom/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKSettingClient;
    //   94: iconst_1
    //   95: istore_2
    //   96: goto -36 -> 60
    //   99: getstatic 28	com/tencent/tmassistantsdk/downloadclient/TMAssistantDownloadSDKManager:mOpenSDKClientList	Ljava/util/ArrayList;
    //   102: invokevirtual 58	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   105: astore_3
    //   106: aload_3
    //   107: invokeinterface 64 1 0
    //   112: ifeq +48 -> 160
    //   115: aload_3
    //   116: invokeinterface 68 1 0
    //   121: checkcast 89	com/tencent/tmassistantsdk/downloadclient/c
    //   124: astore 4
    //   126: aload 4
    //   128: ifnull -22 -> 106
    //   131: aload 4
    //   133: getfield 102	com/tencent/tmassistantsdk/downloadclient/c:mClientKey	Ljava/lang/String;
    //   136: aload_1
    //   137: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   140: iconst_1
    //   141: if_icmpne -35 -> 106
    //   144: aload 4
    //   146: invokevirtual 90	com/tencent/tmassistantsdk/downloadclient/c:unInitTMAssistantDownloadSDK	()V
    //   149: aload_3
    //   150: invokeinterface 138 1 0
    //   155: iconst_1
    //   156: istore_2
    //   157: goto -97 -> 60
    //   160: iconst_0
    //   161: istore_2
    //   162: goto -102 -> 60
    //   165: astore_1
    //   166: aload_0
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	TMAssistantDownloadSDKManager
    //   0	170	1	paramString	String
    //   59	103	2	bool	boolean
    //   8	142	3	localIterator	Iterator
    //   27	118	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	165	finally
    //   9	29	165	finally
    //   34	58	165	finally
    //   64	94	165	finally
    //   99	106	165	finally
    //   106	126	165	finally
    //   131	155	165	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager
 * JD-Core Version:    0.7.0.1
 */