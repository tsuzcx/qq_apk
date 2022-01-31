import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class utp
  extends QQUIEventReceiver<uth, uzj>
{
  public utp(@NonNull uth paramuth)
  {
    super(paramuth);
  }
  
  public void a(@NonNull uth paramuth, @NonNull uzj paramuzj)
  {
    utr localutr = paramuth.a;
    if (localutr != null) {
      localutr.a(paramuth.a());
    }
    for (;;)
    {
      urp.b("edit_video", "face_list_success", 0, paramuzj.a.errorCode, new String[0]);
      return;
      urk.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return uzj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     utp
 * JD-Core Version:    0.7.0.1
 */