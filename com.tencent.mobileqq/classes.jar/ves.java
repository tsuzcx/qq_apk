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

public class ves
  extends uro
{
  public List<vet> a;
  public List<wop> b = new ArrayList(0);
  
  public ves(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ves(qqstory_service.RspBatchFeedComment paramRspBatchFeedComment)
  {
    super(paramRspBatchFeedComment.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspBatchFeedComment = paramRspBatchFeedComment.feed_comment_info_list.get().iterator();
    while (paramRspBatchFeedComment.hasNext())
    {
      Object localObject = (qqstory_struct.FeedCommentInfo)paramRspBatchFeedComment.next();
      vet localvet = new vet();
      localvet.jdField_a_of_type_JavaLangString = ((qqstory_struct.FeedCommentInfo)localObject).feed_id.get().toStringUtf8();
      localvet.jdField_a_of_type_Int = ((qqstory_struct.FeedCommentInfo)localObject).comment_total_num.get();
      localvet.jdField_b_of_type_JavaLangString = ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8();
      localvet.jdField_b_of_type_Int = ((qqstory_struct.FeedCommentInfo)localObject).is_end.get();
      if (localvet.jdField_b_of_type_Int != 1) {
        this.b.add(new wop(localvet.jdField_a_of_type_JavaLangString, 1, ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8()));
      }
      localObject = ((qqstory_struct.FeedCommentInfo)localObject).comment_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)((Iterator)localObject).next());
        localCommentEntry.feedId = localvet.jdField_a_of_type_JavaLangString;
        localvet.jdField_a_of_type_JavaUtilList.add(localCommentEntry);
      }
      this.jdField_a_of_type_JavaUtilList.add(localvet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ves
 * JD-Core Version:    0.7.0.1
 */