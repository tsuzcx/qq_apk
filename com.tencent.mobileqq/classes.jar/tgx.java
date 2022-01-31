import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.CardObserver;

public class tgx
  extends CardObserver
{
  public tgx(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.setResult(-1);
      this.a.b(2131434979);
    }
    for (;;)
    {
      this.a.a = false;
      this.a.finish();
      return;
      this.a.b(2131434980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tgx
 * JD-Core Version:    0.7.0.1
 */