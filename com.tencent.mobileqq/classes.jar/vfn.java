import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFriendStoryFeedVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFriendStoryFeedVideoList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class vfn
  extends urt<vhh>
{
  public String a = "";
  public String b = "";
  public int c;
  
  public String a()
  {
    return uqn.a("StorySvc.homepage_feed_loadmore_720");
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFriendStoryFeedVideoList localRspFriendStoryFeedVideoList = new qqstory_service.RspFriendStoryFeedVideoList();
    try
    {
      localRspFriendStoryFeedVideoList.mergeFrom(paramArrayOfByte);
      return new vhh(localRspFriendStoryFeedVideoList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      wxe.d("Q.qqstory:GetFeedVideoListRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqFriendStoryFeedVideoList localReqFriendStoryFeedVideoList = new qqstory_service.ReqFriendStoryFeedVideoList();
    if (!TextUtils.isEmpty(this.a)) {
      localReqFriendStoryFeedVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localReqFriendStoryFeedVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    localReqFriendStoryFeedVideoList.pull_type.set(this.c);
    return localReqFriendStoryFeedVideoList.toByteArray();
  }
  
  public String toString()
  {
    return "GetFeedVideoListRequest{, feedId='" + this.b + '\'' + ", startCookie='" + this.a + '\'' + ", pullType=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfn
 * JD-Core Version:    0.7.0.1
 */