package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.Settings.System;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import evg;
import evh;
import java.io.IOException;
import mqq.app.AppRuntime;

public class AudioUtil
{
  private static int a;
  public static MediaPlayer a;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    return ((AudioManager)BaseApplicationImpl.a.getSystemService("audio")).getRingerMode();
  }
  
  private static MediaPlayer a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = paramContext.getResources().openRawResourceFd(paramInt);
      if (paramContext == null) {
        return null;
      }
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
      paramContext.close();
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramContext);
      }
    }
    return null;
  }
  
  private static MediaPlayer a(Context paramContext, Uri paramUri)
  {
    try
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      a(localMediaPlayer);
      localMediaPlayer.setDataSource(paramContext, paramUri);
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("createAndSetAudioStreamType", 2, "create failed:", paramContext);
      }
    }
    return null;
  }
  
  public static void a()
  {
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      label12:
      jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  /* Error */
  public static void a(int paramInt1, int paramInt2, android.media.MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +28 -> 34
    //   9: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   12: invokevirtual 105	android/media/MediaPlayer:isPlaying	()Z
    //   15: istore_3
    //   16: iload_3
    //   17: ifeq +7 -> 24
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   27: invokevirtual 101	android/media/MediaPlayer:release	()V
    //   30: aconst_null
    //   31: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   34: iload_0
    //   35: getstatic 110	com/tencent/common/config/AppSetting:e	I
    //   38: if_icmpeq +109 -> 147
    //   41: getstatic 21	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   44: iload_0
    //   45: invokestatic 113	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   48: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   51: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   54: ifnull -34 -> 20
    //   57: iload_1
    //   58: putstatic 11	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   61: getstatic 11	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   64: ifeq +11 -> 75
    //   67: getstatic 11	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   70: iconst_1
    //   71: isub
    //   72: putstatic 11	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_Int	I
    //   75: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   78: new 115	evi
    //   81: dup
    //   82: aload_2
    //   83: invokespecial 118	evi:<init>	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   86: invokevirtual 121	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   89: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   92: invokevirtual 124	android/media/MediaPlayer:start	()V
    //   95: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   98: iconst_0
    //   99: invokevirtual 128	android/media/MediaPlayer:setLooping	(Z)V
    //   102: goto -82 -> 20
    //   105: astore 4
    //   107: aload_2
    //   108: ifnull -88 -> 20
    //   111: aload_2
    //   112: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   115: invokeinterface 133 2 0
    //   120: goto -100 -> 20
    //   123: astore_2
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: astore 4
    //   131: aconst_null
    //   132: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   135: goto -101 -> 34
    //   138: astore 4
    //   140: aconst_null
    //   141: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   144: aload 4
    //   146: athrow
    //   147: getstatic 21	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   150: getstatic 139	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   153: invokestatic 141	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   156: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   159: goto -108 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramInt1	int
    //   0	162	1	paramInt2	int
    //   0	162	2	paramOnCompletionListener	android.media.MediaPlayer.OnCompletionListener
    //   15	2	3	bool	boolean
    //   105	1	4	localException1	Exception
    //   129	1	4	localException2	Exception
    //   138	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	105	java/lang/Exception
    //   30	34	105	java/lang/Exception
    //   34	51	105	java/lang/Exception
    //   51	75	105	java/lang/Exception
    //   75	102	105	java/lang/Exception
    //   131	135	105	java/lang/Exception
    //   140	147	105	java/lang/Exception
    //   147	159	105	java/lang/Exception
    //   3	16	123	finally
    //   30	34	123	finally
    //   34	51	123	finally
    //   51	75	123	finally
    //   75	102	123	finally
    //   111	120	123	finally
    //   131	135	123	finally
    //   140	147	123	finally
    //   147	159	123	finally
    //   24	30	129	java/lang/Exception
    //   24	30	138	finally
  }
  
  public static void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("mediaPlayerStartForMsg", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
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
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("mediaPlayerStartForMsg", 2, "media palyer release exception", localException2);
        label167:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.e)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplicationImpl.a, paramInt);
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("mediaPlayerStartForMsg", 2, "media palyer is null");
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = a(BaseApplicationImpl.a, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("mediaPlayerStartForMsg", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new evg());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  /* Error */
  public static void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, android.media.MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +28 -> 34
    //   9: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   12: invokevirtual 105	android/media/MediaPlayer:isPlaying	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +7 -> 24
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   27: invokevirtual 101	android/media/MediaPlayer:release	()V
    //   30: aconst_null
    //   31: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   34: iload_0
    //   35: getstatic 110	com/tencent/common/config/AppSetting:e	I
    //   38: if_icmpeq +68 -> 106
    //   41: getstatic 21	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   44: iload_0
    //   45: invokestatic 113	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   48: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   51: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   54: ifnull -34 -> 20
    //   57: aload_3
    //   58: ifnull +63 -> 121
    //   61: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   64: aload_3
    //   65: invokevirtual 121	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   68: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   71: invokevirtual 124	android/media/MediaPlayer:start	()V
    //   74: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   77: iload_1
    //   78: invokevirtual 128	android/media/MediaPlayer:setLooping	(Z)V
    //   81: goto -61 -> 20
    //   84: astore 4
    //   86: aconst_null
    //   87: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   90: goto -56 -> 34
    //   93: astore_3
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_3
    //   98: athrow
    //   99: astore_3
    //   100: aconst_null
    //   101: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   104: aload_3
    //   105: athrow
    //   106: getstatic 21	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   109: getstatic 139	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   112: invokestatic 141	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   115: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   118: goto -67 -> 51
    //   121: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   124: new 196	evj
    //   127: dup
    //   128: invokespecial 197	evj:<init>	()V
    //   131: invokevirtual 121	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   134: goto -66 -> 68
    //   137: astore_3
    //   138: goto -118 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramInt	int
    //   0	141	1	paramBoolean1	boolean
    //   0	141	2	paramBoolean2	boolean
    //   0	141	3	paramOnCompletionListener	android.media.MediaPlayer.OnCompletionListener
    //   84	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   24	30	84	java/lang/Exception
    //   3	16	93	finally
    //   30	34	93	finally
    //   34	51	93	finally
    //   51	57	93	finally
    //   61	68	93	finally
    //   68	81	93	finally
    //   86	90	93	finally
    //   100	106	93	finally
    //   106	118	93	finally
    //   121	134	93	finally
    //   24	30	99	finally
    //   3	16	137	java/lang/Exception
    //   30	34	137	java/lang/Exception
    //   34	51	137	java/lang/Exception
    //   51	57	137	java/lang/Exception
    //   61	68	137	java/lang/Exception
    //   68	81	137	java/lang/Exception
    //   86	90	137	java/lang/Exception
    //   100	106	137	java/lang/Exception
    //   106	118	137	java/lang/Exception
    //   121	134	137	java/lang/Exception
  }
  
  private static void a(MediaPlayer paramMediaPlayer)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      paramMediaPlayer.setAudioStreamType(3);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MediaPlayerStart", 2, "get QQAppInterface error");
  }
  
  /* Error */
  public static void a(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +13 -> 21
    //   11: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   14: invokevirtual 101	android/media/MediaPlayer:release	()V
    //   17: aconst_null
    //   18: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: aload_0
    //   22: invokevirtual 219	android/net/Uri:getScheme	()Ljava/lang/String;
    //   25: ldc 221
    //   27: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +127 -> 157
    //   33: new 49	android/media/MediaPlayer
    //   36: dup
    //   37: invokespecial 50	android/media/MediaPlayer:<init>	()V
    //   40: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   43: iload_2
    //   44: ifeq +23 -> 67
    //   47: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +11 -> 61
    //   53: ldc 229
    //   55: iconst_2
    //   56: ldc 231
    //   58: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   64: invokestatic 53	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   67: new 233	java/io/FileInputStream
    //   70: dup
    //   71: new 235	java/io/File
    //   74: dup
    //   75: aload_0
    //   76: invokevirtual 238	android/net/Uri:getPath	()Ljava/lang/String;
    //   79: invokespecial 241	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 244	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: astore_0
    //   86: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   89: aload_0
    //   90: invokevirtual 247	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   93: invokevirtual 250	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   96: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   99: invokevirtual 76	android/media/MediaPlayer:prepare	()V
    //   102: aload_0
    //   103: invokevirtual 251	java/io/FileInputStream:close	()V
    //   106: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   109: new 253	evk
    //   112: dup
    //   113: invokespecial 254	evk:<init>	()V
    //   116: invokevirtual 121	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   119: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   122: invokevirtual 124	android/media/MediaPlayer:start	()V
    //   125: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   128: iload_1
    //   129: invokevirtual 128	android/media/MediaPlayer:setLooping	(Z)V
    //   132: ldc 2
    //   134: monitorexit
    //   135: return
    //   136: astore_3
    //   137: aconst_null
    //   138: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   141: goto -120 -> 21
    //   144: astore_0
    //   145: aconst_null
    //   146: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   149: aload_0
    //   150: athrow
    //   151: astore_0
    //   152: ldc 2
    //   154: monitorexit
    //   155: aload_0
    //   156: athrow
    //   157: getstatic 21	com/tencent/common/app/BaseApplicationImpl:a	Lcom/tencent/common/app/BaseApplicationImpl;
    //   160: aload_0
    //   161: invokestatic 141	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   164: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   167: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   170: ifnull -38 -> 132
    //   173: iload_2
    //   174: ifeq -68 -> 106
    //   177: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +11 -> 191
    //   183: ldc 229
    //   185: iconst_2
    //   186: ldc 231
    //   188: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   194: invokestatic 53	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   197: goto -91 -> 106
    //   200: astore_0
    //   201: goto -69 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramUri	Uri
    //   0	204	1	paramBoolean1	boolean
    //   0	204	2	paramBoolean2	boolean
    //   6	2	3	localMediaPlayer	MediaPlayer
    //   136	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	17	136	java/lang/Exception
    //   11	17	144	finally
    //   3	7	151	finally
    //   17	21	151	finally
    //   21	43	151	finally
    //   47	61	151	finally
    //   61	67	151	finally
    //   67	106	151	finally
    //   106	132	151	finally
    //   137	141	151	finally
    //   145	151	151	finally
    //   157	173	151	finally
    //   177	191	151	finally
    //   191	197	151	finally
    //   3	7	200	java/lang/Exception
    //   17	21	200	java/lang/Exception
    //   21	43	200	java/lang/Exception
    //   47	61	200	java/lang/Exception
    //   61	67	200	java/lang/Exception
    //   67	106	200	java/lang/Exception
    //   106	132	200	java/lang/Exception
    //   137	141	200	java/lang/Exception
    //   145	151	200	java/lang/Exception
    //   157	173	200	java/lang/Exception
    //   177	191	200	java/lang/Exception
    //   191	197	200	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.lang.String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +28 -> 34
    //   9: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   12: invokevirtual 105	android/media/MediaPlayer:isPlaying	()Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +7 -> 24
    //   20: ldc 2
    //   22: monitorexit
    //   23: return
    //   24: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   27: invokevirtual 101	android/media/MediaPlayer:release	()V
    //   30: aconst_null
    //   31: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   34: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   37: ifnonnull +13 -> 50
    //   40: new 49	android/media/MediaPlayer
    //   43: dup
    //   44: invokespecial 50	android/media/MediaPlayer:<init>	()V
    //   47: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   50: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   53: invokevirtual 258	android/media/MediaPlayer:reset	()V
    //   56: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   59: new 233	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   67: invokevirtual 247	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   70: invokevirtual 250	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   73: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   76: invokestatic 53	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/media/MediaPlayer;)V
    //   79: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   82: invokevirtual 76	android/media/MediaPlayer:prepare	()V
    //   85: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   88: new 261	evf
    //   91: dup
    //   92: invokespecial 262	evf:<init>	()V
    //   95: invokevirtual 121	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   98: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   101: invokevirtual 124	android/media/MediaPlayer:start	()V
    //   104: getstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   107: iload_1
    //   108: invokevirtual 128	android/media/MediaPlayer:setLooping	(Z)V
    //   111: goto -91 -> 20
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   119: goto -99 -> 20
    //   122: astore_0
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    //   128: astore_3
    //   129: aconst_null
    //   130: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   133: goto -99 -> 34
    //   136: astore_0
    //   137: aconst_null
    //   138: putstatic 98	com/tencent/mobileqq/utils/AudioUtil:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   141: aload_0
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	java.lang.String
    //   0	143	1	paramBoolean	boolean
    //   15	2	2	bool	boolean
    //   128	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	16	114	java/lang/Exception
    //   30	34	114	java/lang/Exception
    //   34	50	114	java/lang/Exception
    //   50	111	114	java/lang/Exception
    //   129	133	114	java/lang/Exception
    //   137	143	114	java/lang/Exception
    //   3	16	122	finally
    //   30	34	122	finally
    //   34	50	122	finally
    //   50	111	122	finally
    //   115	119	122	finally
    //   129	133	122	finally
    //   137	143	122	finally
    //   24	30	128	java/lang/Exception
    //   24	30	136	finally
  }
  
  @TargetApi(8)
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "context is null.");
      }
    }
    do
    {
      return false;
      if (VersionUtils.b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AudioUtil", 2, "Android 2.1 and below can not stop music");
    return false;
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramBoolean) {
      if (paramContext.requestAudioFocus(null, 3, 2) == 1) {
        bool = true;
      }
    }
    while (paramContext.abandonAudioFocus(null) == 1) {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioUtil", 2, "pauseMusic bMute=" + paramBoolean + " result=" + bool);
        }
        return bool;
        bool = false;
      }
    }
    for (;;)
    {
      bool = false;
    }
  }
  
  public static void b(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerStart", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
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
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label167;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer release exception", localException2);
        label167:
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != AppSetting.e)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.a, paramInt);
        if (jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("MediaPlayerStart", 2, "media palyer is null");
        }
      }
      else
      {
        jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(BaseApplicationImpl.a, Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MediaPlayerStart", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new evh());
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AudioUtil
 * JD-Core Version:    0.7.0.1
 */