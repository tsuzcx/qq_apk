import OnlinePushPack.DelMsgInfo;
import PushNotifyPack.C2CMsgReadedNotify;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.imcore.message.C2CMessageProcessor.4;
import com.tencent.imcore.message.C2CMessageProcessor.6;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyFlowerMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.PubAccInfo;
import tencent.im.msg.im_msg_body.RichText;

public class tob
  extends tnv
{
  private boolean aPZ;
  HashSet<String> at = null;
  HashSet<String> au = null;
  public int bCC = 1;
  public int bCD = 3;
  public int bCE = 10;
  public int bCF = 30;
  public int bCG;
  public int bCH = 1;
  public int bCI = 5;
  public int bCJ = 10;
  public int bCK = 50;
  public int bCL;
  private Set<String> bb = new HashSet();
  private Set<String> bc = new HashSet();
  public Comparator x = new toc(this);
  
  public tob(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private int a(byte paramByte, msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt)
  {
    byte b;
    int i;
    if ((paramUinPairMsg.c2c_type.has()) && (paramUinPairMsg.service_type.has()))
    {
      b = paramUinPairMsg.c2c_type.get();
      i = paramUinPairMsg.service_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : peerUin:" + paramString + "c2cType:" + b + " serviceType:" + i + " channelType:" + paramByte);
      }
      if ((b == 1) && (i == 130)) {
        paramByte = 1006;
      }
    }
    for (;;)
    {
      b = a(paramUinPairMsg, paramString, paramInt);
      paramInt = paramByte;
      if (b != paramByte) {
        paramInt = b;
      }
      return paramInt;
      if ((b == 1) && (i == 164))
      {
        paramByte = 10007;
      }
      else
      {
        paramByte = this.app.b().a(paramString, paramInt).istroop;
        continue;
        paramByte = this.app.b().a(paramString, paramInt).istroop;
      }
    }
  }
  
  private int a(msg_comm.UinPairMsg paramUinPairMsg, String paramString, int paramInt)
  {
    Object localObject = this.app.b().a().cx();
    int[] arrayOfInt = new int[1];
    localObject = ((List)localObject).iterator();
    tpr localtpr;
    do
    {
      i = paramInt;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localtpr = (tpr)((Iterator)localObject).next();
      arrayOfInt[0] = paramInt;
    } while (!localtpr.a(paramUinPairMsg, paramString, arrayOfInt, this.app));
    int i = arrayOfInt[0];
    return i;
  }
  
  private Pair<String, Integer> a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    long l6 = this.app.getLongAccountUin();
    String str1 = this.app.getCurrentAccountUin();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList2 = new ArrayList();
    t((List)localObject1, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    anax localanax = new anax(l6, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localanax.cEF = true;
    localanax.G(1000, localHashMap);
    localanax.G(1001, localHashSet);
    int k = 0;
    long l2 = -1L;
    localObject1 = paramString;
    int i = 0;
    long l1 = -1L;
    if (k < localArrayList2.size())
    {
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
    }
    try
    {
      localObject4 = (msg_comm.Msg)localArrayList2.get(k);
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localObject5 = (msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get();
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      if (!((msg_comm.Msg)localObject4).msg_head.has())
      {
        j = i;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        if (!QLog.isColorLevel()) {
          break label2386;
        }
        j = i;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + k + "] : msg doesn't has msgHead.");
        break label2386;
      }
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      l8 = ((msg_comm.MsgHead)localObject5).to_uin.get();
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      l7 = ((msg_comm.MsgHead)localObject5).from_uin.get();
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      l9 = ((msg_comm.MsgHead)localObject5).from_uin.get();
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      l5 = ((msg_comm.MsgHead)localObject5).msg_time.get();
      if (l5 <= paramLong) {
        break label2377;
      }
      paramBoolean3 = false;
      bool = false;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        long l8;
        long l7;
        long l9;
        long l5;
        localObject1 = localObject3;
        localObject3 = localException3;
        i = j;
        l1 = l4;
        l2 = l3;
        continue;
        paramBoolean3 = true;
        boolean bool = true;
      }
    }
    int j = i;
    long l4 = l1;
    Object localObject2 = localObject1;
    long l3 = l2;
    l8 = achp.a(this.app, l9, l8, paramUinPairMsg.peer_uin.get(), paramUinPairMsg);
    j = i;
    l4 = l1;
    localObject2 = localObject1;
    l3 = l2;
    localanax.cEI = true;
    j = i;
    l4 = l1;
    localObject2 = localObject1;
    l3 = l2;
    localObject1 = String.valueOf(l8);
    j = i;
    l4 = l1;
    localObject2 = localObject1;
    l3 = l2;
    l9 = this.app.a().j(String.valueOf(l8), 0);
    if ((l5 <= l9) && (bool))
    {
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      if (QLog.isColorLevel())
      {
        j = i;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        localStringBuilder.setLength(0);
        j = i;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        localStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(k).append("] : filter msg by del time delTime =").append(l9).append(", msgTime = ").append(l5);
        j = i;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
      }
    }
    else
    {
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localanax.isRead = bool;
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localanax.friendUin = l8;
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localanax.cEH = paramBoolean3;
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      localObject4 = a((msg_comm.Msg)localObject4, localanax).iterator();
      j = i;
      l4 = l1;
      localObject2 = localObject1;
      l3 = l2;
      if (((Iterator)localObject4).hasNext())
      {
        j = i;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        localObject5 = (MessageRecord)((Iterator)localObject4).next();
        j = i;
        l4 = l1;
        localObject2 = localObject1;
        l3 = l2;
        l5 = ((MessageRecord)localObject5).vipBubbleID;
        if (l5 != -1L)
        {
          j = i;
          l4 = l1;
          localObject2 = localObject1;
          l3 = l2;
          paramBoolean3 = aqiu.ms(((MessageRecord)localObject5).issend);
          if (paramBoolean3) {
            l1 = l5;
          }
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              label935:
              j = ((MessageRecord)localObject5).istroop;
              try
              {
                paramBoolean3 = b((MessageRecord)localObject5, true);
                bool = q((MessageRecord)localObject5);
                if ((!paramBoolean3) && (!bool)) {
                  if ((((MessageRecord)localObject5).istroop == 1008) && ((localObject5 instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.aZ((MessageRecord)localObject5)) || (StructLongMessageDownloadProcessor.bb((MessageRecord)localObject5))))
                  {
                    localObject2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("longMsg_State");
                    if ((localObject2 == null) || (!String.valueOf(3).equals(localObject2))) {
                      break label1684;
                    }
                  }
                }
                for (;;)
                {
                  if ((localObject5 instanceof MessageForMarketFace)) {
                    ajdf.a(this.app, (MessageForMarketFace)localObject5);
                  }
                  if (acbn.blw.equals(((MessageRecord)localObject5).frienduin)) {
                    ((MessageRecord)localObject5).time = NetConnInfoCenter.getServerTime();
                  }
                  if (acbn.blP.equals(((MessageRecord)localObject5).frienduin)) {
                    ((KandianDailyManager)this.app.getManager(296)).l((MessageRecord)localObject5);
                  }
                  localArrayList1.add(localObject5);
                  i = KandianMergeManager.a((MessageRecord)localObject5, this.app);
                  if ((i == 0) || (i == 1))
                  {
                    localObject2 = ((KandianMergeManager)this.app.getManager(162)).a((MessageRecord)localObject5);
                    if (localObject2 != null) {
                      localArrayList1.add(localObject2);
                    }
                  }
                  Object localObject6;
                  if (((MessageRecord)localObject5).msgtype == -2002)
                  {
                    if ((!paramBoolean3) && (anqo.a(((MessageRecord)localObject5).msgUid, ((MessageRecord)localObject5).shmsgseq) != null)) {
                      aomq.Rc(true);
                    }
                    if ((paramBoolean3) && ((localObject5 instanceof MessageForPtt)) && (top.fv(((MessageRecord)localObject5).istroop)))
                    {
                      localObject2 = this.app.b().k(((MessageRecord)localObject5).frienduin, ((MessageRecord)localObject5).istroop).iterator();
                      while (((Iterator)localObject2).hasNext())
                      {
                        localObject6 = (MessageRecord)((Iterator)localObject2).next();
                        if (((localObject6 instanceof MessageForPtt)) && (((MessageRecord)localObject6).msgUid == ((MessageRecord)localObject5).msgUid) && (((MessageRecord)localObject6).shmsgseq == ((MessageRecord)localObject5).shmsgseq)) {
                          a((MessageForPtt)localObject6, (MessageForPtt)localObject5);
                        }
                      }
                    }
                  }
                  if ((!paramBoolean3) && (((MessageRecord)localObject5).istroop == 1008))
                  {
                    if (!"1".equals(((MessageRecord)localObject5).getExtInfoFromExtStr("is_AdArrive_Msg"))) {
                      break label1734;
                    }
                    localObject2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("gdt_msgImp");
                    localObject6 = ((MessageRecord)localObject5).getExtInfoFromExtStr("pa_msgId");
                    String str2 = ((MessageRecord)localObject5).getExtInfoFromExtStr("gdt_view_id");
                    ArrayList localArrayList3 = new ArrayList();
                    localArrayList3.add(localObject6);
                    obl.a(this.app, "", "", ((MessageRecord)localObject5).senderuin, (String)localObject2, str2, localArrayList3);
                  }
                  i = j;
                  break;
                  l2 = l5;
                  break label935;
                  j = i;
                  l4 = l1;
                  localObject2 = localObject1;
                  l3 = l2;
                  if (((MessageRecord)localObject5).msgtype == -2002)
                  {
                    j = i;
                    l4 = l1;
                    localObject2 = localObject1;
                    l3 = l2;
                    if (aqiu.ms(((MessageRecord)localObject5).issend))
                    {
                      if (l1 != -1L)
                      {
                        j = i;
                        l4 = l1;
                        localObject2 = localObject1;
                        l3 = l2;
                        ((MessageRecord)localObject5).vipBubbleID = l1;
                        break label935;
                      }
                      j = i;
                      l4 = l1;
                      localObject2 = localObject1;
                      l3 = l2;
                      ((MessageRecord)localObject5).vipBubbleID = this.app.b().c(String.valueOf(l8), String.valueOf(l7));
                      break label935;
                    }
                    if (l2 != -1L)
                    {
                      j = i;
                      l4 = l1;
                      localObject2 = localObject1;
                      l3 = l2;
                      ((MessageRecord)localObject5).vipBubbleID = l2;
                      break label935;
                    }
                    j = i;
                    l4 = l1;
                    localObject2 = localObject1;
                    l3 = l2;
                    ((MessageRecord)localObject5).vipBubbleID = this.app.b().c(String.valueOf(l8), String.valueOf(l7));
                    break label935;
                  }
                  j = i;
                  l4 = l1;
                  localObject2 = localObject1;
                  l3 = l2;
                  ((MessageRecord)localObject5).vipBubbleID = 0L;
                  break label935;
                  label1684:
                  ((MessageRecord)localObject5).saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
                  StructLongMessageDownloadProcessor.m(this.app, (MessageRecord)localObject5);
                }
                if (!QLog.isColorLevel()) {
                  break label1731;
                }
              }
              catch (Exception localException1)
              {
                i = j;
              }
            }
          }
          catch (Exception localException2)
          {
            label1731:
            label1734:
            Object localObject3;
            continue;
          }
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException1);
          break label2386;
          if ("2290230341".equals(((MessageRecord)localObject5).frienduin)) {
            anot.a(this.app, "CliOper", "", "", "0X80090E1", "0X80090E1", 0, 0, "", "", "", "");
          }
        }
      }
      break label2386;
      if (localObject1 != null)
      {
        paramUinPairMsg = (msg_comm.UinPairMsg)localObject1;
        if (!((String)localObject1).equals("0")) {}
      }
      else
      {
        paramUinPairMsg = paramString;
      }
      if (!localHashMap.isEmpty())
      {
        localObject1 = localHashSet.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject1).next();
          localHashMap.remove(localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("svenxu", 2, "Discard video request because canceled: fromUin = " + localObject3);
          }
        }
        localObject1 = localHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (msg_comm.Msg)localHashMap.get((Long)((Iterator)localObject1).next());
          if ((((msg_comm.Msg)localObject3).msg_body.has()) && (((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).msg_content.has())) {
            this.a.a(l6, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject3).msg_body.get()).msg_content.get().toByteArray(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject3).msg_head.get()).msg_time.get());
          }
        }
      }
      if (localArrayList1.size() > 0)
      {
        if (!paramBoolean2) {
          this.app.a().mp(localArrayList1);
        }
        this.app.b().a(paramUinPairMsg, 0, localArrayList1, paramBoolean1);
        paramBoolean3 = x(localArrayList1);
        j = top.a(localArrayList1, this.app);
        aegu.g(this.app, localArrayList1);
        localObject1 = this.app.b();
        if ((!paramBoolean3) || (!this.app.isBackground_Stop)) {
          break label2284;
        }
      }
      label2284:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((QQMessageFacade)localObject1).c(localArrayList1, str1, paramBoolean1);
        fo(localArrayList1);
        cK(localArrayList1);
        a("handleGetBuddyMessageResp", true, j, paramBoolean3, paramBoolean2);
        u(localArrayList1, paramBoolean2);
        acqz.e((MessageRecord)localArrayList1.get(0), this.app);
        if (i == 1008)
        {
          localObject1 = (acja)this.app.getManager(56);
          if (localObject1 != null) {
            ((acja)localObject1).a(localArrayList1, this.app);
          }
        }
        if ((i != 0) || (localArrayList1.size() <= 0)) {
          break;
        }
        localObject1 = localArrayList1.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          aluu.b(this.app, paramString, 0, (MessageRecord)localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage : dstUin:" + paramUinPairMsg + ", pkgUinType:" + i);
      }
      return new Pair(paramUinPairMsg, Integer.valueOf(i));
    }
    for (;;)
    {
      label2377:
      label2386:
      k += 1;
      break;
    }
  }
  
  private Pair<List<MessageRecord>, List<MessageRecord>> a(List<msg_comm.Msg> paramList, List<MessageRecord> paramList1, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((achs)this.app.getManager(92)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramList = paramList.iterator();
      Object localObject;
      int i;
      while (paramList.hasNext())
      {
        localObject = (msg_comm.Msg)paramList.next();
        if (!((msg_comm.Msg)localObject).msg_head.has())
        {
          paramList.remove();
        }
        else
        {
          localObject = (msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get();
          paramLong1 = ((msg_comm.MsgHead)localObject).msg_uid.get();
          paramLong2 = (short)((msg_comm.MsgHead)localObject).msg_seq.get();
          i = 0;
          while (i < localList.size())
          {
            localObject = (MessageRecord)localList.get(i);
            if ((((MessageRecord)localObject).msgUid == paramLong1) && (((MessageRecord)localObject).shmsgseq == paramLong2))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
              }
              localArrayList.add(localObject);
              paramList.remove();
            }
            i += 1;
          }
        }
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        localObject = (MessageRecord)paramList.next();
        i = 0;
        while (i < localList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
          if ((localMessageRecord.msgUid == ((MessageRecord)localObject).msgUid) && (localMessageRecord.shmsgseq == ((MessageRecord)localObject).shmsgseq))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
            }
            paramList.remove();
          }
          i += 1;
        }
      }
    }
    return new Pair(localArrayList, paramList1);
  }
  
  @Nullable
  private msg_svc.PbGetMsgResp a(byte[] paramArrayOfByte)
  {
    msg_svc.PbGetMsgResp localPbGetMsgResp = new msg_svc.PbGetMsgResp();
    try
    {
      paramArrayOfByte = (msg_svc.PbGetMsgResp)localPbGetMsgResp.mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msf.msg.decodeerr", false, 0L, 0L, new HashMap(), "");
      }
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.C2CMessageProcessor", 2, "<---handleGetC2CMessageResp_PB : decode pb:", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
    }
  }
  
  private void a(int paramInt, msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, MessageHandler paramMessageHandler, anax paramanax)
  {
    anbs localanbs = this.app.b().a().a(paramInt);
    if (localanbs != null) {
      localanbs.a(paramMessageHandler, paramMsg, paramArrayList, paramanax);
    }
  }
  
  private void a(String paramString, int paramInt, long paramLong, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq)
  {
    if (paramLong == 0L) {}
    for (;;)
    {
      return;
      if (acbn.bkD.equals(paramString))
      {
        this.app.a().a().cOb();
        return;
      }
      if ((paramInt != 1001) || (Long.valueOf(paramString).longValue() <= acbn.Pd))
      {
        if ((paramInt == 1001) && ((top.gS(paramString)) || (top.gT(paramString))))
        {
          if (top.gU(paramString))
          {
            afcu.a(this.app, 1, null);
            return;
          }
          if (top.gT(paramString))
          {
            afcu.cM(this.app);
            return;
          }
          afcu.a(this.app, 2, null);
          return;
        }
        Object localObject;
        long l;
        if (paramInt == 1006)
        {
          localObject = aqgv.x(this.app, paramString);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break label360;
          }
          l = Long.valueOf((String)localObject).longValue();
        }
        while (l != -1L) {
          if (paramInt == 10007)
          {
            ahti.a(this.app, paramPbMsgReadedReportReq, paramString, paramLong);
            return;
            l = Long.valueOf(paramString).longValue();
          }
          else
          {
            localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l);
            ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramLong);
            if (paramInt == 1024)
            {
              paramString = this.app.a().K(paramString);
              if (paramString != null)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + aqhs.bytes2HexStr(paramString) + ",length:" + paramString.length);
                }
                ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).crm_sig.set(ByteStringMicro.copyFrom(paramString));
              }
            }
            paramString = new msg_svc.PbC2CReadedReportReq();
            paramString.pair_info.add((MessageMicro)localObject);
            localObject = this.app.a().a().am();
            if (localObject != null) {
              paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
            }
            paramPbMsgReadedReportReq.c2c_read_report.set(paramString);
            return;
            label360:
            l = -1L;
          }
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush: no C2CCmd.");
      }
    }
    long l1;
    long l2;
    int i;
    int j;
    Object localObject1;
    long l7;
    Object localObject2;
    boolean bool2;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      i = localMsgHead.user_active.get();
      j = localMsgHead.from_instid.get();
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.app.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_C2CPush:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + i + ",fromInstid:" + j + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.app.cxj = i;
        localObject1 = new ArrayList();
      }
      try
      {
        localObject2 = new anax(l7, l2, true, false, false, false);
        ((anax)localObject2).cEH = true;
        paramMsg = a(paramMsg, (anbl)localObject2);
        achp.iZ(paramMsg);
        if ((paramMsg != null) && (paramMsg.size() != 0))
        {
          a(paramMsg, (ArrayList)localObject1, true);
          paramMsg = new ArrayList();
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            j = ((ArrayList)localObject1).size();
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                localMessageRecord = (MessageRecord)((ArrayList)localObject1).get(i);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_C2CPush after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
                }
                if ((localMessageRecord.frienduin == null) || (localMessageRecord.frienduin.length() <= 2))
                {
                  i += 1;
                  continue;
                  localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
                }
              }
            }
          }
        }
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          MessageRecord localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handleMsgPush_PB_C2CPush decodeSinglePBMsg_C2C error,", paramMsg);
          }
          paramMsg = null;
          continue;
          localMessageRecord.isread = false;
          ((ArrayList)localObject2).add(localMessageRecord);
          DelMsgInfo localDelMsgInfo = new DelMsgInfo();
          localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
          localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
          localDelMsgInfo.uMsgTime = localMessageRecord.time;
          paramMsg.add(localDelMsgInfo);
        }
        this.app.a().mp((List)localObject2);
        bool2 = achp.F((ArrayList)localObject2);
        i = top.a((List)localObject1, this.app);
        localObject1 = this.app.b();
        if (!bool2) {
          break label858;
        }
      }
    }
    if (this.app.isBackground_Stop) {}
    label858:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QQMessageFacade)localObject1).c((ArrayList)localObject2, String.valueOf(l7), bool1);
      this.app.a().UG(localMsgHead.msg_seq.get());
      j = paramFromServiceMsg.getRequestSsoSeq();
      paramFromServiceMsg = paramPbPushMsg.bytes_push_token.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, new Object[] { "----------handleMsgPush_PB_C2CPush get Push token = ", paramFromServiceMsg, " and use ", "OnlinePush.RespPush", " send back to server" });
      }
      this.a.a(l2, paramMsg, paramPbPushMsg.svrip.get(), j, paramPbPushMsg);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_C2CPush", true, i, this.a.aO(bool2), false);
      this.a.dI((ArrayList)localObject2);
      return;
    }
  }
  
  private void a(msg_comm.Msg paramMsg, ArrayList<MessageRecord> paramArrayList, anax paramanax, MessageHandler paramMessageHandler)
  {
    Iterator localIterator = this.app.b().a().a().cB().iterator();
    while (localIterator.hasNext()) {
      ((anbs)localIterator.next()).a(paramMessageHandler, paramMsg, paramArrayList, paramanax);
    }
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.app.a().bv(paramArrayOfByte1);
      this.app.a().bw(paramArrayOfByte1);
      this.a.Fg(false);
      this.a.Fh(false);
      return;
    case 1: 
      this.app.a().bv(paramArrayOfByte1);
      this.a.Fg(false);
      return;
    }
    this.app.a().bw(paramArrayOfByte2);
    this.a.Fh(false);
  }
  
  /* Error */
  private void aW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_2
    //   4: istore 5
    //   6: aload_1
    //   7: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   10: ldc_w 980
    //   13: iconst_1
    //   14: invokevirtual 986	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   17: istore 11
    //   19: aload_1
    //   20: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   23: ldc_w 988
    //   26: iconst_1
    //   27: invokevirtual 986	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   30: istore 13
    //   32: aload_1
    //   33: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   36: ldc_w 990
    //   39: iconst_0
    //   40: invokevirtual 986	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   43: istore 12
    //   45: invokestatic 995	java/lang/System:currentTimeMillis	()J
    //   48: lstore 14
    //   50: aload_0
    //   51: aload_3
    //   52: checkcast 997	[B
    //   55: checkcast 997	[B
    //   58: invokespecial 999	tob:a	([B)Lmsf/msgsvc/msg_svc$PbGetMsgResp;
    //   61: astore 25
    //   63: new 98	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   70: astore 23
    //   72: aload 25
    //   74: ifnull +25 -> 99
    //   77: aload 25
    //   79: getfield 1002	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   85: ifeq +14 -> 99
    //   88: aload 25
    //   90: getfield 1002	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: ifeq +150 -> 246
    //   99: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +104 -> 206
    //   105: aload 23
    //   107: iconst_0
    //   108: invokevirtual 299	java/lang/StringBuilder:setLength	(I)V
    //   111: aload 23
    //   113: ldc_w 1004
    //   116: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 1005	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   123: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 1007
    //   129: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: astore 22
    //   134: aload 25
    //   136: ifnonnull +80 -> 216
    //   139: ldc_w 1009
    //   142: astore_3
    //   143: aload 22
    //   145: aload_3
    //   146: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: ldc_w 1011
    //   152: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: astore 22
    //   157: aload 25
    //   159: ifnonnull +72 -> 231
    //   162: ldc_w 1009
    //   165: astore_3
    //   166: aload 22
    //   168: aload_3
    //   169: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: ldc_w 1013
    //   175: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload 11
    //   180: invokevirtual 848	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: ldc_w 1015
    //   186: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 13
    //   191: invokevirtual 848	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: ldc 96
    //   197: iconst_2
    //   198: aload 23
    //   200: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 1017	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   210: aload_1
    //   211: aload_2
    //   212: invokevirtual 1021	com/tencent/mobileqq/app/MessageHandler:n	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   215: return
    //   216: aload 25
    //   218: getfield 1002	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   221: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   224: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   227: astore_3
    //   228: goto -85 -> 143
    //   231: aload 25
    //   233: getfield 1022	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 538	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   239: invokestatic 1027	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   242: astore_3
    //   243: goto -77 -> 166
    //   246: aload 25
    //   248: getfield 1030	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   251: invokevirtual 195	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   254: astore 24
    //   256: aload_0
    //   257: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   260: iconst_0
    //   261: putfield 1033	com/tencent/mobileqq/app/MessageHandler:cwR	I
    //   264: aload 25
    //   266: getfield 1037	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   269: invokevirtual 1040	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   272: ifeq +13 -> 285
    //   275: aload 25
    //   277: getfield 1037	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   280: invokevirtual 1041	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   283: istore 5
    //   285: iload 5
    //   287: iconst_2
    //   288: if_icmpge +7 -> 295
    //   291: iconst_1
    //   292: i2b
    //   293: istore 4
    //   295: aconst_null
    //   296: astore_2
    //   297: aload 25
    //   299: getfield 1022	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   302: invokevirtual 538	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   305: ifeq +15 -> 320
    //   308: aload 25
    //   310: getfield 1022	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   313: invokevirtual 544	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   316: invokevirtual 550	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   319: astore_2
    //   320: aconst_null
    //   321: astore 22
    //   323: aload 25
    //   325: getfield 1044	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   328: invokevirtual 538	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   331: ifeq +16 -> 347
    //   334: aload 25
    //   336: getfield 1044	msf/msgsvc/msg_svc$PbGetMsgResp:pubaccount_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   339: invokevirtual 544	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   342: invokevirtual 550	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   345: astore 22
    //   347: iconst_0
    //   348: istore 6
    //   350: aload 25
    //   352: getfield 1047	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   358: ifeq +13 -> 371
    //   361: aload 25
    //   363: getfield 1047	msf/msgsvc/msg_svc$PbGetMsgResp:msg_rsp_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   366: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   369: istore 6
    //   371: aload_0
    //   372: aload_2
    //   373: aload 22
    //   375: iload 6
    //   377: invokespecial 1049	tob:a	([B[BI)V
    //   380: iconst_0
    //   381: istore 10
    //   383: aload_0
    //   384: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   387: invokevirtual 1052	com/tencent/mobileqq/app/MessageHandler:aaH	()Z
    //   390: ifeq +6 -> 396
    //   393: iconst_1
    //   394: istore 10
    //   396: iload 4
    //   398: ifle +25 -> 423
    //   401: aload_0
    //   402: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   405: iload 4
    //   407: aload_2
    //   408: iload 5
    //   410: iload 11
    //   412: iload 13
    //   414: iload 10
    //   416: aconst_null
    //   417: iload 6
    //   419: aconst_null
    //   420: invokevirtual 1055	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZLjava/lang/String;ILjava/lang/Object;)V
    //   423: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +153 -> 579
    //   429: aload 23
    //   431: iconst_0
    //   432: invokevirtual 299	java/lang/StringBuilder:setLength	(I)V
    //   435: aload 23
    //   437: ldc_w 1004
    //   440: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_1
    //   444: invokevirtual 1005	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   447: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: ldc_w 1007
    //   453: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 25
    //   458: getfield 1002	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   464: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   467: ldc_w 1057
    //   470: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 25
    //   475: getfield 1022	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   478: invokevirtual 538	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   481: invokevirtual 848	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   484: ldc 114
    //   486: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 4
    //   491: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: ldc_w 1059
    //   497: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: iload 5
    //   502: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: ldc_w 1061
    //   508: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: iload 11
    //   513: invokevirtual 848	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   516: ldc_w 1015
    //   519: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: iload 13
    //   524: invokevirtual 848	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: ldc_w 1063
    //   530: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 24
    //   535: invokeinterface 198 1 0
    //   540: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   543: ldc_w 1065
    //   546: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_3
    //   550: invokevirtual 1068	java/lang/Object:hashCode	()I
    //   553: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   556: ldc_w 1070
    //   559: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 6
    //   564: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 96
    //   570: iconst_2
    //   571: aload 23
    //   573: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: iconst_0
    //   580: istore 7
    //   582: iload 7
    //   584: aload 24
    //   586: invokeinterface 198 1 0
    //   591: if_icmpge +1015 -> 1606
    //   594: invokestatic 995	java/lang/System:currentTimeMillis	()J
    //   597: lstore 14
    //   599: aload 24
    //   601: iload 7
    //   603: invokeinterface 637 2 0
    //   608: checkcast 72	msf/msgcomm/msg_comm$UinPairMsg
    //   611: astore 22
    //   613: aload 22
    //   615: getfield 273	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   618: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   621: invokestatic 286	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   624: astore_2
    //   625: aload 22
    //   627: getfield 1071	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   630: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   633: i2l
    //   634: ldc2_w 1072
    //   637: land
    //   638: lstore 16
    //   640: aload 22
    //   642: getfield 191	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   645: invokevirtual 195	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   648: astore_3
    //   649: aload 22
    //   651: getfield 1076	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   654: invokevirtual 82	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   657: ifeq +847 -> 1504
    //   660: aload 22
    //   662: getfield 1076	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   665: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   668: ifeq +836 -> 1504
    //   671: iconst_1
    //   672: istore 10
    //   674: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   677: ifeq +77 -> 754
    //   680: aload 23
    //   682: iconst_0
    //   683: invokevirtual 299	java/lang/StringBuilder:setLength	(I)V
    //   686: aload 23
    //   688: ldc_w 1078
    //   691: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_2
    //   695: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 1080
    //   701: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: iload 10
    //   706: invokevirtual 848	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   709: ldc_w 1082
    //   712: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: lload 16
    //   717: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   720: ldc_w 1084
    //   723: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: astore 25
    //   728: aload_3
    //   729: ifnonnull +781 -> 1510
    //   732: ldc_w 1009
    //   735: astore_1
    //   736: aload 25
    //   738: aload_1
    //   739: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: ldc 96
    //   745: iconst_2
    //   746: aload 23
    //   748: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: aload_3
    //   755: ifnull +811 -> 1566
    //   758: aload_3
    //   759: invokeinterface 198 1 0
    //   764: ifle +802 -> 1566
    //   767: aload_3
    //   768: invokeinterface 198 1 0
    //   773: iconst_1
    //   774: if_icmple +11 -> 785
    //   777: aload_3
    //   778: aload_0
    //   779: getfield 54	tob:x	Ljava/util/Comparator;
    //   782: invokestatic 1090	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   785: aload_0
    //   786: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   789: bipush 51
    //   791: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   794: checkcast 1092	acff
    //   797: aload_3
    //   798: iconst_0
    //   799: invokeinterface 637 2 0
    //   804: checkcast 242	msf/msgcomm/msg_comm$Msg
    //   807: getfield 246	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   810: invokevirtual 251	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   813: checkcast 248	msf/msgcomm/msg_comm$MsgHead
    //   816: getfield 267	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   819: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   822: invokevirtual 1095	acff:hu	(J)V
    //   825: aload_0
    //   826: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   829: aload_2
    //   830: iconst_0
    //   831: invokevirtual 1098	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   834: astore 25
    //   836: aload 25
    //   838: monitorenter
    //   839: aload_0
    //   840: aload_2
    //   841: aload 22
    //   843: lload 16
    //   845: iload 10
    //   847: iload 11
    //   849: iload 12
    //   851: invokespecial 1100	tob:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   854: astore_2
    //   855: aload_2
    //   856: getfield 1104	android/util/Pair:first	Ljava/lang/Object;
    //   859: checkcast 283	java/lang/String
    //   862: astore_1
    //   863: aload_2
    //   864: getfield 1107	android/util/Pair:second	Ljava/lang/Object;
    //   867: checkcast 202	java/lang/Integer
    //   870: invokevirtual 1110	java/lang/Integer:intValue	()I
    //   873: istore 5
    //   875: aload 25
    //   877: monitorexit
    //   878: iload 10
    //   880: ifne +169 -> 1049
    //   883: aload_0
    //   884: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   887: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   890: aload_1
    //   891: invokevirtual 1113	anaz:aF	(Ljava/lang/String;)J
    //   894: lstore 18
    //   896: aload_3
    //   897: iconst_0
    //   898: invokeinterface 637 2 0
    //   903: checkcast 242	msf/msgcomm/msg_comm$Msg
    //   906: getfield 246	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   909: invokevirtual 251	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   912: checkcast 248	msf/msgcomm/msg_comm$MsgHead
    //   915: getfield 270	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   918: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   921: i2l
    //   922: lstore 20
    //   924: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq +60 -> 987
    //   930: ldc 96
    //   932: iconst_2
    //   933: new 98	java/lang/StringBuilder
    //   936: dup
    //   937: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   940: ldc 101
    //   942: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: aload_1
    //   946: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   949: ldc_w 1115
    //   952: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   955: lload 18
    //   957: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   960: ldc_w 1117
    //   963: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: lload 20
    //   968: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   971: ldc 114
    //   973: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: iload 4
    //   978: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   981: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   987: lload 18
    //   989: lconst_0
    //   990: lcmp
    //   991: ifeq +11 -> 1002
    //   994: lload 20
    //   996: lload 18
    //   998: lcmp
    //   999: ifge +35 -> 1034
    //   1002: aload_0
    //   1003: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1006: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   1009: aload_1
    //   1010: lload 20
    //   1012: lconst_0
    //   1013: invokevirtual 1121	anaz:r	(Ljava/lang/String;JJ)V
    //   1016: iload 4
    //   1018: ifle +16 -> 1034
    //   1021: aload_0
    //   1022: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1025: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   1028: aload_1
    //   1029: lload 20
    //   1031: invokevirtual 1125	anaz:aP	(Ljava/lang/String;J)V
    //   1034: iload 4
    //   1036: ifne +13 -> 1049
    //   1039: aload_0
    //   1040: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1043: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   1046: invokevirtual 1128	anaz:dOO	()V
    //   1049: iconst_0
    //   1050: istore 8
    //   1052: iload 11
    //   1054: ifeq +441 -> 1495
    //   1057: iload 5
    //   1059: sipush 1006
    //   1062: if_icmpne +24 -> 1086
    //   1065: aload_0
    //   1066: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1069: bipush 11
    //   1071: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1074: checkcast 1130	ajdo
    //   1077: aload_1
    //   1078: invokeinterface 1133 2 0
    //   1083: ifnull +3 -> 1086
    //   1086: iload 5
    //   1088: invokestatic 1137	top:eD	(I)I
    //   1091: sipush 1032
    //   1094: if_icmpne +1165 -> 2259
    //   1097: iconst_0
    //   1098: istore 9
    //   1100: aload 22
    //   1102: aload_0
    //   1103: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1106: iload 9
    //   1108: invokestatic 1140	ahti:a	(Lmsf/msgcomm/msg_comm$UinPairMsg;Lcom/tencent/mobileqq/app/QQAppInterface;I)Ljava/lang/String;
    //   1111: astore_1
    //   1112: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1115: ifeq +51 -> 1166
    //   1118: ldc 96
    //   1120: iconst_2
    //   1121: new 98	java/lang/StringBuilder
    //   1124: dup
    //   1125: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1128: ldc_w 1142
    //   1131: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: aload_1
    //   1135: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: ldc_w 1144
    //   1141: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: iload 5
    //   1146: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1149: ldc_w 1146
    //   1152: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: lload 16
    //   1157: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1160: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1166: iload 8
    //   1168: ifne +238 -> 1406
    //   1171: aload_1
    //   1172: iload 9
    //   1174: invokestatic 1152	com/tencent/mobileqq/data/ConversationInfo:reportPublicaccoutTypeError	(Ljava/lang/String;I)Z
    //   1177: ifeq +229 -> 1406
    //   1180: new 98	java/lang/StringBuilder
    //   1183: dup
    //   1184: sipush 128
    //   1187: invokespecial 1154	java/lang/StringBuilder:<init>	(I)V
    //   1190: astore_2
    //   1191: aload_2
    //   1192: ldc_w 1155
    //   1195: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: ldc_w 1157
    //   1201: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: aload_1
    //   1205: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload_2
    //   1210: ldc_w 1159
    //   1213: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: iload 9
    //   1218: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload_3
    //   1223: ifnull +173 -> 1396
    //   1226: aload_3
    //   1227: invokeinterface 198 1 0
    //   1232: ifle +164 -> 1396
    //   1235: aload_3
    //   1236: iconst_0
    //   1237: invokeinterface 637 2 0
    //   1242: checkcast 242	msf/msgcomm/msg_comm$Msg
    //   1245: astore_3
    //   1246: aload_3
    //   1247: getfield 246	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1250: invokevirtual 252	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   1253: ifeq +143 -> 1396
    //   1256: aload_3
    //   1257: getfield 246	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1260: invokevirtual 251	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1263: checkcast 248	msf/msgcomm/msg_comm$MsgHead
    //   1266: astore_3
    //   1267: aload_2
    //   1268: ldc_w 1161
    //   1271: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1274: aload_3
    //   1275: getfield 1164	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1278: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1281: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1284: pop
    //   1285: aload_2
    //   1286: ldc_w 1166
    //   1289: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: aload_3
    //   1293: getfield 636	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1296: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1299: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: aload_2
    //   1304: ldc_w 1168
    //   1307: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: aload_3
    //   1311: getfield 633	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1314: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1317: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload_2
    //   1322: ldc_w 1170
    //   1325: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: aload_3
    //   1329: getfield 270	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1332: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1335: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload_3
    //   1340: getfield 1174	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1343: invokevirtual 1177	msf/msgcomm/msg_comm$C2CTmpMsgHead:has	()Z
    //   1346: ifeq +50 -> 1396
    //   1349: aload_3
    //   1350: getfield 1174	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   1353: invokevirtual 1178	msf/msgcomm/msg_comm$C2CTmpMsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1356: checkcast 1176	msf/msgcomm/msg_comm$C2CTmpMsgHead
    //   1359: astore_3
    //   1360: aload_2
    //   1361: ldc_w 1180
    //   1364: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: aload_3
    //   1368: getfield 1181	msf/msgcomm/msg_comm$C2CTmpMsgHead:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1371: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1374: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: aload_2
    //   1379: ldc_w 1183
    //   1382: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: aload_3
    //   1386: getfield 1184	msf/msgcomm/msg_comm$C2CTmpMsgHead:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1389: invokevirtual 89	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1392: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: ldc 96
    //   1398: iconst_1
    //   1399: aload_2
    //   1400: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 1017	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1406: new 1186	android/os/Message
    //   1409: dup
    //   1410: invokespecial 1187	android/os/Message:<init>	()V
    //   1413: astore_2
    //   1414: aload_2
    //   1415: iconst_1
    //   1416: putfield 1190	android/os/Message:what	I
    //   1419: new 982	android/os/Bundle
    //   1422: dup
    //   1423: invokespecial 1191	android/os/Bundle:<init>	()V
    //   1426: astore_3
    //   1427: aload_3
    //   1428: ldc_w 1193
    //   1431: lload 16
    //   1433: invokevirtual 1196	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1436: aload_3
    //   1437: ldc_w 1198
    //   1440: aload_1
    //   1441: invokevirtual 1201	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1444: aload_3
    //   1445: ldc_w 1203
    //   1448: iload 9
    //   1450: invokevirtual 1207	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1453: aload_2
    //   1454: aload_3
    //   1455: invokevirtual 1211	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1458: aload_0
    //   1459: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1462: astore_3
    //   1463: iload 4
    //   1465: ifgt +121 -> 1586
    //   1468: iconst_1
    //   1469: istore 10
    //   1471: aload_3
    //   1472: aload_2
    //   1473: iload 10
    //   1475: invokevirtual 1214	com/tencent/mobileqq/app/MessageHandler:b	(Landroid/os/Message;Z)V
    //   1478: iload 6
    //   1480: iconst_2
    //   1481: if_icmpne +111 -> 1592
    //   1484: aload_0
    //   1485: getfield 67	tob:bc	Ljava/util/Set;
    //   1488: aload_1
    //   1489: invokeinterface 1215 2 0
    //   1494: pop
    //   1495: iload 7
    //   1497: iconst_1
    //   1498: iadd
    //   1499: istore 7
    //   1501: goto -919 -> 582
    //   1504: iconst_0
    //   1505: istore 10
    //   1507: goto -833 -> 674
    //   1510: aload_3
    //   1511: invokeinterface 198 1 0
    //   1516: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1519: astore_1
    //   1520: goto -784 -> 736
    //   1523: astore_1
    //   1524: aload 25
    //   1526: monitorexit
    //   1527: aload_1
    //   1528: athrow
    //   1529: astore_1
    //   1530: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1533: ifeq -38 -> 1495
    //   1536: ldc 96
    //   1538: iconst_2
    //   1539: new 98	java/lang/StringBuilder
    //   1542: dup
    //   1543: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1546: ldc_w 1217
    //   1549: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1552: aload_1
    //   1553: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1556: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1559: aload_1
    //   1560: invokestatic 670	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1563: goto -68 -> 1495
    //   1566: aload_0
    //   1567: iload 4
    //   1569: aload 22
    //   1571: aload_2
    //   1572: iconst_0
    //   1573: invokespecial 1219	tob:a	(BLmsf/msgcomm/msg_comm$UinPairMsg;Ljava/lang/String;I)I
    //   1576: istore 5
    //   1578: iconst_1
    //   1579: istore 8
    //   1581: aload_2
    //   1582: astore_1
    //   1583: goto -531 -> 1052
    //   1586: iconst_0
    //   1587: istore 10
    //   1589: goto -118 -> 1471
    //   1592: aload_0
    //   1593: getfield 65	tob:bb	Ljava/util/Set;
    //   1596: aload_1
    //   1597: invokeinterface 1215 2 0
    //   1602: pop
    //   1603: goto -108 -> 1495
    //   1606: iload 4
    //   1608: ifgt +544 -> 2152
    //   1611: aload_0
    //   1612: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1615: invokevirtual 1222	com/tencent/mobileqq/app/MessageHandler:cKb	()V
    //   1618: iload 11
    //   1620: ifeq +454 -> 2074
    //   1623: aload_0
    //   1624: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1627: invokevirtual 1225	com/tencent/mobileqq/app/QQAppInterface:a	()Ltog;
    //   1630: invokevirtual 1229	tog:x	()Ljava/util/Set;
    //   1633: invokeinterface 521 1 0
    //   1638: astore_1
    //   1639: aload_1
    //   1640: invokeinterface 165 1 0
    //   1645: ifeq +414 -> 2059
    //   1648: aload_1
    //   1649: invokeinterface 169 1 0
    //   1654: checkcast 1148	com/tencent/mobileqq/data/ConversationInfo
    //   1657: astore_2
    //   1658: aload_2
    //   1659: getfield 1232	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1662: ifnull -23 -> 1639
    //   1665: aload_2
    //   1666: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1669: sipush 1036
    //   1672: if_icmpeq -33 -> 1639
    //   1675: aload_2
    //   1676: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1679: invokestatic 1137	top:eD	(I)I
    //   1682: sipush 1032
    //   1685: if_icmpeq -46 -> 1639
    //   1688: iload 6
    //   1690: iconst_1
    //   1691: if_icmpne +13 -> 1704
    //   1694: aload_2
    //   1695: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1698: sipush 1008
    //   1701: if_icmpeq -62 -> 1639
    //   1704: iload 6
    //   1706: iconst_2
    //   1707: if_icmpne +13 -> 1720
    //   1710: aload_2
    //   1711: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1714: sipush 1008
    //   1717: if_icmpne -78 -> 1639
    //   1720: iload 6
    //   1722: iconst_2
    //   1723: if_icmpeq +31 -> 1754
    //   1726: aload_0
    //   1727: getfield 65	tob:bb	Ljava/util/Set;
    //   1730: invokeinterface 1236 1 0
    //   1735: ifle +19 -> 1754
    //   1738: aload_0
    //   1739: getfield 65	tob:bb	Ljava/util/Set;
    //   1742: aload_2
    //   1743: getfield 1232	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1746: invokeinterface 1239 2 0
    //   1751: ifne -112 -> 1639
    //   1754: iload 6
    //   1756: iconst_2
    //   1757: if_icmpne +31 -> 1788
    //   1760: aload_0
    //   1761: getfield 67	tob:bc	Ljava/util/Set;
    //   1764: invokeinterface 1236 1 0
    //   1769: ifle +19 -> 1788
    //   1772: aload_0
    //   1773: getfield 67	tob:bc	Ljava/util/Set;
    //   1776: aload_2
    //   1777: getfield 1232	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1780: invokeinterface 1239 2 0
    //   1785: ifne -146 -> 1639
    //   1788: aload_2
    //   1789: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1792: invokestatic 440	top:fv	(I)Z
    //   1795: ifeq -156 -> 1639
    //   1798: aload_2
    //   1799: invokestatic 1242	tog:c	(Lcom/tencent/mobileqq/data/ConversationInfo;)I
    //   1802: ifle -163 -> 1639
    //   1805: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1808: ifeq +45 -> 1853
    //   1811: ldc 96
    //   1813: iconst_2
    //   1814: new 98	java/lang/StringBuilder
    //   1817: dup
    //   1818: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1821: ldc_w 1244
    //   1824: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: aload_2
    //   1828: getfield 1232	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1831: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: ldc_w 1246
    //   1837: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: aload_2
    //   1841: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1844: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1847: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1850: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1853: aload_2
    //   1854: getfield 1232	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1857: invokevirtual 877	java/lang/String:length	()I
    //   1860: iconst_4
    //   1861: if_icmple -222 -> 1639
    //   1864: aload_2
    //   1865: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1868: sipush 1001
    //   1871: if_icmpne +134 -> 2005
    //   1874: aload_0
    //   1875: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1878: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   1881: aload_2
    //   1882: getfield 1232	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1885: invokevirtual 1249	anaz:T	(Ljava/lang/String;)[B
    //   1888: astore_3
    //   1889: aload_3
    //   1890: ifnull -251 -> 1639
    //   1893: aload_3
    //   1894: arraylength
    //   1895: ifle -256 -> 1639
    //   1898: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1901: ifeq +29 -> 1930
    //   1904: ldc 96
    //   1906: iconst_2
    //   1907: new 98	java/lang/StringBuilder
    //   1910: dup
    //   1911: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1914: ldc_w 1251
    //   1917: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: aload_3
    //   1921: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1924: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1927: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1930: new 1186	android/os/Message
    //   1933: dup
    //   1934: invokespecial 1187	android/os/Message:<init>	()V
    //   1937: astore_3
    //   1938: aload_3
    //   1939: iconst_1
    //   1940: putfield 1190	android/os/Message:what	I
    //   1943: new 982	android/os/Bundle
    //   1946: dup
    //   1947: invokespecial 1191	android/os/Bundle:<init>	()V
    //   1950: astore 22
    //   1952: aload 22
    //   1954: ldc_w 1193
    //   1957: ldc2_w 1252
    //   1960: invokevirtual 1196	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1963: aload 22
    //   1965: ldc_w 1198
    //   1968: aload_2
    //   1969: getfield 1232	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1972: invokevirtual 1201	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1975: aload 22
    //   1977: ldc_w 1203
    //   1980: aload_2
    //   1981: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1984: invokevirtual 1207	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1987: aload_3
    //   1988: aload 22
    //   1990: invokevirtual 1211	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1993: aload_0
    //   1994: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1997: aload_3
    //   1998: iconst_1
    //   1999: invokevirtual 1214	com/tencent/mobileqq/app/MessageHandler:b	(Landroid/os/Message;Z)V
    //   2002: goto -363 -> 1639
    //   2005: aload_2
    //   2006: getfield 1235	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   2009: sipush 10002
    //   2012: if_icmpne +21 -> 2033
    //   2015: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2018: ifeq -88 -> 1930
    //   2021: ldc 96
    //   2023: iconst_2
    //   2024: ldc_w 1255
    //   2027: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2030: goto -100 -> 1930
    //   2033: aload_2
    //   2034: getfield 1258	com/tencent/mobileqq/data/ConversationInfo:isImax	Z
    //   2037: ifeq -107 -> 1930
    //   2040: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2043: ifeq -404 -> 1639
    //   2046: ldc_w 1260
    //   2049: iconst_2
    //   2050: ldc_w 1262
    //   2053: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2056: goto -417 -> 1639
    //   2059: iload 6
    //   2061: iconst_2
    //   2062: if_icmpne +140 -> 2202
    //   2065: aload_0
    //   2066: getfield 67	tob:bc	Ljava/util/Set;
    //   2069: invokeinterface 1265 1 0
    //   2074: invokestatic 1271	com/tencent/util/MsgAutoMonitorUtil:getInstance	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   2077: invokevirtual 1274	com/tencent/util/MsgAutoMonitorUtil:markC2CFinishTime	()V
    //   2080: iload 6
    //   2082: tableswitch	default:+26 -> 2108, 0:+132->2214, 1:+153->2235, 2:+165->2247
    //   2109: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2112: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   2115: invokevirtual 1277	anaz:dOS	()V
    //   2118: aload_0
    //   2119: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2122: invokevirtual 1052	com/tencent/mobileqq/app/MessageHandler:aaH	()Z
    //   2125: ifeq +27 -> 2152
    //   2128: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2131: ifeq +12 -> 2143
    //   2134: ldc 96
    //   2136: iconst_2
    //   2137: ldc_w 1279
    //   2140: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2143: aload_0
    //   2144: getfield 541	tob:a	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2147: iconst_0
    //   2148: iconst_0
    //   2149: invokevirtual 1283	com/tencent/mobileqq/app/MessageHandler:aY	(ZI)V
    //   2152: invokestatic 995	java/lang/System:currentTimeMillis	()J
    //   2155: lload 14
    //   2157: lsub
    //   2158: lstore 14
    //   2160: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2163: ifeq +30 -> 2193
    //   2166: ldc 96
    //   2168: iconst_2
    //   2169: new 98	java/lang/StringBuilder
    //   2172: dup
    //   2173: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   2176: ldc_w 1285
    //   2179: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2182: lload 14
    //   2184: invokevirtual 306	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2187: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2190: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2193: ldc_w 1287
    //   2196: lload 14
    //   2198: invokestatic 1290	acqz:ad	(Ljava/lang/String;J)V
    //   2201: return
    //   2202: aload_0
    //   2203: getfield 65	tob:bb	Ljava/util/Set;
    //   2206: invokeinterface 1265 1 0
    //   2211: goto -137 -> 2074
    //   2214: aload_0
    //   2215: sipush 4016
    //   2218: iconst_1
    //   2219: aconst_null
    //   2220: invokevirtual 1293	tob:b	(IZLjava/lang/Object;)V
    //   2223: aload_0
    //   2224: sipush 4001
    //   2227: iconst_1
    //   2228: aconst_null
    //   2229: invokevirtual 1293	tob:b	(IZLjava/lang/Object;)V
    //   2232: goto -124 -> 2108
    //   2235: aload_0
    //   2236: sipush 4001
    //   2239: iconst_1
    //   2240: aconst_null
    //   2241: invokevirtual 1293	tob:b	(IZLjava/lang/Object;)V
    //   2244: goto -136 -> 2108
    //   2247: aload_0
    //   2248: sipush 4016
    //   2251: iconst_1
    //   2252: aconst_null
    //   2253: invokevirtual 1293	tob:b	(IZLjava/lang/Object;)V
    //   2256: goto -148 -> 2108
    //   2259: iload 5
    //   2261: istore 9
    //   2263: goto -1163 -> 1100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2266	0	this	tob
    //   0	2266	1	paramToServiceMsg	ToServiceMsg
    //   0	2266	2	paramFromServiceMsg	FromServiceMsg
    //   0	2266	3	paramObject	Object
    //   1	1606	4	b	byte
    //   4	2256	5	i	int
    //   348	1733	6	j	int
    //   580	920	7	k	int
    //   1050	530	8	m	int
    //   1098	1164	9	n	int
    //   381	1207	10	bool1	boolean
    //   17	1602	11	bool2	boolean
    //   43	807	12	bool3	boolean
    //   30	493	13	bool4	boolean
    //   48	2149	14	l1	long
    //   638	794	16	l2	long
    //   894	103	18	l3	long
    //   922	108	20	l4	long
    //   132	1857	22	localObject1	Object
    //   70	677	23	localStringBuilder	StringBuilder
    //   254	346	24	localList	List
    // Exception table:
    //   from	to	target	type
    //   839	878	1523	finally
    //   1524	1527	1523	finally
    //   825	839	1529	java/lang/Exception
    //   1527	1529	1529	java/lang/Exception
  }
  
  private void aX(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localObject4 = Long.valueOf(paramToServiceMsg.extraData.getLong("lBeginTime"));
      bool1 = paramToServiceMsg.extraData.getBoolean("fetchMore");
      k = paramToServiceMsg.extraData.getInt("fetchNum");
      bool2 = paramToServiceMsg.extraData.getBoolean("preloadType");
      bool3 = paramToServiceMsg.extraData.getBoolean("notify", true);
      paramObject = new Bundle();
      paramObject.putLong("BEGTIME", ((Long)localObject4).longValue());
      paramObject.putBoolean("FETCH_MORE", bool1);
      paramObject.putInt("MSG_COUNT", k);
      paramObject.putString("PEER_UIN", paramToServiceMsg.extraData.getString("peerUin"));
      paramObject.putBoolean("IS_PRELOAD_TYPE", bool2);
      if (paramFromServiceMsg != null)
      {
        str = String.valueOf(paramFromServiceMsg.peer_uin.get());
        j = paramFromServiceMsg.result.get();
        localObject1 = paramFromServiceMsg.msg.get();
        if (localObject1 == null)
        {
          this.a.iU.remove(str);
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + j + ", msgList is null !");
          }
          b(1004, false, paramObject);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      Object localObject4;
      boolean bool1;
      int k;
      boolean bool2;
      boolean bool3;
      String str;
      int j;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
      ArrayList localArrayList = new ArrayList();
      t((List)localObject1, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg begTime: " + localObject4 + ", code=" + j + " ,errMsg=" + paramFromServiceMsg.errmsg.get() + ", msgList.size()=" + localArrayList.size() + ",peerUin=" + str + ",time=" + paramFromServiceMsg.last_msgtime.get() + ",fetchMore:" + bool1 + ",fetchNum: " + k);
      }
      Object localObject1 = (achs)this.app.getManager(92);
      int i = 0;
      if (((j != 0) && (j != 1)) || (j == 0)) {}
      for (;;)
      {
        try
        {
          if (localArrayList.size() > 0)
          {
            if (!this.a.iU.containsKey(str)) {
              continue;
            }
            localObject2 = (List)this.a.iU.get(str);
            if (((List)localObject2).size() == 0) {
              ((List)localObject2).addAll(0, localArrayList);
            }
          }
          else
          {
            this.a.a(str, ((Long)localObject4).longValue(), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get(), 1, ((achs)localObject1).getTicket(), ((achs)localObject1).getAuthMode(), paramToServiceMsg.extraData.getBoolean("fetchMore"), k, bool2, bool3);
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
          }
          i = 0;
          if (i != 0) {
            break;
          }
          this.a.iU.remove(str);
          paramObject.putInt("SVR_CODE", j);
          if (paramFromServiceMsg.errmsg.has()) {
            paramObject.putString("SVR_MSG", paramFromServiceMsg.errmsg.get());
          }
          b(1004, false, paramObject);
          return;
          if ((((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_uid.get() == ((msg_comm.MsgHead)((msg_comm.Msg)localArrayList.get(0)).msg_head.get()).msg_uid.get()) && (((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_seq.get() == ((msg_comm.MsgHead)((msg_comm.Msg)localArrayList.get(0)).msg_head.get()).msg_seq.get())) {
            continue;
          }
          ((List)localObject2).addAll(0, localArrayList);
          continue;
        }
        catch (OutOfMemoryError paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
          }
          i = 0;
          continue;
          this.a.iU.put(str, localArrayList);
          continue;
        }
        localArrayList = new ArrayList(localArrayList);
        if (this.a.iU.containsKey(str))
        {
          localArrayList.addAll((Collection)this.a.iU.get(str));
          this.a.iU.remove(str);
        }
        if (localArrayList.isEmpty())
        {
          new Object[2][0] = Boolean.valueOf(true);
          paramObject.putBoolean("NO_MSG", Boolean.TRUE.booleanValue());
          b(1004, false, paramObject);
          return;
        }
        long l1 = paramToServiceMsg.extraData.getLong("lBeginTime");
        long l2 = paramToServiceMsg.extraData.getLong("lEndTime");
        Object localObject2 = new ArrayList();
        Object localObject3 = localArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (msg_comm.Msg)((Iterator)localObject3).next();
          if (!((msg_comm.Msg)localObject5).msg_head.has())
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msg msg_head = null");
            }
          }
          else
          {
            long l3 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject5).msg_head.get()).msg_time.get();
            if ((l3 >= l1) && (l3 <= l2)) {
              ((ArrayList)localObject2).add(localObject5);
            }
          }
        }
        Object localObject5 = this.app.a().a(this.a, (List)localObject2, Long.valueOf(str).longValue(), true);
        localObject3 = new ArrayList();
        l1 = Long.parseLong(str);
        Object localObject6;
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject6 = (msg_comm.Msg)((ArrayList)localObject2).get(0);
          l1 = achp.a(this.app, ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject6).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        ((ArrayList)localObject3).addAll((Collection)a((List)localObject2, (List)localObject5, l1, ((Long)localObject4).longValue(), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        localObject4 = new anax(Long.parseLong(this.app.getCurrentAccountUin()), l1, true, true, false, false);
        ((anax)localObject4).cEH = true;
        localObject5 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (msg_comm.Msg)((Iterator)localObject5).next();
          try
          {
            localObject6 = a((msg_comm.Msg)localObject6, (anbl)localObject4);
            if ((localObject6 == null) || (((List)localObject6).isEmpty())) {
              continue;
            }
            ((ArrayList)localObject3).addAll((Collection)localObject6);
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
          }
        }
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          Collections.sort((List)localObject3, new tod(this));
          if (localObject1 == null) {}
        }
        try
        {
          ((achs)localObject1).h((List)localObject3, str, bool3);
          this.a.C((ArrayList)localObject3, false);
          localObject4 = this.app.a().h(String.valueOf(paramFromServiceMsg.peer_uin.get()));
          if ((localObject4 == null) || (((Long)((Pair)localObject4).first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
            this.app.a().r(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
          }
          ((achs)localObject1).a().o(str, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg resList size = " + localArrayList.size() + ", dayList size = " + ((ArrayList)localObject2).size() + ", loopList size=" + ((ArrayList)localObject3).size());
          }
          paramObject.putInt("MSG_COUNT", k - ((ArrayList)localObject3).size());
          b(1004, true, paramObject);
          i = 1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", localException1);
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
            }
          }
        }
      }
      b(1004, false, paramObject);
    }
  }
  
  private void aY(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
    }
    paramFromServiceMsg = new msg_svc.PbGetOneDayRoamMsgResp();
    Bundle localBundle;
    long l2;
    int i;
    long l1;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localBundle = paramToServiceMsg.extraData.getBundle("context");
      paramObject = null;
      l2 = 0L;
      if (paramFromServiceMsg == null) {
        break label683;
      }
      i = paramFromServiceMsg.result.get();
      Object localObject = paramFromServiceMsg.msg.get();
      paramToServiceMsg = new ArrayList();
      t((List)localObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + i + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + paramToServiceMsg.size() + ", context" + localBundle);
      }
      if (i != 0) {
        break label684;
      }
      paramObject = new ArrayList();
      try
      {
        localObject = this.app.a().a(this.a, paramToServiceMsg, paramFromServiceMsg.peer_uin.get(), true);
        if (localObject != null) {
          paramObject.addAll((Collection)localObject);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          anax localanax;
          Iterator localIterator;
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "FileMsg filter error,", localException1);
          }
        }
      }
      l1 = paramFromServiceMsg.peer_uin.get();
      if (!paramToServiceMsg.isEmpty())
      {
        localObject = (msg_comm.Msg)paramToServiceMsg.get(0);
        l1 = achp.a(this.app, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localanax = new anax(Long.parseLong(this.app.getCurrentAccountUin()), l1, true, true, false, false);
      localanax.cEH = true;
      localIterator = paramToServiceMsg.iterator();
      paramToServiceMsg = null;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label481;
        }
        localObject = (msg_comm.Msg)localIterator.next();
        try
        {
          localObject = a((msg_comm.Msg)localObject, localanax);
          paramToServiceMsg = (ToServiceMsg)localObject;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
            }
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          paramObject.addAll(paramToServiceMsg);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
      }
    }
    label481:
    if (paramObject.size() > 0)
    {
      Collections.sort(paramObject, new toe(this));
      l1 = ((MessageRecord)paramObject.get(0)).time;
    }
    for (paramToServiceMsg = paramObject;; paramToServiceMsg = null)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool1;
        label555:
        boolean bool2;
        if (localBundle != null)
        {
          l2 = localBundle.getLong("UIN", 0L);
          bool3 = localBundle.getBoolean("canUpdateEct", true);
          if (paramFromServiceMsg.iscomplete.get() == 0) {
            break label726;
          }
          bool1 = true;
          if ((i != 0) && (i != 1) && (i != 4)) {
            break label732;
          }
          bool2 = true;
          label575:
          if ((!bool2) || (!bool3)) {
            break label775;
          }
          if (!bool1) {
            break label738;
          }
          this.app.a().r(String.valueOf(l2), 0L, 0L);
          label607:
          localBundle.putBoolean("complete", bool1);
          localBundle.putBoolean("success", bool2);
          localBundle.putLong("lowTime", l1);
          paramObject = new ArrayList();
        }
        try
        {
          this.app.b().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), 0, paramToServiceMsg, paramObject, localBundle);
          if (paramToServiceMsg != null) {
            this.a.C(paramObject, false);
          }
          label683:
          return;
          label684:
          l1 = l2;
          paramToServiceMsg = paramObject;
          if (i == 1)
          {
            l1 = l2;
            paramToServiceMsg = paramObject;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
              l1 = l2;
              paramToServiceMsg = paramObject;
              continue;
              label726:
              bool1 = false;
              break label555;
              label732:
              bool2 = false;
              break label575;
              label738:
              this.app.a().r(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
              break label607;
              label775:
              if (bool3) {
                break label607;
              }
              if (bool1)
              {
                localBundle.putLong("tempEct", 0L);
                localBundle.putLong("tempRandom", 0L);
                break label607;
              }
              localBundle.putLong("tempEct", paramFromServiceMsg.last_msgtime.get());
              localBundle.putLong("tempRandom", paramFromServiceMsg.random.get());
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
      l1 = 0L;
    }
  }
  
  /* Error */
  private void aZ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1545
    //   7: invokevirtual 1320	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 4
    //   12: new 215	java/util/HashMap
    //   15: dup
    //   16: iconst_1
    //   17: invokespecial 1546	java/util/HashMap:<init>	(I)V
    //   20: astore 14
    //   22: aload 14
    //   24: ldc_w 1548
    //   27: aload_1
    //   28: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 1550
    //   34: invokevirtual 1341	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokevirtual 1419	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: pop
    //   41: aload 14
    //   43: ldc_w 1552
    //   46: aload_1
    //   47: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   50: ldc_w 1554
    //   53: invokevirtual 1307	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   56: invokestatic 1310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: invokevirtual 1419	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: aload 14
    //   65: ldc_w 1556
    //   68: iload 4
    //   70: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: invokevirtual 1419	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: new 1558	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   80: dup
    //   81: invokespecial 1559	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:<init>	()V
    //   84: astore 13
    //   86: aload 13
    //   88: aload_3
    //   89: checkcast 997	[B
    //   92: checkcast 997	[B
    //   95: invokevirtual 1560	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1558	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp
    //   101: astore 13
    //   103: aload 13
    //   105: ifnull +67 -> 172
    //   108: new 1562	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   111: dup
    //   112: invokespecial 1563	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:<init>	()V
    //   115: astore_3
    //   116: aload 13
    //   118: getfield 1566	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   121: invokevirtual 538	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   124: ifeq +139 -> 263
    //   127: aload_3
    //   128: aload 13
    //   130: getfield 1566	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:serialize_rspbody	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 544	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 550	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokevirtual 1567	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   142: checkcast 1562	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody
    //   145: astore_3
    //   146: aload_3
    //   147: ifnonnull +121 -> 268
    //   150: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +12 -> 165
    //   156: ldc 96
    //   158: iconst_2
    //   159: ldc_w 1569
    //   162: invokestatic 1356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload_0
    //   166: aload_1
    //   167: aload_2
    //   168: iconst_0
    //   169: invokespecial 1572	tob:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   172: return
    //   173: astore_3
    //   174: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 96
    //   182: iconst_2
    //   183: ldc_w 1574
    //   186: aload_3
    //   187: invokestatic 486	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: astore 13
    //   193: goto -90 -> 103
    //   196: astore_3
    //   197: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +13 -> 213
    //   203: ldc 96
    //   205: iconst_2
    //   206: ldc_w 1576
    //   209: aload_3
    //   210: invokestatic 486	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   213: aconst_null
    //   214: astore 13
    //   216: goto -113 -> 103
    //   219: astore_3
    //   220: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +13 -> 236
    //   226: ldc 96
    //   228: iconst_2
    //   229: ldc_w 1578
    //   232: aload_3
    //   233: invokestatic 486	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aconst_null
    //   237: astore_3
    //   238: goto -92 -> 146
    //   241: astore_3
    //   242: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +13 -> 258
    //   248: ldc 96
    //   250: iconst_2
    //   251: ldc_w 1580
    //   254: aload_3
    //   255: invokestatic 486	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aconst_null
    //   259: astore_3
    //   260: goto -114 -> 146
    //   263: aconst_null
    //   264: astore_3
    //   265: goto -119 -> 146
    //   268: aload_3
    //   269: getfield 1582	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:result	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   272: invokevirtual 1041	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   275: istore 5
    //   277: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +41 -> 321
    //   283: ldc 96
    //   285: iconst_2
    //   286: new 98	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   293: ldc_w 1584
    //   296: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: iload 5
    //   301: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   304: ldc_w 1586
    //   307: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload 4
    //   312: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 1356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: iload 5
    //   323: ifeq +9 -> 332
    //   326: iload 5
    //   328: iconst_1
    //   329: if_icmpne +701 -> 1030
    //   332: aload 13
    //   334: getfield 1587	msf/msgsvc/msg_svc$PbSearchRoamMsgInCloudResp:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   337: invokevirtual 195	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   340: astore 15
    //   342: aload 15
    //   344: ifnonnull +19 -> 363
    //   347: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq -178 -> 172
    //   353: ldc 96
    //   355: iconst_2
    //   356: ldc_w 1589
    //   359: invokestatic 1356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: return
    //   363: new 179	java/util/ArrayList
    //   366: dup
    //   367: invokespecial 180	java/util/ArrayList:<init>	()V
    //   370: astore 16
    //   372: aload_0
    //   373: aload 15
    //   375: aload 16
    //   377: invokespecial 213	tob:t	(Ljava/util/List;Ljava/util/List;)V
    //   380: aload_0
    //   381: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   384: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   387: invokestatic 224	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   390: lstore 10
    //   392: new 218	anax
    //   395: dup
    //   396: lload 10
    //   398: lconst_0
    //   399: iconst_1
    //   400: iconst_1
    //   401: iconst_0
    //   402: iconst_0
    //   403: invokespecial 227	anax:<init>	(JJZZZZ)V
    //   406: astore 17
    //   408: aload 17
    //   410: iconst_1
    //   411: putfield 318	anax:cEH	Z
    //   414: new 179	java/util/ArrayList
    //   417: dup
    //   418: invokespecial 180	java/util/ArrayList:<init>	()V
    //   421: astore 13
    //   423: aload 16
    //   425: invokevirtual 608	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   428: astore 18
    //   430: aload 18
    //   432: invokeinterface 165 1 0
    //   437: ifeq +255 -> 692
    //   440: aload 18
    //   442: invokeinterface 169 1 0
    //   447: checkcast 242	msf/msgcomm/msg_comm$Msg
    //   450: astore_2
    //   451: aload_2
    //   452: ifnull +23 -> 475
    //   455: aload_2
    //   456: getfield 246	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   459: invokevirtual 252	msf/msgcomm/msg_comm$MsgHead:has	()Z
    //   462: ifeq +13 -> 475
    //   465: aload_2
    //   466: getfield 527	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   469: invokevirtual 530	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   472: ifne +113 -> 585
    //   475: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq -48 -> 430
    //   481: new 98	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 1591
    //   491: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: astore 19
    //   496: aload_2
    //   497: ifnonnull +45 -> 542
    //   500: ldc_w 1593
    //   503: astore_2
    //   504: ldc 96
    //   506: iconst_2
    //   507: aload 19
    //   509: aload_2
    //   510: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: goto -89 -> 430
    //   522: astore_2
    //   523: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq -96 -> 430
    //   529: ldc 96
    //   531: iconst_2
    //   532: ldc_w 1595
    //   535: aload_2
    //   536: invokestatic 486	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   539: goto -109 -> 430
    //   542: new 98	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 1597
    //   552: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_2
    //   556: getfield 246	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   559: invokevirtual 514	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   562: ldc_w 1599
    //   565: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_2
    //   569: getfield 527	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   572: invokevirtual 530	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   575: invokevirtual 848	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   578: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: astore_2
    //   582: goto -78 -> 504
    //   585: aload_2
    //   586: getfield 246	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   589: invokevirtual 251	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   592: checkcast 248	msf/msgcomm/msg_comm$MsgHead
    //   595: astore 19
    //   597: aload 19
    //   599: getfield 260	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   602: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   605: lstore 6
    //   607: aload 19
    //   609: getfield 267	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   612: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   615: lstore 8
    //   617: lload 6
    //   619: lload 10
    //   621: lcmp
    //   622: ifeq +416 -> 1038
    //   625: lload 8
    //   627: lload 10
    //   629: lcmp
    //   630: ifeq +408 -> 1038
    //   633: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq -206 -> 430
    //   639: ldc 96
    //   641: iconst_2
    //   642: ldc_w 1601
    //   645: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto -218 -> 430
    //   651: aload 17
    //   653: lload 6
    //   655: putfield 315	anax:friendUin	J
    //   658: aload_0
    //   659: aload_2
    //   660: aload 17
    //   662: invokevirtual 321	tob:a	(Lmsf/msgcomm/msg_comm$Msg;Lanbl;)Ljava/util/List;
    //   665: astore_2
    //   666: aload_2
    //   667: ifnull -237 -> 430
    //   670: aload_2
    //   671: invokeinterface 628 1 0
    //   676: ifne -246 -> 430
    //   679: aload 13
    //   681: aload_2
    //   682: invokevirtual 1427	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   685: pop
    //   686: goto -256 -> 430
    //   689: goto -38 -> 651
    //   692: aload 13
    //   694: invokevirtual 237	java/util/ArrayList:size	()I
    //   697: ifle +16 -> 713
    //   700: aload 13
    //   702: new 1603	tof
    //   705: dup
    //   706: aload_0
    //   707: invokespecial 1604	tof:<init>	(Ltob;)V
    //   710: invokestatic 1090	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   713: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +63 -> 779
    //   719: ldc 96
    //   721: iconst_2
    //   722: new 98	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 1606
    //   732: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 15
    //   737: invokeinterface 198 1 0
    //   742: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   745: ldc_w 1608
    //   748: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload 16
    //   753: invokevirtual 237	java/util/ArrayList:size	()I
    //   756: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: ldc_w 1610
    //   762: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: aload 13
    //   767: invokevirtual 237	java/util/ArrayList:size	()I
    //   770: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   773: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   776: invokestatic 1356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   779: aload_3
    //   780: getfield 1613	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   783: invokevirtual 1614	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   786: ifeq +124 -> 910
    //   789: aload_3
    //   790: getfield 1613	tencent/im/oidb/searcher/oidb_c2c_searcher$RspBody:friends	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   793: invokevirtual 195	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   796: astore_2
    //   797: aload_2
    //   798: ifnull +117 -> 915
    //   801: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   804: ifeq +34 -> 838
    //   807: ldc 96
    //   809: iconst_2
    //   810: new 98	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   817: ldc_w 1616
    //   820: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_2
    //   824: invokeinterface 198 1 0
    //   829: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   832: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   835: invokestatic 1356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   838: aload 13
    //   840: invokevirtual 237	java/util/ArrayList:size	()I
    //   843: ifne +126 -> 969
    //   846: iload 5
    //   848: iconst_1
    //   849: if_icmpeq +120 -> 969
    //   852: aload_1
    //   853: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   856: ldc_w 1618
    //   859: invokevirtual 1320	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   862: istore 5
    //   864: iload 5
    //   866: iconst_4
    //   867: if_icmpge +66 -> 933
    //   870: aload_0
    //   871: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   874: invokevirtual 688	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   877: iload 4
    //   879: aconst_null
    //   880: aload_1
    //   881: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   884: ldc_w 1550
    //   887: invokevirtual 1341	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   890: aload_1
    //   891: getfield 978	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   894: ldc_w 1554
    //   897: invokevirtual 1307	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   900: aload_2
    //   901: iload 5
    //   903: iconst_1
    //   904: iadd
    //   905: lconst_0
    //   906: invokevirtual 1621	com/tencent/mobileqq/app/MessageHandler:a	(ILjava/util/List;Ljava/lang/String;JLjava/util/List;IJ)V
    //   909: return
    //   910: aconst_null
    //   911: astore_2
    //   912: goto -115 -> 797
    //   915: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   918: ifeq -80 -> 838
    //   921: ldc 96
    //   923: iconst_2
    //   924: ldc_w 1623
    //   927: invokestatic 1356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   930: goto -92 -> 838
    //   933: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   936: ifeq +12 -> 948
    //   939: ldc 96
    //   941: iconst_2
    //   942: ldc_w 1625
    //   945: invokestatic 1356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   948: aload 14
    //   950: ldc_w 1627
    //   953: aload_2
    //   954: invokevirtual 1419	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   957: pop
    //   958: aload_0
    //   959: sipush 8015
    //   962: iconst_0
    //   963: aload 14
    //   965: invokevirtual 1293	tob:b	(IZLjava/lang/Object;)V
    //   968: return
    //   969: aload 14
    //   971: ldc_w 1627
    //   974: aload_2
    //   975: invokevirtual 1419	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   978: pop
    //   979: aload 14
    //   981: ldc_w 1629
    //   984: aload 13
    //   986: invokevirtual 1419	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   989: pop
    //   990: iload 5
    //   992: iconst_1
    //   993: if_icmpne +31 -> 1024
    //   996: iconst_1
    //   997: istore 12
    //   999: aload 14
    //   1001: ldc_w 1631
    //   1004: iload 12
    //   1006: invokestatic 1027	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1009: invokevirtual 1419	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1012: pop
    //   1013: aload_0
    //   1014: sipush 8015
    //   1017: iconst_1
    //   1018: aload 14
    //   1020: invokevirtual 1293	tob:b	(IZLjava/lang/Object;)V
    //   1023: return
    //   1024: iconst_0
    //   1025: istore 12
    //   1027: goto -28 -> 999
    //   1030: aload_0
    //   1031: aload_1
    //   1032: aload_2
    //   1033: iconst_0
    //   1034: invokespecial 1572	tob:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Z)V
    //   1037: return
    //   1038: lload 6
    //   1040: lload 10
    //   1042: lcmp
    //   1043: ifne -354 -> 689
    //   1046: lload 8
    //   1048: lstore 6
    //   1050: goto -399 -> 651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1053	0	this	tob
    //   0	1053	1	paramToServiceMsg	ToServiceMsg
    //   0	1053	2	paramFromServiceMsg	FromServiceMsg
    //   0	1053	3	paramObject	Object
    //   10	868	4	i	int
    //   275	719	5	j	int
    //   605	444	6	l1	long
    //   615	432	8	l2	long
    //   390	651	10	l3	long
    //   997	29	12	bool	boolean
    //   84	901	13	localObject1	Object
    //   20	999	14	localHashMap	HashMap
    //   340	396	15	localList	List
    //   370	382	16	localArrayList	ArrayList
    //   406	255	17	localanax	anax
    //   428	13	18	localIterator	Iterator
    //   494	114	19	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   86	103	173	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   86	103	196	java/lang/OutOfMemoryError
    //   127	146	219	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   127	146	241	java/lang/OutOfMemoryError
    //   455	475	522	java/lang/Exception
    //   475	496	522	java/lang/Exception
    //   504	519	522	java/lang/Exception
    //   542	582	522	java/lang/Exception
    //   585	617	522	java/lang/Exception
    //   633	648	522	java/lang/Exception
    //   651	666	522	java/lang/Exception
    //   670	686	522	java/lang/Exception
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    paramFromServiceMsg = new HashMap(1);
    paramFromServiceMsg.put("KEYWORD", paramToServiceMsg.extraData.getString("keyword"));
    paramFromServiceMsg.put("SEARCHSEQUENCE", Long.valueOf(paramToServiceMsg.extraData.getLong("sequence")));
    paramFromServiceMsg.put("LOADTYPE", Integer.valueOf(paramToServiceMsg.extraData.getInt("loadType")));
    int i = paramToServiceMsg.extraData.getInt("retryIndex");
    if ((!paramBoolean) && (i < 2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.C2CMessageProcessor", 2, "handleSearchRoamMsgInCloudTimeOutAndError retry index:" + i);
      }
      paramToServiceMsg.extraData.putInt("retryIndex", i + 1);
      this.app.a().sendPbReq(paramToServiceMsg);
      return;
    }
    b(8015, false, paramFromServiceMsg);
  }
  
  private void b(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
    }
    long l1;
    long l2;
    int i;
    long l7;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    MessageRecord localMessageRecord;
    Object localObject2;
    int k;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      i = localMsgHead.user_active.get();
      j = localMsgHead.from_instid.get();
      Object localObject1;
      ArrayList localArrayList1;
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.app.getCurrentAccountUin());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + i + ",fromInstid:" + j + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.app.cxj = i;
        localArrayList1 = new ArrayList();
      }
      try
      {
        localObject1 = new anax(l7, l3, true, false, false, false);
        ((anax)localObject1).cEH = true;
        localObject1 = a(paramMsg, (anbl)localObject1);
        achp.iZ((List)localObject1);
        if ((localObject1 != null) && (((List)localObject1).size() != 0))
        {
          if (localArrayList1 != null) {
            a((List)localObject1, localArrayList1, true);
          }
          i = 0;
          localObject1 = null;
          localArrayList2 = new ArrayList();
          localArrayList3 = new ArrayList();
          if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
            break label1514;
          }
          int i3 = localArrayList1.size();
          int i1 = 0;
          for (;;)
          {
            if (i1 >= i3) {
              break label1368;
            }
            localMessageRecord = (MessageRecord)localArrayList1.get(i1);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
            }
            localObject3 = localObject1;
            m = i;
            if (localMessageRecord.frienduin != null)
            {
              if (localMessageRecord.frienduin.length() > 2) {
                break;
              }
              m = i;
              localObject3 = localObject1;
            }
            i1 += 1;
            localObject1 = localObject3;
            i = m;
          }
          localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException1);
          }
          localObject2 = null;
        }
        localMessageRecord.isread = true;
        localMessageRecord.issend = 2;
        k = 0;
        if (!(localMessageRecord instanceof MessageForStructing)) {
          break label1331;
        }
      }
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)localMessageRecord;
    int j = k;
    Object localObject3 = localObject2;
    int m = i;
    if (localMessageForStructing != null)
    {
      j = k;
      localObject3 = localObject2;
      m = i;
      if (localMessageForStructing.structingMsg != null)
      {
        j = k;
        localObject3 = localObject2;
        m = i;
        if (localMessageForStructing.structingMsg.mMsgServiceID == 128) {
          localObject3 = localMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
        }
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt((String)localObject3);
        if ((j & 0x4) == 4)
        {
          k = 1;
          m = i;
          if (k != 0)
          {
            localMessageForStructing.extraflag = 32768;
            localMessageRecord.issend = 1;
            localMessageForStructing.saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(j & 0xFFFFFFFB));
            localObject2 = localMessageForStructing.frienduin;
            m = 1;
          }
          localMessageForStructing.isCheckNeedShowInListTypeMsg = true;
          i = -1;
          k = i;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          try
          {
            localObject3 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
            j = i;
            if (localObject3 != null)
            {
              j = i;
              k = i;
              if (((List)localObject3).size() > 0)
              {
                i2 = 0;
                j = i;
                k = i;
                if (i2 < ((List)localObject3).size())
                {
                  k = i;
                  localElem = (im_msg_body.Elem)((List)localObject3).get(i2);
                  k = i;
                  if (!localElem.general_flags.has()) {
                    continue;
                  }
                  k = i;
                  bool = localElem.general_flags.bytes_pb_reserve.has();
                  if (!bool) {
                    continue;
                  }
                  n = i;
                  k = i;
                }
              }
            }
          }
          catch (Throwable localThrowable2)
          {
            int i2;
            im_msg_body.Elem localElem;
            boolean bool;
            int n;
            generalflags.ResvAttr localResvAttr;
            Object localObject4;
            j = k;
            continue;
            continue;
          }
          try
          {
            localResvAttr = new generalflags.ResvAttr();
            n = i;
            k = i;
            localResvAttr.mergeFrom(localElem.general_flags.bytes_pb_reserve.get().toByteArray());
            n = i;
            k = i;
            if (!localResvAttr.uint32_show_in_msg_list.has()) {
              continue;
            }
            n = i;
            k = i;
            i = localResvAttr.uint32_show_in_msg_list.get();
            j = i;
            n = i;
            k = i;
            if (QLog.isColorLevel())
            {
              n = i;
              k = i;
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster has uint32ShowInMsgList:" + i);
              j = i;
            }
            if (j != 1) {
              continue;
            }
            bool = true;
            localMessageForStructing.needNeedShowInList = bool;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster isCheckNeedShowInListTypeMsg:" + localMessageForStructing.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + localMessageForStructing.needNeedShowInList + " uint32ShowInMsgList:" + j);
            }
            j = 1;
            localObject3 = localObject2;
            if (j == 0) {
              this.app.b().s(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.time);
            }
            localArrayList3.add(localMessageRecord);
            localObject2 = new DelMsgInfo();
            ((DelMsgInfo)localObject2).lFromUin = Long.parseLong(localMessageRecord.senderuin);
            ((DelMsgInfo)localObject2).shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
            ((DelMsgInfo)localObject2).uMsgTime = localMessageRecord.time;
            localArrayList2.add(localObject2);
          }
          catch (Exception localException2)
          {
            i = n;
            try
            {
              QLog.e("msgFold", 1, "prase ResvAttr error, ", localException2);
            }
            catch (Throwable localThrowable1)
            {
              j = i;
            }
          }
        }
        localNumberFormatException = localNumberFormatException;
        localNumberFormatException.printStackTrace();
        j = 0;
        continue;
        k = 0;
        continue;
      }
      i2 += 1;
      continue;
      QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", localThrowable1);
      continue;
      bool = false;
      continue;
      label1331:
      j = k;
      localObject4 = localObject2;
      m = i;
      if (localMessageRecord.msgtype == -10000)
      {
        j = 1;
        localObject4 = localObject2;
        m = i;
      }
    }
    for (;;)
    {
      label1368:
      this.app.a().mp(localArrayList3);
      this.app.b().c(localArrayList3, String.valueOf(l7), false);
      this.app.a().UG(localMsgHead.msg_seq.get());
      j = paramFromServiceMsg.getRequestSsoSeq();
      this.a.a(l2, localArrayList2, paramPbPushMsg.svrip.get(), j, null);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_SlaveMaster", true, 0, this.a.aO(false), false);
      this.a.dI(localArrayList3);
      if ((i == 0) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break;
      }
      anbk.aI(this.app, (String)localObject2);
      return;
      label1514:
      i = 0;
      localObject2 = null;
    }
  }
  
  private void cK(ArrayList<MessageRecord> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -3006) || (localMessageRecord.msgtype == -5004))
      {
        PAMessage localPAMessage = wna.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          anot.b(this.app, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
      }
      if ((localMessageRecord.mQidianMasterUin != 0L) && (!TextUtils.isEmpty(localMessageRecord.mQidianTipText)) && (localMessageRecord.mIsShowQidianTips == 1)) {
        ThreadManager.executeOnSubThread(new C2CMessageProcessor.4(this, localMessageRecord));
      }
    }
    this.a.dI(paramArrayList);
  }
  
  private void fo(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis() / 1000L;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if (localMessageRecord.istroop == 1008) {
          if ((!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_send_flag"))) && (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"))) && (!TextUtils.equals(localMessageRecord.frienduin, localMessageRecord.selfuin))) {
            ThreadManager.post(new C2CMessageProcessor.6(this, localMessageRecord.frienduin, localMessageRecord.selfuin, localMessageRecord.getExtInfoFromExtStr("public_account_msg_id"), localMessageRecord.time, l, localMessageRecord.getExtInfoFromExtStr("public_account_send_flag")), 5, null, false);
          } else if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
          }
        }
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    b(1004, false, paramFromServiceMsg);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = new Bundle();
    paramFromServiceMsg.putLong("BEGTIME", paramToServiceMsg.extraData.getLong("lBeginTime"));
    paramFromServiceMsg.putBoolean("FETCH_MORE", paramToServiceMsg.extraData.getBoolean("fetchMore"));
    b(1004, false, paramFromServiceMsg);
  }
  
  private boolean q(MessageRecord paramMessageRecord)
  {
    return this.app.a().b(paramMessageRecord.frienduin, paramMessageRecord.msgUid, paramMessageRecord.shmsgseq);
  }
  
  private void t(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---C2CMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_uid_" + l1 + "_seq_" + l2;
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, anbl paramanbl)
  {
    if (!(paramanbl instanceof anax)) {
      return new ArrayList();
    }
    anax localanax = (anax)paramanbl;
    long l4 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        paramanbl = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
        if (paramMsg != null) {
          break label104;
        }
      }
      label104:
      for (paramMsg = " msg=null";; paramMsg = " msg.msg_head:" + paramMsg.msg_head + " msg.msg_body:" + paramMsg.msg_body.has())
      {
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramMsg);
        return localArrayList;
      }
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int n = (short)localMsgHead.msg_seq.get();
    long l2 = localMsgHead.to_uin.get();
    long l5 = localMsgHead.from_uin.get();
    long l3 = localMsgHead.msg_time.get();
    long l6 = localMsgHead.msg_uid.get();
    int i1 = localMsgHead.msg_type.get();
    int i = paramMsg.msg_head.c2c_cmd.get();
    localanax.friendType = 0;
    localanax.dEO = 0;
    int m;
    int k;
    int j;
    if (paramMsg.content_head.has())
    {
      paramanbl = (msg_comm.ContentHead)paramMsg.content_head.get();
      m = paramanbl.div_seq.get();
      k = paramanbl.pkg_num.get();
      j = paramanbl.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      paramanbl = null;
      if (!localanax.cEE)
      {
        paramanbl = anbh.a(this.a, paramMsg, String.valueOf(localanax.friendUin), String.valueOf(l5));
        if (((Long)paramanbl.first).longValue() == 4294967295L) {
          break label974;
        }
        l1 = ((Long)paramanbl.first).longValue();
      }
      label430:
      label631:
      Object localObject3;
      for (;;)
      {
        localanax.senderUin = l5;
        localanax.msgTime = l3;
        int i2 = anbh.a(paramMsg);
        localanax.dEN = i2;
        localanax.vipBubbleID = acle.g((int)l1, i2);
        localanax.vipSubBubbleId = anbh.e(paramMsg);
        Object localObject1;
        Object localObject2;
        if (l5 == localanax.akr)
        {
          localanax.isRead = true;
          localanax.cEG = true;
          if (!QLog.isColorLevel()) {
            break label1009;
          }
          localObject1 = new StringBuilder();
          localObject2 = ((StringBuilder)localObject1).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l3).append(" shortSeq:").append(n).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l6).append(" toUin:").append(l2).append(" senderUin:").append(l5).append(" friendUin:").append(localanax.friendUin).append(" isReaded:").append(localanax.isRead).append(" isSyncFromOtherTerm:").append(localanax.cEG).append(" msgType:").append(i1).append(" c2CCmd:").append(i).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:");
          if (paramanbl != null) {
            break label998;
          }
          paramanbl = "nullPair";
          ((StringBuilder)localObject2).append(paramanbl).append(" longMsgID:").append(m).append(" longMsgCount:").append(k).append(" longMsgIndex:").append(j).append("init_direction_flag").append(localanax.dEO);
          QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
          label696:
          paramanbl = new ArrayList();
          a(i1, paramMsg, paramanbl, this.a, localanax);
          a(paramMsg, paramanbl, localanax, this.a);
          if ((paramanbl.size() == 0) && (k > 1))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C, empty long msg fragment");
            }
            localObject1 = (MessageForText)anbi.d(-1000);
            ((MessageForText)localObject1).msgtype = -1000;
            ((MessageForText)localObject1).msg = "";
            paramanbl.add(localObject1);
          }
          l1 = -1L;
          l2 = l1;
        }
        try
        {
          localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          l3 = l1;
          if (localObject1 != null)
          {
            l3 = l1;
            l2 = l1;
            if (((List)localObject1).size() > 0)
            {
              i = 0;
              for (;;)
              {
                l3 = l1;
                l2 = l1;
                if (i >= ((List)localObject1).size()) {
                  break;
                }
                l2 = l1;
                localObject2 = (im_msg_body.Elem)((List)localObject1).get(i);
                l3 = l1;
                l2 = l1;
                if (((im_msg_body.Elem)localObject2).elem_flags2.has())
                {
                  l3 = l1;
                  l2 = l1;
                  if (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.has())
                  {
                    l2 = l1;
                    l3 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint64_msg_id.get();
                  }
                }
                i += 1;
                l1 = l3;
              }
              label974:
              l1 = ((Long)paramanbl.second).longValue();
              continue;
              localanax.cEG = false;
              break label430;
              label998:
              paramanbl = (Serializable)paramanbl.first;
              break label631;
              label1009:
              if (localanax.friendUin != 0L) {
                break label696;
              }
              QLog.e("Q.msg.C2CMessageProcessor", 1, "<---decodeSinglePBMsg_C2C : decode msg: frienduin=0");
              break label696;
            }
          }
          l1 = l3;
        }
        catch (Throwable localThrowable)
        {
          do
          {
            for (;;)
            {
              QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeSinglePBMsg_C2C: ", localThrowable);
              l1 = l2;
              continue;
              localMessageRecord.selfuin = String.valueOf(localanax.akr);
              localMessageRecord.frienduin = String.valueOf(localanax.friendUin);
              localMessageRecord.senderuin = String.valueOf(localanax.senderUin);
              localMessageRecord.time = localanax.msgTime;
              localMessageRecord.shmsgseq = n;
              localMessageRecord.msgUid = l6;
              localMessageRecord.istroop = localanax.friendType;
              localMessageRecord.longMsgId = m;
              localMessageRecord.longMsgCount = k;
              localMessageRecord.longMsgIndex = j;
              if ((1 == localanax.dEO) && (top.fL(localMessageRecord.istroop)) && (top.eD(localMessageRecord.istroop) != 1032) && (!this.app.a().gO(localMessageRecord.frienduin)) && (!this.app.a().f(localMessageRecord.frienduin, top.eD(localMessageRecord.istroop), top.co(top.eD(localMessageRecord.istroop)))))
              {
                top.a(localMessageRecord, true);
                if (localMessageRecord.msgtype == -2058) {
                  EmojiStickerManager.f(localMessageRecord, this.app);
                }
                if ((!top.fL(localanax.friendType)) || (!(localMessageRecord instanceof MessageForStructing))) {
                  break label1819;
                }
                i = acqu.a(localMessageRecord, 1);
                if (i > 0) {
                  localMessageRecord.saveExtInfoToExtStr("nearby_gift_msg", "1|" + i);
                }
                paramanbl = (MessageForStructing)localMessageRecord;
                if ((paramanbl.structingMsg.mMsgServiceID != 52) || ((acie)this.app.getManager(124) == null)) {
                  break label1819;
                }
                paramanbl = new NearbyFlowerMessage(this.app, paramanbl);
                if (!this.app.getCurrentUin().equals(paramanbl.sUin)) {
                  break label1763;
                }
                anot.a(this.app, "CliOper", "", "", "0X80060AF", "0X80060AF", 0, 0, "", "", "", "");
              }
              for (;;)
              {
                if (!"4".equals(paramanbl.version)) {
                  break label1819;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.C2CMessageProcessor", 2, "<---received random chat flower message, don't put it to aio");
                }
                anbh.a(this.a, l5, n, l6, i1);
                break;
                top.a(localMessageRecord, false);
                break label1531;
                if (this.app.getCurrentUin().equals(paramanbl.rUin)) {
                  anot.a(this.app, "CliOper", "", "", "0X80060B0", "0X80060B0", 0, 0, "", "", "", "");
                }
              }
              paramanbl = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
              if ((paramanbl != null) && (paramanbl.lock_display.has()) && (paramanbl.lock_display.get() == 1))
              {
                localMessageRecord.extLong |= 0x1;
                localMessageRecord.saveExtInfoToExtStr("lockDisplay", "true");
              }
              if ((localanax.friendType == 0) && ((localMessageRecord instanceof MessageForPic))) {
                ((MessageForPic)localMessageRecord).bEnableEnc = true;
              }
              if (localanax.friendType == 1006)
              {
                if (localMsgHead.from_nick.has()) {
                  ((acff)this.app.getManager(51)).eK(String.valueOf(localanax.friendUin), localMsgHead.from_nick.get());
                }
                localMessageRecord.frienduin = aqgv.y(this.app, String.valueOf(localanax.friendUin));
                localMessageRecord.senderuin = aqgv.y(this.app, String.valueOf(l5));
                if ((TextUtils.isEmpty(localMessageRecord.frienduin)) && (localanax.cEE)) {
                  localMessageRecord.frienduin = String.valueOf(localanax.friendUin);
                }
                if (localMessageRecord.frienduin == null)
                {
                  QLog.e("Q.msg.C2CMessageProcessor", 1, String.format("decodeMessage error, getPhoneNumByUin is null, friendUin: %d senderUin: %d uinType: %d msgType: %d", new Object[] { Long.valueOf(localanax.friendUin), Long.valueOf(l5), Integer.valueOf(localMessageRecord.istroop), Integer.valueOf(localMessageRecord.msgtype) }));
                  continue;
                }
              }
              if (localanax.cEG)
              {
                localMessageRecord.issend = 2;
                localMessageRecord.isread = true;
                if ((localMessageRecord instanceof MessageForPoke))
                {
                  if ((!localMessageRecord.isread) && (!localMessageRecord.isSend())) {
                    ((MessageForPoke)localMessageRecord).isPlayed = false;
                  }
                  ((MessageForPoke)localMessageRecord).initMsg();
                }
                localMessageRecord.vipBubbleID = localanax.vipBubbleID;
                localMessageRecord.vipBubbleDiyTextId = localanax.dEN;
                localMessageRecord.vipSubBubbleId = localanax.vipSubBubbleId;
                if (localanax.vipSubBubbleId > 0) {
                  localMessageRecord.saveExtInfoToExtStr("bubble_sub_id", String.valueOf(localanax.vipSubBubbleId));
                }
                i = anbh.c(paramMsg);
                if (i > 0) {
                  localMessageRecord.saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i));
                }
                i = anbh.b(paramMsg);
                if (i >= 0) {
                  localMessageRecord.saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(i));
                }
                i = anbh.d(paramMsg);
                if (i >= 0) {
                  localMessageRecord.saveExtInfoToExtStr("vip_face_id", String.valueOf(i));
                }
                if (localMessageRecord.istroop != 1008) {}
              }
              try
              {
                if (localMsgHead.public_account_group_send_flag.has()) {
                  localMessageRecord.saveExtInfoToExtStr("public_account_send_flag", String.valueOf(localMsgHead.public_account_group_send_flag.get()));
                }
                if (l1 != -1L) {
                  localMessageRecord.saveExtInfoToExtStr("public_account_msg_id", String.valueOf(l1));
                }
                if ((localMessageRecord instanceof MessageForStructing))
                {
                  paramanbl = (MessageForStructing)localMessageRecord;
                  if ((paramanbl.structingMsg != null) && (paramanbl.structingMsg.mMsgServiceID == 76)) {
                    ((jsp)this.app.getManager(171)).a(paramanbl);
                  }
                }
                if (localMessageRecord.msgtype == -7005)
                {
                  aine.g(localMessageRecord, this.app);
                  continue;
                  if (localMessageRecord.msgtype == -2037) {
                    break label2114;
                  }
                  localMessageRecord.isread = localanax.isRead;
                }
              }
              catch (Throwable paramanbl)
              {
                for (;;)
                {
                  QLog.e("Q.msg.C2CMessageProcessor", 2, "<---decodeMessage: ", paramanbl);
                }
                localArrayList.add(localMessageRecord);
                if (localanax.friendType == 1036) {
                  anbh.a(this.a, l5, n, l6, i1);
                }
              }
            }
          } while (localMessageRecord.msgtype != -2039);
          localObject3 = (MessageForApollo)localMessageRecord;
          localabhh = (abhh)this.app.getManager(153);
          paramanbl = null;
          if (!QLog.isColorLevel()) {
            break label2601;
          }
          paramanbl = new StringBuilder("decode apollo c2c msg: ").append(", id: ").append(((MessageForApollo)localObject3).mApolloMessage.id).append(", name: ").append(new String(((MessageForApollo)localObject3).mApolloMessage.name)).append(", doubleAction: ").append(((MessageForApollo)localObject3).isDoubleAction()).append(", signTS: ").append(((MessageForApollo)localObject3).signTs);
          i3 = ((MessageForApollo)localObject3).isSend();
          if (((MessageForApollo)localObject3).mApolloMessage.peer_uin == 0L) {
            break label3171;
          }
        }
      }
      localObject2 = paramanbl.iterator();
      MessageRecord localMessageRecord;
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label3309;
        }
        localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        if ((localMessageRecord != null) && ((localanax.senderUin != 3338705755L) || (!ocp.t(this.app))) && ((localanax.senderUin != 2171946401L) || (!kxm.e(this.app))))
        {
          if (localanax.senderUin == 2171946401L) {
            ocp.k(this.app, true);
          }
          if (((localanax.friendType != 1025) && (localanax.friendType != 1024)) || (localMessageRecord.msgtype != -1000) || (!localMessageRecord.msg.startsWith("default:SigT=")))
          {
            if (top.eD(localanax.friendType) != 1032) {
              break;
            }
            localObject1 = null;
            paramanbl = (anbl)localObject1;
            if (this.app != null)
            {
              localObject3 = this.app.a();
              paramanbl = (anbl)localObject1;
              if (localObject3 != null) {
                paramanbl = ((anaz)localObject3).c(String.valueOf(localanax.friendUin), String.valueOf(localanax.akr));
              }
            }
            anbh.a(this.a, l5, n, l6, i1, paramanbl);
            if (localanax.friendType != 1032) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.C2CMessageProcessor", 2, String.format("decodeMessage discard confess msg senderUin:%s msgSeq:%d msgType:%d", new Object[] { Long.toString(l5), Integer.valueOf(n), Integer.valueOf(i1) }));
            }
          }
        }
      }
      label1531:
      abhh localabhh;
      label1763:
      int i3;
      label1819:
      label2114:
      i = 1;
      label2601:
      label2623:
      ApolloBaseInfo localApolloBaseInfo;
      if (((i & i3) != 0) && (((MessageForApollo)localObject3).mApolloMessage.peer_uin != this.app.getLongAccountUin()))
      {
        localApolloBaseInfo = localabhh.b(((MessageForApollo)localObject3).mApolloMessage.peer_uin + "");
        l2 = ((MessageForApollo)localObject3).mApolloMessage.peer_ts;
        i = ((MessageForApollo)localObject3).mApolloMessage.peer_status;
        label2702:
        if ((QLog.isColorLevel()) && (localApolloBaseInfo != null)) {
          paramanbl.append("\n fuin: ").append(localApolloBaseInfo.uin).append(", msg time: ").append(localMessageRecord.time).append(", msg ts: ").append(l2).append(", svr ts: ").append(localApolloBaseInfo.apolloServerTS).append(", update time: ").append(localApolloBaseInfo.apolloUpdateTime).append(", status: ").append(i);
        }
        if ((localApolloBaseInfo == null) || (localMessageRecord.time <= localApolloBaseInfo.apolloUpdateTime) || (localApolloBaseInfo.apolloServerTS >= l2)) {
          break label3210;
        }
        localApolloBaseInfo.apolloStatus = i;
        localApolloBaseInfo.apolloServerTS = l2;
        localApolloBaseInfo.apolloVipFlag = (((MessageForApollo)localObject3).mApolloMessage.flag >> 30 & 0x1);
        localApolloBaseInfo.apolloUpdateTime = localMessageRecord.time;
        if ((((MessageForApollo)localObject3).isSend()) || (((MessageForApollo)localObject3).signTs <= NetConnInfoCenter.getServerTime()) || (((MessageForApollo)localObject3).signTs == localApolloBaseInfo.apolloSignValidTS)) {
          break label3587;
        }
        localApolloBaseInfo.apolloSignValidTS = ((MessageForApollo)localObject3).signTs;
        localApolloBaseInfo.apolloSignStr = "";
        i = 1;
      }
      for (;;)
      {
        label2917:
        if (i != 0)
        {
          localabhh.a(localApolloBaseInfo);
          if (QLog.isColorLevel()) {
            paramanbl.append("\n save apollo info fuin: ").append(localApolloBaseInfo.uin).append("-->").append(localApolloBaseInfo.apolloVipFlag).append("|").append(localApolloBaseInfo.apolloStatus).append("|").append(localApolloBaseInfo.apolloLocalTS).append("|").append(localApolloBaseInfo.apolloServerTS).append("|").append(localApolloBaseInfo.apolloUpdateTime).append("|").append(localApolloBaseInfo.apolloSignValidTS);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, paramanbl.toString());
        }
        if (this.app == null) {
          break;
        }
        i = localabhh.cd(this.app.getCurrentUin());
        paramanbl = "";
        if (((MessageForApollo)localObject3).msgType == 0) {
          paramanbl = String.valueOf(((MessageForApollo)localObject3).mApolloMessage.id);
        }
        for (;;)
        {
          VipUtils.a(this.app, "cmshow", "Apollo", "rev_action", String.valueOf(((MessageForApollo)localObject3).mApolloMessage.peer_uin), 0, ((MessageForApollo)localObject3).msgType, new String[] { paramanbl, Integer.toString(i), Integer.toString(abhh.a(this.app)), String.valueOf(System.currentTimeMillis() / 1000L) });
          break;
          label3171:
          i = 0;
          break label2623;
          localApolloBaseInfo = localabhh.b(((MessageForApollo)localObject3).senderuin);
          l2 = ((MessageForApollo)localObject3).mApolloMessage.sender_ts;
          i = ((MessageForApollo)localObject3).mApolloMessage.sender_status;
          break label2702;
          label3210:
          if ((localApolloBaseInfo == null) || (((MessageForApollo)localObject3).isSend()) || (((MessageForApollo)localObject3).signTs <= NetConnInfoCenter.getServerTime()) || (((MessageForApollo)localObject3).signTs == localApolloBaseInfo.apolloSignValidTS)) {
            break label3587;
          }
          localApolloBaseInfo.apolloSignValidTS = ((MessageForApollo)localObject3).signTs;
          localApolloBaseInfo.apolloSignStr = "";
          i = 1;
          break label2917;
          if (((MessageForApollo)localObject3).msgType == 2) {
            paramanbl = "" + ((MessageForApollo)localObject3).gameId;
          }
        }
        label3309:
        if ((localanax.friendType == 1008) && (paramMsg.msg_body.has()))
        {
          paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
          if (paramMsg.rich_text.has())
          {
            paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
            if (paramMsg.elems.has())
            {
              paramMsg = paramMsg.elems.get().iterator();
              while (paramMsg.hasNext())
              {
                paramanbl = (im_msg_body.Elem)paramMsg.next();
                if (paramanbl.pub_acc_info.has())
                {
                  i = paramanbl.pub_acc_info.uint32_is_inter_num.get();
                  paramMsg = paramanbl.pub_acc_info.string_msg_template_id.get();
                  if (i != 0)
                  {
                    paramanbl = localArrayList.iterator();
                    while (paramanbl.hasNext()) {
                      ((MessageRecord)paramanbl.next()).saveExtInfoToExtStr("inter_num", String.valueOf(i));
                    }
                  }
                  paramanbl = localArrayList.iterator();
                  while (paramanbl.hasNext()) {
                    ((MessageRecord)paramanbl.next()).saveExtInfoToExtStr("msg_template_id", paramMsg);
                  }
                }
              }
            }
          }
        }
        MsgAutoMonitorUtil.getInstance().addDecodeC2CMsgTime(System.currentTimeMillis() - l4);
        j = 0;
        paramMsg = localArrayList.iterator();
        i = 0;
        if (paramMsg.hasNext())
        {
          paramanbl = (MessageRecord)paramMsg.next();
          j = paramanbl.istroop;
          if (paramanbl.isread) {
            break label3584;
          }
          i += 1;
        }
        label3584:
        for (;;)
        {
          break;
          anod.T(0, 1, j, i);
          return localArrayList;
        }
        label3587:
        i = 0;
      }
      j = 0;
      k = 0;
      m = 0;
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      j(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, false);
  }
  
  public void a(C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    String str = String.valueOf(paramC2CMsgReadedNotify.lPeerUin);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processPushReadedNotify is called. uAioType = " + paramC2CMsgReadedNotify.uAioType);
    }
    if (paramC2CMsgReadedNotify.uAioType == 3L) {
      ahti.a(this.app, str, paramC2CMsgReadedNotify);
    }
    do
    {
      return;
      this.app.b().s(str, 0, paramC2CMsgReadedNotify.lLastReadTime);
    } while (paramC2CMsgReadedNotify.lLastReadTime < 0L);
    this.app.b().a.ea(str, 0);
  }
  
  public void a(MessageForPtt paramMessageForPtt1, MessageForPtt paramMessageForPtt2)
  {
    bool2 = false;
    bool1 = bool2;
    if (paramMessageForPtt1.getPttStreamFlag() == 10001)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramMessageForPtt2.directUrl))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramMessageForPtt1.directUrl)) {}
      }
    }
    try
    {
      paramMessageForPtt1.directUrl = paramMessageForPtt2.directUrl;
      paramMessageForPtt1.serial();
      this.app.b().c(paramMessageForPtt1.frienduin, paramMessageForPtt1.istroop, paramMessageForPtt1.uniseq, paramMessageForPtt1.msgData);
      bool1 = true;
    }
    catch (Exception paramMessageForPtt1)
    {
      for (;;)
      {
        paramMessageForPtt1.printStackTrace();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "updateStreamPttDirectUrl : " + bool1);
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2001: 
      i(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, true);
  }
  
  public void cL(ArrayList<Pair<Long, Long>> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("-ReportList-");
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Pair localPair = (Pair)paramArrayList.next();
      msg_svc.PbC2CReadedReportReq.UinPairReadInfo localUinPairReadInfo = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      localUinPairReadInfo.peer_uin.set(((Long)localPair.first).longValue());
      localUinPairReadInfo.last_read_time.set(((Long)localPair.second).intValue());
      localStringBuilder.append("-uin:").append(localPair.first).append("-ReadTime-").append(localPair.second);
      localPbC2CReadedReportReq.pair_info.add(localUinPairReadInfo);
    }
    paramArrayList = this.app.a().a().am();
    if (paramArrayList != null) {
      localPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
    }
    localPbMsgReadedReportReq.c2c_read_report.set(localPbC2CReadedReportReq);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><S>_C2C:" + localStringBuilder.toString());
    }
    a(localPbMsgReadedReportReq);
  }
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processType" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        aW((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 2001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        aX((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 2005: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        aZ((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        aY((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
      return;
    }
    bN(getClass().getName(), paramInt);
  }
  
  public void m(String paramString, int paramInt, long paramLong)
  {
    super.m(paramString, paramInt, paramLong);
    if (top.fv(paramInt))
    {
      msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      a(paramString, paramInt, paramLong, localPbMsgReadedReportReq);
      a(localPbMsgReadedReportReq);
    }
  }
  
  public boolean r(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 1001) && (paramMessageRecord.istroop != 10002)) {}
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.app.getCurrentAccountUin()))) || (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && ((paramMessageRecord.msgtype == -3001) || (!top.v(paramMessageRecord)) || (top.d(this.app, paramMessageRecord))))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public void u(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokevirtual 237	java/util/ArrayList:size	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: invokestatic 2395	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   15: aload_0
    //   16: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   22: invokestatic 2401	com/tencent/mobileqq/activity/UserguideActivity:L	(Landroid/content/Context;Ljava/lang/String;)Z
    //   25: ifne -14 -> 11
    //   28: invokestatic 2395	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   31: invokevirtual 2405	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   34: aload_0
    //   35: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: invokestatic 2410	aqel:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;)Z
    //   41: ifeq -30 -> 11
    //   44: aload_1
    //   45: invokevirtual 608	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore 7
    //   50: aload 7
    //   52: invokeinterface 165 1 0
    //   57: ifeq +1587 -> 1644
    //   60: aload 7
    //   62: invokeinterface 169 1 0
    //   67: checkcast 323	com/tencent/mobileqq/data/MessageRecord
    //   70: astore 8
    //   72: aload 8
    //   74: getfield 336	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   77: invokestatic 2002	top:fL	(I)Z
    //   80: ifeq -30 -> 50
    //   83: aload 8
    //   85: invokestatic 2386	top:v	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   88: ifeq -38 -> 50
    //   91: aload_0
    //   92: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload 8
    //   97: invokestatic 2389	top:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   100: ifne -50 -> 50
    //   103: aload 8
    //   105: invokevirtual 2089	com/tencent/mobileqq/data/MessageRecord:isSend	()Z
    //   108: ifne -58 -> 50
    //   111: aload 8
    //   113: getfield 882	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   116: ifne -66 -> 50
    //   119: iconst_1
    //   120: istore_3
    //   121: iload_3
    //   122: ifeq -111 -> 11
    //   125: aload_0
    //   126: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 51
    //   131: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 1092	acff
    //   137: aload_0
    //   138: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   141: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   144: invokevirtual 2413	acff:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   147: astore 7
    //   149: aload_0
    //   150: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   153: invokevirtual 135	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   156: astore 10
    //   158: aload 7
    //   160: ifnonnull +566 -> 726
    //   163: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +1472 -> 1638
    //   169: ldc 96
    //   171: iconst_2
    //   172: ldc_w 2415
    //   175: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iconst_1
    //   179: istore 4
    //   181: aload_0
    //   182: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: bipush 106
    //   187: invokevirtual 396	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   190: checkcast 2417	ajpj
    //   193: invokevirtual 2420	ajpj:arq	()Z
    //   196: istore 6
    //   198: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +42 -> 243
    //   204: ldc_w 2422
    //   207: iconst_2
    //   208: new 98	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 2424
    //   218: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 4
    //   223: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: ldc_w 2426
    //   229: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: iload 6
    //   234: invokevirtual 848	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload_0
    //   244: getfield 2428	tob:aPZ	Z
    //   247: ifne +293 -> 540
    //   250: invokestatic 2433	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   253: getstatic 2439	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayDateMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   256: invokevirtual 2441	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   259: invokevirtual 2444	com/tencent/mobileqq/app/DeviceProfileManager:jf	(Ljava/lang/String;)Ljava/lang/String;
    //   262: astore 8
    //   264: invokestatic 2433	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   267: getstatic 2447	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:OneyWayLBSFriendMsgNotifyCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   270: invokevirtual 2441	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   273: invokevirtual 2444	com/tencent/mobileqq/app/DeviceProfileManager:jf	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore 7
    //   278: aload 8
    //   280: ldc_w 2449
    //   283: invokevirtual 2453	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   286: astore 8
    //   288: aload 7
    //   290: ldc_w 2449
    //   293: invokevirtual 2453	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   296: astore 7
    //   298: aload 8
    //   300: arraylength
    //   301: bipush 6
    //   303: if_icmplt +232 -> 535
    //   306: aload 7
    //   308: arraylength
    //   309: bipush 6
    //   311: if_icmplt +224 -> 535
    //   314: aload_0
    //   315: aload 8
    //   317: iconst_0
    //   318: aaload
    //   319: invokestatic 1661	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   322: putfield 33	tob:bCC	I
    //   325: aload_0
    //   326: aload 8
    //   328: iconst_1
    //   329: aaload
    //   330: invokestatic 1661	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   333: putfield 35	tob:bCD	I
    //   336: aload_0
    //   337: aload 8
    //   339: iconst_2
    //   340: aaload
    //   341: invokestatic 1661	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   344: putfield 37	tob:bCE	I
    //   347: aload_0
    //   348: aload 8
    //   350: iconst_3
    //   351: aaload
    //   352: invokestatic 1661	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   355: putfield 39	tob:bCF	I
    //   358: aload_0
    //   359: aload 7
    //   361: iconst_0
    //   362: aaload
    //   363: invokestatic 1661	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   366: putfield 41	tob:bCH	I
    //   369: aload_0
    //   370: aload 7
    //   372: iconst_1
    //   373: aaload
    //   374: invokestatic 1661	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   377: putfield 43	tob:bCI	I
    //   380: aload_0
    //   381: aload 7
    //   383: iconst_2
    //   384: aaload
    //   385: invokestatic 1661	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   388: putfield 45	tob:bCJ	I
    //   391: aload_0
    //   392: aload 7
    //   394: iconst_3
    //   395: aaload
    //   396: invokestatic 1661	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   399: putfield 47	tob:bCK	I
    //   402: invokestatic 759	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   405: ifeq +130 -> 535
    //   408: ldc_w 2455
    //   411: iconst_4
    //   412: new 98	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   419: ldc_w 2457
    //   422: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload_0
    //   426: getfield 33	tob:bCC	I
    //   429: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: ldc_w 2218
    //   435: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_0
    //   439: getfield 35	tob:bCD	I
    //   442: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc_w 2218
    //   448: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 37	tob:bCE	I
    //   455: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc_w 2218
    //   461: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: getfield 39	tob:bCF	I
    //   468: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc_w 2459
    //   474: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_0
    //   478: getfield 41	tob:bCH	I
    //   481: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: ldc_w 2218
    //   487: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 43	tob:bCI	I
    //   494: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: ldc_w 2218
    //   500: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 45	tob:bCJ	I
    //   507: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 2218
    //   513: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_0
    //   517: getfield 47	tob:bCK	I
    //   520: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 2461
    //   526: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_0
    //   536: iconst_1
    //   537: putfield 2428	tob:aPZ	Z
    //   540: invokestatic 2395	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   543: new 98	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   550: aload_0
    //   551: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   554: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   557: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: ldc_w 2463
    //   563: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: iconst_0
    //   570: invokevirtual 2467	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   573: astore 11
    //   575: ldc_w 460
    //   578: astore 8
    //   580: ldc_w 460
    //   583: astore 9
    //   585: aload 8
    //   587: astore 7
    //   589: aload_0
    //   590: getfield 56	tob:at	Ljava/util/HashSet;
    //   593: ifnonnull +145 -> 738
    //   596: aload_0
    //   597: monitorenter
    //   598: aload 8
    //   600: astore 7
    //   602: aload_0
    //   603: getfield 56	tob:at	Ljava/util/HashSet;
    //   606: ifnonnull +130 -> 736
    //   609: aload_0
    //   610: new 60	java/util/HashSet
    //   613: dup
    //   614: invokespecial 63	java/util/HashSet:<init>	()V
    //   617: putfield 56	tob:at	Ljava/util/HashSet;
    //   620: aload 11
    //   622: new 98	java/lang/StringBuilder
    //   625: dup
    //   626: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   629: aload_0
    //   630: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   633: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   636: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 2469
    //   642: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: ldc_w 460
    //   651: invokeinterface 2474 3 0
    //   656: astore 8
    //   658: aload 8
    //   660: ldc_w 2449
    //   663: invokevirtual 2453	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   666: astore 12
    //   668: aload 12
    //   670: arraylength
    //   671: istore 5
    //   673: iconst_0
    //   674: istore_3
    //   675: aload 8
    //   677: astore 7
    //   679: iload_3
    //   680: iload 5
    //   682: if_icmpge +54 -> 736
    //   685: aload 12
    //   687: iload_3
    //   688: aaload
    //   689: astore 7
    //   691: aload 7
    //   693: invokevirtual 877	java/lang/String:length	()I
    //   696: ifle +23 -> 719
    //   699: aload 7
    //   701: invokestatic 224	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   704: lconst_0
    //   705: lcmp
    //   706: ifle +13 -> 719
    //   709: aload_0
    //   710: getfield 56	tob:at	Ljava/util/HashSet;
    //   713: aload 7
    //   715: invokevirtual 2475	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   718: pop
    //   719: iload_3
    //   720: iconst_1
    //   721: iadd
    //   722: istore_3
    //   723: goto -48 -> 675
    //   726: aload 7
    //   728: getfield 2480	com/tencent/mobileqq/data/Card:shGender	S
    //   731: istore 4
    //   733: goto -552 -> 181
    //   736: aload_0
    //   737: monitorexit
    //   738: aload 9
    //   740: astore 8
    //   742: aload_0
    //   743: getfield 58	tob:au	Ljava/util/HashSet;
    //   746: ifnonnull +140 -> 886
    //   749: aload_0
    //   750: monitorenter
    //   751: aload 9
    //   753: astore 8
    //   755: aload_0
    //   756: getfield 58	tob:au	Ljava/util/HashSet;
    //   759: ifnonnull +125 -> 884
    //   762: aload_0
    //   763: new 60	java/util/HashSet
    //   766: dup
    //   767: invokespecial 63	java/util/HashSet:<init>	()V
    //   770: putfield 58	tob:au	Ljava/util/HashSet;
    //   773: aload 11
    //   775: new 98	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   782: aload_0
    //   783: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   786: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   789: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 2482
    //   795: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: ldc_w 460
    //   804: invokeinterface 2474 3 0
    //   809: astore 9
    //   811: aload 9
    //   813: ldc_w 2449
    //   816: invokevirtual 2453	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   819: astore 12
    //   821: aload 12
    //   823: arraylength
    //   824: istore 5
    //   826: iconst_0
    //   827: istore_3
    //   828: aload 9
    //   830: astore 8
    //   832: iload_3
    //   833: iload 5
    //   835: if_icmpge +49 -> 884
    //   838: aload 12
    //   840: iload_3
    //   841: aaload
    //   842: astore 8
    //   844: aload 8
    //   846: invokevirtual 877	java/lang/String:length	()I
    //   849: ifle +23 -> 872
    //   852: aload 8
    //   854: invokestatic 224	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   857: lconst_0
    //   858: lcmp
    //   859: ifle +13 -> 872
    //   862: aload_0
    //   863: getfield 58	tob:au	Ljava/util/HashSet;
    //   866: aload 8
    //   868: invokevirtual 2475	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   871: pop
    //   872: iload_3
    //   873: iconst_1
    //   874: iadd
    //   875: istore_3
    //   876: goto -48 -> 828
    //   879: astore_1
    //   880: aload_0
    //   881: monitorexit
    //   882: aload_1
    //   883: athrow
    //   884: aload_0
    //   885: monitorexit
    //   886: aload_1
    //   887: invokevirtual 608	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   890: astore 12
    //   892: aload 8
    //   894: astore_1
    //   895: aload 12
    //   897: invokeinterface 165 1 0
    //   902: ifeq -891 -> 11
    //   905: aload 12
    //   907: invokeinterface 169 1 0
    //   912: checkcast 323	com/tencent/mobileqq/data/MessageRecord
    //   915: astore 13
    //   917: aload_1
    //   918: astore 9
    //   920: aload_0
    //   921: aload 13
    //   923: invokevirtual 2484	tob:r	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   926: ifeq +641 -> 1567
    //   929: aload_1
    //   930: astore 9
    //   932: aload 10
    //   934: ifnull +633 -> 1567
    //   937: aload 13
    //   939: getfield 336	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   942: sipush 1010
    //   945: if_icmpne +340 -> 1285
    //   948: aload 7
    //   950: astore 8
    //   952: aload_0
    //   953: getfield 56	tob:at	Ljava/util/HashSet;
    //   956: aload 13
    //   958: getfield 381	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   961: invokevirtual 2485	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   964: ifne +89 -> 1053
    //   967: aload_0
    //   968: getfield 56	tob:at	Ljava/util/HashSet;
    //   971: aload 13
    //   973: getfield 381	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   976: invokevirtual 2475	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   979: pop
    //   980: aload 7
    //   982: invokevirtual 877	java/lang/String:length	()I
    //   985: ifne +237 -> 1222
    //   988: aload 13
    //   990: getfield 381	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   993: astore 7
    //   995: aload 11
    //   997: invokeinterface 2489 1 0
    //   1002: new 98	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1009: aload_0
    //   1010: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1013: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1016: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 2469
    //   1022: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1028: aload 7
    //   1030: invokeinterface 2494 3 0
    //   1035: pop
    //   1036: aload 11
    //   1038: invokeinterface 2489 1 0
    //   1043: invokeinterface 2497 1 0
    //   1048: pop
    //   1049: aload 7
    //   1051: astore 8
    //   1053: iload 4
    //   1055: ifne +209 -> 1264
    //   1058: iload 6
    //   1060: ifeq +196 -> 1256
    //   1063: aload_0
    //   1064: getfield 37	tob:bCE	I
    //   1067: istore_3
    //   1068: aload_0
    //   1069: aload_0
    //   1070: getfield 56	tob:at	Ljava/util/HashSet;
    //   1073: invokevirtual 2498	java/util/HashSet:size	()I
    //   1076: putfield 2500	tob:bCG	I
    //   1079: aload_0
    //   1080: getfield 2500	tob:bCG	I
    //   1083: iload_3
    //   1084: irem
    //   1085: ifne +113 -> 1198
    //   1088: aload_0
    //   1089: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1092: aload 13
    //   1094: iload_2
    //   1095: invokevirtual 2502	com/tencent/mobileqq/app/QQAppInterface:f	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1098: aload_0
    //   1099: getfield 56	tob:at	Ljava/util/HashSet;
    //   1102: invokevirtual 2503	java/util/HashSet:clear	()V
    //   1105: aload 11
    //   1107: invokeinterface 2489 1 0
    //   1112: new 98	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1119: aload_0
    //   1120: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1123: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1126: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: ldc_w 2469
    //   1132: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokeinterface 2506 2 0
    //   1143: pop
    //   1144: aload 11
    //   1146: invokeinterface 2489 1 0
    //   1151: invokeinterface 2497 1 0
    //   1156: pop
    //   1157: iload 6
    //   1159: ifeq +39 -> 1198
    //   1162: aload_0
    //   1163: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1166: ldc_w 490
    //   1169: ldc_w 460
    //   1172: ldc_w 460
    //   1175: ldc_w 2508
    //   1178: ldc_w 2508
    //   1181: iconst_0
    //   1182: iconst_0
    //   1183: ldc_w 460
    //   1186: ldc_w 460
    //   1189: ldc_w 460
    //   1192: ldc_w 460
    //   1195: invokestatic 497	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1198: aload_1
    //   1199: astore 7
    //   1201: aload 8
    //   1203: astore_1
    //   1204: aload_1
    //   1205: astore 8
    //   1207: aload 7
    //   1209: astore_1
    //   1210: aload 8
    //   1212: astore 7
    //   1214: goto -319 -> 895
    //   1217: astore_1
    //   1218: aload_0
    //   1219: monitorexit
    //   1220: aload_1
    //   1221: athrow
    //   1222: new 98	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1229: aload 7
    //   1231: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: ldc_w 2218
    //   1237: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: aload 13
    //   1242: getfield 381	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1245: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: astore 7
    //   1253: goto -258 -> 995
    //   1256: aload_0
    //   1257: getfield 33	tob:bCC	I
    //   1260: istore_3
    //   1261: goto -193 -> 1068
    //   1264: iload 6
    //   1266: ifeq +11 -> 1277
    //   1269: aload_0
    //   1270: getfield 39	tob:bCF	I
    //   1273: istore_3
    //   1274: goto -206 -> 1068
    //   1277: aload_0
    //   1278: getfield 35	tob:bCD	I
    //   1281: istore_3
    //   1282: goto -214 -> 1068
    //   1285: aload 13
    //   1287: getfield 336	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1290: sipush 1001
    //   1293: if_icmpeq +17 -> 1310
    //   1296: aload_1
    //   1297: astore 9
    //   1299: aload 13
    //   1301: getfield 336	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   1304: sipush 10002
    //   1307: if_icmpne +260 -> 1567
    //   1310: aload_1
    //   1311: astore 8
    //   1313: aload_0
    //   1314: getfield 58	tob:au	Ljava/util/HashSet;
    //   1317: aload 13
    //   1319: getfield 381	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1322: invokevirtual 2485	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   1325: ifne +85 -> 1410
    //   1328: aload_0
    //   1329: getfield 58	tob:au	Ljava/util/HashSet;
    //   1332: aload 13
    //   1334: getfield 381	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1337: invokevirtual 2475	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1340: pop
    //   1341: aload_1
    //   1342: invokevirtual 877	java/lang/String:length	()I
    //   1345: ifne +232 -> 1577
    //   1348: aload 13
    //   1350: getfield 381	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1353: astore_1
    //   1354: aload 11
    //   1356: invokeinterface 2489 1 0
    //   1361: new 98	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1368: aload_0
    //   1369: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1372: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1375: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 2482
    //   1381: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: aload_1
    //   1388: invokeinterface 2494 3 0
    //   1393: pop
    //   1394: aload 11
    //   1396: invokeinterface 2489 1 0
    //   1401: invokeinterface 2497 1 0
    //   1406: pop
    //   1407: aload_1
    //   1408: astore 8
    //   1410: iload 4
    //   1412: ifne +205 -> 1617
    //   1415: iload 6
    //   1417: ifeq +192 -> 1609
    //   1420: aload_0
    //   1421: getfield 45	tob:bCJ	I
    //   1424: istore_3
    //   1425: aload_0
    //   1426: aload_0
    //   1427: getfield 58	tob:au	Ljava/util/HashSet;
    //   1430: invokevirtual 2498	java/util/HashSet:size	()I
    //   1433: putfield 2510	tob:bCL	I
    //   1436: aload 8
    //   1438: astore 9
    //   1440: aload_0
    //   1441: getfield 2510	tob:bCL	I
    //   1444: iload_3
    //   1445: irem
    //   1446: ifne +121 -> 1567
    //   1449: aload_0
    //   1450: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1453: aload 13
    //   1455: iload_2
    //   1456: invokevirtual 2502	com/tencent/mobileqq/app/QQAppInterface:f	(Lcom/tencent/mobileqq/data/MessageRecord;Z)V
    //   1459: aload_0
    //   1460: getfield 58	tob:au	Ljava/util/HashSet;
    //   1463: invokevirtual 2503	java/util/HashSet:clear	()V
    //   1466: aload 11
    //   1468: invokeinterface 2489 1 0
    //   1473: new 98	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1480: aload_0
    //   1481: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1484: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1487: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: ldc_w 2482
    //   1493: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1499: invokeinterface 2506 2 0
    //   1504: pop
    //   1505: aload 11
    //   1507: invokeinterface 2489 1 0
    //   1512: invokeinterface 2497 1 0
    //   1517: pop
    //   1518: aload 8
    //   1520: astore 9
    //   1522: iload 6
    //   1524: ifeq +43 -> 1567
    //   1527: aload_0
    //   1528: getfield 129	tob:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1531: ldc_w 490
    //   1534: ldc_w 460
    //   1537: ldc_w 460
    //   1540: ldc_w 2508
    //   1543: ldc_w 2508
    //   1546: iconst_0
    //   1547: iconst_0
    //   1548: ldc_w 460
    //   1551: ldc_w 460
    //   1554: ldc_w 460
    //   1557: ldc_w 460
    //   1560: invokestatic 497	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1563: aload 8
    //   1565: astore 9
    //   1567: aload 7
    //   1569: astore_1
    //   1570: aload 9
    //   1572: astore 7
    //   1574: goto -370 -> 1204
    //   1577: new 98	java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   1584: aload_1
    //   1585: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1588: ldc_w 2218
    //   1591: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1594: aload 13
    //   1596: getfield 381	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1599: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1605: astore_1
    //   1606: goto -252 -> 1354
    //   1609: aload_0
    //   1610: getfield 41	tob:bCH	I
    //   1613: istore_3
    //   1614: goto -189 -> 1425
    //   1617: iload 6
    //   1619: ifeq +11 -> 1630
    //   1622: aload_0
    //   1623: getfield 47	tob:bCK	I
    //   1626: istore_3
    //   1627: goto -202 -> 1425
    //   1630: aload_0
    //   1631: getfield 43	tob:bCI	I
    //   1634: istore_3
    //   1635: goto -210 -> 1425
    //   1638: iconst_1
    //   1639: istore 4
    //   1641: goto -1460 -> 181
    //   1644: iconst_0
    //   1645: istore_3
    //   1646: goto -1525 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1649	0	this	tob
    //   0	1649	1	paramArrayList	ArrayList<MessageRecord>
    //   0	1649	2	paramBoolean	boolean
    //   120	1526	3	i	int
    //   179	1461	4	j	int
    //   671	165	5	k	int
    //   196	1422	6	bool	boolean
    //   48	1525	7	localObject1	Object
    //   70	1494	8	localObject2	Object
    //   583	988	9	localObject3	Object
    //   156	777	10	localQQMessageFacade	QQMessageFacade
    //   573	933	11	localSharedPreferences	android.content.SharedPreferences
    //   666	240	12	localObject4	Object
    //   915	680	13	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   602	673	879	finally
    //   691	719	879	finally
    //   736	738	879	finally
    //   880	882	879	finally
    //   755	826	1217	finally
    //   844	872	1217	finally
    //   884	886	1217	finally
    //   1218	1220	1217	finally
  }
  
  public boolean x(ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((top.v(localMessageRecord)) && (!top.d(this.app, localMessageRecord))) || (FriendsStatusUtil.g(localMessageRecord.frienduin, this.app)) || (!aagv.iN(localMessageRecord.frienduin)) || (!ahti.aA(localMessageRecord)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tob
 * JD-Core Version:    0.7.0.1
 */