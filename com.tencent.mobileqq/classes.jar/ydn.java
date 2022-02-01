import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class ydn
  implements vqp<wen, wgh>
{
  ydn(ydh paramydh, WeakReference paramWeakReference) {}
  
  public void a(@NonNull wen paramwen, @Nullable wgh paramwgh, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramwgh == null)
    {
      paramwen = (ydu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramwen != null) {
        paramwen.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramwen = (ydu)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramwen != null)
    {
      paramwen.a(0, paramwgh.a);
      return;
    }
    xvv.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydn
 * JD-Core Version:    0.7.0.1
 */