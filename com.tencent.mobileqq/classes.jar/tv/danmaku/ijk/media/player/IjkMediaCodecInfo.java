package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;
import java.util.Map;

public class IjkMediaCodecInfo
{
  public static final int RANK_ACCEPTABLE = 700;
  public static final int RANK_LAST_CHANCE = 600;
  public static final int RANK_MAX = 1000;
  public static final int RANK_NON_STANDARD = 100;
  public static final int RANK_NO_SENSE = 0;
  public static final int RANK_SECURE = 300;
  public static final int RANK_SOFTWARE = 200;
  public static final int RANK_TESTED = 800;
  private static final String TAG = "IjkMediaCodecInfo";
  private static Map<String, Integer> sKnownCodecList;
  public MediaCodecInfo mCodecInfo;
  public String mMimeType;
  public int mRank = 0;
  
  /* Error */
  private static Map<String, Integer> getKnownCodecList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   6: ifnull +12 -> 18
    //   9: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 45	java/util/TreeMap
    //   21: dup
    //   22: getstatic 51	java/lang/String:CASE_INSENSITIVE_ORDER	Ljava/util/Comparator;
    //   25: invokespecial 54	java/util/TreeMap:<init>	(Ljava/util/Comparator;)V
    //   28: putstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   31: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   34: ldc 56
    //   36: sipush 800
    //   39: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   42: invokeinterface 68 3 0
    //   47: pop
    //   48: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   51: ldc 70
    //   53: sipush 300
    //   56: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: invokeinterface 68 3 0
    //   64: pop
    //   65: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   68: ldc 72
    //   70: sipush 801
    //   73: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: invokeinterface 68 3 0
    //   81: pop
    //   82: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   85: ldc 74
    //   87: sipush 800
    //   90: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: invokeinterface 68 3 0
    //   98: pop
    //   99: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   102: ldc 76
    //   104: sipush 800
    //   107: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: invokeinterface 68 3 0
    //   115: pop
    //   116: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   119: ldc 78
    //   121: iconst_0
    //   122: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokeinterface 68 3 0
    //   130: pop
    //   131: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   134: ldc 80
    //   136: sipush 800
    //   139: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: invokeinterface 68 3 0
    //   147: pop
    //   148: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   151: ldc 82
    //   153: sipush 799
    //   156: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: invokeinterface 68 3 0
    //   164: pop
    //   165: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   168: ldc 84
    //   170: sipush 798
    //   173: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: invokeinterface 68 3 0
    //   181: pop
    //   182: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   185: ldc 86
    //   187: sipush 200
    //   190: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   193: invokeinterface 68 3 0
    //   198: pop
    //   199: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   202: ldc 88
    //   204: sipush 800
    //   207: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: invokeinterface 68 3 0
    //   215: pop
    //   216: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   219: ldc 90
    //   221: sipush 799
    //   224: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: invokeinterface 68 3 0
    //   232: pop
    //   233: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   236: ldc 92
    //   238: sipush 800
    //   241: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: invokeinterface 68 3 0
    //   249: pop
    //   250: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   253: ldc 94
    //   255: sipush 800
    //   258: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: invokeinterface 68 3 0
    //   266: pop
    //   267: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   270: ldc 96
    //   272: sipush 800
    //   275: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: invokeinterface 68 3 0
    //   283: pop
    //   284: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   287: ldc 98
    //   289: sipush 800
    //   292: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: invokeinterface 68 3 0
    //   300: pop
    //   301: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   304: ldc 100
    //   306: sipush 800
    //   309: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   312: invokeinterface 68 3 0
    //   317: pop
    //   318: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   321: ldc 102
    //   323: sipush 800
    //   326: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: invokeinterface 68 3 0
    //   334: pop
    //   335: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   338: ldc 104
    //   340: sipush 200
    //   343: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: invokeinterface 68 3 0
    //   351: pop
    //   352: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   355: ldc 106
    //   357: invokeinterface 110 2 0
    //   362: pop
    //   363: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   366: ldc 112
    //   368: invokeinterface 110 2 0
    //   373: pop
    //   374: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   377: ldc 114
    //   379: invokeinterface 110 2 0
    //   384: pop
    //   385: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   388: ldc 116
    //   390: invokeinterface 110 2 0
    //   395: pop
    //   396: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   399: ldc 118
    //   401: invokeinterface 110 2 0
    //   406: pop
    //   407: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   410: ldc 120
    //   412: invokeinterface 110 2 0
    //   417: pop
    //   418: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   421: ldc 122
    //   423: invokeinterface 110 2 0
    //   428: pop
    //   429: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   432: ldc 124
    //   434: invokeinterface 110 2 0
    //   439: pop
    //   440: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   443: ldc 126
    //   445: invokeinterface 110 2 0
    //   450: pop
    //   451: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   454: ldc 128
    //   456: invokeinterface 110 2 0
    //   461: pop
    //   462: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   465: ldc 130
    //   467: invokeinterface 110 2 0
    //   472: pop
    //   473: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   476: ldc 132
    //   478: invokeinterface 110 2 0
    //   483: pop
    //   484: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   487: ldc 134
    //   489: invokeinterface 110 2 0
    //   494: pop
    //   495: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   498: ldc 136
    //   500: invokeinterface 110 2 0
    //   505: pop
    //   506: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   509: ldc 138
    //   511: invokeinterface 110 2 0
    //   516: pop
    //   517: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   520: ldc 140
    //   522: invokeinterface 110 2 0
    //   527: pop
    //   528: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   531: ldc 142
    //   533: invokeinterface 110 2 0
    //   538: pop
    //   539: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   542: ldc 144
    //   544: invokeinterface 110 2 0
    //   549: pop
    //   550: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   553: ldc 146
    //   555: invokeinterface 110 2 0
    //   560: pop
    //   561: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   564: ldc 148
    //   566: sipush 200
    //   569: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   572: invokeinterface 68 3 0
    //   577: pop
    //   578: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   581: ldc 150
    //   583: sipush 200
    //   586: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   589: invokeinterface 68 3 0
    //   594: pop
    //   595: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   598: ldc 152
    //   600: sipush 200
    //   603: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   606: invokeinterface 68 3 0
    //   611: pop
    //   612: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   615: ldc 154
    //   617: sipush 200
    //   620: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   623: invokeinterface 68 3 0
    //   628: pop
    //   629: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   632: ldc 156
    //   634: sipush 200
    //   637: invokestatic 62	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   640: invokeinterface 68 3 0
    //   645: pop
    //   646: getstatic 43	tv/danmaku/ijk/media/player/IjkMediaCodecInfo:sKnownCodecList	Ljava/util/Map;
    //   649: astore_0
    //   650: goto -637 -> 13
    //   653: astore_0
    //   654: ldc 2
    //   656: monitorexit
    //   657: aload_0
    //   658: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	638	0	localMap	Map
    //   653	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	653	finally
    //   18	650	653	finally
  }
  
  public static String getLevelName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "0";
    case 1: 
      return "1";
    case 2: 
      return "1b";
    case 4: 
      return "11";
    case 8: 
      return "12";
    case 16: 
      return "13";
    case 32: 
      return "2";
    case 64: 
      return "21";
    case 128: 
      return "22";
    case 256: 
      return "3";
    case 512: 
      return "31";
    case 1024: 
      return "32";
    case 2048: 
      return "4";
    case 4096: 
      return "41";
    case 8192: 
      return "42";
    case 16384: 
      return "5";
    case 32768: 
      return "51";
    }
    return "52";
  }
  
  public static String getProfileLevelName(int paramInt1, int paramInt2)
  {
    return String.format(Locale.US, " %s Profile Level %s (%d,%d)", new Object[] { getProfileName(paramInt1), getLevelName(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static String getProfileName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown";
    case 1: 
      return "Baseline";
    case 2: 
      return "Main";
    case 4: 
      return "Extends";
    case 8: 
      return "High";
    case 16: 
      return "High10";
    case 32: 
      return "High422";
    }
    return "High444";
  }
  
  @TargetApi(16)
  public static IjkMediaCodecInfo setupCandidate(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    int j = 200;
    if ((paramMediaCodecInfo == null) || (Build.VERSION.SDK_INT < 16)) {
      return null;
    }
    Object localObject = paramMediaCodecInfo.getName();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = ((String)localObject).toLowerCase(Locale.US);
    int i;
    if (!((String)localObject).startsWith("omx.")) {
      i = 100;
    }
    for (;;)
    {
      localObject = new IjkMediaCodecInfo();
      ((IjkMediaCodecInfo)localObject).mCodecInfo = paramMediaCodecInfo;
      ((IjkMediaCodecInfo)localObject).mRank = i;
      ((IjkMediaCodecInfo)localObject).mMimeType = paramString;
      return localObject;
      i = j;
      if (!((String)localObject).startsWith("omx.pv"))
      {
        i = j;
        if (!((String)localObject).startsWith("omx.google."))
        {
          i = j;
          if (!((String)localObject).startsWith("omx.ffmpeg."))
          {
            i = j;
            if (!((String)localObject).startsWith("omx.k3.ffmpeg."))
            {
              i = j;
              if (!((String)localObject).startsWith("omx.avcodec.")) {
                if (((String)localObject).startsWith("omx.ittiam."))
                {
                  i = 0;
                }
                else if (((String)localObject).startsWith("omx.mtk."))
                {
                  if (Build.VERSION.SDK_INT < 18) {
                    i = 0;
                  } else {
                    i = 800;
                  }
                }
                else
                {
                  localObject = (Integer)getKnownCodecList().get(localObject);
                  if (localObject != null) {
                    i = ((Integer)localObject).intValue();
                  } else {
                    try
                    {
                      localObject = paramMediaCodecInfo.getCapabilitiesForType(paramString);
                      if (localObject != null) {
                        i = 700;
                      } else {
                        i = 600;
                      }
                    }
                    catch (Throwable localThrowable)
                    {
                      i = 600;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @TargetApi(16)
  public void dumpProfileLevels(String paramString)
  {
    int i = 0;
    int m = 0;
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    int i1;
    int k;
    Object localObject;
    try
    {
      paramString = this.mCodecInfo.getCapabilitiesForType(paramString);
      if ((paramString == null) || (paramString.profileLevels == null)) {
        break label148;
      }
      paramString = paramString.profileLevels;
      i1 = paramString.length;
      k = 0;
      j = 0;
    }
    catch (Throwable paramString)
    {
      Log.i("IjkMediaCodecInfo", "profile-level: exception");
      return;
    }
    int j = Math.max(j, localObject.profile);
    i = Math.max(i, localObject.level);
    for (;;)
    {
      label74:
      Log.i("IjkMediaCodecInfo", String.format(Locale.US, "%s", new Object[] { getProfileLevelName(n, m) }));
      return;
      for (;;)
      {
        m = i;
        n = j;
        if (k >= i1) {
          break label74;
        }
        localObject = paramString[k];
        if (localObject != null) {
          break;
        }
        k += 1;
      }
      label148:
      int n = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaCodecInfo
 * JD-Core Version:    0.7.0.1
 */