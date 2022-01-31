import android.media.MediaMetadataRetriever;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaDatabaseHelper;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class xcd
  implements Runnable
{
  public xcd(MediaScanner paramMediaScanner, WeakReference paramWeakReference1, WeakReference paramWeakReference2, int paramInt) {}
  
  public void run()
  {
    try
    {
      LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      MediaScanner.OnMediaScannerListener localOnMediaScannerListener = (MediaScanner.OnMediaScannerListener)this.b.get();
      if (localLocalMediaInfo != null)
      {
        if (localOnMediaScannerListener == null) {
          return;
        }
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(localLocalMediaInfo.path);
        localLocalMediaInfo.mDuration = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
        localOnMediaScannerListener.a(this.jdField_a_of_type_Int, localLocalMediaInfo);
        MediaScanner.a(MediaScanner.a(BaseApplicationImpl.getContext())).a(localLocalMediaInfo.path, localLocalMediaInfo.mDuration);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaScanner", 2, "queryMediaInfoDuration() error=" + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcd
 * JD-Core Version:    0.7.0.1
 */