import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBlackList;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class xeh
  extends wov
{
  public int b;
  public int c;
  
  public xeh(qqstory_service.RspGetBlackList paramRspGetBlackList)
  {
    super(paramRspGetBlackList.result);
    this.b = paramRspGetBlackList.black_status.get();
    this.c = paramRspGetBlackList.update_interval.get();
  }
  
  public String toString()
  {
    return "GetBlackListStatusResponse{blackStatus=" + this.b + ", updateInterval=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xeh
 * JD-Core Version:    0.7.0.1
 */