import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupStoryInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qao
  extends ppu
{
  public List<StoryVideoItem> mVideoItemList = new ArrayList();
  
  public qao(qqstory_service.RspBatchGetVideoInfo paramRspBatchGetVideoInfo)
  {
    super(paramRspBatchGetVideoInfo.result);
    if (paramRspBatchGetVideoInfo.vid_info_list.has())
    {
      paramRspBatchGetVideoInfo = paramRspBatchGetVideoInfo.vid_info_list.get().iterator();
      while (paramRspBatchGetVideoInfo.hasNext())
      {
        qqstory_struct.GroupStoryInfo localGroupStoryInfo = (qqstory_struct.GroupStoryInfo)paramRspBatchGetVideoInfo.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.shareGroup:GetShareGroupVideoInfoResponse", localGroupStoryInfo);
        this.mVideoItemList.add(localStoryVideoItem);
      }
    }
  }
  
  public String toString()
  {
    return "GetShareGroupVideoInfoResponse{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + '\'' + ", mVideoItemList=" + this.mVideoItemList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qao
 * JD-Core Version:    0.7.0.1
 */