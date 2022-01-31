import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.common.GloableValue;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;

public class xtt
  implements Runnable
{
  public xtt(EditLocalVideoActivity paramEditLocalVideoActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity.getResources().getDisplayMetrics().widthPixels / 6;
    float f = this.jdField_a_of_type_Int * 1.0F / this.b;
    int k;
    int n;
    int m;
    int j;
    if (f <= 1.0F)
    {
      k = (int)(i / f);
      n = (k - i) / 2;
      m = 0;
      j = i;
      if (!TextUtils.isEmpty(EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity))) {
        break label121;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "initFramesBar, mTrimVideoPath is null");
      }
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).sendEmptyMessage(1001);
    }
    for (;;)
    {
      return;
      j = (int)(f * i);
      m = (j - i) / 2;
      n = 0;
      k = i;
      break;
      label121:
      if (!EditLocalVideoActivity.b())
      {
        i = ThumbnailUtils.a(EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity), j, k, m, n, i, i);
        if (QLog.isColorLevel()) {
          QLog.d("EditLocalVideoActivity", 2, "init, status1=" + i + ", dstWidth=" + j + ", dstHeight=" + k);
        }
        if (i != 0)
        {
          QzoneVideoBeaconReport.a(EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity), "qzone_video_trim", "2", null);
          EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).sendEmptyMessage(1001);
          return;
        }
      }
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).a(EditLocalVideoActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity), EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity));
      if (EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity) == 0) {
        EditLocalVideoActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, (int)EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).a());
      }
      if (EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity) == 0) {
        EditLocalVideoActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, (int)EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).b());
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditLocalVideoActivity", 2, "mStartTime=" + EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity) + ", mEndTime=" + EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity));
      }
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).setPlayDuration(EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity), EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity) - EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity));
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).sendEmptyMessage(1100);
      if (!EditLocalVideoActivity.b())
      {
        if (TextUtils.isEmpty(EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity))) {}
        for (i = -999;; i = ThumbnailUtils.a(EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity), this.jdField_a_of_type_Int, this.b))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EditLocalVideoActivity", 2, "init, status0=" + i);
          }
          if (i == 0) {
            break;
          }
          QzoneVideoBeaconReport.a(EditLocalVideoActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity), "qzone_video_trim", "3", null);
          EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).sendEmptyMessage(1000);
          return;
        }
      }
      try
      {
        Object localObject;
        Bitmap localBitmap;
        if (EditLocalVideoActivity.b())
        {
          localObject = new MediaMetadataRetriever();
          ((MediaMetadataRetriever)localObject).setDataSource(EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity));
          localBitmap = ((MediaMetadataRetriever)localObject).getFrameAtTime(EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity) * 1000, 3);
          ((MediaMetadataRetriever)localObject).release();
        }
        while (localBitmap != null)
        {
          localObject = GloableValue.a + File.separator + System.currentTimeMillis() + ".jpg";
          if (FileUtils.a((String)localObject, localBitmap)) {
            EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).obtainMessage(1102, localObject).sendToTarget();
          }
          localBitmap.recycle();
          return;
          localBitmap = ThumbnailUtils.a(0L, 1000L);
        }
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtt
 * JD-Core Version:    0.7.0.1
 */