import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class twj
  extends QQUIEventReceiver<twh, sjc>
{
  public twj(@NonNull twh paramtwh)
  {
    super(paramtwh);
  }
  
  public void a(@NonNull twh paramtwh, @NonNull sjc paramsjc)
  {
    if ((paramtwh.a == null) || (paramsjc.a == null) || (!TextUtils.equals(paramtwh.a.a, paramsjc.a.mVid))) {}
    do
    {
      return;
      paramtwh.i();
      paramtwh = (tob)paramtwh.a(tob.class);
    } while (paramtwh == null);
    paramtwh.d();
  }
  
  public Class acceptEventClass()
  {
    return sjc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twj
 * JD-Core Version:    0.7.0.1
 */