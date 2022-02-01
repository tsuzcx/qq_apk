import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.tim.cloudfile.FileShowListActivity;

public class atis
  implements View.OnLongClickListener
{
  public atis(FileShowListActivity paramFileShowListActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (FileShowListActivity.b(this.a))
    {
      FileShowListActivity.a(this.a, true);
      paramView.performClick();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atis
 * JD-Core Version:    0.7.0.1
 */