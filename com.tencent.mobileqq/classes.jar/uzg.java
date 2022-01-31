import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class uzg
  implements slx<szm, tbk>
{
  uzg(uyz paramuyz) {}
  
  public void a(@NonNull szm paramszm, @Nullable tbk paramtbk, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramtbk + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramszm.a, this.a.jdField_b_of_type_JavaLangString))
      {
        urk.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramtbk);
        return;
      }
      if ((paramtbk == null) || (paramErrorMessage.isFail()))
      {
        urk.d("DoodleEmojiManager", "get emoji error : " + paramtbk + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramtbk.a;
    this.a.a(TextUtils.isEmpty(paramszm.a), paramtbk, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uzg
 * JD-Core Version:    0.7.0.1
 */