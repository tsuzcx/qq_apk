import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xoi
  extends QQUIEventReceiver<xoh, wcx>
{
  public xoi(@NonNull xoh paramxoh)
  {
    super(paramxoh);
  }
  
  public void a(@NonNull xoh paramxoh, @NonNull wcx paramwcx)
  {
    if ((xoh.a(paramxoh) == null) || (paramwcx.a == null) || (!TextUtils.equals(xoh.a(paramxoh).a, paramwcx.a.mVid))) {
      return;
    }
    paramxoh.a.i();
  }
  
  public Class acceptEventClass()
  {
    return wcx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoi
 * JD-Core Version:    0.7.0.1
 */