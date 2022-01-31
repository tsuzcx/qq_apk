package com.tencent.av.service;

import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import bim;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.AppService;

public class QQServiceForAV
  extends AppService
  implements Observer
{
  static final String jdField_a_of_type_JavaLangString = "QQServiceForAV";
  public int a;
  public long a;
  public final RemoteCallbackList a;
  final IQQServiceForAV.Stub jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub = new bim(this);
  public QQAppInterface a;
  public String b = null;
  public String c = null;
  public String d = null;
  
  public QQServiceForAV()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 9223372036854775807L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidOsRemoteCallbackList = new RemoteCallbackList();
  }
  
  public AppRuntime a()
  {
    return this.app;
  }
  
  void a(int paramInt, String paramString1, String paramString2)
  {
    int j = this.jdField_a_of_type_AndroidOsRemoteCallbackList.beginBroadcast();
    try
    {
      RecvMsg localRecvMsg = new RecvMsg();
      int i = 0;
      if (i < j)
      {
        localRecvMsg.a(paramInt);
        localRecvMsg.a(this.c);
        localRecvMsg.d(this.b);
        localRecvMsg.b(paramString2);
        localRecvMsg.e(paramString1);
        if (this.jdField_a_of_type_Int == 3000) {}
        for (String str = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub.a(1004, paramString2, this.b);; str = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub.a(this.jdField_a_of_type_Int, paramString2, this.d))
        {
          localRecvMsg.c(str);
          ((IQQServiceCallback)this.jdField_a_of_type_AndroidOsRemoteCallbackList.getBroadcastItem(i)).a(localRecvMsg);
          i += 1;
          break;
        }
      }
      return;
    }
    catch (RemoteException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "callBack RemoteException", paramString1);
      }
      this.jdField_a_of_type_AndroidOsRemoteCallbackList.finishBroadcast();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onBind");
    }
    return this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV$Stub;
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onCreate");
    }
    if ((a() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
    }
    super.onCreate();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onDestroy");
    }
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onStartCommand");
    }
    if ((a() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        this.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      }
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onUnbind");
    }
    return super.onUnbind(paramIntent);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {}
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof ChatMessage));
        localMessageRecord = (MessageRecord)paramObject;
      } while (localMessageRecord.isSendFromLocal());
      if ((this.c == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)a());
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.c = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        }
      }
    } while ((TextUtils.isEmpty(this.c)) || (TextUtils.isEmpty(this.b)));
    long l1 = this.jdField_a_of_type_Long;
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.b, this.jdField_a_of_type_Int);
    int i = 0;
    long l2;
    String str1;
    int j;
    int k;
    for (;;)
    {
      if ((localList != null) && (i < localList.size()))
      {
        paramObservable = (MessageRecord)localList.get(i);
        if (paramObservable == null)
        {
          i += 1;
        }
        else
        {
          l2 = paramObservable.time;
          paramObject = paramObservable.selfuin;
          String str2 = paramObservable.frienduin;
          str1 = paramObservable.senderuin;
          j = (int)paramObservable.vipBubbleID;
          if ((l2 >= this.jdField_a_of_type_Long) && (paramObject != null) && (str2 != null) && (str1 != null) && (this.c.equals(paramObject)) && (this.b.equals(str2)) && (!str1.equals(paramObject)))
          {
            k = paramObservable.msgtype;
            switch (k)
            {
            default: 
              paramObservable = null;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQServiceForAV", 2, "pos: " + i + ", vipBubbleId: " + j + ", time: " + l2 + ", msgtype: " + k + ", msg: " + paramObservable + ", senderUin: " + str1);
      }
      if (paramObservable != null) {
        a(j, paramObservable, str1);
      }
      if (l2 >= l1)
      {
        l1 = l2;
        break;
        paramObject = paramObservable.msg;
        paramObservable = paramObject;
        if (paramObject == null) {
          continue;
        }
        paramObservable = paramObject;
        if (paramObject.indexOf("http://maps.google.com/maps?q=") == -1) {
          continue;
        }
        paramObservable = getResources().getString(2131560140);
        continue;
        paramObservable = getResources().getString(2131560137);
        continue;
        paramObservable = getResources().getString(2131560138);
        continue;
        paramObservable = getResources().getString(2131560139);
        continue;
        paramObservable = getResources().getString(2131560141);
        continue;
        paramObservable = getResources().getString(2131560142);
        continue;
        paramObservable = (String)MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramObservable);
        continue;
        try
        {
          paramObservable = StructMsgFactory.a(localMessageRecord.msgData);
          if (paramObservable == null)
          {
            if (!QLog.isColorLevel()) {
              break label659;
            }
            QLog.d("QQServiceForAV", 2, "QQServiceForAV:getStructMsg is null");
            break label659;
          }
          paramObservable = paramObservable.mMsgBrief;
        }
        catch (Exception paramObservable)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, "QQServiceForAV:getStructMsg error", paramObservable);
          }
          paramObservable = null;
        }
        continue;
        this.jdField_a_of_type_Long = (l1 + 1L);
        return;
      }
      break;
      label659:
      paramObservable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV
 * JD-Core Version:    0.7.0.1
 */