import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;

class zvr
  implements MediaScanner.OnMediaInfoScannerListener
{
  zvr(zvq paramzvq, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    ((NewPhotoListActivity)this.a.mActivity).cancleProgressDailog();
    if (aytv.a(this.a.mActivity, paramLocalMediaInfo))
    {
      this.val$intent.putExtra("media_info", paramLocalMediaInfo);
      PhotoUtils.a(this.a.mActivity, this.val$intent, this.val$paths, 2, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvr
 * JD-Core Version:    0.7.0.1
 */