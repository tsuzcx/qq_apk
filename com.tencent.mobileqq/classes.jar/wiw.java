import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class wiw
  extends FriendListObserver
{
  public wiw(SearchBaseFragment paramSearchBaseFragment) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && (SearchBaseFragment.a(this.a) != null) && (SearchBaseFragment.a(this.a).uin.get() == ((Long)paramObject).longValue())) {
      SearchBaseFragment.a(this.a).relation.set(SearchBaseFragment.a(this.a).relation.get() & 0x10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wiw
 * JD-Core Version:    0.7.0.1
 */