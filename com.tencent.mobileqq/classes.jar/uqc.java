import UserGrowth.stSchema;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class uqc
  implements uqb
{
  public upq a(ups paramups)
  {
    if ((yqu.a(BaseApplicationImpl.getContext())) && (!TextUtils.isEmpty(paramups.a().schema))) {
      return new upu(paramups);
    }
    if (!TextUtils.isEmpty(paramups.a().miniAppSchema)) {
      return new upx(paramups);
    }
    if (!TextUtils.isEmpty(paramups.a().H5Url)) {
      return new uqa(paramups);
    }
    if (yqu.a(BaseApplicationImpl.getContext())) {
      return new upu(paramups);
    }
    return new upw(paramups);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqc
 * JD-Core Version:    0.7.0.1
 */