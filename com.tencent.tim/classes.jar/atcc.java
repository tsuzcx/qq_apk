import android.view.View;
import com.tencent.tim.activity.profile.host.HostProfileFragment;
import java.util.Locale;

public class atcc
  implements ausj.a
{
  public atcc(HostProfileFragment paramHostProfileFragment, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.val$actionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      HostProfileFragment.c(this.this$0, String.format(Locale.getDefault(), "https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
      return;
    case 1: 
      HostProfileFragment.c(this.this$0, String.format(Locale.getDefault(), "https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
      return;
    }
    HostProfileFragment.c(this.this$0, String.format(Locale.getDefault(), "https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atcc
 * JD-Core Version:    0.7.0.1
 */