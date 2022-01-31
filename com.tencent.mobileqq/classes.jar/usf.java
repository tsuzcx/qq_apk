import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;
import java.util.Map;

class usf
  implements bfso
{
  usf(use paramuse, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, usb paramusb) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      use.a(this.jdField_a_of_type_Use).a.put("2_" + this.jdField_a_of_type_Use.a.a.feedId, ((StoryVideoItem)this.jdField_a_of_type_Usb.a.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usf
 * JD-Core Version:    0.7.0.1
 */