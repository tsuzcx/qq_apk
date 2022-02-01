import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupHotRankVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class wzy
  extends wri
{
  boolean jdField_a_of_type_Boolean = false;
  
  public wzy(wzx paramwzx, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String a()
  {
    return wnu.a("StoryGroupSvc.get_hot_rank_video_list");
  }
  
  public wrj a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspGetGroupHotRankVideo localRspGetGroupHotRankVideo = new qqstory_group.RspGetGroupHotRankVideo();
    try
    {
      localRspGetGroupHotRankVideo.mergeFrom(paramArrayOfByte);
      return new wzz(this.jdField_a_of_type_Wzx, localRspGetGroupHotRankVideo, this.jdField_a_of_type_Boolean);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yuk.d("GetHotSortVideoHandler", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_group.ReqGetGroupHotRankVideo localReqGetGroupHotRankVideo = new qqstory_group.ReqGetGroupHotRankVideo();
    localReqGetGroupHotRankVideo.union_id.set(ByteStringMicro.copyFromUtf8(wzx.a(this.jdField_a_of_type_Wzx)));
    localReqGetGroupHotRankVideo.size.set(10);
    if (this.jdField_a_of_type_Boolean)
    {
      localReqGetGroupHotRankVideo.seq.set(wzx.a(this.jdField_a_of_type_Wzx));
      if (!TextUtils.isEmpty(wzx.b(this.jdField_a_of_type_Wzx))) {
        localReqGetGroupHotRankVideo.start_cookie.set(ByteStringMicro.copyFromUtf8(wzx.b(this.jdField_a_of_type_Wzx)));
      }
    }
    return localReqGetGroupHotRankVideo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzy
 * JD-Core Version:    0.7.0.1
 */