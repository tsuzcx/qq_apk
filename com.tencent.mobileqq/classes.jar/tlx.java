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

public class tlx
  extends syn
{
  public HashSet<String> a;
  public List<uxm> a;
  
  public tlx(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public tlx(qqstory_service.RspStoryFeed paramRspStoryFeed)
  {
    super(paramRspStoryFeed.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    paramRspStoryFeed = paramRspStoryFeed.feed_list.get().iterator();
    while (paramRspStoryFeed.hasNext())
    {
      qqstory_struct.StoryFeed localStoryFeed = (qqstory_struct.StoryFeed)paramRspStoryFeed.next();
      int i = localStoryFeed.type.get();
      uxm localuxm = uxm.a(i);
      if (localuxm == null)
      {
        ved.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "目前没有这个类型的Feed=" + i);
      }
      else if (localuxm.a(localStoryFeed))
      {
        if (localuxm.a() != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localuxm.a().feedId);
        }
        if ((!(localuxm instanceof uxl)) || (!uke.a((ShareGroupFeedItem)((uxl)localuxm).a()))) {
          this.jdField_a_of_type_JavaUtilList.add(localuxm);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tlx
 * JD-Core Version:    0.7.0.1
 */