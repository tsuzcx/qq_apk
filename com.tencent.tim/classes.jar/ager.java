import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView.a;

public class ager
  implements QfileCloudFileTabView.a
{
  public ager(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public View.OnClickListener a(TextView paramTextView)
  {
    this.this$0.bG = paramTextView;
    return new ages(this);
  }
  
  public boolean akX()
  {
    return this.this$0.cdd;
  }
  
  public boolean akY()
  {
    return this.this$0.ccZ;
  }
  
  public boolean isEnd()
  {
    return QfileCloudFileTabView.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ager
 * JD-Core Version:    0.7.0.1
 */