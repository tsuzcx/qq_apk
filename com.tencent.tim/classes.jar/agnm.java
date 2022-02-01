import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class agnm
  extends agnn
{
  private ajkv jdField_a_of_type_Ajkv;
  private ajlf jdField_a_of_type_Ajlf;
  HashMap<String, ArrayList<MessageRecord>> kM;
  private HashMap<String, ArrayList<MessageRecord>> kN;
  private QQAppInterface mApp;
  
  public agnm(QQAppInterface paramQQAppInterface, ajlf paramajlf, HashMap<String, ArrayList<MessageRecord>> paramHashMap, ajkv paramajkv)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Ajlf = paramajlf;
    this.jdField_a_of_type_Ajkv = paramajkv;
    this.kM = paramHashMap;
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
      Iterator localIterator = this.kM.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        ArrayList localArrayList = new ArrayList();
        this.kN.put(localObject, localArrayList);
        localObject = (ArrayList)this.kM.get(localObject);
        int i = 0;
        label86:
        MessageRecord localMessageRecord1;
        if (i < ((ArrayList)localObject).size())
        {
          localMessageRecord1 = (MessageRecord)((ArrayList)localObject).get(i);
          if (!(localMessageRecord1 instanceof MessageForReplyText)) {
            break label175;
          }
          MessageForReplyText localMessageForReplyText = (MessageForReplyText)localMessageRecord1;
          MessageRecord localMessageRecord2 = localMessageForReplyText.getSourceMessage();
          if ((localMessageRecord2 == null) || (!ahav.ax(localMessageRecord2))) {
            break label165;
          }
          localMessageRecord2.isMultiMsg = localMessageForReplyText.isMultiMsg;
          localArrayList.add(localMessageRecord2);
        }
        for (;;)
        {
          i += 1;
          break label86;
          break;
          label165:
          localArrayList.add(localMessageRecord1);
          continue;
          label175:
          localArrayList.add(localMessageRecord1);
        }
      }
    }
    return this.kN;
  }
  
  public void a(String paramString, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramList == null) || (paramMessageRecord == null)) {}
    do
    {
      return;
      paramList = (List)this.kM.get(paramString);
      paramString = null;
      if (paramList != null) {
        paramString = (MessageRecord)paramList.get(paramInt);
      }
    } while (paramString == null);
    if ((paramString instanceof MessageForReplyText))
    {
      paramList = acfp.m(2131708587) + paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      paramList = this.mApp.a().b().a(paramMessageRecord, paramList, true);
      ((MessageForReplyText)paramString).setSourceMessageRecord(paramList);
      return;
    }
    paramString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
    paramList.set(paramInt, this.mApp.a().b().a(paramMessageRecord, paramString, true));
  }
  
  public void b(int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    b(this.kN, this.kM);
    paramList2 = new ArrayList();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList2.addAll(paramList1);
      this.mApp.a().b().a(paramList2, null);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Ajkv.a(1, 2, this.jdField_a_of_type_Ajlf);
      return;
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
 * Qualified Name:     agnm
 * JD-Core Version:    0.7.0.1
 */