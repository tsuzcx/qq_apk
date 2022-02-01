import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class wsq
  extends wfh
{
  public HashSet<String> a;
  public List<ydz> a;
  
  public wsq(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public wsq(qqstory_service.RspStoryFeed paramRspStoryFeed)
  {
    super(paramRspStoryFeed.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    paramRspStoryFeed = paramRspStoryFeed.feed_list.get().iterator();
    while (paramRspStoryFeed.hasNext())
    {
      qqstory_struct.StoryFeed localStoryFeed = (qqstory_struct.StoryFeed)paramRspStoryFeed.next();
      int i = localStoryFeed.type.get();
      ydz localydz = ydz.a(i);
      if (localydz == null)
      {
        ykq.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "目前没有这个类型的Feed=" + i);
      }
      else if (localydz.a(localStoryFeed))
      {
        if (localydz.a() != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localydz.a().feedId);
        }
        if ((!(localydz instanceof ydy)) || (!xqr.a((ShareGroupFeedItem)((ydy)localydz).a()))) {
          this.jdField_a_of_type_JavaUtilList.add(localydz);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsq
 * JD-Core Version:    0.7.0.1
 */