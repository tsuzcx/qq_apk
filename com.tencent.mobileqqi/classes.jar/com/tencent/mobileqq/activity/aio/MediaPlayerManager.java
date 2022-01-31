package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import dvu;
import dvv;
import mqq.manager.Manager;

public class MediaPlayerManager
  extends BroadcastReceiver
  implements SensorEventListener, AudioPlayer.AudioPlayerListener, Manager
{
  private static final String jdField_a_of_type_JavaLangString = MediaPlayerManager.class.getSimpleName();
  public float a;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private MediaPlayerManager.Listener jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private dvv jdField_a_of_type_Dvv;
  public boolean a;
  public float b;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  boolean jdField_b_of_type_Boolean = true;
  public float c;
  boolean c = false;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  public MediaPlayerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    BaseApplication localBaseApplication = paramQQAppInterface.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(localBaseApplication, this);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)localBaseApplication.getSystemService("sensor"));
    this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
    this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
    this.jdField_a_of_type_Dvv = new dvv(this);
    if (this.jdField_a_of_type_AndroidHardwareSensor != null) {
      if ((!a()) && (!b())) {
        break label179;
      }
    }
    label179:
    for (this.jdField_d_of_type_Float = 97.0F;; this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidHardwareSensor.getMaximumRange())
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      if (Build.VERSION.SDK_INT >= 11) {
        localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
      }
      localBaseApplication.registerReceiver(this, localIntentFilter);
      a(paramQQAppInterface);
      return;
    }
  }
  
  private int a()
  {
    int i = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    if (i >= 0)
    {
      View localView = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.k() + i);
      ((MediaPlayerManager.Callback)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1)).a(this.jdField_a_of_type_ComTencentWidgetXListView, i, localView, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    return i;
  }
  
  private int a(ChatMessage paramChatMessage, ChatAdapter1 paramChatAdapter1)
  {
    int i = 0;
    while (i < paramChatAdapter1.getCount())
    {
      ChatMessage localChatMessage = (ChatMessage)paramChatAdapter1.getItem(i);
      if ((localChatMessage.getClass() == paramChatMessage.getClass()) && (localChatMessage.uniseq == paramChatMessage.uniseq)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static MediaPlayerManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (MediaPlayerManager)paramQQAppInterface.getManager(21);
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "$bindApp, app = " + paramQQAppInterface);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static boolean a()
  {
    return Build.MODEL.equals("ZTE U880s");
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)) {
        a();
      }
    }
    for (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;; this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null)
    {
      do
      {
        return true;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
      if (!((MediaPlayerManager.Callback)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1)).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      a();
    }
    return false;
  }
  
  public static boolean b()
  {
    return Build.MODEL.equals("ZTE U807");
  }
  
  public static boolean c()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  private boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null))
    {
      int j = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
      if (j <= m)
      {
        View localView2 = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.k() + j);
        int i = j;
        View localView1 = localView2;
        if (j >= 0)
        {
          ((MediaPlayerManager.Callback)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1)).a(this.jdField_a_of_type_ComTencentWidgetXListView, j, localView2, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          localView1 = localView2;
          i = j;
        }
        while (i < m - 1)
        {
          int k = i + 1;
          ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(k);
          i = k;
          if ((localChatMessage instanceof MediaPlayerManager.Media))
          {
            if ((this.f) && (localView1 != null)) {}
            for (j = 1;; j = 0) {
              for (;;)
              {
                localView2 = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, k);
                MediaPlayerManager.Callback localCallback = (MediaPlayerManager.Callback)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
                i = k;
                localView1 = localView2;
                try
                {
                  if (!localCallback.a(this.jdField_a_of_type_ComTencentWidgetXListView, k, localView2, localChatMessage)) {
                    break;
                  }
                  i = k;
                  localView1 = localView2;
                  if (!localCallback.a(this.jdField_a_of_type_ComTencentWidgetXListView, k, localView2, localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer)) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = localChatMessage;
                  if (j != 0) {
                    this.jdField_a_of_type_ComTencentWidgetXListView.b(k);
                  }
                  return true;
                }
                catch (Exception localException)
                {
                  i = k;
                  localView1 = localView2;
                }
              }
            }
            if (QLog.isColorLevel())
            {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "playNext", localException);
              i = k;
              localView1 = localView2;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
    return false;
  }
  
  public ChatMessage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public void a()
  {
    try
    {
      a(true);
      b();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "$unBindApp");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "", localException);
    }
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    BaseApplicationImpl.a().a(2131165198, false);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (e())) {
      return;
    }
    d();
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.b(paramInt);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new dvu(this, paramAudioPlayer, paramInt));
  }
  
  public void a(XListView paramXListView, ChatAdapter1 paramChatAdapter1, MediaPlayerManager.Listener paramListener)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != paramXListView)
    {
      b();
      this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = paramListener;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a(paramBoolean)) {
      d();
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (paramChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (a(false)))
    {
      int i = a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      View localView = AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.k() + i);
      MediaPlayerManager.Callback localCallback = (MediaPlayerManager.Callback)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      if (AIOUtils.b()) {}
      for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v())
      {
        boolean bool = AudioHelper.a(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool);
        if (!localCallback.a(this.jdField_a_of_type_ComTencentWidgetXListView, i, localView, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
        this.f = true;
        this.c = false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.q();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(false, bool, this.jdField_d_of_type_Boolean);
        }
        this.e = false;
        if ((this.jdField_b_of_type_AndroidHardwareSensor != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null))
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Dvv, this.jdField_b_of_type_AndroidHardwareSensor, 3);
        }
        if (this.jdField_a_of_type_AndroidHardwareSensor != null) {
          this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 3);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "$requestPlay| mAccelerationSensro=" + this.jdField_b_of_type_AndroidHardwareSensor + " | mProximitySensor = " + this.jdField_a_of_type_AndroidHardwareSensor);
        }
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = null;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener = null;
    }
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.c(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (d())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.f = paramBoolean;
      return;
    }
  }
  
  public void c()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
    if ((bool != this.jdField_d_of_type_Boolean) && (d()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null) || (QLog.isColorLevel())) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "$updateSpeakPhone| speakerOn=" + bool);
      }
    }
    this.jdField_d_of_type_Boolean = bool;
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "$onStop");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.r();
    }
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_Dvv);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onDestroy()
  {
    a();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    String str = paramIntent.getAction();
    if ((str != null) && (str.equals("android.intent.action.HEADSET_PLUG")) && (d())) {
      if (paramIntent.hasExtra("state"))
      {
        if (paramIntent.getIntExtra("state", 0) != 1) {
          break label101;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool1);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(bool1, AudioHelper.a(BaseApplicationImpl.getContext()), this.jdField_d_of_type_Boolean);
        }
      }
    }
    label101:
    int i;
    label206:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            bool1 = false;
            break;
            if (!"android.media.RINGER_MODE_CHANGED".equals(str)) {
              break label206;
            }
          } while (((AudioManager)paramContext.getSystemService("audio")).getRingerMode() == 2);
          this.jdField_d_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f(this.jdField_d_of_type_Boolean);
          }
        } while ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(this.e, this.jdField_d_of_type_Boolean);
        return;
        if ("android.intent.action.SCREEN_OFF".equals(str))
        {
          a(false);
          return;
        }
      } while ((!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str)) || (!d()));
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
    } while ((i != 2) && (i != 0));
    if (i == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool1);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null) {
        break;
      }
      return;
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    boolean bool1;
    if (paramSensorEvent.values[0] < this.jdField_d_of_type_Float)
    {
      bool1 = true;
      if ((AudioHelper.a()) || (!bool1) || (this.jdField_a_of_type_Boolean)) {
        break label39;
      }
    }
    label39:
    label195:
    label240:
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool2;
            do
            {
              do
              {
                return;
                bool1 = false;
                break;
              } while ((this.e == bool1) || (!d()));
              bool2 = AudioHelper.a(BaseApplicationImpl.getContext());
              this.e = bool1;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "ProximityEventListener$onSensorChanged | currentSpeaker = " + this.jdField_d_of_type_Boolean + " | mNearToEar = " + this.e + " | wiredHeadsetConnected = " + false + " | btHeadsetConnect = " + bool2);
              }
            } while (bool2);
            if ((!this.e) || (!this.jdField_d_of_type_Boolean)) {
              break label195;
            }
            this.jdField_d_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean);
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(this.e, this.jdField_d_of_type_Boolean);
          return;
          if (!this.e) {
            break label240;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean, true);
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(this.e, this.jdField_d_of_type_Boolean);
        return;
      } while ((this.e) || (this.jdField_d_of_type_Boolean));
      this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_d_of_type_Boolean);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager$Listener.a(this.e, this.jdField_d_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */