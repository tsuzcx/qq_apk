import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryPlayerTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryPlayerTagInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;

public class pzi
  extends ppw<qaq>
{
  public final List<String> mVidList;
  
  public pzi(List<String> paramList)
  {
    this.mVidList = paramList;
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryPlayerTagInfo localRspStoryPlayerTagInfo = new qqstory_service.RspStoryPlayerTagInfo();
    try
    {
      localRspStoryPlayerTagInfo.mergeFrom(paramArrayOfByte);
      return new qaq(localRspStoryPlayerTagInfo);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        ram.e("Q.qqstory.net:GetStoryPlayerTagInfoRequest", paramArrayOfByte.toString());
      }
    }
  }
  
  protected byte[] encode()
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqStoryPlayerTagInfo localReqStoryPlayerTagInfo = new qqstory_service.ReqStoryPlayerTagInfo();
    Iterator localIterator = this.mVidList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqStoryPlayerTagInfo.vid_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    localReqStoryPlayerTagInfo.client.set(2);
    localReqStoryPlayerTagInfo.version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
    return localReqStoryPlayerTagInfo.toByteArray();
  }
  
  public String mg()
  {
    return "StorySvc.get_video_tag_778";
  }
  
  public static class a
  {
    public final rmq a;
    public final rmw.a a;
    public final String avW;
    public final String vid;
    
    public a(String paramString1, rmw.a parama, rmq paramrmq, String paramString2)
    {
      this.vid = paramString1;
      this.jdField_a_of_type_Rmw$a = parama;
      this.jdField_a_of_type_Rmq = paramrmq;
      this.avW = paramString2;
    }
    
    public String toString()
    {
      return "TagInfoBaseVidList{vid='" + this.vid + '\'' + ", tagInfo=" + this.jdField_a_of_type_Rmw$a + ", comInfo=" + this.jdField_a_of_type_Rmq + ", extCfgInfo=" + this.avW + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzi
 * JD-Core Version:    0.7.0.1
 */