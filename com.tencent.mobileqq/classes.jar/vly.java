import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class vly
  implements syq<tmp, toj>
{
  vly(vls paramvls, WeakReference paramWeakReference) {}
  
  public void a(@NonNull tmp paramtmp, @Nullable toj paramtoj, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramtoj == null)
    {
      paramtmp = (vmf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramtmp != null) {
        paramtmp.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramtmp = (vmf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramtmp != null)
    {
      paramtmp.a(0, paramtoj.a);
      return;
    }
    ved.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vly
 * JD-Core Version:    0.7.0.1
 */