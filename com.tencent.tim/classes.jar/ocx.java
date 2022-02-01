import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class ocx
  implements BusinessObserver
{
  ocx(acje paramacje, String paramString, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountUtil", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean)
    {
      if (this.a != null) {
        this.a.onUpdate(101, false, this.val$uin);
      }
      if (this.awp) {
        ocp.K(this.val$context, 2131697432);
      }
    }
    label366:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!paramBoolean) {
                  break label404;
                }
                try
                {
                  paramBundle = paramBundle.getByteArray("data");
                  if (paramBundle == null) {
                    break label366;
                  }
                  mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
                  localFollowResponse.mergeFrom(paramBundle);
                  paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
                  if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountUtil", 2, "followUin, retCode=" + paramInt);
                  }
                  if (paramInt != 0) {
                    break;
                  }
                  if (this.a != null) {
                    this.a.onUpdate(101, true, this.val$uin);
                  }
                  ocp.b(this.b, this.val$context, this.val$uin, this.val$source);
                  return;
                }
                catch (Exception paramBundle)
                {
                  if (this.a != null) {
                    this.a.onUpdate(101, false, this.val$uin);
                  }
                }
              } while (!this.awp);
              ocp.K(this.val$context, 2131697432);
              return;
              if (paramInt != 58) {
                break;
              }
              if (this.a != null) {
                this.a.onUpdate(101, false, this.val$uin);
              }
            } while (!this.awp);
            ocp.K(this.val$context, 2131697429);
            return;
            if (paramInt != 65) {
              break;
            }
            if (this.a != null) {
              this.a.onUpdate(101, false, this.val$uin);
            }
          } while (!this.awp);
          ocp.K(this.val$context, 2131697402);
          return;
          if (this.a != null) {
            this.a.onUpdate(101, false, this.val$uin);
          }
        } while (!this.awp);
        ocp.K(this.val$context, 2131697432);
        return;
        if (this.a != null) {
          this.a.onUpdate(101, false, this.val$uin);
        }
      } while (!this.awp);
      ocp.K(this.val$context, 2131697432);
      return;
      if (this.a != null) {
        this.a.onUpdate(101, false, this.val$uin);
      }
    } while (!this.awp);
    label404:
    ocp.K(this.val$context, 2131697432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocx
 * JD-Core Version:    0.7.0.1
 */