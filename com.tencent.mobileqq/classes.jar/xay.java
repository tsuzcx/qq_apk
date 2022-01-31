import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;

public class xay
  extends Handler
{
  public xay(ThemeHbFragment paramThemeHbFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (TextUtils.isEmpty(ThemeHbFragment.a(this.a)));
    ThemeHbFragment.a(this.a).setText(ThemeHbFragment.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xay
 * JD-Core Version:    0.7.0.1
 */