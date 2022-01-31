import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vdj
  extends QQUIEventReceiver<vcs, tkn>
{
  public vdj(@NonNull vcs paramvcs)
  {
    super(paramvcs);
  }
  
  public void a(@NonNull vcs paramvcs, @NonNull tkn paramtkn)
  {
    if ((paramtkn == null) || (paramtkn.a == null) || (TextUtils.isEmpty(paramtkn.a.headUrl))) {
      veg.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramtkn.a.isMe()) {
      return;
    }
    vcs.b(paramvcs);
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdj
 * JD-Core Version:    0.7.0.1
 */