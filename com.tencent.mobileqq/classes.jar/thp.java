import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;

public class thp
  extends ulp
{
  public thp(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void a(int paramInt, View paramView, Object paramObject, unw paramunw)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      skt.a(this.a, 10, paramView.uid);
      if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null)) {
        urp.a("home_page", "clk_head_list", urp.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem), 0, new String[] { "1", urp.a(this.a.jdField_a_of_type_Int), "", this.a.jdField_a_of_type_JavaLangString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     thp
 * JD-Core Version:    0.7.0.1
 */