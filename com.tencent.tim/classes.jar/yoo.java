import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;

public class yoo
  extends acfd
{
  public yoo(SearchBaseFragment paramSearchBaseFragment) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null) && (SearchBaseFragment.a(this.b) != null) && (SearchBaseFragment.a(this.b).uin.get() == ((Long)paramObject).longValue())) {
      SearchBaseFragment.a(this.b).relation.set(SearchBaseFragment.a(this.b).relation.get() & 0x10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yoo
 * JD-Core Version:    0.7.0.1
 */