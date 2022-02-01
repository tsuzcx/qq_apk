import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFeedCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedCommentInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pyt
  extends ppw
{
  public static final String CMD = ppf.fQ("StorySvc.feed_comment_list_775");
  public qvc a;
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspFeedCommentList localRspFeedCommentList = new qqstory_service.RspFeedCommentList();
    try
    {
      localRspFeedCommentList.mergeFrom(paramArrayOfByte);
      return new pyt.a(localRspFeedCommentList);
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
    qqstory_service.ReqFeedCommentList localReqFeedCommentList = new qqstory_service.ReqFeedCommentList();
    localReqFeedCommentList.feed_id.set(ByteStringMicro.copyFromUtf8(this.a.mFeedId));
    if (this.a.avr == null) {
      this.a.avr = "";
    }
    localReqFeedCommentList.cookie.set(ByteStringMicro.copyFromUtf8(this.a.avr));
    localReqFeedCommentList.source.set(this.a.mSource);
    if (this.a.mType != -1) {
      localReqFeedCommentList.type.set(this.a.mType);
    }
    return localReqFeedCommentList.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public static class a
    extends ppt
  {
    public String feedId;
    public List<CommentEntry> nh = new ArrayList();
    public int totalNum;
    
    public a(qqstory_service.RspFeedCommentList paramRspFeedCommentList)
    {
      super(paramRspFeedCommentList.feed_comment_info.is_end, paramRspFeedCommentList.feed_comment_info.next_cookie);
      this.feedId = paramRspFeedCommentList.feed_comment_info.feed_id.get().toStringUtf8();
      this.totalNum = paramRspFeedCommentList.feed_comment_info.comment_total_num.get();
      paramRspFeedCommentList = paramRspFeedCommentList.feed_comment_info.comment_list.get().iterator();
      while (paramRspFeedCommentList.hasNext())
      {
        CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)paramRspFeedCommentList.next());
        localCommentEntry.feedId = this.feedId;
        this.nh.add(localCommentEntry);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyt
 * JD-Core Version:    0.7.0.1
 */