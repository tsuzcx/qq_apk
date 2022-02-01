import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aggd
  implements View.OnClickListener
{
  public aggd(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void onClick(View paramView)
  {
    QfileLocalFilePicTabView.a(this.this$0, paramView, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggd
 * JD-Core Version:    0.7.0.1
 */