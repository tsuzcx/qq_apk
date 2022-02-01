import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqShareVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspShareVideoCollectionList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class xde
  extends wpa<xeu>
{
  public String a = "";
  public long b;
  public String b;
  public int c;
  public int d;
  
  public String a()
  {
    return wnu.a("StorySvc.get_share_group_collection_list");
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspShareVideoCollectionList localRspShareVideoCollectionList = new qqstory_service.RspShareVideoCollectionList();
    try
    {
      localRspShareVideoCollectionList.mergeFrom(paramArrayOfByte);
      return new xeu(this.jdField_b_of_type_JavaLangString, localRspShareVideoCollectionList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      yuk.d("Q.qqstory:GetShareGroupListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqShareVideoCollectionList localReqShareVideoCollectionList = new qqstory_service.ReqShareVideoCollectionList();
    if (!TextUtils.isEmpty(this.a)) {
      localReqShareVideoCollectionList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localReqShareVideoCollectionList.union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    localReqShareVideoCollectionList.collection_count.set(this.c);
    localReqShareVideoCollectionList.collection_video_count.set(this.d);
    localReqShareVideoCollectionList.seqno.set(this.jdField_b_of_type_Long);
    return localReqShareVideoCollectionList.toByteArray();
  }
  
  public String toString()
  {
    return "GetShareGroupListRequest{startCookie='" + this.a + '\'' + ", collectionCount=" + this.c + ", collectionVideoCount=" + this.d + ", seqno=" + this.jdField_b_of_type_Long + ", unionId='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xde
 * JD-Core Version:    0.7.0.1
 */