import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class ysu
  extends QQUIEventReceiver<ysm, yyo>
{
  public ysu(@NonNull ysm paramysm)
  {
    super(paramysm);
  }
  
  public void a(@NonNull ysm paramysm, @NonNull yyo paramyyo)
  {
    ysw localysw = paramysm.a;
    if (localysw != null) {
      localysw.a(paramysm.a());
    }
    for (;;)
    {
      yqu.b("edit_video", "face_list_success", 0, paramyyo.a.errorCode, new String[0]);
      return;
      yqp.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return yyo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysu
 * JD-Core Version:    0.7.0.1
 */