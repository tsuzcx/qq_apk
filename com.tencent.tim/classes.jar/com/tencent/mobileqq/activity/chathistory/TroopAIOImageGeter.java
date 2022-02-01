package com.tencent.mobileqq.activity.chathistory;

import acei;
import acfx;
import acrb;
import agkf;
import ahav;
import ahbr;
import android.text.TextUtils;
import ansu;
import aqiu;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AccountNotMatchException;
import ton;
import top;
import xkl;
import xtj;
import xtm;

public class TroopAIOImageGeter
{
  long FH = 9223372036854775807L;
  long FI = 9223372036854775807L;
  long FJ = 9223372036854775807L;
  long Jy;
  a jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$a;
  b jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$b;
  int bFx = 3;
  int bWY = 1;
  int bWZ = 0;
  volatile boolean bjm = false;
  String friendUin;
  auru h;
  volatile boolean isLoading = false;
  boolean isMultiMsg = false;
  final List<AIORichMediaData> jl = Collections.synchronizedList(new LinkedList());
  String myUin;
  int sessionType;
  final List<ChatMessage> sn = Collections.synchronizedList(new LinkedList());
  
  public TroopAIOImageGeter(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.myUin = paramString1;
    this.friendUin = paramString2;
    this.sessionType = paramInt;
    if (paramChatMessage != null)
    {
      this.isMultiMsg = paramChatMessage.isMultiMsg;
      this.Jy = paramChatMessage.msgseq;
      this.sn.add(paramChatMessage);
    }
    this.h = new auru(ThreadManager.getFileThreadLooper(), null);
  }
  
