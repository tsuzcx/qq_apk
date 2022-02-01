import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ajlh
  extends ajks
{
  private static final String bRH = acfp.m(2131709638);
  
  public ajlh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ajlf paramajlf, MessageRecord paramMessageRecord, ArrayList<akxm> paramArrayList, ArrayList<MessageRecord> paramArrayList1, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramajlf = akxj.a(7, (MessageForPic)paramMessageRecord, paramInt1, paramString1, paramString2, this.app.getAccount());
      if (paramajlf != null) {
        paramArrayList.add(paramajlf);
      }
    }
    label47:
    label224:
    do
    {
      do
      {
        do
        {
          Object localObject;
          do
          {
            do
            {
              paramArrayList1.add(paramMessageRecord);
              break label47;
              break label47;
              break label47;
              break label47;
              for (;;)
              {
                return;
                if (QLog.isColorLevel())
                {
                  QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
                  return;
                  if ((paramMessageRecord instanceof MessageForMixedMsg))
                  {
                    paramajlf = akxj.a(7, (MessageForMixedMsg)paramMessageRecord, paramInt1, paramString1, paramString2, this.app.getAccount());
                    if (paramajlf != null)
                    {
                      paramArrayList.addAll(paramajlf);
                      paramArrayList1.add(paramMessageRecord);
                      return;
                    }
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfos from MessageForMixedMsg failed");
                    return;
                  }
                  if (paramMessageRecord.msgtype != -1036) {
                    break label224;
                  }
                  paramajlf = ((MessageForLongMsg)paramMessageRecord).longMsgFragmentList.iterator();
                  while (paramajlf.hasNext())
                  {
                    localObject = (MessageRecord)paramajlf.next();
                    if ((localObject instanceof MessageForMixedMsg))
                    {
                      localObject = akxj.a(7, (MessageForMixedMsg)localObject, paramInt1, paramString1, paramString2, this.app.getAccount());
                      if (localObject != null)
                      {
                        paramArrayList.addAll((Collection)localObject);
                        paramArrayList1.add(paramMessageRecord);
                      }
                    }
                  }
                }
              }
              if (!(paramMessageRecord instanceof MessageForStructing)) {
                break;
              }
              paramajlf = ((MessageForStructing)paramMessageRecord).structingMsg;
            } while ((paramajlf == null) || (!(paramajlf instanceof StructMsgForImageShare)));
            localObject = ((StructMsgForImageShare)paramajlf).getFirstImageElement();
          } while (localObject == null);
          if (((ansu)localObject).j == null)
          {
            if (((ansu)localObject).d == null) {
              ((ansu)localObject).d = ((StructMsgForImageShare)paramajlf);
            }
            ((ansu)localObject).j = ((ansu)localObject).a();
          }
          paramajlf = akxj.a(7, ((ansu)localObject).j, paramInt2, paramString1, paramString2, this.app.getAccount());
          if (paramajlf != null)
          {
            paramArrayList.add(paramajlf);
            paramArrayList1.add(paramMessageRecord);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]createForwardPicInfo from MessageForPic failed");
        return;
      } while (!(paramMessageRecord instanceof MessageForReplyText));
      paramMessageRecord = ((MessageForReplyText)paramMessageRecord).getSourceMessage();
    } while ((paramMessageRecord == null) || ((!(paramMessageRecord instanceof MessageForPic)) && (!(paramMessageRecord instanceof MessageForMixedMsg)) && (!(paramMessageRecord instanceof MessageForStructing)) && (paramMessageRecord.msgtype != -1036)));
    if (QLog.isColorLevel()) {
      QLog.e("PicMultiMsgProcessor", 2, "[requestSendMultiMsg] MessageForReplyText add to list");
    }
    if (paramajlf.djJ == 2) {}
    for (paramInt1 = 0;; paramInt1 = paramMessageRecord.istroop)
    {
      a(paramajlf, paramMessageRecord, paramArrayList, paramArrayList1, paramInt1, paramMessageRecord.selfuin, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      return;
    }
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, MessageRecord paramMessageRecord, ArrayList<MessageRecord> paramArrayList, ArrayList<akxm> paramArrayList1, int paramInt, ajlf paramajlf, ajkv paramajkv)
  {
    akxq localakxq = akxj.a(8, 7);
    localakxq.eF(paramArrayList1);
    localakxq.b(new ajli(this, paramArrayList, paramHashMap, paramMessageRecord, paramajkv, paramajlf));
    akxj.a(localakxq, this.app);
  }
  
  public void a(ajlf paramajlf, HashMap<String, ArrayList<MessageRecord>> paramHashMap, ajkv paramajkv)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramajlf.djJ == 2) {}
    for (int i = 0;; i = paramajlf.sessionInfo.cZ)
    {
      String str1 = this.app.getAccount();
      String str2 = paramajlf.sessionInfo.aTl;
      int j = paramajlf.sessionInfo.cZ;
      Iterator localIterator1 = paramHashMap.keySet().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
        while (localIterator2.hasNext()) {
          a(paramajlf, (MessageRecord)localIterator2.next(), localArrayList1, localArrayList2, i, str1, str2, j);
        }
      }
    }
    if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload pictures, count is [" + localArrayList1.size() + "], goto requestUploadPics");
      }
      a(paramHashMap, paramajlf.j, localArrayList2, localArrayList1, paramajlf.djJ, paramajlf, paramajkv);
      return;
    }
    paramajkv.a(0, 1, paramajlf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajlh
 * JD-Core Version:    0.7.0.1
 */