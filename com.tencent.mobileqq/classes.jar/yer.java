import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;
import java.util.Map;

class yer
  implements bkle
{
  yer(yeq paramyeq, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, yen paramyen) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      yeq.a(this.jdField_a_of_type_Yeq).a.put("2_" + this.jdField_a_of_type_Yeq.a.a.feedId, ((StoryVideoItem)this.jdField_a_of_type_Yen.a.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yer
 * JD-Core Version:    0.7.0.1
 */