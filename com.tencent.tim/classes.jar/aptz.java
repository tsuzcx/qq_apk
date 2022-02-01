import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;

class aptz
  extends acfd
{
  aptz(aptw paramaptw) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (!this.this$0.gM(paramString)) {}
    while (!paramBoolean1) {
      return;
    }
    aptw.a(this.this$0, paramString);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    paramObject = "" + paramObject;
    if (!this.this$0.gM(paramObject)) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      aptw.a(this.this$0, paramObject);
    } while (!(this.this$0.mApp instanceof QQAppInterface));
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.mApp;
    ((acff)this.this$0.mApp.getManager(51)).yZ(paramObject);
    aluu.aB(localQQAppInterface, paramObject);
    localQQAppInterface.a().a().bR(paramObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aptz
 * JD-Core Version:    0.7.0.1
 */