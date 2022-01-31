import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;

public class dfz
  implements View.OnClickListener
{
  public dfz(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.setResult(0, new Intent());
    this.a.finish();
    this.a.overridePendingTransition(2130968583, 2130968584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfz
 * JD-Core Version:    0.7.0.1
 */