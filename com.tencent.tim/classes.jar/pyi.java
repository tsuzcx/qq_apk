import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedCommentInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pyi
  extends ppw
{
  private static final String CMD = ppf.fQ("StorySvc.feed_comment_list_batch_775");
  private int mSource;
  private List<String> ne;
  
  public pyi(List<String> paramList, boolean paramBoolean)
  {
    this.ne = paramList;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.mSource = i;
      return;
    }
  }
  
  public ppu a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchFeedComment localRspBatchFeedComment = new qqstory_service.RspBatchFeedComment();
    try
    {
      localRspBatchFeedComment.mergeFrom(paramArrayOfByte);
      return new pyi.a(localRspBatchFeedComment);
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
    qqstory_service.ReqBatchFeedComment localReqBatchFeedComment = new qqstory_service.ReqBatchFeedComment();
    List localList = ak(this.ne);
    localReqBatchFeedComment.feed_id_list.set(localList);
    localReqBatchFeedComment.source.set(this.mSource);
    return localReqBatchFeedComment.toByteArray();
  }
  
  public String mg()
  {
    return CMD;
  }
  
  public static class a
    extends ppu
  {
    public List<pyi.b> nf = new ArrayList();
    public List<qvc> ng = new ArrayList(0);
    
    public a(ErrorMessage paramErrorMessage)
    {
      super(paramErrorMessage.errorMsg);
    }
    
    public a(qqstory_service.RspBatchFeedComment paramRspBatchFeedComment)
    {
      super();
      paramRspBatchFeedComment = paramRspBatchFeedComment.feed_comment_info_list.get().iterator();
      while (paramRspBatchFeedComment.hasNext())
      {
        Object localObject = (qqstory_struct.FeedCommentInfo)paramRspBatchFeedComment.next();
        pyi.b localb = new pyi.b();
        localb.feedId = ((qqstory_struct.FeedCommentInfo)localObject).feed_id.get().toStringUtf8();
        localb.commentCount = ((qqstory_struct.FeedCommentInfo)localObject).comment_total_num.get();
        localb.cookie = ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8();
        localb.isEnd = ((qqstory_struct.FeedCommentInfo)localObject).is_end.get();
        if (localb.isEnd != 1) {
          this.ng.add(new qvc(localb.feedId, 1, ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8()));
        }
        localObject = ((qqstory_struct.FeedCommentInfo)localObject).comment_list.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)((Iterator)localObject).next());
          localCommentEntry.feedId = localb.feedId;
          localb.nh.add(localCommentEntry);
        }
        this.nf.add(localb);
      }
    }
  }
  
  public static class b
  {
    public int commentCount;
    public String cookie;
    public String feedId;
    public int isEnd;
    public List<CommentEntry> nh = new ArrayList();
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.feedId != null) {
          return this.feedId.equals(paramObject.feedId);
        }
      } while (paramObject.feedId == null);
      return false;
    }
    
    public int hashCode()
    {
      if (this.feedId != null) {
        return this.feedId.hashCode();
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pyi
 * JD-Core Version:    0.7.0.1
 */