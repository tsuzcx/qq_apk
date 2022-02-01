package com.tencent.android.tpush.message;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.dataacquisition.DeviceInfos;

class e$2
  implements Runnable
{
  e$2(e parame, Intent paramIntent) {}
  
  public void run()
  {
    if (XGPushConfig.enableDebug) {
      TLogger.d("PushMessageHandler", "Action -> handleRemotePushMessage");
    }
    long l1 = this.a.getLongExtra("msgId", 0L);
    long l2 = this.a.getLongExtra("timestamps", 0L);
    long l3 = this.a.getLongExtra("server_time", 0L);
    int i = this.a.getIntExtra("ttl", 0);
    long l4 = this.a.getLongExtra("type", 1L);
    int j = this.a.getIntExtra("revokeId", 0);
    if (j > 0) {}
    for (;;)
    {
      try
      {
        TLogger.i("PushMessageHandler", "message revokeId of notifyId " + j);
        ((NotificationManager)e.a(this.b).getSystemService("notification")).cancel(j);
        return;
      }
      catch (Throwable localThrowable1)
      {
        TLogger.e("PushMessageHandler", "NotificationManager.cancel error: " + localThrowable1.toString());
        return;
      }
      if (!XGPushConfig.isNotificationShowEnable(e.a(this.b)))
      {
        TLogger.ii("PushMessageHandler", "XINGE NotificationShow is not enabe, so discard this notification, msgid:" + l1);
        return;
      }
      long l5 = this.a.getLongExtra("accId", 0L);
      String str1 = this.a.getPackage();
      try
      {
        localObject = CacheManager.getCurrentAppRegisterEntity(e.a(this.b));
        if ((localObject != null) && (!i.b(((RegisterEntity)localObject).packageName)) && (str1.equals(((RegisterEntity)localObject).packageName)) && (l5 == ((RegisterEntity)localObject).accessId))
        {
          j = ((RegisterEntity)localObject).state;
          if (j == 1) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject;
          String str2;
          long l6;
          long l7;
          long l8;
          long l9;
          String str3;
          String str4;
          long l10;
          String str5;
          TLogger.e("PushMessageHandler", localThrowable2.toString());
        }
        if (!MessageManager.getInstance().isMsgAcked(e.a(this.b), str1, localThrowable2.id)) {
          break label993;
        }
        TLogger.ee("PushMessageHandler", ">> msgId:" + localThrowable2.id + " has been acked, return");
        return;
        localThrowable2.pkgName = str1;
        if (localThrowable2.id <= 0L) {
          break label1027;
        }
        MessageManager.getInstance().addMsgId(e.a(this.b), str1, localThrowable2);
        MessageManager.getInstance().addNewCachedMsgIntent(e.a(this.b), this.a);
        e.a(this.b, this.a);
      }
    }
    str2 = this.a.getStringExtra("date");
    l6 = this.a.getLongExtra("extra_push_time", 0L);
    l7 = this.a.getLongExtra("busiMsgId", 0L);
    l8 = this.a.getLongExtra("multiPkg", 0L);
    l9 = this.a.getLongExtra("channel_id", -1L);
    str3 = this.a.getStringExtra("group_id");
    str4 = this.a.getStringExtra("stat_tag");
    l10 = System.currentTimeMillis();
    localObject = new MessageId();
    ((MessageId)localObject).id = l1;
    ((MessageId)localObject).isAck = 0;
    ((MessageId)localObject).accessId = l5;
    ((MessageId)localObject).host = this.a.getLongExtra("extra_host", 0L);
    ((MessageId)localObject).port = this.a.getIntExtra("extra_port", 0);
    ((MessageId)localObject).pact = this.a.getByteExtra("extra_pact", (byte)0);
    ((MessageId)localObject).apn = DeviceInfos.getNetworkType(e.a(this.b));
    ((MessageId)localObject).isp = i.o(e.a(this.b));
    ((MessageId)localObject).serviceHost = this.a.getStringExtra("svrPkgName");
    ((MessageId)localObject).receivedTime = l10;
    ((MessageId)localObject).pkgName = str1;
    ((MessageId)localObject).busiMsgId = l7;
    ((MessageId)localObject).timestamp = l2;
    ((MessageId)localObject).msgType = l4;
    ((MessageId)localObject).multiPkg = l8;
    ((MessageId)localObject).date = str2;
    ((MessageId)localObject).channelId = l9;
    ((MessageId)localObject).pushTime = this.a.getLongExtra("pushTime", 0L);
    ((MessageId)localObject).pushChannel = this.a.getIntExtra("pushChannel", 100);
    str5 = this.a.getStringExtra("groupId");
    if (!i.b(str5)) {
      ((MessageId)localObject).nGroupId = str5;
    }
    if (!i.b(str3)) {
      ((MessageId)localObject).groupId = str3;
    }
    if (!i.b(str4)) {
      ((MessageId)localObject).statTag = str4;
    }
    TLogger.i("PushMessageHandler", ">> msg from service,  @msgId=" + ((MessageId)localObject).id + " @accId=" + ((MessageId)localObject).accessId + " @timeUs=" + l6 + " @recTime=" + ((MessageId)localObject).receivedTime + " @msg.date=" + str2 + " @msg.busiMsgId=" + l7 + " @msg.timestamp=" + l2 + " @msg.type=" + l4 + " @msg.multiPkg=" + l8 + " @msg.serverTime=" + l3 + " @msg.ttl=" + i + " @currentTimeMillis=" + l10);
    str2 = MessageManager.getNotifiedMsgIds(e.a(this.b), l5);
    str3 = "@" + ((MessageId)localObject).id + str1 + "@";
    TLogger.i("PushMessageHandler", "cache msgIds:" + str2 + ", vs current msgIdstr:" + str3);
    if (str2.contains(str3))
    {
      TLogger.ee("PushMessageHandler", "getNotifiedMsgIds contain the msgId id:" + str3 + ", return");
      return;
    }
    label993:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.e.2
 * JD-Core Version:    0.7.0.1
 */