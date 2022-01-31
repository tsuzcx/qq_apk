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

public class vcs
  extends unf
{
  public String a;
  public List<StoryVideoItem> a;
  public boolean a;
  public int b;
  public List<List<VideoUrlEntry>> b;
  public String c;
  
  public vcs(String paramString, qqstory_service.RspGetCollectionVideoList paramRspGetCollectionVideoList)
  {
    super(paramRspGetCollectionVideoList.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramRspGetCollectionVideoList.is_end.get() == 1)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_Int = paramRspGetCollectionVideoList.interact_status.get();
      this.c = paramRspGetCollectionVideoList.next_cookie.get().toStringUtf8();
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
      this.jdField_a_of_type_JavaUtilList.add(paramRspGetCollectionVideoList);
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
        this.jdField_b_of_type_JavaUtilList.add(localObject1);
      }
    }
  }
  
  public String toString()
  {
    return "GetCollectionVideoListResponse{unionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", nextCookie='" + this.c + '\'' + ", isEnd=" + this.jdField_a_of_type_Boolean + ", interactStatus=" + this.jdField_b_of_type_Int + ", videoItems=" + this.jdField_a_of_type_JavaUtilList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vcs
 * JD-Core Version:    0.7.0.1
 */