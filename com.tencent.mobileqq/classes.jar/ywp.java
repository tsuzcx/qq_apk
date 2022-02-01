import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ywp
  extends QQUIEventReceiver<ywh, zcj>
{
  public ywp(@NonNull ywh paramywh)
  {
    super(paramywh);
  }
  
  public void a(@NonNull ywh paramywh, @NonNull zcj paramzcj)
  {
    ywr localywr = paramywh.a;
    if (localywr != null) {
      localywr.a(paramywh.a());
    }
    for (;;)
    {
      yup.b("edit_video", "face_list_success", 0, paramzcj.a.errorCode, new String[0]);
      return;
      yuk.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return zcj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywp
 * JD-Core Version:    0.7.0.1
 */