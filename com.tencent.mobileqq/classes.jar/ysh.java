import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ysh
  implements wfk<wsy, wuw>
{
  ysh(ysa paramysa) {}
  
  public void a(@NonNull wsy paramwsy, @Nullable wuw paramwuw, @NonNull ErrorMessage paramErrorMessage)
  {
    ykq.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramwuw + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramwsy.a, this.a.jdField_b_of_type_JavaLangString))
      {
        ykq.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramwuw);
        return;
      }
      if ((paramwuw == null) || (paramErrorMessage.isFail()))
      {
        ykq.d("DoodleEmojiManager", "get emoji error : " + paramwuw + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramwuw.a;
    this.a.a(TextUtils.isEmpty(paramwsy.a), paramwuw, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ysh
 * JD-Core Version:    0.7.0.1
 */