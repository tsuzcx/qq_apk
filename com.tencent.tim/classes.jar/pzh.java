import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pzh
  extends ppw
{
  public static final String CMD = ppf.fQ("StorySvc.homepage_batch_feeds_720");
  public pua b;
  public String cookie;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeedIdList localRspStoryFeedIdList = new qqstory_service.RspStoryFeedIdList();
    try
    {
      localRspStoryFeedIdList.mergeFrom(paramArrayOfByte);
      return new pzh.a(localRspStoryFeedIdList);
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
    qqstory_service.ReqStoryFeedIdList localReqStoryFeedIdList = new qqstory_service.ReqStoryFeedIdList();
    localReqStoryFeedIdList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.cookie));
    if (this.b != null)
    {
      localReqStoryFeedIdList.coordinate.set(this.b.mType);
      localReqStoryFeedIdList.gps.setHasFlag(true);
      localReqStoryFeedIdList.gps.lat.set(this.b.mLatitude);
      localReqStoryFeedIdList.gps.lng.set(this.b.mLongitude);
    }
    localReqStoryFeedIdList.client_version.set(6);
    return localReqStoryFeedIdList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public static class a
    extends ppt
  {
    public boolean aCG;
    public List<qvd> nk = new ArrayList();
    
    public a(qqstory_service.RspStoryFeedIdList paramRspStoryFeedIdList)
    {
      super(paramRspStoryFeedIdList.is_end, paramRspStoryFeedIdList.next_cookie);
      if (paramRspStoryFeedIdList.is_today_end.get() == 1) {}
      for (;;)
      {
        this.aCG = bool;
        paramRspStoryFeedIdList = paramRspStoryFeedIdList.feed_seq_info_list.get().iterator();
        while (paramRspStoryFeedIdList.hasNext())
        {
          qvd localqvd = new qvd((qqstory_struct.FeedSeqInfo)paramRspStoryFeedIdList.next());
          this.nk.add(localqvd);
        }
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pzh
 * JD-Core Version:    0.7.0.1
 */