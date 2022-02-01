import android.os.Handler;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.adapter.BaseWhatASmoothAdapter.1;

public abstract class abdv
  extends BaseAdapter
  implements AbsListView.OnScrollListener
{
  public String bft;
  protected Handler mMainHandler;
  
  private final void a(View paramView, Object paramObject, int paramInt, abdv.a parama)
  {
    Object localObject = l(paramInt);
    if (localObject == null) {
      return;
    }
    paramView = new BaseWhatASmoothAdapter.1(this, paramView, localObject, paramObject, paramInt, parama);
    abdv.a.a(parama, true);
    abdv.a.a(parama, paramView);
    this.mMainHandler.post(paramView);
  }
  
  protected abstract Object l(int paramInt);
  
  public abstract void s(View paramView, Object paramObject);
  
  public class a
  {
    private boolean bBX;
    private Runnable mTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abdv
 * JD-Core Version:    0.7.0.1
 */