package com.tencent.mobileqq.listentogether.player;

import aipo;
import aipw;
import aipx;
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
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class QQMusicPlayService
  extends Service
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static volatile ISong jdField_b_of_type_ComTencentMobileqqListentogetherDataISong;
  private static boolean clr;
  private static boolean cls;
  private static boolean clt;
  private static volatile int deN = 0;
  private static volatile int deO;
  private static int deP;
  private static MediaPlayer g;
  private a jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a;
  private b jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$b;
  private c jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$c;
  private AudioManager.OnAudioFocusChangeListener jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener;
  private final LinkedHashSet<Messenger> jdField_b_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  private volatile boolean clp;
  private volatile boolean clq;
  private HandlerThread mHandlerThread;
  private Messenger mMessenger;
  
  public static int FH()
  {
    int i = -1;
    if ((g != null) && ((deN == 2) || (deN == 3))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        i = g.getCurrentPosition();
        return i;
      }
      catch (Exception localException)
      {
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, new Object[] { "getPlayPosition exception state=", aipo.bA(deN), localException.getStackTrace() });
        return -1;
      }
    }
    QLog.d("QQMusicPlay.QQMusicPlayService", 2, "getPlayPosition  " + -1);
    return -1;
  }
  
  /* Error */
  public static void LR(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 124	java/io/RandomAccessFile
    //   5: dup
    //   6: new 126	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: ldc 130
    //   16: invokespecial 133	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: astore_0
    //   22: aload_2
    //   23: invokevirtual 137	java/io/RandomAccessFile:readByte	()B
    //   26: istore_1
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: lconst_0
    //   31: invokevirtual 141	java/io/RandomAccessFile:seek	(J)V
    //   34: aload_2
    //   35: astore_0
    //   36: aload_2
    //   37: iload_1
    //   38: invokevirtual 145	java/io/RandomAccessFile:write	(I)V
    //   41: aload_2
    //   42: ifnull +7 -> 49
    //   45: aload_2
    //   46: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   49: return
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_2
    //   53: aload_2
    //   54: astore_0
    //   55: aload_3
    //   56: invokevirtual 151	java/io/IOException:printStackTrace	()V
    //   59: aload_2
    //   60: ifnull -11 -> 49
    //   63: aload_2
    //   64: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   67: return
    //   68: astore_0
    //   69: return
    //   70: astore_0
    //   71: aload_3
    //   72: astore_2
    //   73: aload_2
    //   74: ifnull +7 -> 81
    //   77: aload_2
    //   78: invokevirtual 148	java/io/RandomAccessFile:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: return
    //   85: astore_2
    //   86: goto -5 -> 81
    //   89: astore_3
    //   90: aload_0
    //   91: astore_2
    //   92: aload_3
    //   93: astore_0
    //   94: goto -21 -> 73
    //   97: astore_3
    //   98: goto -45 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   26	12	1	i	int
    //   19	59	2	localObject1	Object
    //   85	1	2	localIOException1	IOException
    //   91	1	2	str	String
    //   1	1	3	localObject2	Object
    //   50	22	3	localIOException2	IOException
    //   89	4	3	localObject3	Object
    //   97	1	3	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   2	20	50	java/io/IOException
    //   63	67	68	java/io/IOException
    //   2	20	70	finally
    //   45	49	83	java/io/IOException
    //   77	81	85	java/io/IOException
    //   22	27	89	finally
    //   29	34	89	finally
    //   36	41	89	finally
    //   55	59	89	finally
    //   22	27	97	java/io/IOException
    //   29	34	97	java/io/IOException
    //   36	41	97	java/io/IOException
  }
  
  public static void LS(String paramString)
  {
    if (isPlaying())
    {
      Intent localIntent = new Intent();
      localIntent.setAction("QQMusicPlay_exit_action");
      BaseApplicationImpl.getApplication().getApplicationContext().sendBroadcast(localIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("notifyExit by[%s]", new Object[] { paramString }));
      }
    }
  }
  
  private void Lp(boolean paramBoolean)
  {
    try
    {
      clr = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateNetStateNotify [%b]", new Object[] { Boolean.valueOf(paramBoolean) }));
      }
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashSet.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 3);
            Bundle localBundle = new Bundle();
            localBundle.putBoolean("key_net_state", paramBoolean);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateNetStateNotify sendToClient exception", localRemoteException);
        }
      }
    }
    finally {}
  }
  
  private void Qc(int paramInt)
  {
    if ((g != null) && ((deN == 2) || (deN == 3))) {}
    try
    {
      g.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      QLog.e("QQMusicPlay.QQMusicPlayService", 1, "seekTo", localIllegalStateException);
    }
  }
  
  public static ISong a()
  {
    return jdField_b_of_type_ComTencentMobileqqListentogetherDataISong;
  }
  
  private void a(Messenger paramMessenger)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashSet.iterator();
    while (localIterator.hasNext()) {
      if (!((Messenger)localIterator.next()).getBinder().isBinderAlive()) {
        localIterator.remove();
      }
    }
    this.jdField_b_of_type_JavaUtilLinkedHashSet.add(paramMessenger);
  }
  
  private boolean apt()
  {
    this.mHandlerThread = new HandlerThread("QQMusicPlayService");
    try
    {
      this.mHandlerThread.start();
      this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a = new a(this, this.mHandlerThread.getLooper());
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a != null) {
        break label75;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("QQMusicPlay.QQMusicPlayService", 1, "initThread exception, stop self ==>", localThrowable);
      stopSelf();
      return false;
    }
    finally
    {
      while (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a == null) {}
    }
    return true;
  }
  
  private void au(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashSet.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 15);
            Bundle localBundle = new Bundle();
            localBundle.putInt("key_position", paramInt1);
            localBundle.putInt("key_duration", paramInt2);
            localBundle.putString("key_id", paramString);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateProgressNotify sendToClient exception", localRemoteException);
        }
      }
    }
    finally {}
  }
  
  private void ch(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      cls = paramBoolean1;
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updateFocusStateNotify [%b_%b]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
      }
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashSet.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 4);
            Bundle localBundle = new Bundle();
            localBundle.putBoolean("key_focus_state", paramBoolean1);
            localBundle.putBoolean("key_focus_transient", paramBoolean2);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateFocusStateNotify sendToClient exception", localRemoteException);
        }
      }
    }
    finally {}
  }
  
  private void eW(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 8)) {
      try
      {
        throw new IllegalArgumentException("playState value " + paramInt + " is illegal.");
      }
      finally {}
    }
    deN = paramInt;
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("updatePlayStateNotify %s [state=%s]", new Object[] { paramString, aipo.bA(paramInt) }));
    }
    if ((deN == 2) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a.sendEmptyMessage(14);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashSet.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 2);
            Bundle localBundle = new Bundle();
            localBundle.putString("key_id", paramString);
            localBundle.putInt("key_play_state", paramInt);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updatePlayStateNotify sendToClient exception", localRemoteException);
        }
      }
    }
  }
  
  private void f(ISong paramISong)
  {
    int j = 1;
    ArrayList localArrayList = new ArrayList();
    String str = paramISong.wX();
    clt = false;
    deP = 0;
    boolean bool;
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()) && (new File(str).canRead()))
    {
      clt = true;
      LR(str);
      localArrayList.add(Uri.fromFile(new File(str)).toString());
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("realStartPlay urls=[%s]", new Object[] { Arrays.toString(localArrayList.toArray()) }));
      }
      if (!localArrayList.isEmpty()) {
        break;
      }
      return;
      if (!clr)
      {
        resetMediaPlayer();
        eW(paramISong.getId(), 6);
        bool = false;
      }
      else
      {
        if (paramISong.fo() != null) {
          localArrayList.addAll(paramISong.fo());
        }
        bool = false;
      }
    }
    int i = 0;
    if (i < localArrayList.size()) {}
    for (;;)
    {
      try
      {
        resetMediaPlayer();
        g.setDataSource((String)localArrayList.get(i));
        eW(paramISong.getId(), 1);
        g.prepare();
        i = j;
        g.start();
        if (i != 0) {
          eW(paramISong.getId(), 2);
        }
        aipw.br(bool, aqiw.getNetworkType(this));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalArgumentException => ", new Object[] { Integer.valueOf(i) }), localIllegalArgumentException);
        i += 1;
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] SecurityException => ", new Object[] { Integer.valueOf(i) }), localSecurityException);
        continue;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        localIllegalStateException.printStackTrace();
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IllegalStateException => ", new Object[] { Integer.valueOf(i) }), localIllegalStateException);
        continue;
      }
      catch (IOException localIOException)
      {
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] IOException => ", new Object[] { Integer.valueOf(i) }), localIOException);
        resetMediaPlayer();
        if (i != localArrayList.size() - 1) {
          continue;
        }
        eW(paramISong.getId(), 6);
        continue;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQMusicPlay.QQMusicPlayService", 1, String.format("realStartPlay [index=%d] Throwable => ", new Object[] { Integer.valueOf(i) }), localThrowable);
        resetMediaPlayer();
        if (i != localArrayList.size() - 1) {
          continue;
        }
        eW(paramISong.getId(), 6);
        continue;
      }
      i = 0;
    }
  }
  
  private void g(ISong paramISong)
  {
    try
    {
      deO = 0;
      jdField_b_of_type_ComTencentMobileqqListentogetherDataISong = paramISong;
      QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("updateSongNotify [id=%s]", new Object[] { paramISong.getId() }));
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashSet.iterator();
      while (localIterator.hasNext())
      {
        Messenger localMessenger = (Messenger)localIterator.next();
        try
        {
          if (localMessenger.getBinder().isBinderAlive())
          {
            Message localMessage = Message.obtain(null, 5);
            Bundle localBundle = new Bundle();
            localBundle.putParcelable("key_song", paramISong);
            localMessage.setData(localBundle);
            localMessenger.send(localMessage);
          }
        }
        catch (RemoteException localRemoteException)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 1, "updateSongNotify sendToClient exception", localRemoteException);
        }
      }
    }
    finally {}
  }
  
  public static int getDuration()
  {
    return deO;
  }
  
  public static int getPlayState()
  {
    return deN;
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
  
  public static boolean isPlaying()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicPlay.QQMusicPlayService", 2, "isPlaying : sPlayState " + aipo.bA(deN));
    }
    return (deN == 2) || (deN == 1);
  }
  
  private void resetMediaPlayer()
  {
    if (g != null) {}
    try
    {
      g.reset();
      return;
    }
    catch (Exception localException) {}
  }
  
  public static String wZ()
  {
    ISong localISong = jdField_b_of_type_ComTencentMobileqqListentogetherDataISong;
    if (localISong != null) {
      return localISong.getId();
    }
    return null;
  }
  
  public static String xa()
  {
    ISong localISong = jdField_b_of_type_ComTencentMobileqqListentogetherDataISong;
    if ((localISong != null) && ((deN == 1) || (deN == 2) || (deN == 3))) {
      return localISong.getId();
    }
    return null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onBind");
    return this.mMessenger.getBinder();
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramInt < 100)) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->onBufferingUpdate %d/100", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onCompletion");
    }
    eW(wZ(), 8);
    aipw.bs(clt, deP);
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->onCreate");
    }
    this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new aipx(this);
    if (apt()) {
      return;
    }
    this.mMessenger = new Messenger(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$c = new c(null);
    QQMusicPlayService.2 local2 = new QQMusicPlayService.2(this);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a.post(local2);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onDestroy");
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a != null)
    {
      Object localObject = new d(g, jdField_b_of_type_ComTencentMobileqqListentogetherDataISong);
      localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a.obtainMessage(12, localObject);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a.sendMessage((Message)localObject);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a = null;
    }
    deO = 0;
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$c);
      label92:
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$b != null) {}
      try
      {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$b);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label92;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.d("QQMusicPlay.QQMusicPlayService", 1, String.format("--->onError [%d %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (paramInt1 == 100)
    {
      if (g != null) {
        g.release();
      }
      initMediaPlayer();
    }
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    resetMediaPlayer();
    eW(wZ(), 5);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (g == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQMusicPlay.QQMusicPlayService", 2, "player is null while invoking method onPrepared");
      }
      stopSelf();
    }
    do
    {
      int i;
      do
      {
        return;
        deO = g.getDuration();
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, "--->onPrepared:sDuration " + deO);
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a != null) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a.sendEmptyMessage(14);
        }
        paramMediaPlayer = (AudioManager)getSystemService("audio");
        i = paramMediaPlayer.requestAudioFocus(this.jdField_b_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
        boolean bool = paramMediaPlayer.isMusicActive();
        if (QLog.isColorLevel()) {
          QLog.d("QQMusicPlay.QQMusicPlayService", 2, "--->onPrepared requestAudioFocus,result:" + i + " isMusicActive:" + bool);
        }
      } while (i == 1);
      eW(wZ(), 7);
    } while (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a == null);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a.sendEmptyMessage(11);
  }
  
  public void onRebind(Intent paramIntent)
  {
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onRebind");
    super.onRebind(paramIntent);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onStart startId=" + paramInt);
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      paramIntent = (Message)paramIntent.getParcelableExtra("key_message");
      if (paramIntent != null)
      {
        QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("--->onStartCommand startId=%d what=%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramIntent.what) }));
        if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a == null) || (this.mHandlerThread.isAlive())) {}
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a.getLooper().quit();
      label79:
      apt();
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherPlayerQQMusicPlayService$a.sendMessage(paramIntent);
      }
      return 2;
    }
    catch (Throwable localThrowable)
    {
      break label79;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->onUnbind");
    return super.onUnbind(paramIntent);
  }
  
  public static class a
    extends Handler
  {
    private final WeakReference<QQMusicPlayService> bs;
    
    a(QQMusicPlayService paramQQMusicPlayService, Looper paramLooper)
    {
      super();
      this.bs = new WeakReference(paramQQMusicPlayService);
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      int k = 0;
      Object localObject = (QQMusicPlayService)this.bs.get();
      if (localObject == null) {
        super.handleMessage(paramMessage);
      }
      label108:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                QQMusicPlayService.d locald;
                                do
                                {
                                  return;
                                  try
                                  {
                                    switch (paramMessage.what)
                                    {
                                    case 2: 
                                    case 3: 
                                    case 4: 
                                    case 5: 
                                      super.handleMessage(paramMessage);
                                      return;
                                    }
                                  }
                                  catch (Throwable paramMessage)
                                  {
                                    paramMessage.printStackTrace();
                                    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage exception==>", paramMessage);
                                    return;
                                  }
                                  locald = (QQMusicPlayService.d)paramMessage.obj;
                                } while (locald == null);
                                if (QQMusicPlayService.b() == null) {}
                                for (paramMessage = "null";; paramMessage = QQMusicPlayService.b().getId())
                                {
                                  QLog.i("QQMusicPlay.QQMusicPlayService", 1, String.format("--->handleMessage[MSG_FROM_SERVICE_RELEASE] [%s]", new Object[] { paramMessage }));
                                  QQMusicPlayService.a((QQMusicPlayService)localObject).clear();
                                  if (locald.player != null)
                                  {
                                    locald.player.release();
                                    if (QQMusicPlayService.c() == locald.player) {
                                      QQMusicPlayService.b(null);
                                    }
                                  }
                                  getLooper().quit();
                                  return;
                                }
                                if (QLog.isColorLevel()) {
                                  QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT]");
                                }
                                paramMessage = paramMessage.replyTo;
                              } while (paramMessage == null);
                              QQMusicPlayService.a((QQMusicPlayService)localObject, paramMessage);
                              localObject = Message.obtain(null, 0);
                              ((Message)localObject).setData(new Bundle());
                              try
                              {
                                paramMessage.send((Message)localObject);
                                return;
                              }
                              catch (RemoteException paramMessage) {}
                            } while (!QLog.isColorLevel());
                            QLog.i("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT] sendToClient excepiton", paramMessage);
                            return;
                            if (QQMusicPlayService.c() != null) {
                              break;
                            }
                          } while (!QLog.isColorLevel());
                          QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_START_PLAY], sPlayer is null");
                          return;
                          paramMessage = paramMessage.getData();
                          paramMessage.setClassLoader(ISong.class.getClassLoader());
                          paramMessage = (ISong)paramMessage.getParcelable("key_song");
                          if ((paramMessage != null) && (paramMessage.fo() != null) && (paramMessage.fo().size() != 0)) {
                            break;
                          }
                        } while (!QLog.isColorLevel());
                        QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] err url is null [%s]", new Object[] { paramMessage }));
                        return;
                        if (QLog.isColorLevel()) {
                          QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_START_PLAY] [%s]", new Object[] { paramMessage }));
                        }
                        if ((paramMessage.equals(QQMusicPlayService.b())) && ((QQMusicPlayService.access$700() == 2) || (QQMusicPlayService.access$700() == 1)))
                        {
                          int m = QQMusicPlayService.FH();
                          if (m < 0) {}
                          for (i = -1;; i = Math.abs(m - paramMessage.FJ()))
                          {
                            int j = k;
                            if (QQMusicPlayService.access$700() == 2) {
                              if (m >= 0)
                              {
                                j = k;
                                if (Math.abs(m - paramMessage.FJ()) <= 3000) {}
                              }
                              else
                              {
                                QQMusicPlayService.access$308();
                                QQMusicPlayService.a((QQMusicPlayService)localObject, paramMessage.FJ());
                                j = 1;
                              }
                            }
                            QLog.i("ListenTogether.Seek", 1, "player start play player seek: " + m + " music seek: " + paramMessage.FJ() + " currentTime: " + System.currentTimeMillis());
                            if (j == 0) {
                              break;
                            }
                            aipw.iy(i, aqiw.getNetworkType((Context)localObject));
                            return;
                          }
                        }
                        if (QQMusicPlayService.c().isPlaying())
                        {
                          if (QLog.isColorLevel()) {
                            QLog.i("QQMusicPlay.QQMusicPlayService", 2, "------------stopped-------------");
                          }
                          QQMusicPlayService.c().stop();
                          aipw.bs(QQMusicPlayService.access$200(), QQMusicPlayService.access$300());
                        }
                        QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.wZ(), 0);
                        QQMusicPlayService.a((QQMusicPlayService)localObject, false);
                        QQMusicPlayService.a((QQMusicPlayService)localObject, paramMessage);
                        QQMusicPlayService.b((QQMusicPlayService)localObject, paramMessage);
                      } while (paramMessage.FJ() <= 0);
                      QQMusicPlayService.a((QQMusicPlayService)localObject, paramMessage.FJ());
                      return;
                      if (QQMusicPlayService.c() != null) {
                        break;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY], sPlayer is null");
                    return;
                    QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage[MSG_FROM_CLIENT_PAUSE_PLAY]");
                  } while ((QQMusicPlayService.access$700() != 2) && ((QQMusicPlayService.access$700() != 1) || (QQMusicPlayService.c() == null)));
                  ((AudioManager)((QQMusicPlayService)localObject).getSystemService("audio")).abandonAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject));
                  if (QQMusicPlayService.c().isPlaying()) {
                    QQMusicPlayService.c().pause();
                  }
                  QQMusicPlayService.a((QQMusicPlayService)localObject, true);
                  QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.wZ(), 3);
                  return;
                  if (QQMusicPlayService.c() != null) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.e("QQMusicPlay.QQMusicPlayService", 2, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY], sPlayer is null");
                return;
                QLog.i("QQMusicPlay.QQMusicPlayService", 1, "--->handleMessage[MSG_FROM_CLIENT_RESUME_PLAY]");
                if ((QQMusicPlayService.access$700() != 3) || (QQMusicPlayService.c() == null)) {
                  break;
                }
                QQMusicPlayService.a((QQMusicPlayService)localObject, false);
                paramMessage = (AudioManager)((QQMusicPlayService)localObject).getSystemService("audio");
                int i = paramMessage.requestAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject), 3, 1);
                bool1 = paramMessage.isMusicActive();
                if (QLog.isColorLevel()) {
                  QLog.d("QQMusicPlay.QQMusicPlayService", 2, "resumePlay requestAudioFocus,result:" + i + " isMusicActive:" + bool1);
                }
                if (i == 1)
                {
                  QQMusicPlayService.c().start();
                  QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.wZ(), 2);
                  return;
                }
                QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.wZ(), 7);
              } while (QQMusicPlayService.a((QQMusicPlayService)localObject) == null);
              QQMusicPlayService.a((QQMusicPlayService)localObject).sendEmptyMessage(11);
              return;
              if (QQMusicPlayService.access$700() != 6) {
                break;
              }
            } while (!aqiw.isNetworkAvailable(((QQMusicPlayService)localObject).getApplicationContext()));
            if (QLog.isColorLevel()) {
              QLog.d("QQMusicPlay.QQMusicPlayService", 2, String.format("resume from network interrupt, start play %s", new Object[] { QQMusicPlayService.b() }));
            }
            QQMusicPlayService.a((QQMusicPlayService)localObject, false);
            QQMusicPlayService.b((QQMusicPlayService)localObject, QQMusicPlayService.b());
            return;
          } while (QQMusicPlayService.access$700() != 5);
          QQMusicPlayService.a((QQMusicPlayService)localObject, false);
          QQMusicPlayService.b((QQMusicPlayService)localObject, QQMusicPlayService.b());
          return;
          if (QQMusicPlayService.c() != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        if (paramMessage.what == 10) {
          bool1 = true;
        }
        QLog.e("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_STOP_PLAY=%b],sPlayer is null", new Object[] { Boolean.valueOf(bool1) }));
        return;
        bool1 = bool2;
        if (paramMessage.what == 10) {
          bool1 = true;
        }
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, String.format("--->handleMessage[MSG_FROM_CLIENT_STOP_PLAY=%b]", new Object[] { Boolean.valueOf(bool1) }));
        if ((QQMusicPlayService.c() != null) && (QQMusicPlayService.c().isPlaying()))
        {
          QQMusicPlayService.c().stop();
          aipw.bs(QQMusicPlayService.access$200(), QQMusicPlayService.access$300());
        }
        ((AudioManager)((QQMusicPlayService)localObject).getSystemService("audio")).abandonAudioFocus(QQMusicPlayService.a((QQMusicPlayService)localObject));
        QQMusicPlayService.a((QQMusicPlayService)localObject, true);
        QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.wZ(), 4);
        ((QQMusicPlayService)localObject).stopSelf();
        return;
        QQMusicPlayService.b((QQMusicPlayService)localObject, paramMessage.getData().getBoolean("key_mute", false));
        if (QLog.isColorLevel()) {
          QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_MUTE_PLAY] %b", new Object[] { Boolean.valueOf(QQMusicPlayService.a((QQMusicPlayService)localObject)) }));
        }
      } while (QQMusicPlayService.c() == null);
      if (QQMusicPlayService.a((QQMusicPlayService)localObject)) {}
      for (float f = 0.0F;; f = 1.0F)
      {
        QQMusicPlayService.c().setVolume(f, f);
        return;
        if (QQMusicPlayService.access$700() == 2)
        {
          QQMusicPlayService.a((QQMusicPlayService)localObject).sendEmptyMessageDelayed(14, 500L);
          label1309:
          if ((QLog.isColorLevel()) && (paramMessage.what == 13)) {
            if (paramMessage.what != 13) {
              break label1394;
            }
          }
        }
        label1394:
        for (bool1 = true;; bool1 = false)
        {
          QLog.i("QQMusicPlay.QQMusicPlayService", 2, String.format("--->handleMessage[MSG_FROM_CLIENT_SYNC_PROGRESS=%b]", new Object[] { Boolean.valueOf(bool1) }));
          if (QQMusicPlayService.b() == null) {
            break;
          }
          QQMusicPlayService.a((QQMusicPlayService)localObject, QQMusicPlayService.wZ(), QQMusicPlayService.FH(), QQMusicPlayService.FS());
          return;
          QQMusicPlayService.a((QQMusicPlayService)localObject).removeMessages(14);
          break label1309;
        }
        break label108;
      }
    }
  }
  
  static class b
    implements INetInfoHandler
  {
    private final WeakReference<QQMusicPlayService> bs;
    long by = 0L;
    
    b(QQMusicPlayService paramQQMusicPlayService)
    {
      this.bs = new WeakReference(paramQQMusicPlayService);
    }
    
    private void HJ(int paramInt)
    {
      boolean bool2 = true;
      QQMusicPlayService localQQMusicPlayService = (QQMusicPlayService)this.bs.get();
      if (localQQMusicPlayService == null) {}
      while (System.currentTimeMillis() - this.by < 500L) {
        return;
      }
      this.by = System.currentTimeMillis();
      boolean bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 2)
        {
          bool1 = bool2;
          if (paramInt != 3) {
            if (paramInt != 6) {
              break label78;
            }
          }
        }
      }
      label78:
      for (bool1 = bool2;; bool1 = false)
      {
        QQMusicPlayService.a(localQQMusicPlayService, bool1);
        return;
      }
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
  
  class c
    extends BroadcastReceiver
  {
    private c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent != null)
      {
        QLog.d("QQMusicPlay.QQMusicPlayService", 1, "QQMusicPlayBroadcastReceiver onReceive,action:" + paramIntent.getAction());
        paramContext = paramIntent.getAction();
        if ((paramContext != null) && ((paramContext.equals("com.tencent.mobileqq.intent.logout")) || (paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) || (paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) || (paramContext.equals("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName())) || (paramContext.equals("mqq.intent.action.LOGOUT")) || (paramContext.equals("QQMusicPlay_exit_action"))))
        {
          if (QQMusicPlayService.a(QQMusicPlayService.this) == null) {
            break label150;
          }
          QQMusicPlayService.a(QQMusicPlayService.this).sendEmptyMessage(11);
        }
      }
      return;
      label150:
      QQMusicPlayService.this.stopSelf();
    }
  }
  
  class d
  {
    ISong a;
    MediaPlayer player;
    
    d(MediaPlayer paramMediaPlayer, ISong paramISong)
    {
      this.player = paramMediaPlayer;
      this.a = paramISong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService
 * JD-Core Version:    0.7.0.1
 */