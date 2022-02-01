import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCollectionVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoUrl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qac
  extends ppu
{
  public int blC;
  public boolean isEnd;
  public String nextCookie;
  public List<StoryVideoItem> nw = new ArrayList();
  public List<List<VideoUrlEntry>> nx = new ArrayList();
  public String unionId;
  
  public qac(String paramString, qqstory_service.RspGetCollectionVideoList paramRspGetCollectionVideoList)
  {
    super(paramRspGetCollectionVideoList.result);
    this.unionId = paramString;
    if (paramRspGetCollectionVideoList.is_end.get() == 1)
    {
      this.isEnd = bool;
      this.blC = paramRspGetCollectionVideoList.interact_status.get();
      this.nextCookie = paramRspGetCollectionVideoList.next_cookie.get().toStringUtf8();
      paramString = paramRspGetCollectionVideoList.full_video_info_list.get().iterator();
    }
    for (;;)
    {
      if (!paramString.hasNext()) {
        return;
      }
      Object localObject1 = (qqstory_struct.StoryVideoFullInfo)paramString.next();
      paramRspGetCollectionVideoList = new StoryVideoItem();
      paramRspGetCollectionVideoList.convertFrom((qqstory_struct.StoryVideoFullInfo)localObject1);
      this.nw.add(paramRspGetCollectionVideoList);
      Object localObject2 = ((qqstory_struct.StoryVideoFullInfo)localObject1).compressed_video.get();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            qqstory_struct.VideoUrl localVideoUrl = (qqstory_struct.VideoUrl)((Iterator)localObject2).next();
            VideoUrlEntry localVideoUrlEntry = new VideoUrlEntry();
            localVideoUrlEntry.vid = paramRspGetCollectionVideoList.mVid;
            localVideoUrlEntry.videoUrlLevel = localVideoUrl.video_level.get();
            localVideoUrlEntry.videoUrl = localVideoUrl.video_url.get();
            ((List)localObject1).add(localVideoUrlEntry);
            continue;
            bool = false;
            break;
          }
        }
        this.nx.add(localObject1);
      }
    }
  }
  
  public String toString()
  {
    return "GetCollectionVideoListResponse{unionId='" + this.unionId + '\'' + ", nextCookie='" + this.nextCookie + '\'' + ", isEnd=" + this.isEnd + ", interactStatus=" + this.blC + ", videoItems=" + this.nw + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qac
 * JD-Core Version:    0.7.0.1
 */