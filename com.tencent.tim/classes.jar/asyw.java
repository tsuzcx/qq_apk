import com.tencent.ims.QSecControlBitsQuery.QSecCbResp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

class asyw
  implements aszo.a
{
  asyw(asyv paramasyv) {}
  
  public void lG(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((!paramFromServiceMsg.isSuccess()) || (paramObject == null)) {}
    for (;;)
    {
      return;
      try
      {
        QSecControlBitsQuery.QSecCbResp localQSecCbResp = new QSecControlBitsQuery.QSecCbResp();
        localQSecCbResp.mergeFrom((byte[])paramObject);
        int j = -1;
        int i = j;
        if (localQSecCbResp.u32_status != null)
        {
          i = j;
          if (localQSecCbResp.u32_status.has()) {
            i = localQSecCbResp.u32_status.get();
          }
        }
        if (i == 0)
        {
          if ((localQSecCbResp.u32_time_interval != null) && (localQSecCbResp.u32_time_interval.has())) {
            localQSecCbResp.u32_time_interval.get();
          }
          paramFromServiceMsg = null;
          paramToServiceMsg = paramFromServiceMsg;
          if (localQSecCbResp.str_cbstr != null)
          {
            paramToServiceMsg = paramFromServiceMsg;
            if (localQSecCbResp.str_cbstr.has()) {
              paramToServiceMsg = localQSecCbResp.str_cbstr.get();
            }
          }
          if ((paramToServiceMsg != null) && (!paramToServiceMsg.equals("")))
          {
            asyv.a(this.this$0, paramToServiceMsg);
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyw
 * JD-Core Version:    0.7.0.1
 */