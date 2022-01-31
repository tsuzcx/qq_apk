import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;

public class www
  implements View.OnClickListener
{
  public www(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    String str = paramView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    int i = paramView.getIntExtra("PhotoConst.CLIP_WIDTH", 0);
    PhotoUtils.a(paramView, this.a, str, i, i, 640, 640, ProfileCardUtil.a());
    ReportController.b(this.a.app, "dc00898", "", "", "0X800723F", "0X800723F", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     www
 * JD-Core Version:    0.7.0.1
 */