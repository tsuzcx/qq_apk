import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqWatchVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pzv
  extends ppw<qbb>
{
  public static final String CMD = ppf.fQ("StorySvc.video_watch_no_expired");
  public String awq;
  public int bkb;
  public boolean isLiveVideo;
  public long mCreateTime;
  public int mSource;
  public String vid;
  
  public qbb a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspWatchVideo localRspWatchVideo = new qqstory_service.RspWatchVideo();
    try
    {
      localRspWatchVideo.mergeFrom(paramArrayOfByte);
      return new qbb(localRspWatchVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqWatchVideo localReqWatchVideo = new qqstory_service.ReqWatchVideo();
    localReqWatchVideo.vid.set(ByteStringMicro.copyFromUtf8(this.vid));
    localReqWatchVideo.to_union_id.set(ByteStringMicro.copyFromUtf8(fR(this.awq)));
    PBUInt32Field localPBUInt32Field = localReqWatchVideo.is_live_video;
    if (this.isLiveVideo) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localReqWatchVideo.source.set(this.mSource);
      if (this.mCreateTime > 0L) {
        localReqWatchVideo.create_time.set(this.mCreateTime / 1000L);
      }
      if (this.bkb > 0) {
        localReqWatchVideo.vid_type.set(this.bkb);
      }
      return localReqWatchVideo.toByteArray();
    }
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public String toString()
  {
    return "WatchVideoRequest{vid='" + this.vid + '\'' + ", videoUid=" + this.awq + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzv
 * JD-Core Version:    0.7.0.1
 */