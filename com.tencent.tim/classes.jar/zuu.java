import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class zuu
  implements MediaScanner.OnMediaInfoScannerListener
{
  zuu(zut paramzut) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (aytv.a(this.a.mActivity, paramLocalMediaInfo))
    {
      zut.a(this.a, paramLocalMediaInfo);
      sqn.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.a.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zuu
 * JD-Core Version:    0.7.0.1
 */