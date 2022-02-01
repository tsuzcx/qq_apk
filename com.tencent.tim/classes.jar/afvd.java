import android.support.v4.app.Fragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView.a;
import com.tencent.widget.XEditTextEx;

public class afvd
  implements ExtendFriendVoiceView.a
{
  public afvd(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void dcW()
  {
    if (this.this$0.c.isPlaying()) {
      this.this$0.c.aRx();
    }
    this.this$0.url = "";
    ExtendFriendProfileEditFragment.b(this.this$0, 0);
    Fragment localFragment = this.this$0.getParentFragment();
    if ((localFragment != null) && ((localFragment instanceof ExtendFriendEditFragment))) {
      ((ExtendFriendEditFragment)localFragment).a = null;
    }
    ExtendFriendProfileEditFragment.a(this.this$0, null);
    ExtendFriendProfileEditFragment.c(this.this$0);
    if (ExtendFriendProfileEditFragment.b(this.this$0))
    {
      ExtendFriendProfileEditFragment.a(this.this$0, true);
      ExtendFriendProfileEditFragment.b(this.this$0);
    }
    do
    {
      return;
      ExtendFriendProfileEditFragment.a(this.this$0, false);
    } while ((this.this$0.bFI == null) || (!this.this$0.bFI.equals(this.this$0.g.getText().toString())));
    ExtendFriendProfileEditFragment.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvd
 * JD-Core Version:    0.7.0.1
 */