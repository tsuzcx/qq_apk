import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class xaq
  implements uni<vbh, vdb>
{
  xaq(xak paramxak, WeakReference paramWeakReference) {}
  
  public void a(@NonNull vbh paramvbh, @Nullable vdb paramvdb, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramvdb == null)
    {
      paramvbh = (xax)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramvbh != null) {
        paramvbh.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramvbh = (xax)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramvbh != null)
    {
      paramvbh.a(0, paramvdb.a);
      return;
    }
    wsv.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xaq
 * JD-Core Version:    0.7.0.1
 */