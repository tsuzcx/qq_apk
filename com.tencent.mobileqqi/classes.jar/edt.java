import android.os.Message;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;

public class edt
  implements Runnable
{
  public edt(SearchResultDialog paramSearchResultDialog) {}
  
  public void run()
  {
    List localList = this.a.a(this.a.getContext(), SearchResultDialog.a(this.a), SearchResultDialog.a(this.a));
    Message localMessage = SearchResultDialog.a(this.a).obtainMessage();
    localMessage.what = 1;
    localMessage.obj = localList;
    SearchResultDialog.a(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     edt
 * JD-Core Version:    0.7.0.1
 */