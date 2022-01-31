import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDateCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDateVideoCollectionList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class vfe
  extends urt
{
  public String a;
  public boolean a;
  public long b;
  public String b;
  public int c;
  public int d;
  public int e;
  
  public vfe()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public String a()
  {
    if (QQStoryContext.a().a(this.jdField_b_of_type_JavaLangString)) {
      return uqn.a("StorySvc.get_date_collection_list");
    }
    return uqn.a("StorySvc.get_others_video_list");
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDateVideoCollectionList localRspDateVideoCollectionList = new qqstory_service.RspDateVideoCollectionList();
    try
    {
      localRspDateVideoCollectionList.mergeFrom(paramArrayOfByte);
      return new vhc(this.jdField_b_of_type_JavaLangString, localRspDateVideoCollectionList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wxe.b("Q.qqstory.memories:GetDateCollectionListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqDateCollectionList localReqDateCollectionList = new qqstory_service.ReqDateCollectionList();
    localReqDateCollectionList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqDateCollectionList.collection_count.set(this.c);
    localReqDateCollectionList.collection_video_count.set(this.d);
    localReqDateCollectionList.seqno.set(this.jdField_b_of_type_Long);
    PBInt32Field localPBInt32Field = localReqDateCollectionList.is_friend;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localPBInt32Field.set(i);
      if (this.e != -1) {
        localReqDateCollectionList.time_zone.set(this.e);
      }
      localReqDateCollectionList.union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
      return localReqDateCollectionList.toByteArray();
    }
  }
  
  public String toString()
  {
    return "GetDateCollectionListRequest{startCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", collectionPageSize=" + this.c + ", collectionVideoCount=" + this.d + ", seq=" + this.jdField_b_of_type_Long + ", timeZoneOffset=" + this.e + ", uin=" + this.jdField_b_of_type_JavaLangString + ", isFriend=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfe
 * JD-Core Version:    0.7.0.1
 */