import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class waw
  extends QQUIEventReceiver<wav, uow>
{
  public waw(@NonNull wav paramwav)
  {
    super(paramwav);
  }
  
  public void a(@NonNull wav paramwav, @NonNull uow paramuow)
  {
    if ((wav.a(paramwav) == null) || (paramuow.a == null) || (!TextUtils.equals(wav.a(paramwav).a, paramuow.a.mVid))) {
      return;
    }
    paramwav.a.i();
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     waw
 * JD-Core Version:    0.7.0.1
 */