import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uhy
  extends QQUIEventReceiver<uhx, svy>
{
  public uhy(@NonNull uhx paramuhx)
  {
    super(paramuhx);
  }
  
  public void a(@NonNull uhx paramuhx, @NonNull svy paramsvy)
  {
    if ((uhx.a(paramuhx) == null) || (paramsvy.a == null) || (!TextUtils.equals(uhx.a(paramuhx).a, paramsvy.a.mVid))) {
      return;
    }
    paramuhx.a.i();
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhy
 * JD-Core Version:    0.7.0.1
 */