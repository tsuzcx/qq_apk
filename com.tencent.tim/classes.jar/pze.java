import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqShareVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspShareVideoCollectionList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class pze
  extends ppw<qan>
{
  public String avV = "";
  public int blr;
  public int collectionCount;
  public long seqno;
  public String unionId;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspShareVideoCollectionList localRspShareVideoCollectionList = new qqstory_service.RspShareVideoCollectionList();
    try
    {
      localRspShareVideoCollectionList.mergeFrom(paramArrayOfByte);
      return new qan(this.unionId, localRspShareVideoCollectionList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory:GetShareGroupListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqShareVideoCollectionList localReqShareVideoCollectionList = new qqstory_service.ReqShareVideoCollectionList();
    if (!TextUtils.isEmpty(this.avV)) {
      localReqShareVideoCollectionList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.avV));
    }
    if (!TextUtils.isEmpty(this.unionId)) {
      localReqShareVideoCollectionList.union_id.set(ByteStringMicro.copyFromUtf8(this.unionId));
    }
    localReqShareVideoCollectionList.collection_count.set(this.collectionCount);
    localReqShareVideoCollectionList.collection_video_count.set(this.blr);
    localReqShareVideoCollectionList.seqno.set(this.seqno);
    return localReqShareVideoCollectionList.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StorySvc.get_share_group_collection_list");
  }
  
  public String toString()
  {
    return "GetShareGroupListRequest{startCookie='" + this.avV + '\'' + ", collectionCount=" + this.collectionCount + ", collectionVideoCount=" + this.blr + ", seqno=" + this.seqno + ", unionId='" + this.unionId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pze
 * JD-Core Version:    0.7.0.1
 */