import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;

public class ftx
  implements View.OnClickListener
{
  public ftx(BaseFileAssistantActivity paramBaseFileAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    FMDataCache.b();
    this.a.setResult(5);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ftx
 * JD-Core Version:    0.7.0.1
 */