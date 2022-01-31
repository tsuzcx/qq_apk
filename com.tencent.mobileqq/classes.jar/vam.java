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

public class vam
  extends unf
{
  public List<van> a;
  
  public vam(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public vam(qqstory_service.RspBatchFeedLike paramRspBatchFeedLike)
  {
    super(paramRspBatchFeedLike.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspBatchFeedLike = paramRspBatchFeedLike.feed_like_info_list.get().iterator();
    while (paramRspBatchFeedLike.hasNext())
    {
      Object localObject = (qqstory_struct.FeedLikeInfo)paramRspBatchFeedLike.next();
      van localvan = new van();
      localvan.jdField_a_of_type_JavaLangString = ((qqstory_struct.FeedLikeInfo)localObject).feed_id.get().toStringUtf8();
      localvan.b = ((qqstory_struct.FeedLikeInfo)localObject).has_like.get();
      localvan.jdField_a_of_type_Int = ((qqstory_struct.FeedLikeInfo)localObject).like_total_count.get();
      localvan.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject = ((qqstory_struct.FeedLikeInfo)localObject).like_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)((Iterator)localObject).next());
        localLikeEntry.feedId = localvan.jdField_a_of_type_JavaLangString;
        localvan.jdField_a_of_type_JavaUtilList.add(localLikeEntry);
      }
      this.jdField_a_of_type_JavaUtilList.add(localvan);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vam
 * JD-Core Version:    0.7.0.1
 */