import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.VideoItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qba
  extends ppu
{
  public List<psq.a> nI = new ArrayList();
  
  public qba(qqstory_service.RspWatchVideoBatch paramRspWatchVideoBatch)
  {
    super(paramRspWatchVideoBatch.result);
    paramRspWatchVideoBatch = paramRspWatchVideoBatch.succ_video_list.get();
    if (paramRspWatchVideoBatch == null) {}
    for (;;)
    {
      return;
      paramRspWatchVideoBatch = paramRspWatchVideoBatch.iterator();
      while (paramRspWatchVideoBatch.hasNext())
      {
        qqstory_service.VideoItem localVideoItem = (qqstory_service.VideoItem)paramRspWatchVideoBatch.next();
        psq.a locala = new psq.a();
        locala.mVid = localVideoItem.vid.get().toStringUtf8();
        this.nI.add(locala);
      }
    }
  }
  
  public String toString()
  {
    return "WatchVideoBatchResponse{ errorCode=" + this.errorCode + " succList=" + this.nI + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qba
 * JD-Core Version:    0.7.0.1
 */