import android.content.Context;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class ocy
  implements BusinessObserver
{
  ocy(acje paramacje, String paramString, boolean paramBoolean, Context paramContext, Object paramObject, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.a != null) {
        this.a.onUpdate(102, false, this.val$uin);
      }
      if (this.awq) {
        ocp.K(this.val$context, 2131697432);
      }
    }
    label220:
    label374:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramBoolean) {
            break label412;
          }
          for (;;)
          {
            try
            {
              paramBundle = paramBundle.getByteArray("data");
              if (paramBundle == null) {
                break label374;
              }
              mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
              localUnFollowResponse.mergeFrom(paramBundle);
              if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() != 0) {
                break label336;
              }
              if (this.aX == null) {
                break label220;
              }
              paramBundle = (PublicAccountHandler)this.val$app.getBusinessHandler(11);
              if (paramBundle != null) {
                paramBundle.bb(this.aX);
              }
              if (this.a == null) {
                break;
              }
              this.a.onUpdate(102, true, this.val$uin);
              return;
            }
            catch (Exception paramBundle)
            {
              if (this.a != null) {
                this.a.onUpdate(102, false, this.val$uin);
              }
            }
            if (!this.awq) {
              break;
            }
            ocp.K(this.val$context, 2131697432);
            return;
            paramBundle = (acja)this.val$app.getManager(56);
            paramBundle.Ez(this.val$uin);
            paramBundle.Ey(this.val$uin);
            StructLongMessageDownloadProcessor.aP(this.val$app, this.val$uin);
            this.val$app.b().N(this.val$uin, 1008);
            oan.a().a(this.val$app, paramBundle.ec());
            nyn.a().k(this.val$app, this.val$uin);
            paramBundle = (kdm)this.val$app.getManager(88);
            if (paramBundle != null) {
              paramBundle.bs(this.val$uin, "unfollow");
            }
          }
          if (this.a != null) {
            this.a.onUpdate(102, false, this.val$uin);
          }
        } while (!this.awq);
        ocp.K(this.val$context, 2131697432);
        return;
        if (this.a != null) {
          this.a.onUpdate(102, false, this.val$uin);
        }
      } while (!this.awq);
      ocp.K(this.val$context, 2131697432);
      return;
      if (this.a != null) {
        this.a.onUpdate(102, false, this.val$uin);
      }
    } while (!this.awq);
    label336:
    ocp.K(this.val$context, 2131697432);
    label412:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocy
 * JD-Core Version:    0.7.0.1
 */