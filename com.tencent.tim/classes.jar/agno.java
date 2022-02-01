import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class agno
  extends agnn
{
  private ajkv jdField_a_of_type_Ajkv;
  private ajlf jdField_a_of_type_Ajlf;
  private MessageForReplyText b;
  private String bIA;
  HashMap<String, ArrayList<MessageRecord>> kM;
  private HashMap<String, ArrayList<MessageRecord>> kN;
  private QQAppInterface mApp;
  
  public agno(QQAppInterface paramQQAppInterface, ajlf paramajlf, HashMap<String, ArrayList<MessageRecord>> paramHashMap, ajkv paramajkv)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Ajlf = paramajlf;
    this.jdField_a_of_type_Ajkv = paramajkv;
    this.kM = paramHashMap;
    if ((this.kM != null) && (!this.kM.isEmpty()))
    {
      paramQQAppInterface = this.kM.keySet().iterator();
      do
      {
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        paramajlf = (String)paramQQAppInterface.next();
        paramHashMap = ((ArrayList)this.kM.get(paramajlf)).iterator();
        while (paramHashMap.hasNext())
        {
          paramajkv = (MessageRecord)paramHashMap.next();
          if ((paramajkv instanceof MessageForReplyText))
          {
            this.b = ((MessageForReplyText)paramajkv);
            this.bIA = paramajlf;
          }
        }
      } while (this.b == null);
    }
  }
  
  public int Ew()
  {
    if (this.jdField_a_of_type_Ajlf == null) {}
    while (this.jdField_a_of_type_Ajlf.sessionInfo == null) {
      return -1;
    }
    return this.jdField_a_of_type_Ajlf.sessionInfo.cZ;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> J()
  {
    if (this.kN == null)
    {
      this.kN = new HashMap();
      if ((this.b != null) && (this.b.getSourceMessage() != null) && (!TextUtils.isEmpty(this.bIA)))
      {
        Object localObject1 = this.b.getSourceMessage();
        Object localObject2;
        if ((localObject1 instanceof MessageForFile))
        {
          localObject2 = this.mApp.a().a(((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
          if ((localObject2 != null) && (((FileManagerEntity)localObject2).getCloudType() == 0))
          {
            QLog.i("ReplyMsgForwardRequest<QFile>", 1, "getForwardMessageList. init UploadSourceMsgList, find online file.");
            localObject2 = acfp.m(2131713890) + ((MessageRecord)localObject1).getExtInfoFromExtStr("_m_ForwardFileName");
            localObject2 = this.mApp.a().b().a((MessageRecord)localObject1, (String)localObject2, true);
            this.b.setSourceMessageRecord((MessageRecord)localObject2);
          }
        }
        if (ahav.ax((MessageRecord)localObject1))
        {
          int i = Ew();
          if ((i != 0) && (i != 3000) && (i != 1))
          {
            QLog.i("ReplyMsgForwardRequest<QFile>", 1, "getForwardMessageList. init UploadSourceMsgList, find unsupport chatType file.");
            localObject2 = acfp.m(2131713887) + ((MessageRecord)localObject1).getExtInfoFromExtStr("_m_ForwardFileName");
            localObject1 = this.mApp.a().b().a((MessageRecord)localObject1, (String)localObject2, true);
            this.b.setSourceMessageRecord((MessageRecord)localObject1);
          }
        }
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(this.b.getSourceMessage());
        this.kN.put(this.bIA, localObject1);
      }
    }
    return this.kN;
  }
  
  public void a(String paramString, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt)
  {
    paramString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
    paramList = acfp.m(2131713888) + paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    paramMessageRecord = this.mApp.a().b().a(paramMessageRecord, paramList, false);
    this.b.setSourceMessageRecord(paramMessageRecord);
    QLog.i("ReplyMsgForwardRequest<QFile>", 1, "replaceDropForwardMsg hint[ + " + paramList + "reason[" + paramString + "]");
  }
  
  public void b(int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    b(this.kN, this.kM);
    if (paramInt == 1)
    {
      paramList1 = this.b.getSourceMessage();
      paramList2 = acfp.m(2131713889) + paramList1.getExtInfoFromExtStr("_m_ForwardFileName");
      paramList1 = this.mApp.a().b().a(paramList1, paramList2, false);
      this.b.setSourceMessageRecord(paramList1);
      this.jdField_a_of_type_Ajkv.a(1, 2, this.jdField_a_of_type_Ajlf);
      return;
    }
    paramList2 = new ArrayList();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      paramList2.addAll(paramList1);
    }
    this.jdField_a_of_type_Ajkv.a(0, 2, this.jdField_a_of_type_Ajlf);
  }
  
  public String vk()
  {
    if (this.jdField_a_of_type_Ajlf == null) {
      return "";
    }
    if (this.jdField_a_of_type_Ajlf.j == null) {
      return "";
    }
    return String.valueOf(this.jdField_a_of_type_Ajlf.j.uniseq);
  }
  
  public String vl()
  {
    if (this.jdField_a_of_type_Ajlf == null) {
      return "";
    }
    if (this.jdField_a_of_type_Ajlf.sessionInfo == null) {
      return "";
    }
    return String.valueOf(this.jdField_a_of_type_Ajlf.sessionInfo.aTl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agno
 * JD-Core Version:    0.7.0.1
 */