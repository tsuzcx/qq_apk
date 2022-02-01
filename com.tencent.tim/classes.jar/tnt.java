import ActionMsg.MsgBody;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.BaseMessageManager.1;
import com.tencent.imcore.message.BaseMessageManager.2;
import com.tencent.imcore.message.BaseMessageManager.3;
import com.tencent.imcore.message.BaseMessageManager.4;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.imcore.message.QQMessageFacade.b;
import com.tencent.ims.bankcode_info.BankcodeCtrlInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.revokemsg.RevokeMsgInfo;>;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import localpb.richMsg.RichMsg.FoldMsg;
import localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public abstract class tnt
  extends Observable
  implements acqy
{
  protected tom a;
  public QQAppInterface app;
  public QQMessageFacade b;
  private Object bD = new Object();
  private Object lock = new Object();
  
  public tnt(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, tom paramtom)
  {
    this.app = paramQQAppInterface;
    this.b = paramQQMessageFacade;
    this.a = paramtom;
  }
  
  private ahwa a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, MessageForUniteGrayTip paramMessageForUniteGrayTip, long paramLong)
  {
    Object localObject1 = "";
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = ((TroopManager)this.app.getManager(52)).jr(paramString3);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt(aqgv.ctc, aqgv.dZg);
      ((Bundle)localObject2).putLong(aqgv.ctd, paramMessageForUniteGrayTip.uniseq);
      localObject2 = aqgv.a(this.app, paramString2, paramString3, (String)localObject1, true, (Bundle)localObject2);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = aqgv.a(this.app, paramString2, paramString3, 1, 0);
      }
    }
    for (;;)
    {
      localObject2 = this.app.getApp().getString(2131699921);
      int i = paramString1.length() + ((String)localObject2).length();
      int j = i + ((String)localObject1).length();
      paramString1 = paramString1 + (String)localObject2 + (String)localObject1 + this.app.getApp().getString(2131699922);
      paramString3 = new ahwa(paramString3, paramString4, paramString1, paramInt, -5040, 1, paramLong);
      paramString4 = new Bundle();
      paramString4.putInt(aqgv.ctc, aqgv.dZg);
      paramString4.putLong(aqgv.ctd, paramMessageForUniteGrayTip.uniseq);
      paramString4.putInt("key_action", 28);
      paramString4.putString("troop_mem_uin", String.valueOf(paramString2));
      paramString4.putBoolean("need_update_nick", true);
      paramString3.addHightlightItem(i, j, paramString4);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke message wording", paramString1, Integer.valueOf(i), " end:", Integer.valueOf(j) });
      }
      return paramString3;
      if (paramInt == 3000) {
        localObject1 = aqgv.a(this.app, paramString2, paramString3, 2, 0);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, tnt.b> paramHashMap)
  {
    HashSet localHashSet = new HashSet();
    paramQQAppInterface = (zxj)paramQQAppInterface.getManager(125);
    paramQQAppInterface.BX(false);
    if (paramQQAppInterface.hM.isEmpty()) {
      return;
    }
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      tnt.b localb1 = (tnt.b)localEntry.getValue();
      if (localb1.aPT)
      {
        String str = (String)paramQQAppInterface.hM.get(localEntry.getKey());
        if ((!TextUtils.isEmpty(str)) && (paramHashMap.containsKey(str)))
        {
          tnt.b localb2 = (tnt.b)paramHashMap.get(str);
          localHashSet.add(str);
          localb1.foldMsgCount += localb2.foldMsgCount;
          localb1.foldUinList.addAll(localb2.foldUinList);
          if ((localb1.aPS) || (localb2.aPS)) {}
          for (boolean bool = true;; bool = false)
          {
            localb1.aPS = bool;
            if (localb1.EB < localb2.EB)
            {
              localb1.EB = localb2.EB;
              localb1.b = localb2.b;
              localb1.b.redBagIndex = ((String)localEntry.getKey());
            }
            if (localb1.EA <= localb2.EA) {
              break;
            }
            localb1.EA = localb2.EA;
            localb1.a = localb2.a;
            localb1.a.redBagIndex = ((String)localEntry.getKey());
            break;
          }
        }
      }
    }
    paramHashMap.keySet().removeAll(localHashSet);
  }
  
  private boolean a(QQMessageFacade.Message paramMessage)
  {
    Iterator localIterator = this.app.b().a().cy().iterator();
    while (localIterator.hasNext()) {
      if (((tpg)localIterator.next()).b(paramMessage)) {
        return true;
      }
    }
    return false;
  }
  
  private long d(String paramString, int paramInt)
  {
    if (paramString == null) {
      return 0L;
    }
    Object localObject1 = null;
    Object localObject2;
    if (top.eD(paramInt) == 1009)
    {
      localObject1 = this.app.a(paramInt).g(acbn.bkt, 1009);
      localObject2 = "";
    }
    for (;;)
    {
      int j = 0;
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (!((List)localObject1).isEmpty())
        {
          localObject1 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject1).next();
            if (paramString.equals(localMessageRecord.senderuin))
            {
              return localMessageRecord.uniseq;
              if (top.eD(paramInt) == 1001)
              {
                localObject1 = this.app.a(paramInt).g(acbn.bkE, 1001);
                localObject2 = acbn.blg;
                continue;
              }
              if (top.eD(paramInt) == 1010)
              {
                localObject1 = this.app.a(paramInt).g(acbn.bkY, 1010);
                localObject2 = acbn.blh;
                continue;
              }
              if (top.eD(paramInt) != 10002) {
                break label361;
              }
              localObject1 = this.app.a(paramInt).g(acbn.bkE, 10002);
              localObject2 = acbn.blg;
              continue;
            }
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || ((!acbn.blg.equals(localMessageRecord.senderuin)) && (!acbn.blh.equals(localMessageRecord.senderuin)))) {
              break label358;
            }
            i = 1;
          }
        }
      }
      label358:
      for (;;)
      {
        break;
        if (i != 0)
        {
          localObject1 = this.app.a(paramInt).g((String)localObject2, top.eD(paramInt));
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if (paramString.equals(((MessageRecord)localObject2).senderuin)) {
                return ((MessageRecord)localObject2).uniseq;
              }
            }
          }
        }
        return 0L;
      }
      label361:
      localObject2 = "";
    }
  }
  
  private boolean gK(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length > 3) {
        try
        {
          Long.valueOf(paramString[1]);
          Integer.valueOf(paramString[2]);
          Boolean.valueOf(paramString[3]);
          return true;
        }
        catch (NumberFormatException paramString)
        {
          return false;
        }
      }
      return false;
    }
    return false;
  }
  
  private void w(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    this.app.execute(new BaseMessageManager.4(this, paramMessageRecord, l));
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (tog.a(paramConversationInfo) > 0) {
      if (paramInt == 2)
      {
        if ((!this.app.P(paramConversationInfo.uin, paramConversationInfo.type)) && (!top.g(this.app, paramConversationInfo.uin, paramConversationInfo.type)) && (this.b.a().u(paramConversationInfo.uin, paramConversationInfo.type))) {
          return tog.a(paramConversationInfo);
        }
      }
      else if (paramInt == 6)
      {
        if (((paramConversationInfo.type == 1001) || (paramConversationInfo.type == 10002)) && (acbn.bkE.equals(paramConversationInfo.uin)) && (this.b.a().u(paramConversationInfo.uin, paramConversationInfo.type))) {
          return tog.a(paramConversationInfo);
        }
      }
      else if (paramInt == 7)
      {
        if ((paramConversationInfo.type == 1009) && (paramConversationInfo.uin.equals(acbn.bkt)) && (this.b.a().u(paramConversationInfo.uin, paramConversationInfo.type))) {
          return tog.a(paramConversationInfo);
        }
      }
      else if (paramInt == 8)
      {
        if ((paramConversationInfo.type == 1010) && (paramConversationInfo.uin.equals(acbn.bkY)) && (this.b.a().u(paramConversationInfo.uin, paramConversationInfo.type))) {
          return tog.a(paramConversationInfo);
        }
      }
      else if (paramInt == 9)
      {
        if ((paramConversationInfo.type == 1008) && (this.b.a().u(paramConversationInfo.uin, paramConversationInfo.type))) {
          return tog.a(paramConversationInfo);
        }
      }
      else if (paramInt == 10)
      {
        if (((paramConversationInfo.type == 0) || (paramConversationInfo.type == 1) || (paramConversationInfo.type == 3000)) && (!this.app.P(paramConversationInfo.uin, paramConversationInfo.type)) && (!top.g(this.app, paramConversationInfo.uin, paramConversationInfo.type)) && (this.b.a().u(paramConversationInfo.uin, paramConversationInfo.type))) {
          return tog.a(paramConversationInfo);
        }
      }
      else {
        return tog.a(paramConversationInfo);
      }
    }
    return 0;
  }
  
  public int a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "clearHistory uin = " + paramString + ", type = " + paramInt + ", needDeleteDB = " + paramBoolean1);
    }
    this.app.a().bP(paramString, paramInt);
    QQMessageFacade.Message localMessage = this.b.a(paramString, paramInt);
    int i = this.app.a(paramInt).c(paramString, paramInt, paramBoolean1);
    Object localObject;
    switch (paramInt)
    {
    default: 
      if ((3000 != paramInt) && (1 != paramInt) && (5000 != paramInt)) {
        this.b.uy(paramString);
      }
      if (i > 0) {
        localMessage.cleanMessageRecordBaseField();
      }
      if ((paramInt != 3000) && (paramInt != 1) && (this.app.a().t(paramString, top.eD(paramInt))))
      {
        if (top.eD(paramInt) != 1009) {
          break label332;
        }
        c(acbn.bkt, 1009, paramString, this.app.getCurrentAccountUin());
        localObject = this.b.a(acbn.bkt, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      break;
    }
    for (;;)
    {
      if (paramBoolean2)
      {
        localObject = this.app.a().a().a(paramString, localMessage.istroop);
        if (localObject != null) {
          this.b.a((RecentUser)localObject);
        }
      }
      this.b.gP.remove(top.u(paramString, paramInt));
      this.b.as(localMessage);
      return i;
      this.app.a().gf(paramString, 0);
      break;
      label332:
      if (top.eD(paramInt) == 1001)
      {
        c(acbn.bkE, 1001, paramString, this.app.getCurrentAccountUin());
        localObject = this.b.a(acbn.bkE, 1001);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (top.eD(paramInt) == 1010)
      {
        c(acbn.bkY, 1010, paramString, this.app.getCurrentAccountUin());
        localObject = this.b.a(acbn.bkY, 1010);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (top.eD(paramInt) == 10002)
      {
        c(acbn.bkE, 10002, paramString, this.app.getCurrentAccountUin());
        localObject = this.b.a(acbn.bkE, 10002);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
      else if (top.eD(paramInt) == 1044)
      {
        c(acbn.blR, 1044, paramString, this.app.getCurrentAccountUin());
        localObject = this.b.a(acbn.blR, 1044);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString))) {
          ((QQMessageFacade.Message)localObject).cleanMessageRecordBaseField();
        }
      }
    }
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt, EntityManager paramEntityManager)
  {
    if (paramString == null)
    {
      paramString = new QQMessageFacade.Message();
      return paramString;
    }
    if (acra.j(this.app, paramString, paramInt))
    {
      QLog.e("MsgInvalidTypeErr", 1, "find invalid refreshSingleLastMsg" + paramString);
      acra.FZ(paramString);
    }
    String str = top.u(paramString, paramInt);
    Object localObject1 = null;
    Object localObject2 = (QQMessageFacade.Message)this.b.gP.get(str);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt);
    if ((localObject2 == null) || (!((QQMessageFacade.Message)localObject2).isCacheValid))
    {
      localObject1 = MessageRecord.getTableName(paramString, paramInt);
      if (paramString.equals(String.valueOf(acbn.bkw))) {
        localObject1 = DataLineMsgRecord.tableName();
      }
      if (paramString.equals(String.valueOf(acbn.bkx))) {
        localObject1 = DataLineMsgRecord.tableName(1);
      }
      QQMessageFacade.Message localMessage = this.app.a(paramInt).a((String)localObject1, paramEntityManager);
      Object localObject3 = localObject1;
      localObject2 = localMessage;
      if (localMessage == null) {
        if ((!top.fv(paramInt)) && (paramInt != 1))
        {
          localObject3 = localObject1;
          localObject2 = localMessage;
          if (paramInt != 3000) {}
        }
        else
        {
          localObject3 = MessageRecord.getOldTableName(paramString, paramInt);
          localObject2 = this.app.a(paramInt).a((String)localObject3, paramEntityManager);
        }
      }
      if (QLog.isColorLevel()) {
        localStringBuilder.append(" message:" + localObject2);
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((QQMessageFacade.Message)localObject2).uniseq == 0L)
        {
          this.app.a(((QQMessageFacade.Message)localObject2).istroop).h(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
          paramEntityManager = this.app.a(((QQMessageFacade.Message)localObject2).istroop).a((String)localObject3, paramEntityManager);
          localObject1 = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject1 = paramEntityManager;
          }
        }
      }
      if (localObject1 != null)
      {
        if (((paramString.equals(String.valueOf(acbn.bkw))) || (paramString.equals(String.valueOf(acbn.bkx)))) && (((QQMessageFacade.Message)localObject1).msgData != null))
        {
          paramString = new DataLineMsgRecord();
          DataLineMsgRecord.unpackMsgData(paramString, ((QQMessageFacade.Message)localObject1).msgData, ((QQMessageFacade.Message)localObject1).versionCode);
          ((QQMessageFacade.Message)localObject1).msg = paramString.msg;
        }
        if ((acbn.bkE.equals(((QQMessageFacade.Message)localObject1).frienduin)) || ((top.eD(((QQMessageFacade.Message)localObject1).istroop) != 1001) && (top.eD(((QQMessageFacade.Message)localObject1).istroop) != 10002)))
        {
          paramString = (String)localObject1;
          if (!acbn.bkY.equals(((QQMessageFacade.Message)localObject1).frienduin))
          {
            paramString = (String)localObject1;
            if (top.eD(((QQMessageFacade.Message)localObject1).istroop) != 1010) {}
          }
        }
        else
        {
          paramEntityManager = this.app.a(((QQMessageFacade.Message)localObject1).istroop).h(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          paramString = (String)localObject1;
          if (paramEntityManager != null)
          {
            paramString = (String)localObject1;
            if (paramEntityManager.size() > 0)
            {
              paramEntityManager = paramEntityManager.iterator();
              do
              {
                paramString = (String)localObject1;
                if (!paramEntityManager.hasNext()) {
                  break;
                }
                paramString = (MessageRecord)paramEntityManager.next();
              } while ((paramString.senderuin == null) || (!paramString.senderuin.equals(paramString.frienduin)) || (anbk.ls(paramString.msgtype)));
              ((QQMessageFacade.Message)localObject1).hasReply = true;
              paramString = (String)localObject1;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg = " + localObject1 + ",hasReply=" + ((QQMessageFacade.Message)localObject1).hasReply);
                paramString = (String)localObject1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramEntityManager = (QQMessageFacade.Message)this.b.gP.get(str);
        if (paramEntityManager != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        b(paramString);
        this.b.gP.put(str, paramString);
        paramEntityManager = paramString;
      }
      catch (Throwable localThrowable)
      {
        paramEntityManager = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramEntityManager = paramString;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramString = paramEntityManager;
      if (paramEntityManager == null) {
        break;
      }
      paramString = paramEntityManager;
      if (!top.x(paramEntityManager.frienduin, paramEntityManager.istroop)) {
        break;
      }
      paramEntityManager.istroop = top.eD(paramEntityManager.istroop);
      return paramEntityManager;
      paramEntityManager = new QQMessageFacade.Message();
      paramEntityManager.frienduin = paramString;
      paramEntityManager.istroop = paramInt;
      paramString = paramEntityManager;
      continue;
      if (b(paramEntityManager) < b(paramString))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        b(paramString);
        this.b.gP.put(str, paramString);
      }
      else if ((!paramEntityManager.isCacheValid) && (paramString.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
        b(paramString);
        this.b.gP.put(str, paramString);
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramEntityManager.isCacheValid = true;
        paramString = paramEntityManager;
        continue;
        paramEntityManager = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localObject2);
          paramEntityManager = localThrowable;
        }
      }
    }
  }
  
  public QQMessageFacade.Message a(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    if ((paramInt1 == 1033) || (paramInt1 == 1034)) {}
    for (int i = 1; i != 0; i = 0) {
      return b(paramString, paramInt1, paramEntityManager, paramInt2);
    }
    return a(paramString, paramInt1, paramEntityManager);
  }
  
  protected List<MessageRecord> a(String paramString, int paramInt1, int paramInt2)
  {
    return new ArrayList();
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong)
  {
    return a(paramString, paramInt, paramLong, false);
  }
  
  public List<ChatMessage> a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    Object localObject1;
    if (paramLong >= 0L) {
      localObject1 = this.app.a(paramInt1).a(paramString, paramInt1, paramLong, paramInt2);
    }
    while (localObject1 == null)
    {
      return new ArrayList();
      if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
        localObject1 = this.app.a(paramInt1).a(paramString, paramInt1, true, true);
      } else {
        localObject1 = this.app.a(paramInt1).b(paramString, paramInt1, paramInt2, true);
      }
    }
    bJ(paramString, paramInt1);
    Object localObject2 = new ArrayList(((List)localObject1).size());
    ((List)localObject2).addAll((Collection)localObject1);
    if (zxj.d(this.app, paramInt1, paramString)) {
      a(this.app, (List)localObject2, null, false, true);
    }
    top.a((List)localObject2, this.app);
    top.a(paramString, paramInt1, (List)localObject2, this.app);
    if ((!((List)localObject2).isEmpty()) && ((((List)localObject2).get(((List)localObject2).size() - 1) instanceof MessageForLongMsg)) && (top.c((MessageRecord)((List)localObject2).get(((List)localObject2).size() - 1), this.b.a(paramString, paramInt1))))
    {
      localObject1 = (MessageForLongMsg)((List)localObject2).get(((List)localObject2).size() - 1);
      if ((((MessageForLongMsg)localObject1).longMsgFragmentList != null) && (!((MessageForLongMsg)localObject1).longMsgFragmentList.isEmpty()) && (((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0)).longMsgIndex < this.b.a(paramString, paramInt1).longMsgIndex))
      {
        a((MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), true, 2);
        b(paramString, paramInt1, (MessageRecord)((MessageForLongMsg)localObject1).longMsgFragmentList.get(0), 2);
        a((MessageRecord)localObject1, true, 3);
        b(paramString, paramInt1, (MessageRecord)localObject1, 3);
      }
    }
    Object localObject3;
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    label459:
    Object localObject4;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("newAIOCursor clone ");
      if (localObject2 != null)
      {
        localObject1 = Integer.valueOf(((List)localObject2).size());
        QLog.d("Q.msg.BaseMessageManager", 2, localObject1);
      }
    }
    else
    {
      localObject3 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList1 = new ArrayList();
      Iterator localIterator = ((List)localObject2).iterator();
      if (!localIterator.hasNext()) {
        break label1138;
      }
      localObject1 = (MessageRecord)localIterator.next();
      if (!(localObject1 instanceof MessageForArkApp)) {
        break label1425;
      }
      localObject2 = adrm.a().a();
      if ((localObject2 == null) || (((MessageRecord)localObject1).uniseq != ((MessageForArkApp)localObject2).uniseq)) {
        break label1425;
      }
      localObject4 = adrm.a().a();
      if (localObject4 != null)
      {
        ((MessageForArkApp)localObject2).arkContainer = ((wyv)localObject4);
        localObject1 = localObject2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArkTipsManager", 2, "refill ark msg: " + ((MessageForArkApp)localObject2).uniseq + " ark c=" + ((MessageForArkApp)localObject2).arkContainer);
      }
    }
    label1411:
    label1420:
    label1425:
    for (;;)
    {
      for (;;)
      {
        if ((localObject1 instanceof ChatMessage))
        {
          ((List)localObject3).add((ChatMessage)localObject1);
          localObject2 = ((MessageRecord)localObject1).getExtInfoFromExtStr("sens_msg_ctrl_info");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label862;
          }
          if (!((MessageRecord)localObject1).isSend()) {
            break label700;
          }
          ((MessageRecord)localObject1).saveExtInfoToExtStr("sens_msg_need_parse", Boolean.toString(false));
          break label459;
          localObject1 = "clone is null";
          break;
        }
        QLog.e("MsgInvalidTypeErr", 1, "err msg" + ((MessageRecord)localObject1).getBaseInfoString());
        acra.X((MessageRecord)localObject1);
        break label459;
        label700:
        localObject4 = new bankcode_info.BankcodeCtrlInfo();
        try
        {
          ((bankcode_info.BankcodeCtrlInfo)localObject4).mergeFrom(HexUtil.hexStr2Bytes((String)localObject2));
          paramInt2 = 0;
          if (((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.has()) {
            paramInt2 = ((bankcode_info.BankcodeCtrlInfo)localObject4).msgtail_id.get();
          }
          if (paramInt2 != 1) {
            break label459;
          }
          ((ChatMessage)localObject1).parse();
          localObject2 = anbi.d(-1014);
          ((MessageRecord)localObject2).msgtype = -1046;
          ((MessageRecord)localObject2).senderuin = ((MessageRecord)localObject2).selfuin;
          ((MessageRecord)localObject2).frienduin = paramString;
          ((MessageRecord)localObject2).istroop = ((MessageRecord)localObject1).istroop;
          ((MessageRecord)localObject2).msg = "";
          ((MessageRecord)localObject2).isread = true;
          ((MessageRecord)localObject2).shmsgseq = ((MessageRecord)localObject1).shmsgseq;
          ((MessageRecord)localObject2).time = ((MessageRecord)localObject1).time;
          ((MessageRecord)localObject2).saveExtInfoToExtStr("sens_msg_uniseq", Long.toString(((MessageRecord)localObject1).uniseq));
          ((List)localObject3).add((ChatMessage)localObject2);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label862:
            String str;
            localException.printStackTrace();
          }
        }
      }
      if ((paramInt1 == 1008) && ((localObject1 instanceof MessageForStructing)))
      {
        localObject4 = ((MessageRecord)localObject1).getExtInfoFromExtStr("pa_phone_msg_tip");
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = new TroopTipsEntity();
          ((TroopTipsEntity)localObject2).optContent = ((String)localObject4);
          ((apuf)this.app.getManager(81)).a((TroopTipsEntity)localObject2);
          localObject4 = new MessageForGrayTips();
          paramLong = ((MessageRecord)localObject1).time;
          str = this.app.getCurrentAccountUin();
          ((MessageForGrayTips)localObject4).init(str, paramString, str, ((TroopTipsEntity)localObject2).optContent, paramLong, -1048, paramInt1, paramLong);
          ((MessageForGrayTips)localObject4).isread = true;
          apuf.a((MessageForGrayTips)localObject4, ((TroopTipsEntity)localObject2).highlightItems);
          ((List)localObject3).add(localObject4);
        }
      }
      if (paramBoolean) {
        break label459;
      }
      if ((paramInt1 == 0) && ((localObject1 instanceof MessageForPoke)))
      {
        localObject2 = (MessageForPoke)localObject1;
        if (!((MessageForPoke)localObject2).isSend()) {
          localArrayList2.add(localObject2);
        }
        if ((((MessageForPoke)localObject2).interactType == 126) && (!((MessageForPoke)localObject2).isPlayed) && (!((MessageForPoke)localObject2).isSend())) {
          break label459;
        }
        if ((((MessageForPoke)localObject2).isread) && (!((MessageForPoke)localObject2).isPlayed) && (!((MessageForPoke)localObject2).isSend())) {
          ((MessageForPoke)localObject2).setPlayed(this.app);
        }
      }
      if ((paramInt1 != 0) || (!(localObject1 instanceof MessageForPokeEmo))) {
        break label459;
      }
      localArrayList1.add((MessageForPokeEmo)localObject1);
      break label459;
      label1138:
      if (!paramBoolean)
      {
        paramInt2 = localArrayList2.size();
        if (paramInt2 <= 1) {
          break label1420;
        }
        paramString = (MessageForPoke)localArrayList2.get(paramInt2 - 1);
        paramInt1 = 0;
        while (paramInt1 < paramInt2 - 1)
        {
          localObject1 = (MessageForPoke)localArrayList2.get(paramInt1);
          if ((localObject1 != null) && (!((MessageForPoke)localObject1).isPlayed) && (!((MessageForPoke)localObject1).isSend())) {
            ((MessageForPoke)localObject1).setPlayed(this.app);
          }
          paramInt1 += 1;
        }
      }
      for (;;)
      {
        paramInt2 = localArrayList1.size();
        if (paramInt2 > 1) {}
        for (localObject1 = (MessageForPokeEmo)localArrayList1.get(paramInt2 - 1);; localObject1 = null)
        {
          paramInt1 = 0;
          if ((paramString != null) && (localObject1 != null))
          {
            if (paramString.time < ((MessageForPokeEmo)localObject1).time)
            {
              paramString.setPlayed(this.app);
              paramInt1 = 1;
            }
            if ((paramString != null) && (paramString.isread) && (!paramString.isPlayed)) {
              paramString.setPlayed(this.app);
            }
            if ((localObject1 == null) || (paramInt1 == 0)) {
              break label1411;
            }
            if (paramInt2 - 3 >= 0) {
              break label1403;
            }
          }
          label1403:
          for (paramInt1 = 0;; paramInt1 = paramInt2 - 3)
          {
            if (paramInt2 <= 3) {
              break label1411;
            }
            paramInt2 -= 1;
            while (paramInt2 >= paramInt1)
            {
              paramString = (MessageForPokeEmo)localArrayList1.get(paramInt2);
              if (!paramString.isread) {
                paramString.setIsNeedPlayed(true);
              }
              paramInt2 -= 1;
            }
            if (paramString != null) {
              break;
            }
            paramInt1 = 1;
            break;
          }
          return localObject3;
        }
        paramString = null;
      }
    }
  }
  
  public List<ChatMessage> a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramLong, 0, paramBoolean);
  }
  
  public List<MessageRecord> a(List<MessageRecord> paramList, String paramString, int paramInt, ArrayList<RevokeMsgInfo> paramArrayList)
  {
    if ((paramInt == 3000) || (paramInt == 1)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.next();
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
          if ((paramInt != 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.shmsgseq))
          {
            if (((!localMessageRecord.isSendFromLocal()) || (localMessageRecord.extraflag == 0)) && (!top.s(localMessageRecord))) {
              paramString.add(localMessageRecord);
            }
          }
          else if ((paramInt == 0) && (localMessageRecord.shmsgseq == localRevokeMsgInfo.shmsgseq) && (localMessageRecord.msgUid == localRevokeMsgInfo.msguid)) {
            paramString.add(localMessageRecord);
          }
        }
      }
    }
    return paramString;
  }
  
  protected void a(int paramInt, String paramString, MessageForUniteGrayTip paramMessageForUniteGrayTip, List<MessageRecord> paramList)
  {
    paramString = this.a.a(paramString, paramInt);
    paramString.lock();
    try
    {
      top.a(paramList, paramMessageForUniteGrayTip, true);
      return;
    }
    finally
    {
      paramString.unlock();
    }
  }
  
  public void a(QQMessageFacade.b paramb)
  {
    synchronized (this.lock)
    {
      if (paramb.aQl)
      {
        paramb.aQl = false;
        this.lock.notify();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshMessageListHead notify");
        }
      }
      return;
    }
  }
  
  protected void a(QQMessageFacade.b paramb, int paramInt)
  {
    if ((paramb.pX != null) && (paramb.pX.size() > 0)) {}
    for (int i = 1;; i = 0)
    {
      do
      {
        synchronized (paramb.pX)
        {
          top.a(paramb.pX, this.app);
          if (paramb.pX.size() > 0) {
            top.a(paramb.uin, paramb.uinType, paramb.pX, this.app);
          }
          ??? = paramb.uin;
          int j = paramb.count;
          if ((paramb.aQh) && (i != 0) && (paramb.pX.isEmpty()) && (paramb.aaU < 9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "refreshHeadComplete : the list is empty after the filter, trying to get more. [ index:" + paramb.aaU + " ]");
            }
            paramb.aaU += 1;
            b((String)???, paramInt, j, paramb);
            return;
          }
        }
        paramb.aaU = 0;
        paramb.bCS = 0;
      } while (!paramb.aQj);
      this.b.as(paramb);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList1, List<MessageRecord> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((QLog.isColorLevel()) && (aqmq.aFf()) && (paramList1 != null) && (paramList1.size() > 0))
    {
      localObject1 = new StringBuilder(paramList1.size() * 48 + 64);
      ((StringBuilder)localObject1).append("BaseMessageManager mergeFoldMsgGrayTips(),searchList size=").append(paramList1.size()).append(":");
      localObject2 = paramList1.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append("(").append(((MessageRecord)localObject3).time).append(",").append(((MessageRecord)localObject3).shmsgseq).append(",").append(((MessageRecord)localObject3).msgtype).append(") ");
      }
      QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
    }
    zxj localzxj = (zxj)paramQQAppInterface.getManager(125);
    Object localObject4 = new HashMap();
    Object localObject5 = paramList1.iterator();
    label534:
    label536:
    label943:
    label949:
    label953:
    for (;;)
    {
      label208:
      MessageForFoldMsg localMessageForFoldMsg;
      boolean bool;
      if (((Iterator)localObject5).hasNext())
      {
        localObject1 = (MessageRecord)((Iterator)localObject5).next();
        if (!(localObject1 instanceof MessageForFoldMsg)) {
          continue;
        }
        localMessageForFoldMsg = (MessageForFoldMsg)localObject1;
        if ((!TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(localMessageForFoldMsg.redBagId))) {
          localzxj.r(true, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex);
        }
        if ((!TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) || (TextUtils.isEmpty(localMessageForFoldMsg.redBagId))) {
          break label949;
        }
        if (localzxj.hL.containsKey(localMessageForFoldMsg.redBagId))
        {
          localMessageForFoldMsg.redBagIndex = ((String)localzxj.hL.get(localMessageForFoldMsg.redBagId));
          bool = true;
        }
      }
      for (;;)
      {
        label345:
        if (((!paramBoolean1) && (localzxj.d(localMessageForFoldMsg.frienduin, localMessageForFoldMsg.istroop, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex))) || ((localMessageForFoldMsg.isSend()) && (!localMessageForFoldMsg.foldFlag) && (localMessageForFoldMsg.msgtype == -2006))) {
          break label953;
        }
        if (bool) {}
        for (localObject1 = localMessageForFoldMsg.redBagIndex;; localObject1 = localMessageForFoldMsg.redBagId)
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label534;
          }
          localObject3 = (tnt.b)((HashMap)localObject4).get(localObject1);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = new tnt.b();
            ((HashMap)localObject4).put(localObject1, localObject2);
          }
          ((tnt.b)localObject2).aPT = bool;
          if (localMessageForFoldMsg.foldFlag) {
            break label536;
          }
          ((tnt.b)localObject2).aPS = true;
          if (localMessageForFoldMsg.shmsgseq <= ((tnt.b)localObject2).EB) {
            break;
          }
          ((tnt.b)localObject2).EB = localMessageForFoldMsg.shmsgseq;
          ((tnt.b)localObject2).b = localMessageForFoldMsg;
          break;
          bool = false;
          break label345;
        }
        break label208;
        ((tnt.b)localObject2).foldMsgCount += 1;
        ((tnt.b)localObject2).foldUinList.add(localMessageForFoldMsg.senderuin);
        if (localMessageForFoldMsg.shmsgseq >= ((tnt.b)localObject2).EA) {
          break label208;
        }
        ((tnt.b)localObject2).EA = localMessageForFoldMsg.shmsgseq;
        ((tnt.b)localObject2).a = localMessageForFoldMsg;
        break label208;
        if (((HashMap)localObject4).isEmpty()) {
          break;
        }
        a(paramQQAppInterface, (HashMap)localObject4);
        localObject2 = ((HashMap)localObject4).entrySet().iterator();
        label622:
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (tnt.b)((Map.Entry)((Iterator)localObject2).next()).getValue();
          if (((tnt.b)localObject3).foldMsgCount > 0)
          {
            if (((tnt.b)localObject3).aPS) {
              ((tnt.b)localObject3).a = ((tnt.b)localObject3).b;
            }
            if (paramList2 != null) {
              break label943;
            }
          }
        }
        for (localObject1 = b(paramQQAppInterface, ((MessageRecord)paramList1.get(0)).frienduin, ((MessageRecord)paramList1.get(0)).istroop);; localObject1 = paramList2)
        {
          if (localObject1 == null)
          {
            QLog.e("Q.msg.BaseMessageManager", 1, "mergeFoldMsgGrayTips null aioList");
            return;
          }
          localObject1 = localzxj.a((List)localObject1, ((tnt.b)localObject3).a, ((tnt.b)localObject3).foldUinList, ((tnt.b)localObject3).foldMsgCount, paramBoolean1, paramBoolean2);
          if ((localObject1 == null) || (paramList2 != null)) {
            break label622;
          }
          if ((QLog.isColorLevel()) && (aqmq.aFf()) && (paramList2 != null) && (paramList2.size() > 0))
          {
            localObject3 = new StringBuilder(paramList2.size() * 48 + 32);
            ((StringBuilder)localObject3).append("insert to clone list,addlist size=").append(paramList2.size()).append(":");
            localObject4 = paramList2.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (MessageRecord)((Iterator)localObject4).next();
              ((StringBuilder)localObject3).append("(").append(((MessageRecord)localObject5).time).append(",").append(((MessageRecord)localObject5).shmsgseq).append(",").append(((MessageRecord)localObject5).msgtype).append(") ");
            }
            QLog.d("msgFold", 2, ((StringBuilder)localObject3).toString());
          }
          top.c(paramList1, (MessageRecord)localObject1, true);
          break label622;
          break;
        }
        bool = true;
      }
    }
  }
  
  protected void a(MessageRecord paramMessageRecord, ProxyListener paramProxyListener, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.app.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, paramProxyListener, paramBoolean1, paramBoolean2, true);
    a(paramMessageRecord, true, paramInt);
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, tnt.a parama)
  {
    if (paramMessageRecord == null) {
      return;
    }
    paramEntityManager = parama.gK;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = anaz.gQ();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    parama = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    if ((paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) && (paramMessageRecord.extraflag == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "addMessage set sendmsg extra " + paramMessageRecord.getBaseInfoString());
      }
      paramMessageRecord.extraflag = 32772;
      paramMessageRecord.sendFailCode = 0;
    }
    Object localObject;
    if ((paramMessageRecord instanceof MessageForUniteGrayTip))
    {
      localObject = (MessageForUniteGrayTip)paramMessageRecord;
      if (((MessageForUniteGrayTip)localObject).callback != null) {
        ((MessageForUniteGrayTip)localObject).callback.a((MessageForUniteGrayTip)localObject);
      }
    }
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      localObject = ((MessageForStructing)paramMessageRecord).structingMsg;
      if ((localObject != null) && (((AbsStructMsg)localObject).mMsgServiceID == 61)) {
        paramMessageRecord.extInt = 61;
      }
    }
    this.app.a(paramMessageRecord.istroop).a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord, null, paramBoolean1, paramBoolean2, paramBoolean4);
    if ((paramMessageRecord != null) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      localObject = (MessageForStructing)paramMessageRecord;
      if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgUrl != null) && (((MessageForStructing)localObject).structingMsg.mMsgUrl.startsWith("https://docs.qq.com"))) {
        afdh.a(this.app, ((MessageForStructing)localObject).frienduin, ((MessageForStructing)localObject).senderuin, ((MessageForStructing)localObject).istroop, ((MessageForStructing)localObject).time, ((MessageForStructing)localObject).msgseq, ((MessageForStructing)localObject).msgUid);
      }
    }
    if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 0)) {
      if (a(paramMessageRecord, false, 1))
      {
        if ((paramEntityManager.containsKey(top.u(parama, i))) && (!paramMessageRecord.isSendFromLocal())) {
          break label555;
        }
        paramEntityManager.put(top.u(parama, i), paramMessageRecord);
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if ((!paramMessageRecord.isSendFromLocal()) && ((paramMessageRecord.msgtype == -1051) || ((paramMessageRecord.isLongMsg()) && (paramMessageRecord.longMsgCount == paramMessageRecord.longMsgIndex + 1))))
          {
            paramEntityManager = (ajkw)this.app.getManager(166);
            if (this.app.a.Bd() != 1) {
              continue;
            }
            paramEntityManager.j(this.app, paramMessageRecord);
          }
        }
        catch (Exception paramEntityManager)
        {
          QLog.d("Q.msg.BaseMessageManager", 1, "longmsg receive report error!", paramEntityManager);
          continue;
          ThreadManager.getSubThreadHandler().postDelayed(new BaseMessageManager.3(this, paramEntityManager, paramMessageRecord), 10000L);
        }
        try
        {
          if ((paramMessageRecord.isSendFromLocal()) || ((paramMessageRecord.msgtype != -1036) && (paramMessageRecord.msgtype != -1035))) {
            break;
          }
          paramEntityManager = (ajcy)this.app.getManager(174);
          if (this.app.a.Bd() != 1) {
            continue;
          }
          paramEntityManager.ap(paramMessageRecord);
          return;
        }
        catch (Exception paramMessageRecord)
        {
          QLog.d("Q.msg.BaseMessageManager", 1, "mixexmsg receive report error!", paramMessageRecord);
          return;
        }
      }
      label555:
      localObject = (MessageRecord)paramEntityManager.get(top.u(parama, i));
      if (b(paramMessageRecord) >= b((MessageRecord)localObject))
      {
        paramEntityManager.put(top.u(parama, i), paramMessageRecord);
        continue;
        a(paramMessageRecord, true, 1);
        continue;
        ThreadManager.getSubThreadHandler().postDelayed(new BaseMessageManager.2(this, paramEntityManager, paramMessageRecord), 10000L);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, kdm paramkdm)
  {
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    paramMessageRecord = top.u(str, i);
    int j = 0;
    Object localObject;
    MessageRecord localMessageRecord;
    if (this.b.gP.containsKey(paramMessageRecord))
    {
      localObject = paramkdm.a();
      localMessageRecord = this.b.d(str, i);
      if (localMessageRecord == null) {
        break label159;
      }
      a(localMessageRecord, true, 4);
      i = j;
      paramMessageRecord = localMessageRecord;
    }
    for (;;)
    {
      if (((localObject != null) && (str.equals(((EcShopData)localObject).mUin))) || (i != 0))
      {
        paramkdm = this.app.a().a().a(String.valueOf(9970L), 7120);
        if (paramkdm != null)
        {
          if (paramMessageRecord != null)
          {
            paramkdm.lastmsgtime = paramMessageRecord.time;
            this.app.a().a().e(paramkdm);
          }
          this.b.as(paramkdm);
        }
      }
      return;
      label159:
      paramkdm.lU(str);
      QQMessageFacade localQQMessageFacade = this.app.b();
      paramMessageRecord = localMessageRecord;
      i = j;
      if (localQQMessageFacade != null)
      {
        paramkdm = paramkdm.a();
        paramMessageRecord = localMessageRecord;
        localObject = paramkdm;
        i = j;
        if (paramkdm != null)
        {
          paramMessageRecord = localQQMessageFacade.a(paramkdm.mUin, 1008);
          i = 1;
          localObject = paramkdm;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    int j = 0;
    Object localObject1 = new ArrayList();
    if ((paramMessageRecord instanceof MessageForLongMsg))
    {
      ((List)localObject1).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
      if (!top.c(paramMessageRecord, this.b.a(paramMessageRecord.frienduin, paramMessageRecord.istroop))) {
        break label450;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + paramMessageRecord);
      }
      Object localObject2 = top.u(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (this.b.gP.containsKey(localObject2))
      {
        localObject2 = (QQMessageFacade.Message)this.b.gP.get(localObject2);
        if ((!paramMessageRecord.isread) && (localObject2 != null)) {
          this.app.a().a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop, (MessageRecord)localObject2);
        }
      }
      this.b.A(paramMessageRecord);
      int k = ((List)localObject1).size();
      for (;;)
      {
        if (j < k)
        {
          localObject2 = (MessageRecord)((List)localObject1).get(j);
          this.app.a(((MessageRecord)localObject2).istroop).a((MessageRecord)localObject2, paramBoolean2);
          this.app.a().ay((MessageRecord)localObject2);
          j += 1;
          continue;
          ((List)localObject1).add(paramMessageRecord);
          if (this.b.y(paramMessageRecord)) {
            break;
          }
          i = 0;
          break;
        }
      }
      if (paramBoolean1) {
        this.app.a().a().Y(paramMessageRecord);
      }
      if (i != 0)
      {
        localObject1 = (kdm)this.app.getManager(88);
        if (!top.fL(paramMessageRecord.istroop)) {
          break label352;
        }
        t(paramMessageRecord);
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.app.a(paramMessageRecord.istroop).bEw();
        }
        return;
        label352:
        if (nyn.i(this.app, paramMessageRecord.frienduin))
        {
          a(paramMessageRecord, (kdm)localObject1);
        }
        else if ((paramMessageRecord.istroop == 1008) && (nyn.f(this.app, paramMessageRecord.frienduin)))
        {
          u(paramMessageRecord);
          nyn.a().ad(this.app);
        }
        else if ((paramMessageRecord.istroop != 1008) || (!nyn.h(this.app, paramMessageRecord.frienduin)))
        {
          u(paramMessageRecord);
        }
      }
      label450:
      i = 0;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb)
  {
    paramb.aQh = true;
    paramb.uin = paramString;
    paramb.uinType = paramInt1;
    paramb.count = paramInt2;
    if (top.eD(paramInt1) != 1032) {}
    for (String str = top.u(paramString, paramInt1); this.b.gQ.containsKey(str); str = aegu.g(paramString, paramInt1, paramb.topicId))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "refreshMessageListHead UNFINISHED ERROR uin = " + paramString + ", type = " + paramInt1);
      }
      if ((paramb.aQl) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.BaseMessageManager", 2, "numTroopRefresh = " + paramb.aQl + ", refreshActionMap[" + top.u(paramString, paramInt1) + "] = " + this.b.gQ.get(str));
      }
      this.b.as(paramb);
      return;
    }
    this.b.gQ.put(str, Boolean.valueOf(true));
    this.app.execute(new BaseMessageManager.1(this, paramString, paramInt1, paramInt2, paramb, str));
  }
  
  public void a(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    List localList = this.app.a(paramInt1).h(paramString, paramInt1);
    QQMessageFacade.Message localMessage = this.b.a(paramString, paramInt1);
    if ((paramMessageRecord != null) && (paramMessageRecord.isLongMsg())) {
      if ((top.c(paramMessageRecord, localMessage)) && (((paramInt2 == 3) && (paramMessageRecord.extraflag == 32768)) || (paramMessageRecord.longMsgIndex == localMessage.longMsgIndex)))
      {
        a(paramMessageRecord, true, paramInt2);
        b(paramString, paramInt1, paramMessageRecord, paramInt2);
      }
    }
    while ((paramMessageRecord == null) || (localList == null) || (localList.isEmpty()) || (paramMessageRecord.uniseq != ((MessageRecord)localList.get(localList.size() - 1)).uniseq)) {
      return;
    }
    a(paramMessageRecord, true, paramInt2);
    b(paramString, paramInt1, paramMessageRecord, paramInt2);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (top.gR(paramString1))
    {
      tol.a(this.app, this, this.b, paramString1, paramInt1, paramString2, paramString3, paramBoolean);
      return;
    }
    tol.a(this.app, this, this.b, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramInt3, paramBoolean);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if ((paramInt == 1008) && (oan.a().e(this.app, paramString1, paramInt))) {}
    do
    {
      do
      {
        return;
        if ((paramInt != 1008) || (!nyn.i(this.app, paramString1))) {
          break;
        }
        paramString2 = (kdm)this.app.getManager(88);
      } while (paramString2 == null);
      paramString2.y(paramString1, paramLong);
      return;
    } while (top.eD(paramInt) == 1032);
    acxw localacxw;
    if ((this.app.a().u(paramString1, paramInt)) || (!top.fL(paramInt)))
    {
      localacxw = this.app.a().a();
      if (0L == paramLong)
      {
        paramString2 = localacxw.b(paramString1, paramInt);
        if (paramString2 == null) {
          break label235;
        }
        paramString2.lastmsgdrafttime = paramLong;
        if ((0L != paramLong) || (paramString2.lastmsgtime != 0L)) {
          break label220;
        }
        localacxw.f(paramString2);
      }
    }
    for (;;)
    {
      if ((paramInt == 1008) && (nyn.f(this.app, paramString1))) {
        nyn.a().a(this.app, paramString1, paramString3, paramLong);
      }
      this.b.as(paramString2);
      return;
      RecentUser localRecentUser = localacxw.a(paramString1, paramInt);
      localRecentUser.troopUin = paramString2;
      paramString2 = localRecentUser;
      break;
      label220:
      ajpd.d(this.app, paramString2);
      localacxw.e(paramString2);
      label235:
      continue;
      paramString2 = null;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean)
  {
    a(paramString1, paramInt, paramString2, paramString3, paramInt, 0, paramBoolean);
  }
  
  public abstract void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle);
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString, paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    long l = 0L;
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReaded uin=" + paramString + ",type=" + paramInt1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : uin=null");
      }
    }
    for (;;)
    {
      return;
      int i = 0;
      if (s(paramString, paramInt1)) {
        i = 1;
      }
      MessageRecord localMessageRecord;
      tog localtog;
      if ((paramInt1 != 1033) && (paramInt1 != 1034)) {
        if (this.app.a().A(paramString, paramInt1) > 0)
        {
          localMessageRecord = this.app.a(paramInt1).a(paramString, paramInt1);
          localtog = this.app.a();
          if (localMessageRecord != null) {
            l = b(localMessageRecord);
          }
          localtog.a(paramString, paramInt1, l, paramBoolean1, paramBoolean2);
          bL(paramString, paramInt1);
          i = j;
        }
      }
      while (i != 0)
      {
        this.b.as(this.b.a(paramString, paramInt1, paramInt2));
        bK(paramString, paramInt1);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
          continue;
          if (this.app.a().e(paramString, paramInt1, paramInt2) > 0)
          {
            localMessageRecord = this.app.a(paramInt1).a(paramString, paramInt1, paramInt2);
            localtog = this.app.a();
            if (localMessageRecord != null) {
              l = b(localMessageRecord);
            }
            localtog.a(paramString, paramInt1, l, paramBoolean1, paramBoolean2, paramInt2);
            bL(paramString, paramInt1);
            i = j;
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "setReaded return : unread=0");
          }
        }
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab " + paramMessageRecord.getBaseInfoString() + ",reason " + paramInt);
    }
    if (paramMessageRecord == null) {
      return false;
    }
    if (paramMessageRecord.isLongMsg())
    {
      if (this.app.a().aQ(paramMessageRecord))
      {
        if ((paramInt == 1) && (!paramMessageRecord.isSendFromLocal()) && (!paramMessageRecord.isread) && (!String.valueOf(acbn.bkA).equals(paramMessageRecord.frienduin))) {
          this.b.e(null);
        }
        return false;
      }
      paramMessageRecord = this.b.c(paramMessageRecord);
    }
    for (;;)
    {
      if (paramMessageRecord.istroop == 1036) {
        return false;
      }
      if (asgx.j(this.app, paramMessageRecord)) {
        return false;
      }
      if ((!paramMessageRecord.isValid) || (top.fz(paramMessageRecord.msgtype)) || ((paramMessageRecord.frienduin.equals(acbn.blu)) && (paramMessageRecord.istroop == 0)) || ((paramMessageRecord.frienduin.equals(acbn.blC)) && (paramMessageRecord.istroop == 0))) {
        break;
      }
      QQMessageFacade.Message localMessage1 = this.b.a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab getLastMessage " + localMessage1.getBaseInfoString());
      }
      int i;
      if (((paramMessageRecord.isBlessMsg) || (paramMessageRecord.isCheckNeedShowInListTypeMsg)) && (aqiu.ms(paramMessageRecord.issend)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab isBlessMsg:" + paramMessageRecord.isBlessMsg + " needUpdateMsgTag:" + paramMessageRecord.needUpdateMsgTag + " isCheckNeedShowInListTypeMsg:" + paramMessageRecord.isCheckNeedShowInListTypeMsg + " needNeedShowInList:" + paramMessageRecord.needNeedShowInList);
        }
        int j = 1;
        i = j;
        if (paramMessageRecord.isBlessMsg)
        {
          i = j;
          if (paramMessageRecord.needUpdateMsgTag) {
            i = 0;
          }
        }
        j = i;
        if (paramMessageRecord.isCheckNeedShowInListTypeMsg)
        {
          j = i;
          if (paramMessageRecord.needNeedShowInList) {
            j = 0;
          }
        }
        if (j != 0) {
          return false;
        }
      }
      boolean bool2;
      boolean bool1;
      if (paramInt == 1)
      {
        bool2 = false;
        bool1 = false;
        if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1))
        {
          paramInt = (int)(localMessage1.shmsgseq - paramMessageRecord.shmsgseq);
          if (paramMessageRecord.msgtype != -1012)
          {
            i = paramInt;
            bool2 = bool1;
            if (paramMessageRecord.msgtype != -5021) {}
          }
          else
          {
            if ((localMessage1.msgtype != -1012) && (localMessage1.msgtype != -5021)) {
              break label663;
            }
            i = 1;
            if (paramInt != 0) {
              break label1469;
            }
            if (i == 0) {
              break label669;
            }
            paramInt = (int)(localMessage1.time - paramMessageRecord.time);
          }
        }
      }
      label533:
      label663:
      label669:
      label1460:
      label1469:
      for (;;)
      {
        if (paramInt > 0) {}
        for (bool1 = true;; bool1 = false)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GrayTipsForTroop", 2, "updateMsgTab mrIsOld " + bool1);
          }
          bool2 = bool1;
          i = paramInt;
          bool1 = bool2;
          if (!paramMessageRecord.isSendFromLocal())
          {
            bool1 = bool2;
            if (i > 0) {
              bool1 = true;
            }
          }
          for (;;)
          {
            bool2 = bool1;
            if (top.gS(paramMessageRecord.senderuin))
            {
              bool2 = bool1;
              if (TextUtils.equals(paramMessageRecord.senderuin, localMessage1.senderuin)) {
                bool2 = false;
              }
            }
            if (!top.c(paramMessageRecord, localMessage1)) {
              break label1460;
            }
            if (paramMessageRecord.longMsgIndex < localMessage1.longMsgIndex) {
              break label722;
            }
            return false;
            i = 0;
            break;
            paramInt = -1;
            break label533;
            bool1 = bool2;
            if (top.fv(paramMessageRecord.istroop))
            {
              bool1 = bool2;
              if (!paramMessageRecord.isSendFromLocal())
              {
                bool1 = bool2;
                if (paramMessageRecord.time < localMessage1.time) {
                  bool1 = true;
                }
              }
            }
          }
          label722:
          bool2 = false;
          for (;;)
          {
            if (!bool2)
            {
              MessageRecord.copyMessageRecordBaseField(localMessage1, paramMessageRecord);
              localMessage1.emoRecentMsg = null;
              localMessage1.fileType = -1;
              localMessage1.lastMsg = null;
              bool1 = paramBoolean;
              if (!paramBoolean)
              {
                bool1 = paramBoolean;
                if (ajoq.b(this.app, localMessage1)) {
                  bool1 = true;
                }
              }
              if (!bool1) {}
            }
            for (;;)
            {
              try
              {
                b(localMessage1);
                bool1 = true;
                if ((!paramMessageRecord.isSend()) && (!anbk.ls(paramMessageRecord.msgtype)))
                {
                  localMessage1.hasReply = true;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab = " + localMessage1 + ",hasReply=" + localMessage1.hasReply);
                  }
                }
                if ((paramMessageRecord.istroop == 1033) || (paramMessageRecord.istroop == 1034))
                {
                  paramInt = 1;
                  if (((paramMessageRecord.isSendFromLocal()) || (paramMessageRecord.isread) || (paramInt != 0)) && (paramMessageRecord.msgtype != -1013) && (paramMessageRecord.msgtype != -1019))
                  {
                    paramBoolean = bool1;
                    if (paramMessageRecord.msgtype != -1018) {}
                  }
                  else
                  {
                    if ((paramMessageRecord.msgtype == -1013) || (paramMessageRecord.msgtype == -1019) || (paramMessageRecord.msgtype == -1018)) {
                      this.b.e(localMessage1);
                    }
                    if ((!String.valueOf(acbn.bkA).equals(localMessage1.frienduin)) && ((!top.v(localMessage1)) || (top.d(this.app, paramMessageRecord))))
                    {
                      if ((paramMessageRecord instanceof MessageForNearbyLiveTip)) {
                        localMessage1.nickName = ((MessageForNearbyLiveTip)paramMessageRecord).nickName;
                      }
                      this.b.e(localMessage1);
                    }
                    if (((localMessage1.msgtype == -2009) || (localMessage1.msgtype == -2016)) && (bool2))
                    {
                      QQMessageFacade.Message localMessage2 = new QQMessageFacade.Message();
                      MessageRecord.copyMessageRecordBaseField(localMessage2, paramMessageRecord);
                      localMessage2.emoRecentMsg = null;
                      localMessage2.fileType = -1;
                      localMessage1.lastMsg = null;
                      this.b.e(localMessage2);
                    }
                    paramBoolean = bool1;
                    if (acbn.bkK.equals(localMessage1.frienduin))
                    {
                      paramInt = anze.a().af(this.app);
                      if (paramInt <= 0) {
                        continue;
                      }
                      this.b.a().unReadNum = paramInt;
                      paramBoolean = bool1;
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab fin " + localMessage1.getBaseInfoString() + " , result = " + paramBoolean);
                  }
                  if (top.x(localMessage1.frienduin, localMessage1.istroop)) {
                    localMessage1.istroop = top.eD(localMessage1.istroop);
                  }
                  return paramBoolean;
                }
              }
              catch (Throwable localThrowable)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", localThrowable);
                continue;
                paramInt = 0;
                continue;
                this.b.e(null);
                paramBoolean = bool1;
                continue;
              }
              if ((paramInt == 4) || (paramInt == 2))
              {
                MessageRecord.copyMessageRecordBaseField(localMessage1, paramMessageRecord);
                localMessage1.emoRecentMsg = null;
                localMessage1.fileType = -1;
                localMessage1.lastMsg = null;
                bool1 = paramBoolean;
                if (!paramBoolean)
                {
                  bool1 = paramBoolean;
                  if (ajoq.b(this.app, localMessage1)) {
                    bool1 = true;
                  }
                }
                if (bool1) {}
                try
                {
                  b(localMessage1);
                  paramBoolean = true;
                }
                catch (Throwable paramMessageRecord)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
                    }
                  }
                }
              }
              else
              {
                if (paramInt == 3)
                {
                  if (localMessage1.uniseq == paramMessageRecord.uniseq) {
                    MessageRecord.copyMessageRecordStatusField(localMessage1, paramMessageRecord);
                  }
                  for (;;)
                  {
                    paramBoolean = true;
                    break;
                    MessageRecord.copyMessageRecordBaseField(localMessage1, paramMessageRecord);
                    localMessage1.emoRecentMsg = null;
                    localMessage1.fileType = -1;
                    localMessage1.lastMsg = null;
                    try
                    {
                      b(localMessage1);
                    }
                    catch (Throwable paramMessageRecord) {}
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTab ERROR", paramMessageRecord);
                    }
                  }
                }
                paramBoolean = false;
                continue;
                bool1 = false;
              }
            }
          }
        }
      }
    }
  }
  
  public abstract long b(MessageRecord paramMessageRecord);
  
  public QQMessageFacade.Message b(String paramString, int paramInt1, EntityManager paramEntityManager, int paramInt2)
  {
    if (paramString == null)
    {
      paramEntityManager = new QQMessageFacade.Message();
      return paramEntityManager;
    }
    String str1 = top.u(paramString, paramInt1);
    Object localObject = null;
    QQMessageFacade.Message localMessage = (QQMessageFacade.Message)this.b.gP.get(str1);
    StringBuilder localStringBuilder = new StringBuilder("CACHE : refreshSingleLastMsg:uin:" + paramString + " uinType:" + paramInt1);
    if ((localMessage == null) || (!localMessage.isCacheValid) || (localMessage.getConfessTopicId() != paramInt2))
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      localMessage = this.app.a(paramInt1).a(str2, paramEntityManager, paramInt2);
      localObject = localMessage;
      if (localMessage != null)
      {
        localObject = localMessage;
        if (localMessage.uniseq == 0L)
        {
          this.app.a(localMessage.istroop).h(localMessage.frienduin, localMessage.istroop);
          paramEntityManager = this.app.a(localMessage.istroop).a(str2, paramEntityManager, paramInt2);
          localObject = paramEntityManager;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.BaseMessageManager", 2, "CACHE : requeryLastMessage = " + paramEntityManager);
            localObject = paramEntityManager;
          }
        }
      }
      paramEntityManager = (EntityManager)localObject;
      if (localObject == null)
      {
        paramEntityManager = new QQMessageFacade.Message();
        paramEntityManager.frienduin = paramString;
        paramEntityManager.istroop = paramInt1;
        paramEntityManager.setConfessTopicId(paramInt2);
      }
    }
    for (;;)
    {
      try
      {
        paramString = (QQMessageFacade.Message)this.b.gP.get(str1);
        if (paramString != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 1 : null inplace");
        }
        b(paramEntityManager);
        this.b.gP.put(str1, paramEntityManager);
        paramString = paramEntityManager;
      }
      catch (Throwable localThrowable)
      {
        paramString = paramEntityManager;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.msg.BaseMessageManager", 2, "refreshSingleLastMsg ERROR", localThrowable);
        paramString = paramEntityManager;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, localStringBuilder.toString());
      }
      paramEntityManager = paramString;
      if (paramString == null) {
        break;
      }
      paramEntityManager = paramString;
      if (!top.x(paramString.frienduin, paramString.istroop)) {
        break;
      }
      paramString.istroop = top.eD(paramString.istroop);
      return paramString;
      if (b(paramString) < b(paramEntityManager))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 2 : new inplace");
        }
        b(paramEntityManager);
        this.b.gP.put(str1, paramEntityManager);
        paramString = paramEntityManager;
      }
      else if ((!paramString.isCacheValid) && (paramEntityManager.isCacheValid))
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 3 : valid inplace");
        }
        b(paramEntityManager);
        this.b.gP.put(str1, paramEntityManager);
        paramString = paramEntityManager;
      }
      else
      {
        if (QLog.isColorLevel()) {
          localStringBuilder.append(" : case 4 :invalid inplace");
        }
        paramString.isCacheValid = true;
        continue;
        paramString = localThrowable;
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(" : case 5 : not null or isValid : " + localMessage);
          paramString = localThrowable;
        }
      }
    }
  }
  
  protected List<MessageRecord> b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return (List)this.a.T().get(top.u(paramString, paramInt));
  }
  
  public void b(QQMessageFacade.Message paramMessage)
    throws Throwable
  {
    if (paramMessage == null) {}
    label4:
    label335:
    label851:
    label1529:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            break label4;
                            for (;;)
                            {
                              return;
                              Object localObject2;
                              if (!a(paramMessage))
                              {
                                if (((paramMessage.msgtype == -1003) || (paramMessage.msgtype == -1032) || (paramMessage.msgtype == 201)) && ((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002))) {}
                                for (;;)
                                {
                                  try
                                  {
                                    paramMessage.msg = aqfw.a(paramMessage.msg).msg;
                                    if (paramMessage.msgtype != -2018) {
                                      if (paramMessage.msgtype != -2050) {
                                        break label335;
                                      }
                                    }
                                  }
                                  catch (Exception paramMessage)
                                  {
                                    for (;;)
                                    {
                                      Object localObject1;
                                      try
                                      {
                                        localObject1 = new structmsg.StructMsg();
                                        ((structmsg.StructMsg)localObject1).mergeFrom(paramMessage.msgData);
                                        paramMessage.msg = MessageForSystemMsg.getSysMsgDesc(this.app.getApp().getResources(), (structmsg.StructMsg)localObject1);
                                        if ((!aqfw.mn(paramMessage.msgtype)) && (paramMessage.msgtype != -3001) && (paramMessage.msgtype != -30002)) {
                                          if (paramMessage.msgtype != -30003) {
                                            continue;
                                          }
                                        }
                                      }
                                      catch (Exception paramMessage)
                                      {
                                        throw paramMessage;
                                      }
                                      try
                                      {
                                        localObject1 = aqfw.a(paramMessage.msg);
                                        paramMessage.msg = ((MsgBody)localObject1).msg;
                                        paramMessage.action = ((MsgBody)localObject1).action;
                                        paramMessage.shareAppID = ((MsgBody)localObject1).shareAppID;
                                        paramMessage.actMsgContentValue = ((MsgBody)localObject1).actMsgContentValue;
                                        localObject1 = null;
                                        if ((!acbn.bkG.equals(paramMessage.senderuin)) || (paramMessage.msgtype != -2011)) {
                                          localObject1 = SystemMsg.decode(this.app, paramMessage.msg, paramMessage.senderuin, paramMessage.msgtype);
                                        }
                                        if (!paramMessage.isFromLS) {
                                          break label843;
                                        }
                                        d(paramMessage);
                                        if (localObject1 == null) {
                                          break label851;
                                        }
                                        paramMessage.msg = ((SystemMsg)localObject1).message;
                                        if (!QLog.isDevelopLevel()) {
                                          break;
                                        }
                                        QLog.d("Q.msg.BaseMessageManager", 4, "addFrindSystemMsg decode end" + paramMessage.msg);
                                        return;
                                      }
                                      catch (Exception paramMessage)
                                      {
                                        AbsStructMsg localAbsStructMsg;
                                        UniteGrayTip.UniteGrayTipMsg localUniteGrayTipMsg;
                                        throw paramMessage;
                                      }
                                    }
                                    paramMessage = paramMessage;
                                    throw paramMessage;
                                  }
                                  if (paramMessage.msgtype == -2011)
                                  {
                                    localAbsStructMsg = anre.a(paramMessage.msgData);
                                    localObject1 = "";
                                    if (localAbsStructMsg != null) {
                                      localObject1 = localAbsStructMsg.mMsgBrief;
                                    }
                                    paramMessage.msg = ((String)localObject1);
                                  }
                                  else if (paramMessage.msgtype == -5003)
                                  {
                                    localObject1 = new SubMsgType0x76.MsgBody();
                                    ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramMessage.msgData);
                                    paramMessage.msg = acof.a(this.app.getApp(), (SubMsgType0x76.MsgBody)localObject1);
                                  }
                                  else if (paramMessage.msgtype == -1000)
                                  {
                                    if ((paramMessage.getExtInfoFromExtStr("redbag_fold_msg").equals("true")) && (paramMessage.msgData != null))
                                    {
                                      localObject1 = new RichMsg.FoldMsg();
                                      try
                                      {
                                        ((RichMsg.FoldMsg)localObject1).mergeFrom(paramMessage.msgData);
                                        paramMessage.msg = ((RichMsg.FoldMsg)localObject1).msg_content.get().toStringUtf8();
                                      }
                                      catch (Exception localException1)
                                      {
                                        localException1.printStackTrace();
                                      }
                                      if (QLog.isColorLevel()) {
                                        QLog.e("msgFold", 2, "MessageForFoldMsg decodeMsg error， " + localException1.getMessage());
                                      }
                                    }
                                  }
                                  else if (paramMessage.msgtype == -5012)
                                  {
                                    if (paramMessage.msgData != null) {
                                      try
                                      {
                                        paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
                                      }
                                      catch (JSONException localJSONException1)
                                      {
                                        localJSONException1.printStackTrace();
                                      }
                                    }
                                  }
                                  else if (paramMessage.msgtype == -5018)
                                  {
                                    if (paramMessage.msgData != null) {
                                      try
                                      {
                                        paramMessage.msg = new JSONObject(new String(paramMessage.msgData)).getString("msg");
                                      }
                                      catch (JSONException localJSONException2)
                                      {
                                        localJSONException2.printStackTrace();
                                      }
                                    }
                                  }
                                  else if (top.fB(paramMessage.msgtype))
                                  {
                                    if (paramMessage.msgData != null)
                                    {
                                      localUniteGrayTipMsg = new UniteGrayTip.UniteGrayTipMsg();
                                      try
                                      {
                                        localUniteGrayTipMsg.mergeFrom(paramMessage.msgData);
                                        paramMessage.msg = localUniteGrayTipMsg.content.get();
                                        if ((!localUniteGrayTipMsg.graytip_id.has()) || (!ajnu.ky(localUniteGrayTipMsg.graytip_id.get()))) {
                                          continue;
                                        }
                                        paramMessage.emoRecentMsg = ajoq.a(this.app.getApp(), paramMessage.msg);
                                      }
                                      catch (Exception localException2)
                                      {
                                        localException2.printStackTrace();
                                      }
                                      if (QLog.isColorLevel()) {
                                        QLog.e(ahwb.TAG, 2, "MessageForUniteGrayTip, docodeMsg failed, " + localException2.getMessage());
                                      }
                                    }
                                    else if (QLog.isColorLevel())
                                    {
                                      QLog.e(ahwb.TAG, 2, "MessageForUniteGrayTip, docodeMsg msgData == null, msg: " + paramMessage.msg);
                                      continue;
                                      c(paramMessage);
                                    }
                                  }
                                }
                                if (paramMessage.msgtype == -2007) {
                                  try
                                  {
                                    MarkFaceMessage localMarkFaceMessage = (MarkFaceMessage)aczw.c(paramMessage.msgData);
                                    if ((localMarkFaceMessage != null) && (!TextUtils.isEmpty(localMarkFaceMessage.faceName)))
                                    {
                                      paramMessage.msg = ("[" + localMarkFaceMessage.faceName + "]");
                                      return;
                                    }
                                  }
                                  catch (Exception localException3)
                                  {
                                    for (;;)
                                    {
                                      QLog.e("Q.msg.BaseMessageManager", 1, "parse MarkFaceMessage: ", localException3);
                                      localObject2 = null;
                                    }
                                    paramMessage.msg = this.app.getApp().getString(2131693094);
                                    return;
                                  }
                                }
                                if (paramMessage.msgtype == -2058)
                                {
                                  paramMessage.msg = this.app.getApp().getString(2131720462);
                                  return;
                                }
                                if (paramMessage.msgtype == -1035)
                                {
                                  localObject2 = new MessageForMixedMsg();
                                  ((MessageForMixedMsg)localObject2).frienduin = paramMessage.frienduin;
                                  ((MessageForMixedMsg)localObject2).msgData = paramMessage.msgData;
                                  ((MessageForMixedMsg)localObject2).extStr = paramMessage.extStr;
                                  ((MessageForMixedMsg)localObject2).extLong |= 0x1;
                                  ((MessageForMixedMsg)localObject2).parse();
                                  paramMessage.msg = ((MessageForMixedMsg)localObject2).msg;
                                  paramMessage.msg2 = ((MessageForMixedMsg)localObject2).msg2;
                                  if ((paramMessage.msg2 != null) && (!"".equals(paramMessage.msg2)))
                                  {
                                    paramMessage.emoRecentMsg = new aofk(paramMessage.msg2, 3, 16);
                                    return;
                                  }
                                  if ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
                                    break;
                                  }
                                  paramMessage.emoRecentMsg = new aofk(paramMessage.msg, 3, 16);
                                  return;
                                }
                                if ((paramMessage.msgtype == -5000) || (paramMessage.msgtype == -5001))
                                {
                                  localObject2 = new MessageForNewGrayTips();
                                  ((MessageForNewGrayTips)localObject2).msgData = paramMessage.msgData;
                                  ((MessageForNewGrayTips)localObject2).parse();
                                  paramMessage.msg = ((MessageForNewGrayTips)localObject2).msg;
                                  if ((paramMessage.msg == null) || ("".equals(paramMessage.msg))) {
                                    break;
                                  }
                                  paramMessage.emoRecentMsg = new aofk(paramMessage.msg, 3, 16);
                                  return;
                                }
                                if ((paramMessage.msgtype != -4500) && (paramMessage.msgtype != -4502) && (paramMessage.msgtype != -4503) && (paramMessage.msgtype != -4501) && (paramMessage.msgtype != -4509)) {
                                  break label1529;
                                }
                                if (paramMessage.msgData == null) {
                                  break;
                                }
                                localObject2 = null;
                                switch (paramMessage.msgtype)
                                {
                                }
                                while (localObject2 != null)
                                {
                                  ((ChatMessage)localObject2).msgData = paramMessage.msgData;
                                  ((ChatMessage)localObject2).parse();
                                  paramMessage.msg = ((ChatMessage)localObject2).msg;
                                  if (paramMessage.msgtype != -4501) {
                                    break label1483;
                                  }
                                  paramMessage.msg = ((MessageForDevPtt)localObject2).getSummary();
                                  return;
                                  localObject2 = new MessageForDeviceFile();
                                  continue;
                                  localObject2 = new MessageForDeviceSingleStruct();
                                  continue;
                                  localObject2 = new MessageForDevPtt();
                                  continue;
                                  localObject2 = new MessageForDevShortVideo();
                                  continue;
                                  localObject2 = new MessageForDevLittleVideo();
                                  continue;
                                  localObject2 = new MessageForNewGrayTips();
                                }
                                continue;
                              }
                              continue;
                              if (paramMessage.msgtype == -4503)
                              {
                                paramMessage.msg = ((MessageForDevShortVideo)localObject2).getSummary();
                                return;
                              }
                              if (paramMessage.msgtype != -4509) {
                                break;
                              }
                              paramMessage.msg = ((MessageForDevLittleVideo)localObject2).getSummary();
                              return;
                              if (paramMessage.msgtype == -2011) {
                                break;
                              }
                              if ((paramMessage.msgtype == -3006) || (paramMessage.msgtype == -5004))
                              {
                                if (paramMessage.msgtype == -3006)
                                {
                                  paramMessage.msg = MessageForPubAccount.getMsgSummary(this.app, paramMessage, false);
                                  if (paramMessage.istroop != 1) {
                                    break;
                                  }
                                  paramMessage.nickName = obt.a(this.app, BaseApplicationImpl.getContext());
                                  return;
                                }
                                paramMessage.msg = this.app.getApp().getString(2131696714);
                                return;
                              }
                              if (paramMessage.msgtype == -2010)
                              {
                                localObject2 = new FunnyFaceMessage();
                                try
                                {
                                  ((FunnyFaceMessage)localObject2).readExternal(new ObjectInputStream(new ByteArrayInputStream(paramMessage.msgData)));
                                  if (localObject2 == null) {
                                    continue;
                                  }
                                  if (((FunnyFaceMessage)localObject2).faceId == 1)
                                  {
                                    paramMessage.msg = this.app.getApp().getString(2131695720);
                                    return;
                                  }
                                }
                                catch (Exception localException4)
                                {
                                  for (;;)
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.e("Q.msg.BaseMessageManager", 2, localException4.toString());
                                    }
                                    localObject3 = null;
                                  }
                                }
                                if (((FunnyFaceMessage)localObject3).faceId != 2) {
                                  break;
                                }
                                paramMessage.msg = this.app.getApp().getString(2131695721);
                                return;
                              }
                              if (paramMessage.msgtype == -2000)
                              {
                                localObject3 = new MessageForPic();
                                ((MessageForPic)localObject3).msgData = paramMessage.msgData;
                                ((MessageForPic)localObject3).istroop = paramMessage.istroop;
                                ((MessageForPic)localObject3).parse();
                                paramMessage.msg = ((MessageForPic)localObject3).getSummaryMsg();
                                return;
                              }
                              if (paramMessage.msgtype == -2005)
                              {
                                paramMessage.msg = this.app.getApp().getString(2131721065);
                                return;
                              }
                              if (paramMessage.msgtype == -2020)
                              {
                                paramMessage.msg = this.app.getApp().getString(2131720017);
                                if (aqiu.ms(paramMessage.issend))
                                {
                                  localObject3 = aqgv.a(this.app, paramMessage.frienduin, "", 0, 0);
                                  paramMessage.msg = this.app.getApp().getString(2131720018, new Object[] { localObject3 });
                                  return;
                                }
                                paramMessage.msg = this.app.getApp().getString(2131720017);
                                return;
                              }
                              if ((paramMessage.msgtype == -2002) || (paramMessage.msgtype == -1031))
                              {
                                paramMessage.msg = this.app.getApp().getString(2131692316);
                                try
                                {
                                  localObject3 = (MessageForPtt)this.b.a(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
                                  if (localObject3 != null)
                                  {
                                    paramMessage.pttUrl = ((MessageForPtt)localObject3).url;
                                    paramMessage.msg = ((MessageForPtt)localObject3).getSummaryMsg();
                                    return;
                                  }
                                }
                                catch (Exception paramMessage)
                                {
                                  paramMessage.printStackTrace();
                                  return;
                                }
                              }
                            }
                            if (paramMessage.msgtype != -2025) {
                              break;
                            }
                          } while (paramMessage.msgData == null);
                          try
                          {
                            localObject3 = new MessageForQQWalletMsg();
                            ((MessageForQQWalletMsg)localObject3).msgData = paramMessage.msgData;
                            ((MessageForQQWalletMsg)localObject3).parse();
                            paramMessage.msg = ((MessageForQQWalletMsg)localObject3).getMsgSummary();
                            return;
                          }
                          catch (Exception paramMessage) {}
                        } while (!QLog.isColorLevel());
                        QLog.e("Q.msg.BaseMessageManager", 2, paramMessage.toString());
                        return;
                        if (paramMessage.msgtype != -2072) {
                          break;
                        }
                      } while (paramMessage.msgData == null);
                      try
                      {
                        localObject3 = new MessageForFuDai();
                        ((MessageForFuDai)localObject3).msgData = paramMessage.msgData;
                        ((MessageForFuDai)localObject3).parse();
                        paramMessage.msg = ((MessageForFuDai)localObject3).getSummaryMsg();
                        return;
                      }
                      catch (Exception paramMessage)
                      {
                        QLog.e("Q.msg.BaseMessageManager", 1, paramMessage, new Object[0]);
                        return;
                      }
                      if (paramMessage.msgtype != -2039) {
                        break;
                      }
                      paramMessage.msg = acfp.m(2131703120);
                    } while (paramMessage.msgData == null);
                    localObject3 = new MessageForApollo();
                    ((MessageForApollo)localObject3).msgData = paramMessage.msgData;
                    ((MessageForApollo)localObject3).parse();
                    paramMessage.msg = ApolloUtil.a(this.app, (MessageForApollo)localObject3);
                    return;
                    if (paramMessage.msgtype != -5008) {
                      break;
                    }
                  } while (paramMessage.msgData == null);
                  localObject3 = new ArkAppMessage();
                  ((ArkAppMessage)localObject3).fromBytes(paramMessage.msgData);
                  paramMessage.msg = ((ArkAppMessage)localObject3).getSummery();
                  return;
                  if (paramMessage.msgtype != -5016) {
                    break;
                  }
                } while (paramMessage.msgData == null);
                localObject3 = new MessageForArkBabyqReply();
                ((MessageForArkBabyqReply)localObject3).fromBytes(paramMessage.msgData);
                paramMessage.msg = ((MessageForArkBabyqReply)localObject3).getSummery();
                return;
                if (paramMessage.msgtype != -5017) {
                  break;
                }
              } while (paramMessage.msgData == null);
              localObject3 = new ArkAppMessage();
              ((ArkAppMessage)localObject3).fromBytes(paramMessage.msgData);
              paramMessage.msg = ((ArkAppMessage)localObject3).getSummery();
              return;
              if (paramMessage.msgtype != -5013) {
                break;
              }
            } while (paramMessage.msgData == null);
            localObject3 = new ArkFlashChatMessage();
            ((ArkFlashChatMessage)localObject3).fromBytes(paramMessage.msgData);
            paramMessage.msg = ((ArkFlashChatMessage)localObject3).getSummery();
            return;
            if (paramMessage.msgtype != -5014) {
              break;
            }
          } while (paramMessage.msgData == null);
          paramMessage.msg = ((HiBoomMessage)aczw.c(paramMessage.msgData)).text;
          return;
          if (paramMessage.msgtype == -2048)
          {
            localObject3 = new MessageForTroopReward();
            ((MessageForTroopReward)localObject3).msgData = paramMessage.msgData;
            ((MessageForTroopReward)localObject3).parse();
            paramMessage.msg = ((MessageForTroopReward)localObject3).getSummaryMsg();
            return;
          }
          if (paramMessage.msgtype == -2051)
          {
            localObject3 = new MessageForQQStory();
            ((MessageForQQStory)localObject3).msgData = paramMessage.msgData;
            ((MessageForQQStory)localObject3).parse();
            paramMessage.msg = ((MessageForQQStory)localObject3).getSummaryMsg();
            return;
          }
          if (paramMessage.msgtype == -7002)
          {
            localObject3 = new MessageForTribeShortVideo();
            ((MessageForTribeShortVideo)localObject3).msgData = paramMessage.msgData;
            ((MessageForTribeShortVideo)localObject3).parse();
            paramMessage.msg = ((MessageForTribeShortVideo)localObject3).getSummaryMsg();
            return;
          }
          if (paramMessage.msgtype == -2054)
          {
            localObject3 = new MessageForTroopSign();
            ((MessageForTroopSign)localObject3).msgData = paramMessage.msgData;
            ((MessageForTroopSign)localObject3).parse();
            paramMessage.msg = ((MessageForTroopSign)localObject3).getSummaryMsg();
            return;
          }
          if (paramMessage.msgtype == -5015)
          {
            paramMessage.msg = acfp.m(2131703121);
            return;
          }
          if (paramMessage.msgtype != -2067) {
            break;
          }
          localObject3 = new MessageForTroopConfess();
          ((MessageForTroopConfess)localObject3).msgData = paramMessage.msgData;
          ((MessageForTroopConfess)localObject3).doParse();
          paramMessage.msg = ((MessageForTroopConfess)localObject3).msg;
          localObject3 = apsb.a(paramMessage);
          if (localObject3 != null) {
            paramMessage.nickName = ((apsb.a)localObject3).nickname;
          }
        } while (!TextUtils.isEmpty(paramMessage.nickName));
        paramMessage.nickName = acfp.m(2131703123);
        return;
      } while ((paramMessage.msg == null) || ("".equals(paramMessage.msg)));
      localObject3 = paramMessage.msg;
      if (!gK((String)localObject3)) {
        break;
      }
      localObject3 = localObject3.split("\026")[1].split("\\|");
    } while (localObject3 == null);
    label843:
    label1483:
    int i;
    if (localObject3.length < 2)
    {
      i = 1;
      label2775:
      paramMessage.fileType = i;
    }
    for (;;)
    {
      try
      {
        if (localObject3.length < 2)
        {
          l = -1L;
          paramMessage.fileSize = l;
        }
      }
      catch (Exception localException5)
      {
        long l;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", localException5);
        paramMessage.fileSize = -1L;
        continue;
        if (paramMessage.msgtype != -3001) {
          continue;
        }
        paramMessage.msg = this.app.getApp().getString(2131696741);
        return;
        paramMessage.msg = this.app.getApp().getString(2131694739);
        return;
      }
      switch (i)
      {
      case 3: 
      default: 
        return;
      case 0: 
        paramMessage.msg = this.app.getApp().getString(2131721065);
        return;
        i = Integer.valueOf(localObject3[2]).intValue();
        break label2775;
        l = Long.valueOf(localObject3[1]).longValue();
      }
    }
    paramMessage.msg = this.app.getApp().getString(2131692316);
    paramMessage.pttUrl = localObject3[0];
    return;
    if (paramMessage.msgtype == -2006)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageManager", 2, "<0x7f_trace>  0x7f in MsgTab decodeMsg method !");
      }
      paramMessage.msg = (this.app.getApp().getString(2131692316) + "(0x7f)");
      return;
    }
    if (paramMessage.msgtype == -2008)
    {
      paramMessage.msg = this.app.getApp().getString(2131719354);
      return;
    }
    if (paramMessage.msg.indexOf("http://maps.google.com/maps?q=") != -1)
    {
      localObject6 = anbk.r(paramMessage.msg);
      localObject4 = "";
      localObject3 = localObject4;
      if (localObject6 != null)
      {
        localObject3 = localObject4;
        if (localObject6[2] != null) {
          localObject3 = localObject6[2];
        }
      }
      paramMessage.fileType = 65536;
      paramMessage.msg = ("[" + this.app.getApp().getString(2131721250) + "] " + (String)localObject3);
      return;
    }
    if (paramMessage.msgtype == -2029)
    {
      localObject3 = new MessageForQQWalletTips();
      ((MessageForQQWalletTips)localObject3).init(paramMessage.selfuin, paramMessage.frienduin, paramMessage.senderuin, "[QQWallet Tips]", anaz.gQ(), paramMessage.msgtype, paramMessage.istroop, anaz.gQ());
      ((MessageForQQWalletTips)localObject3).msgData = paramMessage.msgData;
      ((MessageForQQWalletTips)localObject3).isread = true;
      ((MessageForQQWalletTips)localObject3).parse();
      ((MessageForQQWalletTips)localObject3).buildQQWalletTips(this.app, this.app.getApp(), null);
      paramMessage.msg = ((MessageForQQWalletTips)localObject3).summary;
      return;
    }
    if (paramMessage.msgtype == -2068)
    {
      localObject3 = new MessageForDarenAssistant();
      ((MessageForDarenAssistant)localObject3).msgData = paramMessage.msgData;
      ((MessageForDarenAssistant)localObject3).parse();
      paramMessage.msg = ((MessageForDarenAssistant)localObject3).msg;
      return;
    }
    if (ajoq.b(this.app, paramMessage))
    {
      paramMessage.emoRecentMsg = ajoq.a(this.app.getApp(), paramMessage.msg);
      return;
    }
    Object localObject3 = new StringBuilder(paramMessage.msg);
    Object localObject6 = paramMessage.getExtInfoFromExtStr("disc_at_info_list");
    Object localObject4 = localObject3;
    if (paramMessage.istroop == 3000)
    {
      localObject4 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject6)) {}
    }
    for (;;)
    {
      try
      {
        localObject4 = BaseApplicationImpl.sApplication.getRuntime();
        if (!QQAppInterface.class.isInstance(localObject4)) {
          continue;
        }
        localObject4 = appb.a((QQAppInterface)localObject4, (StringBuilder)localObject3, (String)localObject6, paramMessage.frienduin, paramMessage.isSend());
        localObject3 = localObject4;
        localObject4 = localObject3;
      }
      catch (Exception localException6)
      {
        QLog.e("Q.msg.BaseMessageManager", 1, "replaceAtMsgByMarkName", localException6);
        Object localObject5 = localObject3;
        continue;
        paramMessage.emoRecentMsg = new aofk(localObject5, 3, 16);
      }
      if (paramMessage.msgtype != -1000) {
        continue;
      }
      paramMessage.emoRecentMsg = new aofk(aqiu.pE(((StringBuilder)localObject4).toString()), 3, 16);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageManager", 1, "We get error AppRuntime");
      }
    }
  }
  
  public void b(QQMessageFacade.b paramb)
  {
    synchronized (this.lock)
    {
      boolean bool = paramb.aQl;
      if (bool) {}
      try
      {
        this.lock.wait(40000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage wait over");
        }
        return;
      }
      catch (InterruptedException paramb)
      {
        for (;;)
        {
          paramb.printStackTrace();
        }
      }
    }
  }
  
  public abstract void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.b paramb);
  
  public void b(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom uin=" + paramString + ",type=" + paramInt + ",from=" + paramLong + ",force=" + paramBoolean);
    }
    if (paramLong < 0L) {}
    do
    {
      return;
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : uin=null");
    return;
    if ((this.app.a().A(paramString, paramInt) <= 0) && (!paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setReadFrom return : unread=0");
      }
      this.app.a().c(paramString, paramInt, paramLong, true);
      return;
    }
    this.app.a().n(paramString, paramInt, paramLong);
    j(paramString, paramInt, paramLong);
    this.b.as(this.b.a(paramString, paramInt));
    bK(paramString, paramInt);
  }
  
  public void b(String paramString, int paramInt1, MessageRecord paramMessageRecord, int paramInt2)
  {
    long l;
    Object localObject;
    if ((paramInt1 != 3000) && (paramInt1 != 1))
    {
      l = d(paramString, paramInt1);
      if (l != 0L)
      {
        if (top.eD(paramInt1) != 1009) {
          break label273;
        }
        localObject = this.b.a(acbn.bkt, 1009);
        if ((((QQMessageFacade.Message)localObject).senderuin != null) && (((QQMessageFacade.Message)localObject).senderuin.equals(paramString)))
        {
          paramString = anbi.d(paramMessageRecord.msgtype);
          MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
          paramString.selfuin = paramMessageRecord.selfuin;
          paramString.senderuin = paramMessageRecord.frienduin;
          paramString.frienduin = acbn.bkt;
          if (paramInt2 != 3) {
            break label181;
          }
          a(paramString, true, paramInt2);
          this.app.a(paramInt1).a(acbn.bkt, 1009, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
          this.app.a(paramInt1).a(acbn.bkt, 1009, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        }
      }
    }
    label181:
    do
    {
      do
      {
        MessageRecord localMessageRecord;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    int i;
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                    if (paramInt2 == 2)
                                    {
                                      a(paramString, true, paramInt2);
                                      this.app.a(paramInt1).a(acbn.bkt, 1009, l, paramMessageRecord.msg);
                                      return;
                                    }
                                  } while (paramInt2 != 4);
                                  this.app.a(paramInt1).a(acbn.bkt, 1009, paramString.senderuin, paramString.selfuin, 0);
                                  a(paramString, null, false, true, paramInt2);
                                  a(paramString, true, paramInt2);
                                  return;
                                  if ((top.eD(paramInt1) != 1001) && (top.eD(paramInt1) != 10002)) {
                                    break label1072;
                                  }
                                  i = top.eD(paramInt1);
                                  localObject = this.app.a();
                                  bool2 = top.v(paramMessageRecord);
                                  bool1 = false;
                                  if (bool2) {
                                    bool1 = ((tog)localObject).f(paramString, i, acbn.bkE);
                                  }
                                  if ((!bool2) || (bool1)) {
                                    break;
                                  }
                                  localObject = this.b.a(acbn.blg, i);
                                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                                paramString = anbi.d(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                                paramString.frienduin = acbn.blg;
                                paramString.senderuin = paramMessageRecord.frienduin;
                                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localMessageRecord = anbi.d(paramMessageRecord.msgtype);
                                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                                localMessageRecord.frienduin = acbn.bkE;
                                localMessageRecord.senderuin = acbn.blg;
                                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                                localObject = this.b.a(acbn.bkE, i);
                                if (paramInt2 != 3) {
                                  break;
                                }
                                a(paramString, true, paramInt2);
                                this.app.a(paramInt1).a(acbn.blg, i, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                                this.app.a(paramInt1).a(acbn.blg, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(acbn.blg)));
                              a(localMessageRecord, true, paramInt2);
                              this.app.a(paramInt1).a(acbn.bkE, i, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
                              this.app.a(paramInt1).a(acbn.bkE, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                              return;
                              if (paramInt2 != 2) {
                                break;
                              }
                              a(paramString, true, paramInt2);
                              this.app.a(paramInt1).a(acbn.blg, i, l, paramMessageRecord.msg);
                            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(acbn.blg)));
                            a(localMessageRecord, true, paramInt2);
                            this.app.a(paramInt1).a(acbn.bkE, i, l, paramMessageRecord.msg);
                            return;
                          } while (paramInt2 != 4);
                          this.app.a(paramInt1).a(acbn.blg, i, paramString.senderuin, paramString.selfuin, 0);
                          a(paramString, null, false, true, 1);
                          this.app.a(paramInt1).a(acbn.bkE, i, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
                          a(localMessageRecord, null, false, true, 1);
                          a(paramString, true, paramInt2);
                        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(acbn.blg)));
                        a(localMessageRecord, true, paramInt2);
                        return;
                        localObject = this.b.a(acbn.bkE, i);
                      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                      paramString = anbi.d(paramMessageRecord.msgtype);
                      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                      paramString.selfuin = paramMessageRecord.selfuin;
                      paramString.senderuin = paramMessageRecord.frienduin;
                      paramString.frienduin = acbn.bkE;
                      if (paramInt2 == 3)
                      {
                        a(paramString, true, paramInt2);
                        this.app.a(paramInt1).a(acbn.bkE, i, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
                        this.app.a(paramInt1).a(acbn.bkE, i, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
                        return;
                      }
                      if (paramInt2 == 2)
                      {
                        a(paramString, true, paramInt2);
                        this.app.a(paramInt1).a(acbn.bkE, i, l, paramMessageRecord.msg);
                        return;
                      }
                    } while (paramInt2 != 4);
                    this.app.a(paramInt1).a(acbn.bkE, i, paramString.senderuin, paramString.selfuin, 0);
                    a(paramString, null, false, true, paramInt2);
                    a(paramString, true, paramInt2);
                    return;
                  } while (top.eD(paramInt1) != 1010);
                  localObject = this.app.a();
                  boolean bool2 = top.v(paramMessageRecord);
                  boolean bool1 = false;
                  if (bool2) {
                    bool1 = ((tog)localObject).f(paramString, 1010, acbn.bkY);
                  }
                  if ((!bool2) || (bool1)) {
                    break;
                  }
                  localObject = this.b.a(acbn.blh, 1010);
                } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
                paramString = anbi.d(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
                paramString.frienduin = acbn.blh;
                paramString.senderuin = paramMessageRecord.frienduin;
                paramString.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localMessageRecord = anbi.d(paramMessageRecord.msgtype);
                MessageRecord.copyMessageRecordBaseField(localMessageRecord, paramMessageRecord);
                localMessageRecord.frienduin = acbn.bkY;
                localMessageRecord.senderuin = acbn.blh;
                localMessageRecord.istroop = ((QQMessageFacade.Message)localObject).istroop;
                localObject = this.b.a(acbn.bkY, 1010);
                if (paramInt2 != 3) {
                  break;
                }
                a(paramString, true, paramInt2);
                this.app.a(paramInt1).a(acbn.blh, 1010, l, paramMessageRecord.extraflag, paramString.sendFailCode);
                this.app.a(paramInt1).a(acbn.blh, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(acbn.blh)));
              a(localMessageRecord, true, paramInt2);
              this.app.a(paramInt1).a(acbn.bkY, 1010, l, paramMessageRecord.extraflag, localMessageRecord.sendFailCode);
              this.app.a(paramInt1).a(acbn.bkY, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
              return;
              if (paramInt2 != 2) {
                break;
              }
              a(paramString, true, paramInt2);
              this.app.a(paramInt1).a(acbn.blh, 1010, l, paramMessageRecord.msg);
            } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(acbn.blh)));
            a(localMessageRecord, true, paramInt2);
            this.app.a(paramInt1).a(acbn.bkY, 1010, l, paramMessageRecord.msg);
            return;
          } while (paramInt2 != 4);
          this.app.a(paramInt1).a(acbn.blh, 1010, paramString.senderuin, paramString.selfuin, 0);
          a(paramString, null, false, true, 1);
          this.app.a(paramInt1).a(acbn.bkY, 1010, localMessageRecord.senderuin, localMessageRecord.selfuin, 0);
          a(localMessageRecord, null, false, true, 1);
          a(paramString, true, paramInt2);
        } while ((((MessageRecord)localObject).senderuin == null) || (!((MessageRecord)localObject).senderuin.equals(acbn.blh)));
        a(localMessageRecord, true, paramInt2);
        return;
        localObject = this.b.a(acbn.bkY, 1010);
      } while ((((QQMessageFacade.Message)localObject).senderuin == null) || (!((QQMessageFacade.Message)localObject).senderuin.equals(paramString)));
      paramString = anbi.d(paramMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField(paramString, paramMessageRecord);
      paramString.selfuin = paramMessageRecord.selfuin;
      paramString.senderuin = paramMessageRecord.frienduin;
      paramString.frienduin = acbn.bkY;
      if (paramInt2 == 3)
      {
        a(paramString, true, paramInt2);
        this.app.a(paramInt1).a(acbn.bkY, 1010, l, paramMessageRecord.extraflag, ((QQMessageFacade.Message)localObject).sendFailCode);
        this.app.a(paramInt1).a(acbn.bkY, 1010, l, paramMessageRecord.time, paramMessageRecord.shmsgseq);
        return;
      }
      if (paramInt2 == 2)
      {
        a(paramString, true, paramInt2);
        this.app.a(paramInt1).a(acbn.bkY, 1010, l, paramMessageRecord.msg);
        return;
      }
    } while (paramInt2 != 4);
    label273:
    label1072:
    this.app.a(paramInt1).a(acbn.bkY, 1010, paramString.senderuin, paramString.selfuin, 0);
    a(paramString, null, false, true, paramInt2);
    a(paramString, true, paramInt2);
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded boxUin=" + paramString + ",boxType=" + paramInt + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : boxUin=null");
      }
    }
    do
    {
      return;
      if (top.x(paramString, paramInt)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : is not msgbox");
    return;
    Object localObject = null;
    if (paramString.equals(acbn.bkE)) {
      localObject = acbn.blg;
    }
    tog localtog;
    while (localObject != null) {
      if (this.app.a().A((String)localObject, paramInt) > 0)
      {
        paramString = this.app.a(paramInt).a((String)localObject, paramInt);
        localtog = this.app.a();
        if (paramString != null) {
          l = b(paramString);
        }
        localtog.a((String)localObject, paramInt, l, paramBoolean1, paramBoolean2);
        bL((String)localObject, paramInt);
        return;
        if (paramString.equals(acbn.bkY)) {
          localObject = acbn.blh;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : childbox unread = 0");
      }
    }
    if (this.app.a().A(paramString, paramInt) > 0)
    {
      localObject = this.app.a(paramInt).a(paramString, paramInt);
      localtog = this.app.a();
      if (localObject != null) {
        l = b((MessageRecord)localObject);
      }
      localtog.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
      bL(paramString, paramInt);
    }
    for (int i = 1;; i = 0)
    {
      if (paramString.equals(acbn.blK))
      {
        aegu.d(this.app, true, true);
        aegu.d(this.app, true, false);
      }
      if (i == 0) {
        break;
      }
      this.b.as(this.b.a(paramString, paramInt));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "setBoxReaded return : box unread = 0");
      }
    }
  }
  
  public void bEk()
  {
    synchronized (this.bD)
    {
      try
      {
        this.bD.wait(15000L);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait over");
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest wait interrupted");
          }
        }
      }
    }
  }
  
  public void bEl()
  {
    synchronized (this.bD)
    {
      this.bD.notify();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeRequest notify");
      }
      return;
    }
  }
  
  protected void bJ(String paramString, int paramInt)
  {
    this.a.b().addCacheOpWeight(top.u(paramString, paramInt), acss.cAd);
  }
  
  protected void bK(String paramString, int paramInt)
  {
    ((znv)this.app.getBusinessHandler(147)).V(paramString, paramInt, -1);
  }
  
  protected void bL(String paramString, int paramInt) {}
  
  protected void c(QQMessageFacade.Message paramMessage) {}
  
  public void c(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    a(paramString1, paramInt, paramString2, paramString3, true);
  }
  
  public void cJ(ArrayList<RevokeMsgInfo> paramArrayList)
  {
    Object localObject1 = (RevokeMsgInfo)paramArrayList.get(0);
    int i = ((RevokeMsgInfo)localObject1).istroop;
    String str = ((RevokeMsgInfo)localObject1).frienduin;
    int j = ((RevokeMsgInfo)localObject1).opType;
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify frienduin = " + str + ", istroop = " + i);
    }
    Object localObject2 = this.app.a(i).l(str, i);
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: AIO is empty");
      }
      this.app.a().a().g(str, i, acsb.czv, acsb.czB);
    }
    List localList;
    do
    {
      return;
      localList = a((List)localObject2, str, i, paramArrayList);
      if ((localList == null) || (localList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify error: can't find previous msg in AIO");
        }
        this.app.a().a().g(str, i, acsb.czv, acsb.czC);
        return;
      }
      if ((localList == null) || (localList.size() != 1) || (!ahwb.aB((MessageRecord)localList.get(0)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "revoke msg doReplaceRevokedMsgAndNotify same gray msg");
      }
      paramArrayList = (MessageRecord)localList.get(0);
    } while (!(paramArrayList instanceof MessageForUniteGrayTip));
    ahwb.a(this.app, (MessageForUniteGrayTip)paramArrayList, i);
    return;
    Object localObject3 = (MessageRecord)localList.get(0);
    localObject2 = localList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramArrayList = (MessageRecord)((Iterator)localObject2).next();
      if ((paramArrayList.shmsgseq == ((RevokeMsgInfo)localObject1).shmsgseq) && (paramArrayList.msgUid == ((RevokeMsgInfo)localObject1).msguid)) {
        localObject3 = paramArrayList;
      }
    }
    for (;;)
    {
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      this.app.getApp().getString(2131699924);
      localObject2 = this.app.getApp().getString(2131699923);
      this.app.getApp().getString(2131699920);
      int k = ((RevokeMsgInfo)localObject1).dyl;
      Object localObject4;
      long l;
      if ((j == 1) || (j == 2))
      {
        localObject4 = acfp.m(2131703127);
        paramArrayList = this.app.getCurrentAccountUin();
        if (((MessageRecord)localList.get(0)).msgtype != -2006)
        {
          l = ((MessageRecord)localList.get(0)).time;
          if ((((RevokeMsgInfo)localObject1).bYF == null) || (gL(((RevokeMsgInfo)localObject1).bYF))) {
            break label784;
          }
          localObject2 = a(i, (String)localObject4, ((RevokeMsgInfo)localObject1).bYF, str, paramArrayList, localMessageForUniteGrayTip, l);
          localObject1 = ((ahwa)localObject2).wording;
          label527:
          ((ahwa)localObject2).ciG = true;
          ((ahwa)localObject2).ciH = false;
          localMessageForUniteGrayTip.initGrayTipMsg(this.app, (ahwa)localObject2);
          localMessageForUniteGrayTip.msgUid = ((MessageRecord)localObject3).msgUid;
          localMessageForUniteGrayTip.shmsgseq = ((MessageRecord)localObject3).shmsgseq;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doReplaceRevokedMsgAndNotify senderUin=", paramArrayList, ",frienduin=", str });
          }
          ahwb.a(this.app, localMessageForUniteGrayTip, localList, i, (String)localObject1, (ahwa)localObject2);
          paramArrayList = localList.iterator();
          label631:
          do
          {
            if (!paramArrayList.hasNext()) {
              break;
            }
            localObject2 = (MessageRecord)paramArrayList.next();
            this.app.b().d(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, false);
          } while (((MessageRecord)localObject2).msgtype != -2005);
          localObject1 = this.app.a();
          localObject2 = ((agkf)localObject1).a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
          if (localObject2 != null)
          {
            ((agkf)localObject1).l((FileManagerEntity)localObject2);
            this.app.a().ca(((FileManagerEntity)localObject2).nSessionId);
          }
          if (((MessageRecord)localObject3).istroop != 3000) {
            break label978;
          }
          ahau.JH("0X8005E50");
        }
      }
      for (;;)
      {
        ahau.JH("0X8005E4C");
        break label631;
        l = ((RevokeMsgInfo)localObject1).time;
        break;
        label784:
        localObject1 = acfp.m(2131703124) + BaseApplicationImpl.getApplication().getString(2131699924);
        if (k == 1) {
          localObject1 = ((String)localObject4).concat((String)localObject2);
        }
        paramArrayList = this.app.getCurrentAccountUin();
        localObject2 = new ahwa(str, paramArrayList, (String)localObject1, i, -5040, 1, ((MessageRecord)localObject3).time);
        break label527;
        paramArrayList = acfp.m(2131703122) + BaseApplicationImpl.getApplication().getString(2131696088);
        if (k == 1) {
          paramArrayList = acfp.m(2131703122) + (String)localObject2;
        }
        localObject1 = ((MessageRecord)localObject3).senderuin;
        localObject4 = new ahwa(str, (String)localObject1, paramArrayList, i, -5040, 1, ((MessageRecord)localObject3).time);
        localObject2 = paramArrayList;
        paramArrayList = (ArrayList<RevokeMsgInfo>)localObject1;
        localObject1 = localObject2;
        localObject2 = localObject4;
        break label527;
        label978:
        ahau.JH("0X8005E4D");
      }
      a(i, str, localMessageForUniteGrayTip, this.app.a(i).m(str, i));
      ahwb.a(this.app, localMessageForUniteGrayTip);
      this.app.a().a().am(null, true);
      return;
    }
  }
  
  protected void d(QQMessageFacade.Message paramMessage) {}
  
  public List<ChatMessage> f(String paramString, int paramInt)
  {
    return a(paramString, paramInt, -1L);
  }
  
  protected void fn(List<MessageRecord> paramList)
  {
    if ((Looper.myLooper() == Looper.getMainLooper()) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForText)) {
          ((MessageForText)localMessageRecord).parse();
        }
      }
    }
  }
  
  public boolean gL(String paramString)
  {
    return (TextUtils.equals(paramString, "10000")) || (TextUtils.equals(paramString, "1000000")) || (TextUtils.equals(paramString, "50000000")) || (TextUtils.equals(paramString, "80000000")) || (gM(paramString));
  }
  
  protected boolean gM(String paramString)
  {
    return ((aptw)this.app.getManager(203)).gM(paramString);
  }
  
  public void h(List<? extends MessageRecord> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    if (paramList.size() == 0) {}
    label774:
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Object localObject3 = (MessageRecord)paramList.get(0);
      int i = 1;
      Object localObject2;
      if (i < paramList.size())
      {
        localObject2 = (MessageRecord)paramList.get(i);
        if ((((MessageRecord)localObject2).istroop == 1) || (((MessageRecord)localObject2).istroop == 3000)) {
          if (((MessageRecord)localObject2).shmsgseq > ((MessageRecord)localObject3).shmsgseq) {
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          i += 1;
          localObject3 = localObject1;
          break;
          localObject1 = localObject3;
          if (((MessageRecord)localObject2).shmsgseq == ((MessageRecord)localObject3).shmsgseq)
          {
            localObject1 = localObject3;
            if (((MessageRecord)localObject2).getId() > ((MessageRecord)localObject3).getId())
            {
              localObject1 = localObject2;
              continue;
              if (((MessageRecord)localObject2).time > ((MessageRecord)localObject3).time)
              {
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = localObject3;
                if (((MessageRecord)localObject2).time == ((MessageRecord)localObject3).time)
                {
                  localObject1 = localObject3;
                  if (((MessageRecord)localObject2).getId() > ((MessageRecord)localObject3).getId()) {
                    localObject1 = localObject2;
                  }
                }
              }
            }
          }
        }
      }
      Object localObject1 = paramList.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((localObject2 instanceof MessageForLongMsg)) {
          localArrayList.addAll(((MessageForLongMsg)localObject2).longMsgFragmentList);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "-->removeMsgByMessageRecord :" + localObject2);
          }
          this.b.A((MessageRecord)localObject2);
          break;
          localArrayList.add(localObject2);
        }
      }
      localObject1 = top.u(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop);
      if (this.b.gP.containsKey(localObject1))
      {
        localObject1 = (QQMessageFacade.Message)this.b.gP.get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)paramList.next();
            if (!localMessageRecord.isread) {
              ((List)localObject2).add(localMessageRecord);
            }
          }
          if (((List)localObject2).size() != 0) {
            this.app.a().a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop, (List)localObject2);
          }
        }
      }
      this.app.a(((MessageRecord)localObject3).istroop).a(localArrayList, paramBoolean2);
      paramList = localArrayList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (MessageRecord)paramList.next();
        this.app.a().ay((MessageRecord)localObject1);
      }
      if (paramBoolean1) {
        this.app.a().a().js(localArrayList);
      }
      if ((localObject3 instanceof MessageForLongMsg))
      {
        if (!top.c((MessageRecord)localObject3, this.b.a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).istroop))) {
          break label665;
        }
        i = j;
        if (i != 0)
        {
          paramList = (kdm)this.app.getManager(88);
          if (!top.fL(((MessageRecord)localObject3).istroop)) {
            break label671;
          }
          t((MessageRecord)localObject3);
        }
      }
      for (;;)
      {
        if (!paramBoolean2) {
          break label774;
        }
        this.app.a(((MessageRecord)localObject3).istroop).bEw();
        return;
        i = j;
        if (this.b.y((MessageRecord)localObject3)) {
          break;
        }
        label665:
        i = 0;
        break;
        label671:
        if (nyn.i(this.app, ((MessageRecord)localObject3).frienduin))
        {
          a((MessageRecord)localObject3, paramList);
        }
        else if ((((MessageRecord)localObject3).istroop == 1008) && (nyn.f(this.app, ((MessageRecord)localObject3).frienduin)))
        {
          u((MessageRecord)localObject3);
          nyn.a().ad(this.app);
        }
        else if ((((MessageRecord)localObject3).istroop != 1008) || (!nyn.h(this.app, ((MessageRecord)localObject3).frienduin)))
        {
          u((MessageRecord)localObject3);
        }
      }
    }
  }
  
  protected void j(String paramString, int paramInt, long paramLong) {}
  
  public boolean m(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramMessageRecord;
      if (localMessageForShortVideo.busiType == 0)
      {
        if ((localMessageForShortVideo.videoFileStatus == 1007) || ((localMessageForShortVideo.videoFileStatus == 1003) && (localMessageForShortVideo.extraflag == 32772))) {}
        for (boolean bool = true; !bool; bool = false) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, holdFlag: " + bool);
        }
        w(paramMessageRecord);
        return true;
      }
    }
    else if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if (paramMessageRecord.extraflag == 32772)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "doMsgRevokeReqForRichMsg, msgForPic");
        }
        w(paramMessageRecord);
        return true;
      }
    }
    return false;
  }
  
  protected boolean s(String paramString, int paramInt)
  {
    return alkm.p(this.app, paramString, paramInt);
  }
  
  public void t(MessageRecord paramMessageRecord)
  {
    Object localObject1 = this.b.c(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localObject1 != null)
    {
      a((MessageRecord)localObject1, true, 4);
      b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, (MessageRecord)localObject1, 4);
    }
    for (;;)
    {
      return;
      Object localObject2 = null;
      Object localObject3 = this.app.getCurrentAccountUin();
      int i = top.eD(paramMessageRecord.istroop);
      if ((i == 1001) || (i == 10002)) {
        if (top.v(paramMessageRecord))
        {
          c(acbn.blg, i, paramMessageRecord.frienduin, (String)localObject3);
          localObject3 = this.b.a(acbn.blg, i);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if (((QQMessageFacade.Message)localObject3).senderuin != null)
            {
              localObject1 = localObject2;
              if (((QQMessageFacade.Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
              {
                ((QQMessageFacade.Message)localObject3).cleanMessageRecordBaseField();
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      while ((localObject1 != null) && (((QQMessageFacade.Message)localObject1).senderuin != null) && (((QQMessageFacade.Message)localObject1).senderuin.equals(paramMessageRecord.frienduin)))
      {
        ((QQMessageFacade.Message)localObject1).cleanMessageRecordBaseField();
        return;
        c(acbn.bkE, i, paramMessageRecord.frienduin, (String)localObject3);
        localObject1 = this.b.a(acbn.bkE, i);
        continue;
        if (top.eD(paramMessageRecord.istroop) == 1009)
        {
          c(acbn.bkt, 1009, paramMessageRecord.frienduin, (String)localObject3);
          localObject1 = this.b.a(acbn.bkt, 1009);
        }
        else
        {
          localObject1 = localObject2;
          if (top.eD(paramMessageRecord.istroop) == 1010) {
            if (top.v(paramMessageRecord))
            {
              c(acbn.blh, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject3 = this.b.a(acbn.blh, 1010);
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((QQMessageFacade.Message)localObject3).senderuin != null)
                {
                  localObject1 = localObject2;
                  if (((QQMessageFacade.Message)localObject3).senderuin.equals(paramMessageRecord.frienduin))
                  {
                    ((QQMessageFacade.Message)localObject3).cleanMessageRecordBaseField();
                    localObject1 = localObject2;
                  }
                }
              }
            }
            else
            {
              c(acbn.bkY, 1010, paramMessageRecord.frienduin, (String)localObject3);
              localObject1 = this.b.a(acbn.bkY, 1010);
            }
          }
        }
      }
    }
  }
  
  public void t(ArrayList<RevokeMsgInfo> paramArrayList, boolean paramBoolean)
  {
    RevokeMsgInfo localRevokeMsgInfo = (RevokeMsgInfo)paramArrayList.get(0);
    int i;
    int n;
    Object localObject4;
    Object localObject1;
    Object localObject3;
    String str2;
    int k;
    int m;
    boolean bool2;
    String str1;
    if (localRevokeMsgInfo.dyj > 1)
    {
      i = 1;
      n = localRevokeMsgInfo.istroop;
      localObject4 = localRevokeMsgInfo.bYD;
      localObject1 = localRevokeMsgInfo.frienduin;
      localObject3 = localRevokeMsgInfo.bYF;
      str2 = localRevokeMsgInfo.authorUin;
      k = localRevokeMsgInfo.opType;
      m = localRevokeMsgInfo.dyl;
      bool2 = localRevokeMsgInfo.czE;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify fromUin = " + (String)localObject4 + ", istroop = " + n + ",toUin=" + (String)localObject1 + ",groupUin=" + (String)localObject3 + ",authorUin=" + str2 + ",opType= " + k + ", needShow = " + bool2);
      }
      str1 = this.app.getCurrentAccountUin();
      localObject5 = localObject3;
      if (n != 1004) {
        if (n != 1000) {
          break label331;
        }
      }
    }
    ArrayList localArrayList;
    Object localObject6;
    label331:
    for (Object localObject5 = localObject3;; localObject5 = localObject4)
    {
      paramBoolean = TextUtils.equals(str1, (CharSequence)localObject4);
      if ((n != 3000) && (n != 1)) {
        break label338;
      }
      localObject3 = localObject1;
      localArrayList = new ArrayList();
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject6 = (RevokeMsgInfo)((Iterator)localObject1).next();
        localObject6 = this.app.b().c((String)localObject3, n, ((RevokeMsgInfo)localObject6).shmsgseq, ((RevokeMsgInfo)localObject6).msguid);
        if ((localObject6 != null) && (!((List)localObject6).isEmpty())) {
          localArrayList.addAll((Collection)localObject6);
        }
      }
      i = 0;
      break;
    }
    label338:
    if (paramBoolean) {}
    for (;;)
    {
      localObject3 = localObject1;
      break;
      localObject1 = localObject4;
    }
    if (i != 0) {}
    label490:
    int j;
    try
    {
      Collections.sort(localArrayList, top.y);
      if ((localArrayList != null) && (localArrayList.size() == 1)) {
        if (ahwb.aB((MessageRecord)localArrayList.get(0))) {
          return;
        }
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageManager", 2, "sort long msg error", localException);
            }
          }
          if (((MessageRecord)localArrayList.get(0)).msgtype != -2006) {
            break label490;
          }
          if (!(localArrayList.get(0) instanceof MessageForFoldMsg)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: msg is fold redbag msg");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.BaseMessageManager", 2, "revoke msg doHandleRevokedNotifyAndNotify, error: same revoke msg");
      return;
      j = 1;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        j = 0;
        if (!this.app.a.abU())
        {
          this.app.a().eQ(paramArrayList);
          return;
        }
      }
      if (localRevokeMsgInfo.dyl != 1) {
        break label2059;
      }
    }
    if (localArrayList.size() > 0) {
      paramBoolean = ((MessageRecord)localArrayList.get(0)).isSend();
    }
    label1281:
    label2059:
    for (;;)
    {
      localObject6 = new MessageForUniteGrayTip();
      long l;
      label631:
      String str3;
      Object localObject2;
      if ((j != 0) && (((MessageRecord)localArrayList.get(0)).msgtype != -2006))
      {
        l = ((MessageRecord)localArrayList.get(0)).time;
        if (!paramBoolean) {
          break label1144;
        }
        paramArrayList = acfp.m(2131703126);
        this.app.getApp().getString(2131699924);
        str3 = this.app.getApp().getString(2131699923);
        localObject2 = this.app.getApp().getString(2131699920);
        if ((k != 1) && (k != 2)) {
          break label1530;
        }
        if (!TextUtils.equals((CharSequence)localObject4, this.app.getCurrentAccountUin())) {
          break label1339;
        }
        if ((str2 == null) || (gL(str2))) {
          break label1281;
        }
        paramArrayList = a(n, paramArrayList, str2, (String)localObject3, (String)localObject5, (MessageForUniteGrayTip)localObject6, l);
        localObject2 = paramArrayList.wording;
        label740:
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, new Object[] { "revoke msg doHandleRevokedNotifyAndNotify isRevokeSender = ", Boolean.valueOf(paramBoolean), ",selfuin=", str1, ",fromUin=", localObject4 });
        }
        paramArrayList.ciG = true;
        paramArrayList.ciH = false;
        ((MessageForUniteGrayTip)localObject6).initGrayTipMsg(this.app, paramArrayList);
        if (j == 0) {
          break label1635;
        }
        l = ((MessageRecord)localArrayList.get(0)).msgUid;
        label833:
        ((MessageForUniteGrayTip)localObject6).msgUid = l;
        ((MessageForUniteGrayTip)localObject6).shmsgseq = localRevokeMsgInfo.shmsgseq;
        if (paramBoolean) {
          ahwb.la(localArrayList);
        }
        if (j == 0) {
          break label1840;
        }
        paramArrayList = localArrayList.iterator();
        label872:
        if (!paramArrayList.hasNext()) {
          break label1840;
        }
        localObject2 = (MessageRecord)paramArrayList.next();
        m = 0;
        k = m;
        if (i != 0)
        {
          k = m;
          if (!((MessageRecord)localObject2).isread)
          {
            k = m;
            if (localObject2 != localArrayList.get(0))
            {
              ((MessageRecord)localObject2).isread = true;
              if (n != 1)
              {
                k = m;
                if (n != 3000) {}
              }
              else
              {
                k = 1;
              }
            }
          }
        }
        if (k == 0) {
          break label1645;
        }
        this.app.a(n).a((MessageRecord)localObject2, false);
        if ((((MessageRecord)localObject2).msgtype == -2005) || ((localObject2 instanceof MessageForTroopFile)))
        {
          if (((MessageRecord)localObject2).msgtype != -2005) {
            break label1750;
          }
          localObject4 = this.app.a();
          localObject5 = ((agkf)localObject4).a(((MessageRecord)localObject2).uniseq, ((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);
          if (localObject5 == null) {
            break label1705;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageManager", 2, "find fileEntity");
          }
          ((agkf)localObject4).l((FileManagerEntity)localObject5);
          this.app.a().ca(((FileManagerEntity)localObject5).nSessionId);
        }
      }
      for (;;)
      {
        ((aocq)this.app.getManager(272)).aF((MessageRecord)localObject2);
        localObject2 = EmojiStickerManager.a((MessageRecord)localObject2);
        if (localObject2 == null) {
          break label872;
        }
        EmojiStickerManager.a().r.put(localObject2, Boolean.valueOf(true));
        break label872;
        l = localRevokeMsgInfo.time;
        break;
        label1144:
        if (n == 1)
        {
          paramArrayList = ((TroopManager)this.app.getManager(52)).jr((String)localObject3);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt(aqgv.ctc, aqgv.dZg);
          ((Bundle)localObject2).putLong(aqgv.ctd, ((MessageForUniteGrayTip)localObject6).uniseq);
          localObject2 = aqgv.a(this.app, (String)localObject5, (String)localObject3, paramArrayList, true, (Bundle)localObject2);
          paramArrayList = (ArrayList<RevokeMsgInfo>)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            paramArrayList = aqgv.a(this.app, (String)localObject5, (String)localObject3, 1, 0);
          }
          break label631;
        }
        if (n == 3000)
        {
          paramArrayList = aqgv.a(this.app, (String)localObject5, (String)localObject3, 2, 0);
          break label631;
        }
        paramArrayList = acfp.m(2131703118);
        break label631;
        localObject2 = paramArrayList.concat(this.app.getApp().getString(2131699924));
        if (m == 1) {
          localObject2 = paramArrayList.concat(str3);
        }
        paramArrayList = new ahwa((String)localObject3, (String)localObject5, (String)localObject2, n, -5040, 1, l);
        break label740;
        label1339:
        if (k == 2) {}
        for (localObject2 = this.app.getApp().getString(2131699952);; localObject2 = this.app.getApp().getString(2131699951))
        {
          k = ((String)localObject2).length();
          m = ((String)localObject2).length();
          int i1 = paramArrayList.length();
          paramArrayList = new ahwa((String)localObject3, (String)localObject5, (String)localObject2 + paramArrayList + this.app.getApp().getString(2131699924), n, -5040, 1, l);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt(aqgv.ctc, aqgv.dZg);
          ((Bundle)localObject2).putLong(aqgv.ctd, ((MessageForUniteGrayTip)localObject6).uniseq);
          ((Bundle)localObject2).putInt("key_action", 5);
          ((Bundle)localObject2).putString("troop_mem_uin", String.valueOf(localObject4));
          ((Bundle)localObject2).putBoolean("need_update_nick", true);
          paramArrayList.addHightlightItem(k, m + i1, (Bundle)localObject2);
          break;
        }
        label1530:
        if (localRevokeMsgInfo.dyl == 1) {
          if (!paramBoolean) {}
        }
        for (localObject2 = paramArrayList.concat(str3);; localObject2 = ((String)localObject2).concat(BaseApplicationImpl.getApplication().getString(2131696088)))
        {
          paramArrayList = new ahwa((String)localObject3, (String)localObject5, (String)localObject2, n, -5040, 1, l);
          break;
          localObject2 = paramArrayList;
          if (paramArrayList.length() > 12) {
            localObject2 = paramArrayList.substring(0, 11) + "...";
          }
        }
        label1635:
        l = localRevokeMsgInfo.msguid;
        break label833;
        label1645:
        localObject4 = this.app.b();
        localObject5 = ((MessageRecord)localObject2).frienduin;
        k = ((MessageRecord)localObject2).istroop;
        l = ((MessageRecord)localObject2).uniseq;
        if (!bool2) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject4).d((String)localObject5, k, l, bool1);
          break;
        }
        label1705:
        if (QLog.isColorLevel())
        {
          QLog.i("Q.msg.BaseMessageManager", 2, "can't find fileEntity,uniseq[" + ((MessageRecord)localObject2).uniseq + "],");
          continue;
          label1750:
          if ((localObject2 instanceof MessageForTroopFile))
          {
            localObject5 = (MessageForTroopFile)localObject2;
            localObject4 = TroopFileTransferManager.a(this.app, Long.parseLong(((MessageForTroopFile)localObject5).frienduin));
            localObject5 = apsv.a(this.app, (MessageForTroopFile)localObject5);
            if ((localObject5 != null) && (((apcy)localObject5).Id != null) && (localObject4 != null))
            {
              localObject5 = ((TroopFileTransferManager)localObject4).a(((apcy)localObject5).Id);
              if (localObject5 != null) {
                ((TroopFileTransferManager)localObject4).c((TroopFileTransferManager.Item)localObject5, 12);
              }
            }
          }
        }
      }
      label1840:
      paramArrayList = this.app.a(n).m((String)localObject3, n);
      if ((paramArrayList == null) || (paramArrayList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageManager", 2, "doHandleRevokedNotifyAndNotify: AIO is empty");
        }
        if (!bool2) {
          break label1970;
        }
        ahwb.a(this.app, (MessageForUniteGrayTip)localObject6);
      }
      for (;;)
      {
        if (j == 0) {
          break label1998;
        }
        paramArrayList = localArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localObject2 = (MessageRecord)paramArrayList.next();
          this.app.b().a.Z((MessageRecord)localObject2);
        }
        if (!bool2) {
          break;
        }
        a(n, (String)localObject3, (MessageForUniteGrayTip)localObject6, paramArrayList);
        break;
        label1970:
        if (localArrayList.size() > 0) {
          this.b.as(localArrayList.get(0));
        }
      }
      label1998:
      this.app.b().a.Z((MessageRecord)localObject6);
      if ((j != 0) && (!((MessageRecord)localArrayList.get(0)).isread)) {
        this.app.cLO();
      }
      this.app.a().a().am(localArrayList, paramBoolean);
      return;
    }
  }
  
  public void u(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord.frienduin;
    int j = paramMessageRecord.istroop;
    paramMessageRecord = top.u((String)localObject, j);
    if (this.b.gP.containsKey(paramMessageRecord)) {
      if (j != 1026) {
        break label237;
      }
    }
    label237:
    for (int i = 1;; i = j)
    {
      RecentUser localRecentUser = this.app.a().a().b((String)localObject, i);
      localObject = this.b.c((String)localObject, j);
      if (localObject != null)
      {
        a((MessageRecord)localObject, true, 4);
        if (localRecentUser != null)
        {
          if ((((MessageRecord)localObject).istroop == 1000) || (((MessageRecord)localObject).istroop == 1020) || (((MessageRecord)localObject).istroop == 1004)) {
            localRecentUser.troopUin = ((MessageRecord)localObject).senderuin;
          }
          localRecentUser.setType(i);
          localRecentUser.lastmsgtime = ((MessageRecord)localObject).time;
          ajpd.d(this.app, localRecentUser);
          this.app.a().a().e(localRecentUser);
        }
      }
      for (;;)
      {
        if (localRecentUser != null) {
          this.b.as(localRecentUser);
        }
        return;
        if (localRecentUser != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "updateMsgTabAfterDelMsg : No MessageRecord for replacing the mstTab, delete the ru.");
          }
          this.b.a(localRecentUser);
          this.b.gP.remove(paramMessageRecord);
        }
      }
    }
  }
  
  public void v(MessageRecord paramMessageRecord) {}
  
  public void x(MessageRecord paramMessageRecord)
  {
    Object localObject = acfp.m(2131703117);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    localObject = new ahwa(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5040, 1, paramMessageRecord.time);
    ((ahwa)localObject).ciH = false;
    localMessageForUniteGrayTip.initGrayTipMsg(this.app, (ahwa)localObject);
    localMessageForUniteGrayTip.msgUid = paramMessageRecord.msgUid;
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    this.app.b().d(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, false);
    localObject = this.app.a(paramMessageRecord.istroop).l(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "doRevokeFakeMsgToGrayTips error: AIO is empty");
      }
      this.app.a().a().g(paramMessageRecord.frienduin, paramMessageRecord.istroop, acsb.czv, acsb.czD);
      return;
    }
    ahwb.a(this.app, localMessageForUniteGrayTip);
  }
  
  public static class a
  {
    public acxw a;
    public ajdr a;
    public tog a;
    public acff c;
    public Map<String, RecentUser> gH = new HashMap();
    public Map<String, MessageRecord> gI = new HashMap();
    public Map<String, MessageRecord> gJ = new HashMap();
    public Map<String, MessageRecord> gK = new HashMap();
    public Map<String, MessageRecord> gL = new HashMap();
    public Map<String, List<MessageRecord>> gM = new HashMap();
    public Map<String, List<MessageRecord>> gN = new HashMap();
    
    public a(QQAppInterface paramQQAppInterface)
    {
      this.c = ((acff)paramQQAppInterface.getManager(51));
      this.jdField_a_of_type_Ajdr = ((ajdr)paramQQAppInterface.getManager(37));
      this.jdField_a_of_type_Acxw = paramQQAppInterface.a().a();
      this.jdField_a_of_type_Tog = paramQQAppInterface.a();
    }
  }
  
  static class b
  {
    long EA = 9223372036854775807L;
    long EB = 0L;
    MessageForFoldMsg a = null;
    boolean aPS = false;
    boolean aPT = true;
    MessageForFoldMsg b = null;
    int foldMsgCount = 0;
    LinkedHashSet<String> foldUinList = new LinkedHashSet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tnt
 * JD-Core Version:    0.7.0.1
 */