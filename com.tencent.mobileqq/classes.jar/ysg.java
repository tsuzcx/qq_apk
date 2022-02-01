import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class ysg
  implements wfk<wti, wvc>
{
  ysg(ysa paramysa, WeakReference paramWeakReference) {}
  
  public void a(@NonNull wti paramwti, @Nullable wvc paramwvc, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramwvc == null)
    {
      paramwti = (ysn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramwti != null) {
        paramwti.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramwti = (ysn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramwti != null)
    {
      paramwti.a(0, paramwvc.a);
      return;
    }
    ykq.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysg
 * JD-Core Version:    0.7.0.1
 */