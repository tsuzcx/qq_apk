import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xvo
  extends QQUIEventReceiver<xvm, wii>
{
  public xvo(@NonNull xvm paramxvm)
  {
    super(paramxvm);
  }
  
  public void a(@NonNull xvm paramxvm, @NonNull wii paramwii)
  {
    if ((paramxvm.a == null) || (paramwii.a == null) || (!TextUtils.equals(paramxvm.a.a, paramwii.a.mVid))) {}
    do
    {
      return;
      paramxvm.i();
      paramxvm = (xng)paramxvm.a(xng.class);
    } while (paramxvm == null);
    paramxvm.d();
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvo
 * JD-Core Version:    0.7.0.1
 */