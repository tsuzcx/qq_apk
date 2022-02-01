import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xde
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, wdj>
{
  public xde(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull wdj paramwdj)
  {
    if (paramwdj.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramwdj);
    }
  }
  
  public Class acceptEventClass()
  {
    return wdj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xde
 * JD-Core Version:    0.7.0.1
 */