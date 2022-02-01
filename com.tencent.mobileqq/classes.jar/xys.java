import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.List;
import java.util.Map;

class xys
  implements HorizontalListView.OnScrollStateChangedListener
{
  xys(xyr paramxyr, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, xyo paramxyo) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      xyr.a(this.jdField_a_of_type_Xyr).a.put("2_" + this.jdField_a_of_type_Xyr.a.a.feedId, ((StoryVideoItem)this.jdField_a_of_type_Xyo.a.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xys
 * JD-Core Version:    0.7.0.1
 */