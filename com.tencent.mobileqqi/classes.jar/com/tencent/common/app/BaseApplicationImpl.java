package com.tencent.common.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import bvo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dalvik.DalvikReplacer;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver;
import com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver.OnRecoverPluginListener;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.GTUtil;
import cooperation.plugin.PluginAdapterImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class BaseApplicationImpl
  extends MobileQQ
  implements PluginRecoverReceiver.OnRecoverPluginListener
{
  public static int a = 0;
  public static long a = 0L;
  public static Handler a;
  public static MQLruCache a;
  public static BaseApplicationImpl a;
  public static StartupDirector a;
  public static String a;
  public static boolean a = false;
  public static long b = 0L;
  public static final String b = "com.tencent.mobileqqi.broadcast.qq";
  public static boolean b = false;
  private static final int c = 8388608;
  public static long c = 0L;
  public static final String c = "com.tencent.mobileqqi";
  public static boolean c = false;
  public static long d = 0L;
  private static final boolean d = true;
  public static long e;
  public static long f;
  public MediaPlayer a;
  private PluginRecoverReceiver a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
    d = 0L;
    e = 0L;
    f = 0L;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
  }
  
  public BaseApplicationImpl()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    String str = "android.resource://" + paramInt;
    Object localObject = (Pair)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(str);
    if (localObject != null) {
      paramResources = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramResources);
    }
    do
    {
      return paramResources;
      localObject = paramResources.getDrawable(paramInt);
      paramInt = SkinUtils.a((Drawable)localObject);
      paramResources = (Resources)localObject;
    } while (paramInt <= 0);
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(str, new Pair(((Drawable)localObject).getConstantState(), Integer.valueOf(paramInt)));
    return localObject;
  }
  
  public static BaseApplicationImpl a()
  {
    return jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  }
  
  public static boolean a(Context paramContext)
  {
    if (DalvikReplacer.a(8388608))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
      StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplication.getContext());
      HashMap localHashMap = new HashMap();
      localHashMap.put("osVersion", Build.VERSION.RELEASE);
      localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      localHashMap.put("callcount", DalvikReplacer.a() + "");
      try
      {
        localHashMap.put("time", localSimpleDateFormat.format(new Date(System.currentTimeMillis())));
        localStatisticCollector.a("", "Dalvik_Replace_Before", true, 0L, 0L, localHashMap, "");
        localStatisticCollector.a("", "Dalvik_Replace_Before_Test", true, 0L, 0L, localHashMap, "");
        long l = DalvikReplacer.a(paramContext, 8388608);
        localHashMap.put("time", localSimpleDateFormat.format(new Date(System.currentTimeMillis())));
        localHashMap.put("result", l + "");
        localHashMap.put("callcount", DalvikReplacer.a() + "");
        if (l == 0L) {}
        for (boolean bool = true;; bool = false)
        {
          localStatisticCollector.a("", "Dalvik_Replace_After", bool, 0L, 0L, localHashMap, "");
          if (l != 0L) {
            break;
          }
          return true;
        }
        return false;
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("replaceDalvikMem", 2, "exception:", paramContext);
        }
      }
    }
    return true;
  }
  
  public int a()
  {
    return ((AudioManager)getSystemService("audio")).getRingerMode();
  }
  
  public AppRuntime a()
  {
    return waitAppRuntime(null);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      label14:
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, android.media.MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +32 -> 38
    //   9: aload_0
    //   10: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   13: invokevirtual 259	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore 4
    //   18: iload 4
    //   20: ifeq +6 -> 26
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   30: invokevirtual 255	android/media/MediaPlayer:release	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   38: iload_1
    //   39: getstatic 263	com/tencent/mobileqq/activity/SoundAndVibrateActivity:a	I
    //   42: if_icmpeq +101 -> 143
    //   45: aload_0
    //   46: aload_0
    //   47: invokevirtual 266	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   50: iload_1
    //   51: invokestatic 270	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   54: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   57: aload_0
    //   58: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   61: ifnull -38 -> 23
    //   64: aload_0
    //   65: iload_2
    //   66: putfield 59	com/tencent/common/app/BaseApplicationImpl:jdField_b_of_type_Int	I
    //   69: aload_0
    //   70: getfield 59	com/tencent/common/app/BaseApplicationImpl:jdField_b_of_type_Int	I
    //   73: ifeq +13 -> 86
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 59	com/tencent/common/app/BaseApplicationImpl:jdField_b_of_type_Int	I
    //   81: iconst_1
    //   82: isub
    //   83: putfield 59	com/tencent/common/app/BaseApplicationImpl:jdField_b_of_type_Int	I
    //   86: aload_0
    //   87: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   90: new 272	bvp
    //   93: dup
    //   94: aload_0
    //   95: aload_3
    //   96: invokespecial 275	bvp:<init>	(Lcom/tencent/common/app/BaseApplicationImpl;Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   99: invokevirtual 279	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   102: aload_0
    //   103: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   106: invokevirtual 282	android/media/MediaPlayer:start	()V
    //   109: aload_0
    //   110: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   113: iconst_0
    //   114: invokevirtual 286	android/media/MediaPlayer:setLooping	(Z)V
    //   117: goto -94 -> 23
    //   120: astore 5
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   127: goto -89 -> 38
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: aload_0
    //   137: aconst_null
    //   138: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   141: aload_3
    //   142: athrow
    //   143: aload_0
    //   144: aload_0
    //   145: invokevirtual 266	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   148: getstatic 292	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   151: invokestatic 295	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   154: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   157: goto -100 -> 57
    //   160: astore_3
    //   161: goto -138 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	BaseApplicationImpl
    //   0	164	1	paramInt1	int
    //   0	164	2	paramInt2	int
    //   0	164	3	paramOnCompletionListener	android.media.MediaPlayer.OnCompletionListener
    //   16	3	4	bool	boolean
    //   120	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   26	33	120	java/lang/Exception
    //   2	18	130	finally
    //   33	38	130	finally
    //   38	57	130	finally
    //   57	86	130	finally
    //   86	117	130	finally
    //   122	127	130	finally
    //   136	143	130	finally
    //   143	157	130	finally
    //   26	33	135	finally
    //   2	18	160	java/lang/Exception
    //   33	38	160	java/lang/Exception
    //   38	57	160	java/lang/Exception
    //   57	86	160	java/lang/Exception
    //   86	117	160	java/lang/Exception
    //   122	127	160	java/lang/Exception
    //   136	143	160	java/lang/Exception
    //   143	157	160	java/lang/Exception
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerStart", 2, "resourceId=" + paramInt + ",looping=" + paramBoolean);
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        if (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
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
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label182;
        }
        QLog.e("MediaPlayerStart", 2, "media palyer release exception", localException2);
        label182:
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        continue;
      }
      finally
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      }
      if (paramInt != SoundAndVibrateActivity.a)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(getApplicationContext(), paramInt);
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("MediaPlayerStart", 2, "media palyer is null");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = MediaPlayer.create(getApplicationContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MediaPlayerStart", 2, "media palyer uri=" + Settings.System.DEFAULT_NOTIFICATION_URI);
        continue;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new bvo(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, android.media.MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   13: invokevirtual 259	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   28: invokevirtual 255	android/media/MediaPlayer:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   36: iload_1
    //   37: getstatic 263	com/tencent/mobileqq/activity/SoundAndVibrateActivity:a	I
    //   40: if_icmpeq +81 -> 121
    //   43: aload_0
    //   44: aload_0
    //   45: invokevirtual 266	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   48: iload_1
    //   49: invokestatic 270	android/media/MediaPlayer:create	(Landroid/content/Context;I)Landroid/media/MediaPlayer;
    //   52: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   55: aload_0
    //   56: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   59: ifnull -38 -> 21
    //   62: aload 4
    //   64: ifnull +74 -> 138
    //   67: aload_0
    //   68: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   71: aload 4
    //   73: invokevirtual 279	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   76: aload_0
    //   77: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   80: invokevirtual 282	android/media/MediaPlayer:start	()V
    //   83: aload_0
    //   84: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   87: iload_2
    //   88: invokevirtual 286	android/media/MediaPlayer:setLooping	(Z)V
    //   91: goto -70 -> 21
    //   94: astore 5
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   101: goto -65 -> 36
    //   104: astore 4
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 4
    //   110: athrow
    //   111: astore 4
    //   113: aload_0
    //   114: aconst_null
    //   115: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   118: aload 4
    //   120: athrow
    //   121: aload_0
    //   122: aload_0
    //   123: invokevirtual 266	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   126: getstatic 292	android/provider/Settings$System:DEFAULT_NOTIFICATION_URI	Landroid/net/Uri;
    //   129: invokestatic 295	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   132: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   135: goto -80 -> 55
    //   138: aload_0
    //   139: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   142: new 334	bvq
    //   145: dup
    //   146: aload_0
    //   147: invokespecial 335	bvq:<init>	(Lcom/tencent/common/app/BaseApplicationImpl;)V
    //   150: invokevirtual 279	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   153: goto -77 -> 76
    //   156: astore 4
    //   158: goto -137 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	BaseApplicationImpl
    //   0	161	1	paramInt	int
    //   0	161	2	paramBoolean1	boolean
    //   0	161	3	paramBoolean2	boolean
    //   0	161	4	paramOnCompletionListener	android.media.MediaPlayer.OnCompletionListener
    //   94	1	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   24	31	94	java/lang/Exception
    //   2	17	104	finally
    //   31	36	104	finally
    //   36	55	104	finally
    //   55	62	104	finally
    //   67	76	104	finally
    //   76	91	104	finally
    //   96	101	104	finally
    //   113	121	104	finally
    //   121	135	104	finally
    //   138	153	104	finally
    //   24	31	111	finally
    //   2	17	156	java/lang/Exception
    //   31	36	156	java/lang/Exception
    //   36	55	156	java/lang/Exception
    //   55	62	156	java/lang/Exception
    //   67	76	156	java/lang/Exception
    //   76	91	156	java/lang/Exception
    //   96	101	156	java/lang/Exception
    //   113	121	156	java/lang/Exception
    //   121	135	156	java/lang/Exception
    //   138	153	156	java/lang/Exception
  }
  
  /* Error */
  public void a(android.net.Uri paramUri, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   15: invokevirtual 255	android/media/MediaPlayer:release	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: aload_1
    //   24: invokevirtual 341	android/net/Uri:getScheme	()Ljava/lang/String;
    //   27: ldc_w 343
    //   30: invokevirtual 349	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifeq +110 -> 143
    //   36: aload_0
    //   37: new 252	android/media/MediaPlayer
    //   40: dup
    //   41: invokespecial 350	android/media/MediaPlayer:<init>	()V
    //   44: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   47: new 352	java/io/FileInputStream
    //   50: dup
    //   51: new 354	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokevirtual 357	android/net/Uri:getPath	()Ljava/lang/String;
    //   59: invokespecial 358	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: invokespecial 361	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   70: aload_1
    //   71: invokevirtual 365	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   74: invokevirtual 369	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   77: aload_0
    //   78: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   81: invokevirtual 372	android/media/MediaPlayer:prepare	()V
    //   84: aload_1
    //   85: invokevirtual 375	java/io/FileInputStream:close	()V
    //   88: aload_0
    //   89: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   92: new 377	bvr
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 378	bvr:<init>	(Lcom/tencent/common/app/BaseApplicationImpl;)V
    //   100: invokevirtual 279	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   103: aload_0
    //   104: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   107: invokevirtual 282	android/media/MediaPlayer:start	()V
    //   110: aload_0
    //   111: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   114: iload_2
    //   115: invokevirtual 286	android/media/MediaPlayer:setLooping	(Z)V
    //   118: aload_0
    //   119: monitorexit
    //   120: return
    //   121: astore_3
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   127: goto -104 -> 23
    //   130: astore_1
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: aload_0
    //   145: invokevirtual 266	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   148: aload_1
    //   149: invokestatic 295	android/media/MediaPlayer:create	(Landroid/content/Context;Landroid/net/Uri;)Landroid/media/MediaPlayer;
    //   152: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   155: aload_0
    //   156: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   159: astore_1
    //   160: aload_1
    //   161: ifnonnull -73 -> 88
    //   164: goto -46 -> 118
    //   167: astore_1
    //   168: goto -50 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	BaseApplicationImpl
    //   0	171	1	paramUri	android.net.Uri
    //   0	171	2	paramBoolean	boolean
    //   6	2	3	localMediaPlayer	MediaPlayer
    //   121	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   11	18	121	java/lang/Exception
    //   11	18	130	finally
    //   2	7	138	finally
    //   18	23	138	finally
    //   23	88	138	finally
    //   88	118	138	finally
    //   122	127	138	finally
    //   131	138	138	finally
    //   143	160	138	finally
    //   2	7	167	java/lang/Exception
    //   18	23	167	java/lang/Exception
    //   23	88	167	java/lang/Exception
    //   88	118	167	java/lang/Exception
    //   122	127	167	java/lang/Exception
    //   131	138	167	java/lang/Exception
    //   143	160	167	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   13: invokevirtual 259	android/media/MediaPlayer:isPlaying	()Z
    //   16: istore_3
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   28: invokevirtual 255	android/media/MediaPlayer:release	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   36: aload_0
    //   37: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   40: ifnonnull +14 -> 54
    //   43: aload_0
    //   44: new 252	android/media/MediaPlayer
    //   47: dup
    //   48: invokespecial 350	android/media/MediaPlayer:<init>	()V
    //   51: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   54: aload_0
    //   55: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   58: invokevirtual 382	android/media/MediaPlayer:reset	()V
    //   61: aload_0
    //   62: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   65: new 352	java/io/FileInputStream
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 365	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   76: invokevirtual 369	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   79: aload_0
    //   80: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   83: invokevirtual 372	android/media/MediaPlayer:prepare	()V
    //   86: aload_0
    //   87: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   90: new 385	bvn
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 386	bvn:<init>	(Lcom/tencent/common/app/BaseApplicationImpl;)V
    //   98: invokevirtual 279	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   101: aload_0
    //   102: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   105: invokevirtual 282	android/media/MediaPlayer:start	()V
    //   108: aload_0
    //   109: getfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   112: iload_2
    //   113: invokevirtual 286	android/media/MediaPlayer:setLooping	(Z)V
    //   116: goto -95 -> 21
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 389	java/lang/Exception:printStackTrace	()V
    //   124: goto -103 -> 21
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: astore 4
    //   134: aload_0
    //   135: aconst_null
    //   136: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   139: goto -103 -> 36
    //   142: astore_1
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 250	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   148: aload_1
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	BaseApplicationImpl
    //   0	150	1	paramString	String
    //   0	150	2	paramBoolean	boolean
    //   16	2	3	bool	boolean
    //   132	1	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	119	java/lang/Exception
    //   31	36	119	java/lang/Exception
    //   36	54	119	java/lang/Exception
    //   54	116	119	java/lang/Exception
    //   134	139	119	java/lang/Exception
    //   143	150	119	java/lang/Exception
    //   2	17	127	finally
    //   31	36	127	finally
    //   36	54	127	finally
    //   54	116	127	finally
    //   120	124	127	finally
    //   134	139	127	finally
    //   143	150	127	finally
    //   24	31	132	java/lang/Exception
    //   24	31	142	finally
  }
  
  public AppRuntime createRuntime(String paramString)
  {
    return AppInterfaceFactory.a(this, paramString);
  }
  
  public int getAppId(String paramString)
  {
    return AppSetting.a;
  }
  
  public String getBootBroadcastName(String paramString)
  {
    if (paramString.equals("com.tencent.mobileqqi")) {
      return "com.tencent.mobileqqi.broadcast.qq";
    }
    if (paramString.equals("com.tencent.mobileqqi:video")) {
      return "com.tencent.av.ui.qqi.VChatActivity";
    }
    return "";
  }
  
  public boolean isNeedMSF(String paramString)
  {
    return !paramString.equals(getPackageName() + ":picture");
  }
  
  public boolean onActivityCreate(AppActivity paramAppActivity, Intent paramIntent)
  {
    if (jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null) {
      return jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(paramAppActivity, paramIntent);
    }
    return false;
  }
  
  public void onActivityFocusChanged(AppActivity paramAppActivity, boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector != null) {
      jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.a(paramAppActivity, paramBoolean);
    }
  }
  
  public void onCreate()
  {
    if (jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {}
    do
    {
      return;
      jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = this;
      super.onCreate();
      Step.a(2, null, null).b();
      if (StartupDirector.f)
      {
        GTUtil.a();
        GTUtil.a(0, "group_global_all_consume_time", "group_application_oncreate", new int[0]);
      }
      jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector = StartupDirector.a(jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
      if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginRecoverReceiver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginRecoverReceiver = PluginRecoverReceiver.register(this);
        if ((this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginRecoverReceiver != null) && (processName.equals("com.tencent.mobileqqi"))) {
          this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginRecoverReceiver.setOnRecoverPluginListener(this);
        }
      }
      mqq.app.MainService.isDebugVersion = false;
      IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
    } while (!StartupDirector.f);
    GTUtil.b(0, "group_global_all_consume_time", "group_application_oncreate", new int[0]);
    GTUtil.a(0, "group_global_all_consume_time", "app_oncreate_2_activity_oncreate", new int[0]);
  }
  
  public void onRecver(String paramString)
  {
    AppRuntime localAppRuntime = a().a();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "NetPlugins", "Download", 9527, 0, "0", "0", paramString, "");
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    try
    {
      super.startActivity(paramIntent);
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    try
    {
      super.startActivity(paramIntent, paramBundle);
      return;
    }
    catch (Exception paramIntent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.app.BaseApplicationImpl
 * JD-Core Version:    0.7.0.1
 */