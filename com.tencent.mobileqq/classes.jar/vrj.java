import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCommentList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class vrj
  extends vsz
{
  int jdField_a_of_type_Int;
  public final String a;
  String b;
  
  public vrj(vrd paramvrd, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = vpl.a("StorySvc.get_comment_list");
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public vta a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetCommentList localRspGetCommentList = new qqstory_service.RspGetCommentList();
    try
    {
      localRspGetCommentList.mergeFrom(paramArrayOfByte);
      return new vrk(this.jdField_a_of_type_Vrd, localRspGetCommentList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      xvv.d("Q.qqstory:GetCommentListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetCommentList localReqGetCommentList = new qqstory_service.ReqGetCommentList();
    localReqGetCommentList.vid.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqGetCommentList.latest_comment_id.set(this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory:GetCommentListRequest", 2, "getCommentListData by latest_comment_id: " + this.jdField_a_of_type_Int);
    }
    return localReqGetCommentList.toByteArray();
  }
  
  public String toString()
  {
    return "GetCommentListRequest{ vid=" + this.b + ", startCommentID=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrj
 * JD-Core Version:    0.7.0.1
 */