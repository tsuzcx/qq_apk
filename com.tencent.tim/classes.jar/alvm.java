import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class alvm
  extends ajlb
{
  public alvm(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private ujt.d a(MessageForReplyText paramMessageForReplyText, ajlf paramajlf)
  {
    SessionInfo localSessionInfo = paramajlf.sessionInfo;
    int i = paramajlf.bEW;
    ujt.d locald = new ujt.d();
    locald.mMsgSignalNetType = aqiw.getSystemNetwork(BaseApplication.getContext());
    locald.mMsgSendTime = System.currentTimeMillis();
    String str1 = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_msg");
    Object localObject = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_at_list");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (i <= 0))
    {
      locald.aLO = ((String)localObject);
      localObject = MessageForText.getTroopMemberInfoFromExtrJson((String)localObject);
      String str2 = ujt.a(str1, (ArrayList)localObject);
      if (!TextUtils.isEmpty(str2)) {
        str1 = anbk.a(str2, true, (ArrayList)localObject);
      }
      locald.aLN = str1;
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_msg");
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_at_list");
    }
    if (paramMessageForReplyText.mSourceMsgInfo != null)
    {
      locald.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText.mSourceMsgInfo);
      if (paramMessageForReplyText.getSourceMessage() != null) {
        locald.mSourceMsgInfo.packSourceMsg(this.mApp, paramMessageForReplyText.getSourceMessage());
      }
      if (i > 0)
      {
        locald.FD = paramMessageForReplyText.uniseq;
        locald.bEW = i;
        paramMessageForReplyText.atInfoList = null;
      }
      locald.mSourceMsgInfo.mType = 0;
    }
    if ((paramMessageForReplyText.istroop == 1) && (localSessionInfo.cZ == 1) && (localSessionInfo.aTl.equals(paramMessageForReplyText.frienduin))) {}
    for (i = 1;; i = 0)
    {
      if ((!paramajlf.cpg) || (i != 0))
      {
        locald.isBarrageMsg = paramMessageForReplyText.isBarrageMsg;
        locald.barrageTimeLocation = paramMessageForReplyText.barrageTimeLocation;
        locald.barrageSourceMsgType = paramMessageForReplyText.barrageSourceMsgType;
      }
      return locald;
    }
  }
  
  private void a(MessageForReplyText paramMessageForReplyText1, MessageForReplyText paramMessageForReplyText2)
  {
    if (paramMessageForReplyText2.getSourceMessage() == null)
    {
      QLog.d("ReplyMsgController", 1, "originMsg is null");
      return;
    }
    paramMessageForReplyText1.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText2.mSourceMsgInfo);
    paramMessageForReplyText2 = paramMessageForReplyText2.getSourceMessage();
    if (paramMessageForReplyText2 != null) {
      if (paramMessageForReplyText2.msgtype == -1037) {
        paramMessageForReplyText2 = ((MessageForLongMsg)paramMessageForReplyText2).rebuildLongMsg(true);
      }
    }
    for (;;)
    {
      if ((paramMessageForReplyText2 == null) && (QLog.isColorLevel())) {
        QLog.d("ReplyMsgController", 2, "MessageForReplyText deepCopySourceMsg is null");
      }
      paramMessageForReplyText1.setSourceMessageRecord(paramMessageForReplyText2);
      return;
      if (paramMessageForReplyText2.msgtype == -1036)
      {
        paramMessageForReplyText2 = (MessageForMixedMsg)((MessageForLongMsg)paramMessageForReplyText2).rebuildLongMsg();
      }
      else if (paramMessageForReplyText2.msgtype == -1035)
      {
        paramMessageForReplyText2 = ((MessageForMixedMsg)paramMessageForReplyText2).rebuildMixedMsg();
      }
      else if (paramMessageForReplyText2.msgtype == -2011)
      {
        paramMessageForReplyText2 = new MessageForStructing(paramMessageForReplyText2);
      }
      else if (paramMessageForReplyText2.msgtype == -2000)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramMessageForReplyText2.deepCopyByReflect();
        paramMessageForReplyText2 = localMessageRecord;
        if (!TextUtils.isEmpty(paramMessageForReplyText1.mSourceMsgInfo.mSourceMsgTroopName))
        {
          localMessageRecord.istroop = paramMessageForReplyText1.istroop;
          paramMessageForReplyText2 = localMessageRecord;
        }
      }
      else
      {
        paramMessageForReplyText2 = (MessageRecord)paramMessageForReplyText2.deepCopyByReflect();
        continue;
        paramMessageForReplyText2 = null;
      }
    }
  }
  
  private void i(ajlf paramajlf)
  {
    HashMap localHashMap = paramajlf.lG;
    Iterator localIterator1 = localHashMap.keySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject = (ArrayList)localHashMap.get((String)localIterator1.next());
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    Iterator localIterator2 = ((ArrayList)localObject).iterator();
    label55:
    MessageForReplyText localMessageForReplyText;
    while (localIterator2.hasNext())
    {
      localObject = (MessageRecord)localIterator2.next();
      if ((localObject instanceof MessageForReplyText))
      {
        localMessageForReplyText = (MessageForReplyText)localObject;
        if (((MessageRecord)localObject).msg != null) {
          break label133;
        }
      }
    }
    label133:
    for (Object localObject = "";; localObject = ((MessageRecord)localObject).msg)
    {
      ujt.d locald = a(localMessageForReplyText, paramajlf);
      ujt.a(this.mApp, null, paramajlf.sessionInfo, (String)localObject, localMessageForReplyText.atInfoList, locald);
      break label55;
      break;
    }
  }
  
  public ArrayList<MessageRecord> a(QQAppInterface paramQQAppInterface, List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (paramBoolean)
      {
        if (localMessageRecord.msgtype == -1037) {
          paramList = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
        }
        while (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReplyMsgController", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
          }
          return null;
          if (localMessageRecord.msgtype == -1036)
          {
            paramList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord).rebuildLongMsg();
          }
          else if (localMessageRecord.msgtype == -1035)
          {
            paramList = ((MessageForMixedMsg)localMessageRecord).rebuildMixedMsg();
          }
          else if (localMessageRecord.msgtype == -2011)
          {
            paramList = new MessageForStructing(localMessageRecord);
          }
          else if (localMessageRecord.msgtype == -1049)
          {
            paramList = (MessageRecord)localMessageRecord.deepCopyByReflect();
            a((MessageForReplyText)paramList, (MessageForReplyText)localMessageRecord);
          }
          else
          {
            paramList = (MessageRecord)localMessageRecord.deepCopyByReflect();
          }
        }
        if (!TextUtils.isEmpty(paramList.getExtInfoFromExtStr("troop_at_info_list"))) {
          paramList.removeExtInfoToExtStr("troop_at_info_list");
        }
        if (!TextUtils.isEmpty(paramList.getExtInfoFromExtStr("disc_at_info_list"))) {
          paramList.removeExtInfoToExtStr("disc_at_info_list");
        }
        paramList.atInfoList = null;
        paramList.extLong = localMessageRecord.extLong;
      }
      while (paramList == null)
      {
        return null;
        paramList = localMessageRecord;
      }
      paramList.uniseq = localMessageRecord.uniseq;
      paramList.msgseq = localMessageRecord.msgseq;
      if (ahav.ax(paramList)) {
        paramQQAppInterface.a().a().b(localMessageRecord, paramList);
      }
      MessageForReplyText localMessageForReplyText1;
      MessageForReplyText localMessageForReplyText2;
      if ((paramList instanceof MessageForReplyText))
      {
        localMessageForReplyText1 = (MessageForReplyText)localMessageRecord;
        localMessageForReplyText2 = (MessageForReplyText)paramList;
        if ((localMessageForReplyText2.getSourceMessage() != null) && (ahav.ax(localMessageForReplyText2.getSourceMessage()))) {
          paramQQAppInterface.a().a().b(localMessageForReplyText1.getSourceMessage(), localMessageForReplyText2.getSourceMessage());
        }
      }
      if ((paramList instanceof MessageForMixedMsg))
      {
        localMessageForReplyText1 = ((MessageForMixedMsg)paramList).getReplyMessage(paramQQAppInterface);
        localMessageForReplyText2 = ((MessageForMixedMsg)localMessageRecord).getReplyMessage(paramQQAppInterface);
        if ((localMessageForReplyText1 != null) && (localMessageForReplyText2 != null) && (localMessageForReplyText1.getSourceMessage() != null) && (ahav.ax(localMessageForReplyText1.getSourceMessage()))) {
          paramQQAppInterface.a().a().b(localMessageForReplyText2.getSourceMessage(), localMessageForReplyText1.getSourceMessage());
        }
      }
      if (paramList.msgtype == -2022) {
        ((MessageForShortVideo)paramList).redBagType = 0;
      }
      localArrayList.add(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "preAddMultiMsg, MessageRecord:" + localMessageRecord.toString());
      }
    }
    return localArrayList;
  }
  
  protected void b(ajlf paramajlf) {}
  
  public void b(akyf.a parama)
  {
    if (this.du.get()) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.mApp == null);
        if (QLog.isColorLevel()) {
          QLog.d("ReplyMsgController", 2, "onSend result.data=" + parama.data);
        }
      } while ((parama.data == null) || (!(parama.data instanceof String)));
      parama = (String)parama.data;
      parama = (ajlf)this.cH.get(parama);
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "onSend request=" + parama);
      }
    } while (parama == null);
    this.cH.remove(parama.getKey());
    i(parama);
  }
  
  protected void c(ajlf paramajlf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReplyMsgController", 2, "onFailed");
    }
    akyf.a locala = new akyf.a();
    locala.data = paramajlf.getKey();
    b(locala);
  }
  
  protected void d(ajlf paramajlf)
  {
    int i = 0;
    Object localObject1 = paramajlf.Dr;
    Object localObject2 = (HashMap)paramajlf.mb;
    localObject2 = this.mApp;
    if (paramajlf.action != 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = a((QQAppInterface)localObject2, (List)localObject1, bool);
      localObject1 = new HashMap(1);
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        long l = localMessageRecord.uniseq;
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(localMessageRecord);
        ((HashMap)localObject1).put(String.valueOf(l), localArrayList);
      }
    }
    paramajlf.lG = ((HashMap)localObject1);
    if (paramajlf.action == 0) {}
    for (;;)
    {
      localObject1 = this.J.obtainMessage(i);
      ((Message)localObject1).obj = paramajlf;
      ((Message)localObject1).sendToTarget();
      return;
      if (paramajlf.action == 2) {
        i = 1;
      }
    }
  }
  
  public void e(ajlf paramajlf)
  {
    if (this.du.get()) {}
    while (this.mApp == null) {
      return;
    }
    if (!this.cH.containsKey(paramajlf.getKey())) {
      this.cH.put(paramajlf.getKey(), paramajlf);
    }
    Message localMessage = this.J.obtainMessage(-1);
    localMessage.obj = paramajlf;
    localMessage.sendToTarget();
  }
  
  public void f(ajlf paramajlf)
  {
    if (this.du.get()) {}
    do
    {
      do
      {
        return;
      } while (this.mApp == null);
      if (paramajlf.lG.size() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReplyMsgController", 2, "uploadRichMsg dstMsgMap is empty");
    return;
    paramajlf.Re(15);
    Iterator localIterator = this.Dq.iterator();
    while (localIterator.hasNext()) {
      ((ajku)localIterator.next()).a(paramajlf, paramajlf.lG, this);
    }
    ajlg.o("ReplyMsgController step.uploadRichStart", new Object[0]);
  }
  
  protected void g(ajlf paramajlf)
  {
    akyf.a locala = new akyf.a();
    locala.data = paramajlf.getKey();
    b(locala);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvm
 * JD-Core Version:    0.7.0.1
 */