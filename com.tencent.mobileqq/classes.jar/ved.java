import UserGrowth.stSchema;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class ved
  implements vec
{
  public vdr a(vdt paramvdt)
  {
    if ((zfn.a(BaseApplicationImpl.getContext())) && (!TextUtils.isEmpty(paramvdt.a().schema))) {
      return new vdv(paramvdt);
    }
    if (!TextUtils.isEmpty(paramvdt.a().miniAppSchema)) {
      return new vdy(paramvdt);
    }
    if (!TextUtils.isEmpty(paramvdt.a().H5Url)) {
      return new veb(paramvdt);
    }
    if (zfn.a(BaseApplicationImpl.getContext())) {
      return new vdv(paramvdt);
    }
    return new vdx(paramvdt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ved
 * JD-Core Version:    0.7.0.1
 */