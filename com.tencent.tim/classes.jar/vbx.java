import android.view.View;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;

public class vbx
  implements ausj.a
{
  public vbx(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      FriendProfilePicBrowserActivity.a(this.a);
      anot.a(this.a.app, "dc00898", "", "", "0X800A8CA", "0X800A8CA", 0, 0, "1", "", "", "");
      return;
    case 1: 
      FriendProfilePicBrowserActivity.b(this.a);
      anot.a(this.a.app, "dc00898", "", "", "0X800A8CB", "0X800A8CB", 0, 0, "1", "", "", "");
      return;
    case 2: 
      FriendProfilePicBrowserActivity.c(this.a);
      anot.a(this.a.app, "dc00898", "", "", "0X8007C14", "0X8007C14", this.a.mFromType, 0, "", "", "", "");
      anot.a(this.a.app, "dc00898", "", "", "0X800A8CC", "0X800A8CC", 0, 0, "1", "", "", "");
      return;
    case 3: 
      FriendProfilePicBrowserActivity.d(this.a);
      anot.a(this.a.app, "dc00898", "", "", "0X800A8CD", "0X800A8CD", 0, 0, "1", "", "", "");
      return;
    }
    FriendProfilePicBrowserActivity.e(this.a);
    anot.a(this.a.app, "dc00898", "", "", "0X8007C15", "0X8007C15", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbx
 * JD-Core Version:    0.7.0.1
 */