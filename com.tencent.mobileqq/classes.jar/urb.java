import android.support.annotation.NonNull;
import android.text.TextUtils;

public class urb
{
  @NonNull
  public static uqt a(String paramString, uqu paramuqu)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return new uuq(paramuqu);
    }
    if (TextUtils.equals(paramString, "follow_tab")) {
      return new uui(paramuqu);
    }
    if ((TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest"))) {
      return new uuo(paramuqu);
    }
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new uuh(paramuqu);
    }
    if (TextUtils.equals(paramString, "friend_feed")) {
      return new uuk(paramuqu);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return new uul(paramuqu);
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new uug(paramuqu);
    }
    return new uuq(paramuqu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urb
 * JD-Core Version:    0.7.0.1
 */