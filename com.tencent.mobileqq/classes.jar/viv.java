import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.playvideo.NewProgressControler.2;
import com.tencent.biz.qqstory.playvideo.NewProgressControler.3;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.Timer;
import java.util.TimerTask;

public class viv
  implements vsc
{
  protected long a;
  public Handler a;
  private SplitedProgressBar jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar;
  public WeakReference<vrr> a;
  public Timer a;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  public boolean a;
  public long b;
  public long c;
  
  public viv(SplitedProgressBar paramSplitedProgressBar)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_a_of_type_AndroidOsHandler = new viw(this, Looper.getMainLooper());
    if (paramSplitedProgressBar == null) {
      throw new InvalidParameterException("ProgressControler: progressBar is null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = paramSplitedProgressBar;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(1);
  }
  
  private void a(long paramLong)
  {
    int i = 100;
    int j;
    if (this.b > 0L)
    {
      j = (int)paramLong * 100 / (int)this.b;
      if (j <= 100) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(0, i);
      return;
      i = j;
      continue;
      i = 0;
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.c = this.jdField_a_of_type_Long;
    this.b = paramLong2;
    a(paramLong1);
    wsv.a("Q.qqstory.player:NewProgressControler", "seek ft:%d , ed:%d", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      wsv.d("Q.qqstory.player:NewProgressControler", "progress already canceled. can't start.");
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    f();
    if (this.b < 0L)
    {
      d();
      return;
    }
    e();
  }
  
  private void d()
  {
    NewProgressControler.2 local2 = new NewProgressControler.2(this);
    this.jdField_a_of_type_AndroidOsHandler.post(local2);
  }
  
  private void e()
  {
    try
    {
      Timer localTimer = new Timer();
      NewProgressControler.3 local3 = new NewProgressControler.3(this);
      localTimer.scheduleAtFixedRate(local3, 0L, 50L);
      this.jdField_a_of_type_JavaUtilTimer = localTimer;
      this.jdField_a_of_type_JavaUtilTimerTask = local3;
      wsv.b("Q.qqstory.player:NewProgressControler", "startTimer");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilTimer != null) {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
      }
      if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
        this.jdField_a_of_type_JavaUtilTimerTask.cancel();
      }
      wsv.b("Q.qqstory.player:NewProgressControler", "cancelTimer");
      return;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public void a(long paramLong1, long paramLong2, vrr paramvrr)
  {
    if (paramvrr == this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      wsv.a("Q.qqstory.player:NewProgressControler", "progress callback :onSeek , ft:%d , et:%d", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      a(paramLong1, paramLong2);
    }
  }
  
  public void a(vrr paramvrr)
  {
    if ((paramvrr instanceof vrx)) {}
    for (vrr localvrr = ((vrx)paramvrr).a();; localvrr = paramvrr)
    {
      if (localvrr == this.jdField_a_of_type_JavaLangRefWeakReference.get())
      {
        wsv.b("Q.qqstory.player:NewProgressControler", "cannot set the same video view");
        return;
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localvrr);
      if ((paramvrr instanceof vrx)) {
        ((vrx)paramvrr).a(this);
      }
      for (;;)
      {
        f();
        a(0L, paramvrr.b());
        return;
        wsv.b("Yarkey", "cannot set the same video view");
      }
    }
  }
  
  public void b()
  {
    wsv.b("Q.qqstory.player:NewProgressControler", "pauseProgressBar");
    f();
  }
  
  public void b(vrr paramvrr)
  {
    if (paramvrr == this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      wsv.b("Q.qqstory.player:NewProgressControler", "progress callback :onStart");
      c();
      return;
    }
    wsv.b("Yarkey", "onStart ignore !!");
  }
  
  public void c(vrr paramvrr)
  {
    if (paramvrr == this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      wsv.b("Q.qqstory.player:NewProgressControler", "progress callback :onPause");
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     viv
 * JD-Core Version:    0.7.0.1
 */