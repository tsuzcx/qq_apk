import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract class aoqk
  extends aopw
{
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    FromServiceMsg localFromServiceMsg = paramd.g;
    Object localObject = paramd.g.getWupBuffer();
    aoql.a locala = (aoql.a)paramc.fi;
    aoql.b localb = locala.a;
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
  
  protected abstract void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, aoql.a parama, aoql.b paramb, achq.a parama1, ProtoReqManager.d paramd, ProtoReqManager.c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqk
 * JD-Core Version:    0.7.0.1
 */