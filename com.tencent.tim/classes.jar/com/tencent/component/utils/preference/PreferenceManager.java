package com.tencent.component.utils.preference;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.component.network.module.cache.common.LruCache;
import java.io.File;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PreferenceManager
{
  private static final String CACHE_NAME = "cache_pref";
  private static final String DEFAULT_NAME = "default_pref";
  private static final float DEFAULT_VERSION = 0.0F;
  private static final long GLOBAL_UID = 0L;
  private static final boolean OPTIMIZE = true;
  private static final int OPTIMIZE_BOUNDS = 1;
  private static final String OPTIMIZE_PREFIX = "preferences";
  private static final LruCache<String, SharedPreferences> sSharedPrefs = new LruCache(12);
  private static final ReentrantReadWriteLock sUniqueReadWriteLock = new ReentrantReadWriteLock();
  
  private static String convertToString(float paramFloat)
  {
    int i = (int)paramFloat;
    if (paramFloat == i) {
      return String.valueOf(i);
    }
    return String.valueOf(paramFloat);
  }
  
  public static SharedPreferences getCacheGlobalPreference(Context paramContext)
  {
    return obtainPreference(paramContext, 0L, "cache_pref", 0.0F);
  }
  
  public static SharedPreferences getCacheGlobalPreference(Context paramContext, float paramFloat)
  {
    return obtainPreference(paramContext, 0L, "cache_pref", paramFloat);
  }
  
  public static SharedPreferences getCachePreference(Context paramContext, long paramLong)
  {
    return obtainPreference(paramContext, paramLong, "cache_pref", 0.0F);
  }
  
  public static SharedPreferences getCachePreference(Context paramContext, long paramLong, float paramFloat)
  {
    return obtainPreference(paramContext, paramLong, "cache_pref", paramFloat);
  }
  
  public static SharedPreferences getDefaultGlobalPreference(Context paramContext)
  {
    return obtainPreference(paramContext, 0L, "default_pref", 0.0F);
  }
  
  public static SharedPreferences getDefaultGlobalPreference(Context paramContext, float paramFloat)
  {
    return obtainPreference(paramContext, 0L, "default_pref", paramFloat);
  }
  
  public static SharedPreferences getDefaultGlobalPreference(Context paramContext, boolean paramBoolean)
  {
    return obtainPreference(paramContext, 0L, "default_pref", 0.0F, paramBoolean);
  }
  
  public static SharedPreferences getDefaultPreference(Context paramContext, long paramLong)
  {
    return obtainPreference(paramContext, paramLong, "default_pref", 0.0F);
  }
  
  public static SharedPreferences getDefaultPreference(Context paramContext, long paramLong, float paramFloat)
  {
    return obtainPreference(paramContext, paramLong, "default_pref", paramFloat);
  }
  
  public static SharedPreferences getGlobalPreference(Context paramContext, String paramString)
  {
    return obtainPreference(paramContext, 0L, paramString, 0.0F);
  }
  
  public static SharedPreferences getGlobalPreference(Context paramContext, String paramString, float paramFloat)
  {
    return obtainPreference(paramContext, 0L, paramString, paramFloat);
  }
  
  public static SharedPreferences getPreference(Context paramContext, long paramLong, String paramString)
  {
    return obtainPreference(paramContext, paramLong, paramString, 0.0F);
  }
  
  public static SharedPreferences getPreference(Context paramContext, long paramLong, String paramString, float paramFloat)
  {
    return obtainPreference(paramContext, paramLong, paramString, paramFloat);
  }
  
  private static String obtainLegalName(String paramString)
  {
    if (paramString == null) {}
    while (paramString.indexOf(File.separatorChar) < 0) {
      return paramString;
    }
    return paramString.replaceAll(File.separator, "_");
  }
  
  private static String obtainOptimizeName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int j = paramString.hashCode() % 1;
    int i = j;
    if (j < 0) {
      i = j + 1;
    }
    return "preferences" + i;
  }
  
  private static SharedPreferences obtainPreference(Context paramContext, long paramLong, String paramString, float paramFloat)
  {
    return obtainPreference(paramContext, paramLong, paramString, paramFloat, false);
  }
  
  /* Error */
  private static SharedPreferences obtainPreference(Context paramContext, long paramLong, String paramString, float paramFloat, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +93 -> 97
    //   7: ldc 11
    //   9: astore_3
    //   10: iload 5
    //   12: ifeq +102 -> 114
    //   15: lload_1
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +87 -> 105
    //   21: ldc 130
    //   23: astore 6
    //   25: new 108	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   32: aload 6
    //   34: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 97
    //   39: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_3
    //   43: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 97
    //   48: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: fload 4
    //   53: invokestatic 132	com/tencent/component/utils/preference/PreferenceManager:convertToString	(F)Ljava/lang/String;
    //   56: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_3
    //   63: aload_0
    //   64: new 108	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   71: aload_0
    //   72: invokevirtual 137	android/content/Context:getPackageName	()Ljava/lang/String;
    //   75: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc 97
    //   80: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_3
    //   84: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: iconst_0
    //   91: invokevirtual 141	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   94: astore_0
    //   95: aload_0
    //   96: areturn
    //   97: aload_3
    //   98: invokestatic 143	com/tencent/component/utils/preference/PreferenceManager:obtainLegalName	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_3
    //   102: goto -92 -> 10
    //   105: lload_1
    //   106: invokestatic 146	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   109: astore 6
    //   111: goto -86 -> 25
    //   114: lload_1
    //   115: lconst_0
    //   116: lcmp
    //   117: ifne +98 -> 215
    //   120: ldc 130
    //   122: astore 6
    //   124: new 108	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   131: aload 6
    //   133: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 97
    //   138: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_3
    //   142: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc 97
    //   147: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: fload 4
    //   152: invokestatic 132	com/tencent/component/utils/preference/PreferenceManager:convertToString	(F)Ljava/lang/String;
    //   155: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: astore 8
    //   163: getstatic 47	com/tencent/component/utils/preference/PreferenceManager:sUniqueReadWriteLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   166: invokevirtual 150	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   169: astore 6
    //   171: aload 6
    //   173: ifnull +10 -> 183
    //   176: aload 6
    //   178: invokeinterface 155 1 0
    //   183: getstatic 41	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   186: aload 8
    //   188: invokevirtual 159	com/tencent/component/network/module/cache/common/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   191: checkcast 161	android/content/SharedPreferences
    //   194: astore_3
    //   195: aload_3
    //   196: ifnull +28 -> 224
    //   199: aload_3
    //   200: astore_0
    //   201: aload 6
    //   203: ifnull -108 -> 95
    //   206: aload 6
    //   208: invokeinterface 164 1 0
    //   213: aload_3
    //   214: areturn
    //   215: lload_1
    //   216: invokestatic 146	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   219: astore 6
    //   221: goto -97 -> 124
    //   224: aload 6
    //   226: ifnull +10 -> 236
    //   229: aload 6
    //   231: invokeinterface 164 1 0
    //   236: getstatic 47	com/tencent/component/utils/preference/PreferenceManager:sUniqueReadWriteLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   239: invokevirtual 168	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   242: astore 7
    //   244: aload 7
    //   246: ifnull +10 -> 256
    //   249: aload 7
    //   251: invokeinterface 155 1 0
    //   256: getstatic 41	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   259: aload 8
    //   261: invokevirtual 159	com/tencent/component/network/module/cache/common/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   264: checkcast 161	android/content/SharedPreferences
    //   267: astore 6
    //   269: aload 6
    //   271: astore_3
    //   272: aload 6
    //   274: ifnonnull +92 -> 366
    //   277: aload 6
    //   279: astore_3
    //   280: aload_0
    //   281: new 108	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   288: aload_0
    //   289: invokevirtual 137	android/content/Context:getPackageName	()Ljava/lang/String;
    //   292: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc 97
    //   297: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 8
    //   302: invokestatic 170	com/tencent/component/utils/preference/PreferenceManager:obtainOptimizeName	(Ljava/lang/String;)Ljava/lang/String;
    //   305: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: iconst_0
    //   312: invokevirtual 141	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   315: astore_0
    //   316: aload_0
    //   317: astore_3
    //   318: aload_3
    //   319: astore_0
    //   320: aload_3
    //   321: ifnull +33 -> 354
    //   324: new 172	com/tencent/component/utils/preference/OptimizedSharedPreferencesWrapper
    //   327: dup
    //   328: aload_3
    //   329: new 108	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   336: aload 8
    //   338: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc 174
    //   343: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: iconst_1
    //   350: invokespecial 177	com/tencent/component/utils/preference/OptimizedSharedPreferencesWrapper:<init>	(Landroid/content/SharedPreferences;Ljava/lang/String;Z)V
    //   353: astore_0
    //   354: getstatic 41	com/tencent/component/utils/preference/PreferenceManager:sSharedPrefs	Lcom/tencent/component/network/module/cache/common/LruCache;
    //   357: aload 8
    //   359: aload_0
    //   360: invokevirtual 181	com/tencent/component/network/module/cache/common/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: aload_0
    //   365: astore_3
    //   366: aload_3
    //   367: astore_0
    //   368: aload 7
    //   370: ifnull -275 -> 95
    //   373: aload 7
    //   375: invokeinterface 164 1 0
    //   380: aload_3
    //   381: areturn
    //   382: astore_0
    //   383: aload 6
    //   385: ifnull +10 -> 395
    //   388: aload 6
    //   390: invokeinterface 164 1 0
    //   395: aload_0
    //   396: athrow
    //   397: astore_0
    //   398: aload_0
    //   399: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   402: ldc 186
    //   404: new 108	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   411: ldc 188
    //   413: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_0
    //   417: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   420: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 197	com/tencent/ttpic/baseutils/log/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload_3
    //   430: astore_0
    //   431: aload 7
    //   433: ifnull -338 -> 95
    //   436: aload 7
    //   438: invokeinterface 164 1 0
    //   443: aload_3
    //   444: areturn
    //   445: astore_0
    //   446: aload 7
    //   448: ifnull +10 -> 458
    //   451: aload 7
    //   453: invokeinterface 164 1 0
    //   458: aload_0
    //   459: athrow
    //   460: astore_0
    //   461: goto -63 -> 398
    //   464: astore 6
    //   466: aload_0
    //   467: astore_3
    //   468: aload 6
    //   470: astore_0
    //   471: goto -73 -> 398
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	paramContext	Context
    //   0	474	1	paramLong	long
    //   0	474	3	paramString	String
    //   0	474	4	paramFloat	float
    //   0	474	5	paramBoolean	boolean
    //   23	366	6	localObject	Object
    //   464	5	6	localException	java.lang.Exception
    //   242	210	7	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   161	197	8	str	String
    // Exception table:
    //   from	to	target	type
    //   183	195	382	finally
    //   256	269	397	java/lang/Exception
    //   280	316	397	java/lang/Exception
    //   256	269	445	finally
    //   280	316	445	finally
    //   324	354	445	finally
    //   354	364	445	finally
    //   398	429	445	finally
    //   324	354	460	java/lang/Exception
    //   354	364	464	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.component.utils.preference.PreferenceManager
 * JD-Core Version:    0.7.0.1
 */