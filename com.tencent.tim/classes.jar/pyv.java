import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeedTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBaseList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pyv
  extends ppw<pyv.b>
{
  public List<String> np = new ArrayList();
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeedTagInfo localRspStoryFeedTagInfo = new qqstory_service.RspStoryFeedTagInfo();
    try
    {
      localRspStoryFeedTagInfo.mergeFrom(paramArrayOfByte);
      return new pyv.b(localRspStoryFeedTagInfo);
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
    throws QQStoryCmdHandler.IllegalUinException
  {
    qqstory_service.ReqStoryFeedTagInfo localReqStoryFeedTagInfo = new qqstory_service.ReqStoryFeedTagInfo();
    Iterator localIterator = this.np.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqStoryFeedTagInfo.feed_id_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    return localReqStoryFeedTagInfo.toByteArray();
  }
  
  public String mg()
  {
    return "StorySvc.homepage_batch_feeds_label";
  }
  
  public static class a
  {
    public String feedId;
    public List<rmw.a> nq = new ArrayList();
  }
  
  public static class b
    extends ppu
  {
    public List<pyv.a> nr = new ArrayList();
    
    public b(qqstory_service.RspStoryFeedTagInfo paramRspStoryFeedTagInfo)
    {
      paramRspStoryFeedTagInfo = paramRspStoryFeedTagInfo.tag_info.get();
      if (paramRspStoryFeedTagInfo != null)
      {
        paramRspStoryFeedTagInfo = paramRspStoryFeedTagInfo.iterator();
        while (paramRspStoryFeedTagInfo.hasNext())
        {
          Object localObject = (qqstory_struct.TagInfoBaseList)paramRspStoryFeedTagInfo.next();
          pyv.a locala = new pyv.a();
          locala.feedId = ((qqstory_struct.TagInfoBaseList)localObject).feed_id.get().toStringUtf8();
          localObject = ((qqstory_struct.TagInfoBaseList)localObject).tag_info_list.get();
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              rmw.a locala1 = new rmw.a((qqstory_struct.TagInfoBase)((Iterator)localObject).next());
              locala.nq.add(locala1);
            }
          }
          this.nr.add(locala);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyv
 * JD-Core Version:    0.7.0.1
 */