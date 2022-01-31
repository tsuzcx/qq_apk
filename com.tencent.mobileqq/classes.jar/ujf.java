import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ujf
  extends QQUIEventReceiver<ujd, svy>
{
  public ujf(@NonNull ujd paramujd)
  {
    super(paramujd);
  }
  
  public void a(@NonNull ujd paramujd, @NonNull svy paramsvy)
  {
    if ((paramujd.a == null) || (paramsvy.a == null) || (!TextUtils.equals(paramujd.a.a, paramsvy.a.mVid))) {}
    do
    {
      return;
      paramujd.i();
      paramujd = (uax)paramujd.a(uax.class);
    } while (paramujd == null);
    paramujd.d();
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujf
 * JD-Core Version:    0.7.0.1
 */