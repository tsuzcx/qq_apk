import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.1;
import com.tencent.mobileqq.danmaku.core.DanmakuMeasureManager.2;
import java.util.List;

public class aexc
{
  private HandlerThread N;
  private aexj a;
  private Handler cK;
  
  public aexc(aexj paramaexj)
  {
    this.a = paramaexj;
  }
  
  public static void a(aexj paramaexj, aexe paramaexe)
  {
    if (paramaexe.isMeasured()) {
      return;
    }
    paramaexj = paramaexj.a(paramaexe).a(paramaexe);
    paramaexe.setPaintWidth(paramaexj.getContentWidth() + aexj.a().getMarginHorizontal() * 2);
    paramaexe.setPaintHeight(paramaexj.getContentHeight() + aexj.a().getMarginVertical() * 2);
    paramaexe.cXW();
  }
  
  private Handler v()
  {
    if ((this.N == null) || (!this.N.isAlive())) {}
    try
    {
      this.N = new HandlerThread("DanmakuMeasureThread");
      this.N.start();
      this.N.setUncaughtExceptionHandler(new aeyt());
      this.cK = new Handler(this.N.getLooper());
      return this.cK;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        aeyw.e("DanmakuMeasureManager", new Object[] { localThrowable });
      }
    }
  }
  
  public void a(aexe paramaexe, aexc.a parama)
  {
    Handler localHandler = v();
    if (localHandler != null) {
      localHandler.post(new DanmakuMeasureManager.1(this, paramaexe, parama));
    }
  }
  
  public void a(List<aexe> paramList, aexc.a parama)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    Handler localHandler;
    do
    {
      return;
      localHandler = v();
    } while (localHandler == null);
    localHandler.post(new DanmakuMeasureManager.2(this, paramList, parama));
  }
  
  public void cXQ()
  {
    if ((this.N == null) || (!this.N.isAlive())) {
      return;
    }
    if (aeyu.aiE())
    {
      this.N.quitSafely();
      return;
    }
    this.N.quit();
  }
  
  public static abstract interface a
  {
    public abstract void h(aexe paramaexe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aexc
 * JD-Core Version:    0.7.0.1
 */