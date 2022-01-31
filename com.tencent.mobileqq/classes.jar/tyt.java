import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class tyt
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, sys>
{
  public tyt(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull sys paramsys)
  {
    if (paramsys.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramsys);
    }
  }
  
  public Class acceptEventClass()
  {
    return sys.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyt
 * JD-Core Version:    0.7.0.1
 */