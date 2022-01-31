import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class vqf
  extends vpr
{
  private ShareFromMemoryPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo;
  private String jdField_a_of_type_JavaLangString = "";
  private vpm jdField_a_of_type_Vpm;
  
  public vqf(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo = paramShareFromMemoryPlayInfo;
    this.jdField_a_of_type_Vpm = new vpm(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
  }
  
  public List<vpt> a(List<vpm> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new vqg(this, (vpm)paramList.next()));
    }
    return localArrayList;
  }
  
  public vpp a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.videoListOrder == 0)
    {
      localObject = ((wpe)uwa.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId, 1);
      if ((localObject == null) || (((FeedVideoInfo)localObject).mVideoItemList.size() <= 0)) {}
    }
    for (Object localObject = ((StoryVideoItem)((FeedVideoInfo)localObject).mVideoItemList.get(0)).mVid;; localObject = null)
    {
      wxe.d("Q.qqstory.player.data.ShareFromMemoryPlayPageLoader", "getStartInfo GroupId=" + this.jdField_a_of_type_Vpm + ",vid=" + (String)localObject + ",feedId=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
      return new vpp(this.jdField_a_of_type_Vpm, (String)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, vps paramvps)
  {
    paramvps.a(new ErrorMessage(), Collections.singletonList(this.jdField_a_of_type_Vpm), true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vqf
 * JD-Core Version:    0.7.0.1
 */