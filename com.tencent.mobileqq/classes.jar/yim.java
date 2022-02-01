import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import java.util.List;
import java.util.Map;

class yim
  implements blmh
{
  yim(yil paramyil, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, yii paramyii) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4097)
    {
      int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getFirstVisiblePosition();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      yil.a(this.jdField_a_of_type_Yil).a.put("2_" + this.jdField_a_of_type_Yil.a.a.feedId, ((StoryVideoItem)this.jdField_a_of_type_Yii.a.get(paramInt)).mVid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yim
 * JD-Core Version:    0.7.0.1
 */