import android.support.annotation.NonNull;
import android.text.TextUtils;

public class tmn
{
  @NonNull
  public static tmi a(String paramString, tmj paramtmj)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return new tns(paramtmj);
    }
    if (TextUtils.equals(paramString, "follow_tab")) {
      return new tno(paramtmj);
    }
    if ((TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest"))) {
      return new tnq(paramtmj);
    }
    return new tns(paramtmj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmn
 * JD-Core Version:    0.7.0.1
 */