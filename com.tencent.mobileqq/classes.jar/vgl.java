import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.QQUIEventReceiver;

class vgl
  extends QQUIEventReceiver<vgd, vmf>
{
  public vgl(@NonNull vgd paramvgd)
  {
    super(paramvgd);
  }
  
  public void a(@NonNull vgd paramvgd, @NonNull vmf paramvmf)
  {
    vgn localvgn = paramvgd.a;
    if (localvgn != null) {
      localvgn.a(paramvgd.a());
    }
    for (;;)
    {
      vel.b("edit_video", "face_list_success", 0, paramvmf.a.errorCode, new String[0]);
      return;
      veg.b(this.TAG, "DoodleEmojiListEventReceiver adapter is null");
    }
  }
  
  public Class acceptEventClass()
  {
    return vmf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vgl
 * JD-Core Version:    0.7.0.1
 */