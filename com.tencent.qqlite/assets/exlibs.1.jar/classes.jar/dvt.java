import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;

public class dvt
  implements AudioManager.OnAudioFocusChangeListener
{
  public dvt(FileViewMusicService paramFileViewMusicService) {}
  
  /* Error */
  public void onAudioFocusChange(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 28
    //   8: iconst_2
    //   9: new 30	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   16: ldc 33
    //   18: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_1
    //   22: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   35: astore_2
    //   36: aload_2
    //   37: monitorenter
    //   38: iload_1
    //   39: tableswitch	default:+33 -> 72, -3:+171->210, -2:+36->75, -1:+36->75, 0:+33->72, 1:+225->264
    //   73: monitorexit
    //   74: return
    //   75: aload_0
    //   76: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   79: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   82: ifnull +51 -> 133
    //   85: aload_0
    //   86: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   89: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   92: invokevirtual 58	android/media/MediaPlayer:isPlaying	()Z
    //   95: ifeq +38 -> 133
    //   98: aload_0
    //   99: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   102: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   105: invokevirtual 61	android/media/MediaPlayer:pause	()V
    //   108: invokestatic 66	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   111: invokevirtual 69	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   114: checkcast 71	com/tencent/mobileqq/app/QQAppInterface
    //   117: checkcast 71	com/tencent/mobileqq/app/QQAppInterface
    //   120: invokevirtual 74	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   123: iconst_1
    //   124: bipush 25
    //   126: iconst_1
    //   127: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   130: invokevirtual 85	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(ZILjava/lang/Object;)V
    //   133: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq -64 -> 72
    //   139: ldc 28
    //   141: iconst_2
    //   142: ldc 87
    //   144: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: goto -75 -> 72
    //   150: astore_3
    //   151: aload_2
    //   152: monitorexit
    //   153: aload_3
    //   154: athrow
    //   155: astore_2
    //   156: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +210 -> 369
    //   162: ldc 28
    //   164: iconst_2
    //   165: new 30	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   172: ldc 89
    //   174: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_2
    //   178: invokevirtual 92	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aload_2
    //   188: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: return
    //   192: astore_3
    //   193: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq -63 -> 133
    //   199: ldc 28
    //   201: iconst_2
    //   202: ldc 97
    //   204: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -74 -> 133
    //   210: aload_0
    //   211: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   214: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   217: ifnull +30 -> 247
    //   220: aload_0
    //   221: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   224: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   227: invokevirtual 58	android/media/MediaPlayer:isPlaying	()Z
    //   230: ifeq +17 -> 247
    //   233: aload_0
    //   234: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   237: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   240: ldc 101
    //   242: ldc 101
    //   244: invokevirtual 105	android/media/MediaPlayer:setVolume	(FF)V
    //   247: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq -178 -> 72
    //   253: ldc 28
    //   255: iconst_2
    //   256: ldc 107
    //   258: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: goto -189 -> 72
    //   264: aload_0
    //   265: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   268: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   271: ifnull +63 -> 334
    //   274: aload_0
    //   275: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   278: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   281: invokevirtual 58	android/media/MediaPlayer:isPlaying	()Z
    //   284: ifne +50 -> 334
    //   287: aload_0
    //   288: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   291: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   294: fconst_1
    //   295: fconst_1
    //   296: invokevirtual 105	android/media/MediaPlayer:setVolume	(FF)V
    //   299: aload_0
    //   300: getfield 12	dvt:a	Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   303: invokestatic 53	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	(Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;)Landroid/media/MediaPlayer;
    //   306: invokevirtual 110	android/media/MediaPlayer:start	()V
    //   309: invokestatic 66	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   312: invokevirtual 69	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   315: checkcast 71	com/tencent/mobileqq/app/QQAppInterface
    //   318: checkcast 71	com/tencent/mobileqq/app/QQAppInterface
    //   321: invokevirtual 74	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   324: iconst_1
    //   325: bipush 25
    //   327: iconst_1
    //   328: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   331: invokevirtual 85	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(ZILjava/lang/Object;)V
    //   334: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq -265 -> 72
    //   340: ldc 28
    //   342: iconst_2
    //   343: ldc 112
    //   345: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: goto -276 -> 72
    //   351: astore_3
    //   352: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq -21 -> 334
    //   358: ldc 28
    //   360: iconst_2
    //   361: ldc 97
    //   363: invokestatic 100	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: goto -32 -> 334
    //   369: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	dvt
    //   0	370	1	paramInt	int
    //   35	117	2	localFileViewMusicService	FileViewMusicService
    //   155	33	2	localException1	java.lang.Exception
    //   150	4	3	localObject	Object
    //   192	1	3	localException2	java.lang.Exception
    //   351	1	3	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   72	74	150	finally
    //   75	108	150	finally
    //   108	133	150	finally
    //   133	147	150	finally
    //   151	153	150	finally
    //   193	207	150	finally
    //   210	247	150	finally
    //   247	261	150	finally
    //   264	309	150	finally
    //   309	334	150	finally
    //   334	348	150	finally
    //   352	366	150	finally
    //   31	38	155	java/lang/Exception
    //   153	155	155	java/lang/Exception
    //   108	133	192	java/lang/Exception
    //   309	334	351	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dvt
 * JD-Core Version:    0.7.0.1
 */