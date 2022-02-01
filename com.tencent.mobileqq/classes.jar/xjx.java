import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.List;
import java.util.Map;

class xjx
  implements HorizontalListView.OnScrollStateChangedListener
{
  xjx(xjw paramxjw, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, xjt paramxjt) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      xjw.a(this.jdField_a_of_type_Xjw).a.put("2_" + this.jdField_a_of_type_Xjw.a.a.feedId, ((StoryVideoItem)this.jdField_a_of_type_Xjt.a.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjx
 * JD-Core Version:    0.7.0.1
 */