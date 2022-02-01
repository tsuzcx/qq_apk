import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;

public class gek
  implements View.OnClickListener
{
  public gek(ProfileCardBrowserActivity paramProfileCardBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, FriendProfileCardActivity.class);
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.a.b.a(), 0);
    localAllInOne.f = 8;
    paramView.putExtra("AllInOne", localAllInOne);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gek
 * JD-Core Version:    0.7.0.1
 */