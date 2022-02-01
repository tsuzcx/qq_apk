import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedLikeList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wha
  extends whu
{
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  
  public wha(wgz paramwgz, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String a()
  {
    return wgz.jdField_a_of_type_JavaLangString;
  }
  
  public whv a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedLikeList localRspFeedLikeList = new qqstory_service.RspFeedLikeList();
    try
    {
      localRspFeedLikeList.mergeFrom(paramArrayOfByte);
      return new whb(this.jdField_a_of_type_Wgz, localRspFeedLikeList, this.jdField_a_of_type_Boolean);
    }
    catch (Exception paramArrayOfByte)
    {
      ykq.d("Q.qqstory:FeedLikeDataProvider", "" + paramArrayOfByte);
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
      return localReqFeedLikeList.toByteArray();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wha
 * JD-Core Version:    0.7.0.1
 */