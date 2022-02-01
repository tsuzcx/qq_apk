import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

public class vxp
  extends wfh
{
  public List<qqstory_struct.GpsMsg> a;
  
  public vxp(qqstory_service.RspCheckBlackList paramRspCheckBlackList)
  {
    super(paramRspCheckBlackList.result);
    this.a = paramRspCheckBlackList.black_gps_list.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxp
 * JD-Core Version:    0.7.0.1
 */