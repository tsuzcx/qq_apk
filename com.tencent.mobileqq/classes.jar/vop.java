import android.support.annotation.NonNull;
import android.text.TextUtils;

public class vop
{
  @NonNull
  public static voh a(String paramString, voi paramvoi)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return new vsg(paramvoi);
    }
    if (TextUtils.equals(paramString, "follow_tab")) {
      return new vsa(paramvoi);
    }
    if ((TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest"))) {
      return new vse(paramvoi);
    }
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new vrz(paramvoi);
    }
    if (TextUtils.equals(paramString, "friend_feed")) {
      return new vsc(paramvoi);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return new vsd(paramvoi);
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new vry(paramvoi);
    }
    return new vsg(paramvoi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vop
 * JD-Core Version:    0.7.0.1
 */