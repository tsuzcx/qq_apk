package com.tencent.mobileqq.pic;

import acei;
import acfx;
import ajlc;
import akwz;
import akxe;
import akxj;
import akxl;
import akxo;
import akxq;
import akxv;
import akxz;
import akyd;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import aoiz;
import aokf;
import aooi;
import aoop;
import aqfw;
import aqiw;
import avfp;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class PicPreDownloader
  implements Manager
{
  public static boolean biC = true;
  static boolean cuX;
  ConcurrentLinkedQueue<PicPreDownRunner> D = new ConcurrentLinkedQueue();
  List<akxq> Es = Collections.synchronizedList(new LinkedList());
  List<akxq> Et = Collections.synchronizedList(new LinkedList());
  List<akxq> Eu = Collections.synchronizedList(new LinkedList());
  List<akxq> Ev = Collections.synchronizedList(new LinkedList());
  akxv jdField_a_of_type_Akxv;
  public akxz a;
  PriorityBlockingQueue<akxq> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  public PriorityBlockingQueue<akxq> b;
  MqqHandler b;
  public AtomicInteger bC = new AtomicInteger();
  BroadcastReceiver bw;
  AtomicBoolean dv = new AtomicBoolean(false);
  Runnable hl = new PicPreDownloader.1(this);
  QQAppInterface mApp;
  volatile int mRunningTaskNum = 0;
  public Map<String, Integer> mp = Collections.synchronizedMap(new HashMap());
  LinkedBlockingQueue<MessageForStructing> o = new LinkedBlockingQueue(100);
  
  public PicPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_MqqOsMqqHandler = ThreadManager.getSubThreadHandler();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.bw = new a(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.getApp().registerReceiver(this.bw, localIntentFilter);
    this.jdField_a_of_type_Akxz = new akxz();
    ThreadManager.post(new PicPreDownloader.2(this, paramQQAppInterface), 5, null, true);
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Akxv = ((akxv)this.mApp.getManager(73));
    akxe.a("PIC_TAG_PRELOAD", "onInit", "Finished");
  }
  
  private void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramMessageForPic.path == null) && (paramMessageForPic.uuid == null) && (paramMessageForPic.md5 == null))
    {
      akxe.a("PIC_TAG_PRELOAD", "add", "pic.path == null && pic.uuid == null && pic.md5 == null");
      d(paramMessageForPic, -3);
      return;
    }
    if (a(paramMessageForPic, paramInt2))
    {
      akxe.a("PIC_TAG_PRELOAD", "filter", "skip uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + "priority:" + paramInt2);
      return;
    }
    if (paramBoolean1) {
      q(paramMessageForPic);
    }
    if ((paramInt1 & 0x2) == 2)
    {
      if (paramInt3 == 1) {
        break label191;
      }
      akxe.a("PIC_TAG_PRELOAD", "add", "The troop is not MSG_FILTER_VALUE.MSG_FILTER_OPEN");
      d(paramMessageForPic, -7);
    }
    label317:
    for (;;)
    {
      akxe.a("PIC_TAG_PRELOAD", "add", "FINISH uniseq:" + paramMessageForPic.uniseq + ",suMsgId:" + paramMessageForPic.subMsgId + ",priority:" + paramInt2);
      return;
      label191:
      if (this.jdField_a_of_type_Akxz.f(paramMessageForPic))
      {
        if ((b(paramMessageForPic, paramInt2)) && (paramBoolean2))
        {
          if (this.bC.get() < 1) {
            consume();
          }
          for (;;)
          {
            if ((!paramMessageForPic.checkGif()) || (paramMessageForPic.isSendFromLocal()) || (paramInt2 != 5) || (paramMessageForPic.hasThumbFile())) {
              break label317;
            }
            akxe.a("PIC_TAG_PRELOAD", "addBigPicRequest", "not hasThumbFile,download thumb,uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt2);
            q(paramMessageForPic);
            break;
            akxe.a("PIC_TAG_PRELOAD", "add", "handlingNum.get() >= MAX_HANDLING_THREADS");
          }
        }
      }
      else {
        d(paramMessageForPic, -6);
      }
    }
  }
  
  private void a(MessageForStructing paramMessageForStructing, int paramInt)
  {
    if ((!biC) && (paramInt != 0)) {
      try
      {
        this.o.add(paramMessageForStructing);
        akxe.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload,networkType:" + paramInt);
        return;
      }
      catch (Exception paramMessageForStructing)
      {
        for (;;)
        {
          akxe.a("PIC_TAG_PRELOAD", "structMsg-screenOFF", "no preDownload exception happened,networkType:" + paramInt);
        }
      }
    }
    String str = "addToQuene-MessageForStructing" + ", msgSeq = " + paramMessageForStructing.shmsgseq;
    a(new PicPreDownRunner(new PicPreDownloader.6(this, paramMessageForStructing), str));
    akxe.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish preDownload uniseq =" + paramMessageForStructing.uniseq);
  }
  
  private void a(PicPreDownRunner paramPicPreDownRunner)
  {
    this.D.offer(paramPicPreDownRunner);
    runNext();
  }
  
  private void runNext()
  {
    if (this.mRunningTaskNum < 3)
    {
      PicPreDownRunner localPicPreDownRunner = (PicPreDownRunner)this.D.poll();
      if (localPicPreDownRunner != null)
      {
        this.mRunningTaskNum += 1;
        ThreadManager.excute(localPicPreDownRunner, 16, null, false);
      }
    }
  }
  
  public void NR(String paramString)
  {
    akxq localakxq = a(paramString, this.Es);
    if (localakxq != null)
    {
      akxe.M("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localakxq.a.uniseq + ",key:" + paramString + ",cmd:" + localakxq.dpE);
      return;
    }
    localakxq = a(paramString, this.Et);
    if (localakxq != null)
    {
      akxe.M("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localakxq.a.uniseq + ",key:" + paramString + ",cmd:" + localakxq.dpE);
      return;
    }
    localakxq = a(paramString, this.Eu);
    if (localakxq != null)
    {
      akxe.M("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localakxq.a.uniseq + ",key:" + paramString + ",cmd:" + localakxq.dpE);
      return;
    }
    localakxq = a(paramString, this.Ev);
    if (localakxq != null)
    {
      akxe.M("PIC_TAG_PRELOAD", "", "drop", "From AIORequests, uniseq:" + localakxq.a.uniseq + ",key:" + paramString + ",cmd:" + localakxq.dpE);
      return;
    }
    akxe.M("PIC_TAG_PRELOAD", "", "drop", "Cannot be found in the request stacks");
  }
  
  akxq a()
  {
    int i;
    synchronized (this.Es)
    {
      i = this.Es.size();
      akxq localakxq1;
      if (i > 0)
      {
        akxe.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from AIORequests");
        localakxq1 = (akxq)this.Es.get(i - 1);
        this.Es.remove(i - 1);
        return localakxq1;
      }
      synchronized (this.Et)
      {
        i = this.Et.size();
        if (i > 0)
        {
          akxe.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from C2CRequests");
          localakxq1 = (akxq)this.Et.get(i - 1);
          this.Et.remove(i - 1);
          return localakxq1;
        }
      }
    }
    synchronized (this.Eu)
    {
      i = this.Eu.size();
      if (i > 0)
      {
        akxe.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from DiscussionRequests");
        akxq localakxq2 = (akxq)this.Eu.get(i - 1);
        this.Eu.remove(i - 1);
        return localakxq2;
      }
    }
    synchronized (this.Ev)
    {
      i = this.Ev.size();
      if (i > 0)
      {
        akxe.a("PIC_TAG_PRELOAD", "getPicRequest", "get a pic request from GroupRequests");
        akxq localakxq3 = (akxq)this.Ev.get(i - 1);
        this.Ev.remove(i - 1);
        return localakxq3;
      }
    }
    akxe.a("PIC_TAG_PRELOAD", "getPicRequest", "cannot get any request");
    return null;
  }
  
  akxq a(String paramString, Collection<akxq> paramCollection)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (localIterator.hasNext())
        {
          akxq localakxq = (akxq)localIterator.next();
          if (localakxq.a == null) {
            continue;
          }
          if (localakxq.a.fileSizeFlag == 1)
          {
            bool = true;
            int i = aoop.n(localakxq.a.protocol, bool);
            String str = aooi.o(localakxq.a.md5, localakxq.a.uuid, i);
            if ((paramString == null) || (!paramString.equals(str))) {
              continue;
            }
            paramCollection.remove(localakxq);
            this.mp.remove(localakxq.a.uuid);
            d(localakxq.j, -5);
            return localakxq;
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  Collection<akxq> a(int paramInt)
  {
    akxe.a("PIC_TAG_PRELOAD", "getRequestsByPriority", "priority=" + paramInt);
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      return this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue;
    case 5: 
      return this.Es;
    case 4: 
      return this.Et;
    case 3: 
      return this.Eu;
    }
    return this.Ev;
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    as(paramMessageForPic);
    if ((akwz.Wn != 2L) && (akwz.Wn != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): PicAuDownTimePoint is not DOWNLOAD_POINT_AIO or DOWNLOAD_POINT_ALL");
      }
      d(paramMessageForPic, -2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): ");
    }
    a(paramMessageForPic, paramInt, 5);
  }
  
  void a(MessageForPic paramMessageForPic, int paramInt1, int paramInt2)
  {
    String str = "productAysnc";
    if (paramMessageForPic != null) {
      str = "productAysnc" + ", msgSeq = " + paramMessageForPic.shmsgseq;
    }
    a(new PicPreDownRunner(new PicPreDownloader.4(this, paramMessageForPic, paramInt1, paramInt2), str));
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong)
  {
    if ((this.jdField_a_of_type_Akxz instanceof akxz)) {
      this.jdField_a_of_type_Akxz.b(paramMessageForPic, paramLong);
    }
  }
  
  void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic)) {
      c((MessageForPic)paramMessageRecord, paramInt1, paramInt2);
    }
    do
    {
      for (;;)
      {
        return;
        if (!(paramMessageRecord instanceof MessageForMixedMsg)) {
          break;
        }
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        int i = 0;
        while (i < paramMessageRecord.msgElemList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.msgElemList.get(i);
          if ((localMessageRecord instanceof MessageForPic))
          {
            MessageForPic localMessageForPic = (MessageForPic)localMessageRecord;
            if (localMessageForPic.time == 0L) {
              MessageForMixedMsg.copyBaseInfoFromMixedToPic((MessageForPic)localMessageRecord, paramMessageRecord);
            }
            c(localMessageForPic, paramInt1, paramInt2);
          }
          i += 1;
        }
      }
    } while ((!(paramMessageRecord instanceof MessageForStructing)) || (!akyd.mIsOpen));
    c(paramMessageRecord, paramInt1, paramInt2);
  }
  
  boolean a(MessageForPic paramMessageForPic, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Integer localInteger = (Integer)this.mp.get(paramMessageForPic.uuid);
    if (localInteger == null)
    {
      akxe.a("PIC_TAG_PRELOAD", "filter", "uuid=" + paramMessageForPic.uuid + ", priority=" + paramInt + ", cannot be found in the PriorityMap");
      return bool2;
    }
    Collection localCollection = a(localInteger.intValue());
    akxe.a("PIC_TAG_PRELOAD", "filter", "priority: " + paramInt + ", uniseq: " + paramMessageForPic.uniseq + ", subMsgId:" + paramMessageForPic.subMsgId);
    if (localCollection == null)
    {
      akxe.a("PIC_TAG_PRELOAD", "filter", "originalRequests == null");
      return false;
    }
    Object localObject1 = null;
    label334:
    for (;;)
    {
      try
      {
        Iterator localIterator = localCollection.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (akxq)localIterator.next();
          if (paramMessageForPic.subMsgId != ((akxq)localObject2).a.subMsgId) {
            break label334;
          }
          bool1 = true;
          localObject1 = localObject2;
          break label334;
        }
        if ((!bool1) || (paramInt <= localInteger.intValue()))
        {
          akxe.a("PIC_TAG_PRELOAD", "filter", "No need to update the picReq");
          return bool1;
        }
      }
      finally {}
      Object localObject2 = a(paramInt);
      bool2 = bool1;
      if (localObject2 == null) {
        break;
      }
      localObject1.dpG = localObject1.priority;
      localObject1.priority = paramInt;
      localCollection.remove(localObject1);
      ((Collection)localObject2).add(localObject1);
      this.mp.put(paramMessageForPic.uuid, Integer.valueOf(paramInt));
      akxe.a("PIC_TAG_PRELOAD", "filter", "update the picReq");
      return bool1;
    }
  }
  
  void as(MessageRecord paramMessageRecord)
  {
    int i = akxo.Hi();
    akxe.a("PIC_TAG_PRELOAD", "setMessageRecordNetworkType", "network=" + i);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).preDownNetworkType = i;
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).msgElemList.iterator();
        while (paramMessageRecord.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            ((MessageForPic)localMessageRecord).preDownNetworkType = i;
          }
        }
      }
    }
  }
  
  public boolean asS()
  {
    boolean bool1 = false;
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131697129), "qqsetting_auto_receive_pic_key", true);
    if ((aqiw.getNetworkType(BaseApplication.getContext()) == 1) || (bool2)) {}
    for (int i = 1;; i = 0)
    {
      if ((akwz.cuM) || (i != 0)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public int b(MessageForPic paramMessageForPic)
  {
    Integer localInteger = (Integer)this.mp.get(paramMessageForPic.uuid);
    if (localInteger == null) {
      return -1;
    }
    Collection localCollection = a(localInteger.intValue());
    if (localCollection != null) {
      try
      {
        Iterator localIterator = localCollection.iterator();
        while (localIterator.hasNext())
        {
          akxq localakxq = (akxq)localIterator.next();
          if (paramMessageForPic.subMsgId == localakxq.a.subMsgId)
          {
            akxe.a("PIC_TAG_PRELOAD", "getPriority", "uuid: " + paramMessageForPic.uuid + " subMsgId: " + paramMessageForPic.subMsgId);
            int i = localInteger.intValue();
            return i;
          }
        }
      }
      finally {}
    }
    return -1;
  }
  
  akxq b()
  {
    int i;
    synchronized (this.Es)
    {
      i = this.Es.size();
      akxq localakxq1;
      if (i > 0)
      {
        akxe.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from AIORequests");
        localakxq1 = (akxq)this.Es.get(i - 1);
        return localakxq1;
      }
      synchronized (this.Et)
      {
        i = this.Et.size();
        if (i > 0)
        {
          akxe.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from C2CRequests");
          localakxq1 = (akxq)this.Et.get(i - 1);
          return localakxq1;
        }
      }
    }
    synchronized (this.Eu)
    {
      i = this.Eu.size();
      if (i > 0)
      {
        akxe.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from DiscussionRequests");
        akxq localakxq2 = (akxq)this.Eu.get(i - 1);
        return localakxq2;
      }
    }
    synchronized (this.Ev)
    {
      i = this.Ev.size();
      if (i > 0)
      {
        akxe.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "get a pic request from GroupRequests");
        akxq localakxq3 = (akxq)this.Ev.get(i - 1);
        return localakxq3;
      }
    }
    akxe.a("PIC_TAG_PRELOAD", "getPicRequestWithoutRemove", "cannot get any request");
    return null;
  }
  
  public void b(MessageForPic paramMessageForPic, int paramInt)
  {
    as(paramMessageForPic);
    if ((akwz.Wn != 2L) && (akwz.Wn != 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIO(): PicAuDownTimePoint is not DOWNLOAD_POINT_AIO or DOWNLOAD_POINT_ALL");
      }
      d(paramMessageForPic, -2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromAIODynamicPic(): ");
    }
    String str = "productFromAIODynamicPic";
    if (paramMessageForPic != null) {
      str = "productFromAIODynamicPic" + ", msgSeq = " + paramMessageForPic.shmsgseq;
    }
    a(new PicPreDownRunner(new PicPreDownloader.3(this, paramMessageForPic, paramInt), str));
  }
  
  void b(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    int n = 0;
    if ((paramMessageRecord instanceof MessageForPic)) {
      akxe.a("PIC_TAG_PRELOAD", "add", "START uniseq:" + ((MessageForPic)paramMessageRecord).uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + ",priority:" + paramInt2);
    }
    Object localObject;
    int i;
    int j;
    int k;
    if ((paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isSend()))
    {
      localObject = ajlc.a().a();
      if (localObject != null)
      {
        i = ((SessionInfo)localObject).cZ;
        localObject = ((SessionInfo)localObject).aTl;
        i = akxo.b(this.mApp, i, (String)localObject);
        j = akxo.Hi();
        k = this.mApp.cs((String)localObject);
        if ((j == 0) || (k != 2)) {
          break label241;
        }
        if ((paramMessageRecord instanceof MessageForPic)) {
          akxe.a("PIC_TAG_PRELOAD", "add", "num group skip, uniseq:" + paramMessageRecord.uniseq + ",suMsgId:" + ((MessageForPic)paramMessageRecord).subMsgId + "priority:" + paramInt2);
        }
      }
    }
    label241:
    do
    {
      return;
      i = paramMessageRecord.istroop;
      localObject = paramMessageRecord.frienduin;
      break;
      i = paramMessageRecord.istroop;
      localObject = paramMessageRecord.frienduin;
      break;
      localObject = this.jdField_a_of_type_Akxz.a(i, j);
      int m = n;
      boolean bool;
      if (localObject[0] != 0)
      {
        m = n;
        if ((paramInt1 & 0x1) == 1) {
          bool = true;
        }
      }
      n = localObject[1];
      akxe.a("PIC_TAG_PRELOAD", "add", "preDownThumb=" + bool + " preDownBig=" + n);
      if ((paramMessageRecord instanceof MessageForPic))
      {
        a((MessageForPic)paramMessageRecord, paramInt1, paramInt2, k, bool, n);
        return;
      }
    } while (!(paramMessageRecord instanceof MessageForStructing));
    a((MessageForStructing)paramMessageRecord, j);
  }
  
  boolean b(MessageForPic paramMessageForPic, int paramInt)
  {
    if (paramMessageForPic.hasBigFile())
    {
      akxe.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasBigFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists");
      }
      akxo.c(this.mApp, paramMessageForPic);
    }
    do
    {
      return false;
      if (((!acfx.W(paramMessageForPic)) && (!acei.W(paramMessageForPic))) || (aoiz.k(aoop.a(paramMessageForPic, 1, null).toString()) == null)) {
        break;
      }
      akxe.a("PIC_TAG_PRELOAD", "addBigPicRequest", "hasFlashPicFile, uniseq: " + paramMessageForPic.uniseq + ", priority: " + paramInt);
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the picture already exists");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "real download a big picture");
    }
    akxe.a("PIC_TAG_PRELOAD", "addBigPicRequest", " START uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority:" + paramInt);
    int i;
    akxq localakxq;
    Object localObject;
    List localList;
    if (akxo.Hi() == 0)
    {
      i = 1536;
      localakxq = akxj.a(6, i, 2);
      localObject = paramMessageForPic.getPicDownloadInfo();
      if (localObject != null)
      {
        ((akxl)localObject).dpC = 1;
        ((akxl)localObject).protocol = "chatimg";
      }
      localakxq.a(paramMessageForPic, (akxl)localObject);
      localList = null;
      localObject = "";
      i = akxo.b(this.mApp, paramMessageForPic.istroop, paramMessageForPic.frienduin);
      if (paramInt != 5) {
        break label517;
      }
      localList = this.Es;
      localakxq.priority = 5;
      localObject = "AIORequests";
      switch (i)
      {
      default: 
        localakxq.dpG = 2;
      }
    }
    for (;;)
    {
      if (localList != null)
      {
        akxe.a("PIC_TAG_PRELOAD", "addBigPicRequest", "successfully to add the pic request to " + (String)localObject);
        localList.add(localakxq);
        dDT();
        this.mp.put(localakxq.a.uuid, Integer.valueOf(localakxq.priority));
      }
      akxe.a("PIC_TAG_PRELOAD", "addBigPicRequest", "END uniseq: " + paramMessageForPic.uniseq + ", suMsgId: " + paramMessageForPic.subMsgId + ", priority: " + paramInt);
      return true;
      i = 1537;
      break;
      localakxq.dpG = 4;
      continue;
      localakxq.dpG = 3;
      continue;
      label517:
      if (paramInt == 1) {
        switch (i)
        {
        default: 
          localList = this.Ev;
          localakxq.priority = 2;
          localakxq.dpG = localakxq.priority;
          localObject = "GroupRequests";
          break;
        case 3: 
          localList = this.Et;
          localakxq.priority = 4;
          localakxq.dpG = localakxq.priority;
          localObject = "C2CRequests";
          break;
        case 2: 
          localList = this.Eu;
          localakxq.priority = 3;
          localakxq.dpG = localakxq.priority;
          localObject = "DiscussionRequests";
        }
      }
    }
  }
  
  void c(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramMessageRecord.isSendFromLocal())
    {
      akxe.a("PIC_TAG_PRELOAD", "add", "MessageRecord isSendFromLocal");
      return;
    }
    b(paramMessageRecord, paramInt1, paramInt2);
  }
  
  public void consume()
  {
    akxe.a("PIC_TAG_PRELOAD", "consume", "START");
    if (!this.dv.get()) {
      akxe.a("PIC_TAG_PRELOAD", "consume", "!mIsPicPreloadSuitable.get() failed");
    }
    int k;
    akxq localakxq;
    int i;
    int j;
    do
    {
      do
      {
        return;
        if (this.bC.get() >= 1)
        {
          akxe.a("PIC_TAG_PRELOAD", "consume", "handlingNum.get() >= MAX_HANDLING_THREADS");
          return;
        }
        localObject = b();
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((akxq)localObject).j != null)
          {
            bool1 = bool2;
            if (((akxq)localObject).j.thumbWidthHeightDP != null)
            {
              bool1 = ((akxq)localObject).j.thumbWidthHeightDP.useCustomSize();
              akxe.a("PIC_TAG_PRELOAD", "consume", "isBigImage=" + bool1);
            }
          }
        }
        k = akxo.Hi();
        if ((!biC) && (k != 0) && (!bool1))
        {
          akxe.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + k + ",isBigImage=" + bool1);
          return;
        }
        localakxq = a();
        if (localakxq == null) {
          break label911;
        }
        if (localakxq.a == null)
        {
          akxe.b("PIC_TAG_PRELOAD", "consume", "picReq.downinfo == null");
          d(localakxq.j, -4);
          return;
        }
        this.mp.remove(localakxq.a.uuid);
        i = akxo.b(this.mApp, localakxq.a.uinType, localakxq.a.peerUin);
        j = this.jdField_a_of_type_Akxz.a(localakxq.a.size, i, k, avfp.ns(localakxq.j.imageType));
        d(localakxq.j, j);
        if (j >= 0) {
          break;
        }
        akxe.a("PIC_TAG_PRELOAD", "consume", "overLimit and put request back to list, uinType=" + i + " networkType=" + k);
        localObject = a(localakxq.priority);
      } while (localObject == null);
      ((Collection)localObject).add(localakxq);
      this.mp.put(localakxq.a.uuid, Integer.valueOf(localakxq.priority));
      dDT();
      return;
      if ((localakxq.dpE != 6) || (this.jdField_a_of_type_Akxz.a(i, k)[1] != 0)) {
        break;
      }
      akxe.a("PIC_TAG_PRELOAD", "consume", "Network changed, put the picReq back to list, uintype:" + localakxq.a.uinType + ", networkType:" + k + ", uniseq:" + localakxq.a.uniseq);
      localObject = a(localakxq.priority);
    } while (localObject == null);
    ((Collection)localObject).add(localakxq);
    this.mp.put(localakxq.a.uuid, Integer.valueOf(localakxq.priority));
    dDT();
    return;
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localakxq);
    localakxq.dpG = localakxq.priority;
    localakxq.priority = 6;
    this.mp.put(localakxq.a.uuid, Integer.valueOf(6));
    if (localakxq.dpE == 6) {}
    for (Object localObject = " big";; localObject = " thumb")
    {
      akxe.a("PIC_TAG_PRELOAD", "run picreq" + (String)localObject, "uniseq:" + localakxq.a.uniseq + "subMsgId:" + localakxq.a.subMsgId + ",priority:" + localakxq.priority);
      this.bC.addAndGet(1);
      if ((localakxq.dpE == 6) && (!new File(localakxq.a.getFilePath()).exists()))
      {
        this.jdField_a_of_type_Akxz.aM(localakxq.a.size, k);
        j = -2147483648;
        i = j;
        if (localakxq != null)
        {
          i = j;
          if (localakxq.j != null) {
            i = akxo.b(this.mApp, localakxq.j.istroop, localakxq.j.frienduin);
          }
        }
        this.jdField_a_of_type_Akxv.ja(k, i);
      }
      String str = "consume";
      localObject = str;
      if (localakxq != null)
      {
        localObject = str;
        if (localakxq.j != null) {
          localObject = "consume" + ", msgSeq = " + localakxq.j.shmsgseq;
        }
      }
      a(new PicPreDownRunner(new PicPreDownloader.10(this, localakxq), (String)localObject));
      label911:
      akxe.a("PIC_TAG_PRELOAD", "consume", "END");
      return;
    }
  }
  
  void d(MessageRecord paramMessageRecord, int paramInt)
  {
    akxe.a("PIC_TAG_PRELOAD", "setNotPredownloadReason", "Reson=" + paramInt);
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).mNotPredownloadReason = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = ((MessageForMixedMsg)paramMessageRecord).msgElemList.iterator();
        while (paramMessageRecord.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramMessageRecord.next();
          if ((localMessageRecord instanceof MessageForPic)) {
            ((MessageForPic)localMessageRecord).mNotPredownloadReason = paramInt;
          }
        }
      }
    }
  }
  
  public void dDQ()
  {
    this.dv.set(false);
    akxe.a("PIC_TAG_PRELOAD", "picPreDownloadOff", "mIsPicPreloadSuitable:" + this.dv.get());
    if ((this.jdField_b_of_type_MqqOsMqqHandler != null) && (this.hl != null))
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.hl);
      this.jdField_b_of_type_MqqOsMqqHandler.postDelayed(this.hl, 60000L);
    }
  }
  
  public void dDR()
  {
    this.dv.set(true);
    akxe.a("PIC_TAG_PRELOAD", "picPreDownloadOn", "mIsPicPreloadSuitable:" + this.dv.get());
    consume();
  }
  
  public void dDS()
  {
    try
    {
      int i = this.Es.size();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): AIORequests size=" + i);
      }
      ThreadManager.post(new PicPreDownloader.5(this, i), 5, null, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): exception=" + localException.getMessage());
    }
  }
  
  void dDT()
  {
    Object localObject1;
    if (this.Es.size() + this.Et.size() + this.Eu.size() + this.Ev.size() > this.jdField_a_of_type_Akxz.Y.longValue()) {
      localObject1 = null;
    }
    for (;;)
    {
      synchronized (this.Ev)
      {
        if (this.Ev.size() > 0)
        {
          localObject1 = (akxq)this.Ev.remove(0);
          if (localObject1 != null)
          {
            this.mp.remove(((akxq)localObject1).a.uuid);
            localObject1 = this.jdField_a_of_type_Akxz;
            ((akxz)localObject1).afp += 1L;
            akxe.a("PIC_TAG_PRELOAD", "checkRequestListSize", "over max request list size: " + this.jdField_a_of_type_Akxz.Y + ", remove a request");
          }
          return;
        }
        synchronized (this.Eu)
        {
          if (this.Eu.size() > 0) {
            localObject1 = (akxq)this.Eu.remove(0);
          }
        }
      }
      synchronized (this.Et)
      {
        if (this.Et.size() > 0) {
          akxq localakxq1 = (akxq)this.Et.remove(0);
        }
      }
      synchronized (this.Es)
      {
        if (this.Es.size() > 0) {
          akxq localakxq2 = (akxq)this.Es.remove(0);
        }
      }
    }
  }
  
  void dDU()
  {
    akxe.a("PIC_TAG_PRELOAD", "consumeThumb", "START");
    int i = akxo.Hi();
    if ((!biC) && (i != 0))
    {
      akxe.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
      return;
    }
    Object localObject3 = this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.iterator();
    akxq localakxq;
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localakxq = (akxq)((Iterator)localObject3).next();
      localObject2 = "consumeAllThumbsInPendingQueue-thumbPendingQueue";
      localObject1 = localObject2;
      if (localakxq != null)
      {
        localObject1 = localObject2;
        if (localakxq.j != null) {
          localObject1 = "consumeAllThumbsInPendingQueue-thumbPendingQueue" + ", msgSeq = " + localakxq.j.shmsgseq;
        }
      }
      a(new PicPreDownRunner(new PicPreDownloader.8(this, localakxq), (String)localObject1));
      if (localakxq.a == null) {
        break label356;
      }
    }
    label356:
    for (Object localObject1 = "uniseq:" + localakxq.a.uniseq;; localObject1 = "")
    {
      akxe.a("PIC_TAG_PRELOAD", "run picreq thumb", (String)localObject1);
      break;
      this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.clear();
      localObject1 = this.o.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageForStructing)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject3 = "consumeAllThumbsInPendingQueue-structMsgPengdingQueue" + ", msgSeq = " + ((MessageForStructing)localObject2).shmsgseq;
          a(new PicPreDownRunner(new PicPreDownloader.9(this, (MessageForStructing)localObject2), (String)localObject3));
          akxe.a("PIC_TAG_PRELOAD", "structMsg-add ", "finish MessageForStructing preDownload uniseq =" + ((MessageForStructing)localObject2).uniseq);
        }
      }
      this.o.clear();
      akxe.a("PIC_TAG_PRELOAD", "consumeThumb", "END");
      return;
    }
  }
  
  public void e(MessageRecord paramMessageRecord, int paramInt)
  {
    as(paramMessageRecord);
    if (!asS())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): cannot predownload");
      }
      d(paramMessageRecord, -1);
    }
    Object localObject;
    do
    {
      return;
      if ((akwz.Wn != 1L) && (akwz.Wn != 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): PicAuDownTimePoint is not DOWNLOAD_POINT_MSG or DOWNLOAD_POINT_ALL");
        }
        d(paramMessageRecord, -2);
        return;
      }
      localObject = this.mApp.b();
      if ((!((QQMessageFacade)localObject).Op()) || (!((QQMessageFacade)localObject).oA().equals(paramMessageRecord.frienduin))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "The AIO is opening, does not need to predownload the thumb picture");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG_PRELOAD", 2, "productFromMsg(): ");
    }
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject = (MessageForPic)paramMessageRecord;
      ((MessageForPic)localObject).getReportInfo().dpT = akxo.Hi();
      ((MessageForPic)localObject).getReportInfo().afA = System.currentTimeMillis();
      ((MessageForPic)localObject).getReportInfo().dpS = 0;
    }
    a(paramMessageRecord, paramInt, 1);
    aokf.aG(paramMessageRecord);
  }
  
  public void onDestroy()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "onDestroy, receiver:" + this.bw);
      }
      this.mApp.getApp().unregisterReceiver(this.bw);
      this.bw = null;
      if ((this.jdField_b_of_type_MqqOsMqqHandler != null) && (this.hl != null)) {
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacks(this.hl);
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
  
  void q(MessageForPic paramMessageForPic)
  {
    if (paramMessageForPic.hasThumbFile()) {}
    akxq localakxq;
    for (;;)
    {
      return;
      if ((aqfw.mn(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {}
      for (int i = 1; i == 0; i = 0)
      {
        this.jdField_a_of_type_Akxv.r(paramMessageForPic);
        localakxq = akxj.a(5, 1536, 2);
        localObject = paramMessageForPic.getPicDownloadInfo();
        if (localObject != null) {
          ((akxl)localObject).dpC = 1;
        }
        localakxq.a(paramMessageForPic, (akxl)localObject);
        i = akxo.Hi();
        if ((biC) || (i == 0)) {
          break label152;
        }
        akxe.a("PIC_TAG_PRELOAD", "screenOFF", "no preDownload,networkType:" + i);
        this.jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue.add(localakxq);
        return;
      }
    }
    label152:
    String str = "consumeThumb";
    Object localObject = str;
    if (localakxq != null)
    {
      localObject = str;
      if (localakxq.j != null) {
        localObject = "consumeThumb" + ", msgSeq = " + localakxq.j.shmsgseq;
      }
    }
    a(new PicPreDownRunner(new PicPreDownloader.7(this, localakxq), (String)localObject));
    akxe.a("PIC_TAG_PRELOAD", "run picreq thumb", "uniseq:" + paramMessageForPic.uniseq + ",subMsgId:" + paramMessageForPic.subMsgId);
  }
  
  class PicPreDownRunner
    implements Runnable
  {
    Runnable mRunnable;
    String tag;
    
    PicPreDownRunner(Runnable paramRunnable, String paramString)
    {
      this.mRunnable = paramRunnable;
    }
    
    public void run()
    {
      this.mRunnable.run();
      PicPreDownloader localPicPreDownloader = PicPreDownloader.this;
      localPicPreDownloader.mRunningTaskNum -= 1;
      PicPreDownloader.a(PicPreDownloader.this);
    }
    
    public String toString()
    {
      return "PicPreDownloader ," + this.tag;
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    String mUinString;
    
    public a(String paramString)
    {
      this.mUinString = paramString;
    }
    
    public boolean aN(Context paramContext)
    {
      return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = false;
      paramIntent = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(paramIntent))
      {
        PicPreDownloader.cuX = PicPreDownloader.biC;
        if (!aN(paramContext)) {
          bool = true;
        }
        PicPreDownloader.biC = bool;
      }
      for (;;)
      {
        akxe.a("PIC_TAG_PRELOAD", "onReceive", "isScreenOn:" + PicPreDownloader.biC + ",lastScreenOnState:" + PicPreDownloader.cuX);
        if ((PicPreDownloader.cuX != PicPreDownloader.biC) || (PicPreDownloader.biC)) {
          break;
        }
        return;
        if ("android.intent.action.SCREEN_OFF".equals(paramIntent))
        {
          PicPreDownloader.cuX = PicPreDownloader.biC;
          PicPreDownloader.biC = false;
        }
        else if ("android.intent.action.USER_PRESENT".equals(paramIntent))
        {
          PicPreDownloader.cuX = PicPreDownloader.biC;
          PicPreDownloader.biC = true;
        }
      }
      ThreadManager.post(new PicPreDownloader.ScreenBroadcastReceiver.1(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader
 * JD-Core Version:    0.7.0.1
 */