import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.widget.XPanelContainer.c;

public class xru
  implements XPanelContainer.c
{
  private BaseChatPie a;
  private Context context;
  private SparseArrayCompat<xrv<? extends View>> d = new SparseArrayCompat();
  
  public xru(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.context = paramContext;
    this.a = paramBaseChatPie;
    cey();
  }
  
  private void a(xrv<? extends View> paramxrv)
  {
    this.d.put(paramxrv.wq(), paramxrv);
  }
  
  private void cey()
  {
    a(new xrw(this.a));
    a(new xrx(this.a));
    a(new xrq(this.a));
    a(new xrp(this.a));
  }
  
  public <T extends View> T B(int paramInt)
  {
    xrv localxrv = (xrv)this.d.get(paramInt);
    if (localxrv != null) {
      return localxrv.M();
    }
    return null;
  }
  
  public View a(int paramInt)
  {
    xrv localxrv = (xrv)this.d.get(paramInt);
    if (localxrv != null) {
      return localxrv.j(this.context);
    }
    return null;
  }
  
  public void bo()
  {
    int i = 0;
    while (i < this.d.size())
    {
      ((xrv)this.d.get(this.d.keyAt(i))).bo();
      i += 1;
    }
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.d.size())
    {
      ((xrv)this.d.get(this.d.keyAt(i))).n(paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public boolean r(int paramInt)
  {
    xrv localxrv = (xrv)this.d.get(paramInt);
    if (localxrv != null) {
      return localxrv.SC();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xru
 * JD-Core Version:    0.7.0.1
 */