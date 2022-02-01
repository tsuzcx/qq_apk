package com.tencent.commonsdk.util.notification;

import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

public class GroupChannelController
{
  public static final boolean ENABLE_GROUP_CHANNEL = false;
  private static final String TAG = "GroupChannelController";
  
  void alignGroupChannelToOriginMessageChannel(NotificationChannel paramNotificationChannel1, NotificationChannel paramNotificationChannel2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupChannelController", 2, new Object[] { "alignGroupChannelToOriginMessageChannel: invoked. ", " messageChannel: ", paramNotificationChannel2, " groupChannel: ", paramNotificationChannel1 });
    }
    if ((paramNotificationChannel1 != null) && (paramNotificationChannel2 != null))
    {
      int i = paramNotificationChannel2.getImportance();
      paramNotificationChannel1.setImportance(i);
      boolean bool1 = paramNotificationChannel2.canShowBadge();
      paramNotificationChannel1.setShowBadge(bool1);
      Uri localUri = paramNotificationChannel2.getSound();
      AudioAttributes localAudioAttributes = paramNotificationChannel2.getAudioAttributes();
      paramNotificationChannel1.setSound(localUri, localAudioAttributes);
      boolean bool2 = paramNotificationChannel2.shouldVibrate();
      paramNotificationChannel1.enableVibration(bool2);
      long[] arrayOfLong = paramNotificationChannel2.getVibrationPattern();
      paramNotificationChannel1.setVibrationPattern(arrayOfLong);
      paramNotificationChannel1.setLightColor(paramNotificationChannel2.getLightColor());
      paramNotificationChannel1.enableLights(paramNotificationChannel2.shouldShowLights());
      paramNotificationChannel1.setLockscreenVisibility(paramNotificationChannel2.getLockscreenVisibility());
      boolean bool3 = paramNotificationChannel2.canBypassDnd();
      paramNotificationChannel1.setBypassDnd(bool3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupChannelController", 2, new Object[] { "alignGroupChannelToOriginMessageChannel: invoked. origin channel switch ", " \nimportance: ", Integer.valueOf(i), " \naudioAttributes: ", localAudioAttributes, " \nsound: ", localUri, " \nshouldVibrate: ", Boolean.valueOf(bool2), " \nvibrationPattern: ", arrayOfLong, " \nshowBadge: ", Boolean.valueOf(bool1), " \nbypassDnd: ", Boolean.valueOf(bool3) });
      }
      if (QLog.isColorLevel()) {
        QLog.d("GroupChannelController", 2, new Object[] { "alignGroupChannelToOriginMessageChannel: invoked. group channel switch ", " \nimportance: ", Integer.valueOf(paramNotificationChannel1.getImportance()), " \naudioAttributes: ", paramNotificationChannel1.getAudioAttributes(), " \nsound: ", paramNotificationChannel1.getSound(), " \nshouldVibrate: ", Boolean.valueOf(paramNotificationChannel1.shouldVibrate()), " \nvibrationPattern: ", paramNotificationChannel1.getVibrationPattern(), " \nshowBadge: ", Boolean.valueOf(paramNotificationChannel1.canShowBadge()), " \nbypassDnd: ", Boolean.valueOf(paramNotificationChannel1.canBypassDnd()) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.commonsdk.util.notification.GroupChannelController
 * JD-Core Version:    0.7.0.1
 */