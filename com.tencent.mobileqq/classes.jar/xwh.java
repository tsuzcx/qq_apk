import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class xwh
  extends wfm<wuz>
{
  public String a;
  public boolean a;
  public int c = -1;
  
  public String a()
  {
    return weg.a("StorySvc.feed_like_list_715");
  }
  
  public wfh a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedLikeList localRspFeedLikeList = new qqstory_service.RspFeedLikeList();
    try
    {
      localRspFeedLikeList.mergeFrom(paramArrayOfByte);
      return new xwi(localRspFeedLikeList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ykq.d("Q.qqstory:GetLikeListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqFeedLikeList localReqFeedLikeList = new qqstory_service.ReqFeedLikeList();
    localReqFeedLikeList.feed_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2;; i = 1)
    {
      localReqFeedLikeList.source.set(i);
      if (this.c != -1) {
        localReqFeedLikeList.type.set(this.c);
      }
      return localReqFeedLikeList.toByteArray();
    }
  }
  
  public String toString()
  {
    return "GetLikeListRequest{, feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", isOpen=" + this.jdField_a_of_type_Boolean + ", type=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xwh
 * JD-Core Version:    0.7.0.1
 */