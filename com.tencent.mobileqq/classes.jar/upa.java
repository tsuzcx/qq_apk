import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment;

public class upa
  extends BroadcastReceiver
{
  private upa(FolderFollowTabFragment paramFolderFollowTabFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_refresh_return_page")) && (FolderFollowTabFragment.a(this.a) != null)) {
      FolderFollowTabFragment.b(this.a, FolderFollowTabFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upa
 * JD-Core Version:    0.7.0.1
 */