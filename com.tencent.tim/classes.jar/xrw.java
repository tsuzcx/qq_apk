import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.qphone.base.util.QLog;

public class xrw
  implements xrv<PlusPanel>
{
  private BaseChatPie a;
  private PlusPanel b;
  
  xrw(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public boolean SC()
  {
    return false;
  }
  
  public PlusPanel a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    this.b = ((PlusPanel)View.inflate(paramContext, 2131558679, null));
    this.b.a(this.a, this.a.sessionInfo);
    paramContext = (wtq)this.a.a(62);
    this.b.setAIOLongCaptureCtrlListener(paramContext.b);
    if (QLog.isColorLevel()) {
      QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l));
    }
    return this.b;
  }
  
  public PlusPanel b()
  {
    return this.b;
  }
  
  public void bo() {}
  
  public void n(int paramInt1, int paramInt2) {}
  
  public int wq()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrw
 * JD-Core Version:    0.7.0.1
 */