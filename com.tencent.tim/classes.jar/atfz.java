import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.tim.cloudfile.CloudFileListFragment;

public class atfz
  implements View.OnLongClickListener
{
  public atfz(CloudFileListFragment paramCloudFileListFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    CloudFileListFragment.a(this.this$0, true);
    paramView.performClick();
    this.this$0.centerView.setOnClickListener(null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfz
 * JD-Core Version:    0.7.0.1
 */