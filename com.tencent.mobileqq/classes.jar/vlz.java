import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vlz
  implements syq<tmf, tod>
{
  vlz(vls paramvls) {}
  
  public void a(@NonNull tmf paramtmf, @Nullable tod paramtod, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramtod + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramtmf.a, this.a.jdField_b_of_type_JavaLangString))
      {
        ved.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramtod);
        return;
      }
      if ((paramtod == null) || (paramErrorMessage.isFail()))
      {
        ved.d("DoodleEmojiManager", "get emoji error : " + paramtod + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramtod.a;
    this.a.a(TextUtils.isEmpty(paramtmf.a), paramtod, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vlz
 * JD-Core Version:    0.7.0.1
 */