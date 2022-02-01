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

public class qas
  extends ppu
{
  public int blC;
  public List<StoryVideoItem> mVideoItemList = new ArrayList();
  public List<List<VideoUrlEntry>> nx = new ArrayList();
  
  public qas(qqstory_service.RspBatchGetVideoFullInfoList paramRspBatchGetVideoFullInfoList)
  {
    super(paramRspBatchGetVideoFullInfoList.result);
    Object localObject1 = paramRspBatchGetVideoFullInfoList.video_list.get();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (qqstory_struct.StoryVideoFullInfo)((Iterator)localObject1).next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom((qqstory_struct.StoryVideoFullInfo)localObject2);
        this.mVideoItemList.add(localStoryVideoItem);
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
          this.nx.add(localObject2);
        }
      }
    }
    this.blC = paramRspBatchGetVideoFullInfoList.interact_status.get();
  }
  
  public String toString()
  {
    return "GetVideoBasicInfoListResponse{mVideoItemList=" + this.mVideoItemList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qas
 * JD-Core Version:    0.7.0.1
 */