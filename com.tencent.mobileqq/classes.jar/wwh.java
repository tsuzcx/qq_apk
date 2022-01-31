import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wwh
  extends QQUIEventReceiver<wvq, vdl>
{
  public wwh(@NonNull wvq paramwvq)
  {
    super(paramwvq);
  }
  
  public void a(@NonNull wvq paramwvq, @NonNull vdl paramvdl)
  {
    if ((paramvdl == null) || (paramvdl.a == null) || (TextUtils.isEmpty(paramvdl.a.headUrl))) {
      wxe.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramvdl.a.isMe()) {
      return;
    }
    wvq.b(paramwvq);
  }
  
  public Class acceptEventClass()
  {
    return vdl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwh
 * JD-Core Version:    0.7.0.1
 */