import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedCommentInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xbz
  extends wov
{
  public List<xca> a;
  public List<ylv> b = new ArrayList(0);
  
  public xbz(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public xbz(qqstory_service.RspBatchFeedComment paramRspBatchFeedComment)
  {
    super(paramRspBatchFeedComment.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspBatchFeedComment = paramRspBatchFeedComment.feed_comment_info_list.get().iterator();
    while (paramRspBatchFeedComment.hasNext())
    {
      Object localObject = (qqstory_struct.FeedCommentInfo)paramRspBatchFeedComment.next();
      xca localxca = new xca();
      localxca.jdField_a_of_type_JavaLangString = ((qqstory_struct.FeedCommentInfo)localObject).feed_id.get().toStringUtf8();
      localxca.jdField_a_of_type_Int = ((qqstory_struct.FeedCommentInfo)localObject).comment_total_num.get();
      localxca.jdField_b_of_type_JavaLangString = ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8();
      localxca.jdField_b_of_type_Int = ((qqstory_struct.FeedCommentInfo)localObject).is_end.get();
      if (localxca.jdField_b_of_type_Int != 1) {
        this.b.add(new ylv(localxca.jdField_a_of_type_JavaLangString, 1, ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8()));
      }
      localObject = ((qqstory_struct.FeedCommentInfo)localObject).comment_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)((Iterator)localObject).next());
        localCommentEntry.feedId = localxca.jdField_a_of_type_JavaLangString;
        localxca.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
      }
      this.jdField_a_of_type_JavaUtilList.add(localxca);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbz
 * JD-Core Version:    0.7.0.1
 */