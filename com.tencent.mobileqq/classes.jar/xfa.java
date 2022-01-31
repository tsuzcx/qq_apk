import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class xfa
  implements urr<vfg, vhe>
{
  xfa(xet paramxet) {}
  
  public void a(@NonNull vfg paramvfg, @Nullable vhe paramvhe, @NonNull ErrorMessage paramErrorMessage)
  {
    wxe.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramvhe + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramvfg.a, this.a.jdField_b_of_type_JavaLangString))
      {
        wxe.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramvhe);
        return;
      }
      if ((paramvhe == null) || (paramErrorMessage.isFail()))
      {
        wxe.d("DoodleEmojiManager", "get emoji error : " + paramvhe + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramvhe.a;
    this.a.a(TextUtils.isEmpty(paramvfg.a), paramvhe, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xfa
 * JD-Core Version:    0.7.0.1
 */