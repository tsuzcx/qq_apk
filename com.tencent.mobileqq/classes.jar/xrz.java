import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xrz
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wse>
{
  public xrz(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wse paramwse)
  {
    if (paramwse.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramwse);
    }
  }
  
  public Class acceptEventClass()
  {
    return wse.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xrz
 * JD-Core Version:    0.7.0.1
 */