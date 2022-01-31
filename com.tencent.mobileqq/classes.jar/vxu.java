import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vxu
  extends QQUIEventReceiver<vxs, ukn>
{
  public vxu(@NonNull vxs paramvxs)
  {
    super(paramvxs);
  }
  
  public void a(@NonNull vxs paramvxs, @NonNull ukn paramukn)
  {
    if ((paramvxs.a == null) || (paramukn.a == null) || (!TextUtils.equals(paramvxs.a.a, paramukn.a.mVid))) {}
    do
    {
      return;
      paramvxs.i();
      paramvxs = (vpm)paramvxs.a(vpm.class);
    } while (paramvxs == null);
    paramvxs.d();
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxu
 * JD-Core Version:    0.7.0.1
 */