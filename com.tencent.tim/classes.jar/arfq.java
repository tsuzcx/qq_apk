import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arfq
  implements View.OnClickListener
{
  public arfq(FolderTextView paramFolderTextView) {}
  
  public void onClick(View paramView)
  {
    if (FolderTextView.a(this.this$0) == 0) {
      FolderTextView.a(this.this$0, 1);
    }
    for (;;)
    {
      FolderTextView.a(this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FolderTextView.a(this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfq
 * JD-Core Version:    0.7.0.1
 */