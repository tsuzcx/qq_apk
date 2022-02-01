import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class ydo
  implements vqp<wed, wgb>
{
  ydo(ydh paramydh) {}
  
  public void a(@NonNull wed paramwed, @Nullable wgb paramwgb, @NonNull ErrorMessage paramErrorMessage)
  {
    xvv.b("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramwgb + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.jdField_b_of_type_JavaLangObject)
    {
      if (!TextUtils.equals(paramwed.a, this.a.jdField_b_of_type_JavaLangString))
      {
        xvv.d("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramwgb);
        return;
      }
      if ((paramwgb == null) || (paramErrorMessage.isFail()))
      {
        xvv.d("DoodleEmojiManager", "get emoji error : " + paramwgb + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.jdField_b_of_type_JavaLangString = paramwgb.a;
    this.a.a(TextUtils.isEmpty(paramwed.a), paramwgb, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydo
 * JD-Core Version:    0.7.0.1
 */