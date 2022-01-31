import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class vmb
  implements syt<tms, tom>
{
  vmb(vlv paramvlv, WeakReference paramWeakReference) {}
  
  public void a(@NonNull tms paramtms, @Nullable tom paramtom, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtom == null)
    {
      paramtms = (vmi)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramtms != null) {
        paramtms.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramtms = (vmi)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramtms != null)
    {
      paramtms.a(0, paramtom.a);
      return;
    }
    veg.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmb
 * JD-Core Version:    0.7.0.1
 */