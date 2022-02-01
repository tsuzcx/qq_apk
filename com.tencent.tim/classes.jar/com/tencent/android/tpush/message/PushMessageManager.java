package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;

public class PushMessageManager
{
  public static final int MESSAGE_TYPE_CLOUD_CTRL = 1000;
  public static final int MESSAGE_TYPE_CTRL = 3;
  public static final int MESSAGE_TYPE_IN_MSG = 7;
  public static final int MESSAGE_TYPE_NOTIFICATION = 1;
  public static final int MESSAGE_TYPE_TEXT = 2;
  private long a = -1L;
  private long b = -1L;
  private long c = -1L;
  private String d = "";
  private long e = -1L;
  private String f = "";
  private String g = "";
  private long h = -1L;
  private long i = -1L;
  private String j = "";
  private String k = "";
  private String l = "";
  private Context m = null;
  private Intent n = null;
  private a o = null;
  private int p = 0;
  public int pushChannel = 100;
  public long pushTime = 0L;
  public long source = 0L;
  public long targetType = 0L;
  
  private PushMessageManager(Context paramContext, Intent paramIntent)
  {
    this.m = paramContext;
    this.n = paramIntent;
  }
  
  public static PushMessageManager getInstance(Context paramContext, Intent paramIntent)
  {
    PushMessageManager localPushMessageManager = new PushMessageManager(paramContext, paramIntent);
    String str = Rijndael.decrypt(paramIntent.getStringExtra("content"));
    TLogger.d("PushMessageManager", "PushMessageManager content:" + str);
    localPushMessageManager.f = str;
    Object localObject1 = Rijndael.decrypt(paramIntent.getStringExtra("inMsg"));
    TLogger.d("PushMessageManager", "PushMessageManager inMsg:" + (String)localObject1);
    localPushMessageManager.g = ((String)localObject1);
    localPushMessageManager.b = paramIntent.getLongExtra("msgId", -1L);
    TLogger.d("PushMessageManager", "PushMessageManager msgId:" + localPushMessageManager.b);
    localPushMessageManager.c = paramIntent.getLongExtra("accId", -1L);
    localPushMessageManager.d = paramIntent.getStringExtra("third_app_pkgname");
    localPushMessageManager.e = paramIntent.getLongExtra("busiMsgId", -1L);
    localPushMessageManager.a = paramIntent.getLongExtra("channel_id", -1L);
    localPushMessageManager.h = paramIntent.getLongExtra("timestamps", -1L);
    localPushMessageManager.i = paramIntent.getLongExtra("type", -1L);
    TLogger.d("PushMessageManager", "PushMessageManager type:" + localPushMessageManager.i);
    int i1 = paramIntent.getIntExtra("pushChannel", 100);
    localPushMessageManager.pushTime = paramIntent.getLongExtra("pushTime", -1L);
    localPushMessageManager.pushChannel = i1;
    localPushMessageManager.j = paramIntent.getStringExtra("group_id");
    if (i.b(localPushMessageManager.j)) {
      localPushMessageManager.j = paramIntent.getStringExtra("groupId");
    }
    localPushMessageManager.targetType = paramIntent.getLongExtra("targetType", 0L);
    localPushMessageManager.source = paramIntent.getLongExtra("source", 0L);
    localPushMessageManager.k = paramIntent.getStringExtra("templateId");
    localPushMessageManager.l = paramIntent.getStringExtra("traceId");
    Object localObject2 = null;
    localObject1 = localObject2;
    switch ((int)localPushMessageManager.i)
    {
    default: 
      TLogger.e("PushMessageManager", "error type for message, drop it, type:" + localPushMessageManager.i + ",intent:" + paramIntent);
      XGPushManager.msgAck(paramContext, localPushMessageManager);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localPushMessageManager.o = ((a)localObject1);
        localPushMessageManager.o.a();
      }
      localPushMessageManager.p = paramIntent.getIntExtra("revokeId", 0);
      return localPushMessageManager;
      localObject1 = new f(str);
      continue;
      localObject1 = new d(str);
      continue;
      MessageManager.getInstance().onCrtlMsgHandle(paramContext, str);
      XGPushManager.msgAck(paramContext, localPushMessageManager);
      localObject1 = localObject2;
    }
  }
  
  public long getAccessId()
  {
    return this.c;
  }
  
  public String getAppPkgName()
  {
    return this.d;
  }
  
  public long getBusiMsgId()
  {
    return this.e;
  }
  
  public long getChannelId()
  {
    return this.a;
  }
  
  public String getContent()
  {
    return this.f;
  }
  
  public Context getContext()
  {
    return this.m;
  }
  
  public String getGroupId()
  {
    return this.j;
  }
  
  public String getInMsg()
  {
    return this.g;
  }
  
  public Intent getIntent()
  {
    return this.n;
  }
  
  public a getMessageHolder()
  {
    return this.o;
  }
  
  public long getMsgId()
  {
    return this.b;
  }
  
  public int getRevokeId()
  {
    return this.p;
  }
  
  public long getSource()
  {
    return this.source;
  }
  
  public long getTargetType()
  {
    return this.targetType;
  }
  
  public String getTemplateId()
  {
    return this.k;
  }
  
  public long getTimestamps()
  {
    return this.h;
  }
  
  public String getTraceId()
  {
    return this.l;
  }
  
  public long getType()
  {
    return this.i;
  }
  
  public void setAppPkgName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setChannelId(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setGroupId(String paramString)
  {
    this.j = paramString;
  }
  
  public void setSource(long paramLong)
  {
    this.source = paramLong;
  }
  
  public void setTargetType(long paramLong)
  {
    this.targetType = paramLong;
  }
  
  public void showNotifacition()
  {
    if (this.o.b() != 1) {
      return;
    }
    b.a(this.m, this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PushMessageManager [msgId=").append(this.b).append(", accessId=").append(this.c).append(", busiMsgId=").append(this.e).append(", content=").append(this.f).append(", timestamps=").append(this.h).append(", type=").append(this.i).append(", intent=").append(this.n).append(", messageHolder=").append(this.o).append(", appPkgName=").append(this.d).append(", revokeId=").append(this.p).append(", templateId=").append(this.k).append(", traceId=").append(this.l).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.message.PushMessageManager
 * JD-Core Version:    0.7.0.1
 */