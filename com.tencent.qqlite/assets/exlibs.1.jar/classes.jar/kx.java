import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;

public class kx
  implements View.OnClickListener
{
  public kx(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    if ((BmqqProfileCardActivity.a(this.a) != null) && (BmqqProfileCardActivity.a(this.a).a) && (this.a.app != null) && (!"0".equals(this.a.app.a()))) {
      this.a.app.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kx
 * JD-Core Version:    0.7.0.1
 */