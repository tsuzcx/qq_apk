import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wzn
  extends QQUIEventReceiver<wzm, voc>
{
  public wzn(@NonNull wzm paramwzm)
  {
    super(paramwzm);
  }
  
  public void a(@NonNull wzm paramwzm, @NonNull voc paramvoc)
  {
    if ((wzm.a(paramwzm) == null) || (paramvoc.a == null) || (!TextUtils.equals(wzm.a(paramwzm).a, paramvoc.a.mVid))) {
      return;
    }
    paramwzm.a.i();
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzn
 * JD-Core Version:    0.7.0.1
 */