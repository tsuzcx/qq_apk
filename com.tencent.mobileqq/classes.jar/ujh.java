import UserGrowth.stSchema;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class ujh
  implements ujg
{
  public uiv a(uix paramuix)
  {
    if ((zqd.a(BaseApplicationImpl.getContext())) && (!TextUtils.isEmpty(paramuix.a().schema))) {
      return new uiz(paramuix);
    }
    if (!TextUtils.isEmpty(paramuix.a().miniAppSchema)) {
      return new ujc(paramuix);
    }
    if (!TextUtils.isEmpty(paramuix.a().H5Url)) {
      return new ujf(paramuix);
    }
    if (zqd.a(BaseApplicationImpl.getContext())) {
      return new uiz(paramuix);
    }
    return new ujb(paramuix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujh
 * JD-Core Version:    0.7.0.1
 */