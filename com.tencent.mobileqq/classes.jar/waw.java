import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryListLoadMoreView;

public class waw
  implements View.OnClickListener
{
  public waw(MyMemoriesListView paramMyMemoriesListView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a() != 4) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a() != 1))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewStoryListLoadMoreView.a(1);
      if (this.a.jdField_a_of_type_Wax != null) {
        this.a.jdField_a_of_type_Wax.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     waw
 * JD-Core Version:    0.7.0.1
 */