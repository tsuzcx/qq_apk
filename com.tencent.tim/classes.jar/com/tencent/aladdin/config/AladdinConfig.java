package com.tencent.aladdin.config;

import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import com.tencent.aladdin.config.parse.AladdinConfigBean;
import com.tencent.aladdin.config.parse.AladdinConfigParser;
import com.tencent.aladdin.config.utils.Log;
import java.io.File;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AladdinConfig
{
  private static final String TAG = "AladdinConfig";
  private final AsyncTaskExecutor asyncTaskExecutor;
  private final File mBackupFile;
  private final int mConfigId;
  private final File mFile;
  private final Object mFileLock = new Object();
  @GuardedBy("mLock")
  private boolean mLoaded = false;
  private final Object mLock = new Object();
  @GuardedBy("mLock")
  private Map<String, ?> mMap = null;
  private final AladdinConfigParser mParser;
  
  AladdinConfig(@NonNull String paramString, int paramInt, @NonNull AsyncTaskExecutor paramAsyncTaskExecutor, @NonNull AladdinConfigParser paramAladdinConfigParser)
  {
    Log.d("AladdinConfig", "AladdinConfig: construct");
    this.mConfigId = paramInt;
    this.mFile = new File(paramString);
    this.mBackupFile = new File(paramString + ".backup");
    this.asyncTaskExecutor = paramAsyncTaskExecutor;
    this.mParser = paramAladdinConfigParser;
    startLoadFromDisk();
  }
  
  private void awaitLoadedLocked()
  {
    while (!this.mLoaded) {
      try
      {
        this.mLock.wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  /* Error */
  private void loadFromDisk()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 8
    //   5: new 60	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   12: ldc 100
    //   14: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   21: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   34: astore_3
    //   35: aload_3
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 39	com/tencent/aladdin/config/AladdinConfig:mLoaded	Z
    //   41: ifeq +33 -> 74
    //   44: ldc 8
    //   46: new 60	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   53: ldc 105
    //   55: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   62: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_3
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: getfield 73	com/tencent/aladdin/config/AladdinConfig:mBackupFile	Ljava/io/File;
    //   78: invokevirtual 109	java/io/File:exists	()Z
    //   81: ifeq +56 -> 137
    //   84: aload_0
    //   85: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   88: invokevirtual 112	java/io/File:delete	()Z
    //   91: istore_1
    //   92: aload_0
    //   93: getfield 73	com/tencent/aladdin/config/AladdinConfig:mBackupFile	Ljava/io/File;
    //   96: aload_0
    //   97: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   100: invokevirtual 116	java/io/File:renameTo	(Ljava/io/File;)Z
    //   103: istore_2
    //   104: ldc 8
    //   106: new 60	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   113: ldc 118
    //   115: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload_1
    //   119: invokevirtual 121	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   122: ldc 123
    //   124: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload_2
    //   128: invokevirtual 121	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   131: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 126	com/tencent/aladdin/config/utils/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_3
    //   138: monitorexit
    //   139: aload_0
    //   140: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   143: invokevirtual 109	java/io/File:exists	()Z
    //   146: ifeq +385 -> 531
    //   149: new 128	java/io/FileReader
    //   152: dup
    //   153: aload_0
    //   154: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   157: invokespecial 131	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   160: astore 4
    //   162: aload 4
    //   164: astore 5
    //   166: aload_0
    //   167: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   170: astore 7
    //   172: aload 4
    //   174: astore 5
    //   176: aload 7
    //   178: monitorenter
    //   179: aload_0
    //   180: getfield 77	com/tencent/aladdin/config/AladdinConfig:mParser	Lcom/tencent/aladdin/config/parse/AladdinConfigParser;
    //   183: aload 4
    //   185: invokeinterface 137 2 0
    //   190: astore_3
    //   191: aload_3
    //   192: astore 6
    //   194: aload 7
    //   196: monitorexit
    //   197: aload_3
    //   198: astore 6
    //   200: aload 4
    //   202: astore 5
    //   204: aload 4
    //   206: invokevirtual 140	java/io/FileReader:close	()V
    //   209: aload_3
    //   210: astore 5
    //   212: aload 4
    //   214: ifnull +11 -> 225
    //   217: aload 4
    //   219: invokevirtual 140	java/io/FileReader:close	()V
    //   222: aload_3
    //   223: astore 5
    //   225: aload_0
    //   226: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   229: astore_3
    //   230: aload_3
    //   231: monitorenter
    //   232: aload_0
    //   233: iconst_1
    //   234: putfield 39	com/tencent/aladdin/config/AladdinConfig:mLoaded	Z
    //   237: aload 5
    //   239: ifnull +514 -> 753
    //   242: aload_0
    //   243: aload 5
    //   245: putfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   248: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   251: ifeq +45 -> 296
    //   254: ldc 8
    //   256: new 60	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   263: ldc 145
    //   265: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 58	com/tencent/aladdin/config/AladdinConfig:mFile	Ljava/io/File;
    //   272: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   275: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 150
    //   280: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_0
    //   284: getfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   287: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_0
    //   297: getfield 35	com/tencent/aladdin/config/AladdinConfig:mLock	Ljava/lang/Object;
    //   300: invokevirtual 156	java/lang/Object:notifyAll	()V
    //   303: aload_3
    //   304: monitorexit
    //   305: return
    //   306: astore 4
    //   308: aload_3
    //   309: monitorexit
    //   310: aload 4
    //   312: athrow
    //   313: astore 4
    //   315: aload_3
    //   316: monitorexit
    //   317: aload 4
    //   319: athrow
    //   320: astore_3
    //   321: aload 7
    //   323: monitorexit
    //   324: aload 4
    //   326: astore 5
    //   328: aload_3
    //   329: athrow
    //   330: astore 5
    //   332: aload 6
    //   334: astore_3
    //   335: aload 5
    //   337: astore 6
    //   339: aload 4
    //   341: astore 5
    //   343: ldc 8
    //   345: new 60	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   352: ldc 100
    //   354: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_0
    //   358: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   361: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: ldc 158
    //   366: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload 6
    //   371: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   374: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 164	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 4
    //   385: astore 5
    //   387: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   390: ifeq +36 -> 426
    //   393: aload 4
    //   395: astore 5
    //   397: ldc 8
    //   399: new 60	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   406: ldc 100
    //   408: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_0
    //   412: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   415: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: aload 6
    //   423: invokestatic 167	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   426: aload_3
    //   427: astore 5
    //   429: aload 4
    //   431: ifnull -206 -> 225
    //   434: aload 4
    //   436: invokevirtual 140	java/io/FileReader:close	()V
    //   439: aload_3
    //   440: astore 5
    //   442: goto -217 -> 225
    //   445: astore 4
    //   447: ldc 8
    //   449: new 60	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   456: ldc 100
    //   458: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_0
    //   462: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   465: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: ldc 158
    //   470: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 4
    //   475: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   478: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 164	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: aload_3
    //   488: astore 5
    //   490: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   493: ifeq -268 -> 225
    //   496: ldc 8
    //   498: new 60	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   505: ldc 100
    //   507: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_0
    //   511: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   514: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: aload 4
    //   522: invokestatic 167	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   525: aload_3
    //   526: astore 5
    //   528: goto -303 -> 225
    //   531: ldc 8
    //   533: new 60	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   540: ldc 169
    //   542: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload_0
    //   546: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   549: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   552: ldc 171
    //   554: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 49	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: aconst_null
    //   564: astore 4
    //   566: aconst_null
    //   567: astore_3
    //   568: goto -359 -> 209
    //   571: astore 4
    //   573: ldc 8
    //   575: new 60	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   582: ldc 100
    //   584: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload_0
    //   588: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   591: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: ldc 158
    //   596: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload 4
    //   601: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   604: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 164	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: aload_3
    //   614: astore 5
    //   616: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   619: ifeq -394 -> 225
    //   622: ldc 8
    //   624: new 60	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   631: ldc 100
    //   633: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_0
    //   637: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   640: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: aload 4
    //   648: invokestatic 167	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   651: aload_3
    //   652: astore 5
    //   654: goto -429 -> 225
    //   657: astore_3
    //   658: aconst_null
    //   659: astore 5
    //   661: aload 5
    //   663: ifnull +8 -> 671
    //   666: aload 5
    //   668: invokevirtual 140	java/io/FileReader:close	()V
    //   671: aload_3
    //   672: athrow
    //   673: astore 4
    //   675: ldc 8
    //   677: new 60	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   684: ldc 100
    //   686: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_0
    //   690: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   693: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: ldc 158
    //   698: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload 4
    //   703: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   706: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokestatic 164	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   715: invokestatic 143	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   718: ifeq -47 -> 671
    //   721: ldc 8
    //   723: new 60	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   730: ldc 100
    //   732: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_0
    //   736: getfield 51	com/tencent/aladdin/config/AladdinConfig:mConfigId	I
    //   739: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: aload 4
    //   747: invokestatic 167	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   750: goto -79 -> 671
    //   753: aload_0
    //   754: new 173	java/util/HashMap
    //   757: dup
    //   758: invokespecial 174	java/util/HashMap:<init>	()V
    //   761: putfield 41	com/tencent/aladdin/config/AladdinConfig:mMap	Ljava/util/Map;
    //   764: goto -516 -> 248
    //   767: astore_3
    //   768: goto -107 -> 661
    //   771: astore 6
    //   773: aconst_null
    //   774: astore 4
    //   776: aconst_null
    //   777: astore_3
    //   778: goto -439 -> 339
    //   781: astore 6
    //   783: aconst_null
    //   784: astore_3
    //   785: goto -446 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	AladdinConfig
    //   91	28	1	bool1	boolean
    //   103	25	2	bool2	boolean
    //   320	9	3	localObject2	Object
    //   334	318	3	localObject3	Object
    //   657	15	3	localObject4	Object
    //   767	1	3	localObject5	Object
    //   777	8	3	localObject6	Object
    //   160	58	4	localFileReader	java.io.FileReader
    //   306	5	4	localObject7	Object
    //   313	122	4	localObject8	Object
    //   445	76	4	localException1	java.lang.Exception
    //   564	1	4	localObject9	Object
    //   571	76	4	localException2	java.lang.Exception
    //   673	73	4	localException3	java.lang.Exception
    //   774	1	4	localObject10	Object
    //   164	163	5	localObject11	Object
    //   330	6	5	localException4	java.lang.Exception
    //   341	326	5	localObject12	Object
    //   1	421	6	localObject13	Object
    //   771	1	6	localException5	java.lang.Exception
    //   781	1	6	localException6	java.lang.Exception
    //   170	152	7	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   232	237	306	finally
    //   242	248	306	finally
    //   248	296	306	finally
    //   296	305	306	finally
    //   308	310	306	finally
    //   753	764	306	finally
    //   37	73	313	finally
    //   74	137	313	finally
    //   137	139	313	finally
    //   315	317	313	finally
    //   179	191	320	finally
    //   194	197	320	finally
    //   321	324	320	finally
    //   204	209	330	java/lang/Exception
    //   328	330	330	java/lang/Exception
    //   434	439	445	java/lang/Exception
    //   217	222	571	java/lang/Exception
    //   139	162	657	finally
    //   531	563	657	finally
    //   666	671	673	java/lang/Exception
    //   166	172	767	finally
    //   176	179	767	finally
    //   204	209	767	finally
    //   328	330	767	finally
    //   343	383	767	finally
    //   387	393	767	finally
    //   397	426	767	finally
    //   139	162	771	java/lang/Exception
    //   531	563	771	java/lang/Exception
    //   166	172	781	java/lang/Exception
    //   176	179	781	java/lang/Exception
  }
  
  private void startLoadFromDisk()
  {
    Log.d("AladdinConfig", "startLoadFromDisk: ");
    synchronized (this.mLock)
    {
      this.mLoaded = false;
      Log.d("AladdinConfig", "startLoadFromDisk: mLoaded = false");
      this.asyncTaskExecutor.execute(new AladdinConfig.3(this));
      return;
    }
  }
  
  public void clear()
  {
    this.asyncTaskExecutor.execute(new AladdinConfig.2(this));
  }
  
  public Map<String, ?> getAll()
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      Map localMap = Collections.unmodifiableMap(this.mMap);
      return localMap;
    }
  }
  
  public <T extends AladdinConfigBean> T getBean(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (AladdinConfigBean)this.mMap.get(paramString);
        return paramString;
      }
      catch (ClassCastException paramString)
      {
        return null;
      }
    }
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Boolean)this.mMap.get(paramString);
        boolean bool = paramBoolean;
        if (paramString != null) {
          bool = paramString.booleanValue();
        }
        return bool;
      }
      catch (ClassCastException paramString)
      {
        return paramBoolean;
      }
    }
  }
  
  public boolean getBooleanFromString(String paramString, boolean paramBoolean)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        boolean bool = Boolean.valueOf((String)this.mMap.get(paramString)).booleanValue();
        return bool;
      }
      catch (ClassCastException paramString)
      {
        return paramBoolean;
      }
    }
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Float)this.mMap.get(paramString);
        float f = paramFloat;
        if (paramString != null) {
          f = paramString.floatValue();
        }
        return f;
      }
      catch (ClassCastException paramString)
      {
        return paramFloat;
      }
    }
  }
  
  public float getFloatFromString(String paramString, float paramFloat)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
    }
    try
    {
      paramString = (String)this.mMap.get(paramString);
      float f = paramFloat;
      if (paramString != null) {
        f = Float.valueOf(paramString).floatValue();
      }
      return f;
    }
    catch (ClassCastException paramString)
    {
      return paramFloat;
      paramString = finally;
      throw paramString;
    }
    catch (NumberFormatException paramString) {}
    return paramFloat;
  }
  
  public int getInteger(String paramString, int paramInt)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Integer)this.mMap.get(paramString);
        int i = paramInt;
        if (paramString != null) {
          i = paramString.intValue();
        }
        return i;
      }
      catch (ClassCastException paramString)
      {
        return paramInt;
      }
    }
  }
  
  public int getIntegerFromString(String paramString, int paramInt)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
    }
    try
    {
      paramString = (String)this.mMap.get(paramString);
      int i = paramInt;
      if (paramString != null) {
        i = Integer.valueOf(paramString).intValue();
      }
      return i;
    }
    catch (ClassCastException paramString)
    {
      return paramInt;
      paramString = finally;
      throw paramString;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public <T> List<T> getList(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (List)this.mMap.get(paramString);
        if (paramString != null) {}
        for (;;)
        {
          return paramString;
          paramString = Collections.emptyList();
        }
        paramString = finally;
      }
      catch (ClassCastException paramString)
      {
        paramString = Collections.emptyList();
        return paramString;
      }
    }
  }
  
  public long getLongFromString(String paramString, long paramLong)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
    }
    try
    {
      paramString = (String)this.mMap.get(paramString);
      long l = paramLong;
      if (paramString != null) {
        l = Long.valueOf(paramString).longValue();
      }
      return l;
    }
    catch (ClassCastException paramString)
    {
      return paramLong;
      paramString = finally;
      throw paramString;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  public <T> Map<String, T> getMap(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Map)this.mMap.get(paramString);
        if (paramString != null) {}
        for (;;)
        {
          return paramString;
          paramString = Collections.emptyMap();
        }
        paramString = finally;
      }
      catch (ClassCastException paramString)
      {
        paramString = Collections.emptyMap();
        return paramString;
      }
    }
  }
  
  public <T> Set<T> getSet(String paramString)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString = (Set)this.mMap.get(paramString);
        if (paramString != null) {}
        for (;;)
        {
          return paramString;
          paramString = Collections.emptySet();
        }
        paramString = finally;
      }
      catch (ClassCastException paramString)
      {
        paramString = Collections.emptySet();
        return paramString;
      }
    }
  }
  
  public String getString(String paramString1, String paramString2)
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      try
      {
        paramString1 = (String)this.mMap.get(paramString1);
        if (paramString1 != null) {
          paramString2 = paramString1;
        }
        return paramString2;
      }
      catch (ClassCastException paramString1)
      {
        return paramString2;
      }
    }
  }
  
  public String toString()
  {
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      String str = "AladdinConfig{mConfigId=" + this.mConfigId + ", mMap=" + this.mMap + '}';
      return str;
    }
  }
  
  public boolean update(String arg1)
  {
    boolean bool = true;
    Map localMap = this.mParser.parse(new StringReader(???));
    synchronized (this.mLock)
    {
      awaitLoadedLocked();
      this.mMap = localMap;
      this.mLoaded = true;
      Log.d("AladdinConfig", "run: updated, renew mMap for " + this.mConfigId);
      this.asyncTaskExecutor.execute(new AladdinConfig.1(this, ???));
    }
    synchronized (this.mLock)
    {
      if (!this.mMap.isEmpty())
      {
        return bool;
        ??? = finally;
        throw ???;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.AladdinConfig
 * JD-Core Version:    0.7.0.1
 */