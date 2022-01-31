import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wry
  extends QQUIEventReceiver<wrh, uzc>
{
  public wry(@NonNull wrh paramwrh)
  {
    super(paramwrh);
  }
  
  public void a(@NonNull wrh paramwrh, @NonNull uzc paramuzc)
  {
    if ((paramuzc == null) || (paramuzc.a == null) || (TextUtils.isEmpty(paramuzc.a.headUrl))) {
      wsv.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramuzc.a.isMe()) {
      return;
    }
    wrh.b(paramwrh);
  }
  
  public Class acceptEventClass()
  {
    return uzc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wry
 * JD-Core Version:    0.7.0.1
 */