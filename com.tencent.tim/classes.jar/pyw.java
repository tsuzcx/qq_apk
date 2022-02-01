import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFriendStoryFeedVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFriendStoryFeedVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class pyw
  extends ppw<qah>
{
  public String avV = "";
  public int bls;
  public String feedId = "";
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFriendStoryFeedVideoList localRspFriendStoryFeedVideoList = new qqstory_service.RspFriendStoryFeedVideoList();
    try
    {
      localRspFriendStoryFeedVideoList.mergeFrom(paramArrayOfByte);
      return new qah(localRspFriendStoryFeedVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      ram.w("Q.qqstory:GetFeedVideoListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqFriendStoryFeedVideoList localReqFriendStoryFeedVideoList = new qqstory_service.ReqFriendStoryFeedVideoList();
    if (!TextUtils.isEmpty(this.avV)) {
      localReqFriendStoryFeedVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.avV));
    }
    if (!TextUtils.isEmpty(this.feedId)) {
      localReqFriendStoryFeedVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(this.feedId));
    }
    localReqFriendStoryFeedVideoList.pull_type.set(this.bls);
    return localReqFriendStoryFeedVideoList.toByteArray();
  }
  
  public String mg()
  {
    return ppf.fQ("StorySvc.homepage_feed_loadmore_720");
  }
  
  public String toString()
  {
    return "GetFeedVideoListRequest{, feedId='" + this.feedId + '\'' + ", startCookie='" + this.avV + '\'' + ", pullType=" + this.bls + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyw
 * JD-Core Version:    0.7.0.1
 */