import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class yon
  implements Runnable
{
  public yon(SystemMsgListAdapter paramSystemMsgListAdapter) {}
  
  public void run()
  {
    SystemMsgListAdapter.a(this.a).a(true);
    ArrayList localArrayList = SystemMsgListAdapter.a(this.a).b();
    this.a.a(localArrayList);
    SystemMsgListAdapter.a(this.a).runOnUiThread(new yoo(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yon
 * JD-Core Version:    0.7.0.1
 */