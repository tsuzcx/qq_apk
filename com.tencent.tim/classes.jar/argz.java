import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;

public class argz
  implements View.OnLayoutChangeListener
{
  public argz(ProfileCardExtendFriendView paramProfileCardExtendFriendView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (!ProfileCardExtendFriendView.a(this.this$0)) {
      this.this$0.removeOnLayoutChangeListener(this);
    }
    while ((!ProfileCardExtendFriendView.a(this.this$0)) || (!ProfileCardExtendFriendView.b(this.this$0)) || (ProfileCardExtendFriendView.a(this.this$0) != 0) || (ProfileCardExtendFriendView.b(this.this$0) != 0)) {
      return;
    }
    ProfileCardExtendFriendView.a(this.this$0, Math.max(paramInt4 - paramInt2, paramInt8 - paramInt6));
    ProfileCardExtendFriendView.b(this.this$0, Math.min(paramInt4 - paramInt2, paramInt8 - paramInt6));
    this.this$0.removeOnLayoutChangeListener(this);
    ProfileCardExtendFriendView.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     argz
 * JD-Core Version:    0.7.0.1
 */