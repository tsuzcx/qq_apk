import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xxy
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wxy>
{
  public xxy(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wxy paramwxy)
  {
    if (paramwxy.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramwxy);
    }
  }
  
  public Class acceptEventClass()
  {
    return wxy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxy
 * JD-Core Version:    0.7.0.1
 */