import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideoBatch;
import com.tencent.biz.qqstory.network.pb.qqstory_service.VideoItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;

public class pzu
  extends ppw<qba>
{
  public static final String CMD = ppf.fQ("StorySvc.video_watch_batch");
  public ArrayList<psq.a> mS = new ArrayList();
  public int mSeq;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspWatchVideoBatch localRspWatchVideoBatch = new qqstory_service.RspWatchVideoBatch();
    try
    {
      localRspWatchVideoBatch.mergeFrom(paramArrayOfByte);
      return new qba(localRspWatchVideoBatch);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        ram.w("Q.qqstory:WatchVideoBatchRequest", paramArrayOfByte.toString());
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqWatchVideoBatch localReqWatchVideoBatch = new qqstory_service.ReqWatchVideoBatch();
    Iterator localIterator = this.mS.iterator();
    if (localIterator.hasNext())
    {
      psq.a locala = (psq.a)localIterator.next();
      qqstory_service.VideoItem localVideoItem = new qqstory_service.VideoItem();
      localVideoItem.vid.set(ByteStringMicro.copyFromUtf8(locala.mVid));
      Object localObject = fR(locala.auQ);
      localVideoItem.to_union_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = localVideoItem.is_live_video;
      if (locala.aBx) {}
      for (int i = 1;; i = 0)
      {
        ((PBUInt32Field)localObject).set(i);
        localVideoItem.create_time.set(locala.mCreateTime / 1000L);
        localVideoItem.source.set(locala.mSource);
        localReqWatchVideoBatch.video_list.add(localVideoItem);
        break;
      }
    }
    return localReqWatchVideoBatch.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "WatchVideoBatchRequest{seq=" + this.mSeq + "mVideoList=" + this.mS + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzu
 * JD-Core Version:    0.7.0.1
 */