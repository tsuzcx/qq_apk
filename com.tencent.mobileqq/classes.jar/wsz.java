import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMonitorValue;

public class wsz
  extends unf
{
  public wsz(qqstory_service.RspMonitorValue paramRspMonitorValue)
  {
    super(paramRspMonitorValue.result);
  }
  
  public String toString()
  {
    return "MonitorValueResponse{errorCode=" + this.a + ", errorMsg='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsz
 * JD-Core Version:    0.7.0.1
 */