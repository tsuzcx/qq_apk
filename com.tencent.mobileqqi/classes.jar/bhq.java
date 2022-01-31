import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.gaudio.GaInviteActivity;

public class bhq
  extends GAudioUIObserver
{
  public bhq(GaInviteActivity paramGaInviteActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.f();
  }
  
  protected void d(long paramLong)
  {
    super.c(paramLong);
    if (this.a.b == paramLong) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhq
 * JD-Core Version:    0.7.0.1
 */