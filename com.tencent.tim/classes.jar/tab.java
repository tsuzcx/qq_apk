import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class tab
  extends aclm
{
  tab(szy paramszy) {}
  
  protected void f(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (paramInt == 1)
      {
        afsf.a().a(this.this$0.app, BaseApplicationImpl.getApplication(), this.this$0.app.getCurrentAccountUin(), true);
        return;
      }
      afsf.a().a(this.this$0.app, BaseApplicationImpl.getApplication(), this.this$0.app.getCurrentAccountUin(), false);
      return;
    }
    afsf.a().a(this.this$0.app, BaseApplicationImpl.getApplication(), this.this$0.app.getCurrentAccountUin(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tab
 * JD-Core Version:    0.7.0.1
 */