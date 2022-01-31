package com.tencent.mobileqq.app.message;

import AccostSvc.Msg;
import AccostSvc.MsgItem;
import AccostSvc.RichMsg;
import AccostSvc.SvrMsg;
import AccostSvc.UserInfo;
import MessageSvcPack.AccostMsg;
import MessageSvcPack.SvcGetMsgInfo;
import MessageSvcPack.SvcResponseGetMsgV2;
import QQService.PushCardMsg;
import QQService.PushType;
import QQService.PushVoteIncreaseInfo;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fnd;
import fne;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public class AccostMessageProcessor
  extends BaseMessageProcessor
{
  public AccostMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private RichMsg a(byte[] paramArrayOfByte)
  {
    try
    {
      RichMsg localRichMsg = new RichMsg();
      return localRichMsg;
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localRichMsg.readFrom(paramArrayOfByte);
        return localRichMsg;
      }
      catch (Exception paramArrayOfByte) {}
      paramArrayOfByte = paramArrayOfByte;
      return null;
    }
  }
  
  private void a(long paramLong, fne paramfne)
  {
    ArrayList localArrayList = paramfne.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    try
    {
      while (i < localArrayList.size())
      {
        Object localObject1 = (MsgItem)localArrayList.get(i);
        new String(((MsgItem)localObject1).MsgContent);
        if (-56 == ((MsgItem)localObject1).cType)
        {
          localObject1 = new JceInputStream(((MsgItem)localObject1).MsgContent);
          ((JceInputStream)localObject1).setServerEncoding("utf-8");
          Object localObject2 = new PushCardMsg();
          ((PushCardMsg)localObject2).readFrom((JceInputStream)localObject1);
          if (PushType.PUSH_TYPE_VOTE_INCR.value() == ((PushCardMsg)localObject2).ePushType)
          {
            localObject2 = new JceInputStream(((PushCardMsg)localObject2).vPushInfo);
            ((JceInputStream)localObject2).setServerEncoding("utf-8");
            localObject1 = new PushVoteIncreaseInfo();
            ((PushVoteIncreaseInfo)localObject1).readFrom((JceInputStream)localObject2);
            if (((PushVoteIncreaseInfo)localObject1).iIncrement > 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = (CardHandler)((QQAppInterface)localObject2).a(2);
              if (localObject2 != null) {
                ((CardHandler)localObject2).a((PushVoteIncreaseInfo)localObject1, String.valueOf(paramLong), String.valueOf(paramfne.jdField_a_of_type_Long));
              }
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramfne)
    {
      paramfne.printStackTrace();
    }
  }
  
  private void a(long paramLong, fne paramfne, SvcGetMsgInfo paramSvcGetMsgInfo, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramfne.jdField_a_of_type_JavaUtilArrayList;
    String str1 = paramfne.jdField_a_of_type_JavaLangString;
    int m = 0;
    int i = -1000;
    MsgItem localMsgItem;
    String str2;
    Object localObject3;
    int j;
    if (m < localArrayList2.size())
    {
      localMsgItem = (MsgItem)localArrayList2.get(m);
      str2 = new String(localMsgItem.MsgContent);
      localObject3 = null;
      j = localMsgItem.cType;
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp msgItem.cType:" + localMsgItem.cType + " isReaded:" + paramBoolean);
          }
          switch (j)
          {
          default: 
            localObject1 = null;
            j = i;
            localObject3 = localObject1;
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          int k;
          long l2;
          if ((localMsgItem.MsgContent == null) || (!QLog.isColorLevel())) {
            continue;
          }
          QLog.w("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp msgItem.MsgContent:" + HexUtil.a(localMsgItem.MsgContent));
          j = i;
          continue;
          if (paramfne.jdField_a_of_type_Int != 201) {
            continue;
          }
          Object localObject2 = ActionMsgUtil.a((String)localObject3, str1);
          if (j != -2000) {
            continue;
          }
          i = -1032;
          long l1 = l2;
          continue;
          if (j != -2002) {
            continue;
          }
          i = -1031;
          l1 = l2;
          continue;
          i = -1003;
          l1 = l2;
          continue;
          if (paramfne.jdField_a_of_type_Int != 6) {
            continue;
          }
          a(str1, paramLong, false);
          localObject2 = ActionMsgUtil.a((String)localObject3, str1);
          i = -3001;
          l1 = l2;
          continue;
          l1 = l2;
          localObject2 = localObject3;
          i = j;
          if (str1 == null) {
            continue;
          }
          l1 = l2;
          localObject2 = localObject3;
          i = j;
          if (str1.length() <= 0) {
            continue;
          }
          localObject2 = ActionMsgUtil.a((String)localObject3, str1);
          i = -3000;
          l1 = l2;
          continue;
          if (!(localObject3 instanceof MessageForPtt)) {
            continue;
          }
          localObject2 = (MessageForPtt)localObject3;
          ((MessageForPtt)localObject2).subVersion = 2;
          ((MessageForPtt)localObject2).url = str2;
          ((MessageForPtt)localObject2).urlAtServer = str2;
          ((MessageForPtt)localObject2).itemType = 2;
          ((MessageForPtt)localObject2).fileSize = 0L;
          ((MessageForPtt)localObject2).isread = false;
          continue;
        }
        k = j;
        if (localObject3 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp accostMsg.eAccostType" + paramfne.jdField_a_of_type_Int + "accostMsg.msgId: " + paramfne.jdField_b_of_type_Long + " accostMsg.time" + paramfne.c + " msgConten: " + Utils.a((String)localObject3));
          }
          l2 = paramfne.jdField_a_of_type_Long;
          if (paramfne.jdField_a_of_type_Int != 1) {
            continue;
          }
          l1 = 9999L;
          i = j;
          localObject1 = localObject3;
          localObject3 = MessageRecordFactory.a(i);
          ((MessageRecord)localObject3).init(paramLong, l1, paramfne.jdField_a_of_type_Long, (String)localObject1, paramfne.c, i, 1001, 0L);
          ((MessageRecord)localObject3).shmsgseq = paramfne.jdField_b_of_type_Long;
          ((MessageRecord)localObject3).isread = paramBoolean;
          if ((paramSvcGetMsgInfo != null) && (paramSvcGetMsgInfo.vReserved != null) && (paramSvcGetMsgInfo.vReserved.length >= 2))
          {
            ((MessageRecord)localObject3).longMsgCount = paramSvcGetMsgInfo.vReserved[0];
            ((MessageRecord)localObject3).longMsgIndex = paramSvcGetMsgInfo.vReserved[1];
            ((MessageRecord)localObject3).longMsgId = paramSvcGetMsgInfo.vReserved[2];
          }
          if (!(localObject3 instanceof MessageForPic)) {
            continue;
          }
          localObject1 = (MessageForPic)localObject3;
          ((MessageForPic)localObject1).subVersion = 2;
          if (i == -2000)
          {
            ((MessageForPic)localObject1).path = str2;
            ((MessageForPic)localObject1).uuid = str2;
            ((MessageForPic)localObject1).size = 0L;
            ((MessageForPic)localObject1).type = 1;
            ((MessageForPic)localObject1).isRead = false;
          }
          k = i;
          if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, false))
          {
            localArrayList1.add(localObject3);
            k = i;
          }
        }
        m += 1;
        i = k;
        break;
        localObject1 = new String(MessageUtils.b(localMsgItem.MsgContent), "utf-8");
        i = -1000;
        continue;
        localObject1 = TransfileUtile.a(str2, 0L, 1, false, str2);
        i = -2000;
        continue;
        localObject1 = TransfileUtile.a(str2, 0L, 2, false, str2);
        i = -2002;
        continue;
        a(paramLong, paramBoolean, paramfne);
      }
    }
    while (localArrayList1.size() <= 0) {
      return;
    }
    boolean bool1 = MessageHandlerUtils.a(localArrayList1);
    boolean bool2 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
    paramfne = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramfne.a(localArrayList1, String.valueOf(paramLong), paramBoolean);
      a("handleAccostMsgItemResp", true, localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool1, bool2), false);
      return;
    }
  }
  
  private void a(long paramLong1, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, long paramLong2, String paramString)
  {
    int i = 0;
    AccostMsg localAccostMsg;
    if (i < paramArrayList1.size())
    {
      localAccostMsg = (AccostMsg)paramArrayList1.get(i);
      if ((paramArrayList3 == null) || (paramArrayList3.size() <= i)) {
        break label343;
      }
    }
    label343:
    for (SvcGetMsgInfo localSvcGetMsgInfo = (SvcGetMsgInfo)paramArrayList3.get(i);; localSvcGetMsgInfo = null)
    {
      Object localObject = new AccostMessageProcessor.DelAccostMsg(this);
      ((AccostMessageProcessor.DelAccostMsg)localObject).jdField_a_of_type_Long = localAccostMsg.lFromMID;
      ((AccostMessageProcessor.DelAccostMsg)localObject).jdField_b_of_type_Long = localAccostMsg.lToMID;
      ((AccostMessageProcessor.DelAccostMsg)localObject).c = localAccostMsg.uMsgID;
      ((AccostMessageProcessor.DelAccostMsg)localObject).jdField_a_of_type_Short = localAccostMsg.shMsgType;
      paramArrayList2.add(localObject);
      boolean bool = a(String.valueOf(paramLong1), String.valueOf(localAccostMsg.lFromMID));
      if (QLog.isColorLevel())
      {
        MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", paramString, localAccostMsg.uMsgID, String.valueOf(paramLong1), String.valueOf(localAccostMsg.lToMID));
        QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleGetAccostMessageResp fromBlackList: " + bool + "accostMsg.shMsgType: " + localAccostMsg.shMsgType);
      }
      if (!bool) {
        switch (localAccostMsg.shMsgType)
        {
        }
      }
      ArrayList localArrayList;
      do
      {
        do
        {
          i += 1;
          break;
          localObject = a(localAccostMsg.strMsg);
        } while (localObject == null);
        localArrayList = ((RichMsg)localObject).VecMsg;
      } while ((localArrayList == null) || (localArrayList.size() <= 0));
      paramLong2 = localAccostMsg.lFromMID;
      if (localAccostMsg.eAccostType == 0) {}
      for (int j = localAccostMsg.iAccostType;; j = localAccostMsg.eAccostType)
      {
        a(paramLong1, new fne(this, paramLong2, j, localAccostMsg.uMsgID, localAccostMsg.iMsgTime, localArrayList, ((RichMsg)localObject).sAction), localSvcGetMsgInfo, false);
        break;
      }
      return;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, fne paramfne)
  {
    ArrayList localArrayList = new ArrayList();
    long l = paramfne.d;
    if (l == paramLong) {}
    SystemMsg localSystemMsg;
    for (int i = 1;; i = 0)
    {
      new ArrayList();
      localSystemMsg = new SystemMsg();
      localObject = new StringBuffer();
      int j = 0;
      while (j < paramfne.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((StringBuffer)localObject).append(new String(((MsgItem)paramfne.jdField_a_of_type_JavaUtilArrayList.get(j)).MsgContent));
        if (j < paramfne.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
          ((StringBuffer)localObject).append("\n");
        }
        j += 1;
      }
    }
    localSystemMsg.sMsg = ((StringBuffer)localObject).toString();
    localSystemMsg.auth = paramfne.jdField_a_of_type_ArrayOfByte;
    localSystemMsg.lToMobile = paramfne.e;
    localSystemMsg.strNickName = paramfne.jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "addFriendRequestByOldVersion, addUin=" + paramfne.d + ", msgUid=" + paramfne.jdField_b_of_type_Long + ", msg=" + localSystemMsg.sMsg);
    }
    Object localObject = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(String.valueOf(l));
    label322:
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = ContactUtils.a((Friends)localObject);
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label549;
      }
      localSystemMsg.message = (l + BaseApplication.getContext().getString(2131561412));
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("UTF-8");
      localSystemMsg.writeTo((JceOutputStream)localObject);
      localObject = HexUtil.a(((JceOutputStream)localObject).toByteArray());
      if (localObject != null)
      {
        localMessageRecord = MessageRecordFactory.a(-1011);
        localMessageRecord.init(paramLong, 9998L, l, (String)localObject, 0L, -1011, 0, paramfne.c);
        localMessageRecord.shmsgseq = 187L;
        localMessageRecord.msgUid = paramfne.jdField_b_of_type_Long;
        if (paramBoolean) {
          localMessageRecord.isread = true;
        }
        if (i == 0) {
          break label584;
        }
        i = 1;
        label429:
        localMessageRecord.issend = i;
        if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true)) {
          break label590;
        }
        localArrayList.add(localMessageRecord);
      }
    }
    for (;;)
    {
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(9998L), 0, localArrayList, true);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, String.valueOf(paramLong));
        a("addFriendRequestByOldVersion", true, localArrayList, true, false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localArrayList);
      }
      return;
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(String.valueOf(l));
      localObject = null;
      break;
      label549:
      localSystemMsg.message = ((String)localObject + BaseApplication.getContext().getString(2131561412));
      break label322;
      label584:
      i = 0;
      break label429;
      label590:
      if (QLog.isColorLevel()) {
        QLog.d("MessageHandler", 2, "addFriendRequestByOldVersion, the message is remove by msgFilter, addUin=" + paramfne.d + ", msgUid=" + localMessageRecord.msgUid + ", msg=" + localSystemMsg.sMsg);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (SvrMsg)paramObject;
      if (paramObject.stMsg != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg sMsg.stMsg is null");
    return;
    if (paramFromServiceMsg.getUin() == null)
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      boolean bool = a(paramFromServiceMsg.getUin(), String.valueOf(paramObject.stMsg.lFromMID));
      if (QLog.isColorLevel()) {
        MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR"), paramObject.stMsg.uMsgID, paramToServiceMsg, String.valueOf(paramObject.stMsg.lFromMID));
      }
      if (!bool) {
        switch (paramObject.stMsg.shMsgType)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramObject);
      return;
      paramToServiceMsg = paramFromServiceMsg.getUin();
      break;
      if ((paramObject.bResend != 1) || (!a(paramToServiceMsg, String.valueOf(paramObject.stMsg.lFromMID), paramObject.stMsg.uMsgID)))
      {
        paramFromServiceMsg = a(paramObject.stMsg.strMsg);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.VecMsg != null))
        {
          Object localObject = paramFromServiceMsg.VecMsg;
          localObject = new fne(this, paramObject.stMsg.lFromMID, paramObject.stMsg.eAccostType, paramObject.stMsg.uMsgID, paramObject.stMsg.iMsgTime, (ArrayList)localObject, paramFromServiceMsg.sAction);
          if (paramFromServiceMsg.stSender != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg richMsg.stSender is null");
            }
            ((fne)localObject).d = paramFromServiceMsg.stSender.lMobileUin;
            ((fne)localObject).jdField_a_of_type_ArrayOfByte = paramFromServiceMsg.stSender.sig;
            ((fne)localObject).jdField_b_of_type_JavaLangString = paramFromServiceMsg.stSender.nickname;
          }
          ((fne)localObject).e = paramObject.stMsg.lFromMID;
          a(Long.valueOf(paramToServiceMsg).longValue(), (fne)localObject, null, false);
          continue;
          paramFromServiceMsg = a(paramObject.stMsg.strMsg);
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = new fne(this, paramObject.stMsg.lFromMID, paramFromServiceMsg.VecMsg);
            a(Long.valueOf(paramToServiceMsg).longValue(), paramFromServiceMsg);
          }
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = Common.a(paramString);
    String str = (String)paramString.get("appid");
    paramString = (String)paramString.get("via");
    if (TextUtils.isEmpty("via")) {
      paramString = "ANDROIDQQ.PCPUSH";
    }
    for (;;)
    {
      if (str != null) {
        OpenSdkStatic.a().a(String.valueOf(paramLong), str, paramString, "100", paramBoolean);
      }
      return;
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    paramString1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(paramString2);
    return (paramString1 != null) && (paramString1.groupid == -1002);
  }
  
  private boolean a(String paramString1, String paramString2, long paramLong)
  {
    boolean bool2 = false;
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(String.valueOf(paramString1)).createEntityManager().a(false, MessageRecord.getTableName(paramString2, 1001), null, "msgseq=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      int i = paramString1.getCount();
      paramString1.close();
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (SvcResponseGetMsgV2)paramObject;
    if ((paramObject == null) || (paramObject.cReplyCode != 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramToServiceMsg, paramFromServiceMsg);
    }
    label315:
    label321:
    label337:
    for (;;)
    {
      return;
      int i;
      label125:
      ArrayList localArrayList1;
      if (paramFromServiceMsg.getUin() == null)
      {
        paramFromServiceMsg = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        long l = paramFromServiceMsg.longValue();
        int j = paramObject.cMoreMsg;
        paramFromServiceMsg = paramObject.vCookies;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder().append("<GetMsgV4><R>--->handleGetLbsMessageResp ssoSeq:").append(paramToServiceMsg.getRequestSsoSeq()).append(" msgStruct.cReplyCode: ").append(paramObject.cReplyCode).append(" vCookies:").append(paramFromServiceMsg).append(" size:");
          if (paramFromServiceMsg == null) {
            break label315;
          }
          i = paramFromServiceMsg.length;
          QLog.d("Q.msg.BaseMessageProcessor", 2, i);
        }
        paramToServiceMsg = paramObject.vAccostMsg;
        localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = paramObject.vMsgInfos;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleGetLbsMessageResp : moreMsg: " + j + "cSyncFlag:" + paramObject.cSyncFlag);
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleGetC2CMessageResp accostMsg size: " + paramToServiceMsg.size());
          }
          a(l, paramToServiceMsg, localArrayList1, localArrayList2, 0L, "handleGetLbsMessageResp");
        }
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.length <= 0)) {
          break label321;
        }
        a(paramFromServiceMsg, paramObject.cSyncFlag);
      }
      for (;;)
      {
        if (localArrayList1.size() <= 0) {
          break label337;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(null, localArrayList1);
        return;
        paramFromServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
        break;
        i = 0;
        break label125;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---handleGetLbsMessageResp. final resp of LbsMessage.");
        }
      }
    }
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><E>handleGetLbsOfflineMessageError ");
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 5001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><S>--->getLbsOfflineMsg : cChannel:4,syncFlag:" + paramInt);
    }
    a(false, false, false, 0L, new fnd(this, paramArrayOfByte, paramInt));
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (!QLog.isColorLevel());
    QLog.e("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><E>handleGetLbsOfflineMessageTimeOut ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.AccostMessageProcessor
 * JD-Core Version:    0.7.0.1
 */