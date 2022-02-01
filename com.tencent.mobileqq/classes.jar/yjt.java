import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class yjt
  extends QQUIEventReceiver<yjc, wrd>
{
  public yjt(@NonNull yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull wrd paramwrd)
  {
    if ((paramwrd == null) || (paramwrd.a == null) || (TextUtils.isEmpty(paramwrd.a.headUrl))) {
      ykq.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramwrd.a.isMe()) {
      return;
    }
    yjc.b(paramyjc);
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjt
 * JD-Core Version:    0.7.0.1
 */