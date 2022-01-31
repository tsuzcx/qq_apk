import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager.OnSingleDownloadCallback;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;

public class xjm
  implements PreloadImgManager.OnSingleDownloadCallback
{
  public xjm(QzoneHbFragment paramQzoneHbFragment) {}
  
  public void a() {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof Bitmap))
    {
      paramObject = QzoneHbFragment.a(this.a).obtainMessage();
      paramObject.what = 102;
      QzoneHbFragment.a(this.a).sendMessage(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xjm
 * JD-Core Version:    0.7.0.1
 */