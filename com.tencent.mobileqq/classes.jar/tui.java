import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;

public class tui
  extends uyi
{
  public tui(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      sxm.a(this.a, 10, paramView.uid);
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null)) {
        vei.a("home_page", "clk_head_list", vei.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem), 0, new String[] { "1", vei.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_JavaLangString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tui
 * JD-Core Version:    0.7.0.1
 */