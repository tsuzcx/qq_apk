import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;

final class ocz
  extends adai.a
{
  ocz(Object paramObject, QQAppInterface paramQQAppInterface, String paramString, acje paramacje, boolean paramBoolean, Context paramContext) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public int dI()
  {
    return 5;
  }
  
  public void onSuccess(Object paramObject)
  {
    if (this.aX != null)
    {
      paramObject = (PublicAccountHandler)this.val$app.getBusinessHandler(11);
      if (paramObject != null) {
        paramObject.bb(this.aX);
      }
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.onUpdate(102, true, this.val$uin);
      }
      return;
      paramObject = (acja)this.val$app.getManager(56);
      paramObject.Ez(this.val$uin);
      paramObject.Ey(this.val$uin);
      StructLongMessageDownloadProcessor.aP(this.val$app, this.val$uin);
      this.val$app.b().N(this.val$uin, 1008);
      oan.a().a(this.val$app, paramObject.ec());
      nyn.a().k(this.val$app, this.val$uin);
      paramObject = (kdm)this.val$app.getManager(88);
      if (paramObject != null) {
        paramObject.bs(this.val$uin, "unfollow");
      }
    }
  }
  
  public void p(Object paramObject)
  {
    if (this.a != null) {
      this.a.onUpdate(102, false, this.val$uin);
    }
    if (this.awq) {
      ocp.K(this.val$context, 2131697432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocz
 * JD-Core Version:    0.7.0.1
 */