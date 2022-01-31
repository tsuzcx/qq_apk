import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class xcm
  implements View.OnClickListener
{
  public xcm(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    paramView = this.a.a;
    boolean bool;
    String str;
    if (!this.a.a.isChecked())
    {
      bool = true;
      paramView.setChecked(bool);
      this.a.c = this.a.a.isChecked();
      this.a.h = 2;
      paramView = this.a;
      str = this.a.getCurrentAccountUin();
      if (!this.a.c) {
        break label92;
      }
    }
    for (;;)
    {
      SharedPreUtils.O(paramView, str, i);
      return;
      bool = false;
      break;
      label92:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcm
 * JD-Core Version:    0.7.0.1
 */