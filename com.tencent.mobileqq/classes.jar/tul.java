import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;

public class tul
  extends uyl
{
  public tul(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      sxp.a(this.a, 10, paramView.uid);
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null)) {
        vel.a("home_page", "clk_head_list", vel.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem), 0, new String[] { "1", vel.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_JavaLangString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tul
 * JD-Core Version:    0.7.0.1
 */