package com.tencent.mobileqq.activity.recent.msg;

import com.tencent.qphone.base.util.BaseApplication;

public class RecentUserMsgFactory
{
  public static Object a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return null;
    case 3: 
      return new TroopSpecialAttentionMsg(BaseApplication.getContext());
    }
    return new TroopNotificationMsg(BaseApplication.getContext());
  }
  
  public static Object a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    Object localObject;
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      localObject = new TroopNotificationMsg(BaseApplication.getContext());
      ((TroopNotificationMsg)localObject).a(paramArrayOfByte);
      return localObject;
    case 3: 
      localObject = new TroopSpecialAttentionMsg(BaseApplication.getContext());
      ((TroopSpecialAttentionMsg)localObject).a(paramArrayOfByte);
      return localObject;
    case 4: 
      localObject = new TroopAtMeMsg(BaseApplication.getContext());
      ((TroopAtMeMsg)localObject).a(paramArrayOfByte);
      return localObject;
    case 2: 
      localObject = new TroopAtAllMsg(BaseApplication.getContext());
      ((TroopAtAllMsg)localObject).a(paramArrayOfByte);
      return localObject;
    }
    return new String(paramArrayOfByte);
  }
  
  public static byte[] a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ((TroopNotificationMsg)paramObject).a();
    case 3: 
      return ((TroopSpecialAttentionMsg)paramObject).a();
    case 4: 
      return ((TroopAtMeMsg)paramObject).a();
    case 2: 
      return ((TroopAtAllMsg)paramObject).a();
    }
    return ((String)paramObject).getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.RecentUserMsgFactory
 * JD-Core Version:    0.7.0.1
 */