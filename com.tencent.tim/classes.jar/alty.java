import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class alty
{
  public RegisterNewBaseActivity a;
  public QQAppInterface app;
  
  protected alty(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    this.a = paramRegisterNewBaseActivity;
    this.app = this.a.app;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alty
 * JD-Core Version:    0.7.0.1
 */