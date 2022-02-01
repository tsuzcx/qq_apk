import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspSimpleInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoSimpleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wgm
  extends vqm
{
  public List<StoryVideoItem> a = new ArrayList();
  
  public wgm(qqstory_service.RspSimpleInfoList paramRspSimpleInfoList)
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
        this.a.add(localStoryVideoItem);
      }
    }
  }
  
  public String toString()
  {
    return "GetSimpleInfoListResponse{mVideoItemList=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgm
 * JD-Core Version:    0.7.0.1
 */