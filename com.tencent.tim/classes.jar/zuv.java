import android.content.Intent;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import java.util.ArrayList;

class zuv
  implements MediaScanner.OnMediaInfoScannerListener
{
  zuv(zut paramzut, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (aytv.a(this.a.mActivity, paramLocalMediaInfo))
    {
      if ((zut.a(this.a) != null) && (paramLocalMediaInfo.mDuration > zut.a(this.a).videoDurationLimit))
      {
        ((NewPhotoListActivity)this.a.mActivity).cancleProgressDailog();
        this.val$intent.putExtra("media_info", paramLocalMediaInfo);
        PhotoUtils.a(this.a.mActivity, this.val$intent, this.val$paths, 2, true);
        return;
      }
      new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration).a(new zuw(this, paramLocalMediaInfo));
      sqn.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.a.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zuv
 * JD-Core Version:    0.7.0.1
 */