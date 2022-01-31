import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;

public class xh
  extends Handler
{
  public xh(AddRequestActivity paramAddRequestActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if ((AddRequestActivity.a(this.a) != null) && (AddRequestActivity.a(this.a).isShowing()))
      {
        AddRequestActivity.a(this.a).setText(this.a.getString(2131363387));
        AddRequestActivity.a(this.a).setVisibility(8);
        AddRequestActivity.a(this.a).setVisibility(0);
        AddRequestActivity.a(this.a).setImageResource(2130837985);
        postDelayed(new xi(this), 1500L);
        return;
      }
      this.a.finish();
      return;
      this.a.a(true);
    } while ((AddRequestActivity.a(this.a) == null) || (!AddRequestActivity.a(this.a).isShowing()));
    AddRequestActivity.a(this.a).setText(this.a.getString(2131363388));
    AddRequestActivity.a(this.a).setVisibility(8);
    AddRequestActivity.a(this.a).setVisibility(0);
    AddRequestActivity.a(this.a).setImageResource(2130837975);
    postDelayed(new xj(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xh
 * JD-Core Version:    0.7.0.1
 */