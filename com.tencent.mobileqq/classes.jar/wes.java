import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGroupDateVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGroupDateVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class wes
  extends vqr
{
  public String a;
  public long b;
  public String b;
  public int c;
  private final String c;
  public int d;
  public int e;
  public int f;
  
  public wes()
  {
    this.jdField_c_of_type_JavaLangString = vpl.a("StoryGroupSvc.datacard_get_feeds_new");
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public vqm a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGroupDateVideoList localRspGroupDateVideoList = new qqstory_service.RspGroupDateVideoList();
    try
    {
      localRspGroupDateVideoList.mergeFrom(paramArrayOfByte);
      return new wgi(this.a, localRspGroupDateVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      xvv.b("Q.qqstory.shareGroup:GetShareGroupDateListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGroupDateVideoList localReqGroupDateVideoList = new qqstory_service.ReqGroupDateVideoList();
    localReqGroupDateVideoList.from.set(this.e);
    localReqGroupDateVideoList.group_unionid.set(ByteStringMicro.copyFromUtf8(this.a));
    localReqGroupDateVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    localReqGroupDateVideoList.date_count.set(this.jdField_c_of_type_Int);
    localReqGroupDateVideoList.video_count.set(this.d);
    localReqGroupDateVideoList.seqno.set(this.jdField_b_of_type_Long);
    if (this.f != -1) {
      localReqGroupDateVideoList.time_zone.set(this.f);
    }
    return localReqGroupDateVideoList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wes
 * JD-Core Version:    0.7.0.1
 */