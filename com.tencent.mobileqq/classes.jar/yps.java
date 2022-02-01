import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yps
  extends QQUIEventReceiver<ypb, wwx>
{
  public yps(@NonNull ypb paramypb)
  {
    super(paramypb);
  }
  
  public void a(@NonNull ypb paramypb, @NonNull wwx paramwwx)
  {
    if ((paramwwx == null) || (paramwwx.a == null) || (TextUtils.isEmpty(paramwwx.a.headUrl))) {
      yqp.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramwwx.a.isMe()) {
      return;
    }
    ypb.b(paramypb);
  }
  
  public Class acceptEventClass()
  {
    return wwx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yps
 * JD-Core Version:    0.7.0.1
 */