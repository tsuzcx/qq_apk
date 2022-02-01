import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoUrl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xbe
  extends wla
{
  public List<StoryVideoItem> a = new ArrayList();
  public int b;
  public List<List<VideoUrlEntry>> b;
  
  public xbe(qqstory_service.RspBatchGetVideoFullInfoList paramRspBatchGetVideoFullInfoList)
  {
    super(paramRspBatchGetVideoFullInfoList.result);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = paramRspBatchGetVideoFullInfoList.video_list.get();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (qqstory_struct.StoryVideoFullInfo)((Iterator)localObject1).next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom((qqstory_struct.StoryVideoFullInfo)localObject2);
        this.a.add(localStoryVideoItem);
        Object localObject3 = ((qqstory_struct.StoryVideoFullInfo)localObject2).compressed_video.get();
        if (localObject3 != null)
        {
          localObject2 = new ArrayList(((List)localObject3).size());
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            qqstory_struct.VideoUrl localVideoUrl = (qqstory_struct.VideoUrl)((Iterator)localObject3).next();
            VideoUrlEntry localVideoUrlEntry = new VideoUrlEntry();
            localVideoUrlEntry.vid = localStoryVideoItem.mVid;
            localVideoUrlEntry.videoUrlLevel = localVideoUrl.video_level.get();
            localVideoUrlEntry.videoUrl = localVideoUrl.video_url.get();
            ((List)localObject2).add(localVideoUrlEntry);
          }
          this.jdField_b_of_type_JavaUtilList.add(localObject2);
        }
      }
    }
    this.jdField_b_of_type_Int = paramRspBatchGetVideoFullInfoList.interact_status.get();
  }
  
  public String toString()
  {
    return "GetVideoBasicInfoListResponse{mVideoItemList=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbe
 * JD-Core Version:    0.7.0.1
 */