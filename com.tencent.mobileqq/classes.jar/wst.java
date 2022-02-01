import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wst
  extends wla
{
  public long a;
  public int b;
  
  public wst(qqstory_service.RspCheckActivity paramRspCheckActivity)
  {
    super(paramRspCheckActivity.result);
    this.b = paramRspCheckActivity.is_activity.get();
    this.a = paramRspCheckActivity.next_check_time.get();
  }
  
  public String toString()
  {
    return "MsgTabCheckActiveResponse{active=" + this.b + ", nextCheckTime=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wst
 * JD-Core Version:    0.7.0.1
 */