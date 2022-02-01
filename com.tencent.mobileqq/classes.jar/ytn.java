import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ytn
  extends QQUIEventReceiver<ysw, xas>
{
  public ytn(@NonNull ysw paramysw)
  {
    super(paramysw);
  }
  
  public void a(@NonNull ysw paramysw, @NonNull xas paramxas)
  {
    if ((paramxas == null) || (paramxas.a == null) || (TextUtils.isEmpty(paramxas.a.headUrl))) {
      yuk.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramxas.a.isMe()) {
      return;
    }
    ysw.b(paramysw);
  }
  
  public Class acceptEventClass()
  {
    return xas.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytn
 * JD-Core Version:    0.7.0.1
 */