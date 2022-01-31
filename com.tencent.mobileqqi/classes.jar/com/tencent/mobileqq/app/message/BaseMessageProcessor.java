package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.os.Bundle;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import fiv;
import fiw;
import fjo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public abstract class BaseMessageProcessor
{
  public static final int a = 480;
  public static final String a = "Q.msg.BaseMessageProcessor";
  public MessageHandler a;
  public QQAppInterface a;
  protected QQMessageFacade a;
  private List a;
  private final int b = 480000;
  private final int c = 450000;
  private final int d = 9;
  private final int e = 3;
  
  public BaseMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQAppInterface.a();
  }
  
  public BaseMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, QQMessageFacade paramQQMessageFacade, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler = paramMessageHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade = paramQQMessageFacade;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public fjo a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return null;
  }
  
  public abstract List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext);
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((ProcessorObserver)localIterator.next()).b(paramInt, paramBoolean, paramObject);
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(ProcessorObserver paramProcessorObserver)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramProcessorObserver);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramToServiceMsg.extraData.putLong("msgSeq", paramLong);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        paramToServiceMsg.setNeedRemindSlowNetwork(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg);
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((ProcessorObserver)localIterator.next()).a(getClass().getSimpleName(), paramString, paramBoolean1, paramInt, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, List arg3, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = MsgProxyUtils.a(???, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((ProcessorObserver)localIterator.next()).a(getClass().getSimpleName(), paramString, paramBoolean1, i, paramBoolean2, paramBoolean3);
      }
    }
  }
  
  public void a(ArrayList paramArrayList1, ArrayList paramArrayList2, boolean paramBoolean)
  {
    if (paramArrayList1.size() > 0)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramArrayList1.next();
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, paramBoolean)) {
          paramArrayList2.add(localMessageRecord);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong, fiw paramfiw)
  {
    int i;
    if (paramLong == 0L)
    {
      i = MobileQQService.c;
      MobileQQService.c = i + 1;
      paramLong = i;
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      if (!paramBoolean1)
      {
        paramfiw = paramfiw.a();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "processRequest cmd=" + paramfiw.getServiceCmd() + ",reqSeq=" + paramLong);
        }
        a(paramfiw, paramLong, paramBoolean2, paramBoolean3);
        return;
      }
      SendMessageHandler localSendMessageHandler = new SendMessageHandler();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramLong, localSendMessageHandler);
      i = 0;
      while (i < 9)
      {
        localSendMessageHandler.a(new fiv(this, paramfiw, paramLong, l, paramBoolean2, paramBoolean3));
        i += 1;
      }
      i = 0;
      label162:
      if (i < 3) {
        if (i != 0) {
          break label215;
        }
      }
      label215:
      for (paramLong = 480000L;; paramLong = (3 - i) * 480000 / 3 - i * 2000)
      {
        l = 480000 * i / 3;
        localSendMessageHandler.getClass();
        localSendMessageHandler.a(l, paramLong, "period");
        i += 1;
        break label162;
        break;
      }
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord, paramBoolean);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        ((ProcessorObserver)localIterator.next()).c(paramInt, paramBoolean, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageProcessor
 * JD-Core Version:    0.7.0.1
 */