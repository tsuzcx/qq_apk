import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class vmc
  implements syt<tmi, tog>
{
  vmc(vlv paramvlv) {}
  
  public void a(@NonNull tmi paramtmi, @Nullable tog paramtog, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramtog + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramtmi.a, this.a.jdField_b_of_type_JavaLangString))
      {
        veg.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramtog);
        return;
      }
      if ((paramtog == null) || (paramErrorMessage.isFail()))
      {
        veg.d("DoodleEmojiManager", "get emoji error : " + paramtog + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramtog.a;
    this.a.a(TextUtils.isEmpty(paramtmi.a), paramtog, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmc
 * JD-Core Version:    0.7.0.1
 */