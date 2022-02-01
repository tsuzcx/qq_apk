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

public class xcf
  extends wov
{
  public HashSet<String> a;
  public List<ynt> a;
  
  public xcf(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public xcf(qqstory_service.RspStoryFeed paramRspStoryFeed)
  {
    super(paramRspStoryFeed.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    paramRspStoryFeed = paramRspStoryFeed.feed_list.get().iterator();
    while (paramRspStoryFeed.hasNext())
    {
      qqstory_struct.StoryFeed localStoryFeed = (qqstory_struct.StoryFeed)paramRspStoryFeed.next();
      int i = localStoryFeed.type.get();
      ynt localynt = ynt.a(i);
      if (localynt == null)
      {
        yuk.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "目前没有这个类型的Feed=" + i);
      }
      else if (localynt.a(localStoryFeed))
      {
        if (localynt.a() != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localynt.a().feedId);
        }
        if ((!(localynt instanceof yns)) || (!yal.a((ShareGroupFeedItem)((yns)localynt).a()))) {
          this.jdField_a_of_type_JavaUtilList.add(localynt);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcf
 * JD-Core Version:    0.7.0.1
 */