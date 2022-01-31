import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;

public class wyc
  implements View.OnClickListener
{
  public wyc(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewActivity.c(this.a))
    {
      this.a.i();
      return;
    }
    if (this.a.x) {
      ReportController.b(null, "CliOper", "", "", "0X8004D94", "0X8004D94", 0, 0, "", "", "", "");
    }
    if (("FROM_PHOTO_LIST_FLOW".equals(this.a.e)) && (this.a.v)) {
      this.a.setResult(-1);
    }
    this.a.finish();
    AlbumUtil.a(this.a, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyc
 * JD-Core Version:    0.7.0.1
 */