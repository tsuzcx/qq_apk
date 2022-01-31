import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class vlw
  extends vli
{
  private ShareFromMemoryPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo;
  private String jdField_a_of_type_JavaLangString = "";
  private vld jdField_a_of_type_Vld;
  
  public vlw(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo = paramShareFromMemoryPlayInfo;
    this.jdField_a_of_type_Vld = new vld(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
  }
  
  public List<vlk> a(List<vld> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new vlx(this, (vld)paramList.next()));
    }
    return localArrayList;
  }
  
  public vlg a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.videoListOrder == 0)
    {
      localObject = ((wkv)urr.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId, 1);
      if ((localObject == null) || (((FeedVideoInfo)localObject).mVideoItemList.size() <= 0)) {}
    }
    for (Object localObject = ((StoryVideoItem)((FeedVideoInfo)localObject).mVideoItemList.get(0)).mVid;; localObject = null)
    {
      wsv.d("Q.qqstory.player.data.ShareFromMemoryPlayPageLoader", "getStartInfo GroupId=" + this.jdField_a_of_type_Vld + ",vid=" + (String)localObject + ",feedId=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
      return new vlg(this.jdField_a_of_type_Vld, (String)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, vlj paramvlj)
  {
    paramvlj.a(new ErrorMessage(), Collections.singletonList(this.jdField_a_of_type_Vld), true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlw
 * JD-Core Version:    0.7.0.1
 */