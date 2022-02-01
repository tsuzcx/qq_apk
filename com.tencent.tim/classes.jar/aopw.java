import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class aopw
  implements aoqm.b, ProtoReqManager.b
{
  int dOO = 0;
  
  public static int KW()
  {
    return jE(aomi.a().getNetType());
  }
  
  public static int jE(int paramInt)
  {
    int j = 6;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      String str = aomi.a().getApnType();
      paramInt = i;
      if (str != null)
      {
        paramInt = i;
        if (str.contains("wap")) {
          paramInt = 5;
        }
      }
      return paramInt;
      i = 3;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, achq.a parama, aoql.b.m paramm)
  {
    paramm.result = paramInt1;
    paramm.errCode = paramInt2;
    paramm.reason = paramString1;
    paramm.errStr = paramString2;
    if (paramInt1 == 0)
    {
      paramm.successCount = 1;
      paramm.failCount = (parama.retryCount - 1);
      return;
    }
    paramm.successCount = 0;
    paramm.failCount = parama.retryCount;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, achq.a parama, List<aoql.b.m> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, parama, (aoql.b.m)paramList.next());
    }
  }
  
  void a(aoql.a parama, ProtoReqManager.c paramc)
  {
    b(parama);
    parama.c = paramc;
    if (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.b(paramc);
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    FromServiceMsg localFromServiceMsg = paramd.g;
    Object localObject = paramd.g.getWupBuffer();
    aoql.a locala = (aoql.a)paramc.fi;
    aoql.b localb = locala.jdField_a_of_type_Aoql$b;
    achq.a locala1 = paramd.a;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      paramd = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((paramd.equals("conSucc")) || (paramd.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.c(localFromServiceMsg);
          paramc = localFromServiceMsg.getBusinessFailMsg();
          paramd = paramc;
          if (paramc == null) {
            paramd = "";
          }
          a(-1, 9311, (String)localObject, paramd, locala1, localb.Hf);
        }
      }
    }
    for (;;)
    {
      aoqm.a(locala, localb);
      return;
      paramc = localFromServiceMsg.getBusinessFailMsg();
      paramd = paramc;
      if (paramc == null) {
        paramd = "";
      }
      a(-1, 9044, String.valueOf(i), paramd, locala1, localb.Hf);
      continue;
      a(-1, 9313, paramd, localFromServiceMsg.getBusinessFailMsg(), locala1, localb.Hf);
      continue;
      a(localFromServiceMsg, (byte[])localObject, locala, localb, locala1, paramd, paramc);
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, aoql.a parama, aoql.b paramb, achq.a parama1, ProtoReqManager.d paramd, ProtoReqManager.c paramc) {}
  
  abstract void b(aoql.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopw
 * JD-Core Version:    0.7.0.1
 */