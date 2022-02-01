import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class zcg
  implements woy<xcn, xel>
{
  zcg(zbz paramzbz) {}
  
  public void a(@NonNull xcn paramxcn, @Nullable xel paramxel, @NonNull ErrorMessage paramErrorMessage)
  {
    yuk.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramxel + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramxcn.a, this.a.jdField_b_of_type_JavaLangString))
      {
        yuk.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramxel);
        return;
      }
      if ((paramxel == null) || (paramErrorMessage.isFail()))
      {
        yuk.d("DoodleEmojiManager", "get emoji error : " + paramxel + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramxel.a;
    this.a.a(TextUtils.isEmpty(paramxcn.a), paramxel, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zcg
 * JD-Core Version:    0.7.0.1
 */