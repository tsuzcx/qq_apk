import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.tim.activity.profile.BaseProfileFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class ataz
  implements Function1<alcn, Unit>
{
  public ataz(BaseProfileFragment paramBaseProfileFragment) {}
  
  public Unit a(alcn paramalcn)
  {
    if (paramalcn != null)
    {
      this.this$0.a = paramalcn;
      if ((this.this$0.a.e != null) && (!TextUtils.isEmpty(this.this$0.a.e.uin))) {
        this.this$0.wd(this.this$0.a.e.uin);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ataz
 * JD-Core Version:    0.7.0.1
 */