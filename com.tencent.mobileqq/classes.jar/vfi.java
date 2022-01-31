import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedCommentList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedCommentInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vfi
  extends urn
{
  public List<CommentEntry> a = new ArrayList();
  public int b;
  public String c;
  
  public vfi(qqstory_service.RspFeedCommentList paramRspFeedCommentList)
  {
    super(paramRspFeedCommentList.result, paramRspFeedCommentList.feed_comment_info.is_end, paramRspFeedCommentList.feed_comment_info.next_cookie);
    this.c = paramRspFeedCommentList.feed_comment_info.feed_id.get().toStringUtf8();
    this.b = paramRspFeedCommentList.feed_comment_info.comment_total_num.get();
    paramRspFeedCommentList = paramRspFeedCommentList.feed_comment_info.comment_list.get().iterator();
    while (paramRspFeedCommentList.hasNext())
    {
      CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)paramRspFeedCommentList.next());
      localCommentEntry.feedId = this.c;
      this.a.add(localCommentEntry);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vfi
 * JD-Core Version:    0.7.0.1
 */