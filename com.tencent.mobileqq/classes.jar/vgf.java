import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGroupStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupStoryFeedIdList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;

public class vgf
  extends urt
{
  public String a;
  
  public String a()
  {
    return uqn.a("StoryGroupSvc.get_dynamic_group_feedid_list");
  }
  
  public uro a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspGroupStoryFeedIdList localRspGroupStoryFeedIdList = new qqstory_group.RspGroupStoryFeedIdList();
    try
    {
      localRspGroupStoryFeedIdList.mergeFrom(paramArrayOfByte);
      return new vgg(localRspGroupStoryFeedIdList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  protected byte[] a()
  {
    qqstory_group.ReqGroupStoryFeedIdList localReqGroupStoryFeedIdList = new qqstory_group.ReqGroupStoryFeedIdList();
    localReqGroupStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    return localReqGroupStoryFeedIdList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgf
 * JD-Core Version:    0.7.0.1
 */