  private List<AIORichMediaData> c(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = 0;
    Object localObject3;
    int i;
    Object localObject1;
    Object localObject2;
    label813:
    int j;
    if (k < paramList.size())
    {
      localObject3 = (MessageRecord)paramList.get(k);
      i = ((MessageRecord)localObject3).msgtype;
      if (((MessageRecord)localObject3).shmsgseq < this.FI) {
        this.FI = ((MessageRecord)localObject3).shmsgseq;
      }
      if (((MessageRecord)localObject3).versionCode < this.bFx) {
        this.bFx = ((MessageRecord)localObject3).versionCode;
      }
      if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.FH)) {
        this.FH = ((MessageRecord)localObject3).getId();
      }
      if (((MessageRecord)localObject3).time < this.FJ) {
        this.FJ = ((MessageRecord)localObject3).time;
      }
      if ((localObject3 instanceof MessageForPic))
      {
        localObject1 = (MessageForPic)localObject3;
        ((MessageForPic)localObject1).parse();
        if ((i == -3000) || (i == -30003)) {
          if (QLog.isColorLevel()) {
            QLog.i("TroopAIOImageGeter", 2, "LoadMediaTask msgType is " + i);
          }
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if ((!acfx.W((MessageRecord)localObject1)) && (!acei.W((MessageRecord)localObject1)) && (!xkl.a((MessageForPic)localObject1)))
        {
          localArrayList1.add(xtm.a((MessageForPic)localObject1));
          localArrayList2.add(localObject1);
          continue;
          if ((localObject3 instanceof MessageForMixedMsg))
          {
            localObject1 = (MessageForMixedMsg)localObject3;
            ((MessageForMixedMsg)localObject1).parse();
            localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if ((localObject2 instanceof MessageForPic))
              {
                localArrayList1.add(xtm.a((MessageForPic)localObject2));
                localArrayList2.add((MessageForPic)localObject2);
              }
            }
          }
          else if ((localObject3 instanceof MessageForStructing))
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)localObject3;
            localMessageForStructing.parse();
            if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg.mMsgServiceID == 5) || (localMessageForStructing.structingMsg.mMsgServiceID == 137)))
            {
              StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
              ansu localansu = localStructMsgForImageShare.getFirstImageElement();
              if (localansu != null)
              {
                localObject2 = localansu.j;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  if (localansu.d == null) {
                    localansu.d = localStructMsgForImageShare;
                  }
                  localObject1 = localansu.a();
                }
                localObject2 = xtm.a((MessageForPic)localObject1);
                ((AIOImageData)localObject2).time = localMessageForStructing.time;
                ((AIOImageData)localObject2).shmsgseq = localMessageForStructing.shmsgseq;
                if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
                {
                  ((AIOImageData)localObject2).EP = 1;
                  ((AIOImageData)localObject2).bQ = localStructMsgForImageShare.getBytes();
                  ((AIOImageData)localObject2).bWU = xtj.a(xtj.a(localStructMsgForImageShare));
                }
                for (;;)
                {
                  localArrayList1.add(localObject2);
                  localArrayList2.add(localObject1);
                  break;
                  if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("ScreenShotShare")))
                  {
                    ((AIOImageData)localObject2).EP = 2;
                    ((AIOImageData)localObject2).bQ = localStructMsgForImageShare.getBytes();
                    if ((aqiu.mt(((MessageRecord)localObject3).issend)) && (!TextUtils.isEmpty(((MessageForPic)localObject1).path)) && (new File(((MessageForPic)localObject1).path).exists())) {
                      ((AIOImageData)localObject2).aVX = ((MessageForPic)localObject1).path;
                    }
                  }
                }
              }
            }
          }
          else
          {
            if (!MessageForShortVideo.class.isInstance(localObject3)) {
              break label813;
            }
            if (MessageForLightVideo.class.isInstance(localObject3))
            {
              localObject1 = (MessageForLightVideo)localObject3;
              localArrayList1.add(xtm.a((MessageForLightVideo)localObject1));
              localArrayList2.add(localObject1);
            }
            else
            {
              localObject1 = (MessageForShortVideo)localObject3;
              if ((((MessageForShortVideo)localObject1).busiType == 1) || (((MessageForShortVideo)localObject1).busiType == 2) || (((MessageForShortVideo)localObject1).busiType == 1007) || (((MessageForShortVideo)localObject1).busiType == 1009) || (((MessageForShortVideo)localObject1).busiType == 0))
              {
                localArrayList1.add(xtm.a((MessageForShortVideo)localObject1));
                localArrayList2.add(localObject1);
              }
            }
          }
        }
      }
      if ((localObject3 instanceof MessageForFile))
      {
        localObject3 = (MessageForFile)localObject3;
        localObject1 = paramQQAppInterface.a().a(((MessageForFile)localObject3).uniseq, ((MessageForFile)localObject3).frienduin, ((MessageForFile)localObject3).istroop);
        j = 0;
        if ((localObject1 == null) || (((!ahav.s((FileManagerEntity)localObject1)) || (((FileManagerEntity)localObject1).nFileType == 2)) && (16 == ((FileManagerEntity)localObject1).status))) {
          break label1340;
        }
        if (((FileManagerEntity)localObject1).nFileType == 0)
        {
          i = 1;
          label897:
          if (((FileManagerEntity)localObject1).nFileType != 2) {
            break label962;
          }
          j = 1;
        }
      }
    }
    for (;;)
    {
      label909:
      localObject2 = null;
      if (i != 0)
      {
        ((MessageForFile)localObject3).parse();
        localObject1 = xtm.a((ChatMessage)localObject3, paramQQAppInterface);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label1031;
        }
        localArrayList1.add(localObject1);
        localArrayList2.add(localObject3);
        break;
        i = 0;
        break label897;
        label962:
        j = 0;
        break label909;
        if (j != 0)
        {
          ((MessageForFile)localObject3).parse();
          localObject1 = xtm.a((ChatMessage)localObject3, paramQQAppInterface);
        }
        else
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("TroopAIOImageGeter", 2, "ignore filePic: " + localObject3);
            localObject1 = localObject2;
          }
        }
      }
      label1031:
      break;
      if ((localObject3 instanceof MessageForTroopFile))
      {
        localObject1 = (MessageForTroopFile)localObject3;
        j = ahav.getFileType(((MessageForTroopFile)localObject1).fileName);
        if ((j == 0) && (((MessageForTroopFile)localObject1).fileSize < 10485760L))
        {
          i = 1;
          label1077:
          if (j != 2) {
            break label1122;
          }
        }
        label1122:
        for (j = 1;; j = 0)
        {
          if (i == 0) {
            break label1128;
          }
          localArrayList1.add(xtm.a((MessageForTroopFile)localObject1, paramQQAppInterface));
          localArrayList2.add(localObject1);
          break;
          i = 0;
          break label1077;
        }
        label1128:
        if ((j == 0) || (!ahbr.aM(paramQQAppInterface))) {
          break;
        }
        localArrayList1.add(xtm.a((ChatMessage)localObject1, paramQQAppInterface));
        localArrayList2.add(localObject1);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TroopAIOImageGeter", 2, "messageRecordToData " + ((MessageRecord)localObject3).getBaseInfoString());
      break;
      if (this.bjm)
      {
        this.sn.addAll(0, localArrayList2);
        this.jl.addAll(0, localArrayList1);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopAIOImageGeter", 2, "messageRecordToData total size " + localArrayList2.size() + ", cost " + (System.currentTimeMillis() - l));
        }
        return localArrayList1;
        this.sn.clear();
        this.jl.clear();
        this.sn.addAll(localArrayList2);
        this.jl.addAll(localArrayList1);
      }
      label1340:
      i = 0;
    }
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$a = parama;
  }
  
  boolean a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaData))
    {
      if (((AIOShortVideoData)paramAIORichMediaData).mBusiType != 0) {}
    }
    else {
      while (AIOFileVideoData.class.isInstance(paramAIORichMediaData)) {
        return true;
      }
    }
    return false;
  }
  
  public void ceR()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$a;
    if (localObject != null) {
      ((a)localObject).b(null, -1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$b;
    if (localObject != null) {
      ((b)localObject).a(null, -1);
    }
  }
  
  public void loadMedias(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$a == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$b == null)) {
      ceR();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopAIOImageGeter", 2, "[loadMedias] + loadType: " + paramInt + ", dataList.size = " + this.jl.size());
      }
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.h.post(new IncreasinglyLoadMediaTask());
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$a == null);
    ArrayList localArrayList;
    if (this.jl.size() > 0)
    {
      localArrayList = new ArrayList();
      ??? = this.jl;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.jl.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.jl.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label344;
          }
          localArrayList.add(localAIORichMediaData);
        }
      }
      finally {}
      ??? = (AIORichMediaData[])localObject2.toArray(new AIORichMediaData[localObject2.size()]);
      this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$a.b((AIORichMediaData[])???, -1);
      return;
      this.h.post(new IncreasinglyLoadMediaTask());
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$b == null) {
        break;
      }
      if (this.jl.size() > 0) {
        synchronized (this.jl)
        {
          AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jl.toArray(new AIORichMediaData[this.jl.size()]);
          this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$b.a(arrayOfAIORichMediaData, -1);
          return;
        }
      }
      this.h.post(new IncreasinglyLoadMediaTask());
      return;
      label344:
      paramInt += 1;
    }
  }
  
  class IncreasinglyLoadMediaTask
    implements Runnable
  {
    IncreasinglyLoadMediaTask() {}
    
    public void run()
    {
      Object localObject7;
      ArrayList localArrayList1;
      Object localObject8;
      for (;;)
      {
        try
        {
          TroopAIOImageGeter.this.isLoading = true;
          if (TroopAIOImageGeter.this.bWY < 1)
          {
            TroopAIOImageGeter.this.isLoading = false;
            TroopAIOImageGeter.this.ceR();
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopAIOImageGeter", 2, "[IncreasinglyLoadTask] start");
          }
          if ((TroopAIOImageGeter.this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$a == null) && (TroopAIOImageGeter.this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$b == null))
          {
            TroopAIOImageGeter.this.isLoading = false;
            TroopAIOImageGeter.this.ceR();
            return;
          }
          l = System.currentTimeMillis();
          localObject7 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(TroopAIOImageGeter.this.myUin);
          localArrayList2 = new ArrayList();
          localArrayList1 = new ArrayList();
          if (TroopAIOImageGeter.this.isMultiMsg) {
            continue;
          }
          if (TroopAIOImageGeter.this.friendUin == null)
          {
            TroopAIOImageGeter.this.isLoading = false;
            TroopAIOImageGeter.this.ceR();
            return;
          }
          localObject8 = new int[8];
          Object tmp193_191 = localObject8;
          tmp193_191[0] = -20000;
          Object tmp199_193 = tmp193_191;
          tmp199_193[1] = -2000;
          Object tmp205_199 = tmp199_193;
          tmp205_199[2] = -1035;
          Object tmp211_205 = tmp205_199;
          tmp211_205[3] = -2011;
          Object tmp217_211 = tmp211_205;
          tmp217_211[4] = -2022;
          Object tmp223_217 = tmp217_211;
          tmp223_217[5] = -2005;
          Object tmp229_223 = tmp223_217;
          tmp229_223[6] = -2017;
          Object tmp236_229 = tmp229_223;
          tmp236_229[7] = -2071;
          tmp236_229;
          if (TroopAIOImageGeter.this.bjm) {
            continue;
          }
          localObject6 = ((QQAppInterface)localObject7).a(TroopAIOImageGeter.this.sessionType).a(TroopAIOImageGeter.this.friendUin, TroopAIOImageGeter.this.sessionType, (int[])localObject8);
          localObject1 = localObject6;
          if (((List)localObject6).size() < 1)
          {
            localObject1 = ((QQAppInterface)localObject7).b().a(TroopAIOImageGeter.this.friendUin, TroopAIOImageGeter.this.sessionType, (int[])localObject8, 1);
            TroopAIOImageGeter.this.bWY = ((List)localObject1).size();
          }
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          long l;
          ArrayList localArrayList2;
          Object localObject6;
          Object localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopAIOImageGeter", 2, "no appRuntime");
          return;
          localObject2 = ((QQAppInterface)localObject7).b().a(TroopAIOImageGeter.this.friendUin, TroopAIOImageGeter.this.sessionType, TroopAIOImageGeter.this.FH, TroopAIOImageGeter.this.bFx, TroopAIOImageGeter.this.FJ, (int[])localObject8, 1);
          continue;
          if ((((QQAppInterface)localObject7).a() != null) && (!TroopAIOImageGeter.this.bjm)) {
            continue;
          }
          TroopAIOImageGeter.this.isLoading = false;
          TroopAIOImageGeter.this.ceR();
          return;
          localObject2 = ((QQAppInterface)localObject7).a().k(TroopAIOImageGeter.this.Jy);
          continue;
          localArrayList2.addAll(0, (Collection)localObject2);
          localArrayList1.addAll(0, TroopAIOImageGeter.a(TroopAIOImageGeter.this, (QQAppInterface)localObject7, (List)localObject2));
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          label514:
          label582:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopAIOImageGeter", 2, "out of memory", localOutOfMemoryError);
          return;
          localList = TroopAIOImageGeter.this.jl;
          continue;
          localObject8 = TroopAIOImageGeter.this.jl;
          i = 0;
          try
          {
            if (i >= localList.size()) {
              break label1083;
            }
            localAIORichMediaData = (AIORichMediaData)localList.get(i);
            if (TroopAIOImageGeter.this.a(localAIORichMediaData)) {
              break label1128;
            }
            ((List)localObject7).add(localAIORichMediaData);
          }
          finally {}
        }
        finally
        {
          TroopAIOImageGeter.this.isLoading = false;
        }
        if (TroopAIOImageGeter.this.bjm) {
          continue;
        }
        localArrayList2.addAll((Collection)localObject1);
        localArrayList1.addAll(TroopAIOImageGeter.a(TroopAIOImageGeter.this, (QQAppInterface)localObject7, (List)localObject1));
        TroopAIOImageGeter.this.bjm = true;
        if ((TroopAIOImageGeter.this.isMultiMsg) || (localArrayList1.size() >= 0) || (TroopAIOImageGeter.this.bWY < 1))
        {
          if (localArrayList1.size() <= 0) {
            break label1111;
          }
          localObject6 = TroopAIOImageGeter.this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$a;
          if (localObject6 != null)
          {
            localObject7 = new ArrayList();
            if (TroopAIOImageGeter.this.sessionType == 1) {
              break label1121;
            }
            if (TroopAIOImageGeter.this.sessionType != 1026) {
              continue;
            }
            break label1121;
            if (TroopAIOImageGeter.this.sessionType != 1) {
              continue;
            }
            localObject1 = (AIORichMediaData[])((List)localObject1).toArray(new AIORichMediaData[((List)localObject1).size()]);
            if (localObject1.length > 0) {
              ((TroopAIOImageGeter.a)localObject6).b((AIORichMediaData[])localObject1, -1);
            }
          }
          localObject1 = TroopAIOImageGeter.this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopAIOImageGeter$b;
          if (localObject1 != null)
          {
            localObject6 = (AIORichMediaData[])localArrayList1.toArray(new AIORichMediaData[localArrayList1.size()]);
            if (localObject6.length > 0) {
              ((TroopAIOImageGeter.b)localObject1).a((AIORichMediaData[])localObject6, -1);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopAIOImageGeter", 2, "[IncreasinglyLoadTask] end isMultiMsg: " + TroopAIOImageGeter.this.isMultiMsg + ", tempList.size: " + localArrayList2.size() + ", tempDataList.size: " + localArrayList1.size() + ", cost:" + (System.currentTimeMillis() - l));
          }
          TroopAIOImageGeter.this.isLoading = false;
          return;
          if (!top.fs(TroopAIOImageGeter.this.sessionType)) {
            continue;
          }
          localObject1 = TroopAIOImageGeter.this;
          ((TroopAIOImageGeter)localObject1).FI -= 1L;
          localObject1 = ((QQAppInterface)localObject7).b().a(TroopAIOImageGeter.this.friendUin, TroopAIOImageGeter.this.sessionType, TroopAIOImageGeter.this.FH, TroopAIOImageGeter.this.bFx, TroopAIOImageGeter.this.FI, (int[])localObject8, 1);
          TroopAIOImageGeter.this.bWY = ((List)localObject1).size();
          localObject6 = TroopAIOImageGeter.this;
          ((TroopAIOImageGeter)localObject6).bWZ += 1;
        }
      }
      for (;;)
      {
        Object localObject2;
        List localList;
        int i;
        AIORichMediaData localAIORichMediaData;
        label1083:
        Object localObject5 = (AIORichMediaData[])((List)localObject7).toArray(new AIORichMediaData[((List)localObject7).size()]);
        break label514;
        label1111:
        TroopAIOImageGeter.this.ceR();
        break label582;
        label1121:
        localObject5 = localArrayList1;
        break;
        label1128:
        i += 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(AIORichMediaData[] paramArrayOfAIORichMediaData, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageGeter
 * JD-Core Version:    0.7.0.1
 */