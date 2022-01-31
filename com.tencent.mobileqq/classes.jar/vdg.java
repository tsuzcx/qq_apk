import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vdg
  extends QQUIEventReceiver<vcp, tkk>
{
  public vdg(@NonNull vcp paramvcp)
  {
    super(paramvcp);
  }
  
  public void a(@NonNull vcp paramvcp, @NonNull tkk paramtkk)
  {
    if ((paramtkk == null) || (paramtkk.a == null) || (TextUtils.isEmpty(paramtkk.a.headUrl))) {
      ved.c(this.TAG, "GetUserInfoHandler return headUrl is null!", new IllegalStateException());
    }
    while (!paramtkk.a.isMe()) {
      return;
    }
    vcp.b(paramvcp);
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdg
 * JD-Core Version:    0.7.0.1
 */