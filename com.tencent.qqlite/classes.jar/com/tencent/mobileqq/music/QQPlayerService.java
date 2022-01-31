package com.tencent.mobileqq.music;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.MusicCacheManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import dzn;
import dzo;
import dzp;
import dzq;
import dzr;
import dzs;
import dzt;
import dzu;
import dzv;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Random;

@SuppressLint({"NewApi"})
public class QQPlayerService
  extends Service
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Constants.PlayMode, Constants.PlayState
{
  public static long a = 0L;
  private static Intent jdField_a_of_type_AndroidContentIntent;
  private static MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  private static SongInfo jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  public static final String a = "QQPlayerService";
  private static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private static SongInfo[] jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  public static long b = 0L;
  public static final String b = "musicplayer.action";
  private static WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  public static final String c = "musicplayer.isDelFileOnDonwloadThreadOver";
  public static final String d = "qqplayer_exit_action";
  private static boolean d = Utils.a();
  public static final String e = "musicplayer.song";
  private static String f;
  private static final String g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/QQLite/qqmusic/";
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 4;
  public static final int m = 5;
  public static final int n = 1;
  public static final int o = 2;
  public static final int p = 3;
  public static final int q = 4;
  public static final int r = 5;
  public static final int s = 6;
  private static int u = 0;
  private static int v = 103;
  private static int w = -1;
  private static int y = 0;
  private static final int z = 4000;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private volatile Looper jdField_a_of_type_AndroidOsLooper;
  private RemoteCallbackList jdField_a_of_type_AndroidOsRemoteCallbackList;
  private IQQPlayerService.Stub jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService$Stub = new dzs(this);
  public dzt a;
  private dzu jdField_a_of_type_Dzu;
  private volatile dzv jdField_a_of_type_Dzv;
  private Object jdField_a_of_type_JavaLangObject;
  public boolean a;
  private volatile boolean jdField_b_of_type_Boolean = false;
  public long c;
  private volatile boolean c;
  public int t = 102400;
  private int x = 0;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    y = 0;
    d = false;
  }
  
  public QQPlayerService()
  {
    this.jdField_c_of_type_Long = 500L;
    this.jdField_a_of_type_Dzt = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public static int a()
  {
    return u;
  }
  
  public static Intent a()
  {
    return jdField_a_of_type_AndroidContentIntent;
  }
  
  public static Bundle a()
  {
    return jdField_a_of_type_AndroidOsBundle;
  }
  
  public static QQPlayerService.QQPlayerCallback a()
  {
    if (jdField_b_of_type_JavaLangRefWeakReference != null) {
      return (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public static SongInfo a()
  {
    return jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
  }
  
  public static String a()
  {
    return f;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknow action";
    case 2: 
      return "start";
    case 3: 
      return "stop";
    case 4: 
      return "loopProgress";
    case 6: 
      return "pause";
    }
    return "resume";
  }
  
  public static String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "generateToken unknown callerType");
      }
      return null;
    case 1: 
      return "aio_" + paramString;
    case 2: 
      return "fav_" + paramString;
    case 3: 
      return "music_gene_" + paramString;
    case 4: 
      return "qzone_" + paramString;
    }
    return "troopbar_" + paramString;
  }
  
  private static String a(String paramString)
  {
    if (paramString != null) {
      return MD5.toMD5(paramString);
    }
    return null;
  }
  
  public static void a(int paramInt)
  {
    v = paramInt;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "pausePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 6);
    paramContext.startService(localIntent);
  }
  
  private static void a(Context paramContext, SongInfo paramSongInfo)
  {
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 2);
    localIntent.putExtra("musicplayer.song", paramSongInfo);
    paramContext.startService(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, SongInfo paramSongInfo)
  {
    try
    {
      a(100);
      a(paramContext, paramString, new SongInfo[] { paramSongInfo });
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo)
  {
    a(paramContext, paramString, paramArrayOfSongInfo, 0);
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull +8 -> 12
    //   7: aload_2
    //   8: arraylength
    //   9: ifne +20 -> 29
    //   12: new 268	java/lang/IllegalArgumentException
    //   15: dup
    //   16: ldc_w 270
    //   19: invokespecial 273	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    //   29: aload_1
    //   30: ifnull +13 -> 43
    //   33: aload_1
    //   34: ldc_w 275
    //   37: invokevirtual 281	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +14 -> 54
    //   43: new 268	java/lang/IllegalArgumentException
    //   46: dup
    //   47: ldc_w 283
    //   50: invokespecial 273	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: iload_3
    //   55: iflt +11 -> 66
    //   58: iload_3
    //   59: aload_2
    //   60: arraylength
    //   61: iconst_1
    //   62: isub
    //   63: if_icmple +14 -> 77
    //   66: new 268	java/lang/IllegalArgumentException
    //   69: dup
    //   70: ldc_w 285
    //   73: invokespecial 273	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +52 -> 132
    //   83: ldc 30
    //   85: iconst_2
    //   86: new 106	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 287
    //   96: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: arraylength
    //   101: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc_w 292
    //   107: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload_3
    //   111: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc_w 294
    //   117: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 89	com/tencent/mobileqq/music/QQPlayerService:v	I
    //   123: invokevirtual 290	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_1
    //   133: putstatic 188	com/tencent/mobileqq/music/QQPlayerService:f	Ljava/lang/String;
    //   136: aload_2
    //   137: putstatic 296	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   140: getstatic 232	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   143: ifnull +28 -> 171
    //   146: iconst_0
    //   147: putstatic 87	com/tencent/mobileqq/music/QQPlayerService:u	I
    //   150: getstatic 232	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   153: invokevirtual 181	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   156: checkcast 183	com/tencent/mobileqq/music/QQPlayerService$QQPlayerCallback
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +29 -> 190
    //   164: aload_1
    //   165: iconst_0
    //   166: invokeinterface 299 2 0
    //   171: iload_3
    //   172: putstatic 91	com/tencent/mobileqq/music/QQPlayerService:w	I
    //   175: aload_0
    //   176: getstatic 296	com/tencent/mobileqq/music/QQPlayerService:jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo	[Lcom/tencent/mobileqq/music/SongInfo;
    //   179: getstatic 91	com/tencent/mobileqq/music/QQPlayerService:w	I
    //   182: aaload
    //   183: invokestatic 301	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/content/Context;Lcom/tencent/mobileqq/music/SongInfo;)V
    //   186: ldc 2
    //   188: monitorexit
    //   189: return
    //   190: invokestatic 207	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq -22 -> 171
    //   196: ldc 30
    //   198: iconst_2
    //   199: ldc_w 303
    //   202: invokestatic 305	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: goto -34 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramContext	Context
    //   0	208	1	paramString	String
    //   0	208	2	paramArrayOfSongInfo	SongInfo[]
    //   0	208	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   7	12	23	finally
    //   12	23	23	finally
    //   33	43	23	finally
    //   43	54	23	finally
    //   58	66	23	finally
    //   66	77	23	finally
    //   77	132	23	finally
    //   132	160	23	finally
    //   164	171	23	finally
    //   171	186	23	finally
    //   190	205	23	finally
  }
  
  public static void a(Intent paramIntent)
  {
    jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public static void a(Bundle paramBundle)
  {
    jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public static void a(QQPlayerService.QQPlayerCallback paramQQPlayerCallback)
  {
    if (paramQQPlayerCallback != null)
    {
      f = paramQQPlayerCallback.getToken();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "setCallback: sToken=" + f);
      }
      jdField_a_of_type_JavaLangRefWeakReference = jdField_b_of_type_JavaLangRefWeakReference;
      jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQPlayerCallback);
    }
  }
  
  private void a(SongInfo paramSongInfo)
  {
    int i1 = 0;
    if (paramSongInfo == null) {
      try
      {
        throw new IllegalArgumentException("newSong shouldn't be null!");
      }
      finally {}
    }
    y = 0;
    jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramSongInfo;
    e();
    QQPlayerService.QQPlayerCallback localQQPlayerCallback;
    if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      localQQPlayerCallback = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:newSong=" + paramSongInfo.b + ",local callback=" + localQQPlayerCallback);
      }
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break label204;
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new dzo(this, localQQPlayerCallback, paramSongInfo));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidOsRemoteCallbackList == null) {
        break label244;
      }
      int i2 = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      label175:
      if (i1 < i2) {
        try
        {
          ((IQQPlayerCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i1)).a(paramSongInfo);
          i1 += 1;
          break label175;
          label204:
          localQQPlayerCallback.onPlaySongChanged(paramSongInfo);
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
    label244:
  }
  
  public static void a(String paramString)
  {
    ComponentName localComponentName = ComponentName.unflattenFromString(paramString);
    if ((localComponentName == null) && (QLog.isColorLevel())) {
      QLog.e("QQPlayerService", 2, "setPlayBarIntent : ComponentName unflattenFromString failure, componentString=" + paramString);
    }
    paramString = new Intent();
    paramString.setComponent(localComponentName);
    jdField_a_of_type_AndroidContentIntent = paramString;
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlaying : sPlayState " + b(u));
    }
    return (u == 2) || (u == 1);
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playPrev");
    }
    SongInfo localSongInfo = c();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    c(paramContext);
    return false;
  }
  
  public static boolean a(QQPlayerService.QQPlayerCallback paramQQPlayerCallback)
  {
    if (((u != 2) && (u != 1)) || (paramQQPlayerCallback == null)) {
      return false;
    }
    if (jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      QQPlayerService.QQPlayerCallback localQQPlayerCallback = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((localQQPlayerCallback != null) && (localQQPlayerCallback == paramQQPlayerCallback)) {
        return true;
      }
    }
    paramQQPlayerCallback = paramQQPlayerCallback.getToken();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlayingMySong:callback.getToken()=" + paramQQPlayerCallback + ",sToken=" + f);
    }
    if (f != null) {
      return f.equals(paramQQPlayerCallback);
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if ((u != 2) && (u != 1)) {}
    while (f == null) {
      return false;
    }
    return f.equals(paramString);
  }
  
  public static SongInfo[] a()
  {
    return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo;
  }
  
  public static int b()
  {
    return v;
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " Unknow playState ";
    case 0: 
      return " IDLE ";
    case 1: 
      return " BUFFERING ";
    case 2: 
      return " PLAYING ";
    case 3: 
      return " PAUSE ";
    case 4: 
      return " STOP ";
    case 5: 
      return " ERROR_INTERNAL ";
    case 7: 
      return " ERROR_SERVER ";
    }
    return " NETWORK_INTERRUPT ";
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQPlayerService");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsLooper = this.jdField_a_of_type_AndroidOsHandlerThread.getLooper();
    this.jdField_a_of_type_Dzv = new dzv(this, this.jdField_a_of_type_AndroidOsLooper);
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 7) && (paramInt != 5) && (paramInt != 6)) {
      try
      {
        throw new IllegalArgumentException("playState value " + paramInt + " is illegal.");
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:" + b(u) + " =====> " + b(paramInt));
    }
    u = paramInt;
    if ((u == 2) || (u == 1)) {
      e();
    }
    for (;;)
    {
      QQPlayerService.QQPlayerCallback localQQPlayerCallback;
      label280:
      int i1;
      if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        localQQPlayerCallback = (QQPlayerService.QQPlayerCallback)jdField_b_of_type_JavaLangRefWeakReference.get();
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:playState=" + b(paramInt) + ",local callback=" + localQQPlayerCallback);
        }
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new dzp(this, localQQPlayerCallback, paramInt));
          if (this.jdField_a_of_type_AndroidOsRemoteCallbackList == null) {
            break label399;
          }
          int i2 = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
          i1 = 0;
          label297:
          if (i1 >= i2) {
            break label392;
          }
        }
      }
      try
      {
        ((IQQPlayerCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i1)).a(paramInt);
        i1 += 1;
        break label297;
        f();
        continue;
        localQQPlayerCallback.onPlayStateChanged(u);
        break label280;
        if ((jdField_b_of_type_JavaLangRefWeakReference != null) || (!QLog.isColorLevel())) {
          break label280;
        }
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify: sCallback = null! ");
      }
      catch (RemoteException localRemoteException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "changePlaySongAndNotify", localRemoteException);
          }
        }
      }
    }
    label392:
    this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
    label399:
    if (u == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "PLAY_STATE_ERROR_INTERNAL ======> post runnable to retry play media");
      }
      this.jdField_a_of_type_Dzv.postDelayed(new dzq(this), 4000L);
    }
  }
  
  public static void b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "resumePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 5);
    paramContext.startService(localIntent);
  }
  
  private void b(Intent paramIntent)
  {
    jdField_a_of_type_Long = SystemClock.uptimeMillis();
    if (paramIntent == null) {}
    int i1;
    do
    {
      do
      {
        do
        {
          return;
          try
          {
            i1 = paramIntent.getIntExtra("musicplayer.action", 0);
            if (!QLog.isColorLevel()) {
              break label895;
            }
            QLog.d("QQPlayerService", 2, "action->" + a(i1));
          }
          catch (Throwable paramIntent) {}
          paramIntent = (SongInfo)paramIntent.getParcelableExtra("musicplayer.song");
          if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.jdField_a_of_type_JavaLangString))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQPlayerService", 2, "mediaPlayStart, url is null");
        return;
      } while (!QLog.isColorLevel());
      QLog.e("QQPlayerService", 2, "onHandleIntent error" + paramIntent.getMessage(), paramIntent);
      return;
      if ((jdField_a_of_type_AndroidMediaMediaPlayer != null) && (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_c_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqMusicSongInfo = paramIntent;
      a(jdField_a_of_type_ComTencentMobileqqMusicSongInfo);
      b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
      return;
    } while ((u != 2) && ((u != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer == null)));
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
    this.jdField_c_of_type_Boolean = true;
    b(3);
    return;
    if ((u == 3) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
    {
      this.jdField_c_of_type_Boolean = false;
      i1 = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject, 3, 1);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder().append("requestAudioFocus,result:");
        if (i1 != 1) {
          break label937;
        }
      }
    }
    label774:
    label777:
    label937:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQPlayerService", 2, bool);
      jdField_a_of_type_AndroidMediaMediaPlayer.start();
      b(2);
      return;
      if ((u == 6) || (u == 7))
      {
        if (!NetworkUtil.f(getApplicationContext())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "resume from network interrupt, start play " + jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b);
        }
        this.jdField_c_of_type_Boolean = false;
        b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
        return;
      }
      if (u != 5) {
        break;
      }
      this.jdField_c_of_type_Boolean = false;
      b(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString);
      return;
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_c_of_type_Boolean = false;
      if ((this.jdField_a_of_type_Dzt != null) && (this.jdField_a_of_type_Dzt.isAlive()) && (!this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean = true;
      }
      b(4);
      if ((f != null) && (f.startsWith("qzone_")) && (jdField_a_of_type_AndroidMediaMediaPlayer != null))
      {
        this.jdField_c_of_type_Boolean = true;
        w = 0;
        jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
      }
      stopSelf();
      return;
      try
      {
        paramIntent = this.jdField_a_of_type_Dzt;
        if ((paramIntent == null) || (jdField_a_of_type_AndroidMediaMediaPlayer == null) || (!paramIntent.isAlive()) || (!paramIntent.jdField_c_of_type_Boolean) || (paramIntent.jdField_a_of_type_Boolean) || (!paramIntent.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_Boolean) || (y == 0)) {
          break label774;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, current playing song isDownloading...");
        }
        if ((!jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) || (this.jdField_b_of_type_Boolean)) {
          break label777;
        }
        i1 = e();
        if (i1 / y * paramIntent.b + this.t >= y)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data is ok, just return;");
          }
          return;
        }
      }
      finally {}
      float f1 = i1;
      if (f1 / y * paramIntent.b + this.t > paramIntent.jdField_a_of_type_Int)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS,no more data to play, need pause!");
        }
        this.x = i1;
        this.jdField_b_of_type_Boolean = true;
        jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        b(1);
      }
      for (;;)
      {
        a();
        return;
        if ((!this.jdField_b_of_type_Boolean) || (u != 1) || (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
          break;
        }
        if (this.x / y * paramIntent.b + this.t <= paramIntent.jdField_a_of_type_Int)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data buffering is enough");
          }
          this.x = 0;
          this.jdField_b_of_type_Boolean = false;
          if (!this.jdField_c_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, user no Pause,so play!");
            }
            jdField_a_of_type_AndroidMediaMediaPlayer.start();
            b(2);
          }
        }
      }
      return;
      label895:
      if (i1 == 0) {
        break;
      }
      switch (i1)
      {
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    boolean bool1 = NetworkUtil.f(getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart,isNetworkAvailable = " + bool1 + ",url : " + paramString);
    }
    if (d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart, || play song in compatible mode ||");
      }
      if (!bool1)
      {
        jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        b(6);
      }
    }
    Object localObject2;
    int[] arrayOfInt;
    do
    {
      for (;;)
      {
        return;
        try
        {
          jdField_a_of_type_AndroidMediaMediaPlayer.reset();
          jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
          b(1);
          jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          b(2);
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          return;
        }
        catch (IllegalArgumentException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalArgumentException => ", paramString);
            }
          }
        }
        catch (SecurityException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode SecurityException => ", paramString);
            }
          }
        }
        catch (IllegalStateException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalStateException => ", paramString);
            }
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IOException => ", paramString);
            }
            jdField_a_of_type_AndroidMediaMediaPlayer.reset();
            b(6);
          }
        }
        localObject2 = a(paramString);
        Object localObject1 = new File(g + "/" + (String)localObject2);
        if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L)) {
          break label1167;
        }
        arrayOfInt = new int[2];
        boolean bool2 = MusicCacheManager.a((String)localObject2, arrayOfInt);
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject1).getAbsolutePath() + ",isCacheComplete:" + bool2 + ",result[0]:" + arrayOfInt[0] + ",result[1]:" + arrayOfInt[1]);
        }
        if (!bool2) {
          break label999;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache is complete");
        }
        jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        try
        {
          MusicCacheManager.a((File)localObject1);
          jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(((File)localObject1).getAbsolutePath());
          jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
          jdField_a_of_type_AndroidMediaMediaPlayer.start();
          b(2);
          if (b())
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download ============");
            }
            paramString = e().jdField_a_of_type_JavaLangString;
            if ((this.jdField_a_of_type_Dzt != null) && (this.jdField_a_of_type_Dzt.isAlive()) && (!this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: downloadThread is  running.... ");
              }
              if (paramString.equals(this.jdField_a_of_type_Dzt.jdField_a_of_type_JavaLangString))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QQPlayerService", 2, "mediaPlayStart: download url equals nextUrl,so no need play and return.");
                }
                this.jdField_a_of_type_Dzt.d = false;
                return;
              }
            }
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart:" + paramString.getMessage(), paramString);
            }
            try
            {
              ((File)localObject1).delete();
            }
            catch (Exception paramString) {}
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart,delete file on error:" + paramString.getMessage(), paramString);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "mediaPlayStart: download url not equals nextUrl,so no need stop.");
          }
          this.jdField_a_of_type_Dzt.d = false;
          this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Dzt = null;
          localObject1 = a(paramString);
          localObject2 = new File(g + "/" + (String)localObject1);
          if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
          {
            arrayOfInt = new int[2];
            bool1 = MusicCacheManager.a((String)localObject1, arrayOfInt);
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject2).getAbsolutePath() + ",isNextCacheComplete:" + bool1 + ",nextResult[0]:" + arrayOfInt[0] + ",nextResult[1]:" + arrayOfInt[1]);
            }
            if (bool1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache is complete.return");
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache not complete");
              }
              this.jdField_a_of_type_Dzt = new dzt(this, paramString, (String)localObject1, arrayOfInt[0], arrayOfInt[1]);
              this.jdField_a_of_type_Dzt.d = false;
              this.jdField_a_of_type_Dzt.start();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache no exists");
            }
            this.jdField_a_of_type_Dzt = new dzt(this, paramString, (String)localObject1, 0, 0);
            this.jdField_a_of_type_Dzt.d = false;
            this.jdField_a_of_type_Dzt.start();
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no need pre download =================");
      }
    } while ((this.jdField_a_of_type_Dzt == null) || (!this.jdField_a_of_type_Dzt.isAlive()) || (this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean));
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: download thread running,so no need play");
    }
    this.jdField_a_of_type_Dzt.d = false;
    return;
    label999:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      b(6);
      return;
    }
    if ((this.jdField_a_of_type_Dzt != null) && (this.jdField_a_of_type_Dzt.isAlive()) && (!this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean))
    {
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_Dzt.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_Dzt.d = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_Dzt.d = false;
      this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Dzt = null;
    }
    this.jdField_a_of_type_Dzt = new dzt(this, paramString, (String)localObject2, arrayOfInt[0], arrayOfInt[1]);
    this.jdField_a_of_type_Dzt.start();
    return;
    label1167:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file");
    }
    if (!bool1)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      b(6);
      return;
    }
    if ((this.jdField_a_of_type_Dzt != null) && (this.jdField_a_of_type_Dzt.isAlive()) && (!this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean))
    {
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_Dzt.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_Dzt.d = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_Dzt.d = false;
      this.jdField_a_of_type_Dzt.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Dzt = null;
    }
    this.jdField_a_of_type_Dzt = new dzt(this, paramString, (String)localObject2, 0, 0);
    this.jdField_a_of_type_Dzt.start();
  }
  
  private boolean b()
  {
    return (NetworkUtil.g(getApplicationContext())) && (e() != null);
  }
  
  public static boolean b(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playNext");
    }
    SongInfo localSongInfo = d();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    c(paramContext);
    return false;
  }
  
  public static boolean b(String paramString)
  {
    paramString = a(paramString);
    paramString = new File(g + "/" + paramString);
    return (paramString.exists()) && (paramString.length() > 102400L);
  }
  
  public static int c()
  {
    if (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo != null) {
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
    }
    return 0;
  }
  
  private static SongInfo c()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0))
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("QQPlayerService", 2, "pickPreviousSong : sSongList shouldn't be null or empty!");
            localObject1 = localObject4;
          }
          return localObject1;
        }
        int i1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "pickPreviousSong : songNum=" + i1 + ",sPlayMode=" + v + ",currentSongIndex=" + w);
        }
        Object localObject1 = localObject4;
        switch (v)
        {
        case 100: 
        case 101: 
          if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
            localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
          } else {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
          }
          break;
        case 102: 
          localObject1 = localObject4;
          if (w >= 1)
          {
            localObject1 = localObject4;
            if (w <= i1 - 1)
            {
              w -= 1;
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
            }
          }
          break;
        case 103: 
          localObject1 = localObject4;
          if (w >= 0)
          {
            localObject1 = localObject4;
            if (w <= i1 - 1)
            {
              w -= 1;
              if (w < 0) {
                w = i1 - 1;
              }
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
            }
          }
          break;
        case 105: 
          int i2 = w;
          w = new Random().nextInt(i1);
          if ((w == i2) && (i1 >= 1))
          {
            w += 1;
            w %= i1;
          }
          if ((w >= 0) && (w <= i1 - 1))
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
          }
          else
          {
            localObject1 = localObject4;
            if (i1 > 0) {
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
            }
          }
          break;
        case 104: 
        default: 
          Object localObject3 = localObject4;
        }
      }
      finally {}
    }
  }
  
  private void c()
  {
    jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
    jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
  }
  
  public static void c(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "stopPlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 3);
    paramContext.startService(localIntent);
  }
  
  public static int d()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = "";
        if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
          str = jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b;
        }
        QLog.d("QQPlayerService", 2, "getDuration(): title= " + str + " ,sPlayState = " + b(u) + " duration = " + y);
      }
      int i1 = y;
      return i1;
    }
    finally {}
  }
  
  private static SongInfo d()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0))
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("QQPlayerService", 2, "pickNextSong : sSongList shouldn't be null or empty!");
            localObject1 = localObject4;
          }
          return localObject1;
        }
        int i1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "pickNextSong : songNum=" + i1 + ",sPlayMode=" + v + ",currentSongIndex=" + w);
        }
        Object localObject1 = localObject4;
        switch (v)
        {
        case 100: 
        case 101: 
          if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
            localObject1 = jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
          } else {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
          }
          break;
        case 102: 
          localObject1 = localObject4;
          if (w >= 0)
          {
            localObject1 = localObject4;
            if (w <= i1 - 2)
            {
              w += 1;
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
            }
          }
          break;
        case 103: 
          localObject1 = localObject4;
          if (w >= 0)
          {
            localObject1 = localObject4;
            if (w <= i1 - 1)
            {
              w += 1;
              if (w > i1 - 1) {
                w = 0;
              }
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
            }
          }
          break;
        case 105: 
          w = new Random().nextInt(i1);
          if ((w >= 0) && (w <= i1 - 1))
          {
            localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
          }
          else
          {
            localObject1 = localObject4;
            if (i1 > 0) {
              localObject1 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
            }
          }
          break;
        case 104: 
        default: 
          Object localObject3 = localObject4;
        }
      }
      finally {}
    }
  }
  
  private static void d()
  {
    if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
  }
  
  public static int e()
  {
    int i2 = -1;
    int i1 = i2;
    try
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        i1 = i2;
        if (jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
          i1 = jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "getCurrentSongPosition(): sPlayState = " + b(u) + " position = " + i1);
      }
      return i1;
    }
    finally {}
  }
  
  private static SongInfo e()
  {
    int i1 = 0;
    if ((jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo == null) || (jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length == 0)) {
      return null;
    }
    int i3 = jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo.length;
    switch (v)
    {
    default: 
      return null;
    case 100: 
      return null;
    case 101: 
      if (jdField_a_of_type_ComTencentMobileqqMusicSongInfo != null) {
        return jdField_a_of_type_ComTencentMobileqqMusicSongInfo;
      }
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[0];
    case 102: 
      if ((w >= 0) && (w <= i3 - 2)) {
        return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[w];
      }
      return null;
    }
    int i2;
    if ((w >= 0) && (w <= i3 - 1))
    {
      i2 = w + 1;
      if (i2 <= i3 - 1) {
        break label137;
      }
    }
    for (;;)
    {
      return jdField_a_of_type_ArrayOfComTencentMobileqqMusicSongInfo[i1];
      return null;
      label137:
      i1 = i2;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "showMsgTabBar =======>");
    }
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).a(Conversation.class);
      if (localObject != null) {
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1134010));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("QQPlayerService", 2, "showMsgTabBar app = null!");
  }
  
  public static int f()
  {
    return w;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "dismissMsgTabBar <=======");
    }
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).a(Conversation.class);
      if (localObject != null)
      {
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(1134011));
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "dismissMsgTabBar: send msg MSG_MUSIC_PLAYER_HIDE ~~~~");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("QQPlayerService", 2, "dismissMsgTabBar app = null!");
  }
  
  private void g()
  {
    ThreadManager.a().post(new dzr(this));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "loopProgress : loopProgressDelayTime=" + this.jdField_c_of_type_Long);
    }
    Message localMessage = this.jdField_a_of_type_Dzv.obtainMessage();
    Intent localIntent = new Intent();
    localIntent.putExtra("musicplayer.action", 4);
    localMessage.obj = localIntent;
    this.jdField_a_of_type_Dzv.sendMessageDelayed(localMessage, this.jdField_c_of_type_Long);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onBind");
    }
    return this.jdField_a_of_type_ComTencentMobileqqMusicIQQPlayerService$Stub;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if ((QLog.isColorLevel()) && (d) && (paramInt < 100)) {
      QLog.d("QQPlayerService", 2, "onBufferingUpdate : " + paramInt + "% buffered");
    }
  }
  
  @TargetApi(8)
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCompletion");
    }
    if ((!b(getApplicationContext())) && (VersionUtils.b())) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCreate");
    }
    if (VersionUtils.b()) {
      this.jdField_a_of_type_JavaLangObject = new dzn(this);
    }
    b();
    c();
    this.jdField_a_of_type_Dzu = new dzu(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("qqplayer_exit_action");
    try
    {
      registerReceiver(this.jdField_a_of_type_Dzu, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQPlayerService", 2, "", localException);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onDestroy");
    }
    this.jdField_a_of_type_AndroidOsLooper.quit();
    this.jdField_a_of_type_Dzv = null;
    f = null;
    y = 0;
    w = 0;
    jdField_a_of_type_ComTencentMobileqqMusicSongInfo = null;
    if (jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      jdField_a_of_type_AndroidMediaMediaPlayer.release();
      jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    jdField_a_of_type_AndroidContentIntent = null;
    jdField_a_of_type_AndroidOsBundle = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      this.jdField_a_of_type_AndroidOsRemoteCallbackList.kill();
      this.jdField_a_of_type_AndroidOsRemoteCallbackList = null;
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      unregisterReceiver(this.jdField_a_of_type_Dzu);
      g();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "Android 2.1 and below can not stop music");
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQPlayerService", 2, "onError,what:" + paramInt1 + ",extra:" + paramInt2);
    }
    if (paramInt1 == 100)
    {
      if (jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      c();
    }
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject);
    }
    d();
    b(5);
    return true;
  }
  
  @TargetApi(8)
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    y = jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onPrepared:sDuration" + y);
    }
    if ((this.jdField_a_of_type_Dzt != null) && (this.jdField_a_of_type_Dzt.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Dzt.jdField_a_of_type_JavaLangString.equals(jdField_a_of_type_ComTencentMobileqqMusicSongInfo.jdField_a_of_type_JavaLangString)))
    {
      if (y != 0) {
        this.jdField_c_of_type_Long = ((y * 0.01D));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "onPrepared:loopProgressDelayTime:" + this.jdField_c_of_type_Long);
      }
      a();
    }
    if (!VersionUtils.b()) {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "onPrepared Android 2.1 and below can not stop music");
      }
    }
    int i1;
    do
    {
      return;
      i1 = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.jdField_a_of_type_JavaLangObject, 3, 1);
    } while (!QLog.isColorLevel());
    paramMediaPlayer = new StringBuilder().append("requestAudioFocus,result:");
    if (i1 == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQPlayerService", 2, bool);
      return;
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onStart");
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onStartCommand");
    }
    Message localMessage = this.jdField_a_of_type_Dzv.obtainMessage();
    localMessage.obj = paramIntent;
    if ((this.jdField_a_of_type_AndroidOsHandlerThread == null) || (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive()) || (this.jdField_a_of_type_AndroidOsLooper != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidOsLooper.quit();
      label61:
      b();
      this.jdField_a_of_type_Dzv.sendMessage(localMessage);
      return 2;
    }
    catch (Throwable paramIntent)
    {
      break label61;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService
 * JD-Core Version:    0.7.0.1
 */