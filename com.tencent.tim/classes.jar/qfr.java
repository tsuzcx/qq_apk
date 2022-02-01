import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;

public class qfr
  extends qwo
{
  public qfr(QQStoryWatcherListActivity paramQQStoryWatcherListActivity) {}
  
  public void a(int paramInt, View paramView, Object paramObject, qyd paramqyd)
  {
    if ((paramObject instanceof QQUserUIItem))
    {
      paramView = (QQUserUIItem)paramObject;
      ppf.f(this.this$0, 10, paramView.uid);
      if ((!TextUtils.isEmpty(this.this$0.mFeedId)) && (this.this$0.c != null)) {
        rar.a("home_page", "clk_head_list", rar.a(this.this$0.c), 0, new String[] { "1", rar.bX(this.this$0.mSource), "", this.this$0.mFeedId });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfr
 * JD-Core Version:    0.7.0.1
 */