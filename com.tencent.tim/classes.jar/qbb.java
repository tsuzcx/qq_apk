import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class qbb
  extends ppu
{
  public int unReadCount;
  
  public qbb(qqstory_service.RspWatchVideo paramRspWatchVideo)
  {
    super(paramRspWatchVideo.result);
    this.unReadCount = paramRspWatchVideo.unread_count.get();
  }
  
  public String toString()
  {
    return "WatchVideoResponse{unReadCount=" + this.unReadCount + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbb
 * JD-Core Version:    0.7.0.1
 */