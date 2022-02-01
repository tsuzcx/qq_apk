import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.MainFragment.e;
import java.util.List;

public class vhp
  implements ausj.a
{
  public vhp(MainFragment paramMainFragment, List paramList, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.this$0.asR();
    if ((paramInt < 0) && (paramInt >= this.qS.size())) {
      return;
    }
    try
    {
      MainFragment.a(this.this$0, ((Integer)((Pair)this.qS.get(paramInt)).first).intValue(), (MainFragment.e)((Pair)this.qS.get(paramInt)).second);
      this.c.dismiss();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vhp
 * JD-Core Version:    0.7.0.1
 */