import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.FriendListObserver;

public class efi
  extends FriendListObserver
{
  public efi(SystemMsgListView paramSystemMsgListView) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (SystemMsgListView.a(this.a) != null)) {
      SystemMsgListView.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (SystemMsgListView.a(this.a) != null)) {
      SystemMsgListView.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (SystemMsgListView.a(this.a) != null)) {
      SystemMsgListView.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     efi
 * JD-Core Version:    0.7.0.1
 */