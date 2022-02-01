import android.support.annotation.NonNull;
import android.text.TextUtils;

public class oqk
{
  @NonNull
  public static oqi.a a(String paramString, oqi.b paramb)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return new osu(paramb);
    }
    if (TextUtils.equals(paramString, "follow_tab")) {
      return new osq(paramb);
    }
    if ((TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest"))) {
      return new oss(paramb);
    }
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return new osp(paramb);
    }
    return new osu(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqk
 * JD-Core Version:    0.7.0.1
 */