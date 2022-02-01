import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xfc
  extends wov
{
  public long a;
  public String a;
  public List<xed> a;
  public long b;
  public String c;
  public String d;
  public String e;
  
  public xfc(qqstory_service.RspPublishVideo paramRspPublishVideo)
  {
    super(paramRspPublishVideo.result);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = paramRspPublishVideo.create_time.get();
    this.jdField_a_of_type_JavaLangString = paramRspPublishVideo.feed_id.get().toStringUtf8();
    this.c = String.valueOf(paramRspPublishVideo.date.get());
    this.b = paramRspPublishVideo.video_index.get();
    if (paramRspPublishVideo.story_id.has()) {
      this.d = paramRspPublishVideo.story_id.get().toStringUtf8();
    }
    if (paramRspPublishVideo.vid.has()) {
      this.e = paramRspPublishVideo.vid.get().toStringUtf8();
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspPublishVideo = paramRspPublishVideo.group_feed_list.get().iterator();
    while (paramRspPublishVideo.hasNext())
    {
      qqstory_group.GroupFeed localGroupFeed = (qqstory_group.GroupFeed)paramRspPublishVideo.next();
      this.jdField_a_of_type_JavaUtilList.add(new xed(localGroupFeed));
    }
  }
  
  public String toString()
  {
    return "PublishStoryVideoRespond{createTime=" + this.jdField_a_of_type_Long + ", feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", date='" + this.c + '\'' + ", storyId='" + this.d + '\'' + ", videoIndex=" + this.b + ", vid=" + this.e + ", addShareGroupFeeds=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfc
 * JD-Core Version:    0.7.0.1
 */