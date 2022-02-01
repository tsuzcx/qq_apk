import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class yyu
  extends ahpp
{
  public yyu(TroopWithCommonFriendsFragment paramTroopWithCommonFriendsFragment) {}
  
  protected void c(boolean paramBoolean, int paramInt, ArrayList<yxd> paramArrayList)
  {
    if (TroopWithCommonFriendsFragment.a(this.a) != null) {
      TroopWithCommonFriendsFragment.a(this.a).dismiss();
    }
    if (!paramBoolean)
    {
      this.a.g.sendEmptyMessage(1014);
      return;
    }
    yyx.u(TroopWithCommonFriendsFragment.mFriendUin, paramArrayList);
    yyx.cH(TroopWithCommonFriendsFragment.mFriendUin, paramInt);
    this.a.bPh = paramInt;
    this.a.mDataList = yyx.a(paramArrayList, TroopWithCommonFriendsFragment.a(this.a));
    TroopWithCommonFriendsFragment.a(this.a).clearDatas();
    TroopWithCommonFriendsFragment.a(this.a).gQ(this.a.mDataList);
    this.a.g.sendEmptyMessage(1012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yyu
 * JD-Core Version:    0.7.0.1
 */