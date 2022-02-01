import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.13.1;

public class uvt
  extends acfd
{
  public uvt(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (!this.this$0.uin.equals(paramString1)) {}
    while (!this.this$0.aVP) {
      return;
    }
    this.this$0.aVP = false;
    this.this$0.runOnUiThread(new EditInfoActivity.13.1(this, paramBoolean, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvt
 * JD-Core Version:    0.7.0.1
 */