import android.support.annotation.NonNull;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.QQToast;

public class arhc
  extends ClickableSpan
{
  public arhc(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.c.authState == 1L) {
      QQToast.a(this.this$0.getContext(), 0, 2131701096, 1).show();
    }
    while ((this.c.authState != 0L) && (this.c.authState != 3L)) {
      return;
    }
    afxn.b((FriendProfileCardActivity)ProfileCardExtendFriendView.a(this.this$0), this.c.idx, this.c.schoolName, this.c.schoolId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arhc
 * JD-Core Version:    0.7.0.1
 */