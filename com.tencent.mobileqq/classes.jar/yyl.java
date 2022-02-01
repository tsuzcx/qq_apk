import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class yyl
  implements wld<wys, xaq>
{
  yyl(yye paramyye) {}
  
  public void a(@NonNull wys paramwys, @Nullable xaq paramxaq, @NonNull ErrorMessage paramErrorMessage)
  {
    yqp.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramxaq + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramwys.a, this.a.jdField_b_of_type_JavaLangString))
      {
        yqp.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramxaq);
        return;
      }
      if ((paramxaq == null) || (paramErrorMessage.isFail()))
      {
        yqp.d("DoodleEmojiManager", "get emoji error : " + paramxaq + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramxaq.a;
    this.a.a(TextUtils.isEmpty(paramwys.a), paramxaq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyl
 * JD-Core Version:    0.7.0.1
 */