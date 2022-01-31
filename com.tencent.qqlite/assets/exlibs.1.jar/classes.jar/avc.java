import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.mobileqq.app.LBSObserver;
import java.util.List;

public class avc
  extends LBSObserver
{
  public avc(MayKnowManActivity paramMayKnowManActivity) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt)
  {
    this.a.runOnUiThread(new avd(this, paramBoolean, paramList, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     avc
 * JD-Core Version:    0.7.0.1
 */