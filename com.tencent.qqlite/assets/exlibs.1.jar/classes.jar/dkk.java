import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;

public class dkk
  extends FMObserver
{
  public dkk(QfileFileAssistantActivity paramQfileFileAssistantActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QfileFileAssistantActivity.b(this.a)) {
      return;
    }
    this.a.runOnUiThread(new dkl(this, paramBoolean));
  }
  
  protected void b(int paramInt, String paramString)
  {
    if (!QfileFileAssistantActivity.b(this.a)) {
      FMToastUtil.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkk
 * JD-Core Version:    0.7.0.1
 */