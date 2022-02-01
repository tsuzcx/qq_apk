import android.support.annotation.NonNull;
import android.text.TextUtils;

public class usc
{
  @NonNull
  public static uru a(String paramString, urv paramurv)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return new uvs(paramurv);
    }
    if (TextUtils.equals(paramString, "follow_tab")) {
      return new uvk(paramurv);
    }
    if ((TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest"))) {
      return new uvq(paramurv);
    }
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new uvj(paramurv);
    }
    if (TextUtils.equals(paramString, "friend_feed")) {
      return new uvm(paramurv);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return new uvn(paramurv);
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new uvi(paramurv);
    }
    return new uvs(paramurv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usc
 * JD-Core Version:    0.7.0.1
 */