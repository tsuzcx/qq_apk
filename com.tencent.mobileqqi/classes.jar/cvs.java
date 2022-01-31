import com.tencent.mobileqq.activity.MayKnowManActivity;
import com.tencent.mobileqq.app.LBSObserver;
import java.util.List;

public class cvs
  extends LBSObserver
{
  public cvs(MayKnowManActivity paramMayKnowManActivity) {}
  
  protected void a(boolean paramBoolean, List paramList, int paramInt)
  {
    this.a.runOnUiThread(new cvt(this, paramBoolean, paramList, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvs
 * JD-Core Version:    0.7.0.1
 */