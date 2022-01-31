import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class uqn
  extends QQUIEventReceiver<upw, sxr>
{
  public uqn(@NonNull upw paramupw)
  {
    super(paramupw);
  }
  
  public void a(@NonNull upw paramupw, @NonNull sxr paramsxr)
  {
    if ((paramsxr == null) || (paramsxr.a == null) || (TextUtils.isEmpty(paramsxr.a.headUrl))) {
      urk.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramsxr.a.isMe()) {
      return;
    }
    upw.b(paramupw);
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqn
 * JD-Core Version:    0.7.0.1
 */