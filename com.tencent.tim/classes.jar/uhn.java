import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.widget.QQToast;

public class uhn
  extends aclm
{
  public uhn(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    AuthDevRenameActivity.a(this.this$0);
    if (!paramBoolean)
    {
      QQToast.a(this.this$0, this.this$0.getString(2131693242), 0).show(this.this$0.getTitleBarHeight());
      return;
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uhn
 * JD-Core Version:    0.7.0.1
 */