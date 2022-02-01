import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ymt
  extends QQUIEventReceiver<yml, ysk>
{
  public ymt(@NonNull yml paramyml)
  {
    super(paramyml);
  }
  
  public void a(@NonNull yml paramyml, @NonNull ysk paramysk)
  {
    ymv localymv = paramyml.a;
    if (localymv != null) {
      localymv.a(paramyml.a());
    }
    for (;;)
    {
      ykv.b("edit_video", "face_list_success", 0, paramysk.a.errorCode, new String[0]);
      return;
      ykq.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return ysk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymt
 * JD-Core Version:    0.7.0.1
 */