import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;
import java.util.Map;

class usi
  implements bfrx
{
  usi(ush paramush, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, use paramuse) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      ush.a(this.jdField_a_of_type_Ush).a.put("2_" + this.jdField_a_of_type_Ush.a.a.feedId, ((StoryVideoItem)this.jdField_a_of_type_Use.a.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usi
 * JD-Core Version:    0.7.0.1
 */