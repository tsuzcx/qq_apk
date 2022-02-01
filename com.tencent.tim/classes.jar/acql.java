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
import android.database.Cursor;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class acql
  extends tnv
{
  public acql(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
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
  
  private void a(long paramLong, acql.b paramb)
  {
    ArrayList localArrayList = paramb.tS;
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
              localObject2 = this.app;
              QQAppInterface localQQAppInterface = this.app;
              localObject2 = (CardHandler)((QQAppInterface)localObject2).getBusinessHandler(2);
              if (localObject2 != null) {
                ((CardHandler)localObject2).a((PushVoteIncreaseInfo)localObject1, String.valueOf(paramLong), String.valueOf(paramb.fromUin));
              }
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramb)
    {
      paramb.printStackTrace();
    }
  }
  
  private void a(long paramLong, acql.b paramb, SvcGetMsgInfo paramSvcGetMsgInfo, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramb.tS;
    String str2 = paramb.msgAction;
    int m = 0;
    int i = -1000;
    Object localObject3;
    String str1;
    int j;
    if (m < localArrayList2.size())
    {
      localObject3 = (MsgItem)localArrayList2.get(m);
      str1 = null;
      if (((MsgItem)localObject3).MsgContent != null) {
        str1 = new String(((MsgItem)localObject3).MsgContent);
      }
      j = ((MsgItem)localObject3).cType;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp msgItem.cType:" + ((MsgItem)localObject3).cType + " isReaded:" + paramBoolean);
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
        if ((((MsgItem)localObject3).MsgContent == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp msgItem.MsgContent:" + aqhs.bytes2HexStr(((MsgItem)localObject3).MsgContent));
        localObject3 = null;
        j = i;
        continue;
        if (paramb.czh != 201) {
          continue;
        }
        localObject2 = aqfw.encode((String)localObject3, str2);
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
        if (paramb.czh != 6) {
          continue;
        }
        h(str2, paramLong, false);
        localObject2 = aqfw.encode((String)localObject3, str2);
        i = -3001;
        l1 = l2;
        continue;
        l1 = l2;
        localObject2 = localObject3;
        i = j;
        if (str2 == null) {
          continue;
        }
        l1 = l2;
        localObject2 = localObject3;
        i = j;
        if (str2.length() <= 0) {
          continue;
        }
        localObject2 = aqfw.encode((String)localObject3, str2);
        i = -3000;
        l1 = l2;
        continue;
        if (!(localObject3 instanceof MessageForPtt)) {
          continue;
        }
        localObject2 = (MessageForPtt)localObject3;
        ((MessageForPtt)localObject2).subVersion = 2;
        ((MessageForPtt)localObject2).url = str1;
        ((MessageForPtt)localObject2).urlAtServer = str1;
        ((MessageForPtt)localObject2).itemType = 2;
        ((MessageForPtt)localObject2).fileSize = 0L;
        ((MessageForPtt)localObject2).isread = false;
        continue;
      }
      k = j;
      if (localObject3 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleAccostMsgItemResp accostMsg.eAccostType" + paramb.czh + "accostMsg.msgId: " + paramb.msgId + " accostMsg.time" + paramb.msgTime + " msgConten: " + aqft.pk((String)localObject3));
        }
        l2 = paramb.fromUin;
        if (paramb.czh != 1) {
          continue;
        }
        l1 = 9999L;
        i = j;
        localObject1 = localObject3;
        localObject3 = anbi.d(i);
        ((MessageRecord)localObject3).init(paramLong, l1, paramb.fromUin, (String)localObject1, paramb.msgTime, i, 1001, 0L);
        ((MessageRecord)localObject3).shmsgseq = paramb.msgId;
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
          ((MessageForPic)localObject1).path = str1;
          ((MessageForPic)localObject1).uuid = str1;
          ((MessageForPic)localObject1).size = 0L;
          ((MessageForPic)localObject1).type = 1;
          ((MessageForPic)localObject1).isRead = false;
        }
        k = i;
        if (!achp.a(this.app, (MessageRecord)localObject3, false))
        {
          localArrayList1.add(localObject3);
          k = i;
        }
      }
      m += 1;
      i = k;
      break;
      if (((MsgItem)localObject3).MsgContent != null)
      {
        localObject1 = new String(anbk.B(((MsgItem)localObject3).MsgContent), "utf-8");
        break label954;
        localObject1 = aoon.a(str1, 0L, 1, false, str1);
        i = -2000;
        continue;
        localObject1 = aoon.a(str1, 0L, 2, false, str1);
        i = -2002;
        continue;
        a(paramLong, paramBoolean, paramb);
        return;
        if (localArrayList1.size() <= 0) {
          continue;
        }
        boolean bool = achp.F(localArrayList1);
        i = top.a(localArrayList1, this.app);
        paramb = this.app.b();
        if ((bool) && (this.app.isBackground_Stop)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramb.c(localArrayList1, String.valueOf(paramLong), paramBoolean);
          a("handleAccostMsgItemResp", true, i, this.a.aO(bool), false);
          return;
        }
      }
      else
      {
        localObject2 = null;
      }
      label954:
      i = -1000;
    }
  }
  
  private void a(long paramLong1, ArrayList<AccostMsg> paramArrayList, ArrayList<acql.a> paramArrayList1, ArrayList<SvcGetMsgInfo> paramArrayList2, long paramLong2, String paramString)
  {
    int i = 0;
    AccostMsg localAccostMsg;
    if (i < paramArrayList.size())
    {
      localAccostMsg = (AccostMsg)paramArrayList.get(i);
      if ((paramArrayList2 == null) || (paramArrayList2.size() <= i)) {
        break label342;
      }
    }
    label342:
    for (SvcGetMsgInfo localSvcGetMsgInfo = (SvcGetMsgInfo)paramArrayList2.get(i);; localSvcGetMsgInfo = null)
    {
      Object localObject = new acql.a();
      ((acql.a)localObject).fromUin = localAccostMsg.lFromMID;
      ((acql.a)localObject).toUin = localAccostMsg.lToMID;
      ((acql.a)localObject).msgId = localAccostMsg.uMsgID;
      ((acql.a)localObject).X = localAccostMsg.shMsgType;
      paramArrayList1.add(localObject);
      boolean bool = aE(String.valueOf(paramLong1), String.valueOf(localAccostMsg.lFromMID));
      if (QLog.isColorLevel())
      {
        achp.a("Q.msg.BaseMessageProcessor", paramString, localAccostMsg.uMsgID, String.valueOf(paramLong1), String.valueOf(localAccostMsg.lToMID));
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
        a(paramLong1, new acql.b(paramLong2, j, localAccostMsg.uMsgID, localAccostMsg.iMsgTime, localArrayList, ((RichMsg)localObject).sAction), localSvcGetMsgInfo, false);
        break;
      }
      return;
    }
  }
  
  private void a(long paramLong, boolean paramBoolean, acql.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    long l = paramb.lMobileUin;
    if (l == paramLong) {}
    SystemMsg localSystemMsg;
    for (int i = 1;; i = 0)
    {
      new ArrayList();
      localSystemMsg = new SystemMsg();
      localObject = new StringBuffer();
      int j = 0;
      while (j < paramb.tS.size())
      {
        ((StringBuffer)localObject).append(new String(((MsgItem)paramb.tS.get(j)).MsgContent));
        if (j < paramb.tS.size() - 1) {
          ((StringBuffer)localObject).append("\n");
        }
        j += 1;
      }
    }
    localSystemMsg.sMsg = ((StringBuffer)localObject).toString();
    localSystemMsg.auth = paramb.sig;
    localSystemMsg.lToMobile = paramb.lToMobile;
    localSystemMsg.strNickName = paramb.nickName;
    if (QLog.isColorLevel()) {
      QLog.d("MessageHandler", 2, "addFriendRequestByOldVersion, addUin=" + paramb.lMobileUin + ", msgUid=" + paramb.msgId + ", msg=" + localSystemMsg.sMsg);
    }
    Object localObject = ((acff)this.app.getManager(51)).e(String.valueOf(l));
    label320:
    MessageRecord localMessageRecord;
    if (localObject != null)
    {
      localObject = aqgv.c((Friends)localObject);
      if ((localObject != null) && (((String)localObject).length() != 0)) {
        break label558;
      }
      localSystemMsg.message = (l + BaseApplication.getContext().getString(2131689802));
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("UTF-8");
      localSystemMsg.writeTo((JceOutputStream)localObject);
      localObject = aqhs.bytes2HexStr(((JceOutputStream)localObject).toByteArray());
      if (localObject != null)
      {
        localMessageRecord = anbi.d(-1011);
        localMessageRecord.init(paramLong, 9998L, l, (String)localObject, 0L, -1011, 0, paramb.msgTime);
        localMessageRecord.shmsgseq = 187L;
        localMessageRecord.msgUid = paramb.msgId;
        if (paramBoolean) {
          localMessageRecord.isread = true;
        }
        if (i == 0) {
          break label593;
        }
        i = 1;
        label427:
        localMessageRecord.issend = i;
        if (achp.a(this.app, localMessageRecord, true)) {
          break label599;
        }
        localArrayList.add(localMessageRecord);
      }
    }
    for (;;)
    {
      if (localArrayList.size() > 0)
      {
        i = top.a(localArrayList, this.app);
        this.app.b().a(String.valueOf(9998L), 0, localArrayList, true);
        this.app.b().s(localArrayList, String.valueOf(paramLong));
        a("addFriendRequestByOldVersion", true, i, true, false);
        this.a.dI(localArrayList);
      }
      return;
      ((FriendListHandler)this.app.getBusinessHandler(1)).DG(String.valueOf(l));
      localObject = null;
      break;
      label558:
      localSystemMsg.message = ((String)localObject + BaseApplication.getContext().getString(2131689802));
      break label320;
      label593:
      i = 0;
      break label427;
      label599:
      if (QLog.isColorLevel()) {
        QLog.d("MessageHandler", 2, "addFriendRequestByOldVersion, the message is remove by msgFilter, addUin=" + paramb.lMobileUin + ", msgUid=" + localMessageRecord.msgUid + ", msg=" + localSystemMsg.sMsg);
      }
    }
  }
  
  private boolean aE(String paramString1, String paramString2)
  {
    paramString1 = ((acff)this.app.getManager(51)).e(paramString2);
    return (paramString1 != null) && (paramString1.groupid == -1002);
  }
  
  private void aW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (SvcResponseGetMsgV2)paramObject;
    if ((paramObject == null) || (paramObject.cReplyCode != 0)) {
      this.a.n(paramToServiceMsg, paramFromServiceMsg);
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
        paramFromServiceMsg = Long.valueOf(this.app.getAccount());
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
        i(paramFromServiceMsg, paramObject.cSyncFlag);
      }
      for (;;)
      {
        if (localArrayList1.size() <= 0) {
          break label337;
        }
        this.a.m(null, localArrayList1);
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
  
  private boolean d(String paramString1, String paramString2, long paramLong)
  {
    EntityManager localEntityManager = this.app.getEntityManagerFactory(String.valueOf(paramString1)).createEntityManager();
    paramString1 = localEntityManager.query(false, MessageRecord.getTableName(paramString2, 1001), null, "msgseq=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
    if (paramString1 != null) {}
    for (;;)
    {
      try
      {
        i = paramString1.getCount();
        if (paramString1 != null) {
          paramString1.close();
        }
        paramString1 = localEntityManager.query(false, MessageRecord.getTableName(paramString2, 10002), null, "msgseq=?", new String[] { String.valueOf(paramLong) }, null, null, null, null);
        int j = 0;
        if (paramString1 != null) {}
        return false;
      }
      finally
      {
        try
        {
          j = paramString1.getCount();
          if (paramString1 != null) {
            paramString1.close();
          }
          if (j + i <= 0) {
            break label165;
          }
          return true;
        }
        finally
        {
          if (paramString1 == null) {
            break label163;
          }
          paramString1.close();
        }
        paramString2 = finally;
        if (paramString1 != null) {
          paramString1.close();
        }
      }
      label163:
      label165:
      int i = 0;
    }
  }
  
  private void h(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = arug.y(paramString);
    String str = (String)paramString.get("appid");
    paramString = (String)paramString.get("via");
    if (TextUtils.isEmpty("via")) {
      paramString = "ANDROIDQQ.PCPUSH";
    }
    for (;;)
    {
      if (str != null) {
        aryb.a().d(String.valueOf(paramLong), str, paramString, "100", paramBoolean);
      }
      return;
    }
  }
  
  private void ik(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramToServiceMsg = this.app.getAccount();
      boolean bool = aE(paramFromServiceMsg.getUin(), String.valueOf(paramObject.stMsg.lFromMID));
      if (QLog.isColorLevel()) {
        achp.a("Q.msg.BaseMessageProcessor", (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR"), paramObject.stMsg.uMsgID, paramToServiceMsg, String.valueOf(paramObject.stMsg.lFromMID));
      }
      if (!bool) {
        switch (paramObject.stMsg.shMsgType)
        {
        }
      }
    }
    for (;;)
    {
      this.a.a(paramObject);
      return;
      paramToServiceMsg = paramFromServiceMsg.getUin();
      break;
      if ((paramObject.bResend != 1) || (!d(paramToServiceMsg, String.valueOf(paramObject.stMsg.lFromMID), paramObject.stMsg.uMsgID)))
      {
        paramFromServiceMsg = a(paramObject.stMsg.strMsg);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.VecMsg != null))
        {
          Object localObject = paramFromServiceMsg.VecMsg;
          localObject = new acql.b(paramObject.stMsg.lFromMID, paramObject.stMsg.eAccostType, paramObject.stMsg.uMsgID, paramObject.stMsg.iMsgTime, (ArrayList)localObject, paramFromServiceMsg.sAction);
          if (paramFromServiceMsg.stSender != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "handlePushAccostMsg richMsg.stSender is null");
            }
            ((acql.b)localObject).lMobileUin = paramFromServiceMsg.stSender.lMobileUin;
            ((acql.b)localObject).sig = paramFromServiceMsg.stSender.sig;
            ((acql.b)localObject).nickName = paramFromServiceMsg.stSender.nickname;
          }
          ((acql.b)localObject).lToMobile = paramObject.stMsg.lFromMID;
          a(Long.valueOf(paramToServiceMsg).longValue(), (acql.b)localObject, null, false);
          continue;
          paramFromServiceMsg = a(paramObject.stMsg.strMsg);
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = new acql.b(paramObject.stMsg.lFromMID, paramFromServiceMsg.VecMsg);
            a(Long.valueOf(paramToServiceMsg).longValue(), paramFromServiceMsg);
          }
        }
      }
    }
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
  
  public void f(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 5001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        ik((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      bN(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      aW((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    bN(getClass().getName(), paramInt);
  }
  
  public void i(byte[] paramArrayOfByte, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "<GetMsgV4><S>--->getLbsOfflineMsg : cChannel:4,syncFlag:" + paramInt);
    }
    a(false, false, false, 0L, new acqm(this, paramArrayOfByte, paramInt));
  }
  
  public static class a
  {
    public short X;
    public long fromUin;
    public long msgId;
    public long toUin;
  }
  
  static class b
  {
    public int czh;
    public long fromUin;
    public long lMobileUin;
    public long lToMobile;
    public String msgAction;
    public long msgId;
    public long msgTime;
    public String nickName;
    public byte[] sig;
    public ArrayList<MsgItem> tS;
    
    public b(long paramLong1, int paramInt, long paramLong2, long paramLong3, ArrayList<MsgItem> paramArrayList, String paramString)
    {
      this.fromUin = paramLong1;
      this.czh = paramInt;
      this.msgId = paramLong2;
      this.msgTime = paramLong3;
      this.tS = paramArrayList;
      this.msgAction = paramString;
    }
    
    public b(long paramLong, ArrayList<MsgItem> paramArrayList)
    {
      this.fromUin = paramLong;
      this.tS = paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acql
 * JD-Core Version:    0.7.0.1
 */