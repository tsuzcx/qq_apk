import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wen
  extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, vem>
{
  public wen(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
  {
    super(paramQQStoryShareGroupProfileActivity);
  }
  
  public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull vem paramvem)
  {
    if (paramvem.a.isSuccess()) {
      paramQQStoryShareGroupProfileActivity.a.a(paramvem);
    }
  }
  
  public Class acceptEventClass()
  {
    return vem.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wen
 * JD-Core Version:    0.7.0.1
 */