import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ybt
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, xbt>
{
  public ybt(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull xbt paramxbt)
  {
    if (paramxbt.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramxbt);
    }
  }
  
  public Class acceptEventClass()
  {
    return xbt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybt
 * JD-Core Version:    0.7.0.1
 */