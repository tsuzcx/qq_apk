import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.MsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoItem;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager.1;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager.5;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager.6;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.RichText;

public class ajcy
  implements Manager
{
  private static final String bQH = acbn.SDCARD_PATH + "fight/pic_expire.png";
  private long acg;
  public QQAppInterface app;
  public ConcurrentHashMap<Long, ChatMessage> fO = new ConcurrentHashMap();
  
  public ajcy(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  private MessageForMixedMsg a(List<MessageRecord> paramList, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, boolean paramBoolean)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "constructMixedMr, input elemList is null, return...");
      }
      return null;
    }
    MessageForMixedMsg localMessageForMixedMsg = (MessageForMixedMsg)anbi.d(-1035);
    Object localObject = (MessageRecord)paramList.get(0);
    ((MessageRecord)localObject).longMsgId = 0;
    MessageRecord.copyMessageRecordBaseField(localMessageForMixedMsg, (MessageRecord)localObject);
    if (localMessageForMixedMsg.istroop == 1) {
      jof.a().b(localMessageForMixedMsg);
    }
    if ((paramSourceMsgInfo != null) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      paramSourceMsgInfo = new JSONObject();
    }
    try
    {
      localObject = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ((JSONArray)localObject).put(i, ((MessageForText.AtTroopMemberInfo)paramArrayList.get(i)).toJsonObject());
        i += 1;
      }
      paramSourceMsgInfo.put("0", localObject);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MixedMsgManager", 1, localJSONException, new Object[0]);
        continue;
        paramInt = -1;
      }
    }
    appb.a(paramInt, paramSourceMsgInfo.toString(), localMessageForMixedMsg);
    localMessageForMixedMsg.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localMessageForMixedMsg.issend = 1;
    localMessageForMixedMsg.msgtype = -1035;
    localMessageForMixedMsg.extraflag = 32772;
    localMessageForMixedMsg.msgElemList = paramList;
    if (paramBoolean)
    {
      paramInt = 1;
      localMessageForMixedMsg.mRobotFlag = paramInt;
      localMessageForMixedMsg.atInfoList = paramArrayList;
      localMessageForMixedMsg.prewrite();
      return localMessageForMixedMsg;
    }
  }
  
  public static MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      paramString2 = anbi.a(paramQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = akxq.xP();
      paramString2.md5 = aqhs.bytes2HexStr(MD5.getFileMd5(paramString2.path));
      if (akyr.lP(paramString1))
      {
        paramString1 = new PicMessageExtraData();
        paramString1.textSummary = paramQQAppInterface.getApp().getString(2131692307);
        paramString2.picExtraData = paramString1;
      }
      paramString2.serial();
      return paramString2;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int m = paramMessageForMixedMsg.msgElemList.size();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < m)
    {
      localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(j);
      if ((localObject instanceof MessageForText))
      {
        localObject = anbh.a((MessageForText)localObject);
        if (localObject != null) {}
      }
    }
    for (;;)
    {
      j += 1;
      break;
      int k = 0;
      while (k < ((im_msg_body.RichText)localObject).elems.size())
      {
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(k));
        k += 1;
      }
      continue;
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject != null)
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
          i += 1;
        }
      }
      else if ((localObject instanceof MessageForReplyText))
      {
        localObject = anbh.a((MessageForReplyText)localObject);
        if (localObject != null)
        {
          k = 0;
          while (k < ((im_msg_body.RichText)localObject).elems.size())
          {
            localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(k));
            k += 1;
            continue;
            i = localRichText.toByteArray().length;
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "packAndSendMsg, richTextLength : " + i);
            }
            paramMessageForMixedMsg.mRichTextLength = i;
            a(paramString, paramInt, paramMessageForMixedMsg, paramQQAppInterface, false);
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "packAndSendMsg,, send by longStruct message");
            }
            return;
          }
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList<akxm> paramArrayList, MessageForMixedMsg paramMessageForMixedMsg)
  {
    akxq localakxq = akxj.a(8, 7);
    localakxq.eF(paramArrayList);
    localakxq.b(new ajcz(this, paramMessageForMixedMsg, paramQQAppInterface, paramString, paramInt));
    akxj.a(localakxq, paramQQAppInterface);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString, boolean paramBoolean)
  {
    Object localObject = (ambj)this.app.getManager(326);
    ((ambj)localObject).aG(paramString, paramMessageForMixedMsg.uniseq);
    ((ambj)localObject).d(paramMessageForMixedMsg, null);
    Map localMap = Collections.synchronizedMap(new HashMap());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMessageForMixedMsg.msgElemList.iterator();
    while (localIterator.hasNext())
    {
      paramString = (MessageRecord)localIterator.next();
      if ((paramString instanceof MessageForPic))
      {
        MessageForPic localMessageForPic = (MessageForPic)paramString;
        if (ahbj.isFileExists(localMessageForPic.path))
        {
          localObject = (List)localMap.get(localMessageForPic.path);
          paramString = (String)localObject;
          if (localObject == null)
          {
            localHashMap.put(localMessageForPic, new ajcy.a(paramMessageForMixedMsg, localMap, localMessageForPic.path, paramArrayList));
            paramString = new ArrayList();
          }
          paramString.add(Integer.valueOf(localMessageForPic.subMsgId));
          localMap.put(localMessageForPic.path, paramString);
        }
      }
    }
    paramMessageForMixedMsg = localHashMap.entrySet().iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      paramArrayList = (Map.Entry)paramMessageForMixedMsg.next();
      a(this.app, (MessageForPic)paramArrayList.getKey(), paramBoolean, (akyf)paramArrayList.getValue());
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "send pic req:" + ((MessageForPic)paramArrayList.getKey()).path);
      }
    }
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    if ((paramMessageForMixedMsg.istroop != 3000) && (paramMessageForMixedMsg.istroop != 1)) {
      this.app.b().b(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32770, paramMessageForMixedMsg.sendFailCode);
    }
    h(this.app, paramMessageForMixedMsg);
    this.fO.remove(paramMessageForMixedMsg);
    this.fO.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(true, paramBoolean, paramMessageForMixedMsg, null);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, String paramString)
  {
    this.app.b().b(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32768, paramMessageForMixedMsg.sendFailCode);
    g(this.app, paramMessageForMixedMsg);
    this.fO.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    ambj.k(this.app, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.uniseq);
    a(false, paramBoolean, paramMessageForMixedMsg, paramString);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, MessageForMixedMsg paramMessageForMixedMsg, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_isresend", String.valueOf(paramMessageForMixedMsg.mIsResend));
    if (!paramMessageForMixedMsg.mIsResend)
    {
      localHashMap.put("param_forwardFromUin", paramMessageForMixedMsg.mForwardFromUin);
      localHashMap.put("param_forwardFromUinType", String.valueOf(paramMessageForMixedMsg.mForwardFromIsTroop));
    }
    localHashMap.put("param_senderUin", paramMessageForMixedMsg.senderuin);
    localHashMap.put("param_toUin", paramMessageForMixedMsg.frienduin);
    localHashMap.put("param_toUinType", String.valueOf(paramMessageForMixedMsg.istroop));
    localHashMap.put("param_sendByLongStruct", String.valueOf(paramBoolean2));
    localHashMap.put("param_richTextLength", String.valueOf(paramMessageForMixedMsg.mRichTextLength));
    if (paramString != null) {
      localHashMap.put("param_errDesc", paramString);
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "MixedMsgForward", paramBoolean1, 0L, 0L, localHashMap, "");
  }
  
  private boolean b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, akyf paramakyf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    aool localaool = new aool();
    localaool.cNy = true;
    localaool.mFileType = 131078;
    localaool.dPD = 1;
    localaool.fT = paramArrayOfByte;
    localaool.mSelfUin = paramString1;
    localaool.mPeerUin = paramString2;
    localaool.cmn = paramString3;
    localaool.mUinType = paramInt1;
    localaool.mUniseq = paramLong;
    localaool.mBusiType = paramInt2;
    localaool.b = paramakyf;
    paramQQAppInterface.a().a(localaool);
    return true;
  }
  
  public static void fa(String paramString, int paramInt)
  {
    anot.a(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public void a(SessionInfo paramSessionInfo, long paramLong, int paramInt)
  {
    Object localObject = (ChatMessage)this.fO.get(Long.valueOf(paramLong));
    if (localObject != null) {
      if (((ChatMessage)localObject).msgtype == -1036)
      {
        localObject = (MessageForMixedMsg)((MessageForLongMsg)localObject).rebuildLongMsg();
        ((MessageForMixedMsg)localObject).mForwardFromUniSeq = paramLong;
        ((MessageForMixedMsg)localObject).forwardID = paramInt;
        alvn.a().a(this.app, (MessageForMixedMsg)localObject, paramSessionInfo, paramInt);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        localObject = (MessageForMixedMsg)localObject;
      }
    }
    QLog.e("MixedMsgManager", 2, "forwardMixedMsg, not find in cache !");
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    a(paramSessionInfo, paramMessageForMixedMsg, paramBoolean, 0);
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, int paramInt)
  {
    paramSessionInfo = new MixedMsgManager.1(this, paramSessionInfo, paramInt, paramMessageForMixedMsg, paramBoolean);
    this.app.execute(paramSessionInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, MixedMsgInfo paramMixedMsgInfo)
  {
    if ((paramQQAppInterface == null) || (paramBaseChatPie == null) || (paramMixedMsgInfo == null)) {
      return;
    }
    Object localObject1 = paramMixedMsgInfo.fy();
    if ((TextUtils.isEmpty(paramMixedMsgInfo.xi())) && (localObject1 != null) && (((List)localObject1).size() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "sendMixedMrInfo, only 1 pic, send by pic message");
      }
      xro.a(paramQQAppInterface, paramBaseChatPie, paramBaseChatPie.a, paramBaseChatPie.b, false, null).a(paramBaseChatPie, (List)localObject1, false);
      return;
    }
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = paramBaseChatPie.mSourceMsgInfo;
    localObject1 = paramBaseChatPie.sessionInfo.aTl;
    int m = paramBaseChatPie.sessionInfo.cZ;
    paramBaseChatPie = new ArrayList();
    boolean bool1 = false;
    boolean bool2 = bool1;
    Object localObject2;
    Object localObject3;
    if (paramArrayList != null)
    {
      bool2 = bool1;
      if (!paramArrayList.isEmpty())
      {
        localObject2 = (aptw)paramQQAppInterface.getManager(203);
        localObject3 = paramArrayList.iterator();
        do
        {
          bool2 = bool1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (!((aptw)localObject2).cR(((MessageForText.AtTroopMemberInfo)((Iterator)localObject3).next()).uin));
        bool2 = true;
      }
    }
    int k = 0;
    bool1 = false;
    int i = 1;
    label206:
    int j;
    Object localObject4;
    if (k < paramMixedMsgInfo.fx().size())
    {
      localObject2 = (MixedMsgInfo.MsgNode)paramMixedMsgInfo.fx().get(k);
      j = i;
      if ((localObject2 instanceof MixedMsgInfo.TextMsgNode))
      {
        localObject3 = ((MixedMsgInfo.MsgNode)localObject2).text();
        j = i;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          if ((i == 0) || (localSourceMsgInfo == null)) {
            break label519;
          }
          localObject4 = anbi.a(paramQQAppInterface, (String)localObject1, m, localSourceMsgInfo, (String)localObject3);
          ((MessageForReplyText)localObject4).atInfoList = paramArrayList;
          paramBaseChatPie.add(localObject4);
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "Attach at first text node");
          }
          i = 0;
          label326:
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("MixedMsgManager", 2, "add txt:" + (String)localObject3);
            j = i;
          }
        }
      }
      if (!(localObject2 instanceof MixedMsgInfo.PhotoMsgNode)) {
        break label649;
      }
      localObject2 = ((MixedMsgInfo.PhotoMsgNode)localObject2).getPhotoItem();
      if ((localObject2 == null) || (!ahbj.isFileExists(((MixedMsgInfo.PhotoItem)localObject2).path))) {
        break label649;
      }
      if ((bool1) || (((MixedMsgInfo.PhotoItem)localObject2).isOriginal))
      {
        bool1 = true;
        label417:
        localObject3 = a(paramQQAppInterface, ((MixedMsgInfo.PhotoItem)localObject2).path, null, (String)localObject1, m);
        ThreadManager.getFileThreadHandler().post(new MixedMsgManager.6(this, (MessageForPic)localObject3));
        ((MessageForPic)localObject3).subMsgId = paramBaseChatPie.size();
        paramBaseChatPie.add(localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("MixedMsgManager", 2, "add pic:" + ((MixedMsgInfo.PhotoItem)localObject2).path);
        }
      }
    }
    label519:
    label649:
    for (;;)
    {
      k += 1;
      i = j;
      break label206;
      localObject4 = anbi.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), (String)localObject1, (String)localObject1, m, (byte)1, (byte)0, (short)0, (String)localObject3);
      ((MessageForText)localObject4).atInfoList = paramArrayList;
      paramBaseChatPie.add(localObject4);
      break label326;
      bool1 = false;
      break label417;
      paramBaseChatPie = a(paramBaseChatPie, paramArrayList, localSourceMsgInfo, m, bool2);
      if (paramBaseChatPie == null) {
        break;
      }
      a(paramBaseChatPie, paramArrayList, (String)localObject1, bool1);
      paramQQAppInterface.b().ce((String)localObject1, m);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MixedMsgManager", 2, "orderSender, sessionUin:" + (String)localObject1 + ", sequin:" + paramBaseChatPie.uniseq);
      return;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean, akyf paramakyf)
  {
    aool localaool = new aool();
    localaool.mSelfUin = paramMessageForPic.selfuin;
    localaool.mPeerUin = paramMessageForPic.frienduin;
    localaool.mUinType = paramMessageForPic.istroop;
    localaool.mFileType = 1;
    localaool.mUniseq = (paramMessageForPic.uniseq + paramMessageForPic.subMsgId);
    for (Object localObject = localaool.mPeerUin + localaool.mUniseq; paramQQAppInterface.a().cz.containsKey(localObject); localObject = localaool.mPeerUin + localaool.mUniseq) {
      localaool.mUniseq += 100L;
    }
    localaool.cNy = true;
    localaool.cMb = false;
    localObject = new aool.d();
    ((aool.d)localObject).cNJ = paramBoolean;
    localaool.en = localObject;
    localaool.dQ = paramMessageForPic.path;
    localaool.b = paramakyf;
    localaool.F = paramMessageForPic;
    paramQQAppInterface.a().a(localaool);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean, String paramString2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if ((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    if (paramSourceMsgInfo != null)
    {
      paramString2 = anbi.a(paramQQAppInterface, paramString1, paramInt, paramSourceMsgInfo, paramString2);
      paramString2.atInfoList = paramArrayList1;
      localArrayList.add(paramString2);
      bool = false;
    }
    for (;;)
    {
      label64:
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString2 = (String)paramArrayList.next();
        if (ahbj.isFileExists(paramString2))
        {
          paramString2 = a(paramQQAppInterface, paramString2, null, paramString1, paramInt);
          if (paramString2 != null)
          {
            ThreadManager.post(new MixedMsgManager.5(this, paramString2), 8, null, true);
            paramString2.subMsgId = localArrayList.size();
            localArrayList.add(paramString2);
            continue;
            if (TextUtils.isEmpty(paramString2)) {
              break label327;
            }
            paramString2 = anbi.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, (byte)1, (byte)0, (short)0, paramString2);
            paramString2.atInfoList = paramArrayList1;
            if ((paramString2.atInfoList == null) || (paramString2.atInfoList.isEmpty())) {
              break label321;
            }
            aptw localaptw = (aptw)paramQQAppInterface.getManager(203);
            Iterator localIterator = paramString2.atInfoList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (!localaptw.cR(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
          }
        }
      }
      label321:
      for (bool = true;; bool = false)
      {
        localArrayList.add(paramString2);
        break label64;
        paramArrayList = a(localArrayList, paramArrayList1, paramSourceMsgInfo, paramInt, bool);
        if (paramArrayList == null) {
          break;
        }
        a(paramArrayList, paramArrayList1, paramString1, paramBoolean);
        paramQQAppInterface.b().ce(paramString1, paramInt);
        return;
      }
      label327:
      bool = false;
    }
  }
  
  public void a(String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, " sendStructLongMsg start");
    }
    if ((paramMessageForMixedMsg instanceof ChatMessage)) {
      paramMessageForMixedMsg.mPendantAnimatable = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg saveMessage end and pack StructLongMsg start currenttime:" + System.currentTimeMillis());
    }
    byte[] arrayOfByte = paramQQAppInterface.a().b().a(paramMessageForMixedMsg);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
      }
      a(paramMessageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
    }
    do
    {
      do
      {
        return;
        this.acg = System.currentTimeMillis();
        paramString = new ajda(this, paramQQAppInterface, paramMessageForMixedMsg, paramString, paramInt);
        paramBoolean = b(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 1035, new ajdb(this, paramQQAppInterface, paramMessageForMixedMsg, paramString));
        if (!paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MixedMsgManager", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MixedMsgManager", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
  }
  
  public void ap(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(jof.a(paramMessageRecord)));
    anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "MixedMsgReceived", true, 0L, 0L, localHashMap, "");
  }
  
  public void bt(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", this.app.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt));
    if (paramBoolean)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "MixedMsgClientAutoPull", true, 0L, 0L, localHashMap, "");
      return;
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "MixedMsgClientManualPull", true, 0L, 0L, localHashMap, "");
  }
  
  protected void g(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().e(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().notifyUI(1000, false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  protected void h(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
      paramMessageRecord.extraflag = 32770;
    }
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().notifyUI(1000, true, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void onDestroy() {}
  
  public class a
    implements akyf
  {
    protected String bQJ;
    protected MessageForMixedMsg e;
    protected Map<String, List<Integer>> lK;
    protected ArrayList<MessageForText.AtTroopMemberInfo> xF;
    
    public a(Map<String, List<Integer>> paramMap, String paramString, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
    {
      this.e = paramMap;
      this.bQJ = paramArrayList;
      this.lK = paramString;
      Object localObject;
      this.xF = localObject;
    }
    
    private void a(MessageForMixedMsg paramMessageForMixedMsg)
    {
      Object localObject;
      if ((paramMessageForMixedMsg.msgElemList.get(0) instanceof MessageForText))
      {
        localObject = (MessageForText)paramMessageForMixedMsg.msgElemList.get(0);
        if ((this.xF != null) && (((MessageForText)localObject).atInfoList == null)) {
          ((MessageForText)localObject).atInfoList = this.xF;
        }
      }
      if (paramMessageForMixedMsg.istroop == 1)
      {
        localObject = paramMessageForMixedMsg.msgElemList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          jof.a().a(localMessageRecord);
        }
      }
      ajcy.a(ajcy.this, ajcy.this.app, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg, true);
    }
    
    public MessageRecord a(im_msg_body.RichText paramRichText)
    {
      Object localObject1 = (List)this.lK.get(this.bQJ);
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {}
      for (;;)
      {
        return null;
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Integer)((Iterator)localObject1).next();
          localObject2 = this.e.getSubMessage(((Integer)localObject2).intValue());
          if ((localObject2 instanceof MessageForPic)) {
            ((MessageForPic)localObject2).richText = paramRichText;
          }
        }
      }
    }
    
    public void a(akyf.a parama) {}
    
    public void b(akyf.a parama)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new ErrorMessage(parama.errCode, parama.errStr);
        QLog.d("MixedMsgManager", 2, "reqUploadMultiPics UiCallBack success result = " + parama + ", error = " + localObject1);
      }
      if (parama.errCode != 0) {
        ajcy.a(ajcy.this, this.e, false, "send Msg fail: " + parama);
      }
      do
      {
        do
        {
          return;
          localObject1 = (List)this.lK.remove(this.bQJ);
        } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Integer)((Iterator)localObject1).next();
          localObject2 = this.e.getSubMessage(((Integer)localObject2).intValue());
          if ((localObject2 instanceof MessageForPic))
          {
            localObject2 = (MessageForPic)localObject2;
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "onSend, pre MessageForPic:" + ((MessageForPic)localObject2).toLogString());
            }
            ((MessageForPic)localObject2).md5 = parama.md5;
            ((MessageForPic)localObject2).uuid = parama.uuid;
            ((MessageForPic)localObject2).size = parama.size;
            ((MessageForPic)localObject2).groupFileID = parama.groupFileID;
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "onSend, end MessageForPic:" + ((MessageForPic)localObject2).toLogString());
            }
            this.e.prewrite();
          }
        }
      } while (!this.lK.isEmpty());
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "onSend, mMsgMap isEmpty, packAndSend..");
      }
      a(this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcy
 * JD-Core Version:    0.7.0.1
 */