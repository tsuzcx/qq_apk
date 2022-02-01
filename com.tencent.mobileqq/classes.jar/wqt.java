import android.view.View;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class wqt
  extends wrf
{
  wqt(wqs paramwqs) {}
  
  public void onClick(View paramView)
  {
    wqg localwqg;
    int i;
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_AndroidAppActivity != null))
    {
      localwqg = (wqg)this.a.a();
      if (wqs.a(this.a) != 11) {
        break label145;
      }
      i = 211;
    }
    for (;;)
    {
      StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
      i = yup.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      yup.a("home_page", "clk_like_more", yup.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), yup.a(localwqg.a), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label145:
      if (wqs.a(this.a) == 12) {
        i = 222;
      } else {
        i = 210;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqt
 * JD-Core Version:    0.7.0.1
 */