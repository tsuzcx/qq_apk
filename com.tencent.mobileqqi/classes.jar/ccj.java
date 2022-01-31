import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseHornListActivity;
import com.tencent.mobileqq.activity.BaseHornListActivity.BaseHornAdapter;
import java.lang.ref.WeakReference;

public class ccj
  extends Handler
{
  private WeakReference a;
  
  public ccj(BaseHornListActivity paramBaseHornListActivity)
  {
    this.a = new WeakReference(paramBaseHornListActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    BaseHornListActivity localBaseHornListActivity = (BaseHornListActivity)this.a.get();
    if (localBaseHornListActivity == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        localBaseHornListActivity.a(2131562097);
      }
    } while (localBaseHornListActivity.a == null);
    localBaseHornListActivity.a.a = false;
    localBaseHornListActivity.a.notifyDataSetChanged();
    return;
    localBaseHornListActivity.a(2131561874);
    return;
    if (paramMessage.arg1 > 0)
    {
      localBaseHornListActivity.a(localBaseHornListActivity.getString(2131559034, new Object[] { Integer.valueOf(paramMessage.arg1) }));
      return;
    }
    localBaseHornListActivity.a(2131563218);
    return;
    localBaseHornListActivity.a(2131562652);
    return;
    localBaseHornListActivity.a(2131563060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ccj
 * JD-Core Version:    0.7.0.1
 */