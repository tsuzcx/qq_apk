import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;

public class yom
  extends Handler
{
  public yom(SearchBaseFragment paramSearchBaseFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (SearchBaseFragment.a(this.b) != null) {
      SearchBaseFragment.a(this.b).sendMessage(Message.obtain(paramMessage));
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.b.refreshList();
      return;
    case 1: 
      this.b.uQ((String)paramMessage.obj);
      return;
    case 2: 
      this.b.showEmptyView();
      return;
    }
    this.b.ckf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yom
 * JD-Core Version:    0.7.0.1
 */