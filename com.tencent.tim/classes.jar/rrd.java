import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class rrd
  implements jox
{
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngQuantUtils", 2, "checkUpByBusinessId loaded,code=" + paramInt);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("url"))) {
      PngQuantUtils.bc.set(false);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrd
 * JD-Core Version:    0.7.0.1
 */