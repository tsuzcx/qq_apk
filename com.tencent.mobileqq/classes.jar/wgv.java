import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import friendlist.EAddFriendSourceID;
import java.util.ArrayList;

public class wgv
  extends FriendListObserver
{
  public wgv(SystemMsgListView paramSystemMsgListView) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList paramArrayList)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.a).c();
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (paramBoolean1)
    {
      paramString = paramBundle.getString("uin");
      int i = paramBundle.getInt("source_id");
      paramBundle = paramBundle.getString("extra");
      if (((i == 3006) || (i == 3075)) && ("ContactMatchBuilder".equals(paramBundle))) {
        this.a.a(paramString);
      }
      if (EAddFriendSourceID.a(i)) {
        SystemMsgListView.a(this.a).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgv
 * JD-Core Version:    0.7.0.1
 */