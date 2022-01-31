import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ujc
  extends QQUIEventReceiver<uja, svv>
{
  public ujc(@NonNull uja paramuja)
  {
    super(paramuja);
  }
  
  public void a(@NonNull uja paramuja, @NonNull svv paramsvv)
  {
    if ((paramuja.a == null) || (paramsvv.a == null) || (!TextUtils.equals(paramuja.a.a, paramsvv.a.mVid))) {}
    do
    {
      return;
      paramuja.i();
      paramuja = (uau)paramuja.a(uau.class);
    } while (paramuja == null);
    paramuja.d();
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujc
 * JD-Core Version:    0.7.0.1
 */