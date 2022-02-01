import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.mobileqq.widget.AnimationView.Player;
import java.lang.ref.WeakReference;

public final class xvu
  extends AnimationView.Player
{
  public static boolean isScrolling;
  
  public xvu(AnimationView paramAnimationView)
  {
    super(paramAnimationView);
  }
  
  public static void setScrolling(boolean paramBoolean)
  {
    isScrolling = paramBoolean;
  }
  
  public void a(AnimationView paramAnimationView)
  {
    reset();
    this.iE.clear();
    this.iE = new WeakReference(paramAnimationView);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (isScrolling)
      {
        paramMessage = this.mHandler.obtainMessage(1);
        this.mHandler.sendMessageDelayed(paramMessage, 500L);
      }
      else
      {
        dpN();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xvu
 * JD-Core Version:    0.7.0.1
 */