package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class AudioDeviceManager
  extends BroadcastReceiver
  implements AudioSenorManager.b, Manager
{
  private AudioSenorManager a;
  private boolean bcT;
  private boolean bcU;
  private boolean bcV;
  private boolean bcW;
  private boolean bcX;
  private WeakReference<QQAppInterface> mApp;
  private List<a> ry = new ArrayList();
  
  public AudioDeviceManager(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    if (Build.VERSION.SDK_INT >= 11)
    {
      localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
      localIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }
    localBaseApplication.registerReceiver(this, localIntentFilter);
    this.a = new AudioSenorManager(paramQQAppInterface);
    this.a.a(this);
    aR(paramQQAppInterface);
  }
  
  public static AudioDeviceManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (AudioDeviceManager)paramQQAppInterface.getManager(354);
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void aL(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioDeviceManager", 2, "notifyAllDeviceStatusChanged: changedType=" + paramInt + " changedValue=" + paramBoolean);
    }
    Iterator localIterator = this.ry.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((locala.vK() & paramInt) == paramInt)
      {
        QLog.d("AudioDeviceManager", 2, "notifyAllDeviceStatusChanged: audioDeviceListener=" + locala.getClass());
        locala.aM(paramInt, paramBoolean);
      }
    }
  }
  
  private void aR(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioDeviceManager", 2, "$bindApp, app = " + paramQQAppInterface);
    }
    if ((this.mApp != null) && (this.mApp.get() == paramQQAppInterface)) {
      return;
    }
    if ((this.mApp != null) && (this.mApp.get() != null)) {
      gB();
    }
    this.mApp = new WeakReference(paramQQAppInterface);
  }
  
  public void Cd(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioDeviceManager", 2, "onNearToEarStatusChanged: senorIsNear=" + bool + " | isRingerMode_not_normal =" + this.bcV);
      }
      if (bool != this.bcT)
      {
        this.bcT = bool;
        aL(2, bool);
      }
      return;
      bool = false;
    }
  }
  
  public void a(a parama)
  {
    if (parama == null)
    {
      QLog.e("AudioDeviceManager", 2, "registerAudioDeviceListener listener is null");
      return;
    }
    if (this.ry.contains(parama))
    {
      QLog.e("AudioDeviceManager", 2, "registerAudioDeviceListener listener is contains");
      return;
    }
    this.ry.add(parama);
  }
  
  public void b(a parama)
  {
    if (parama == null)
    {
      QLog.e("AudioDeviceManager", 2, "unRegisterAudioDeviceListener listener is null");
      return;
    }
    if (this.ry.contains(parama))
    {
      this.ry.remove(parama);
      return;
    }
    QLog.e("AudioDeviceManager", 2, "unRegisterAudioDeviceListener listener is not contains");
  }
  
  public void gB()
  {
    try
    {
      if ((this.mApp != null) && (this.mApp.get() != null)) {
        ((QQAppInterface)this.mApp.get()).getApp().unregisterReceiver(this);
      }
      this.mApp = null;
      if (QLog.isColorLevel()) {
        QLog.d("AudioDeviceManager", 2, "$unBindApp");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioDeviceManager", 2, "", localException);
    }
  }
  
  public void onDestroy()
  {
    this.ry.clear();
    this.a.onDestory();
    this.a = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    String str = paramIntent.getAction();
    if ((str != null) && (str.equals("android.intent.action.HEADSET_PLUG"))) {
      if (paramIntent.hasExtra("state"))
      {
        if (paramIntent.getIntExtra("state", 0) != 1) {
          break label73;
        }
        bool1 = true;
        if (this.bcU != bool1)
        {
          this.bcU = bool1;
          aL(4, bool1);
        }
      }
    }
    label73:
    int i;
    label376:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            bool1 = false;
            break;
            if ("android.media.RINGER_MODE_CHANGED".equals(str))
            {
              paramContext = (AudioManager)paramContext.getSystemService("audio");
              try
              {
                i = paramContext.getRingerMode();
                if (QLog.isColorLevel()) {
                  QLog.d("AudioDeviceManager", 2, "currentRingerMode:" + i);
                }
                if (i != 2)
                {
                  bool1 = true;
                  if (bool1 == this.bcV) {
                    continue;
                  }
                  this.bcV = bool1;
                  if (!bool1) {
                    continue;
                  }
                  if (this.mApp != null)
                  {
                    paramContext = (QQAppInterface)this.mApp.get();
                    if (paramContext != null) {
                      paramContext.setLoudSpeakerState(false);
                    }
                  }
                  aL(1, false);
                }
              }
              catch (Throwable paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AudioDeviceManager", 2, "onReceive getRingerMode error:" + paramContext.getMessage());
                  }
                  i = 2;
                  continue;
                  bool1 = false;
                }
              }
            }
          }
          if (!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str)) {
            break label376;
          }
          i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        } while ((i != 2) && (i != 0));
        if (i == 2) {}
        for (;;)
        {
          if (bool1 != this.bcW)
          {
            this.bcW = bool1;
            aL(8, bool1);
          }
          if (i != 0) {
            break;
          }
          bool1 = ((AudioManager)paramContext.getSystemService("audio")).isBluetoothA2dpOn();
          bool2 = AudioHelper.aCx();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AudioPlayer", 2, "BluetoothHeadset.STATE_DISCONNECTED: isSysA2dpOn=" + bool1 + "| isAppA2dpOn = " + bool2);
          return;
          bool1 = false;
        }
      } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(str));
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
    } while ((i != 2) && (i != 0));
    if (i == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      if (bool1 != this.bcX)
      {
        this.bcX = bool1;
        aL(16, bool1);
      }
      if (i != 0) {
        break;
      }
      bool1 = ((AudioManager)paramContext.getSystemService("audio")).isBluetoothA2dpOn();
      bool2 = AudioHelper.aCx();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AudioPlayer", 2, "BluetoothA2dp.STATE_DISCONNECTED: isSysA2dpOn=" + bool1 + "| isAppA2dpOn = " + bool2);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aM(int paramInt, boolean paramBoolean);
    
    public abstract int vK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioDeviceManager
 * JD-Core Version:    0.7.0.1
 */