import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wcd
  extends QQUIEventReceiver<wcb, uow>
{
  public wcd(@NonNull wcb paramwcb)
  {
    super(paramwcb);
  }
  
  public void a(@NonNull wcb paramwcb, @NonNull uow paramuow)
  {
    if ((paramwcb.a == null) || (paramuow.a == null) || (!TextUtils.equals(paramwcb.a.a, paramuow.a.mVid))) {}
    do
    {
      return;
      paramwcb.i();
      paramwcb = (vtv)paramwcb.a(vtv.class);
    } while (paramwcb == null);
    paramwcb.d();
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcd
 * JD-Core Version:    0.7.0.1
 */