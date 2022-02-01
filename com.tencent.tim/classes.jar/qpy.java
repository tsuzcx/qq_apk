import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView.a;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qpy
  implements View.OnClickListener
{
  public qpy(MyMemoriesListView paramMyMemoriesListView) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() != 4) && (this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.getState() != 1))
    {
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.eW(1);
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a != null) {
        this.this$0.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$a.aSa();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpy
 * JD-Core Version:    0.7.0.1
 */