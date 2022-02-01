import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class ajlb
  implements ajkv, akxb, akyf, Handler.Callback
{
  protected List<ajku> Dq = new ArrayList();
  protected MqqHandler J;
  protected Map<String, ajlf> cH = new HashMap();
  protected AtomicBoolean du = new AtomicBoolean(false);
  protected QQAppInterface mApp;
  
  public ajlb(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1) {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
    }
    this.mApp = ((QQAppInterface)localObject);
    this.J = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
    paramQQAppInterface = new ajlh(this.mApp);
    localObject = new ajlk(this.mApp);
    ajlj localajlj = new ajlj(this.mApp);
    ajkt localajkt = new ajkt(this.mApp);
    this.Dq.add(paramQQAppInterface);
    this.Dq.add(localObject);
    this.Dq.add(localajlj);
    this.Dq.add(localajkt);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, @NonNull ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, HashMap<String, ArrayList<MessageRecord>> paramHashMap1)
  {
    Object localObject1 = paramHashMap1;
    if (paramHashMap1 == null) {
      localObject1 = new HashMap();
    }
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = paramArrayList.iterator();
    int j;
    for (int i = 0; localIterator1.hasNext(); i = j + 1)
    {
      paramArrayList = (MessageRecord)localIterator1.next();
      localArrayList1.add(paramArrayList);
      ajlg.a(paramArrayList, (String)paramHashMap.get(top.g(paramArrayList)), paramMessageForStructing);
      j = i;
      if (ajlg.P((ChatMessage)paramArrayList))
      {
        j = 0;
        int k = 0;
        MessageForStructing localMessageForStructing = (MessageForStructing)paramArrayList;
        HashMap localHashMap = paramQQAppInterface.a().a(localMessageForStructing);
        if (localHashMap.size() > 0)
        {
          Iterator localIterator2 = localHashMap.keySet().iterator();
          j = k;
          while (localIterator2.hasNext())
          {
            paramArrayList = (String)localIterator2.next();
            ArrayList localArrayList2 = (ArrayList)localHashMap.get(paramArrayList);
            j = localArrayList2.size();
            paramHashMap1 = paramArrayList;
            if (paramArrayList.equalsIgnoreCase("MultiMsg"))
            {
              paramHashMap1 = String.valueOf(((HashMap)localObject1).size());
              localMessageForStructing.structingMsg.mFileName = paramHashMap1;
              localMessageForStructing.doPrewrite();
            }
            Iterator localIterator3 = localArrayList2.iterator();
            while (localIterator3.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)localIterator3.next();
              Object localObject2 = localMessageRecord.getExtInfoFromExtStr("self_nickname");
              paramArrayList = (ArrayList<ChatMessage>)localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                paramArrayList = ajlc.a().a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              if (paramArrayList != null)
              {
                localObject2 = paramArrayList;
                if (paramArrayList.trim().length() != 0) {}
              }
              else
              {
                localObject2 = ajlg.me(localMessageRecord.senderuin);
              }
              ajlg.a(localMessageRecord, (String)localObject2, paramMessageForStructing);
            }
            ((HashMap)localObject1).put(paramHashMap1, localArrayList2);
          }
        }
        j = i + j;
      }
    }
    paramMessageForStructing.structingMsg.mTSum = i;
    paramMessageForStructing.doPrewrite();
    ((HashMap)localObject1).put("MultiMsg", localArrayList1);
    ajlg.o("step.preHandle.mTSum = %d", new Object[] { Integer.valueOf(i) });
    return localObject1;
  }
  
  public void a(int paramInt1, int paramInt2, ajlf paramajlf)
  {
    if (this.du.get()) {
      return;
    }
    paramajlf.Re(paramInt2);
    paramajlf.iK(paramInt1, paramInt2);
    if (paramajlf.Gs() == 0)
    {
      Message localMessage = this.J.obtainMessage(3);
      localMessage.obj = paramajlf;
      localMessage.sendToTarget();
    }
    ajlg.logD("step.onUploadFinish:resultCode = %d,richMask = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramajlf.Gs()), Integer.valueOf(paramajlf.getResult()) });
  }
  
  protected void a(ajlf paramajlf)
  {
    Object localObject1 = paramajlf.lG.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (ArrayList)paramajlf.lG.get(localObject2);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if ((localObject3 instanceof MessageForReplyText))
          {
            localObject3 = (MessageForReplyText)localObject3;
            if ((((MessageForReplyText)localObject3).getSourceMessage() != null) && (((MessageForReplyText)localObject3).mSourceMsgInfo != null))
            {
              ((MessageForReplyText)localObject3).getSourceMessage().createMessageUniseq();
              ((MessageForReplyText)localObject3).mSourceMsgInfo.setUniSeq(((MessageForReplyText)localObject3).getSourceMessage().uniseq, true);
              ((MessageForReplyText)localObject3).mSourceMsgInfo.packSourceMsg(this.mApp, ((MessageForReplyText)localObject3).getSourceMessage());
              if ((paramajlf.bEW > 0) || (paramajlf.djJ == 0) || (paramajlf.djJ == 9))
              {
                ((MessageForReplyText)localObject3).mSourceMsgInfo.mSourceMsgTroopName = null;
                anot.a(this.mApp, "CliOper", "", "", "0X800A5D2", "0X800A5D2", 0, 0, "", "", "", "");
              }
              try
              {
                ((MessageForReplyText)localObject3).saveExtInfoToExtStr("sens_msg_source_msg_info", aqhs.bytes2HexStr(aczw.b(((MessageForReplyText)localObject3).mSourceMsgInfo)));
                if (ahav.ax(((MessageForReplyText)localObject3).getSourceMessage()))
                {
                  String str = ((MessageForReplyText)localObject3).getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                  ChatMessage localChatMessage = ahav.e((ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                  ahbr.a(this.mApp, localChatMessage, ((MessageForReplyText)localObject3).getSourceMessage());
                  if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
                  {
                    int i = Integer.parseInt(str);
                    if ((i == 1) || (i == 2)) {
                      ahav.a(this.mApp, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                    }
                  }
                }
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
    }
    if (paramajlf.lG.containsKey("reply_msg")) {
      paramajlf.lG.remove("reply_msg");
    }
    b(paramajlf);
    if (paramajlf.getResult() != 0)
    {
      c(paramajlf);
      return;
    }
    localObject1 = this.J.obtainMessage(1);
    ((Message)localObject1).obj = paramajlf;
    ((Message)localObject1).sendToTarget();
  }
  
  public void a(akxb.a parama)
  {
    Object localObject1 = null;
    if (this.du.get()) {}
    QQAppInterface localQQAppInterface;
    Object localObject2;
    long l;
    ajlf localajlf;
    List localList;
    do
    {
      do
      {
        do
        {
          return;
          localQQAppInterface = this.mApp;
        } while (localQQAppInterface == null);
        localObject2 = parama.bQY;
        l = parama.uniseq;
        localajlf = (ajlf)this.cH.get(localObject2);
        ajlg.o("onDownloadResp: mUniseq = %d,resIdStr = %s,errcode = %d", new Object[] { Long.valueOf(l), parama.resid, Integer.valueOf(parama.errCode) });
      } while (localajlf == null);
      localList = localajlf.Ds;
    } while (localList == null);
    label288:
    for (;;)
    {
      try
      {
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (MessageForStructing)localIterator.next();
          if (((MessageForStructing)localObject2).uniseq != l) {
            break label288;
          }
          localObject1 = localObject2;
          break label288;
        }
        if (localObject1 == null) {
          return;
        }
      }
      finally {}
      if (parama.errCode == 0)
      {
        localList.remove(localObject1);
        localObject2 = new HashMap();
        localQQAppInterface.a().b().a(parama.data, (HashMap)localObject2, localObject1, null);
      }
      for (;;)
      {
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        e(localajlf);
        return;
        parama = localQQAppInterface.a().a(localObject1, ajla.bRG, false);
        int i = localajlf.Dr.indexOf(localObject1);
        if (i >= 0) {
          localajlf.Dr.set(i, (ChatMessage)parama);
        }
      }
    }
  }
  
  public void a(akyf.a parama) {}
  
  public void a(QQAppInterface paramQQAppInterface, ajlf paramajlf)
  {
    List localList = paramajlf.Ds;
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)localIterator.next();
      aool localaool = new aool();
      localaool.cNy = false;
      localaool.mFileType = 131078;
      localaool.cmp = localMessageForStructing.structingMsg.mResid;
      localaool.mSelfUin = localMessageForStructing.selfuin;
      localaool.mPeerUin = localMessageForStructing.frienduin;
      localaool.cmn = localMessageForStructing.frienduin;
      localaool.mUinType = localMessageForStructing.istroop;
      localaool.mUniseq = localMessageForStructing.uniseq;
      localaool.mBusiType = 1035;
      localaool.jdField_b_of_type_Akxb = this;
      localaool.ckW = paramajlf.getKey();
      paramQQAppInterface.a().a(localaool);
      ajlg.o("downloadNestMultiMsg mUniseq = %d,resIdStr = %s", new Object[] { Long.valueOf(localaool.mUniseq), localaool.cmp });
    }
    ajlg.o("downloadNestMultiMsg msgSize = %d ", new Object[] { Integer.valueOf(localList.size()) });
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ajlf paramajlf)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramajlf.Dr;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (ajlg.P(localChatMessage))
      {
        Object localObject = (MessageForStructing)localChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mResid == null))
        {
          localObject = paramQQAppInterface.a().a(localChatMessage, ajla.bRF, false);
          localList.set(localList.indexOf(localChatMessage), (ChatMessage)localObject);
        }
        else if (paramQQAppInterface.a().a((MessageRecord)localObject).size() == 0)
        {
          localArrayList.add((MessageForStructing)localChatMessage);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      paramajlf.Ds = localArrayList;
      return true;
    }
    return false;
  }
  
  public void aS(int paramInt, boolean paramBoolean) {}
  
  protected void b(ajlf paramajlf)
  {
    acrb localacrb = this.mApp.a();
    Iterator localIterator = paramajlf.lG.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ArrayList)paramajlf.lG.get(localObject);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord instanceof MessageForReplyText))
          {
            if (localacrb != null) {
              localacrb.a(localMessageRecord, null);
            }
          }
          else if (((localMessageRecord instanceof MessageForMixedMsg)) && (((MessageForMixedMsg)localMessageRecord).getReplyMessage(this.mApp) != null) && (localacrb != null)) {
            localacrb.a(localMessageRecord, null);
          }
        }
      }
    }
  }
  
  public void b(akyf.a parama)
  {
    if (this.du.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.mApp;
    } while (localQQAppInterface == null);
    label769:
    for (;;)
    {
      Object localObject1;
      try
      {
        long l = ((Long)parama.data).longValue();
        localObject1 = null;
        localObject2 = this.cH.keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (((ajlf)this.cH.get(localObject3)).j.uniseq != l) {
            break label769;
          }
          localObject1 = (ajlf)this.cH.get(localObject3);
          continue;
        }
        if (localObject1 == null) {
          break;
        }
      }
      catch (Exception parama)
      {
        QLog.e("MultiMsg_TAG", 1, parama, new Object[0]);
        return;
      }
      this.cH.remove(((ajlf)localObject1).getKey());
      Object localObject2 = ((ajlf)localObject1).j;
      Object localObject3 = ((ajlf)localObject1).sessionInfo.aTl;
      int i = ((ajlf)localObject1).sessionInfo.cZ;
      if (((ajlf)localObject1).djJ == 2)
      {
        if (parama.result == 0)
        {
          ((MessageForStructing)localObject2).structingMsg.mResid = parama.uuid;
          ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
        }
        i = ((ajlf)localObject1).sessionInfo.bPv;
        new ajlc.a(localQQAppInterface, (MessageRecord)localObject2, (String)localObject3, i, (ArrayList)((ajlf)localObject1).lG.get("MultiMsg"), (HashMap)((ajlf)localObject1).mb).b(parama);
        ajlg.logD("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(parama.result), Long.valueOf(((MessageForStructing)localObject2).uniseq), Integer.valueOf(((ajlf)localObject1).Gs()), Integer.valueOf(((ajlf)localObject1).getResult()) });
        if (i != 0) {
          break label563;
        }
        i = 1;
      }
      for (;;)
      {
        label331:
        parama = ((MessageForStructing)localObject2).frienduin;
        int m = ((MessageForStructing)localObject2).structingMsg.mTSum;
        int n = ((ajlf)localObject1).djK;
        int i1 = ((ajlf)localObject1).videoSize;
        int i2 = ((ajlf)localObject1).fileSize;
        int i3 = ((ajlf)localObject1).bnm;
        localObject1 = ((ajlf)localObject1).lG;
        localObject2 = ((HashMap)localObject1).keySet().iterator();
        int k = 0;
        int j = 0;
        label648:
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label651;
          }
          localObject3 = ((ArrayList)((HashMap)localObject1).get((String)((Iterator)localObject2).next())).iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label648;
            }
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            if (localMessageRecord.msgtype == -2022)
            {
              j += 1;
              continue;
              if (parama.result == 0)
              {
                ((MessageForStructing)localObject2).structingMsg.mResid = parama.uuid;
                ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
                localQQAppInterface.b().c((String)localObject3, i, ((MessageForStructing)localObject2).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
                localQQAppInterface.b().b((MessageRecord)localObject2, null);
                break;
              }
              ((ajlf)localObject1).iK(1, 65536);
              c((ajlf)localObject1);
              break;
              label563:
              if ((i == 3000) || (i == 1))
              {
                i = 2;
                break label331;
              }
              if ((i == 1000) || (i == 1004))
              {
                i = 3;
                break label331;
              }
              if (!ChatActivityUtils.e(localQQAppInterface, ((ajlf)localObject1).sessionInfo)) {
                break label764;
              }
              i = 4;
              break label331;
            }
            if ((localMessageRecord.msgtype == -2005) || (localMessageRecord.msgtype == -2017)) {
              k += 1;
            }
          }
        }
        label651:
        anot.a(localQQAppInterface, "CliOper", "", parama, "0X8009AC0", "0X8009AC0", i, 0, m + "", n + i1 + i2 + i3 + "", "" + j, "" + k);
        return;
        label764:
        i = 1;
      }
    }
  }
  
  protected void c(ajlf paramajlf)
  {
    if (paramajlf == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (this.du.get());
      localQQAppInterface = this.mApp;
    } while (localQQAppInterface == null);
    MessageForStructing localMessageForStructing = paramajlf.j;
    String str = paramajlf.sessionInfo.aTl;
    int i = paramajlf.sessionInfo.cZ;
    localMessageForStructing.extraflag = 32768;
    localQQAppInterface.a().e(str, i, localMessageForStructing.uniseq);
    paramajlf = localQQAppInterface.b().a(str, i);
    if ((paramajlf != null) && (paramajlf.uniseq == localMessageForStructing.uniseq)) {
      paramajlf.extraflag = 32768;
    }
    long l = localMessageForStructing.uniseq;
    ((MessageHandler)localQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.gz(i), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  protected void d(ajlf paramajlf) {}
  
  public void destroy()
  {
    this.du.set(true);
    this.J.removeCallbacksAndMessages(null);
    this.Dq.clear();
    this.mApp = null;
  }
  
  public void e(ajlf paramajlf)
  {
    if (this.du.get()) {}
    Object localObject;
    do
    {
      return;
      localObject = this.mApp;
    } while (localObject == null);
    if (!this.cH.containsKey(paramajlf.getKey())) {
      this.cH.put(paramajlf.getKey(), paramajlf);
    }
    if (a((QQAppInterface)localObject, paramajlf))
    {
      a((QQAppInterface)localObject, paramajlf);
      return;
    }
    if (paramajlf.action == 0) {}
    for (int i = 0;; i = 2)
    {
      localObject = this.J.obtainMessage(i);
      ((Message)localObject).obj = paramajlf;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  public void f(ajlf paramajlf)
  {
    if (this.du.get()) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = this.mApp;
      } while (localObject1 == null);
      Object localObject3 = paramajlf.Dr;
      HashMap localHashMap = (HashMap)paramajlf.mb;
      localObject2 = paramajlf.j;
      localObject3 = a((QQAppInterface)localObject1, (MessageForStructing)localObject2, (ArrayList)localObject3, localHashMap, null);
      localObject1 = ((QQAppInterface)localObject1).a().b().a((MessageRecord)localObject2, (HashMap)localObject3, null, true, true);
      paramajlf.lG = ((HashMap)localObject1);
    } while (((HashMap)localObject1).size() == 0);
    paramajlf.Re(15);
    Object localObject2 = this.Dq.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ajku)((Iterator)localObject2).next()).a(paramajlf, (HashMap)localObject1, this);
    }
    ajlg.o("step.uploadRichStart", new Object[0]);
  }
  
  protected void g(ajlf paramajlf)
  {
    if (this.du.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.mApp;
    } while (localQQAppInterface == null);
    byte[] arrayOfByte = localQQAppInterface.a().b().a(paramajlf.lG, (HashMap)paramajlf.mb, true);
    if (arrayOfByte == null)
    {
      paramajlf.iK(99, 99);
      c(paramajlf);
      return;
    }
    String str1 = localQQAppInterface.getAccount();
    String str2 = paramajlf.sessionInfo.aTl;
    String str3 = paramajlf.sessionInfo.troopUin;
    int i = paramajlf.sessionInfo.cZ;
    long l = paramajlf.j.uniseq;
    paramajlf.djK = arrayOfByte.length;
    paramajlf = new aool();
    paramajlf.cNy = true;
    paramajlf.mFileType = 131078;
    paramajlf.dPD = 0;
    paramajlf.fT = arrayOfByte;
    paramajlf.mSelfUin = str1;
    paramajlf.mPeerUin = str2;
    paramajlf.cmn = str3;
    paramajlf.mUinType = i;
    paramajlf.mUniseq = l;
    paramajlf.mBusiType = 1035;
    paramajlf.jdField_b_of_type_Akyf = this;
    localQQAppInterface.a().a(paramajlf);
    ajlg.o("step.uploadPb.uniseq = %d,fileSize = %d", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    ajlf localajlf = (ajlf)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d(localajlf);
      continue;
      f(localajlf);
      continue;
      g(localajlf);
      continue;
      a(localajlf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ajlb
 * JD-Core Version:    0.7.0.1
 */