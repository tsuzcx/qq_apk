package com.tencent.mobileqq.music;

import acbn;
import aeay;
import aeba;
import aebf;
import aeeg;
import ajat;
import ajat.c;
import ajmi;
import ajmj.a;
import ajmk;
import ajml;
import ajmm;
import ajmn;
import ajmp;
import akum;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import aqiv;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import cooperation.qzone.music.BroadcastMusicInfo;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.os.MqqHandler;

@SuppressLint({"NewApi"})
public class QQPlayerService
  extends Service
  implements aebf, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static ajat.c jdField_a_of_type_Ajat$c = new ajmm();
  public static long acX;
  private static Intent af;
  private static Bundle bk;
  private static SongInfo[] c;
  static SparseArray<Boolean> cX;
  private static Map<String, WeakReference<c>> callbacks;
  private static boolean cpn;
  private static boolean cpo;
  private static int deN = 0;
  private static int deO;
  private static int djM = 103;
  private static int djN = -1;
  private static MediaPlayer g;
  private static WeakReference<c> hq;
  private static WeakReference<c> hr;
  private static SongInfo i;
  private static int mRetryTimes;
  private static String sToken;
  private aeeg jdField_a_of_type_Aeeg = new ajmn(this);
  private ajmj.a jdField_a_of_type_Ajmj$a = new ajml(this);
  private RemoteCallbackList<ajmi> jdField_a_of_type_AndroidOsRemoteCallbackList;
  public DownloadThread a;
  private a jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$a;
  private b jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$b;
  private volatile e jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e;
  private boolean aZC;
  public long acY = 500L;
  private volatile Looper b;
  private volatile boolean clp;
  public boolean cpl = true;
  private volatile boolean cpm;
  private int djO;
  private Object eg;
  private aeay mColorNoteController;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  public float xv = 0.3F;
  
  static
  {
    callbacks = new HashMap();
    cX = new SparseArray();
    cpo = true;
    cX.put(10, Boolean.valueOf(true));
    cpn = ajmp.arb();
  }
  
  public static void F(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "resumePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 5);
    localIntent.putExtra("key_add_to_color_note", paramBoolean);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQPlayerService", 1, "resumePlayMusic", paramContext);
    }
  }
  
  public static int Gt()
  {
    int j = -1;
    try
    {
      if (g != null) {
        j = g.getCurrentPosition();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "getCurrentPlayPosition(): sPlayState = " + bA(deN) + " position = " + j);
      }
      return j;
    }
    finally {}
  }
  
  public static String I(int paramInt, String paramString)
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
    case 5: 
      return "troopbar_" + paramString;
    case 6: 
      return "music_pendant_" + paramString;
    case 7: 
      return "search_" + paramString;
    }
    return "miniapp_" + paramString;
  }
  
  private void MD(String paramString)
  {
    boolean bool1 = aqiw.isNetworkAvailable(getApplicationContext());
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart,isNetworkAvailable = " + bool1 + ",url : " + paramString);
    }
    if ((cpn) || ((i != null) && (i.type == 9)))
    {
      dyp();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart, || play song in compatible mode ||");
      }
      if (!bool1)
      {
        g.reset();
        Rh(6);
      }
    }
    String str;
    Object localObject2;
    do
    {
      for (;;)
      {
        return;
        try
        {
          g.reset();
          str = paramString;
          if (!TextUtils.isEmpty(paramString))
          {
            str = paramString;
            if (paramString.startsWith("qzonevipmusic://"))
            {
              paramString = mf(paramString);
              str = paramString;
              if (TextUtils.isEmpty(paramString))
              {
                Rh(10);
                if (i == null) {
                  continue;
                }
                QLog.e("QQPlayerService", 1, "mediaPlayStart:url coverted is null , title :" + i.title + "and mid :" + i.album);
                return;
              }
            }
          }
        }
        catch (IllegalArgumentException paramString)
        {
          paramString.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("QQPlayerService", 2, "mediaPlayStart: inCompatibleMode IllegalArgumentException => ", paramString);
          }
          for (;;)
          {
            g.start();
            return;
            g.setDataSource(str);
            Rh(1);
            g.prepare();
            Rh(2);
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
            g.reset();
            Rh(6);
          }
        }
        localObject2 = mg(paramString);
        Object localObject1 = new File(acbn.bmv + (String)localObject2);
        str = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          str = paramString;
          if (paramString.startsWith("qzonevipmusic://"))
          {
            paramString = mf(paramString);
            str = paramString;
            if (TextUtils.isEmpty(paramString))
            {
              g.reset();
              Rh(10);
              if (i == null) {
                continue;
              }
              QLog.e("QQPlayerService", 1, "mediaPlayStart:url coverted is null , title :" + i.title + "and mid :" + i.album);
              return;
            }
          }
        }
        if ((!((File)localObject1).exists()) || (((File)localObject1).length() <= 0L)) {
          break label1436;
        }
        paramString = new int[2];
        boolean bool2 = aqiv.d((String)localObject2, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject1).getAbsolutePath() + ",isCacheComplete:" + bool2 + ",result[0]:" + paramString[0] + ",result[1]:" + paramString[1]);
        }
        if (!bool2) {
          break label1267;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache is complete");
        }
        g.reset();
        try
        {
          aqiv.C((File)localObject1);
          g.setDataSource(((File)localObject1).getAbsolutePath());
          g.prepare();
          g.start();
          Rh(2);
          if (ara())
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download ============");
            }
            paramString = "";
            if (f() != null) {
              paramString = f().url;
            }
            localObject1 = mg(paramString);
            if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              continue;
            }
            localObject2 = new File(acbn.bmv + (String)localObject1);
            str = paramString;
            if (!TextUtils.isEmpty(paramString))
            {
              str = paramString;
              if (paramString.startsWith("qzonevipmusic://"))
              {
                str = mf(paramString);
                if (TextUtils.isEmpty(str)) {
                  continue;
                }
              }
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QQPlayerService", 2, "mediaPlayStart: downloadThread is  running.... ");
              }
              if (str.equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.url))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QQPlayerService", 2, "mediaPlayStart: download url equals nextUrl,so no need play and return.");
                }
                this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = false;
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
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = false;
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop = true;
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
          if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
          {
            paramString = new int[2];
            bool1 = aqiv.d((String)localObject1, paramString);
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart:" + ((File)localObject2).getAbsolutePath() + ",isNextCacheComplete:" + bool1 + ",nextResult[0]:" + paramString[0] + ",nextResult[1]:" + paramString[1]);
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
              this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new DownloadThread(str, (String)localObject1, paramString[0], paramString[1]);
              this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = false;
              this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "mediaPlayStart: need pre download,next cache no exists");
            }
            this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new DownloadThread(str, (String)localObject1, 0, 0);
            this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = false;
            this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
            return;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no need pre download =================");
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread == null) || (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) || (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop));
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: download thread running,so no need play");
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = false;
    return;
    label1267:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete");
    }
    if (!bool1)
    {
      g.reset();
      Rh(6);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop))
    {
      if ((str != null) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.url)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart:cache not complete,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = false;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop = true;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new DownloadThread(str, (String)localObject2, paramString[0], paramString[1]);
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
    return;
    label1436:
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file");
    }
    if (!bool1)
    {
      g.reset();
      Rh(6);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop))
    {
      if ((str != null) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.url)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url is equals current url,need play!");
        }
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = true;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "mediaPlayStart: no buff file,the download url not equals current url,need stop!");
      }
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.aIS = false;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop = true;
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread = new DownloadThread(str, (String)localObject2, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.start();
  }
  
  private void Rh(int paramInt)
  {
    int j = 0;
    if ((paramInt != 0) && (paramInt != 2) && (paramInt != 3) && (paramInt != 1) && (paramInt != 4) && (paramInt != 7) && (paramInt != 5) && (paramInt != 6) && (paramInt != 8) && (paramInt != 10)) {
      try
      {
        throw new IllegalArgumentException("playState value " + paramInt + " is illegal.");
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:" + bA(deN) + " =====> " + bA(paramInt));
    }
    deN = paramInt;
    Object localObject2;
    label342:
    Iterator localIterator;
    if ((deN == 2) || (deN == 1))
    {
      if (aeba.v(16973824, "music_color_note_only_one")) {
        this.mColorNoteController.deleteColorNote();
      }
      if ((a(a())) && (this.mColorNoteController.shouldDisplayColorNote()) && (deN == 2)) {
        this.mColorNoteController.insertColorNote();
      }
      if ((hr == null) || (hr.get() == null)) {
        break label485;
      }
      localObject2 = (c)hr.get();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:playState=" + bA(paramInt) + ",local callback=" + localObject2);
      }
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break label472;
      }
      if (this.mHandler == null) {
        this.mHandler = new Handler(Looper.getMainLooper());
      }
      this.mHandler.post(new QQPlayerService.7(this, (c)localObject2, paramInt));
      localIterator = callbacks.keySet().iterator();
    }
    for (;;)
    {
      label357:
      if (!localIterator.hasNext()) {
        break label535;
      }
      localObject2 = (String)localIterator.next();
      localObject2 = (WeakReference)callbacks.get(localObject2);
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = (c)((WeakReference)localObject2).get())
      {
        if (localObject2 == null) {
          break label520;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          break label522;
        }
        if (this.mHandler == null) {
          this.mHandler = new Handler(Looper.getMainLooper());
        }
        this.mHandler.post(new QQPlayerService.8(this, (c)localObject2, paramInt));
        break label357;
        this.mColorNoteController.deleteColorNote();
        break;
        label472:
        ((c)localObject2).onPlayStateChanged(deN);
        break label342;
        label485:
        if ((hr != null) || (!QLog.isColorLevel())) {
          break label342;
        }
        QLog.d("QQPlayerService", 2, "changePlayStateAndNotify: sCallback = null! ");
        break label342;
      }
      label520:
      continue;
      label522:
      ((c)localObject2).onPlayStateChanged(deN);
    }
    label535:
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      int k = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      for (;;)
      {
        if (j < k) {
          try
          {
            ((ajmi)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(j)).onPlayStateChanged(paramInt);
            j += 1;
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
      if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null) {
        this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
      }
    }
    if (deN == 2) {
      mRetryTimes = 0;
    }
    if (deN == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "PLAY_STATE_ERROR_INTERNAL ======> post runnable to retry play media");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e != null) {
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.postDelayed(new QQPlayerService.9(this), 4000L);
      }
    }
  }
  
  public static SongInfo a()
  {
    return i;
  }
  
  private static void a(Context paramContext, SongInfo paramSongInfo)
  {
    a(paramContext, paramSongInfo, a(paramSongInfo));
  }
  
  private static void a(Context paramContext, SongInfo paramSongInfo, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 2);
    localIntent.putExtra("musicplayer.song", paramSongInfo);
    localIntent.putExtra("key_add_to_color_note", paramBoolean);
    ajat.a().requestMediaFocus(1, jdField_a_of_type_Ajat$c);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQPlayerService", 1, "startPlayMusic", paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString, SongInfo paramSongInfo)
  {
    try
    {
      setPlayMode(100);
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
  
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt)
  {
    try
    {
      a(paramContext, paramString, paramArrayOfSongInfo, paramInt, a(paramArrayOfSongInfo[0]));
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString, SongInfo[] paramArrayOfSongInfo, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull +8 -> 12
    //   7: aload_2
    //   8: arraylength
    //   9: ifne +20 -> 29
    //   12: new 258	java/lang/IllegalArgumentException
    //   15: dup
    //   16: ldc_w 664
    //   19: invokespecial 481	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   22: athrow
    //   23: astore_0
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    //   29: aload_1
    //   30: ifnull +13 -> 43
    //   33: aload_1
    //   34: ldc_w 403
    //   37: invokevirtual 425	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +14 -> 54
    //   43: new 258	java/lang/IllegalArgumentException
    //   46: dup
    //   47: ldc_w 666
    //   50: invokespecial 481	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: iload_3
    //   55: iflt +11 -> 66
    //   58: iload_3
    //   59: aload_2
    //   60: arraylength
    //   61: iconst_1
    //   62: isub
    //   63: if_icmple +14 -> 77
    //   66: new 258	java/lang/IllegalArgumentException
    //   69: dup
    //   70: ldc_w 668
    //   73: invokespecial 481	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +52 -> 132
    //   83: ldc 171
    //   85: iconst_2
    //   86: new 212	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 670
    //   96: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: arraylength
    //   101: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc_w 672
    //   107: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload_3
    //   111: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc_w 674
    //   117: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: getstatic 99	com/tencent/mobileqq/music/QQPlayerService:djM	I
    //   123: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_1
    //   133: putstatic 676	com/tencent/mobileqq/music/QQPlayerService:sToken	Ljava/lang/String;
    //   136: aload_2
    //   137: putstatic 678	com/tencent/mobileqq/music/QQPlayerService:c	[Lcom/tencent/mobileqq/music/SongInfo;
    //   140: getstatic 680	com/tencent/mobileqq/music/QQPlayerService:hq	Ljava/lang/ref/WeakReference;
    //   143: ifnull +28 -> 171
    //   146: iconst_0
    //   147: putstatic 97	com/tencent/mobileqq/music/QQPlayerService:deN	I
    //   150: getstatic 680	com/tencent/mobileqq/music/QQPlayerService:hq	Ljava/lang/ref/WeakReference;
    //   153: invokevirtual 520	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   156: checkcast 25	com/tencent/mobileqq/music/QQPlayerService$c
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +31 -> 192
    //   164: aload_1
    //   165: iconst_0
    //   166: invokeinterface 587 2 0
    //   171: iload_3
    //   172: putstatic 101	com/tencent/mobileqq/music/QQPlayerService:djN	I
    //   175: aload_0
    //   176: getstatic 678	com/tencent/mobileqq/music/QQPlayerService:c	[Lcom/tencent/mobileqq/music/SongInfo;
    //   179: getstatic 101	com/tencent/mobileqq/music/QQPlayerService:djN	I
    //   182: aaload
    //   183: iload 4
    //   185: invokestatic 633	com/tencent/mobileqq/music/QQPlayerService:a	(Landroid/content/Context;Lcom/tencent/mobileqq/music/SongInfo;Z)V
    //   188: ldc 2
    //   190: monitorexit
    //   191: return
    //   192: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq -24 -> 171
    //   198: ldc 171
    //   200: iconst_2
    //   201: ldc_w 682
    //   204: invokestatic 332	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: goto -36 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramContext	Context
    //   0	210	1	paramString	String
    //   0	210	2	paramArrayOfSongInfo	SongInfo[]
    //   0	210	3	paramInt	int
    //   0	210	4	paramBoolean	boolean
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
    //   171	188	23	finally
    //   192	207	23	finally
  }
  
  public static void a(c paramc)
  {
    if (paramc != null)
    {
      sToken = paramc.getToken();
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "setCallback: sToken=" + sToken);
      }
      hq = hr;
      hr = new WeakReference(paramc);
      return;
    }
    sToken = null;
    hq = hr;
    hr = null;
  }
  
  public static void a(SongInfo[] paramArrayOfSongInfo, int paramInt1, int paramInt2)
  {
    c = paramArrayOfSongInfo;
    djM = paramInt1;
    djN = paramInt2;
  }
  
  public static boolean a(c paramc)
  {
    if (((deN != 2) && (deN != 1)) || (paramc == null)) {
      return false;
    }
    if (hr != null)
    {
      c localc = (c)hr.get();
      if ((localc != null) && (localc == paramc)) {
        return true;
      }
    }
    paramc = paramc.getToken();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlayingMySong:callback.getToken()=" + paramc + ",sToken=" + sToken);
    }
    if (sToken != null) {
      return sToken.equals(paramc);
    }
    return false;
  }
  
  public static boolean a(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {}
    while (cX.get(paramSongInfo.type) == null) {
      return true;
    }
    return false;
  }
  
  public static SongInfo[] a()
  {
    return c;
  }
  
  public static void ag(Intent paramIntent)
  {
    af = paramIntent;
  }
  
  private boolean ara()
  {
    return (aqiw.isWifiConnected(getApplicationContext())) && (f() != null);
  }
  
  public static void b(c paramc)
  {
    if (paramc != null) {
      callbacks.put(paramc.getToken(), new WeakReference(paramc));
    }
  }
  
  public static void b(SongInfo[] paramArrayOfSongInfo)
  {
    a(paramArrayOfSongInfo, djM, 0);
  }
  
  public static String bA(int paramInt)
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
    case 6: 
      return " NETWORK_INTERRUPT ";
    }
    return " COMPLETION ";
  }
  
  public static boolean bq(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playPrev");
    }
    SongInfo localSongInfo = d();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    eG(paramContext);
    return false;
  }
  
  public static boolean br(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "playNext");
    }
    SongInfo localSongInfo = e();
    if (localSongInfo != null)
    {
      a(paramContext, localSongInfo);
      return true;
    }
    eG(paramContext);
    return false;
  }
  
  public static void c(c paramc)
  {
    if (paramc != null) {
      callbacks.remove(paramc.getToken());
    }
  }
  
  private static SongInfo d()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((c == null) || (c.length == 0))
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("QQPlayerService", 2, "pickPreviousSong : sSongList shouldn't be null or empty!");
            localObject1 = localObject4;
          }
          return localObject1;
        }
        int j = c.length;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "pickPreviousSong : songNum=" + j + ",sPlayMode=" + djM + ",currentSongIndex=" + djN);
        }
        Object localObject1 = localObject4;
        switch (djM)
        {
        case 100: 
        case 101: 
          if (i != null) {
            localObject1 = i;
          } else {
            localObject1 = c[0];
          }
          break;
        case 102: 
          localObject1 = localObject4;
          if (djN >= 1)
          {
            localObject1 = localObject4;
            if (djN <= j - 1)
            {
              djN -= 1;
              localObject1 = c[djN];
            }
          }
          break;
        case 103: 
          localObject1 = localObject4;
          if (djN >= 0)
          {
            localObject1 = localObject4;
            if (djN <= j - 1)
            {
              djN -= 1;
              if (djN < 0) {
                djN = j - 1;
              }
              localObject1 = c[djN];
            }
          }
          break;
        case 105: 
          int k = djN;
          djN = new Random().nextInt(j);
          if ((djN == k) && (j >= 1))
          {
            djN += 1;
            djN %= j;
          }
          if ((djN >= 0) && (djN <= j - 1))
          {
            localObject1 = c[djN];
          }
          else
          {
            localObject1 = localObject4;
            if (j > 0) {
              localObject1 = c[0];
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
  
  private void dyo()
  {
    if ((i != null) && (i.type == 9) && (i.b != null))
    {
      long l1 = i.b.getNearestTime();
      if (l1 > 0L)
      {
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e != null) {
          this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.postDelayed(new QQPlayerService.4(this), l1 * 1000L - l2);
        }
      }
    }
  }
  
  private void dyp()
  {
    try
    {
      if ((i != null) && (i.type == 9) && (i.b != null))
      {
        i.title = i.b.getTitle();
        g(i);
        dyo();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void dyr()
  {
    ThreadManager.getFileThreadHandler().post(new QQPlayerService.10(this));
  }
  
  private void dys()
  {
    if ((i != null) && (cpo))
    {
      ColorNote localColorNote = getColorNote();
      localColorNote.mMainTitle = i.title;
      localColorNote.mSubTitle = i.singer;
      localColorNote.mPicUrl = i.coverUrl;
      this.mColorNoteController.j(localColorNote);
    }
  }
  
  public static SongInfo e()
  {
    Object localObject4 = null;
    for (;;)
    {
      try
      {
        if ((c == null) || (c.length == 0))
        {
          localObject1 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.e("QQPlayerService", 2, "pickNextSong : sSongList shouldn't be null or empty!");
            localObject1 = localObject4;
          }
          return localObject1;
        }
        int j = c.length;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "pickNextSong : songNum=" + j + ",sPlayMode=" + djM + ",currentSongIndex=" + djN);
        }
        Object localObject1 = localObject4;
        switch (djM)
        {
        case 100: 
        case 101: 
          if (i != null) {
            localObject1 = i;
          } else {
            localObject1 = c[0];
          }
          break;
        case 102: 
          localObject1 = localObject4;
          if (djN >= 0)
          {
            localObject1 = localObject4;
            if (djN <= j - 2)
            {
              djN += 1;
              localObject1 = c[djN];
            }
          }
          break;
        case 103: 
          localObject1 = localObject4;
          if (djN >= 0)
          {
            localObject1 = localObject4;
            if (djN <= j - 1)
            {
              djN += 1;
              if (djN > j - 1) {
                djN = 0;
              }
              localObject1 = c[djN];
            }
          }
          break;
        case 105: 
          djN = new Random().nextInt(j);
          if ((djN >= 0) && (djN <= j - 1))
          {
            localObject1 = c[djN];
          }
          else
          {
            localObject1 = localObject4;
            if (j > 0) {
              localObject1 = c[0];
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
  
  public static String eA(int paramInt)
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
  
  public static void eE(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "pausePlayMusic");
    }
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 6);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQPlayerService", 1, "pausePlayMusic", paramContext);
    }
  }
  
  public static void eF(Context paramContext)
  {
    F(paramContext, a(i));
  }
  
  public static void eG(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "stopPlayMusic");
    }
    ajat.a().abandonMediaFocus(jdField_a_of_type_Ajat$c);
    Intent localIntent = new Intent(paramContext, QQPlayerService.class);
    localIntent.putExtra("musicplayer.action", 3);
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("QQPlayerService", 1, "stopPlayMusic", paramContext);
    }
  }
  
  public static void eH(Context paramContext)
  {
    if ((aqiw.isNetworkAvailable(paramContext)) && (deN == 2) && (i != null) && (i.type == 9) && (i.b != null))
    {
      eG(paramContext);
      i.url = i.b.getSongUrl(aqiw.isWifiConnected(paramContext));
      SongInfo[] arrayOfSongInfo = c;
      int k = arrayOfSongInfo.length;
      int j = 0;
      while (j < k)
      {
        SongInfo localSongInfo = arrayOfSongInfo[j];
        if ((localSongInfo != null) && (localSongInfo.type == 9) && (localSongInfo.b != null)) {
          localSongInfo.url = localSongInfo.b.getSongUrl(aqiw.isWifiConnected(paramContext));
        }
        j += 1;
      }
      a(paramContext, sToken, c, djN);
    }
  }
  
  public static SongInfo f()
  {
    int j = 0;
    if ((c == null) || (c.length == 0)) {
      return null;
    }
    int m = c.length;
    switch (djM)
    {
    default: 
      return null;
    case 100: 
      return null;
    case 101: 
      if (i != null) {
        return i;
      }
      return c[0];
    case 102: 
      if ((djN >= 0) && (djN <= m - 2)) {
        return c[djN];
      }
      return null;
    }
    int k;
    if ((djN >= 0) && (djN <= m - 1))
    {
      k = djN + 1;
      if (k <= m - 1) {
        break label137;
      }
    }
    for (;;)
    {
      return c[j];
      return null;
      label137:
      j = k;
    }
  }
  
  private void f(SongInfo paramSongInfo)
  {
    if (paramSongInfo == null) {
      try
      {
        throw new IllegalArgumentException("newSong shouldn't be null!");
      }
      finally {}
    }
    deO = 0;
    i = paramSongInfo;
    dys();
    g(paramSongInfo);
  }
  
  private void g(SongInfo paramSongInfo)
  {
    for (;;)
    {
      try
      {
        if ((hr != null) && (hr.get() != null))
        {
          localObject = (c)hr.get();
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "changePlayStateAndNotify:newSong=" + paramSongInfo.title + ",local callback=" + localObject);
          }
          if (Thread.currentThread() != Looper.getMainLooper().getThread())
          {
            if (this.mHandler == null) {
              this.mHandler = new Handler(Looper.getMainLooper());
            }
            this.mHandler.post(new QQPlayerService.5(this, (c)localObject, paramSongInfo));
          }
        }
        else
        {
          Iterator localIterator = callbacks.keySet().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
          localObject = (WeakReference)callbacks.get(localObject);
          if (localObject != null) {
            break label262;
          }
          localObject = null;
          if (localObject == null) {
            continue;
          }
          if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            break label275;
          }
          if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
          }
          this.mHandler.post(new QQPlayerService.6(this, (c)localObject, paramSongInfo));
          continue;
        }
        ((c)localObject).onPlaySongChanged(paramSongInfo);
      }
      finally {}
      continue;
      label262:
      Object localObject = (c)((WeakReference)localObject).get();
      continue;
      label275:
      ((c)localObject).onPlaySongChanged(paramSongInfo);
    }
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      int k = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
      int j = 0;
      for (;;)
      {
        if (j < k) {
          try
          {
            ((ajmi)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(j)).onPlaySongChanged(paramSongInfo);
            j += 1;
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
    }
  }
  
  public static int getCurrentSongPosition()
  {
    int k = -1;
    int j = k;
    try
    {
      if (g != null)
      {
        j = k;
        if (g.isPlaying()) {
          j = g.getCurrentPosition();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "getCurrentSongPosition(): sPlayState = " + bA(deN) + " position = " + j);
      }
      return j;
    }
    finally {}
  }
  
  public static int getDuration()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = "";
        if (i != null) {
          str = i.title;
        }
        QLog.d("QQPlayerService", 2, "getDuration(): title= " + str + " ,sPlayState = " + bA(deN) + " duration = " + deO);
      }
      int j = deO;
      return j;
    }
    finally {}
  }
  
  public static Bundle getExtras()
  {
    return bk;
  }
  
  public static int getPlayMode()
  {
    return djM;
  }
  
  public static int getPlayState()
  {
    return deN;
  }
  
  public static String getToken()
  {
    return sToken;
  }
  
  public static Intent i()
  {
    return af;
  }
  
  public static int iH()
  {
    return djN;
  }
  
  public static int iI()
  {
    if (c != null) {
      return c.length;
    }
    return 0;
  }
  
  private void initMediaPlayer()
  {
    g = new MediaPlayer();
    g.setOnErrorListener(this);
    g.setOnPreparedListener(this);
    g.setOnCompletionListener(this);
    g.setOnBufferingUpdateListener(this);
    g.setAudioStreamType(3);
  }
  
  private void initThread()
  {
    this.mHandlerThread = new HandlerThread("QQPlayerService");
    try
    {
      this.mHandlerThread.start();
      this.b = this.mHandlerThread.getLooper();
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e = new e(this.b);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QQPlayerService", 1, "start thread oom, stop self");
      stopSelf();
    }
  }
  
  public static boolean isPlaying()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "isPlaying : sPlayState " + bA(deN));
    }
    return (deN == 2) || (deN == 1);
  }
  
  private String mf(String paramString)
  {
    try
    {
      Object localObject = getExtras();
      if ((localObject != null) && (((Bundle)localObject).containsKey("cacheForRealUrl")))
      {
        localObject = (HashMap)((Bundle)localObject).getSerializable("cacheForRealUrl");
        if ((localObject != null) && (((HashMap)localObject).containsKey(paramString))) {
          return (String)((HashMap)localObject).get(paramString);
        }
        QLog.e("QQPlayerService", 1, "fakeUrl:" + paramString);
      }
      else
      {
        QLog.e("QQPlayerService", 1, "playDataExtras dont contains cacheForRealUrl !");
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private static String mg(String paramString)
  {
    if (paramString != null) {
      return MD5.toMD5(paramString);
    }
    return null;
  }
  
  public static boolean nt(String paramString)
  {
    if ((deN != 2) && (deN != 1)) {}
    while (sToken == null) {
      return false;
    }
    return sToken.equals(paramString);
  }
  
  public static boolean nu(String paramString)
  {
    paramString = mg(paramString);
    paramString = new File(acbn.bmv + paramString);
    return (paramString.exists()) && (paramString.length() > 102400L);
  }
  
  private void onHandleIntent(Intent paramIntent)
  {
    acX = SystemClock.uptimeMillis();
    if (paramIntent == null) {}
    int j;
    label118:
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return;
              try
              {
                j = paramIntent.getIntExtra("musicplayer.action", 0);
                if (QLog.isColorLevel()) {
                  QLog.d("QQPlayerService", 2, "action->" + eA(j));
                }
                if (j != 0)
                {
                  if (g != null) {
                    break label118;
                  }
                  if (QLog.isColorLevel())
                  {
                    QLog.e("QQPlayerService", 2, "onHandleIntent, sPlayer is null");
                    return;
                  }
                }
              }
              catch (Throwable paramIntent) {}
            }
          } while (!QLog.isColorLevel());
          QLog.e("QQPlayerService", 2, "onHandleIntent error" + paramIntent.getMessage(), paramIntent);
          return;
          switch (j)
          {
          default: 
            return;
          case 2: 
            paramIntent = (SongInfo)paramIntent.getParcelableExtra("musicplayer.song");
            if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.url))) {
              break label194;
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("QQPlayerService", 2, "mediaPlayStart, url is null");
        return;
        if (g.isPlaying()) {
          g.stop();
        }
        this.clp = false;
        i = paramIntent;
        f(i);
        MD(i.url);
      } while (paramIntent.startTime <= 0);
      seekTo(paramIntent.startTime);
      return;
    } while ((deN != 2) && ((deN != 1) || (g == null)));
    label194:
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.eg);
    }
    if (g.isPlaying()) {
      g.pause();
    }
    this.clp = true;
    Rh(3);
    return;
    if ((deN == 3) && (g != null))
    {
      this.clp = false;
      j = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.eg, 3, 1);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder().append("requestAudioFocus,result:");
        if (j != 1) {
          break label1031;
        }
      }
    }
    label1031:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQPlayerService", 2, bool);
      g.start();
      Rh(2);
      return;
      if ((deN == 6) || ((deN == 7) && (i != null) && (!TextUtils.isEmpty(i.url))))
      {
        if (!aqiw.isNetworkAvailable(getApplicationContext())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "resume from network interrupt, start play " + i.title);
        }
        this.clp = false;
        MD(i.url);
        return;
      }
      if ((deN != 5) || (i == null) || (TextUtils.isEmpty(i.url))) {
        break;
      }
      this.clp = false;
      MD(i.url);
      return;
      if ((g != null) && (g.isPlaying())) {
        g.stop();
      }
      this.clp = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.isAlive()) && (!this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop)) {
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.stop = true;
      }
      Rh(4);
      if ((sToken != null) && (sToken.startsWith("qzone_")) && (g != null))
      {
        this.clp = true;
        djN = 0;
        i = null;
      }
      stopSelf();
      return;
      try
      {
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread;
        if ((paramIntent == null) || (g == null) || (!paramIntent.isAlive()) || (!paramIntent.cpq) || (paramIntent.stop) || (!paramIntent.url.equals(i.url)) || (!this.cpl) || (deO == 0)) {
          break label905;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, current playing song isDownloading...");
        }
        if ((!g.isPlaying()) || (this.cpm)) {
          break label908;
        }
        j = getCurrentSongPosition();
        if (j / deO * paramIntent.fileSize + paramIntent.fileSize * this.xv >= deO)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data is ok, just return;");
          }
          return;
        }
      }
      finally {}
      float f = j;
      if (f / deO * paramIntent.fileSize + paramIntent.fileSize * this.xv > paramIntent.djQ)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS,no more data to play, need pause!");
        }
        this.djO = j;
        this.cpm = true;
        g.pause();
        Rh(1);
        QLog.i("QQPlayerService", 2, "buffered");
      }
      for (;;)
      {
        dyq();
        label905:
        return;
        label908:
        if ((!this.cpm) || (deN != 1) || (g.isPlaying())) {
          break;
        }
        if (this.djO / deO * paramIntent.fileSize + paramIntent.fileSize * this.xv <= paramIntent.djQ)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, data buffering is enough");
          }
          this.djO = 0;
          this.cpm = false;
          if (!this.clp)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "ACTION_LOOP_PROGRESS, user no Pause,so play!");
            }
            g.start();
            Rh(2);
          }
        }
      }
      return;
    }
  }
  
  private static void resetMediaPlayer()
  {
    if (g != null) {}
    try
    {
      g.reset();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void seekTo(int paramInt)
  {
    if ((g != null) && ((deN == 2) || (deN == 3))) {}
    try
    {
      g.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQPlayerService", 2, "seekTo", localIllegalStateException);
    }
  }
  
  public static void setExtras(Bundle paramBundle)
  {
    bk = paramBundle;
  }
  
  public static void setPlayMode(int paramInt)
  {
    djM = paramInt;
  }
  
  public void dyq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "loopProgress : loopProgressDelayTime=" + this.acY);
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.obtainMessage();
    Intent localIntent = new Intent();
    localIntent.putExtra("musicplayer.action", 4);
    localMessage.obj = localIntent;
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.sendMessageDelayed(localMessage, this.acY);
  }
  
  public ColorNote getColorNote()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (i != null)
    {
      localObject1 = localObject2;
      if (i.detailUrl != null) {
        localObject1 = i.detailUrl.getBytes();
      }
      localObject1 = new ColorNote.a().a(16973824).a("music_color_note_only_one").b(i.title).c(i.singer).d(i.coverUrl).a((byte[])localObject1).a();
    }
    return localObject1;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onBind");
    }
    return this.jdField_a_of_type_Ajmj$a;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if ((QLog.isColorLevel()) && (cpn) && (paramInt < 100)) {
      QLog.d("QQPlayerService", 2, "onBufferingUpdate : " + paramInt + "% buffered");
    }
  }
  
  @TargetApi(8)
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCompletion");
    }
    Rh(8);
    if ((!br(getApplicationContext())) && (VersionUtils.isrFroyo())) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.eg);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onCreate");
    }
    if (VersionUtils.isrFroyo()) {
      this.eg = new ajmk(this);
    }
    initThread();
    if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$b = new b();
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.post(new QQPlayerService.2(this));
    this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$a = new a();
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$a);
    this.mColorNoteController = new aeay(getBaseContext(), false, false);
    this.mColorNoteController.setServiceInfo(this);
    this.mColorNoteController.cVC();
    this.mColorNoteController.a(this.jdField_a_of_type_Aeeg);
    this.mColorNoteController.registerBroadcast();
    b(akum.b());
  }
  
  @TargetApi(18)
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQPlayerService", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e != null)
    {
      Object localObject = new d(null);
      ((d)localObject).player = g;
      ((d)localObject).looper = this.b;
      ((d)localObject).k = i;
      localObject = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.obtainMessage(1, localObject);
      this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.sendMessage((Message)localObject);
    }
    this.mColorNoteController.cVD();
    sToken = null;
    deO = 0;
    djN = 0;
    af = null;
    bk = null;
    if (this.mHandler != null) {
      this.mHandler = null;
    }
    if (this.jdField_a_of_type_AndroidOsRemoteCallbackList != null)
    {
      this.jdField_a_of_type_AndroidOsRemoteCallbackList.kill();
      this.jdField_a_of_type_AndroidOsRemoteCallbackList = null;
    }
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.eg);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$a != null) {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$a);
      }
      dyr();
      this.aZC = true;
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
      if (g != null) {
        g.release();
      }
      initMediaPlayer();
    }
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener)this.eg);
    }
    resetMediaPlayer();
    try
    {
      Rh(5);
      label99:
      return true;
    }
    catch (NullPointerException paramMediaPlayer)
    {
      break label99;
    }
  }
  
  @TargetApi(8)
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (g == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQPlayerService", 2, "player is null while invoking method onPrepared");
      }
      stopSelf();
    }
    int j;
    do
    {
      do
      {
        return;
        deO = g.getDuration();
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "onPrepared:sDuration" + deO);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.cpq) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.url != null) && (i != null) && (this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$DownloadThread.url.equals(i.url)))
        {
          if (deO != 0) {
            this.acY = ((deO * 0.01D));
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "onPrepared:loopProgressDelayTime:" + this.acY);
          }
          dyq();
        }
        if (VersionUtils.isrFroyo()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQPlayerService", 2, "onPrepared Android 2.1 and below can not stop music");
      return;
      j = ((AudioManager)getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener)this.eg, 3, 1);
    } while (!QLog.isColorLevel());
    paramMediaPlayer = new StringBuilder().append("requestAudioFocus,result:");
    if (j == 1) {}
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
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onStartCommand");
    }
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.obtainMessage();
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      if (!paramIntent.getBooleanExtra("key_add_to_color_note", true)) {
        break label107;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      cpo = bool1;
      localMessage.obj = paramIntent;
      if ((this.mHandlerThread == null) || (this.mHandlerThread.isAlive()) || (this.b != null)) {}
      try
      {
        this.b.quit();
        label91:
        initThread();
        this.jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService$e.sendMessage(localMessage);
        return 2;
        label107:
        bool1 = false;
      }
      catch (Throwable paramIntent)
      {
        break label91;
      }
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
  
  class DownloadThread
    extends Thread
  {
    public volatile boolean aIS = true;
    public volatile boolean cpp;
    public volatile boolean cpq;
    private int djP;
    public int djQ;
    public String fileName;
    public int fileSize;
    public volatile boolean stop;
    public String url;
    
    public DownloadThread(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      setName("QQPlayerService-DownloadThread");
      this.url = paramString1;
      this.fileName = paramString2;
      this.djP = paramInt2;
      this.fileSize = paramInt2;
      this.djQ = paramInt1;
    }
    
    private File createNewFile(String paramString)
    {
      File localFile = new File(acbn.bmv);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      paramString = new File(acbn.bmv + paramString);
      if (!paramString.exists()) {}
      try
      {
        paramString.createNewFile();
        return paramString;
      }
      catch (IOException localIOException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("QQPlayerService", 2, "createNewFile:" + localIOException.getMessage(), localIOException);
      }
      return paramString;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 113	aqgz:getSDCardMemory	()[J
      //   3: astore 5
      //   5: aload 5
      //   7: ifnull +39 -> 46
      //   10: aload 5
      //   12: iconst_1
      //   13: laload
      //   14: ldc2_w 114
      //   17: lcmp
      //   18: ifgt +28 -> 46
      //   21: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   24: ifeq +11 -> 35
      //   27: ldc 87
      //   29: iconst_2
      //   30: ldc 117
      //   32: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   35: aload_0
      //   36: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   39: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
      //   42: invokestatic 128	com/tencent/mobileqq/music/QQPlayerService:eG	(Landroid/content/Context;)V
      //   45: return
      //   46: aload_0
      //   47: aload_0
      //   48: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   51: invokespecial 130	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:createNewFile	(Ljava/lang/String;)Ljava/io/File;
      //   54: astore 10
      //   56: aload_0
      //   57: iconst_1
      //   58: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   61: aconst_null
      //   62: astore 5
      //   64: new 134	java/io/RandomAccessFile
      //   67: dup
      //   68: aload 10
      //   70: invokevirtual 137	java/io/File:getPath	()Ljava/lang/String;
      //   73: ldc 139
      //   75: invokespecial 142	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   78: astore 6
      //   80: aload 6
      //   82: astore 5
      //   84: ldc 144
      //   86: aload_0
      //   87: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:url	Ljava/lang/String;
      //   90: invokestatic 150	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   93: astore 9
      //   95: aload 6
      //   97: astore 5
      //   99: new 152	java/net/URL
      //   102: dup
      //   103: aload 9
      //   105: invokespecial 153	java/net/URL:<init>	(Ljava/lang/String;)V
      //   108: astore 8
      //   110: aload 6
      //   112: astore 5
      //   114: invokestatic 157	com/tencent/mobileqq/music/QQPlayerService:g	()Lcom/tencent/mobileqq/music/SongInfo;
      //   117: astore 7
      //   119: aload 7
      //   121: ifnonnull +74 -> 195
      //   124: aload 6
      //   126: astore 5
      //   128: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   131: ifeq +15 -> 146
      //   134: aload 6
      //   136: astore 5
      //   138: ldc 87
      //   140: iconst_2
      //   141: ldc 159
      //   143: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   146: aload_0
      //   147: iconst_0
      //   148: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   151: aload 6
      //   153: ifnull +8 -> 161
      //   156: aload 6
      //   158: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   161: aload_0
      //   162: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   165: aload_0
      //   166: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   169: if_icmpge -124 -> 45
      //   172: aload_0
      //   173: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   176: ifle -131 -> 45
      //   179: aload_0
      //   180: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   183: aload_0
      //   184: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   187: aload_0
      //   188: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   191: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   194: return
      //   195: aload 6
      //   197: astore 5
      //   199: aload 7
      //   201: getfield 174	com/tencent/mobileqq/music/SongInfo:url	Ljava/lang/String;
      //   204: astore 11
      //   206: aload 6
      //   208: astore 5
      //   210: aload 11
      //   212: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   215: ifne +3107 -> 3322
      //   218: aload 6
      //   220: astore 5
      //   222: aload 11
      //   224: ldc 182
      //   226: invokevirtual 188	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   229: ifeq +3093 -> 3322
      //   232: aload 6
      //   234: astore 5
      //   236: aload_0
      //   237: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:url	Ljava/lang/String;
      //   240: aload_0
      //   241: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   244: aload 11
      //   246: invokestatic 192	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
      //   249: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   252: istore_3
      //   253: aload 6
      //   255: astore 5
      //   257: aload 7
      //   259: getfield 174	com/tencent/mobileqq/music/SongInfo:url	Ljava/lang/String;
      //   262: aload_0
      //   263: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:url	Ljava/lang/String;
      //   266: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   269: ifne +7 -> 276
      //   272: iload_3
      //   273: ifeq +3054 -> 3327
      //   276: aload 6
      //   278: astore 5
      //   280: aload_0
      //   281: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:aIS	Z
      //   284: ifeq +3043 -> 3327
      //   287: aload 6
      //   289: astore 5
      //   291: aload_0
      //   292: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   295: i2f
      //   296: aload_0
      //   297: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   300: i2f
      //   301: aload_0
      //   302: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   305: getfield 200	com/tencent/mobileqq/music/QQPlayerService:xv	F
      //   308: fmul
      //   309: fcmpl
      //   310: ifle +598 -> 908
      //   313: aload 6
      //   315: astore 5
      //   317: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   320: ifeq +15 -> 335
      //   323: aload 6
      //   325: astore 5
      //   327: ldc 87
      //   329: iconst_2
      //   330: ldc 202
      //   332: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   335: aload 6
      //   337: astore 5
      //   339: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   342: invokevirtual 211	android/media/MediaPlayer:reset	()V
      //   345: aload 6
      //   347: astore 5
      //   349: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   352: aload 10
      //   354: invokevirtual 214	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   357: invokevirtual 217	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
      //   360: aload 6
      //   362: astore 5
      //   364: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   367: invokevirtual 220	android/media/MediaPlayer:prepare	()V
      //   370: aload 6
      //   372: astore 5
      //   374: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   377: invokevirtual 223	android/media/MediaPlayer:start	()V
      //   380: aload 6
      //   382: astore 5
      //   384: aload_0
      //   385: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   388: iconst_2
      //   389: invokestatic 226	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
      //   392: aload 6
      //   394: astore 5
      //   396: aload_0
      //   397: iconst_0
      //   398: putfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:aIS	Z
      //   401: goto +2926 -> 3327
      //   404: iload_2
      //   405: ifgt +2910 -> 3315
      //   408: iload_1
      //   409: iconst_5
      //   410: if_icmpgt +2905 -> 3315
      //   413: aload 6
      //   415: astore 5
      //   417: aload 8
      //   419: invokevirtual 230	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   422: checkcast 232	java/net/HttpURLConnection
      //   425: astore 7
      //   427: aload 6
      //   429: astore 5
      //   431: aload 7
      //   433: iconst_0
      //   434: invokevirtual 236	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   437: aload 6
      //   439: astore 5
      //   441: aload 7
      //   443: ldc 238
      //   445: ldc 240
      //   447: invokevirtual 243	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   450: aload 6
      //   452: astore 5
      //   454: aload_0
      //   455: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   458: ifeq +63 -> 521
      //   461: aload 6
      //   463: astore 5
      //   465: aload_0
      //   466: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   469: aload_0
      //   470: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   473: if_icmple +48 -> 521
      //   476: aload 6
      //   478: astore 5
      //   480: aload 7
      //   482: ldc 245
      //   484: new 69	java/lang/StringBuilder
      //   487: dup
      //   488: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   491: ldc 247
      //   493: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   496: aload_0
      //   497: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   500: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   503: ldc 252
      //   505: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   508: aload_0
      //   509: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   512: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   515: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   518: invokevirtual 243	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   521: aload 6
      //   523: astore 5
      //   525: aload 8
      //   527: invokevirtual 255	java/net/URL:getHost	()Ljava/lang/String;
      //   530: astore 11
      //   532: aload 6
      //   534: astore 5
      //   536: aload 11
      //   538: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   541: ifne +270 -> 811
      //   544: aload 6
      //   546: astore 5
      //   548: aload 11
      //   550: ldc_w 257
      //   553: invokevirtual 260	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   556: ifeq +255 -> 811
      //   559: aload 6
      //   561: astore 5
      //   563: invokestatic 266	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
      //   566: invokevirtual 270	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
      //   569: iconst_2
      //   570: invokevirtual 276	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
      //   573: checkcast 278	mqq/manager/TicketManager
      //   576: astore 12
      //   578: aload 6
      //   580: astore 5
      //   582: invokestatic 266	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
      //   585: invokevirtual 270	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
      //   588: invokevirtual 281	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
      //   591: astore 11
      //   593: aload 6
      //   595: astore 5
      //   597: aload 12
      //   599: aload 11
      //   601: ldc2_w 282
      //   604: iconst_1
      //   605: anewarray 184	java/lang/String
      //   608: dup
      //   609: iconst_0
      //   610: ldc_w 257
      //   613: aastore
      //   614: aconst_null
      //   615: invokeinterface 287 6 0
      //   620: astore 12
      //   622: aload 12
      //   624: ifnull +459 -> 1083
      //   627: aload 6
      //   629: astore 5
      //   631: aload 12
      //   633: getfield 293	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
      //   636: ifnull +447 -> 1083
      //   639: aload 6
      //   641: astore 5
      //   643: aload 12
      //   645: getfield 293	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
      //   648: ldc_w 257
      //   651: invokeinterface 299 2 0
      //   656: ifnull +427 -> 1083
      //   659: aload 6
      //   661: astore 5
      //   663: ldc 87
      //   665: iconst_1
      //   666: ldc_w 301
      //   669: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   672: aload 6
      //   674: astore 5
      //   676: new 184	java/lang/String
      //   679: dup
      //   680: aload 12
      //   682: getfield 293	oicq/wlogin_sdk/request/Ticket:_pskey_map	Ljava/util/Map;
      //   685: ldc_w 257
      //   688: invokeinterface 299 2 0
      //   693: checkcast 303	[B
      //   696: invokespecial 306	java/lang/String:<init>	([B)V
      //   699: astore 12
      //   701: aload 6
      //   703: astore 5
      //   705: new 69	java/lang/StringBuilder
      //   708: dup
      //   709: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   712: ldc_w 308
      //   715: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   718: aload 12
      //   720: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   723: ldc_w 310
      //   726: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   729: aload 11
      //   731: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   734: ldc_w 312
      //   737: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   740: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   743: astore 11
      //   745: aload 6
      //   747: astore 5
      //   749: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   752: ifeq +45 -> 797
      //   755: aload 6
      //   757: astore 5
      //   759: ldc 87
      //   761: iconst_1
      //   762: new 69	java/lang/StringBuilder
      //   765: dup
      //   766: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   769: ldc_w 314
      //   772: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   775: aload 9
      //   777: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   780: ldc_w 316
      //   783: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   786: aload 11
      //   788: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   791: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   794: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   797: aload 6
      //   799: astore 5
      //   801: aload 7
      //   803: ldc_w 320
      //   806: aload 11
      //   808: invokevirtual 243	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   811: aload 6
      //   813: astore 5
      //   815: aload 7
      //   817: invokevirtual 323	java/net/HttpURLConnection:connect	()V
      //   820: aload 6
      //   822: astore 5
      //   824: aload 7
      //   826: invokevirtual 327	java/net/HttpURLConnection:getResponseCode	()I
      //   829: sipush 302
      //   832: if_icmpne +335 -> 1167
      //   835: iload_1
      //   836: iconst_1
      //   837: iadd
      //   838: istore_1
      //   839: aload 6
      //   841: astore 5
      //   843: new 152	java/net/URL
      //   846: dup
      //   847: aload 7
      //   849: ldc_w 329
      //   852: invokevirtual 333	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   855: invokespecial 153	java/net/URL:<init>	(Ljava/lang/String;)V
      //   858: astore 8
      //   860: aload 6
      //   862: astore 5
      //   864: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   867: ifeq +2441 -> 3308
      //   870: aload 6
      //   872: astore 5
      //   874: ldc 87
      //   876: iconst_1
      //   877: new 69	java/lang/StringBuilder
      //   880: dup
      //   881: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   884: ldc_w 335
      //   887: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   890: aload 8
      //   892: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   895: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   898: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   901: aload 7
      //   903: astore 5
      //   905: goto -501 -> 404
      //   908: aload 6
      //   910: astore 5
      //   912: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   915: ifeq +16 -> 931
      //   918: aload 6
      //   920: astore 5
      //   922: ldc 87
      //   924: iconst_2
      //   925: ldc_w 340
      //   928: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   931: aload 6
      //   933: astore 5
      //   935: aload_0
      //   936: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   939: iconst_1
      //   940: invokestatic 226	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
      //   943: goto +2384 -> 3327
      //   946: astore 7
      //   948: aload 6
      //   950: astore 5
      //   952: aload 7
      //   954: astore 6
      //   956: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   959: ifeq +35 -> 994
      //   962: ldc 87
      //   964: iconst_2
      //   965: new 69	java/lang/StringBuilder
      //   968: dup
      //   969: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   972: ldc_w 342
      //   975: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   978: aload 6
      //   980: invokevirtual 343	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
      //   983: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   986: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   989: aload 6
      //   991: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   994: aload_0
      //   995: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   998: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
      //   1001: invokestatic 128	com/tencent/mobileqq/music/QQPlayerService:eG	(Landroid/content/Context;)V
      //   1004: aload_0
      //   1005: iconst_0
      //   1006: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   1009: aload 5
      //   1011: ifnull +8 -> 1019
      //   1014: aload 5
      //   1016: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   1019: aload_0
      //   1020: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1023: aload_0
      //   1024: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1027: if_icmpge +25 -> 1052
      //   1030: aload_0
      //   1031: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1034: ifle +18 -> 1052
      //   1037: aload_0
      //   1038: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   1041: aload_0
      //   1042: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1045: aload_0
      //   1046: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1049: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   1052: aload_0
      //   1053: getfield 345	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpp	Z
      //   1056: ifeq +6 -> 1062
      //   1059: invokestatic 348	aqiv:edU	()V
      //   1062: aload_0
      //   1063: iconst_0
      //   1064: putfield 345	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpp	Z
      //   1067: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1070: ifeq -1025 -> 45
      //   1073: ldc 87
      //   1075: iconst_2
      //   1076: ldc_w 350
      //   1079: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1082: return
      //   1083: aload 6
      //   1085: astore 5
      //   1087: ldc 87
      //   1089: ldc_w 352
      //   1092: invokestatic 357	cooperation/qzone/util/QZLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   1095: iload_1
      //   1096: iconst_1
      //   1097: iadd
      //   1098: istore_1
      //   1099: aload 6
      //   1101: astore 5
      //   1103: ldc2_w 358
      //   1106: invokestatic 363	java/lang/Thread:sleep	(J)V
      //   1109: aload 7
      //   1111: astore 5
      //   1113: goto -709 -> 404
      //   1116: astore 11
      //   1118: aload 6
      //   1120: astore 5
      //   1122: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1125: ifeq +2212 -> 3337
      //   1128: aload 6
      //   1130: astore 5
      //   1132: ldc 87
      //   1134: iconst_2
      //   1135: new 69	java/lang/StringBuilder
      //   1138: dup
      //   1139: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   1142: ldc_w 365
      //   1145: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1148: aload 11
      //   1150: invokevirtual 366	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   1153: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1156: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1159: aload 11
      //   1161: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1164: goto +2173 -> 3337
      //   1167: aload 6
      //   1169: astore 5
      //   1171: ldc 87
      //   1173: iconst_1
      //   1174: new 69	java/lang/StringBuilder
      //   1177: dup
      //   1178: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   1181: ldc_w 368
      //   1184: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1187: aload 7
      //   1189: invokevirtual 327	java/net/HttpURLConnection:getResponseCode	()I
      //   1192: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1195: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1198: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   1201: aload 6
      //   1203: astore 5
      //   1205: aload 7
      //   1207: invokevirtual 371	java/net/HttpURLConnection:getContentLength	()I
      //   1210: istore_2
      //   1211: iload_2
      //   1212: ifle +92 -> 1304
      //   1215: iload_2
      //   1216: ifgt +273 -> 1489
      //   1219: aload 6
      //   1221: astore 5
      //   1223: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1226: ifeq +16 -> 1242
      //   1229: aload 6
      //   1231: astore 5
      //   1233: ldc 87
      //   1235: iconst_2
      //   1236: ldc_w 373
      //   1239: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1242: aload 6
      //   1244: astore 5
      //   1246: aload_0
      //   1247: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   1250: bipush 7
      //   1252: invokestatic 226	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
      //   1255: aload_0
      //   1256: iconst_0
      //   1257: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   1260: aload 6
      //   1262: ifnull +8 -> 1270
      //   1265: aload 6
      //   1267: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   1270: aload_0
      //   1271: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1274: aload_0
      //   1275: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1278: if_icmpge -1233 -> 45
      //   1281: aload_0
      //   1282: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1285: ifle -1240 -> 45
      //   1288: aload_0
      //   1289: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   1292: aload_0
      //   1293: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1296: aload_0
      //   1297: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1300: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   1303: return
      //   1304: aload 6
      //   1306: astore 5
      //   1308: ldc2_w 358
      //   1311: invokestatic 363	java/lang/Thread:sleep	(J)V
      //   1314: iload_1
      //   1315: iconst_1
      //   1316: iadd
      //   1317: istore_1
      //   1318: aload 7
      //   1320: astore 5
      //   1322: goto -918 -> 404
      //   1325: astore 11
      //   1327: aload 6
      //   1329: astore 5
      //   1331: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1334: ifeq -20 -> 1314
      //   1337: aload 6
      //   1339: astore 5
      //   1341: ldc 87
      //   1343: iconst_2
      //   1344: new 69	java/lang/StringBuilder
      //   1347: dup
      //   1348: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   1351: ldc_w 365
      //   1354: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1357: aload 11
      //   1359: invokevirtual 366	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   1362: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1365: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1368: aload 11
      //   1370: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1373: goto -59 -> 1314
      //   1376: astore 7
      //   1378: aload 6
      //   1380: astore 5
      //   1382: aload_0
      //   1383: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   1386: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
      //   1389: invokestatic 128	com/tencent/mobileqq/music/QQPlayerService:eG	(Landroid/content/Context;)V
      //   1392: aload 6
      //   1394: astore 5
      //   1396: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1399: ifeq +39 -> 1438
      //   1402: aload 6
      //   1404: astore 5
      //   1406: ldc 87
      //   1408: iconst_2
      //   1409: new 69	java/lang/StringBuilder
      //   1412: dup
      //   1413: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   1416: ldc_w 375
      //   1419: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1422: aload 7
      //   1424: invokevirtual 376	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
      //   1427: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1430: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1433: aload 7
      //   1435: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1438: aload_0
      //   1439: iconst_0
      //   1440: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   1443: aload 6
      //   1445: ifnull +8 -> 1453
      //   1448: aload 6
      //   1450: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   1453: aload_0
      //   1454: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1457: aload_0
      //   1458: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1461: if_icmpge -409 -> 1052
      //   1464: aload_0
      //   1465: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1468: ifle -416 -> 1052
      //   1471: aload_0
      //   1472: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   1475: aload_0
      //   1476: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1479: aload_0
      //   1480: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1483: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   1486: goto -434 -> 1052
      //   1489: iload_2
      //   1490: istore_1
      //   1491: aload 6
      //   1493: astore 5
      //   1495: aload_0
      //   1496: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1499: ifle +14 -> 1513
      //   1502: aload 6
      //   1504: astore 5
      //   1506: iload_2
      //   1507: aload_0
      //   1508: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1511: iadd
      //   1512: istore_1
      //   1513: aload 6
      //   1515: astore 5
      //   1517: aload_0
      //   1518: iload_1
      //   1519: putfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1522: iload_1
      //   1523: istore_2
      //   1524: aload 7
      //   1526: astore 9
      //   1528: aload 6
      //   1530: astore 5
      //   1532: aload_0
      //   1533: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   1536: ifeq +246 -> 1782
      //   1539: iload_1
      //   1540: istore_2
      //   1541: aload 7
      //   1543: astore 9
      //   1545: aload 6
      //   1547: astore 5
      //   1549: aload_0
      //   1550: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   1553: iload_1
      //   1554: if_icmpeq +228 -> 1782
      //   1557: aload 6
      //   1559: astore 5
      //   1561: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1564: ifeq +46 -> 1610
      //   1567: aload 6
      //   1569: astore 5
      //   1571: ldc 87
      //   1573: iconst_2
      //   1574: new 69	java/lang/StringBuilder
      //   1577: dup
      //   1578: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   1581: ldc_w 378
      //   1584: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1587: aload_0
      //   1588: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   1591: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1594: ldc_w 380
      //   1597: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1600: iload_1
      //   1601: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1604: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1607: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1610: aload 6
      //   1612: astore 5
      //   1614: aload_0
      //   1615: iconst_0
      //   1616: putfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1619: aload 6
      //   1621: astore 5
      //   1623: aload_0
      //   1624: iconst_1
      //   1625: putfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:aIS	Z
      //   1628: aload 6
      //   1630: astore 5
      //   1632: aload 8
      //   1634: invokevirtual 230	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   1637: checkcast 232	java/net/HttpURLConnection
      //   1640: astore 9
      //   1642: aload 6
      //   1644: astore 5
      //   1646: aload 9
      //   1648: iconst_1
      //   1649: invokevirtual 236	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   1652: aload 6
      //   1654: astore 5
      //   1656: aload 9
      //   1658: ldc 238
      //   1660: ldc 240
      //   1662: invokevirtual 243	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1665: aload 6
      //   1667: astore 5
      //   1669: aload 9
      //   1671: invokevirtual 323	java/net/HttpURLConnection:connect	()V
      //   1674: aload 6
      //   1676: astore 5
      //   1678: aload 9
      //   1680: invokevirtual 371	java/net/HttpURLConnection:getContentLength	()I
      //   1683: istore_2
      //   1684: iload_2
      //   1685: ifge +88 -> 1773
      //   1688: aload 6
      //   1690: astore 5
      //   1692: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1695: ifeq +16 -> 1711
      //   1698: aload 6
      //   1700: astore 5
      //   1702: ldc 87
      //   1704: iconst_2
      //   1705: ldc_w 382
      //   1708: invokestatic 318	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   1711: aload 6
      //   1713: astore 5
      //   1715: aload_0
      //   1716: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   1719: bipush 7
      //   1721: invokestatic 226	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
      //   1724: aload_0
      //   1725: iconst_0
      //   1726: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   1729: aload 6
      //   1731: ifnull +8 -> 1739
      //   1734: aload 6
      //   1736: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   1739: aload_0
      //   1740: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1743: aload_0
      //   1744: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1747: if_icmpge -1702 -> 45
      //   1750: aload_0
      //   1751: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1754: ifle -1709 -> 45
      //   1757: aload_0
      //   1758: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   1761: aload_0
      //   1762: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1765: aload_0
      //   1766: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1769: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   1772: return
      //   1773: aload 6
      //   1775: astore 5
      //   1777: aload_0
      //   1778: iload_2
      //   1779: putfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1782: aload 6
      //   1784: astore 5
      //   1786: aload 6
      //   1788: iload_2
      //   1789: i2l
      //   1790: invokevirtual 385	java/io/RandomAccessFile:setLength	(J)V
      //   1793: aload 6
      //   1795: astore 5
      //   1797: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1800: ifeq +62 -> 1862
      //   1803: aload 6
      //   1805: astore 5
      //   1807: ldc 87
      //   1809: iconst_2
      //   1810: new 69	java/lang/StringBuilder
      //   1813: dup
      //   1814: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   1817: ldc_w 387
      //   1820: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1823: aload_0
      //   1824: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1827: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1830: ldc_w 389
      //   1833: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1836: aload_0
      //   1837: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   1840: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1843: ldc_w 391
      //   1846: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1849: aload_0
      //   1850: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1853: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1856: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1859: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1862: aload 6
      //   1864: astore 5
      //   1866: aload 9
      //   1868: invokevirtual 395	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   1871: astore 7
      //   1873: aload 6
      //   1875: astore 5
      //   1877: sipush 8192
      //   1880: newarray byte
      //   1882: astore 8
      //   1884: aload 6
      //   1886: astore 5
      //   1888: aload 6
      //   1890: aload_0
      //   1891: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1894: i2l
      //   1895: invokevirtual 398	java/io/RandomAccessFile:seek	(J)V
      //   1898: aload 6
      //   1900: astore 5
      //   1902: aload_0
      //   1903: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   1906: ifne +22 -> 1928
      //   1909: aload 6
      //   1911: astore 5
      //   1913: aload_0
      //   1914: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   1917: aload_0
      //   1918: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1921: aload_0
      //   1922: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1925: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   1928: iconst_0
      //   1929: istore_2
      //   1930: iload_2
      //   1931: istore_1
      //   1932: aload 6
      //   1934: astore 5
      //   1936: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1939: ifeq +51 -> 1990
      //   1942: aload 6
      //   1944: astore 5
      //   1946: ldc 87
      //   1948: iconst_2
      //   1949: new 69	java/lang/StringBuilder
      //   1952: dup
      //   1953: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   1956: ldc_w 400
      //   1959: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1962: aload_0
      //   1963: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   1966: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1969: ldc_w 391
      //   1972: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1975: aload_0
      //   1976: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   1979: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1982: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1985: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1988: iload_2
      //   1989: istore_1
      //   1990: aload 6
      //   1992: astore 5
      //   1994: aload_0
      //   1995: getfield 402	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:stop	Z
      //   1998: ifne +858 -> 2856
      //   2001: aload 6
      //   2003: astore 5
      //   2005: aload_0
      //   2006: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2009: aload_0
      //   2010: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2013: if_icmpge +843 -> 2856
      //   2016: iload_1
      //   2017: bipush 10
      //   2019: if_icmpge +837 -> 2856
      //   2022: aload 6
      //   2024: astore 5
      //   2026: invokestatic 157	com/tencent/mobileqq/music/QQPlayerService:g	()Lcom/tencent/mobileqq/music/SongInfo;
      //   2029: astore 9
      //   2031: aload 9
      //   2033: ifnonnull +74 -> 2107
      //   2036: aload 6
      //   2038: astore 5
      //   2040: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2043: ifeq +15 -> 2058
      //   2046: aload 6
      //   2048: astore 5
      //   2050: ldc 87
      //   2052: iconst_2
      //   2053: ldc 159
      //   2055: invokestatic 162	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   2058: aload_0
      //   2059: iconst_0
      //   2060: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   2063: aload 6
      //   2065: ifnull +8 -> 2073
      //   2068: aload 6
      //   2070: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   2073: aload_0
      //   2074: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2077: aload_0
      //   2078: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2081: if_icmpge -2036 -> 45
      //   2084: aload_0
      //   2085: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2088: ifle -2043 -> 45
      //   2091: aload_0
      //   2092: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   2095: aload_0
      //   2096: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2099: aload_0
      //   2100: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2103: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   2106: return
      //   2107: aload 6
      //   2109: astore 5
      //   2111: aload_0
      //   2112: getfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:aIS	Z
      //   2115: ifeq +191 -> 2306
      //   2118: aload 6
      //   2120: astore 5
      //   2122: aload 9
      //   2124: getfield 174	com/tencent/mobileqq/music/SongInfo:url	Ljava/lang/String;
      //   2127: aload_0
      //   2128: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:url	Ljava/lang/String;
      //   2131: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2134: ifne +7 -> 2141
      //   2137: iload_3
      //   2138: ifeq +168 -> 2306
      //   2141: aload 6
      //   2143: astore 5
      //   2145: aload_0
      //   2146: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2149: i2f
      //   2150: aload_0
      //   2151: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2154: i2f
      //   2155: aload_0
      //   2156: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   2159: getfield 200	com/tencent/mobileqq/music/QQPlayerService:xv	F
      //   2162: fmul
      //   2163: fcmpl
      //   2164: ifle +142 -> 2306
      //   2167: aload 6
      //   2169: astore 5
      //   2171: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   2174: invokevirtual 211	android/media/MediaPlayer:reset	()V
      //   2177: aload 6
      //   2179: astore 5
      //   2181: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   2184: aload 10
      //   2186: invokevirtual 214	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   2189: invokevirtual 217	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
      //   2192: aload 6
      //   2194: astore 5
      //   2196: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   2199: invokevirtual 220	android/media/MediaPlayer:prepare	()V
      //   2202: aload 6
      //   2204: astore 5
      //   2206: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2209: ifeq +52 -> 2261
      //   2212: aload 6
      //   2214: astore 5
      //   2216: ldc 87
      //   2218: iconst_2
      //   2219: new 69	java/lang/StringBuilder
      //   2222: dup
      //   2223: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   2226: ldc_w 404
      //   2229: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2232: aload_0
      //   2233: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2236: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2239: ldc_w 406
      //   2242: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2245: aload_0
      //   2246: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   2249: invokestatic 410	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
      //   2252: invokevirtual 413	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   2255: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2258: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2261: aload 6
      //   2263: astore 5
      //   2265: aload_0
      //   2266: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   2269: invokestatic 410	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
      //   2272: ifne +25 -> 2297
      //   2275: aload 6
      //   2277: astore 5
      //   2279: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   2282: invokevirtual 223	android/media/MediaPlayer:start	()V
      //   2285: aload 6
      //   2287: astore 5
      //   2289: aload_0
      //   2290: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   2293: iconst_2
      //   2294: invokestatic 226	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
      //   2297: aload 6
      //   2299: astore 5
      //   2301: aload_0
      //   2302: iconst_0
      //   2303: putfield 30	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:aIS	Z
      //   2306: aload 6
      //   2308: astore 5
      //   2310: aload 7
      //   2312: aload 8
      //   2314: invokevirtual 419	java/io/InputStream:read	([B)I
      //   2317: istore_2
      //   2318: iload_2
      //   2319: ifgt +392 -> 2711
      //   2322: aload 6
      //   2324: astore 5
      //   2326: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2329: ifeq +16 -> 2345
      //   2332: aload 6
      //   2334: astore 5
      //   2336: ldc 87
      //   2338: iconst_2
      //   2339: ldc_w 421
      //   2342: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2345: aload 6
      //   2347: astore 5
      //   2349: ldc2_w 358
      //   2352: invokestatic 363	java/lang/Thread:sleep	(J)V
      //   2355: iload_1
      //   2356: iconst_1
      //   2357: iadd
      //   2358: istore_1
      //   2359: goto -369 -> 1990
      //   2362: astore 9
      //   2364: aload 6
      //   2366: astore 5
      //   2368: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2371: ifeq -16 -> 2355
      //   2374: aload 6
      //   2376: astore 5
      //   2378: ldc 87
      //   2380: iconst_2
      //   2381: new 69	java/lang/StringBuilder
      //   2384: dup
      //   2385: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   2388: ldc_w 423
      //   2391: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2394: aload 9
      //   2396: invokevirtual 366	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
      //   2399: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2402: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2405: aload 9
      //   2407: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2410: goto -55 -> 2355
      //   2413: astore 7
      //   2415: aload 6
      //   2417: astore 5
      //   2419: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2422: ifeq +39 -> 2461
      //   2425: aload 6
      //   2427: astore 5
      //   2429: ldc 87
      //   2431: iconst_2
      //   2432: new 69	java/lang/StringBuilder
      //   2435: dup
      //   2436: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   2439: ldc_w 425
      //   2442: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2445: aload 7
      //   2447: invokevirtual 92	java/io/IOException:getMessage	()Ljava/lang/String;
      //   2450: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2453: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2456: aload 7
      //   2458: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2461: aload 6
      //   2463: astore 5
      //   2465: invokestatic 157	com/tencent/mobileqq/music/QQPlayerService:g	()Lcom/tencent/mobileqq/music/SongInfo;
      //   2468: astore 7
      //   2470: iconst_0
      //   2471: istore 4
      //   2473: aload 7
      //   2475: ifnull +126 -> 2601
      //   2478: aload 6
      //   2480: astore 5
      //   2482: aload 7
      //   2484: getfield 174	com/tencent/mobileqq/music/SongInfo:url	Ljava/lang/String;
      //   2487: astore 8
      //   2489: iload 4
      //   2491: istore_3
      //   2492: aload 6
      //   2494: astore 5
      //   2496: aload 8
      //   2498: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   2501: ifne +44 -> 2545
      //   2504: iload 4
      //   2506: istore_3
      //   2507: aload 6
      //   2509: astore 5
      //   2511: aload 8
      //   2513: ldc 182
      //   2515: invokevirtual 188	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   2518: ifeq +27 -> 2545
      //   2521: aload 6
      //   2523: astore 5
      //   2525: aload_0
      //   2526: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:url	Ljava/lang/String;
      //   2529: aload_0
      //   2530: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   2533: aload 7
      //   2535: getfield 174	com/tencent/mobileqq/music/SongInfo:url	Ljava/lang/String;
      //   2538: invokestatic 192	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;Ljava/lang/String;)Ljava/lang/String;
      //   2541: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2544: istore_3
      //   2545: aload 6
      //   2547: astore 5
      //   2549: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   2552: ifnull +49 -> 2601
      //   2555: aload 6
      //   2557: astore 5
      //   2559: aload_0
      //   2560: getfield 38	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:url	Ljava/lang/String;
      //   2563: aload 7
      //   2565: getfield 174	com/tencent/mobileqq/music/SongInfo:url	Ljava/lang/String;
      //   2568: invokevirtual 196	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2571: ifne +7 -> 2578
      //   2574: iload_3
      //   2575: ifeq +26 -> 2601
      //   2578: aload 6
      //   2580: astore 5
      //   2582: invokestatic 206	com/tencent/mobileqq/music/QQPlayerService:e	()Landroid/media/MediaPlayer;
      //   2585: invokevirtual 211	android/media/MediaPlayer:reset	()V
      //   2588: aload 6
      //   2590: astore 5
      //   2592: aload_0
      //   2593: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   2596: bipush 6
      //   2598: invokestatic 226	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
      //   2601: aload 6
      //   2603: astore 5
      //   2605: invokestatic 428	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
      //   2608: ifnull +52 -> 2660
      //   2611: aload 6
      //   2613: astore 5
      //   2615: invokestatic 428	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
      //   2618: arraylength
      //   2619: iconst_1
      //   2620: if_icmpne +40 -> 2660
      //   2623: aload 6
      //   2625: astore 5
      //   2627: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2630: ifeq +16 -> 2646
      //   2633: aload 6
      //   2635: astore 5
      //   2637: ldc 87
      //   2639: iconst_2
      //   2640: ldc_w 430
      //   2643: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2646: aload 6
      //   2648: astore 5
      //   2650: aload_0
      //   2651: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   2654: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
      //   2657: invokestatic 128	com/tencent/mobileqq/music/QQPlayerService:eG	(Landroid/content/Context;)V
      //   2660: aload_0
      //   2661: iconst_0
      //   2662: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   2665: aload 6
      //   2667: ifnull +8 -> 2675
      //   2670: aload 6
      //   2672: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   2675: aload_0
      //   2676: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2679: aload_0
      //   2680: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2683: if_icmpge -1631 -> 1052
      //   2686: aload_0
      //   2687: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2690: ifle -1638 -> 1052
      //   2693: aload_0
      //   2694: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   2697: aload_0
      //   2698: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2701: aload_0
      //   2702: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2705: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   2708: goto -1656 -> 1052
      //   2711: iconst_0
      //   2712: istore_1
      //   2713: aload 6
      //   2715: astore 5
      //   2717: aload_0
      //   2718: aload_0
      //   2719: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2722: iload_2
      //   2723: iadd
      //   2724: putfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2727: aload 6
      //   2729: astore 5
      //   2731: aload 6
      //   2733: aload 8
      //   2735: iconst_0
      //   2736: iload_2
      //   2737: invokevirtual 434	java/io/RandomAccessFile:write	([BII)V
      //   2740: goto -750 -> 1990
      //   2743: astore 7
      //   2745: aload 6
      //   2747: astore 5
      //   2749: aload_0
      //   2750: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   2753: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
      //   2756: invokestatic 128	com/tencent/mobileqq/music/QQPlayerService:eG	(Landroid/content/Context;)V
      //   2759: aload 6
      //   2761: astore 5
      //   2763: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2766: ifeq +39 -> 2805
      //   2769: aload 6
      //   2771: astore 5
      //   2773: ldc 87
      //   2775: iconst_2
      //   2776: new 69	java/lang/StringBuilder
      //   2779: dup
      //   2780: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   2783: ldc_w 436
      //   2786: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2789: aload 7
      //   2791: invokevirtual 437	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
      //   2794: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2797: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2800: aload 7
      //   2802: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2805: aload_0
      //   2806: iconst_0
      //   2807: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   2810: aload 6
      //   2812: ifnull +8 -> 2820
      //   2815: aload 6
      //   2817: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   2820: aload_0
      //   2821: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2824: aload_0
      //   2825: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2828: if_icmpge -1776 -> 1052
      //   2831: aload_0
      //   2832: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2835: ifle -1783 -> 1052
      //   2838: aload_0
      //   2839: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   2842: aload_0
      //   2843: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2846: aload_0
      //   2847: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2850: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   2853: goto -1801 -> 1052
      //   2856: aload 6
      //   2858: astore 5
      //   2860: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2863: ifeq +72 -> 2935
      //   2866: aload 6
      //   2868: astore 5
      //   2870: ldc 87
      //   2872: iconst_2
      //   2873: new 69	java/lang/StringBuilder
      //   2876: dup
      //   2877: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   2880: ldc_w 439
      //   2883: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2886: aload_0
      //   2887: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2890: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2893: ldc_w 441
      //   2896: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2899: iload_1
      //   2900: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2903: ldc_w 391
      //   2906: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2909: aload_0
      //   2910: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2913: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2916: ldc_w 389
      //   2919: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2922: aload_0
      //   2923: getfield 42	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djP	I
      //   2926: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2929: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2932: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2935: aload 7
      //   2937: ifnull +12 -> 2949
      //   2940: aload 6
      //   2942: astore 5
      //   2944: aload 7
      //   2946: invokevirtual 442	java/io/InputStream:close	()V
      //   2949: aload 6
      //   2951: astore 5
      //   2953: aload_0
      //   2954: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   2957: aload_0
      //   2958: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2961: if_icmpne +25 -> 2986
      //   2964: aload 6
      //   2966: astore 5
      //   2968: aload_0
      //   2969: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   2972: ifle +14 -> 2986
      //   2975: aload 6
      //   2977: astore 5
      //   2979: aload_0
      //   2980: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   2983: invokestatic 445	aqiv:UL	(Ljava/lang/String;)V
      //   2986: aload_0
      //   2987: iconst_0
      //   2988: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   2991: aload 6
      //   2993: ifnull +8 -> 3001
      //   2996: aload 6
      //   2998: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   3001: aload_0
      //   3002: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   3005: aload_0
      //   3006: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3009: if_icmpge -1957 -> 1052
      //   3012: aload_0
      //   3013: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3016: ifle -1964 -> 1052
      //   3019: aload_0
      //   3020: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   3023: aload_0
      //   3024: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   3027: aload_0
      //   3028: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3031: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   3034: goto -1982 -> 1052
      //   3037: astore 7
      //   3039: aconst_null
      //   3040: astore 6
      //   3042: aload 6
      //   3044: astore 5
      //   3046: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   3049: ifeq +39 -> 3088
      //   3052: aload 6
      //   3054: astore 5
      //   3056: ldc 87
      //   3058: iconst_2
      //   3059: new 69	java/lang/StringBuilder
      //   3062: dup
      //   3063: invokespecial 70	java/lang/StringBuilder:<init>	()V
      //   3066: ldc_w 447
      //   3069: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3072: aload 7
      //   3074: invokevirtual 448	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   3077: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3080: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3083: aload 7
      //   3085: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   3088: aload 6
      //   3090: astore 5
      //   3092: aload_0
      //   3093: getfield 25	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:this$0	Lcom/tencent/mobileqq/music/QQPlayerService;
      //   3096: invokevirtual 124	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
      //   3099: invokestatic 128	com/tencent/mobileqq/music/QQPlayerService:eG	(Landroid/content/Context;)V
      //   3102: aload_0
      //   3103: iconst_0
      //   3104: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   3107: aload 6
      //   3109: ifnull +8 -> 3117
      //   3112: aload 6
      //   3114: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   3117: aload_0
      //   3118: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   3121: aload_0
      //   3122: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3125: if_icmpge -2073 -> 1052
      //   3128: aload_0
      //   3129: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3132: ifle -2080 -> 1052
      //   3135: aload_0
      //   3136: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   3139: aload_0
      //   3140: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   3143: aload_0
      //   3144: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3147: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   3150: goto -2098 -> 1052
      //   3153: astore 6
      //   3155: aconst_null
      //   3156: astore 5
      //   3158: aload_0
      //   3159: iconst_0
      //   3160: putfield 132	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:cpq	Z
      //   3163: aload 5
      //   3165: ifnull +8 -> 3173
      //   3168: aload 5
      //   3170: invokevirtual 165	java/io/RandomAccessFile:close	()V
      //   3173: aload_0
      //   3174: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   3177: aload_0
      //   3178: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3181: if_icmpge +25 -> 3206
      //   3184: aload_0
      //   3185: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3188: ifle +18 -> 3206
      //   3191: aload_0
      //   3192: getfield 40	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileName	Ljava/lang/String;
      //   3195: aload_0
      //   3196: getfield 46	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:djQ	I
      //   3199: aload_0
      //   3200: getfield 44	com/tencent/mobileqq/music/QQPlayerService$DownloadThread:fileSize	I
      //   3203: invokestatic 171	aqiv:aM	(Ljava/lang/String;II)V
      //   3206: aload 6
      //   3208: athrow
      //   3209: astore 5
      //   3211: goto -3050 -> 161
      //   3214: astore 5
      //   3216: goto -1946 -> 1270
      //   3219: astore 5
      //   3221: goto -1482 -> 1739
      //   3224: astore 5
      //   3226: goto -1153 -> 2073
      //   3229: astore 5
      //   3231: goto -230 -> 3001
      //   3234: astore 5
      //   3236: goto -2217 -> 1019
      //   3239: astore 5
      //   3241: goto -1788 -> 1453
      //   3244: astore 5
      //   3246: goto -571 -> 2675
      //   3249: astore 5
      //   3251: goto -431 -> 2820
      //   3254: astore 5
      //   3256: goto -139 -> 3117
      //   3259: astore 5
      //   3261: goto -88 -> 3173
      //   3264: astore 6
      //   3266: goto -108 -> 3158
      //   3269: astore 6
      //   3271: goto -113 -> 3158
      //   3274: astore 7
      //   3276: goto -234 -> 3042
      //   3279: astore 7
      //   3281: aconst_null
      //   3282: astore 6
      //   3284: goto -539 -> 2745
      //   3287: astore 7
      //   3289: aconst_null
      //   3290: astore 6
      //   3292: goto -877 -> 2415
      //   3295: astore 7
      //   3297: aconst_null
      //   3298: astore 6
      //   3300: goto -1922 -> 1378
      //   3303: astore 6
      //   3305: goto -2349 -> 956
      //   3308: aload 7
      //   3310: astore 5
      //   3312: goto -2908 -> 404
      //   3315: aload 5
      //   3317: astore 7
      //   3319: goto -2104 -> 1215
      //   3322: iconst_0
      //   3323: istore_3
      //   3324: goto -3071 -> 253
      //   3327: iconst_0
      //   3328: istore_2
      //   3329: iconst_0
      //   3330: istore_1
      //   3331: aconst_null
      //   3332: astore 5
      //   3334: goto -2930 -> 404
      //   3337: aload 7
      //   3339: astore 5
      //   3341: goto -2937 -> 404
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	3344	0	this	DownloadThread
      //   408	2923	1	i	int
      //   404	2925	2	j	int
      //   252	3072	3	bool1	boolean
      //   2471	34	4	bool2	boolean
      //   3	3166	5	localObject1	Object
      //   3209	1	5	localIOException1	IOException
      //   3214	1	5	localIOException2	IOException
      //   3219	1	5	localIOException3	IOException
      //   3224	1	5	localIOException4	IOException
      //   3229	1	5	localIOException5	IOException
      //   3234	1	5	localIOException6	IOException
      //   3239	1	5	localIOException7	IOException
      //   3244	1	5	localIOException8	IOException
      //   3249	1	5	localIOException9	IOException
      //   3254	1	5	localIOException10	IOException
      //   3259	1	5	localIOException11	IOException
      //   3310	30	5	localObject2	Object
      //   78	3035	6	localObject3	Object
      //   3153	54	6	localObject4	Object
      //   3264	1	6	localObject5	Object
      //   3269	1	6	localObject6	Object
      //   3282	17	6	localObject7	Object
      //   3303	1	6	localFileNotFoundException1	java.io.FileNotFoundException
      //   117	785	7	localObject8	Object
      //   946	373	7	localFileNotFoundException2	java.io.FileNotFoundException
      //   1376	166	7	localMalformedURLException1	java.net.MalformedURLException
      //   1871	440	7	localInputStream	java.io.InputStream
      //   2413	44	7	localIOException12	IOException
      //   2468	96	7	localSongInfo	SongInfo
      //   2743	202	7	localIllegalStateException1	IllegalStateException
      //   3037	47	7	localException1	Exception
      //   3274	1	7	localException2	Exception
      //   3279	1	7	localIllegalStateException2	IllegalStateException
      //   3287	1	7	localIOException13	IOException
      //   3295	14	7	localMalformedURLException2	java.net.MalformedURLException
      //   3317	21	7	localObject9	Object
      //   108	2626	8	localObject10	Object
      //   93	2030	9	localObject11	Object
      //   2362	44	9	localInterruptedException1	java.lang.InterruptedException
      //   54	2131	10	localFile	File
      //   204	603	11	str	String
      //   1116	44	11	localInterruptedException2	java.lang.InterruptedException
      //   1325	44	11	localInterruptedException3	java.lang.InterruptedException
      //   576	143	12	localObject12	Object
      // Exception table:
      //   from	to	target	type
      //   84	95	946	java/io/FileNotFoundException
      //   99	110	946	java/io/FileNotFoundException
      //   114	119	946	java/io/FileNotFoundException
      //   128	134	946	java/io/FileNotFoundException
      //   138	146	946	java/io/FileNotFoundException
      //   199	206	946	java/io/FileNotFoundException
      //   210	218	946	java/io/FileNotFoundException
      //   222	232	946	java/io/FileNotFoundException
      //   236	253	946	java/io/FileNotFoundException
      //   257	272	946	java/io/FileNotFoundException
      //   280	287	946	java/io/FileNotFoundException
      //   291	313	946	java/io/FileNotFoundException
      //   317	323	946	java/io/FileNotFoundException
      //   327	335	946	java/io/FileNotFoundException
      //   339	345	946	java/io/FileNotFoundException
      //   349	360	946	java/io/FileNotFoundException
      //   364	370	946	java/io/FileNotFoundException
      //   374	380	946	java/io/FileNotFoundException
      //   384	392	946	java/io/FileNotFoundException
      //   396	401	946	java/io/FileNotFoundException
      //   417	427	946	java/io/FileNotFoundException
      //   431	437	946	java/io/FileNotFoundException
      //   441	450	946	java/io/FileNotFoundException
      //   454	461	946	java/io/FileNotFoundException
      //   465	476	946	java/io/FileNotFoundException
      //   480	521	946	java/io/FileNotFoundException
      //   525	532	946	java/io/FileNotFoundException
      //   536	544	946	java/io/FileNotFoundException
      //   548	559	946	java/io/FileNotFoundException
      //   563	578	946	java/io/FileNotFoundException
      //   582	593	946	java/io/FileNotFoundException
      //   597	622	946	java/io/FileNotFoundException
      //   631	639	946	java/io/FileNotFoundException
      //   643	659	946	java/io/FileNotFoundException
      //   663	672	946	java/io/FileNotFoundException
      //   676	701	946	java/io/FileNotFoundException
      //   705	745	946	java/io/FileNotFoundException
      //   749	755	946	java/io/FileNotFoundException
      //   759	797	946	java/io/FileNotFoundException
      //   801	811	946	java/io/FileNotFoundException
      //   815	820	946	java/io/FileNotFoundException
      //   824	835	946	java/io/FileNotFoundException
      //   843	860	946	java/io/FileNotFoundException
      //   864	870	946	java/io/FileNotFoundException
      //   874	901	946	java/io/FileNotFoundException
      //   912	918	946	java/io/FileNotFoundException
      //   922	931	946	java/io/FileNotFoundException
      //   935	943	946	java/io/FileNotFoundException
      //   1087	1095	946	java/io/FileNotFoundException
      //   1103	1109	946	java/io/FileNotFoundException
      //   1122	1128	946	java/io/FileNotFoundException
      //   1132	1164	946	java/io/FileNotFoundException
      //   1171	1201	946	java/io/FileNotFoundException
      //   1205	1211	946	java/io/FileNotFoundException
      //   1223	1229	946	java/io/FileNotFoundException
      //   1233	1242	946	java/io/FileNotFoundException
      //   1246	1255	946	java/io/FileNotFoundException
      //   1308	1314	946	java/io/FileNotFoundException
      //   1331	1337	946	java/io/FileNotFoundException
      //   1341	1373	946	java/io/FileNotFoundException
      //   1495	1502	946	java/io/FileNotFoundException
      //   1506	1513	946	java/io/FileNotFoundException
      //   1517	1522	946	java/io/FileNotFoundException
      //   1532	1539	946	java/io/FileNotFoundException
      //   1549	1557	946	java/io/FileNotFoundException
      //   1561	1567	946	java/io/FileNotFoundException
      //   1571	1610	946	java/io/FileNotFoundException
      //   1614	1619	946	java/io/FileNotFoundException
      //   1623	1628	946	java/io/FileNotFoundException
      //   1632	1642	946	java/io/FileNotFoundException
      //   1646	1652	946	java/io/FileNotFoundException
      //   1656	1665	946	java/io/FileNotFoundException
      //   1669	1674	946	java/io/FileNotFoundException
      //   1678	1684	946	java/io/FileNotFoundException
      //   1692	1698	946	java/io/FileNotFoundException
      //   1702	1711	946	java/io/FileNotFoundException
      //   1715	1724	946	java/io/FileNotFoundException
      //   1777	1782	946	java/io/FileNotFoundException
      //   1786	1793	946	java/io/FileNotFoundException
      //   1797	1803	946	java/io/FileNotFoundException
      //   1807	1862	946	java/io/FileNotFoundException
      //   1866	1873	946	java/io/FileNotFoundException
      //   1877	1884	946	java/io/FileNotFoundException
      //   1888	1898	946	java/io/FileNotFoundException
      //   1902	1909	946	java/io/FileNotFoundException
      //   1913	1928	946	java/io/FileNotFoundException
      //   1936	1942	946	java/io/FileNotFoundException
      //   1946	1988	946	java/io/FileNotFoundException
      //   1994	2001	946	java/io/FileNotFoundException
      //   2005	2016	946	java/io/FileNotFoundException
      //   2026	2031	946	java/io/FileNotFoundException
      //   2040	2046	946	java/io/FileNotFoundException
      //   2050	2058	946	java/io/FileNotFoundException
      //   2111	2118	946	java/io/FileNotFoundException
      //   2122	2137	946	java/io/FileNotFoundException
      //   2145	2167	946	java/io/FileNotFoundException
      //   2171	2177	946	java/io/FileNotFoundException
      //   2181	2192	946	java/io/FileNotFoundException
      //   2196	2202	946	java/io/FileNotFoundException
      //   2206	2212	946	java/io/FileNotFoundException
      //   2216	2261	946	java/io/FileNotFoundException
      //   2265	2275	946	java/io/FileNotFoundException
      //   2279	2285	946	java/io/FileNotFoundException
      //   2289	2297	946	java/io/FileNotFoundException
      //   2301	2306	946	java/io/FileNotFoundException
      //   2310	2318	946	java/io/FileNotFoundException
      //   2326	2332	946	java/io/FileNotFoundException
      //   2336	2345	946	java/io/FileNotFoundException
      //   2349	2355	946	java/io/FileNotFoundException
      //   2368	2374	946	java/io/FileNotFoundException
      //   2378	2410	946	java/io/FileNotFoundException
      //   2717	2727	946	java/io/FileNotFoundException
      //   2731	2740	946	java/io/FileNotFoundException
      //   2860	2866	946	java/io/FileNotFoundException
      //   2870	2935	946	java/io/FileNotFoundException
      //   2944	2949	946	java/io/FileNotFoundException
      //   2953	2964	946	java/io/FileNotFoundException
      //   2968	2975	946	java/io/FileNotFoundException
      //   2979	2986	946	java/io/FileNotFoundException
      //   1103	1109	1116	java/lang/InterruptedException
      //   1308	1314	1325	java/lang/InterruptedException
      //   84	95	1376	java/net/MalformedURLException
      //   99	110	1376	java/net/MalformedURLException
      //   114	119	1376	java/net/MalformedURLException
      //   128	134	1376	java/net/MalformedURLException
      //   138	146	1376	java/net/MalformedURLException
      //   199	206	1376	java/net/MalformedURLException
      //   210	218	1376	java/net/MalformedURLException
      //   222	232	1376	java/net/MalformedURLException
      //   236	253	1376	java/net/MalformedURLException
      //   257	272	1376	java/net/MalformedURLException
      //   280	287	1376	java/net/MalformedURLException
      //   291	313	1376	java/net/MalformedURLException
      //   317	323	1376	java/net/MalformedURLException
      //   327	335	1376	java/net/MalformedURLException
      //   339	345	1376	java/net/MalformedURLException
      //   349	360	1376	java/net/MalformedURLException
      //   364	370	1376	java/net/MalformedURLException
      //   374	380	1376	java/net/MalformedURLException
      //   384	392	1376	java/net/MalformedURLException
      //   396	401	1376	java/net/MalformedURLException
      //   417	427	1376	java/net/MalformedURLException
      //   431	437	1376	java/net/MalformedURLException
      //   441	450	1376	java/net/MalformedURLException
      //   454	461	1376	java/net/MalformedURLException
      //   465	476	1376	java/net/MalformedURLException
      //   480	521	1376	java/net/MalformedURLException
      //   525	532	1376	java/net/MalformedURLException
      //   536	544	1376	java/net/MalformedURLException
      //   548	559	1376	java/net/MalformedURLException
      //   563	578	1376	java/net/MalformedURLException
      //   582	593	1376	java/net/MalformedURLException
      //   597	622	1376	java/net/MalformedURLException
      //   631	639	1376	java/net/MalformedURLException
      //   643	659	1376	java/net/MalformedURLException
      //   663	672	1376	java/net/MalformedURLException
      //   676	701	1376	java/net/MalformedURLException
      //   705	745	1376	java/net/MalformedURLException
      //   749	755	1376	java/net/MalformedURLException
      //   759	797	1376	java/net/MalformedURLException
      //   801	811	1376	java/net/MalformedURLException
      //   815	820	1376	java/net/MalformedURLException
      //   824	835	1376	java/net/MalformedURLException
      //   843	860	1376	java/net/MalformedURLException
      //   864	870	1376	java/net/MalformedURLException
      //   874	901	1376	java/net/MalformedURLException
      //   912	918	1376	java/net/MalformedURLException
      //   922	931	1376	java/net/MalformedURLException
      //   935	943	1376	java/net/MalformedURLException
      //   1087	1095	1376	java/net/MalformedURLException
      //   1103	1109	1376	java/net/MalformedURLException
      //   1122	1128	1376	java/net/MalformedURLException
      //   1132	1164	1376	java/net/MalformedURLException
      //   1171	1201	1376	java/net/MalformedURLException
      //   1205	1211	1376	java/net/MalformedURLException
      //   1223	1229	1376	java/net/MalformedURLException
      //   1233	1242	1376	java/net/MalformedURLException
      //   1246	1255	1376	java/net/MalformedURLException
      //   1308	1314	1376	java/net/MalformedURLException
      //   1331	1337	1376	java/net/MalformedURLException
      //   1341	1373	1376	java/net/MalformedURLException
      //   1495	1502	1376	java/net/MalformedURLException
      //   1506	1513	1376	java/net/MalformedURLException
      //   1517	1522	1376	java/net/MalformedURLException
      //   1532	1539	1376	java/net/MalformedURLException
      //   1549	1557	1376	java/net/MalformedURLException
      //   1561	1567	1376	java/net/MalformedURLException
      //   1571	1610	1376	java/net/MalformedURLException
      //   1614	1619	1376	java/net/MalformedURLException
      //   1623	1628	1376	java/net/MalformedURLException
      //   1632	1642	1376	java/net/MalformedURLException
      //   1646	1652	1376	java/net/MalformedURLException
      //   1656	1665	1376	java/net/MalformedURLException
      //   1669	1674	1376	java/net/MalformedURLException
      //   1678	1684	1376	java/net/MalformedURLException
      //   1692	1698	1376	java/net/MalformedURLException
      //   1702	1711	1376	java/net/MalformedURLException
      //   1715	1724	1376	java/net/MalformedURLException
      //   1777	1782	1376	java/net/MalformedURLException
      //   1786	1793	1376	java/net/MalformedURLException
      //   1797	1803	1376	java/net/MalformedURLException
      //   1807	1862	1376	java/net/MalformedURLException
      //   1866	1873	1376	java/net/MalformedURLException
      //   1877	1884	1376	java/net/MalformedURLException
      //   1888	1898	1376	java/net/MalformedURLException
      //   1902	1909	1376	java/net/MalformedURLException
      //   1913	1928	1376	java/net/MalformedURLException
      //   1936	1942	1376	java/net/MalformedURLException
      //   1946	1988	1376	java/net/MalformedURLException
      //   1994	2001	1376	java/net/MalformedURLException
      //   2005	2016	1376	java/net/MalformedURLException
      //   2026	2031	1376	java/net/MalformedURLException
      //   2040	2046	1376	java/net/MalformedURLException
      //   2050	2058	1376	java/net/MalformedURLException
      //   2111	2118	1376	java/net/MalformedURLException
      //   2122	2137	1376	java/net/MalformedURLException
      //   2145	2167	1376	java/net/MalformedURLException
      //   2171	2177	1376	java/net/MalformedURLException
      //   2181	2192	1376	java/net/MalformedURLException
      //   2196	2202	1376	java/net/MalformedURLException
      //   2206	2212	1376	java/net/MalformedURLException
      //   2216	2261	1376	java/net/MalformedURLException
      //   2265	2275	1376	java/net/MalformedURLException
      //   2279	2285	1376	java/net/MalformedURLException
      //   2289	2297	1376	java/net/MalformedURLException
      //   2301	2306	1376	java/net/MalformedURLException
      //   2310	2318	1376	java/net/MalformedURLException
      //   2326	2332	1376	java/net/MalformedURLException
      //   2336	2345	1376	java/net/MalformedURLException
      //   2349	2355	1376	java/net/MalformedURLException
      //   2368	2374	1376	java/net/MalformedURLException
      //   2378	2410	1376	java/net/MalformedURLException
      //   2717	2727	1376	java/net/MalformedURLException
      //   2731	2740	1376	java/net/MalformedURLException
      //   2860	2866	1376	java/net/MalformedURLException
      //   2870	2935	1376	java/net/MalformedURLException
      //   2944	2949	1376	java/net/MalformedURLException
      //   2953	2964	1376	java/net/MalformedURLException
      //   2968	2975	1376	java/net/MalformedURLException
      //   2979	2986	1376	java/net/MalformedURLException
      //   2349	2355	2362	java/lang/InterruptedException
      //   84	95	2413	java/io/IOException
      //   99	110	2413	java/io/IOException
      //   114	119	2413	java/io/IOException
      //   128	134	2413	java/io/IOException
      //   138	146	2413	java/io/IOException
      //   199	206	2413	java/io/IOException
      //   210	218	2413	java/io/IOException
      //   222	232	2413	java/io/IOException
      //   236	253	2413	java/io/IOException
      //   257	272	2413	java/io/IOException
      //   280	287	2413	java/io/IOException
      //   291	313	2413	java/io/IOException
      //   317	323	2413	java/io/IOException
      //   327	335	2413	java/io/IOException
      //   339	345	2413	java/io/IOException
      //   349	360	2413	java/io/IOException
      //   364	370	2413	java/io/IOException
      //   374	380	2413	java/io/IOException
      //   384	392	2413	java/io/IOException
      //   396	401	2413	java/io/IOException
      //   417	427	2413	java/io/IOException
      //   431	437	2413	java/io/IOException
      //   441	450	2413	java/io/IOException
      //   454	461	2413	java/io/IOException
      //   465	476	2413	java/io/IOException
      //   480	521	2413	java/io/IOException
      //   525	532	2413	java/io/IOException
      //   536	544	2413	java/io/IOException
      //   548	559	2413	java/io/IOException
      //   563	578	2413	java/io/IOException
      //   582	593	2413	java/io/IOException
      //   597	622	2413	java/io/IOException
      //   631	639	2413	java/io/IOException
      //   643	659	2413	java/io/IOException
      //   663	672	2413	java/io/IOException
      //   676	701	2413	java/io/IOException
      //   705	745	2413	java/io/IOException
      //   749	755	2413	java/io/IOException
      //   759	797	2413	java/io/IOException
      //   801	811	2413	java/io/IOException
      //   815	820	2413	java/io/IOException
      //   824	835	2413	java/io/IOException
      //   843	860	2413	java/io/IOException
      //   864	870	2413	java/io/IOException
      //   874	901	2413	java/io/IOException
      //   912	918	2413	java/io/IOException
      //   922	931	2413	java/io/IOException
      //   935	943	2413	java/io/IOException
      //   1087	1095	2413	java/io/IOException
      //   1103	1109	2413	java/io/IOException
      //   1122	1128	2413	java/io/IOException
      //   1132	1164	2413	java/io/IOException
      //   1171	1201	2413	java/io/IOException
      //   1205	1211	2413	java/io/IOException
      //   1223	1229	2413	java/io/IOException
      //   1233	1242	2413	java/io/IOException
      //   1246	1255	2413	java/io/IOException
      //   1308	1314	2413	java/io/IOException
      //   1331	1337	2413	java/io/IOException
      //   1341	1373	2413	java/io/IOException
      //   1495	1502	2413	java/io/IOException
      //   1506	1513	2413	java/io/IOException
      //   1517	1522	2413	java/io/IOException
      //   1532	1539	2413	java/io/IOException
      //   1549	1557	2413	java/io/IOException
      //   1561	1567	2413	java/io/IOException
      //   1571	1610	2413	java/io/IOException
      //   1614	1619	2413	java/io/IOException
      //   1623	1628	2413	java/io/IOException
      //   1632	1642	2413	java/io/IOException
      //   1646	1652	2413	java/io/IOException
      //   1656	1665	2413	java/io/IOException
      //   1669	1674	2413	java/io/IOException
      //   1678	1684	2413	java/io/IOException
      //   1692	1698	2413	java/io/IOException
      //   1702	1711	2413	java/io/IOException
      //   1715	1724	2413	java/io/IOException
      //   1777	1782	2413	java/io/IOException
      //   1786	1793	2413	java/io/IOException
      //   1797	1803	2413	java/io/IOException
      //   1807	1862	2413	java/io/IOException
      //   1866	1873	2413	java/io/IOException
      //   1877	1884	2413	java/io/IOException
      //   1888	1898	2413	java/io/IOException
      //   1902	1909	2413	java/io/IOException
      //   1913	1928	2413	java/io/IOException
      //   1936	1942	2413	java/io/IOException
      //   1946	1988	2413	java/io/IOException
      //   1994	2001	2413	java/io/IOException
      //   2005	2016	2413	java/io/IOException
      //   2026	2031	2413	java/io/IOException
      //   2040	2046	2413	java/io/IOException
      //   2050	2058	2413	java/io/IOException
      //   2111	2118	2413	java/io/IOException
      //   2122	2137	2413	java/io/IOException
      //   2145	2167	2413	java/io/IOException
      //   2171	2177	2413	java/io/IOException
      //   2181	2192	2413	java/io/IOException
      //   2196	2202	2413	java/io/IOException
      //   2206	2212	2413	java/io/IOException
      //   2216	2261	2413	java/io/IOException
      //   2265	2275	2413	java/io/IOException
      //   2279	2285	2413	java/io/IOException
      //   2289	2297	2413	java/io/IOException
      //   2301	2306	2413	java/io/IOException
      //   2310	2318	2413	java/io/IOException
      //   2326	2332	2413	java/io/IOException
      //   2336	2345	2413	java/io/IOException
      //   2349	2355	2413	java/io/IOException
      //   2368	2374	2413	java/io/IOException
      //   2378	2410	2413	java/io/IOException
      //   2717	2727	2413	java/io/IOException
      //   2731	2740	2413	java/io/IOException
      //   2860	2866	2413	java/io/IOException
      //   2870	2935	2413	java/io/IOException
      //   2944	2949	2413	java/io/IOException
      //   2953	2964	2413	java/io/IOException
      //   2968	2975	2413	java/io/IOException
      //   2979	2986	2413	java/io/IOException
      //   84	95	2743	java/lang/IllegalStateException
      //   99	110	2743	java/lang/IllegalStateException
      //   114	119	2743	java/lang/IllegalStateException
      //   128	134	2743	java/lang/IllegalStateException
      //   138	146	2743	java/lang/IllegalStateException
      //   199	206	2743	java/lang/IllegalStateException
      //   210	218	2743	java/lang/IllegalStateException
      //   222	232	2743	java/lang/IllegalStateException
      //   236	253	2743	java/lang/IllegalStateException
      //   257	272	2743	java/lang/IllegalStateException
      //   280	287	2743	java/lang/IllegalStateException
      //   291	313	2743	java/lang/IllegalStateException
      //   317	323	2743	java/lang/IllegalStateException
      //   327	335	2743	java/lang/IllegalStateException
      //   339	345	2743	java/lang/IllegalStateException
      //   349	360	2743	java/lang/IllegalStateException
      //   364	370	2743	java/lang/IllegalStateException
      //   374	380	2743	java/lang/IllegalStateException
      //   384	392	2743	java/lang/IllegalStateException
      //   396	401	2743	java/lang/IllegalStateException
      //   417	427	2743	java/lang/IllegalStateException
      //   431	437	2743	java/lang/IllegalStateException
      //   441	450	2743	java/lang/IllegalStateException
      //   454	461	2743	java/lang/IllegalStateException
      //   465	476	2743	java/lang/IllegalStateException
      //   480	521	2743	java/lang/IllegalStateException
      //   525	532	2743	java/lang/IllegalStateException
      //   536	544	2743	java/lang/IllegalStateException
      //   548	559	2743	java/lang/IllegalStateException
      //   563	578	2743	java/lang/IllegalStateException
      //   582	593	2743	java/lang/IllegalStateException
      //   597	622	2743	java/lang/IllegalStateException
      //   631	639	2743	java/lang/IllegalStateException
      //   643	659	2743	java/lang/IllegalStateException
      //   663	672	2743	java/lang/IllegalStateException
      //   676	701	2743	java/lang/IllegalStateException
      //   705	745	2743	java/lang/IllegalStateException
      //   749	755	2743	java/lang/IllegalStateException
      //   759	797	2743	java/lang/IllegalStateException
      //   801	811	2743	java/lang/IllegalStateException
      //   815	820	2743	java/lang/IllegalStateException
      //   824	835	2743	java/lang/IllegalStateException
      //   843	860	2743	java/lang/IllegalStateException
      //   864	870	2743	java/lang/IllegalStateException
      //   874	901	2743	java/lang/IllegalStateException
      //   912	918	2743	java/lang/IllegalStateException
      //   922	931	2743	java/lang/IllegalStateException
      //   935	943	2743	java/lang/IllegalStateException
      //   1087	1095	2743	java/lang/IllegalStateException
      //   1103	1109	2743	java/lang/IllegalStateException
      //   1122	1128	2743	java/lang/IllegalStateException
      //   1132	1164	2743	java/lang/IllegalStateException
      //   1171	1201	2743	java/lang/IllegalStateException
      //   1205	1211	2743	java/lang/IllegalStateException
      //   1223	1229	2743	java/lang/IllegalStateException
      //   1233	1242	2743	java/lang/IllegalStateException
      //   1246	1255	2743	java/lang/IllegalStateException
      //   1308	1314	2743	java/lang/IllegalStateException
      //   1331	1337	2743	java/lang/IllegalStateException
      //   1341	1373	2743	java/lang/IllegalStateException
      //   1495	1502	2743	java/lang/IllegalStateException
      //   1506	1513	2743	java/lang/IllegalStateException
      //   1517	1522	2743	java/lang/IllegalStateException
      //   1532	1539	2743	java/lang/IllegalStateException
      //   1549	1557	2743	java/lang/IllegalStateException
      //   1561	1567	2743	java/lang/IllegalStateException
      //   1571	1610	2743	java/lang/IllegalStateException
      //   1614	1619	2743	java/lang/IllegalStateException
      //   1623	1628	2743	java/lang/IllegalStateException
      //   1632	1642	2743	java/lang/IllegalStateException
      //   1646	1652	2743	java/lang/IllegalStateException
      //   1656	1665	2743	java/lang/IllegalStateException
      //   1669	1674	2743	java/lang/IllegalStateException
      //   1678	1684	2743	java/lang/IllegalStateException
      //   1692	1698	2743	java/lang/IllegalStateException
      //   1702	1711	2743	java/lang/IllegalStateException
      //   1715	1724	2743	java/lang/IllegalStateException
      //   1777	1782	2743	java/lang/IllegalStateException
      //   1786	1793	2743	java/lang/IllegalStateException
      //   1797	1803	2743	java/lang/IllegalStateException
      //   1807	1862	2743	java/lang/IllegalStateException
      //   1866	1873	2743	java/lang/IllegalStateException
      //   1877	1884	2743	java/lang/IllegalStateException
      //   1888	1898	2743	java/lang/IllegalStateException
      //   1902	1909	2743	java/lang/IllegalStateException
      //   1913	1928	2743	java/lang/IllegalStateException
      //   1936	1942	2743	java/lang/IllegalStateException
      //   1946	1988	2743	java/lang/IllegalStateException
      //   1994	2001	2743	java/lang/IllegalStateException
      //   2005	2016	2743	java/lang/IllegalStateException
      //   2026	2031	2743	java/lang/IllegalStateException
      //   2040	2046	2743	java/lang/IllegalStateException
      //   2050	2058	2743	java/lang/IllegalStateException
      //   2111	2118	2743	java/lang/IllegalStateException
      //   2122	2137	2743	java/lang/IllegalStateException
      //   2145	2167	2743	java/lang/IllegalStateException
      //   2171	2177	2743	java/lang/IllegalStateException
      //   2181	2192	2743	java/lang/IllegalStateException
      //   2196	2202	2743	java/lang/IllegalStateException
      //   2206	2212	2743	java/lang/IllegalStateException
      //   2216	2261	2743	java/lang/IllegalStateException
      //   2265	2275	2743	java/lang/IllegalStateException
      //   2279	2285	2743	java/lang/IllegalStateException
      //   2289	2297	2743	java/lang/IllegalStateException
      //   2301	2306	2743	java/lang/IllegalStateException
      //   2310	2318	2743	java/lang/IllegalStateException
      //   2326	2332	2743	java/lang/IllegalStateException
      //   2336	2345	2743	java/lang/IllegalStateException
      //   2349	2355	2743	java/lang/IllegalStateException
      //   2368	2374	2743	java/lang/IllegalStateException
      //   2378	2410	2743	java/lang/IllegalStateException
      //   2717	2727	2743	java/lang/IllegalStateException
      //   2731	2740	2743	java/lang/IllegalStateException
      //   2860	2866	2743	java/lang/IllegalStateException
      //   2870	2935	2743	java/lang/IllegalStateException
      //   2944	2949	2743	java/lang/IllegalStateException
      //   2953	2964	2743	java/lang/IllegalStateException
      //   2968	2975	2743	java/lang/IllegalStateException
      //   2979	2986	2743	java/lang/IllegalStateException
      //   64	80	3037	java/lang/Exception
      //   64	80	3153	finally
      //   156	161	3209	java/io/IOException
      //   1265	1270	3214	java/io/IOException
      //   1734	1739	3219	java/io/IOException
      //   2068	2073	3224	java/io/IOException
      //   2996	3001	3229	java/io/IOException
      //   1014	1019	3234	java/io/IOException
      //   1448	1453	3239	java/io/IOException
      //   2670	2675	3244	java/io/IOException
      //   2815	2820	3249	java/io/IOException
      //   3112	3117	3254	java/io/IOException
      //   3168	3173	3259	java/io/IOException
      //   84	95	3264	finally
      //   99	110	3264	finally
      //   114	119	3264	finally
      //   128	134	3264	finally
      //   138	146	3264	finally
      //   199	206	3264	finally
      //   210	218	3264	finally
      //   222	232	3264	finally
      //   236	253	3264	finally
      //   257	272	3264	finally
      //   280	287	3264	finally
      //   291	313	3264	finally
      //   317	323	3264	finally
      //   327	335	3264	finally
      //   339	345	3264	finally
      //   349	360	3264	finally
      //   364	370	3264	finally
      //   374	380	3264	finally
      //   384	392	3264	finally
      //   396	401	3264	finally
      //   417	427	3264	finally
      //   431	437	3264	finally
      //   441	450	3264	finally
      //   454	461	3264	finally
      //   465	476	3264	finally
      //   480	521	3264	finally
      //   525	532	3264	finally
      //   536	544	3264	finally
      //   548	559	3264	finally
      //   563	578	3264	finally
      //   582	593	3264	finally
      //   597	622	3264	finally
      //   631	639	3264	finally
      //   643	659	3264	finally
      //   663	672	3264	finally
      //   676	701	3264	finally
      //   705	745	3264	finally
      //   749	755	3264	finally
      //   759	797	3264	finally
      //   801	811	3264	finally
      //   815	820	3264	finally
      //   824	835	3264	finally
      //   843	860	3264	finally
      //   864	870	3264	finally
      //   874	901	3264	finally
      //   912	918	3264	finally
      //   922	931	3264	finally
      //   935	943	3264	finally
      //   1087	1095	3264	finally
      //   1103	1109	3264	finally
      //   1122	1128	3264	finally
      //   1132	1164	3264	finally
      //   1171	1201	3264	finally
      //   1205	1211	3264	finally
      //   1223	1229	3264	finally
      //   1233	1242	3264	finally
      //   1246	1255	3264	finally
      //   1308	1314	3264	finally
      //   1331	1337	3264	finally
      //   1341	1373	3264	finally
      //   1382	1392	3264	finally
      //   1396	1402	3264	finally
      //   1406	1438	3264	finally
      //   1495	1502	3264	finally
      //   1506	1513	3264	finally
      //   1517	1522	3264	finally
      //   1532	1539	3264	finally
      //   1549	1557	3264	finally
      //   1561	1567	3264	finally
      //   1571	1610	3264	finally
      //   1614	1619	3264	finally
      //   1623	1628	3264	finally
      //   1632	1642	3264	finally
      //   1646	1652	3264	finally
      //   1656	1665	3264	finally
      //   1669	1674	3264	finally
      //   1678	1684	3264	finally
      //   1692	1698	3264	finally
      //   1702	1711	3264	finally
      //   1715	1724	3264	finally
      //   1777	1782	3264	finally
      //   1786	1793	3264	finally
      //   1797	1803	3264	finally
      //   1807	1862	3264	finally
      //   1866	1873	3264	finally
      //   1877	1884	3264	finally
      //   1888	1898	3264	finally
      //   1902	1909	3264	finally
      //   1913	1928	3264	finally
      //   1936	1942	3264	finally
      //   1946	1988	3264	finally
      //   1994	2001	3264	finally
      //   2005	2016	3264	finally
      //   2026	2031	3264	finally
      //   2040	2046	3264	finally
      //   2050	2058	3264	finally
      //   2111	2118	3264	finally
      //   2122	2137	3264	finally
      //   2145	2167	3264	finally
      //   2171	2177	3264	finally
      //   2181	2192	3264	finally
      //   2196	2202	3264	finally
      //   2206	2212	3264	finally
      //   2216	2261	3264	finally
      //   2265	2275	3264	finally
      //   2279	2285	3264	finally
      //   2289	2297	3264	finally
      //   2301	2306	3264	finally
      //   2310	2318	3264	finally
      //   2326	2332	3264	finally
      //   2336	2345	3264	finally
      //   2349	2355	3264	finally
      //   2368	2374	3264	finally
      //   2378	2410	3264	finally
      //   2419	2425	3264	finally
      //   2429	2461	3264	finally
      //   2465	2470	3264	finally
      //   2482	2489	3264	finally
      //   2496	2504	3264	finally
      //   2511	2521	3264	finally
      //   2525	2545	3264	finally
      //   2549	2555	3264	finally
      //   2559	2574	3264	finally
      //   2582	2588	3264	finally
      //   2592	2601	3264	finally
      //   2605	2611	3264	finally
      //   2615	2623	3264	finally
      //   2627	2633	3264	finally
      //   2637	2646	3264	finally
      //   2650	2660	3264	finally
      //   2717	2727	3264	finally
      //   2731	2740	3264	finally
      //   2749	2759	3264	finally
      //   2763	2769	3264	finally
      //   2773	2805	3264	finally
      //   2860	2866	3264	finally
      //   2870	2935	3264	finally
      //   2944	2949	3264	finally
      //   2953	2964	3264	finally
      //   2968	2975	3264	finally
      //   2979	2986	3264	finally
      //   3046	3052	3264	finally
      //   3056	3088	3264	finally
      //   3092	3102	3264	finally
      //   956	994	3269	finally
      //   994	1004	3269	finally
      //   84	95	3274	java/lang/Exception
      //   99	110	3274	java/lang/Exception
      //   114	119	3274	java/lang/Exception
      //   128	134	3274	java/lang/Exception
      //   138	146	3274	java/lang/Exception
      //   199	206	3274	java/lang/Exception
      //   210	218	3274	java/lang/Exception
      //   222	232	3274	java/lang/Exception
      //   236	253	3274	java/lang/Exception
      //   257	272	3274	java/lang/Exception
      //   280	287	3274	java/lang/Exception
      //   291	313	3274	java/lang/Exception
      //   317	323	3274	java/lang/Exception
      //   327	335	3274	java/lang/Exception
      //   339	345	3274	java/lang/Exception
      //   349	360	3274	java/lang/Exception
      //   364	370	3274	java/lang/Exception
      //   374	380	3274	java/lang/Exception
      //   384	392	3274	java/lang/Exception
      //   396	401	3274	java/lang/Exception
      //   417	427	3274	java/lang/Exception
      //   431	437	3274	java/lang/Exception
      //   441	450	3274	java/lang/Exception
      //   454	461	3274	java/lang/Exception
      //   465	476	3274	java/lang/Exception
      //   480	521	3274	java/lang/Exception
      //   525	532	3274	java/lang/Exception
      //   536	544	3274	java/lang/Exception
      //   548	559	3274	java/lang/Exception
      //   563	578	3274	java/lang/Exception
      //   582	593	3274	java/lang/Exception
      //   597	622	3274	java/lang/Exception
      //   631	639	3274	java/lang/Exception
      //   643	659	3274	java/lang/Exception
      //   663	672	3274	java/lang/Exception
      //   676	701	3274	java/lang/Exception
      //   705	745	3274	java/lang/Exception
      //   749	755	3274	java/lang/Exception
      //   759	797	3274	java/lang/Exception
      //   801	811	3274	java/lang/Exception
      //   815	820	3274	java/lang/Exception
      //   824	835	3274	java/lang/Exception
      //   843	860	3274	java/lang/Exception
      //   864	870	3274	java/lang/Exception
      //   874	901	3274	java/lang/Exception
      //   912	918	3274	java/lang/Exception
      //   922	931	3274	java/lang/Exception
      //   935	943	3274	java/lang/Exception
      //   1087	1095	3274	java/lang/Exception
      //   1103	1109	3274	java/lang/Exception
      //   1122	1128	3274	java/lang/Exception
      //   1132	1164	3274	java/lang/Exception
      //   1171	1201	3274	java/lang/Exception
      //   1205	1211	3274	java/lang/Exception
      //   1223	1229	3274	java/lang/Exception
      //   1233	1242	3274	java/lang/Exception
      //   1246	1255	3274	java/lang/Exception
      //   1308	1314	3274	java/lang/Exception
      //   1331	1337	3274	java/lang/Exception
      //   1341	1373	3274	java/lang/Exception
      //   1495	1502	3274	java/lang/Exception
      //   1506	1513	3274	java/lang/Exception
      //   1517	1522	3274	java/lang/Exception
      //   1532	1539	3274	java/lang/Exception
      //   1549	1557	3274	java/lang/Exception
      //   1561	1567	3274	java/lang/Exception
      //   1571	1610	3274	java/lang/Exception
      //   1614	1619	3274	java/lang/Exception
      //   1623	1628	3274	java/lang/Exception
      //   1632	1642	3274	java/lang/Exception
      //   1646	1652	3274	java/lang/Exception
      //   1656	1665	3274	java/lang/Exception
      //   1669	1674	3274	java/lang/Exception
      //   1678	1684	3274	java/lang/Exception
      //   1692	1698	3274	java/lang/Exception
      //   1702	1711	3274	java/lang/Exception
      //   1715	1724	3274	java/lang/Exception
      //   1777	1782	3274	java/lang/Exception
      //   1786	1793	3274	java/lang/Exception
      //   1797	1803	3274	java/lang/Exception
      //   1807	1862	3274	java/lang/Exception
      //   1866	1873	3274	java/lang/Exception
      //   1877	1884	3274	java/lang/Exception
      //   1888	1898	3274	java/lang/Exception
      //   1902	1909	3274	java/lang/Exception
      //   1913	1928	3274	java/lang/Exception
      //   1936	1942	3274	java/lang/Exception
      //   1946	1988	3274	java/lang/Exception
      //   1994	2001	3274	java/lang/Exception
      //   2005	2016	3274	java/lang/Exception
      //   2026	2031	3274	java/lang/Exception
      //   2040	2046	3274	java/lang/Exception
      //   2050	2058	3274	java/lang/Exception
      //   2111	2118	3274	java/lang/Exception
      //   2122	2137	3274	java/lang/Exception
      //   2145	2167	3274	java/lang/Exception
      //   2171	2177	3274	java/lang/Exception
      //   2181	2192	3274	java/lang/Exception
      //   2196	2202	3274	java/lang/Exception
      //   2206	2212	3274	java/lang/Exception
      //   2216	2261	3274	java/lang/Exception
      //   2265	2275	3274	java/lang/Exception
      //   2279	2285	3274	java/lang/Exception
      //   2289	2297	3274	java/lang/Exception
      //   2301	2306	3274	java/lang/Exception
      //   2310	2318	3274	java/lang/Exception
      //   2326	2332	3274	java/lang/Exception
      //   2336	2345	3274	java/lang/Exception
      //   2349	2355	3274	java/lang/Exception
      //   2368	2374	3274	java/lang/Exception
      //   2378	2410	3274	java/lang/Exception
      //   2717	2727	3274	java/lang/Exception
      //   2731	2740	3274	java/lang/Exception
      //   2860	2866	3274	java/lang/Exception
      //   2870	2935	3274	java/lang/Exception
      //   2944	2949	3274	java/lang/Exception
      //   2953	2964	3274	java/lang/Exception
      //   2968	2975	3274	java/lang/Exception
      //   2979	2986	3274	java/lang/Exception
      //   64	80	3279	java/lang/IllegalStateException
      //   64	80	3287	java/io/IOException
      //   64	80	3295	java/net/MalformedURLException
      //   64	80	3303	java/io/FileNotFoundException
    }
  }
  
  static class a
    implements INetInfoHandler
  {
    long by = 0L;
    
    private void HJ(int paramInt)
    {
      if (System.currentTimeMillis() - this.by < 500L) {
        return;
      }
      this.by = System.currentTimeMillis();
      QQPlayerService.eH(BaseApplicationImpl.getContext());
    }
    
    public void onNetMobile2None()
    {
      HJ(4);
    }
    
    public void onNetMobile2Wifi(String paramString)
    {
      HJ(3);
    }
    
    public void onNetNone2Mobile(String paramString)
    {
      HJ(1);
    }
    
    public void onNetNone2Wifi(String paramString)
    {
      HJ(2);
    }
    
    public void onNetWifi2Mobile(String paramString)
    {
      HJ(6);
    }
    
    public void onNetWifi2None()
    {
      HJ(5);
    }
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (QQPlayerService.c(QQPlayerService.this)) {
        if (QLog.isColorLevel()) {
          QLog.i("QQPlayerService", 2, "received broadcast after service destroy");
        }
      }
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "QQPlayerBroadcastReceiverReceiver onReceive,action:" + paramIntent.getAction());
        }
      } while ((!"com.tencent.mobileqq.intent.logout".equals(paramIntent.getAction())) && (!"qqplayer_exit_action".equals(paramIntent.getAction())));
      if ((paramIntent.getBooleanExtra("musicplayer.isDelFileOnDonwloadThreadOver", false)) && (QQPlayerService.this.a != null)) {
        QQPlayerService.this.a.cpp = true;
      }
      QQPlayerService.eG(QQPlayerService.this.getApplicationContext());
    }
  }
  
  public static abstract interface c
  {
    public abstract String getToken();
    
    public abstract void onPlaySongChanged(SongInfo paramSongInfo);
    
    public abstract void onPlayStateChanged(int paramInt);
  }
  
  static class d
  {
    SongInfo k;
    Looper looper;
    MediaPlayer player;
  }
  
  final class e
    extends Handler
  {
    public e(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        QQPlayerService.a(QQPlayerService.this, (Intent)paramMessage.obj);
      }
      for (;;)
      {
        return;
        try
        {
          BaseApplicationImpl.getContext().unregisterReceiver(QQPlayerService.a(QQPlayerService.this));
          paramMessage = (QQPlayerService.d)paramMessage.obj;
          if (paramMessage == null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.i("QQPlayerService", 2, "release player");
          }
          if (paramMessage.player != null)
          {
            paramMessage.player.release();
            if (QQPlayerService.e() == paramMessage.player) {
              QQPlayerService.c(null);
            }
          }
          if (paramMessage.looper != null) {
            paramMessage.looper.quit();
          }
          if (QQPlayerService.g() != paramMessage.k) {
            continue;
          }
          QQPlayerService.a(null);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQPlayerService", 2, "onDestroy unregisterReceiver exception ");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService
 * JD-Core Version:    0.7.0.1
 */