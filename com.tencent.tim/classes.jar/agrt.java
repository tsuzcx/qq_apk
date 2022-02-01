import android.content.BroadcastReceiver;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class agrt
  implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static WeakReference<agrt> gU;
  private final String TAG = "FileViewMusicService<FileAssistant>";
  agsc a;
  private BroadcastReceiver aG;
  String bJi;
  private int bQC;
  private boolean ceZ;
  private boolean cfa;
  private boolean cfb;
  private boolean cfc;
  private MediaPlayer mediaPlayer;
  SurfaceHolder surfaceHolder = null;
  
  private void Ye()
  {
    if ((!this.cfa) || (!this.cfb)) {}
    label102:
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            if ((this.bJi != null) && (this.bJi.length() != 0)) {
              break label102;
            }
            if (!QLog.isDevelopLevel()) {
              break;
            }
            throw new NullPointerException(acfp.m(2131706318));
          }
          catch (Exception localException1) {}
        } while (!QLog.isColorLevel());
        QLog.e("FileViewMusicService<FileAssistant>", 2, "musicPathString not init " + localException1.toString());
        return;
      } while (!QLog.isColorLevel());
      QLog.e("FileViewMusicService<FileAssistant>", 2, "musci path not init!");
      return;
      if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
      {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
        return;
      }
      if ((this.mediaPlayer != null) && (this.ceZ)) {
        this.mediaPlayer.start();
      }
      try
      {
        ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().b(true, 25, Boolean.valueOf(true));
        return;
      }
      catch (Exception localException2) {}
    } while (!QLog.isColorLevel());
    QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
  }
  
  public static agrt a()
  {
    agrt localagrt1 = null;
    if (gU != null) {
      localagrt1 = (agrt)gU.get();
    }
    agrt localagrt2 = localagrt1;
    if (localagrt1 == null)
    {
      localagrt2 = new agrt();
      gU = new WeakReference(localagrt2);
    }
    return localagrt2;
  }
  
  public void Os(int paramInt)
  {
    if (this.mediaPlayer != null)
    {
      this.bQC = paramInt;
      this.cfc = true;
      if (this.cfa) {
        this.mediaPlayer.seekTo(this.bQC);
      }
    }
  }
  
  public void a(agsc paramagsc)
  {
    this.a = paramagsc;
  }
  
  public void a(String paramString, agrt.a parama)
  {
    ThreadManager.executeOnSubThread(new FileViewMusicService.1(this, paramString, parama));
  }
  
  public void djo()
  {
    if ((this.mediaPlayer != null) && (this.mediaPlayer.isPlaying())) {
      this.mediaPlayer.pause();
    }
  }
  
  public int getCurrentPosition()
  {
    if (this.mediaPlayer != null) {
      return this.mediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  /* Error */
  public boolean init(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +22 -> 28
    //   9: aload_0
    //   10: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   13: invokevirtual 220	android/media/MediaPlayer:stop	()V
    //   16: aload_0
    //   17: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   20: invokevirtual 223	android/media/MediaPlayer:release	()V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   28: aload_0
    //   29: new 130	android/media/MediaPlayer
    //   32: dup
    //   33: invokespecial 224	android/media/MediaPlayer:<init>	()V
    //   36: putfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   39: aload_0
    //   40: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   43: aload_0
    //   44: invokevirtual 228	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   47: aload_0
    //   48: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   51: aload_0
    //   52: invokevirtual 232	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   55: aload_0
    //   56: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   59: aload_0
    //   60: invokevirtual 236	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   63: aload_0
    //   64: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   67: iconst_0
    //   68: invokevirtual 240	android/media/MediaPlayer:setLooping	(Z)V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 55	agrt:bJi	Ljava/lang/String;
    //   76: new 242	java/io/FileInputStream
    //   79: dup
    //   80: new 244	java/io/File
    //   83: dup
    //   84: aload_1
    //   85: invokespecial 245	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: invokespecial 248	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: astore 4
    //   93: aload 4
    //   95: astore_3
    //   96: aload_0
    //   97: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   100: iconst_3
    //   101: invokevirtual 251	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   104: aload 4
    //   106: astore_3
    //   107: aload_0
    //   108: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   111: aload 4
    //   113: invokevirtual 255	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   116: invokevirtual 259	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   119: aload 4
    //   121: astore_3
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 53	agrt:cfb	Z
    //   127: aload 4
    //   129: astore_3
    //   130: aload_0
    //   131: iconst_0
    //   132: putfield 51	agrt:cfa	Z
    //   135: aload 4
    //   137: astore_3
    //   138: aload_0
    //   139: iconst_0
    //   140: putfield 177	agrt:bQC	I
    //   143: aload 4
    //   145: astore_3
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 179	agrt:cfc	Z
    //   151: aload 4
    //   153: astore_3
    //   154: aload_0
    //   155: getfield 261	agrt:aG	Landroid/content/BroadcastReceiver;
    //   158: ifnonnull +57 -> 215
    //   161: aload 4
    //   163: astore_3
    //   164: aload_0
    //   165: new 263	agrv
    //   168: dup
    //   169: aload_0
    //   170: invokespecial 266	agrv:<init>	(Lagrt;)V
    //   173: putfield 261	agrt:aG	Landroid/content/BroadcastReceiver;
    //   176: aload 4
    //   178: astore_3
    //   179: new 268	android/content/IntentFilter
    //   182: dup
    //   183: invokespecial 269	android/content/IntentFilter:<init>	()V
    //   186: astore 5
    //   188: aload 4
    //   190: astore_3
    //   191: aload 5
    //   193: ldc_w 271
    //   196: invokevirtual 274	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   199: aload 4
    //   201: astore_3
    //   202: invokestatic 108	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   205: aload_0
    //   206: getfield 261	agrt:aG	Landroid/content/BroadcastReceiver;
    //   209: aload 5
    //   211: invokevirtual 278	com/tencent/qphone/base/util/BaseApplication:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   214: pop
    //   215: aload 4
    //   217: astore_3
    //   218: aload_0
    //   219: getfield 126	agrt:mediaPlayer	Landroid/media/MediaPlayer;
    //   222: invokevirtual 281	android/media/MediaPlayer:prepareAsync	()V
    //   225: aload 4
    //   227: ifnull +8 -> 235
    //   230: aload 4
    //   232: invokevirtual 284	java/io/FileInputStream:close	()V
    //   235: aload_0
    //   236: aload_1
    //   237: putfield 55	agrt:bJi	Ljava/lang/String;
    //   240: iconst_1
    //   241: istore_2
    //   242: iload_2
    //   243: ireturn
    //   244: astore_3
    //   245: aload_3
    //   246: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   249: goto -14 -> 235
    //   252: astore_1
    //   253: aconst_null
    //   254: astore 4
    //   256: aload 4
    //   258: astore_3
    //   259: aload_0
    //   260: getfield 185	agrt:a	Lagsc;
    //   263: ifnull +16 -> 279
    //   266: aload 4
    //   268: astore_3
    //   269: aload_0
    //   270: getfield 185	agrt:a	Lagsc;
    //   273: aconst_null
    //   274: invokeinterface 292 2 0
    //   279: aload 4
    //   281: astore_3
    //   282: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +35 -> 320
    //   288: aload 4
    //   290: astore_3
    //   291: ldc 41
    //   293: iconst_2
    //   294: new 84	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 294
    //   304: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 295	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   311: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: aload 4
    //   322: ifnull -80 -> 242
    //   325: aload 4
    //   327: invokevirtual 284	java/io/FileInputStream:close	()V
    //   330: iconst_0
    //   331: ireturn
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   337: iconst_0
    //   338: ireturn
    //   339: astore_1
    //   340: aconst_null
    //   341: astore 4
    //   343: aload 4
    //   345: astore_3
    //   346: aload_0
    //   347: getfield 185	agrt:a	Lagsc;
    //   350: ifnull +16 -> 366
    //   353: aload 4
    //   355: astore_3
    //   356: aload_0
    //   357: getfield 185	agrt:a	Lagsc;
    //   360: aconst_null
    //   361: invokeinterface 292 2 0
    //   366: aload 4
    //   368: astore_3
    //   369: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +35 -> 407
    //   375: aload 4
    //   377: astore_3
    //   378: ldc 41
    //   380: iconst_2
    //   381: new 84	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 297
    //   391: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_1
    //   395: invokevirtual 298	java/lang/SecurityException:toString	()Ljava/lang/String;
    //   398: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: aload 4
    //   409: ifnull -167 -> 242
    //   412: aload 4
    //   414: invokevirtual 284	java/io/FileInputStream:close	()V
    //   417: iconst_0
    //   418: ireturn
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   424: iconst_0
    //   425: ireturn
    //   426: astore_1
    //   427: aconst_null
    //   428: astore 4
    //   430: aload 4
    //   432: astore_3
    //   433: aload_0
    //   434: getfield 185	agrt:a	Lagsc;
    //   437: ifnull +16 -> 453
    //   440: aload 4
    //   442: astore_3
    //   443: aload_0
    //   444: getfield 185	agrt:a	Lagsc;
    //   447: aconst_null
    //   448: invokeinterface 292 2 0
    //   453: aload 4
    //   455: astore_3
    //   456: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +35 -> 494
    //   462: aload 4
    //   464: astore_3
    //   465: ldc 41
    //   467: iconst_2
    //   468: new 84	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   475: ldc_w 300
    //   478: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_1
    //   482: invokevirtual 301	java/lang/IllegalStateException:toString	()Ljava/lang/String;
    //   485: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: aload 4
    //   496: astore_3
    //   497: aload_1
    //   498: invokevirtual 302	java/lang/IllegalStateException:printStackTrace	()V
    //   501: aload 4
    //   503: ifnull -261 -> 242
    //   506: aload 4
    //   508: invokevirtual 284	java/io/FileInputStream:close	()V
    //   511: iconst_0
    //   512: ireturn
    //   513: astore_1
    //   514: aload_1
    //   515: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   518: iconst_0
    //   519: ireturn
    //   520: astore_1
    //   521: aconst_null
    //   522: astore 4
    //   524: aload 4
    //   526: astore_3
    //   527: aload_0
    //   528: getfield 185	agrt:a	Lagsc;
    //   531: ifnull +21 -> 552
    //   534: aload 4
    //   536: astore_3
    //   537: aload_0
    //   538: getfield 185	agrt:a	Lagsc;
    //   541: ldc_w 303
    //   544: invokestatic 76	acfp:m	(I)Ljava/lang/String;
    //   547: invokeinterface 292 2 0
    //   552: aload 4
    //   554: astore_3
    //   555: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +35 -> 593
    //   561: aload 4
    //   563: astore_3
    //   564: ldc 41
    //   566: iconst_2
    //   567: new 84	java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   574: ldc_w 305
    //   577: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload_1
    //   581: invokevirtual 306	java/io/IOException:toString	()Ljava/lang/String;
    //   584: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: aload 4
    //   595: ifnull -353 -> 242
    //   598: aload 4
    //   600: invokevirtual 284	java/io/FileInputStream:close	()V
    //   603: iconst_0
    //   604: ireturn
    //   605: astore_1
    //   606: aload_1
    //   607: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   610: iconst_0
    //   611: ireturn
    //   612: astore_1
    //   613: aconst_null
    //   614: astore_3
    //   615: aload_3
    //   616: ifnull +7 -> 623
    //   619: aload_3
    //   620: invokevirtual 284	java/io/FileInputStream:close	()V
    //   623: aload_1
    //   624: athrow
    //   625: astore_3
    //   626: aload_3
    //   627: invokevirtual 287	java/io/IOException:printStackTrace	()V
    //   630: goto -7 -> 623
    //   633: astore_1
    //   634: goto -19 -> 615
    //   637: astore_1
    //   638: goto -114 -> 524
    //   641: astore_1
    //   642: goto -212 -> 430
    //   645: astore_1
    //   646: goto -303 -> 343
    //   649: astore_1
    //   650: goto -394 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	agrt
    //   0	653	1	paramString	String
    //   1	242	2	bool	boolean
    //   95	123	3	localFileInputStream1	java.io.FileInputStream
    //   244	2	3	localIOException1	java.io.IOException
    //   258	362	3	localFileInputStream2	java.io.FileInputStream
    //   625	2	3	localIOException2	java.io.IOException
    //   91	508	4	localFileInputStream3	java.io.FileInputStream
    //   186	24	5	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   230	235	244	java/io/IOException
    //   76	93	252	java/lang/IllegalArgumentException
    //   325	330	332	java/io/IOException
    //   76	93	339	java/lang/SecurityException
    //   412	417	419	java/io/IOException
    //   76	93	426	java/lang/IllegalStateException
    //   506	511	513	java/io/IOException
    //   76	93	520	java/io/IOException
    //   598	603	605	java/io/IOException
    //   76	93	612	finally
    //   619	623	625	java/io/IOException
    //   96	104	633	finally
    //   107	119	633	finally
    //   122	127	633	finally
    //   130	135	633	finally
    //   138	143	633	finally
    //   146	151	633	finally
    //   154	161	633	finally
    //   164	176	633	finally
    //   179	188	633	finally
    //   191	199	633	finally
    //   202	215	633	finally
    //   218	225	633	finally
    //   259	266	633	finally
    //   269	279	633	finally
    //   282	288	633	finally
    //   291	320	633	finally
    //   346	353	633	finally
    //   356	366	633	finally
    //   369	375	633	finally
    //   378	407	633	finally
    //   433	440	633	finally
    //   443	453	633	finally
    //   456	462	633	finally
    //   465	494	633	finally
    //   497	501	633	finally
    //   527	534	633	finally
    //   537	552	633	finally
    //   555	561	633	finally
    //   564	593	633	finally
    //   96	104	637	java/io/IOException
    //   107	119	637	java/io/IOException
    //   122	127	637	java/io/IOException
    //   130	135	637	java/io/IOException
    //   138	143	637	java/io/IOException
    //   146	151	637	java/io/IOException
    //   154	161	637	java/io/IOException
    //   164	176	637	java/io/IOException
    //   179	188	637	java/io/IOException
    //   191	199	637	java/io/IOException
    //   202	215	637	java/io/IOException
    //   218	225	637	java/io/IOException
    //   96	104	641	java/lang/IllegalStateException
    //   107	119	641	java/lang/IllegalStateException
    //   122	127	641	java/lang/IllegalStateException
    //   130	135	641	java/lang/IllegalStateException
    //   138	143	641	java/lang/IllegalStateException
    //   146	151	641	java/lang/IllegalStateException
    //   154	161	641	java/lang/IllegalStateException
    //   164	176	641	java/lang/IllegalStateException
    //   179	188	641	java/lang/IllegalStateException
    //   191	199	641	java/lang/IllegalStateException
    //   202	215	641	java/lang/IllegalStateException
    //   218	225	641	java/lang/IllegalStateException
    //   96	104	645	java/lang/SecurityException
    //   107	119	645	java/lang/SecurityException
    //   122	127	645	java/lang/SecurityException
    //   130	135	645	java/lang/SecurityException
    //   138	143	645	java/lang/SecurityException
    //   146	151	645	java/lang/SecurityException
    //   154	161	645	java/lang/SecurityException
    //   164	176	645	java/lang/SecurityException
    //   179	188	645	java/lang/SecurityException
    //   191	199	645	java/lang/SecurityException
    //   202	215	645	java/lang/SecurityException
    //   218	225	645	java/lang/SecurityException
    //   96	104	649	java/lang/IllegalArgumentException
    //   107	119	649	java/lang/IllegalArgumentException
    //   122	127	649	java/lang/IllegalArgumentException
    //   130	135	649	java/lang/IllegalArgumentException
    //   138	143	649	java/lang/IllegalArgumentException
    //   146	151	649	java/lang/IllegalArgumentException
    //   154	161	649	java/lang/IllegalArgumentException
    //   164	176	649	java/lang/IllegalArgumentException
    //   179	188	649	java/lang/IllegalArgumentException
    //   191	199	649	java/lang/IllegalArgumentException
    //   202	215	649	java/lang/IllegalArgumentException
    //   218	225	649	java/lang/IllegalArgumentException
  }
  
  public boolean isPlaying()
  {
    if (this.mediaPlayer == null) {
      return false;
    }
    return this.mediaPlayer.isPlaying();
  }
  
  public boolean mD(String paramString)
  {
    return (this.bJi != null) && (this.bJi.equalsIgnoreCase(paramString) == true);
  }
  
  public void onAudioFocusChange(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!this.mediaPlayer.isPlaying());
      pause();
      return;
    } while (this.mediaPlayer == null);
    this.mediaPlayer.setVolume(0.1F, 0.1F);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.mediaPlayer.seekTo(0);
    if (this.a != null) {
      this.a.onCompletion();
    }
    if (this.aG != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.aG);
      this.aG = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().b(true, 25, Boolean.valueOf(true));
      this.ceZ = false;
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
        }
      }
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "what[" + paramInt1 + "],extra[" + paramInt2 + "]");
    }
    if (this.a != null) {
      this.a.onError(acfp.m(2131706316));
    }
    this.mediaPlayer.release();
    this.mediaPlayer = null;
    this.bJi = null;
    if (this.aG != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.aG);
      this.aG = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().b(true, 25, Boolean.valueOf(true));
      return true;
    }
    catch (Exception paramMediaPlayer)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
    }
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    this.cfa = true;
    Ye();
    if ((this.mediaPlayer != null) && (this.cfc)) {
      this.mediaPlayer.seekTo(this.bQC);
    }
  }
  
  public void pause()
  {
    if ((this.mediaPlayer != null) && (this.mediaPlayer.isPlaying())) {
      this.mediaPlayer.pause();
    }
    this.ceZ = false;
    if (this.aG != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.aG);
      this.aG = null;
    }
    if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
      QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
    }
    try
    {
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().b(true, 25, Boolean.valueOf(true));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
    }
  }
  
  public void resume()
  {
    if ((this.mediaPlayer != null) && (this.ceZ)) {
      try
      {
        if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1) == 0)
        {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not get audio focus");
          return;
        }
        this.mediaPlayer.start();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void start()
  {
    this.ceZ = true;
    this.cfb = true;
    Ye();
  }
  
  public void stop()
  {
    if (this.mediaPlayer != null)
    {
      this.mediaPlayer.stop();
      this.mediaPlayer.release();
      this.mediaPlayer = null;
    }
    if (this.aG != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.aG);
      this.aG = null;
    }
    try
    {
      if (((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).abandonAudioFocus(this) == 0) {
        QLog.e("FileViewMusicService<FileAssistant>", 2, "fileviewer mediaplayservice can not abandon audio focus");
      }
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().b(true, 25, Boolean.valueOf(true));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileViewMusicService<FileAssistant>", 2, "FileViewMusicService get QQAppInterface failed!!!");
        }
      }
    }
    this.bJi = null;
  }
  
  public String vI()
  {
    return ahav.getFileName(this.bJi);
  }
  
  public String vJ()
  {
    return this.bJi;
  }
  
  public static abstract interface a
  {
    public abstract void Ot(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrt
 * JD-Core Version:    0.7.0.1
 */