import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.7.1;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;

public class agfg
  extends aghq
{
  public agfg(FileAssistantActivity paramFileAssistantActivity) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    super.b(paramLong1, paramLong2, paramString, paramInt);
    this.this$0.a.refreshUI();
  }
  
  protected void bd(int paramInt, String paramString)
  {
    if (!FileAssistantActivity.a(this.this$0)) {
      ahao.JD(paramString);
    }
  }
  
  protected void wG(boolean paramBoolean)
  {
    if (FileAssistantActivity.a(this.this$0)) {
      return;
    }
    this.this$0.runOnUiThread(new FileAssistantActivity.7.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfg
 * JD-Core Version:    0.7.0.1
 */