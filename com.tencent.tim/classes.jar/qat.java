import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFeedVisitor;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserSimpleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;

public class qat
  extends ppu
{
  public long AE;
  public long AF;
  public List<qqstory_struct.UserSimpleInfo> nE;
  
  public qat(String paramString, qqstory_service.RspGetFeedVisitor paramRspGetFeedVisitor)
  {
    super(paramRspGetFeedVisitor.result);
    this.AF = paramRspGetFeedVisitor.view_total_num.get();
    this.nE = paramRspGetFeedVisitor.user_list.get();
    this.AE = this.nE.size();
  }
  
  public String toString()
  {
    return "GetVideoWatcherListResponse{totalReadTime=" + this.AF + "totalWatcherCount=" + this.AE + ", userList=" + this.nE + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qat
 * JD-Core Version:    0.7.0.1
 */