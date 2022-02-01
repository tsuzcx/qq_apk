import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBlackList;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class qab
  extends ppu
{
  public int blA;
  public int blB;
  
  public qab(qqstory_service.RspGetBlackList paramRspGetBlackList)
  {
    super(paramRspGetBlackList.result);
    this.blA = paramRspGetBlackList.black_status.get();
    this.blB = paramRspGetBlackList.update_interval.get();
  }
  
  public String toString()
  {
    return "GetBlackListStatusResponse{blackStatus=" + this.blA + ", updateInterval=" + this.blB + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qab
 * JD-Core Version:    0.7.0.1
 */