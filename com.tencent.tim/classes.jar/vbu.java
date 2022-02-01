import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class vbu
  implements ausj.a
{
  public vbu(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.val$actionSheet != null) {
      this.val$actionSheet.dismiss();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      FriendProfileMoreInfoActivity.b(this.this$0, 1);
      FriendProfileMoreInfoActivity.a(this.this$0, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
      return;
    case 1: 
      FriendProfileMoreInfoActivity.b(this.this$0, 2);
      FriendProfileMoreInfoActivity.a(this.this$0, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
      return;
    }
    FriendProfileMoreInfoActivity.b(this.this$0, 3);
    FriendProfileMoreInfoActivity.a(this.this$0, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbu
 * JD-Core Version:    0.7.0.1
 */