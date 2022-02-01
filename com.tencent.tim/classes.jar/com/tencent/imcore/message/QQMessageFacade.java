package com.tencent.imcore.message;

import aagv;
import aako;
import aalb;
import abcx;
import acbn;
import acdu;
import acff;
import acfs;
import achq;
import ackn;
import acle;
import acqo;
import acqp;
import acqq;
import acqr;
import acqv;
import acqy;
import acro;
import acsa;
import acsu;
import acsu.a;
import acxu;
import acxw;
import acxz;
import aczr;
import aegu;
import aekv;
import afcu;
import afhl;
import aghw;
import agkf;
import ahav;
import ahiy;
import ahta;
import ahti;
import ahua;
import aiyx;
import aizp;
import ajdr;
import ajpc;
import ajpd;
import akwg;
import altq;
import ambj;
import anaz;
import anbi;
import anbk;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import anoe;
import anot;
import antl;
import anxk;
import anxr;
import anze;
import aobw;
import aojn;
import aooi;
import aozx;
import apav;
import apdd;
import aptw;
import aqgv;
import aqiu;
import aqjl;
import aqoe;
import aqrc;
import awit;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.Wording;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NeedHandleUserData;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Sqlite;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import jnv;
import jof;
import kct;
import kdm;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import nyn;
import oan;
import ocp;
import rnu;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import tnt;
import tnt.a;
import toa;
import tog;
import toh;
import toj;
import tom;
import ton;
import top;
import tow;
import tox;
import toy;
import tpj;
import ujt.a;
import wte;
import wvo;
import xki;
import ylm;
import yxe;
import znv;

