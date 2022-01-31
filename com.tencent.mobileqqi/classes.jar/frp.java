import com.tencent.mobileqq.filemanager.activity.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class frp
  extends FMObserver
{
  public frp(FileAssistantActivity paramFileAssistantActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (FileAssistantActivity.a(this.a)) {
      return;
    }
    this.a.runOnUiThread(new frq(this, paramBoolean));
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!FileAssistantActivity.a(this.a)) {
      FMToastUtil.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     frp
 * JD-Core Version:    0.7.0.1
 */