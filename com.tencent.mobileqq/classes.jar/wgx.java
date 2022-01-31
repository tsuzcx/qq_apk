import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;
import java.util.Map;

class wgx
  implements bhtl
{
  wgx(wgw paramwgw, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, wgt paramwgt) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      wgw.a(this.jdField_a_of_type_Wgw).a.put("2_" + this.jdField_a_of_type_Wgw.a.a.feedId, ((StoryVideoItem)this.jdField_a_of_type_Wgt.a.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgx
 * JD-Core Version:    0.7.0.1
 */