import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqTranslateToken;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspTranslateToken;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class wfl
  extends vqr
{
  public static final String a = vpl.a("StorySvc.translate_share_parameters_to_token");
  public String b;
  public int c;
  public String c;
  
  public String a()
  {
    return a;
  }
  
  public vqm a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspTranslateToken localRspTranslateToken = new qqstory_service.RspTranslateToken();
    try
    {
      localRspTranslateToken.mergeFrom(paramArrayOfByte);
      return new wfm(localRspTranslateToken);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share.trans.req", 2, "decode failed", paramArrayOfByte);
        }
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqTranslateToken localReqTranslateToken = new qqstory_service.ReqTranslateToken();
    localReqTranslateToken.src_buffer.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqTranslateToken.type.set(this.jdField_c_of_type_Int);
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_c_of_type_JavaLangString != null)) {
      localReqTranslateToken.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    }
    return localReqTranslateToken.toByteArray();
  }
  
  public String toString()
  {
    return "StoryShareTranslateTokenRequest{feedId='" + this.jdField_c_of_type_JavaLangString + '\'' + ", srcBuffer='" + this.b + '\'' + ", type=" + this.jdField_c_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfl
 * JD-Core Version:    0.7.0.1
 */