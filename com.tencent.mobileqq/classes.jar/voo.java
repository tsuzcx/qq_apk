import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class voo
  implements moc
{
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngQuantUtils", 2, "checkUpByBusinessId loaded,code=" + paramInt);
    }
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramString)) && (paramString.contains("url"))) {
      PngQuantUtils.a.set(false);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     voo
 * JD-Core Version:    0.7.0.1
 */