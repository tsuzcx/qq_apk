import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioUtil.1;
import com.tencent.mobileqq.utils.AudioUtil.7;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.IOException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class aqge
{
  private static ajat.c a = new aqgg();
  public static MediaPlayer d;
  private static int loopCount;
  
  public static int LR()
  {
    return ((AudioManager)BaseApplicationImpl.sApplication.getSystemService("audio")).getRingerMode();
  }
  
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      a(paramInt1, paramInt2, paramOnCompletionListener, null);
      return;
    }
    finally
    {
      paramOnCompletionListener = finally;
      throw paramOnCompletionListener;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, MediaPlayer.OnCompletionListener paramOnCompletionListener, Handler paramHandler)
  {
    for (;;)
    {
      try
      {
        if (d == null) {
          continue;
        }
        boolean bool = d.isPlaying();
        if (!bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (paramOnCompletionListener == null) {
          continue;
        }
        if ((paramHandler != null) && (paramHandler.getLooper() != Looper.myLooper())) {
          break label154;
        }
        paramOnCompletionListener.onCompletion(d);
        continue;
      }
      finally {}
      return;
      bVz();
      if (paramInt1 != AppSetting.bAf)
      {
        d = MediaPlayer.create(BaseApplicationImpl.sApplication, paramInt1);
        if (d != null)
        {
          loopCount = paramInt2;
          if (loopCount != 0) {
            loopCount -= 1;
          }
          d.setOnCompletionListener(new aqgk(paramOnCompletionListener, paramHandler));
          d.start();
          d.setLooping(false);
        }
      }
      else
      {
        d = MediaPlayer.create(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      continue;
      label154:
      paramHandler.post(new AudioUtil.7(paramOnCompletionListener));
    }
  }
  
  /* Error */
  public static void a(Uri paramUri, int paramInt, MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 5
    //   12: aload 7
    //   14: astore 6
    //   16: aload 8
    //   18: astore 4
    //   20: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   23: ifnull +63 -> 86
    //   26: aload 7
    //   28: astore 6
    //   30: aload 8
    //   32: astore 4
    //   34: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   37: invokevirtual 54	android/media/MediaPlayer:isPlaying	()Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifeq +33 -> 75
    //   45: iconst_0
    //   46: ifeq +11 -> 57
    //   49: new 123	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: ldc 2
    //   59: monitorexit
    //   60: return
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   66: goto -9 -> 57
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    //   75: aload 7
    //   77: astore 6
    //   79: aload 8
    //   81: astore 4
    //   83: invokestatic 57	aqge:bVz	()V
    //   86: aload 7
    //   88: astore 6
    //   90: aload 8
    //   92: astore 4
    //   94: aload_0
    //   95: invokevirtual 133	android/net/Uri:getScheme	()Ljava/lang/String;
    //   98: ldc 135
    //   100: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifeq +67 -> 170
    //   106: aload 7
    //   108: astore 6
    //   110: aload 8
    //   112: astore 4
    //   114: new 50	android/media/MediaPlayer
    //   117: dup
    //   118: invokespecial 142	android/media/MediaPlayer:<init>	()V
    //   121: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   124: aload 7
    //   126: astore 6
    //   128: aload 8
    //   130: astore 4
    //   132: new 144	java/io/FileInputStream
    //   135: dup
    //   136: new 146	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokevirtual 149	android/net/Uri:getPath	()Ljava/lang/String;
    //   144: invokespecial 152	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   150: astore_0
    //   151: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   154: aload_0
    //   155: invokevirtual 159	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   158: invokevirtual 163	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   161: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   164: invokevirtual 166	android/media/MediaPlayer:prepare	()V
    //   167: aload_0
    //   168: astore 5
    //   170: aload 5
    //   172: astore 6
    //   174: aload 5
    //   176: astore 4
    //   178: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   181: astore_0
    //   182: aload_0
    //   183: ifnonnull +24 -> 207
    //   186: aload 5
    //   188: ifnull -131 -> 57
    //   191: aload 5
    //   193: invokevirtual 169	java/io/FileInputStream:close	()V
    //   196: goto -139 -> 57
    //   199: astore_0
    //   200: aload_0
    //   201: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   204: goto -147 -> 57
    //   207: aload 5
    //   209: astore 6
    //   211: aload 5
    //   213: astore 4
    //   215: iload_1
    //   216: putstatic 68	aqge:loopCount	I
    //   219: aload 5
    //   221: astore 6
    //   223: aload 5
    //   225: astore 4
    //   227: getstatic 68	aqge:loopCount	I
    //   230: ifeq +19 -> 249
    //   233: aload 5
    //   235: astore 6
    //   237: aload 5
    //   239: astore 4
    //   241: getstatic 68	aqge:loopCount	I
    //   244: iconst_1
    //   245: isub
    //   246: putstatic 68	aqge:loopCount	I
    //   249: aload 5
    //   251: astore 6
    //   253: aload 5
    //   255: astore 4
    //   257: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   260: new 171	aqgf
    //   263: dup
    //   264: aload_2
    //   265: invokespecial 172	aqgf:<init>	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   268: invokevirtual 77	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   271: aload 5
    //   273: astore 6
    //   275: aload 5
    //   277: astore 4
    //   279: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   282: invokevirtual 80	android/media/MediaPlayer:start	()V
    //   285: aload 5
    //   287: astore 6
    //   289: aload 5
    //   291: astore 4
    //   293: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   296: iconst_0
    //   297: invokevirtual 84	android/media/MediaPlayer:setLooping	(Z)V
    //   300: aload 5
    //   302: ifnull -245 -> 57
    //   305: aload 5
    //   307: invokevirtual 169	java/io/FileInputStream:close	()V
    //   310: goto -253 -> 57
    //   313: astore_0
    //   314: aload_0
    //   315: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   318: goto -261 -> 57
    //   321: astore_0
    //   322: aload 6
    //   324: astore 4
    //   326: aload_0
    //   327: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   330: aload 6
    //   332: ifnull -275 -> 57
    //   335: aload 6
    //   337: invokevirtual 169	java/io/FileInputStream:close	()V
    //   340: goto -283 -> 57
    //   343: astore_0
    //   344: aload_0
    //   345: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   348: goto -291 -> 57
    //   351: astore_0
    //   352: aload 4
    //   354: astore_2
    //   355: aload_2
    //   356: ifnull +7 -> 363
    //   359: aload_2
    //   360: invokevirtual 169	java/io/FileInputStream:close	()V
    //   363: aload_0
    //   364: athrow
    //   365: astore_2
    //   366: aload_2
    //   367: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   370: goto -7 -> 363
    //   373: astore 4
    //   375: aload_0
    //   376: astore_2
    //   377: aload 4
    //   379: astore_0
    //   380: goto -25 -> 355
    //   383: astore_2
    //   384: aload_0
    //   385: astore 6
    //   387: aload_2
    //   388: astore_0
    //   389: goto -67 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramUri	Uri
    //   0	392	1	paramInt	int
    //   0	392	2	paramOnCompletionListener	MediaPlayer.OnCompletionListener
    //   40	2	3	bool	boolean
    //   18	335	4	localObject1	Object
    //   373	5	4	localObject2	Object
    //   10	296	5	localUri	Uri
    //   14	372	6	localObject3	Object
    //   4	121	7	localObject4	Object
    //   7	122	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	61	java/io/IOException
    //   49	57	69	finally
    //   62	66	69	finally
    //   191	196	69	finally
    //   200	204	69	finally
    //   305	310	69	finally
    //   314	318	69	finally
    //   335	340	69	finally
    //   344	348	69	finally
    //   359	363	69	finally
    //   363	365	69	finally
    //   366	370	69	finally
    //   191	196	199	java/io/IOException
    //   305	310	313	java/io/IOException
    //   20	26	321	java/lang/Exception
    //   34	41	321	java/lang/Exception
    //   83	86	321	java/lang/Exception
    //   94	106	321	java/lang/Exception
    //   114	124	321	java/lang/Exception
    //   132	151	321	java/lang/Exception
    //   178	182	321	java/lang/Exception
    //   215	219	321	java/lang/Exception
    //   227	233	321	java/lang/Exception
    //   241	249	321	java/lang/Exception
    //   257	271	321	java/lang/Exception
    //   279	285	321	java/lang/Exception
    //   293	300	321	java/lang/Exception
    //   335	340	343	java/io/IOException
    //   20	26	351	finally
    //   34	41	351	finally
    //   83	86	351	finally
    //   94	106	351	finally
    //   114	124	351	finally
    //   132	151	351	finally
    //   178	182	351	finally
    //   215	219	351	finally
    //   227	233	351	finally
    //   241	249	351	finally
    //   257	271	351	finally
    //   279	285	351	finally
    //   293	300	351	finally
    //   326	330	351	finally
    //   359	363	365	java/io/IOException
    //   151	167	373	finally
    //   151	167	383	java/lang/Exception
  }
  
  /* Error */
  public static void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +13 -> 24
    //   14: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   17: invokevirtual 177	android/media/MediaPlayer:release	()V
    //   20: aconst_null
    //   21: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   24: aload_0
    //   25: invokevirtual 133	android/net/Uri:getScheme	()Ljava/lang/String;
    //   28: ldc 135
    //   30: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +191 -> 224
    //   36: new 50	android/media/MediaPlayer
    //   39: dup
    //   40: invokespecial 142	android/media/MediaPlayer:<init>	()V
    //   43: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   46: iload_2
    //   47: ifeq +23 -> 70
    //   50: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +11 -> 64
    //   56: ldc 184
    //   58: iconst_2
    //   59: ldc 186
    //   61: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   67: invokestatic 192	aqge:c	(Landroid/media/MediaPlayer;)V
    //   70: new 144	java/io/FileInputStream
    //   73: dup
    //   74: new 146	java/io/File
    //   77: dup
    //   78: aload_0
    //   79: invokevirtual 149	android/net/Uri:getPath	()Ljava/lang/String;
    //   82: invokespecial 152	java/io/File:<init>	(Ljava/lang/String;)V
    //   85: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   88: astore_0
    //   89: aload_0
    //   90: astore 4
    //   92: aload_0
    //   93: astore_3
    //   94: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   97: aload_0
    //   98: invokevirtual 159	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   101: invokevirtual 163	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   104: aload_0
    //   105: astore 4
    //   107: aload_0
    //   108: astore_3
    //   109: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   112: invokevirtual 166	android/media/MediaPlayer:prepare	()V
    //   115: aload_0
    //   116: astore 4
    //   118: aload_0
    //   119: astore_3
    //   120: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   123: new 194	aqgl
    //   126: dup
    //   127: invokespecial 195	aqgl:<init>	()V
    //   130: invokevirtual 77	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   133: aload_0
    //   134: astore 4
    //   136: aload_0
    //   137: astore_3
    //   138: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   141: invokevirtual 80	android/media/MediaPlayer:start	()V
    //   144: aload_0
    //   145: astore 4
    //   147: aload_0
    //   148: astore_3
    //   149: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   152: iload_1
    //   153: invokevirtual 84	android/media/MediaPlayer:setLooping	(Z)V
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 169	java/io/FileInputStream:close	()V
    //   164: ldc 2
    //   166: monitorexit
    //   167: return
    //   168: astore_3
    //   169: aconst_null
    //   170: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   173: goto -149 -> 24
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: ifnull -16 -> 164
    //   183: aload_3
    //   184: invokevirtual 169	java/io/FileInputStream:close	()V
    //   187: goto -23 -> 164
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   195: goto -31 -> 164
    //   198: astore_0
    //   199: ldc 2
    //   201: monitorexit
    //   202: aload_0
    //   203: athrow
    //   204: astore_0
    //   205: aconst_null
    //   206: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   209: aload_0
    //   210: athrow
    //   211: astore_0
    //   212: aload 4
    //   214: ifnull +8 -> 222
    //   217: aload 4
    //   219: invokevirtual 169	java/io/FileInputStream:close	()V
    //   222: aload_0
    //   223: athrow
    //   224: getstatic 28	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   227: aload_0
    //   228: invokestatic 110	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   231: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   234: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   237: astore_0
    //   238: aload_0
    //   239: ifnonnull +23 -> 262
    //   242: iconst_0
    //   243: ifeq -79 -> 164
    //   246: new 123	java/lang/NullPointerException
    //   249: dup
    //   250: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   253: athrow
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   259: goto -95 -> 164
    //   262: iload_2
    //   263: ifeq +23 -> 286
    //   266: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +11 -> 280
    //   272: ldc 184
    //   274: iconst_2
    //   275: ldc 186
    //   277: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   283: invokestatic 192	aqge:c	(Landroid/media/MediaPlayer;)V
    //   286: aconst_null
    //   287: astore_0
    //   288: goto -173 -> 115
    //   291: astore_0
    //   292: aload_0
    //   293: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   296: goto -132 -> 164
    //   299: astore_3
    //   300: aload_3
    //   301: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   304: goto -82 -> 222
    //   307: astore_0
    //   308: goto -96 -> 212
    //   311: astore_0
    //   312: goto -133 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	paramUri	Uri
    //   0	315	1	paramBoolean1	boolean
    //   0	315	2	paramBoolean2	boolean
    //   9	140	3	localObject1	Object
    //   168	1	3	localException	Exception
    //   178	6	3	localObject2	Object
    //   299	2	3	localIOException	IOException
    //   1	217	4	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   14	20	168	java/lang/Exception
    //   6	10	176	java/lang/Exception
    //   20	24	176	java/lang/Exception
    //   24	46	176	java/lang/Exception
    //   50	64	176	java/lang/Exception
    //   64	70	176	java/lang/Exception
    //   70	89	176	java/lang/Exception
    //   169	173	176	java/lang/Exception
    //   205	211	176	java/lang/Exception
    //   224	238	176	java/lang/Exception
    //   266	280	176	java/lang/Exception
    //   280	286	176	java/lang/Exception
    //   183	187	190	java/io/IOException
    //   160	164	198	finally
    //   183	187	198	finally
    //   191	195	198	finally
    //   217	222	198	finally
    //   222	224	198	finally
    //   246	254	198	finally
    //   255	259	198	finally
    //   292	296	198	finally
    //   300	304	198	finally
    //   14	20	204	finally
    //   6	10	211	finally
    //   20	24	211	finally
    //   24	46	211	finally
    //   50	64	211	finally
    //   64	70	211	finally
    //   70	89	211	finally
    //   169	173	211	finally
    //   205	211	211	finally
    //   224	238	211	finally
    //   266	280	211	finally
    //   280	286	211	finally
    //   246	254	254	java/io/IOException
    //   160	164	291	java/io/IOException
    //   217	222	299	java/io/IOException
    //   94	104	307	finally
    //   109	115	307	finally
    //   120	133	307	finally
    //   138	144	307	finally
    //   149	156	307	finally
    //   94	104	311	java/lang/Exception
    //   109	115	311	java/lang/Exception
    //   120	133	311	java/lang/Exception
    //   138	144	311	java/lang/Exception
    //   149	156	311	java/lang/Exception
  }
  
  /* Error */
  private static MediaPlayer b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 204	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: iload_1
    //   7: invokevirtual 210	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnull +151 -> 163
    //   15: new 50	android/media/MediaPlayer
    //   18: dup
    //   19: invokespecial 142	android/media/MediaPlayer:<init>	()V
    //   22: astore_2
    //   23: aload_2
    //   24: invokestatic 192	aqge:c	(Landroid/media/MediaPlayer;)V
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 215	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   32: aload_0
    //   33: invokevirtual 219	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   36: aload_0
    //   37: invokevirtual 222	android/content/res/AssetFileDescriptor:getLength	()J
    //   40: invokevirtual 225	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   43: aload_0
    //   44: invokevirtual 226	android/content/res/AssetFileDescriptor:close	()V
    //   47: aload_2
    //   48: invokevirtual 166	android/media/MediaPlayer:prepare	()V
    //   51: aload_3
    //   52: astore_0
    //   53: aload_2
    //   54: astore_3
    //   55: aload_0
    //   56: ifnull +9 -> 65
    //   59: aload_0
    //   60: invokevirtual 226	android/content/res/AssetFileDescriptor:close	()V
    //   63: aload_2
    //   64: astore_3
    //   65: aload_3
    //   66: areturn
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_0
    //   72: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +12 -> 87
    //   78: ldc 228
    //   80: iconst_2
    //   81: ldc 230
    //   83: aload_3
    //   84: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_2
    //   88: ifnull +72 -> 160
    //   91: aload_2
    //   92: invokevirtual 177	android/media/MediaPlayer:release	()V
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: aload_0
    //   100: ifnull -35 -> 65
    //   103: aload_0
    //   104: invokevirtual 226	android/content/res/AssetFileDescriptor:close	()V
    //   107: aload_2
    //   108: areturn
    //   109: astore_0
    //   110: aload_2
    //   111: areturn
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 226	android/content/res/AssetFileDescriptor:close	()V
    //   123: aload_2
    //   124: athrow
    //   125: astore_0
    //   126: aload_2
    //   127: areturn
    //   128: astore_2
    //   129: goto -34 -> 95
    //   132: astore_0
    //   133: goto -10 -> 123
    //   136: astore_2
    //   137: goto -22 -> 115
    //   140: astore_2
    //   141: goto -26 -> 115
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_2
    //   147: goto -75 -> 72
    //   150: astore_3
    //   151: goto -79 -> 72
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_0
    //   157: goto -85 -> 72
    //   160: goto -63 -> 97
    //   163: aconst_null
    //   164: astore_2
    //   165: goto -112 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	Context
    //   0	168	1	paramInt	int
    //   22	89	2	localMediaPlayer1	MediaPlayer
    //   112	15	2	localMediaPlayer2	MediaPlayer
    //   128	1	2	localException1	Exception
    //   136	1	2	localObject1	Object
    //   140	1	2	localObject2	Object
    //   146	19	2	localObject3	Object
    //   1	65	3	localObject4	Object
    //   67	17	3	localException2	Exception
    //   98	1	3	localObject5	Object
    //   144	1	3	localException3	Exception
    //   150	1	3	localException4	Exception
    //   154	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   2	11	67	java/lang/Exception
    //   103	107	109	java/lang/Exception
    //   2	11	112	finally
    //   47	51	112	finally
    //   59	63	125	java/lang/Exception
    //   91	95	128	java/lang/Exception
    //   119	123	132	java/lang/Exception
    //   15	23	136	finally
    //   23	47	136	finally
    //   72	87	140	finally
    //   91	95	140	finally
    //   15	23	144	java/lang/Exception
    //   23	47	150	java/lang/Exception
    //   47	51	154	java/lang/Exception
  }
  
  private static MediaPlayer b(Context paramContext, Uri paramUri)
  {
    label42:
    do
    {
      try
      {
        localObject = new MediaPlayer();
        if (!QLog.isColorLevel()) {
          break label42;
        }
      }
      catch (IOException paramUri)
      {
        try
        {
          c((MediaPlayer)localObject);
          ((MediaPlayer)localObject).setDataSource(paramContext, paramUri);
          ((MediaPlayer)localObject).prepare();
          return localObject;
        }
        catch (IOException paramUri)
        {
          for (;;)
          {
            Object localObject;
            paramContext = (Context)localObject;
          }
        }
        paramUri = paramUri;
        paramContext = null;
      }
      QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramUri);
      localObject = paramContext;
    } while (paramContext == null);
    try
    {
      paramContext.release();
      label52:
      return null;
    }
    catch (Exception paramContext)
    {
      break label52;
    }
  }
  
  public static void bVz()
  {
    try
    {
      if (d != null) {
        d.release();
      }
      label12:
      d = null;
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  private static void c(MediaPlayer paramMediaPlayer)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      paramMediaPlayer.setAudioStreamType(3);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MediaPlayerStart", 2, "get QQAppInterface error");
  }
  
  public static void cd(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("mediaPlayerStartForMsg", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (d == null) {
          continue;
        }
        if (!d.isPlaying()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is playing");
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer exception", localException1);
        continue;
      }
      finally {}
      return;
      try
      {
        d.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label178;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer release exception", localException2);
        label178:
        d = null;
        continue;
      }
      finally
      {
        d = null;
      }
      if (paramInt != AppSetting.bAf)
      {
        d = b(BaseApplicationImpl.sApplication, paramInt);
        if (d == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is null");
        }
      }
      else
      {
        d = b(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("mediaPlayerStartForMsg", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      d.setOnCompletionListener(new aqgi());
      d.start();
      d.setLooping(paramBoolean);
    }
  }
  
  public static void ce(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerStart", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (d == null) {
          continue;
        }
        if (!d.isPlaying()) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("MediaPlayerStart", 2, "media palyer is playing");
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer exception", localException1);
        continue;
      }
      finally {}
      return;
      try
      {
        d.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label173;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer release exception", localException2);
        label173:
        d = null;
        continue;
      }
      finally
      {
        d = null;
      }
      if (paramInt != AppSetting.bAf)
      {
        d = MediaPlayer.create(BaseApplicationImpl.sApplication, paramInt);
        if (d == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("MediaPlayerStart", 2, "media palyer is null");
        }
      }
      else
      {
        d = MediaPlayer.create(BaseApplicationImpl.sApplication, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MediaPlayerStart", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      d.setOnCompletionListener(new aqgj());
      d.start();
      d.setLooping(paramBoolean);
    }
  }
  
  /* Error */
  public static void dk(java.lang.String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload 5
    //   11: astore_3
    //   12: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   15: ifnull +60 -> 75
    //   18: aload 5
    //   20: astore_3
    //   21: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   24: invokevirtual 54	android/media/MediaPlayer:isPlaying	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifeq +33 -> 62
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 123	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: ldc 2
    //   46: monitorexit
    //   47: return
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   53: goto -9 -> 44
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    //   62: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   65: invokevirtual 177	android/media/MediaPlayer:release	()V
    //   68: aload 5
    //   70: astore_3
    //   71: aconst_null
    //   72: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   75: aload 5
    //   77: astore_3
    //   78: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   81: ifnonnull +16 -> 97
    //   84: aload 5
    //   86: astore_3
    //   87: new 50	android/media/MediaPlayer
    //   90: dup
    //   91: invokespecial 142	android/media/MediaPlayer:<init>	()V
    //   94: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   97: aload 5
    //   99: astore_3
    //   100: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   103: invokevirtual 313	android/media/MediaPlayer:reset	()V
    //   106: aload 5
    //   108: astore_3
    //   109: new 144	java/io/FileInputStream
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 314	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   117: astore_0
    //   118: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   121: aload_0
    //   122: invokevirtual 159	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   125: invokevirtual 163	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   128: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   131: invokestatic 192	aqge:c	(Landroid/media/MediaPlayer;)V
    //   134: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   137: invokevirtual 166	android/media/MediaPlayer:prepare	()V
    //   140: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   143: new 316	aqgh
    //   146: dup
    //   147: invokespecial 317	aqgh:<init>	()V
    //   150: invokevirtual 77	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   153: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   156: invokevirtual 80	android/media/MediaPlayer:start	()V
    //   159: getstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   162: iload_1
    //   163: invokevirtual 84	android/media/MediaPlayer:setLooping	(Z)V
    //   166: aload_0
    //   167: ifnull -123 -> 44
    //   170: aload_0
    //   171: invokevirtual 169	java/io/FileInputStream:close	()V
    //   174: goto -130 -> 44
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   182: goto -138 -> 44
    //   185: astore_3
    //   186: aload 5
    //   188: astore_3
    //   189: aconst_null
    //   190: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   193: goto -118 -> 75
    //   196: astore_3
    //   197: aload 4
    //   199: astore_0
    //   200: aload_3
    //   201: astore 4
    //   203: aload_0
    //   204: astore_3
    //   205: aload 4
    //   207: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   210: aload_0
    //   211: astore_3
    //   212: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +17 -> 232
    //   218: aload_0
    //   219: astore_3
    //   220: ldc_w 319
    //   223: iconst_2
    //   224: ldc_w 321
    //   227: aload 4
    //   229: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   232: aload_0
    //   233: ifnull -189 -> 44
    //   236: aload_0
    //   237: invokevirtual 169	java/io/FileInputStream:close	()V
    //   240: goto -196 -> 44
    //   243: astore_0
    //   244: aload_0
    //   245: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   248: goto -204 -> 44
    //   251: astore_0
    //   252: aload 5
    //   254: astore_3
    //   255: aconst_null
    //   256: putstatic 48	aqge:d	Landroid/media/MediaPlayer;
    //   259: aload 5
    //   261: astore_3
    //   262: aload_0
    //   263: athrow
    //   264: astore_0
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 169	java/io/FileInputStream:close	()V
    //   273: aload_0
    //   274: athrow
    //   275: astore_3
    //   276: aload_3
    //   277: invokevirtual 127	java/io/IOException:printStackTrace	()V
    //   280: goto -7 -> 273
    //   283: astore 4
    //   285: aload_0
    //   286: astore_3
    //   287: aload 4
    //   289: astore_0
    //   290: goto -25 -> 265
    //   293: astore 4
    //   295: goto -92 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramString	java.lang.String
    //   0	298	1	paramBoolean	boolean
    //   27	2	2	bool	boolean
    //   11	98	3	localObject1	Object
    //   185	1	3	localException1	Exception
    //   188	1	3	localObject2	Object
    //   196	5	3	localException2	Exception
    //   204	66	3	localObject3	Object
    //   275	2	3	localIOException	IOException
    //   286	1	3	str	java.lang.String
    //   4	224	4	localObject4	Object
    //   283	5	4	localObject5	Object
    //   293	1	4	localException3	Exception
    //   1	259	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	48	java/io/IOException
    //   36	44	56	finally
    //   49	53	56	finally
    //   170	174	56	finally
    //   178	182	56	finally
    //   236	240	56	finally
    //   244	248	56	finally
    //   269	273	56	finally
    //   273	275	56	finally
    //   276	280	56	finally
    //   170	174	177	java/io/IOException
    //   62	68	185	java/lang/Exception
    //   12	18	196	java/lang/Exception
    //   21	28	196	java/lang/Exception
    //   71	75	196	java/lang/Exception
    //   78	84	196	java/lang/Exception
    //   87	97	196	java/lang/Exception
    //   100	106	196	java/lang/Exception
    //   109	118	196	java/lang/Exception
    //   189	193	196	java/lang/Exception
    //   255	259	196	java/lang/Exception
    //   262	264	196	java/lang/Exception
    //   236	240	243	java/io/IOException
    //   62	68	251	finally
    //   12	18	264	finally
    //   21	28	264	finally
    //   71	75	264	finally
    //   78	84	264	finally
    //   87	97	264	finally
    //   100	106	264	finally
    //   109	118	264	finally
    //   189	193	264	finally
    //   205	210	264	finally
    //   212	218	264	finally
    //   220	232	264	finally
    //   255	259	264	finally
    //   262	264	264	finally
    //   269	273	275	java/io/IOException
    //   118	166	283	finally
    //   118	166	293	java/lang/Exception
  }
  
  @TargetApi(8)
  public static boolean m(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "context is null.");
      }
    }
    do
    {
      return false;
      if (VersionUtils.isrFroyo()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AudioUtil", 2, "Android 2.1 and below can not stop music");
    return false;
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramBoolean)
    {
      if (paramContext.requestAudioFocus(null, 3, 2) == 1) {}
      for (bool = true;; bool = false)
      {
        ajat.a().requestMediaFocus(1, a);
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "pauseMusic bMute=" + paramBoolean + " result=" + bool);
        }
        return bool;
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          int i = paramContext.abandonAudioFocus(null);
          if (i != 1) {
            break label182;
          }
          bool = true;
          try
          {
            ThreadManager.getSubThreadHandler().postDelayed(new AudioUtil.1(), 1000L);
          }
          catch (NullPointerException paramContext) {}
        }
      }
      catch (NullPointerException paramContext)
      {
        label182:
        bool = false;
        continue;
      }
      QLog.e("AudioUtil", 1, "caught npe", paramContext);
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqge
 * JD-Core Version:    0.7.0.1
 */