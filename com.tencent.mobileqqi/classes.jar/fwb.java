import com.tencent.mobileqq.filemanager.activity.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class fwb
  extends FMObserver
{
  public fwb(FileAssistantActivity paramFileAssistantActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (FileAssistantActivity.a(this.a)) {
      return;
    }
    this.a.runOnUiThread(new fwc(this, paramBoolean));
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!FileAssistantActivity.a(this.a)) {
      FMToastUtil.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fwb
 * JD-Core Version:    0.7.0.1
 */