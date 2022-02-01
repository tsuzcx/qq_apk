import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.lang.ref.WeakReference;
import java.util.Collections;

class yyk
  implements wld<wzc, xaw>
{
  yyk(yye paramyye, WeakReference paramWeakReference) {}
  
  public void a(@NonNull wzc paramwzc, @Nullable xaw paramxaw, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramxaw == null)
    {
      paramwzc = (yyr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramwzc != null) {
        paramwzc.a(paramErrorMessage.errorCode, Collections.EMPTY_LIST);
      }
      return;
    }
    paramwzc = (yyr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramwzc != null)
    {
      paramwzc.a(0, paramxaw.a);
      return;
    }
    yqp.c("DoodleEmojiManager", "requestPoiFaces callback is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyk
 * JD-Core Version:    0.7.0.1
 */