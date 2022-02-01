import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xzj
  extends QQUIEventReceiver<xzh, wmd>
{
  public xzj(@NonNull xzh paramxzh)
  {
    super(paramxzh);
  }
  
  public void a(@NonNull xzh paramxzh, @NonNull wmd paramwmd)
  {
    if ((paramxzh.a == null) || (paramwmd.a == null) || (!TextUtils.equals(paramxzh.a.a, paramwmd.a.mVid))) {}
    do
    {
      return;
      paramxzh.i();
      paramxzh = (xrb)paramxzh.a(xrb.class);
    } while (paramxzh == null);
    paramxzh.d();
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzj
 * JD-Core Version:    0.7.0.1
 */