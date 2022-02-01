import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class zcf
  implements woy<xcx, xer>
{
  zcf(zbz paramzbz, WeakReference paramWeakReference) {}
  
  public void a(@NonNull xcx paramxcx, @Nullable xer paramxer, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramxer == null)
    {
      paramxcx = (zcm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramxcx != null) {
        paramxcx.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramxcx = (zcm)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramxcx != null)
    {
      paramxcx.a(0, paramxer.a);
      return;
    }
    yuk.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcf
 * JD-Core Version:    0.7.0.1
 */