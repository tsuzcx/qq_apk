import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

public class mlz
  implements mlt, mlu.b
{
  private boolean ano;
  private mlw b;
  private Executor executor = acmo.a(64);
  private Handler handler = new mma(this);
  private Queue<mlu> l = new ArrayDeque();
  private Queue<mlu> m = new ArrayDeque();
  
  public mlz(mlw parammlw)
  {
    this.b = parammlw;
    this.b.a(this);
  }
  
  private void aQc()
  {
    if ((!this.ano) || (this.l.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.w("PreviewCaptureManager", 2, "fetchTaskToExe return for capturePrepared is false or waittingTaskQueue is Empty");
      }
    }
    for (;;)
    {
      return;
      while (canExecute())
      {
        mlu localmlu = (mlu)this.l.poll();
        if (localmlu != null) {
          f(localmlu);
        }
      }
    }
  }
  
  private void aQd()
  {
    this.handler.sendEmptyMessage(1000);
  }
  
  private boolean canExecute()
  {
    return this.m.size() < 3;
  }
  
  private void e(mlu parammlu)
  {
    parammlu.a(this.b);
    parammlu.a(this);
  }
  
  private void f(mlu parammlu)
  {
    this.m.add(parammlu);
    e(parammlu);
    parammlu.executeOnExecutor(this.executor, null);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.ano = true;
    aQd();
  }
  
  public void b(mlu parammlu) {}
  
  public void c(mlu parammlu)
  {
    this.m.remove(parammlu);
    aQd();
  }
  
  public void d(mlu parammlu)
  {
    if ((this.l.contains(parammlu)) || (this.m.contains(parammlu))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreviewCaptureManager", 2, "addCaptureTask task:" + parammlu);
    }
    this.l.add(parammlu);
    aQd();
  }
  
  public void stop()
  {
    this.handler.removeCallbacksAndMessages(null);
    ArrayList localArrayList = new ArrayList(this.l);
    localArrayList.addAll(this.m);
    this.l.clear();
    this.m.clear();
    int i = 0;
    while (i < localArrayList.size())
    {
      mlu localmlu = (mlu)localArrayList.get(i);
      if (localmlu != null) {
        localmlu.cancel(true);
      }
      i += 1;
    }
    if (this.b != null) {
      this.b.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mlz
 * JD-Core Version:    0.7.0.1
 */