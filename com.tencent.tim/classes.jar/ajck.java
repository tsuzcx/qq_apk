import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;

public abstract class ajck
{
  public MiniAppActivity a;
  public ajcn d;
  
  public ajck(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    this.a = paramMiniAppActivity;
  }
  
  public void b(ajcn paramajcn)
  {
    this.d = paramajcn;
    if (this.a != null) {
      this.a.d = paramajcn;
    }
  }
  
  public abstract boolean isRunning();
  
  public void onDestroy()
  {
    this.a = null;
  }
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajck
 * JD-Core Version:    0.7.0.1
 */