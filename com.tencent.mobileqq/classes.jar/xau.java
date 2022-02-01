import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xau
  extends QQUIEventReceiver<xas, voc>
{
  public xau(@NonNull xas paramxas)
  {
    super(paramxas);
  }
  
  public void a(@NonNull xas paramxas, @NonNull voc paramvoc)
  {
    if ((paramxas.a == null) || (paramvoc.a == null) || (!TextUtils.equals(paramxas.a.a, paramvoc.a.mVid))) {}
    do
    {
      return;
      paramxas.i();
      paramxas = (wsm)paramxas.a(wsm.class);
    } while (paramxas == null);
    paramxas.d();
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xau
 * JD-Core Version:    0.7.0.1
 */