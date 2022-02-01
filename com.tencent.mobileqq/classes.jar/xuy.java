import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xuy
  extends QQUIEventReceiver<xuh, wci>
{
  public xuy(@NonNull xuh paramxuh)
  {
    super(paramxuh);
  }
  
  public void a(@NonNull xuh paramxuh, @NonNull wci paramwci)
  {
    if ((paramwci == null) || (paramwci.a == null) || (TextUtils.isEmpty(paramwci.a.headUrl))) {
      xvv.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramwci.a.isMe()) {
      return;
    }
    xuh.b(paramxuh);
  }
  
  public Class acceptEventClass()
  {
    return wci.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xuy
 * JD-Core Version:    0.7.0.1
 */