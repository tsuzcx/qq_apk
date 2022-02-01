import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xpp
  extends QQUIEventReceiver<xpn, wcx>
{
  public xpp(@NonNull xpn paramxpn)
  {
    super(paramxpn);
  }
  
  public void a(@NonNull xpn paramxpn, @NonNull wcx paramwcx)
  {
    if ((paramxpn.a == null) || (paramwcx.a == null) || (!TextUtils.equals(paramxpn.a.a, paramwcx.a.mVid))) {}
    do
    {
      return;
      paramxpn.i();
      paramxpn = (xhh)paramxpn.a(xhh.class);
    } while (paramxpn == null);
    paramxpn.d();
  }
  
  public Class acceptEventClass()
  {
    return wcx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpp
 * JD-Core Version:    0.7.0.1
 */