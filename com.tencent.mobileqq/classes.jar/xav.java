import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;

public class xav
  extends yev
{
  public xav(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      weg.a(this.a, 10, paramView.uid);
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null)) {
        ykv.a("home_page", "clk_head_list", ykv.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem), 0, new String[] { "1", ykv.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_JavaLangString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xav
 * JD-Core Version:    0.7.0.1
 */