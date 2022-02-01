import android.app.Activity;
import com.tencent.biz.qqstory.playvideo.playerwidget.BottomVideoInfoWidget.8.1;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;

public class qmu
  implements MediaScanner.OnMediaInfoScannerListener
{
  qmu(qmo paramqmo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    this.this$0.getActivity().runOnUiThread(new BottomVideoInfoWidget.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmu
 * JD-Core Version:    0.7.0.1
 */