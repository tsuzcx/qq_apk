import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

public class wcu
  extends wla
{
  public List<qqstory_struct.GpsMsg> a;
  
  public wcu(qqstory_service.RspCheckBlackList paramRspCheckBlackList)
  {
    super(paramRspCheckBlackList.result);
    this.a = paramRspCheckBlackList.black_gps_list.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcu
 * JD-Core Version:    0.7.0.1
 */