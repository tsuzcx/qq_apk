import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;

class rgw
  implements ppv.b<pys, qaf>
{
  rgw(rgp paramrgp) {}
  
  public void a(@NonNull pys parampys, @Nullable qaf paramqaf, @NonNull ErrorMessage paramErrorMessage)
  {
    ram.d("DoodleEmojiManager", "fireRequestEmojiPackList, result : " + paramqaf + ", errorMsg = " + paramErrorMessage);
    synchronized (this.a.bw)
    {
      if (!TextUtils.equals(parampys.mCookie, this.a.mCookie))
      {
        ram.w("DoodleEmojiManager", "cookie mismatch ! ignore this response : " + paramqaf);
        return;
      }
      if ((paramqaf == null) || (paramErrorMessage.isFail()))
      {
        ram.w("DoodleEmojiManager", "get emoji error : " + paramqaf + ", " + paramErrorMessage);
        return;
      }
    }
    this.a.mCookie = paramqaf.avr;
    this.a.a(TextUtils.isEmpty(parampys.mCookie), paramqaf, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgw
 * JD-Core Version:    0.7.0.1
 */