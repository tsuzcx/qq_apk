import UserGrowth.stSchema;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class ojz
  implements ojy
{
  public ojn a(ojp paramojp)
  {
    if ((rpw.isWeishiInstalled(BaseApplicationImpl.getContext())) && (!TextUtils.isEmpty(paramojp.a().schema))) {
      return new ojr(paramojp);
    }
    if (!TextUtils.isEmpty(paramojp.a().miniAppSchema)) {
      return new oju(paramojp);
    }
    if (!TextUtils.isEmpty(paramojp.a().H5Url)) {
      return new ojx(paramojp);
    }
    if (rpw.isWeishiInstalled(BaseApplicationImpl.getContext())) {
      return new ojr(paramojp);
    }
    return new ojt(paramojp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojz
 * JD-Core Version:    0.7.0.1
 */