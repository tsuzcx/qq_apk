import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedCommentList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class vfh
  extends urt
{
  public static final String a;
  public wop a;
  
  static
  {
    jdField_a_of_type_JavaLangString = uqn.a("StorySvc.feed_comment_list_775");
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedCommentList localRspFeedCommentList = new qqstory_service.RspFeedCommentList();
    try
    {
      localRspFeedCommentList.mergeFrom(paramArrayOfByte);
      return new vfi(localRspFeedCommentList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqFeedCommentList localReqFeedCommentList = new qqstory_service.ReqFeedCommentList();
    localReqFeedCommentList.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Wop.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Wop.jdField_b_of_type_JavaLangString == null) {
      this.jdField_a_of_type_Wop.jdField_b_of_type_JavaLangString = "";
    }
    localReqFeedCommentList.cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Wop.jdField_b_of_type_JavaLangString));
    localReqFeedCommentList.source.set(this.jdField_a_of_type_Wop.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Wop.jdField_b_of_type_Int != -1) {
      localReqFeedCommentList.type.set(this.jdField_a_of_type_Wop.jdField_b_of_type_Int);
    }
    return localReqFeedCommentList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfh
 * JD-Core Version:    0.7.0.1
 */