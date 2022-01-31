import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class txh
  extends twt
{
  private ShareFromMemoryPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo;
  private String jdField_a_of_type_JavaLangString = "";
  private two jdField_a_of_type_Two;
  
  public txh(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo = paramShareFromMemoryPlayInfo;
    this.jdField_a_of_type_Two = new two(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
  }
  
  public List<twv> a(List<two> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new txi(this, (two)paramList.next()));
    }
    return localArrayList;
  }
  
  public twr a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.videoListOrder == 0)
    {
      localObject = ((uwg)tdc.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId, 1);
      if ((localObject == null) || (((FeedVideoInfo)localObject).mVideoItemList.size() <= 0)) {}
    }
    for (Object localObject = ((StoryVideoItem)((FeedVideoInfo)localObject).mVideoItemList.get(0)).mVid;; localObject = null)
    {
      veg.d("Q.qqstory.player.data.ShareFromMemoryPlayPageLoader", "getStartInfo GroupId=" + this.jdField_a_of_type_Two + ",vid=" + (String)localObject + ",feedId=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
      return new twr(this.jdField_a_of_type_Two, (String)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, twu paramtwu)
  {
    paramtwu.a(new ErrorMessage(), Collections.singletonList(this.jdField_a_of_type_Two), true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txh
 * JD-Core Version:    0.7.0.1
 */