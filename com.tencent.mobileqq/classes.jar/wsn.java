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

public class wsn
  extends wfh
{
  public List<wso> a;
  
  public wsn(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public wsn(qqstory_service.RspBatchFeedLike paramRspBatchFeedLike)
  {
    super(paramRspBatchFeedLike.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspBatchFeedLike = paramRspBatchFeedLike.feed_like_info_list.get().iterator();
    while (paramRspBatchFeedLike.hasNext())
    {
      Object localObject = (qqstory_struct.FeedLikeInfo)paramRspBatchFeedLike.next();
      wso localwso = new wso();
      localwso.jdField_a_of_type_JavaLangString = ((qqstory_struct.FeedLikeInfo)localObject).feed_id.get().toStringUtf8();
      localwso.b = ((qqstory_struct.FeedLikeInfo)localObject).has_like.get();
      localwso.jdField_a_of_type_Int = ((qqstory_struct.FeedLikeInfo)localObject).like_total_count.get();
      localwso.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject = ((qqstory_struct.FeedLikeInfo)localObject).like_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)((Iterator)localObject).next());
        localLikeEntry.feedId = localwso.jdField_a_of_type_JavaLangString;
        localwso.jdField_a_of_type_JavaUtilList.add(localLikeEntry);
      }
      this.jdField_a_of_type_JavaUtilList.add(localwso);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsn
 * JD-Core Version:    0.7.0.1
 */