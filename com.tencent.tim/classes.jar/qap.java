import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSimpleInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoSimpleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qap
  extends ppu
{
  public List<StoryVideoItem> mVideoItemList = new ArrayList();
  
  public qap(qqstory_service.RspSimpleInfoList paramRspSimpleInfoList)
  {
    super(paramRspSimpleInfoList.result);
    paramRspSimpleInfoList = paramRspSimpleInfoList.video_list.get();
    if (paramRspSimpleInfoList != null)
    {
      paramRspSimpleInfoList = paramRspSimpleInfoList.iterator();
      while (paramRspSimpleInfoList.hasNext())
      {
        qqstory_struct.StoryVideoSimpleInfo localStoryVideoSimpleInfo = (qqstory_struct.StoryVideoSimpleInfo)paramRspSimpleInfoList.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.net:GetSimpleInfoListResponse", localStoryVideoSimpleInfo);
        this.mVideoItemList.add(localStoryVideoItem);
      }
    }
  }
  
  public String toString()
  {
    return "GetSimpleInfoListResponse{mVideoItemList=" + this.mVideoItemList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qap
 * JD-Core Version:    0.7.0.1
 */