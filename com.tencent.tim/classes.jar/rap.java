import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMonitorValue;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMonitorValue;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class rap
  extends ppw
{
  private int ID;
  public String msg;
  private int value;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspMonitorValue localRspMonitorValue = new qqstory_service.RspMonitorValue();
    try
    {
      localRspMonitorValue.mergeFrom(paramArrayOfByte);
      return new raq(localRspMonitorValue);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    return null;
  }
  
  public void dY(int paramInt1, int paramInt2)
  {
    this.ID = paramInt1;
    this.value = paramInt2;
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqMonitorValue localReqMonitorValue = new qqstory_service.ReqMonitorValue();
    localReqMonitorValue.ID.set(this.ID);
    if (this.value > 0) {
      localReqMonitorValue.Value.set(this.value);
    }
    for (;;)
    {
      if (this.msg != null) {
        localReqMonitorValue.errmsg.set(ByteStringMicro.copyFromUtf8(this.msg));
      }
      return localReqMonitorValue.toByteArray();
      localReqMonitorValue.Value.set(1);
    }
  }
  
  public String mg()
  {
    return ppf.fQ("StoryMonitorSvc.client_monitor_report");
  }
  
  public String toString()
  {
    return "MonitorValueRequest{ID=" + this.ID + ", value=" + this.value + ", msg=" + this.msg + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rap
 * JD-Core Version:    0.7.0.1
 */