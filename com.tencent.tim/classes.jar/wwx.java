import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.LocalCrashCollector;
import com.tencent.widget.XEditTextEx;

class wwx
  implements View.OnLongClickListener
{
  wwx(www paramwww) {}
  
  public boolean onLongClick(View paramView)
  {
    if ("//findcrash".equals(this.a.f.a.getText().toString())) {
      ThreadManager.post(new LocalCrashCollector(this.a.f), 8, null, true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwx
 * JD-Core Version:    0.7.0.1
 */