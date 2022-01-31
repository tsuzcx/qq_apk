import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uhv
  extends QQUIEventReceiver<uhu, svv>
{
  public uhv(@NonNull uhu paramuhu)
  {
    super(paramuhu);
  }
  
  public void a(@NonNull uhu paramuhu, @NonNull svv paramsvv)
  {
    if ((uhu.a(paramuhu) == null) || (paramsvv.a == null) || (!TextUtils.equals(uhu.a(paramuhu).a, paramsvv.a.mVid))) {
      return;
    }
    paramuhu.a.i();
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhv
 * JD-Core Version:    0.7.0.1
 */