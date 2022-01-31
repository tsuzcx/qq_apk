import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class vgi
  extends QQUIEventReceiver<vga, vmc>
{
  public vgi(@NonNull vga paramvga)
  {
    super(paramvga);
  }
  
  public void a(@NonNull vga paramvga, @NonNull vmc paramvmc)
  {
    vgk localvgk = paramvga.a;
    if (localvgk != null) {
      localvgk.a(paramvga.a());
    }
    for (;;)
    {
      vei.b("edit_video", "face_list_success", 0, paramvmc.a.errorCode, new String[0]);
      return;
      ved.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return vmc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgi
 * JD-Core Version:    0.7.0.1
 */