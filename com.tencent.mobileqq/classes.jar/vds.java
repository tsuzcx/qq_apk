import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class vds
  extends unf
{
  public int b;
  
  public vds(qqstory_service.RspWatchVideo paramRspWatchVideo)
  {
    super(paramRspWatchVideo.result);
    this.b = paramRspWatchVideo.unread_count.get();
  }
  
  public String toString()
  {
    return "WatchVideoResponse{unReadCount=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vds
 * JD-Core Version:    0.7.0.1
 */