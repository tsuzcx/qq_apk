import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;

public class ator
  implements View.OnClickListener
{
  public ator(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.c != null) {
      this.this$0.c.eiZ();
    }
    Button localButton = (Button)paramView.findViewById(2131365674);
    if (localButton.getTag() != null)
    {
      this.this$0.cWH = ((Integer)localButton.getTag()).intValue();
      if (this.this$0.a != null) {
        this.this$0.a.bk(null);
      }
    }
    this.this$0.bP();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ator
 * JD-Core Version:    0.7.0.1
 */