import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zse
  implements View.OnClickListener
{
  public zse(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = QzonePhotoPreviewActivity.a(this.a);
    localIntent.putExtra("PhotoConst.send_changtu", true);
    localIntent.putExtra("PhotoConst.KEY_SHOW_TYPE", 1);
    localIntent.putExtra("PhotoConst.KEY_SHOW_ORIGIN_TYPE", 1);
    PhotoUtils.a(this.a.getActivity(), QzonePhotoPreviewActivity.a(this.a), this.a.paths, this.a.Cv, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zse
 * JD-Core Version:    0.7.0.1
 */