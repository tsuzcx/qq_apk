import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zsa
  implements View.OnClickListener
{
  public zsa(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = this.a.getIntent();
    String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    int i = localIntent.getIntExtra("PhotoConst.CLIP_WIDTH", 0);
    PhotoUtils.a(localIntent, this.a, str, i, i, 1080, 1080, aqep.BR());
    anot.a(this.a.app, "dc00898", "", "", "0X800723F", "0X800723F", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zsa
 * JD-Core Version:    0.7.0.1
 */