import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class wva
  extends QQUIEventReceiver<wus, xau>
{
  public wva(@NonNull wus paramwus)
  {
    super(paramwus);
  }
  
  public void a(@NonNull wus paramwus, @NonNull xau paramxau)
  {
    wvc localwvc = paramwus.a;
    if (localwvc != null) {
      localwvc.a(paramwus.a());
    }
    for (;;)
    {
      wta.b("edit_video", "face_list_success", 0, paramxau.a.errorCode, new String[0]);
      return;
      wsv.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return xau.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wva
 * JD-Core Version:    0.7.0.1
 */