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

public class wsk
  extends wfh
{
  public List<wsl> a;
  public List<ycb> b = new ArrayList(0);
  
  public wsk(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public wsk(qqstory_service.RspBatchFeedComment paramRspBatchFeedComment)
  {
    super(paramRspBatchFeedComment.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspBatchFeedComment = paramRspBatchFeedComment.feed_comment_info_list.get().iterator();
    while (paramRspBatchFeedComment.hasNext())
    {
      Object localObject = (qqstory_struct.FeedCommentInfo)paramRspBatchFeedComment.next();
      wsl localwsl = new wsl();
      localwsl.jdField_a_of_type_JavaLangString = ((qqstory_struct.FeedCommentInfo)localObject).feed_id.get().toStringUtf8();
      localwsl.jdField_a_of_type_Int = ((qqstory_struct.FeedCommentInfo)localObject).comment_total_num.get();
      localwsl.jdField_b_of_type_JavaLangString = ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8();
      localwsl.jdField_b_of_type_Int = ((qqstory_struct.FeedCommentInfo)localObject).is_end.get();
      if (localwsl.jdField_b_of_type_Int != 1) {
        this.b.add(new ycb(localwsl.jdField_a_of_type_JavaLangString, 1, ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8()));
      }
      localObject = ((qqstory_struct.FeedCommentInfo)localObject).comment_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)((Iterator)localObject).next());
        localCommentEntry.feedId = localwsl.jdField_a_of_type_JavaLangString;
        localwsl.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
      }
      this.jdField_a_of_type_JavaUtilList.add(localwsl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsk
 * JD-Core Version:    0.7.0.1
 */