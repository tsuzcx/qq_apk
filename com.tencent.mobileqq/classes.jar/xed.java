import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.fragment.ThemeHbFragment;

public class xed
  extends Handler
{
  public xed(ThemeHbFragment paramThemeHbFragment) {}
  
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
 * Qualified Name:     xed
 * JD-Core Version:    0.7.0.1
 */