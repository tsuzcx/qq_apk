package com.tencent.mobileqq.pic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dzr;
import dzs;
import dzt;
import dzu;
import dzv;
import dzw;
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
  public static final int b = 2;
  private static boolean jdField_b_of_type_Boolean = true;
  public static final int c = 3;
  private static boolean c = false;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  private static final int h = 1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public BaseStrategy a;
  private PicStatisticsManager jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager;
  private Timer jdField_a_of_type_JavaUtilTimer;
  PriorityBlockingQueue jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public AtomicInteger a;
  boolean jdField_a_of_type_Boolean = true;
  PriorityBlockingQueue jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  public PriorityBlockingQueue c;
  
  static
  {
    jdField_c_of_type_Boolean = false;
  }
  
  public PicPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_c_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject).addAction("android.intent.action.USER_PRESENT");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new dzw(paramQQAppInterface.a());
    paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    if (this.jdField_a_of_type_Boolean) {}
    for (localObject = new PreDownloadStrategyBeta();; localObject = new PreDownloadStrategyAlpha())
    {
      this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy = ((BaseStrategy)localObject);
      this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager = ((PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57));
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
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(paramMessageForPic);
        localPicReq = PicBusiManager.a(4, 2);
        PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
        if (localPicDownloadInfo != null) {
          localPicDownloadInfo.j = 1;
        }
        localPicReq.a(localPicDownloadInfo);
        localPicReq.a(paramMessageForPic);
        i = PicPreDownloadUtils.a();
        if ((jdField_b_of_type_Boolean) || (i == 0)) {
          break label152;
        }
        Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
        return;
      }
    }
    label152:
    ThreadManager.a().post(new dzt(this, localPicReq));
    Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (paramMessageForPic.hasBigFile())
        {
          Logger.a("PIC_TAG_PRELOAD", "handle", "hasBigFile,uniseq:" + paramMessageForPic.uniseq + ",priority:" + paramInt);
          PicPreDownloadUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic);
          return;
        }
        Logger.a("PIC_TAG_PRELOAD", "handle", "START uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt);
        PicReq localPicReq = PicBusiManager.a(5, 2);
        PicDownloadInfo localPicDownloadInfo = paramMessageForPic.getPicDownloadInfo();
        if (localPicDownloadInfo != null)
        {
          localPicDownloadInfo.j = 1;
          localPicReq.k = paramInt;
          localPicDownloadInfo.e = "chatimg";
        }
        localPicReq.a(localPicDownloadInfo);
        localPicReq.a(paramMessageForPic);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
        Logger.a("PIC_TAG_PRELOAD", "handle", "requestQueue.add(bigReq) OK");
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.b(paramMessageForPic);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() < 1)
        {
          d();
          Logger.a("PIC_TAG_PRELOAD", "handle", "END uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt);
        }
        else
        {
          Logger.a("PIC_TAG_PRELOAD", "add picreq big", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt);
        }
      }
      finally {}
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      c(paramMessageRecord, paramInt1, paramInt2, paramInt3);
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        int i = 0;
        while (i < paramMessageRecord.msgElemList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.msgElemList.get(i);
          if ((localMessageRecord instanceof MessageForPic))
          {
            if (((MessageForPic)localMessageRecord).time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, paramMessageRecord);
            }
            c(localMessageRecord, paramInt1, paramInt2, paramInt3);
          }
          i += 1;
        }
      }
    }
  }
  
  private boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    PicReq localPicReq;
    while (localIterator.hasNext())
    {
      localPicReq = (PicReq)localIterator.next();
      if ((paramMessageForPic.uuid.equals(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g)) && (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i)) {
        return true;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      localPicReq = (PicReq)localIterator.next();
      if ((paramMessageForPic.uuid.equals(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g)) && (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i))
      {
        Logger.a("PIC_TAG_PRELOAD", "filter", "old priority:" + localPicReq.k + ",new priority:" + paramInt + "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
        localPicReq.k = paramInt;
        return true;
      }
    }
    return false;
  }
  
  private void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3)
  {
    ThreadManager.a().postDelayed(new dzs(this, paramMessageRecord, paramInt1, paramInt2, paramInt3), 100L);
  }
  
  private void c(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
    if ((localMessageForPic.path == null) && (localMessageForPic.uuid == null) && (localMessageForPic.md5 == null)) {}
    while (paramMessageRecord.isSendFromLocal()) {
      return;
    }
    Logger.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + localMessageForPic.uniseq + ",suMsgId:" + localMessageForPic.subMsgId + ",priority:" + paramInt3);
    if (a(localMessageForPic, paramInt3))
    {
      Logger.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + localMessageForPic.uniseq + ",suMsgId:" + localMessageForPic.subMsgId + "priority:" + paramInt3);
      return;
    }
    if ((paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isSend()))
    {
      SessionInfo localSessionInfo = MultiMsgManager.a().a();
      if (localSessionInfo != null)
      {
        paramInt2 = localSessionInfo.jdField_a_of_type_Int;
        paramMessageRecord = localSessionInfo.jdField_a_of_type_JavaLangString;
      }
    }
    int j;
    for (;;)
    {
      paramInt2 = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt2, paramMessageRecord);
      j = PicPreDownloadUtils.a();
      if ((j == 0) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramMessageRecord) != 2)) {
        break;
      }
      Logger.a("PIC_TAG_PRELOAD", "num group", "skip uniseq:" + localMessageForPic.uniseq + ",suMsgId:" + localMessageForPic.subMsgId + "priority:" + paramInt3);
      return;
      paramInt2 = paramMessageRecord.istroop;
      paramMessageRecord = paramMessageRecord.frienduin;
      continue;
      paramInt2 = paramMessageRecord.istroop;
      paramMessageRecord = paramMessageRecord.frienduin;
    }
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(paramInt2, j);
    if ((paramMessageRecord[0] != 0) && ((paramInt1 & 0x1) == 1))
    {
      paramInt2 = 1;
      if ((paramMessageRecord[1] == 0) || ((paramInt1 & 0x2) != 2)) {
        break label442;
      }
    }
    label442:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt2 != 0) {
        a(localMessageForPic);
      }
      if (paramInt1 != 0) {
        a(localMessageForPic, paramInt3);
      }
      Logger.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + localMessageForPic.uniseq + ",suMsgId:" + localMessageForPic.subMsgId + ",priority:" + paramInt3);
      return;
      paramInt2 = 0;
      break;
    }
  }
  
  private void e()
  {
    Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = PicPreDownloadUtils.a();
    if ((!jdField_b_of_type_Boolean) && (i != 0))
    {
      Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    if (localIterator.hasNext())
    {
      localObject = (PicReq)localIterator.next();
      ThreadManager.a().post(new dzu(this, (PicReq)localObject));
      if (((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null) {
        break label158;
      }
    }
    label158:
    for (Object localObject = "uniseq:" + ((PicReq)localObject).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a;; localObject = "")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject);
      break;
      this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      Logger.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public int a(MessageForPic paramMessageForPic)
  {
    Iterator localIterator = this.jdField_c_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    PicReq localPicReq;
    while (localIterator.hasNext())
    {
      localPicReq = (PicReq)localIterator.next();
      if ((paramMessageForPic.uuid.equals(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g)) && (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i)) {
        return localPicReq.k;
      }
    }
    localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    while (localIterator.hasNext())
    {
      localPicReq = (PicReq)localIterator.next();
      if ((paramMessageForPic.uuid.equals(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g)) && (paramMessageForPic.subMsgId == localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i)) {
        return localPicReq.k;
      }
    }
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    Logger.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new dzr(this), 60000L);
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy instanceof PreDownloadStrategyBeta)) {
      ((PreDownloadStrategyBeta)this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy).b(paramMessageForPic, paramLong);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if (!a()) {}
    while (((BaseStrategy.h != 1L) && (BaseStrategy.h != 0L)) || ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg)))) {
      return;
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
      localMessageForPic.getReportInfo().jdField_f_of_type_Int = PicPreDownloadUtils.a();
      localMessageForPic.getReportInfo().a = System.currentTimeMillis();
      localMessageForPic.getReportInfo().e = 0;
    }
    a(paramMessageRecord, paramInt, 1, 202);
    ChatImageDownloader.a(paramMessageRecord);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
        PicReq localPicReq;
        if (localIterator.hasNext())
        {
          localPicReq = (PicReq)localIterator.next();
          if ((localPicReq != null) && (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo != null))
          {
            boolean bool;
            if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_Int == 1)
            {
              bool = true;
              int i = URLDrawableHelper.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.e, bool);
              String str = TransFileController.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_JavaLangString, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.g, i);
              if ((paramString != null) && (paramString.equals(str))) {
                if (localPicReq != null)
                {
                  this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.remove(localPicReq);
                  Logger.a("PIC_TAG_PRELOAD", "", "dropPicreq", "uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",key:" + paramString + ",cmd:" + localPicReq.i);
                }
              }
            }
            else
            {
              bool = false;
            }
          }
        }
        else
        {
          localPicReq = null;
        }
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131363052), "qqsetting_auto_receive_pic_key", true);
    if ((NetworkUtil.b(BaseApplication.getContext()) == 1) || (bool2)) {}
    for (int i = 1;; i = 0)
    {
      if (("1".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.common, "UseLocalFlowSet"))) || (i != 0)) {
        bool1 = true;
      }
      return bool1;
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
    if (!a()) {}
    while (((BaseStrategy.h != 2L) && (BaseStrategy.h != 0L)) || ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg)))) {
      return;
    }
    b(paramMessageRecord, paramInt, 2, 201);
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    int k;
    PicReq localPicReq;
    int i;
    for (;;)
    {
      try
      {
        Logger.a("PIC_TAG_PRELOAD", "consume", "START");
        if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          Logger.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
          return;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1)
        {
          Logger.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
          continue;
        }
        k = PicPreDownloadUtils.a();
      }
      finally {}
      if ((!jdField_b_of_type_Boolean) && (k != 0))
      {
        Logger.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + k);
      }
      else
      {
        localPicReq = (PicReq)this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.poll();
        Logger.a("PIC_TAG_PRELOAD", "consume", "requestQueue.poll() ok");
        if (localPicReq == null) {
          break label605;
        }
        if (localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo == null)
        {
          Logger.b("PIC_TAG_PRELOAD", "drop picreq", "downinfo == null");
        }
        else
        {
          i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b, localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.c);
          if (!this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, i, k)) {
            if (localPicReq.i == 4)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(i, k)[0] != 0) {
                break;
              }
              Logger.a("PIC_TAG_PRELOAD", "drop picreq thumb,networkchanged", "uintype:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b + ",networkType:" + k + ",uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
            }
            else
            {
              if (this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(i, k)[1] != 0) {
                break;
              }
              Logger.a("PIC_TAG_PRELOAD", "drop picreq big,networkchanged", "uintype:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b + ",networkType:" + k + ",uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a);
            }
          }
        }
      }
    }
    this.jdField_c_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localPicReq);
    if (localPicReq.i == 5) {}
    for (String str = " big";; str = " thumb")
    {
      Logger.a("PIC_TAG_PRELOAD", "run picreq" + str, "uniseq:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + "subMsgId:" + localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.i + ",priority:" + localPicReq.k);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
      if ((localPicReq.i == 5) && (!new File(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b()).exists()))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicBaseStrategy.a(localPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.d, k);
        int j = -2147483648;
        i = j;
        if (localPicReq != null)
        {
          i = j;
          if (localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) {
            i = PicPreDownloadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.istroop, localPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicStatisticsManager.a(k, i);
      }
      ThreadManager.a().post(new dzv(this, localPicReq));
      label605:
      Logger.a("PIC_TAG_PRELOAD", "consume", "END");
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
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer.purge();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */