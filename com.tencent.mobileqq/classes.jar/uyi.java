import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupHotRankVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class uyi
  extends ups
{
  boolean jdField_a_of_type_Boolean = false;
  
  public uyi(uyh paramuyh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String a()
  {
    return ume.a("StoryGroupSvc.get_hot_rank_video_list");
  }
  
  public upt a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspGetGroupHotRankVideo localRspGetGroupHotRankVideo = new qqstory_group.RspGetGroupHotRankVideo();
    try
    {
      localRspGetGroupHotRankVideo.mergeFrom(paramArrayOfByte);
      return new uyj(this.jdField_a_of_type_Uyh, localRspGetGroupHotRankVideo, this.jdField_a_of_type_Boolean);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wsv.d("GetHotSortVideoHandler", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_group.ReqGetGroupHotRankVideo localReqGetGroupHotRankVideo = new qqstory_group.ReqGetGroupHotRankVideo();
    localReqGetGroupHotRankVideo.union_id.set(ByteStringMicro.copyFromUtf8(uyh.a(this.jdField_a_of_type_Uyh)));
    localReqGetGroupHotRankVideo.size.set(10);
    if (this.jdField_a_of_type_Boolean)
    {
      localReqGetGroupHotRankVideo.seq.set(uyh.a(this.jdField_a_of_type_Uyh));
      if (!TextUtils.isEmpty(uyh.b(this.jdField_a_of_type_Uyh))) {
        localReqGetGroupHotRankVideo.start_cookie.set(ByteStringMicro.copyFromUtf8(uyh.b(this.jdField_a_of_type_Uyh)));
      }
    }
    return localReqGetGroupHotRankVideo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uyi
 * JD-Core Version:    0.7.0.1
 */