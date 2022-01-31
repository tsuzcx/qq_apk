import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBaseList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tml
  extends syn
{
  public List<tmk> a;
  
  public tml(qqstory_service.RspStoryFeedTagInfo paramRspStoryFeedTagInfo)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramRspStoryFeedTagInfo = paramRspStoryFeedTagInfo.tag_info.get();
    if (paramRspStoryFeedTagInfo != null)
    {
      paramRspStoryFeedTagInfo = paramRspStoryFeedTagInfo.iterator();
      while (paramRspStoryFeedTagInfo.hasNext())
      {
        Object localObject = (qqstory_struct.TagInfoBaseList)paramRspStoryFeedTagInfo.next();
        tmk localtmk = new tmk();
        localtmk.jdField_a_of_type_JavaLangString = ((qqstory_struct.TagInfoBaseList)localObject).feed_id.get().toStringUtf8();
        localObject = ((qqstory_struct.TagInfoBaseList)localObject).tag_info_list.get();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            vve localvve = new vve((qqstory_struct.TagInfoBase)((Iterator)localObject).next());
            localtmk.jdField_a_of_type_JavaUtilList.add(localvve);
          }
        }
        this.jdField_a_of_type_JavaUtilList.add(localtmk);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tml
 * JD-Core Version:    0.7.0.1
 */