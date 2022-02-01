import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class xnl
  extends xmx
{
  private ShareFromMemoryPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo;
  private String jdField_a_of_type_JavaLangString = "";
  private xms jdField_a_of_type_Xms;
  
  public xnl(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo = paramShareFromMemoryPlayInfo;
    this.jdField_a_of_type_Xms = new xms(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
  }
  
  public List<xmz> a(List<xms> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new xnm(this, (xms)paramList.next()));
    }
    return localArrayList;
  }
  
  public xmv a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.videoListOrder == 0)
    {
      localObject = ((ymk)wth.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId, 1);
      if ((localObject == null) || (((FeedVideoInfo)localObject).mVideoItemList.size() <= 0)) {}
    }
    for (Object localObject = ((StoryVideoItem)((FeedVideoInfo)localObject).mVideoItemList.get(0)).mVid;; localObject = null)
    {
      yuk.d("Q.qqstory.player.data.ShareFromMemoryPlayPageLoader", "getStartInfo GroupId=" + this.jdField_a_of_type_Xms + ",vid=" + (String)localObject + ",feedId=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
      return new xmv(this.jdField_a_of_type_Xms, (String)localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceShareFromMemoryPlayInfo.feedId);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, xmy paramxmy)
  {
    paramxmy.a(new ErrorMessage(), Collections.singletonList(this.jdField_a_of_type_Xms), true);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnl
 * JD-Core Version:    0.7.0.1
 */