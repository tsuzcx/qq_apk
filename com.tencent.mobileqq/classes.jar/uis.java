import UserGrowth.stSchema;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class uis
  implements uir
{
  public uig a(uii paramuii)
  {
    if ((zmi.a(BaseApplicationImpl.getContext())) && (!TextUtils.isEmpty(paramuii.a().schema))) {
      return new uik(paramuii);
    }
    if (!TextUtils.isEmpty(paramuii.a().miniAppSchema)) {
      return new uin(paramuii);
    }
    if (!TextUtils.isEmpty(paramuii.a().H5Url)) {
      return new uiq(paramuii);
    }
    if (zmi.a(BaseApplicationImpl.getContext())) {
      return new uik(paramuii);
    }
    return new uim(paramuii);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uis
 * JD-Core Version:    0.7.0.1
 */