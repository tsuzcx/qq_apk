import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vwn
  extends QQUIEventReceiver<vwm, ukn>
{
  public vwn(@NonNull vwm paramvwm)
  {
    super(paramvwm);
  }
  
  public void a(@NonNull vwm paramvwm, @NonNull ukn paramukn)
  {
    if ((vwm.a(paramvwm) == null) || (paramukn.a == null) || (!TextUtils.equals(vwm.a(paramvwm).a, paramukn.a.mVid))) {
      return;
    }
    paramvwm.a.i();
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwn
 * JD-Core Version:    0.7.0.1
 */