import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xya
  extends QQUIEventReceiver<xxs, ydr>
{
  public xya(@NonNull xxs paramxxs)
  {
    super(paramxxs);
  }
  
  public void a(@NonNull xxs paramxxs, @NonNull ydr paramydr)
  {
    xyc localxyc = paramxxs.a;
    if (localxyc != null) {
      localxyc.a(paramxxs.a());
    }
    for (;;)
    {
      xwa.b("edit_video", "face_list_success", 0, paramydr.a.errorCode, new String[0]);
      return;
      xvv.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return ydr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xya
 * JD-Core Version:    0.7.0.1
 */