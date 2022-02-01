import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetCollectionVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCollectionVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class pyp
  extends ppw
{
  public static final String avS = ppf.fQ("StorySvc.new_get_date_share_list");
  public static final String avT = ppf.fQ("StorySvc.get_share_video_info_list");
  public String avU;
  public String avV = "";
  public int bln = -1;
  public int blp;
  public int count;
  public String feedId;
  public int identify;
  public int videoListOrder;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetCollectionVideoList localRspGetCollectionVideoList = new qqstory_service.RspGetCollectionVideoList();
    try
    {
      localRspGetCollectionVideoList.mergeFrom(paramArrayOfByte);
      return new qac(this.avU, localRspGetCollectionVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] encode()
  {
    qqstory_service.ReqGetCollectionVideoList localReqGetCollectionVideoList = new qqstory_service.ReqGetCollectionVideoList();
    localReqGetCollectionVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.avV));
    localReqGetCollectionVideoList.count.set(this.count);
    if (this.feedId == null)
    {
      localReqGetCollectionVideoList.collection_id.set(this.bln);
      if (this.blp != -1) {
        localReqGetCollectionVideoList.time_zone.set(this.blp);
      }
    }
    for (;;)
    {
      rom.checkNotNull(this.avU);
      localReqGetCollectionVideoList.union_id.set(ByteStringMicro.copyFromUtf8(this.avU));
      localReqGetCollectionVideoList.video_dir.set(this.videoListOrder);
      return localReqGetCollectionVideoList.toByteArray();
      localReqGetCollectionVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedId));
      localReqGetCollectionVideoList.identify.set(this.identify);
    }
  }
  
  public String mg()
  {
    if (this.feedId == null) {
      return avS;
    }
    return avT;
  }
  
  public String toString()
  {
    return super.toString() + " GetCollectionVideoListRequest{targetUid=" + this.avU + ", startCookie='" + this.avV + ", count=" + this.count + ", collectionId=" + this.bln + ", timeZoneOffset=" + this.blp + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyp
 * JD-Core Version:    0.7.0.1
 */