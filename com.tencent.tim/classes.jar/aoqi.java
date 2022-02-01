import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class aoqi
  extends aopw
{
  private byte[] b(List<aoql.a.k> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (aoql.a.e)paramList.get(0);
    mobileqq_mp.LongMsgUrlRequest localLongMsgUrlRequest = new mobileqq_mp.LongMsgUrlRequest();
    try
    {
      l = Long.parseLong(paramList.peerUin);
      localLongMsgUrlRequest.puin.set(l);
      localLongMsgUrlRequest.str_fileid.set(paramList.cmA);
      return localLongMsgUrlRequest.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "PubAccountSvc.pull_long_msg_url";
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    aoql.a locala = (aoql.a)paramc.fi;
    aoql.b localb = locala.jdField_a_of_type_Aoql$b;
    paramc = paramd.g;
    Object localObject = paramd.g.getWupBuffer();
    achq.a locala1 = paramd.a;
    if (paramc.getResultCode() == 1000) {}
    try
    {
      if (localb.Hf.size() > 0)
      {
        paramd = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        paramc = (aoql.b.h)localb.Hf.get(0);
        paramc.a = ((mobileqq_mp.RetInfo)paramd.ret_info.get());
        paramc.cmF = paramd.str_url.get();
        paramc.cmG = paramd.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        aoqm.a(locala, localb);
        return;
        int i = paramc.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(paramc);
          paramc = paramc.getBusinessFailMsg();
          paramd = paramc;
          if (paramc == null) {
            paramd = "";
          }
          a(-1, 9311, (String)localObject, paramd, locala1, localb.Hf);
        }
        else
        {
          localObject = MessageHandler.b(paramc);
          paramc = paramc.getBusinessFailMsg();
          paramd = paramc;
          if (paramc == null) {
            paramd = "";
          }
          a(-1, 9044, (String)localObject, paramd, locala1, localb.Hf);
        }
      }
    }
    catch (Exception paramd)
    {
      break label126;
    }
  }
  
  void b(aoql.a parama)
  {
    parama = parama.jdField_a_of_type_Aoql$b;
    parama.Hf.clear();
    aoql.b.h localh = new aoql.b.h();
    parama.Hf.add(localh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoqi
 * JD-Core Version:    0.7.0.1
 */