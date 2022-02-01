import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.Subscriber;
import java.lang.ref.WeakReference;
import java.util.List;

public class ydy
  implements Subscriber
{
  private WeakReference<QQStoryBaseActivity> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ydy(QQStoryBaseActivity paramQQStoryBaseActivity1, QQStoryBaseActivity paramQQStoryBaseActivity2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQStoryBaseActivity2);
  }
  
  public void accept(@NonNull List<Class<? extends Dispatcher.Dispatchable>> paramList)
  {
    paramList.add(zoe.class);
  }
  
  public void handleDispatch(@NonNull Dispatcher.Dispatchable paramDispatchable)
  {
    paramDispatchable = (QQStoryBaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramDispatchable != null) {
      paramDispatchable.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydy
 * JD-Core Version:    0.7.0.1
 */