import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.CardObserver;

public class tlr
  extends CardObserver
{
  public tlr(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.setResult(-1);
      this.a.b(2131434995);
    }
    for (;;)
    {
      this.a.a = false;
      this.a.finish();
      return;
      this.a.b(2131434996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tlr
 * JD-Core Version:    0.7.0.1
 */