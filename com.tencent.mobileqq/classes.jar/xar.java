import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xar
  implements uni<vax, vcv>
{
  xar(xak paramxak) {}
  
  public void a(@NonNull vax paramvax, @Nullable vcv paramvcv, @NonNull ErrorMessage paramErrorMessage)
  {
    wsv.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramvcv + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramvax.a, this.a.jdField_b_of_type_JavaLangString))
      {
        wsv.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramvcv);
        return;
      }
      if ((paramvcv == null) || (paramErrorMessage.isFail()))
      {
        wsv.d("DoodleEmojiManager", "get emoji error : " + paramvcv + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramvcv.a;
    this.a.a(TextUtils.isEmpty(paramvax.a), paramvcv, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xar
 * JD-Core Version:    0.7.0.1
 */