public class QQMessageFacade
  extends Observable
  implements Manager
{
  public static final Object bG = new Object();
  public acsu a;
  private aiyx jdField_a_of_type_Aiyx;
  private toy jdField_a_of_type_Toy;
  private String aJH;
  private String aJI;
  private volatile boolean aQd;
  private final QQAppInterface app;
  public final AtomicInteger ax = new AtomicInteger(0);
  private int bCQ = -1;
  private volatile int bCR = -1;
  private Object bF = new Object();
  private SparseArray<tnt> bl = new SparseArray();
  private ConcurrentHashMap<String, Integer> cO = new ConcurrentHashMap();
  public final ConcurrentHashMap<Integer, List<MessageRecord>> cP = new ConcurrentHashMap();
  public final ConcurrentHashMap<String, Boolean> cQ = new ConcurrentHashMap();
  public final Map<String, Message> gP;
  public Map<String, Boolean> gQ;
  private Map<String, acqy> gR = new ConcurrentHashMap();
  public Handler mUIHandler;
  private List<ChatMessage> pW;
  
  public QQMessageFacade(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.gP = new QQConcurrentHashMap(1017, 0, 1200);
    this.gQ = new QQConcurrentHashMap(1018, 0);
    this.jdField_a_of_type_Acsu = new acsu(paramQQAppInterface);
    this.jdField_a_of_type_Toy = new toy();
    init();
  }
  
  private int a(ConversationInfo paramConversationInfo, int paramInt)
  {
    int i = paramInt;
    if (paramConversationInfo.type == 1008)
    {
      i = paramInt;
      if (paramInt > 0)
      {
        int j = this.app.a().G(paramConversationInfo.uin, 1008);
        i = paramInt;
        if (j > 0) {
          i = paramInt - 1;
        }
        paramInt = i;
        if (acbn.blO.equals(paramConversationInfo.uin))
        {
          paramInt = i;
          if (j > 0) {
            paramInt = 0;
          }
        }
        i = paramInt;
        if (acbn.blP.equals(paramConversationInfo.uin)) {
          if (j <= 0)
          {
            i = paramInt;
            if (awit.Vs()) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    return i;
  }
  
  private int a(StringBuilder paramStringBuilder)
  {
    Iterator localIterator = this.jdField_a_of_type_Toy.cA().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((tpj)localIterator.next()).b(paramStringBuilder) + i) {}
    return i;
  }
  
  private Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    return a(paramString, paramInt, paramEntityManager, 0);
  }
  
  private Message a(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    long l = SystemClock.uptimeMillis();
    paramEntityManager = a(paramInt1).a(paramString, paramInt1, paramEntityManager, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "refreshSingleLastMsg() called with: uin = [" + paramString + "], uinType = [" + paramInt1 + "], topicId = [" + paramInt2 + "], cost = [" + (SystemClock.uptimeMillis() - l) + "]ms");
    }
    return paramEntityManager;
  }
  
  private void a(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.query(TroopAssistantData.class, false, null, null, null, null, "lastmsgtime desc", null);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopAssistantData)((Iterator)localObject).next()).troopUin, 1, paramEntityManager);
      }
    }
  }
  
  private void a(List<MessageRecord> paramList, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      df(String.format("addMultiMessagesInner size = %s, sync = %s, saveToDB = %s, needUpdateUnread = %s, needAddAIO = %s ", new Object[] { Integer.valueOf(paramList.size()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4) }), null);
    }
    paramList = ahiy.d(this.app, paramList);
    if (paramList.isEmpty())
    {
      QLog.d("Q.msg.QQMessageFacade", 1, "addMultiMessagesInner all fake messages");
      return;
    }
    Object localObject1 = new tnt.a(this.app);
    long l2 = paramList.size();
    fu(paramList);
    Object localObject2 = paramList.iterator();
    Object localObject3;
    int i;
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        i = FlashChatManager.k((MessageRecord)localObject3);
        if (i != -1) {}
        try
        {
          ((FlashChatManager)this.app.getManager(217)).b(i, (MessageRecord)localObject3);
          if (((MessageRecord)localObject3).msgtype == -2029) {
            QLog.d("VideoRedBag", 1, new Object[] { "onReceiveGrapTips, uniseq:", Long.valueOf(((MessageRecord)localObject3).uniseq), " uin:", ((MessageRecord)localObject3).frienduin, " type:", Integer.valueOf(((MessageRecord)localObject3).istroop) });
          }
          a(((MessageRecord)localObject3).istroop).a((MessageRecord)localObject3, paramEntityManager, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, (tnt.a)localObject1);
          if (xki.hN(((MessageRecord)localObject3).frienduin)) {
            abcx.a().f(this.app, (MessageRecord)localObject3);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner type " + i, localException2);
            }
          }
        }
      }
    }
    paramEntityManager = ((tnt.a)localObject1).gN.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject3 = (String)paramEntityManager.next();
      localObject2 = (kdm)this.app.getManager(88);
      localObject3 = ((List)((tnt.a)localObject1).gN.get(localObject3)).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((kdm)localObject2).a((MessageRecord)((Iterator)localObject3).next(), this.app);
      }
    }
    ((tnt.a)localObject1).gN.clear();
    paramEntityManager = a();
    int j;
    if (paramEntityManager != null)
    {
      j = 0;
      if (paramEntityManager.istroop == 1)
      {
        localObject2 = ((tnt.a)localObject1).jdField_a_of_type_Ajdr.a(paramEntityManager.frienduin);
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (((aozx)localObject2).getShmsgseq() == paramEntityManager.shmsgseq) {
            i = ((aozx)localObject2).b(this.app, true, paramEntityManager.frienduin);
          }
        }
        paramEntityManager.bizType = i;
      }
    }
    else
    {
      if (paramBoolean3) {
        ((tnt.a)localObject1).jdField_a_of_type_Tog.fp(paramList);
      }
      localObject2 = ((tnt.a)localObject1).gH.keySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label870;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localObject3 = (RecentUser)((tnt.a)localObject1).gH.get(localObject3);
      try
      {
        ajpd.d(this.app, (RecentUser)localObject3);
        aalb.a((RecentUser)localObject3, this);
        ((tnt.a)localObject1).jdField_a_of_type_Acxw.e((RecentUser)localObject3);
        if (((RecentUser)localObject3).getType() == 1038) {
          ((aagv)this.app.getManager(315)).c((RecentUser)localObject3);
        }
        if (paramEntityManager == null) {
          continue;
        }
        if (paramEntityManager.istroop != 3000) {
          break label853;
        }
        ((tnt.a)localObject1).jdField_a_of_type_Ajdr.b(((RecentUser)localObject3).uin + "&" + 3000);
      }
      catch (Exception localException1) {}
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "addMultiMessagesInner --> Catch Exception .Info = " + localException1);
        continue;
        i = j;
        if (paramEntityManager.istroop != 3000) {
          break;
        }
        localObject2 = ((tnt.a)localObject1).jdField_a_of_type_Ajdr.a(paramEntityManager.frienduin + "&" + 3000);
        i = j;
        if (localObject2 == null) {
          break;
        }
        i = j;
        if (((aozx)localObject2).getShmsgseq() != paramEntityManager.shmsgseq) {
          break;
        }
        i = ((aozx)localObject2).Lc();
        break;
        label853:
        ((tnt.a)localObject1).jdField_a_of_type_Ajdr.b(localException1.uin);
      }
    }
    label870:
    paramEntityManager = ((tnt.a)localObject1).gI.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      aizp.a().h((MessageRecord)((tnt.a)localObject1).gI.get(localObject2), this.app);
    }
    paramEntityManager = (acfs)this.app.getManager(255);
    localObject2 = ((tnt.a)localObject1).gJ.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      paramEntityManager.R((MessageRecord)((tnt.a)localObject1).gJ.get(localObject4));
    }
    paramEntityManager = ((tnt.a)localObject1).gK.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      localObject4 = (MessageRecord)((tnt.a)localObject1).gK.get(localObject2);
      localObject2 = a(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop);
      b((Message)localObject2);
      if ((localObject4 instanceof MessageForPic))
      {
        localObject4 = aqiu.c((MessageForPic)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((Message)localObject2).msg = ((String)localObject4);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "addMessage decodeMsg uin = " + ((Message)localObject2).frienduin + " , type = " + ((Message)localObject2).istroop + " ,msgType:" + ((Message)localObject2).msgtype + ", con = " + ((Message)localObject2).getLogColorContent());
      }
    }
    paramEntityManager = ((tnt.a)localObject1).gM.keySet().iterator();
    while (paramEntityManager.hasNext())
    {
      localObject2 = (String)paramEntityManager.next();
      localObject2 = ((List)((tnt.a)localObject1).gM.get(localObject2)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        oan.a().b((MessageRecord)localObject4, this.app);
      }
    }
    ((tnt.a)localObject1).gM.clear();
    MsgAutoMonitorUtil.getInstance().addAddMsgTime(System.currentTimeMillis() - l1, l2);
    paramEntityManager = nyn.a();
    localObject1 = (aczr)this.app.getManager(199);
    localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (MessageRecord)((Iterator)localObject2).next();
      paramEntityManager.a(this.app, localObject4);
      kct.c((MessageRecord)localObject4);
      if ((localObject1 != null) && (((aczr)localObject1).adh())) {
        ((aczr)localObject1).Gh(((MessageRecord)localObject4).senderuin);
      }
      if (((localObject4 instanceof MessageForShortVideo)) && (((MessageForShortVideo)localObject4).redBagType == LocalMediaInfo.REDBAG_TYPE_GET))
      {
        localObject4 = (MessageForShortVideo)localObject4;
        VideoRedbagData.insertData(((MessageForShortVideo)localObject4).shortVideoId, ((MessageForShortVideo)localObject4).uniseq, ((MessageForShortVideo)localObject4).redBagStat);
      }
    }
    wte.a().b(this.app, paramList);
  }
  
  private boolean a(ConversationInfo paramConversationInfo, boolean[] paramArrayOfBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_Toy.cA().iterator();
    while (localIterator.hasNext()) {
      if (((tpj)localIterator.next()).b(paramConversationInfo, paramArrayOfBoolean)) {
        return true;
      }
    }
    return false;
  }
  
  private tnt b(int paramInt)
  {
    tom localtom = b(paramInt).a();
    switch (paramInt)
    {
    default: 
      return new toa(this.app, this, localtom);
    case 1: 
      return new apdd(this.app, this, localtom);
    case 3000: 
      return new acqr(this.app, this, localtom);
    case 7000: 
      return new acro(this.app, this, localtom);
    case 1026: 
      return new acqv(this.app, this, localtom);
    }
    return new acsa(this.app, this, localtom);
  }
  
  private ton b(int paramInt)
  {
    return this.app.a(paramInt);
  }
  
  private void b(String paramString, MessageRecord paramMessageRecord)
  {
    paramString = (acle)this.app.getBusinessHandler(13);
    if (!jof.a(paramMessageRecord)) {
      paramString.W(paramMessageRecord);
    }
  }
  
  private void cd(String paramString, int paramInt)
  {
    Object localObject = b(paramInt).g(paramString, paramInt);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (top.gR(localMessageRecord.senderuin))
        {
          cd(localMessageRecord.senderuin, localMessageRecord.istroop);
        }
        else if (((acff)this.app.getManager(51)).isFriend(localMessageRecord.senderuin))
        {
          a().d(paramString, paramInt, localMessageRecord.frienduin, localMessageRecord.istroop);
          c(paramString, paramInt, localMessageRecord.senderuin, localMessageRecord.selfuin);
          Message localMessage = a(localMessageRecord.senderuin, paramInt);
          acxw localacxw = this.app.a().a();
          RecentUser localRecentUser = localacxw.a(localMessage.frienduin, localMessage.istroop);
          localRecentUser.lastmsgtime = localMessage.time;
          aalb.a(localRecentUser, this.app.b());
          localacxw.e(localRecentUser);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshMsgBox uin=" + paramString + ",type=" + paramInt + ",move " + localMessageRecord.senderuin + " from box to recentlist");
          }
          setChanged();
          notifyObservers(localRecentUser);
        }
      }
    }
  }
  
  private boolean e(ConversationInfo paramConversationInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_Toy.cA().iterator();
    while (localIterator.hasNext()) {
      if (((tpj)localIterator.next()).f(paramConversationInfo)) {
        return true;
      }
    }
    return false;
  }
  
  private int eE(int paramInt)
  {
    int k = 0;
    int i = 0;
    Object localObject = this.app.a().a().y();
    int j = i;
    if (localObject != null)
    {
      if (((Set)localObject).isEmpty()) {
        j = i;
      }
    }
    else {
      return j;
    }
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("getUnreadMsgsNum type=" + paramInt + "{");; localStringBuilder = null)
    {
      localObject = ((Set)localObject).iterator();
      i = k;
      while (((Iterator)localObject).hasNext())
      {
        ConversationInfo localConversationInfo = (ConversationInfo)((Iterator)localObject).next();
        if (!a(localConversationInfo))
        {
          j = a(localConversationInfo.type).a(paramInt, localConversationInfo);
          if ((QLog.isColorLevel()) && (localStringBuilder != null) && (j > 0)) {
            localStringBuilder.append("[" + localConversationInfo.uin + "," + localConversationInfo.type + "," + j + "]");
          }
          i = a(localConversationInfo, j) + i;
        }
      }
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      j = i;
      if (localStringBuilder == null) {
        break;
      }
      j = i;
      if (i <= 0) {
        break;
      }
      localStringBuilder.append("}");
      QLog.d("Q.msg.QQMessageFacade", 2, localStringBuilder.toString());
      return i;
    }
  }
  
  private void f(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.frienduin != null) && (paramMessage.frienduin.equals(acbn.bkt)) && (paramMessage.istroop == 1009))
    {
      paramMessage.unReadNum = 0;
      Object localObject = b(paramMessage.istroop).g(paramMessage.frienduin, paramMessage.istroop);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        EntityManager localEntityManager = this.app.a().createEntityManager();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          int i = paramMessage.unReadNum;
          paramMessage.unReadNum = (b(paramMessage.istroop).e(localMessageRecord.senderuin, localMessageRecord.istroop, 0L) + i);
        }
        localEntityManager.close();
      }
    }
  }
  
  /* Error */
  private void fB(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 711	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/proxy/ProxyManager;
    //   7: invokevirtual 716	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Lacxw;
    //   10: iconst_1
    //   11: invokevirtual 804	acxw:q	(Z)Ljava/util/List;
    //   14: invokeinterface 188 1 0
    //   19: astore 8
    //   21: iconst_0
    //   22: istore_3
    //   23: iconst_0
    //   24: istore 4
    //   26: aload 8
    //   28: invokeinterface 193 1 0
    //   33: ifeq +422 -> 455
    //   36: aload 8
    //   38: invokeinterface 197 1 0
    //   43: checkcast 459	com/tencent/mobileqq/data/RecentUser
    //   46: astore 9
    //   48: iload 4
    //   50: iconst_1
    //   51: iadd
    //   52: istore 7
    //   54: iload_3
    //   55: istore 6
    //   57: iload 7
    //   59: istore 5
    //   61: aload 9
    //   63: getfield 725	com/tencent/mobileqq/data/RecentUser:lastmsgtime	J
    //   66: lload_1
    //   67: lcmp
    //   68: ifle +377 -> 445
    //   71: aload 9
    //   73: getfield 486	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   76: getstatic 807	acbn:bkz	Ljava/lang/String;
    //   79: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +103 -> 185
    //   85: invokestatic 508	aizp:a	()Laizp;
    //   88: aload_0
    //   89: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 811	aizp:l	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   95: invokeinterface 188 1 0
    //   100: astore 9
    //   102: iload 7
    //   104: iconst_1
    //   105: isub
    //   106: istore 4
    //   108: aload 9
    //   110: invokeinterface 193 1 0
    //   115: ifeq +67 -> 182
    //   118: aload 9
    //   120: invokeinterface 197 1 0
    //   125: checkcast 266	com/tencent/mobileqq/data/TroopAssistantData
    //   128: astore 10
    //   130: iload 4
    //   132: iconst_1
    //   133: iadd
    //   134: istore 5
    //   136: iload 5
    //   138: istore 4
    //   140: aload 10
    //   142: getfield 812	com/tencent/mobileqq/data/TroopAssistantData:lastmsgtime	J
    //   145: lload_1
    //   146: lcmp
    //   147: ifle -39 -> 108
    //   150: iload_3
    //   151: iconst_1
    //   152: iadd
    //   153: istore_3
    //   154: aload_0
    //   155: getfield 74	com/tencent/imcore/message/QQMessageFacade:cO	Ljava/util/concurrent/ConcurrentHashMap;
    //   158: aload 10
    //   160: getfield 281	com/tencent/mobileqq/data/TroopAssistantData:troopUin	Ljava/lang/String;
    //   163: iconst_1
    //   164: invokestatic 816	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   167: iconst_1
    //   168: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: invokevirtual 820	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: iload 5
    //   177: istore 4
    //   179: goto -71 -> 108
    //   182: goto -156 -> 26
    //   185: aload 9
    //   187: getfield 486	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   190: aload 9
    //   192: invokevirtual 480	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   195: invokestatic 824	top:x	(Ljava/lang/String;I)Z
    //   198: ifeq +115 -> 313
    //   201: iload 7
    //   203: iconst_1
    //   204: isub
    //   205: istore 4
    //   207: aload_0
    //   208: aload 9
    //   210: getfield 486	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   213: aload 9
    //   215: invokevirtual 480	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   218: invokevirtual 826	com/tencent/imcore/message/QQMessageFacade:k	(Ljava/lang/String;I)Ljava/util/List;
    //   221: invokeinterface 188 1 0
    //   226: astore 9
    //   228: aload 9
    //   230: invokeinterface 193 1 0
    //   235: ifeq +75 -> 310
    //   238: aload 9
    //   240: invokeinterface 197 1 0
    //   245: checkcast 331	com/tencent/mobileqq/data/MessageRecord
    //   248: astore 10
    //   250: iload 4
    //   252: iconst_1
    //   253: iadd
    //   254: istore 5
    //   256: iload 5
    //   258: istore 4
    //   260: aload 10
    //   262: getfield 827	com/tencent/mobileqq/data/MessageRecord:time	J
    //   265: lload_1
    //   266: lcmp
    //   267: ifle -39 -> 228
    //   270: iload_3
    //   271: iconst_1
    //   272: iadd
    //   273: istore_3
    //   274: aload_0
    //   275: getfield 74	com/tencent/imcore/message/QQMessageFacade:cO	Ljava/util/concurrent/ConcurrentHashMap;
    //   278: aload 10
    //   280: getfield 596	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   283: aload 10
    //   285: getfield 370	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   288: invokestatic 816	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   291: aload 10
    //   293: getfield 370	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   296: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   299: invokevirtual 820	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   302: pop
    //   303: iload 5
    //   305: istore 4
    //   307: goto -79 -> 228
    //   310: goto -128 -> 182
    //   313: iload_3
    //   314: istore 4
    //   316: aload 9
    //   318: getfield 486	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   321: invokestatic 830	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   324: invokevirtual 833	java/lang/Long:longValue	()J
    //   327: ldc2_w 834
    //   330: lcmp
    //   331: ifle +46 -> 377
    //   334: iload_3
    //   335: iconst_1
    //   336: iadd
    //   337: istore_3
    //   338: iload_3
    //   339: istore 4
    //   341: aload_0
    //   342: getfield 74	com/tencent/imcore/message/QQMessageFacade:cO	Ljava/util/concurrent/ConcurrentHashMap;
    //   345: aload 9
    //   347: getfield 486	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   350: aload 9
    //   352: invokevirtual 480	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   355: invokestatic 816	com/tencent/mobileqq/data/MessageRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   358: aload 9
    //   360: invokevirtual 480	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   363: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: invokevirtual 820	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   369: pop
    //   370: iload 7
    //   372: istore 4
    //   374: goto -192 -> 182
    //   377: iload 7
    //   379: iconst_1
    //   380: isub
    //   381: istore 4
    //   383: goto -9 -> 374
    //   386: astore 9
    //   388: iload 7
    //   390: iconst_1
    //   391: isub
    //   392: istore_3
    //   393: aload 9
    //   395: invokevirtual 838	java/lang/NumberFormatException:printStackTrace	()V
    //   398: iload 4
    //   400: istore 6
    //   402: iload_3
    //   403: istore 5
    //   405: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +37 -> 445
    //   411: ldc 227
    //   413: iconst_2
    //   414: new 229	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 840
    //   424: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 9
    //   429: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: iload_3
    //   439: istore 5
    //   441: iload 4
    //   443: istore 6
    //   445: iload 6
    //   447: istore_3
    //   448: iload 5
    //   450: istore 4
    //   452: goto -270 -> 182
    //   455: iload_3
    //   456: iload 4
    //   458: if_icmpne +173 -> 631
    //   461: aload_0
    //   462: getfield 74	com/tencent/imcore/message/QQMessageFacade:cO	Ljava/util/concurrent/ConcurrentHashMap;
    //   465: invokevirtual 841	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   468: astore 10
    //   470: aload_0
    //   471: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   474: invokevirtual 845	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   477: astore 8
    //   479: aload 8
    //   481: ldc_w 847
    //   484: aconst_null
    //   485: invokevirtual 853	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   488: astore 9
    //   490: aload 9
    //   492: ifnull +140 -> 632
    //   495: aload 9
    //   497: astore 8
    //   499: aload 9
    //   501: invokeinterface 858 1 0
    //   506: ifeq +126 -> 632
    //   509: aload 9
    //   511: astore 8
    //   513: aload 9
    //   515: iconst_0
    //   516: invokeinterface 862 2 0
    //   521: invokestatic 868	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   524: astore 11
    //   526: aload 9
    //   528: astore 8
    //   530: aload 10
    //   532: aload 11
    //   534: invokeinterface 871 2 0
    //   539: ifne -44 -> 495
    //   542: aload 9
    //   544: astore 8
    //   546: aload_0
    //   547: getfield 74	com/tencent/imcore/message/QQMessageFacade:cO	Ljava/util/concurrent/ConcurrentHashMap;
    //   550: aload 11
    //   552: aload 11
    //   554: invokestatic 875	com/tencent/mobileqq/data/MessageRecord:getTypeByTableName	(Ljava/lang/String;)I
    //   557: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   560: invokevirtual 820	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: goto -69 -> 495
    //   567: astore 10
    //   569: aload 9
    //   571: astore 8
    //   573: aload 10
    //   575: invokevirtual 876	java/lang/Exception:printStackTrace	()V
    //   578: aload 9
    //   580: astore 8
    //   582: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +34 -> 619
    //   588: aload 9
    //   590: astore 8
    //   592: ldc 227
    //   594: iconst_2
    //   595: new 229	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 840
    //   605: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 10
    //   610: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   613: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload 9
    //   621: ifnull +10 -> 631
    //   624: aload 9
    //   626: invokeinterface 877 1 0
    //   631: return
    //   632: aload 9
    //   634: ifnull -3 -> 631
    //   637: aload 9
    //   639: invokeinterface 877 1 0
    //   644: return
    //   645: astore 9
    //   647: aconst_null
    //   648: astore 8
    //   650: aload 8
    //   652: ifnull +10 -> 662
    //   655: aload 8
    //   657: invokeinterface 877 1 0
    //   662: aload 9
    //   664: athrow
    //   665: astore 9
    //   667: goto -17 -> 650
    //   670: astore 10
    //   672: aconst_null
    //   673: astore 9
    //   675: goto -106 -> 569
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	QQMessageFacade
    //   0	678	1	paramLong	long
    //   22	437	3	i	int
    //   24	435	4	j	int
    //   59	390	5	k	int
    //   55	391	6	m	int
    //   52	340	7	n	int
    //   19	637	8	localObject1	Object
    //   46	313	9	localObject2	Object
    //   386	42	9	localNumberFormatException	java.lang.NumberFormatException
    //   488	150	9	localCursor	Cursor
    //   645	18	9	localObject3	Object
    //   665	1	9	localObject4	Object
    //   673	1	9	localObject5	Object
    //   128	403	10	localObject6	Object
    //   567	42	10	localException1	Exception
    //   670	1	10	localException2	Exception
    //   524	29	11	str	String
    // Exception table:
    //   from	to	target	type
    //   316	334	386	java/lang/NumberFormatException
    //   341	370	386	java/lang/NumberFormatException
    //   499	509	567	java/lang/Exception
    //   513	526	567	java/lang/Exception
    //   530	542	567	java/lang/Exception
    //   546	564	567	java/lang/Exception
    //   479	490	645	finally
    //   499	509	665	finally
    //   513	526	665	finally
    //   530	542	665	finally
    //   546	564	665	finally
    //   573	578	665	finally
    //   582	588	665	finally
    //   592	619	665	finally
    //   479	490	670	java/lang/Exception
  }
  
  private String u(String paramString, int paramInt)
  {
    return top.u(paramString, paramInt);
  }
  
  public void A(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    Object localObject2;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)paramMessageRecord;
      localObject2 = this.app.a();
      if (!((MessageForShortVideo)localObject1).isSendFromLocal())
      {
        ((aooi)localObject2).y(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
        ShortVideoUtils.q((MessageForShortVideo)localObject1);
      }
    }
    else
    {
      if (paramMessageRecord.isSendFromLocal()) {
        break label78;
      }
    }
    for (;;)
    {
      return;
      ((aooi)localObject2).z(((MessageForShortVideo)localObject1).frienduin, ((MessageForShortVideo)localObject1).uniseq);
      break;
      label78:
      localObject1 = this.app.a();
      localObject2 = new ArrayList();
      Object localObject3;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        paramMessageRecord = (MessageForMixedMsg)paramMessageRecord;
        j = paramMessageRecord.msgElemList.size();
        i = 0;
        while (i < j)
        {
          localObject3 = (MessageRecord)paramMessageRecord.msgElemList.get(i);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          i += 1;
        }
      }
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        paramMessageRecord = (MessageForLongMsg)paramMessageRecord;
        int k = paramMessageRecord.longMsgFragmentList.size();
        i = 0;
        if (i < k)
        {
          localObject3 = (MessageRecord)paramMessageRecord.longMsgFragmentList.get(i);
          if ((localObject3 instanceof MessageForPic)) {
            ((List)localObject2).add((MessageForPic)localObject3);
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localObject3 instanceof MessageForMixedMsg))
            {
              localObject3 = (MessageForMixedMsg)localObject3;
              int m = ((MessageForMixedMsg)localObject3).msgElemList.size();
              j = 0;
              while (j < m)
              {
                MessageRecord localMessageRecord = (MessageRecord)((MessageForMixedMsg)localObject3).msgElemList.get(j);
                if ((localMessageRecord instanceof MessageForPic)) {
                  ((List)localObject2).add((MessageForPic)localMessageRecord);
                }
                j += 1;
              }
            }
          }
        }
      }
      else
      {
        if (!(paramMessageRecord instanceof MessageForPic)) {
          continue;
        }
        ((List)localObject2).add((MessageForPic)paramMessageRecord);
      }
      int j = ((List)localObject2).size();
      int i = 0;
      while (i < j)
      {
        paramMessageRecord = (MessageForPic)((List)localObject2).get(i);
        paramMessageRecord = paramMessageRecord.frienduin + paramMessageRecord.uniseq + "_" + paramMessageRecord.subMsgId;
        localObject3 = ((aooi)localObject1).a(paramMessageRecord);
        if ((localObject3 != null) && ((localObject3 instanceof aojn)))
        {
          ((aojn)localObject3).stop();
          ((aooi)localObject1).oy(paramMessageRecord);
        }
        i += 1;
      }
    }
  }
  
  public boolean A(String paramString, int paramInt)
  {
    return B(paramString, paramInt);
  }
  
  public void B(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.frienduin == null) || (paramMessageRecord.frienduin.length() < 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      z(paramMessageRecord);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
  }
  
  public boolean B(String paramString, int paramInt)
  {
    if (this.app.a.abT())
    {
      this.app.a().dC(paramString, paramInt);
      return true;
    }
    return false;
  }
  
  public void C(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (a(paramMessageRecord.istroop).m(paramMessageRecord)) {
      return;
    }
    if (paramMessageRecord.msgtype == -2005)
    {
      a((MessageForFile)paramMessageRecord);
      return;
    }
    if ((paramMessageRecord.msgtype == -2057) && (paramMessageRecord.istroop == 1)) {
      ((rnu)this.app.getManager(208)).p(paramMessageRecord);
    }
    a(paramMessageRecord.istroop).v(paramMessageRecord);
  }
  
  public boolean C(String paramString, int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    List localList = k(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty()))
    {
      bool1 = false;
      return bool1;
    }
    if (localList.size() == 1)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(0);
      if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid)) {
        return false;
      }
      if (localMessageRecord.shmsgseq > Math.max(this.app.a().aB(paramString), this.app.a().j(paramString, paramInt)) + 1L) {}
      for (;;)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool2 + "; cacheList size = " + localList.size() + "; msgseq = " + localMessageRecord.shmsgseq + ", expiredSeq = " + this.app.a().aB(paramString) + ", delLastSeq = " + this.app.a().j(paramString, paramInt));
        return bool2;
        bool2 = false;
      }
    }
    if (localList.size() > 1)
    {
      paramString = (MessageRecord)localList.get(localList.size() - 1);
      if ((paramString.msgtype == -2006) || (!paramString.isValid)) {
        return false;
      }
      paramString = top.d(localList, false);
      if (paramString.size() < 10) {}
      for (bool2 = bool1;; bool2 = false)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "isAIOBreak = " + bool2 + "; cacheList size = " + localList.size() + "; continuedList size = " + paramString.size());
        return bool2;
      }
    }
    return false;
  }
  
  public boolean D(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_Aiyx != null)) {
      return this.jdField_a_of_type_Aiyx.D(paramString, paramInt);
    }
    return false;
  }
  
  public int N(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, true);
  }
  
  public boolean Op()
  {
    return (this.aJH != null) && (this.bCQ >= 0);
  }
  
  protected boolean Oq()
  {
    return aagv.aG(false);
  }
  
  public long S(String paramString)
  {
    Object localObject1 = this.app.a(0).h(paramString, 0);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).senderuin != null) && (((MessageRecord)localObject2).senderuin.equals(paramString)))
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = this.app.a(0).a(paramString, 0, 9223372036854775807L, 1, String.format("issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          paramString = (String)localObject1;
          if (!((List)localObject2).isEmpty()) {
            paramString = (MessageRecord)((List)localObject2).get(0);
          }
        }
        localObject2 = paramString;
        if (QLog.isColorLevel())
        {
          QLog.d("vip", 2, "getLastC2CBubleID find in db");
          localObject2 = paramString;
        }
      }
      if (localObject2 == null)
      {
        return 0L;
        i -= 1;
        break;
      }
      return ((MessageRecord)localObject2).vipBubbleID;
    }
  }
  
  public void V(List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList.size() != 0) {
      a(((MessageRecord)paramList.get(0)).istroop).h(paramList, true, paramBoolean);
    }
  }
  
  public int a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    return b(paramInt).a(paramString, paramInt, paramMessageRecord);
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public int a(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase != null)
    {
      i = j;
      if (paramBoolean) {
        i = -1000;
      }
      i = localSQLiteDatabase.getCount(paramString, paramLong1, paramLong2, i, -1000);
    }
    return i;
  }
  
  public acqp a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (String str = "dataline_manager_pc";; str = "dataline_manager_ipad") {
      return (acqp)a(str);
    }
  }
  
  public acqr a()
  {
    return (acqr)a(3000);
  }
  
  public acqy a(String paramString)
  {
    if (this.gR == null) {
      return null;
    }
    if (!this.gR.containsKey(paramString)) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.gR)
      {
        if (this.gR.containsKey(paramString)) {
          break label116;
        }
        if ("dataline_manager_pc".equals(paramString))
        {
          localObject = new acqq(this.app, this);
          if (localObject != null) {
            break label104;
          }
          return null;
        }
      }
      if ("dataline_manager_ipad".equals(paramString))
      {
        localObject = new acqo(this.app, this);
        continue;
        label104:
        this.gR.put(paramString, localObject);
        label116:
        return (acqy)this.gR.get(paramString);
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  public apdd a()
  {
    return (apdd)a(1);
  }
  
  public Message a()
  {
    return this.jdField_a_of_type_Acsu.a();
  }
  
  @Nullable
  protected Message a(long paramLong, List<MessageRecord> paramList)
  {
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if ((localMessageRecord != null) && (localMessageRecord.uniseq > paramLong))
      {
        paramList = new Message();
        paramList.frienduin = localMessageRecord.frienduin;
        paramList.istroop = localMessageRecord.istroop;
        paramList.time = localMessageRecord.time;
        paramList.isread = localMessageRecord.isread;
        b(paramList);
        return paramList;
      }
      i += 1;
    }
    return null;
  }
  
  public Message a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, false);
  }
  
  public Message a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1; i != 0; i = 0) {
      return b(paramString, paramInt1, paramInt2);
    }
    return a(paramString, paramInt1);
  }
  
  public Message a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null)
    {
      paramString = new Message();
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = u(paramString, paramInt);
    Message localMessage = (Message)this.gP.get(str1);
    Object localObject1;
    if (localMessage != null)
    {
      localObject1 = localMessage;
      if (localMessage.isCacheValid) {}
    }
    else
    {
      if (this.bCR != 0) {
        break label206;
      }
      localObject1 = new Message();
      ((Message)localObject1).frienduin = paramString;
      ((Message)localObject1).istroop = paramInt;
      this.gP.put(str1, localObject1);
      localStringBuilder.append("All-In");
    }
    for (;;)
    {
      if ((localObject1 != null) && (top.x(((Message)localObject1).frienduin, ((Message)localObject1).istroop))) {
        ((Message)localObject1).istroop = top.eD(((Message)localObject1).istroop);
      }
      paramString = (String)localObject1;
      if (((Message)localObject1).istroop != 1) {
        break;
      }
      paramString = (String)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.QQMessageFacade", 2, "getLastMessage " + ((Message)localObject1).getBaseInfoString());
      return localObject1;
      label206:
      if (!this.aQd)
      {
        localObject1 = localMessage;
        if (localMessage == null)
        {
          if ((!aako.L(this.app)) || ((!paramBoolean) && (Looper.getMainLooper() == Looper.myLooper()))) {
            break label369;
          }
          localObject2 = MessageRecord.getTableName(paramString, paramInt);
          localObject1 = this.app.a().createEntityManager();
          if (((EntityManager)localObject1).tabbleIsExist((String)localObject2))
          {
            localMessage = a(paramString, paramInt, (EntityManager)localObject1);
            localStringBuilder.append("Not-Finish-Yet，force Check DB");
          }
          ((EntityManager)localObject1).close();
          localObject1 = localMessage;
          if (localMessage == null)
          {
            localObject1 = new Message();
            ((Message)localObject1).frienduin = paramString;
            ((Message)localObject1).istroop = paramInt;
            ((Message)localObject1).isCacheValid = false;
            this.gP.put(str1, localObject1);
            localStringBuilder.append("Not-Finish-Yet，force Check DB But Null");
          }
        }
        for (;;)
        {
          localStringBuilder.append("Not-Finish-Yet");
          break;
          label369:
          localObject1 = new Message();
          ((Message)localObject1).frienduin = paramString;
          ((Message)localObject1).istroop = paramInt;
          ((Message)localObject1).isCacheValid = false;
          this.gP.put(str1, localObject1);
        }
      }
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      Object localObject2 = this.app.a().createEntityManager();
      if ((!((EntityManager)localObject2).tabbleIsExist((String)localObject1)) && (!((EntityManager)localObject2).tabbleIsExist(str2))) {
        break label530;
      }
      localMessage = a(paramString, paramInt, (EntityManager)localObject2);
      localStringBuilder.append("Check-DB");
      localObject1 = localMessage;
      if (localMessage == null)
      {
        localObject1 = new Message();
        ((Message)localObject1).frienduin = paramString;
        ((Message)localObject1).istroop = paramInt;
        this.gP.put(str1, localObject1);
      }
      ((EntityManager)localObject2).close();
    }
    label530:
    if (localMessage == null)
    {
      localObject1 = new Message();
      ((Message)localObject1).frienduin = paramString;
      ((Message)localObject1).istroop = paramInt;
      this.gP.put(str1, localObject1);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject1 = localMessage;
    }
  }
  
  public MsgSummary a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    for (;;)
    {
      try
      {
        if (!(a(localMessage.istroop) instanceof apdd)) {
          continue;
        }
        if (!TextUtils.isEmpty(aqgv.q(this.app, localMessage.frienduin, localMessage.senderuin))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "getMsgSummaryStrForTroop nickname is null");
        }
        localMessage.isFromLS = true;
        b(localMessage);
        localMessage.isFromLS = false;
        ThreadManager.getSubThreadHandler().post(new QQLSActivity.SyncTroopSummaryTask(this.app, ((QQLSActivity)paramContext).g, localMessage.senderuin, localMessage.frienduin));
      }
      catch (Throwable paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        continue;
        b(localMessage);
        continue;
      }
      paramMessageRecord = new MsgSummary();
      aqiu.a(paramContext, this.app, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
      return paramMessageRecord;
      b(localMessage);
    }
  }
  
  public ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    return b(paramSessionInfo.cZ).a(paramSessionInfo, paramString);
  }
  
  public ChatHistorySearchData a(String paramString, int paramInt, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = b(paramInt).d(paramString, paramInt, paramList);
    return localChatHistorySearchData;
  }
  
  public DraftSummaryInfo a(String paramString, int paramInt)
  {
    if ((paramString != null) && (this.jdField_a_of_type_Aiyx != null)) {
      return this.jdField_a_of_type_Aiyx.a(this.app, paramString, paramInt);
    }
    return null;
  }
  
  public MessageRecord a(Message paramMessage)
  {
    MessageRecord localMessageRecord = anbi.a(paramMessage.msgtype, paramMessage.msgData, paramMessage.extLong, paramMessage.extStr, paramMessage.istroop);
    MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessage);
    if ((localMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)localMessageRecord).parse();
    }
    return localMessageRecord;
  }
  
  public MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return b(paramInt).a(paramString, paramInt, paramLong);
  }
  
  public MessageRecord a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return b(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public MessageRecord a(String paramString1, int paramInt1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt2)
  {
    return b(paramInt1).a(paramString1, paramInt1, paramLong1, paramString2, paramString3, paramLong2, paramInt2);
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    ton localton = b(paramInt);
    if ((localton instanceof apav)) {
      return ((apav)localton).a(paramString, paramInt, paramMessageRecord);
    }
    return null;
  }
  
  public MessageRecord a(String paramString, int paramInt, MessageRecord paramMessageRecord, List<MessageRecord> paramList)
  {
    ton localton = b(paramInt);
    if ((localton instanceof apav)) {
      return ((apav)localton).a(paramString, paramInt, paramMessageRecord, paramList);
    }
    return null;
  }
  
  public MessageRecord a(String paramString1, int paramInt, String paramString2)
  {
    return b(paramInt).a(paramString1, paramInt, paramString2);
  }
  
  public String a(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return a(paramContext, paramMessageRecord, paramBoolean).a(paramContext).toString();
  }
  
  public String a(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean)
  {
    String str4 = "select * from " + paramString;
    String str1 = null;
    String str2 = null;
    if (paramLong1 >= 0L) {}
    for (paramString = String.format(" time >= %d and time <= %d ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });; paramString = null)
    {
      if (paramLong3 >= 0L) {}
      for (String str3 = String.format(" _id >= %d ", new Object[] { Long.valueOf(paramLong3) });; str3 = null)
      {
        int i;
        if (paramBoolean)
        {
          i = -1000;
          if (i == -1000) {
            str2 = " msgtype = " + i;
          }
          if (paramString != null) {
            str1 = " where " + paramString;
          }
          paramString = str1;
          if (str3 != null)
          {
            if (str1 == null) {
              break label323;
            }
            paramString = str1 + " and " + str3;
          }
          label194:
          str1 = paramString;
          if (str2 != null) {
            if (paramString == null) {
              break label348;
            }
          }
        }
        label323:
        label348:
        for (str1 = paramString + " and " + str2;; str1 = " where " + str2)
        {
          paramString = str4;
          if (str1 != null) {
            paramString = str4 + str1;
          }
          str1 = paramString;
          if (paramInt > 0)
          {
            str1 = " order by _id limit " + paramInt;
            str1 = paramString + str1;
          }
          return str1;
          i = 0;
          break;
          paramString = " where " + str3;
          break label194;
        }
      }
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (bG)
    {
      paramString = a(paramString, paramInt1, -1L, paramInt2, false);
      paramInt1 = paramInt3;
      if (paramInt3 == -1) {
        paramInt1 = paramString.size();
      }
      Iterator localIterator = paramString.iterator();
      paramInt3 = 0;
      int i;
      do
      {
        ChatMessage localChatMessage;
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localChatMessage = (ChatMessage)localIterator.next();
          } while (localChatMessage.getConfessTopicId() != paramInt2);
          i = paramInt3 + 1;
          paramInt3 = i;
        } while (!(localChatMessage instanceof MessageForText));
        localChatMessage.parse();
        paramInt3 = i;
      } while (i < paramInt1);
      return paramString;
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int[] paramArrayOfInt, int paramInt3)
  {
    return b(paramInt1).a(paramString, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramArrayOfInt);
  }
  
  public List<MessageRecord> a(String paramString1, int paramInt1, long paramLong, int paramInt2, String paramString2)
  {
    return this.app.a(paramInt1).a(paramString1, paramInt1, paramLong, paramInt2, paramString2);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    int i = 0;
    paramString = a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramBoolean);
    ChatMessage localChatMessage;
    if ((paramInt1 == 1001) || (paramInt1 == 10002) || (top.eD(paramInt1) == 1032))
    {
      if (paramString == null) {}
      for (paramInt2 = 0;; paramInt2 = paramString.size())
      {
        paramInt2 -= 1;
        while (paramInt2 >= 0)
        {
          localChatMessage = (ChatMessage)paramString.get(paramInt2);
          if ((localChatMessage != null) && (localChatMessage.msgtype == -4011)) {
            paramString.remove(localChatMessage);
          }
          paramInt2 -= 1;
        }
      }
    }
    if (paramInt1 == 1008)
    {
      if (paramString == null) {}
      for (paramInt1 = i;; paramInt1 = paramString.size())
      {
        paramInt1 -= 1;
        for (;;)
        {
          if (paramInt1 < 0) {
            break label330;
          }
          localChatMessage = (ChatMessage)paramString.get(paramInt1);
          if (localChatMessage != null) {
            break;
          }
          paramInt1 -= 1;
        }
      }
      if (xki.hN(localChatMessage.senderuin))
      {
        if (!(localChatMessage instanceof MessageForText)) {
          break label302;
        }
        if (!((MessageForText)localChatMessage).msg.startsWith(" ")) {
          paramString.remove(localChatMessage);
        }
      }
      for (;;)
      {
        if ((localChatMessage.msgtype == -5008) && (ArkAppCenter.aft())) {
          paramString.remove(localChatMessage);
        }
        if ((localChatMessage.msgtype != -2011) || (!(localChatMessage instanceof MessageForStructing))) {
          break;
        }
        AbsStructMsg localAbsStructMsg = ((MessageForStructing)localChatMessage).structingMsg;
        if ((localAbsStructMsg == null) || (localAbsStructMsg.mMsgServiceID != 85)) {
          break;
        }
        paramString.remove(localChatMessage);
        break;
        label302:
        if ((!(localChatMessage instanceof MessageForArkApp)) && (!(localChatMessage instanceof MessageForStructing))) {
          paramString.remove(localChatMessage);
        }
      }
    }
    try
    {
      label330:
      Collections.sort(paramString, new tow(this));
      return paramString;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.msg.QQMessageFacade", 2, "Collections sort exception ! ", localException);
    }
    return paramString;
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<MessageRecord> a(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    return b(paramInt1).a(paramString, paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public msg_svc.PbMsgReadedReportReq a(String paramString, int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq;
    Object localObject2;
    Object localObject1;
    label156:
    Object localObject3;
    if (top.x(paramString, paramInt))
    {
      cb(paramString, paramInt);
      List localList = k(paramString, paramInt);
      if (localList == null) {
        return null;
      }
      localStringBuilder = new StringBuilder();
      paramString = null;
      localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
      paramInt = localList.size() - 1;
      if (paramInt >= 0)
      {
        localObject2 = (MessageRecord)localList.get(paramInt);
        if (localObject2 == null) {
          localObject1 = paramString;
        }
        do
        {
          do
          {
            paramInt -= 1;
            paramString = (String)localObject1;
            break;
            if (!top.gR(((MessageRecord)localObject2).senderuin)) {
              break label291;
            }
            localObject2 = k(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
            localObject1 = paramString;
          } while (localObject2 == null);
          localObject1 = paramString;
        } while (((List)localObject2).isEmpty());
        localObject2 = ((List)localObject2).iterator();
        do
        {
          localObject1 = paramString;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
        } while (localObject3 == null);
        if (this.app.a().A(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop) <= 0) {
          break label630;
        }
        a(((MessageRecord)localObject3).senderuin, ((MessageRecord)localObject3).istroop, false, paramBoolean);
        localObject1 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).peer_uin.set(Long.valueOf(((MessageRecord)localObject3).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).last_read_time.set((int)((MessageRecord)localObject3).time);
        if (paramString != null) {
          break label627;
        }
        paramString = new msg_svc.PbC2CReadedReportReq();
        label279:
        paramString.pair_info.add((MessageMicro)localObject1);
      }
    }
    label291:
    label627:
    label630:
    for (;;)
    {
      break label156;
      if (top.gS(((MessageRecord)localObject2).senderuin))
      {
        if (this.app.a().A(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) > 0) {
          ca(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop);
        }
        afcu.a(this.app, 1, null);
        afcu.a(this.app, 2, null);
        localObject1 = paramString;
        break;
      }
      localObject1 = paramString;
      if (this.app.a().A(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop) <= 0) {
        break;
      }
      a(((MessageRecord)localObject2).senderuin, ((MessageRecord)localObject2).istroop, false, paramBoolean);
      localObject3 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).peer_uin.set(Long.valueOf(((MessageRecord)localObject2).senderuin).longValue());
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject3).last_read_time.set((int)((MessageRecord)localObject2).time);
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = new msg_svc.PbC2CReadedReportReq();
      }
      ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject3);
      localStringBuilder.append("{MSGBOX:").append(((MessageRecord)localObject2).senderuin).append("}");
      break;
      if (paramString != null)
      {
        localObject1 = this.app.a().a().am();
        if (localObject1 != null) {
          paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject1));
        }
        localPbMsgReadedReportReq.c2c_read_report.set(paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_LBS>setLbsFriendReaded: " + localStringBuilder.toString());
          long l2 = System.currentTimeMillis();
          QLog.d("Q.msg_box", 2, "setBoxMsgReaded[cost:" + (l2 - l1) + "]");
        }
        return localPbMsgReadedReportReq;
      }
      return null;
      break label279;
    }
  }
  
  public msg_svc.PbMsgReadedReportReq a(boolean paramBoolean)
  {
    Object localObject2 = this.app.a().a().y();
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = null;
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    Iterator localIterator = ((Set)localObject2).iterator();
    Object localObject3;
    int i;
    label179:
    Object localObject4;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject3 = (ConversationInfo)localIterator.next();
        if ((tog.a((ConversationInfo)localObject3) > 0) && (a().u(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type)) && (!e((ConversationInfo)localObject3))) {
          if (top.x(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))
          {
            if (1044 == ((ConversationInfo)localObject3).type) {
              continue;
            }
            localObject3 = k(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            if (localObject3 == null) {
              continue;
            }
            i = ((List)localObject3).size() - 1;
            if (i >= 0)
            {
              localObject4 = (MessageRecord)((List)localObject3).get(i);
              if (localObject4 == null) {
                localObject2 = localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label205:
      i -= 1;
      localObject1 = localObject2;
      break label179;
      label275:
      Object localObject5;
      if (top.gR(((MessageRecord)localObject4).senderuin))
      {
        localObject4 = k(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop);
        localObject2 = localObject1;
        if (localObject4 == null) {
          continue;
        }
        localObject2 = localObject1;
        if (((List)localObject4).isEmpty()) {
          continue;
        }
        localObject2 = ((List)localObject4).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label1307;
        }
        localObject5 = (MessageRecord)((Iterator)localObject2).next();
        a(((MessageRecord)localObject5).senderuin, ((MessageRecord)localObject5).istroop, true, paramBoolean);
        localObject4 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).peer_uin.set(Long.valueOf(((MessageRecord)localObject5).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).last_read_time.set((int)((MessageRecord)localObject5).time);
        if (localObject1 != null) {
          break label1304;
        }
        localObject1 = new msg_svc.PbC2CReadedReportReq();
      }
      label1157:
      label1301:
      label1304:
      for (;;)
      {
        ((msg_svc.PbC2CReadedReportReq)localObject1).pair_info.add((MessageMicro)localObject4);
        break label275;
        a(((MessageRecord)localObject4).senderuin, ((MessageRecord)localObject4).istroop, ((MessageRecord)localObject4).getConfessTopicId(), true, paramBoolean);
        localObject5 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject5).peer_uin.set(Long.valueOf(((MessageRecord)localObject4).senderuin).longValue());
        ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject5).last_read_time.set((int)((MessageRecord)localObject4).time);
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new msg_svc.PbC2CReadedReportReq();
        }
        ((msg_svc.PbC2CReadedReportReq)localObject2).pair_info.add((MessageMicro)localObject5);
        localStringBuilder.append("{MSGBOX:").append(((MessageRecord)localObject4).frienduin).append("}");
        break label205;
        break;
        if (7000 == ((ConversationInfo)localObject3).type)
        {
          if (acbn.bku.equals(((ConversationInfo)localObject3).uin)) {
            break;
          }
          localObject2 = (anxr)this.app.getManager(61);
          if (localObject2 == null) {
            break;
          }
          ((anxr)localObject2).Ry(((ConversationInfo)localObject3).uin);
          localObject2 = ((anxr)localObject2).aa(((ConversationInfo)localObject3).uin);
          if (localObject2 == null) {
            break;
          }
          localObject3 = new msg_svc.PbBindUinMsgReadedConfirmReq();
          ((msg_svc.PbBindUinMsgReadedConfirmReq)localObject3).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
          localPbMsgReadedReportReq.bind_uin_read_report.set((MessageMicro)localObject3);
          localStringBuilder.append("{SUBUIN}");
          break;
        }
        if ((!paramBoolean) && (((ConversationInfo)localObject3).type == 1008) && (b((ConversationInfo)localObject3))) {
          break;
        }
        long l;
        if ((1006 == ((ConversationInfo)localObject3).type) || ((top.fv(((ConversationInfo)localObject3).type)) && (Long.valueOf(((ConversationInfo)localObject3).uin).longValue() > 10000L))) {
          if (10007 == ((ConversationInfo)localObject3).type)
          {
            if (!paramBoolean) {
              break;
            }
            a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
            l = g(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            if (localObject1 != null) {
              break label1301;
            }
            localObject1 = new msg_svc.PbC2CReadedReportReq();
          }
        }
        for (;;)
        {
          ahti.a(this.app, (msg_svc.PbC2CReadedReportReq)localObject1, l, (ConversationInfo)localObject3);
          if (ahta.isInited()) {
            ((ahta)this.app.getManager(358)).Pr(0);
          }
          break;
          if (((ConversationInfo)localObject3).type == 1036) {
            break;
          }
          a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
          l = g(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          if (l == -1L) {}
          do
          {
            do
            {
              if (localObject1 != null)
              {
                localObject2 = this.app.a().a().am();
                if (localObject2 != null) {
                  ((msg_svc.PbC2CReadedReportReq)localObject1).sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject2));
                }
                localPbMsgReadedReportReq.c2c_read_report.set((MessageMicro)localObject1);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.QQMessageFacade", 2, "<ReadReport_All>setAllReaded: " + localStringBuilder.toString());
              }
              return localPbMsgReadedReportReq;
              localObject4 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
              localObject2 = ((ConversationInfo)localObject3).uin;
              if (1006 == ((ConversationInfo)localObject3).type) {
                localObject2 = aqgv.x(this.app, ((ConversationInfo)localObject3).uin);
              }
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).peer_uin.set(Long.valueOf((String)localObject2).longValue());
              localStringBuilder.append("{C2C:").append(Long.valueOf((String)localObject2)).append(((ConversationInfo)localObject3).type).append("}");
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject4).last_read_time.set((int)l);
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new msg_svc.PbC2CReadedReportReq();
              }
              ((msg_svc.PbC2CReadedReportReq)localObject2).pair_info.add((MessageMicro)localObject4);
              localObject1 = localObject2;
              break;
              if (3000 != ((ConversationInfo)localObject3).type) {
                break label1157;
              }
              a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
              l = g(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
            } while (l == -1L);
            localObject2 = new msg_svc.PbDiscussReadedReportReq();
            ((msg_svc.PbDiscussReadedReportReq)localObject2).conf_uin.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
            ((msg_svc.PbDiscussReadedReportReq)localObject2).last_read_seq.set(l);
            localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject2);
            break;
            if ((1 != ((ConversationInfo)localObject3).type) || (this.app.P(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type))) {
              break;
            }
            a(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type, true, paramBoolean);
            ajpd.ar(this.app, ((ConversationInfo)localObject3).uin);
            l = g(((ConversationInfo)localObject3).uin, ((ConversationInfo)localObject3).type);
          } while (l == -1L);
          if (!((ConversationInfo)localObject3).uin.matches("^\\d+$")) {
            break;
          }
          localObject2 = new msg_svc.PbGroupReadedReportReq();
          ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(((ConversationInfo)localObject3).uin).longValue());
          ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l);
          localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
          break;
        }
      }
      label1307:
      localObject2 = localObject1;
    }
  }
  
  public tnt a(int paramInt)
  {
    synchronized (this.bF)
    {
      tnt localtnt2 = (tnt)this.bl.get(paramInt);
      tnt localtnt1 = localtnt2;
      if (localtnt2 == null)
      {
        localtnt1 = b(paramInt);
        this.bl.put(paramInt, localtnt1);
      }
      return localtnt1;
    }
  }
  
  public toa a()
  {
    return (toa)a(0);
  }
  
  public tog a()
  {
    return this.app.a();
  }
  
  public toy a()
  {
    return this.jdField_a_of_type_Toy;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, ujt.a parama)
  {
    ThreadManager.post(new QQMessageFacade.5(this, paramQQAppInterface, paramMessageRecord, paramArrayList, parama), 8, null, false);
  }
  
  public void a(MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = this.app.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    if (localFileManagerEntity != null) {
      if ((paramMessageForFile.isSend()) && ((localFileManagerEntity.status == 1) || (localFileManagerEntity.status == -1) || (localFileManagerEntity.status == 3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg, msgForFile");
        }
        this.app.a().a(paramMessageForFile, localFileManagerEntity, new tox(this, paramMessageForFile, localFileManagerEntity));
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MsgRevert<FileAssistant>", 2, "doMsgRevokeReqForFileMsg uniseq[" + paramMessageForFile.uniseq + "], sendUin[" + ahav.kZ(paramMessageForFile.senderuin) + "], type[" + paramMessageForFile.istroop + "], Entity is Null, return");
  }
  
  public void a(MessageRecord paramMessageRecord, achq paramachq)
  {
    a(paramMessageRecord, paramachq, false);
  }
  
  public void a(MessageRecord paramMessageRecord, achq paramachq, boolean paramBoolean)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.frienduin == null) || (paramMessageRecord.frienduin.length() < 2)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage start currenttime:" + System.currentTimeMillis());
      }
      if ((paramMessageRecord instanceof ChatMessage)) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      z(paramMessageRecord);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " addAndSendMessage addSendMessage end and sendMessage start currenttime:" + System.currentTimeMillis());
      }
      b(paramMessageRecord, paramachq, paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("SendMsgBtn", 2, " addAndSendMessage sendMessage end currenttime:" + System.currentTimeMillis());
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      fv(localArrayList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void a(RecentUser paramRecentUser)
  {
    this.app.a().a().b(paramRecentUser, false);
    a(paramRecentUser.uin, paramRecentUser.getType(), true, true);
    if (paramRecentUser.getType() == 1) {
      ajpd.ar(this.app, paramRecentUser.uin);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, b paramb)
  {
    a(paramInt1).a(paramString, paramInt1, paramInt2, paramb);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1).a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateGroupMsgSeqAndTimeByUniseq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong1 + " shmsgseq = " + paramLong2 + " time = " + paramLong3);
    }
    ton localton = b(paramInt);
    MessageRecord localMessageRecord = null;
    if ((localton instanceof apav))
    {
      localMessageRecord = ((apav)localton).b(paramString, paramInt, paramLong1, paramLong2, paramLong3);
      ((aptw)this.app.getManager(203)).aL(paramLong1, paramLong2);
    }
    a(paramInt).a(paramString, paramInt, localMessageRecord, 3);
    s(paramString, paramInt, paramLong2);
    setChanged();
    notifyObservers(localMessageRecord);
    if (localMessageRecord == null) {}
    do
    {
      return;
      paramString = this.app.a();
    } while ((!paramString.awx()) || ((!paramString.aU(localMessageRecord)) && (!paramString.f(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq))));
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "updateGroupMsgSeqAndTimeByUniseq, in revoking cache");
    }
    paramString.aB(null);
    a(paramInt).bEl();
  }
  
  public void a(String paramString1, int paramInt, long paramLong, String paramString2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgFieldByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong + " fieldName = " + paramString2 + " fieldValue = " + paramObject);
    }
    paramString2 = b(paramInt).a(paramString1, paramInt, paramLong, paramString2, paramObject);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void a(String paramString, int paramInt, b paramb)
  {
    List localList = f(paramString, paramInt);
    if (localList == null) {}
    for (int i = 0;; i = localList.size())
    {
      i = 10 - i;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "refreshMessageListHeadByAIOBreak numTroopRefresh = " + paramb.aQl + ", count = " + i);
      }
      if (i <= 0) {
        break;
      }
      paramb.aQl = true;
      a(paramInt).a(paramString, paramInt, i, paramb);
      return;
    }
    paramb.aQh = true;
    paramb.uin = paramString;
    paramb.uinType = paramInt;
    paramb.count = i;
    as(paramb);
  }
  
  public void a(String paramString, int paramInt, MessageRecord paramMessageRecord, ContentValues paramContentValues)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateFakeMsgByUniseq mr=" + paramMessageRecord);
    }
    b(paramInt).a(paramString, paramInt, paramMessageRecord.uniseq, paramContentValues);
    a(paramInt).a(paramString, paramInt, paramMessageRecord, 2);
    a(paramInt).a(paramString, paramInt, paramMessageRecord, 3);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3)
  {
    a(paramInt1).a(paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, true);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt).a(paramString, paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString, Collection<MessageRecord> paramCollection)
  {
    if (paramCollection != null)
    {
      df("------------" + paramString + "--------------" + paramCollection.size(), "");
      return;
    }
    df("------------" + paramString + "-------------- is null", "");
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.close();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          b(((MessageRecord)paramArrayList.get(0)).istroop).b(paramArrayList, null);
        }
        if (paramBoolean2)
        {
          paramString = top.a(paramArrayList);
          if (paramString != null)
          {
            setChanged();
            notifyObservers(paramString);
          }
        }
        return;
      }
      finally
      {
        paramString.close();
      }
      bool = false;
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean1) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean1, bool, paramBoolean2, true);
        paramString.close();
        if ((paramBoolean1) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          b(((MessageRecord)paramArrayList.get(0)).istroop).b(paramArrayList, null);
        }
        if ((paramBoolean2) || (paramBoolean3))
        {
          paramString = top.a(paramArrayList);
          if (paramString != null)
          {
            setChanged();
            notifyObservers(paramString);
          }
        }
        return;
      }
      finally
      {
        paramString.close();
      }
      bool = false;
    }
  }
  
  protected boolean a(ConversationInfo paramConversationInfo)
  {
    if ((paramConversationInfo == null) || (paramConversationInfo.uin == null)) {}
    while ((acbn.bkT.equals(paramConversationInfo.uin)) || (d(paramConversationInfo)) || (c(paramConversationInfo)) || (TextUtils.equals(acbn.blw, paramConversationInfo.uin)) || (TextUtils.equals(acbn.bkE, paramConversationInfo.uin)) || (TextUtils.equals(acbn.blx, paramConversationInfo.uin)) || ((paramConversationInfo.type == 1008) && (b(paramConversationInfo))) || (paramConversationInfo.type == 1033) || (paramConversationInfo.type == 1034) || (paramConversationInfo.type == 1037) || (paramConversationInfo.type == 1044) || (paramConversationInfo.type == 1045) || (paramConversationInfo.type == 1036) || ((paramConversationInfo.type == 1038) && (!Oq()))) {
      return true;
    }
    if (paramConversationInfo.type == 7000)
    {
      QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum subaccount info.uin=" + paramConversationInfo.uin + "  info.type=" + paramConversationInfo.type);
      return true;
    }
    Object localObject;
    if (paramConversationInfo.type == 1)
    {
      localObject = this.app.a().a().b(paramConversationInfo.uin, paramConversationInfo.type);
      if ((localObject == null) || ((((RecentUser)localObject).lFlag & 1L) == 0L)) {
        break label532;
      }
      localObject = this.app.a(true);
      if ((localObject == null) || (((HotChatManager)localObject).kj(paramConversationInfo.uin))) {
        break label532;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum invalide hotchat!");
      }
    }
    label530:
    label532:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (paramConversationInfo.type == 1038)
      {
        localObject = this.app.a().a().b(paramConversationInfo.uin, paramConversationInfo.type);
        Message localMessage = a(paramConversationInfo.uin, paramConversationInfo.type);
        if (((aagv)this.app.getManager(315)).a(localMessage, (RecentUser)localObject) != 1) {
          break label530;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.QQMessageFacade", 2, "getUnreadMsgsNum appletsaccount info.uin=" + paramConversationInfo.uin + "  info.type=" + paramConversationInfo.type);
        return true;
      }
      if (paramConversationInfo.type == 10007) {
        break;
      }
      if (paramConversationInfo.type == 1008)
      {
        if (!ocp.ew(paramConversationInfo.uin)) {
          break;
        }
        return false;
      }
      if (TextUtils.equals(acbn.bla, paramConversationInfo.uin)) {
        break;
      }
      if (("2010741172".equals(paramConversationInfo.uin)) && (paramConversationInfo.type == 0))
      {
        QLog.d("Q.msg.QQMessageFacade", 1, "fight_unread has PUBLIC_ACCOUNT_QQ_MAIL ");
        return true;
      }
      localObject = new boolean[1];
      if (a(paramConversationInfo, (boolean[])localObject)) {
        return localObject[0];
      }
      return false;
    }
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (top.fG(paramInt2))
    {
      bool1 = bool2;
      if (top.fz(paramInt2))
      {
        bool1 = bool2;
        if (b(paramInt1).e(paramString, paramInt1, paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString, int paramInt, List<MessageRecord> paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.QQMessageFacade", 2, "refresh C2C autopull step 0 , FAIL! , timestamp = " + System.currentTimeMillis());
      }
    }
    do
    {
      return false;
      this.cQ.put(u(paramString, paramInt), Boolean.valueOf(true));
      paramString = this.app.a(paramInt).l(paramString, paramInt);
    } while ((paramString == null) || (paramString.isEmpty()));
    if (!paramBoolean) {
      this.app.a(paramInt).bEs();
    }
    df("refresh C2C autopull, size = " + paramString.size(), ", timestamp = " + System.currentTimeMillis());
    return true;
  }
  
  public void aZ(int paramInt, String paramString)
  {
    if (((ambj)this.app.getManager(326)).oD(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "orderMediaMsgSending in chat:" + paramString);
      }
      return;
    }
    b(paramInt).aY(paramInt, paramString);
  }
  
  public void as(Object paramObject)
  {
    setChanged();
    notifyObservers(paramObject);
  }
  
  public void aw(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "refreshRecentCache_Lazy() called with: refreshTopN = [" + paramInt + "], isLoadGrpAssist = [" + paramBoolean + "]");
    }
    if ((paramInt == 0) && (this.aQd)) {
      return;
    }
    EntityManager localEntityManager = this.app.a().createEntityManager();
    Object localObject = this.app.a().a();
    int i;
    int k;
    int j;
    if (this.bCR == -1)
    {
      if (localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName()))
      {
        i = 1;
        this.bCR = i;
      }
    }
    else
    {
      localObject = ((acxw)localObject).q(true);
      i = 0;
      k = i;
      if (localObject == null) {
        break label423;
      }
      k = i;
      if (((List)localObject).size() <= 0) {
        break label423;
      }
      i = ((List)localObject).size();
      if (paramInt <= 0) {
        break label480;
      }
      if (i <= paramInt) {
        break label364;
      }
      j = paramInt;
    }
    for (;;)
    {
      label161:
      int m = 0;
      label164:
      k = i;
      if (m < j)
      {
        long l = SystemClock.uptimeMillis();
        RecentUser localRecentUser = (RecentUser)((List)localObject).get(m);
        a(localRecentUser.uin, localRecentUser.getType(), localEntityManager);
        if (m == 10)
        {
          setChanged();
          notifyObservers(new RecentUser());
        }
        if (top.x(localRecentUser.uin, localRecentUser.getType()))
        {
          if (!acbn.bkE.equals(localRecentUser.uin)) {
            break label370;
          }
          if (this.app.a().t(acbn.blg, localRecentUser.getType())) {
            a(acbn.blg, localRecentUser.getType(), localEntityManager);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.QQMessageFacade", 2, "refreshRecentCache_Lazy() i = [" + m + "], cost = [" + (SystemClock.uptimeMillis() - l) + "]ms");
          }
          m += 1;
          break label164;
          i = 0;
          break;
          label364:
          j = i;
          break label161;
          label370:
          if ((acbn.bkY.equals(localRecentUser.uin)) && (this.app.a().t(acbn.blh, localRecentUser.getType()))) {
            a(acbn.blh, localRecentUser.getType(), localEntityManager);
          }
        }
      }
      label423:
      if (paramBoolean) {
        a(localEntityManager);
      }
      if ((paramBoolean) || (((List)localObject).size() > 10))
      {
        setChanged();
        notifyObservers(new RecentUser());
      }
      if ((paramInt != 0) && (paramInt < k)) {
        break;
      }
      this.aQd = true;
      return;
      label480:
      j = i;
    }
  }
  
  public int b(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    Object localObject = this.app.getCurrentUin();
    localObject = new akwg((String)localObject).build((String)localObject).getReadableDatabase();
    if (localObject != null)
    {
      i = j;
      if (paramBoolean) {
        i = -1000;
      }
      i = ((SQLiteDatabase)localObject).getCount(paramString, paramLong1, paramLong2, i, -1000);
      ((SQLiteDatabase)localObject).close();
    }
    return i;
  }
  
  public Message b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "getFirstUnreadMessage() called with: uin = [" + paramString + "], type = [" + paramInt + "]");
    }
    long l = this.app.a().a().f(paramString, paramInt);
    Object localObject = a(l, k(paramString, paramInt));
    if (localObject != null) {}
    Message localMessage;
    do
    {
      return localObject;
      localMessage = a(l, a(paramString, paramInt, l, 3, String.format("time>=%d", new Object[] { Long.valueOf(l) })));
      localObject = localMessage;
    } while (localMessage != null);
    localObject = new Message();
    ((Message)localObject).frienduin = paramString;
    ((Message)localObject).istroop = paramInt;
    return localObject;
  }
  
  public Message b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      paramString = new Message();
    }
    StringBuilder localStringBuilder;
    String str;
    Message localMessage;
    Object localObject;
    do
    {
      do
      {
        return paramString;
        localStringBuilder = new StringBuilder("Case:");
        str = u(paramString, paramInt1);
        localMessage = (Message)this.gP.get(str);
        if ((localMessage != null) && (localMessage.isCacheValid))
        {
          localObject = localMessage;
          if (localMessage.getConfessTopicId() == paramInt2) {}
        }
        else
        {
          localObject = MessageRecord.getTableName(paramString, paramInt1);
          EntityManager localEntityManager = this.app.a().createEntityManager();
          if (!localEntityManager.tabbleIsExist((String)localObject)) {
            break;
          }
          localMessage = a(paramString, paramInt1, localEntityManager, paramInt2);
          localStringBuilder.append("Check-DB");
          localObject = localMessage;
          if (localMessage == null)
          {
            localObject = new Message();
            ((Message)localObject).frienduin = paramString;
            ((Message)localObject).istroop = paramInt1;
            ((Message)localObject).setConfessTopicId(paramInt2);
            this.gP.put(str, localObject);
          }
          localEntityManager.close();
        }
        paramString = (String)localObject;
      } while (localObject == null);
      paramString = (String)localObject;
    } while (!top.x(((Message)localObject).frienduin, ((Message)localObject).istroop));
    ((Message)localObject).istroop = top.eD(((Message)localObject).istroop);
    return localObject;
    if (localMessage == null)
    {
      localObject = new Message();
      ((Message)localObject).frienduin = paramString;
      ((Message)localObject).istroop = paramInt1;
      ((Message)localObject).setConfessTopicId(paramInt2);
      this.gP.put(str, localObject);
    }
    for (;;)
    {
      localStringBuilder.append("Not-In-TableCache");
      break;
      localMessage.isCacheValid = true;
      localObject = localMessage;
    }
  }
  
  public MessageRecord b(String paramString, int paramInt, long paramLong)
  {
    return b(paramInt).b(paramString, paramInt, paramLong);
  }
  
  public MessageRecord b(String paramString1, int paramInt, String paramString2)
  {
    return b(paramInt).b(paramString1, paramInt, paramString2);
  }
  
  public String b(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    b(localMessage);
    paramMessageRecord = new MsgSummary();
    aqiu.a(paramContext, this.app, localMessage, localMessage.istroop, paramMessageRecord, localMessage.nickName, false, paramBoolean);
    return paramMessageRecord.a(paramContext).toString();
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, List<Long> paramList)
  {
    return b(paramInt).b(paramString, paramInt, paramList);
  }
  
  public List<ChatMessage> b(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, -1L, paramBoolean);
  }
  
  public List<MessageRecord> b(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    return b(paramInt).a(paramString, paramInt, 5000, paramArrayOfInt);
  }
  
  public void b(Message paramMessage)
  {
    try
    {
      a(paramMessage.istroop).b(paramMessage);
      return;
    }
    catch (Throwable paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.QQMessageFacade", 2, "decodeMsg ERROR", paramMessage);
    }
  }
  
  public void b(MessageRecord paramMessageRecord, int paramInt)
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    try
    {
      b(paramMessageRecord.frienduin, paramMessageRecord);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, localEntityManager, false, true, true, true);
      if (QLog.isColorLevel()) {
        QLog.d("sendmsg", 2, String.format("addSendMessage key = %d %s %d", new Object[] { Long.valueOf(paramMessageRecord.uniseq), paramMessageRecord.frienduin, Integer.valueOf(paramMessageRecord.istroop) }));
      }
      this.app.a().f(paramMessageRecord, paramInt);
      setChanged();
      notifyObservers(paramMessageRecord);
      return;
    }
    finally
    {
      localEntityManager.close();
    }
  }
  
  public void b(MessageRecord paramMessageRecord, achq paramachq)
  {
    b(paramMessageRecord, paramachq, false);
  }
  
  public void b(MessageRecord paramMessageRecord, achq paramachq, boolean paramBoolean)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread()) {
      ThreadManager.post(new QQMessageFacade.2(this, paramMessageRecord, paramachq, paramBoolean), 10, null, false);
    }
    for (;;)
    {
      if (paramMessageRecord.msgtype == -2011) {
        anoe.aC(paramMessageRecord);
      }
      return;
      c(paramMessageRecord, paramachq, paramBoolean);
    }
  }
  
  public void b(MessageRecord paramMessageRecord, String paramString)
  {
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramMessageRecord);
      a(localArrayList, paramString, false, true, true, true);
      setChanged();
      if (((paramMessageRecord instanceof ChatMessage)) && (paramMessageRecord.isSend())) {
        ((ChatMessage)paramMessageRecord).mPendantAnimatable = true;
      }
      notifyObservers(paramMessageRecord);
      fv(localArrayList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    a(paramMessageRecord.istroop).a(paramMessageRecord, true, paramBoolean);
  }
  
  public void b(EntityManager paramEntityManager)
  {
    Object localObject = paramEntityManager.query(PubAccountAssistantData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PubAccountAssistantData localPubAccountAssistantData = (PubAccountAssistantData)((Iterator)localObject).next();
        a(localPubAccountAssistantData.mUin, localPubAccountAssistantData.mType, paramEntityManager);
      }
    }
    localObject = paramEntityManager.query(TroopBarData.class, false, null, null, null, null, "mLastMsgTime desc", null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((TroopBarData)((Iterator)localObject).next()).mUin, 1008, paramEntityManager);
      }
    }
  }
  
  public void b(String paramString, int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgExtraFlagByuniseq: peerUin = " + paramString + " type = " + paramInt1 + " uniseq = " + paramLong);
    }
    MessageRecord localMessageRecord = b(paramInt1).a(paramString, paramInt1, paramLong, paramInt2, paramInt3);
    a(paramInt1).a(paramString, paramInt1, localMessageRecord, 3);
  }
  
  public void b(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateC2CMsgTimeByUniseq: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong1 + " time = " + paramLong2);
    }
    paramString2 = b(paramInt).a(paramString1, paramInt, paramLong1, paramLong2, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 3);
  }
  
  public void b(String paramString1, int paramInt, long paramLong, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContent: peerUin = " + paramString1 + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramString2 = b(paramInt).a(paramString1, paramInt, paramLong, paramString2);
    a(paramInt).a(paramString1, paramInt, paramString2, 2);
  }
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    a(paramInt).b(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void b(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    b(paramInt).b(paramString, paramInt, paramMessageRecord);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (QLog.isColorLevel()) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      if (TextUtils.isEmpty(paramString3)) {
        paramLong = 0L;
      }
      for (;;)
      {
        a(paramInt).a(paramString1, paramInt, paramString2, paramString3, paramLong);
        if (QLog.isColorLevel()) {
          QLog.i("notification", 2, "notifyDraftUpdated| " + (System.currentTimeMillis() - l) + " drafttime = " + paramLong);
        }
        return;
      }
    }
  }
  
  public void b(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle)
  {
    a(paramInt).a(paramString, paramInt, paramList1, paramList2, paramBundle);
  }
  
  protected boolean b(ConversationInfo paramConversationInfo)
  {
    return nyn.f(this.app, paramConversationInfo.uin);
  }
  
  public void bEA()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    boolean bool;
    int i;
    if (this.bCR == -1)
    {
      bool = localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName());
      if (bool)
      {
        i = 1;
        this.bCR = i;
      }
    }
    for (;;)
    {
      localEntityManager.close();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache start : Lazy : " + bool);
      }
      long l = System.currentTimeMillis();
      if (bool) {
        aw(90, true);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.QQMessageFacade", 2, "CACHE : refreshCache finish : TimeSpend:" + (System.currentTimeMillis() - l));
        }
        return;
        i = 0;
        break;
        bEB();
      }
      bool = true;
    }
  }
  
  public void bEB()
  {
    df("refreshCache", "");
    EntityManager localEntityManager = this.app.a().createEntityManager();
    Object localObject1 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    int j;
    if (localObject1 != null)
    {
      List localList = this.app.a().a().q(true);
      boolean bool1 = localEntityManager.tabbleIsExist(ConversationInfo.getConversationInfoTableName());
      tog localtog = a();
      StringBuilder localStringBuilder = new StringBuilder(128);
      Iterator localIterator = ((List)localObject1).iterator();
      int i = 0;
      boolean bool2;
      Object localObject2;
      label669:
      label822:
      do
      {
        Object localObject3;
        do
        {
          do
          {
            do
            {
              j = i;
              if (!localIterator.hasNext()) {
                break;
              }
              localObject3 = (Sqlite)localIterator.next();
              ((Sqlite)localObject3).tbl_name = SecurityUtile.decode(((Sqlite)localObject3).tbl_name);
            } while ((((Sqlite)localObject3).tbl_name.equals("mr_fileManager")) || (((Sqlite)localObject3).tbl_name.startsWith("mr_confess_a")) || (((Sqlite)localObject3).tbl_name.startsWith("mr_confess_b")));
            bool2 = ((Sqlite)localObject3).tbl_name.endsWith("_New");
            localObject2 = b(top.bA(((Sqlite)localObject3).tbl_name)).a(((Sqlite)localObject3).tbl_name, localEntityManager);
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.QQMessageFacade", 4, "getMsgProxy().queryLastMessage = " + localObject2);
            }
          } while ((localObject2 == null) || (((Message)localObject2).frienduin == null));
          localObject1 = localObject2;
          if (((Message)localObject2).uniseq == 0L)
          {
            b(((Message)localObject2).istroop).h(((Message)localObject2).frienduin, ((Message)localObject2).istroop);
            localObject2 = b(((Message)localObject2).istroop).a(((Sqlite)localObject3).tbl_name, localEntityManager);
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject2);
              localObject1 = localObject2;
            }
          }
          if (localObject1 == null) {
            break label1052;
          }
        } while (((acbn.bkw.equals(((Message)localObject1).frienduin)) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName()))) || ((acbn.bkx.equals(((Message)localObject1).frienduin)) && (!((Sqlite)localObject3).tbl_name.equals(DataLineMsgRecord.tableName(1)))));
        if (((!acbn.bkE.equals(((Message)localObject1).frienduin)) && ((top.eD(((Message)localObject1).istroop) == 10002) || (top.eD(((Message)localObject1).istroop) == 1001))) || ((!acbn.bkY.equals(((Message)localObject1).frienduin)) && (top.eD(((Message)localObject1).istroop) == 1010)))
        {
          localObject2 = b(((Message)localObject1).istroop).h(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (MessageRecord)((Iterator)localObject2).next();
              if ((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(((MessageRecord)localObject3).frienduin)) && (!anbk.ls(((MessageRecord)localObject3).msgtype)))
              {
                ((Message)localObject1).hasReply = true;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.QQMessageFacade", 2, "requeryLastMessage = " + localObject1 + ",hasReply=" + ((Message)localObject1).hasReply);
                }
              }
            }
          }
        }
        b((Message)localObject1);
        if (!bool1)
        {
          f((Message)localObject1);
          if (localList != null)
          {
            j = 0;
            if (j < localList.size())
            {
              localObject2 = (RecentUser)localList.get(j);
              if ((localObject2 == null) || (((RecentUser)localObject2).uin == null) || (!((RecentUser)localObject2).uin.equals(((Message)localObject1).frienduin))) {
                break label1008;
              }
              if ((top.fL(((Message)localObject1).istroop)) && (a().t(((Message)localObject1).frienduin, top.eD(((Message)localObject1).istroop))))
              {
                if (((Message)localObject1).istroop != 1009) {
                  c(acbn.bkt, 1009, ((Message)localObject1).frienduin, this.app.getCurrentAccountUin());
                }
                if (((Message)localObject1).istroop == 1001) {
                  break;
                }
                c(acbn.bkE, 1001, ((Message)localObject1).frienduin, this.app.getCurrentAccountUin());
              }
            }
          }
          localStringBuilder.setLength(0);
          localStringBuilder.append("refreshCache message uin = ").append(((Message)localObject1).frienduin).append(", type = ").append(((Message)localObject1).istroop).append(", unread = ").append(((Message)localObject1).unReadNum).append(", time = ").append(((Message)localObject1).time);
          df(localStringBuilder.toString(), "");
        }
        localObject2 = u(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
      } while ((!bool2) && (this.gP.containsKey(localObject2)));
      this.gP.put(localObject2, localObject1);
      j = i + 1;
      i = j;
      if (!bool1)
      {
        localtog.F(((Message)localObject1).frienduin, ((Message)localObject1).istroop, ((Message)localObject1).unReadNum);
        i = j;
      }
    }
    label1052:
    for (;;)
    {
      break;
      c(acbn.bkE, 10002, ((Message)localObject1).frienduin, this.app.getCurrentAccountUin());
      break label822;
      label1008:
      j += 1;
      break label669;
      j = 0;
      localEntityManager.close();
      MsgAutoMonitorUtil.getInstance().printKeyAndValue("MSG_TableNum", j + "");
      return;
    }
  }
  
  public void bEC()
  {
    Object localObject1 = new RecentUser().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.app.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localObject1 = localSQLiteDatabase.query((String)localObject1, new String[] { "uin", "type" }, null, null, null, null);
    if (localObject1 != null) {}
    try
    {
      ((Cursor)localObject1).moveToFirst();
      int i = 0;
      while (i < ((Cursor)localObject1).getCount())
      {
        a(((Cursor)localObject1).getString(0), ((Cursor)localObject1).getInt(1), false, true);
        ((Cursor)localObject1).moveToNext();
        i += 1;
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      bED();
      b(0).bEv();
      b(0).bEu();
      b(3000).bEv();
      b(3000).bEu();
      b(1).bEv();
      b(1).bEu();
      if ((acxu.ENABLE) && (aqoe.cg(this.app)))
      {
        this.app.a().a().cOT();
        return;
      }
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
    QLog.e("Q.msg.QQMessageFacade", 1, "not support fts");
  }
  
  public void bED()
  {
    List localList = this.app.a(1032).g(acbn.blK, 1032);
    HashSet localHashSet = new HashSet(localList.size());
    int i = 0;
    if (i < localList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      int j;
      label71:
      String str;
      if (localMessageRecord.isSelfConfessor())
      {
        j = 1033;
        str = j + "&" + localMessageRecord.senderuin;
        if (!localHashSet.contains(str)) {
          break label127;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 1034;
        break label71;
        label127:
        localHashSet.add(str);
        a(localMessageRecord.senderuin, j, true, true);
      }
    }
    aegu.B(this.app, true);
    aegu.A(this.app, true);
  }
  
  public void bEE()
  {
    acxw localacxw = this.app.a().a();
    Object localObject = new RecentUser().getTableName();
    String str1 = new TroopAssistantData().getTableName();
    String str2 = new PubAccountAssistantData().getTableName();
    String str3 = new TroopBarData().getTableName();
    String str4 = new NeedHandleUserData().getTableName();
    SQLiteDatabase localSQLiteDatabase = this.app.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      return;
    }
    localSQLiteDatabase.delete((String)localObject, null, null);
    localSQLiteDatabase.delete(str1, null, null);
    localSQLiteDatabase.delete(str2, null, null);
    localSQLiteDatabase.delete(str4, null, null);
    localSQLiteDatabase.delete(str3, null, null);
    this.app.cLG();
    anze.a().N(this.app, 0);
    localObject = (ackn)this.app.getManager(22);
    if (localObject != null)
    {
      ((ackn)localObject).cMc();
      ((ackn)localObject).JE(1);
    }
    aizp.a().I(this.app, true);
    bEG();
    localacxw.cNj();
  }
  
  public void bEF()
  {
    this.app.a().aC(false, true);
  }
  
  public void bEG()
  {
    this.app.a().aC(true, true);
  }
  
  public void bEH()
  {
    cd(acbn.bkt, 1009);
    cd(acbn.bkE, 1001);
    cd(acbn.bkE, 10002);
    cd(acbn.bkY, 1010);
    cd(acbn.blR, 1044);
  }
  
  /* Error */
  public void bEI()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 2266	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   7: aload_0
    //   8: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11: invokevirtual 2126	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 2272	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: astore 4
    //   20: aload 4
    //   22: ldc_w 2274
    //   25: lconst_0
    //   26: invokeinterface 2280 4 0
    //   31: lstore_2
    //   32: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   35: ldc2_w 2281
    //   38: ldiv
    //   39: lload_2
    //   40: lsub
    //   41: ldc2_w 2283
    //   44: lcmp
    //   45: ifge +4 -> 49
    //   48: return
    //   49: aload_0
    //   50: lload_2
    //   51: invokespecial 2286	com/tencent/imcore/message/QQMessageFacade:fB	(J)V
    //   54: new 229	java/lang/StringBuilder
    //   57: dup
    //   58: ldc_w 2288
    //   61: invokespecial 760	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: astore 5
    //   66: aload_0
    //   67: getfield 74	com/tencent/imcore/message/QQMessageFacade:cO	Ljava/util/concurrent/ConcurrentHashMap;
    //   70: astore 7
    //   72: aload 7
    //   74: monitorenter
    //   75: new 71	java/util/concurrent/ConcurrentHashMap
    //   78: dup
    //   79: aload_0
    //   80: getfield 74	com/tencent/imcore/message/QQMessageFacade:cO	Ljava/util/concurrent/ConcurrentHashMap;
    //   83: invokespecial 2291	java/util/concurrent/ConcurrentHashMap:<init>	(Ljava/util/Map;)V
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 74	com/tencent/imcore/message/QQMessageFacade:cO	Ljava/util/concurrent/ConcurrentHashMap;
    //   92: invokevirtual 2292	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 6
    //   100: invokevirtual 841	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   103: invokeinterface 409 1 0
    //   108: astore 7
    //   110: aload 7
    //   112: invokeinterface 193 1 0
    //   117: ifeq +114 -> 231
    //   120: aload 7
    //   122: invokeinterface 197 1 0
    //   127: checkcast 164	java/lang/String
    //   130: astore 8
    //   132: aload 6
    //   134: aload 8
    //   136: invokevirtual 2293	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 295	java/lang/Integer
    //   142: invokevirtual 2296	java/lang/Integer:intValue	()I
    //   145: istore_1
    //   146: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +23 -> 172
    //   152: aload 5
    //   154: ldc_w 2298
    //   157: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 8
    //   162: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 2300
    //   168: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_0
    //   173: aload 8
    //   175: iload_1
    //   176: invokevirtual 2303	com/tencent/imcore/message/QQMessageFacade:bZ	(Ljava/lang/String;I)V
    //   179: goto -69 -> 110
    //   182: astore 4
    //   184: aload 4
    //   186: invokevirtual 876	java/lang/Exception:printStackTrace	()V
    //   189: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -144 -> 48
    //   195: ldc 227
    //   197: iconst_2
    //   198: new 229	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 2305
    //   208: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 4
    //   213: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: return
    //   223: astore 4
    //   225: aload 7
    //   227: monitorexit
    //   228: aload 4
    //   230: athrow
    //   231: aload 4
    //   233: invokeinterface 2309 1 0
    //   238: ldc_w 2274
    //   241: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   244: ldc2_w 2281
    //   247: ldiv
    //   248: invokeinterface 2315 4 0
    //   253: invokeinterface 2318 1 0
    //   258: pop
    //   259: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -214 -> 48
    //   265: ldc 227
    //   267: iconst_2
    //   268: aload 5
    //   270: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	277	0	this	QQMessageFacade
    //   145	31	1	i	int
    //   31	20	2	l	long
    //   18	3	4	localSharedPreferences	android.content.SharedPreferences
    //   182	30	4	localException	Exception
    //   223	9	4	localObject1	Object
    //   64	205	5	localStringBuilder	StringBuilder
    //   86	47	6	localConcurrentHashMap	ConcurrentHashMap
    //   130	44	8	str	String
    // Exception table:
    //   from	to	target	type
    //   49	54	182	java/lang/Exception
    //   75	98	223	finally
    //   225	228	223	finally
  }
  
  public void bEJ()
  {
    ConcurrentHashMap localConcurrentHashMap = this.app.a().B();
    if (localConcurrentHashMap.isEmpty()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "handleRevokeNotifyAfterSyncMsg");
    }
    Iterator localIterator = localConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList = (ArrayList)localConcurrentHashMap.get(localIterator.next());
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        int i = ((RevokeMsgInfo)localArrayList.get(0)).istroop;
        if (i == 3000)
        {
          if (((acdu)this.app.getManager(53)).a(((RevokeMsgInfo)localArrayList.get(0)).frienduin) == null) {}
        }
        else
        {
          String str1;
          do
          {
            do
            {
              v(localArrayList, true);
              break;
            } while (i != 0);
            RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)localArrayList.get(0);
            String str3 = this.app.getCurrentAccountUin();
            String str2 = localRevokeMsgInfo.bYD;
            str1 = str2;
            if (TextUtils.equals(str3, str2)) {
              str1 = localRevokeMsgInfo.frienduin;
            }
          } while (!((acff)this.app.getManager(51)).ke(str1));
        }
      }
    }
    localConcurrentHashMap.clear();
  }
  
  public void bEy()
  {
    this.aJH = null;
    this.bCQ = -1;
    this.pW = null;
  }
  
  public void bEz()
  {
    b(0).bEs();
    b(3000).bEs();
    b(1).bEs();
    b(1026).bEs();
  }
  
  public void bY(String paramString, int paramInt)
  {
    this.aJH = paramString;
    this.bCQ = paramInt;
  }
  
  /* Error */
  public void bZ(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 845	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   7: astore 14
    //   9: aload 14
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aload 14
    //   17: aload_1
    //   18: invokevirtual 2350	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   21: istore_3
    //   22: iload_3
    //   23: sipush 6000
    //   26: if_icmple -12 -> 14
    //   29: iload_3
    //   30: sipush 5000
    //   33: isub
    //   34: sipush 1200
    //   37: invokestatic 2353	java/lang/Math:max	(II)I
    //   40: istore 4
    //   42: aload_0
    //   43: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: invokevirtual 784	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   49: invokevirtual 2356	com/tencent/mobileqq/data/QQEntityManagerFactory:createMessageRecordEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   52: checkcast 2358	akvm
    //   55: astore 15
    //   57: aload 15
    //   59: invokevirtual 2362	akvm:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   62: astore 13
    //   64: iload 4
    //   66: sipush 2500
    //   69: idiv
    //   70: iconst_1
    //   71: iadd
    //   72: istore 5
    //   74: iload 4
    //   76: iload 5
    //   78: idiv
    //   79: istore 6
    //   81: iconst_0
    //   82: istore_3
    //   83: iload_3
    //   84: iload 5
    //   86: if_icmpge +661 -> 747
    //   89: iload_2
    //   90: ifne +408 -> 498
    //   93: ldc_w 2364
    //   96: iconst_3
    //   97: anewarray 59	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_1
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload_1
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: iload 6
    //   112: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: aastore
    //   116: invokestatic 308	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   119: astore 10
    //   121: ldc_w 2366
    //   124: iconst_3
    //   125: anewarray 59	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_1
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload_1
    //   135: aastore
    //   136: dup
    //   137: iconst_2
    //   138: iload 6
    //   140: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: aastore
    //   144: invokestatic 308	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   147: astore 11
    //   149: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   152: lstore 7
    //   154: aload 13
    //   156: ifnull +8 -> 164
    //   159: aload 13
    //   161: invokevirtual 2371	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   164: aload 15
    //   166: aload 11
    //   168: aconst_null
    //   169: aload_0
    //   170: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   173: invokevirtual 2374	akvm:a	(Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   176: astore 11
    //   178: aload 11
    //   180: ifnull +536 -> 716
    //   183: new 2199	java/util/HashSet
    //   186: dup
    //   187: iconst_5
    //   188: invokespecial 2200	java/util/HashSet:<init>	(I)V
    //   191: astore 12
    //   193: aload 11
    //   195: invokeinterface 188 1 0
    //   200: astore 16
    //   202: aload 16
    //   204: invokeinterface 193 1 0
    //   209: ifeq +507 -> 716
    //   212: aload 16
    //   214: invokeinterface 197 1 0
    //   219: checkcast 331	com/tencent/mobileqq/data/MessageRecord
    //   222: astore 18
    //   224: aload 18
    //   226: invokevirtual 2377	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   229: ifeq -27 -> 202
    //   232: aload 18
    //   234: getfield 994	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   237: ifeq -35 -> 202
    //   240: aload 18
    //   242: getfield 347	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   245: sipush -2006
    //   248: if_icmpeq -46 -> 202
    //   251: aload 18
    //   253: invokestatic 2382	com/tencent/mobileqq/utils/fts/FTSMessageCodec:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/fts/FTSMessage;
    //   256: astore 17
    //   258: aload 17
    //   260: invokevirtual 2387	com/tencent/mobileqq/data/fts/FTSMessage:deleteOpt	()V
    //   263: aload 17
    //   265: invokestatic 2390	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/fts/FTSMessage;)Lcom/tencent/mobileqq/data/FTSMessageDelete;
    //   268: astore 17
    //   270: aload 18
    //   272: ldc_w 2392
    //   275: invokevirtual 2395	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 18
    //   280: aload 18
    //   282: invokestatic 541	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   285: ifeq +350 -> 635
    //   288: aload 17
    //   290: invokevirtual 2400	com/tencent/mobileqq/data/FTSMessageDelete:deleteOne	()V
    //   293: aload 15
    //   295: aload 17
    //   297: invokevirtual 2404	akvm:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   300: goto -98 -> 202
    //   303: astore 12
    //   305: aload 11
    //   307: astore 10
    //   309: aload 12
    //   311: astore 11
    //   313: aload 11
    //   315: invokevirtual 876	java/lang/Exception:printStackTrace	()V
    //   318: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +30 -> 351
    //   324: ldc 227
    //   326: iconst_2
    //   327: new 229	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   334: ldc_w 2406
    //   337: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload 11
    //   342: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload 10
    //   353: astore 11
    //   355: aload 13
    //   357: ifnull +12 -> 369
    //   360: aload 13
    //   362: invokevirtual 2409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   365: aload 10
    //   367: astore 11
    //   369: aload 11
    //   371: ifnull +120 -> 491
    //   374: aload 11
    //   376: invokeinterface 278 1 0
    //   381: ifle +110 -> 491
    //   384: aload_0
    //   385: getfield 98	com/tencent/imcore/message/QQMessageFacade:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   388: sipush 201
    //   391: invokevirtual 341	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   394: checkcast 2411	akwh
    //   397: astore 10
    //   399: aload 10
    //   401: ifnull +11 -> 412
    //   404: aload 10
    //   406: aload_1
    //   407: aload 11
    //   409: invokevirtual 2414	akwh:P	(Ljava/lang/String;Ljava/util/List;)V
    //   412: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   415: ifeq +76 -> 491
    //   418: ldc 227
    //   420: iconst_2
    //   421: new 229	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 2416
    //   431: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_1
    //   435: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 1350
    //   441: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 6
    //   446: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: ldc_w 2418
    //   452: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload_3
    //   456: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: ldc_w 2418
    //   462: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: iload 4
    //   467: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: ldc_w 2420
    //   473: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   479: lload 7
    //   481: lsub
    //   482: invokevirtual 248	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   485: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: iload_3
    //   492: iconst_1
    //   493: iadd
    //   494: istore_3
    //   495: goto -412 -> 83
    //   498: iload_2
    //   499: iconst_1
    //   500: if_icmpeq +17 -> 517
    //   503: iload_2
    //   504: sipush 3000
    //   507: if_icmpeq +10 -> 517
    //   510: iload_2
    //   511: sipush 1026
    //   514: if_icmpne +62 -> 576
    //   517: ldc_w 2422
    //   520: iconst_3
    //   521: anewarray 59	java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: aload_1
    //   527: aastore
    //   528: dup
    //   529: iconst_1
    //   530: aload_1
    //   531: aastore
    //   532: dup
    //   533: iconst_2
    //   534: iload 6
    //   536: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   539: aastore
    //   540: invokestatic 308	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   543: astore 10
    //   545: ldc_w 2424
    //   548: iconst_3
    //   549: anewarray 59	java/lang/Object
    //   552: dup
    //   553: iconst_0
    //   554: aload_1
    //   555: aastore
    //   556: dup
    //   557: iconst_1
    //   558: aload_1
    //   559: aastore
    //   560: dup
    //   561: iconst_2
    //   562: iload 6
    //   564: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   567: aastore
    //   568: invokestatic 308	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   571: astore 11
    //   573: goto -424 -> 149
    //   576: ldc_w 2426
    //   579: iconst_3
    //   580: anewarray 59	java/lang/Object
    //   583: dup
    //   584: iconst_0
    //   585: aload_1
    //   586: aastore
    //   587: dup
    //   588: iconst_1
    //   589: aload_1
    //   590: aastore
    //   591: dup
    //   592: iconst_2
    //   593: iload 6
    //   595: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   598: aastore
    //   599: invokestatic 308	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   602: astore 10
    //   604: ldc_w 2428
    //   607: iconst_3
    //   608: anewarray 59	java/lang/Object
    //   611: dup
    //   612: iconst_0
    //   613: aload_1
    //   614: aastore
    //   615: dup
    //   616: iconst_1
    //   617: aload_1
    //   618: aastore
    //   619: dup
    //   620: iconst_2
    //   621: iload 6
    //   623: invokestatic 299	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: aastore
    //   627: invokestatic 308	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   630: astore 11
    //   632: goto -483 -> 149
    //   635: aload 12
    //   637: aload 18
    //   639: invokevirtual 2429	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   642: istore 9
    //   644: iload 9
    //   646: ifne -444 -> 202
    //   649: aload 17
    //   651: aload 18
    //   653: invokestatic 2432	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   656: invokestatic 360	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   659: invokevirtual 833	java/lang/Long:longValue	()J
    //   662: putfield 2435	com/tencent/mobileqq/data/FTSMessageDelete:delCounter	J
    //   665: aload 17
    //   667: invokevirtual 2438	com/tencent/mobileqq/data/FTSMessageDelete:deletePatch	()V
    //   670: aload 12
    //   672: aload 18
    //   674: invokevirtual 2439	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   677: pop
    //   678: goto -385 -> 293
    //   681: astore 18
    //   683: invokestatic 225	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq -393 -> 293
    //   689: ldc 227
    //   691: iconst_2
    //   692: aload 18
    //   694: invokevirtual 2440	java/lang/Exception:toString	()Ljava/lang/String;
    //   697: invokestatic 258	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   700: goto -407 -> 293
    //   703: astore_1
    //   704: aload 13
    //   706: ifnull +8 -> 714
    //   709: aload 13
    //   711: invokevirtual 2409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   714: aload_1
    //   715: athrow
    //   716: aload 14
    //   718: aload 10
    //   720: invokevirtual 2443	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   723: pop
    //   724: aload 13
    //   726: ifnull +8 -> 734
    //   729: aload 13
    //   731: invokevirtual 2445	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   734: aload 13
    //   736: ifnull +25 -> 761
    //   739: aload 13
    //   741: invokevirtual 2409	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   744: goto -375 -> 369
    //   747: aload 15
    //   749: invokevirtual 2446	akvm:close	()V
    //   752: return
    //   753: astore 11
    //   755: aconst_null
    //   756: astore 10
    //   758: goto -445 -> 313
    //   761: goto -392 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	764	0	this	QQMessageFacade
    //   0	764	1	paramString	String
    //   0	764	2	paramInt	int
    //   21	474	3	i	int
    //   40	426	4	j	int
    //   72	15	5	k	int
    //   79	543	6	m	int
    //   152	328	7	l	long
    //   642	3	9	bool	boolean
    //   119	638	10	localObject1	Object
    //   147	484	11	localObject2	Object
    //   753	1	11	localException1	Exception
    //   191	1	12	localHashSet	HashSet
    //   303	368	12	localException2	Exception
    //   62	678	13	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   7	710	14	localSQLiteDatabase	SQLiteDatabase
    //   55	693	15	localakvm	akvm
    //   200	13	16	localIterator	Iterator
    //   256	410	17	localObject3	Object
    //   222	451	18	localObject4	Object
    //   681	12	18	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   183	202	303	java/lang/Exception
    //   202	293	303	java/lang/Exception
    //   293	300	303	java/lang/Exception
    //   635	644	303	java/lang/Exception
    //   683	700	303	java/lang/Exception
    //   716	724	303	java/lang/Exception
    //   729	734	303	java/lang/Exception
    //   649	678	681	java/lang/Exception
    //   159	164	703	finally
    //   164	178	703	finally
    //   183	202	703	finally
    //   202	293	703	finally
    //   293	300	703	finally
    //   313	351	703	finally
    //   635	644	703	finally
    //   649	678	703	finally
    //   683	700	703	finally
    //   716	724	703	finally
    //   729	734	703	finally
    //   159	164	753	java/lang/Exception
    //   164	178	753	java/lang/Exception
  }
  
  public int bl()
  {
    Object localObject1 = new StringBuilder(168);
    int j = eE(2);
    if (j != 0) {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(j) }));
    }
    int i = j;
    int k;
    if (a().u(acbn.bkT, 9000))
    {
      k = yxe.u(this.app);
      if ((k != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.QQMessageFacade", 2, "Recent TroopNotification Unread=" + k);
      }
      i = j + k;
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { acbn.bkT, Integer.valueOf(9000), Integer.valueOf(k) }));
    }
    j = i;
    Object localObject2;
    if (a().u(acbn.bly, 7230))
    {
      j = nyn.a().rc();
      i += j;
      localObject2 = this.app.getManager(36);
      if (!(localObject2 instanceof altq)) {
        break label792;
      }
      k = ((altq)localObject2).ag("104000.104001", 100);
      if (k <= 0) {
        break label792;
      }
      i = k + i;
    }
    label787:
    label792:
    for (;;)
    {
      ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { acbn.bly, Integer.valueOf(7230), Integer.valueOf(j) }));
      j = i;
      i = j;
      if (aobw.bK(this.app))
      {
        i = j;
        if (a().u(acbn.blM, 6004))
        {
          localObject2 = ((jnv)this.app.getManager(70)).a(46, false);
          if ((localObject2 == null) || (!((oidb_0x791.RedDotInfo)localObject2).uint32_number.has()) || (!((oidb_0x791.RedDotInfo)localObject2).bool_display_reddot.get())) {
            break label787;
          }
        }
      }
      for (i = ((oidb_0x791.RedDotInfo)localObject2).uint32_number.get();; i = 0)
      {
        j += i;
        ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { acbn.blM, Integer.valueOf(6004), Integer.valueOf(i) }));
        i = j;
        j = i;
        if (a().u(acbn.blr, 9003))
        {
          localObject2 = (ylm)this.app.getManager(138);
          j = i;
          if (localObject2 != null)
          {
            k = ((ylm)localObject2).wU();
            j = i + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { acbn.blr, Integer.valueOf(9003), Integer.valueOf(k) }));
          }
        }
        i = j;
        if (a().u(acbn.bku, 7000))
        {
          k = anxk.a(this.app, a());
          i = j + k;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { acbn.bku, Integer.valueOf(7000), Integer.valueOf(k) }));
        }
        j = i;
        if (ahta.isInited())
        {
          k = ((ahta)this.app.getManager(358)).Fj();
          j = i + k;
          ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { "2747277822", Integer.valueOf(10007), Integer.valueOf(k) }));
        }
        i = j;
        if (aekv.W("MiniAppEcShopNumMsgEnable", 1) == 1)
        {
          i = j;
          if (a().u(acbn.blb, 7120))
          {
            k = ((kdm)this.app.getManager(88)).b(this.app);
            i = j + k;
            ((StringBuilder)localObject1).append(String.format("(%s,%d,%d) ", new Object[] { acbn.bly, Integer.valueOf(7120), Integer.valueOf(k) }));
          }
        }
        j = a((StringBuilder)localObject1);
        localObject1 = ((StringBuilder)localObject1).toString();
        if (!((String)localObject1).equals(this.aJI))
        {
          QLog.d("Q.msg.QQMessageFacade_UnreadMonitor", 1, "Recent Msg Unread: " + (String)localObject1);
          this.aJI = ((String)localObject1);
        }
        return j + i;
      }
    }
  }
  
  public long c(String paramString1, String paramString2)
  {
    paramString1 = this.app.a(0).h(paramString1, 0);
    int i;
    MessageRecord localMessageRecord;
    if (paramString1 != null)
    {
      i = paramString1.size() - 1;
      if (i >= 0)
      {
        localMessageRecord = (MessageRecord)paramString1.get(i);
        if (localMessageRecord.senderuin.equals(paramString2))
        {
          paramString1 = localMessageRecord;
          if (QLog.isColorLevel()) {
            QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          }
        }
      }
    }
    for (paramString1 = localMessageRecord;; paramString1 = null)
    {
      if (paramString1 == null)
      {
        return 0L;
        i -= 1;
        break;
      }
      return paramString1.vipBubbleID;
    }
  }
  
  public Message c(String paramString, int paramInt)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    String str1 = u(paramString, paramInt);
    Message localMessage = (Message)this.gP.get(str1);
    Object localObject = localMessage;
    EntityManager localEntityManager;
    if (localMessage == null)
    {
      localObject = MessageRecord.getTableName(paramString, paramInt);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt);
      localEntityManager = this.app.a().createEntityManager();
      if ((!localEntityManager.tabbleIsExist((String)localObject)) && (!localEntityManager.tabbleIsExist(str2))) {
        break label135;
      }
      paramString = a(paramString, paramInt, localEntityManager);
    }
    for (;;)
    {
      localEntityManager.close();
      localObject = paramString;
      paramString = (String)localObject;
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
      if (!top.x(((Message)localObject).frienduin, ((Message)localObject).istroop)) {
        break;
      }
      ((Message)localObject).istroop = top.eD(((Message)localObject).istroop);
      return localObject;
      label135:
      if (localMessage == null)
      {
        localObject = new Message();
        ((Message)localObject).frienduin = paramString;
        ((Message)localObject).istroop = paramInt;
        this.gP.put(str1, localObject);
        paramString = (String)localObject;
      }
      else
      {
        localMessage.isCacheValid = true;
        paramString = localMessage;
      }
    }
  }
  
  public MessageRecord c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.longMsgIndex == 0) {}
    List localList;
    do
    {
      return paramMessageRecord;
      localList = b(paramMessageRecord.istroop).h(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    } while ((localList == null) || (localList.isEmpty()));
    int i = localList.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)localList.get(i);
      if (top.c(localMessageRecord, paramMessageRecord))
      {
        if (localMessageRecord.longMsgIndex == 0) {
          return localMessageRecord;
        }
        if (localMessageRecord.longMsgIndex < paramMessageRecord.longMsgIndex) {
          paramMessageRecord = localMessageRecord;
        }
      }
      for (;;)
      {
        i -= 1;
        break;
      }
    }
    return paramMessageRecord;
  }
  
  public MessageRecord c(String paramString, int paramInt)
  {
    Object localObject1 = b(paramInt).h(paramString, paramInt);
    if (localObject1 != null)
    {
      int i = ((List)localObject1).size() - 1;
      Object localObject2;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).isValid) && (!top.fz(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
      for (localObject1 = c((MessageRecord)localObject2);; localObject1 = null)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = b(paramInt).b(paramString, paramInt, null);
        }
        return localObject2;
        i -= 1;
        break;
      }
    }
    return null;
  }
  
  public MessageRecord c(String paramString, int paramInt, long paramLong)
  {
    return b(paramInt).c(paramString, paramInt, paramLong);
  }
  
  public String c(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    Message localMessage = new Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    b(localMessage);
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info");
    ConfessInfo localConfessInfo = new ConfessInfo();
    localConfessInfo.parseFromJsonStr((String)localObject);
    paramMessageRecord = aegu.a(this.app, localConfessInfo, paramMessageRecord.senderuin);
    localObject = new MsgSummary();
    aqiu.a(paramContext, this.app, localMessage, localMessage.istroop, (MsgSummary)localObject, paramMessageRecord, false, paramBoolean);
    return ((MsgSummary)localObject).a(paramContext).toString();
  }
  
  public List<MessageRecord> c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return b(paramInt1).c(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return b(paramInt).c(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public void c(MessageRecord paramMessageRecord, achq paramachq, boolean paramBoolean)
  {
    wte.a().d(this.app, paramMessageRecord);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "sendMessage: mr_uinType:" + paramMessageRecord.istroop + " mr_msgType:" + paramMessageRecord.msgtype);
    }
    try
    {
      if (paramMessageRecord.msgUid == 0L) {
        paramMessageRecord.msgUid = anbk.I(anbk.Ji());
      }
      if ((paramMessageRecord.msgtype == -1000) || (paramMessageRecord.msgtype == -1049))
      {
        if (paramMessageRecord.istroop == 1001) {
          if (!this.app.kp(paramMessageRecord.frienduin)) {
            anot.a(this.app, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
          }
        }
        for (;;)
        {
          this.app.a().a(paramMessageRecord, null, paramBoolean);
          return;
          if (paramMessageRecord.istroop == 1003) {
            anot.a(this.app, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_use_old_channel", 0, 0, paramMessageRecord.frienduin, String.valueOf(paramMessageRecord.msgtype), String.valueOf(paramMessageRecord.istroop), "");
          }
        }
      }
      return;
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("Q.msg.QQMessageFacade", 2, "sendMessage ERROR:" + paramMessageRecord.getMessage(), paramMessageRecord);
        return;
        if ((paramMessageRecord.msgtype == -2011) || (paramMessageRecord.msgtype == -2007) || (paramMessageRecord.msgtype == -2002) || (paramMessageRecord.msgtype == -2000) || (paramMessageRecord.msgtype == -2010) || (paramMessageRecord.msgtype == -2020) || (paramMessageRecord.msgtype == -2022) || (paramMessageRecord.msgtype == -2039) || (paramMessageRecord.msgtype == -5008) || (paramMessageRecord.msgtype == -5012) || (paramMessageRecord.msgtype == -5018) || (paramMessageRecord.msgtype == -1051) || (paramMessageRecord.msgtype == -2051) || (paramMessageRecord.msgtype == -1035) || (paramMessageRecord.msgtype == -2056) || (paramMessageRecord.msgtype == -2057) || (paramMessageRecord.msgtype == -2058) || (paramMessageRecord.msgtype == -7001) || (paramMessageRecord.msgtype == -5013) || (paramMessageRecord.msgtype == -5014) || (paramMessageRecord.msgtype == -5016) || (paramMessageRecord.msgtype == -5017) || (paramMessageRecord.msgtype == -7002) || (paramMessageRecord.msgtype == -7005))
        {
          this.app.a().a(paramMessageRecord, paramachq, paramBoolean);
          return;
        }
        if (paramMessageRecord.msgtype == -2071)
        {
          if (paramMessageRecord.istroop == 1) {
            jof.a().a(paramMessageRecord);
          }
          this.app.a().a(paramMessageRecord, paramachq, paramBoolean);
        }
      }
    }
  }
  
  public void c(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    b(paramString, paramInt, paramLong1, paramLong2, null);
  }
  
  public void c(String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "updateMsgContentByUniSeq: peerUin = " + paramString + " type = " + paramInt + " uniseq = " + paramLong);
    }
    paramArrayOfByte = b(paramInt).a(paramString, paramInt, paramLong, paramArrayOfByte);
    a(paramInt).a(paramString, paramInt, paramArrayOfByte, 2);
  }
  
  public void c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramInt).c(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void c(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    if (!paramBoolean) {}
    for (;;)
    {
      try
      {
        a(paramArrayList, paramString, paramBoolean, bool, true, true);
        paramString.close();
        if ((paramBoolean) && (paramArrayList != null) && (!paramArrayList.isEmpty())) {
          b(((MessageRecord)paramArrayList.get(0)).istroop).b(paramArrayList, null);
        }
        paramString = top.a(paramArrayList);
        if (paramString != null)
        {
          setChanged();
          notifyObservers(paramString);
          aqjl.n(this.app, paramString);
        }
        return;
      }
      finally
      {
        paramString.close();
      }
      bool = false;
    }
  }
  
  protected boolean c(ConversationInfo paramConversationInfo)
  {
    return wvo.a(paramConversationInfo.uin, paramConversationInfo.type, this.app);
  }
  
  public void cN(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    a(((RevokeMsgInfo)paramArrayList.get(0)).istroop).cJ(paramArrayList);
  }
  
  public void ca(String paramString, int paramInt)
  {
    a(paramString, paramInt, true, false);
  }
  
  public void cb(String paramString, int paramInt)
  {
    a(paramInt).b(paramString, paramInt, false, false);
  }
  
  public void cc(String paramString, int paramInt)
  {
    paramString = new a(paramString, paramInt, 0, null);
    setChanged();
    notifyObservers(paramString);
  }
  
  public void ce(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < 5)) {}
    while ((this.jdField_a_of_type_Aiyx == null) || (paramString == null) || (paramString.length() < 5)) {
      return;
    }
    this.jdField_a_of_type_Aiyx.o(this.app, paramString, paramInt);
  }
  
  public List<ChatMessage> cu()
  {
    return this.pW;
  }
  
  public List<RecentBaseData> cv()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    Object localObject1 = localEntityManager.rawQuery(Sqlite.class, "select distinct tbl_name from Sqlite_master where tbl_name like \"mr_%\"", null);
    Object localObject4;
    HashMap localHashMap;
    Iterator localIterator;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject4 = this.app.a().a().q(true);
      localHashMap = new HashMap();
      localIterator = ((List)localObject1).iterator();
    }
    label187:
    label344:
    label489:
    label630:
    label636:
    label639:
    for (;;)
    {
      Object localObject2;
      int i;
      Message localMessage;
      Object localObject3;
      int j;
      if (localIterator.hasNext())
      {
        localObject1 = (Sqlite)localIterator.next();
        localObject2 = SecurityUtile.decode(((Sqlite)localObject1).tbl_name);
        ((Sqlite)localObject1).tbl_name = ((String)localObject2);
        if (!((String)localObject2).endsWith("_New")) {
          continue;
        }
        i = top.bA((String)localObject2);
        localMessage = this.app.a(i).a((String)localObject2, localEntityManager);
        if ((localMessage == null) || (localMessage.frienduin == null)) {
          continue;
        }
        localObject3 = localMessage.frienduin;
        localObject1 = null;
        if (((String)localObject2).startsWith("mr_friend_"))
        {
          localObject1 = aqgv.b(this.app, (String)localObject3, false);
          j = 1;
        }
      }
      for (;;)
      {
        if (j == 0) {
          break label639;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = localObject3;
        }
        if ((localMessage.istroop == 0) || (localMessage.istroop == 1) || (localMessage.istroop == 3000)) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label344;
          }
          localObject1 = new MsgBackupMsgUserData();
          ((MsgBackupMsgUserData)localObject1).uin = ((String)localObject3);
          ((MsgBackupMsgUserData)localObject1).uinType = i;
          ((MsgBackupMsgUserData)localObject1).name = ((String)localObject2);
          ((MsgBackupMsgUserData)localObject1).mTitleName = ((String)localObject2);
          localHashMap.put(localObject3, localObject1);
          break;
          if (((String)localObject2).startsWith("mr_troop_"))
          {
            localObject1 = aqgv.a(this.app, (String)localObject3, false);
            j = 1;
            i = 1;
            break label187;
          }
          if (!((String)localObject2).startsWith("mr_discusssion_")) {
            break label636;
          }
          localObject1 = aqgv.v(this.app, (String)localObject3);
          j = 1;
          i = 3000;
          break label187;
        }
        break;
        if (localHashMap.size() > 0)
        {
          localObject1 = new ArrayList();
          if ((localObject4 != null) && (((List)localObject4).size() > 0))
          {
            localObject2 = ((List)localObject4).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = ((RecentUser)((Iterator)localObject2).next()).uin;
              localObject4 = (MsgBackupMsgUserData)localHashMap.get(localObject3);
              if ((localObject4 != null) && (Long.parseLong((String)localObject3) > 10000L))
              {
                if ((((MsgBackupMsgUserData)localObject4).uinType == 0) || (((MsgBackupMsgUserData)localObject4).uinType == 1) || (((MsgBackupMsgUserData)localObject4).uinType == 3000)) {}
                for (i = 1;; i = 0)
                {
                  if (i == 0) {
                    break label489;
                  }
                  ((List)localObject1).add(localObject4);
                  break;
                }
              }
            }
          }
          localObject2 = localHashMap.keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MsgBackupMsgUserData)localHashMap.get((String)((Iterator)localObject2).next());
            if ((((MsgBackupMsgUserData)localObject3).uinType == 0) || (((MsgBackupMsgUserData)localObject3).uinType == 1) || (((MsgBackupMsgUserData)localObject3).uinType == 3000) || (((MsgBackupMsgUserData)localObject3).uinType == 1000) || (((MsgBackupMsgUserData)localObject3).uinType == 1004)) {}
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (((List)localObject1).contains(localObject3)) || (Long.parseLong(((MsgBackupMsgUserData)localObject3).uin) <= 10000L)) {
                break label630;
              }
              ((List)localObject1).add(localObject3);
              break;
            }
          }
          return localObject1;
        }
        return null;
        j = 0;
      }
    }
  }
  
  public MessageRecord d(String paramString, int paramInt)
  {
    Object localObject1 = b(paramInt).i(paramString, paramInt);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((List)localObject1).size() - 1;
      if (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).isValid) && (!top.fz(((MessageRecord)localObject2).msgtype)))
        {
          localObject1 = localObject2;
          if (!((MessageRecord)localObject2).isLongMsg()) {}
        }
      }
    }
    for (localObject1 = c((MessageRecord)localObject2);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        return localObject1;
        i -= 1;
        break;
      }
      Message localMessage = a(paramString, paramInt);
      localObject2 = localObject1;
      if (localMessage != null)
      {
        localObject2 = localObject1;
        if (localMessage.isCacheValid) {
          if (localMessage.lastMsg == null) {
            break label170;
          }
        }
      }
      label170:
      for (localObject2 = localMessage.lastMsg;; localObject2 = a(localMessage))
      {
        localMessage.lastMsg = ((MessageRecord)localObject2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return b(paramInt).b(paramString, paramInt, null);
      }
    }
  }
  
  public MessageRecord d(String paramString, int paramInt, long paramLong)
  {
    return b(paramInt).d(paramString, paramInt, paramLong);
  }
  
  public String d(Context paramContext, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramContext = new Message();
    MessageRecord.copyMessageRecordBaseField(paramContext, paramMessageRecord);
    paramContext.emoRecentMsg = null;
    paramContext.fileType = -1;
    b(paramContext);
    return aqiu.b(paramContext.nickName, 0.4F);
  }
  
  public List<MessageRecord> d(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    return b(paramInt).d(paramString, paramInt, paramLong1, paramLong2);
  }
  
  public void d(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    MessageRecord localMessageRecord = b(paramString, paramInt, paramLong);
    ((aqrc)this.app.getManager(235)).c.ai(localMessageRecord);
    if (b(paramInt).g(paramString, paramInt, paramLong) == 2) {
      this.app.a().a(paramString, paramInt, localMessageRecord);
    }
    if (!paramBoolean) {}
    label168:
    label183:
    do
    {
      for (;;)
      {
        return;
        if (localMessageRecord == null) {
          break label183;
        }
        if (a().u(localMessageRecord.frienduin, localMessageRecord.istroop))
        {
          paramInt = 0;
          if ((localMessageRecord instanceof MessageForLongMsg)) {
            if (top.c(localMessageRecord, a(localMessageRecord.frienduin, localMessageRecord.istroop))) {
              paramInt = 1;
            }
          }
          while (paramInt != 0)
          {
            if (!top.fL(localMessageRecord.istroop)) {
              break label168;
            }
            a(localMessageRecord.istroop).t(localMessageRecord);
            return;
            if (y(localMessageRecord)) {
              paramInt = 1;
            }
          }
        }
      }
      a(localMessageRecord.istroop).u(localMessageRecord);
      return;
    } while (!QLog.isColorLevel());
    QLog.w("Q.msg.QQMessageFacade", 2, "removeMsgByUniseq error: message not found. uin=" + paramString + ",type=" + paramInt + ",uniseq=" + paramLong);
  }
  
  public void d(String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    b(paramInt).d(paramString, paramInt, paramMessageRecord);
  }
  
  public void d(String paramString, int paramInt, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      b(((MessageRecord)paramList.get(0)).istroop).d(paramString, paramInt, paramList);
      setChanged();
      notifyObservers(paramList.get(0));
      paramString = this.app.getEntityManagerFactory(this.app.getCurrentAccountUin()).createEntityManager();
    }
    try
    {
      a(paramList, paramString, true, true, false, false);
      paramString.close();
      fv(paramList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  protected boolean d(ConversationInfo paramConversationInfo)
  {
    return FriendsStatusUtil.g(paramConversationInfo.uin, this.app);
  }
  
  public void df(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, paramString1);
    }
  }
  
  public String e(String paramString1, String paramString2, long paramLong)
  {
    int j = 0;
    List localList = this.app.a(0).a(paramString1, 0, false, false);
    paramString1 = null;
    int i;
    Object localObject;
    if (localList != null)
    {
      i = localList.size() - 1;
      if (i < 0) {
        break label128;
      }
      localObject = (MessageRecord)localList.get(i);
      if (((MessageRecord)localObject).uniseq == paramLong) {
        j = 1;
      }
      if ((localObject instanceof MessageForPic))
      {
        localObject = (MessageForPic)localObject;
        paramString1 = (String)localObject;
        if (j == 0) {}
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "chatthumb";
        }
        return ((MessageForPic)localObject).getFilePath(paramString1);
        i -= 1;
        break;
      }
      return "";
      label128:
      localObject = paramString1;
    }
  }
  
  public List<MessageRecord> e(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return b(paramInt1).e(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public void e(Message paramMessage)
  {
    this.jdField_a_of_type_Acsu.e(paramMessage);
  }
  
  public List<ChatMessage> f(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  public List<MessageRecord> f(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    return b(paramInt1).f(paramString, paramInt1, paramLong, paramInt2);
  }
  
  public List<MessageRecord> f(String paramString1, String paramString2)
  {
    localObject1 = null;
    str = null;
    Object localObject2 = this.app.getCurrentUin();
    localArrayList = new ArrayList();
    akwg localakwg = new akwg((String)localObject2);
    EntityManager localEntityManager = localakwg.createMessageRecordEntityManager();
    localObject2 = localakwg.build((String)localObject2).getWritableDatabase();
    try
    {
      paramString1 = ((SQLiteDatabase)localObject2).rawQuery(paramString1, paramString2, null, null);
      str = paramString1;
      localObject1 = paramString1;
      paramString2 = localEntityManager.cursor2List(MessageRecord.class, paramString2, paramString1);
      if (paramString2 != null)
      {
        str = paramString1;
        localObject1 = paramString1;
        if (paramString2.size() > 0)
        {
          str = paramString1;
          localObject1 = paramString1;
          localArrayList.addAll(paramString2);
        }
      }
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    catch (Exception paramString1)
    {
      do
      {
        localObject1 = str;
        paramString1.printStackTrace();
      } while (str == null);
      str.close();
      return localArrayList;
    }
    finally
    {
      if (localObject1 == null) {
        break label156;
      }
      ((Cursor)localObject1).close();
    }
    return localArrayList;
  }
  
  public void f(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.app.a().createEntityManager();
    try
    {
      a(paramList, paramString, false, true, true, paramBoolean);
      paramString.close();
      paramString = top.a(paramList);
      if (paramString != null)
      {
        setChanged();
        if (paramBoolean) {
          notifyObservers(paramString);
        }
      }
      if (paramBoolean) {
        fv(paramList);
      }
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void fr(List<ChatMessage> paramList)
  {
    this.pW = paramList;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.QQMessageFacade", 2, "setChatMsgList");
    }
  }
  
  public void fs(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    EntityManager localEntityManager = this.app.a().createEntityManager();
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localEntityManager.persistOrReplace((MessageRecord)localIterator.next());
      }
    }
    finally
    {
      localEntityManager.close();
    }
    b((MessageRecord)paramList.get(paramList.size() - 1), this.app.getCurrentUin());
  }
  
  public void ft(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        b(localMessageRecord.istroop).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord, null, false, true, true);
      }
    }
    fv(paramList);
  }
  
  public void fu(List<MessageRecord> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord instanceof MessageForStructing))
      {
        paramList = (MessageForStructing)localMessageRecord;
        if ((paramList.structingMsg != null) && (paramList.structingMsg.mMsgServiceID == 98))
        {
          top.a(paramList, false);
          Object localObject = (NearbyGrayTipsManager)this.app.getManager(93);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner will insert a face score message, msg = " + paramList);
          }
          boolean bool2 = ajpc.a(paramList, "isFaceScoreSecondMember");
          localObject = ((NearbyGrayTipsManager)localObject).b(1, 2, localMessageRecord.time);
          if (QLog.isColorLevel()) {
            QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner  getValidConfigForFaceScore, flag = " + bool2 + ", configForFaceScore = " + localObject);
          }
          if (localObject != null)
          {
            int i = antl.ew(paramList.structingMsg.mExtraData);
            paramList = new Random();
            paramList.setSeed(localMessageRecord.time);
            boolean bool1;
            if ((i & 0x4) != 0)
            {
              bool1 = true;
              label224:
              if (!bool1) {
                break label464;
              }
              if (!bool2) {
                break label454;
              }
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getFavoriteGrayTipWording1(paramList);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner  getGrayTipWording, wording = " + paramList);
              }
              if ((paramList == null) || (TextUtils.isEmpty(paramList.text))) {
                break;
              }
              paramList = MessageForNearbyMarketGrayTips.makeGrayTipMsg(((NearbyGrayTipsManager.GrayTipsConfig)localObject).id, paramList.text, paramList.highlightText, 16, ((NearbyGrayTipsManager.GrayTipsConfig)localObject).url, 1);
              localObject = anbi.d(-2027);
              ((MessageRecord)localObject).init(localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.selfuin, paramList, localMessageRecord.time - 1L, -2027, 1001, localMessageRecord.time - 1L);
              ((MessageRecord)localObject).isread = true;
              ajpc.a((MessageRecord)localObject, "isFaceScoreGrayTips", true);
              ajpc.a((MessageRecord)localObject, "isFaceScoreSecondMember", bool2);
              ajpc.a((MessageRecord)localObject, "isFaceScoreSpecialLike", bool1);
              top.a((MessageRecord)localObject, false);
              b((MessageRecord)localObject, localMessageRecord.selfuin);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q..troop.faceScore", 2, "QQMessageFacade.addMultiMessagesInner insert faceScore gray tips., msg = " + localObject);
              break;
              bool1 = false;
              break label224;
              label454:
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getFavoriteGrayTipWording2(paramList);
              continue;
              label464:
              paramList = ((NearbyGrayTipsManager.GrayTipsConfig)localObject).getGrayTipWording(paramList);
            }
          }
        }
      }
    }
  }
  
  public void fv(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      this.app.a().notifyUI(8020, true, paramList);
    }
    ahua.kY(paramList);
  }
  
  public long g(String paramString, int paramInt)
  {
    long l2 = -1L;
    Object localObject;
    long l1;
    if ((paramInt == 1) || (paramInt == 3000) || (paramInt == 1026))
    {
      localObject = this.app.b().a(paramString, paramInt);
      l2 = ((Message)localObject).shmsgseq;
      l1 = l2;
      if (((Message)localObject).isLongMsg())
      {
        paramString = this.app.b().k(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (paramString.size() > 0) {
            return Math.max(l2, ((MessageRecord)paramString.get(paramString.size() - 1)).shmsgseq);
          }
        }
      }
    }
    else
    {
      l1 = l2;
      if (top.fv(paramInt))
      {
        paramString = this.app.a(paramInt).h(paramString, paramInt);
        l1 = l2;
        if (paramString != null)
        {
          l1 = l2;
          if (!paramString.isEmpty())
          {
            paramInt = paramString.size() - 1;
            for (;;)
            {
              l1 = l2;
              if (paramInt < 0) {
                break;
              }
              localObject = (MessageRecord)paramString.get(paramInt);
              if (!aqiu.mt(((MessageRecord)localObject).issend)) {
                return ((MessageRecord)localObject).time;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
    return l1;
  }
  
  public List<MessageRecord> g(String paramString1, String paramString2)
  {
    localObject = null;
    str = null;
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    localArrayList = new ArrayList();
    EntityManager localEntityManager = this.app.a().createMessageRecordEntityManager();
    try
    {
      paramString1 = localSQLiteDatabase.rawQuery(paramString1, paramString2, null, null);
      str = paramString1;
      localObject = paramString1;
      paramString2 = localEntityManager.cursor2List(MessageRecord.class, paramString2, paramString1);
      if (paramString2 != null)
      {
        str = paramString1;
        localObject = paramString1;
        if (paramString2.size() > 0)
        {
          str = paramString1;
          localObject = paramString1;
          localArrayList.addAll(paramString2);
        }
      }
      if (paramString1 != null) {
        paramString1.close();
      }
    }
    catch (Exception paramString1)
    {
      do
      {
        localObject = str;
        paramString1.printStackTrace();
      } while (str == null);
      str.close();
      return localArrayList;
    }
    finally
    {
      if (localObject == null) {
        break label138;
      }
      ((Cursor)localObject).close();
    }
    return localArrayList;
  }
  
  public void g(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, false, false, true, false);
      paramString.close();
      paramString = top.a(paramList);
      if (paramString != null)
      {
        setChanged();
        if (paramBoolean) {
          notifyObservers(paramString);
        }
      }
      if (paramBoolean) {
        fv(paramList);
      }
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public boolean gW(String paramString)
  {
    return A(paramString, 0);
  }
  
  public MessageRecord i(String paramString, int paramInt, long paramLong)
  {
    return b(paramInt).i(paramString, paramInt, paramLong);
  }
  
  public List<MessageRecord> i(String paramString, int paramInt1, int paramInt2)
  {
    return b(paramInt1).a(paramString, paramInt1, paramInt2, null);
  }
  
  public void init()
  {
    ThreadManager.post(new QQMessageFacade.1(this), 10, null, false);
  }
  
  public List<ChatMessage> j(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (bG)
    {
      paramString = f(paramString, paramInt1);
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        paramInt1 = paramString.size();
      }
      Iterator localIterator = paramString.iterator();
      paramInt2 = 0;
      int i;
      do
      {
        ChatMessage localChatMessage;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localChatMessage = (ChatMessage)localIterator.next();
          i = paramInt2 + 1;
          paramInt2 = i;
        } while (!(localChatMessage instanceof MessageForText));
        localChatMessage.parse();
        paramInt2 = i;
      } while (i < paramInt1);
      return paramString;
    }
  }
  
  public List<MessageRecord> k(String paramString, int paramInt)
  {
    return b(paramInt).h(paramString, paramInt);
  }
  
  public int m(int paramInt, String paramString)
  {
    tog localtog = this.app.a();
    if (localtog != null) {
      return localtog.A(paramString, paramInt);
    }
    return 0;
  }
  
  public MessageRecord m(String paramString, int paramInt, long paramLong)
  {
    return b(paramInt).m(paramString, paramInt, paramLong);
  }
  
  public void notifyObservers(Object paramObject)
  {
    long l = System.currentTimeMillis();
    super.notifyObservers(paramObject);
    paramObject = MsgAutoMonitorUtil.getInstance();
    if (paramObject != null)
    {
      paramObject.addMsgObserverTime(System.currentTimeMillis() - l);
      paramObject.addMsgObserverNotifyNum();
    }
  }
  
  public String oA()
  {
    return this.aJH;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aiyx != null) {
      this.jdField_a_of_type_Aiyx.dvD();
    }
    if (this.gP != null) {
      this.gP.clear();
    }
    if (this.gQ != null) {
      this.gQ.clear();
    }
    this.jdField_a_of_type_Acsu.cOC();
    this.aQd = false;
    deleteObservers();
  }
  
  public void s(String paramString, int paramInt, long paramLong)
  {
    a(paramInt).b(paramString, paramInt, paramLong, false);
  }
  
  public void s(List<MessageRecord> paramList, String paramString)
  {
    f(paramList, paramString, true);
  }
  
  public void t(String paramString, int paramInt, long paramLong)
  {
    d(paramString, paramInt, paramLong, true);
  }
  
  public void t(List<MessageRecord> paramList, String paramString)
  {
    paramString = this.app.getEntityManagerFactory(paramString).createEntityManager();
    try
    {
      a(paramList, paramString, true, false, true, true);
      paramString.close();
      paramString = top.a(paramList);
      if (paramString != null)
      {
        setChanged();
        notifyObservers(paramString);
      }
      fv(paramList);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public void uy(String paramString)
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    paramString = (ArrayList)localEntityManager.query(TransFileInfo.class, false, "friendUin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        localEntityManager.remove((TransFileInfo)paramString.next());
      }
    }
    localEntityManager.close();
  }
  
  public void uz(String paramString)
  {
    MessageRecord localMessageRecord = anbi.d(-1052);
    localMessageRecord.msg = paramString;
    localMessageRecord.frienduin = acbn.blz;
    localMessageRecord.senderuin = this.app.getCurrentAccountUin();
    localMessageRecord.time = anaz.gQ();
    localMessageRecord.msgseq = ((int)localMessageRecord.time);
    localMessageRecord.msgUid = anbk.I(anbk.Ji());
    this.app.a().a(localMessageRecord, null, true);
  }
  
  public void v(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    String str;
    int i;
    do
    {
      return;
      str = ((RevokeMsgInfo)paramArrayList.get(0)).frienduin;
      i = ((RevokeMsgInfo)paramArrayList.get(0)).istroop;
      a(i).t(paramArrayList, paramBoolean);
      ((znv)this.app.getBusinessHandler(147)).V(str, i, -1);
    } while ((!paramBoolean) || ((i != 1) && (i != 3000)));
    s(str, i, this.app.a().e(str, i));
  }
  
  public int vc()
  {
    return this.bCQ;
  }
  
  public int vd()
  {
    int i = eE(10);
    if (QLog.isColorLevel()) {
      QLog.d("MiniUnreadMsgsNum", 2, "unread count = " + i);
    }
    return i;
  }
  
  public int ve()
  {
    return eE(7);
  }
  
  public int vf()
  {
    return eE(9);
  }
  
  public boolean y(MessageRecord paramMessageRecord)
  {
    Message localMessage = a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (top.fv(paramMessageRecord.istroop)) {
      if ((paramMessageRecord.msgUid != localMessage.msgUid) || (paramMessageRecord.shmsgseq != localMessage.shmsgseq)) {}
    }
    while (paramMessageRecord.shmsgseq == localMessage.shmsgseq)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean y(String paramString, int paramInt)
  {
    paramString = MessageRecord.getTableName(paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("select count() as counter, 'x' as msgData from ").append(paramString).append(" where issend=0 and isValid=1 and msgtype ").append(top.ow());
    paramString = this.app.a().createEntityManager().rawQuery(Message.class, localStringBuilder.toString(), null);
    if ((paramString != null) && (paramString.size() > 0)) {
      return ((Message)paramString.get(0)).counter > 0;
    }
    return false;
  }
  
  public void z(MessageRecord paramMessageRecord)
  {
    b(paramMessageRecord, MessageHandler.cwL);
  }
  
  public boolean z(String paramString, int paramInt)
  {
    paramString = u(paramString, paramInt);
    if (this.gP.containsKey(paramString))
    {
      paramString = (Message)this.gP.get(paramString);
      if ((paramString.time > 0L) && (paramString.senderuin != null)) {
        return true;
      }
    }
    return false;
  }
  
  public void zB(int paramInt)
  {
    String str = String.valueOf(acbn.bkV);
    if (a().A(str, 4001) <= 0) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.QQMessageFacade", 2, "setRecommendMsgReaded return : unread=0");
      }
    }
    do
    {
      return;
      Message localMessage = a(str, 4001);
      paramInt = b(4001).a(paramInt, localMessage);
      a().G(str, 4001, -paramInt);
    } while (paramInt == 0);
    setChanged();
    notifyObservers(a(str, 4001));
  }
  
  public void zC(int paramInt)
  {
    Object localObject = this.app.a(4001).h(String.valueOf(acbn.bkV), 4001);
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      return;
      this.app.b().zB(paramInt);
    } while (b(4001).eB(paramInt) <= 0);
    setChanged();
    localObject = new RecentUser();
    ((RecentUser)localObject).uin = String.valueOf(acbn.bkT);
    notifyObservers(localObject);
  }
  
  public static class Message
    extends MessageRecord
  {
    public String actMsgContentValue;
    public String action;
    public int bizType = -1;
    public int counter;
    public CharSequence emoRecentMsg;
    public long fileSize = -1L;
    public int fileType = -1;
    public boolean hasReply;
    @notColumn
    public boolean isCacheValid = true;
    @notColumn
    public boolean isFromLS;
    public MessageRecord lastMsg;
    public ArrayList<acsu.a> msgInfoList;
    public String nickName;
    public String pttUrl;
    public long shareAppID;
    @Deprecated
    public int unReadNum;
    
    public void cleanMessageRecordBaseField()
    {
      this.msg = null;
      this.emoRecentMsg = null;
      this.fileType = -1;
    }
    
    public Class<? extends Entity> getClassForTable()
    {
      return Message.class;
    }
    
    public CharSequence getMessageText()
    {
      if (this.emoRecentMsg == null) {
        return this.msg;
      }
      return this.emoRecentMsg;
    }
    
    public boolean needNotification()
    {
      return (this.bizType == 24) || (this.bizType == 17) || (this.bizType == 16) || (this.bizType == 5) || (this.bizType == 13) || (this.bizType == 27) || (this.bizType == 4) || (this.bizType == 14) || (this.bizType == 12);
    }
  }
  
  public static class a
  {
    public Object obj;
    public int operation;
    public int type;
    public String uin;
    
    public a() {}
    
    public a(String paramString, int paramInt1, int paramInt2, Object paramObject)
    {
      this.uin = paramString;
      this.type = paramInt1;
      this.operation = paramInt2;
      this.obj = paramObject;
    }
  }
  
  public static class b
  {
    public long EK = 9223372036854775807L;
    public long EL = 0L;
    public toj a;
    public boolean aQf = true;
    public boolean aQg;
    public boolean aQh = true;
    public boolean aQi;
    public boolean aQj = true;
    public boolean aQk;
    public volatile boolean aQl;
    public int aaU;
    public int bCS;
    public int bCT;
    public Object context;
    public int count;
    public boolean isComplete;
    public boolean isSuccess = true;
    public List<MessageRecord> pX;
    public int topicId;
    public String uin;
    public int uinType;
    
    public String toString()
    {
      return "[isComplete = " + this.isComplete + ", isJoined = " + this.aQf + ", isLocalOnly = " + this.aQg + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade
 * JD-Core Version:    0.7.0.1
 */