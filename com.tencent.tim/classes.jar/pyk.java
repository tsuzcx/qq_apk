import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class pyk
  extends ppw
{
  public static final String CMD = ppf.fQ("StorySvc.homepage_batch_feeds_detail_720");
  public List<qvd> nk = new ArrayList();
  public List<String> nl = new ArrayList();
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeed localRspStoryFeed = new qqstory_service.RspStoryFeed();
    try
    {
      localRspStoryFeed.mergeFrom(paramArrayOfByte);
      return new pyk.a(localRspStoryFeed);
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
    qqstory_service.ReqStoryFeed localReqStoryFeed = new qqstory_service.ReqStoryFeed();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.nk.iterator();
    while (localIterator.hasNext())
    {
      qvd localqvd = (qvd)localIterator.next();
      if (localqvd != null) {
        if (TextUtils.isEmpty(localqvd.mFeedId)) {
          ram.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "check your param feedId is null");
        } else {
          localArrayList.add(localqvd.a());
        }
      }
    }
    if (localArrayList.size() == 0) {
      throw new QQStoryCmdHandler.IllegalUinException("feed id seq is null");
    }
    localReqStoryFeed.feed_id_list.set(localArrayList);
    return localReqStoryFeed.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public static class a
    extends ppu
  {
    public HashSet<String> af = new HashSet();
    public List<qwa> nm = new ArrayList();
    
    public a(ErrorMessage paramErrorMessage)
    {
      super(paramErrorMessage.errorMsg);
    }
    
    public a(qqstory_service.RspStoryFeed paramRspStoryFeed)
    {
      super();
      paramRspStoryFeed = paramRspStoryFeed.feed_list.get().iterator();
      while (paramRspStoryFeed.hasNext())
      {
        qqstory_struct.StoryFeed localStoryFeed = (qqstory_struct.StoryFeed)paramRspStoryFeed.next();
        int i = localStoryFeed.type.get();
        qwa localqwa = qwa.a(i);
        if (localqwa == null)
        {
          ram.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "目前没有这个类型的Feed=" + i);
        }
        else if (localqwa.a(localStoryFeed))
        {
          if (localqwa.a() != null) {
            this.af.add(localqwa.a().feedId);
          }
          if ((!(localqwa instanceof qvz)) || (!qow.a((ShareGroupFeedItem)((qvz)localqwa).c()))) {
            this.nm.add(localqwa);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyk
 * JD-Core Version:    0.7.0.1
 */