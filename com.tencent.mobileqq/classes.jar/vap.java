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

public class vap
  extends unf
{
  public HashSet<String> a;
  public List<wme> a;
  
  public vap(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public vap(qqstory_service.RspStoryFeed paramRspStoryFeed)
  {
    super(paramRspStoryFeed.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    paramRspStoryFeed = paramRspStoryFeed.feed_list.get().iterator();
    while (paramRspStoryFeed.hasNext())
    {
      qqstory_struct.StoryFeed localStoryFeed = (qqstory_struct.StoryFeed)paramRspStoryFeed.next();
      int i = localStoryFeed.type.get();
      wme localwme = wme.a(i);
      if (localwme == null)
      {
        wsv.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "目前没有这个类型的Feed=" + i);
      }
      else if (localwme.a(localStoryFeed))
      {
        if (localwme.a() != null) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localwme.a().feedId);
        }
        if ((!(localwme instanceof wmd)) || (!vyw.a((ShareGroupFeedItem)((wmd)localwme).a()))) {
          this.jdField_a_of_type_JavaUtilList.add(localwme);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vap
 * JD-Core Version:    0.7.0.1
 */