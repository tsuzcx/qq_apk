import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xuh
  extends QQUIEventReceiver<xug, wii>
{
  public xuh(@NonNull xug paramxug)
  {
    super(paramxug);
  }
  
  public void a(@NonNull xug paramxug, @NonNull wii paramwii)
  {
    if ((xug.a(paramxug) == null) || (paramwii.a == null) || (!TextUtils.equals(xug.a(paramxug).a, paramwii.a.mVid))) {
      return;
    }
    paramxug.a.i();
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuh
 * JD-Core Version:    0.7.0.1
 */