import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupHotRankVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class tjq
  extends tba
{
  boolean jdField_a_of_type_Boolean = false;
  
  public tjq(tjp paramtjp, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String a()
  {
    return sxm.a("StoryGroupSvc.get_hot_rank_video_list");
  }
  
  public tbb a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspGetGroupHotRankVideo localRspGetGroupHotRankVideo = new qqstory_group.RspGetGroupHotRankVideo();
    try
    {
      localRspGetGroupHotRankVideo.mergeFrom(paramArrayOfByte);
      return new tjr(this.jdField_a_of_type_Tjp, localRspGetGroupHotRankVideo, this.jdField_a_of_type_Boolean);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ved.d("GetHotSortVideoHandler", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_group.ReqGetGroupHotRankVideo localReqGetGroupHotRankVideo = new qqstory_group.ReqGetGroupHotRankVideo();
    localReqGetGroupHotRankVideo.union_id.set(ByteStringMicro.copyFromUtf8(tjp.a(this.jdField_a_of_type_Tjp)));
    localReqGetGroupHotRankVideo.size.set(10);
    if (this.jdField_a_of_type_Boolean)
    {
      localReqGetGroupHotRankVideo.seq.set(tjp.a(this.jdField_a_of_type_Tjp));
      if (!TextUtils.isEmpty(tjp.b(this.jdField_a_of_type_Tjp))) {
        localReqGetGroupHotRankVideo.start_cookie.set(ByteStringMicro.copyFromUtf8(tjp.b(this.jdField_a_of_type_Tjp)));
      }
    }
    return localReqGetGroupHotRankVideo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjq
 * JD-Core Version:    0.7.0.1
 */