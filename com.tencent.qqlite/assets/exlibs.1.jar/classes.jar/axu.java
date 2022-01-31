import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.model.FriendManager;

public class axu
  extends FriendListObserver
{
  public axu(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    while ((NearbyPeopleProfileActivity.b(this.a) != 3) || (NearbyPeopleProfileActivity.c(this.a)) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    b();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (!paramBoolean2)) {}
    while ((NearbyPeopleProfileActivity.b(this.a) != 3) || (NearbyPeopleProfileActivity.a(this.a) == null) || (TextUtils.isEmpty(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    b();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((!paramBoolean1) || (!paramBoolean2) || (!paramBoolean3) || (TextUtils.isEmpty(paramString))) {}
    while ((NearbyPeopleProfileActivity.b(this.a) != 3) || (NearbyPeopleProfileActivity.c(this.a)) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin))) {
      return;
    }
    b();
  }
  
  public void b()
  {
    boolean bool = NearbyPeopleProfileActivity.c(this.a);
    FriendManager localFriendManager = (FriendManager)this.a.app.getManager(8);
    if (localFriendManager != null) {
      bool = localFriendManager.b(NearbyPeopleProfileActivity.a(this.a).uin);
    }
    for (;;)
    {
      if (bool != NearbyPeopleProfileActivity.c(this.a))
      {
        NearbyPeopleProfileActivity.a(this.a, bool);
        this.a.runOnUiThread(new axv(this));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axu
 * JD-Core Version:    0.7.0.1
 */