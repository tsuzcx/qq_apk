import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

final class ajkz
  implements akxb
{
  ajkz(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(akxb.a parama)
  {
    for (;;)
    {
      try
      {
        if ((parama.result != 0) || (parama.data == null)) {
          continue;
        }
        Object localObject1 = new HashMap();
        localMessageRecord = this.val$app.b().a(this.bQI, this.dhX, this.rJ);
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg mr:" + localMessageRecord.toString());
          }
          Object localObject4 = new aozx();
          ((aozx)localObject4).uinType = localMessageRecord.istroop;
          ArrayList localArrayList1 = this.val$app.a().b().a(parama.data, (HashMap)localObject1, null, (aozx)localObject4);
          if ((localArrayList1 == null) || (localArrayList1.size() != 1) || ((((MessageRecord)localArrayList1.get(0)).msgtype != -1000) && (((MessageRecord)localArrayList1.get(0)).msgtype != -1051) && (((MessageRecord)localArrayList1.get(0)).msgtype != -1035))) {
            continue;
          }
          localObject1 = null;
          if (((MessageRecord)localArrayList1.get(0)).msgtype == -1035)
          {
            localObject1 = (MessageRecord)localArrayList1.get(0);
            MessageRecord.copyMessageRecordStatusField((MessageRecord)localObject1, localMessageRecord);
            ((MessageRecord)localObject1).selfuin = localMessageRecord.selfuin;
            ((MessageRecord)localObject1).frienduin = localMessageRecord.frienduin;
            ((MessageRecord)localObject1).senderuin = localMessageRecord.senderuin;
            ((MessageRecord)localObject1).istroop = localMessageRecord.istroop;
            ((MessageRecord)localObject1).msgId = localMessageRecord.msgId;
            this.val$app.b().t(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
            ((ajcy)this.val$app.getManager(174)).bt(true, this.dhX);
            if (((((MessageRecord)localArrayList1.get(0)).istroop == 1) && (localMessageRecord.istroop == 1)) || ((((MessageRecord)localArrayList1.get(0)).istroop == 3000) && (localMessageRecord.istroop == 3000) && (localObject4 != null)))
            {
              ((aozx)localObject4).b.ar(13, this.rJ);
              ((aozx)localObject4).b.ar(24, this.rJ);
              String str = localMessageRecord.frienduin;
              long l = this.val$app.a().e(str, localMessageRecord.istroop);
              if (QLog.isColorLevel()) {
                QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg update MessageInfo-- groupUin:" + str + "lastSeq:" + l + ",shMsgSeq:" + localMessageRecord.shmsgseq + ",msgInfo.hasFlag:" + ((aozx)localObject4).aAH());
              }
              if ((localMessageRecord.shmsgseq > l) && (((aozx)localObject4).aAH()))
              {
                localMessageRecord.mMessageInfo = ((aozx)localObject4);
                localObject4 = (tnu)this.val$app.b().a(1);
                ArrayList localArrayList2 = new ArrayList();
                localArrayList2.add(localMessageRecord);
                ((tnu)localObject4).r(str, localArrayList2);
              }
            }
            if ((((MessageRecord)localArrayList1.get(0)).msgtype != -1035) || (localObject1 == null)) {
              continue;
            }
            this.val$app.b().b((MessageRecord)localObject1, this.val$app.getAccount());
            this.val$app.a().notifyUI(1000, true, this.bQI);
            if (QLog.isColorLevel()) {
              QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload success end! cost:" + (System.currentTimeMillis() - this.acW));
            }
            ((MessageForLongTextMsg)localMessageRecord).loading = false;
            ((ajkw)this.val$app.getManager(166)).a(this.val$app, this.dhX, parama.result, 1);
            return;
          }
          localMessageRecord.msg = ((MessageRecord)localArrayList1.get(0)).msg;
          localMessageRecord.saveExtInfoToExtStr("long_text_recv_state", "1");
          localMessageRecord.removeExtInfoToExtStr("long_text_msg_resid");
          continue;
          if (localObject2 == null) {
            continue;
          }
        }
        catch (Exception localException1)
        {
          localObject2 = localMessageRecord;
        }
      }
      catch (Exception localException2)
      {
        MessageRecord localMessageRecord;
        Object localObject2;
        Object localObject3 = null;
        continue;
      }
      if ((localObject2 instanceof MessageForLongTextMsg))
      {
        ((MessageForLongTextMsg)localObject2).loading = false;
        this.val$app.a().notifyUI(999, true, this.bQI);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload exception! resultCode:" + parama.result + ",errCode: " + parama.errCode + ",errStr:" + parama.errStr + ",cost:" + (System.currentTimeMillis() - this.acW));
        continue;
        this.val$app.b().b(this.bQI, this.dhX, this.rJ, localMessageRecord.msg);
        this.val$app.b().a(this.bQI, this.dhX, this.rJ, "extStr", localMessageRecord.extStr);
        this.val$app.a().notifyUI(999, true, this.bQI);
        continue;
        ((MessageForLongTextMsg)localMessageRecord).loading = false;
        this.val$app.a().notifyUI(999, true, this.bQI);
        continue;
        localObject2 = this.val$app.b().a(this.bQI, this.dhX, this.rJ);
        try
        {
          if ((localObject2 instanceof MessageForLongTextMsg))
          {
            ((MessageForLongTextMsg)localObject2).loading = false;
            this.val$app.a().notifyUI(999, true, this.bQI);
          }
          if (QLog.isColorLevel()) {
            QLog.d("StructLongTextMsg", 2, "requestDownloadLongTextMsg onDownload failed! resultCode:" + parama.result + ",errCode: " + parama.errCode + ",errStr:" + parama.errStr + ",cost:" + (System.currentTimeMillis() - this.acW));
          }
        }
        catch (Exception localException3) {}
      }
    }
  }
  
  public void aS(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajkz
 * JD-Core Version:    0.7.0.1
 */