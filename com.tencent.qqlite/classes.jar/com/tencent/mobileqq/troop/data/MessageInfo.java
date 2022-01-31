package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg;
import com.tencent.mobileqq.activity.recent.msg.TroopSpecialAttentionMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.qphone.base.util.BaseApplication;

public class MessageInfo
{
  public static final long a = -1L;
  public MessageNavInfo a = new MessageNavInfo();
  public MessageNavInfo b = new MessageNavInfo();
  public MessageNavInfo c = new MessageNavInfo();
  
  public MessageInfo()
  {
    a();
  }
  
  public MessageInfo(MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo != null)
    {
      this.c.a(paramMessageInfo.c);
      this.a.a(paramMessageInfo.a);
      this.b.a(paramMessageInfo.b);
      return;
    }
    a();
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString, MessageInfo paramMessageInfo, Object paramObject)
  {
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)paramQQAppInterface.getManager(33);
    switch (paramMessageInfo.a())
    {
    default: 
      paramQQAppInterface = null;
    }
    do
    {
      do
      {
        do
        {
          return paramQQAppInterface;
          if (!(paramObject instanceof TroopSpecialAttentionMsg)) {
            break;
          }
          paramObject = (TroopSpecialAttentionMsg)paramObject;
          paramQQAppInterface = paramObject;
        } while (!paramObject.a.a(paramMessageInfo.b));
        localTroopInfoManager.a(paramString, 3, paramMessageInfo.b.b, "");
        return paramObject;
        paramQQAppInterface = new TroopSpecialAttentionMsg(BaseApplication.getContext());
        paramQQAppInterface.a = new MessageNavInfo(paramMessageInfo.b);
        localTroopInfoManager.a(paramString, 3, paramMessageInfo.b.b, "");
        return paramQQAppInterface;
        return new TroopNotificationMsg(BaseApplication.getContext());
        if (!(paramObject instanceof TroopAtMeMsg)) {
          break;
        }
        paramObject = (TroopAtMeMsg)paramObject;
        paramQQAppInterface = paramObject;
      } while (!paramObject.a.a(paramMessageInfo.a));
      localTroopInfoManager.a(paramString, 4, paramMessageInfo.a.b, "");
      return paramObject;
      paramQQAppInterface = new TroopAtMeMsg(BaseApplication.getContext());
      paramQQAppInterface.a = new MessageNavInfo(paramMessageInfo.a);
      localTroopInfoManager.a(paramString, 4, paramMessageInfo.a.b, "");
      return paramQQAppInterface;
      if (!(paramObject instanceof TroopAtAllMsg)) {
        break;
      }
      paramObject = (TroopAtAllMsg)paramObject;
      paramQQAppInterface = paramObject;
    } while (!paramObject.a.a(paramMessageInfo.c));
    localTroopInfoManager.a(paramString, 2, paramMessageInfo.c.b, "");
    return paramObject;
    paramQQAppInterface = new TroopAtAllMsg(BaseApplication.getContext());
    paramQQAppInterface.a = new MessageNavInfo(paramMessageInfo.c);
    localTroopInfoManager.a(paramString, 2, paramMessageInfo.c.b, "");
    return paramQQAppInterface;
  }
  
  public int a()
  {
    if (this.a.a()) {
      return 4;
    }
    if (this.b.a()) {
      return 3;
    }
    if (this.c.a()) {
      return 2;
    }
    return 0;
  }
  
  public long a()
  {
    if (this.a.a()) {
      return this.a.a;
    }
    if (this.b.a()) {
      return this.b.a;
    }
    if (this.c.a()) {
      return this.c.a;
    }
    return -1L;
  }
  
  public MessageInfo a(MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo != null)
    {
      this.c.a(paramMessageInfo.c);
      this.a.a(paramMessageInfo.a);
      this.b.a(paramMessageInfo.b);
    }
    return this;
  }
  
  public void a()
  {
    this.c.a();
    this.a.a();
    this.b.a();
  }
  
  public boolean a()
  {
    return (this.c.a()) || (this.a.a()) || (this.b.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.MessageInfo
 * JD-Core Version:    0.7.0.1
 */