import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedLike;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xcc
  extends wov
{
  public List<xcd> a;
  
  public xcc(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public xcc(qqstory_service.RspBatchFeedLike paramRspBatchFeedLike)
  {
    super(paramRspBatchFeedLike.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspBatchFeedLike = paramRspBatchFeedLike.feed_like_info_list.get().iterator();
    while (paramRspBatchFeedLike.hasNext())
    {
      Object localObject = (qqstory_struct.FeedLikeInfo)paramRspBatchFeedLike.next();
      xcd localxcd = new xcd();
      localxcd.jdField_a_of_type_JavaLangString = ((qqstory_struct.FeedLikeInfo)localObject).feed_id.get().toStringUtf8();
      localxcd.b = ((qqstory_struct.FeedLikeInfo)localObject).has_like.get();
      localxcd.jdField_a_of_type_Int = ((qqstory_struct.FeedLikeInfo)localObject).like_total_count.get();
      localxcd.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject = ((qqstory_struct.FeedLikeInfo)localObject).like_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)((Iterator)localObject).next());
        localLikeEntry.feedId = localxcd.jdField_a_of_type_JavaLangString;
        localxcd.jdField_a_of_type_JavaUtilList.add(localLikeEntry);
      }
      this.jdField_a_of_type_JavaUtilList.add(localxcd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcc
 * JD-Core Version:    0.7.0.1
 */