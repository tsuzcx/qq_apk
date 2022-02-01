import android.support.annotation.NonNull;
import android.text.TextUtils;

public class uzx
{
  @NonNull
  public static uzp a(String paramString, uzq paramuzq)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return new vdn(paramuzq);
    }
    if (TextUtils.equals(paramString, "follow_tab")) {
      return new vdf(paramuzq);
    }
    if ((TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest"))) {
      return new vdl(paramuzq);
    }
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new vde(paramuzq);
    }
    if (TextUtils.equals(paramString, "friend_feed")) {
      return new vdh(paramuzq);
    }
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return new vdi(paramuzq);
    }
    if (TextUtils.equals(paramString, "qqchat")) {
      return new vdd(paramuzq);
    }
    return new vdn(paramuzq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzx
 * JD-Core Version:    0.7.0.1
 */