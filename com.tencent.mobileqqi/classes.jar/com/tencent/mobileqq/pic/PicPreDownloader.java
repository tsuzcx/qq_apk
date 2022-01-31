package com.tencent.mobileqq.pic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gih;
import gii;
import gij;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager.ConfigType;

public class PicPreDownloader
  implements Manager
{
  public static final int a = 1;
  public static AtomicInteger a;
  public static final int b = 2;
  private static boolean jdField_b_of_type_Boolean = false;
  public static final int c = 3;
  public static PriorityBlockingQueue c;
  private static boolean c = false;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  private static final int h = 1;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public BaseStrategy a;
  PriorityBlockingQueue jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  public AtomicBoolean a;
  boolean jdField_a_of_type_Boolean = true;
  PriorityBlockingQueue jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  
  static
  {
    jdField_c_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Boolean = false;
  }
  
  public PicPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new gij(paramQQAppInterface.a());
    paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = new PreDownloadStrategyBeta();; localObject = new PreDownloadStrategyAlpha())
    {
      this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy = ((BaseStrategy)localObject);
      this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "onInit");
      }
      return;
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    PicReq localPicReq;
    for (;;)
    {
      return;
      if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {}
      for (int i = 1; i == 0; i = 0)
      {
        localPicReq = PicBusiManager.a(4, 2);
        PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
        if (localPicDownloadInfo != null) {
          localPicDownloadInfo.j = 1;
        }
        localPicReq.a(localPicDownloadInfo);
        i = PicPreDownloadUtils.a();
        if ((jdField_b_of_type_Boolean) || (i == 0)) {
          break label138;
        }
        Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
        return;
      }
    }
    label138:
    PicBusiManager.a(localPicReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  private boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    Iterator localIterator = jdField_c_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    PicReq localPicReq;
    while (localIterator.hasNext())
    {
      localPicReq = (PicReq)localIterator.next();
      if ((paramMessageForPic.uuid.equals(localPicReq.a.g)) && (paramMessageForPic.subMsgId == localPicReq.a.i)) {
        return true;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      localPicReq = (PicReq)localIterator.next();
      if ((paramMessageForPic.uuid.equals(localPicReq.a.g)) && (paramMessageForPic.subMsgId == localPicReq.a.i))
      {
        Logger.a("PIC_TAG_PRELOAD", "filter", "old priority:" + localPicReq.j + ",new priority:" + paramInt + "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
        localPicReq.j = paramInt;
        return true;
      }
    }
    return false;
  }
  
  private void c(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 1;
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131563423), "qqsetting_auto_receive_pic_key", true);
    int j;
    int i;
    if ((NetworkUtil.b(BaseApplication.getContext()) == 1) || (bool))
    {
      j = 1;
      i = k;
      if (!"1".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "UseLocalFlowSet")))
      {
        if (j == 0) {
          break label105;
        }
        i = k;
      }
      label77:
      if (!(paramMessageRecord instanceof MessageForPic)) {
        break label111;
      }
      if (i != 0) {
        b(paramMessageRecord, paramInt1, paramInt2, paramInt3);
      }
    }
    for (;;)
    {
      return;
      j = 0;
      break;
      label105:
      i = 0;
      break label77;
      label111:
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        k = paramMessageRecord.msgElemList.size();
        j = 0;
        while (j < k)
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.msgElemList.get(j);
          if ((localMessageRecord instanceof MessageForPic))
          {
            if (((MessageForPic)localMessageRecord).time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, paramMessageRecord);
            }
            if (i != 0) {
              b(localMessageRecord, paramInt1, paramInt2, paramInt3);
            }
          }
          j += 1;
        }
      }
    }
  }
  
  private void e()
  {
    int i = PicPreDownloadUtils.a();
    if ((!jdField_b_of_type_Boolean) && (i != 0)) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    if (localIterator.hasNext())
    {
      localObject = (PicReq)localIterator.next();
      PicBusiManager.a((PicReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (((PicReq)localObject).a == null) {
        break label102;
      }
    }
    label102:
    for (Object localObject = "uniseq:" + ((PicReq)localObject).a.a;; localObject = "")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject);
      break;
      this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    new Timer().schedule(new gih(this), 60000L);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (paramMessageForPic.hasBigFile())
        {
          Logger.a("PIC_TAG_PRELOAD", "handle", "hasBigFile,uniseq:" + paramMessageForPic.uniseq + ",priority:" + paramInt2);
          PicPreDownloadUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
          return;
        }
        localObject = PicBusiManager.a(paramInt1, 2);
        PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
        if (paramInt1 == 5)
        {
          paramInt1 = 1;
          if (localPicDownloadInfo != null)
          {
            localPicDownloadInfo.j = 1;
            ((PicReq)localObject).j = paramInt2;
            localPicDownloadInfo.e = "chatimg";
          }
          ((PicReq)localObject).a(localPicDownloadInfo);
          ((PicReq)localObject).a(paramMessageForPic);
          this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localObject);
          if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1) {
            break;
          }
          d();
        }
        else
        {
          paramInt1 = 0;
        }
      }
      finally {}
    }
    if (paramInt1 != 0) {}
    for (Object localObject = " big";; localObject = " thumb")
    {
      Logger.a("PIC_TAG_PRELOAD", "add picreq" + (String)localObject, "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt2);
      break;
    }
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy instanceof PreDownloadStrategyBeta)) {
      ((PreDownloadStrategyBeta)this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy).b(paramMessageForPic, paramLong);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    Object localObject;
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject).getReportInfo().jdField_f_of_type_Int = PicPreDownloadUtils.a();
      ((MessageForPic)localObject).getReportInfo().a = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().e = 0;
      b(paramMessageRecord, paramInt, 1, 202);
      ChatImageDownloader.a(paramMessageRecord);
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        localObject = (MessageForMixedMsg)paramMessageRecord;
        int j = ((MessageForMixedMsg)localObject).msgElemList.size();
        int i = 0;
        while (i < j)
        {
          MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject).msgElemList.get(i);
          if ((localMessageRecord instanceof MessageForPic))
          {
            if (((MessageForPic)localMessageRecord).time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, (MessageForMixedMsg)localObject);
            }
            b(localMessageRecord, paramInt, 1, 202);
            ChatImageDownloader.a(paramMessageRecord);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg))) {
      return;
    }
    ThreadManager.a().postDelayed(new gii(this, paramMessageRecord, paramInt1, paramInt2, paramInt3), 100L);
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    PicReq localPicReq;
    boolean bool;
    String str;
    do
    {
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localPicReq = (PicReq)localIterator.next();
      } while ((localPicReq == null) || (localPicReq.a == null));
      if (localPicReq.a.jdField_f_of_type_Int != 1) {
        break;
      }
      bool = true;
      int i = URLDrawableHelper.a(localPicReq.a.e, bool);
      str = TransFileController.a(localPicReq.a.jdField_f_of_type_JavaLangString, localPicReq.a.g, i);
    } while ((paramString == null) || (!paramString.equals(str)));
    for (;;)
    {
      if (localPicReq != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(localPicReq);
        Logger.a("PIC_TAG_PRELOAD", "", "dropPicreq", "uniseq:" + localPicReq.a.a + ",key:" + paramString + ",cmd:" + localPicReq.h);
      }
      return;
      bool = false;
      break;
      localPicReq = null;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    d();
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((BaseStrategy.d != 2L) && (BaseStrategy.d != 0L)) {}
    while ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg))) {
      return;
    }
    a(paramMessageRecord, paramInt, 2, 201);
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    MessageForPic localMessageForPic;
    try
    {
      localMessageForPic = (MessageForPic)paramMessageRecord;
      if ((localMessageForPic.path == null) && (localMessageForPic.uuid == null))
      {
        String str = localMessageForPic.md5;
        if (str != null) {}
      }
      for (;;)
      {
        return;
        if (!paramMessageRecord.isSendFromLocal())
        {
          Logger.a("PIC_TAG_PRELOAD", "add", "uniseq:" + localMessageForPic.uniseq + ",suMsgId:" + localMessageForPic.subMsgId + ",priority:" + paramInt3);
          if (!a(localMessageForPic, paramInt3)) {
            break;
          }
          Logger.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + localMessageForPic.uniseq + ",suMsgId:" + localMessageForPic.subMsgId + "priority:" + paramInt3);
        }
      }
      i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.istroop, paramMessageRecord.frienduin);
    }
    finally {}
    int i;
    int k = PicPreDownloadUtils.a();
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(i, k);
    if ((paramMessageRecord[0] != 0) && ((paramInt1 & 0x1) == 1)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        a(localMessageForPic);
      }
      if ((paramInt1 == 0) || ((BaseStrategy.d != 0L) && (BaseStrategy.d != paramInt2))) {
        break;
      }
      a(localMessageForPic, 5, paramInt3);
      break;
      i = 0;
      while ((paramMessageRecord[1] == 0) || ((paramInt1 & 0x2) != 2))
      {
        paramInt1 = 0;
        break;
      }
      paramInt1 = j;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
  }
  
  public void c(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((BaseStrategy.d != 3L) && (BaseStrategy.d != 0L)) {}
    while ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg))) {
      return;
    }
    c(paramMessageRecord, paramInt, 3, 200);
  }
  
  public void d()
  {
    int i;
    PicReq localPicReq;
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
        if (!bool) {
          return;
        }
        if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1) {
          continue;
        }
        i = PicPreDownloadUtils.a();
        if ((!jdField_b_of_type_Boolean) && (i != 0))
        {
          Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
          continue;
        }
        localPicReq = (PicReq)this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.poll();
      }
      finally {}
      if (localPicReq != null) {
        if (localPicReq.a == null)
        {
          Logger.b("PIC_TAG_PRELOAD", "drop picreq", "downinfo == null");
        }
        else
        {
          int j = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.a.b, localPicReq.a.c);
          if (!this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(localPicReq.a.d, j, i)) {
            if (localPicReq.h == 4)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(j, i)[0] != 0) {
                break;
              }
              Logger.a("PIC_TAG_PRELOAD", "drop picreq thumb,networkchanged", "uintype:" + localPicReq.a.b + ",networkType:" + i + ",uniseq:" + localPicReq.a.a);
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(j, i)[1] != 0) {
                break;
              }
              Logger.a("PIC_TAG_PRELOAD", "drop picreq big,networkchanged", "uintype:" + localPicReq.a.b + ",networkType:" + i + ",uniseq:" + localPicReq.a.a);
            }
          }
        }
      }
    }
    jdField_c_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
    if (localPicReq.h == 5) {}
    for (String str = " big";; str = " thumb")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq" + str, "uniseq:" + localPicReq.a.a + "subMsgId:" + localPicReq.a.i + ",priority:" + localPicReq.j);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((localPicReq.h == 5) && (!new File(localPicReq.a.b()).exists())) {
        this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(localPicReq.a.d, i);
      }
      PicBusiManager.a(localPicReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "onDestroy,receiver:" + this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */