package com.tencent.mobileqq.app;

import QQService.RespTmpChatPicDownload;
import android.os.Bundle;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.OffLineFileInfo;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class MessageObserver
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {}
    for (Object localObject1 = (Object[])paramObject;; localObject1 = null)
    {
      String str1 = null;
      String str2 = null;
      String str3 = null;
      Object localObject2 = null;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return;
      case 6008: 
        e(paramBoolean);
        return;
      case 999: 
        if ((paramObject instanceof String))
        {
          d(paramBoolean, (String)paramObject);
          return;
        }
        d(paramBoolean, "");
        return;
      case 6005: 
        d(paramBoolean);
        return;
      case 6004: 
        a(paramBoolean, paramObject);
        return;
      case 6006: 
        i(paramBoolean);
        return;
      case 1000: 
        e();
        return;
      case 1003: 
        b(paramBoolean);
        return;
      case 1004: 
        if ((localObject1 != null) && (localObject1.length >= 2)) {
          if ((localObject1[0] != null) && ((localObject1[0] instanceof Boolean)))
          {
            bool = ((Boolean)localObject1[0]).booleanValue();
            label575:
            if ((localObject1[1] != null) && ((localObject1[1] instanceof String))) {
              paramObject = (String)localObject1[1];
            }
          }
        }
        break;
      }
      for (;;)
      {
        a(paramBoolean, bool, paramObject);
        return;
        c(paramBoolean);
        return;
        c();
        return;
        d();
        a();
        return;
        a();
        return;
        if ((localObject1 == null) || (localObject1.length <= 2)) {
          break;
        }
        str1 = (String)localObject1[0];
        paramInt = ((Integer)localObject1[1]).intValue();
        int i = ((Integer)localObject1[2]).intValue();
        long l1;
        if (localObject1.length >= 6)
        {
          paramObject = (SendMessageHandler)localObject1[3];
          l1 = ((Long)localObject1[4]).longValue();
        }
        for (long l2 = ((Long)localObject1[5]).longValue();; l2 = 0L)
        {
          localObject2 = "";
          if (localObject1.length >= 7) {
            localObject2 = (String)localObject1[6];
          }
          a(str1, paramInt, i, paramObject, l1, l2, (String)localObject2);
          return;
          paramObject = null;
          l1 = 96000L;
        }
        if ((localObject1 == null) || (localObject1.length <= 2)) {
          break;
        }
        a((String)localObject1[0], ((Integer)localObject1[1]).intValue(), ((Integer)localObject1[2]).intValue());
        return;
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          paramObject = new String[localObject1.length];
          paramInt = 0;
          while (paramInt < paramObject.length)
          {
            paramObject[paramInt] = ((String)localObject1[paramInt]);
            paramInt += 1;
          }
          a(paramBoolean, paramObject);
          return;
        }
        a(paramBoolean, null);
        return;
        if (paramBoolean)
        {
          localObject2 = null;
          paramObject = localObject2;
          if (localObject1 != null)
          {
            paramObject = localObject2;
            if (localObject1.length > 0) {
              paramObject = (RespTmpChatPicDownload)localObject1[0];
            }
          }
          a(paramBoolean, paramObject);
          return;
        }
        a(paramBoolean, null);
        return;
        a(paramBoolean, false);
        return;
        a(false, true);
        return;
        paramObject = (ToServiceMsg)paramObject;
        str2 = (String)paramObject.getAttribute("_tag_LOGSTR");
        paramInt = paramObject.extraData.getInt("system_msg_action_type");
        localObject1 = paramObject.extraData.getString("system_msg_action_resp_key");
        localObject2 = paramObject.extraData.getString("system_msg_action_resp_error_key");
        i = paramObject.extraData.getInt("system_msg_action_resp_result_code_key");
        int j = paramObject.extraData.getInt("system_msg_action_resp_type_key");
        str1 = paramObject.extraData.getString("system_msg_action_resp_invalid_decided_key");
        int k = paramObject.extraData.getInt("system_msg_action_resp_remark_result_key");
        paramObject = localObject1;
        if (localObject1 == null) {
          paramObject = "";
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        if (QLog.isColorLevel()) {
          QLog.d("MessageObserver", 2, "sendSystemMsgActionResult logStr=" + str2 + ";actionType=" + paramInt + ";msgDetail=" + paramObject + ";resultCode=" + i + ";respType=" + j + ";msgFail=" + (String)localObject1 + ";msgInvalidDecided=" + (String)localObject2 + ";remarkRet=" + k);
        }
        a(paramBoolean, str2, paramInt, paramObject, i, j, (String)localObject1, (String)localObject2, k);
        return;
        a((String)((ToServiceMsg)paramObject).getAttribute("_tag_LOGSTR"));
        return;
        a(paramBoolean);
        return;
        f(paramBoolean);
        return;
        if ((localObject1 == null) || (localObject1.length < 1)) {
          break;
        }
        a(paramBoolean, (String)localObject1[0]);
        return;
        h(paramBoolean);
        return;
        if (paramBoolean) {
          if ((localObject1 == null) || (localObject1.length < 1)) {
            break label1997;
          }
        }
        label1986:
        label1997:
        for (paramObject = (byte[])localObject1[0];; paramObject = null)
        {
          if ((localObject1 != null) && (localObject1.length >= 2)) {}
          for (localObject1 = (MessageObserver.StatictisInfo)localObject1[1];; localObject1 = null)
          {
            a(paramBoolean, paramObject, (MessageObserver.StatictisInfo)localObject1);
            return;
            paramObject = localObject2;
            if (localObject1 != null)
            {
              paramObject = localObject2;
              if (localObject1.length >= 2) {
                paramObject = (MessageObserver.StatictisInfo)localObject1[1];
              }
            }
            a(paramBoolean, null, paramObject);
            return;
            if (paramBoolean) {
              if ((localObject1 == null) || (localObject1.length < 1)) {
                break label1986;
              }
            }
            for (paramObject = (MessageFactoryReceiver.OffLineFileInfo)localObject1[0];; paramObject = null)
            {
              localObject2 = str1;
              if (localObject1 != null)
              {
                localObject2 = str1;
                if (localObject1.length >= 2) {
                  localObject2 = (MessageObserver.StatictisInfo)localObject1[1];
                }
              }
              a(paramBoolean, paramObject, (MessageObserver.StatictisInfo)localObject2);
              return;
              paramObject = str2;
              if (localObject1 != null)
              {
                paramObject = str2;
                if (localObject1.length >= 2) {
                  paramObject = (MessageObserver.StatictisInfo)localObject1[1];
                }
              }
              a(paramBoolean, null, paramObject);
              return;
              if (paramBoolean)
              {
                localObject2 = null;
                paramObject = localObject2;
                if (localObject1 != null)
                {
                  paramObject = localObject2;
                  if (localObject1.length >= 1) {
                    paramObject = (MessageFactoryReceiver.OffLineFileInfo)localObject1[0];
                  }
                }
                a(paramBoolean, paramObject);
                return;
              }
              a(paramBoolean, null);
              return;
              g(paramBoolean);
              return;
              if ((localObject1 != null) && (localObject1.length >= 2))
              {
                a(paramBoolean, ((Long)localObject1[0]).longValue(), ((Long)localObject1[1]).longValue());
                return;
              }
              a(paramBoolean, 0L, 0L);
              return;
              if ((localObject1 == null) || (localObject1.length < 1)) {
                break;
              }
              a(paramBoolean, (MessageFactoryReceiver.UploadStreamStruct)localObject1[0]);
              return;
              if (!(paramObject instanceof String)) {
                break;
              }
              b(paramBoolean, (String)paramObject);
              return;
              if (!(paramObject instanceof String)) {
                break;
              }
              c(paramBoolean, (String)paramObject);
              return;
              if ((localObject1 == null) || (localObject1.length <= 1)) {
                break;
              }
              a(((Byte)localObject1[0]).byteValue(), ((Byte)localObject1[1]).byteValue());
              return;
              paramObject = str3;
              if (localObject1 != null)
              {
                paramObject = str3;
                if (localObject1.length >= 1) {
                  paramObject = (MessageObserver.StatictisInfo)localObject1[0];
                }
              }
              a(paramBoolean, paramObject);
              return;
              if ((localObject1 == null) || (localObject1.length < 2)) {
                break;
              }
              paramObject = (Integer)localObject1[0];
              localObject2 = (String)localObject1[1];
              localObject1 = (String)localObject1[2];
              a(paramBoolean, (String)localObject2, paramObject.intValue(), (String)localObject1);
              return;
              b();
              return;
              if (QLog.isColorLevel()) {
                QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_GET_MSG");
              }
              localObject1 = null;
              if (paramObject != null) {
                localObject1 = ((SubAccountBackProtocData)paramObject).c;
              }
              b(paramBoolean, (String)localObject1, (SubAccountBackProtocData)paramObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_MSG_NUM_READED_CONFIRM isSucc=" + paramBoolean + " data=" + String.valueOf(paramObject));
              }
              str1 = null;
              str2 = null;
              localObject2 = str2;
              localObject1 = str1;
              if ((paramObject instanceof String[]))
              {
                paramObject = (String[])paramObject;
                localObject2 = str2;
                localObject1 = str1;
                if (paramObject.length == 2)
                {
                  localObject1 = paramObject[0];
                  localObject2 = paramObject[1];
                }
              }
              a(paramBoolean, (String)localObject1, (String)localObject2);
              return;
              localObject1 = null;
              if (paramObject != null) {
                localObject1 = ((SubAccountBackProtocData)paramObject).c;
              }
              a(paramBoolean, (String)localObject1, (SubAccountBackProtocData)paramObject);
              return;
              if ((localObject1 == null) || (localObject1.length != 6)) {
                break;
              }
              paramObject = (Boolean)localObject1[0];
              localObject2 = (String)localObject1[1];
              str1 = (String)localObject1[2];
              str2 = (String)localObject1[3];
              str3 = (String)localObject1[4];
              localObject1 = (ArrayList)localObject1[5];
              a(paramBoolean, paramObject.booleanValue(), (String)localObject2, str1, str2, str3, (ArrayList)localObject1);
              return;
              a(paramObject);
              return;
              b(paramObject);
              return;
            }
          }
        }
        paramObject = null;
        continue;
        bool = false;
        break label575;
        bool = false;
        paramObject = null;
      }
    }
  }
  
  protected void a(Object paramObject) {}
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, int paramInt1, int paramInt2) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2) {}
  
  public void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, RespTmpChatPicDownload paramRespTmpChatPicDownload) {}
  
  protected void a(boolean paramBoolean, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.OffLineFileInfo paramOffLineFileInfo, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList paramArrayList) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void b() {}
  
  protected void b(Object paramObject) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void b(boolean paramBoolean, String paramString) {}
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  protected void c() {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  protected void d() {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void d(boolean paramBoolean, String paramString) {}
  
  protected void e() {}
  
  protected void e(boolean paramBoolean) {}
  
  protected void f(boolean paramBoolean) {}
  
  protected void g(boolean paramBoolean) {}
  
  protected void h(boolean paramBoolean) {}
  
  protected void i(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageObserver
 * JD-Core Version:    0.7.0.1
 */