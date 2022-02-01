import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqWatchVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspWatchVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class xae
  extends wlf<xbn>
{
  public static final String a;
  public boolean a;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = wjz.a("StorySvc.video_watch_no_expired");
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public xbn a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspWatchVideo localRspWatchVideo = new qqstory_service.RspWatchVideo();
    try
    {
      localRspWatchVideo.mergeFrom(paramArrayOfByte);
      return new xbn(localRspWatchVideo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqWatchVideo localReqWatchVideo = new qqstory_service.ReqWatchVideo();
    localReqWatchVideo.vid.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    localReqWatchVideo.to_union_id.set(ByteStringMicro.copyFromUtf8(a(this.jdField_c_of_type_JavaLangString)));
    PBUInt32Field localPBUInt32Field = localReqWatchVideo.is_live_video;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      localReqWatchVideo.source.set(this.jdField_c_of_type_Int);
      if (this.jdField_b_of_type_Long > 0L) {
        localReqWatchVideo.create_time.set(this.jdField_b_of_type_Long / 1000L);
      }
      if (this.d > 0) {
        localReqWatchVideo.vid_type.set(this.d);
      }
      return localReqWatchVideo.toByteArray();
    }
  }
  
  public String toString()
  {
    return "WatchVideoRequest{vid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", videoUid=" + this.jdField_c_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xae
 * JD-Core Version:    0.7.0.1
 */